var app = angular.module('loja', []);

app.controller('MainController', [ '$scope', function($scope) {
	$scope.user = { meuNome : "Saudações" };
	
	$scope.contador = 0;
	
	$scope.addContador = function(){
		$scope.contador++;
	};
	
	$scope.pessoas = ['kratos', 'lara croft', 'peter parker', 'Thor'];
}]);
