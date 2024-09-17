package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "natureza")
public class Natureza implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNatureza;
	private String natureza;
	
	public Natureza() {
	}

	public Natureza(int id, String natureza) {
		super();
		this.idNatureza = id;
		this.natureza = natureza;
	}

	public int getId() {
		return idNatureza;
	}

	public void setId(int id) {
		this.idNatureza = id;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNatureza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Natureza other = (Natureza) obj;
		return idNatureza == other.idNatureza;
	}
	
	

}
