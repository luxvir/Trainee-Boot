package com.ciber.service;

import com.ciber.model.Students;
import java.util.List;
import java.util.Optional;

public interface IStudentsService {
  
  List<Students> findAll();

  Students create(Students stu);

  Students update(Students stu);

  int delete(Integer id);
  
  Optional<Students> findById(int id);
  
  List<Students> listAllStudentById(List<Integer> listStudnt);
}
