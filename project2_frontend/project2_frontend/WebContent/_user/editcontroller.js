app.controller('EditController',function($scope,UserService,$location,$rootScope){
	$scope.user=UserService.getUser()
		.then(function(response){
			$scope.user=response.data
			console.log(response.data);
			},function (response){
				console.log(response.status)
			$location.path('/login')
			})
			
	$scope.updateUser=function(){
		UserService.updateUser($scope.user)
		.then(function(response){
			console.log(response.status)
			$location.path('/home')
	},function(response){
		console.log(response.status)
		$location.path('/edituser')
	})
	}	
})
