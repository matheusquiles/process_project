package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.processos.dao.FaseProcessualDAO;
import com.projeto.processos.model.FaseProcessual;
import com.projeto.processos.service.FaseProcessualService;

@Service
public class FaseProcessualServiceImpl extends BaseServiceImpl<FaseProcessual, Integer> implements FaseProcessualService {

	@Autowired
	private FaseProcessualDAO dao;
	

	@Transactional
	@Override
	public void save(FaseProcessual fase) {
		if(dao.getByDescription(fase.getFaseProcessual()) == null) {
			dao.save(fase);
		} else {
			throw new RuntimeException("A Fase Processual "+fase.getFaseProcessual()+" já existe");
		}
	}


}
