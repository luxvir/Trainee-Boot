package com.ciber.dao;

import com.ciber.model.StudentClasses;


import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface IStudentClassesDao extends  CrudRepository<StudentClasses, Integer> {
  List<StudentClasses> findByClassesClassesId(int classId);
  /*
  @Override
	@Query("select e from StudentClasses e where e.deleteStatus=0")
	@Transactional
	public List<StudentClasses> findAll();

	@Query("select e from StudentClasses e where e.deleteStatus=1")
	@Transactional
	public List<StudentClasses> findDelete();

	@Query("update StudentClasses e set e.deleteStatus=1 where e.dateFrom=?1 and e.students.studentId=?2 and e.classes.classesId=?3")
	@Transactional
	@Modifying
	public void softDelete(Date dateFrom, int studentId, int classesId );
	
	*/
}
