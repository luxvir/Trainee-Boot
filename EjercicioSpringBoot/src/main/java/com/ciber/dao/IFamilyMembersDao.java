package com.ciber.dao;

import com.ciber.model.FamilyMembers;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamilyMembersDao extends  JpaRepository<FamilyMembers, Integer> {
  List<FamilyMembers> findByFamiliesFamilyId(int familyId);
  
}
