package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.BaseDAO;
import com.projeto.processos.dao.PedidoDAO;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.dao.TipoPedidoDAO;
import com.projeto.processos.model.Pedido;
import com.projeto.processos.model.Processo;
import com.projeto.processos.model.TipoPedido;
import com.projeto.processos.service.PedidoService;

import jakarta.transaction.Transactional;

@Service
public class PedidoServiceImp extends BaseServiceImpl<Pedido, Integer> implements PedidoService {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private ProcessoDAO processoDAO;
	
	@Autowired
	private TipoPedidoDAO tipoPedidoDAO;
	
	@Transactional
	@Override
	public void save(Pedido entity) {

		Processo processo = getEntity(processoDAO, entity.getProcesso().getIdProcesso(), "Process not found");
		TipoPedido tipoPedido = getEntity(tipoPedidoDAO, entity.getTipoPedido().getIdTipoPedido(), "Tipo Pedido not found");
		
		entity.setProcesso(processo);
		entity.setTipoPedido(tipoPedido);
		
		pedidoDAO.save(entity);
		
		
	}

	
	 private <T> T getEntity(BaseDAO<T, Integer> dao, Integer id, String errorMessage) {
	        return dao.get(id).orElseThrow(() -> new RuntimeException(errorMessage));
	    }
	

}