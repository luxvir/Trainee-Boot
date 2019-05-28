package com.ciber.server;

import com.ciber.model.Teachers;
import java.util.List;
import java.util.Optional;


public interface ITeachersService {
  List<Teachers> findAll();

  Teachers create(Teachers tea);

  Teachers update(Teachers tea);

  int delete(Integer id);
  
  Optional<Teachers> findByID(int id);
}
