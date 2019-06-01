package com.ciber.controller;


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

import com.ciber.model.Families;
import com.ciber.service.FamiliesServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = FamiliesController.class)
public class FamiliesControllerTest {

  
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FamiliesServiceImpl familiesServiceImpl;

  List<Families> listFamilisMock = new ArrayList<Families>();

  
  @Test
  public void testListfamili() throws Exception {
    listFamilisMock.add(new Families(9, "Paredes"));
    

    Mockito.when(familiesServiceImpl.findAll()).thenReturn(listFamilisMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/families").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{\"familyId\":9,\"familyName\":\"Paredes\",\"parents\":null}]";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }
  
  @Test
  public void testListfamilifalse() throws Exception {
    listFamilisMock.add(new Families(9, "Paredes"));
    

    Mockito.when(familiesServiceImpl.findAll()).thenReturn(listFamilisMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/families").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{\"familyId\":10,\"familyName\":\"Paredes\",\"parents\":null}]";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }
  
  @Test
  public void testEliminar() throws Exception {
    Families famiMiock = new Families(9, "Pinedo");
    Mockito.when(familiesServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(famiMiock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/families/9")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }
  
  @Test
  public void testEliminarfalse() throws Exception {
    Families famiMiock = new Families(9, "Pinedo");
    Mockito.when(familiesServiceImpl.findByID(Mockito.anyInt())).thenReturn(Optional.of(famiMiock));

    RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/families/1")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());

  }
  
  

}
