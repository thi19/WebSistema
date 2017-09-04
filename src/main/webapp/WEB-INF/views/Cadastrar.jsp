<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE>
<html ng-app="cadastrarControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>
 
<style type="text/css">
 
	label{
	    display: inline-block;
	    width: 90px;
	}
 
</style>
<script type="text/javascript" src="../resources/javascript/angular.min.js"></script>
<script type="text/javascript" src="../resources/javascript/cadastrarController.js"></script>
 
 
</head>
<body>
 
<form ng-controller="cadastrarController">
 
	<h2>Cadastro de Usuário</h2>
	<br/>
 
	<label for="input-nome" >Nome:</label>
	<input type="text" id="input-nome" style="width:220px;" ng-model="nome"/>
 
	<br/><br/>
	
	<label for="input-endereco">Endereço</label>
	<input type="text" id="input-endereco" style="width:120px;" ng-model="endereco"/>
	
	<br/></br>
	<label for="input-numero">Numero</label>
	<input type="text" id="input-numero" style="width:60px;" ng-model="numero"/>
 
	<br/><br/>
 
	<label for="input-registroAtivo">Ativo:</label>
	<input type="checkbox" id="input-registroAtivo" ng-model="ativo"/> 
 
	<br/><br/>
 
 
	<p>
		<a href= "../">Voltar</a>
 
		<input type="button" value="Salvar" ng-click="salvarUsuario()"/>
 
	</p>
 
 
</form>
 
 
 
</body>
</html>