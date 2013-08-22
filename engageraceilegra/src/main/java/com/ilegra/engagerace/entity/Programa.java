package com.ilegra.engagerace.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PROGRAMA")
public class Programa {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Basic (optional = false)
	@Column (name = "IDPROGRAMA")
	private Integer idPrograma;
	private String nomePrograma;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoPrograma", referencedColumnName="idTipoPrograma")
	private TipoPrograma tipoPrograma;

	public Programa(){
	}

	public Programa(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (idPrograma == null ? 0 : idPrograma.hashCode());
		result = prime * result
				+ (nomePrograma == null ? 0 : nomePrograma.hashCode());
		result = prime * result
				+ (tipoPrograma == null ? 0 : tipoPrograma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programa other = (Programa) obj;
		if (idPrograma == null) {
			if (other.idPrograma != null)
				return false;
		} else if (!idPrograma.equals(other.idPrograma))
			return false;
		if (nomePrograma == null) {
			if (other.nomePrograma != null)
				return false;
		} else if (!nomePrograma.equals(other.nomePrograma))
			return false;
		if (tipoPrograma == null) {
			if (other.tipoPrograma != null)
				return false;
		} else if (!tipoPrograma.equals(other.tipoPrograma))
			return false;
		return true;
	}

	public Integer getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Integer idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

	public TipoPrograma getTipoPrograma() {
		return tipoPrograma;
	}

	public void setTipoPrograma(TipoPrograma tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}
}