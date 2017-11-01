const fun = require("firebase-functions");
const admin = require("firebase-admin");
admin.initializeApp(fun.config().firebase);

exports.addMessage = fun.https.onRequest((req,res)=>{
    // http 요청에서 ? 다음에 있는 변수중에 text 변수값을 가져온다.
    var text = req.query.text;
    // 파이어베이스 db의 message 레퍼런스에 그 값을 넣는다.
    admin.database().ref('/message')
        .push({msg:text})
        .then(snapshot => {
            res.end("success!!!");
        });
});

const fcmServerUrl = "https://fcm.googleapis.com/fcm/send";
const serverKey = "AAAA5XFymEg:APA91bGOQDhsOh2sW34sMbDT5cpMIBiQPLcjm2Y1Xyy5lPuG6PmKOebOlAZMZZxzfcJFw3CeaRHr7iCFc9se0oW32WTkgflm8z2GTfEZEuEmlaM4uAMWZKMtFPK54YkEgY5IrWV7OkpQ";

exports.sendNotification = fun.https.onRequest((req,res)=>{
    //json 데이터로 post 값을 수신
    var postdata = "";
    req.on("data", function(data) {
        postdat += data;
    });

    req.on("end", function() {
        var dataObj = JSON.parse(postdata);
        /* dataObj의 형태
            {
                to : "상대방토큰",
                msg : "메시지"
            }
        */
        // 전송할 메세지 객체를 완성
    
        var msg = {
            notification : {
                title : "노티바에 나타나는 타이틀",
                body : dataObj.msg
            }
        };
        var result = admin.messaging().sendToDevice(dataObj.to, msg);
        res.end(JSON.stringify(result));
    });
});