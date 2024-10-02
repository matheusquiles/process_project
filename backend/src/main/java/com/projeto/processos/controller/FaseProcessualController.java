package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.FaseProcessual;
import com.projeto.processos.service.impl.FaseProcessualServiceImpl;

@RestController
@RequestMapping(value = "/api/faseProcessual")
public class FaseProcessualController extends BaseControllerImpl<FaseProcessual, Integer>{

	public FaseProcessualController(FaseProcessualServiceImpl service) {
		super(service);
	}

	
	
}
