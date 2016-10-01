'use strict';

app.controller('EditAuctionController', ['$scope', '$location', '$cookies', '$routeParams', 'RequestServices', function($scope, $location, $cookies, $routeParams, RequestServices) {
    // $scope.categories = [];
    $scope.categories = [];

    $scope.buttonDisabled = false;
    $scope.credentials = {
        itemId: 0,
        name:'A new auction',
        description: 'This is a description for the first auction and it needs to be somehow big. So, I will continue typing for some more characters in order to make thi big enough. I think thats enough.. Or maybe not. Ok Bye!',
        firstBid: 10,
        latitude: 12,
        longitude: 6,
        country: 'Greece',
        startDate: null,
        endDate: null,
        buyPrice: 100,
        sellerId: '',
        categories: [],
        photos: []
    };
    $scope.params = $routeParams;
    var auctionId = $scope.params.auctionId;

    RequestServices.get_auction(auctionId).then( function (response){

        // TODO: User should be able to delete photos.
        // response.photos = response.images;
        response.photos = [];
        delete response.images;

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

    $scope.upload= function(){
        var files = $scope.files;
        console.log(files);

        var fileCount = files.length;

        for (var i = 0; i < fileCount; i++) {

            RequestServices.upload_file(files[i])
                .then(function (response){
                    console.log(response);
                    $scope.credentials.photos.push(response.data.path);
                });

        }

    };


    $scope.addAuction = function() {
        $scope.buttonDisabled=  true;

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
