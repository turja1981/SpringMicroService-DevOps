/**
 * 
 */

var app = angular.module("myApp", []);


app.controller("myController",function($scope, $http, $location) {

	$scope.sendPayment = function(paymentDetail) {
		$http.post("http://API-Gateway:8084/sendPayment",
				JSON.stringify(paymentDetail)).then(function(response) {
					if (response.data) {
						console.log(response.data);
						$scope.paymentDetail = eval(response.data);
					}
				});
	}
});
app.controller("showController", ['$scope', '$http', '$location', function($scope, $http, $location) {	
	$http.get("http://API-Gateway:8084/payments").then(function(response) {
		$scope.allPayment = eval(response.data);
		console.log(response.data);
	});
	$scope.editPayment = function(id) {
		$http.get("http://showPayment:3334/payments/" + id).then(
				function(response) {
					if (response.data) {
						console.log(response.data);
					}
				});
	}
}]);
