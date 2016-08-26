'use strict';

app.controller('GetProfileController', ['$scope', '$routeParams', 'RequestServices', function($scope, $routeParams, RequestServices ) {
    $scope.buttonDisabled = false;

    // RequestServices.auctions_list().then(function (response){
    //     console.log(response);
    //     $scope.auctions = response;
    // });
    $scope.params = $routeParams;
    var userId = $scope.params.userId;

    RequestServices.get_user(userId)
        .then(function(response) {
            $scope.current_user = response;
        });

}]);