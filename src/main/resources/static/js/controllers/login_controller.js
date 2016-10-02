'use strict';

app.controller('UserController', ['$scope', '$location', 'RequestServices', 'sharedProperties', function($scope, $location, RequestServices, sharedProperties) {

    $scope.credentials = {
        username: '',
        password: ''
    };

    $scope.login = function() {
        $scope.authenticated = true;

        var request = {
            username: $scope.credentials.username,
            password: $scope.credentials.password
        };

        RequestServices.login(request).then(function (response){
            console.log(response);
            if (response.status == 400) {
                $scope.user_error = 'set'
            }
            else {
                if (response.role === 'admin') { $location.path("/admin_panel"); }
                else { $location.path("/"); }

                sharedProperties.setSuccSignup(response.verified);
                console.log(response.verified);
            }


        })


    };


}]);