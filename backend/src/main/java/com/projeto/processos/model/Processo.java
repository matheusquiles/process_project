package com.projeto.processos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "processo")
public class Processo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProcesso;
	
    @OneToOne()
	@JoinColumn(name = "escritorio")
	private Escritorio escritorio;
	
    @OneToOne()
	@JoinColumn(name = "natureza")
	private Natureza natureza;
	
    @OneToOne()
	@JoinColumn(name = "tipo_acao")
	private TipoAcao tipoAcao;
	
    @OneToOne()
	@JoinColumn(name = "funcao")
	private Funcao funcao;
	
    @OneToOne()
	@JoinColumn(name = "tribunal")
	private Tribunal tribunal;
	
    @OneToOne()
	@JoinColumn(name = "fase_processual")
	private FaseProcessual faseProcessual;
	
    @OneToOne()
	@JoinColumn(name = "vara")
	private Vara vara;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate admissao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate demissao;
	private String numeroProcesso;
	private String estado;
	private String cidade;
	private String reu;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataAjuizamento;
	private String ultimosAndamentosProcessuais;
	private Double valorCausa;
	private String autor;
	private Double valorPerdaEstimado;
	private String reclamada;
	private String classificacaoRisco;
	private Double depositoRecursalOrdinario;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataDepositoRecursalOrdinario;
	private Double depositoRecursalRevista;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataDepositoRecursalRevista;
	private Double depositoJudicial;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataDepositoJudicial;
	private int bloqueioJudicial;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataBloqueioJudicial;
	 
	private LocalDateTime creationDate;
	private LocalDateTime lastModificationDate;

	@Transient
	private List<Pedido> pedido;
	
	public Processo() {
		this.creationDate = LocalDateTime.now();
		this.lastModificationDate = LocalDateTime.now();
	}
	
	

	public Processo(Escritorio idEscritorio, String reclamada, Natureza idNatureza, String autor, String reu,
			TipoAcao idTipoAcao, Funcao idFuncao, LocalDate admissao, LocalDate demissao, String numeroProcesso,
			Tribunal idTribunal, String estado, String cidade, Vara vara, LocalDate dataAjuizamento,
			String ultimosAndamentosProcessuais, FaseProcessual idFaseProcessual, Double valorCausa,
			Double valorPerdaEstimado, String classificacaoRisco, Double depositoRecursoOrdinario,
			LocalDate dataDepositoRecursoOrdinario, Double depositoRecursoRevisao, LocalDate dataDepositoRecursoRevisao,
			Double depositoJudicial, LocalDate dataDepositoJudicial, int bloqueioJudicial, LocalDate dataBloqueioJudicial) {
		super();
		this.escritorio = idEscritorio;
		this.reclamada = reclamada;
		this.natureza = idNatureza;
		this.autor = autor;
		this.reu = reu;
		this.tipoAcao = idTipoAcao;
		this.funcao = idFuncao;
		this.admissao = admissao;
		this.demissao = demissao;
		this.numeroProcesso = numeroProcesso;
		this.tribunal = idTribunal;
		this.estado = estado;
		this.cidade = cidade;
		this.vara = vara;
		this.dataAjuizamento = dataAjuizamento;
		this.ultimosAndamentosProcessuais = ultimosAndamentosProcessuais;
		this.faseProcessual = idFaseProcessual;
		this.valorCausa = valorCausa;
		this.valorPerdaEstimado = valorPerdaEstimado;
		this.classificacaoRisco = classificacaoRisco;
		this.depositoRecursalOrdinario = depositoRecursoOrdinario;
		this.dataDepositoRecursalOrdinario = dataDepositoRecursoOrdinario;
		this.depositoRecursalRevista = depositoRecursoRevisao;
		this.dataDepositoRecursalRevista = dataDepositoRecursoRevisao;
		this.depositoJudicial = depositoJudicial;
		this.dataDepositoJudicial = dataDepositoJudicial;
		this.bloqueioJudicial = bloqueioJudicial;
		this.dataBloqueioJudicial = dataBloqueioJudicial;
		this.creationDate = LocalDateTime.now();
		this.lastModificationDate = LocalDateTime.now();
	}
	
	//contrutor sem idProcesso
	public Processo(String reclamada, Natureza idNatureza, String autor, String reu,
			TipoAcao idTipoAcao, Funcao idFuncao, LocalDate admissao, LocalDate demissao, String numeroProcesso,
			Tribunal idTribunal, String estado, String cidade, Vara vara, LocalDate dataAjuizamento,
			String ultimosAndamentosProcessuais, FaseProcessual idFaseProcessual, Double valorCausa,
			Double valorPerdaEstimado, String classificacaoRisco, Double depositoRecursoOrdinario,
			LocalDate dataDepositoRecursoOrdinario, Double depositoRecursoRevisao, LocalDate dataDepositoRecursoRevisao,
			Double depositoJudicial, LocalDate dataDepositoJudicial, int bloqueioJudicial, LocalDate dataBloqueioJudicial) {
		this.reclamada = reclamada;
		this.natureza = idNatureza;
		this.autor = autor;
		this.reu = reu;
		this.tipoAcao = idTipoAcao;
		this.funcao = idFuncao;
		this.admissao = admissao;
		this.demissao = demissao;
		this.numeroProcesso = numeroProcesso;
		this.tribunal = idTribunal;
		this.estado = estado;
		this.cidade = cidade;
		this.vara = vara;
		this.dataAjuizamento = dataAjuizamento;
		this.ultimosAndamentosProcessuais = ultimosAndamentosProcessuais;
		this.faseProcessual = idFaseProcessual;
		this.valorCausa = valorCausa;
		this.valorPerdaEstimado = valorPerdaEstimado;
		this.classificacaoRisco = classificacaoRisco;
		this.depositoRecursalOrdinario = depositoRecursoOrdinario;
		this.dataDepositoRecursalOrdinario = dataDepositoRecursoOrdinario;
		this.depositoRecursalRevista = depositoRecursoRevisao;
		this.dataDepositoRecursalRevista = dataDepositoRecursoRevisao;
		this.depositoJudicial = depositoJudicial;
		this.dataDepositoJudicial = dataDepositoJudicial;
		this.bloqueioJudicial = bloqueioJudicial;
		this.dataBloqueioJudicial = dataBloqueioJudicial;
		this.creationDate = LocalDateTime.now();
		this.lastModificationDate = LocalDateTime.now();
	}
	

	public Processo(Integer idProcesso, Escritorio escritorio, Natureza natureza, TipoAcao tipoAcao, Funcao funcao,
			Tribunal tribunal, FaseProcessual faseProcessual, Vara vara, LocalDate admissao, LocalDate demissao,
			String numeroProcesso, String estado, String cidade, String reu, LocalDate dataAjuizamento,
			String ultimosAndamentosProcessuais, Double valorCausa, String autor, Double valorPerdaEstimado,
			String reclamada, String classificacaoRisco, Double depositoRecursalOrdinario,
			LocalDate dataDepositoRecursalOrdinario, Double depositoRecursalRevista, LocalDate dataDepositoRecursalRevista,
			Double depositoJudicial, LocalDate dataDepositoJudicial, int bloqueioJudicial, LocalDate dataBloqueioJudicial,
			List<Pedido> pedido) {
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
		this.cidade = cidade;
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
		this.creationDate = LocalDateTime.now();
		this.lastModificationDate = LocalDateTime.now();
	}



	public Integer getIdProcesso() {
		return idProcesso;
	}



	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}



	public Escritorio getEscritorio() {
		return escritorio;
	}



	public void setEscritorio(Escritorio escritorio) {
		this.escritorio = escritorio;
	}



	public Natureza getNatureza() {
		return natureza;
	}



	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}



	public TipoAcao getTipoAcao() {
		return tipoAcao;
	}



	public void setTipoAcao(TipoAcao tipoAcao) {
		this.tipoAcao = tipoAcao;
	}



	public Funcao getFuncao() {
		return funcao;
	}



	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}



	public Tribunal getTribunal() {
		return tribunal;
	}



	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}



	public FaseProcessual getFaseProcessual() {
		return faseProcessual;
	}



	public void setFaseProcessual(FaseProcessual faseProcessual) {
		this.faseProcessual = faseProcessual;
	}



	public Vara getVara() {
		return vara;
	}



	public void setVara(Vara vara) {
		this.vara = vara;
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


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getReu() {
		return reu;
	}



	public void setReu(String reu) {
		this.reu = reu;
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





	public Double getDepositoRecursalRevista() {
		return depositoRecursalRevista;
	}



	public void setDepositoRecursalRevista(Double depositoRecursalRevista) {
		this.depositoRecursalRevista = depositoRecursalRevista;
	}




	public Double getDepositoJudicial() {
		return depositoJudicial;
	}



	public void setDepositoJudicial(Double depositoJudicial) {
		this.depositoJudicial = depositoJudicial;
	}





	public int getBloqueioJudicial() {
		return bloqueioJudicial;
	}



	public void setBloqueioJudicial(int bloqueioJudicial) {
		this.bloqueioJudicial = bloqueioJudicial;
	}




	public List<Pedido> getPedido() {
		return pedido == null ? Collections.emptyList() : pedido ;
	}

	
	public LocalDate getAdmissao() {
		return admissao;
	}



	public void setAdmissao(LocalDate admissao) {
		this.admissao = admissao;
	}



	public LocalDate getDemissao() {
		return demissao;
	}



	public void setDemissao(LocalDate demissao) {
		this.demissao = demissao;
	}



	public LocalDate getDataAjuizamento() {
		return dataAjuizamento;
	}



	public void setDataAjuizamento(LocalDate dataAjuizamento) {
		this.dataAjuizamento = dataAjuizamento;
	}



	public LocalDate getDataDepositoRecursalOrdinario() {
		return dataDepositoRecursalOrdinario;
	}



	public void setDataDepositoRecursalOrdinario(LocalDate dataDepositoRecursalOrdinario) {
		this.dataDepositoRecursalOrdinario = dataDepositoRecursalOrdinario;
	}



	public LocalDate getDataDepositoRecursalRevista() {
		return dataDepositoRecursalRevista;
	}



	public void setDataDepositoRecursalRevista(LocalDate dataDepositoRecursalRevista) {
		this.dataDepositoRecursalRevista = dataDepositoRecursalRevista;
	}



	public LocalDate getDataDepositoJudicial() {
		return dataDepositoJudicial;
	}



	public void setDataDepositoJudicial(LocalDate dataDepositoJudicial) {
		this.dataDepositoJudicial = dataDepositoJudicial;
	}



	public LocalDate getDataBloqueioJudicial() {
		return dataBloqueioJudicial;
	}



	public void setDataBloqueioJudicial(LocalDate dataBloqueioJudicial) {
		this.dataBloqueioJudicial = dataBloqueioJudicial;
	}



	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}






	public LocalDateTime getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}



	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}



	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
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



	@Override
	public String toString() {
		return "Processo [idProcesso=" + idProcesso + ", escritorio=" + escritorio + ", natureza=" + natureza
				+ ", tipoAcao=" + tipoAcao + ", funcao=" + funcao + ", tribunal=" + tribunal + ", faseProcessual="
				+ faseProcessual + ", vara=" + vara + ", admissao=" + admissao + ", demissao=" + demissao
				+ ", numeroProcesso=" + numeroProcesso + ", estado=" + estado + ", cidade=" + cidade
				+ ", reu=" + reu + ", dataAjuizamento=" + dataAjuizamento + ", ultimosAndamentosProcessuais="
				+ ultimosAndamentosProcessuais + ", valorCausa=" + valorCausa + ", autor=" + autor
				+ ", valorPerdaEstimado=" + valorPerdaEstimado + ", reclamada=" + reclamada + ", classificacaoRisco="
				+ classificacaoRisco + ", depositoRecursalOrdinario=" + depositoRecursalOrdinario
				+ ", dataDepositoRecursalOrdinario=" + dataDepositoRecursalOrdinario + ", depositoRecursalRevista="
				+ depositoRecursalRevista + ", dataDepositoRecursalRevista=" + dataDepositoRecursalRevista
				+ ", depositoJudicial=" + depositoJudicial + ", dataDepositoJudicial=" + dataDepositoJudicial
				+ ", bloqueioJudicial=" + bloqueioJudicial + ", dataBloqueioJudicial=" + dataBloqueioJudicial
				+ ", pedido=" + pedido + "]";
	}





}