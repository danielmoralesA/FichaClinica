package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.EnfermedadSistema;

@Transactional
public interface EnfermedadSistemaRepo extends CrudRepository<EnfermedadSistema , Integer>{

}