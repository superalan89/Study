package observer;

import java.util.ArrayList;
import java.util.List;

public class Server {
	// 등록된 옵저버들
	List<Observer> observers = new ArrayList<>();
	
	// 실행함수
	public void run() {
		while(true) {
			/*
			 *  서버의 변경사항을 체크하는 로직
			 */
			
			if(/*내서버에 변경사항이 있으면*/) {
				for(Observer obs : observers) {
					obs.noti();
				}
			}
		}
	}
	
	
	// 옵저버 인터페이스
	public interface Observer{
		public void onNext();
		public void onComplete();
		public void onError();
	}
}
