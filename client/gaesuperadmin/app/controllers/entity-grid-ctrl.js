angular.module('gaesuperadmin').controller('EntityGridController', function($scope) {

    $scope.students = [
               {fname:'Yashvir',lname:'Surana',sid:'1368177'},
               {fname:'Aman', lname:'Surana', sid:'1358148'},
               {fname:'Raghuvir', lname:'Surana', sid:'1459159'},
               {fname:'Sudha', lname:'Surana', sid:'1469124'},
               {fname:'Rani', lname:'Surana', sid:'1353258'}];

    $scope.addStudent = function (entity) {
        console.log('Adding new entity in list');
        $scope.successMessage = true;
        $scope.students.push(entity);
    };

    $scope.deleteStudent = function(index) {
        $scope.students.splice(index, 1);
    };
});
