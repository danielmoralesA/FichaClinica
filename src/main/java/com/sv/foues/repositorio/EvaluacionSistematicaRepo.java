package com.sv.foues.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sv.foues.entidades.EvaluacionSistematica;
import com.sv.foues.entidades.FichaAdmision;


@Repository
public interface EvaluacionSistematicaRepo extends CrudRepository<EvaluacionSistematica, Integer>{
	
	@Query("SELECT m from EvaluacionSistematica m WHERE m.fichaadmisionidFicha= :idpac")
	public List<EvaluacionSistematica> findEvaluacion(@Param("idpac") FichaAdmision idpac);
	
	
}
