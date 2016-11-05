/**
 * Created by Monika on 11/1/2016.
 */
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $scope.names = [];
    $http.get("/clients")
        .success(function (response){
            $scope.names = response;
        })
        .error(function(response) {
            alert("Error");
        });
});