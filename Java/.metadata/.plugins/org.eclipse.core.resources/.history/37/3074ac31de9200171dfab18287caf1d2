
public class StringApi {
	public void text() {
		String a = "String/Text";
		
		// 길이
		System.out.println(a.length());
		
		// 위치검색
		System.out.println(a.indexOf("Test"));
		
		// 특정 구분자로 분해  ex) String이랑 Text로 나눠짐
		String[] temp = a.split("/");
		
		for (String item : temp) {
			System.out.println(item);
		}
		
		
		// 빈 문자열로 자르면 글자 하나 단위로 쪼개준다
		String temp2[] = a.split("");
		
		// 문자열 자르기
		System.out.println(a.substring(2,7));
		
		// 문자열 바꾸기
		System.out.println(a.replace("Te", "Px"));
		
		// 특정 문자열로 시작되는지를 검사 ex) 인터넷 주소가 정상적인 주소인지 확인할때 사용
		a.startsWith("Str");  //Str로 시작되면 true값을 날려준다. 
		
		String address = "naver.com";
		
		if(!address.startsWith("http:")) {
			address = "http://" + address;
		}		
	}
	
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
	
	public void stringConstantPool() {
		String a = "안녕하세요";
		String b = "안녕하세요";
		
		System.out.println(a==b);  // 주소체크
		System.out.println(a.equals(b)); // 값체크
		
		String c = new String("안녕하세요"); 
		
		String d = c.intern(); //new로 만들어진 객체를 constant pool로 이동시킨다.

	}
}
