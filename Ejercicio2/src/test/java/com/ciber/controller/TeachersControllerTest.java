package com.ciber.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ciber.model.Subjects;
import com.ciber.model.Teachers;
import com.ciber.service.TeachersServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TeachersController.class)
public class TeachersControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TeachersServiceImpl  teachersServiceImpl  ;

  List<Teachers> listTeacherMock = new ArrayList<Teachers>();
  

  @Test
  public void testListTeachers() throws Exception {
    listTeacherMock.add(new Teachers(9, 1,"F","Peredo","Lina","Pinedo","Avenida"));
  
    Mockito.when(teachersServiceImpl.findAll()).thenReturn(listTeacherMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/teachers").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{\"teacherId\":9,\"schoolId\":1,\"gender\":\"F\",\"firstName\":\"Peredo\",\"middleName\":\"Lina\",\"lastName\":\"Pinedo\",\"otherTeacherDetails\":\"Avenida\"}]";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListTeachersFalse() throws Exception {
    listTeacherMock.add(new Teachers(9, 1,"F","Peredo","Lina","Pinedo","Avenida"));
   
    Mockito.when(teachersServiceImpl.findAll()).thenReturn(listTeacherMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/teachers").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{\"teacherId\":10,\"schoolId\":1,\"gender\":\"F\",\"firstName\":\"Peredo\",\"middleName\":\"Lina\",\"lastName\":\"Pinedo\",\"otherTeacherDetails\":\"Avenida\"}]";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }
  
  @Test
  public void testListTeachersByID() throws Exception {
    Teachers teacherMock = new Teachers(9, 1,"F","Peredo","Lina","Pinedo","Avenida");
  
    Mockito.when(teachersServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(teacherMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/teachers/9").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{\"teacherId\":9,\"schoolId\":1,\"gender\":\"F\",\"firstName\":\"Peredo\",\"middleName\":\"Lina\",\"lastName\":\"Pinedo\",\"otherTeacherDetails\":\"Avenida\"}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }
  
  
  @Test
  public void testListTeachersByIDFalse() throws Exception {
    Teachers teacherMock = new Teachers(9, 1,"F","Peredo","Lina","Pinedo","Avenida");
  
    Mockito.when(teachersServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(teacherMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/teachers/9").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{\"teacherId\":10,\"schoolId\":1,\"gender\":\"F\",\"firstName\":\"Peredo\",\"middleName\":\"Lina\",\"lastName\":\"Pinedo\",\"otherTeacherDetails\":\"Avenida\"}";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }
  
  
  @Test
  public void testEliminar() throws Exception {
    Teachers teacherMock = new Teachers(9, 1,"F","Peredo","Lina","Pinedo","Avenida");
    
    Mockito.when(teachersServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(teacherMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/teachers/9")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }
  
  @Test
  public void testEliminarFalse() throws Exception {
    Teachers teacherMock = new Teachers(9, 1,"F","Peredo","Lina","Pinedo","Avenida");
    
    Mockito.when(teachersServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(teacherMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/teachers/1")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }
  
 

}
