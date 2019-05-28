package com.ciber.dao;

import com.ciber.model.StudentClasses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface IStudentClassesDao extends  CrudRepository<StudentClasses, Integer> {
  List<StudentClasses> findByClassesClassesId(int classId);
}
