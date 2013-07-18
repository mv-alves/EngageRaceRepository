package com.ilegra.engagerace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilegra.engagerace.business.LoginBusiness;
import com.ilegra.engagerace.dto.LoginDto;

public class LoginServlet extends HttpServlet{
	
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
		String action = request.getParameter("action");
		
		PrintWriter out = response.getWriter();
		
		if (action.equals("confirmaLogin")) {

			String login = request.getParameter("loginAdmin");
			String senha = request.getParameter("senhaAdmin");
			
			LoginDto dto = new LoginDto();
			dto.setLoginAdmin(login);
			dto.setSenhaAdmin(senha);
			
			Integer id = LoginBusiness.confirmaLogin(dto);

			if (id != null){
				HttpSession session = request.getSession();

				session.setAttribute("id", id);
				session.setAttribute("login", login);

				out.print("engageRace.jsp");
			}else
				out.print("acessoNegado.jsp");
		} 
	}
}