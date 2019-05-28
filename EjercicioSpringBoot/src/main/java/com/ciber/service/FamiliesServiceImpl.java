package com.ciber.service;

import com.ciber.dao.IFamiliesDao;
import com.ciber.dao.IFamilyMembersDao;
import com.ciber.dao.IParentsDao;
import com.ciber.model.Families;
import com.ciber.model.FamilyMembers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class FamiliesServiceImpl implements IFamiliesService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IFamiliesDao dao;

  @Autowired
  private IFamilyMembersDao daoMem;

  @Autowired
  private IParentsDao daoParen;

  @Override
  public List<Families> findAll() {
    List<Families> lista = new ArrayList<>();
    try {
      lista = dao.findAll();
      log.info("Lista familias.");
    } catch (Exception e) {
      log.info("error " + e);
    }
    return lista;
  }

  Families famili = new Families();

  @Override
  public Families create(Families fami) {
    log.info("entro");
    try {

      daoParen.findById(fami.getParents().getParentId()).ifPresent((p) -> {

        log.info("codigo encontrado" + fami.getParents().getParentId());

        fami.setFamilyId(fami.getFamilyId());
        log.info("pasa al registro");

        famili = dao.save(fami);
        log.info("registrado");
      });

    } catch (Exception e) {
      log.info("error" + e);
    }
    log.info("termino proceso");
    return famili;
  }

  @Override
  public Families update(Families fami) {
    return dao.save(fami);
  }

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

  @Override
  public List<FamilyMembers> findByFamilies(int famiId) {
    return (List<FamilyMembers>) daoMem.findByFamiliesFamilyId(famiId);
  }
 
  @Override
  public Optional<Families> findByID(int id) {
    log.info(" id "+id);
    return (Optional<Families>)dao.findById(id);
  }

}
