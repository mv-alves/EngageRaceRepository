package com.ilegra.engagerace.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
	"idCadastro",
	"cadastroLogin",
	"cadastroSenha"
})

public class AdministradorDto {	
	
	@XmlElement(name="idCadastro")
	private Integer idAdministrador;
	
	@XmlElement(name="cadastroLogin")
	private String login;
	
	@XmlElement(name="cadastroSenha")
	private String senha;
	
	public AdministradorDto(){
	}
	
	public Integer getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
