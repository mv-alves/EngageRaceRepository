package com.ilegra.engagerace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilegra.engagerace.business.PontuacaoBusiness;
import com.ilegra.engagerace.dto.PontuacaoDto;
import com.ilegra.engagerace.entity.Programa;
import com.ilegra.engagerace.entity.Usuario;
import com.ilegra.engagerace.json.PontuacaoJSONConverter;

public class PontuacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException, Exception {
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		if (action.equals("salvaPontuacao") || action.equals("excluiPontuacao")) {
			Integer idPontuacao = null;
			String idPont = request.getParameter("idPontuacao");

			if (idPont != null && !idPont.equals("")) 
				idPontuacao = Integer.parseInt(idPont);
			
			String usuario = request.getParameter("usuario");
			String programa = request.getParameter("programa");
			String data = request.getParameter("data");
	       	String pontuacao = request.getParameter("pontuacao");
	       	String bonus = request.getParameter("bonus");

			PontuacaoDto dto = new PontuacaoDto();
			dto.setIdPontuacao(idPontuacao);			
			dto.setData(data);
						
			if (action.equals("salvaPontuacao")) {
				dto.setUsuario(new Usuario(Integer.parseInt(usuario)));
				dto.setPrograma(new Programa(Integer.parseInt(programa)));
				dto.setPontuacao(Integer.parseInt(pontuacao));
				dto.setBonus(Integer.parseInt(bonus));
				
				PontuacaoBusiness.salvaPontuacao(dto);				
			} else 
				PontuacaoBusiness.excluiPontuacao(dto);
			
		} else if (action.equals("buscaPontuacao")){
			List<PontuacaoDto> pontos = PontuacaoBusiness.listaPontuacao(); 
    	    PontuacaoJSONConverter converter = new PontuacaoJSONConverter();
    	    out.println(converter.toJson(pontos));  
		}
	}
}