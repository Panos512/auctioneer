'use strict';

app.controller('MyBidsController', ['$scope', 'RequestServices', function($scope, RequestServices) {

    $scope.isVisible = function(auction){
        var today = new Date();
        var date = new Date(auction.endDate);
        today.setHours(0,0,0,0);
        date.setHours(0,0,0,0);

        return today <= date || auction.startDate == null || ( auction.bids.length == 0 && (today <= date || auction.startDate == null));

    };


    RequestServices.get_my_auctions()
        .then(function(response) {
            $scope.credentials = response;
        });

}]);