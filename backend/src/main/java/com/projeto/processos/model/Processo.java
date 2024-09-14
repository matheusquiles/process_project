package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "processo")
public class Processo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProcesso;
	private int idEscritorio;
	private String reclamada;
	private int idNatureza;
	private String autor;
	private String reu;
	private int idTipoAcao;
	private int idFuncao;
	private Date admissao;
	private Date demissao;
	private String numeroProcesso;
	private int idTribunal;
	private String estado;
	private String cidadeOrigem;
	private int vara;
	private Date dataAjuizamento;
	private String ultimosAndamentosProcessuais;
	private int idFaseProcessual;
	private Double valorCausa;
	private Double valorPerdaEstimado;
	private String classificacaoRisco;
	private Double depositoRecursoOrdinario;
	private Date dataDepositoRecursoOrdinario;
	private Double depositoRecursoRevisao;
	private Date dataDepositoRecursoRevisao;
	private Double depositoJudicial;
	private Date dataDepositoJudicial;
	private int bloqueioJudicial;
	private Date dataBloqueioJudicial;


	@OneToMany(mappedBy = "processo", orphanRemoval = true, cascade = {jakarta.persistence.CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private List<Pedido> pedido;
	
	public Processo() {
	}
	
	

	public Processo(int idProcesso, int idEscritorio, String reclamada, int idNatureza, String autor, String reu,
			int idTipoAcao, int idFuncao, Date admissao, Date demissao, String numeroProcesso, int idTribunal,
			String estado, String cidadeOrigem, int vara, Date dataAjuizamento, String ultimosAndamentosProcessuais,
			int idFaseProcessual, Double valorCausa, Double valorPerdaEstimado, String classificacaoRisco,
			Double depositoRecursoOrdinario, Date dataDepositoRecursoOrdinario, Double depositoRecursoRevisao,
			Date dataDepositoRecursoRevisao, Double depositoJudicial, Date dataDepositoJudicial, int bloqueioJudicial,
			Date dataBloqueioJudicial) {
		super();
		this.idProcesso = idProcesso;
		this.idEscritorio = idEscritorio;
		this.reclamada = reclamada;
		this.idNatureza = idNatureza;
		this.autor = autor;
		this.reu = reu;
		this.idTipoAcao = idTipoAcao;
		this.idFuncao = idFuncao;
		this.admissao = admissao;
		this.demissao = demissao;
		this.numeroProcesso = numeroProcesso;
		this.idTribunal = idTribunal;
		this.estado = estado;
		this.cidadeOrigem = cidadeOrigem;
		this.vara = vara;
		this.dataAjuizamento = dataAjuizamento;
		this.ultimosAndamentosProcessuais = ultimosAndamentosProcessuais;
		this.idFaseProcessual = idFaseProcessual;
		this.valorCausa = valorCausa;
		this.valorPerdaEstimado = valorPerdaEstimado;
		this.classificacaoRisco = classificacaoRisco;
		this.depositoRecursoOrdinario = depositoRecursoOrdinario;
		this.dataDepositoRecursoOrdinario = dataDepositoRecursoOrdinario;
		this.depositoRecursoRevisao = depositoRecursoRevisao;
		this.dataDepositoRecursoRevisao = dataDepositoRecursoRevisao;
		this.depositoJudicial = depositoJudicial;
		this.dataDepositoJudicial = dataDepositoJudicial;
		this.bloqueioJudicial = bloqueioJudicial;
		this.dataBloqueioJudicial = dataBloqueioJudicial;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idProcesso);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		return idProcesso == other.idProcesso;
	}



	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public int getIdEscritorio() {
		return idEscritorio;
	}

	public void setIdEscritorio(int idEscritorio) {
		this.idEscritorio = idEscritorio;
	}

	public String getReclamada() {
		return reclamada;
	}

	public void setReclamada(String reclamada) {
		this.reclamada = reclamada;
	}

	public int getIdNatureza() {
		return idNatureza;
	}

	public void setIdNatureza(int idNatureza) {
		this.idNatureza = idNatureza;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getReu() {
		return reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public int getIdTipoAcao() {
		return idTipoAcao;
	}

	public void setIdTipoAcao(int idTipoAcao) {
		this.idTipoAcao = idTipoAcao;
	}

	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
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

	public int getIdTribunal() {
		return idTribunal;
	}

	public void setIdTribunal(int idTribunal) {
		this.idTribunal = idTribunal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public int getVara() {
		return vara;
	}

	public void setVara(int vara) {
		this.vara = vara;
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

	public int getIdFaseProcessual() {
		return idFaseProcessual;
	}

	public void setIdFaseProcessual(int idFaseProcessual) {
		this.idFaseProcessual = idFaseProcessual;
	}

	public Double getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(Double valorCausa) {
		this.valorCausa = valorCausa;
	}

	public Double getValorPerdaEstimado() {
		return valorPerdaEstimado;
	}

	public void setValorPerdaEstimado(Double valorPerdaEstimado) {
		this.valorPerdaEstimado = valorPerdaEstimado;
	}

	public String getClassificacaoRisco() {
		return classificacaoRisco;
	}

	public void setClassificacaoRisco(String classificacaoRisco) {
		this.classificacaoRisco = classificacaoRisco;
	}

	public Double getDepositoRecursoOrdinario() {
		return depositoRecursoOrdinario;
	}

	public void setDepositoRecursoOrdinario(Double depositoRecursoOrdinario) {
		this.depositoRecursoOrdinario = depositoRecursoOrdinario;
	}

	public Date getDataDepositoRecursoOrdinario() {
		return dataDepositoRecursoOrdinario;
	}

	public void setDataDepositoRecursoOrdinario(Date dataDepositoRecursoOrdinario) {
		this.dataDepositoRecursoOrdinario = dataDepositoRecursoOrdinario;
	}

	public Double getDepositoRecursoRevisao() {
		return depositoRecursoRevisao;
	}

	public void setDepositoRecursoRevisao(Double depositoRecursoRevisao) {
		this.depositoRecursoRevisao = depositoRecursoRevisao;
	}

	public Date getDataDepositoRecursoRevisao() {
		return dataDepositoRecursoRevisao;
	}

	public void setDataDepositoRecursoRevisao(Date dataDepositoRecursoRevisao) {
		this.dataDepositoRecursoRevisao = dataDepositoRecursoRevisao;
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
	
	

}