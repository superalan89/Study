# Math

Math 클래스는 흔히계산을 하는데 도움이 되는 많은 수의 기본적 수학 함수들을 제공


#### 1. 절대값 구하기
```Java
int a = Math.abs(-123);
```
#### 2. 반올림
```Java
long b = Math.round(123.5);
```
#### 3. 올림
```Java
double c = Math.ceil(343.1543);
```
#### 4. 내림
```Java
double d = Math.floor(563.8);
```
#### 5. 0~1사이의 랜덤값
```Java
Math.random();		
Random random = new Random();
```
#### 예제) 1부터 100사이의 랜덤한 숫자 가져오기
```Java
random.nextInt(100); // -> 0~99 사이의 정수가 리턴
int r = random.nextInt(100) + 1;
```
