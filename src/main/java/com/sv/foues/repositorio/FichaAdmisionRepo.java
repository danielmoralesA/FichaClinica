package com.sv.foues.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.FichaAdmision;


@Repository
public interface FichaAdmisionRepo extends CrudRepository<FichaAdmision, Integer> {
	@Query("SELECT f FROM FichaAdmision f WHERE f.idFicha= :idpac") 
    public FichaAdmision getFicha(@Param("idpac") int idpac);
	
	@Query("SELECT MAX(idFicha) FROM FichaAdmision")
	public Integer getid();
}
