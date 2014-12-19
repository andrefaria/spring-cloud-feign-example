<!DOCTYPE HTML>
<html ng-app="myApp">
<head>
    <title>Spring Cloud + Feign Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.7/angular.min.js"></script>
    <script>

        angular.module('myApp', [])
                .controller('GitHub', ['$scope','$http', function($scope, $http) {
                    $scope.change = function() {
                        var url = '/' + $scope.owner + '/' + $scope.repo;
                        $http.get(url).
                                success(function (data) {
                                    $scope.contributors = data;
                                }).failure(function(){
                                    $scope.contributors = [];
                                });
                    };
                }]);
    </script>


</head>

<body>
<h1>List Git Hub Repository Contributors</h1>

<div ng-controller="GitHub">

    Owner: <input name="owner" ng-model="owner" type="text" ng-blur="change()"/>
    Repo: <input name="repo" ng-model="repo" type="text" ng-blur="change()"/>
    <br/>
    <br/>


    <h4>Contributors of {{repo}}</h4>
    <div ng-repeat="c in contributors">
        <span>{{c.login}}: {{c.contributions}} contributions.</span>
    </div>

    <div ng-show="contributors.length == 0">
        Repository not found
    </div>

</div>


</body>
</html>