package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase Parents es un modelo que define un conjunto de variables el estado, y métodos
 * apropiados para operar con dichos datos.
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Parents {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "parent_id")
  private int parentId;

  @Column(name = "gender", length = 1, nullable = false)
  private String gender;

  @Column(name = "fisrst_name", length = 20, nullable = false)
  private String fisrstName;

  @Column(name = "middle_name", length = 20, nullable = false)
  private String middleName;

  @Column(name = "last_name", length = 20, nullable = false)
  private String lastName;

  @Column(name = "other_parent_details", length = 100, nullable = false)
  private String otherParentDetails;

  @JsonIgnore
  @JoinTable(name = "studentParents", joinColumns = @JoinColumn(name = "parent_id",
          referencedColumnName = "parent_id"), inverseJoinColumns = @JoinColumn(
              name = "student_id", referencedColumnName = "student_id"))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Students> students;

  
}
