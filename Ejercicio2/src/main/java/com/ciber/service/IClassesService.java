package com.ciber.service;

import com.ciber.model.Classes;
import com.ciber.model.StudentClasses;

import java.util.List;
import java.util.Optional;

public interface IClassesService {
  /**
   * Funcion que lista todas las clases.
   * @return liosta de Clases
   */
  List<Classes> findAll();

  /**
   * Funcion que se encargara de registar un Clase.
   * 
   * @param cla Clase Objeto.
   * @return una nueva Clase.
   */
  Classes create(Classes cla);

  /**
   * Funcion que se encarga de actualizar una Clase.
   * 
   * @param cla Clase objeto.
   * @return una Clase objeto.
   */
  Classes update(Classes cla);

  /**
   * Funcion que se encargara de eleminar una CLase.
   * 
   * @param id es el ID de la clase.
   * @return un objeto eliminado.
   */
  int delete(Integer id);

  /**
   * Funcion que buscar por ID de la clase.
   * @param id es el ID de la clase.
   * @return id.
   */
  Optional<Classes> findByID(int id);

  /**
   * Metodo que actualiza el estado de Clase.
   * @param id es el ID de la Clase.
   */
  void softdelete(int id);
  
  /***********************************************************/
  /**
   * 
   * @param clasId
   * @return
   */
  Classes getOne(int clasId);
}
