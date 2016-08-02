'use strict';

app.controller('AddAuctionController', ['$scope', 'sharedProperties', function($scope, sharedProperties) {
    $scope.credentials = {
        name:'',
        buyPrice: '',
        firstBid: '',
        latitude: '',
        longitude: '',
        country: '',
        startDate: '',
        description: '',
        sellerId: ''
    };
}]);