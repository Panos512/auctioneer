'use strict';

app.controller('AuctionsController', ['$scope', 'RequestServices', function($scope, RequestServices ) {

    $(document).ready(function() {
        $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
        $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    });

    $scope.byRange = function (fieldName, minValue, maxValue) {
        console.log(fieldName, minValue, maxValue);
        if (minValue === undefined || minValue == null) minValue = Number.MIN_VALUE;
        if (maxValue === undefined || maxValue == null) maxValue = Number.MAX_VALUE;

        return function predicateFunc(item) {
            console.log(item);
            return minValue <= item[fieldName] && item[fieldName] <= maxValue;
        };
    };

    RequestServices.auctions_list().then(function (response){
        console.log(response);
        $scope.auctions = response;
    });
    
}]);