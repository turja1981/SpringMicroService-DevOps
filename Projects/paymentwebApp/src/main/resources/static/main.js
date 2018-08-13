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
		console.log(billingInfo);
		$http.post("http://API-Gateway:8084/eft/setup",billingInfo, headers).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.billingInfo = eval(response.data);
			}
		});
	}
	$scope.sendCardPayment = function(billingInfo) {

		$http.post("http://API-Gateway:8084/card/setup", billingInfo, headers).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.billingInfo = eval(response.data);
			}
		});
	}

	$scope.getBankName = function(routingNo) {
		console.log(routingNo)
		$http.get("http://API-Gateway:8084/eft/routing/"+ routingNo, headers).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.billingInfo.bankName = response.data.bankName;
			}
		});
	}	
});

