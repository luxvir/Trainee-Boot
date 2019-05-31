package com.ciber.service;

import com.ciber.dao.ITeachersDao;
import com.ciber.model.Teachers;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersServiceImpl implements ITeachersService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ITeachersDao dao;

  /**
   * Funcion que lista a los profesores.
   */
  @Override
  public List<Teachers> findAll() {
  
    return (List<Teachers>) dao.findAll();
  }

  /**
   * Fucnion que se encarga de crear a un profesor.
   */
  @Override
  public Teachers create(Teachers tea) {
    System.out.println("entro a implement");
    //tea.setDeleteStatus(0);
    return dao.save(tea);
  }

  /**
   * Funcion que se encarga de actualizar  a un profesor.
   */
  @Override
  public Teachers update(Teachers tea) {

    return dao.save(tea);
  }

  /**
   * Funcion que se encarga de elimianar a un Subjects.
   */
  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
      log.info("Eleminado familia");
    } catch (Exception e) {
      rpta = 0;
      log.info("error" + e);
      log.info("no Eleminado familia");
    }
    return rpta;
  }

  /**
   *  Fucnion que busca por ID a Subjects.
   */
  @Override
  public Optional<Teachers> findByID(int id) {

    return dao.findById(id);
  }

  /**
   * Metodo que actualiza a un objeto Subjects.
   */
  @Override
  public void softdelete(int id) {
    dao.softDelete(id);

  }

}
