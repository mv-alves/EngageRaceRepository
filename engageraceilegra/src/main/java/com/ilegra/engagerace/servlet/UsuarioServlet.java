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
import com.ilegra.engagerace.business.UsuarioBusiness;
import com.ilegra.engagerace.dto.UsuarioDto;
import com.ilegra.engagerace.entity.Area;
import com.ilegra.engagerace.json.UsuarioJSONConverter;

public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioBusiness usuarioBusiness;
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
		usuarioBusiness = (UsuarioBusiness)context.getBean("usuarioBusiness");
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, Exception {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");

		if (action.equals("salvarUsuario") || action.equals("excluirUsuario")) {
			Integer idUsuario = null;
			String idUs = request.getParameter("idUsuario");

			if (idUs != null && !idUs.equals(""))
				idUsuario = Integer.parseInt(idUs);

			String nomeUsuario = request.getParameter("nomeUsuario");
			String area = request.getParameter("areaUsuario");
			String email = request.getParameter("email");

			UsuarioDto dto = new UsuarioDto();
			dto.setIdUsuario(idUsuario);
			dto.setNomeUsuario(nomeUsuario);
			dto.setEmail(email);

			Boolean existeRegistro = null;

			if (action.equals("salvarUsuario")) {
				dto.setArea(new Area(Integer.parseInt(area)));
				usuarioBusiness.salvaUsuario(dto);
				out.println("Insercao executada com sucesso!");
			} else
				existeRegistro = pontuacaoBusiness.buscaRegistroUsuario(dto.getIdUsuario());
			if(existeRegistro)
				out.println("A exclusao nao pode ser realizada pois existem registros de Pontuacao com este Usuario!");
			else{
				usuarioBusiness.excluiUsuario(dto);
				out.println("insercao executada com sucesso!");
			}

		} else if(action.equals("buscaUsuario") || action.equals("carregaUsuario")) {

			List<UsuarioDto> usuarios = null;
			if (action.equals("buscaUsuario")){
				String chave = request.getParameter("pesquisaPorUsuario");
				chave = chave == null || chave.equals("null") ? null : chave;
				usuarios = usuarioBusiness.pesquisaUsuario(chave);
			} else
				usuarios = usuarioBusiness.pesquisaUsuario(null);

			UsuarioJSONConverter converter = new UsuarioJSONConverter();

			out.println(converter.toJson(usuarios));
		}
	}
}

