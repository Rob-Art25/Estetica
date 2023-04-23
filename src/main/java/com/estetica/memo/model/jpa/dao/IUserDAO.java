package com.estetica.memo.model.jpa.dao;

import java.util.List;

import com.estetica.memo.model.jpa.entity.User;


public interface IUserDAO 
{
	public List<User> obtenerTodos();
	public void insertar(User usr);
	public void eliminar(Long id);
	public User buscarPorId(Long id);	
}
