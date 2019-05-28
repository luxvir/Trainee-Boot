package com.ciber.controller;

import com.ciber.dao.IStudentsDao;
import com.ciber.model.Students;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentsControllerTest {

  @Autowired
  private IStudentsDao dao;

  @Test
  public void testListStudents() {
    dao.findAll();
  }

  @Test
  public void testCreateStudents() {
    Students stu = new Students();
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
    String strFecha = "12/04/1999";
    Date fecha = null;
    try {

      fecha = formatoDelTexto.parse(strFecha);
    } catch (ParseException ex) {

      ex.printStackTrace();

    }
    stu.setDateOfBirth(fecha);
    stu.setFirstName("Malu");
    stu.setMiddleName("Gabiela");
    stu.setLastName("Canva");
    stu.setOtherStudentsDetails("Calle el Santo Domingo");
    dao.save(stu);
  }

  @Test
  public void testUpdateStudents() {
    Students stu = new Students();
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
    String strFecha = "12/04/1999";
    Date fecha = null;
    try {

      fecha = formatoDelTexto.parse(strFecha);

    } catch (ParseException ex) {

      ex.printStackTrace();

    }
    stu.setStudentId(5);
    stu.setDateOfBirth(fecha);
    stu.setFirstName("Alma");
    stu.setMiddleName("Lina");
    stu.setLastName("Perales");
    stu.setOtherStudentsDetails("Calle el Olivar N 897");
    dao.save(stu);
  }

  @Test
  public void testDeleteStudents() {
    dao.deleteById(5);
  }

}
