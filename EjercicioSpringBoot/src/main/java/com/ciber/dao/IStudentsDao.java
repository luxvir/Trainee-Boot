package com.ciber.dao;

import com.ciber.model.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentsDao extends JpaRepository<Students, Integer> {

}
