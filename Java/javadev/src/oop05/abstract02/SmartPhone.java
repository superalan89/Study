package oop05.abstract02;

public class SmartPhone extends Phone{
	public SmartPhone(String owner) {
		super(owner);
	}

	@Override
	public void internetSearch() {
		System.out.println(owner + "의 폰으로 인터넷 검색을 시작합니다.");
	}

	
}
