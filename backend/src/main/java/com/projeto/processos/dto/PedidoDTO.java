package com.projeto.processos.dto;

public class PedidoDTO {
	
	private Integer idPedido;
	private String processo;
	private String tipoPedido;
	private Boolean pedidoGanhoPrimeiraInstancia;
	private Boolean pedidoGanhoSegundaInstancia;
	private Boolean pedidoGanhoTerceiraInstancia;
	
	public PedidoDTO() {
	}

	public PedidoDTO(Integer idPedido, String processo, String tipoPedido, Boolean pedidoGanhoPrimeiraInstancia,
			Boolean pedidoGanhoSegundaInstancia, Boolean pedidoGanhoTerceiraInstancia) {
		super();
		this.idPedido = idPedido;
		this.processo = processo;
		this.tipoPedido = tipoPedido;
		this.pedidoGanhoPrimeiraInstancia = pedidoGanhoPrimeiraInstancia;
		this.pedidoGanhoSegundaInstancia = pedidoGanhoSegundaInstancia;
		this.pedidoGanhoTerceiraInstancia = pedidoGanhoTerceiraInstancia;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
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
