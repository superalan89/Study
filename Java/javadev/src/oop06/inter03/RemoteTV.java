package oop06.inter03;

public abstract class RemoteTV implements IRemoteControl {
	int channel = 0;		//채널
	boolean power = false;  //전원
	
	@Override
	public void powerOn() {
		power = true;
		System.out.println("RemoteTV 전원을 켭니다.");
		
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("RemoteTV 전원을 끕니다.");
		
	}

	@Override
	public void channelUp() {
		channel++;
		System.out.println("TV 채널을 올리니다. 현재 채널 : " + channel + "번");
		
	}
}
