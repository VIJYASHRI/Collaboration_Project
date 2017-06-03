app.controller('Editcontroller',function($scope,UserService,$location,$rootScope){
	$scope.User=UserService.getUser()
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
