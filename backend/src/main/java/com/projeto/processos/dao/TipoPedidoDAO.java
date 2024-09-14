package com.projeto.processos.dao;

import java.util.List;

import com.projeto.processos.model.TipoPedido;

public interface TipoPedidoDAO {
	
	List<TipoPedido> getAll();
	
	TipoPedido get(int id);
	
	void save(TipoPedido user);
	
	void delete(int id);

}
