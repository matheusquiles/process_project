package com.projeto.processos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.processos.dao.BaseDAO;
import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.dao.FuncaoDAO;
import com.projeto.processos.dao.NaturezaDAO;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.dao.TipoAcaoDAO;
import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.model.Funcao;
import com.projeto.processos.model.Natureza;
import com.projeto.processos.model.Processo;
import com.projeto.processos.model.TipoAcao;
import com.projeto.processos.model.Tribunal;
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
	

	@Transactional
	@Override
	public void save(Processo entity) {

		 // Carregar as entidades relacionadas do banco de dados
		Escritorio escritorio = getEntity(escritorioDAO, entity.getEscritorio().getIdEscritorio(), "Natureza not found");
        Natureza natureza = getEntity(naturezaDAO, entity.getNatureza().getIdNatureza(), "Natureza not found");
        TipoAcao tipoAcao = getEntity(tipoAcaoDAO, entity.getTipoAcao().getIdTipoAcao(), "TipoAcao not found");
        Funcao funcao = getEntity(funcaoDAO, entity.getFuncao().getIdFuncao(), "Funcao not found");
        Tribunal tribunal = getEntity(tribunalDAO, entity.getTribunal().getIdTribunal(), "Tribunal not found");

        // Associar as entidades carregadas ao Processo
        entity.setEscritorio(escritorio);
        entity.setNatureza(natureza);
        entity.setTipoAcao(tipoAcao);
        entity.setFuncao(funcao);
        entity.setTribunal(tribunal);

				
		dao.save(entity);

	}
	
    private <T> T getEntity(BaseDAO<T, Integer> dao, Integer id, String errorMessage) {
        return dao.get(id).orElseThrow(() -> new RuntimeException(errorMessage));
    }
	

}
