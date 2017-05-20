app.controller('BlogDetailController',function($routeParams,$scope,BlogService){
	var id=$routeParams.id
	//instead of writing function and calling explicitly, we can call the service function directly
	$scope.blogPost=
	BlogService.getBlogDetail(id) //calling service function directly
	.then(function(response){
	console.log(response.data);
	console.log(response.status)
	$scope.blogPost=response.data; 
	},function(response){
	console.log(response.status)
	})
	$scope.addBlogComment=function(){
		$scope.blogComment.blogPost=$scope.blogPost;   //blogComment.setBlogPost(blogPost)
	BlogService.addblogComment($scope.blogComment)
	.then(function(response){
		console.log(response.status);
	},function(response){
	console.log(response.status)
	})
	}
})
