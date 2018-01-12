var userEditNgModule = angular.module('userEditNgModule', [ 'ngResource',
		'ngCookies', 'ui.bootstrap', 'toaster', 'app' ]);

var userEditCtrl = userEditNgModule.controller('userEditCtrl', function($scope,
		$rootScope, $modalInstance, $cookieStore, $http, $window, toaster,
		user,httpService) {
	
	$scope.user = user;
	$scope.closeBtn = function() {
		$modalInstance.dismiss('cancel');
	}
	// 确认添加
	$scope.confirmAdd = function() {
		if ($scope.user.username ==null ||$scope.user.username ==0) {
			$.toaster({
				title : "Error",
				priority : "danger",
				message : "用户名不能为空!"
			});
			return false;
		}
		if ($scope.user.password ==null ||$scope.user.password ==0) {
			$.toaster({
				title : "Error",
				priority : "danger",
				message : "密码不能为空!"
			});
			return false;
		}
		httpService.post({url:'./user/addUser',data:$scope.user,showSuccessMsg:true}).then(function(data) {  
			$modalInstance.dismiss('cancel')
		})
	};
	
});
