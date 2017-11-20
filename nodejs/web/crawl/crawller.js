// http 통신으로 request를 할 모듈
var request = require("request")
var querystring = require("querystring")
// mysql db 연결정보
var mysql = require("mysql")
var conInfo = {
    host : '127.0.0.1',
    user: 'root',
    password : 'mysql',
    port : '3306',
    database : 'socar'
}
var con = mysql.createConnection(conInfo);
con.connect();
var query_str = "select * from crawl_zone"

var result;
var result_idx = 0;

// zone 테이블 select
con.query(query_str, function(error, items, fields){
    result = items;
    runRequest();
});

function runRequest(){
    // 테이블에서 한개의 row를 꺼내고
    var obj = result[result_idx];
    // 웹사이트로 request 를 다시 전송한다.
    var form = {
        way: "round",
        start_at: "2017-11-21 15:00",
        end_at: "2017-11-21 15:30",
        loc_type: 2,
        class_id: "",
        lat: obj.lat,
        lng: obj.lng,
        zone_id: obj.zone_id,
        region_name: obj.zone_name,
        distance: 1
    };

    // form 데이터를 문자열로 변환
    var formData = querystring.stringify(form);
    var formLength = formData.length;

    request(
        {
            headers : {
                'Content-Length' : formLength,
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            url : "https://www.socar.kr/reserve/search",
            body : formData,
            method : "POST"
        },
        function(error, answer, body){
            if(error){
                console.log(error)
            }else{
                if(body){ // html 데이터가 반환된다.
                    var start = body.indexOf('<h3 class="blind">쏘카목록</h3>');
                    var end = body.indexOf('페이지네이션 추가');
                    body = body.substring(start,end);
                    console.log(body);
                }
            }
        }
    );

    result_idx++
    if(result_idx < result.length)
        setTimeout(runRequest,1000);
}