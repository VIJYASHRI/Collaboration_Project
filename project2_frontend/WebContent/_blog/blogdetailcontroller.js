app.controller('BlogDetailController',function($routeParams,n$location, $scope, BlogService){
	var id=$routeParams.id
	//instead of writing function and calling explicitly, we can call the service function directly
	$scope.blogPost= BlogService.getBlogPostedById(id) //calling service function directly
	.then(function(response){
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
	$scope.getBlogComments=function(blogPostId){
		$scope.showcomments=true;
		$scope.blogComments=BlogService.getBlogComments(blogPostId)
		.then(function(response){
			$scope.blogComments=response.data;
		},function(response){
			console.log(response.status);
		})
	}
	$scope.updateApproval=function(){
		BlogService.updateApproval($scope.blogPost)
		.then(function(response){
			$location.path("/getAllBlogs")
		},function(response){
			console.log(response.status);
		})
	}

	})
