jQuery(document).ready(function() {
		        
		carregaCadastro();
		
	    $("#btn_submeterCadastro").click(function() {	     	    	
	       	var idCadastro = $('#idCadastro').val();
	       	var cadastroLogin = $('#cadastroLogin').val();
	       	var cadastroSenha = $('#cadastroSenha').val();
	       	var confirmacaoSenha = $('#confirmacaoSenha').val();
    	
        	var validado = true;
        	var msg = "";
        	var campo = "";
	        	
        	if(cadastroLogin == ""){
        		msg = "Campo 'login' é obrigatório!";
        		campo = "cadastroLogin";
        		validado = false;
           	}else if(cadastroSenha == ""){
        		msg = "Campo 'senha' é obrigatório!";
        		campo = "cadastroSenha";
        		validado = false;
        	}else if(confirmacaoSenha == ""){
        		msg = "Campo 'confirmação de senha' é obrigatório!";
        		campo = "confirmacaoSenha";
        		validado = false;
        	}else if(cadastroSenha != confirmacaoSenha){
        		msg = "A senha digitada não corresponde à senha previamente informada!";
        		campo = "confirmacaoSenha";
        		validado = false;
        	}
	        	
        	if(validado){
        		postCadastro('salvaCadastro', idCadastro, cadastroLogin, cadastroSenha, confirmacaoSenha);	 
        		carregaCadastro();
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	       
	       $("#btn_cancelar").click(function(){
	       	  limpaCadastroForm();	       	
	       });
		});
	
	function editarCadastro(idCadastro, cadastroLogin, cadastroSenha, confirmacaoSenha) {
	 	$('#idCadastro').val(idCadastro);
		$('#cadastroLogin').val(cadastroLogin);
		$('#cadastroSenha').val(cadastroSenha);
		$('#confirmacaoSenha').val(confirmacaoSenha);
	}
	
	function excluirCadastro(id) {
		postCadastro('excluiCadastro', id, null, null);
	}

	function postCadastro(acao, idCadastro, cadastroLogin, cadastroSenha, confirmacaoSenha) {
		$.post("AdministradorServlet",{		
		action: acao,
			idCadastro: idCadastro,
			cadastroLogin: cadastroLogin,
			cadastroSenha: cadastroSenha,
			confirmacaoSenha: confirmacaoSenha
		}, function(retorno) {
		    carregaCadastro();
		    limpaCadastroForm();
			alert('Ação executada com sucesso!');
		});	       					
	}	
	
	function carregaCadastro() {	
		$.post("AdministradorServlet", {
			action: 'buscaCadastro',
			}, function(retorno){
				
				htmlOutput = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if (obj.length == 0) {
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td colspan="5">Nenhum registro encontrado!</td>';
						htmlOutput = htmlOutput + '</tr>';					
				} else {
					for (var i = 0; i < obj.length; i++) {
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td>' + obj[i].cadastroLogin + '</td>';	
						htmlOutput = htmlOutput + '<td>' + obj[i].cadastroSenha + '</td>';	
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_excluirCadastro" value="Excluir" onclick="javascript:excluirCadastro(' + obj[i].idCadastro + ')">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_editarCadastro" value="Editar" onclick="javascript:editarCadastro(' + obj[i].idCadastro + ', \'' + obj[i].cadastroLogin + '\', \'' + obj[i].cadastroSenha + '\')">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
				}
				$('#cadastroAdmin').html(htmlOutput);
			});
	}
	
	function limpaCadastroForm(){
		$('#idCadastro').val("");
       	$('#cadastroLogin').val("");
       	$('#cadastroSenha').val("");
        $('#confirmacaoSenha').val("");
	}	