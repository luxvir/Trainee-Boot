package com.ciber.dao;

import com.ciber.model.Students;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentsDao extends JpaRepository<Students, Integer> {

	@Query("select s from Students s where s.studentId IN :listStudent")
	List<Students> listAllStudentById(List<Integer> listStudent);
}
