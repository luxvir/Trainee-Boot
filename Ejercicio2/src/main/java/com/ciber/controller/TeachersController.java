package com.ciber.controller;

import com.ciber.exception.ModeloNotFoundException;
import com.ciber.model.Teachers;
import com.ciber.service.ITeachersService;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Spring Boot Swagger rest", description = "Mostar información")
@RestController
public class TeachersController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ITeachersService service;

  /**
   * La función listTeachers() retorna la lista de Teachers.
   * 
   * @return list of Teachers.
   */
  @ApiOperation(value = "Retorna lista de Teachers")
  @GetMapping(value = "/api/v1/teachers")
  public ResponseEntity<List<Teachers>> listTeachers() {
    return new ResponseEntity<List<Teachers>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * La función createTeachers() se encarga de registrar a un objeto Teachers.
   * 
   * @param teach object Teachers.
   * @return object Teachers.
   */
  @ApiOperation(value = "Crea a una teachers")
  @PostMapping(value = "/api/v1/teachers", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Teachers> createTeachers(@RequestBody Teachers teach) {
    System.out.println("entro a implement   implements");
    return new ResponseEntity<Teachers>(service.create(teach), HttpStatus.CREATED);
  }

  /**
   * La función updateTeachers() se encarga de actualizar a un objeto Teachers.
   * 
   * @param teach object Teachers.
   * @return object Teachers.
   */
  @ApiOperation(value = "Actualiza a una Teachers")
  @PutMapping(value = "/api/v1/teachers", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Teachers> updateTeachers(@RequestBody Teachers teach) {
    String mensaje = "";
    Optional<Teachers> tea = service.findByID(teach.getTeacherId());

    if (tea.isPresent()) {
      return new ResponseEntity<Teachers>(service.update(teach), HttpStatus.OK);
    } else {
      mensaje = "error " + teach.getTeacherId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteTeachers() se encarga de remover a un objeto teachers por su
   * código.
   * 
   * @param teach Update.
   * @return object teachers delete.
   */
  @ApiOperation(value = "Elimina datos de una teachers")
  @DeleteMapping(value = "/api/v1/teachers", consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<Integer> deleteTeachers(@RequestBody Teachers teach) {
    int rpta = 0;
    String mensaje = "";

    Optional<Teachers> fa = service.findByID(teach.getTeacherId());

    if (fa.isPresent()) {
      log.info("id " + teach.getTeacherId());
      rpta = service.delete(teach.getTeacherId());
      return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    } else {
      mensaje = "error ID " + teach.getTeacherId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función listById() se le envia un parametro id y retorna a la Teachers de
   * ese id.
   * 
   * @param id parametro de filtro.
   * @return id.
   */
  @ApiOperation(value = "Retorna inforacion de teachers  por su Id")
  @GetMapping(value = "/api/v1/teachers/{id}")
  public ResponseEntity<Object> listById(@PathVariable("id") Integer id) {

    String mensaje = "";
    Optional<Teachers> teach = service.findByID(id);

    if (teach.isPresent()) {
      return new ResponseEntity<Object>(teach, HttpStatus.OK);
    } else {
      mensaje = "error  " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función delete() se encarga de actualizar su estado a un 
   * objeto Teachers por su código.
   * 
   */
  @ApiOperation(value = "Eliminar Teachers")
  @DeleteMapping(value = "/api/v1/teachers/{id}")
  public void delete(@PathVariable("id") int id) {
    Optional<Teachers> s = service.findByID(id);
    String mensaje = "";
    if (s.isPresent()) {
      log.warn("Un Teachers fue Eliminado");
      service.softdelete(id);
    } else {
      mensaje = "error en el ID " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

}
