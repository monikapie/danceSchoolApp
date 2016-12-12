/**
 * Created by Monika on 11/1/2016.
 */
var crudApp = angular.module('crudApp', ['ngMaterial']);
crudApp.controller("DbController", ['$scope', '$http', '$mdDialog', function ($scope, $http, $mdDialog) {

    function getClientsInfo() {
        $http.get('/clients').success(function (data) {
            $scope.details = data;
        });
    };

    function getEmployeesInfo() {
       $http.get('/employees').success(function (data) {
            $scope.details2 = data;
       });
    };

    function getCoursesInfo() {
        $http.get('/courses').success(function (data) {
            $scope.courseDetails = data;
        })
    };

    var monday = [];
    var tuesday = [];
    var wednesday = [];
    var thursday = [];
    var friday = [];
    function checkDayOfWeek(item, index){

             switch (item.dayOfWeek) {
                 case "Monday":
                     monday.push(item)
                     break;
                 case "Tuesday":
                     tuesday.push(item)
                     break;
                 case "Wednesday":
                     wednesday.push(item)
                     break;
                 case "Thursday":
                     thursday.push(item)
                     break;
                 case "Friday":
                     friday.push(item)
                     break;
             }

         };

    $scope.getPlanInfo = function() {
                $http.get('/plans').success(function (data) {
                    data.forEach(checkDayOfWeek);
                    $scope.monday = monday;
                    $scope.tuesday = tuesday;
                    $scope.wednesday = wednesday;
                    $scope.thursday = thursday;
                    $scope.friday = friday;
                });
            };

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

    $scope.insertCourseInfo = function (info) {
        $http.post('/courses', {
            "cost": info.cost,
            "type": info.type
        }).success(function (data) {
            $mdDialog.hide();
        })
    };

    $scope.showAdvancedEmployee = function(ev) {
        $mdDialog.show({
          controller: "DbController",
          templateUrl: '../templates/employeeCreateForm.html',
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
            templateUrl: '../templates/clientCreateForm.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
         })
         .then(function() {
            getClientsInfo();
         })
    };

    $scope.showAdvancedCourse = function (ev) {
        $mdDialog.show({
            controller: "DbController",
            templateUrl: '../templates/courseCreateForm.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true
        }).then(function () {
            getCoursesInfo();
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
              templateUrl: '../templates/employeeEditForm.html',
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

                                  $scope.createCard = function(){
                                        var currentTime = new Date();
                                        var endTime = new Date();
                                        endTime.setDate(endTime.getDate() + 30);
                                        $http.post('/cards', {
                                                   "startDate": currentTime,
                                                    "endDate": endTime,
                                                    "clientId": currentUser.id,
                                                    });
                                  };

                              },
                  controllerAs: 'modal',
                  templateUrl: '../templates/clientEditForm.html',
                  parent: angular.element(document.body),
                  targetEvent: ev,
                  clickOutsideToClose:true,
                })
                .then(function() {
                    getClientsInfo();
                })
        };

    $scope.showUpdateCourse = function (ev, currentUser) {
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
                $scope.UpdateCourseInfo = function () {
                    $http.post('/courses', {
                        "id": currentUser.id,
                        "cost": currentUser.cost,
                        "type": currentUser.type
                    }).success(function (data) {
                        $mdDialog.hide();
                    });
                };
            },
            controllerAs: 'modal',
            templateUrl: '../templates/courseEditForm.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true
        })
            .then(function () {
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

    $scope.deleteCourseInfo = function (info) {
        $http.delete('/courses/' + info.id, {
            "id": info.id
        }).success(function (data) {
            getCoursesInfo();
        })
    };

    $scope.selectChanged = function () {
        console.log("Changes");
        if ($scope.tables == "clients") {
            $('#employees-table').css('display', 'none');
            $('#courses-table').css('display', 'none');
            getClientsInfo();
            $('#clients-table').slideToggle();
        }else if($scope.tables == "employees"){
            $('#clients-table').css('display', 'none');
            $('#courses-table').css('display', 'none');
            getEmployeesInfo();
            $('#employees-table').slideToggle();
        }else if($scope.tables == "courses"){
            $('#employees-table').css('display', 'none');
            $('#clients-table').css('display', 'none');
            getCoursesInfo();
            $('#courses-table').slideToggle();

        }
    };

        $scope.showCourseDetails = function(ev, currentPlan) {
                $mdDialog.show({
                  controller: function ($mdDialog, $scope, $http) {
                                  var vm = this;
                                  vm.currentPlan = {};
                                  vm.currentPlan = currentPlan;  //your task object from the ng-repeat

                                  $http.get('/teams/'+currentPlan.teamId).success(function (data) {
                                     $scope.teamDetails = data;
                                     $http.get('/courses/'+data.courseId).success(function (data2) {
                                        $scope.courseDetails = data2;
                                     });
                                  });

                                  $scope.hide = function () {
                                      $mdDialog.hide();
                                  };
                                  $scope.cancel = function () {
                                      $mdDialog.cancel();
                                  };
                              },
                  controllerAs: 'modal',
                  templateUrl: '../templates/courseDetailForm.html',
                  parent: angular.element(document.body),
                  targetEvent: ev,
                  clickOutsideToClose:true,
                })
                .then(function() {
                })
        };

        $scope.showEmpContracts = function(ev, currentEmployee) {
                        $mdDialog.show({
                          controller: function ($mdDialog, $scope, $http) {
                                          var vm = this;
                                          vm.currentEmployee = {};
                                          vm.currentEmployee = currentEmployee;  //your task object from the ng-repeat

                                          $http.get('/contracts/employee/'+currentEmployee.id).success(function (data) {
                                             $scope.contracts = data;
                                          });

                                          $scope.hide = function () {
                                              $mdDialog.hide();
                                          };
                                          $scope.cancel = function () {
                                              $mdDialog.cancel();
                                          };
                                      },
                          controllerAs: 'modal',
                          templateUrl: '../templates/contracts.html',
                          parent: angular.element(document.body),
                          targetEvent: ev,
                          clickOutsideToClose:true,
                        })
                        .then(function() {
                        })
                };

        $scope.showClientCards = function(ev, currentClient) {
                                $mdDialog.show({
                                  controller: function ($mdDialog, $scope, $http) {
                                                  var vm = this;
                                                  vm.currentClient = {};
                                                  vm.currentClient = currentClient;  //your task object from the ng-repeat

                                                  $http.get('/cards/client/'+currentClient.id).success(function (data) {
                                                     $scope.cards = data;
                                                  });

                                                  $scope.hide = function () {
                                                      $mdDialog.hide();
                                                  };
                                                  $scope.cancel = function () {
                                                      $mdDialog.cancel();
                                                  };
                                              },
                                  controllerAs: 'modal',
                                  templateUrl: '../templates/cards.html',
                                  parent: angular.element(document.body),
                                  targetEvent: ev,
                                  clickOutsideToClose:true,
                                })
                                .then(function() {
                                });
                        };

}]);
