package com.sv.foues.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sv.foues.entidades.EnfermedadSistema;
import com.sv.foues.entidades.EvaluacionSistematica;
import com.sv.foues.entidades.FichaAdmision;
import com.sv.foues.entidades.FichaClinica;

import com.sv.foues.entidades.Referencias;
import com.sv.foues.entidades.Tiposenfermedades;
import com.sv.foues.repositorio.EnfermedadSistemaRepo;
import com.sv.foues.repositorio.EvaluacionSistematicaRepo;
import com.sv.foues.repositorio.FichaAdmisionRepo;
import com.sv.foues.repositorio.FichaClinicaRepo;
import com.sv.foues.repositorio.ReferenciasRepo;
import com.sv.foues.repositorio.TiposEnfermedadRepo;

@Controller
public class ReferenciasController {
	
	@Autowired
	ReferenciasRepo refrepo;
	
	@Autowired
	FichaAdmisionRepo ficharepo;
	
	@Autowired
	FichaClinicaRepo clinicarepo;
	
	
	@Autowired
	EnfermedadSistemaRepo enfrepo;
	
	@Autowired
	TiposEnfermedadRepo tiporepo;
	
	@Autowired
	EvaluacionSistematicaRepo evasistrepo;
	
	//llamada al controlador 
	@RequestMapping("/referencias/referenciasadulto")
	public String adultoref(){
		return "referencias/referenciasadulto";
	}
	
	//llamada para guardar
	@RequestMapping(value="/referencias/referenciasadulto",method=RequestMethod.POST)
	public String refadultoinsert(@ModelAttribute FichaAdmision fichaadmin, @ModelAttribute EvaluacionSistematica evasist){
		FichaClinica fclinica=new FichaClinica();
		int valor=clinicarepo.getid();
		fclinica=clinicarepo.findOne(valor);
		fichaadmin.setFichaidFicha(fclinica);
		ficharepo.save(fichaadmin);
		evasist.setFichaadmisionidFicha(fichaadmin);
		evasistrepo.save(evasist);
		return "redirect:/referencias/referenciasadultoshow/"+fichaadmin.getIdFicha();
	}
	
	//muestra el show
	@RequestMapping("/referencias/referenciasadultoshow/{idficha}")
	public String ShowAdulto(@PathVariable int idficha, Model model){
		//model.addAttribute("fichaadmision",ficharepo.findOne(idficha));
		int x;
		int y;
		model.addAttribute("fichaadmision",ficharepo.getFicha(idficha));
		FichaAdmision ficha=new FichaAdmision();
		ficha=ficharepo.getFicha(idficha);
		List<EvaluacionSistematica> eva=(List<EvaluacionSistematica>)evasistrepo.findEvaluacion(ficha);
		for(EvaluacionSistematica evas : eva){
			x=evas.getIdenfermedad();
			y=Integer.parseInt(evas.getIdtipo());
			model.addAttribute("enfermedadSistema",enfrepo.findOne(x));
			model.addAttribute("tiposenfermedades",tiporepo.findOne(y));
		}
		
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
		
		model.addAttribute("evaluacionsistematica",evasistrepo.findEvaluacion(ficharepo.getFicha(id)));
		return "referencias/editreferenciasadulto";
		
	}
	
	
	//carga lista de las enfermedades por sistema
	@ModelAttribute("enfermedades")
	public List<EnfermedadSistema> getenfermedad(){
		ArrayList<EnfermedadSistema> depa=new ArrayList<EnfermedadSistema>();
		depa=(ArrayList<EnfermedadSistema>)enfrepo.findAll();
		return depa;
	}
	
	//para cargar la lista de tipo de engfermedad
	
	
	@RequestMapping("/tipos")
	@ResponseBody
	public Map<String, String> gettipos(@RequestParam int idenfermedad){
		Map<String, String> Tipovalor=new HashMap<>();
		EnfermedadSistema enfermedad=new EnfermedadSistema();
		enfermedad=enfrepo.findOne(idenfermedad);
		List<Tiposenfermedades> tipo=tiporepo.datos(enfermedad);
		for(Tiposenfermedades tipos: tipo){
			Tipovalor.put(String.valueOf(tipos.getIdtipo()),tipos.getNombreenfermedad());
		}
		return Tipovalor;
		
	}
	
	
	
	//referencias para infantil
	@RequestMapping("/referencias/referenciasinfantil")
	public String formInfantil(Model model){
		FichaAdmision ficha=new FichaAdmision();
		model.addAttribute(ficha);
		return "referencias/referenciasinfantil";
			}
	
	@RequestMapping(value="/referencias/referenciasinfantil",params={"addenfermedad"},method=RequestMethod.POST)
	public String addRow(final FichaAdmision ficha, final BindingResult bindingResult){
		EvaluacionSistematica eva=new  EvaluacionSistematica(); 
		eva.setFichaadmisionidFicha(ficha);
		ficha.getEvaluacionSistematicaCollection().add(eva);
		return "referencias/referenciasinfantil";
	}
	
	@RequestMapping(value="/sistema", params={"removeEnfermedad"},method=RequestMethod.POST)
	public String removeRow(final FichaAdmision ficha, final HttpServletRequest  req)
	{
		final Integer evaid= Integer.valueOf(req.getParameter("removeEnfermedad"));
		
		for(EvaluacionSistematica eva: ficha.getEvaluacionSistematicaCollection()){
			if(eva.getIdEva().equals(evaid)){
				ficha.getEvaluacionSistematicaCollection().remove(eva);
				break;
			}
		}
			
		//if(evaid>0)
			//evasistrepo.
			
		return "/referencias/referenciasinfantil";
		
	
	
		}
	
}
