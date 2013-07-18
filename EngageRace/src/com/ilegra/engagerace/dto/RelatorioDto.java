package com.ilegra.engagerace.dto;

import java.math.BigDecimal;

public class RelatorioDto {
	
	Integer idTipoRelatorio;
	BigDecimal totalpontos;
	String tipoprograma;
	String programa;
	String nomeusuario;
	String area;
	BigDecimal ocorrencias;
	BigDecimal pontos;
	BigDecimal bonus;
	String data;
	
	public RelatorioDto() {
	}
	
	public Integer getIdTipoRelatorio() {
		return idTipoRelatorio;
	}

	public void setIdTipoRelatorio(Integer idTipoRelatorio) {
		this.idTipoRelatorio = idTipoRelatorio;
	}

	public BigDecimal getTotalpontos() {
		return totalpontos;
	}

	public void setTotalpontos(BigDecimal totalpontos) {
		this.totalpontos = totalpontos;
	}

	public String getTipoprograma() {
		return tipoprograma;
	}

	public void setTipoprograma(String tipoprograma) {
		this.tipoprograma = tipoprograma;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(BigDecimal ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public BigDecimal getPontos() {
		return pontos;
	}

	public void setPontos(BigDecimal pontos) {
		this.pontos = pontos;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}