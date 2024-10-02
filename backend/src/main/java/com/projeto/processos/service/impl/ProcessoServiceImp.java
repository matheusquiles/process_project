package com.projeto.processos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.BaseDAO;
import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.dao.FaseProcessualDAO;
import com.projeto.processos.dao.FuncaoDAO;
import com.projeto.processos.dao.NaturezaDAO;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.dao.TipoAcaoDAO;
import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.dao.VaraDAO;
import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.model.FaseProcessual;
import com.projeto.processos.model.Funcao;
import com.projeto.processos.model.Natureza;
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
	

	@Transactional
	@Override
	public void save(Processo entity) {

		 // Carregar as entidades relacionadas do banco de dados
		Escritorio escritorio = getEntity(escritorioDAO, entity.getEscritorio().getIdEscritorio(), "Natureza not found");
        Natureza natureza = getEntity(naturezaDAO, entity.getNatureza().getIdNatureza(), "Natureza not found");
        TipoAcao tipoAcao = getEntity(tipoAcaoDAO, entity.getTipoAcao().getIdTipoAcao(), "TipoAcao not found");
        Funcao funcao = getEntity(funcaoDAO, entity.getFuncao().getIdFuncao(), "Funcao not found");
        Tribunal tribunal = getEntity(tribunalDAO, entity.getTribunal().getIdTribunal(), "Tribunal not found");
        FaseProcessual fase = getEntity(faseDAO, entity.getFaseProcessual().getIdFaseProcessual(), "Fase Processual not foud");
        Vara vara = getEntity(varaDAO, entity.getVara().getIdVara(), "Vara Processual not foud");

        // Associar as entidades carregadas ao Processo
        entity.setEscritorio(escritorio);
        entity.setNatureza(natureza);
        entity.setTipoAcao(tipoAcao);
        entity.setFuncao(funcao);
        entity.setTribunal(tribunal);
        entity.setFaseProcessual(fase);
        entity.setVara(vara);

		dao.save(entity);

	}
	

	@Override
	public List<ProcessoDTO> findAllDTO() {
		return dao.getAllDTO();
	}

	@Override
	public ProcessoDTO findDTO(Integer idProcesso) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private <T> T getEntity(BaseDAO<T, Integer> dao, Integer id, String errorMessage) {
		return dao.get(id).orElseThrow(() -> new RuntimeException(errorMessage));
	}

}
