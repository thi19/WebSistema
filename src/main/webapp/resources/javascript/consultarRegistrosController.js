var consultarRegistrosControllerApp = angular.module("consultarRegistrosControllerApp",[]);
 
consultarRegistrosControllerApp.controller("consultarRegistrosController",function($scope, $window, $http){
 
	/*CRIANDO UM ARRAY PARA OS REGISTROS QUE VÃƒO SER RETORNADOS PELO SPRING*/
	 $scope.usuarios = new Array();
 
 
	 $scope.init = function(){
 
		 /*CHAMA O MÃ‰TODO consultarTodos DO CONTROLLER GERENCIADO PELO SPRING*/
		 var response = $http.get("consultarTodos");
 
		 response.success(function(data, status, headers, config) {
 
			 /*SETA OS REGISTROS QUE FORAM RETORNADOS DO CONTROLLER DO SPRING,
			  ESSE REGISTROS VÃƒO PREENCHER OS CAMPOS DA TABELA DA PÃ�GINA consultarRegistros.jsp
			  ATAVÃ‰S DO ng-repeat do AngularJS*/
			 $scope.usuarios = data;
 
		 });
 
		 response.error(function(data, status, headers, config) {
			 /*SE OCORRER ERRO NÃƒO TRATADO IREMOS MOSTRA EM MENSAGEM*/
			 $window.alert(data);
 
		 });
	 }

 
	 /*FUNÃ‡ÃƒO PARA EXCLUIR UM REGISTRO*/	 
	 $scope.excluirRegistro = function(codigo){
 
		 if($window.confirm("Deseja realmente excluir esse registro?")){
 
			 /*CHAMA O MÃ‰TODO DO SPRING PARA EXCLUIR UM REGISTRO*/
			 var response = $http.delete("excluirRegistro/" + codigo);
 
			 response.success(function(data, status, headers, config) {
 
				 /*RECARREGANDO OS REGISTROS CADASTRADOS*/
				 $scope.init();
 
			 });
 
			 response.error(function(data, status, headers, config) {
				 /*SE OCORRER ERRO NÃƒO TRATADO IREMOS MOSTRA EM MENSAGEM*/
				 $window.alert(data);
 
			 });
 
		 }
 
 
	 }
 
});

