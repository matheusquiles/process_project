package com.projeto.processos.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.BaseDAO;
import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.dao.FaseProcessualDAO;
import com.projeto.processos.dao.FuncaoDAO;
import com.projeto.processos.dao.NaturezaDAO;
import com.projeto.processos.dao.PedidoDAO;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.dao.TipoAcaoDAO;
import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.dao.VaraDAO;
import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.model.FaseProcessual;
import com.projeto.processos.model.Funcao;
import com.projeto.processos.model.Natureza;
import com.projeto.processos.model.Pedido;
import com.projeto.processos.model.Processo;
import com.projeto.processos.model.TipoAcao;
import com.projeto.processos.model.Tribunal;
import com.projeto.processos.model.Vara;
import com.projeto.processos.service.ProcessoService;

import jakarta.transaction.Transactional;

@Service
public class ProcessoServiceImp extends BaseServiceImpl<Processo, Integer> implements ProcessoService {

	@Autowired
	private ProcessoDAO dao;

	@Autowired
	private NaturezaDAO naturezaDAO;

	@Autowired
	private EscritorioDAO escritorioDAO;

	@Autowired
	private TipoAcaoDAO tipoAcaoDAO;

	@Autowired
	private FuncaoDAO funcaoDAO;

	@Autowired
	private TribunalDAO tribunalDAO;

	@Autowired
	private FaseProcessualDAO faseDAO;

	@Autowired
	private VaraDAO varaDAO;

	@Autowired
	private PedidoDAO pedidoDAO;

	@Transactional
	@Override
	public void save(Processo entity) {

	}

