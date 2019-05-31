package com.ciber.service;

import com.ciber.model.Teachers;
import java.util.List;
import java.util.Optional;

public interface ITeachersService {
  /**
   * FUncion que lista a los profesores.
   * @return lista de profesores.
   */
  List<Teachers> findAll();

  /**
   * Fucnion que se encarga de crear a un profesor.
   * @param tea paramatro de Subjects.
   * @return a un Subjects creado.
   */
  Teachers create(Teachers tea);

  /**
   * Funcion que se encarga de actualizar  a un profesor.
   * @param tea objeto de Subjects.
   * @return a un objeto Subjects actualizado.
   */
  Teachers update(Teachers tea);

  /**
   * Funcion que se encarga de elimianar a un Subjects.
   * @param id es el ID de Subjects.
   * @return a un objeto Subjects eleminado.
   */
  int delete(Integer id);

  /**
   * Fucnion que busca por ID a Subjects.
   * @param id es el ID de Subjects.
   * @return a un/unos objeto/s buscado.
   */
  Optional<Teachers> findByID(int id);

  /**
   * Metodo que actualiza a un objeto Subjects.
   * @param id es el  de ID de Subjects.
   */
  void softdelete(int id);
}
