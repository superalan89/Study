package design;

// 인터페이스를 정의하는 방법
// 접근제한자 + interface + 이름
public interface IChange {
	public void clac(int pay, int buy);
	public void move();
	// 
}

interface IChangeMove {
	public void move();
}

// 현재 다른 파일이라고 생각하고~

// 인터페이스를 구현하기
// class + 클래스이름 + implements + 인터페이스 이름
class Change implements IChange, IChangeMove {

	@Override
	public void clac(int pay, int buy) {
		// 구현단의 코드를 작성
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}