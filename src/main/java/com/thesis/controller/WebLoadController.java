package com.thesis.controller;

import com.thesis.response.Response;
import com.thesis.response.Success;
import org.jsoup.nodes.Document;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by huyqut on 8/14/17.
 */
@RestController
@RequestMapping(value = "/api/webload")
public class WebLoadController {

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<String> getWebPage(@RequestParam String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return Success.LOAD_WEB.with(document.html());
    }


}
