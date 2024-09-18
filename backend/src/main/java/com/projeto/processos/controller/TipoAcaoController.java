package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.TipoAcao;
import com.projeto.processos.service.impl.TipoAcaoServiceImpl;

@RestController
@RequestMapping("api/tipoAcao")
public class TipoAcaoController extends BaseControllerImpl<TipoAcao, Integer> {

	public TipoAcaoController(TipoAcaoServiceImpl service) {
		super(service);
	}

}
