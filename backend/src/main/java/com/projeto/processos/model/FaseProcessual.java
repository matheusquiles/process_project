package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fase_processual")
public class FaseProcessual implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFaseProcessual;
	private String faseProcessual;
	
	public FaseProcessual() {
	}

	
	
	public FaseProcessual(int idFaseProcessual) {
		this.idFaseProcessual = idFaseProcessual;
	}


	public FaseProcessual(int id, String faseProcessual) {
		super();
		this.idFaseProcessual = id;
		this.faseProcessual = faseProcessual;
	}

	public int getId() {
		return idFaseProcessual;
	}

	public void setId(int id) {
		this.idFaseProcessual = id;
	}

	public String getFaseProcessual() {
		return faseProcessual;
	}

	public void setFaseProcessual(String faseProcessual) {
		this.faseProcessual = faseProcessual;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFaseProcessual);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaseProcessual other = (FaseProcessual) obj;
		return idFaseProcessual == other.idFaseProcessual;
	}
	
	

}
