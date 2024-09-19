package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Processo;
import com.projeto.processos.service.impl.ProcessoServiceImp;

@RestController
@RequestMapping("api/processo")
public class ProcessoController extends BaseControllerImpl<Processo, Integer> {

	public ProcessoController(ProcessoServiceImp service) {
		super(service);
	}
	
}
