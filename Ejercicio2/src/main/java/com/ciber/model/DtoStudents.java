package com.ciber.model;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase Students es un modelo que define un conjunto de variables el estado,
 * y métodos apropiados para operar con dichos datos.
 * 
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudents {
  
  private int studentId;
  private String gender;
  private String firstName;
  private String middleName;
  private String lastName;
  private Date dateOfBirth;
  private String otherStudentsDetails;
  //private int deleteStatus;

}
