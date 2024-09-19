package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.model.Processo;
import com.projeto.processos.service.ProcessoService;

import jakarta.transaction.Transactional;

@Service
public class ProcessoServiceImp extends BaseServiceImpl<Processo, Integer> implements ProcessoService {

	@Autowired
	private ProcessoDAO dao;
	
	@Autowired
	private EscritorioDAO escritorioDAO;
	

	@Transactional
	@Override
	public void save(Processo entity) {


//		Escritorio escritorio = escritorioDAO.get(entity.getIdEscritorio().getIdEscritorio())
//.orElseThrow(() -> new EntityNotFoundException("Escritório não encontrado"));
				
			dao.save(entity);

		
		
	}
	

}
