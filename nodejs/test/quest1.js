var count = 20;

// 함수를 만들고
// 0,1 부터 시작해서 100개의 피보나치 수열을 출력하세요

var p = function(count) {
	var a = 0;
	var b = 1;
	
	for (var i=2; i<count; i++) {
		console.log(a+b);
		var c = a + b;	
		a = b;
		b = c;
	}
}

p(count);


