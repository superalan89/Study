package Abstract_Main;

interface Building {
	public String getName();
}

//기능 변화가 자주 일어나느 경우는 추상 클래스로 설계
//기능변화가 없는 경우는 인터페이스로 설계
abstract interface Base {
	abstract void create();
	abstract void read();
	abstract void update();	
	abstract void delete();	
	abstract void showList();
}

abstract class Memo implements Base {
	public void deleteList() {
		delete();
		showList();
	}
	
	@Override	// annotation - 이노테이션 (부가적인 기능을 추가 혹은 단순정보 제공)
	public void create() {
		System.out.println("called create!");
	}
	@Override
	public void read() {
		System.out.println("called read!");
	}
	@Override
	public void update() {
		System.out.println("called update!");
	}
	@Override
	public void delete() {
		System.out.println("called delete!");
	}
	@Override
	public void showList() {
		System.out.println("called showlist!");
	}
}

//구현체
class MemoIpml extends Memo {
	@Override
	public void read() {
		update();
	}
}

public class Animal {
	public static void main(String args[]) {
		MemoImpl memo = new MemoImpl();
		memo.read();
	}

	public String type() {
		// TODO Auto-generated method stub
		return null;
	}
}