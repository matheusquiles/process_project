package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcao")
public class Funcao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFuncao;
	private String funcao;
	
	public Funcao() {
	}

	public Funcao(int id, String funcao) {
		super();
		this.idFuncao = id;
		this.funcao = funcao;
	}

	public Funcao(int id) {
		this.idFuncao = id;
	}
	
	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int id) {
		this.idFuncao = id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFuncao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcao other = (Funcao) obj;
		return idFuncao == other.idFuncao;
	}

	
	
}
