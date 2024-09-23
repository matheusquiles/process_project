package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.dto.PedidoDTO;
import com.projeto.processos.model.Pedido;

public interface PedidoService extends BaseService<Pedido, Integer> {
	
	public List<PedidoDTO> findAllDTO();
	public List<PedidoDTO> findDTO(Integer idProcesso);

}
