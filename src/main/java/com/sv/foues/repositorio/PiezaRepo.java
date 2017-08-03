package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.Pieza;

@Transactional
public interface PiezaRepo extends CrudRepository<Pieza, Integer> {

}
