package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Processo;

public interface ProcessoService extends BaseService<Processo, Integer> {
	
	public List<ProcessoDTO> findAllDTO();
	public ProcessoDTO findDTO(Integer idProcesso);

}
