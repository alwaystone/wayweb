angular.module('hc.lib', [])
    //模块管理服务
    .factory("util", function ($http, $q,$log) {
        var api = {
            //提交数据
            post:function (uri, params) {
		        return $http.post(uri,
		        		params)
		        .then(function (resp) {
		            /*if (resp.data && resp.success){
		                return resp.data
		            }else if (!resp.message&&resp.timeOut) {
		            	if(resp.data.message=="No login."){
		            		window.location.href = "login.html";
		            	}else{
            				return $q.reject(resp.data.message)
		            	}
		            	console.log("time out") ;
		            }else {
		               return $q.reject("操作失败")
		            }*/
		        	console.log(resp) ;
		        	return resp ;
		        },function (msg) {
		        	console.log("======================================") ;
					return $q.reject("网络超时，请检查网络！")
		     	})
		    },
            //提交文件
            postFile: function (uri, params, fileName, files) {
                var deferred = $q.defer();
                uiUploader.removeAll();
                uiUploader.addFiles(files);
                uiUploader.startUpload({
                    url: uri,
                    concurrency: 10,
                    onCompleted: function (file, response, status) {
                        try {
                            response.data = angular.fromJson(response.responseText)
                        }
                        catch (e) {
                            response.data = response.responseText
                        }
                        if (status == 200) {
                            deferred.resolve(response)
                        }
                        else {
                            deferred.reject(response)
                        }
                        //
                    },
                    key: fileName,
                    data: params
                });
                return deferred.promise
            },
            get: function (uri) {
                return $http.get(uri
                    , {
                        headers: {
                            'If-Modified-Since': "0",
                            "Cache-Control": "no_cache",
                            "Pragma": "no-cache",
                            "Expires": "-1"
                        }
                    })
            },
            getFilePost:function(url,params,fileName){
            	$http.post(url,params, {responseType: "blob"})
            	.success(function (data) {
			                var blob = new Blob([data],{type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
			                var a = document.createElement("a");  
			                document.body.appendChild(a);
			                a.download = fileName+(new Date()).valueOf();
			                a.href = URL.createObjectURL(blob);
			                a.click();  
	            })
            }
        }
        return api;
    })
