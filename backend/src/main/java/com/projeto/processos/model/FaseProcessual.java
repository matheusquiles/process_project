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
	private Integer idFaseProcessual;
	private String faseProcessual;
	
	public FaseProcessual() {
	}

	public FaseProcessual(Integer idFaseProcessual) {
		super();
		this.idFaseProcessual = idFaseProcessual;
	}

	public FaseProcessual(Integer idFaseProcessual, String faseProcessual) {
		super();
		this.idFaseProcessual = idFaseProcessual;
		this.faseProcessual = faseProcessual;
	}

	public Integer getIdFaseProcessual() {
		return idFaseProcessual;
	}

	public void setIdFaseProcessual(Integer idFaseProcessual) {
		this.idFaseProcessual = idFaseProcessual;
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
		return Objects.equals(idFaseProcessual, other.idFaseProcessual);
	}

	@Override
	public String toString() {
		return "FaseProcessual [idFaseProcessual=" + idFaseProcessual + ", faseProcessual=" + faseProcessual + "]";
	}
	
	

}
