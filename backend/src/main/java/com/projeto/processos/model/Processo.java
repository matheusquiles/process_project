package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "processo")
public class Processo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProcesso;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "escritorio")
	private Escritorio escritorio;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "natureza")
	private Natureza natureza;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tipo_acao")
	private TipoAcao tipoAcao;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "funcao")
	private Funcao funcao;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tribunal")
	private Tribunal tribunal;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fase_processual")
	private FaseProcessual faseProcessual;
	
    @OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "vara")
	private Vara vara;
	
	private Date admissao;
	private Date demissao;
	private String numeroProcesso;
	private String estado;
	private String cidadeOrigem;
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


	@Transient
	@OneToMany(mappedBy = "processo", orphanRemoval = true, cascade = {jakarta.persistence.CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private List<Pedido> pedido;
	
	public Processo() {
	}
	
	

	public Processo(Escritorio idEscritorio, String reclamada, Natureza idNatureza, String autor, String reu,
			TipoAcao idTipoAcao, Funcao idFuncao, Date admissao, Date demissao, String numeroProcesso,
			Tribunal idTribunal, String estado, String cidadeOrigem, Vara vara, Date dataAjuizamento,
			String ultimosAndamentosProcessuais, FaseProcessual idFaseProcessual, Double valorCausa,
			Double valorPerdaEstimado, String classificacaoRisco, Double depositoRecursoOrdinario,
			Date dataDepositoRecursoOrdinario, Double depositoRecursoRevisao, Date dataDepositoRecursoRevisao,
			Double depositoJudicial, Date dataDepositoJudicial, int bloqueioJudicial, Date dataBloqueioJudicial) {
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
		this.cidadeOrigem = cidadeOrigem;
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
	}
	
	//contrutor sem idProcesso
	public Processo(String reclamada, Natureza idNatureza, String autor, String reu,
			TipoAcao idTipoAcao, Funcao idFuncao, Date admissao, Date demissao, String numeroProcesso,
			Tribunal idTribunal, String estado, String cidadeOrigem, Vara vara, Date dataAjuizamento,
			String ultimosAndamentosProcessuais, FaseProcessual idFaseProcessual, Double valorCausa,
			Double valorPerdaEstimado, String classificacaoRisco, Double depositoRecursoOrdinario,
			Date dataDepositoRecursoOrdinario, Double depositoRecursoRevisao, Date dataDepositoRecursoRevisao,
			Double depositoJudicial, Date dataDepositoJudicial, int bloqueioJudicial, Date dataBloqueioJudicial) {
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
		this.cidadeOrigem = cidadeOrigem;
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
	}



	public int getIdProcesso() {
		return idProcesso;
	}



	public void setIdProcesso(int idProcesso) {
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



	public String getCidadeOrigem() {
		return cidadeOrigem;
	}



	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
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



	public List<Pedido> getPedido() {
		return pedido;
	}



	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
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
				+ ", numeroProcesso=" + numeroProcesso + ", estado=" + estado + ", cidadeOrigem=" + cidadeOrigem
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