package com.ciber.dao;

import com.ciber.model.Families;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamiliesDao extends JpaRepository<Families, Integer> {

}
