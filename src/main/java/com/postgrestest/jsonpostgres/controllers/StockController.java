package com.postgrestest.jsonpostgres.controllers;


import com.postgrestest.jsonpostgres.entity.Stock;
import com.postgrestest.jsonpostgres.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockController {

    StockRepository stockRepository;

    @Autowired
    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @RequestMapping("stock")
    public RedirectView stock() {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock());
        stocks.add(new Stock());
        stocks.add(new Stock());

        stockRepository.saveAll(stocks);

        return new RedirectView("http://localhost:4001/result");
    }
}
