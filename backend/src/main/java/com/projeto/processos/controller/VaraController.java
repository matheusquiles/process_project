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
import com.projeto.processos.model.Vara;
import com.projeto.processos.service.VaraService;

@RestController
@RequestMapping(value = "/api")
public class VaraController {
	
	@Autowired
	private VaraService service;
	
	@GetMapping("/vara") 
	public List<Vara> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/vara/{id}")
	public Vara get(@PathVariable int id) {
		Vara vara = service.get(id);
		
		if(vara == null) {
			throw new RuntimeException("Vara de ID "+id+" não encontrado");
		}
		 
		 return vara;	
	}
	
	@PostMapping("/vara/salvar")
	public Vara save(@RequestBody Vara vara) {
		service.save(vara);
		return vara;
	}
	
	@PostMapping("/vara/buscar-por-descricao")
	public boolean bescarPorDescricao(@RequestBody DescricaoRequest vara) {
		return service.getByDescription(vara.getDescricao());
	}
	

}
