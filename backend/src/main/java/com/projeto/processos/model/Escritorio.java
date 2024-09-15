package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "escritorio")
public class Escritorio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEscritorio;
	private String nomeEscritorio;
	
	public Escritorio() {
	}

	public Escritorio(int id, String nomeEscritorio) {
		super();
		this.idEscritorio = id;
		this.nomeEscritorio = nomeEscritorio;
	}

	public int getId() {
		return idEscritorio;
	}

	public void setId(int id) {
		this.idEscritorio = id;
	}

	public String getNomeEscritorio() {
		return nomeEscritorio;
	}

	public void setNomeEscritorio(String nomeEscritorio) {
		this.nomeEscritorio = nomeEscritorio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEscritorio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escritorio other = (Escritorio) obj;
		return idEscritorio == other.idEscritorio;
	}

	
}
