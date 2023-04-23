package com.estetica.memo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.estetica.memo.model.jpa.dao.ICitasDAO;
import com.estetica.memo.model.jpa.entity.Citas;

@Controller
@RequestMapping("/citas")
public class CitasController 
{

	@Autowired
	private ICitasDAO citasDAO;
	
	@GetMapping("/listar")
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Citas Agendadas");
		model.addAttribute("citasAgendadas", citasDAO.obtenerTodos());
		return "citas";
	}
	
	@GetMapping("/crear")
	public String crear(Map<String, Object> model)
	{
		Citas cita = new Citas();
		model.put("titulo", "Agendar Cita");
		model.put("citaNueva", cita);			
		return "reservar";
	}
	
	@PostMapping("/crear")
	public String guardar(Citas citaAgendada)
	{
		System.out.println("Cita Agendada: " + citaAgendada);		
		citasDAO.insertar(citaAgendada);
		return "redirect:/citas/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Long id)
	{		
		if(id != null && id > 0)
		{
			citasDAO.eliminar(id);
		}		
		
		return "redirect:/citas/listar";		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model)
	{
	
		Citas cita = new Citas();
		if(id > 0)
		{
			cita = citasDAO.buscarPorId(id);
		}
		else
		{
			return "redirect:/citas/listar";
		}
		model.put("citaAgendada", cita);
		model.put("titulo", "agendarCita");
		return "reservar";
	}
	
}
