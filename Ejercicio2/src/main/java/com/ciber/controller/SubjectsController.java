package com.ciber.controller;

import com.ciber.exception.ModeloNotFoundException;
import com.ciber.model.Subjects;
import com.ciber.server.ISubjectsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Spring Boot Swagger rest", description = "Mostar información")
@RestController
public class SubjectsController {
  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ISubjectsService service;

  /**
   * La función listSubjects() retorna la lista de subjects.
   * 
   * @return list of subjects.
   */
  @ApiOperation(value = "Retorna lista de subjects")
  @GetMapping(value = "/api/v1/subjects")
  public ResponseEntity<List<Subjects>> listSubjects() {
    return new ResponseEntity<List<Subjects>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * La función createSubjectss() se encarga de registrar a un objeto subjects.
   * 
   * @param sub object subjects.
   * @return object subjects.
   */
  @ApiOperation(value = "Crea a una subjects")
  @PostMapping(value = "/api/v1/subjects", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Subjects> createSubjectss(@RequestBody Subjects sub) {

    return new ResponseEntity<Subjects>(service.create(sub), HttpStatus.CREATED);
  }

  /**
   * La función updateSubjects() se encarga de actualizar a un objeto subjects.
   * 
   * @param sub object subjects.
   * @return object subjects.
   */
  @ApiOperation(value = "Actualiza a una subjects")
  @PutMapping(value = "/api/v1/subjects", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Subjects> updateSubjects(@RequestBody Subjects sub) {
    String mensaje = "";
    Optional<Subjects> s = service.findByID(sub.getSubjectId());

    if (s.isPresent()) {
      return new ResponseEntity<Subjects>(service.update(sub), HttpStatus.OK);
    } else {
      mensaje = "error " + sub.getSubjectId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteSubjects() se encarga de remover a un objeto subjects por su
   * código.
   * 
   * @param sub Update.
   * @return object subjects delete.
   */
  @ApiOperation(value = "Elimina datos de una subjects")
  @DeleteMapping(value = "/api/v1/subjects", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deleteSubjects(@RequestBody Subjects sub) {
    int rpta = 0;
    String mensaje = "";

    Optional<Subjects> s = service.findByID(sub.getSubjectId());

    if (s.isPresent()) {
      log.info("id " + sub.getSubjectId());
      rpta = service.delete(sub.getSubjectId());
      return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    } else {
      mensaje = "error ID " + sub.getSubjectId();
      throw new ModeloNotFoundException(mensaje);
    }
  }
}
