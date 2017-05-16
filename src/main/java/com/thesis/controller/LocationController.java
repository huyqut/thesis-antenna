package com.thesis.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.thesis.AbstractResponse;
import com.thesis.common.ErrorCode;
import com.thesis.common.SuccessCode;
import com.thesis.entity.Location;
import com.thesis.repository.LocationRepository;
import com.thesis.responseDTO.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lap08 on 5/13/2017.
 */

@RestController
@RequestMapping(value = "/api/location")
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    static GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCsy02RVCZOrSgEDC-R5daQ1vz5A3lpIL4");

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AbstractResponse getAllUsers() throws InterruptedException, ApiException, IOException {

        List<LocationDTO> locationDTOList = new ArrayList<>();
        List<Location> locationList = locationRepository.findAll();
        locationList.subList(20, locationList.size()).clear();
        for(Location location : locationList) {
            GeocodingResult[] results =  GeocodingApi.geocode(context,
                            location.getPlace()).await();
            LocationDTO locationDTO = new LocationDTO(location.getPlace(), location.getCount(), results[0].geometry);
            System.out.println(results[0].formattedAddress);
            locationDTOList.add(locationDTO);
        }
        return new AbstractResponse(locationDTOList, "Success", SuccessCode.SUCCESS, null);
    }
}
