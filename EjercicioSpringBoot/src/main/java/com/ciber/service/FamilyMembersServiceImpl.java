package com.ciber.service;

import com.ciber.dao.IFamiliesDao;
import com.ciber.dao.IFamilyMembersDao;
import com.ciber.dao.IParentsDao;
import com.ciber.dao.IStudentsDao;
import com.ciber.model.FamilyMembers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMembersServiceImpl implements IFamilyMembersService {
  Logger log = LoggerFactory.getLogger(this.getClass());

  FamilyMembers faMembers;

  @Autowired
  private IFamilyMembersDao dao;

  @Autowired
  private IParentsDao daoParen;

  @Autowired
  private IFamiliesDao daoFami;

  @Autowired
  private IStudentsDao daoStu;

  @Override
  public List<FamilyMembers> findAll() {
    List<FamilyMembers> lista = new ArrayList<>();
    try {
      lista = (List<FamilyMembers>) dao.findAll();
      log.info("Lista miembros de familias.");
    } catch (Exception e) {
      log.info("error " + e);
    }
    return lista;
  }

  @Override
  public FamilyMembers create(FamilyMembers famiMem) {
    log.info("entro a registro de miembros de familia");
    try {
      if (famiMem.getParentOrStudentMember().equals("P")) {
        daoParen.findById(famiMem.getParents().getParentId()).ifPresent((p) -> {
          famiMem.setParents(p);
          log.info("Id parents " + famiMem.getParents().getParentId());

          daoFami.findById(famiMem.getFamilies().getFamilyId()).ifPresent((q) -> {
            log.info("Id encontrado de fami " + famiMem.getFamilies().getFamilyId());
            famiMem.setFamilies(q);
          });

          faMembers = dao.save(famiMem);
          log.info("Registro Family Members ");
        });

      } else if (famiMem.getParentOrStudentMember().equals("S")) {
        daoStu.findById(famiMem.getStudents().getStudentId()).ifPresent((s) -> {
          famiMem.setStudents(s);
          log.info("Id encontrado de studiante " + famiMem.getStudents().getStudentId());

          daoFami.findById(famiMem.getFamilies().getFamilyId()).ifPresent((q) -> {
            log.info("Id encontrado de fam " + famiMem.getFamilies().getFamilyId());
            famiMem.setFamilies(q);
          });

          faMembers = dao.save(famiMem);
          log.info("Registro miembro de familia ");
        });

      }

    } catch (Exception e) {
      log.info("Error: " + e);
    }
    log.info("termino proceso");
    return dao.save(famiMem);
  }

  @Override
  public FamilyMembers update(FamilyMembers famiMem) {
    FamilyMembers fami = new FamilyMembers();
    try {
      fami = dao.save(famiMem);
      log.info("Actualizo miembro de familia");
    } catch (Exception e) {
      log.info("Error: " + e);
    }
    return fami;
  }

  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
    } catch (Exception e) {
      rpta = 0;
      log.info("error " + e);
    }
    log.info("termino proceso");
    return rpta;
  }

}
