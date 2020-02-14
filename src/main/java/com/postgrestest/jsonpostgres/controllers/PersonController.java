package com.postgrestest.jsonpostgres.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgrestest.jsonpostgres.entity.Person;
import com.postgrestest.jsonpostgres.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("json")
    public void json() {
//        List<String> tickers;
//        URL url = null;
//        try {
//            url = new URL("http://asd.com");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//
//        if (url!=null) {
//            File jsonFile = new File(url.get);
//
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            try {
//                List<Person> people = objectMapper.readValue(jsonFile, new TypeReference<List<Person>>(){});
//
//                personRepository.saveAll(people);
//
//                logger.info("All records saved.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else
//            logger.warn("url is null");
    }

}
