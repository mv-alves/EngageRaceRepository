jQuery(document).ready(function() {
	
		limpaProgramaForm();	
		carregaPrograma();
		
		$.post("TipoProgramaServlet", {
			action: 'carregaTipoPrograma',
			}, function(retorno){
				htmlOutput = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if(obj.length == 0){
					htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
				}else{
					htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
					for(var i = 0; i< obj.length; i++){
						htmlOutput = htmlOutput + "<option value='" + obj[i].idTipoPrograma + "'>" + obj[i].tipoPrograma+ "</option>";
					}
				}

				$('#tipoPrograma').html(htmlOutput);
			});
		
	    $("#btn_salvarPrograma").click(function() {	     	    	
	       	var idPrograma = $('#idPrograma').val();
	       	var nomePrograma = $('#nomePrograma').val();
	       	var tipoPrograma = $('#tipoPrograma').val();
    	
        	var validado = true;
        	var msg = "";
        	var campo = "";
	        	
        	if(nomePrograma == ""){
        		msg = "Campo 'nome' é obrigatório!";
        		campo = "nomePrograma";
        		validado = false;
           	}else if(tipoPrograma == "0"){
        		msg = "Campo 'tipo' é obrigatório!";
        		campo = "tipoPrograma";
        		validado = false;
        	}
	        	
        	if(validado){
        		postPrograma('salvaPrograma', idPrograma, nomePrograma, tipoPrograma);	      
        		carregaPrograma();
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	       
	       $("#btn_mostraTodosProgramas").click(function() {
	    	  carregaProgramas();
	       });
	       
	       $("#btn_cancelar").click(function(){
	       	  limpaProgramaForm();	       	
	       });
		});
	
	function editarPrograma(idPrograma, nomePrograma, tipoPrograma) {
		$('#idPrograma').val(idPrograma);
		$('#nomePrograma').val(nomePrograma);
		$("#tipoPrograma").find("option:contains(" + tipoPrograma + ")").attr('selected', true); 
	}
	
	function excluirPrograma(id) {
		postPrograma('excluiPrograma', id, null, null);
	}

	function postPrograma(acao, idPrograma, nomePrograma, tipoPrograma) {
		$.post("ProgramaServlet",{		
		action: acao,
			idPrograma: idPrograma,
			nomePrograma: nomePrograma,
			tipoPrograma: tipoPrograma
		}, function(retorno) {
		    carregaPrograma();
		    limpaProgramaForm();
			alert(retorno);
		});	       					
	}	
	
	function carregaPrograma() {	
		$.post("ProgramaServlet", {
			action: 'buscaPrograma',
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
						htmlOutput = htmlOutput + '<td>' + obj[i].nomePrograma + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].tipoPrograma + '</td>';	
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_excluirPrograma" value="Excluir" onclick="javascript:excluirPrograma(' + obj[i].idPrograma + ')">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_editarPrograma" value="Editar" onclick="javascript:editarPrograma(' + obj[i].idPrograma + ', \'' + obj[i].nomePrograma + '\', \'' + obj[i].tipoPrograma + '\')">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
				}
				$('#cadastroPrograma').html(htmlOutput);
			});
	}
	
	
	function limpaProgramaForm(){
		$('#idPrograma').val("");
       	$('#nomePrograma').val("");
       	$('#tipoPrograma').val("0");
	}	