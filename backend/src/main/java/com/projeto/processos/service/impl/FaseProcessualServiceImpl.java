package com.projeto.processos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.processos.dao.FaseProcessualDAO;
import com.projeto.processos.model.FaseProcessual;
import com.projeto.processos.service.FaseProcessualService;

@Service
public class FaseProcessualServiceImpl implements FaseProcessualService {

	@Autowired
	private FaseProcessualDAO dao;
	
	@Transactional
	@Override
	public List<FaseProcessual> getAll() {
		return dao.getAll();
	}

	@Transactional
	@Override
	public FaseProcessual get(int id) {
		return dao.get(id);
	}

	@Transactional
	@Override
	public void save(FaseProcessual fase) {
		if(dao.getByDescription(fase.getFaseProcessual()) == null) {
			dao.save(fase);
		} else {
			throw new RuntimeException("A Fase Processual "+fase.getFaseProcessual()+" já existe");
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
		FaseProcessual f = dao.getByDescription(vara);
		if(f != null) {
			return true;
		}
		return false;
	}


}
