package com.ilegra.engagerace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ilegra.engagerace.business.ProgramaBusiness;
import com.ilegra.engagerace.dto.ProgramaDto;
import com.ilegra.engagerace.entity.TipoPrograma;
import com.ilegra.engagerace.json.ProgramaJSONConverter;


public class ProgramaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ApplicationContext context;
	private ProgramaBusiness programaBusiness;

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
	
	@Override
	public void init() throws ServletException {
	    context = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/spring-config.xml"));	
		BeanFactory factory = context;
		programaBusiness = (ProgramaBusiness)factory.getBean("programaBusiness");
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
				programaBusiness.salvaPrograma(dto);				
			} else 
				programaBusiness.excluiPrograma(dto);
			
		} else if(action.equals("buscaPrograma") || action.equals("carregaPrograma")) {       

			List<ProgramaDto> programas = programaBusiness.listaProgramas(); 
    	    ProgramaJSONConverter converter = new ProgramaJSONConverter();
    	    out.println(converter.toJson(programas));  
		}
	}
}
