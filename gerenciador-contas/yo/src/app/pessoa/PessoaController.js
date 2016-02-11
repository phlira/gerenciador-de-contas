angular.module('gcontas').controller('PessoaController', function($scope, $http, $routeParams) {

		$scope.pessoas =     [{"id":1, "firstName":"John", "lastName":"Doe"}, {"id":2, "firstName":"Anna", "lastName":"Smith"}, {"id":3 ,"firstName":"Peter", "lastName":"Jones"}];
		$scope.titulo = "";
		$scope.porcentagem = 0;

		var idGet = $routeParams.pessoaId;

		if(idGet) {
			$scope.pessoa = {"id":1, "firstName":"John", "lastName":"Doe"};
			$scope.titulo = "Editando Registro Pessoa";			
		} else {
			$scope.titulo = "Cadastrar Novo Registro Pessoa";
		}

		$scope.submeter = function() {
			$scope.pessoa = {};
		}

});