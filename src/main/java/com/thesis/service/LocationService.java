package com.thesis.service;

import com.google.maps.errors.ApiException;
import com.thesis.dto.LocationDTO;

import java.io.IOException;
import java.util.List;

/**
 * Created by lap08 on 7/20/2017.
 */
public interface LocationService {
    List<LocationDTO> getTopLocation(int size) throws InterruptedException, ApiException, IOException;
}
