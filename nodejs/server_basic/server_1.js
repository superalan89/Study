// 1. 서버모듈 가져오기
var h = require("http");
var url = require("url");
var qs = require("querystring");

// 2. 서버 생성하기
var s = h.createServer(function(request, response) {
	
	var parsedUrl = url.parse(request.url);
	console.log(parsedUrl);
	
	var parsedQuery = qs.parse(parsedUrl.query);
	console.log(parsedQuery);
	
	// response.end(request.url);
	response.end("aaa's value is " + parsedQuery.aaa);
});

// 3. 서버 실행하기 -> port : 8090
s.listen(8090, function() {
	console.log("server is start!!");
});
