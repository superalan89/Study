package oop08.singleton;
/*
 * 싱글턴 패턴 구현 순서
 * 		1. 생성자를 작성하고 private으로 설정
 * 		2. 자기자신을 참조할 수 있는 변수를 선언 후 공유
 * 		3. 게터 메소드 내부에서 자기자신의 인스턴스 생성
 * 		4. Singleton.getInstance() 이용해서 인스턴스 얻어오기
 */
public class Singleton {
	
	private static Singleton singleton = null;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		
		if(singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}
	
}
