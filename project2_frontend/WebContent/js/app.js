var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider){
	$routeProvider
	.when('/register',{
		templateUrl:'_user/registerUser.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'_user/login.html',
		controller:'UserController'
	})
	.when('/home',{
		templateUrl:'_home/home.html'
	})
})
app.run(function($rootScope,$cookieStore,UserService,$location){
	console.log('entering running method ')
	console.log($rootScope.currentUser)
	if($rootScope.currentUser==undefined){
		$rootScope.currentUser=$cookieStore.get("currentUser")
		console.log($rootScope.currentUser)
	}
	
})