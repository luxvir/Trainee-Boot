package com.ciber.controller;

import com.ciber.exception.ModeloNotFoundException;
import com.ciber.model.Families;
import com.ciber.service.IFamiliesService;

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
public class FamiliesController {
  
  Logger log = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  private IFamiliesService service;

  /**
   * La función listFamiliesthat() retorna la lista de familiass.
   * 
   * @return list of families.
   */
  @ApiOperation(value = "Retorna lista de families")
  @GetMapping(value = "/api/v1/families")
  public ResponseEntity<List<Families>> listFamilies() {
    return new ResponseEntity<List<Families>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * La función createfamilies() se encarga de registrar a un objeto familia.
   * 
   * @param fami object families.
   * @return object families.
   */
  @ApiOperation(value = "Crea a una families")
  @PostMapping(value = "/api/v1/families", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Families> createfamilies(@RequestBody Families fami) {
    
    return new ResponseEntity<Families>(service.create(fami), HttpStatus.CREATED);
  }

  /**
   * La función updatefamilies() se encarga de actualizar a un objeto familia.
   * 
   * @param fami object families.
   * @return object families.
   */
  @ApiOperation(value = "Actualiza a una families")
  @PutMapping(value = "/api/v1/families", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Families> updatefamilies(@RequestBody Families fami) {
    String mensaje="";
    Optional<Families> fa = service.findByID(fami.getFamilyId());
    
    if(fa.isPresent()) {
      return new ResponseEntity<Families>(service.update(fami), HttpStatus.OK);
    }else {
      mensaje = "error "+fami.getFamilyId();
      throw  new ModeloNotFoundException(mensaje);
    }    
  }

  /**
   * La función deletefamilies() se encarga de remover a un objeto famila por su
   * código.
   * 
   * @param fami Update.
   * @return object families delete.
   */
  @ApiOperation(value = "Elimina datos de una families")
  @DeleteMapping(value = "/api/v1/families", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Integer> deletefamilies(@RequestBody Families fami) {
    int rpta = 0;
    String mensaje= "";
    
    Optional<Families>   fa = service.findByID(fami.getFamilyId());
    
    if( fa.isPresent()) {
      log.info("id "+ fami.getFamilyId() );
     rpta = service.delete(fami.getFamilyId());
     return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
   }else {
      mensaje="error ID "+fami.getFamilyId();
      throw  new ModeloNotFoundException(mensaje);
    }  
  }
  
  /**
   * La función listById() se le envia un parametro id y retorna a
   * la familia de ese id.
   * 
   * @param id parametro de filtro.
   * @return id.
   */
  @ApiOperation(value = "Retorna inforacion de Families  por su Id")
  @GetMapping(value = "/api/v1/families/{id}")
  public ResponseEntity<Object> listById(@PathVariable("id") Integer id) {
   
    String mensaje= "";
    Optional<Families> fam = service.findByID(id);
    
    if ( fam.isPresent() ) {
      return new ResponseEntity<Object>(fam,HttpStatus.OK);
    }else { 
      mensaje="error  "+id;
      throw  new ModeloNotFoundException(mensaje);
    }
  }
}
