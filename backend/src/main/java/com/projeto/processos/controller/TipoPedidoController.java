package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.TipoPedido;
import com.projeto.processos.service.impl.TipoPedidoServiceImpl;

@RestController
@RequestMapping(value = "/api/tipoPedido")
public class TipoPedidoController extends BaseControllerImpl<TipoPedido, Integer>{

	public TipoPedidoController(TipoPedidoServiceImpl service) {
		super(service);
	}
	
	
	
	
}
