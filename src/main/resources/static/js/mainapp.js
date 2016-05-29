var mainapp = angular.module('mainapp', ["ngRoute",
    "mobile-angular-ui"]);
mainapp.config(function ($routeProvider) {
    $routeProvider

        // route for the home page


        .when('/login', {
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
    $scope.menuItems={items:{1:"Meals",2:"Burgers",3:"Drinks",4:"Fries",5:"Desserts & Shakes",6:"McCafe"}};

});


/* Server Sent Client
if (!!window.EventSource) {
    console.log("Event source available");
    var source = new EventSource('ssectrl');

    source.addEventListener('message', function(e) {
        console.log(e.data);
    });

    source.addEventListener('open', function(e) {
        console.log("Connection was opened.");
    }, false);

    source.addEventListener('error', function(e) {
        if (e.readyState == EventSource.CLOSED) {
            console.log("Connection was closed.");
        } else {
            console.log(e);
        }
    }, false);
} else {
    console.log("No SSE available");
}*/
function webSTest(){
    var ws = new WebSocket("ws://localhost:8080/wsctrl");
    console.log("webtest runs")
    alert("web test started")
    ws.onopen = function ( ) {
        // Web Socket is connected, send data using send()
        var url = location.href;
        console.log(  "open")
        ws.send("bc:");
    };
    ws.onmessage = function (evt) {

        var received_msg = evt.data;
        console.log(received_msg,"�������������")
        ClientApi.showToast(received_msg)
     /*   var jsonson= undefined;
        if( received_msg.indexOf("b64") > -1) {
            jsonson =JSON.parse(received_msg);
            console.log("jsonson", jsonson);
        }
        if (  undefined != jsonson && undefined != jsonson.userName ) {
            var picfbo={userName:"",b64:"",player:"",pos:"",stat:""}
    };*/

}
    ws.onclose = function () {
        // websocket is closed.
console.log("close")
    };
    ws.onerror = function (error) {
        console.log(error,"RRRRRRRRRRRRR")
    }

    function sendMessage() {
        ws.send("sdf");

    }
}