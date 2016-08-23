'use strict';

app.controller('EditAuctionController', ['$scope', '$location', '$cookies', '$routeParams', 'RequestServices', function($scope, $location, $cookies, $routeParams, RequestServices) {
    // $scope.categories = [];
    $scope.categories = [];

    $scope.buttonDisabled = false;
    $scope.credentials = {
        name:'',
        description: '',
        firstBid: 0,
        latitude: 0,
        longitude: 0,
        country: '',
        startDate: null,
        endDate: null,
        buyPrice: 0,
        sellerId: '',
        categories: []
    };
    $scope.params = $routeParams;
    var auctionId = $scope.params.auctionId;

    RequestServices.get_auction(auctionId).then( function (response){
        $scope.credentials = response;
        $scope.ItemCategories = [];

        for (var category in $scope.credentials.categories) {
            if ($scope.credentials.categories.hasOwnProperty(category)) {
                console.log(category);
                var cat = {
                    id: $scope.credentials.categories[category].categoryId
                };
                console.log(cat);
                $scope.ItemCategories.push(cat);
            }
        }
        $scope.credentials.categories = $scope.ItemCategories;
        console.log($scope.credentials.categories);

        $scope.credentials.endDate = new Date($scope.credentials.endDate);
        var d1 = new Date($scope.credentials.endDate);
        var d2 = new Date('1/1/1970');
        if (d1.getTime() === d2.getTime()) {
            $scope.credentials.endDate = null;
        }
        else {
            $scope.credentials.endDate = new Date($scope.credentials.endDate);
        }

        console.log($scope.credentials);

    });


    $scope.selectedCategories = [];

    RequestServices.get_categories().then( function (response){
        $scope.categories = [];
        console.log(response);

        for (var category in response) {
            if (response.hasOwnProperty(category)) {
                console.log(category);
                var cat = {
                    id: response[category].categoryId,
                    label: response[category].categoryName
                };
                console.log(cat);
                $scope.categories.push(cat);
            }
        }
        console.log($scope.categories);



    });

    $scope.categoryDropdownSettings = {
        scrollableHeight: '190px',
        scrollable: true,
        enableSearch: true,
        showCheckAll: false,
        showUncheckAll: false
    };




    $scope.addAuction = function() {
        $scope.buttonDisabled=  true;
        var cookie = $cookies.getObject('auctioneer_user');

        if ($scope.credentials.categories.length == 0) {
            $scope.credentials.categories.push({id: 3});
        }


        console.log($scope.credentials);


        RequestServices.update_auction($scope.credentials).then(function (response){
            console.log(response);
            $location.path("/");
        })
    };
}]);
