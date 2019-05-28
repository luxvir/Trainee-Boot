package com.ciber.controller;

import com.ciber.exception.ModeloNotFoundException;
import com.ciber.model.StudentClasses;
import com.ciber.server.IClassesService;
import com.ciber.server.IStudentClassesService;

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
public class StudentClassesController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IStudentClassesService service;
  private IClassesService serviceClass;

  /**
   * La función listStudentClasses() retorna la lista de student Classes.
   * 
   * @return list of student Classes.
   */
  @ApiOperation(value = "Retorna lista de student Classes")
  @GetMapping(value = "/api/v1/studentClasses")
  public ResponseEntity<List<StudentClasses>> listStudentClasses() {
    return new ResponseEntity<List<StudentClasses>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * La función createfamilies() se encarga de registrar a un objeto student
   * Classes.
   * 
   * @param stu object student Classes.
   * @return object student Classes.
   */
  @ApiOperation(value = "Crea a una student Classes")
  @PostMapping(value = "/api/v1/studentClasses", consumes = "application/json", produces = "application/json")
  public ResponseEntity<StudentClasses> createfamilies(@RequestBody StudentClasses stu) {

    return new ResponseEntity<StudentClasses>(service.create(stu), HttpStatus.CREATED);
  }

  /**
   * La función studentClasses() se encarga de actualizar a un objeto student Classes.
   * 
   * @param stuClass object student Classes.
   * @return object student Classes.
   */
  @ApiOperation(value = "Actualiza a una student Classes")
  @PutMapping(value = "/api/v1/studentClasses", consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<StudentClasses> updateStudentClasse(@RequestBody StudentClasses stuClass) {
    String mensaje = "";
    Optional<StudentClasses> stu = service.findByID(stuClass.getStudents().getStudentId());
    Optional<StudentClasses> cla = service.findByID(stuClass.getClasses().getClassesId());

    if (stu.isPresent() && cla.isPresent()) {
      return new ResponseEntity<StudentClasses>(service.update(stuClass), HttpStatus.OK);
    } else {
      mensaje = "error " + stuClass.getClasses().getClassesId();
      throw new ModeloNotFoundException(mensaje);
    }
  }
  /**
   * La función deleteTeachers() se encarga de remover a un objeto studentClasses por su
   * código.
   * 
   * @param teach Update.
   * @return object studentClasses delete.
   */
  @ApiOperation(value = "Elimina datos de una studentClasses")
  @DeleteMapping(value = "/api/v1/studentClasses", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<Integer> deleteTeachers(@RequestBody StudentClasses stuClass) {
    int rpta = 0;
    String mensaje = "";

    Optional<StudentClasses> s = service.findByID(stuClass.getStudents().getStudentId());
    Optional<StudentClasses> c = service.findByID(stuClass.getClasses().getClassesId());
    if (s.isPresent() && c.isPresent()) {
      log.info("id student : " + stuClass.getStudents().getStudentId()+" - "+ "id teacher: "+stuClass.getClasses().getClassesId());
      rpta = service.delete(stuClass);
      return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    } else {
      mensaje = "error en  StudentClasses" ;
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * findByClassIdStudentClasses() se le envia un parametro idClass y retorna a
   * los studentClasses.
   * 
   * @param idClass es el parametro definido para studentClasses.
   * @return idClass es el parametro necesario para bucarlos a los de cuyo idClass
   *         studentClasses.
   */
  @ApiOperation(value = "Retorna inforacion de studentClasses por su Id")
  @GetMapping(value = "/api/v1/studentClasses/{id}/class")
  public ResponseEntity<List<StudentClasses>> findByClassIdStudentClasses(@PathVariable("id") int idClass) {
    return new ResponseEntity<List<StudentClasses>>(serviceClass.findByClass(idClass),
        HttpStatus.OK);

  }
  
}
