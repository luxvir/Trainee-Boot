package com.ciber.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;



/**
 * La clase Classes es un modelo que define un conjunto de variables el estado,
 * y métodos apropiados para operar con dichos datos.
 * 
 * @version 27/05/2019 V.1
 * @author vperezqu.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DtoClasses {

  private int classesId;
  private Subjects subjects;
  private Teachers teachers;
  private String classCode;
  private String className;
  private Date dateFrom;
  private Date dateTo;
  private int deleteStatus = 0;
  private List<Students> listStudents;
}
