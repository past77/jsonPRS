package com.postgrestest.jsonpostgres.controllers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgrestest.jsonpostgres.entity.Result;
import com.postgrestest.jsonpostgres.entity.Stock;
import com.postgrestest.jsonpostgres.repositories.ResultRepository;
import com.postgrestest.jsonpostgres.repositories.StockRepository;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class StockController {

    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    private StockRepository stockRepository;
    private ResultRepository resultRepository;

    @Autowired
    public StockController(ResultRepository stockRepository) {
        this.resultRepository = stockRepository;
    }


    @RequestMapping("stock")
    public void json() {

        URL url = null;
        String key = "32b01b33aemsh0cdca1e2035edeap131d08jsn449d7afd12d2";
        String host = "morningstar1.p.rapidapi.com";
        try {
            url = new URL("https://morningstar1.p.rapidapi.com/endofdayquotes/history?Mic=XNAS&EndOfDayQuoteTicker=126.1.MSFT");
            //
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

            String data = response.body();

            System.out.println(data);
            JSONObject obj = new JSONObject(data);

            JSONArray arr = obj.getJSONArray("results");

            for (int i = 0; i < arr.length(); i++) {
                String date = arr.getJSONObject(i).getString("date");
                System.out.println(date);
            }

//            JSONObject jsonObject = new JSONObject(data);
//            JSONObject jsonMap = (JSONObject) jsonObject.get("results:"); // Generates HashMap, key-value pair
//            //String companyName = (String) jsonMap.get("Company Name:"); // from map prepared above get key value
//            System.out.println(jsonMap);
//            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
//            writer.write(data);
//
            ObjectMapper objectMapper = new ObjectMapper();
            List<Result> stocks = objectMapper.readValue(arr.toString(), new TypeReference<List<Result>>(){});
            resultRepository.saveAll(stocks);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
