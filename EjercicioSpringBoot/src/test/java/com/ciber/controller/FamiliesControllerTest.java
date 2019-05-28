package com.ciber.controller;

import com.ciber.dao.IFamiliesDao;
import com.ciber.model.Families;
import com.ciber.model.Parents;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamiliesControllerTest {
  @Autowired
  private IFamiliesDao dao;

  @Test
  public void testListFamilies() {
    dao.findAll();
  }

  @Test
  public void testCreatefamilies() {
    Families f = new Families();
    Parents p = new Parents();
    int par = 3;
    p.setParentId(par);
    f.setParents(p);
    f.setFamilyName("");
    dao.save(f);

  }

  @Test
  public void testUpdatefamilies() {
    Families f = new Families();
    Parents p = new Parents();
    int par = 3;
    p.setParentId(par);

    p.setParentId(1);
    f.setFamilyId(2);
    f.setParents(p);
    f.setFamilyName("Pinedo");
    dao.save(f);
  }

  @Test
  public void testDeletefamilies() {
    dao.deleteById(2);
  }

}
