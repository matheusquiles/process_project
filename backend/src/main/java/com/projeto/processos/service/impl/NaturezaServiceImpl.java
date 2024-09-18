package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.NaturezaDAO;
import com.projeto.processos.model.Natureza;
import com.projeto.processos.service.NaturezaService;

import jakarta.transaction.Transactional;

@Service
public class NaturezaServiceImpl extends BaseServiceImpl<Natureza, Integer> implements NaturezaService {

	@Autowired
	private NaturezaDAO dao;
	
	@Transactional
	@Override
	public void save(Natureza entity) {
		if(dao.getByDescription(entity.getNatureza()).isEmpty()){
			dao.save(entity);
		}  else {
	        throw new RuntimeException("Natureza " + entity.getNatureza() + " já existe");
	    }		
	}



}
