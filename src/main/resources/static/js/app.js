var app = angular.module('app', ['ngRoute'])

app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/dashboard', {
            templateUrl: 'js/component/login/login.html',
            controller: 'LoginController'
        }).
        otherwise({
            redirecTo: '/dashboard'
        });
}]);