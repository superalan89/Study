package observer;

import observer.Server.Observer;

public class Client implements Observer {
	
	@Override
	public void onNext() {
		/*
		 * 화면에 변경사항을 반영한다
		 * */
	}
	
	@Override
	public void onComplete() {
		
	}
	
	@Override
	public void onError() {
		
	}
}
