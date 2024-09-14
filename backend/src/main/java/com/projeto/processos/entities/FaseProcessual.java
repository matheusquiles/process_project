package com.projeto.processos.entities;

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
	private int id;
	private String faseProcessual;
	
	public FaseProcessual() {
	}

	public FaseProcessual(int id, String faseProcessual) {
		super();
		this.id = id;
		this.faseProcessual = faseProcessual;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFaseProcessual() {
		return faseProcessual;
	}

	public void setFaseProcessual(String faseProcessual) {
		this.faseProcessual = faseProcessual;
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
		FaseProcessual other = (FaseProcessual) obj;
		return id == other.id;
	}
	
	

}
