package com.projeto.processos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Processo;
import com.projeto.processos.service.ProcessoService;
import com.projeto.processos.service.impl.ProcessoServiceImp;

@RestController
@RequestMapping("api/processo")
public class ProcessoController extends BaseControllerImpl<Processo, Integer> {

	@Autowired
	private ProcessoService service;
	
	
	public ProcessoController(ProcessoServiceImp service) {
		super(service);
	}
	
	
	@GetMapping("todos")
	 public List<ProcessoDTO> getAllDTO(){
		 return service.findAllDTO();
	 }
	
	@Override
	public String save(Processo entity) {
		try {
			service.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar processo";
		}
		try {
			service.salvarPedido(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar pedidos";
		}		
		
		
		return "Saved";
	}
	 
//	 @GetMapping("/porProcesso")
//	 public PedidoDTO findByIdDTO(@RequestBody IdRequest id) {
//		 return service.findDTO(id.getId());
//		 
//	 }
	
}
