package com.postgrestest.jsonpostgres.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Entity(name = "Stock")
@Data
@Table(schema = "stocks", name = "table1")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String total;
    private String ofset;
    @OneToMany
    private List<Result> results;

    public void addComment(Result result) {
        results.add(result);
        result.setStock(this);
    }

    public void removeComment(Result result) {
        results.remove(results);
        result.setStock(null);
    }

    public Stock() {
    }
}
