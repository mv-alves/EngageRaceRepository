jQuery(document).ready(function() {
	
		limpaLoginForm();
		        
	    $("#btn_submeterLogin").click(function() {	     	    	
	       	var loginAdmin = $('#loginAdmin').val();
	       	var senhaAdmin = $('#senhaAdmin').val();
    	
        	var validado = true;
        	var msg = "";
        	var campo = "";
	        	
        	if(loginAdmin == ""){
        		msg = "Campo 'login' � obrigat�rio!";
        		campo = "loginAdmin";
        		validado = false;
           	}else if(senhaAdmin == ""){
        		msg = "Campo 'senha' � obrigat�rio!";
        		campo = "senhaAdmin";
        		validado = false;
        	}
	        	
        	if(validado){
        		postLogin('confirmaLogin', loginAdmin, senhaAdmin);	        	
			} else {
				alert(msg);
				$('#'+campo).focus();
			}
	    });
	       
	});

	function postLogin(acao, loginAdmin, senhaAdmin) {
		$.post("LoginServlet",{		
		action: acao,
			loginAdmin: loginAdmin,
			senhaAdmin: senhaAdmin,
		}, function(retorno) {
		    limpaLoginForm();
			window.location = retorno;
		});	       					
	}	
		
	function limpaLoginForm(){
		$('#loginAdmin').val("");
       	$('#senhaAdmin').val("");
	}	