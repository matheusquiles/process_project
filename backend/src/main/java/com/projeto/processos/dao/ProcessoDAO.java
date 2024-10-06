package com.projeto.processos.dao;

import java.util.List;
import java.util.Optional;

import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Processo;

public interface ProcessoDAO extends BaseDAO<Processo, Integer> {
	Optional<Processo> getByDescription(String processo);
	List<ProcessoDTO> getAllDTO();
	ProcessoDTO getDTO(Integer idProcesso);
	Processo getByProcesso(String processo);

}
