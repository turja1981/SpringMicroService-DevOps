/**
 * 
 */
var app = angular.module("myApp", []);

app.controller("myController", function($scope, $http, $location) {
	var headers = {

		'Content-Type' : 'application/json',

	};

	$scope.searchCustomer = function(searchPolicyNumber) {

		$http.get("http://API-Gateway:8084/payment/payments/" + searchPolicyNumber).then(
				function(response) {
					if (response.data) {
						console.log(response.data);
						$scope.billingInfo = eval(response.data);
					}
				});
	}

	$scope.sendEFTPayment = function(billingInfo) {

		$http.post("http://API-Gateway:8084/eft/setup", angular.toJson($scope.billingInfo),
				headers).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.msg = eval(response.data);
			}
		});
	}
	$scope.sendCardPayment = function(billingInfo) {

		$http.post("http://API-Gateway:8084/card/setup", angular.toJson($scope.billingInfo),
				headers).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.msg = eval(response.data);
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
