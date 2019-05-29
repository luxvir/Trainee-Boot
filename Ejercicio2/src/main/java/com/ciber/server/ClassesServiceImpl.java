package com.ciber.server;

import com.ciber.dao.IClassesDao;
import com.ciber.dao.IStudentClassesDao;
import com.ciber.dao.ISubjectsDao;
import com.ciber.dao.ITeachersDao;
import com.ciber.model.Classes;
import com.ciber.model.StudentClasses;
import com.ciber.model.Subjects;
import com.ciber.model.Teachers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements IClassesService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IClassesDao dao;
  private IStudentClassesDao daoStuCLass;
  private ISubjectsDao daoSubj;
  private ITeachersDao daoTeach;

  @Override
  public List<Classes> findAll() {

    return (List<Classes>) dao.findAll();
  }

  @Override
  public Classes create(Classes cla) {
    Classes clas = new Classes();

    String msg = "";
    Optional<Subjects> s = daoSubj.findById(cla.getSubjects().getSubjectId());
    Optional<Teachers> t = daoTeach.findById(cla.getTeachers().getTeacherId());
    if (s.isPresent() && t.isPresent()) {
      clas = dao.save(cla);
    } else {
      msg = "error en el registro";
      log.info(msg);
    }
    return clas;
  }

  @Override
  public Classes update(Classes cla) {

    return dao.save(cla);
  }

  @Override
  public int delete(Integer id) {
    int rpta = 0;
    try {
      dao.deleteById(id);
      rpta = 1;
      log.info("Eleminado familia");
    } catch (Exception e) {
      rpta = 0;
      log.info("error" + e);
      log.info("no Eleminado familia");
    }
    return rpta;
  }

  @Override
  public Optional<Classes> findByID(int id) {

    return dao.findById(id);
  }

  @Override
  public List<StudentClasses> findByClass(int classId) {
    
    return daoStuCLass.findByClassesClassesId(classId);
  }

	@Override
	public void softdelete(int id) {
		dao.softDelete(id);
		
	}

}
