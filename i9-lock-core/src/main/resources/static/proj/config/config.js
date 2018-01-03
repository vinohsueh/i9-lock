var configNgModule=angular.module('configNgModule',['ngAnimate','ui.bootstrap','app']);
var configService = configNgModule.factory('configService',
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
var configNgControl=configNgModule.controller('configNgControl',function($rootScope, $scope,$stateParams,  $log, $http, $window, $state,$modal, toaster,configService,httpService){
	//初始化
	$scope.initTable = function (){
		httpService.post({url:'./config/pageConfig',showSuccessMsg:false}).then(function(data) {  
			$scope.configs= data.data.data;
			for(var i = 0;i<$scope.configs.length;i++){
				if ($scope.configs[i].configKey == "maxHirer"){
					$scope.maxHirer = $scope.configs[i];
				}else if($scope.configs[i].configKey == "maxPassword"){
					$scope.maxPassword = $scope.configs[i];
				}
			}
		})
	};
	$scope.initTable();
    //编辑
    $scope.modify1 = function () { 
    	httpService.post({url:'./config/updateConfig',data:$scope.maxHirer,showSuccessMsg:true}).then(function(data) {  
		})
    };  
    $scope.modify2 = function () { 
    	httpService.post({url:'./config/updateConfig',data:$scope.maxPassword,showSuccessMsg:true}).then(function(data) {  
		})
    };  
})