package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.AdministradorDto;

public class AdministradorJSONConverter {
	
	public String toJson(List<AdministradorDto> administradores) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		
		if (administradores != null && administradores.size() > 0) {
			int size = administradores.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idCadastro\":");
				sb.append("\"" + administradores.get(i).getIdAdministrador() + "\",");
				sb.append("\"cadastroLogin\":");
				sb.append("\"" + administradores.get(i).getLogin() + "\",");	
				sb.append("\"cadastroSenha\":");
				sb.append("\"" + administradores.get(i).getSenha() + "\"");	
				
				sb.append("}");

				if (i != (size - 1)) {
					sb.append(",\r\n");
				}
			}
		}		
		
		sb.append("]");		
				
		return sb.toString();
	}

}
