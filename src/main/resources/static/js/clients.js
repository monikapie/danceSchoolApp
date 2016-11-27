/**
 * Created by Monika on 11/1/2016.
 */
var crudApp = angular.module('crudApp',['ngMaterial']);
crudApp.controller("DbController",['$scope','$http', function($scope,$http){

// Function to get employee details from the database
    function getInfo() {
        $http.get('/clients').success(function (data) {
            $scope.details = data;
        });
    }

    $scope.insertInfo = function(info){
        $http.post('/clients',{"name":info.name,"surname":info.surname,"email":info.email,"phone":info.phone}).success(function(data){
            getInfo();
    // Hide details insertion form
     //       $('#editForm').css('display', 'none');
        });
    };

    $scope.currentUser = {};
    $scope.addInfo = function() {
        $('#empForm').slideToggle();
        $('#editForm').slideUp();
    };

    $scope.currentUser = {};
    $scope.editInfo = function(info) {
        $scope.currentUser = info;
        $('#empForm').slideUp();
        $('#editForm').slideToggle();
    };

    $scope.UpdateInfo = function(info){
        $http.post('/clients',{"id":info.id,"name":info.name,"surname":info.surname,"phone":info.phone,"email":info.email}).success(function(data){
            getInfo();
        });
    };

    $scope.deleteInfo = function(info){
        $http.delete('/clients/'+info.id,{"id":info.id}).success(function(data){
            getInfo();
        });
    $scope.selectChanged = function(){
        console.log("Changes");
        if ($scope.tables=="clients"){
                $scope.getInfo();
            }
        };

    }}]);
