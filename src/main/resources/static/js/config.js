'use strict';

app.config(function($routeProvider, $httpProvider){
    $routeProvider
        .when('/' ,{
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
        .when('/add_auction',{
            templateUrl: "/views/add_auction.html",
            controller: 'AddAuctionController',
            controllerAs: 'controller'
        })
        .when('/edit_auction/:auctionId?',{
            templateUrl: "/views/edit_auction.html",
            controller: 'EditAuctionController',
            controllerAs: 'controller'
        })
        .when('/messages',{
            templateUrl: "/views/messages.html",
            controller: 'MessagesController',
            controllerAs: 'controller'
        })
        .when('/auction/:auctionId?',{
            templateUrl: "/views/view_auction.html",
            controller: 'GetAuctionController',
            controllerAs: 'controller'
        })
        .when('/profile/:userId?',{
            templateUrl: "/views/view_profile.html",
            controller: 'GetProfileController',
            controllerAs: 'controller'
        })
        .otherwise(
            { redirectTo: '/'}
        );

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});