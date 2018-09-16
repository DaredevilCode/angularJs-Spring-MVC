var app = angular.module('loja', [ 'ngRoute', 'ngResource', 'ngAnimate' ]);


app.config(function($routeProvider,  $provide, $httpProvider, $locationProvider) {
	$routeProvider.
		when("/clientes", { controller: "clientesController", templateUrl: "clientes/list.html"}).
		when("/clientes/:id/edit", { controller: "clientesController", templateUrl: "clientes/form.html"}).
		when("/clientes/new", { controller: "clientesController", templateUrl: "clientes/form.html"}).
		otherwise({ 
			redirectTo: "/" 
		});
});

app.controller('clientesController', ['$scope', function($scope) {
	
}]);