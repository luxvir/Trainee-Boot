package com.ciber.controller;

import com.ciber.exception.ModeloNotFoundException;
import com.ciber.model.Classes;
import com.ciber.model.DtoClasses;
import com.ciber.model.StudentClasses;
import com.ciber.model.Students;
import com.ciber.service.IClassesService;
import com.ciber.service.IStudentClassesService;
import com.ciber.service.feign.StudentsServiceClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
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

@Api(value = "Swagger rest", description = "Mostar información")
@RestController
public class StudentClassesController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IStudentClassesService service;

  /**
   * La función listStudentClasses() retorna la lista de student Classes.
   * 
   * @return list of student Classes.
   */
  @ApiOperation(value = "Retorna lista de student Classes")
  @GetMapping(value = "/api/v2/studentClasses")
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
  @PostMapping(value = "/api/v2/studentClasses", consumes = "application/json", produces = "application/json")
  public ResponseEntity<StudentClasses> createfamilies(@RequestBody StudentClasses stu) {

    return new ResponseEntity<StudentClasses>(service.create(stu), HttpStatus.CREATED);
  }

  /**
   * La función studentClasses() se encarga de actualizar a un objeto student
   * Classes.
   * 
   * @param stuClass object student Classes.
   * @return object student Classes.
   */
  @ApiOperation(value = "Actualiza a una student Classes")
  @PutMapping(value = "/api/v2/studentClasses", consumes = "application/json", produces = "application/json")
  public ResponseEntity<StudentClasses> updateStudentClasse(@RequestBody StudentClasses stuClass) {
    String mensaje = "";
    Optional<StudentClasses> stu = service.findByID(stuClass.getStudents().getStudentId());

    if (stu.isPresent()) {
      return new ResponseEntity<StudentClasses>(service.update(stuClass), HttpStatus.OK);
    } else {
      mensaje = "Error en el ID: " + stuClass.getClasses().getClassesId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteTeachers() se encarga de remover a un objeto studentClasses
   * por su código.
   * 
   * @param stuClass Update.
   * @return object studentClasses delete.
   */

  @ApiOperation(value = "Elimina datos de una studentClasses")
  @DeleteMapping(value = "/api/v2/studentClasses", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deleteTeachers(@RequestBody StudentClasses stuClass) {
    int rpta = 0;
    String mensaje = "";

    Optional<StudentClasses> s = service.findByID(stuClass.getStudents().getStudentId());
    Optional<StudentClasses> c = service.findByID(stuClass.getClasses().getClassesId());
    if (s.isPresent() && c.isPresent()) {
      log.info("ID student : " + stuClass.getStudents().getStudentId() + " - " + "ID teacher: "
          + stuClass.getClasses().getClassesId());
      rpta = service.delete(stuClass);
      return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    } else {
      mensaje = "Error en  Student Classes";
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * Lo necesario para Listar. 
   */
  
  List<Integer> listStudentIds = new ArrayList<Integer>();
  List<Students> listStudents = new ArrayList<Students>();
  // llamo al feign service
  @Autowired
  StudentsServiceClient studentsServiceClient;
  
  Classes clase = new Classes();
  @Autowired
  DtoClasses dtoClase;
  @Autowired
  private IClassesService serviceClass;

  @GetMapping("/api/v2/studentClasses/ids")
  public List<Integer> getAllIdsByClassId(@RequestBody Integer classId) {
    return service.getAllIdsByClassId(classId);
  }

  /**
   * Lista a los estudiantes por CLase ID.
   * @param classId parametro de Clase.
   * @return lista de clase por ID.
   */
  @GetMapping("/api/v2/studentClasses/ids/{classId}")
  public DtoClasses getClassAndAllStudentsByClassId(@PathVariable Integer classId) {
    listStudentIds = (List<Integer>) getAllIdsByClassId(classId);

    try {
      listStudents = studentsServiceClient.listAllStudentById(listStudentIds);
      log.info("ID de clase: "+classId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    clase = serviceClass.getOne(classId);

    if (clase == null) {
      log.info("clase es nulo.");
    } else {
      log.info("clase no es nulo.");
    }
    dtoClase.setClassesId(clase.getClassesId());
    dtoClase.setClassCode(clase.getClassCode());
    dtoClase.setClassName(clase.getClassName());
    dtoClase.setDeleteStatus(clase.getDeleteStatus());
    dtoClase.setSubjects(clase.getSubjects());
    dtoClase.setTeachers(clase.getTeachers());
    dtoClase.setDateFrom(clase.getDateFrom());
    dtoClase.setDateTo(clase.getDateTo());
    dtoClase.setListStudents(listStudents);
    return dtoClase;
  }

}
