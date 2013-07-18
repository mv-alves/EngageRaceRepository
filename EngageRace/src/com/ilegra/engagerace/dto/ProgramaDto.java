package com.ilegra.engagerace.dto;

import com.ilegra.engagerace.entity.TipoPrograma;

public class ProgramaDto {
	
	private Integer idPrograma;
	private String nomePrograma;
	private TipoPrograma tipoPrograma;
	
	public ProgramaDto(){
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