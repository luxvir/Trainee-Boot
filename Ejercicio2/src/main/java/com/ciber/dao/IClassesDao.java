package com.ciber.dao;

import com.ciber.model.Classes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IClassesDao extends  CrudRepository<Classes, Integer> {
	
	@Override
	@Query("select e from Classes e where e.deleteStatus=0")
	@Transactional
	public List<Classes> findAll();

	@Query("select e from Classes e where e.deleteStatus=1")
	@Transactional
	public List<Classes> findDelete();

	@Query("update Classes e set e.deleteStatus=1 where e.classesId=?1")
	@Transactional
	@Modifying
	public void softDelete(int id);
}
