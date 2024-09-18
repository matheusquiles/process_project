package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.TipoAcaoDAO;
import com.projeto.processos.model.TipoAcao;
import com.projeto.processos.service.TipoAcaoService;

import jakarta.transaction.Transactional;

@Service
public class TipoAcaoServiceImpl extends BaseServiceImpl<TipoAcao, Integer> implements TipoAcaoService {

	
	@Autowired
	private TipoAcaoDAO dao;
	
	
	@Transactional
	@Override
	public void save(TipoAcao entity) {
		if(dao.getByDescription(entity.getTipoAcao()).isEmpty()){
			dao.save(entity);
		}  else {
	        throw new RuntimeException("Tipo Acao " + entity.getTipoAcao() + " já existe");
	    }		
		
	}

	
	

}
