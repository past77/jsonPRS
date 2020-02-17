package com.postgrestest.jsonpostgres.repositories;

import com.postgrestest.jsonpostgres.entity.Result;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Long> {
}
