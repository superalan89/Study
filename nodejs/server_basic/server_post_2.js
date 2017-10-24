// 1. 서버모듈 가져오기
var http = require("http");
var u = require("url");
var fs = require("fs");
var qs = require("querystring");
var mime = require("mime");

// 주소(Rest Api) 요청의 형태
// http://localhost:8090/post?filepath=/dirl/xxx.png

// 2. 서버 생성하기
var server = http.createServer(function(request,response) {
	var url = u.parse(request.url);
	// 주소에서 명령 어느서버자원의 id(uri)를 먼저 꺼낸다
	var cmd = url.pathname;
	if(cmd == "/getfile") {
		if(request.method == 'POST') {
			// .. body에 넘어온 filepath
		}else if (request.method == "GET") {
			var query = qs.parse(url.query);
			if(query.filepath) {
				var filepath = query.filepath;
				console.log("filepath" + filepath);
				var mtype = mime.getType(filepath);  // 파일의 minetype을 알려준다.
					
				fs.readFile(filepath, function(error, data) {
					if(error) {
						response.writeHead(500,{'Content-Type' : 'text/html'});
						response.end(error+'');
					} else {
						response.writeHead(200,{'Content-Type' : mtype});
						response.end(data);
					}
				});
			}
		}
	} else {
		
	}
});
	
// 3. 서버 실행하기 -> port : 8090
server.listen(8090, function() {
	console.log("server is running!");
});

