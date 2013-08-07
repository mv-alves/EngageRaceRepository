<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Engage Race</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoes.js" type="text/javascript"></script>
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
						<b>Engage Race</b>
					</h1>						
					<table border="0">											
						<tr>
							<td>
								<a id="reload" href="gerenciarPontuacao.jsp">Gerenciar Pontuação</a>
							</td>
						</tr>
						<tr>
							<td>
								<a id="reload" href="gerenciarUsuario.jsp">Gerenciar Usuário</a>
							</td>
						</tr>
						<tr>
							<td>
								<a id="reload" href="gerenciarPrograma.jsp">Gerenciar Programa</a>
							</td>
						</tr>
						<tr>
							<td>
								<a id="reload" href="relatorios.jsp">Relatórios</a>
							</td>
						</tr>
						<tr>
							<td>
								<a id="noUnderline" href="LogoutServlet">Logout</a>
							</td>
						</tr>
					</table>	
				</form>
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