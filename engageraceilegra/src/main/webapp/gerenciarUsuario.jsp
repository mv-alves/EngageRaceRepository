<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Usuário</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoesUsuario.js" type="text/javascript"></script>
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
						<b>Gerenciar Usuário</b>
					</h1>						
					<table border="0" style="width: 416px;">
						<tr style="text-align:right">
							<td>
								<a id="noUnderline" href="engageRace.jsp">Voltar à página inicial</a>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" id="idUsuario" name="idUsuario">
							</td>
						</tr>							
						<tr>
							<td>
								<label for="nomeUsuario">Nome:</label>
							</td>
							<td>
								<input type="text" class="nomeUsuario" id="nomeUsuario" name="nomeUsuario">
							</td>					
						</tr>
						<tr>
							<td>Área:</td>
							<td>
								<select name="areaUsuario" id="areaUsuario">
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<label for="email">e-mail:</label>
							</td>
							<td>
								<input type="text" class="email" id="email" name="email">
							</td>					
						</tr>
							<tr>
								<td colspan="2" style="text-align:left">
								<input type="button" id="btn_salvarUsuario" name="btn_salvarUsuario" value="Salvar">
								<input type="button" id="btn_cancelarUsuario" name="btn_cancelarUsuario" value="Cancelar"><br><br><br>
								</td>
							</tr>
							<tr style="text-align:right">
								<td>
									<input type="button" id="btn_mostraTodosUsuarios" name="btn_mostraTodosUsuarios" value="Mostra Todos">
								</td>
							</tr>
						<tr style="text-align:right">
							<td>
								<input type="text" id="pesquisaPorUsuario" name="pesquisaPorUsuario" value="Pesquisar...">
							</td>
							<td>
								<input type="button" id="btn_pesquisarPorUsuario" name="btn_pesquisarPorUsuario" value="Pesquisar por usuário">
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
							<td class="td2" width='16%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Nome</b>
								</div>
							</td>		
							<td class="td2" width='16%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Área</b>
								</div>
							</td>	
							<td class="td2" width='16%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>e-mail</b>
								</div>
							</td>									
							<td class="td2" width='12%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Ação</b>
								</div>
							</td>		
						</tr>
					</thead>
					<tbody id="cadastroUsuario">					
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