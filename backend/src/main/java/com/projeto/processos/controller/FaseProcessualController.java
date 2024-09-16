package com.projeto.processos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.dto.DescricaoRequest;
import com.projeto.processos.model.FaseProcessual;
import com.projeto.processos.service.FaseProcessualService;

@RestController
@RequestMapping(value = "/api")
public class FaseProcessualController {

	@Autowired
	private FaseProcessualService service;
	
	@GetMapping("/faseProcessual") 
	public List<FaseProcessual> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/faseProcessual/{id}")
	public FaseProcessual get(@PathVariable int id) {
		FaseProcessual fase = service.get(id);
		
		if(fase == null) {
			throw new RuntimeException("Fase de ID "+id+" não encontrado");
		}
		 
		 return fase;	
	}
	
	@PostMapping("/faseProcessual/salvar")
	public FaseProcessual save(@RequestBody FaseProcessual fase) {
		service.save(fase);
		return fase;
	}
	
	@PostMapping("/faseProcessual/buscar-por-descricao")
	public boolean bescarPorDescricao(@RequestBody DescricaoRequest fase) {
		return service.getByDescription(fase.getDescricao());
	}
	
	@DeleteMapping("/faseProcessual/deletar/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "Fase Processual de id " + id + " deletada com sucesso";
	}
	
	@PutMapping("/faseProcessual/atualizar")
	public FaseProcessual update(@RequestBody FaseProcessual fase) {
		service.save(fase);
		return fase;
	}
	
	
}
