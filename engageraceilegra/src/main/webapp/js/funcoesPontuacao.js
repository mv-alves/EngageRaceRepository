jQuery(document).ready(function() {
	
		$("#data").mask("99/99/9999");  
		carregaPontuacao();
				
		$.post("UsuarioServlet", {
			action: 'carregaUsuario',
			}, function(retorno){
				htmlOutput = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if(obj.length == 0){
					htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
				}else{
					htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
					for(var i = 0; i< obj.length; i++){
						htmlOutput = htmlOutput + "<option value='" + obj[i].idUsuario + "'>" + obj[i].nomeUsuario+ "</option>";
					}
				}

				$('#usuario').html(htmlOutput);
			});
      
		$.post("ProgramaServlet", {
			action: 'carregaPrograma',
			}, function(retorno){
				htmlOutput = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if(obj.length == 0){
					htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
				}else{
					htmlOutput = htmlOutput + "<option value='0'>SELECIONE</option>";
					for(var i = 0; i< obj.length; i++){
						htmlOutput = htmlOutput + "<option value='" + obj[i].idPrograma + "'>" + obj[i].nomePrograma+ "</option>";
					}
				}

				$('#programa').html(htmlOutput);
			});
		
	    $("#btn_salvarPontuacao").click(function() {	     	    	
	       	var idPontuacao = $('#idPontuacao').val();
	       	var usuario = $('#usuario').val();
	       	var programa = $('#programa').val();
	       	var data = $('#data').val();
	       	var pontuacao = $('#pontuacao').val();
	       	var bonus = $('#bonus').val();
	       	
        	var validado = true;
        	var msg = "";
        	var campo = "";
	        	
        	if(usuario == "0"){
        		msg = "Campo 'usuario' é obrigatório!";
        		campo = "usuario";
        		validado = false;
        	}else if(programa == "0"){
        		msg = "Campo 'programa' é obrigatório!";
        		campo = "programa";
        		validado = false;
        	}else if(data == ""){
        		msg = "Campo 'data' é obrigatório!";
        		campo = "data";
        		validado = false;
        	}else if(pontuacao == ""){
        		msg = "Campo 'pontuacao' é obrigatório!";
        		campo = "pontuacao";
        		validado = false;
        	}else if(bonus == ""){
        		msg = "Campo 'bonus' é obrigatório!";
        		campo = "bonus";
        		validado = false;
        	}
	        	
        	if(validado){
        		postPontuacao('salvaPontuacao', idPontuacao, usuario, programa, data, pontuacao, bonus);	    
        		carregaPontuacao(chave);
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	       
	       $("#btn_cancelarPontuacao").click(function(){
	       	  limpaPontuacaoForm();	       	
	       });
		});
	
	function editarPontuacao(idPontuacao, usuario, programa, data, pontuacao, bonus) {
		$('#idPontuacao').val(idPontuacao);
		$("#usuario").find("option:contains(" + usuario + ")").attr('selected', true); 
		$("#programa").find("option:contains(" + programa + ")").attr('selected', true);
		$('#data').val(data);
		$('#pontuacao').val(pontuacao);
		$('#bonus').val(bonus);
	}
	
	function excluirPontuacao(id) {
		postPontuacao('excluiPontuacao', id, null, null, null, null, null);
	}

	function postPontuacao(acao, idPontuacao, usuario, programa, data, pontuacao, bonus) {
		$.post("PontuacaoServlet",{		
		action: acao,
			idPontuacao: idPontuacao,
			usuario: usuario,
			programa: programa,
			data: data,
			pontuacao: pontuacao,
			bonus: bonus
		}, function(retorno) {
		    carregaPontuacao();
		    limpaPontuacaoForm();
			alert('Ação executada com sucesso!');
		});	       					
	}	
	
	function carregaPontuacao() {	
		$.post("PontuacaoServlet", {
			action: 'buscaPontuacao',
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
						htmlOutput = htmlOutput + '<td>' + obj[i].usuario + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].programa + '</td>';
						htmlOutput = htmlOutput + '<td>' + formataData(obj[i].data) + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].pontos + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].bonus + '</td>';
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_excluirPontuacao" value="Excluir" onclick="javascript:excluirPontuacao(' + obj[i].idPontuacao + ')">';
						htmlOutput = htmlOutput + '<input type="button" name="btn_editarPontuacao" value="Editar" onclick="javascript:editarPontuacao(' + obj[i].idPontuacao + ', \'' + obj[i].usuario + '\', \'' + obj[i].programa + '\', \'' + obj[i].data+ '\', \'' + obj[i].pontos+ '\', \'' + obj[i].bonus + '\')">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
				}
				$('#cadastroPontuacao').html(htmlOutput);
			});
	}
	
	function limpaPontuacaoForm(){
		$('#idPontuacao').val("");
       	$('#usuario').val("0");
       	$('#programa').val("0");
        $('#data').val("");
       	$('#pontuacao').val("");
       	$('#bonus').val("");
	}	
	
	function formataData(data){
		var dataArray = data.split('-');
		var ano = dataArray[0];
		var mes = dataArray[1];
		var dia = dataArray[2];
		var diaArray = dia.split(' ');
		var diaFormatado = diaArray[0];
	    return diaFormatado + "/" + mes + "/" + ano;
	}