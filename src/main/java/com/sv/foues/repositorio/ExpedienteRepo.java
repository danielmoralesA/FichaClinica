package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.Expediente;

@Transactional
public interface ExpedienteRepo extends CrudRepository<Expediente, String> {
	
	public Expediente findFirstByNumExpediente(String exp);
}
