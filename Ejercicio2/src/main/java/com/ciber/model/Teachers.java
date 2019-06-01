package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase Teachers es un modelo que define un conjunto de variables el estado,
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
public class Teachers {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacher_id")
  private int teacherId;

  @Column(name = "school_id")
  private int schoolId;

  @Column(name = "gender", length = 1, nullable = false)
  private String gender;

  @Column(name = "firstName", length = 20, nullable = false)
  private String firstName;

  @Column(name = "middle_name", length = 20, nullable = false)
  private String middleName;

  @Column(name = "last_name", length = 20, nullable = false)
  private String lastName;

  @Column(name = "other_teacher_details", length = 100, nullable = false)
  private String otherTeacherDetails;

  // de uno muchos clases
  @JsonIgnore
  @OneToMany(mappedBy = "teachers")
  private List<Classes> classes;
  
  @JsonIgnore
  @Column(name = "delete_status")
  private int deleteStatus = 0;

  public Teachers(int teacherId, int schoolId, String gender, String firstName, String middleName, String lastName,
      String otherTeacherDetails) {
    super();
    this.teacherId = teacherId;
    this.schoolId = schoolId;
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.otherTeacherDetails = otherTeacherDetails;
  }
  
  
  
}
