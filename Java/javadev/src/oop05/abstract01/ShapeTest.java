package oop05.abstract01;

public class ShapeTest {
	public static void main(String[] args) {
		printArea(new Circle());
		printArea(new Rectangle());
		printArea(new Triangle());
	}

	private static void printArea(Shape s) {  //다형성 성질을 받는다.
		s.area();
		if(s instanceof Circle) {  //instanceof 연산자
			Circle c = (Circle) s;
			System.out.println("반지름이 " + c.r + "인 원의 넓이는 " + c.res);
		}else if(s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			System.out.println("가로가 " + r.w + "세로가 " + r.h + "인 사각형의 넓이는" + r.res);
		}else if(s instanceof Triangle) {
			Triangle t = (Triangle) s;
			System.out.println("밑변이 " + t.w + "높이가 " + t.h + "인 삼각형의 넓이는" + t.res);
		}
	}

//	private static void printArea(Triangle t) {
//		t.area();
//		System.out.println("밑변이 " + t.w + "높이가 " + t.h + "인 삼각형의 넓이는" + t.res);
//	}
//
//	private static void printArea(Rectangle r) {
//		r.area();
//		System.out.println("가로가 " + r.w + "세로가 " + r.h + "인 사각형의 넓이는" + r.res);
//	}
//
//	private static void printArea(Circle c) {
//		c.area();
//		System.out.println("반지름이 " + c.r + "인 원의 넓이는 " + c.res);
//	}
	
}
