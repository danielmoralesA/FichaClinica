package com.sv.foues.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sv.foues.entidades.Roles;
import com.sv.foues.entidades.Usuarios;
import com.sv.foues.repositorio.RolesRepo;
import com.sv.foues.repositorio.UsuarioRepo;
import com.sv.foues.servicio.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private RolesRepo rolesrepo;
	
	@Autowired
	private UsuarioRepo userrepo;
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	
	/* cargar vista para el usuario q tiene vista de administrador*/
	/*@RequestMapping(value="/principal", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuarios user = userService.findUsuarioByNombre(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getNomUsuario() );
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("/principal");
		return modelAndView;
	}*/
	
	@RequestMapping(value="/principal",method=RequestMethod.GET)
	public String principal(){
		return "principal";
	}
	
	
	

	//carga vista para insertar un nuevo usuario
	@RequestMapping(value="/admin/usuario/user",method=RequestMethod.GET)
	public String registration(Model model){
		//ModelAndView modelAndView = new ModelAndView();
		//Usuarios user = new Usuarios();
		model.addAttribute("usuarios", new Usuarios());
		//modelAndView.setViewName("admin/usuario");
		return "admin/usuario/user";
}
	
	/*@RequestMapping(value="/admin/usuario")
	public String cargar(){
		return "admin/usuario";
	}*/
	
	
	
	@RequestMapping(value = "/admin/usuario/add", method = RequestMethod.POST)
		public ModelAndView createNewUser(@Valid Usuarios user, BindingResult bindingResult, @ModelAttribute Roles rol) {
		ModelAndView modelAndView = new ModelAndView();
		Usuarios userExists = userService.findUsuarioByNombre(user.getNomUsuario());
		if (userExists != null) {
			bindingResult
					.rejectValue("nomUsuario", "error.usuarios",
							"Error hay un usario registrado con ese nombre");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("admin/usuario/user");
		} else {
			userService.save(user,rol);
			modelAndView.addObject("successMessage", "Usuario registrado exitosamente");
			modelAndView.addObject("usuarios", new Usuarios());
			modelAndView.setViewName("/admin/usuario/user");
					
		}
		return modelAndView;
	} 
	
	
	//vista para cargar los roles del sistema
	@ModelAttribute("rol")
	public List<Roles> getRoles(){
		ArrayList<Roles> roles=new ArrayList<Roles>();
		roles=(ArrayList<Roles>)rolesrepo.findAll();
		return roles;
		
	}
	
	//vista de usuarios registrados

	
	
	//lista de usuarios con su respectivo rol
	@RequestMapping("/admin/usuario/userlist")
	public String list(Model model){
		List<Usuarios> user=(List<Usuarios>)userrepo.findAll();
		model.addAttribute("usuarios",user);
		return "admin/usuario/userlist";
		
	}
	
	/*@RequestMapping(value="/admin/usuariolist", method=RequestMethod.GET)
	public @ResponseBody List<Usuarios> getUser(){
		return (List<Usuarios>)userdao.findAll();
		
	} */
	
	//eliminar usuario (desactivar)
	 @RequestMapping(value = "/admin/usuario/delete/{id}", method = RequestMethod.GET)
	    public String editRemoveEmployee(@PathVariable("id") int id, Model model) {
	    	//repository.delete(studentId);
		 	Usuarios user=new Usuarios();
		 	user=userrepo.findOne(id);
		 	user.setActivo(0);
		 	userrepo.save(user);
	        return "redirect:/admin/usuario/userlist";
	    }  
	
	
}
