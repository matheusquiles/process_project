package com.projeto.processos.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "id_processo", nullable=false)
	private Processo processo;
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "id_tipo_pedido", nullable=false)
	private TipoPedido tipoPedido;
	
	private Boolean pedidoGanhoPrimeiraInstancia;
	private Boolean pedidoGanhoSegundaInstancia;
	private Boolean pedidoGanhoTerceiraInstancia;
	
	public Pedido() {
	}
	
	
	
	public Pedido(int id, Processo processo, TipoPedido tipoPedido, Boolean pedidoGanhoPrimeiraInstancia,
			Boolean pedidoGanhoSegundaInstancia, Boolean pedidoGanhoTerceiraInstancia) {
		super();
		this.id = id;
		this.processo = processo;
		this.tipoPedido = tipoPedido;
		this.pedidoGanhoPrimeiraInstancia = pedidoGanhoPrimeiraInstancia;
		this.pedidoGanhoSegundaInstancia = pedidoGanhoSegundaInstancia;
		this.pedidoGanhoTerceiraInstancia = pedidoGanhoTerceiraInstancia;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(TipoPedido tipoPedido) {
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id == other.id;
	}
	
	
}
