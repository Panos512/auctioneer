'use strict';

app.controller('AdminController', ['$scope', '$location', 'RequestServices', function($scope, $location, RequestServices) {

    $scope.tab = 1;

    $scope.setTab = function(newTab){
        $scope.tab = newTab;
    };

    function download(filename, text) {
        var pom = document.createElement('a');
        pom.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
        pom.setAttribute('download', filename);

        if (document.createEvent) {
            var event = document.createEvent('MouseEvents');
            event.initEvent('click', true, true);
            pom.dispatchEvent(event);
        }
        else {
            pom.click();
        }
    }

    $scope.export_data = function(){
        RequestServices.export()
            .then(function (response) {
                console.log(response);
                download('auctioneer.xml', response);
            });
    };

    $scope.isSet = function(tabNum){
        return $scope.tab === tabNum;
    };
}]);

// 'ngMessages', 'material.svgAssetsCache',