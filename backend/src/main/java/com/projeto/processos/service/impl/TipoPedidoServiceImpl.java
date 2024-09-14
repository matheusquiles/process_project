package com.projeto.processos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.processos.dao.TipoPedidoDAO;
import com.projeto.processos.model.TipoPedido;
import com.projeto.processos.service.TipoPedidoService;

@Service
public class TipoPedidoServiceImpl implements TipoPedidoService {

	@Autowired
	private TipoPedidoDAO dao;
	
	@Transactional
	@Override
	public List<TipoPedido> getAll() {
		return dao.getAll();
	}

	@Transactional
	@Override
	public TipoPedido get(int id) {
		return dao.get(id);
	}


}
