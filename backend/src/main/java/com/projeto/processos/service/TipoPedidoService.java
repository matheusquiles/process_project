package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.model.TipoPedido;

public interface TipoPedidoService {
	
	List<TipoPedido> getAll();
	
	TipoPedido get(int id);

}
