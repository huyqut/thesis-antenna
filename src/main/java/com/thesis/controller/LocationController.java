package com.thesis.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.sun.xml.internal.stream.events.LocationImpl;
import com.thesis.dto.LocationDTO;
import com.thesis.repository.LocationRepository;
import com.thesis.response.Response;
import com.thesis.response.Success;
import com.thesis.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<LocationDTO>> getTopLocations(@RequestParam int size) throws InterruptedException, ApiException, IOException {
        List<LocationDTO> locationDTOList = locationService.getTopLocation(size);
        return Success.TOP_LOCATION_FOUND.with(locationDTOList);
    }
}
