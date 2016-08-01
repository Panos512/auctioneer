'use strict';

app.controller('AuctionsController', ['$scope', 'sharedProperties', function($scope, sharedProperties) {
    $(document).ready(function() {
        $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
        $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    });

    $scope.auctions = [{
        itemId: 1,
        name: 'A great item!',
        currently: 100,
        description: 'A great description for a great item that must be big a  description for a great item that must be big a   description for a great item that must be big a ',
        categories: ['Category A', 'Category B'],
        buy_price: 120,
        country: 'Greece',
        sellerId: '25',
        mainImage: '/images/1_1.png'
    },
    {
        itemId: 2,
        name: 'A greater item!',
        currently: 150,
        description: 'A great description for a great item that must be big a  description for a great item that must be big a   description for a great item that must be big a ',
        categories: ['Category A', 'Category C'],
        buy_price: 220,
        country: 'Greece',
        sellerId: '25',
        mainImage: '/images/2_1.png'
    }
    ];
}]);