package com.projeto.processos.dto;

import java.util.Date;
import java.util.List;

public class ProcessoDTO {
	
	private int idProcesso;
	private Integer escritorio;
	private Integer natureza;
	private Integer tipoAcao;
	private Integer funcao;
	private Integer tribunal;
	private Integer faseProcessual;
	private Integer vara;
	
	private Date admissao;
	private Date demissao;
	private String numeroProcesso;
	private String estado;
	private String cidade;
	private String reu;
	private Date dataAjuizamento;
	private String ultimosAndamentosProcessuais;
	private Double valorCausa;
	private String autor;
	private Double valorPerdaEstimado;
	private String reclamada;
	private String classificacaoRisco;
	private Double depositoRecursalOrdinario;
	private Date dataDepositoRecursalOrdinario;
	private Double depositoRecursalRevista;
	private Date dataDepositoRecursalRevista;
	private Double depositoJudicial;
	private Date dataDepositoJudicial;
	private int bloqueioJudicial;
	private Date dataBloqueioJudicial;


	private List<PedidoDTO> pedido;
	
	public ProcessoDTO() {
	}

	
	

	public ProcessoDTO(int idProcesso, Integer escritorio, Integer natureza, Integer tipoAcao, Integer funcao,
			Integer tribunal, Integer faseProcessual, Integer vara, Date admissao, Date demissao, String numeroProcesso,
			String estado, String cidadeOrigem, String reu, Date dataAjuizamento, String ultimosAndamentosProcessuais,
			Double valorCausa, String autor, Double valorPerdaEstimado, String reclamada, String classificacaoRisco,
			Double depositoRecursalOrdinario, Date dataDepositoRecursalOrdinario, Double depositoRecursalRevista,
			Date dataDepositoRecursalRevista, Double depositoJudicial, Date dataDepositoJudicial, int bloqueioJudicial,
			Date dataBloqueioJudicial, List<PedidoDTO> pedido) {
		super();
		this.idProcesso = idProcesso;
		this.escritorio = escritorio;
		this.natureza = natureza;
		this.tipoAcao = tipoAcao;
		this.funcao = funcao;
		this.tribunal = tribunal;
		this.faseProcessual = faseProcessual;
		this.vara = vara;
		this.admissao = admissao;
		this.demissao = demissao;
		this.numeroProcesso = numeroProcesso;
		this.estado = estado;
		this.cidade = cidadeOrigem;
		this.reu = reu;
		this.dataAjuizamento = dataAjuizamento;
		this.ultimosAndamentosProcessuais = ultimosAndamentosProcessuais;
		this.valorCausa = valorCausa;
		this.autor = autor;
		this.valorPerdaEstimado = valorPerdaEstimado;
		this.reclamada = reclamada;
		this.classificacaoRisco = classificacaoRisco;
		this.depositoRecursalOrdinario = depositoRecursalOrdinario;
		this.dataDepositoRecursalOrdinario = dataDepositoRecursalOrdinario;
		this.depositoRecursalRevista = depositoRecursalRevista;
		this.dataDepositoRecursalRevista = dataDepositoRecursalRevista;
		this.depositoJudicial = depositoJudicial;
		this.dataDepositoJudicial = dataDepositoJudicial;
		this.bloqueioJudicial = bloqueioJudicial;
		this.dataBloqueioJudicial = dataBloqueioJudicial;
		this.pedido = pedido;
	}




	public ProcessoDTO(int idProcesso, Integer escritorio, Integer natureza, Integer tipoAcao, Integer funcao,
			Integer tribunal, Integer faseProcessual, Integer vara, Date admissao, Date demissao, String numeroProcesso,
			String estado, String cidadeOrigem, String reu, Date dataAjuizamento, String ultimosAndamentosProcessuais,
			Double valorCausa, String autor, Double valorPerdaEstimado, String reclamada, String classificacaoRisco,
			Double depositoRecursalOrdinario, Date dataDepositoRecursalOrdinario, Double depositoRecursalRevista,
			Date dataDepositoRecursalRevista, Double depositoJudicial, Date dataDepositoJudicial, int bloqueioJudicial,
			Date dataBloqueioJudicial) {
		super();
		this.idProcesso = idProcesso;
		this.escritorio = escritorio;
		this.natureza = natureza;
		this.tipoAcao = tipoAcao;
		this.funcao = funcao;
		this.tribunal = tribunal;
		this.faseProcessual = faseProcessual;
		this.vara = vara;
		this.admissao = admissao;
		this.demissao = demissao;
		this.numeroProcesso = numeroProcesso;
		this.estado = estado;
		this.cidade = cidadeOrigem;
		this.reu = reu;
		this.dataAjuizamento = dataAjuizamento;
		this.ultimosAndamentosProcessuais = ultimosAndamentosProcessuais;
		this.valorCausa = valorCausa;
		this.autor = autor;
		this.valorPerdaEstimado = valorPerdaEstimado;
		this.reclamada = reclamada;
		this.classificacaoRisco = classificacaoRisco;
		this.depositoRecursalOrdinario = depositoRecursalOrdinario;
		this.dataDepositoRecursalOrdinario = dataDepositoRecursalOrdinario;
		this.depositoRecursalRevista = depositoRecursalRevista;
		this.dataDepositoRecursalRevista = dataDepositoRecursalRevista;
		this.depositoJudicial = depositoJudicial;
		this.dataDepositoJudicial = dataDepositoJudicial;
		this.bloqueioJudicial = bloqueioJudicial;
		this.dataBloqueioJudicial = dataBloqueioJudicial;
	}

	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	
	

