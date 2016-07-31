'use strict';

app.config(function($routeProvider, $httpProvider){
    $routeProvider
        .when('/',{
            templateUrl: '/views/home.html',
            controller: 'HomeController',
            controllerAs: 'controller'
        })
        .when('/login',{
            templateUrl: "/views/login.html",
            controller: 'UserController',
            controllerAs: 'controller'
        })
        .when('/signup',{
            templateUrl: "/views/signup.html",
            controller: 'SignUpController',
            controllerAs: 'controller'
        })
        .when('/admin_panel',{
            templateUrl: "/views/admin_panel.html",
            controller: 'AdminController',
            controllerAs: 'controller'
        })
        .when('/auctions',{
            templateUrl: "/views/auctions_list.html",
            controller: 'AuctionsController',
            controllerAs: 'controller'
        })
        .otherwise(
            { redirectTo: '/'}
        );

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});