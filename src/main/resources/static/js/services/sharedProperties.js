'use strict';

app.service('sharedProperties', function () {

    var succ_signup = '';
    var services = {};


        services.getSuccSignup = function () {
            return succ_signup;
        };

        services.setSuccSignup = function(value) {
            succ_signup = value;
        };

        return services;
});