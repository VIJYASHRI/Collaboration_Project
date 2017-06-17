app.controller(
				"BlogController",
				function($scope, $location, BlogService,$rootScope) {
					$scope.saveBlogPost = function() {
						BlogService.saveBlogPost($scope.blog)
								.then(function(response) {
											alert("Your blog is posted successfully and it is waiting for approval from admin");
											$rootScope.blogPostId=$scope.bolg.id;
											$location.path('/getAllBlogs')
										}, function(response) {
											console.log(response.status)
											console.log(response.data)
											$scope.message=response.data.message
											$location.path('/addPost')
										})
					}
					
						$scope.blogPosts=BlogService.getAllBlogs()
							.then(function(response) {
						$scope.blogPosts=response.data;
							}, function(response) {
								console.log(response.status)
							})
							
					/*$scope.postsForApproval=BlogService.getAllBlogsForApproval()
							.then(function(response) {
								$scope.postsForApproval = response.data;
								$scope.showpostsForApproval=true
							}, function(response) {
								console.log(response.status)
							})*/
					
				})