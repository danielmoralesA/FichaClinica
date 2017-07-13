package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.Referencias;

@Transactional
public interface ReferenciasRepo extends CrudRepository<Referencias, Integer>{

}
