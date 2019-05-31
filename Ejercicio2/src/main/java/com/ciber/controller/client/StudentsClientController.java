package com.ciber.controller.client;

import com.ciber.model.Students;
import com.ciber.service.feign.StudentsServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentsClientController {

  @Autowired
  StudentsServiceClient service;

  public StudentsClientController(StudentsServiceClient service) {
    this.service = service;
  }

  /**
   * HystrixCommand se encarga de controlar los servicios.
   * @return
   * @throws InterruptedException
   */
  @HystrixCommand(fallbackMethod = "fallback_list", commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
  @GetMapping("api/versions")
  public List<Students> getStudnts() throws InterruptedException {
    Thread.sleep(2000);
    return service.getStudents();
  }

  /**
   * Funcion que retorna un mensaje de error.
   * @return mensaje de error.
   */
  public List<Object> fallback_list() {
    List<Object> e = new ArrayList<>();
    e.add("Error");
    return e;
  }

  /**
   * Devuelve Lista de estudiantes.
   * @param listStudnt lista de estudiantes.
   * @return lista de estudiantes.
   * @throws InterruptedException error.
   */
  @PostMapping("api/versions/listIds/")
  public ResponseEntity<List<Students>> listAllStudentById(@RequestBody List<Integer> listStudnt)
      throws InterruptedException {
    return new ResponseEntity<List<Students>>(service.listAllStudentById(listStudnt), 
            HttpStatus.OK);
  }

}
