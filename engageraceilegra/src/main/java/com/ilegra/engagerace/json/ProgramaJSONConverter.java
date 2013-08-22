package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.ProgramaDto;

public class ProgramaJSONConverter {

	public String toJson(List<ProgramaDto> programas) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");

		if (programas != null && programas.size() > 0) {
			int size = programas.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idPrograma\":");
				sb.append("\"" + programas.get(i).getIdPrograma() + "\",");
				sb.append("\"nomePrograma\":");
				sb.append("\"" + programas.get(i).getNomePrograma() + "\",");	
				sb.append("\"tipoPrograma\":");
				sb.append("\"" + programas.get(i).getTipoPrograma().getTipoPrograma() + "\"");	

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
