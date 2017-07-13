package com.sv.foues.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sv.foues.entidades.Roles;

@Transactional
public interface RolesRepo  extends CrudRepository<Roles, Integer>{
	public Roles findFirstByNomRol(String nombre);
	public Roles findByNomRol(String nombre);
}
