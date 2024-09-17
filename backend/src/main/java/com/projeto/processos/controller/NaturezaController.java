package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Natureza;
import com.projeto.processos.service.impl.NaturezaServiceImpl;

@RestController
@RequestMapping("api/natureza")
public class NaturezaController extends BaseControllerImpl<Natureza, Integer> {

	public NaturezaController(NaturezaServiceImpl service) {
		super(service);
		// TODO Auto-generated constructor stub
	}


}
