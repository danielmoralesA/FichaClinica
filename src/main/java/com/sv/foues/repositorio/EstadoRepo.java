package com.sv.foues.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.foues.entidades.Estado;

import com.sv.foues.entidades.Superficie;

@Repository
public interface EstadoRepo extends CrudRepository<Estado, Integer>{

	@Query("SELECT m from Estado m WHERE m.superficieIdsession= :idpac")
	public List<Estado> findSuperByPieza(@Param("idpac") Superficie superficie);
	
}
