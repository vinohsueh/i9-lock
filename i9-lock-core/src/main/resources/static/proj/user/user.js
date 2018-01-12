var userNgModule=angular.module('userNgModule',['ngAnimate','ui.bootstrap','app']);
var userService = userNgModule.factory('userService',
		['$resource', function($resource){
			//指定url格式:../模块名/服务名/方法名?参数
			var path = '../rest/:moduleName/:serviceName/:methodName?rnd=:random';
			//service中的方法
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
var userNgControl=userNgModule.controller('userNgControl',function($rootScope, $scope,$stateParams,  $log, $http, $window, $state,$modal, toaster,userService,httpService){
	//分页条件
	$scope.pageSize = 10;
	$scope.currentPage = 1;
	
	//初始化
	$scope.initTable = function (){
		var searchText = $scope.searchText;
		
		var pageParam = {
				pageSize:$scope.pageSize,
				currentPage:$scope.currentPage,
				username:searchText,
				phone:searchText,
				familyPhone:searchText				
			};
		
		httpService.post({url:'./user/pageUser',data:pageParam,showSuccessMsg:false}).then(function(data) {  
			$scope.users = data.data.data.pageList;
			$scope.hasPrevious = data.data.data.hasPrevious;
			$scope.currentPage = data.data.data.currentPage;
			$scope.hasNext = data.data.data.hasNext;
			$scope.total = data.data.data.totalSize;
			$scope.start = data.data.data.offset+1;
			$scope.end = data.data.data.offset+$scope.users.length;
			$scope.pages = data.data.data.loopPageNum;
			$scope.currentPage = pageParam.currentPage;
		})
	};
	$scope.initTable();
	//修改分页大小
	$scope.changePageSize = function(){
		$scope.currentPage = 1;
		$scope.initTable();
	}
	//上一页
	$scope.lastPage = function(){
		if ($scope.hasPrevious){
			$scope.currentPage -=1;
			$scope.initTable();
		}
	}
	//下一页
	$scope.nextPage = function (){
		if ($scope.hasNext){
			$scope.currentPage +=1;
			$scope.initTable();
		}
	}
	//跳转
	$scope.pageTo = function(page){
		$scope.currentPage = page;
		$scope.initTable();
	}
	$scope.search = function(){
		$scope.initTable();
	}
	

   
    
})