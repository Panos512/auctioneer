'use strict';

app.controller('AddAuctionController', ['$scope', '$location', '$cookies', 'RequestServices', 'fileUploadService', function($scope, $location, $cookies, RequestServices, fileUploadService) {
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
        sellerId: ''
    };
    $scope.files = [];
    // $scope.upload=function(){
    //     console.log($scope.files);
    // };

    $scope.upload= function(){
        var files = $scope.files;
        console.log(files);
        fileUploadService.uploadFileToUrl(files);
        // RequestServices.upload_files(files).then(function (response){
        //     console.log(response);
        // });
    };

    $scope.addAuction = function() {
        $scope.buttonDisabled=  true;
        $scope.credentials.createdDate = new Date();
        var cookie = $cookies.getObject('auctioneer_user');
        $scope.credentials.sellerId = cookie.id;
        console.log($scope.credentials);

        RequestServices.add_auction($scope.credentials).then(function (response){
            console.log(response);
            $location.path("/");
        })
    };
}]);
