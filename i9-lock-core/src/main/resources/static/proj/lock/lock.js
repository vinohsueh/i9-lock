var lockNgModule=angular.module('lockNgModule',['ngAnimate','ui.bootstrap','app']);
var lockService = lockNgModule.factory('lockService',
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
var lockNgControl=lockNgModule.controller('lockNgControl',function($rootScope, $scope,$stateParams,  $log, $http, $window, $state,$modal, toaster,lockService,httpService){
	//分页条件
	$scope.pageSize = 10;
	$scope.currentPage = 1;
	
	//初始化
	$scope.initTable = function (){
		var searchText = $scope.searchText;
		var pageParam = {
				pageSize:$scope.pageSize,
				currentPage:$scope.currentPage,
				orderByClause:"createTime desc",
				name: searchText,
				keyUser: searchText,
				keyNumber: searchText,
				phone: searchText,
			};
		httpService.post({url:'./lock/pageLock',data:pageParam,showSuccessMsg:false}).then(function(data) {  
			$scope.locks = data.data.data.pageList;
			$scope.hasPrevious = data.data.data.hasPrevious;
			$scope.currentPage = data.data.data.currentPage;
			$scope.hasNext = data.data.data.hasNext;
			$scope.total = data.data.data.totalSize;
			$scope.start = data.data.data.offset+1;
			$scope.end = data.data.data.offset+$scope.locks.length;
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
	$scope.search = function () { 
		$scope.initTable();
	}
	$scope.add = function () {  
        var modalInstance = $modal.open({  
            templateUrl: 'proj/lock/add.html',  
            controller: 'lockEditCtrl', 
            backdrop:"static",//但点击模态窗口之外时，模态窗口不关闭
            resolve: {  
            	deps : ['$ocLazyLoad',function($ocLazyLoad) {
        			return $ocLazyLoad.load({
        				name : 'lockEditNgModule',
        				insertBefore : '#ng_load_plugins_before',
        				files : [
        				         'proj/lock/add.js',
        				]
        			});
        		}],
        		lock: function () {  
                    return {};  
                },
            }  
        }); 
        modalInstance.result.then(function(data){//$modalInstance.close()正常关闭后执行的函数
            $scope.selected = data;
        },function(){//$modalInstance.dismiss('cancel')后执行的函数，取消或退出执行的函数
        	$scope.initTable();
        });
         
    };  
    //编辑
    $scope.edit = function (id) { 
    	httpService.post({url:'./lock/getLock',data:id,showSuccessMsg:false}).then(function(data) {  
    		$scope.lock = data.data.data;
			var modalInstance = $modal.open({  
	            templateUrl: 'proj/lock/add.html',  
	            controller: 'lockEditCtrl', 
	            backdrop:"static",//但点击模态窗口之外时，模态窗口不关闭
	            resolve: {  
	            	deps : ['$ocLazyLoad',function($ocLazyLoad) {
	        			return $ocLazyLoad.load({
	        				name : 'lockEditNgModule',
	        				insertBefore : '#ng_load_plugins_before',
	        				files : [
	        				         'proj/lock/add.js',
	        				]
	        			});
	        		}],
	            	lock: function () {  
	                    return $scope.lock;  
	                },
	            }  
	        });
			modalInstance.result.then(function(data){//$modalInstance.close()正常关闭后执行的函数
	            $scope.selected = data;
	        },function(reason){//$modalInstance.dismiss('cancel')后执行的函数，取消或退出执行的函数
	        	$scope.initTable();
	        });
    	})
    };  
})