package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sv.foues.entidades.Radio;

@Repository
public interface RadioRepo  extends CrudRepository<Radio, Integer>{

}
