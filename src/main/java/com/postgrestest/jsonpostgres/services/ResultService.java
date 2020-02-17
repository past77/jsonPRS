package com.postgrestest.jsonpostgres.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgrestest.jsonpostgres.entity.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ResultService {


    public List<Result> method(HttpResponse<String> response) {
        List<Result> results = null;
        String data = response.body();
        JSONObject obj = new JSONObject(data);

        JSONArray arr = obj.getJSONArray("results");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
        results = objectMapper.readValue(arr.toString(), new TypeReference<List<Result>>(){});
        results.forEach(r -> r.setSymbol("A"));
        } catch (IOException e) {
        e.printStackTrace();
        }
        return results;
    }
}
