package com.projeto.processos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.processos.model.Vara;
import com.projeto.processos.service.impl.VaraServiceImpl;

@RestController
@RequestMapping(value = "/api/vara")
public class VaraController extends BaseControllerImpl<Vara, Integer>{

	
    public VaraController(VaraServiceImpl service) {
        super(service);  
    }
	

}
