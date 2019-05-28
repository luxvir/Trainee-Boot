package com.ciber.dao;

import com.ciber.model.Subjects;
import org.springframework.data.repository.CrudRepository;



public interface ISubjectsDao  extends  CrudRepository<Subjects, Integer> {

}
