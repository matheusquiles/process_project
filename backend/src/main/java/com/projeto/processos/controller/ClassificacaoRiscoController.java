package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.ClassificacaoRisco;
import com.projeto.processos.service.impl.ClassificacaoRiscoServiceImpl;

@RestController
@RequestMapping("api/classificacaoRisco")
public class ClassificacaoRiscoController extends BaseControllerImpl<ClassificacaoRisco, Integer> {

	public ClassificacaoRiscoController(ClassificacaoRiscoServiceImpl service) {
		super(service);
	}

}
