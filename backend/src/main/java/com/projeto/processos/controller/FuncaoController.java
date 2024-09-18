package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Funcao;
import com.projeto.processos.service.impl.FuncaoServiceImpl;

@RestController
@RequestMapping("api/funcao")
public class FuncaoController extends BaseControllerImpl<Funcao, Integer> {

	public FuncaoController(FuncaoServiceImpl service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
