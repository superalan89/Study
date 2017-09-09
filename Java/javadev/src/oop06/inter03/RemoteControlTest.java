package oop06.inter03;

public class RemoteControlTest {
	public static void main(String[] args) {
		LGRemoteTV tv = new LGRemoteTV();
		tv.powerOn();
		tv.channelUp();
		tv.channelDown();
		tv.powerOff();
	}	
}
