package com.ciber.controller;

import com.ciber.model.Students;

import com.ciber.service.IStudentsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Spring Boot Swagger rest", description = "Mostar información")
@RestController
public class StudentsController {

  @Autowired
  IStudentsService service;

  /**
   * La función listStudents() encargado de retorna la lista de studiantes.
   * 
   * @return lista de studentes.
   */

  @ApiOperation(value = "Retorna lista de estudiante")
  @GetMapping(value = "/api/v1/students")
  public ResponseEntity<List<Students>> listStudents() {
    return new ResponseEntity<List<Students>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * La función createStudents() encargado de crear a un objeto estudiante.
   * 
   * @param stu object students.
   * @return objeto studiante creado.
   */

  @ApiOperation(value = "Registra a una estudiante")
  @PostMapping(value = "/api/v1/students", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Students> createStudents(@RequestBody Students stu) {
    return new ResponseEntity<Students>(service.create(stu), HttpStatus.CREATED);
  }

  /**
   * La función updateStudents() encargado de realizar la actualizacion a un
   * objeto estudiante.
   * 
   * @param stu object students.
   * @return estudiante modificado.
   */

  @ApiOperation(value = "Actualiza datos a un estudiante")
  @PutMapping(value = "/api/v1/students", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Students> updateStudents(@RequestBody Students stu) {
    return new ResponseEntity<Students>(service.update(stu), HttpStatus.OK);
  }

  /**
   * La función deleteStudents() responsable de eliminar a un objeto estudiante.
   * 
   * @param stu object studiants.
   * @return objeto estudiant eliminado.
   */

  @ApiOperation(value = "Elimina los datos de un estudiante")
  @DeleteMapping(value = "/api/v1/students", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<Integer> deleteStudents(@RequestBody Students stu) {
    int rpta = 0;
    rpta = service.delete(stu.getStudentId());
    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }

  @ApiOperation(value = "Retorna informacion de students  por su Id")
  @GetMapping(value = "/api/v1/students/{id}")
  public ResponseEntity<Students> listById(@PathVariable("id") int id) {
    return new ResponseEntity<Students>(service.findById(id).get(), HttpStatus.OK);
  }
}
