package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.ClassificacaoRiscoDAO;
import com.projeto.processos.model.ClassificacaoRisco;

@Repository
public class ClassificacaoRiscoDAOImpl extends BaseDAOImpl<ClassificacaoRisco, Integer> implements ClassificacaoRiscoDAO {

	@Autowired
	public ClassificacaoRiscoDAOImpl() {
		super(ClassificacaoRisco.class);
	}
	
	@Override
	public Optional<ClassificacaoRisco> getByDescription(String description) {
		Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM ClassificacaoRisco c WHERE LOWER(c.classificacaoRisco) = LOWER(:classificacao)";
        ClassificacaoRisco c = currentSession.createQuery(hql, ClassificacaoRisco.class)
                .setParameter("classificacao", description)
                .uniqueResult();
        return Optional.ofNullable(c);
	}
	
	

}
