package oop06.inter01;

public class IntelSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("IntelSpeaker : 볼륨을 키웁니다.");
		
	}

	@Override
	public void soundDown() {
		System.out.println("IntelSpeaker : 볼륨을 줄입니다.");
		
	}

}
