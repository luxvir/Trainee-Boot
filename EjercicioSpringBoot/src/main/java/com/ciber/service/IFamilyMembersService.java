package com.ciber.service;

import com.ciber.model.FamilyMembers;
import java.util.List;

public interface IFamilyMembersService {

  List<FamilyMembers> findAll();

  FamilyMembers create(FamilyMembers famiMem);

  FamilyMembers update(FamilyMembers famiMem);

  int delete(Integer id);

}
