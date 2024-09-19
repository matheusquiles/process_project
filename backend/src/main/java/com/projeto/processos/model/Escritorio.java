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
    private Integer idEscritorio;
    private String nomeEscritorio;

    public Escritorio() {
    }

    public Escritorio(Integer id, String nomeEscritorio) {
        this.idEscritorio = id;
        this.nomeEscritorio = nomeEscritorio;
    }
    
    public Escritorio(Integer id) {
        this.idEscritorio = id;
    }
    
    public Integer getIdEscritorio() {
        return idEscritorio;
    }

    public void setIdEscritorio(Integer idEscritorio) {
        this.idEscritorio = idEscritorio;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Escritorio other = (Escritorio) obj;
        return Objects.equals(idEscritorio, other.idEscritorio);
    }

	
}
