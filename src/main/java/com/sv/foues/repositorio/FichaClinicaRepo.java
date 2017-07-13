package com.sv.foues.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sv.foues.entidades.FichaClinica;
@Repository
public interface FichaClinicaRepo extends CrudRepository<FichaClinica, Integer>{

	@Query("SELECT MAX(idFicha) FROM FichaClinica")
	public Integer getid();
}
