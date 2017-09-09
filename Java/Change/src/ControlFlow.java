
public class ControlFlow {
	//조건문
	// if switch
	public void checkIf() {
		int a = 10;
		int b = 5;
		
		if (a > b) {
			// a가 b보다 크면 실행되는 영역
			System.out.println("a가 b보다 큽니다");
		}else if (a == b){
			// a와 b가 같으면 실행되는 영역
		}else {
			// 그 외 조건일 때 실행되는 영역
		}
	}
	
	public void checkSwitch() {
		int a = 10;
		int b = 5;
		switch(a) {
			case 5 :
				System.out.println("a의 값이 5입니다.");
				break;
			case 10 :
				System.out.println("a의 값이 10입니다.");
				break;
		}
		
	}
	//반복문
	//for while
	public void checkFor() {
		int array[] = {1 ,2 ,3 ,4 ,5 ,6 ,7};
		// 인덱스는 0부터 시작한다.
		array[0] = 1;
		array[1] = 2;
		
		//일반적인 for문
		//	시작값 ; 종료값 ; 증감값
		for (int i = 0; i<array.length ; i++) {
			System.out.println(array[i]);
		}
		
		//향상된 for문
		for(int item : array) {
			System.out.println(item);
		}
		/*
		 1
		 2
		 3
		 4
		 5
		 6
		 7
		 */
	}
	
	// for while 
	public void checkWhile() {
		int array[] = {1 ,2 ,3 ,4 ,5 ,6 ,7};
		// 반복이 가능한 if문
		int count = 0; // 시작값
		while (count < array.length) { // 종료값
			System.out.println(array[count]);
			count = count + 1; // 증갑값
		}
	}
	public void checkDoWhile() {
		int array[] = {};
		int count = 0;
		// while 문의 조건에 상관없이 do 블럭이 한번은 꼭 실행된다
			do {
				System.out.println(array[count]);
				count = count + 1; // 증갑값
			} 
			while (count < array.length);
	}
}
