package com.ilegra.engagerace.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ilegra.engagerace.business.RelatorioBusiness;
import com.ilegra.engagerace.dto.RelatorioDto;
import com.ilegra.engagerace.json.RelatorioJSONConverter;

public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RelatorioBusiness relatorioBusiness;
	private ApplicationContext context;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			handleRequest(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			handleRequest(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		context = new FileSystemXmlApplicationContext(getServletContext().getRealPath("/WEB-INF/spring-config.xml"));
		BeanFactory factory = context;
		relatorioBusiness = (RelatorioBusiness)factory.getBean("relatorioBusiness");
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, Exception {
		String action = request.getParameter("action");

		if (action.equals("rankingPorPrograma")){
			String usuarioP = request.getParameter("pesquisaPorUsuario");
			String areaP = request.getParameter("pesquisaPorArea");
			String programaP = request.getParameter("pesquisaPorPrograma");
			String tipoP = request.getParameter("pesquisaPorTipo");
			String periodoInicioP = request.getParameter("pesquisaPorPeriodoInicio");
			String periodoFimP = request.getParameter("pesquisaPorPeriodoFim");

			List<RelatorioDto> relatorio = relatorioBusiness.rankingPorPrograma(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);

			RelatorioJSONConverter converter = new RelatorioJSONConverter();
			PrintWriter out = response.getWriter();
			out.println(converter.toJsonRankingPorPrograma(relatorio));

		} else if(action.equals("rankingEngageRace")) {
			String usuarioP = request.getParameter("pesquisaPorUsuario");
			String areaP = request.getParameter("pesquisaPorArea");
			String programaP = request.getParameter("pesquisaPorPrograma");
			String tipoP = request.getParameter("pesquisaPorTipo");
			String periodoInicioP = request.getParameter("pesquisaPorPeriodoInicio");
			String periodoFimP = request.getParameter("pesquisaPorPeriodoFim");

			List<RelatorioDto> relatorio = relatorioBusiness.rankingEngageRace(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);

			RelatorioJSONConverter converter = new RelatorioJSONConverter();
			PrintWriter out = response.getWriter();
			out.println(converter.toJsonRankingGeral(relatorio));

		} else if(action.equals("historicoUsuario")){
			String usuarioP = request.getParameter("pesquisaPorUsuario");
			String areaP = request.getParameter("pesquisaPorArea");
			String programaP = request.getParameter("pesquisaPorPrograma");
			String tipoP = request.getParameter("pesquisaPorTipo");
			String periodoInicioP = request.getParameter("pesquisaPorPeriodoInicio");
			String periodoFimP = request.getParameter("pesquisaPorPeriodoFim");

			List<RelatorioDto> relatorio = relatorioBusiness.historicoUsuario(usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);

			RelatorioJSONConverter converter = new RelatorioJSONConverter();
			PrintWriter out = response.getWriter();
			out.println(converter.toJsonHistoricoUsuario(relatorio));

		}else if(action.equals("Relatorio")){
			String idTipoRelatorio = request.getParameter("idTipoRelatorio");
			String usuarioP = request.getParameter("pesquisaPorUsuario");
			String areaP = request.getParameter("pesquisaPorArea");
			String programaP = request.getParameter("pesquisaPorPrograma");
			String tipoP = request.getParameter("pesquisaPorTipo");
			String periodoInicioP = request.getParameter("pesquisaPorPeriodoInicio");
			String periodoFimP = request.getParameter("pesquisaPorPeriodoFim");

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			HSSFWorkbook workbook = relatorioBusiness.exportaRelatorio(idTipoRelatorio, usuarioP, areaP, periodoInicioP, periodoFimP, programaP, tipoP);
			workbook.write(baos);

			int contentLength = baos.size();

			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			response.setHeader("Content-Transfer-Encoding", "none");
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-type", "application/x-msexcel");
			response.setHeader("Content-Length", String.valueOf(contentLength));
			response.setHeader("Content-Disposition", "attachment; filename=relatorio_engage_race.xls");

			OutputStream os = response.getOutputStream();
			os.write(baos.toByteArray());
			os.flush();
		}
	}
}
