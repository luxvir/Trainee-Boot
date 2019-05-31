package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase Subjects es un modelo que define un conjunto de variables el estado,
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
@Entity
public class Subjects {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subject_id")
  private int subjectId;

  @Column(name = "subject_name", length = 20, nullable = false)
  private String subjectName;

  // de uno a muchos
  @JsonIgnore
  @OneToMany(mappedBy = "subjects")
  private List<Classes> classes;
  
  @JsonIgnore
  @Column(name = "delete_status")
  private int deleteStatus = 0;

  public Subjects(int subjectId, String subjectName, int deleteStatus) {
    super();
    this.subjectId = subjectId;
    this.subjectName = subjectName;
    this.deleteStatus = deleteStatus;
  }
  
  

}
