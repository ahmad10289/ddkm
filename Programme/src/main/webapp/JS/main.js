var app = angular.module('myApp', []);
app.controller('fetchCtrl', function($scope, $http) {
	 $http.get("http://192.168.1.112:8080/Programme/v1/operations")
    .error(function() {
    	alert('Repository error');
})
    .success(
    		function(response) {
    			console.log(response); 		
    			$scope.names = response.response;
     });
    
    
});

app.controller('addCtrl', function($scope, $http) {
	
	$scope.clearData = function(){		
		$scope.fileID=undefined;
		$scope.program=undefined;
		$scope.episodeNumber=undefined;				
		$scope.producerName=undefined;
		$scope.mediaNumber=undefined;
		$scope.mediaType=undefined;
		$scope.genre=undefined;
		$scope.qualityControl=undefined;
		$scope.qualityRemark=undefined;
		$scope.mediaFormat=undefined;
		$scope.participant=undefined;
	}
	
	$scope.addData = function(){
		var config={
				headers:{
						"Content-Type": "application/json"
				}
		}
		var data={requestType:"create",				
				programmeArchivedList:[{
				fileID:$scope.fileID,
				programmeName:$scope.program,
				episodeNumber:$scope.episodeNumber,				
				producerName:$scope.producerName,
				mediaNmumber:$scope.mediaNumber,
				meadiType:$scope.mediaType,
				genre:$scope.genre,	
				qualityControl:$scope.qualityControl,
				qualityRemark:$scope.qualityRemark,
				mediaFormat:$scope.mediaFormat,
				participant:$scope.participant
				}]
		};
		/*alert("1. "+data.programmeName+"\n2. "+data.episodeNumber+"\n3. "+data.producerName+
				"\n4. "+data.mediaNumber+"\n5. "+data.meadiType+"\n6. "+data.genre+
				"\n7. "+data.qualityControl+"\n8. "+data.qualityRemark+"\n9. "+data.mediaFormat
				+"\n10. "+data.participant
				);*/
		console.log("post"+data);
		data=JSON.stringify(data);
		console.log("post"+data);
		$http.post("http://192.168.1.112:8080/Programme/v1/operations",data).success(function(data,status,headers){
			alert("Program data added successfully!!");
			$scope.clearData();
			$http.get(headers("location")).success(function(data){
				$scope.names.push(data);
				alert("pranay data added and dat is "+$scope.names);
			});
		});
			
		//alert("pranay"+$scope.program);
	};
});




