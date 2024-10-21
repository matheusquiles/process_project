package com.projeto.processos.dto;

public class PedidoDTO {
	
	private Integer idPedido;
	private Integer idTipoPedido;
	private String processo;
	private String descricao;
	private Boolean pedidoGanhoPrimeiraInstancia;
	private Boolean pedidoGanhoSegundaInstancia;
	private Boolean pedidoGanhoTerceiraInstancia;
	
	public PedidoDTO() {
	}


	public PedidoDTO(Integer idPedido, Integer idTipoPedido, String processo, String descricao,
			Boolean pedidoGanhoPrimeiraInstancia, Boolean pedidoGanhoSegundaInstancia,
			Boolean pedidoGanhoTerceiraInstancia) {
		super();
		this.idPedido = idPedido;
		this.idTipoPedido = idTipoPedido;
		this.processo = processo;
		this.descricao = descricao;
		this.pedidoGanhoPrimeiraInstancia = pedidoGanhoPrimeiraInstancia;
		this.pedidoGanhoSegundaInstancia = pedidoGanhoSegundaInstancia;
		this.pedidoGanhoTerceiraInstancia = pedidoGanhoTerceiraInstancia;
	}

	

	public PedidoDTO(Integer idTipoPedido, String processo, String descricao) {
		super();
		this.idTipoPedido = idTipoPedido;
		this.processo = processo;
		this.descricao = descricao;
	}
	
	

	public PedidoDTO(Integer idTipoPedido, String descricao) {
		super();
		this.idTipoPedido = idTipoPedido;
		this.descricao = descricao;
	}


	public Integer getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}


	public Integer getIdTipoPedido() {
		return idTipoPedido;
	}


	public void setIdTipoPedido(Integer idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}


	public String getProcesso() {
		return processo;
	}


	public void setProcesso(String processo) {
		this.processo = processo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Boolean getPedidoGanhoPrimeiraInstancia() {
		return pedidoGanhoPrimeiraInstancia;
	}


	public void setPedidoGanhoPrimeiraInstancia(Boolean pedidoGanhoPrimeiraInstancia) {
		this.pedidoGanhoPrimeiraInstancia = pedidoGanhoPrimeiraInstancia;
	}


	public Boolean getPedidoGanhoSegundaInstancia() {
		return pedidoGanhoSegundaInstancia;
	}


	public void setPedidoGanhoSegundaInstancia(Boolean pedidoGanhoSegundaInstancia) {
		this.pedidoGanhoSegundaInstancia = pedidoGanhoSegundaInstancia;
	}


	public Boolean getPedidoGanhoTerceiraInstancia() {
		return pedidoGanhoTerceiraInstancia;
	}


	public void setPedidoGanhoTerceiraInstancia(Boolean pedidoGanhoTerceiraInstancia) {
		this.pedidoGanhoTerceiraInstancia = pedidoGanhoTerceiraInstancia;
	}


}
