package com.postgrestest.jsonpostgres.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgrestest.jsonpostgres.entity.Result;
import com.postgrestest.jsonpostgres.repositories.ResultRepository;
import com.postgrestest.jsonpostgres.repositories.StockRepository;


import com.postgrestest.jsonpostgres.services.ResultService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class ResultController {

    private final String apiLink = "https://morningstar1.p.rapidapi.com/endofdayquotes/history?Mic=XNAS&EndOfDayQuoteTicker=126.1.";
    private final String key = "32b01b33aemsh0cdca1e2035edeap131d08jsn449d7afd12d2";
    private final String host = "morningstar1.p.rapidapi.com";

    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

    private ResultRepository resultRepository;
    private ResultService resultService;


    @Autowired
    public ResultController(ResultRepository resultRepository, ResultService resultService) {
        this.resultService = resultService;
        this.resultRepository = resultRepository;
    }



    @RequestMapping("result")
    public void getHistoryRequest(String symbol) {
        URL url = null;
        symbol = "Aasfewgrehewhrth";
        try {
            url = new URL(apiLink + symbol);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = java.net.http.HttpRequest.newBuilder()
                    .uri(URI.create(String.valueOf(url)))
                    .header("x-rapidapi-host", host)
                    .header("x-rapidapi-key", key)
                    .header("accept","string")
                    .build();

                HttpResponse<String> response = client.send(request,
                        HttpResponse.BodyHandlers.ofString());
            resultRepository.saveAll(resultService.method(response));
        } catch (IOException | InterruptedException e) {
                e.printStackTrace();
        }


        }
}
