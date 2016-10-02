'use strict';

app.controller('AuctionsController', ['$scope', 'RequestServices', function($scope, RequestServices) {

    $scope.options = {
        types: 'geocode',
        watchEnter: true,
        country: 'gr'
    };

    $(document).ready(function() {
        $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
        $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    });

    $scope.byRange = function (fieldName, minValue, maxValue) {
        if (minValue === undefined || minValue == null) minValue = Number.MIN_VALUE;
        if (maxValue === undefined || maxValue == null) maxValue = Number.MAX_VALUE;

        return function predicateFunc(item) {
            return minValue <= item[fieldName] && item[fieldName] <= maxValue;
        };
    };


    RequestServices.auctions_list().then(function (response){
        $scope.auctions = response;
    });

    $scope.filterItem ={
        categoryName: "Show All",
        categoryId: 0
    };

    RequestServices.get_categories().then(function (response){
        response.unshift($scope.filterItem);
        $scope.filterOptions = response;

        $scope.filterItem = $scope.filterOptions[0];

    });

    $scope.categoriesFilter = function (data) {
        if ($scope.filterItem.categoryName == "Show All") {
            return true;
        }
        for (var i=0; i < data.categories.length; i++) {
            if (data.categories[i].categoryId === $scope.filterItem.categoryId) {
                return true;
            }
        }

        return false;
    };


    $scope.mapFilter = function (data) {
        if (typeof $scope.details != 'undefined' && $scope.geoloc != ""){

            var input = $scope.details.geometry.location;
            var point = new google.maps.LatLng(data.latitude, data.longitude);

            if (google.maps.geometry.spherical.computeDistanceBetween(input, point) <= 10000){
                return true;
            }

            return false;
        }

        return true;
    };

}]);