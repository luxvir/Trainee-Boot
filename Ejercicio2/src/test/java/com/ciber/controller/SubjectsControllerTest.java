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
import com.ciber.service.SubjectsServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SubjectsController.class)
public class SubjectsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SubjectsServiceImpl subjectsServiceImpl;

  List<Subjects> listSubjectsMock = new ArrayList<Subjects>();

  @Test
  public void testListSubjects() throws Exception {
    listSubjectsMock.add(new Subjects(9, "Matematica"));
    listSubjectsMock.add(new Subjects(10, "Algebra"));

    Mockito.when(subjectsServiceImpl.findAll()).thenReturn(listSubjectsMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/subjects").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{subjectId:9,subjectName:Matematica},{subjectId:10,subjectName:Algebra}]";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListSubjectsFalse() throws Exception {
    listSubjectsMock.add(new Subjects(9, "Matematica"));
    listSubjectsMock.add(new Subjects(10, "Algebra"));

    Mockito.when(subjectsServiceImpl.findAll()).thenReturn(listSubjectsMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/subjects").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{subjectId:11,subjectName:Matematica},{subjectId:10,subjectName:Algebra}]";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListSubjectsByID() throws Exception {
    Subjects subjectMock = new Subjects(9, "Matematica");

    Mockito.when(subjectsServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(subjectMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/subjects/9").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{subjectId:9,subjectName:Matematica}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testListSubjectsByIDFalse() throws Exception {
    Subjects subjectMock = new Subjects(9, "Matematica");

    Mockito.when(subjectsServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(subjectMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/subjects/9").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{subjectId:11,subjectName:Matematica}";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testEliminar() throws Exception {
    Subjects subjectMock = new Subjects(9, "Matematica");
    Mockito.when(subjectsServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(subjectMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/subjects/9")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }

  @Test
  public void testEliminarFalse() throws Exception {
    Subjects subjectMock = new Subjects(9, "Matematica");
    Mockito.when(subjectsServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(subjectMock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/subjects/1")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }
  


}
