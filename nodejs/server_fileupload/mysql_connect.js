var mysql = require("mysql");
var settings = {
    host : "localhost",
    user : "root",
    password : "mysql",
    port : "3306",
    database : "memo"
};

var con = mysql.createConnection(settings);
con.connect();
con.query("select * from memo", function(error, record_set, columns){
    record_set.forEach(function(record) {
        console.log(record);
    });
    this.end(); // 쿼리 처리에 대한 연결 해제
});

con.end(); // 데이터베이스 연결 해제