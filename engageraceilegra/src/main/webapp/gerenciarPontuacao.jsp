<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Pontuação</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoesPontuacao.js" type="text/javascript"></script>
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
						<b>Gerenciar Pontuação</b>
					</h1>						
					<table border="0">					
						<tr>
							<td>
								<a id="noUnderline" href="engageRace.jsp">Voltar à página inicial</a>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" id="idPontuacao" name="idPontuacao">
							</td>
						</tr>
						<tr>
							<td>Usuário:</td>
							<td>
								<select name="usuario" id="usuario">
								</select>
							</td>
						</tr>
						<tr>
							<td>Programa:</td>
							<td>
								<select name="programa" id="programa">
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<label for="data">Data:</label>
							</td>
							<td>
								<input type="text" class="data" id="data" name="data">
							</td>					
						</tr>
						<tr>
							<td>
								<label for="pontuacao">Pontuação:</label>
							</td>
							<td>
								<input type="text" class="pontuacao" id="pontuacao" name="pontuacao">
							</td>					
						</tr>
						<tr>
							<td>
								<label for="bonus">Bônus:</label>
							</td>
							<td>
								<input type="text" class="bonus" id="bonus" name="bonus">
							</td>					
						</tr>
							<tr>
								<td colspan="2" style="text-align:left">
									<input type="button" id="btn_salvarPontuacao" name="btn_salvarPontuacao" value="Salvar">
									<input type="button" id="btn_cancelarPontuacao" name="btn_cancelarPontuacao" value="Cancelar"><br><br><br>
								</td>
							</tr>
					</table>
				</form>
			</div><br><br>
			<br/>
			<div>			
				<table class="table2">
					<thead>
						<tr class="tr2">
							<td class="td2" width='50px' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Nome</b>
								</div>
							</td>		
							<td class="td2" width="50px" class="lblTitulo_generico_titulo">
								<div align="center">
									<b>Programa</b>
								</div>
							</td>
							<td class="td2" width="50px" class="lblTitulo_generico_titulo">
								<div align="center">
									<b>Data</b>
								</div>
							</td>		
							<td class="td2" width="50px" class="lblTitulo_generico_titulo">
								<div align="center">
									<b>Pontuação</b>
								</div>
							</td>	
							<td class="td2" width="50px" class="lblTitulo_generico_titulo">
								<div align="center">
									<b>Bônus</b>
								</div>
							</td>	
							
							<td class="td2" width="50px" class="lblTitulo_generico_titulo">
								<div align="center">
									<b>Ação</b>
								</div>
							</td>
						</tr>
					</thead>
					<tbody id="cadastroPontuacao">
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