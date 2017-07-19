package com.sv.foues.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sv.foues.entidades.Departamento;
import com.sv.foues.entidades.Municipio;

@Repository
public interface MunicipioRepo  extends CrudRepository<Municipio, Integer>{

	@Query("SELECT  m.nomMunicipio from Municipio m   WHERE m.departamento= :idpac")
	public List<Municipio> datos(@Param("idpac") Departamento idpac); 
	
	@Query("SELECT m from Municipio m WHERE m.departamento= :idpac")
	public List<Municipio> findMunicipiobydepart(@Param("idpac") Departamento idpac);
	
}
