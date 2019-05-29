package com.ciber.serverFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciber.model.Students;

@FeignClient(name="micro-server", url="http://localhost:9090")
public interface StudentsServiceClient {

  @RequestMapping(value="/api/v1/students", method = RequestMethod.GET)
  List<Students> getStudents();
  
  @RequestMapping(value="/api/v1/students/ids")
  List<Students> listAllStudentById(List<Integer> listStudnt);
 
}
