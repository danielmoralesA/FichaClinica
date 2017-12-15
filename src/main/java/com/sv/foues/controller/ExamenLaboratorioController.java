package com.sv.foues.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamenLaboratorioController {
	
	@RequestMapping("/exameneslaboratorio/examenlaboadulto")
	public String examenAdulto(){
		return "exameneslaboratorio/examenlaboadulto";
	}
	
}
