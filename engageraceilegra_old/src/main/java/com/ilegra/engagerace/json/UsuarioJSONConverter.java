package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.UsuarioDto;

public class UsuarioJSONConverter {

	public String toJson(List<UsuarioDto> usuarios) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");

		if (usuarios != null && usuarios.size() > 0) {
			int size = usuarios.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idUsuario\":");
				sb.append("\"" + usuarios.get(i).getIdUsuario() + "\","); 
				sb.append("\"nomeUsuario\":");
				sb.append("\"" + usuarios.get(i).getNomeUsuario() + "\",");	
				sb.append("\"areaUsuario\":");
				sb.append("\"" + usuarios.get(i).getArea().getArea() + "\",");	
				sb.append("\"email\":");
				sb.append("\"" + usuarios.get(i).getEmail() + "\"");	

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
