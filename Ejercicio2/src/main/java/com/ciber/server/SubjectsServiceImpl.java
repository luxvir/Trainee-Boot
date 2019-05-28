package com.ciber.server;

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

  @Override
  public List<Subjects> findAll() {

    return (List<Subjects>) dao.findAll();
  }

  @Override
  public Subjects create(Subjects subj) {

    return dao.save(subj);
  }

  @Override
  public Subjects update(Subjects subj) {
    // TODO Auto-generated method stub
    return dao.save(subj);
  }

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

  @Override
  public Optional<Subjects> findByID(int id) {

    return dao.findById(id);
  }

}
