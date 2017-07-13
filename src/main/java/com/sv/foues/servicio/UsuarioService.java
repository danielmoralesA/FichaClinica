package com.sv.foues.servicio;

import com.sv.foues.entidades.Roles;
import com.sv.foues.entidades.Usuarios;

public interface UsuarioService {
	public Usuarios findUsuarioByNombre(String nombre);
	public void save(Usuarios usuario,Roles roles);
}
