/**
 * Created by wangjunling on 2016/8/15.
 */
$( document ).ready(function(){
    $(".button-collapse").sideNav();
    $(".dropdown-button").dropdown();
    $.fn.extend({
        animateCss: function (animationName) {
            var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            $(this).addClass('animated ' + animationName).one(animationEnd, function() {
                $(this).removeClass('animated ' + animationName);
            });
        }
    });

    $("#logo").animateCss('bounce');
});
var app = angular.module("indexApp", ['ngRoute', 'ngSanitize']);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        controller: listController,
        templateUrl: 'list.html'
    }).when("/home/:username", {
        controller: userController,
        templateUrl: 'user.html'
    }).when("/detail/:id", {
        controller: detailController,
        templateUrl: 'detail.html'
    }).when("/write", {
        controller: writeController,
        templateUrl: 'write.html'
    }).when("/save/result", {
        controller:saveResultController,
        templateUrl: '/save_result.html'
    }).when("/login", {
        controller:loginController,
        templateUrl: '/login.html'
    }).when("/register", {
        controller:registerController,
        templateUrl: '/register.html'
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
app.filter('markdown2html', function () {
    return function (input) {
        if (!input || !input.length) { return; }
        return markdown.toHTML(input);
    }
});

function navController($scope, $http) {
    $http.get("/category/nav").success(function (response) {
        $scope.categories = response.data;
    });
    $http.get("/check/login").success(function (response) {
        $scope.user = response.data;
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
        // article.content = markdown.toHTML(article.content);
        $scope.article = article;
    })
}

function loginController($scope,$http){
    $scope.submit=function () {
        $http.post("/user/login",{
            username:$scope.username,
            password:$scope.password
        }).success(function (response) {
            window.location.href='/';
        });
    }
}
function registerController($scope, $http) {
    $scope.submit=function () {
        $http.post("/user/register", {
            email: $scope.email,
            password: $scope.password
        }).success(function (response) {
            window.location.href = '#/login';
        });
    }
}

function writeController($scope, $http) {
    $scope.changeContent=function () {
        var content = $scope.content;
        if(content!=undefined){
            $scope.htmlContent = markdown.toHTML($scope.content);
        }
    }
    $scope.save=function () {
      $http.post("/article/save",{
          title:$scope.title,
          description:$scope.description,
          content:$scope.content
      }).success(function (response) {
          location.href="#/save/result"
      });
    }
}
function saveResultController() {
    
}
function userController($scope, $http, $routeParams) {
    $('ul.tabs').tabs();
    $('.materialboxed').materialbox();
    $('#addBio').leanModal({
            dismissible: false, // 点击模态框外部则关闭模态框
            opacity: .6, // 背景透明度
            in_duration: 300, // 切入时间
            out_duration: 200, // 切出时间
            ready: function() {  }, // 当模态框打开时执行的函数
            complete: function() {  } // 当模态框关闭时执行的函数
        }
    );




    console.log($routeParams);
    var username = $routeParams.username;
    console.log(username);
    $http.get('/article/list/'+username).success(function (response) {
        if(response.meta.success){
            $scope.list = response.data.content;
        }else{
            Materialize.toast(response.meta.message, 3000, 'rounded')
        }
    });
}