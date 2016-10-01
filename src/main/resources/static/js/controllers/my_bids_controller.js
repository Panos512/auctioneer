'use strict';

app.controller('MyBidsController', ['$scope', 'RequestServices', function($scope, RequestServices) {

    $scope.notExpired = function(auction){
        var today = new Date();
        var date = new Date(auction.endDate);
        today.setHours(0,0,0,0);
        date.setHours(0,0,0,0);
        console.log(date);
        return today <= date;

    };


    RequestServices.get_my_auctions()
        .then(function(response) {
            $scope.credentials = response;
        });

}]);