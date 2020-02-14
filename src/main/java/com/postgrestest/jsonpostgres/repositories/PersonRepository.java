package com.postgrestest.jsonpostgres.repositories;

import com.postgrestest.jsonpostgres.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
