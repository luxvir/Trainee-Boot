package com.example.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@FeignClient(name = "micro-server" ,url = "https://localhost:9090")
public interface StudentsServiceClient {

  @GetMapping(value="/api/v1/students")
  public List<Object> getStudents();
  
  @RequestMapping(value="/api/v1/students/ids")
  List<Object> listAllStudentById(List<Integer> listStudnt);
 
}
