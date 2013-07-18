jQuery(document).ready(function() {
	
	limpaFiltros();
	$("#pesquisaPorPeriodoInicio").mask("99/99/9999");
	$("#pesquisaPorPeriodoFim").mask("99/99/9999");
	
	 $("#btn_limparFiltros").click(function() {
		 limpaFiltros();
     });
	 
	 $("#btn_gerarRelatorio").click(function() {
		 exportaRelatorio();
     });
	 
	$.post("UsuarioServlet", {
		action: 'carregaUsuario',
		}, function(retorno){
			htmlOutput = '';
			
			var obj = jQuery.parseJSON(retorno);
			
			if(obj.length == 0){
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE O USUARIO</option>";
			}else{
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE O USUARIO</option>";
				for(var i = 0; i< obj.length; i++){
					htmlOutput = htmlOutput + "<option value='" + obj[i].idUsuario + "'>" + obj[i].nomeUsuario+ "</option>";
				}
			}

			$('#pesquisaPorUsuario').html(htmlOutput);
		});
	
	$.post("AreaServlet", {
		action: 'carregaAreas',
		}, function(retorno){
			htmlOutput = '';
			
			var obj = jQuery.parseJSON(retorno);
			
			if(obj.length == 0){
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE A ÁREA</option>";
			}else{
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE A ÁREA</option>";
				for(var i = 0; i< obj.length; i++){
					htmlOutput = htmlOutput + "<option value='" + obj[i].idArea + "'>" + obj[i].area+ "</option>";
				}
			}

			$('#pesquisaPorArea').html(htmlOutput);
		});
	
	$.post("TipoProgramaServlet", {
		action: 'carregaTipoPrograma',
		}, function(retorno){
			htmlOutput = '';
			
			var obj = jQuery.parseJSON(retorno);
			
			if(obj.length == 0){
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE O TIPO</option>";
			}else{
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE O TIPO</option>";
				for(var i = 0; i< obj.length; i++){
					htmlOutput = htmlOutput + "<option value='" + obj[i].idTipoPrograma + "'>" + obj[i].tipoPrograma+ "</option>";
				}
			}

			$('#pesquisaPorTipo').html(htmlOutput);
		});
	
	$.post("ProgramaServlet", {
		action: 'carregaPrograma',
		}, function(retorno){
			htmlOutput = '';
			
			var obj = jQuery.parseJSON(retorno);
			
			if(obj.length == 0){
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE O PROGRAMA</option>";
			}else{
				htmlOutput = htmlOutput + "<option value='0'>SELECIONE O PROGRAMA</option>";
				for(var i = 0; i< obj.length; i++){
					htmlOutput = htmlOutput + "<option value='" + obj[i].idPrograma + "'>" + obj[i].nomePrograma+ "</option>";
				}
			}

			$('#pesquisaPorPrograma').html(htmlOutput);
		});
	
	  $("#btn_rankingPorPrograma").click(function() {	
		  	var pesquisaPorUsuario = $('#pesquisaPorUsuario').val();
	       	var pesquisaPorArea = $('#pesquisaPorArea').val();
	       	var pesquisaPorTipo = $('#pesquisaPorTipo').val();
	       	var pesquisaPorPrograma = $('#pesquisaPorPrograma').val();
	       	var pesquisaPorPeriodoInicio = $('#pesquisaPorPeriodoInicio').val();
	       	var pesquisaPorPeriodoFim = $('#pesquisaPorPeriodoFim').val();
	              	
	       	var validado = true;
	       	var msg = "";
	       	var campo = "";
	     
	       	if(pesquisaPorPeriodoInicio != "0"){
      			if(pesquisaPorPeriodoFim == "0"){
		      		msg = "Os dois campos de data devem ser preenchidos!";
		      		campo = "pesquisaPorPeriodoFim";
		      		validado = false;
	      		}
      		}else if(pesquisaPorPeriodoFim != "0"){
	      		if(pesquisaPorPeriodoInicio == "0"){
	      			msg = "Os dois campos de data devem ser preenchidos!";
		      		campo = "pesquisaPorPeriodoInicio";
		      		validado = false;
	      		}
      		}
	        	
      	if(validado){
      		rankingPorPrograma(pesquisaPorUsuario, pesquisaPorArea, pesquisaPorTipo, pesquisaPorPrograma, pesquisaPorPeriodoInicio, pesquisaPorPeriodoFim);
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	  
	  $("#btn_rankingEngageRace").click(function() {	
		  	var pesquisaPorUsuario = $('#pesquisaPorUsuario').val();
	       	var pesquisaPorArea = $('#pesquisaPorArea').val();
	       	var pesquisaPorTipo = $('#pesquisaPorTipo').val();
	       	var pesquisaPorPrograma = $('#pesquisaPorPrograma').val();
	       	var pesquisaPorPeriodoInicio = $('#pesquisaPorPeriodoInicio').val();
	       	var pesquisaPorPeriodoFim = $('#pesquisaPorPeriodoFim').val();
	              	
	       	var validado = true;
	       	var msg = "";
	       	var campo = "";
	     
	       	if(pesquisaPorPeriodoInicio != "0"){
    			if(pesquisaPorPeriodoFim == "0"){
		      		msg = "Os dois campos de data devem ser preenchidos!";
		      		campo = "pesquisaPorPeriodoFim";
		      		validado = false;
	      		}
    		}else if(pesquisaPorPeriodoFim != "0"){
	      		if(pesquisaPorPeriodoInicio == "0"){
	      			msg = "Os dois campos de data devem ser preenchidos!";
		      		campo = "pesquisaPorPeriodoInicio";
		      		validado = false;
	      		}
    		}
	        	
    	if(validado){
    		rankingEngageRace(pesquisaPorUsuario, pesquisaPorArea, pesquisaPorTipo, pesquisaPorPrograma, pesquisaPorPeriodoInicio, pesquisaPorPeriodoFim);
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	  
	  $("#btn_historicoUsuario").click(function() {	
		  	var pesquisaPorUsuario = $('#pesquisaPorUsuario').val();
	       	var pesquisaPorArea = $('#pesquisaPorArea').val();
	       	var pesquisaPorTipo = $('#pesquisaPorTipo').val();
	       	var pesquisaPorPrograma = $('#pesquisaPorPrograma').val();
	       	var pesquisaPorPeriodoInicio = $('#pesquisaPorPeriodoInicio').val();
	       	var pesquisaPorPeriodoFim = $('#pesquisaPorPeriodoFim').val();
	              	
	       	var validado = true;
	       	var msg = "";
	       	var campo = "";
	     
	       	if(pesquisaPorPeriodoInicio != "0"){
  			if(pesquisaPorPeriodoFim == "0"){
		      		msg = "Os dois campos de data devem ser preenchidos!";
		      		campo = "pesquisaPorPeriodoFim";
		      		validado = false;
	      		}
  		}else if(pesquisaPorPeriodoFim != "0"){
	      		if(pesquisaPorPeriodoInicio == "0"){
	      			msg = "Os dois campos de data devem ser preenchidos!";
		      		campo = "pesquisaPorPeriodoInicio";
		      		validado = false;
	      		}
  		}
	        	
  	if(validado){
  		historicoUsuario(pesquisaPorUsuario, pesquisaPorArea, pesquisaPorTipo, pesquisaPorPrograma, pesquisaPorPeriodoInicio, pesquisaPorPeriodoFim);
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });


});

	function rankingPorPrograma(pesquisaPorUsuario, pesquisaPorArea, pesquisaPorTipo, pesquisaPorPrograma, pesquisaPorPeriodoInicio, pesquisaPorPeriodoFim) {	
		$.post("RelatorioServlet", {
			action: 'rankingPorPrograma',
			pesquisaPorUsuario: pesquisaPorUsuario, 
			pesquisaPorArea: pesquisaPorArea, 
			pesquisaPorTipo: pesquisaPorTipo, 
			pesquisaPorPrograma: pesquisaPorPrograma, 
			pesquisaPorPeriodoInicio: pesquisaPorPeriodoInicio, 
			pesquisaPorPeriodoFim: pesquisaPorPeriodoFim
			}, function(retorno){
				
				htmlOutput = '';
				htmlOutputHeader = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if (obj.length == 0) {
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td colspan="5">Nenhum registro encontrado!</td>';
						htmlOutput = htmlOutput + '</tr>';					
				} else {
					htmlOutputHeader = htmlOutputHeader + '<tr  class="tr2">';
					htmlOutputHeader = htmlOutputHeader + '<td>Nome</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Área</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Programa</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Tipo do Programa</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Ocorrências</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Pontuação</td>';
					htmlOutputHeader = htmlOutputHeader + '</tr>';		
					
					var idTipoRelatorio = 0;
					
					for (var i = 0; i < obj.length; i++) {
						idTipoRelatorio = obj[i].idTipoRelatorio;
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td>' + obj[i].usuario + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].area + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].programa + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].tipoPrograma + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].ocorrencias + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].totalPontuacao + '</td>';
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}	
					
					htmlOutput = htmlOutput + '<tr>';
					htmlOutput = htmlOutput + '<td align="right">';
					htmlOutput = htmlOutput + '<a href=\'/EngageRace/RelatorioServlet?action=Relatorio';
					htmlOutput = htmlOutput + '&idTipoRelatorio='+ idTipoRelatorio;
					htmlOutput = htmlOutput + '&pesquisaPorUsuario='+ $('#pesquisaPorUsuario').val();
					htmlOutput = htmlOutput + '&pesquisaPorArea='+$('#pesquisaPorArea').val();
					htmlOutput = htmlOutput + '&pesquisaPorTipo='+$('#pesquisaPorTipo').val();
					htmlOutput = htmlOutput + '&pesquisaPorPrograma='+$('#pesquisaPorPrograma').val();
					htmlOutput = htmlOutput + '&pesquisaPorPeriodoInicio='+$('#pesquisaPorPeriodoInicio').val();
					htmlOutput = htmlOutput + '&pesquisaPorPeriodoFim='+$('#pesquisaPorPeriodoFim').val();
					htmlOutput = htmlOutput + '\'>Gerar Relatório</a>';
					htmlOutput = htmlOutput + '</td>';
					htmlOutput = htmlOutput + '</tr>';
				}
				$('#relatorio').html(htmlOutput);
				$('#cabecalho').html(htmlOutputHeader);
			});
	}
	
	function rankingEngageRace(pesquisaPorUsuario, pesquisaPorArea, pesquisaPorTipo, pesquisaPorPrograma, pesquisaPorPeriodoInicio, pesquisaPorPeriodoFim) {
		$.post("RelatorioServlet", {
			action: 'rankingEngageRace',
			pesquisaPorUsuario: pesquisaPorUsuario, 
			pesquisaPorArea: pesquisaPorArea, 
			pesquisaPorTipo: pesquisaPorTipo, 
			pesquisaPorPrograma: pesquisaPorPrograma, 
			pesquisaPorPeriodoInicio: pesquisaPorPeriodoInicio, 
			pesquisaPorPeriodoFim: pesquisaPorPeriodoFim
			}, function(retorno){
				htmlOutput = '';
				htmlOutputHeader = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if (obj.length == 0) {
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td colspan="5">Nenhum registro encontrado!</td>';
						htmlOutput = htmlOutput + '</tr>';					
				} else {
					htmlOutputHeader = htmlOutputHeader + '<tr  class="tr2">';
					htmlOutputHeader = htmlOutputHeader + '<td>Nome</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Área</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Pontuação Total</td>';
					htmlOutputHeader = htmlOutputHeader + '</tr>';		
					
					var idTipoRelatorio = 0;
					
					for (var i = 0; i < obj.length; i++) {
						idTipoRelatorio = obj[i].idTipoRelatorio;
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td>' + obj[i].usuario + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].area + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].totalPontuacao + '</td>';
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
					
					htmlOutput = htmlOutput + '<tr>';
					htmlOutput = htmlOutput + '<td align="right">';
					htmlOutput = htmlOutput + '<a href=\'/EngageRace/RelatorioServlet?action=Relatorio';
					htmlOutput = htmlOutput + '&idTipoRelatorio='+ idTipoRelatorio;
					htmlOutput = htmlOutput + '&pesquisaPorUsuario='+ $('#pesquisaPorUsuario').val();
					htmlOutput = htmlOutput + '&pesquisaPorArea='+$('#pesquisaPorArea').val();
					htmlOutput = htmlOutput + '&pesquisaPorTipo='+$('#pesquisaPorTipo').val();
					htmlOutput = htmlOutput + '&pesquisaPorPrograma='+$('#pesquisaPorPrograma').val();
					htmlOutput = htmlOutput + '&pesquisaPorPeriodoInicio='+$('#pesquisaPorPeriodoInicio').val();
					htmlOutput = htmlOutput + '&pesquisaPorPeriodoFim='+$('#pesquisaPorPeriodoFim').val();
					htmlOutput = htmlOutput + '\'>Gerar Relatório</a>';
					htmlOutput = htmlOutput + '</td>';
					htmlOutput = htmlOutput + '</tr>';
				}
				$('#relatorio').html(htmlOutput);
				$('#cabecalho').html(htmlOutputHeader);
			});
	}
	
	function historicoUsuario(pesquisaPorUsuario, pesquisaPorArea, pesquisaPorTipo, pesquisaPorPrograma, pesquisaPorPeriodoInicio, pesquisaPorPeriodoFim) {	
		$.post("RelatorioServlet", {
			action: 'historicoUsuario',
			pesquisaPorUsuario: pesquisaPorUsuario, 
			pesquisaPorArea: pesquisaPorArea, 
			pesquisaPorTipo: pesquisaPorTipo, 
			pesquisaPorPrograma: pesquisaPorPrograma, 
			pesquisaPorPeriodoInicio: pesquisaPorPeriodoInicio, 
			pesquisaPorPeriodoFim: pesquisaPorPeriodoFim
			}, function(retorno){
				
				htmlOutput = '';
				htmlOutputHeader = '';
				
				var obj = jQuery.parseJSON(retorno);
				
				if (obj.length == 0) {
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td colspan="5">Nenhum registro encontrado!</td>';
						htmlOutput = htmlOutput + '</tr>';					
				} else {
					htmlOutputHeader = htmlOutputHeader + '<tr  class="tr2">';
					htmlOutputHeader = htmlOutputHeader + '<td>Data</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Nome</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Área</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Programa</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Tipo do Programa</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Pontos</td>';
					htmlOutputHeader = htmlOutputHeader + '<td>Bonus</td>';
					htmlOutputHeader = htmlOutputHeader + '</tr>';		
					
					var idTipoRelatorio = 0;
					
					for (var i = 0; i < obj.length; i++) {
						idTipoRelatorio = obj[i].idTipoRelatorio;
						htmlOutput = htmlOutput + '<tr>';
						htmlOutput = htmlOutput + '<td>' + obj[i].data + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].usuario + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].area + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].programa + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].tipoPrograma + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].pontos + '</td>';
						htmlOutput = htmlOutput + '<td>' + obj[i].bonus + '</td>';
						htmlOutput = htmlOutput + '<td align="center">';
						htmlOutput = htmlOutput + '</td>';
						htmlOutput = htmlOutput + '</tr>';
					}				
					
					htmlOutput = htmlOutput + '<tr>';
					htmlOutput = htmlOutput + '<td align="right">';
					htmlOutput = htmlOutput + '<a href=\'/EngageRace/RelatorioServlet?action=Relatorio';
					htmlOutput = htmlOutput + '&idTipoRelatorio='+ idTipoRelatorio;
					htmlOutput = htmlOutput + '&pesquisaPorUsuario='+ $('#pesquisaPorUsuario').val();
					htmlOutput = htmlOutput + '&pesquisaPorArea='+$('#pesquisaPorArea').val();
					htmlOutput = htmlOutput + '&pesquisaPorTipo='+$('#pesquisaPorTipo').val();
					htmlOutput = htmlOutput + '&pesquisaPorPrograma='+$('#pesquisaPorPrograma').val();
					htmlOutput = htmlOutput + '&pesquisaPorPeriodoInicio='+$('#pesquisaPorPeriodoInicio').val();
					htmlOutput = htmlOutput + '&pesquisaPorPeriodoFim='+$('#pesquisaPorPeriodoFim').val();
					htmlOutput = htmlOutput + '\'>Gerar Relatório</a>';
					htmlOutput = htmlOutput + '</td>';
					htmlOutput = htmlOutput + '</tr>';
				}
				$('#relatorio').html(htmlOutput);
				$('#cabecalho').html(htmlOutputHeader);
			});
	}
	
	function exportaRelatorio(){
		//to do
	}
	
	function limpaFiltros(){
    	$('#pesquisaPorUsuario').val("0");
	   	$('#pesquisaPorArea').val("0");
	   	$('#pesquisaPorTipo').val("0");
	    $('#pesquisaPorPrograma').val("0");
	   	$('#pesquisaPorPeriodoInicio').val("");
	   	$('#pesquisaPorPeriodoFim').val("");
	}	
	