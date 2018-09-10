var app = angular.module('loja', [ 'ngRoute' ]);

// configuração de rotas da aplicacao
app.config(function($routeProvider) {
	$routeProvider.
		when("/", { controller: "listController", templateUrl: "list.html" }).
		when("/edit/:name", { controller: "editController", templateUrl: "form.html"}).
		when("/new", { controller: "newController", templateUrl: "form.html"}).
		otherwise({ redirectTo: "/" })
});

app.run(function($rootScope) {
	$rootScope.frutas = ['laranja', 'limão', 'Pessegos', 'morangos'];
});

app.controller('listController', ['$scope', function($scope) {
	
}]);

// $scope é o escopo da aplicação html a view
// $location é o redirecionamento das rotas
// $routeParams são os parametros passados pela url
app.controller('editController', ['$scope', function editController($scope, $location, $routeParams) {
	$scope.title = "Editar Fruta";
	$scope.fruta = $routeParams.name;
	$scope.frutaIndex = $scope.frutas.indexOf($scope.fruta);
	
	$scope.salvar = function () {
		$scope.frutas[$scope.frutaIndex] = $scope.fruta; //Atualiza Fruta
		$location.path('/'); // Volta pra home
	};
}]);

// Controller para nova Fruta
app.controller('newController', ['$scope', function newController($scope, $location) {
	$scope.title = "Nova Fruta";
	$scope.fruta= '';
	
	$scope.salvar = function () {
		$scope.frutas.push($scope.fruta); //Add nova Fruta
		$location.path('/');
	};
	
}])