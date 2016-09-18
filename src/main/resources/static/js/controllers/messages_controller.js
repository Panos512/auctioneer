'use strict';

app.controller('MessagesController', ['$scope', '$cookies', 'RequestServices', function($scope, $cookies, RequestServices) {

    var cookie = $cookies.getObject('auctioneer_user');

    $scope.credentials = {};

    $scope.credentials.send = {
        messageText: "",
        userIdSender: cookie.id,
        userIdReceiver: 0,
        hasRead: false
    };

    console.log($scope.credentials.send);

    $scope.sendMessage = function() {
        // $scope.buttonDisabled=  true;
        
        RequestServices.send_message($scope.credentials.send).then(function (response){
            console.log(response);
            $scope.credentials.send.to = 0;
            $scope.credentials.send.message = "";
        })
    };


}]);