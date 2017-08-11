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
    public GraphDTO getDataGraph() {

        long date = System.currentTimeMillis();
        int offset = TimeZone.getTimeZone("GMT-7").getOffset(date);
        // Get current time - 24h
        long currentSeconds = (date + offset)/1000 - 24*3600;

        List<News> newsList = newsRepository.findCurrentNewsIn24H(currentSeconds);
        List<GraphDTO.NodeGraph> nodeGraphs = new ArrayList<>();
        List<GraphDTO.LinkGraph> linkGraphs = new ArrayList<>();
        GraphDTO graphDTO = new GraphDTO(nodeGraphs, linkGraphs);
        for(News news : newsList){
            GraphDTO.NodeGraph nodeGraph = graphDTO.new NodeGraph(news.getTitle(), 0, Constant.GraphNodeType.TYPE_ARTICLE);
            nodeGraphs.add(nodeGraph);
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
                nodeGraph = graphDTO.new NodeGraph(people, 0, Constant.GraphNodeType.TYPE_PERSON);
                nodeGraphs.add(nodeGraph);
                GraphDTO.LinkGraph linkGraph = graphDTO.new LinkGraph(people, news.getTitle(), personList.get(people)*3/2);
                linkGraphs.add(linkGraph);
            }
        }
        return new GraphDTO(nodeGraphs, linkGraphs);
    }
}
