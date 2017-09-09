package oop06.inter01;

public interface TV {  //인터페이스는 추상메소드! 자식메소드는 하나도 빠짐없이 오버라이딩 시켜준다.
	public void turnOn();  //abstract는 따로 붙일필요 없다.
	
	public void turnOff();
	
	public void channelUp();
	
	public void channelDown();
	
	public void soundUp();
	
	public void soundDown();
}
