package com.projeto.processos.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.PedidoDAO;
import com.projeto.processos.model.Pedido;

@Repository
public class PedidoDAOImp extends BaseDAOImpl<Pedido, Integer> implements PedidoDAO {

	@Autowired
	public PedidoDAOImp() {
		super(Pedido.class);
	}


}
