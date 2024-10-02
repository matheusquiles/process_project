package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.processos.dao.VaraDAO;
import com.projeto.processos.model.Vara;
import com.projeto.processos.service.VaraService;

@Service
public class VaraServiceImpl extends BaseServiceImpl<Vara, Integer> implements VaraService {

	@Autowired
	private VaraDAO dao;
	

	@Transactional
	@Override
	public void save(Vara vara) {
		if(dao.getByDescription(vara.getVara()) == null) {
			dao.save(vara);
		} else {
			throw new RuntimeException("A Vara "+vara.getVara()+" já existe");
		}

	}

}
