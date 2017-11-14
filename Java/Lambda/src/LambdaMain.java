
public class LambdaMain {

	public static void main(String[] args) {
		LambdaInterfaceBasic lib = new LambdaInterfaceBasic();
		lib.run();
		
		OneProcess process = OneProcess();
		process.process(
			// callback 클래스를 lambda로 변경하기
			
			// 1. 함수명을 없애고 () {} 사이에 화살표를 넣는다.
			//    (int x) -> {
			//	  System.out.println(x);
			//    }
			
			// 2. 파라미터가 하나이면 타입을 생략할 수 있다
			// -> {
			//	  System.out.println();
			//    }
			
			// 3. 하나의 파라미터면 파라미터측의 괄호를 생략,
			//    로직이 한줄이면 로직측의 괄호를 생략
			//    x -> System.out.println(x)
			
			// 4. 파라미터가 없으면 괄호를 반드시 작성
			//	  ()-> System.out.println("Hello")
			
			// 5. 리턴값이 있을 경우
			//    () -> return "Hello"
			
			// 6. 참조형
			//    파라미터의 개수가 예측 가능할 경우 객체 :: 메서드 형태로 호출할 수 있다.
			System.out::println
		);
	}
}

class OneProcess() {
	public void process(One one) {
		one.run(x, y, z);
	}
}

// 1. 하나의 클래스에 하나의 함수 ( O )

interface One {
	public void run(int x, int y, int z);
	public void stop();
}