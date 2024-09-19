package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_acao")
public class TipoAcao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoAcao;
	private String tipoAcao;
	
	public TipoAcao() {
	}

	public TipoAcao(int id, String tipoAcao) {
		super();
		this.idTipoAcao = id;
		this.tipoAcao = tipoAcao;
	}
	
	public TipoAcao(int id) {
		this.idTipoAcao = id;
	}
	

	public int getId() {
		return idTipoAcao;
	}

	public void setId(int id) {
		this.idTipoAcao = id;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoAcao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAcao other = (TipoAcao) obj;
		return idTipoAcao == other.idTipoAcao;
	}
	
	

}
