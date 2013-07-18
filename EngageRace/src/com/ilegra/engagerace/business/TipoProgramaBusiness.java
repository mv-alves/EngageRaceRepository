package com.ilegra.engagerace.business;

import java.util.ArrayList;
import java.util.List;

import com.ilegra.engagerace.dao.TipoProgramaDao;
import com.ilegra.engagerace.dto.TipoProgramaDto;
import com.ilegra.engagerace.entity.TipoPrograma;

public class TipoProgramaBusiness {
	
	static TipoProgramaDao tipoProgramaDao= new TipoProgramaDao(); 

	public static List<TipoProgramaDto> listaTipoPrograma()  throws Exception{
		List<TipoProgramaDto> list = null;
		List<TipoPrograma> tipos = tipoProgramaDao.listaTipoPrograma();

		if (tipos != null && tipos.size() > 0) {
			for (TipoPrograma tipo : tipos){
				if (list == null) 
					list = new ArrayList<TipoProgramaDto>();
				
				TipoProgramaDto dto = new TipoProgramaDto();
				dto.setIdTipoPrograma(tipo.getIdTipoPrograma());
				dto.setTipoPrograma(tipo.getTipoPrograma());
				list.add(dto);
			}
		}
		return list;
	}
}
