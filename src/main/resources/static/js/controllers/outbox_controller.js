'use strict';

app.controller('OutboxController', ['$scope', '$cookies', 'RequestServices', function($scope, $cookies, RequestServices) {

    $scope.sortType     = 'name'; // default sort type
    $scope.sortReverse  = false;  // default sort order
    $scope.searchUser   = '';     // default search/filter term


    var cookie = $cookies.getObject('auctioneer_user');



    $scope.show_message = function (message) {
        $scope.current_message = message;
    };



    RequestServices.get_outbox(cookie.id).then(function (response){
        console.log(response);
        $scope.messages = response;
    })



}]);