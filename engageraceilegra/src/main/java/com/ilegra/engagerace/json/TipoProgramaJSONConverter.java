package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.TipoProgramaDto;

public class TipoProgramaJSONConverter {

	public String toJson(List<TipoProgramaDto> tipos) {
				StringBuffer sb = new StringBuffer();
				
				sb.append("[");
				
				if (tipos != null && tipos.size() > 0) {
					int size = tipos.size();
					for (int i = 0; i < size; i++) {
						sb.append("{");
						sb.append("\"idTipoPrograma\":");
						sb.append("\"" + tipos.get(i).getIdTipoPrograma() + "\",");
						sb.append("\"tipoPrograma\":");
						sb.append("\"" + tipos.get(i).getTipoPrograma() + "\"");	
						
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
