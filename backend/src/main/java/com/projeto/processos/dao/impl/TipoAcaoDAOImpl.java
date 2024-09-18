package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.TipoAcaoDAO;
import com.projeto.processos.model.TipoAcao;

@Repository
public class TipoAcaoDAOImpl extends BaseDAOImpl<TipoAcao, Integer> implements TipoAcaoDAO {

	   @Autowired
	    public TipoAcaoDAOImpl() {
	        super(TipoAcao.class);
	    }
	   
	   @Override
		public Optional<TipoAcao> getByDescription(String description) {
			Session currentSession = entityManager.unwrap(Session.class);
	        String hql = "FROM TipoAcao t WHERE LOWER(t.tipoAcao) = LOWER(:tipo)";
	        TipoAcao t = currentSession.createQuery(hql, TipoAcao.class)
	                .setParameter("tipo", description)
	                .uniqueResult();
	        return Optional.ofNullable(t);
		}

}
