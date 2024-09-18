package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.FuncaoDAO;
import com.projeto.processos.model.Funcao;

@Repository
public class FuncaoDAOImpl extends BaseDAOImpl<Funcao, Integer> implements FuncaoDAO {

	@Autowired
	public FuncaoDAOImpl(){
		super(Funcao.class);
	}
	
	@Override
	public Optional<Funcao> getByDescription(String description) {
		Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Funcao f WHERE LOWER(f.funcao) = LOWER(:funcao)";
        Funcao f = currentSession.createQuery(hql, Funcao.class)
                .setParameter("funcao", description)
                .uniqueResult();
        return Optional.ofNullable(f);
	}
	

}
