package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.TipoPedidoDAO;
import com.projeto.processos.model.TipoPedido;

@Repository
public class TipoPedidoDAOImpl extends BaseDAOImpl<TipoPedido, Integer> implements TipoPedidoDAO {

	public TipoPedidoDAOImpl() {
		super(TipoPedido.class);
	}
	
	@Override
	public Optional<TipoPedido> getByDescription(String description) {
		Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM TipoPedido t WHERE LOWER(t.descricao) = LOWER(:descricao)";
        TipoPedido t = currentSession.createQuery(hql, TipoPedido.class)
                .setParameter("descricao", description)
                .uniqueResult();
        return Optional.ofNullable(t);
	}
	
	
	

}
