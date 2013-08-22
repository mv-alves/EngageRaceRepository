<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatórios</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoesRelatorios.js" type="text/javascript"></script>
</head>
	<body>			
		<% 
		Integer id = (Integer) session.getAttribute("id");
		if (id != null) {
		%>		
		<div class="container1">
			<div>			
				<form>				
					<h1>
						<b>Relatórios Engage Race</b>
					</h1>						
					<table border="0" style="width: 416px; ">	
						<tr style="text-align:right">
							<td>
								<a id="noUnderline" href="engageRace.jsp">Voltar à página inicial</a>
							</td>
						</tr>	
						<tr style="width: 668px; ">
							<td>
								<select name="pesquisaPorUsuario" id="pesquisaPorUsuario">
								</select>
							</td>
							<td>
								<select name="pesquisaPorArea" id="pesquisaPorArea">
								</select>
							</td>
							<td>
								<select name="pesquisaPorTipo" id="pesquisaPorTipo">
								</select>
							</td>
							<td>
								<select name="pesquisaPorPrograma" id="pesquisaPorPrograma">
								</select>
							</td>
							</tr>
							<tr>	
								<td>
									<label for="PeriodoP">Período: de</label>
									<input type="text" id="pesquisaPorPeriodoInicio" name="pesquisaPorPeriodoInicio" value="">
								</td>							
								<td>
									<label for="PeriodoP">até:</label>
									<input type="text" id="pesquisaPorPeriodoFim" name="pesquisaPorPeriodoFim" value="">
								</td>		
							</tr>
							<tr>
								<td>
									<input type="button" id="btn_limparFiltros" name="btn_limparFiltros" value="Limpar filtros">
								</td>	
							</tr>
							<tr style="text-align:right">
								<td>
									<input type="button" id="btn_rankingPorPrograma" name="btn_rankingPorPrograma" value="Ranking por Programa">
								</td>
								<td>
									<input type="button" id="btn_rankingEngageRace" name="btn_rankingEngageRace" value="Ranking Engage Race">
								</td>
								<td>
									<input type="button" id="btn_historicoUsuario" name="btn_historicoUsuario" value="Histórico por Usuário">
								</td>
							</tr>
						</table>
					</form>
				</div>
				<br/>
				<div>			
					<table class="table2">
						<thead id="cabecalho">
						</thead>
					<tbody id="relatorio">
					</tbody>			
				</table>
			</div>			
		</div>
		<%
		}else{
		%>
			<h1>
				<b>Acesso Negado!</b>
			</h1>	
				<a id="noUnderline" href="index.jsp">Efetue o login novamente!</a>
		<%
		}
		 %>		
	</body>
</html>
