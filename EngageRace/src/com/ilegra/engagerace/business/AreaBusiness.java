package com.ilegra.engagerace.business;

import java.util.ArrayList;
import java.util.List;
import com.ilegra.engagerace.dao.AreaDao;
import com.ilegra.engagerace.dto.AreaDto;
import com.ilegra.engagerace.entity.Area;

public class AreaBusiness {
	
	static AreaDao areaDao= new AreaDao(); 

	public static List<AreaDto> listaAreas() throws Exception{
		List<AreaDto> list = null;
		List<Area> areas = areaDao.listaAreas();

		if (areas != null && areas.size() > 0) {
			for (Area area : areas){
				if (list == null) 
					list = new ArrayList<AreaDto>();
				
				AreaDto dto = new AreaDto();
				dto.setIdArea(area.getIdArea());
				dto.setArea(area.getArea());
				list.add(dto);
			}
		}
		return list;
	}
}