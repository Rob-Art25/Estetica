package com.estetica.memo.model.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estetica.memo.model.jpa.entity.Citas;

@Repository
public class ICitasDAOImpl implements ICitasDAO
{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly=true)
	@Override
	public List<Citas> obtenerTodos()
	{
		
		return em.createQuery("from Citas").getResultList();
	}
	
	@Transactional
	@Override
	public void insertar(Citas cita)
	{
		
		if(cita.getId() != null && cita.getId() > 0)
		{
			em.merge(cita);
		}
		else
		{
			em.persist(cita);
		}
		
	}
	
	@Transactional(readOnly=true)
	@Override
	public Citas buscarPorId(Long id)
	{
		return em.find(Citas.class, id);
	}
	
	@Transactional
	@Override
	public void eliminar(Long id)
	{
		em.remove(buscarPorId(id));
	}

}
