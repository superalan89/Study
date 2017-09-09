package oop01;

public class Point3D extends Point2D{   //extends 부모상속 Point2D를 그대로 물려받음
	private int z;		//변수 하나밖에 없을때 노란줄에다 마우스 갖다데면 바로 get set 지정이 가능

	public Point3D() {
		//super();  //값을 지정안하면 자동으로 부모객체를 호출하게 되어있다.
		this(10, 20, 30);
		System.out.println("Point3D() 수행 중");
	}
	
	
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("Point3D(x,y,z) 수행 중");
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public void print() {
		//메인메소드, 실행시 메인메소드 결과가 나온다
				super.print();  // super 부모클래스를 뜻함(부모클래스에 있는 print메소드를 호출)
				System.out.println("z=" + getZ());
	}
	// 부모가 public인데 자식이 private를 줄일수 없다. 에러남 - 대부분 내용물만 재정의함
	
}
