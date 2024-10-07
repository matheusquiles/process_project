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
	public List<ProcessoDTO> getAllDTO() {
		return service.findAllDTO();
	}

	@Override
	public Boolean save(Processo entity) {
		
		if(service.validaProcessoExistente(entity.getNumeroProcesso())) {
			System.err.println("Já existe um processo de número: " + entity.getNumeroProcesso());
	        return false;
		}
		
		try {
	        if (service.salvarProcesso(entity)) {
	            service.salvarPedido(entity);
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
	        System.err.println("Erro ao salvar processo: " + e.getMessage());
	        return false;
	    }
	}

//	 @GetMapping("/porProcesso")
//	 public PedidoDTO findByIdDTO(@RequestBody IdRequest id) {
//		 return service.findDTO(id.getId());
//		 
//	 }

}
