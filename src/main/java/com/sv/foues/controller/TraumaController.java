package com.sv.foues.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sv.foues.entidades.Pieza;
import com.sv.foues.repositorio.PiezaRepo;

@Controller
public class TraumaController {

	@Autowired
	PiezaRepo piezarepo;
	
	
	@RequestMapping("/traumadentro/traumanew")
	public String registrartrauma(){
		return "traumadentro/traumanew";
	}
	
	
	//lista de departamentos
	@ModelAttribute("piezas")
	public List<Pieza> getPiezas(){
		ArrayList<Pieza> pieza=new ArrayList<Pieza>();
		pieza=(ArrayList<Pieza>)piezarepo.findAll();
		return pieza;
	}
	
}
