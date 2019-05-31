package com.ciber.service;

import com.ciber.dao.IClassesDao;
import com.ciber.dao.IStudentClassesDao;
import com.ciber.model.Classes;
import com.ciber.model.StudentClasses;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SudentClassesServiceImpl implements IStudentClassesService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IStudentClassesDao dao;
  @Autowired
  private IClassesDao daoClas;

  /**
   * Funcion que lista todos los estudiantes de un Clase.
   */
  @Override
  public List<StudentClasses> findAll() {

    return (List<StudentClasses>) dao.findAll();
  }

  /**
  * Funcion que se encargara de registar un estudiante de clase.
  */
  @Override
  public StudentClasses create(StudentClasses stu) {
    StudentClasses studen = new StudentClasses();
    String msg = "";
    Optional<Classes> c = daoClas.findById(stu.getClasses().getClassesId());
    if (c.isPresent()) {
      studen = dao.save(stu);
    } else {
      msg = "error en el registro";
      log.info(msg);
    }
    return studen;
  }

  /**
   * Funcion que se encarga de actualizar una Clase.
   */
  @Override
  public StudentClasses update(StudentClasses stu) {

    return dao.save(stu);
  }

  /**
   * Funcion que elemina a un estudiante de clase.
   */
  @Override
  public int delete(StudentClasses stu) {

    int rpta = 0;
    try {
      dao.delete(stu);
      rpta = 1;
    } catch (Exception e) {
      rpta = 0;
      log.info("error " + e);
    }
    log.info("termino proceso");
    return rpta;
  }

  /**
   * Funcion que busca por sus PKs.
   */
  @Override
  public Optional<StudentClasses> findByID(int id) {

    return dao.findById(id);
  }

  /**
   * oooooooooooo
   */
  @Override
  public List<Integer> getAllIdsByClassId(int classId) {
    return dao.findByClassesClassesId(classId);
  }

}
