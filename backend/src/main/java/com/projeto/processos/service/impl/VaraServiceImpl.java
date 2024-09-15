package com.projeto.processos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.processos.dao.VaraDAO;
import com.projeto.processos.model.Vara;
import com.projeto.processos.service.VaraService;

@Service
public class VaraServiceImpl implements VaraService {

	@Autowired
	private VaraDAO dao;
	
	@Transactional
	@Override
	public List<Vara> getAll() {
		return dao.getAll();
	}

	@Transactional
	@Override
	public Vara get(int id) {
		return dao.get(id);
	}

	@Transactional
	@Override
	public void save(Vara vara) {
		if(dao.getByDescription(vara.getVara()) == null) {
			dao.save(vara);
		} else {
			throw new RuntimeException("A Vara "+vara.getVara()+" já existe");
		}

	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);

	}

	@Transactional
	@Override
	public Boolean getByDescription(String vara) {
		Vara v = dao.getByDescription(vara);
		if(v != null) {
			return true;
		}
		return false;
	}

}
