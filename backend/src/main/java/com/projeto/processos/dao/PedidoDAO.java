package com.projeto.processos.dao;

import java.util.List;
import java.util.Optional;

import com.projeto.processos.dto.PedidoDTO;
import com.projeto.processos.model.Pedido;

public interface PedidoDAO extends BaseDAO<Pedido, Integer> {
	Optional<Pedido> getByDescription(String pedido);
	List<PedidoDTO> getAllDTO();
	List<PedidoDTO> getDTO(Integer idProcesso);
	List<Pedido> getPedidoByProcesso(Integer idProcesso);

}
