'use strict';

app.controller('GetProfileController', ['$scope', '$routeParams', 'RequestServices', function($scope, $routeParams, RequestServices ) {
    $scope.buttonDisabled = false;



    $scope.vote_up = function(){
        RequestServices.vote_up($scope.params.userId)
            .then(function(response) {

                $scope.current_user.sellerRating++;
            });
    };

    $scope.vote_down = function(){
        RequestServices.vote_down($scope.params.userId)
            .then(function(response) {
                $scope.current_user.sellerRating--;
            });
    };


    $scope.params = $routeParams;
    var userId = $scope.params.userId;

    RequestServices.get_user(userId)
        .then(function(response) {
            $scope.current_user = response;
        });

}]);