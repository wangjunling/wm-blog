/**
 * Created by wangjunling on 2016/8/15.
 */
var app = angular.module("indexApp", ['ngRoute', 'ngSanitize']);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        controller: listController,
        templateUrl: 'list.html'
    }).when("/detail/:id", {
        controller: detailController,
        templateUrl: 'detail.html'
    }).when("/login", {
        controller:loginController,
        templateUrl: '/login.html'
    }).otherwise({
        redirectTo: '/'
    });
});
app.controller("navCtrl", navController);
app.filter('split', function () {
    return function (input, splitChar) {
        return input.split(splitChar);
    }
});


function navController($scope, $http) {
    $http.get("/category/nav").success(function (response) {
        $scope.categories = response.data;
    });
    $http.get("/check/login").success(function (response) {
        $scope.user = response.data;
        if(response.data){
            $scope.loginUrl = "#/";
        }
    });
    $scope.logout=function () {
        $http.get("/user/logout").success(function (response) {
            if(response.meta.success){
                location.href="/";
            }
        });
    }
}
function listController($scope, $http) {
    $http.get("/article/list").success(function (response) {
        $scope.list = response.data.content;
    })
}

function detailController($scope, $http, $routeParams) {
    var id = $routeParams.id;
    $http.get('/article/detail/' + id + '').success(function (response) {
        var article = response.data;
        article.content = markdown.toHTML(article.content);
        $scope.article = article;
    })
}

function loginController($scope,$http){
    $scope.submit=function () {
        $http.post("/user/login",{
            username:$scope.username,
            password:$scope.password
        }).success(function (response) {
            window.location.href='/'
        });
    }
}
