var express = require("express")

var app = express()

// gallery, user
var gallery = require("./routes/gallery")
var user = require("./routes/user");

// uri 요청에 따라 모듈을 분기해준다
app.use("/gallery", gallery)
app.use("/user", user)

// public 디텍토리 아래에 정적(image, video.. etc)파일을 읽어서 넘겨준다.
app.use(express.static("public"));

app.listen(8080,function(){
    console.log("server's running...")
});