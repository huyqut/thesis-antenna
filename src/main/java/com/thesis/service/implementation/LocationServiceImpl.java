package com.thesis.service.implementation;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.thesis.common.Constant;
import com.thesis.common.Utils;
import com.thesis.dto.LocationDTO;
import com.thesis.dto.NewsDTO;
import com.thesis.entity.News;
import com.thesis.repository.NewsRepository;
import com.thesis.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by lap08 on 8/15/2017.
 */
@Service
public class LocationServiceImpl implements LocationService {

    private static GeoApiContext context = new GeoApiContext()
            .setApiKey("AIzaSyCsy02RVCZOrSgEDC-R5daQ1vz5A3lpIL4");
    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<LocationDTO> getTopLocation(int size) throws InterruptedException, ApiException, IOException {
        long date = System.currentTimeMillis();
        int offset = TimeZone.getTimeZone("GMT-7").getOffset(date);
        // Get current time - 12h
        long currentSeconds = (date + offset) / 1000 - Constant.IN_TIME_HOUR * 3600;
        int id = 0;
        List<LocationDTO> locationDTOList = new ArrayList<>();

        List<News> newsList = newsRepository.findCurrentNewsInTime(currentSeconds);
        Map<String, Integer> topLocation = new HashMap<>();
        Map<String, List<NewsDTO>> topLinks = new HashMap<>();
        for (News news : newsList) {
            if(news.getPlaceList() == null || news.getPlaceList().isEmpty()) {
                continue;
            }
            boolean checkedNews = true;
            for (String place : news.getPlaceList()) {
                if (topLocation.containsKey(place)) {
                    topLocation.put(place, topLocation.get(place) + 1);
                } else {
                    topLocation.put(place, 1);
                }


                if(!topLinks.containsKey(place) || checkedNews) {
                    NewsDTO newsDTO = new NewsDTO(news.getTitle(), news.getReference(), news.get_id());
                    List<NewsDTO> newsDTOList = topLinks.getOrDefault(place, new ArrayList<>());
                    if(newsDTOList.size() >= Constant.TOP_LINKS_RELATED_LOATION) {
                        continue;
                    }
                    newsDTOList.add(newsDTO);
                    topLinks.put(place, newsDTOList);
                    checkedNews = false;
                }
            }
        }
        topLocation = Utils.sortByValue(topLocation);

        int count = 1;
        for (String location : topLocation.keySet()) {
            if(count > size) {
                break;
            }
            GeocodingResult[] results = GeocodingApi.geocode(context,
                    location).await();
            LocationDTO locationDTO = new LocationDTO(location,
                    topLocation.get(location),
                    results[0].geometry, topLinks.get(location));
            System.out.println(results[0].formattedAddress);
            locationDTOList.add(locationDTO);
            count++;
        }
        return locationDTOList;
    }

}
