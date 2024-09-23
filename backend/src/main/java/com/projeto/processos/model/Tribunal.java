package com.projeto.processos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tribunal")
public class Tribunal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTribunal;
	private String tribunalOrigem;

	public Tribunal() {
	}

	public Tribunal(int id, String tribunalOrigem) {
		super();
		this.idTribunal = id;
		this.tribunalOrigem = tribunalOrigem;
	}
	

	public Tribunal(int idTribunal) {
		this.idTribunal = idTribunal;
	}

	public int getIdTribunal() {
		return idTribunal;
	}

	public void setIdTribunal(int id) {
		this.idTribunal = id;
	}

	public String getTribunalOrigem() {
		return tribunalOrigem;
	}

	public void setTribunalOrigem(String tribunalOrigem) {
		this.tribunalOrigem = tribunalOrigem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTribunal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tribunal other = (Tribunal) obj;
		return idTribunal == other.idTribunal;
	}
	
	
	
}
