package com.sv.foues.servicio;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sv.foues.repositorio.RolesRepo;
import com.sv.foues.repositorio.UsuarioRepo;
import com.sv.foues.entidades.Roles;
import com.sv.foues.entidades.Usuarios;

@Service("usuarioService")
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepo userRepository;
	@Autowired
	private RolesRepo roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private Roles rol;
	@Override
	public Usuarios findUsuarioByNombre(String nombre) {
		Usuarios user=userRepository.findFirstByNomUsuario(nombre);
		if(user==null){
			return null;
		}
		return user;
	}

	@Override
	public void save(Usuarios usuario, Roles roles) {
		//usuario.setIdUsuario(1);
				usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
				usuario.setActivo(1);
				//rol=roleRepository.findFirstByNomRol("ADMIN");
				usuario.setRoles(new HashSet<Roles>(Arrays.asList(roles)));
			
				userRepository.save(usuario);

	}

}
