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

    $scope.showUpdateEmployee = function(ev, currentUser) {
            $mdDialog.show({
              controller: function ($mdDialog, $scope, $http) {
                              var vm = this;
                              vm.currentUser = {};
                              vm.currentUser = currentUser;  //your task object from the ng-repeat

                              $scope.hide = function () {
                                  $mdDialog.hide();
                              };
                              $scope.cancel = function () {
                                  $mdDialog.cancel();
                              };
                              $scope.UpdateEmployeeInfo = function () {
                                    $http.post('/employees', {
                                        "id": currentUser.id,
                                        "name": currentUser.name,
                                        "surname": currentUser.surname,
                                        "position": currentUser.position,
                                        "phone": currentUser.phone
                                    }).success(function (data) {
                                        $mdDialog.hide();
                                    });
                                };
                          },
              controllerAs: 'modal',
              templateUrl: 'templates/employeeEditForm.html',
              parent: angular.element(document.body),
              targetEvent: ev,
              clickOutsideToClose:true,
            })
            .then(function() {
                getEmployeesInfo();
            })
    };

    $scope.showUpdateClient = function(ev, currentUser) {
                $mdDialog.show({
                  controller: function ($mdDialog, $scope, $http) {
                                  var vm = this;
                                  vm.currentUser = {};
                                  vm.currentUser = currentUser;  //your task object from the ng-repeat

                                  $scope.hide = function () {
                                      $mdDialog.hide();
                                  };
                                  $scope.cancel = function () {
                                      $mdDialog.cancel();
                                  };
                                  $scope.UpdateInfo = function () {
                                      $http.post('/clients', {
                                          "id": currentUser.id,
                                          "name": currentUser.name,
                                          "surname": currentUser.surname,
                                          "phone": currentUser.phone,
                                          "email": currentUser.email
                                      }).success(function (data) {
                                          $mdDialog.hide();
                                      });
                                  };
                              },
                  controllerAs: 'modal',
                  templateUrl: 'templates/clientEditForm.html',
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
