package com.sv.foues.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sv.foues.entidades.Profecion;

@Transactional
public interface ProfecionRepo extends CrudRepository<Profecion, Integer>{

}
