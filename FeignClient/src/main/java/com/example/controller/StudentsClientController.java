package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.StudentsServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RequestMapping("/api")
@RestController
public class StudentsClientController {

  @Autowired
  StudentsServiceClient service;
  
  
  @HystrixCommand(fallbackMethod = "fallback_list", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
      })
  @GetMapping("/version")
  public List<Object> getStudnts() throws InterruptedException{
    Thread.sleep(200);
    return service.getStudents();
  }
  
  public List<Object> fallback_list(){
    List<Object> e = new ArrayList<>();
    e.add("Error");
    return e;
  }

}
