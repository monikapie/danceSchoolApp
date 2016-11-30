/**
 * Created by Monika on 11/1/2016.
 */
var crudApp = angular.module('crudApp', ['ngMaterial']);
crudApp.controller("DbController", ['$scope', '$http', '$mdDialog', function ($scope, $http, $mdDialog) {

    function getClientsInfo() {
        $http.get('/clients').success(function (data) {
            $scope.details = data;
        });
    }

    function getEmployeesInfo() {
       $http.get('/employees').success(function (data) {
            $scope.details2 = data;
       });
    }

    $scope.insertInfo = function (info) {
        $http.post('/clients', {
            "name": info.name,
            "surname": info.surname,
            "email": info.email,
            "phone": info.phone
            }).success(function (data) {
                 $mdDialog.hide();
            });
    };

    $scope.insertEmployeeInfo = function (info) {
        $http.post('/employees', {
            "name": info.name,
                "surname": info.surname,
                "position": info.position,
                "phone": info.phone
            }).success(function (data) {
                $mdDialog.hide();
            });
    };

    $scope.showAdvancedEmployee = function(ev) {
        $mdDialog.show({
          controller: "DbController",
          templateUrl: 'templates/employeeCreateForm.html',
          parent: angular.element(document.body),
          targetEvent: ev,
          clickOutsideToClose:true,
        })
        .then(function() {
            getEmployeesInfo();
        })
    };

    $scope.showAdvancedClient = function(ev) {
         $mdDialog.show({
            controller: "DbController",
            templateUrl: 'templates/clientCreateForm.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
         })
         .then(function() {
            getClientsInfo();
         })
    };

    $scope.currentUser = {};
    $scope.editInfo = function (info) {
        $scope.currentUser = info;
        $('#empForm').slideUp();
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
            getClientsInfo();
        });
    };

    $scope.deleteInfo = function (info) {
        $http.delete('/clients/' + info.id, {"id": info.id}).success(function (data) {
            getClientsInfo();
        })
    };

    $scope.deleteEmployeeInfo = function (info) {
        $http.delete('/employees/' + info.id, {"id": info.id}).success(function (data) {
            getEmployeesInfo();
        })
    };

    $scope.selectChanged = function () {
        console.log("Changes");
        if ($scope.tables == "clients") {
            $('#employees-table').css('display', 'none');
            $('#clients-table').slideToggle();
            getClientsInfo();
        }else if($scope.tables == "employees"){
            $('#clients-table').css('display', 'none');
            $('#employees-table').slideToggle();
            getEmployeesInfo();
        }
    };

}]);
