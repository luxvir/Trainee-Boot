package com.ciber.service;

import com.ciber.dao.IStudentsDao;
import com.ciber.model.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements IStudentsService {
  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IStudentsDao dao;

  /**
   * The function findAll() returns the list of students.
   * 
   * @return list of students.
   */
  @Override
  public List<Students> findAll() {
    List<Students> lista = new ArrayList<>();
    try {
      lista = dao.findAll();
      log.info("Lista de estudiantes.");
    } catch (Exception e) {
      log.info("error " + e);
    }
    return lista;
  }

  /**
   * The function create() is responsible for creating a student object.
   * 
   * @return student.
   */
  @Override
  public Students create(Students stu) {
    Students st = new Students();
    try {
      st = dao.save(stu);
      log.info("Actualizo estudiante");
    } catch (Exception e) {
      log.info("Error: " + e);
    }
    return st;
  }

  /**
   * The function create() is responsible for creating a student object.
   * 
   * @return student.
   */
  @Override
  public Students update(Students stu) {
    Students st = new Students();
    try {
      st = dao.save(stu);
      log.info("Actualizo estudiante ");
    } catch (Exception e) {
      log.info("Error: " + e);
    }
    return st;
  }

  /**
   * The function delete() is responsible for delete a student object.
   * 
   * @return student.
   */
  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
      log.info("Elemino estudiante");
    } catch (Exception e) {
      rpta = 0;
      log.info("Error: " + e);
    }
    return rpta;
  }

  @Override
  public Optional<Students> findById(int id) {
    return (Optional<Students>) dao.findById(id);
  }
}
