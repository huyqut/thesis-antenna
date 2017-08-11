package com.thesis.controller;

import com.google.maps.errors.ApiException;
import com.thesis.dto.GraphDTO;
import com.thesis.repository.LocationRepository;
import com.thesis.dto.LocationDTO;
import com.thesis.response.Response;
import com.thesis.response.Success;
import com.thesis.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by lap08 on 8/11/2017.
 */

@RestController
@RequestMapping(value = "/api/graph")
public class ForceGraphController {

    @Autowired
    GraphService graphService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<GraphDTO> getGraphData()
            throws InterruptedException, ApiException, IOException {
        GraphDTO graphDTO = graphService.getDataGraph();
        return Success.GET_DATA_GRAPH.with(graphDTO);
    }
}
