package com.ciber.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase FamilyMembers es un modelo que define un conjunto de variables el estado, y métodos
 * apropiados para operar con dichos datos.
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FamilyMembers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_member_id")
  private int familyMemberId;

  @Column(name = "parent_or_student_member", length = 3, nullable = false)
  private String parentOrStudentMember;

  @ManyToOne
  @JoinColumn(name = "family_id", nullable = false)
  private Families families;

  @ManyToOne
  @JoinColumn(name = "parent_id", nullable = true)
  private Parents parents;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = true)
  private Students students;

}
