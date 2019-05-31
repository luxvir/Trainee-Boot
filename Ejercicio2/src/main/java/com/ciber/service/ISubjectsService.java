package com.ciber.service;

import com.ciber.model.Subjects;
import java.util.List;
import java.util.Optional;

public interface ISubjectsService {
  /**
   * Funcion que lista a todos los Subjects.
   * 
   * @return
   */
  List<Subjects> findAll();

  /**
   * Funcion que se encarga de registar a un Subjects.
   * 
   * @param subj Objeto de Subjects.
   * @return a un objeto Subjects creado.
   */
  Subjects create(Subjects subj);

  /**
   * Funcion que se encarga de actualizar a un objeto Subjects.
   * 
   * @param subj parametro de actualizacion.
   * @return a un objeto actualizado.
   */
  Subjects update(Subjects subj);

  /**
   * Funcion que se encarga de eliminar a un objeto Subjects.
   * 
   * @param id es el ID de Subjects.
   * @return un objeto Subjects eleminado.
   */
  int delete(Integer id);

  /**
   * Funcion que busca por ID.
   * 
   * @param id parametro de filtro.
   * @return a un objeto Subjects.
   */
  Optional<Subjects> findByID(int id);

  /**
   * Funcion que se encarga de eliminar a un objeto Subjects.
   * @param id parametro de Subjects.
   */
  void softdelete(int id);

  /**
   * Funcion que actualiza a un objeto Subjects.
   * @param subj parametro de Subjects.
   * @return a un objeto Subjects actualizado.
   */
  Subjects patchUpd(Subjects subj);
  
  Optional<Subjects> patchFindById(int  id);
}
