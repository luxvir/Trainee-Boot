package com.ciber.dao;

import com.ciber.model.Classes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IClassesDao extends  CrudRepository<Classes, Integer> {

}
