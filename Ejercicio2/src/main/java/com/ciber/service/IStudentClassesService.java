package com.ciber.service;

import com.ciber.model.StudentClasses;
import java.util.List;
import java.util.Optional;

public interface IStudentClassesService {
  /**
   * Funcion que lista todos los estudiantes de un Clase.
   * 
   * @return lista de estudiantes de una clase.
   */
  List<StudentClasses> findAll();

  /**
   * Funcion que se encargara de registar un estudiante de clase.
   * 
   * @param stu Clase objeto.
   * @return una nueva Clase.
   */
  StudentClasses create(StudentClasses stu);

  /**
   * Funcion que se encarga de actualizar una Clase.
   * 
   * @param stu clase objeto.
   * @return una Clase objeto.
   */
  StudentClasses update(StudentClasses stu);

  /**
   * Funcion que elemina a un estudiante de clase.
   * @param stuClass parametros de estudiante de clase.
   * @return stuClass.
   */
  int delete(StudentClasses stuClass);

  /**
   * Funcion que busca por sus PKs.
   * @param id parametros que representan las PKs.
   * @return lista de estudiantes de Clase.
   */
  Optional<StudentClasses> findByID(int id);
  /**
   * oooooooooooooooo
   * 
   * @param classId
   * @return
   */
   List<Integer> getAllIdsByClassId(int classId);

}
