var http = require("http");
var httpUrlConnection = require("request");

const fcmServerUrl = "https://fcm.googleapis.com/fcm/send";
const serverKey    = "AAAA5XFymEg:APA91bGOQDhsOh2sW34sMbDT5cpMIBiQPLcjm2Y1Xyy5lPuG6PmKOebOlAZMZZxzfcJFw3CeaRHr7iCFc9se0oW32WTkgflm8z2GTfEZEuEmlaM4uAMWZKMtFPK54YkEgY5IrWV7OkpQ ";

var msg = {
	to : "",
	notification : {
		title : "메시지 테스트",
		body : "",
		sound : "Alarm01.wav",
		click_action : "NOTI_LAUNCHER"
	},
	data : {
		type : "one"
	}

}


var server = http.createServer(function(request,response){
	// 넘겨준 json 데이터를을 꺼낸다
	if(request.url == "/sendNotification"){
		var postdata = "";
		request.on("data", function(data){
			postdata += data;
		});
		// 메시지 수신완료
		request.on("end", function(){
			// json 스트링을 객체로 변환
			var postObj = JSON.parse(postdata);
			// 메시지 데이터를 완성
			msg.to = postObj.to;
			msg.notification.body = postObj.msg;

			// 메시지를 fcm 서버로 전송
			httpUrlConnection(
				// http 메시지 객체
				{
					url : fcmServerUrl,
					method : "POST",
					headers : {
						"Authorization" : "key="+serverKey,
						"Content-Type" : "application/json"
					},
					body : JSON.stringify(msg)
				},
				// 콜백 함수
				function(error, answer, body){
					var result = {
						code : answer.statusCode,
						msg : body
					};
					response.writeHead(200, {"Content-Type":"plain/text"});
					response.end(JSON.stringify(result));
				}
			);
		});
	}else{
		response.end("404 page not found!!!");
	}
});

server.listen(8090,function(){
	console.log("server's running...");
})