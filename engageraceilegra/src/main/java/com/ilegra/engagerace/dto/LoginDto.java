package com.ilegra.engagerace.dto;

public class LoginDto {
	
	private String loginAdmin;
	private String senhaAdmin;
	
	public LoginDto(){
	}

	public String getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getSenhaAdmin() {
		return senhaAdmin;
	}

	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}
}