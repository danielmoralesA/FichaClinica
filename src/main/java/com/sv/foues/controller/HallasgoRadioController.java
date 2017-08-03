package com.sv.foues.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sv.foues.entidades.Departamento;
import com.sv.foues.entidades.EnfermedadSistema;
import com.sv.foues.entidades.Estado;
import com.sv.foues.entidades.Pieza;
import com.sv.foues.entidades.Superficie;
import com.sv.foues.entidades.Tiposenfermedades;
import com.sv.foues.repositorio.EstadoRepo;
import com.sv.foues.repositorio.PiezaRepo;
import com.sv.foues.repositorio.SuperficieRepo;

@Controller
public class HallasgoRadioController {

	
	@Autowired
	private EstadoRepo estadorepo;
	
	@Autowired
	private SuperficieRepo superrepo;
	
	@Autowired
	private PiezaRepo piezarepo;
	
	
	@RequestMapping("/hallazgoradio/radionew")
	public String radioinsert(){
		return "hallazgoradio/radionew";
	}
	
	
	//para llenar los respectivos select
	@RequestMapping("/parte")
	@ResponseBody
	public Map<String, String> getParteSuper(@RequestParam int pieza){
		Map<String, String> Tipovalor=new HashMap<>();
		Pieza pz=new Pieza();
		pz=piezarepo.findOne(pieza);
		List<Superficie> tipo=superrepo.findSuperByPieza(pz);
		for(Superficie tipos: tipo){
			Tipovalor.put(String.valueOf(tipos.getIdsession()),tipos.getNombre());
		}
		return Tipovalor;
		
	}
	
	
	//para llenar los respectivos select
		@RequestMapping("/estado")
		@ResponseBody
		public Map<String, String> getEstadoSuper(@RequestParam int parte){
			Map<String, String> Tipovalor=new HashMap<>();
			Superficie superficie=new Superficie();
			superficie=superrepo.findOne(parte);
			List<Estado> tipo=estadorepo.findSuperByPieza(superficie);
			for(Estado tipos: tipo){
				Tipovalor.put(String.valueOf(tipos.getIdestado()),tipos.getNombre());
			}
			return Tipovalor;
			
		}
		
		
		//lista de departamentos
		@ModelAttribute("piezas")
		public List<Pieza> getPieza(){
			ArrayList<Pieza> pieza=new ArrayList<Pieza>();
			pieza=(ArrayList<Pieza>)piezarepo.findAll();
			return pieza;
		}
		
		@ModelAttribute("estados")
		public List<Estado> getEstado(){
			ArrayList<Estado> estado=new ArrayList<Estado>();
			estado=(ArrayList<Estado>)estadorepo.findAll();
			return estado;
		}
		
		//dificultad quirugica
		
		
		
}
