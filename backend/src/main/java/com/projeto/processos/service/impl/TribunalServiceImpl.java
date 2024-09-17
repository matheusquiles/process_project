package com.projeto.processos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.model.Tribunal;
import com.projeto.processos.service.BaseService;

@Service
public class TribunalServiceImpl implements BaseService<Tribunal, Integer> {

	@Autowired
	private TribunalDAO dao;

	@Override
	public List<Tribunal> findAll() {
		return dao.getAll();
	}

	@Override
	public Optional<Tribunal> findById(Integer id) {
		return Optional.ofNullable(dao.get(id));
	}


	@Override
	public void deleteById(Integer id) {
		dao.delete(0);		
	}

	@Override
	public Tribunal update(Tribunal entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Tribunal entity) {
		if(dao.getByDescription(entity.getTribunalOrigem()) == null) {
			dao.save(entity);
		} else {
			throw new RuntimeException("Tribunal origem "+entity.getTribunalOrigem()+" já existe");
		}
	}

	@Override
	public Boolean findByDescription(String s) {
		Tribunal t = dao.getByDescription(s);
		if(t != null) {
			return true;
		}
		return false;
	}
	

	
}
