var mainapp=angular.module('mainapp', ["ngRoute",
    "mobile-angular-ui"]);
 mainapp.config(function($routeProvider) {
     $routeProvider

         // route for the home page
         .when('/', {
             templateUrl : 'views/login.html',
             controller  : 'mainCtrl'
         })

     // route for the about page
         .when('/menu', {
             templateUrl : 'views/menu.html',
             controller  : 'menuCtrl'
         })

        /*     // route for the contact page
         .when('/contact', {
             templateUrl : 'pages/contact.html',
             controller  : 'contactController'
         });*/
});

mainapp.factory('LoginFboFactory', function() {
    var state=false;
    return {
        setState: function(boolsk){
            return state=boolsk;
        },
        getState:function () {
            return state;
        }
    }

});
mainapp.controller('mainCtrl',function($scope,$http, LoginFboFactory) {
    var dataObj = {
        name : "kubi",
        password : "12445",
        state : false
    };

    $scope.inner={tableItems:{m:{0:""},ti:{0:""},o:{0:""},to:{0:""},f:{0:""},l:{0:""},s:{0:""}}};
    $scope.mTimer=7.5;
    $scope.oneAtATime = true;

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

    $scope.addItem = function() {
        var newItemNo = $scope.items.length + 1;
        $scope.items.push('Item ' + newItemNo);
    };



    $scope.logon=function() {
        var res = $http.post('/token', dataObj);
        res.success(function(data, status, headers, config) {
            $scope.message = data;
            $scope.showDayView=true;
            $scope.showWeekView=false;
            document.cookie="loggedIn = true";
            LoginFboFactory.setState(true);
            console.log(LoginFboFactory.getState())
        });
        res.error(function(data, status, headers, config) {
            $scope.showDayView=false;
        });
    }



});
mainapp.controller('menuCtrl',function($scope,$http, LoginFboFactory) {
  $scope.pageId="menu"
});