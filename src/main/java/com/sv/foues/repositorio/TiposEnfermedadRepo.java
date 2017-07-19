package com.sv.foues.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.foues.entidades.EnfermedadSistema;
import com.sv.foues.entidades.Tiposenfermedades;

@Repository
public interface TiposEnfermedadRepo extends CrudRepository<Tiposenfermedades, Integer> {

	@Query("SELECT t from Tiposenfermedades t   WHERE t.enfermedadSistemaIdsistema= :idpac")
	public List<Tiposenfermedades> datos(@Param("idpac") EnfermedadSistema idpac); 
}
