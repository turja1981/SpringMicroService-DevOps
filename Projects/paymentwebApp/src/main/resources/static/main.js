/**
 * 
 */
var app = angular.module("myApp", []);

app.controller("myController", function($scope, $http, $location) {
	var headers = {
			'Access-Control-Allow-Origin' : '*',
			'Access-Control-Allow-Methods' : 'POST, GET, OPTIONS, PUT',
			'Content-Type': 'application/json',
			'Accept': 'application/json'
		};

	$scope.searchCustomer = function(searchPolicyNumber) {

		$http.get("http://172.18.0.6:3334/payments/" + searchPolicyNumber).then(function(response) {
			if (response.data) {
				console.log(response.data);
				$scope.billingInfo = eval(response.data);
			}
		});
	}
	
	$scope.sendEFTPayment = function(billingInfo) {

		$http.post("http://172.18.0.7:3336/eft/", billingInfo , headers).then(function(response) {
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
