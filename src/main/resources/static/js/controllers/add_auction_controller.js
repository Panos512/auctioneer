'use strict';

app.controller('AddAuctionController', ['$scope', '$location', '$cookies', 'RequestServices', function($scope, $location, $cookies, RequestServices) {
    $scope.categories = null;
    $scope.buttonDisabled = false;
    $scope.credentials = {
        name:'A new auction',
        description: 'This is a description for the first auction and it needs to be somhow big. So, I will continue typing for some more characters in order to make thi big enough. I think thats enough.. Or maybe not. Ok Bye!',
        firstBid: 10,
        latitude: 12,
        longitude: 6,
        country: 'Greece',
        startDate: new Date(),
        endDate: new Date(),
        buyPrice: 100,
        sellerId: '',
        categories: []
    };
    $scope.files = [];

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






    // $scope.upload=function(){
    //     console.log($scope.files);
    // };

    $scope.upload= function(){
        var files = $scope.files;
        console.log(files);

        var fileCount = files.length;

        var cookie = $cookies.getObject('auctioneer_user');
        var userId = cookie.id;

        for (var i = 0; i < fileCount; i++) {

            RequestServices.upload_file(files[i])
                .then(function (response){
                    console.log(response);
                    $scope.credentials.photos.push(response.data.path);
                });

        }

    };

    $scope.addAuction = function() {
        // $scope.buttonDisabled=  true; TODO: ENABLE THIS!!!!!!!!!!!!!
        console.log($scope.selectedCategories);
        $scope.credentials.createdDate = new Date();
        var cookie = $cookies.getObject('auctioneer_user');
        $scope.credentials.sellerId = cookie.id;

        if ($scope.credentials.categories.length == 0) {
            $scope.credentials.categories.push({id: 3});
        }


        console.log($scope.credentials);


        RequestServices.add_auction($scope.credentials).then(function (response){
            console.log(response);
            $location.path("/");
        })
    };
}]);
