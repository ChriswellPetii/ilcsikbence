package com.greenfoxacademy.rest.repositories;

import com.greenfoxacademy.rest.modells.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogRepository extends CrudRepository<Log, Long> {
  List<Log> findAll();
}
