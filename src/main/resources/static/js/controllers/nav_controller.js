'use strict';

app.controller('NavController', ['$scope', '$cookies', '$location', 'sharedProperties', 'RequestServices', function($scope, $cookies, $location, sharedProperties, RequestServices) {

    $scope.authenticated = $cookies.getObject('auctioneer_user');
    console.log($scope.authenticated);

    $scope.unreadMessages = false;

    $scope.$on("getUnread", function(){
        RequestServices.get_unread($scope.authenticated.id).then(function (response) {
            $scope.unreadMessages = response;

            if (response == "0") {
                $scope.unreadMessages = false;
            }
        })
    });

    $scope.$broadcast("getUnread");


    $scope.logout = function() {
        console.log('bye');
        sharedProperties.setSuccSignup(false);
        $cookies.remove("auctioneer_user");
        $scope.authenticated = false;
        $location.path('/');
        return true;
    };


    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };

}]);