	public Integer getEscritorio() {
		return escritorio;
	}




	public void setEscritorio(Integer escritorio) {
		this.escritorio = escritorio;
	}




	public Integer getNatureza() {
		return natureza;
	}




	public void setNatureza(Integer natureza) {
		this.natureza = natureza;
	}




	public Integer getTipoAcao() {
		return tipoAcao;
	}




	public void setTipoAcao(Integer tipoAcao) {
		this.tipoAcao = tipoAcao;
	}




	public Integer getFuncao() {
		return funcao;
	}




	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}




	public Integer getTribunal() {
		return tribunal;
	}




	public void setTribunal(Integer tribunal) {
		this.tribunal = tribunal;
	}




	public Integer getFaseProcessual() {
		return faseProcessual;
	}




	public void setFaseProcessual(Integer faseProcessual) {
		this.faseProcessual = faseProcessual;
	}




	public Integer getVara() {
		return vara;
	}




	public void setVara(Integer vara) {
		this.vara = vara;
	}




	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public Date getDemissao() {
		return demissao;
	}

	public void setDemissao(Date demissao) {
		this.demissao = demissao;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidadeOrigem) {
		this.cidade = cidadeOrigem;
	}

	public String getReu() {
		return reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public Date getDataAjuizamento() {
		return dataAjuizamento;
	}

	public void setDataAjuizamento(Date dataAjuizamento) {
		this.dataAjuizamento = dataAjuizamento;
	}

	public String getUltimosAndamentosProcessuais() {
		return ultimosAndamentosProcessuais;
	}

	public void setUltimosAndamentosProcessuais(String ultimosAndamentosProcessuais) {
		this.ultimosAndamentosProcessuais = ultimosAndamentosProcessuais;
	}

	public Double getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(Double valorCausa) {
		this.valorCausa = valorCausa;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getValorPerdaEstimado() {
		return valorPerdaEstimado;
	}

	public void setValorPerdaEstimado(Double valorPerdaEstimado) {
		this.valorPerdaEstimado = valorPerdaEstimado;
	}

	public String getReclamada() {
		return reclamada;
	}

	public void setReclamada(String reclamada) {
		this.reclamada = reclamada;
	}

	public String getClassificacaoRisco() {
		return classificacaoRisco;
	}

	public void setClassificacaoRisco(String classificacaoRisco) {
		this.classificacaoRisco = classificacaoRisco;
	}

	public Double getDepositoRecursalOrdinario() {
		return depositoRecursalOrdinario;
	}

	public void setDepositoRecursalOrdinario(Double depositoRecursalOrdinario) {
		this.depositoRecursalOrdinario = depositoRecursalOrdinario;
	}

	public Date getDataDepositoRecursalOrdinario() {
		return dataDepositoRecursalOrdinario;
	}

	public void setDataDepositoRecursalOrdinario(Date dataDepositoRecursalOrdinario) {
		this.dataDepositoRecursalOrdinario = dataDepositoRecursalOrdinario;
	}

	public Double getDepositoRecursalRevista() {
		return depositoRecursalRevista;
	}

	public void setDepositoRecursalRevista(Double depositoRecursalRevista) {
		this.depositoRecursalRevista = depositoRecursalRevista;
	}

	public Date getDataDepositoRecursalRevista() {
		return dataDepositoRecursalRevista;
	}

	public void setDataDepositoRecursalRevista(Date dataDepositoRecursalRevista) {
		this.dataDepositoRecursalRevista = dataDepositoRecursalRevista;
	}

	public Double getDepositoJudicial() {
		return depositoJudicial;
	}

	public void setDepositoJudicial(Double depositoJudicial) {
		this.depositoJudicial = depositoJudicial;
	}

	public Date getDataDepositoJudicial() {
		return dataDepositoJudicial;
	}

	public void setDataDepositoJudicial(Date dataDepositoJudicial) {
		this.dataDepositoJudicial = dataDepositoJudicial;
	}

	public int getBloqueioJudicial() {
		return bloqueioJudicial;
	}

	public void setBloqueioJudicial(int bloqueioJudicial) {
		this.bloqueioJudicial = bloqueioJudicial;
	}

	public Date getDataBloqueioJudicial() {
		return dataBloqueioJudicial;
	}

	public void setDataBloqueioJudicial(Date dataBloqueioJudicial) {
		this.dataBloqueioJudicial = dataBloqueioJudicial;
	}

	public List<PedidoDTO> getPedido() {
		return pedido;
	}

	public void setPedido(List<PedidoDTO> pedido) {
		this.pedido = pedido;
	}
	
	
	
	
	

}
