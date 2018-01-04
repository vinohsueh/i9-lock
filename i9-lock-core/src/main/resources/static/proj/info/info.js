var infoNgModule=angular.module('infoNgModule',['ngAnimate','ui.bootstrap','app']);
var infoService = infoNgModule.factory('infoService',
		['$resource', function($resource){
			//指定url格式:../模块名/服务名/方法名?参数
			var path = '../rest/:moduleName/:serviceName/:methodName?rnd=:random';
			//service忠的方法
			var resource = $resource(path, {}, {
				save : {
					method : 'POST',
					params : {
						moduleName : 'proj',
						serviceName : 'info',
						methodName : 'save',
						//role : '@role',
						//rp : '@rp',
						random : Math.random()
					}
				},
			});
			return resource;
	}]);
var infoNgControl=infoNgModule.controller('infoNgControl',function($rootScope, $scope,$stateParams,  $log, $http, $window, $state,$modal, toaster,infoService,httpService){

	$scope.publish = function(){
		if($scope.info != null){
			if($scope.info.content.length>200 || $scope.info.content.length<=0){
				$.toaster({
					title : "Error",
					priority : "danger",
					message : "字数在0-200字"
				});
				return false;
			}
			confirm("确定发布吗?", "", function (isConfirm) {
	            if (isConfirm) {
	            	httpService.post({url:'./info/add',data:$scope.info,showSuccessMsg:true}).then(function(data) {  
	        		})
	            } else {
	            }
	        }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
		}else{
			$.toaster({
				title : "Error",
				priority : "danger",
				message : "发布内容不能为空"
			});
		}
	}
})