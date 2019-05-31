package com.ciber.dao;

import com.ciber.model.Subjects;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ISubjectsDao extends CrudRepository<Subjects, Integer> {

  @Override
  @Query("select e from Subjects e where e.deleteStatus=0")
  @Transactional
  public List<Subjects> findAll();

  @Query("select e from Subjects e where e.deleteStatus=1")
  @Transactional
  public List<Subjects> findDelete();

  @Query("update Subjects e set e.deleteStatus=1 where e.subjectId=?1")
  @Transactional
  @Modifying
  public void softDelete(int id);
}
