package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Escritorio;
import com.projeto.processos.service.impl.EscritorioServiceImpl;

@RestController
@RequestMapping(value = "/api/escritorio")
public class EscritorioController extends BaseControllerImpl<Escritorio, Integer>{

	public EscritorioController(EscritorioServiceImpl service) {
		super(service);
	}

	
	
}
