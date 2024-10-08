package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Processo;

import jakarta.persistence.EntityManager;

@Repository
public class ProcessoDAOImpl extends BaseDAOImpl<Processo, Integer> implements ProcessoDAO {

	@Autowired
	public ProcessoDAOImpl() {
		super(Processo.class);
	}

	@Autowired
	private PedidoDAOImp pedidoDAO;

	@Override
	public void save(Processo entity) {
		Session session = entityManager.unwrap(Session.class);
		((EntityManager) session).merge(entity);
	}

	@Override
	public List<ProcessoDTO> getAllDTO() {
		Session currentSession = entityManager.unwrap(Session.class);

		StringBuilder hql = searchDTO();
		Query<ProcessoDTO> list = currentSession.createQuery(hql.toString(), ProcessoDTO.class);
		List<ProcessoDTO> processos = list.getResultList();

		for (ProcessoDTO processoDTO : processos) {
			processoDTO.setPedido(pedidoDAO.getDTO(processoDTO.getIdProcesso()));
		}

		return processos;
	}

	@Override
	public ProcessoDTO getDTO(String processo) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = searchDTO();
		
		hql.append(" and pro.numeroProcesso = :processo ");
		
		ProcessoDTO dto = currentSession.createQuery(hql.toString(), ProcessoDTO.class)
					.setParameter("processo", processo)
					.uniqueResult();

		dto.setPedido(pedidoDAO.getDTO(dto.getIdProcesso()));

		return dto;
	}

	private StringBuilder searchDTO() {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.projeto.processos.dto.ProcessoDTO(");
		hql.append(" pro.idProcesso idProcesso ");
		hql.append(", esc.nomeEscritorio escritorio ");
		hql.append(", nat.natureza natureza ");
		hql.append(", tip.tipoAcao tipoAcao ");
		hql.append(", fun.funcao funcao ");
		hql.append(", tri.tribunalOrigem tribunal ");
		hql.append(", fas.faseProcessual faseProcessual ");
		hql.append(", var.vara vara ");
		hql.append(", pro.admissao ");
		hql.append(", pro.demissao ");
		hql.append(", pro.numeroProcesso ");
		hql.append(", pro.estado ");
		hql.append(", pro.cidade ");
		hql.append(", pro.reu ");
		hql.append(", pro.dataAjuizamento ");
		hql.append(", pro.ultimosAndamentosProcessuais ");
		hql.append(", pro.valorCausa ");
		hql.append(", pro.autor ");
		hql.append(", pro.valorPerdaEstimado ");
		hql.append(", pro.reclamada ");
		hql.append(", pro.classificacaoRisco ");
		hql.append(", pro.depositoRecursalOrdinario ");
		hql.append(", pro.dataDepositoRecursalOrdinario ");
		hql.append(", pro.depositoRecursalRevista ");
		hql.append(", pro.dataDepositoRecursalRevista ");
		hql.append(", pro.depositoJudicial ");
		hql.append(", pro.dataDepositoJudicial ");
		hql.append(", pro.bloqueioJudicial ");
		hql.append(", pro.dataBloqueioJudicial ");
		hql.append(" ) ");

		hql.append(" from Processo pro ");
		hql.append(" left join pro.escritorio esc ");
		hql.append(" left join pro.natureza nat ");
		hql.append(" left join pro.tipoAcao tip ");
		hql.append(" left join pro.funcao fun ");
		hql.append(" left join pro.tribunal tri ");
		hql.append(" left join pro.faseProcessual fas ");
		hql.append(" left join pro.vara var ");

		hql.append(" where 1=1 ");

		return hql;
	}

	@Override
	public Processo getByProcesso(String processo) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("from Processo p ");
		hql.append("where LOWER(p.numeroProcesso) = LOWER(:processo)");

		Query<Processo> query = currentSession.createQuery(hql.toString(), Processo.class);
		query.setParameter("processo", processo);
		Processo p = query.uniqueResult();

		return p;
	}

	@Override
	public Boolean validaProcessoExistente(String processo) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("from Processo p ");
		hql.append("where LOWER(p.numeroProcesso) = LOWER(:processo)");

		Query<Processo> query = currentSession.createQuery(hql.toString(), Processo.class);
		query.setParameter("processo", processo);
		Processo p = query.uniqueResult();

		return p != null;
	}

}
