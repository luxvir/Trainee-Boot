package com.ciber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * La clase Families es un modelo que define un conjunto de variables el estado,
 * y métodos apropiados para operar con dichos datos.
 * 
 * @version 15/05/2019 V.1
 * @author vperezqu.
 *
 */
@Data
@Entity
public class Families {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_id")
  private int familyId;

  @NotNull
  @Column(name = "family_name", length = 50, nullable = false)
  private String familyName;

  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id", nullable = false)
  private Parents parents;

  @JsonIgnore
  @OneToMany(mappedBy = "families")
  private List<FamilyMembers> familyMembers;

}
