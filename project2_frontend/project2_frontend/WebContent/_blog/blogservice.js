app.factory('BlogService',function($http){
	var blogService={}
	var BASE_URL="http://localhost:8080/project2_Backnd/"
	
	blogService.saveBlogPost=function(blog){
		return $http.post(BASE_URL + "/saveBlogPost",blog)
	}	

	blogService.getBlogDetail=function(id){
		return $http.get("http://localhost:8080/project2_Backnd/get/"+ id)
		}
	return blogService;
})