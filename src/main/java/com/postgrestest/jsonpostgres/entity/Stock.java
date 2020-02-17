package com.postgrestest.jsonpostgres.entity;


import lombok.Data;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.net.http.HttpClient;
import java.util.*;


@Entity(name = "stock")
@Data
@Table(schema = "stocks", name = "stockNYSE")
public class Stock {
    @Id
    @GeneratedValue()
    private Long id;
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Result> results = new HashSet<>();

    public Stock() {
    }
}
