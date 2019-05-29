package com.ciber.server;

import com.ciber.model.Subjects;
import java.util.List;
import java.util.Optional;

public interface ISubjectsService {

  List<Subjects> findAll();

  Subjects create(Subjects subj);

  Subjects update(Subjects subj);

  int delete(Integer id);
  
  Optional<Subjects> findByID(int id);
  
  void softdelete(int id);
  
  Subjects patchUpd(Subjects subj);
}
