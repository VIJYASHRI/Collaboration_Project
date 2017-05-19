app.controller("BlogController",function($scope,$location,BlogService){
	$scope.saveBlogPost=function(){
		BlogService.saveBlogPost($scope.blog)
		.then(function(response){
			$scope.successMessage="Your blog is posted successfully and it is waiting for approval from admin";
			$location.path('/getAllBlogs')
		},function(response){
			console.log(response.status)
			$location.path('/login')
		})
	}
})