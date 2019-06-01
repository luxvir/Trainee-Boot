package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Entity
public class Classes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classes_id")
  private int classesId;

  // de muchos a uno
  @ManyToOne
  @JoinColumn(name = "subject_id", nullable = true)
  private Subjects subjects;

  // de muchos a uno
  @ManyToOne
  @JoinColumn(name = "teacher_id", nullable = true)
  private Teachers teachers;

  // de uno a muchos
  @JsonIgnore
  @OneToMany(mappedBy = "classes")
  private List<StudentClasses> studentClasses;

  @Column(name = "class_code", length = 3, nullable = false)
  private String classCode;

  @Column(name = "class_name", length = 20, nullable = false)
  private String className;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_from")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateFrom;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_to")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateTo;

  public Classes(int classesId, String classCode, String className) {
    super();
    this.classesId = classesId;
    this.classCode = classCode;
    this.className = className;
 
  }

  @JsonIgnore
  @Column(name = "delete_status")
  private int deleteStatus = 0;
}
