# Java String

## String Api

#### 스트링 함수

1.length - 문자열의 길이를 구한다

```Java
System.out.println(a.length());
```

2.indexOf - 문자열의 위치를 리턴한다

```Java
System.out.println(a.indexOf("Test"));
```

3.split - 특정 구분자로 분해

```Java
String[] temp = a.split("/");

for (String item : temp) {
			System.out.println(item);
		}
```

4.빈 문자열로 자르면 글자 하나 단위로 쪼개줌

```Java
String temp2[] = a.split("");
```

5.substring - 문자열 자르기

```Java
System.out.println(a.substring(2,7));
```

6.replace - 문자열 바꾸기

```Java
System.out.println(a.replace("Te", "Px"));
```

7.특정 문자열로 시작되는지를 검사

```Java
a.startsWith("Str");  //Str로 시작되면 true값을 날려준다.

String address = "naver.com";

if(!address.startsWith("http:")) {
	address = "http://" + address;
}
```

8.builderVsBuffer - jdk 1.5 버전 이상부터는 일반적인 스트링 연산을 StringBuilder로 커파일러가 자동변환 해준다.
```Java
public void builderVsBuffer() {
		// jdk 1.5 버전 이상부터는 일반적인 스트링 연산을 StringBuilder로 커파일러가 자동변환 해준다.
		String result = "안" + "녕하" + "세요" + "! 반갑습니다";


		StringBuffer buffer = new StringBuffer();
		buffer.append("안");
		buffer.append("녕하").append("세요");
		buffer.append("반갑습니다");

		System.out.println(buffer.toString());

		// 속도 가장 빠름
		// 비동기에서 안정성이 보장되지 않는다.
		// 다중 thread 환경에서는 StringBuilder로 변수를 사용하지 않는다.
		StringBuilder builder = new StringBuilder();
		builder.append("안");
		builder.append("녕하").append("세요");
		builder.append("반갑습니다");
		System.out.println(builder.toString());

	}
```

### Algorithm
스트링을 활용한 알고리즘 풀이

1.로또번호 생성기 실습
```Java
public int[] getLottoNumbers() {
  int[] result = new int[6];     
	Random random = new Random();

     for(int i = 0; i < 6; i++) {

  	   // random 함수에서 발생되는 난수는 중복될 수 잇다
  	   // 아래에제에서 결과값이 처음에 33이 나왔을 경우
  	   // 두번째 케이스에서도 33이 나올 수 있다.

  	   int temp = random.nextInt(45) + 1;
  	   result[i] = temp;


  	   // 중복값에 대한 예외처리
  	   for(int j = 0; j < i; j++) {
  		   if (temp == result[j]) {

  		   }
  	   }
     }
	return result;
}
```

2.Anagram

아나그램 알고리즘


**아나그램이란** : Anagram 일종의 말장난으로 어떠한 단어의 문자를 재배열하여 다른 뜻을 가지는 다른 단어로 바꾸는 것을 말한다 (출저 : 나무위키)

![Alt text](https://github.com/superalan89/4th_String/blob/master//img/Anagram.png)



**아나그램 활용예시**) <br>
두개의 문자열 입력을 받아서 두개의 관계가 아나그램 관계인지 확인하는 프로그램을 개발



```Java
/*
 * 아나그램 알고리즘
 *
 * 두개의 문자열 입력을 받아서 두개의 관계가 아나그램 관계인지 확인하는
 * 프로그램을 개발
 *
 * option. 받은 문자열의 공백제거
 * 1. 받은 문자열의 길이를 체크 -> 길이가 다르면 검사하지 않는다.
 * 2. 받은 문자열을 정렬
 * 3. 정렬된 문자열을 비교
 *
 * cat -> act
 * was it a cat i saw -> was it a cat is
 * listen -> silent
 *
 * */

public boolean checkAnagram(String a, String b) {
	boolean result = false;

	// 대소문자 처리
	a = a.toLowerCase();
	b = b.toLowerCase();

	// 공배제거
	a = a.replace(" ", "");
	b = b.replace(" ", "");

	// 길이 비교
	if (a.length() != b.length()) {
		return false;
	}

	// 정렬을 하기 위해서 char 배열로 변경
	char aTemp[] = a.toCharArray();
	char bTemp[] = b.toCharArray();

	// 캐릭터 배열 정렬
	Arrays.sort(aTemp);
	Arrays.sort(bTemp);

	// 문자열 비교후 리턴
	return Arrays.equals(aTemp, bTemp);
}
```
