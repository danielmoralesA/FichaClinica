package com.sv.foues.repositorio;



import org.springframework.data.repository.CrudRepository;

import com.sv.foues.entidades.ApreciacioPerio;

@org.springframework.transaction.annotation.Transactional
public interface ApreciacionPerioRepo extends CrudRepository<ApreciacioPerio, Integer>{

}
