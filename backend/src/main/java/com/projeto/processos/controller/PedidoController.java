package com.projeto.processos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.dto.IdRequest;
import com.projeto.processos.dto.PedidoDTO;
import com.projeto.processos.model.Pedido;
import com.projeto.processos.service.PedidoService;
import com.projeto.processos.service.impl.PedidoServiceImp;

@RestController
@RequestMapping(value = "/api/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, Integer> {

	
	@Autowired
	private PedidoService service;
	
	
	public PedidoController(PedidoServiceImp service) {
		super(service);
	}
	
	 @GetMapping("todos")
	 public List<PedidoDTO> getAllDTO(){
		 return service.findAllDTO();
	 }
	 
	 @GetMapping("/porProcesso")
	 public List<PedidoDTO> findByIdDTO(@RequestBody IdRequest id) {
		 return service.findDTO(id.getId());
		 
	 }
	
	
}
