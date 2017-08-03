package com.sv.foues.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sv.foues.entidades.Pieza;
import com.sv.foues.entidades.Superficie;

@Repository
public interface SuperficieRepo extends CrudRepository<Superficie, Integer> {
	
	@Query("SELECT m from Superficie m WHERE m.piezaIdpieza= :idpac")
	public List<Superficie> findSuperByPieza(@Param("idpac") Pieza pieza);

}
