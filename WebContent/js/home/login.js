angular.module("app").controller("loginController",['$scope', '$rootScope', 
	'$stateParams', '$state',"$http", "$q",
	function($scope, $rootScope,$stateParams,
		$state, $http, $q,i18nService) {
	//i18nService.setCurrentLang('zh-cn');
	$scope.loginFun = function(){
		
		//$state.go('main');
		
		$http.post("userLoginController/getUserLoginInfo",{userId:"waystone",password:"1"}).then(
			function(data){
				console.log(data) ;
				$state.go('main');
			},function(errorData){
				console.log(errorData) ;
			}
		)
		/*$http({
		    method : 'POST',
		    url : "userLoginController/getUserLoginInfo",
		    data: {userId:"waystone",password:"1"}
		}).success(function(data, status, headers, config) {
		    console.log(data);
		}).error(function(data, status, headers, config) {
		     
		});*/
	}
}])