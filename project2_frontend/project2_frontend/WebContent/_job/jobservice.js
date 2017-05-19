app.factory('JobService',function($http){
	var jobService={}
	
	var BASE_URL="http://localhost:8080/project2_Backnd/"
	
	jobService.saveJob=function(job){
		return $http.post(BASE_URL + "/saveJob",job)
	}
	
	jobService.getAllJobs=function(){
		return $http.get(BASE_URL + "/getAllJobs")
	}
	
	jobService.getJobDetail=function(id){
		return $http.get(BASE_URL + "/getJob/" +id)
	}
	
	return jobService;
})