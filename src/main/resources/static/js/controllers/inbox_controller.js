'use strict';

app.controller('InboxController', ['$scope','$rootScope', '$cookies', 'RequestServices', function($scope,$rootScope, $cookies, RequestServices) {

    $scope.sortType     = 'name'; // default sort type
    $scope.sortReverse  = false;  // default sort order
    $scope.searchUser   = '';     // default search/filter term


    var cookie = $cookies.getObject('auctioneer_user');



    $scope.show_message = function (message) {
        $scope.current_message = message;
        console.log(message);
        RequestServices.mark_read(message).then(function (response){
            console.log(response);
            $rootScope.$broadcast("getUnread");
        })
    };



    RequestServices.get_inbox(cookie.id).then(function (response){
        console.log(response);
        $scope.messages = response;
    })



}]);