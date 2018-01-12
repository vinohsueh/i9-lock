var lockEditNgModule = angular.module('lockEditNgModule', [ 'ngResource',
		'ngCookies', 'ui.bootstrap', 'toaster', 'app' ]);

var lockEditCtrl = lockEditNgModule.controller('lockEditCtrl', function($scope,
		$rootScope, $modalInstance, $cookieStore, $http, $window, toaster,
		lock,httpService) {
	
	$scope.lock = lock;
	$scope.closeBtn = function() {
		$modalInstance.dismiss('cancel');
	}	
});
