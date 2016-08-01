'use strict';

app.controller('AuctionsController', ['$scope', 'RequestServices', function($scope, RequestServices ) {

    $(document).ready(function() {
        $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
        $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    });

    RequestServices.auctions_list().then(function (response){
        console.log(response);
        $scope.auctions = response;
    });
    
}]);