package com.ciber.controller;

import com.ciber.exception.ModeloNotFoundException;
import com.ciber.model.Classes;
import com.ciber.service.IClassesService;

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
public class ClassesController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IClassesService service;

  /**
   * La función listClasses() retorna la lista de Classes.
   * 
   * @return list of classes.
   */
  @ApiOperation(value = "Retorna lista de classes")
  @GetMapping(value = "/api/v1/classes")
  public ResponseEntity<List<Classes>> listClasses() {
    return new ResponseEntity<List<Classes>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * La función createClasses() se encarga de registrar a un objeto classes.
   * 
   * @param cla object classes.
   * @return object classes.
   */
  @ApiOperation(value = "Crea a una classes")
  @PostMapping(value = "/api/v1/classes", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Classes> createClasses(@RequestBody Classes cla) {

    return new ResponseEntity<Classes>(service.create(cla), HttpStatus.CREATED);
  }

  /**
   * La función updateClasses() se encarga de actualizar a un objeto classes.
   * 
   * @param cla object classes.
   * @return object classes.
   */
  @ApiOperation(value = "Actualiza a una classes")
  @PutMapping(value = "/api/v1/classes", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Classes> updateClasses(@RequestBody Classes cla) {
    String mensaje = "";
    log.info("ingreso al controller");
    Optional<Classes> c = service.findByID(cla.getClassesId());
    if (c.isPresent()) {
      log.info("id " + cla.getClassesId());
      return new ResponseEntity<Classes>(service.update(cla), HttpStatus.OK);

    } else {
      mensaje = "error " + cla.getClassesId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteClasses() se encarga de remover a un objeto classes por su
   * código.
   * 
   * @param cla Update.
   * @return object classes delete.
   */
  @ApiOperation(value = "Elimina datos de una classes")
  @DeleteMapping(value = "/api/v1/classes", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deleteClasses(@RequestBody Classes cla) {
    int rpta = 0;
    String mensaje = "";

    Optional<Classes> fa = service.findByID(cla.getClassesId());

    if (fa.isPresent()) {
      log.info("id " + cla.getClassesId());
      rpta = service.delete(cla.getClassesId());
      return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    } else {
      mensaje = "error ID " + cla.getClassesId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función listById() se le envia un parametro id y retorna a la classes de
   * ese id.
   * 
   * @param id parametro de filtro.
   * @return id.
   */

  /*
   * @ApiOperation(value = "Retorna inforacion de classes  por su Id")
   * 
   * @GetMapping(value = "/api/v1/classes/{id}") public ResponseEntity<Object>
   * listById(@PathVariable("id") Integer id) {
   * 
   * String mensaje = ""; Optional<Classes> cla = service.findByID(id);
   * 
   * if (cla.isPresent()) { return new ResponseEntity<Object>(cla, HttpStatus.OK);
   * } else { mensaje = "error  " + id; throw new
   * ModeloNotFoundException(mensaje); } }
   */

  /**
   * La función delete() se encarga de actualizar su estado a un objeto Classes
   * por su código.
   * 
   */
  @ApiOperation(value = "Eliminar Classes")
  @DeleteMapping(value = "/api/v1/classes/{id}")
  public void delete(@PathVariable("id") int id) {
    Optional<Classes> s = service.findByID(id);
    String mensaje = "";
    if (s.isPresent()) {
      log.warn("Un Classes fue Eliminado");
      service.softdelete(id);
    } else {
      mensaje = "error en el ID " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * Obtener la lista de clase por un ID.
   * 
   * @param classId parametro de clase.
   * @return lista de clase filtrado por ID.
   * @throws ClassNotFoundException exception.
   */
  @GetMapping("/api/v1/classes/{classId}")
  public Classes getOne(@PathVariable(value = "classId") int classId) throws ClassNotFoundException {
    Classes c = service.getOne(classId);
    if (c == null) {
      throw new ClassNotFoundException("classId: " + classId);
    }
    return c;
  }
}
