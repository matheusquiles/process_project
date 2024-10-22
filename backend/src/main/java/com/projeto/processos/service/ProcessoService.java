package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.dto.ProcessoDTO;
import com.projeto.processos.model.Processo;

public interface ProcessoService extends BaseService<Processo, Integer> {
	
	public List<ProcessoDTO> findAllDTO();
	public ProcessoDTO findDTO(String processo);
	public void salvarPedido(Processo entity);
	public Boolean salvarProcesso(Processo entity);
	public Boolean validaProcessoExistente (String processo);
	public Processo getByProcesso(String processo);
	public Boolean editarProcesso(String nrProcesso, Processo processo);

}
