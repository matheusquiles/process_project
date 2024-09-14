package com.projeto.processos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.TipoPedido;
import com.projeto.processos.service.TipoPedidoService;

@RestController
@RequestMapping(value = "/api")
public class TipoPedidoController {
	
	@Autowired
	private TipoPedidoService service;
	
	@GetMapping("/tipoPedido") 
	public List<TipoPedido> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/tipoPedido/{id}")
	public TipoPedido get(@PathVariable int id) {
		TipoPedido tipoPedido = service.get(id);
		
		if(tipoPedido == null) {
			throw new RuntimeException("Tipo Pedido de ID "+id+" não encontrado");
		}
		 
		 return tipoPedido;	
	}
}
