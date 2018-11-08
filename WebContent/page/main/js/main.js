angular.module("app",["hc.lib"]).controller("mainController",['$scope', '$rootScope', 
	'$stateParams', '$state',"$http", "$q","util",function($scope, $rootScope,$stateParams,
			///这里注入的时候有一个问题 如果i18nService存在着问题，那么写在其后的注入类都将失效，这是测试得到的结果
			$state, $http, $q,util,i18nService){
	//i18nService.setCurrentLang('zh-cn');
	util.post("userController/testGetSessionInfo",{userId:"waystone",password:"1"}).then(
		function(data){
			console.log(data) ;
		},function(errorData){
			console.log(errorData) ;
		}
	)
	
	$scope.getUserList = function(){
		util.post("userController/getUserList",{}).then(
			function(data){
				console.log(data) ;
			},function(msg){
				
				
			}
		)
		
	}
	
	$scope.testEhcacheFun = function(){
		util.post("userController/testEhcacheFun",{}).then(
			function(data){
				console.log(data) ;
			},function(errorData){
				console.log(errorData) ;
			}
		)
	}
	$scope.deltestEhcacheFun = function(){
		util.post("userController/deltestEhcacheFun",{}).then(
			function(data){
				console.log(data) ;
			},function(errorData){
				console.log(errorData) ;
			}
		)
	}
	
	$scope.getUserRoleResources = function(){
		util.post("userController/getUserRoleResources",{}).then(
			function(data){
				console.log(data) ;
			},function(errorData){
				console.log(errorData) ;
			}
		)
	}
	
	$scope.getMenuList = function(){
		util.post("userController/getMenuList",{}).then(
			function(data){
				console.log(data) ;
			},function(errorData){
				console.log(errorData) ;
			}
		)
	}
	
	$scope.getMemoList = function(){
		util.post("userController/getMemoList",{}).then(
			function(data){
				console.log(data) ;
			},function(errorData){
				console.log(errorData) ;
			}
		)
	}
}])