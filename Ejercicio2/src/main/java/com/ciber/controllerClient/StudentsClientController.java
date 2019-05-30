package com.ciber.controllerClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciber.model.Students;
import com.ciber.serverFeign.StudentsServiceClient;


@RestController
public class StudentsClientController {

 @Autowired
  StudentsServiceClient service;
  
  public StudentsClientController(StudentsServiceClient service) {
	this.service = service;
  }


  @GetMapping("api/version")
  public List<Students> getStudnts() throws InterruptedException { 
	  Thread.sleep(2000);
    return service.getStudents();
  }
  
  @PostMapping("api/version/listIds/")
  public ResponseEntity< List<Students>> listAllStudentById(@RequestBody List<Integer> listStudnt) throws InterruptedException {
	  return new ResponseEntity<List<Students>>(service.listAllStudentById(listStudnt), HttpStatus.OK);
  }

}
