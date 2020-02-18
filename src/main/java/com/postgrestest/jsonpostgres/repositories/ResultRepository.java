package com.postgrestest.jsonpostgres.repositories;

import com.postgrestest.jsonpostgres.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
