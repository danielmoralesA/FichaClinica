package com.sv.foues.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sv.foues.entidades.Usuarios;

@Transactional
public interface UsuarioRepo extends CrudRepository<Usuarios, Integer> {
	Usuarios findByNomUsuario(String nombre);
	Usuarios findFirstByNomUsuario(String nombre);
}
