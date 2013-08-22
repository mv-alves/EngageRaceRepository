package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.RelatorioDto;

public class RelatorioJSONConverter {

	public String toJsonRankingPorPrograma(List<RelatorioDto> r) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");
		
		if (r != null && r.size() > 0) {
			int size = r.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idTipoRelatorio\":");
				sb.append("\"" + 1 + "\",");
				sb.append("\"usuario\":");
				sb.append("\"" + r.get(i).getNomeusuario() + "\",");
				sb.append("\"area\":");
				sb.append("\"" + r.get(i).getArea() + "\",");	
				sb.append("\"programa\":");
				sb.append("\"" + r.get(i).getPrograma() + "\",");
				sb.append("\"tipoPrograma\":");
				sb.append("\"" + r.get(i).getTipoprograma() + "\",");
				sb.append("\"ocorrencias\":");
				sb.append("\"" + r.get(i).getOcorrencias() + "\",");
				sb.append("\"totalPontuacao\":");
				sb.append("\"" + r.get(i).getTotalpontos() + "\"");	

				sb.append("}");

				if (i != (size - 1)) {
					sb.append(",\r\n");
				}
			}
		}		

		sb.append("]");		

		return sb.toString();
	}

	public String toJsonRankingGeral(List<RelatorioDto> r) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");
		
		if (r != null && r.size() > 0) {
			int size = r.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idTipoRelatorio\":");
				sb.append("\"" + 2 + "\",");
				sb.append("\"usuario\":");
				sb.append("\"" + r.get(i).getNomeusuario() + "\",");
				sb.append("\"area\":");
				sb.append("\"" + r.get(i).getArea() + "\",");	
				sb.append("\"totalPontuacao\":");
				sb.append("\"" + r.get(i).getTotalpontos() + "\"");	

				sb.append("}");

				if (i != (size - 1)) {
					sb.append(",\r\n");
				}
			}
		}		

		sb.append("]");		

		return sb.toString();

	}

	public String toJsonHistoricoUsuario(List<RelatorioDto> r) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");
		
		if (r != null && r.size() > 0) {
			int size = r.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idTipoRelatorio\":");
				sb.append("\"" + 3 + "\",");
				sb.append("\"usuario\":");
				sb.append("\"" + r.get(i).getNomeusuario() + "\",");
				sb.append("\"area\":");
				sb.append("\"" + r.get(i).getArea() + "\",");	
				sb.append("\"programa\":");
				sb.append("\"" + r.get(i).getPrograma() + "\",");
				sb.append("\"tipoPrograma\":");
				sb.append("\"" + r.get(i).getTipoprograma() + "\",");
				sb.append("\"pontos\":");
				sb.append("\"" + r.get(i).getPontos() + "\",");
				sb.append("\"bonus\":");
				sb.append("\"" + r.get(i).getBonus() + "\",");
				sb.append("\"data\":");
				sb.append("\"" + r.get(i).getData() + "\"");	

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
