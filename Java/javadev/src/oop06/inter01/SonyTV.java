package oop06.inter01;

public class SonyTV implements TV{   //인터페이스를 구현한다.
	
	private Speaker speaker = new IntelSpeaker();
	
	public void turnOn() {
		System.out.println("SonyTV : 전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("SonyTV : 전원을 끕니다.");
	}
	
	public void channelUp() {
		System.out.println("SonyTV : 채널을 올립니다.");
	}
	
	public void channelDown() {
		System.out.println("SonyTV : 채널을 내립니다.");
	}
	
	public void soundUp() {
		//System.out.println("SonyTV : 소리를 키웁니다.");
		speaker.soundUp();
	}
	
	public void soundDown() {
		//System.out.println("SonyTV : 소리를 줄입니다.");
		speaker.soundDown();
	}
}
