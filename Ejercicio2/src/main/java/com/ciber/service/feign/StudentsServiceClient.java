package com.ciber.service.feign;

import com.ciber.model.Students;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "micro-server", url = "http://localhost:9090")
public interface StudentsServiceClient {

  /**
   * Funcion que obtiene la lista de estudintes.
   * @return lista de estudiantes.
   */
  @RequestMapping(value = "/api/v1/students",method = RequestMethod.GET)
  List<Students> getStudents();

  /**
   * Funcion que obtine la una lista de estudiantes de una lista de enteros
   * por codigo de estudiante.
   * @param listStudnt lista de codigo de estudiantes.
   * @return una lista de estudiante.
   */
  @RequestMapping(value = "/api/v1/students/ids", method = RequestMethod.POST)
  List<Students> listAllStudentById(List<Integer> listStudnt);

}
