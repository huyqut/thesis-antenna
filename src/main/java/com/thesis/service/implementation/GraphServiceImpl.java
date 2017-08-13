package com.thesis.service.implementation;

import com.thesis.common.Constant;
import com.thesis.dto.GraphDTO;
import com.thesis.entity.News;
import com.thesis.repository.NewsRepository;
import com.thesis.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * Created by lap08 on 8/11/2017.
 */
@Service
public class GraphServiceImpl implements GraphService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public GraphDTO getDataGraph(int nodes) {

        long date = System.currentTimeMillis();
        int offset = TimeZone.getTimeZone("GMT-7").getOffset(date);
        // Get current time - 12h
        long currentSeconds = (date + offset)/1000 - 12*3600;
        int id = 0;
        List<News> newsList = newsRepository.findCurrentNewsIn24H(currentSeconds);
        List<GraphDTO.NodeGraph> nodeGraphs = new ArrayList<>();
        List<GraphDTO.LinkGraph> linkGraphs = new ArrayList<>();
        List<GraphDTO.TypeNodeGraph> typeNodeGraphs = new ArrayList<>();
        GraphDTO graphDTO = new GraphDTO(nodeGraphs, linkGraphs, typeNodeGraphs);
        typeNodeGraphs.add(graphDTO.new TypeNodeGraph("PERSON", Constant.GraphNodeType.TYPE_PERSON));
        typeNodeGraphs.add(graphDTO.new TypeNodeGraph("ARTICLE", Constant.GraphNodeType.TYPE_ARTICLE));

        Map<String, Integer> allPersonSet = new TreeMap<>();
        for(News news : newsList){

            if(news.getTitle() == null) {
                continue;
            }

            // Check number of nodes
            if (nodeGraphs.size() >= nodes) {
                break;
            }

            GraphDTO.NodeGraph nodeArticleGraph = graphDTO.new NodeGraph(id,Constant.GraphNodeType.TYPE_ARTICLE, news.getTitle());
            nodeGraphs.add(nodeArticleGraph);
            ++id;
            if(news.getPeopleList() == null) {
                continue;
            }
            TreeMap<String, Integer> personList = new TreeMap<>();
            for(String people : news.getPeopleList()){
                if(personList.containsKey(people)) {
                    personList.put(people, personList.get(people) + 1);
                }
                else {
                    personList.put(people, 1);
                }
            }
            for(String people : personList.keySet()) {
                if(!allPersonSet.containsKey(people)) {
                    GraphDTO.NodeGraph nodePersonGraph = graphDTO.new NodeGraph(id, Constant.GraphNodeType.TYPE_PERSON, people);
                    nodeGraphs.add(nodePersonGraph);
                    allPersonSet.put(people, id);
                    ++id;
                }
                GraphDTO.LinkGraph linkGraph = graphDTO.new LinkGraph(allPersonSet.get(people), nodeArticleGraph.getId(), personList.get(people)*3/2);
                linkGraphs.add(linkGraph);
            }
        }
        return graphDTO;
    }
}
