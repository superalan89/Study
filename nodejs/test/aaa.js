// 1. 변수의 선언 var 변수명

var a = 11;
var b = "hello";


// 2. 콘솔 출력
console.log(a);
console.log(b);

// 3. 반복문
for(var i=0; i<10; i++) {
	console.log(i);
}

// 4. 조건문
if(a > 10) {
	console.log("a가 10보다 큽니다");
} else if (a < 10) {
	console.log("a가 10보다 작습니다");
} else {
	console.log("a가 10과 같습니다");
}

// 5. 문자열 기본연산 : "문자열" + "문자열" = "문자열문자열"

// 6. 함수 사용하기 - 파라미터에 타입이 없다
// 문장내에서 return이 있는지 여부에 따라서 결정

var c = 10;
var d = 5;

sum(c,d);

// 함수만들기 1
function sum (param1, param2) {
    return param1 + param2;
}

// 함수만들기 2
var sum = function (param1, param2) {
	return param1 + param2;
}

// 7. class 사용하기
function Num(param1,param2) {
	var e = 0;   // private 선언된 변수 : 외부에서 접근 안됨
	this.f = 10; // public 으로 선언된 변수 : 외부에서 접근 가능
}

// 클래스의 사용
var num = new Num ("Hello", 157);

num.b = 500;
num.c("a",49949);