/**
 * 
 */
var app = angular.module("myApp", []);

app.controller("myController", function($scope, $http, $location) {

	$scope.searchCustomer = function(searchPolicyNumber) {
		$http.get("http://172.18.0.6:3334/payments/" + searchPolicyNumber).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.billingInfo = eval(response.data);
			}
		});
	}
});
app.controller("showController", [
		'$scope',
		'$http',
		'$location',
		function($scope, $http, $location) {
			$http.get("http://API-Gateway:8084/showpayment/payments").then(
					function(response) {
						$scope.allPayment = eval(response.data);
						console.log(response.data);
					});

		} ]);
