package com.ciber.server;

import com.ciber.model.StudentClasses;
import java.util.List;
import java.util.Optional;



public interface IStudentClassesService {
 
  List<StudentClasses> findAll();

  StudentClasses create(StudentClasses stu);

  StudentClasses update(StudentClasses stu);

  int delete(StudentClasses stuClass);
 

  Optional<StudentClasses> findByID(int id);

}
