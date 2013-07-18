jQuery(document).ready(function() {
	
	limpaUsuarioForm();
	carregaUsuario();
	
	$.post("AreaServlet", {
		action: 'carregaAreas',
		}, function(retorno){
			htmlOutput = '';
			
			var obj = jQuery.parseJSON(retorno);
			
			if(obj.length == 0){
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
			}else{
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
				for(var i = 0; i< obj.length; i++){
					htmlOutput = htmlOutput + "<option value='" + obj[i].idArea + "'>" + obj[i].area+ "</option>";
				}
			}

			$('#areaUsuario').html(htmlOutput);
		});
		        
	    $("#btn_salvarUsuario").click(function() {	     	    	
	       	var idUsuario = $('#idUsuario').val();
	       	var nomeUsuario = $('#nomeUsuario').val();
	       	var areaUsuario = $('#areaUsuario').val();
	       	var email = $('#email').val();
    	
        	var validado = true;
        	var msg = "";
        	var campo = "";
	        	
        	if(nomeUsuario == ""){
        		msg = "Campo 'nome' é obrigatório!";
        		campo = "nomeUsuario";
        		validado = false;
           	}else if(areaUsuario == "0"){
        		msg = "Campo 'área' é obrigatório!";
        		campo = "areaUsuario";
        		validado = false;
        	}else if(email == ""){
        		msg = "Campo 'e-mail' é obrigatório!";
        		campo = "email";
        		validado = false;
        	}
	        	
        	if(validado){
        		postUsuario('salvarUsuario', idUsuario, nomeUsuario, areaUsuario, email);	        	
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	       
	       $("#btn_pesquisarPorUsuario").click(function() {
	    	   var chave = $('#pesquisaPorUsuario').val();
	    	   buscaUsuario(chave);
	       });
	       
	       $("#btn_mostraTodosUsuarios").click(function() {
	    	  carregaUsuario();
	       });
	       
	       $("#btn_cancelarUsuario").click(function(){
	       	  limpaUsuarioForm();	       	
	       });
		});
	
	function editarUsuario(id, nome, area, email) {
		$('#idUsuario').val(id);
		$('#nomeUsuario').val(nome);
		$("#areaUsuario").find("option:contains(" + area + ")").attr('selected', true); 
		$('#email').val(email);
	}
	
	function excluirUsuario(id) {
		postUsuario('excluirUsuario', id, null, null, null);
	}

	function postUsuario(acao, idUsuario, nomeUsuario, areaUsuario, email) {
		$.post("UsuarioServlet",{		
		action: acao,
			idUsuario: idUsuario,
			nomeUsuario: nomeUsuario,
			areaUsuario: areaUsuario,
			email: email
		}, function(retorno) {
		    carregaUsuario();
		    limpaUsuarioForm();
			alert('Ação executada com sucesso!');
		});	       					
	}	
	
	function carregaUsuario() {	
		$.post("UsuarioServlet", {
			action: 'carregaUsuario',
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
						htmlOutput = htmlOutput + '<td>' + obj[i].nomeUsuario + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].areaUsuario + '</td>';	
						htmlOutput = htmlOutput + '<td>' + obj[i].email + '</td>';
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_excluirUsuario" value="Excluir" onclick="javascript:excluirUsuario(' + obj[i].idUsuario + ')">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_editarUsuario" value="Editar" onclick="javascript:editarUsuario(' + obj[i].idUsuario + ', \'' + obj[i].nomeUsuario + '\', \'' + obj[i].areaUsuario + '\', \'' + obj[i].email + '\')">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
				}
				$('#cadastroUsuario').html(htmlOutput);
			});
	}
	
	function buscaUsuario(chave) {	
		$.post("UsuarioServlet", {
			action: 'buscaUsuario',
			pesquisaPorUsuario: chave
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
						htmlOutput = htmlOutput + '<td>' + obj[i].nomeUsuario + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].areaUsuario + '</td>';	
						htmlOutput = htmlOutput + '<td>' + obj[i].email + '</td>';
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_excluirUsuario" value="Excluir" onclick="javascript:excluirUsuario(' + obj[i].idUsuario + ')">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_editarUsuario" value="Editar" onclick="javascript:editarUsuario(' + obj[i].idUsuario + ', \'' + obj[i].nomeUsuario + '\', \'' + obj[i].areaUsuario + '\', \'' + obj[i].email + '\')">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
				}
				$('#cadastroUsuario').html(htmlOutput);
			});
	}
	
	function limpaUsuarioForm(){
		$('#idUsuario').val("");
       	$('#nomeUsuario').val("");
       	$('#areaUsuario').val("0");
        $('#email').val("");
	}	