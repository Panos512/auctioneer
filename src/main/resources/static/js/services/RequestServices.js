'use strict';

app.service("RequestServices", ['$http', '$cookies', 'sharedProperties', function($http, $cookies, sharedProperties) {
    var services = {};

    services.login = function(request){
        return $http.post('/login', request)
            .then(function (response) {
                var obj = {
                    id: response.data.userId,
                    role: response.data.role,
                    token: 'response.data.token',
                    verified: response.data.verified
                };
                $cookies.putObject('auctioneer_user', obj);
                return response.data;
            })
            .catch(function(response) {
                return response;
            })
            .finally(function() {
                console.log("Finished processing request.");
            });
        };

    services.signup = function(request){
        return $http.post('/signup', request)
            .then(function (response) {
                var obj = {
                    id: response.data.userId,
                    role: response.data.role,
                    token: 'response.data.token'
                };
                $cookies.putObject('auctioneer_user', obj);
                return obj;
            });

    };

    services.users_list = function(){
        return $http.get('/get_user_list')
            .then(function (response) {
                console.log(response);
                return response.data;
            });

    }

    services.add_auction = function(request){
        return $http.post('/add_auction', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            });

    };

    services.upload_files = function(request){
        console.log(request);
        request = request[0]._file;
        console.log(request);
        return $http.post('/upload_image', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            });
    };


    services.auctions_list = function(){
        return $http.get('/auctions_list')
            .then(function (response) {
                console.log(response);
                return response.data;
            });

    };

    services.get_user = function(userId){
        var url = '/get_user/'.concat(userId);

        return $http.get(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            });

    };

    services.approve_user = function(userId){
        sharedProperties.setSuccSignup(false);
        var obj = {
            userId: userId
        };

        return $http.post('/approve_user', obj)
            .then(function (response) {
                console.log(response);
                return response.data;
            });

    };

    return services;
}]);

app.service('fileUploadService', function ($http) {
    this.uploadFileToUrl = function(file){
        var fd = new FormData();
        console.log(file);
        fd.append('file', file._file);
        $http.post('/upload_image', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .success(function(){
            })
            .error(function(){
            });
    }
});