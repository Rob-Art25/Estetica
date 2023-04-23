package com.estetica.memo.model.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estetica.memo.model.jpa.entity.User;

@Repository
public class UserDAOImpl implements IUserDAO
{

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly=true)
	@Override
	public List<User> obtenerTodos() 
	{
		
		return em.createQuery("from User").getResultList();
	}
	
	@Transactional
	@Override
	public void insertar(User usr)
	{
		
		if(usr.getId() != null && usr.getId()>0)
		{
			/*
			 *Sí el usuario ya está registrado, solo se actualizan los datos, pues ya tiene un id
			 *se hace el update con el método em.merge
			 */
			em.merge(usr);
		}
		else
		{	
			// De lo Contrario, se crea un nuevo usuario
			// inserta a la base de datos con el EntityManager
			em.persist(usr);
		}
	}
	
	
	// Método Búscar Usuario por id
	@Transactional(readOnly=true)
	@Override
	public User buscarPorId(Long id)
	{		
		return em.find(User.class, id);
	}
	
	@Transactional
	@Override
	public void eliminar(Long id)
	{		
		em.remove(buscarPorId(id));
	}
	
}
