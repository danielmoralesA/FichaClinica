package com.sv.foues.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sv.foues.entidades.Departamento;
import com.sv.foues.entidades.EstadoCivil;
import com.sv.foues.entidades.Expediente;
import com.sv.foues.entidades.Municipio;
import com.sv.foues.entidades.Paciente;
import com.sv.foues.entidades.Profecion;
import com.sv.foues.repositorio.DepartamentoRepo;
import com.sv.foues.repositorio.EstadoCivilRepo;
import com.sv.foues.repositorio.ExpedienteRepo;
import com.sv.foues.repositorio.MunicipioRepo;
import com.sv.foues.repositorio.PacienteRepo;
import com.sv.foues.repositorio.ProfecionRepo;

import groovyjarjarcommonscli.ParseException;

@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepo pacienterepo;
	
	@Autowired
	private ExpedienteRepo expedienterepo;
	
	@Autowired
	private EstadoCivilRepo estadorepo;
	
	@Autowired
	private ProfecionRepo proferepo;
	
	@Autowired
	private DepartamentoRepo deparepo;
	
	@Autowired
	private MunicipioRepo munrepo;
	
	
	@RequestMapping(value="/paciente/pacienteadulto")
	public  String pacAdulto(){
		return "paciente/pacienteadulto";
	}
	
	@RequestMapping(value="/paciente/pacienteadulto",method=RequestMethod.POST )
	public String CrearPaciente(@ModelAttribute Paciente paciente)
	throws ParseException, java.text.ParseException{
		try{
			
			Paciente aux=new Paciente();
			
			Calendar fecha=Calendar.getInstance();
			Date fechas=fecha.getTime();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String fechacad=format.format(fechas);
			Date fechaIng=format.parse(fechacad);
			
			paciente.setFechaIngreso(fechaIng);
			
			String year=String.valueOf(fecha.get(Calendar.YEAR));
			String anio=year.substring(2,4);
			
			//int x=Integer.parseInt(pacienterepo.getid());
			String valoractual=pacienterepo.getid();
			//int x=pacienterepo.getid();
			//System.out.println("\n id paciente \n"+x);
			if(valoractual!=null){
				int x=Integer.parseInt(valoractual);
				//aux=pacienterepo.findOne(x);
				aux=pacienterepo.getPaciente(x);
				System.out.println("\n id paciente \n"+aux.getIdpac());
			}
			else
				System.out.println("Crear primer expediente");
			if(aux.getNumExpediente()==null){
				//generaremos el primer correlativo
				String correc="001";
				String cadena="A"+correc+"-"+anio;
				//obtenemos la fecha actual del sistema para insertar
							
				paciente.setNumExpediente(cadena);
				paciente.setActivo(1);
				//guardamos los datos en expediente y paciente
				pacienterepo.save(paciente);
				int z=paciente.getIdpac();
				
				//insertamos el expediente
				insertExp(pacienterepo.findOne(z));
				return "redirect:/paciente/pacienteadultoshow/"+paciente.getIdpac();
							
			}
			else {
				//aqui obtengo la parte de la izquierda ejemplo 001
				String num=aux.getNumExpediente();
				String cadena=num.substring(1,4);
				//entonces lo convertiremos a numero y luego sumaremos uno
				//aplicaremos string format para darle forma de 002
				int numero=Integer.parseInt(cadena);
				numero++;
				String correc=String.format("%03d",numero);
				String numExp="A"+correc+"-"+anio;
				paciente.setActivo(1);
				paciente.setNumExpediente(numExp);
				pacienterepo.save(paciente);
				int id=paciente.getIdpac();
				insertExp(pacienterepo.findOne(id));
				System.out.println("\n num expediente\n"+paciente.getNumExpediente());
				return "redirect:/paciente/pacienteadultoshow/"+paciente.getIdpac();
			}
				
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	//funcion que va dentro de crear paciente
	public void insertExp(Paciente paciente){
		Expediente exp=new Expediente();
		exp.setNumExpediente(paciente.getNumExpediente());
		exp.setActivo(true);
		exp.setPacienteIdpac(paciente);
		expedienterepo.save(exp);
		
	}
	
	//show de paciente ese servira para el de niño tambien
	@RequestMapping("/paciente/pacienteadultoshow/{idpac}")
	public String ShowAdulto(@PathVariable int idpac, Model model){
		model.addAttribute("paciente",pacienterepo.getPaciente(idpac));
		return "paciente/pacienteadultoshow";
	}
	
	//lista de todos los pacientes
		@RequestMapping("/paciente/pacienteadultolist")
		public ModelAndView ListPaciente(){
			List<Paciente> list=(List<Paciente>) pacienterepo.findAll();
			return new ModelAndView("paciente/pacienteadultolist","pacList",list);
		}
		
	
		//editar usuario
	@RequestMapping(value="/paciente/editaadulto/update", method=RequestMethod.POST)
	public String actualizar(Paciente paciente){
		//paciente.setNumExpediente(paciente.getNumExpediente());
		//paciente.setFechaIngreso(paciente.getFechaIngreso());
		
		pacienterepo.save(paciente);
		return "redirect:/paciente/pacienteadultoshow/"+paciente.getIdpac();
		
	}
	
	@RequestMapping("/paciente/editadulto/{id}")
	public String pacienteadultoedit(@PathVariable Integer id, Model model){
		model.addAttribute("paciente",pacienterepo.getPaciente(id));
		return "paciente/editadulto";
		
	}
  
	
	//para los select de municipio estado civil profecion etc
	@ModelAttribute("estadoc")
	public List<EstadoCivil> getEstadoCivil(){
		ArrayList<EstadoCivil> estado=new ArrayList<EstadoCivil>();
		estado=(ArrayList<EstadoCivil>) estadorepo.findAll();
		return estado;
		
	}
	
	@ModelAttribute("profecion")
	public List<Profecion> getProfecion(){
		ArrayList<Profecion> profe=new ArrayList<Profecion>();
		profe=(ArrayList<Profecion>)proferepo.findAll();
		return profe;
	}
	
	//lista de departamentos
	@ModelAttribute("departamentos")
	public List<Departamento> getdepartamento(){
		ArrayList<Departamento> depa=new ArrayList<Departamento>();
		depa=(ArrayList<Departamento>)deparepo.findAll();
		return depa;
	}
	
	//lista para los municipio
	@RequestMapping("/municipios")
	@ResponseBody
	public List getMunicipio(@RequestParam String departamento){
		int x=Integer.parseInt(departamento);
		Departamento depa=new Departamento();
		depa=deparepo.findOne(x);
		HashMap<String, String> map=new HashMap<String,String>();
	//	Map<String, Set<String>> municipios= (Map<String, Set<String>>) munrepo.datos(x);
	//	return municipios.get(departamento);
		
		List<Municipio> muni=munrepo.datos(depa);
	
			
			//System.out.println("\n lista "+muni.get(i));
		
		
		return  munrepo.datos(depa);
	}
	
	
	
}
