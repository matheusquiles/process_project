package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vara")
public class Vara implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVara;
	private String vara;
	
	public Vara() {
	}
	
	

	public Vara(Integer idVara) {
		this.idVara = idVara;
	}

	public Vara(Integer id, String vara) {
		super();
		this.idVara = id;
		this.vara = vara;
	}

	public int getId() {
		return idVara;
	}

	public void setId(int id) {
		this.idVara = id;
	}

	public String getVara() {
		return vara;
	}

	public void setVara(String vara) {
		this.vara = vara;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idVara);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vara other = (Vara) obj;
		return idVara == other.idVara;
	}
	
	

}