	@Transactional
	public void salvarPedido(Processo entity) {
		Processo processo = dao.getByProcesso(entity.getNumeroProcesso());

		if (!entity.getPedido().isEmpty()) {
			for (Pedido pedido : entity.getPedido()) {
				pedido.setProcesso(processo);

				try {
					pedidoDAO.save(pedido);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<ProcessoDTO> findAllDTO() {
		return dao.getAllDTO();
	}

	@Override
	public ProcessoDTO findDTO(String processo) {
		return dao.getDTO(processo);
	}

	private <T> T getEntity(BaseDAO<T, Integer> dao, Integer id, String errorMessage) {
		return dao.get(id).orElseThrow(() -> new RuntimeException(errorMessage));
	}

	@Override
	public Boolean salvarProcesso(Processo entity) {

		Escritorio escritorio = getEntity(escritorioDAO, entity.getEscritorio().getIdEscritorio(),
				"Natureza not found");
		Natureza natureza = getEntity(naturezaDAO, entity.getNatureza().getIdNatureza(), "Natureza not found");
		TipoAcao tipoAcao = getEntity(tipoAcaoDAO, entity.getTipoAcao().getIdTipoAcao(), "TipoAcao not found");
		Funcao funcao = getEntity(funcaoDAO, entity.getFuncao().getIdFuncao(), "Funcao not found");
		Tribunal tribunal = getEntity(tribunalDAO, entity.getTribunal().getIdTribunal(), "Tribunal not found");
		FaseProcessual fase = getEntity(faseDAO, entity.getFaseProcessual().getIdFaseProcessual(),
				"Fase Processual not foud");
		Vara vara = getEntity(varaDAO, entity.getVara().getIdVara(), "Vara Processual not foud");

		entity.setEscritorio(escritorio);
		entity.setNatureza(natureza);
		entity.setTipoAcao(tipoAcao);
		entity.setFuncao(funcao);
		entity.setTribunal(tribunal);
		entity.setFaseProcessual(fase);
		entity.setVara(vara);

		try {
			dao.save(entity);
			System.out.println(entity.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Boolean validaProcessoExistente(String processo) {
		return dao.validaProcessoExistente(processo);
	}

	@Override
	@Transactional
	public Processo getByProcesso(String processo) {
		return dao.getByProcesso(processo);
	}

	@Override
	public Boolean editarProcesso(String nrProcesso, Processo processo) {

	    Processo processoExistente = dao.getByProcesso(nrProcesso);

	    if (processoExistente == null) {
	        return null; // Retorna nulo se o processo não foi encontrado
	    }

	    atualizarProcesso(processoExistente, processo);
	    
	    
	    // Obter a lista de pedidos atuais do banco
	    List<Pedido> pedidosAtuais = processoExistente.getPedido();

	    // Nova lista de pedidos enviada
	    List<Pedido> novosPedidos = processo.getPedido();

	    
	    if(!novosPedidos.isEmpty()) {
	    	for (Pedido pedidoAtual : pedidosAtuais) {
	    		boolean pedidoExiste = novosPedidos.stream()
	    				.anyMatch(p -> p.getIdPedido() != null && p.getIdPedido().equals(pedidoAtual.getIdPedido()));
	    		
	    		if (!pedidoExiste) {
	    			// Remove o pedido atual se ele não estiver na nova lista
	    			pedidoDAO.delete(pedidoAtual.getIdPedido());
	    		}
	    	}
	    	
	    	for (Pedido novoPedido : novosPedidos) {
	    		Pedido pedidoExistente = pedidosAtuais.stream()
	    				.filter(p -> (p.getIdPedido() != null && p.getIdPedido().equals(novoPedido.getIdPedido())) ||
	    						(p.getTipoPedido().equals(novoPedido.getTipoPedido()) && 
	    								p.getProcesso().getIdProcesso().equals(processoExistente.getIdProcesso())))
	    				.findFirst().orElse(null);
	    		
	    		if (pedidoExistente != null) {
	    			// Atualiza os campos do pedido existente
//	            pedidoExistente.setCamposPedido(novoPedido.getCamposPedido());
	    			pedidoDAO.save(pedidoExistente);
	    		} else {
	    			// Se for um novo pedido, adicione-o ao processo
	    			novoPedido.setProcesso(processoExistente); // Relaciona o pedido ao processo
	    			pedidoDAO.save(novoPedido);
	    		}
	    	}
	    }

	    try {
	    	dao.save(processoExistente);
	    	return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}
	
	private void atualizarProcesso(Processo existente, Processo novo) {
		
	    existente.setEscritorio(novo.getEscritorio());
	    existente.setNatureza(novo.getNatureza());
	    existente.setTipoAcao(novo.getTipoAcao());
	    existente.setFuncao(novo.getFuncao());
	    existente.setTribunal(novo.getTribunal());
	    existente.setFaseProcessual(novo.getFaseProcessual());
	    existente.setVara(novo.getVara());

	    existente.setAdmissao(novo.getAdmissao());
	    existente.setDemissao(novo.getDemissao());
	    existente.setNumeroProcesso(novo.getNumeroProcesso());
	    existente.setEstado(novo.getEstado());
	    existente.setCidade(novo.getCidade());
	    existente.setReu(novo.getReu());
	    existente.setDataAjuizamento(novo.getDataAjuizamento());
	    existente.setUltimosAndamentosProcessuais(novo.getUltimosAndamentosProcessuais());
	    existente.setValorCausa(novo.getValorCausa());
	    existente.setAutor(novo.getAutor());
	    existente.setValorPerdaEstimado(novo.getValorPerdaEstimado());
	    existente.setReclamada(novo.getReclamada());
	    existente.setClassificacaoRisco(novo.getClassificacaoRisco());
	    existente.setDepositoRecursalOrdinario(novo.getDepositoRecursalOrdinario());
	    existente.setDataDepositoRecursalOrdinario(novo.getDataDepositoRecursalOrdinario());
	    existente.setDepositoRecursalRevista(novo.getDepositoRecursalRevista());
	    existente.setDataDepositoRecursalRevista(novo.getDataDepositoRecursalRevista());
	    existente.setDepositoJudicial(novo.getDepositoJudicial());
	    existente.setDataDepositoJudicial(novo.getDataDepositoJudicial());
	    existente.setBloqueioJudicial(novo.getBloqueioJudicial());
	    existente.setDataBloqueioJudicial(novo.getDataBloqueioJudicial());
	    existente.setLastModificationDate(LocalDateTime.now());
		
	}

}
