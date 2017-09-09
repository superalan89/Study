package oop04;

public class PointTest {
	public static void main(String[] args) {
		
		//up casting(업 캐스팅) 자동 형변환
		Point2D up = new Point3D();
		up.x = 100;
		up.y = 200;
		//up.z = 300;
		
		//자식(3D)라는 객체를 참조했지만.. 컴파일러는 2D(부모)로 인식함 
		
		
		//다운 캐스팅
		Point3D dn = (Point3D) up;
		dn.x = 1000;
		dn.y = 2000;
		dn.z = 3000;
		
		//강제 형변환으로 자식클래스 인식가능   -   자식이 곧 부모객체이기도함. 따로따로X
		
		// ex)   자식클래스 < 부모클래스 < Object
		
	}
}
