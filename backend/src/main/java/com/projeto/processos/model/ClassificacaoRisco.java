package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classificacao_risco")
public class ClassificacaoRisco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClassificacaoRisco;
	private String classificacaoRisco;
	
	public ClassificacaoRisco() {
	}

	public ClassificacaoRisco(String classificacaoRisco) {
		super();
		this.classificacaoRisco = classificacaoRisco;
	}

	public Integer getIdClassificacaoRisco() {
		return idClassificacaoRisco;
	}

	public void setIdClassificacaoRisco(Integer idClassificacaoRisco) {
		this.idClassificacaoRisco = idClassificacaoRisco;
	}

	public String getClassificacaoRisco() {
		return classificacaoRisco;
	}

	public void setClassificacaoRisco(String classificacaoRisco) {
		this.classificacaoRisco = classificacaoRisco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClassificacaoRisco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassificacaoRisco other = (ClassificacaoRisco) obj;
		return Objects.equals(idClassificacaoRisco, other.idClassificacaoRisco);
	}

	@Override
	public String toString() {
		return "ClassificacaoRisco [idClassificacaoRisco=" + idClassificacaoRisco + ", classificacaoRisco="
				+ classificacaoRisco + "]";
	}


}
