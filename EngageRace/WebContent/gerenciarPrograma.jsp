<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Programa</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoesPrograma.js" type="text/javascript"></script>
</head>
	<body>			
		<% 
		Integer id = (Integer) session.getAttribute("id");
		if (id != null) {
		%>		
		<div class="container1">		
			<div>			
				<form action="EngageRaceServlet" method="post">				
					<h1>
						<b>Gerenciar Programa</b>
					</h1>						
					<table border="0">	
						<tr>
							<td>
								<a id="noUnderline" href="engageRace.jsp">Voltar à página inicial</a>
							</td>
						</tr>
						<tr>
							<td style="width: 320px; ">
								<input type="hidden" id="idPrograma" name="idPrograma">
							</td>
						</tr>							
						<tr>
							<td>
								<label for="nomePrograma">Nome:</label>
							</td>
							<td>
								<input type="text" class="nomePrograma" id="nomePrograma" name="nomePrograma">
							</td>					
						</tr>
						<tr>
							<td>Tipo:</td>
							<td>
								<select name="tipoPrograma" id="tipoPrograma">
								</select>
							</td>
						</tr>				
							<tr>
								<td colspan="2" style="text-align:left">
									<input type="button" id="btn_salvarPrograma" name="btn_salvarPrograma" value="Salvar novo programa">
									<input type="button" id="btn_cancelarPrograma" name="btn_cancelarPrograma" value="Cancelar"><br><br><br>
								</td>
							</tr>
							<tr style="text-align:right">
								<td>
									<input type="button" id="btn_mostraTodosProgramas" name="btn_mostraTodosProgramas" value="Mostra Todos">
								</td>
							</tr>				
					</table>
				</form>
			</div>
			<br/>
			<div>			
				<table class="table2">
					<thead>
						<tr class="tr2">
							<td class="td2" width='20%' class='lblTitulo_generico_titulo'>
								<div align='center'>	
									<b>Nome do Programa</b>
								</div>
							</td>		
							<td class="td2" width='20%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Tipo</b>
								</div>
							</td>	
							<td class="td2" width='20%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Ação</b>
								</div>
							</td>		
						</tr>
					</thead>
					<tbody id="cadastroPrograma">
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