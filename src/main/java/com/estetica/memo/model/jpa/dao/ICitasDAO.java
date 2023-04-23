package com.estetica.memo.model.jpa.dao;

import java.util.List;

import com.estetica.memo.model.jpa.entity.Citas;

public interface ICitasDAO 
{

	public List<Citas> obtenerTodos();
	public void insertar(Citas id);
	public void eliminar(Long id);
	public Citas buscarPorId(Long id);
	
}
