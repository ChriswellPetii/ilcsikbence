package com.greenfoxacademy.greenfoxclassapp.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  ArrayList<String> names;

  public StudentServiceImpl() {
    names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
  }

  @Override
  public List<String> findAll() {
    return names;
  }

  @Override
  public int count() {
    return names.size();
  }

  @Override
  public String isExisting(String student) {
    if (names.contains(student)) {
      return student + " exists in database";
    } else {
      return student + " does not exist in database";
    }
  }

  @Override
  public void save(String student) {
    names.add(student);
  }
}
