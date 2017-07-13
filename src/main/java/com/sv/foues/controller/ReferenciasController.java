package com.sv.foues.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sv.foues.entidades.FichaAdmision;
import com.sv.foues.entidades.FichaClinica;
import com.sv.foues.entidades.Paciente;
import com.sv.foues.entidades.Referencias;
import com.sv.foues.repositorio.FichaAdmisionRepo;
import com.sv.foues.repositorio.FichaClinicaRepo;
import com.sv.foues.repositorio.ReferenciasRepo;

@Controller
public class ReferenciasController {
	
	@Autowired
	ReferenciasRepo refrepo;
	
	@Autowired
	FichaAdmisionRepo ficharepo;
	
	@Autowired
	FichaClinicaRepo clinicarepo;
	
	//llamada al controlador 
	@RequestMapping("/referencias/referenciasadulto")
	public String adultoref(){
		return "referencias/referenciasadulto";
	}
	
	//llamada para guardar
	@RequestMapping(value="/referencias/referenciasadulto",method=RequestMethod.POST)
	public String refadultoinsert(@ModelAttribute FichaAdmision fichaadmin){
		FichaClinica fclinica=new FichaClinica();
		int valor=clinicarepo.getid();
		fclinica=clinicarepo.findOne(valor);
		fichaadmin.setFichaidFicha(fclinica);
		ficharepo.save(fichaadmin);
		return "redirect:/referencias/referenciasadultoshow/"+fichaadmin.getIdFicha();
	}
	
	//muestra el show
	@RequestMapping("/referencias/referenciasadultoshow/{idficha}")
	public String ShowAdulto(@PathVariable int idficha, Model model){
		//model.addAttribute("fichaadmision",ficharepo.findOne(idficha));
		model.addAttribute("fichaadmision",ficharepo.getFicha(idficha));
		return "referencias/referenciasadultoshow";
	}
	
	
	//controlador a referencias
	@ModelAttribute("referencia")
	public List<Referencias> getreferencia(){
		ArrayList<Referencias> ref=new ArrayList<Referencias>();
		ref=(ArrayList<Referencias>)refrepo.findAll();
		return ref;
	}
	
	@RequestMapping(value="/referencias/editreferenciasadulto/update", method=RequestMethod.POST)
	public String actualizar(FichaAdmision fichaadmin){
				
		ficharepo.save(fichaadmin);
		return "redirect:/referencias/referenciasadultoshow/"+fichaadmin.getIdFicha();
		
	}
	
	@RequestMapping("/referencias/editreferenciasadulto/{id}")
	public String pacienteadultoedit(@PathVariable Integer id, Model model){
		model.addAttribute("fichaadmision",ficharepo.getFicha(id));
		return "referencias/editreferenciasadulto";
		
	}
	
}
