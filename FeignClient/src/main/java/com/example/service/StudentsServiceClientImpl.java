package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class StudentsServiceClientImpl implements StudentsServiceClient{
  
  StudentsServiceClient dao;
  @Override
  public List<Object> getStudents() {

    return dao.getStudents();
  }

}
