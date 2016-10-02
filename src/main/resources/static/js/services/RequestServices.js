'use strict';
app.config(function ($httpProvider) {
    $httpProvider.interceptors.push(function($q, $cookies) {
        return {
            'request': function(config) {

                var cookie = $cookies.getObject('auctioneer_user');
                console.log(cookie);
                if (typeof cookie == 'undefined') {
                    config.headers['token'] = 'None';
                }
                else {
                    config.headers['token'] = $cookies.getObject('auctioneer_user').token;
                }

                return config;
            }
        };
    });
});

app.service("RequestServices", ['$http', '$cookies', '$location', 'sharedProperties', function($http, $cookies, $location, sharedProperties) {
    var services = {};

    services.login = function(request){
        return $http.post('/login', request)
            .then(function (response) {
                var obj = {
                    id: response.data.userId,
                    role: response.data.role,
                    token: response.data.generatedToken,
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
                    token: response.data.generatedToken
                };
                $cookies.putObject('auctioneer_user', obj);
                return obj;
            },
                function (response){
                    $location.url('/');
            });

    };

    services.users_list = function(){
        return $http.get('/get_user_list')
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.get_categories = function(){
        return $http.get('/get_categories')
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });


    };

    services.get_my_auctions = function(){
        return $http.get('/get_my_auctions')
            .then(function (response) {
                console.log(response);
                return response.data;
            },
            function (response){
                $location.url('/');
            });

    };

    services.logout = function(){
        return $http.post('/logout')
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.add_auction = function(request){
        console.log(JSON.stringify(request));
        return $http.post('/add_auction', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.delete_auction = function(request){
        return $http.post('/delete_auction', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.place_bid = function(request){
        console.log(JSON.stringify(request));
        return $http.post('/place_bid', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.send_message = function(request){
        console.log(JSON.stringify(request));
        return $http.post('/send_message', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
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
            },
                function (response){
                    $location.url('/');
                });
    };


    services.auctions_list = function(){
        return $http.get('/auctions_list')
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.get_inbox = function(userId){
        var url = '/inbox/'.concat(userId);

        return $http.get(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.get_outbox = function(userId){
        var url = '/outbox/'.concat(userId);

        return $http.get(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.mark_read = function(request){
        console.log(JSON.stringify(request));
        return $http.post('/mark_read', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.delete_message = function(request){
        console.log(JSON.stringify(request));
        return $http.post('/delete_message', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.get_unread = function(userId){
        var url = '/get_unread/'.concat(userId);

        return $http.get(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };


    services.get_auction = function(auctionId){
        var url = '/get_auction/'.concat(auctionId);

        return $http.get(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });

    };

    services.get_edit_auction = function(auctionId){
        var url = '/get_edit_auction/'.concat(auctionId);

        return $http.get(url)
            .then(function (response) {
                    console.log(response);
                    return response.data;
                },
                function (response){
                    console.log(response);
                    $location.url('/');
                });

    };


    services.update_auction = function(request){
        console.log('updating');
        return $http.post('/update_auction', request)
            .then(function (response) {
                console.log(response);
                return response.data;
            });
    };

    services.vote_up = function(userId){
        var url = '/vote_up/'.concat(userId);
        console.log(url);
        return $http.post(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });
    };

    services.vote_down = function(userId){
        var url = '/vote_down/'.concat(userId);
        console.log(url);
        return $http.post(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
                });
    };

    services.get_user = function(userId){
        var url = '/get_user/'.concat(userId);

        return $http.get(url)
            .then(function (response) {
                console.log(response);
                return response.data;
            },
                function (response){
                    $location.url('/');
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
            },
                function (response){
                    $location.url('/');
                });

    };

    services.upload_file = function(file){
        var fd = new FormData();
        console.log(file);
        fd.append('file', file._file);
        var response = $http.post('/upload_image', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .then(function(response){
                console.log(response);
                return response;
            },
                function (response){
                    $location.url('/');
                });
        return response;


    };

    return services;
}]);
