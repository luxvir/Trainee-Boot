package com.ciber.service;

import com.ciber.dao.ISubjectsDao;
import com.ciber.model.Subjects;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectsServiceImpl implements ISubjectsService {
  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ISubjectsDao dao;

  /**
   * uncion que lista a todos los Subjects.
   */
  @Override
  public List<Subjects> findAll() {

    return (List<Subjects>) dao.findAll();
  }

  /**
   * Funcion que se encarga de registar a un Subjects.
   */
  @Override
  public Subjects create(Subjects subj) {

    return dao.save(subj);
  }

  /**
   * Funcion que se encarga de actualizar a un objeto Subjects.
   */
  @Override
  public Subjects update(Subjects subj) {
    // TODO Auto-generated method stub
    return dao.save(subj);
  }

  /**
   * Funcion que se encarga de eliminar a un objeto Subjects.
   */
  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
      log.info("Eleminado familia " + id);
    } catch (Exception e) {
      rpta = 0;
      log.info("error" + e);
      log.info("no Eleminado familia");
    }
    return rpta;
  }

  /**
   * Funcion que busca por ID.
   */
  @Override
  public Optional<Subjects> findByID(int id) {

    return dao.findById(id);
  }

  /**
   * Funcion que actualiza a un objeto Subjects.
   */
  @Override
  public void softdelete(int id) {
    dao.softDelete(id);
  }

  /**
   * Funcion que actualiza a un objeto Subjects.
   */
  @Override
  public Subjects patchUpd(Subjects subj) {

    return dao.save(subj);
  }

  @Override
  public Optional<Subjects> patchFindById(int id) {
    
    return dao.findById(id);
  }

}
