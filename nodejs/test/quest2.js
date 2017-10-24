// 1. 서버 모듈(라이브러리)을 import
var http = require("http");

var count = 0;

// 2. 서버 모듈을 사용해서 서버를 정의    // req= 요청, res = 응답
var server = http.createServer(function(request, response){
	
	// 사용자 요청에 대해 어떻게 응답할지를 정의
	// count ++;
	// response.write("guests : " + count);
	// response.write("url : " + request.url);
	
	var array = request.url.split("/");
	
	// 2-1. 일반 for문은 배열의 index를 리턴
	// for (i in array)
	//   response.write(" ["+array[i]+"] ");


	// 2-2. 향상된 for문은 배열안의 실제 item을 리턴
	response.writeHead(200, {'Content-Type':'text/html'});
	
	array.forEach(function(item){
		response.write(" ["+item+"] </br>");
	});
	
	response.end("");
	
});

// 3. 서버 실행
server.listen(8089, function() {
	console.log("server is running ...")
});