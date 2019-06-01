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

import com.ciber.model.Classes;
import com.ciber.model.Subjects;
import com.ciber.model.Teachers;
import com.ciber.service.ClassesServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ClassesController.class)
public class ClassesControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ClassesServiceImpl classesServiceImpl;

  List<Classes> listClassMock = new ArrayList<Classes>();

  @Test
  public void testListClasses() throws Exception {
    listClassMock.add(new Classes(9, "MAT", "Mateatica"));

    Mockito.when(classesServiceImpl.findAll()).thenReturn(listClassMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/classes").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{\"classesId\":9,\"subjects\":null,\"teachers\":null,\"classCode\":\"MAT\",\"className\":\"Mateatica\",\"dateFrom\":null,\"dateTo\":null}]";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListClassesFalse() throws Exception {
    listClassMock.add(new Classes(9, "MAT", "Mateatica"));

    Mockito.when(classesServiceImpl.findAll()).thenReturn(listClassMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/classes").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{\"classesId\":10,\"subjects\":null,\"teachers\":null,\"classCode\":\"MAT\",\"className\":\"Mateatica\",\"dateFrom\":null,\"dateTo\":null}]";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListClassesByID() throws Exception {
    Classes classMock = new Classes(9, "MAT", "Mateatica");

    Mockito.when(classesServiceImpl.getOne(Mockito.anyInt())).thenReturn((classMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/classes/9").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{\"classesId\":9,\"subjects\":null,\"teachers\":null,\"classCode\":\"MAT\",\"className\":\"Mateatica\",\"dateFrom\":null,\"dateTo\":null}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListClassesByIDFalse() throws Exception {
    Classes classMock = new Classes(9, "MAT", "Mateatica");

    Mockito.when(classesServiceImpl.getOne(Mockito.anyInt())).thenReturn((classMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/classes/9").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{\"classesId\":10,\"subjects\":null,\"teachers\":null,\"classCode\":\"MAT\",\"className\":\"Mateatica\",\"dateFrom\":null,\"dateTo\":null}";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testEliminar() throws Exception {
    Classes classMock = new Classes(9, "MAT", "Mateatica");

    Mockito.when(classesServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(classMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/teachers/9")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }

  @Test
  public void testEliminarFalse() throws Exception {
    Classes classMock = new Classes(9, "MAT", "Mateatica");
    Mockito.when(classesServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(classMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/teachers/1")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }

}
