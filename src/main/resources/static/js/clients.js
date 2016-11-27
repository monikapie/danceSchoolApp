/**
 * Created by Monika on 11/1/2016.
 */
var crudApp = angular.module('crudApp', ['ngMaterial']);
crudApp.controller("DbController", ['$scope', '$http', function ($scope, $http) {

// Function to get employee details from the database
    function getInfo() {
        $http.get('/clients').success(function (data) {
            $scope.details = data;
        });
    }

    $scope.currentUser = {};
    $scope.addInfo = function () {
        console.log("Works");
        $('#empForm').slideToggle();
    };
    
    $scope.insertInfo = function (info) {
        $http.post('/clients', {
            "name": info.name,
            "surname": info.surname,
            "email": info.email,
            "phone": info.phone
        }).success(function (data) {
            getInfo();
        });
    };

    $scope.currentUser = {};
    $scope.editInfo = function (info) {
        $scope.currentUser = info;
        //$('#empForm').slideUp();
        $('#editForm').slideToggle();
    };

    $scope.UpdateInfo = function (info) {
        $http.post('/clients', {
            "id": info.id,
            "name": info.name,
            "surname": info.surname,
            "phone": info.phone,
            "email": info.email
        }).success(function (data) {
            getInfo();
        });
    };

    $scope.deleteInfo = function (info) {
        $http.delete('/clients/' + info.id, {"id": info.id}).success(function (data) {
            getInfo();
        })
    };

    $scope.selectChanged = function () {
        console.log("Changes");
        if ($scope.tables == "clients") {
            $('#clients-table').slideToggle();
            getInfo();
        }
    };

}]);
