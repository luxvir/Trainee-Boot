package com.ciber.service;

import com.ciber.dao.IParentsDao;
import com.ciber.model.Parents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentsServiceImpl implements IParentsService {
  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IParentsDao dao;

  @Override
  public List<Parents> findAll() {
    List<Parents> lista = new ArrayList<>();
    try {
      lista = dao.findAll();
      log.info("Lista parientes.");
    } catch (Exception e) {
      log.info("error " + e);
    }
    return lista;
  }

  @Override
  public Parents create(Parents paren) {
    Parents pa = new Parents();
    try {
      pa = dao.save(paren);
      log.info("Regristro parientes.");
    } catch (Exception e) {
      log.info("error " + e);
    }
    return pa;
  }

  @Override
  public Parents update(Parents paren) {
    Parents pa = new Parents();
    try {
      pa = dao.save(paren);
      log.info("Actulizo parientes");
    } catch (Exception e) {
      log.info("error " + e);
    }
    return pa;
  }

  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
    } catch (Exception e) {
      rpta = 0;
    }
    return rpta;
  }

  @Override
  public Optional<Parents> findId(int id) {
    return (Optional<Parents>)dao.findById(id);
  }

}
