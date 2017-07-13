package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.EstadoCivil;

@Transactional
public interface EstadoCivilRepo extends CrudRepository<EstadoCivil, Integer> {

}
