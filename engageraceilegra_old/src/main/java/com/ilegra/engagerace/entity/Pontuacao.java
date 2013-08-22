package com.ilegra.engagerace.entity;

import java.util.Date;

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
@Table (name = "PONTUACAO")
public class Pontuacao {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Basic (optional = false)
	@Column (name = "IDPONTUACAO")
	private Integer idPontuacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Usuario", referencedColumnName="idUsuario")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Programa", referencedColumnName="idPrograma")
	private Programa programa;
	
	private Date data;
	private Integer pontos;
	private Integer bonus;
		
	public Pontuacao(){
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

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
}