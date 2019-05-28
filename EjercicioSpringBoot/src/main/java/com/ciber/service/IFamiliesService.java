package com.ciber.service;

import com.ciber.model.Families;
import com.ciber.model.FamilyMembers;

import java.util.List;
import java.util.Optional;


public interface IFamiliesService {
  List<Families> findAll();

  Families create(Families fami);

  Families update(Families fami);

  int delete(Integer id);

  List<FamilyMembers> findByFamilies(int famiId);
  
  Optional<Families> findByID(int id);
}
