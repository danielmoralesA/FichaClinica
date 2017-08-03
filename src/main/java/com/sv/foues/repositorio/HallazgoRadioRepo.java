package com.sv.foues.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sv.foues.entidades.HallazgosRadio;

@Transactional
public interface HallazgoRadioRepo extends CrudRepository<HallazgosRadio, Integer>{

}
