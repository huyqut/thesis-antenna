package com.thesis.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.thesis.entity.Location;
import com.thesis.repository.LocationRepository;
import com.thesis.dto.LocationDTO;
import com.thesis.response.Response;
import com.thesis.response.Success;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    private static GeoApiContext context = new GeoApiContext.Builder()
        .apiKey("AIzaSyCsy02RVCZOrSgEDC-R5daQ1vz5A3lpIL4")
        .build();

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<LocationDTO>> getTopLocations(@RequestParam int size)
        throws InterruptedException, ApiException, IOException {
        List<LocationDTO> locationDTOList = new ArrayList<>();
        List<Location> locationList = locationRepository.findTop50ByOrderByCountDesc();
        for(Location location : locationList) {
            GeocodingResult[] results =  GeocodingApi.geocode(context,
                                                              location.getPlace()).await();
            LocationDTO locationDTO = new LocationDTO(location.getPlace(),
                                                               location.getCount(),
                                                               results[0].geometry);
            System.out.println(results[0].formattedAddress);
            locationDTOList.add(locationDTO);
        }
        return Success.TOP_10_LOCATION_FOUND.with(locationDTOList);
    }
}
