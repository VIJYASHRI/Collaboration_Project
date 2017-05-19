app.factory('UserService',function($http){
	var userService={}
	var BASE_URL="http://localhost:8080/CollaborationBack"
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/register",user);
	}
	
	userService.login=function(user){
		return $http.post(BASE_URL + "/login",user)
	}
	userService.logout=function(){
		return $http.put(BASE_URL + "/logout");
	}
	userService.getUser=function(){
		return $http.get(BASE_URL + "/getuser");
	}
	
	userService.updateUesr=function(){
		return $http.put(BASE_URL + "updateuser")
	}
	return userService;
})