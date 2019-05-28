package com.ciber.dao;

import com.ciber.model.Parents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParentsDao extends JpaRepository<Parents, Integer> {

}
