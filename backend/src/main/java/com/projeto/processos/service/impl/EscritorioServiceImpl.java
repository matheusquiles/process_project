package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.service.EscritorioService;

@Service
public class EscritorioServiceImpl extends BaseServiceImpl<Escritorio, Integer> implements EscritorioService {

	@Autowired
	private EscritorioDAO dao;

	@Override
	public void save(Escritorio entity) {
		if(dao.getByDescription(entity.getNomeEscritorio()).isEmpty()){
			dao.save(entity);
		}  else {
	        throw new RuntimeException("Escritorio " + entity.getNomeEscritorio() + " já existe");
	    }
		
	}
	
	
	

}
