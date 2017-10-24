// 1. 서버모듈 가져오기
var http = require("http");
var u = require("url");
var fs = require("fs");

// 2. 서버 생성하기
var server = http.createServer(function(request,response) {
	var url = u.parse(request.url);
	var path = url.pathname;
	// path 에 해당되는 파일을 읽는다
	
	response.writeHead(200, {'Content-Type':'text/html'});
	
	//              파일 경로           인코딩          콜백함수
	fs.readFile(path.substring(1), 'utf-8', function(error, data) {
		var text = "";
		if(error) {
			text = htmlText(error);
		}else {
			text = data;
		}
		response.end(text);
	});
});

// 3. 서버 실행하기 -> port : 8090
server.listen(8090, function() {
	console.log("server is running!");
});

function htmlText(str) {	
		text = "<html><meta charset='utf-8'/><body>서버 오류 : ";
		text += error;
		text += "</body></html>";
		return text;
}

