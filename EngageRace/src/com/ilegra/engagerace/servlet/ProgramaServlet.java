package com.ilegra.engagerace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilegra.engagerace.business.ProgramaBusiness;
import com.ilegra.engagerace.dto.ProgramaDto;
import com.ilegra.engagerace.entity.TipoPrograma;
import com.ilegra.engagerace.json.ProgramaJSONConverter;


public class ProgramaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			request.setCharacterEncoding("UTF-8"); 
	        response.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");
	        
			handleRequest(request, response);			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, Exception {
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		
		if (action.equals("salvaPrograma") || action.equals("excluiPrograma")) {
			Integer idPrograma = null;
			String idProg = request.getParameter("idPrograma");

			if (idProg != null && !idProg.equals("")) 
				idPrograma = Integer.parseInt(idProg);

			String nomePrograma = request.getParameter("nomePrograma");
			String tipoPrograma = request.getParameter("tipoPrograma");

			ProgramaDto dto = new ProgramaDto();
			dto.setIdPrograma(idPrograma);			
			dto.setNomePrograma(nomePrograma);
			
			if (action.equals("salvaPrograma")) {
				dto.setTipoPrograma(new TipoPrograma(Integer.parseInt(tipoPrograma)));
				ProgramaBusiness.salvaPrograma(dto);				
			} else 
				ProgramaBusiness.excluiPrograma(dto);
			
		} else if(action.equals("buscaPrograma") || action.equals("carregaPrograma")) {       

			List<ProgramaDto> programas = ProgramaBusiness.listaProgramas(); 
    	    ProgramaJSONConverter converter = new ProgramaJSONConverter();
    	    out.println(converter.toJson(programas));  
		}
	}
}
