var mainapp = angular.module('mainapp', ["ngRoute",
    "mobile-angular-ui"]);
mainapp.config(function ($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl: 'views/login.html',
            controller: 'mainCtrl'
        })


        .when('/menu', {
            templateUrl: 'views/menu.html',
            controller: 'menuCtrl'
        })


        .when('/ol', {
            templateUrl: 'views/ol.html',
            controller: 'menuCtrl'
        })
        .when('/drink', {
            templateUrl: 'views/drink.html',
            controller: 'menuCtrl'
        })
        .when('/vin', {
            templateUrl: 'views/vin.html',
            controller: 'menuCtrl'
        });
});

mainapp.factory('LoginFboFactory', function () {
    var state = false;
    return {
        setState: function (boolsk) {
            return state = boolsk;
        },
        getState: function () {
            return state;
        }
    }

});
mainapp.controller('mainCtrl', function ($scope, $http, LoginFboFactory,$location) {
    var dataObj = {
        name: "kubi",
        password: "12445",
        state: false
    };
    $scope.$on('$routeChangeStart', function(next, current) {
           if(current.templateUrl == "views/login.html"){
               $scope.isLogin=true;}else{
               $scope.isLogin=false;}
    });
    $scope.mTimer = 7.5;
    $scope.sWidth =  $(window).width();
    $scope.groups = [
        {
            title: 'Dynamic Group Header - 1',
            content: 'Dynamic Group Body - 1'
        },
        {
            title: 'Dynamic Group Header - 2',
            content: 'Dynamic Group Body - 2'
        }
    ];

    $scope.items = ['Item 1', 'Item 2', 'Item 3'];

    $scope.addItem = function () {
        var newItemNo = $scope.items.length + 1;
        $scope.items.push('Item ' + newItemNo);
    };


    $scope.logon = function () {
        var res = $http.post('/token', dataObj);
        res.success(function (data, status, headers, config) {
            $scope.message = data;
            $scope.showDayView = true;
            $scope.showWeekView = false;
            document.cookie = "loggedIn = true";
            LoginFboFactory.setState(true);
            console.log(LoginFboFactory.getState())
        });
        res.error(function (data, status, headers, config) {
            $scope.showDayView = false;
        });
    }


});
mainapp.controller('menuCtrl', function ($scope, $http, LoginFboFactory) {
    $scope.pageId = "menu"
    $scope.menuItems={drinks:{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8}};

});