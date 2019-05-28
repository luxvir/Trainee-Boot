package com.ciber.service;

import com.ciber.model.Parents;

import java.util.List;
import java.util.Optional;

public interface IParentsService {
  List<Parents> findAll();

  Parents create(Parents paren);

  Parents update(Parents paren);

  int delete(Integer id);
  
  Optional<Parents> findId(int id);
}
