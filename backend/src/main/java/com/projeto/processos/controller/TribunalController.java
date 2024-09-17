package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Tribunal;
import com.projeto.processos.service.impl.TribunalServiceImpl;

@RestController
@RequestMapping("api/tribunal")
public class TribunalController extends BaseControllerImpl<Tribunal, Integer>{

	
    public TribunalController(TribunalServiceImpl service) {
        super(service);  // Passa o serviço para a classe base
    }
	

}
