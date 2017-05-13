package com.thesis.controller;

import com.thesis.entity.Location;
import com.thesis.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lap08 on 5/13/2017.
 */

@RestController
@RequestMapping(value = "/api/location")
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBody getAllUsers() {

        List<Location> locationList = locationRepository.findAll();
        System.out.println(locationList.size());
        return null;
    }
}
