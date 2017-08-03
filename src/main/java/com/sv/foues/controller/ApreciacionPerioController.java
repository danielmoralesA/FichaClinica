package com.sv.foues.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sv.foues.entidades.ApreciacioPerio;
import com.sv.foues.entidades.FichaAdmision;
import com.sv.foues.repositorio.ApreciacionPerioRepo;
import com.sv.foues.repositorio.FichaAdmisionRepo;



@Controller
public class ApreciacionPerioController {

	
	@Autowired
	private ApreciacionPerioRepo aperepo;
	
	@Autowired
	FichaAdmisionRepo ficharepo;
	
	@RequestMapping("/apreciacionperio/apreciacionperionew")
	public String aprecionperio(){
		return "apreciacionperio/apreciacionperionew";
	}
	
	@RequestMapping(value="/apreciacionperio/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute ApreciacioPerio apre){
		FichaAdmision fichaadmin=new FichaAdmision();
		int valor=ficharepo.getid();
		fichaadmin=ficharepo.findOne(valor);
		apre.setFichaadmisionidFicha(fichaadmin);
		aperepo.save(apre);
		return "apreciacionperio/apreciacionperioshow/"+apre.getIdperio();
	}
	
	
	@RequestMapping("/apreciacionperio/apreciacionperioshow/{idperio}")
	public String ShowAdulto(@PathVariable int idperio, Model model){
		//model.addAttribute("fichaadmision",ficharepo.findOne(idficha));
		model.addAttribute("apreciacioPerio",aperepo.findOne(idperio));
		return "apreciacionperio/apreciacionperioshow";
	}
	
	
	
	//actualizar
	@RequestMapping(value="/apreciacionperio/update", method=RequestMethod.POST)
	public String actualizar(ApreciacioPerio apre){
				
		aperepo.save(apre);
		return "redirect:/apreciacionperio/apreciacionperioshow/"+apre.getIdperio();
		
	}
	
	@RequestMapping("/apreciacionperio/apreciacionperioedit/{idperio}")
	public String apreciacionedit(@PathVariable Integer idperio, Model model){
		model.addAttribute("apreciacioPerio",aperepo.findOne(idperio));
		return "apreciacionperio/apreciacionperioedit";
		
	}
	
}
