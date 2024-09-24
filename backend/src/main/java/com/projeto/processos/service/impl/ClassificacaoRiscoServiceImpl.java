package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.ClassificacaoRiscoDAO;
import com.projeto.processos.model.ClassificacaoRisco;
import com.projeto.processos.service.ClassificacaoRiscoService;

@Service
public class ClassificacaoRiscoServiceImpl extends BaseServiceImpl<ClassificacaoRisco, Integer> implements ClassificacaoRiscoService {

	@Autowired
	private ClassificacaoRiscoDAO dao;

	@Override
	public void save(ClassificacaoRisco entity) {
		if(dao.getByDescription(entity.getClassificacaoRisco()).isEmpty()){
			dao.save(entity);
		}  else {
	        throw new RuntimeException("Classificação de risco " + entity.getClassificacaoRisco() + " já existe");
	    }
		
	}

	
	
	

}
