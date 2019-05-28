package com.ciber.controller;

import com.ciber.dao.IFamilyMembersDao;
import com.ciber.model.Families;
import com.ciber.model.FamilyMembers;
import com.ciber.model.Parents;
import com.ciber.model.Students;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyMembersControllerTest {
  @Autowired
  private IFamilyMembersDao dao;

  @Test
  public void testListfamilyMembers() {
    dao.findAll();
  }

  @Test
  public void testCreatefamilyMembers() {
    Parents p = new Parents();
    int pa = 3;
    p.setParentId(pa);
    Families f = new Families();
    int fa = 4;
    f.setFamilyId(fa);
    Students s = new Students();
    int st = 5;
    s.setStudentId(st);
    FamilyMembers fam = new FamilyMembers();
    fam.setParentOrStudentMember("P");
    fam.setFamilies(f);
    fam.setParents(p);
    fam.setStudents(s);
    dao.save(fam);
  }

  @Test
  public void testUpdatefamilyMembers() {
  
    Parents p = new Parents();
    int pa = 3;
    p.setParentId(pa);
    Families f = new Families();
    int fa = 4;
    f.setFamilyId(fa);
    Students s = new Students();
    int st = 5;
    s.setStudentId(st);
    FamilyMembers fam = new FamilyMembers();
    fam.setFamilyMemberId(3);
    fam.setParentOrStudentMember("P");
    fam.setFamilies(f);
    fam.setParents(p);
    fam.setStudents(s);
    dao.save(fam);
  }

  @Test
  public void testDeletefamilyMembers() {
    dao.deleteById(1);
  }

}
