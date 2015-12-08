var app = angular.module('myApp', ['angularBeans']);
app.controller('myCtrl', function($scope,helloBean) {
	$scope.getMessage = function(name) {
		helloBean.getMessage(name).then(function(result){
			$scope.result=result;	
		});
	}
});