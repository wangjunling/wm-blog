/**
 * Created by wangjunling on 2016/8/15.
 */
var app = angular.module("indexApp", ['ngRoute','ngSanitize']);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        controller: listController,
        templateUrl: 'list.html'
    }).when("/detail/:id", {
        controller: detailController,
        templateUrl: 'detail.html'
    }).otherwise({
        redirectTo: '/'
    });
});
app.controller("navCtrl",navController);



function navController($scope,$http) {
    $http.get("/category/nav").success(function (response) {
        $scope.categories = response.data;
    });
}
function listController($scope, $http) {
    $http.get("/article/list").success(function (response) {
        $scope.list = response.data.content;
    })
}

function detailController($scope,$http,$routeParams) {
    var id = $routeParams.id;
    $http.get('/article/detail/'+id+'').success(function (response) {
        var article = response.data;
        article.content= markdown.toHTML(article.content);
        $scope.article=article;
    })
}
app.filter('split',function () {
    return function (input, splitChar) {
        return input.split(splitChar);
    }
});