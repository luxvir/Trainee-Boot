package com.ciber.dao;

import com.ciber.model.Teachers;
import org.springframework.data.repository.CrudRepository;



public interface ITeachersDao extends CrudRepository<Teachers,Integer> {

}
