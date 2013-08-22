package com.ilegra.engagerace.dto;

import java.util.Date;

import com.ilegra.engagerace.entity.Programa;
import com.ilegra.engagerace.entity.Usuario;

public class PontuacaoDto {
	
	private Integer idPontuacao;
	private Usuario usuario;
	private Programa programa;
	private Date data;
	private Integer pontos;
	private Integer bonus;
	private Integer ocorrencias;
	
	public PontuacaoDto(){
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getIdPontuacao() {
		return idPontuacao;
	}

	public void setIdPontuacao(Integer idPontuacao) {
		this.idPontuacao = idPontuacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontos = pontuacao;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(Integer ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
}