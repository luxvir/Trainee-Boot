package com.ciber.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

  Subjects subjectMock = new Subjects(9, "Ana", 0);
  List<Subjects> listSubjectsMock = new ArrayList<Subjects>();

  @Test
  public void testListSubjects() throws Exception {
    listSubjectsMock.add(new Subjects(9, "Ana", 0));
    listSubjectsMock.add(new Subjects(10, "Dan", 0));

    Mockito.when(subjectsServiceImpl.findAll()).thenReturn(listSubjectsMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/subjects/")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = (MvcResult) mockMvc.perform(requestBuilder);

    System.out.println(result.getResponse());
    String expected = "[{subjectId:9,subjectName:Ana,deleteStatus:0},"
                      + "{{subjectId:10,subjectName:Dan,deleteStatus:0}]";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testCreateSubjectss() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdateSubjects() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteSubjects() {
    fail("Not yet implemented");
  }

  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }

}
