package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Pedido;
import com.projeto.processos.service.impl.PedidoServiceImp;

@RestController
@RequestMapping(value = "/api/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, Integer> {

	public PedidoController(PedidoServiceImp service) {
		super(service);
	}

}
