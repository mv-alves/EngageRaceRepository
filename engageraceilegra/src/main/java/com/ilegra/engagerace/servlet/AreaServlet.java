package com.ilegra.engagerace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ilegra.engagerace.business.AreaBusiness;
import com.ilegra.engagerace.dto.AreaDto;
import com.ilegra.engagerace.json.AreaJSONConverter;

public class AreaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PrintWriter out;
	private AreaBusiness areaBusiness;
	private WebApplicationContext context;
	@Override
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
		context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		areaBusiness = (AreaBusiness)context.getBean("areaBusiness");
	}


	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException, Exception{

		out = response.getWriter();
		String action = request.getParameter("action");

		if(action.equals("carregaAreas")){
			List<AreaDto> areas = areaBusiness.listaAreas();
			AreaJSONConverter converter = new AreaJSONConverter();
			out.println(converter.toJson(areas));
		}
	}
}