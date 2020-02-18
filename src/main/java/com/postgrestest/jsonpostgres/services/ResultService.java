package com.postgrestest.jsonpostgres.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgrestest.jsonpostgres.entity.Result;
import com.postgrestest.jsonpostgres.repositories.ResultRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ResultService implements ResultServiceInterface {
    private final String apiLink = "https://morningstar1.p.rapidapi.com/endofdayquotes/history?Mic=XNAS&EndOfDayQuoteTicker=126.1.";
    private final String key = "32b01b33aemsh0cdca1e2035edeap131d08jsn449d7afd12d2";
    private final String host = "morningstar1.p.rapidapi.com";

    private ResultRepository resultRepository;

    //method for daily update
    @Scheduled
    public void updateHistoryData() {
        getHistoryData("A");
    }

    public void getHistoryData(String symbol) {
        URL url = null;
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
                    .header("accept", "string")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            String data = response.body();
            JSONObject obj = new JSONObject(data);
            JSONArray arr = obj.getJSONArray("results");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Result> results = objectMapper.readValue(arr.toString(), new TypeReference<>() {
            });
            results.forEach(r -> r.setSymbol("A"));
            resultRepository.saveAll(results);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
