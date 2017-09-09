package oop06.inter03;

public class LGRemoteTV extends RemoteTV {

	@Override
	public void channelDown() {
		channel--;
		System.out.println("TV 채널을 내립니다. 현재 채널 : " + channel + "번");
	}
}