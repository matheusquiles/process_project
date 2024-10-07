package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.FuncaoDAO;
import com.projeto.processos.model.Funcao;
import com.projeto.processos.service.FuncaoService;

import jakarta.transaction.Transactional;

@Service
public class FuncaoServiceImpl extends BaseServiceImpl<Funcao, Integer> implements FuncaoService {

	
	@Autowired
	private FuncaoDAO dao;
	
	@Transactional
	@Override
	public void save(Funcao entity) {
		if(dao.getByDescription(entity.getFuncao()).isEmpty()){
			dao.save(entity);
		}  else {
	        throw new RuntimeException("Função " + entity.getFuncao() + " já existe");
	    }
	}


}
