package com.sv.foues.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OdontogramaController {

	
	@RequestMapping("/odontograma/odontogramanew")
	public String odontograma()
	{
		return "odontograma/odontogramanew";
	}
	
	//odontograma para 
	@RequestMapping("/odontograma/odontogramamenor")
	public String odontogramamenor()
	{
		return "odontograma/odontogramamenor";
	}
}

