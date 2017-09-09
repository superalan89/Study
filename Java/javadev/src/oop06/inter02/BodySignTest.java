package oop06.inter02;

public class BodySignTest {
	public static void main(String[] args) {
		BodySign p = new Pitcher();
		p.throwBall(BodySign.CENTER);
		p.throwBall(BodySign.RIGHT);
		p.throwBall(BodySign.LEFT);
		p.throwBall(BodySign.UP);
		p.throwBall(BodySign.DOWN);
		
		System.out.println("----------------------");
		
		p.throwBall(2);
		p.throwBall(5);
		p.throwBall(8);
	}	

}
