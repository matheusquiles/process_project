package com.projeto.processos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.dto.DescricaoRequest;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.service.EscritorioService;

@RestController
@RequestMapping(value = "/api")
public class EscritorioController {

	@Autowired
	private EscritorioService service;
	
	@GetMapping("/escritorio") 
	public List<Escritorio> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/escritorio/{id}")
	public Escritorio get(@PathVariable int id) {
		Escritorio escritorio = service.get(id);
		
		if(escritorio == null) {
			throw new RuntimeException("Escritorio de ID "+id+" não encontrado");
		}
		 
		 return escritorio;	
	}
	
	@PostMapping("/escritorio/salvar")
	public Escritorio save(@RequestBody Escritorio escritorio) {
		service.save(escritorio);
		return escritorio;
	}
	
	@PostMapping("/escritorio/buscar-por-descricao")
	public boolean bescarPorDescricao(@RequestBody DescricaoRequest request) {
		return service.getByDescription(request.getDescricao());
	}
	
	
}
