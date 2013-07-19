package com.ilegra.engagerace.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RelatorioDto {
	
	Integer idTipoRelatorio;
	BigDecimal totalpontos;
	String tipoprograma;
	String programa;
	String nomeusuario;
	String area;
	BigInteger ocorrencias;
	Integer pontos;
	Integer bonus;
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

	public BigInteger getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(BigInteger ocorrencias) {
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}