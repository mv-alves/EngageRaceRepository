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

import com.ilegra.engagerace.business.AdministradorBusiness;
import com.ilegra.engagerace.dto.AdministradorDto;
import com.ilegra.engagerace.json.AdministradorJSONConverter;

public class AdministradorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PrintWriter out;
	private AdministradorBusiness administradorBusiness;
	private ApplicationContext context;


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
			administradorBusiness = (AdministradorBusiness)factory.getBean("adminBusiness");
		}
		
		private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, Exception {
			out = response.getWriter();

			String action = request.getParameter("action");
			
			if (action.equals("salvaCadastro") || action.equals("excluiCadastro")) {
				Integer idAdministrador = null;
				String idAdmin = request.getParameter("idCadastro");

				if (idAdmin != null && !idAdmin.equals("")) 
					idAdministrador = Integer.parseInt(idAdmin);
				
				String login = request.getParameter("cadastroLogin");
				String senha = request.getParameter("cadastroSenha");

				AdministradorDto dto = new AdministradorDto();
				dto.setIdAdministrador(idAdministrador);			
				dto.setLogin(login);
				dto.setSenha(senha);
				
				if (action.equals("salvaCadastro")) 
					administradorBusiness.salvaAdministrador(dto);				
				else 
					administradorBusiness.excluiAdministrador(dto);
				
			} else if(action.equals("buscaCadastro")) {       

				List<AdministradorDto> administradores = administradorBusiness.listaAdminstrador(); 
	    	    AdministradorJSONConverter converter = new AdministradorJSONConverter();
	    	    out.println(converter.toJson(administradores));        		
			} 
		}
	}