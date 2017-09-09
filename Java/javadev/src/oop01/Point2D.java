package oop01;

public class Point2D {
	private int x;
	private int y;   // 바로 아래 접근이 가능함
	
	//메소드 이름 정의 ; 소문자로 시작 다음단어를 대문자
	
	//alt shift s : Source 메뉴랑 동일 - getter setter 클릭하면 편리하게 메소드 추가시킬 수 있다.
	
	
	public Point2D() {
		this(1, 2);
		System.out.println("Point2D() 수행중");
	}	//기본 생성자 정의 (특징 : 클래스 이름과 같으며, 반환형 (ex int)이 없다.) 객체를 만든 동시에 바로 셋팅!
		//this를 이용하면 아래 int x, y 로 대입이 가능
	
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Point2D(x,y) 수행중");
	}
	
	//생성자도 메소드 오버로딩이 가능.. 여러개 나열하는거.
	//한번 생성자 정의하면 기본 생성자를 컴파일러가 자동으로 생성해 주지 않는다.
	

	public int getX() {
		return x;
	}
	public void setX(int x) {   //바깥에 있는 int x랑 다르다!
		this.x = x;  //오른쪽 x 는 public에 있는 x랑 같음.  this.x는 바깥에 있는 x와 같다. this를 이용해서 구분을 짓는다.
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void print() {
		//메인메소드, 실행시 메인메소드 결과가 나온다
				System.out.println("x=" + getX());
				System.out.println("y=" + getY());		//get 불러오기
	}
	

	// getter setter 이용하여 값을 직접 지정! getter(불러오기) setter(저장) 둘다 동시에 정의를 
	
	
	
	
	
}
