package com.postgrestest.jsonpostgres.entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "result")
@Data
@Table(schema = "stocks", name = "resultsNYSE")
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String open;
    private String high;
    private String low;
    private String last;
    private int volume;
    private String symbol;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Result() {
    }

}
