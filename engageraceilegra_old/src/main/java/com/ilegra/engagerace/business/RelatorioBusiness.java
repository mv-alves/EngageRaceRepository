package com.ilegra.engagerace.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ilegra.engagerace.dao.RelatorioDao;
import com.ilegra.engagerace.dto.RelatorioDto;

@Component
public class RelatorioBusiness {
	
	@Autowired private RelatorioDao relatorioDao;

	@Transactional(readOnly=true)
	public List<RelatorioDto> rankingPorPrograma(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP)  throws Exception{
		return relatorioDao.rankingPorPrograma(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
	}
	
	@Transactional(readOnly=true)
	public List<RelatorioDto> rankingEngageRace(String usuarioP,	String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
		return relatorioDao.rankingEngageRace(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
	}

	@Transactional(readOnly=true)
	public List<RelatorioDto> historicoUsuario(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
		return relatorioDao.historicoUsuario(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
	}

	public HSSFWorkbook exportaRelatorio(String idTipoRelatorio, String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
				
		List<RelatorioDto> registrosRelatorio = null;
		String nomeRelatorio = null;
		
		Integer tipo = Integer.parseInt(idTipoRelatorio);
		
		if(tipo == 1){
			registrosRelatorio = rankingPorPrograma(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
			nomeRelatorio = "Relat�rio Engage Race";
		}else if (tipo == 2){
			registrosRelatorio = rankingEngageRace(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
			nomeRelatorio = "Ranking Geral Engage Race";
		}else{
			registrosRelatorio = historicoUsuario(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
			nomeRelatorio = "Engage Race - Hist�rico";
		}
					
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(nomeRelatorio);
		int rownum = 0;
		
		if(registrosRelatorio != null && registrosRelatorio.size() > 0){
			Row headerRow = sheet.createRow(rownum++);
			int cellnumH = 0;
			
			if (tipo == 3){
				Cell cellH1 = headerRow.createCell(cellnumH++);
				cellH1.setCellValue("Data");
			}
					
			Cell cellH2 = headerRow.createCell(cellnumH++);
			cellH2.setCellValue("Nome");

			Cell cellH3 = headerRow.createCell(cellnumH++);
			cellH3.setCellValue("�rea");
			
			if(tipo == 1 || tipo == 3){
				Cell cellH4 = headerRow.createCell(cellnumH++);
				cellH4.setCellValue("Programa");
				
				Cell cellH5 = headerRow.createCell(cellnumH++);
				cellH5.setCellValue("Tipo do Programa");
			}
			
			if (tipo == 1){
				Cell cellH6 = headerRow.createCell(cellnumH++);
				cellH6.setCellValue("Ocorr�ncias");
			}
			
			if(tipo == 1 || tipo == 2){
				Cell cellH7 = headerRow.createCell(cellnumH++);
				cellH7.setCellValue("Pontua��o");	
			}
			
			if(tipo == 3){
				Cell cellH8 = headerRow.createCell(cellnumH++);
				cellH8.setCellValue("Pontos");
				
				Cell cellH9 = headerRow.createCell(cellnumH++);
				cellH9.setCellValue("Bonus");
			}
			
			for(RelatorioDto registro : registrosRelatorio){
				Row row = sheet.createRow(rownum++);		
				int cellnum = 0;
				
				if(tipo == 3){
					Cell cell1 = row.createCell(cellnum++);
					cell1.setCellValue((Date)registro.getData());
				}
				
				Cell cell2 = row.createCell(cellnum++);
				cell2.setCellValue((String)registro.getNomeusuario());
				
				Cell cell3 = row.createCell(cellnum++);				
				cell3.setCellValue((String)registro.getArea());
				
				if (tipo == 1 || tipo == 3){
					Cell cell4 = row.createCell(cellnum++);				
					cell4.setCellValue((String)registro.getPrograma());
					
					Cell cell5 = row.createCell(cellnum++);
					cell5.setCellValue((String)registro.getTipoprograma());	
				}
				
				if(tipo == 1){
					Cell cell6 = row.createCell(cellnum++);
					cell6.setCellValue(String.valueOf(registro.getOcorrencias()));
				}
				
				if (tipo == 1 || tipo == 2){
					Cell cell7 = row.createCell(cellnum++);
					cell7.setCellValue(String.valueOf(registro.getTotalpontos()));
				}
				
				if(tipo == 3){
					Cell cell8 = row.createCell(cellnum++);
					cell8.setCellValue(String.valueOf(registro.getPontos()));
					
					Cell cell9 = row.createCell(cellnum++);
					cell9.setCellValue(String.valueOf(registro.getBonus()));
				}
			}
		}
		return workbook;
	}
}
