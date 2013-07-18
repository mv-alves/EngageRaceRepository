package com.ilegra.engagerace.business;

import java.util.ArrayList;
import java.util.List;

import com.ilegra.engagerace.dao.ProgramaDao;
import com.ilegra.engagerace.dto.ProgramaDto;
import com.ilegra.engagerace.entity.Programa;

public class ProgramaBusiness {
	
	static ProgramaDao programaDao = new ProgramaDao();

	public static void salvaPrograma(ProgramaDto dto) throws Exception {
		Programa programa = new Programa();	
		programa.setIdPrograma(dto.getIdPrograma());
		programa.setNomePrograma(dto.getNomePrograma());
		programa.setTipoPrograma(dto.getTipoPrograma());

		if (programa.getIdPrograma() != null)
			programaDao.editaPrograma(programa);
		else
			programaDao.salvaPrograma(programa);
	}

	public static void excluiPrograma(ProgramaDto dto)  throws Exception{
		Programa programa = new Programa();
		programa.setIdPrograma(dto.getIdPrograma());
		programaDao.excluiPrograma(programa);
	}

	public static List<ProgramaDto> listaProgramas()  throws Exception{
		List<ProgramaDto> list = null;
		List<Programa> programas = programaDao.pesquisaPrograma();

		if (programas != null && programas.size() > 0) {
			for (Programa programa : programas){
				if (list == null) 
					list = new ArrayList<ProgramaDto>();
				
				ProgramaDto dto = new ProgramaDto();
				dto.setIdPrograma(programa.getIdPrograma());
				dto.setNomePrograma(programa.getNomePrograma());
				dto.setTipoPrograma(programa.getTipoPrograma());
				list.add(dto);
			}
		}
		return list;
	}
}