package com.postgrestest.jsonpostgres.controllers;


import com.postgrestest.jsonpostgres.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    private ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }



    @RequestMapping("result")
    public void getHistoryRequest(String symbol) {
        resultService.getHistoryData(symbol);
        }
}
