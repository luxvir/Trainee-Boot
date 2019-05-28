package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Embeddable
public class PkStudentsClasses implements Serializable {

  /**
   * serializable.
   */
  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = true)
  private Students students;

  @ManyToOne
  @JoinColumn(name = "classes_id", nullable = true)
  private Classes classes;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_from")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateFrom;
 
}
