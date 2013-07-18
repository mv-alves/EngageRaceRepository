package com.ilegra.engagerace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoPrograma {
	
	@Id
	@SequenceGenerator(name="TipoPrograma_seq", sequenceName="TipoPrograma_seq")	
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TipoPrograma_seq")
	private Integer idTipoPrograma;
	private String tipoPrograma;
	
	
	public Integer getIdTipoPrograma() {
		return idTipoPrograma;
	}

	public void setIdTipoPrograma(Integer idTipoPrograma) {
		this.idTipoPrograma = idTipoPrograma;
	}

	public String getTipoPrograma() {
		return tipoPrograma;
	}

	public void setTipoPrograma(String tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}

	public TipoPrograma(){
		
	}
	
	public TipoPrograma(Integer idTipoPrograma){
		this.idTipoPrograma = idTipoPrograma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTipoPrograma == null) ? 0 : idTipoPrograma.hashCode());
		result = prime * result
				+ ((tipoPrograma == null) ? 0 : tipoPrograma.hashCode());
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
		TipoPrograma other = (TipoPrograma) obj;
		if (idTipoPrograma == null) {
			if (other.idTipoPrograma != null)
				return false;
		} else if (!idTipoPrograma.equals(other.idTipoPrograma))
			return false;
		if (tipoPrograma == null) {
			if (other.tipoPrograma != null)
				return false;
		} else if (!tipoPrograma.equals(other.tipoPrograma))
			return false;
		return true;
	}
}