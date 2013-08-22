<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">		
<script src="js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput-1.3.js" type="text/javascript"></script>		
<script src="js/funcoesLogin.js" type="text/javascript"></script>
</head>
	<body>			
		<div class="container1">		
			<div>			
				<form action="EngageRaceServlet" method="post">				
					<h1>
						<b>Engage Race Administração</b>
					</h1>						
					<table border="0" style="width: 416px; ">		
						<tr>
							<td>
								<label for="loginAdmin">Login:</label>
							</td>
							<td>
								<input type="text" class="loginAdmin" id="loginAdmin" name="loginAdmin">
							</td>					
						</tr>	
						<tr>
							<td>
								<label for="senhaAdmin">Senha:</label>
							</td>
							<td>
								<input type="password" class="senhaAdmin" id="senhaAdmin" name="senhaAdmin">
							</td>					
						</tr>					
						<tr style="text-align:right">
							<td colspan="2">
								<input type="button" id="btn_submeterLogin" name="btn_submeterLogin" value="Submeter">
							</td>
						</tr>										
					</table>	
				</form>
			</div>
		</div>
	</body>
</html>