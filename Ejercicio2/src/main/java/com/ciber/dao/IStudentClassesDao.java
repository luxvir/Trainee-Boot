package com.ciber.dao;

import com.ciber.model.StudentClasses;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IStudentClassesDao extends CrudRepository<StudentClasses, Integer> {
  @Query(value = "select sc.students.studentId from StudentClasses sc where sc.classes.classesId=?1")
  List<Integer> findByClassesClassesId(Integer classId);
 
}
