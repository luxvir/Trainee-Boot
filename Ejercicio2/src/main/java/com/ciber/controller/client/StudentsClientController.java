package com.ciber.controller.client;

import com.ciber.model.Students;
import com.ciber.service.feign.StudentsServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Swagger Feign - client ")
@RestController
public class StudentsClientController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentsServiceClient service;

	public StudentsClientController(StudentsServiceClient service) {
		super();
		this.service = service;
	}

	/**
	 * HystrixCommand se encarga de controlar los servicios.
	 * 
	 * @return un mensaje de error.
	 * @throws InterruptedException excepcion.
	 */
	@ApiOperation(value = "Retorna lista de students")
	@HystrixCommand(fallbackMethod = "fallback_list", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	@GetMapping("/api/v2/students")
	public List<Object> getStudents() throws InterruptedException {
		Thread.sleep(200);
		return service.getStudents();
	}

	/**
	 * Funcion que retorna un mensaje de error.
	 * 
	 * @return mensaje de error.
	 */
	public List<Object> fallback_list() {
		List<Object> e = new ArrayList<>();
		e.add("Lo sentimos, por el momento no contamos con servicio.");
		log.error("Ingreso al conrol de hystrix, time out");
		return e;
	}

	/**
	 * Devuelve Lista de estudiantes.
	 * 
	 * @param listStudnt lista de estudiantes.
	 * @return lista de estudiantes.
	 * @throws InterruptedException error.
	 */
	@ApiOperation(value = "Retorna lista de student de una lista de enteros de IDs.")
	@PostMapping("/api/v2/listIds/")
	public ResponseEntity<List<Students>> listAllStudentById(@RequestBody List<Integer> listStudnt)
			throws InterruptedException {
		return new ResponseEntity<List<Students>>(service.listAllStudentById(listStudnt), HttpStatus.OK);
	}

}
