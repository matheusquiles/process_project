package com.projeto.processos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.service.EscritorioService;

@Service
public class EscritorioServiceImpl implements EscritorioService {

	@Autowired
	private EscritorioDAO dao;
	
	@Transactional
	@Override
	public List<Escritorio> getAll() {
		return dao.getAll();
	}

	@Transactional
	@Override
	public Escritorio get(int id) {
		return dao.get(id);
	}

	@Transactional
	@Override
	public void save(Escritorio e) {
		if(dao.getByDescription(e.getNomeEscritorio()) == null) {
			dao.save(e);
		} else {
			throw new RuntimeException("O escritório "+e.getNomeEscritorio()+" já existe");
		}

	}

	@Transactional
	@Override
	public Boolean getByDescription(String escritorio) {
		Escritorio e = dao.getByDescription(escritorio);
		if(e != null) {
			return true;
		}
		return false;
	
	}
	
	

}
