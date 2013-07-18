package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.PontuacaoDto;

public class PontuacaoJSONConverter {

	public String toJson(List<PontuacaoDto> pontos) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");

		
		if (pontos != null && pontos.size() > 0) {
			int size = pontos.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idPontuacao\":");
				sb.append("\"" + pontos.get(i).getIdPontuacao() + "\",");
				sb.append("\"usuario\":");
				sb.append("\"" + pontos.get(i).getUsuario().getNomeUsuario() + "\",");	
				sb.append("\"programa\":");
				sb.append("\"" + pontos.get(i).getPrograma().getNomePrograma() + "\",");
				sb.append("\"data\":");
				sb.append("\"" + pontos.get(i).getData() + "\",");
				sb.append("\"pontos\":");
				sb.append("\"" + pontos.get(i).getPontos() + "\",");
				sb.append("\"bonus\":");
				sb.append("\"" + pontos.get(i).getBonus() + "\"");	

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
