// 1. 서버모듈 가져오기
var http = require("http");

// 2. 서버 생성하기
var server = http.createServer(function(request, response) {
	console.log(request);
	response.end(fibonacci.run());
});

// 3. 서버 실행하기 -> port : 8090
server.listen(8090, function() {
	console.log("server is start!!");
});

// 피보나치
var fibonacci = {
	count : 100,
	run : function() {
		result = "";
		prev = 0;
		result += prev + ",";
		next = 1;
		result += next + ",";
		for (i=0; i<this.count; i++) {
			sum = prev+next;
			result += sum + ",";
			prev = next;
			next = sum;
		}
		return result;
	}
};


// javascript의 object
/*
var request = {
	one : 157,
	two : "hello",
	three : 5,
	sum : function() {
		return one + three;
	}
};

console.log (request.one);
console.log (request.two);
console.log (request.sum());
*/