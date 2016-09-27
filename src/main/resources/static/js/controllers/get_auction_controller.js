'use strict';

app.controller('GetAuctionController', ['$scope', '$cookies', '$routeParams', 'RequestServices', 'NgMap', function($scope, $cookies, $routeParams, RequestServices, NgMap) {
    $scope.buttonDisabled = false;
    $scope.notGuest = false;

    var cookie = $cookies.getObject('auctioneer_user');

    if (typeof cookie != 'undefined') {
        $scope.notGuest = true;
    }


    // RequestServices.auctions_list().then(function (response){
    //     console.log(response);
    //     $scope.auctions = response;
    // });
    $scope.params = $routeParams;
    var auctionId = $scope.params.auctionId;

    RequestServices.get_auction(auctionId)
        .then(function(response) {
            $scope.credentials = response;
            $scope.maxBid = response.currently;
        });

    NgMap.getMap().then(function(map) {
        console.log(map.getCenter());
        console.log('markers', map.markers);
        console.log('shapes', map.shapes);
    });

    $scope.PlaceBid = function(){
        console.log('123');

        $scope.buttonDisabled=  true;
        var cookie = $cookies.getObject('auctioneer_user');

        var request = {
            userId: cookie.id,
            itemId: $scope.credentials.itemId,
            bidDate: new Date(),
            offerPrice: $scope.maxBid
        };

        RequestServices.place_bid(request)
            .then(function(response) {
                console.log(response);
            });
    };

}]);