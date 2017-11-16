var express = require('express');
var router = express.Router();

/* GET users listing. */
// 요청주소가 localhost:3000일때
router.get('/', function(req, res, next) {
  res.send('respond from user root!!!');
});

// exports를 통해서 외부로부터 위에서 정의된 변수에 접근할 수 있게 해준다
module.exports = router
