package com.ciber.server;

import com.ciber.dao.ITeachersDao;
import com.ciber.model.Teachers;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class TeachersServiceImpl implements ITeachersService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  private ITeachersDao dao;
  
  @Override
  public List<Teachers> findAll() {
    
    return (List<Teachers>) dao.findAll();
  }

  @Override
  public Teachers create(Teachers tea) {
    
    return dao.save(tea);
  }

  @Override
  public Teachers update(Teachers tea) {
   
    return dao.save(tea);
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
  public Optional<Teachers> findByID(int id) {
    
    return dao.findById(id);
  }

	@Override
	public void softdelete(int id) {
		dao.softDelete(id);
		
	}

}
