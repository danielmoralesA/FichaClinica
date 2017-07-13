package com.sv.foues.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.sv.foues.entidades.Paciente;


@Repository
public interface PacienteRepo extends CrudRepository<Paciente, Integer>{
	
	@Query("SELECT p FROM Paciente p WHERE p.idpac= :idpac") 
    public Paciente getPaciente(@Param("idpac") int idpac);
	
	@Query("SELECT MAX(idpac) FROM Paciente")
	public String getid();
	
}
