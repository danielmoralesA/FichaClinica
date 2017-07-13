package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.Departamento;

@Transactional
public interface DepartamentoRepo extends CrudRepository<Departamento, Integer>{
	
}
