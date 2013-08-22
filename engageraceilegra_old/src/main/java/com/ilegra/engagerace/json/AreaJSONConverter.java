package com.ilegra.engagerace.json;

import java.util.List;

import com.ilegra.engagerace.dto.AreaDto;

public class AreaJSONConverter {

	public String toJson(List<AreaDto> areas) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");

		if (areas != null && areas.size() > 0) {
			int size = areas.size();
			for (int i = 0; i < size; i++) {
				sb.append("{");
				sb.append("\"idArea\":");
				sb.append("\"" + areas.get(i).getIdArea() + "\",");
				sb.append("\"area\":");
				sb.append("\"" + areas.get(i).getArea() + "\"");	

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
