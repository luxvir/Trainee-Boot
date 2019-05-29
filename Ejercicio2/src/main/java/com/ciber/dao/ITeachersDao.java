package com.ciber.dao;

import com.ciber.model.Teachers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ITeachersDao extends CrudRepository<Teachers,Integer> {

	@Override
	@Query("select e from Teachers e where e.deleteStatus=0")
	@Transactional
	public List<Teachers> findAll();

	@Query("select e from Teachers e where e.deleteStatus=1")
	@Transactional
	public List<Teachers> findDelete();

	@Query("update Teachers e set e.deleteStatus=1 where e.teacherId=?1")
	@Transactional
	@Modifying
	public void softDelete(int id);
}
