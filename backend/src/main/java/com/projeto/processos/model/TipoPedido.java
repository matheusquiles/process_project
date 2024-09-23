package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_pedido")
public class TipoPedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoPedido;
	private String descricao;
	
	
	public TipoPedido() {
	}
	
	
	public TipoPedido(int idTipoPedido, String descricao) {
		super();
		this.idTipoPedido = idTipoPedido;
		this.descricao = descricao;
	}


	public int getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(int idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTipoPedido);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPedido other = (TipoPedido) obj;
		return idTipoPedido == other.idTipoPedido;
	}
	
}
