app.factory('BlogService', function($http) {
	var blogService = {}
	var BASE_URL = "http://localhost:8080/CollaborationBack"

	blogService.saveBlogPost = function(blog) {
		return $http.post(BASE_URL + "/saveBlogPost", blog)
	}

	blogService.getAllBlogs = function() {
		return $http.get(BASE_URL + "/list/"+1)
	}
	blogService.getAllBlogs = function() {
		return $http.get(BASE_URL + "/list/" + 0)
	}
	blogService.getBlogPostedById = function(id) {
		return $http.get(BASE_URL + "/get/", + id)
	}
	

	blogService.addBlogComment = function(blogComment) {
		return $http.post(BASE_URL + "/addComment", blogComment)
	}

	blogService.getBlogComments = function(blogPostId) {
		return $http.get(BASE_URL + "/getBlogComments/")
	}
	return blogService;
})