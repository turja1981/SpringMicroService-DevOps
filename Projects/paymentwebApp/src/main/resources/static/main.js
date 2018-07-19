/**
 * 
 */

var app = angular.module("myApp", []);


app.controller("myController",function($scope, $http, $location) {

	$scope.sendPayment = function(paymentDetail) {
		$http.post("http://172.18.0.5:3333/sendPayment",
				JSON.stringify(paymentDetail)).then(function(response) {
					if (response.data) {
						console.log(response.data);
						$scope.msg = "Payment Successful";
					}
				});
	}
});
app.controller("showController", ['$scope', '$http', '$location', function($scope, $http, $location) {	
	$http.get("http://localhost:8098/Payments").then(function(response) {
		$scope.allPayment = eval(response.data);
		console.log(response.data);
	});
	$scope.editPayment = function(id) {
		$http.get("http://localhost:8098/Payments/" + id).then(
				function(response) {
					if (response.data) {
						console.log(response.data);
					}
				});
	}
}]);
