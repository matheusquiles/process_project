package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.PedidoDAO;
import com.projeto.processos.dto.PedidoDTO;
import com.projeto.processos.model.Pedido;

@Repository
public class PedidoDAOImp extends BaseDAOImpl<Pedido, Integer> implements PedidoDAO {

	@Autowired
	public PedidoDAOImp() {
		super(Pedido.class);
	}

	@Override
	public List<PedidoDTO> getAllDTO() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		StringBuilder hql = searchDTO();
		
		Query<PedidoDTO> list =  currentSession.createQuery(hql.toString(), PedidoDTO.class);
		List<PedidoDTO> results = list.getResultList();
		
		return results;
	}

	@Override
	public PedidoDTO getDTO(Integer idProcesso) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			
			StringBuilder hql = searchDTO();
			hql.append("and pro.idProcesso = :idProcesso");
			
			Query<PedidoDTO> query =  currentSession.createQuery(hql.toString(), PedidoDTO.class);
			query.setParameter("idProcesso", idProcesso);
			
			List<PedidoDTO> vehicleList = query.getResultList();
			
			return vehicleList.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		    throw new RuntimeException("Erro ao obter os dados", e);
		}
	}
	
	
	private StringBuilder searchDTO() {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.projeto.processos.dto.PedidoDTO(");
		hql.append(" ped.idPedido idPedido ");
		hql.append(", pro.numeroProcesso processo ");
		hql.append(", tpe.descricao tipoPedido ");
		hql.append(", ped.pedidoGanhoPrimeiraInstancia ");
		hql.append(", ped.pedidoGanhoSegundaInstancia ");
		hql.append(", ped.pedidoGanhoTerceiraInstancia) ");

		hql.append(" from Pedido ped ");
		hql.append(" inner join ped.processo pro ");
		hql.append(" inner join ped.tipoPedido tpe ");
		hql.append(" where 1=1 ");
		
		return hql;
	}
	


}
