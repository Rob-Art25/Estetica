package com.estetica.memo.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.estetica.memo.model.jpa.dao.IUserDAO;
import com.estetica.memo.model.jpa.entity.User;

@Controller
@RequestMapping("/usuarios")
public class UsersController 
{
	
	@Autowired
	private IUserDAO usrDAO;
	
	@GetMapping({"/listar", "/usuarios"})
	public String listar(Model model) 
	{
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("listaUsuarios", usrDAO.obtenerTodos());
		return "usuarios";
	}
	
	/**
	 * Se Inicia el CRUD (CREATE, UPDATE & DELETE system)
	 * Empezando por la creación o agregación de usuarios
	 * 
	 */
	
	@GetMapping("/crear")
	public String crear(Map<String, Object> model)
	{
		User us = new User();
		//llamar al modelo para que inserte datos:
		model.put("titulo", "Formulario Usuario");
		model.put("usuarioNuevo", us);		
		return "registrar";
	}
	
	@PostMapping("/crear")
	public String guardar(User usuarioConDatos)
	{
		// Llamar al dao para que inserte al usuario nuevo
		System.out.println("Usuario con Datos: " + usuarioConDatos);
		usrDAO.insertar(usuarioConDatos);
		return "redirect:/usuarios/listar";
	}	
	
	//localhost:8081/usuarios/eliminar/6----> Ejemplo
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id)
	{
		//Llamar al DAO para eliminar
		if(id != null && id > 0)
		{
			usrDAO.eliminar(id);
		}
		
		return "redirect:/usuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model)
	{
		//Llamar al DAO para editar
		User usuario = null;
		if(id > 0)
		{
			usuario = usrDAO.buscarPorId(id);
		}
		else
		{
			
			return "redirect:/usuarios/listar";
		}
		
		model.put("usuarioNuevo", usuario);
		model.put("titulo", "Editar Usuario");
		
		return "registrar";
	}	
	
}
