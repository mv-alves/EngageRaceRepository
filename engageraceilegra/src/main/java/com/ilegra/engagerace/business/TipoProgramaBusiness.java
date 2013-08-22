package com.ilegra.engagerace.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ilegra.engagerace.dao.TipoProgramaDao;
import com.ilegra.engagerace.dto.TipoProgramaDto;
import com.ilegra.engagerace.entity.TipoPrograma;

@Component
public class TipoProgramaBusiness {
	
	@Autowired private TipoProgramaDao tipoProgramaDao;
	
	@Transactional (readOnly=true)
	public List<TipoProgramaDto> listaTipoPrograma()  throws Exception{
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
