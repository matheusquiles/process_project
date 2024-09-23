package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Pedido;

public interface PedidoDAO extends BaseDAO<Pedido, Integer> {
	Optional<Pedido> getByDescription(String pedido);

}
