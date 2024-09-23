package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.TipoPedidoDAO;
import com.projeto.processos.model.TipoPedido;
import com.projeto.processos.service.TipoPedidoService;

@Service
public class TipoPedidoServiceImpl extends BaseServiceImpl<TipoPedido, Integer> implements TipoPedidoService {

	@Autowired
	private TipoPedidoDAO dao;
	

	@Override
	public void save(TipoPedido entity) {
		dao.save(entity);
		
	}


}
