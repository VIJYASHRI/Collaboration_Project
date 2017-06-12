app.factory('FriendService',function($http,FriendService){
	var friendService={}
	var BASE_URL="http://localhost:8080/CollaborationBack"
		
	friendService.getAllUsers=function(){
		return $http.get(BASE_URL + "/getAllUsers")
	}
	
	friendService.sendFriendRequest=function(username){
		return $http.put(BASE_URL + "/friendRequest/"+username)
	}
	friendService.pendingRequests=function(){
		return $http.get(BASE_URL + "/pendingRequests")
	}
	friendService.updatependingRequests=function(from, status){
		return $http.put(BASE_URL + "/updatependingRequests/"+from+"/"+status)
	}
	friendService.getAllFriends=function(){
		return $http.get(BASE_URL + "/friendslist")
	}
	
	return friendService;
})