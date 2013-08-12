<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoesCadastro.js" type="text/javascript"></script>
</head>
	<body>			
		<% 
		Integer id = (Integer) session.getAttribute("id");
		if (id != null) {
		%>		
		<div class="container1">		
			<div>			
				<form action="AdministradorServlet" method="post">				
					<h1>
						<b>Engage Race Administração</b>
					</h1>						
					<table border="0" style="width: 416px; ">		
						<tr style="width: 465px; ">
							<td>
								<label for="cadastroAdministrador">Cadastro de administrador:</label>
							</td>
						</tr>	
						<tr>
							<td>
								<input type="hidden" id="idCadastro" name="idCadastro">
								<input type="hidden" id="action" name="action" value="salvaCadastro">
							</td>
						</tr>	
						<tr>
							<td>
								<label for="cadastroLogin">Login:</label>
							</td>
							<td>
								<input type="text" class="cadastroLogin" id="cadastroLogin" name="cadastroLogin">
							</td>					
						</tr>	
						<tr>
							<td>
								<label for="cadastroSenha">Senha:</label>
							</td>
							<td>
								<input type="password" class="cadastroSenha" id="cadastroSenha" name="cadastroSenha">
							</td>					
						</tr>	
						<tr>
							<td>
								<label for="confirmacaoSenha">Confirmação de Senha:</label>
							</td>
							<td>
								<input type="password" class="confirmacaoSenha" id="confirmacaoSenha" name="confirmacaoSenha">
							</td>					
						</tr>					
						<tr style="text-align:right">
							<td>
								<input type="button" id="btn_submeterCadastro" name="btn_submeterCadastro" value="Submeter">
							</td>
							<td>
								<input type="button" id="btn_cancelar" name="btn_cancelar" value="cancelar">
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
									<b>Nome</b>
								</div>
							</td>		
							<td class="td2" width='20%' class='lblTitulo_generico_titulo'>
								<div align='center'>
									<b>Senha</b>
								</div>
							</td>		
							<td class="td2" width="20%" class="lblTitulo_generico_titulo">
								<div align="center">
									<b>Ação</b>
								</div>
							</td>
						</tr>
					</thead>
					<tbody id="cadastroAdmin">
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