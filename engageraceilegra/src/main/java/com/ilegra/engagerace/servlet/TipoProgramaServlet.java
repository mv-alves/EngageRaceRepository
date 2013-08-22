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

import com.ilegra.engagerace.business.TipoProgramaBusiness;
import com.ilegra.engagerace.dto.TipoProgramaDto;
import com.ilegra.engagerace.json.TipoProgramaJSONConverter;

public class TipoProgramaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ApplicationContext context;
	private TipoProgramaBusiness tipoProgramaBusiness;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		tipoProgramaBusiness = (TipoProgramaBusiness)factory.getBean("tipoProgramaBusiness");
	}
	
	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException, Exception {

		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		if(action.equals("carregaTipoPrograma")){        	
			List<TipoProgramaDto> tipos = tipoProgramaBusiness.listaTipoPrograma(); 
    	    TipoProgramaJSONConverter converter = new TipoProgramaJSONConverter();
    	    out.println(converter.toJson(tipos));  
		}
	}
}