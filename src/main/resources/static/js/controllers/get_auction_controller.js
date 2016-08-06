'use strict';

app.controller('GetAuctionController', ['$scope', '$routeParams', 'RequestServices', function($scope, $routeParams, RequestServices ) {
    $scope.buttonDisabled = false;

    // RequestServices.auctions_list().then(function (response){
    //     console.log(response);
    //     $scope.auctions = response;
    // });
    $scope.params = $routeParams;
    var auctionId = $scope.params.auctionId;

    RequestServices.get_auction(auctionId)
        .then(function(response) {
            $scope.credentials = response;
        });

    $scope.PlaceBid = function(){
        $scope.buttonDisabled=  true;
    };
}]);