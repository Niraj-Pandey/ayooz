var app = angular.module('myApp', ['angularBeans']);
app.controller('myCtrl', function($scope,helloBean) {
	$scope.sayHello = function(name) {
		helloBean.sayHello(name).then(function(result){
			$scope.result=result;	
		});
	}
});