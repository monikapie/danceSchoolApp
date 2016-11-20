/**
 * Created by Monika on 11/1/2016.
 */
var crudApp = angular.module('crudApp',[]);
crudApp.controller("DbController",['$scope','$http', function($scope,$http){

// Function to get employee details from the database
    getInfo();
    function getInfo() {
        $http.get('/clients').success(function (data) {
            $scope.details = data;
        });
    }

    $scope.insertInfo = function(info){
        $http.put('/clients',{"name":info.name,"surname":info.surname,"phone":info.phone,"email":info.email}).success(function(data){
            if (data == true) {
                getInfo();
    // Hide details insertion form
                $('#empForm').css('display', 'none');
            }
        });
    }

    $scope.currentUser = {};
    $scope.editInfo = function(info) {
        $scope.currentUser = info;
        $('#empForm').slideUp();
        $('#editForm').slideToggle();
    }

    $scope.UpdateInfo = function(info){
        $http.post('/clients',{"id":info.id,"name":info.name,"surname":info.surname,"phone":info.phone,"email":info.email}).success(function(data){
            $scope.show_form = true;
            if (data == true) {
                getInfo();
            }
        });
    }

    $scope.deleteInfo = function(info){
        $http.delete('/clients/'+info.id,{"id":info.id}).success(function(data){
            if (data == true) {
                getInfo();
            }
        });
    }}])
