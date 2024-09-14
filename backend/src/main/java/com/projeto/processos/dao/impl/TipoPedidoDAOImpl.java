package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.TipoPedidoDAO;
import com.projeto.processos.model.TipoPedido;

import jakarta.persistence.EntityManager;

@Repository
public class TipoPedidoDAOImpl implements TipoPedidoDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TipoPedido> getAll() {
		Session currentSession = entityManager.unwrap(Session.class); 
		
		Query<TipoPedido> list =  currentSession.createQuery("from TipoPedido", TipoPedido.class);
		
		return list.getResultList();
	}

	@Override
	public TipoPedido get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(TipoPedido.class, id);
	}

	@Override
	public void save(TipoPedido user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
