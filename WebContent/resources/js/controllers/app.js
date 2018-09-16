var app = angular.module('loja', [ 'ngRoute' ]);


app.config(function($routeProvider) {
	$routeProvider.
		when("/clientes", { controller: "clientesController", templateUrl: "clientes/list.html"}).
		otherwise({ redirectTo: "/" })
});

app.controller('clientesController', ['$scope', function($scope) {
	
}]);