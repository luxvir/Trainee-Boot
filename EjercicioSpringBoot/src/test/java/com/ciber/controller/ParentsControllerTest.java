package com.ciber.controller;

import com.ciber.dao.IParentsDao;
import com.ciber.model.Parents;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentsControllerTest {

  @Autowired
  private IParentsDao dao;

  @Test
  public void testListParents() {

    dao.findAll();
  }

  @Test
  public void testCreateParents() {
    Parents p = new Parents();
    p.setFisrstName("Fabio");
    p.setGender("M");
    p.setLastName("Cordova");
    p.setMiddleName("Leandro");
    p.setOtherParentDetails("calle el san martin 998 ");

    dao.save(p);

  }

  @Test
  public void testUpdateParents() {
    Parents p = new Parents();
    p.setParentId(7);
    p.setFisrstName("Carla");
    p.setGender("F");
    p.setLastName("Soler");
    p.setMiddleName("Lucia");
    p.setOtherParentDetails("calle el san francisco N 567 ");

    dao.save(p);
  }

  @Test
  public void testDeleteParents() {
    dao.deleteById(6);
  }

}
