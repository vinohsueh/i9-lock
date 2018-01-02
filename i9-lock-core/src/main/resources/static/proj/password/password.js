var passwordNgModule=angular.module('passwordNgModule',['ngAnimate','ui.bootstrap','app']);
var passwordService = passwordNgModule.factory('passwordService',
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
var passwordNgControl=passwordNgModule.controller('passwordNgControl',function($rootScope, $scope,$stateParams,  $log, $http, $window, $state,$modal, toaster,passwordService,httpService){
	//分页条件
	$scope.pageSize = 10;
	$scope.currentPage = 1;
	
	//初始化
	$scope.initTable = function (){
		var searchText=$scope.searchText;	
		var pageParam = {
				pageSize:$scope.pageSize,
				currentPage:$scope.currentPage,
				name:searchText,
				lockNumber:searchText,
				lockName:searchText,
				userName:searchText,
				userPhone:searchText,
			};
		
		httpService.post({url:'../password/pagePassword',data:pageParam,showSuccessMsg:false}).then(function(data) {  
			$scope.passwords= data.data.data.pageList;
			$scope.hasPrevious = data.data.data.hasPrevious;
			$scope.currentPage = data.data.data.currentPage;
			$scope.hasNext = data.data.data.hasNext;
			$scope.total = data.data.data.totalSize;
			$scope.start = data.data.data.offset+1;
			$scope.end = data.data.data.offset+$scope.passwords.length;
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
	//查询
	$scope.search = function(){
		$scope.initTable();
	}
	
//	$scope.add = function () {  
//        var modalInstance = $modal.open({  
//            templateUrl: '/proj/password/add.html',  
//            controller: 'passwordEditCtrl', 
//            backdrop:"static",//但点击模态窗口之外时，模态窗口不关闭
//            resolve: {  
//            	deps : ['$ocLazyLoad',function($ocLazyLoad) {
//        			return $ocLazyLoad.load({
//        				name : 'passwordEditNgModule',
//        				insertBefore : '#ng_load_plugins_before',
//        				files : [
//        				         'proj/password/add.js',
//        				]
//        			});
//        		}],
//        		password: function () {  
//                    return {};  
//                },
//            }  
//        }); 
//        modalInstance.result.then(function(data){//$modalInstance.close()正常关闭后执行的函数
//            $scope.selected = data;
//        },function(){//$modalInstance.dismiss('cancel')后执行的函数，取消或退出执行的函数
//        	$scope.initTable();
//        });
//         
//    };  
    //编辑
    $scope.edit = function (id) { 
    	httpService.post({url:'../password/getPassword',data:id,showSuccessMsg:false}).then(function(data) {  
    		$scope.password = data.data.data;
			var modalInstance = $modal.open({  
	            templateUrl: '/proj/password/passwordUpdate.html',  
	            controller: 'passwordEditCtrl', 
	            backdrop:"static",//但点击模态窗口之外时，模态窗口不关闭
	            resolve: {  
	            	deps : ['$ocLazyLoad',function($ocLazyLoad) {
	        			return $ocLazyLoad.load({
	        				name : 'passwordEditNgModule',
	        				insertBefore : '#ng_load_plugins_before',
	        				files : [
	        				         'proj/password/passwordUpdate.js',
	        				]
	        			});
	        		}],
	            	password: function () {  
	                    return $scope.password;  
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
//    $scope.del = function(id){
//    	confirm("确定删除吗?", "", function (isConfirm) {
//            if (isConfirm) {
//            	$http.post('../password/delPassword',id).success(function(data){
//        			if (data.result == 1) {
//        				$.toaster({
//        					title : "Success",
//        					priority : "success",
//        					message : "成功！"
//        				});
//        				$scope.initTable();
//        			}else{
//        				$.toaster({
//        					title : "Error",
//        					priority : "danger",
//        					message : data.errorMsg
//        				});
//        			}
//        		}).error(function(data){
//        			$.toaster({
//        				title : "Error",
//        				priority : "danger",
//        				message : "请求错误！"
//        			});
//        		});
//            } else {
//            }
//        }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
//    }
})