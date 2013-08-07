package com.ilegra.engagerace.dto;

import java.util.Date;

public class RelatorioDto {
	
	Integer idTipoRelatorio;
	Integer totalPontos;
	String tipoPrograma;
	String programa;
	String nomeUsuario;
	String area;
	Long ocorrencias;
	Integer pontos;
	Integer bonus;
	Date data;
	
	public RelatorioDto() {
	}
	
	public Integer getIdTipoRelatorio() {
		return idTipoRelatorio;
	}

	public void setIdTipoRelatorio(Integer idTipoRelatorio) {
		this.idTipoRelatorio = idTipoRelatorio;
	}

	public Integer getTotalpontos() {
		return totalPontos;
	}

	public void setTotalpontos(Integer totalpontos) {
		this.totalPontos = totalpontos;
	}

	public String getTipoprograma() {
		return tipoPrograma;
	}

	public void setTipoprograma(String tipoprograma) {
		this.tipoPrograma = tipoprograma;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getNomeusuario() {
		return nomeUsuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeUsuario = nomeusuario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(Long ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}