import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Observer Pattern에 대해서
 * 
 * Subject <- Observer
 * 
 */
public class DPMain {

	public static void main(String[] args) {
		Subject server = new Subject();
		server.start();
		
		ClientDeamon deamon = new ClientDeamon(server);
		deamon.start();
	}
}

class Client1 implements Subject.IObserver {
	
	@Override
	public void noti() {
		System.out.println("클라이언트 1에 변경사항이 반영됨");
	}
}


class Client2 implements Subject.IObserver {
	String title = "";
	public Client2(String title) {
		this.title = title;
	}
	@Override
	public void noti() {
		System.out.println("클라이언트 2에 변경사항이 반영됨");
	}
}

class Subject extends Thread {
	List<IObserver> clients = new ArrayList<>();
	public void run() {
		Random random = new Random();
		while(true) {
			for(IObserver observer : clients) {
				observer.noti();
			}
			System.out.println("[Subject] 메세지를 전송하였습니다.");
			
			
			// 비주기적 갱신을 위한 테스트 코드
			try {
				Thread.sleep((random.nextInt(10)+1)*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public interface IObserver {
		public void noti();
	}
}

/**
* 클라이언트 등록을 위한 데몬 클래스
*/

class ClientDeamon {
	Subject server;
	Public ClientDeamon(Subject server) {
		this.server = server;
	}
	public void start () {
		while(true) {
			if(count%2 ==0) {
				server.clients.add(new Client1());
			} else {
				server.clients.add(new Client2());
			}
		}
	}
}