package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase StudentClasses es un modelo que define un conjunto de variables el
 * estado, y métodos apropiados para operar con dichos datos.
 * 
 * @version 27/05/2019 V.1
 * @author vperezqu.
 **/
@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass (PkStudentsClasses.class)
public class StudentClasses {
  @Id
  private Date dateFrom;
  
  @Id
  private Students students;

  @Id
  private Classes classes;
  
  

  @Temporal(TemporalType.DATE)
  @Column(name = "date_to")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateTo;
}
