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

import com.ilegra.engagerace.business.PontuacaoBusiness;
import com.ilegra.engagerace.business.ProgramaBusiness;
import com.ilegra.engagerace.dto.ProgramaDto;
import com.ilegra.engagerace.entity.TipoPrograma;
import com.ilegra.engagerace.json.ProgramaJSONConverter;




public class ProgramaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProgramaBusiness programaBusiness;
	private PontuacaoBusiness pontuacaoBusiness;
	private WebApplicationContext context;

	@Override
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
		context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		pontuacaoBusiness = (PontuacaoBusiness)context.getBean("pontuacaoBusiness");
		programaBusiness = (ProgramaBusiness)context.getBean("programaBusiness");
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

			Boolean existeRegistro = null;

			if (action.equals("salvaPrograma")) {
				dto.setTipoPrograma(new TipoPrograma(Integer.parseInt(tipoPrograma)));
				programaBusiness.salvaPrograma(dto);
				out.println("Insercao executada com sucesso!");
			} else {
				existeRegistro = pontuacaoBusiness.buscaRegistroPrograma(dto.getIdPrograma());
				if(existeRegistro)
					out.println("A exclusao nao pode ser realizada pois existem registros de Pontuacao com este Programa!");
				else{
					programaBusiness.excluiPrograma(dto);
					out.println("Insercao executada com sucesso!");
				}
			}

		} else if(action.equals("buscaPrograma") || action.equals("carregaPrograma")) {

			List<ProgramaDto> programas = programaBusiness.listaProgramas();
			ProgramaJSONConverter converter = new ProgramaJSONConverter();
			out.println(converter.toJson(programas));
		}
	}
}
