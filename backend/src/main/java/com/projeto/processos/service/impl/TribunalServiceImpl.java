package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.model.Tribunal;
import com.projeto.processos.service.TribunalService;

import jakarta.transaction.Transactional;

@Service
public class TribunalServiceImpl extends BaseServiceImpl<Tribunal, Integer> implements TribunalService {

	@Autowired
	private TribunalDAO dao;
	
	
	@Transactional
	@Override
	public void save(Tribunal entity) {
		if(dao.getByDescription(entity.getTribunalOrigem()).isEmpty()){
			dao.save(entity);
		}  else {
	        throw new RuntimeException("Tribunal origem " + entity.getTribunalOrigem() + " já existe");
	    }
	}

	@Override
	public Boolean findByDescription(String s) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
