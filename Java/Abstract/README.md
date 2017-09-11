## Abstract Class
추상함수와구현로직을갖는설계요소
```java
// abstract 예약어를 사용한다.
// class 이지만 new 로 instance 화 할 수 없다.
public abstract class Animal {
	// 구현로직 사용가능
	public void move(){
		System.out.println("움직인다");
	}
    public abstract String type();
}

// 구현시 extends 사용
public class Dog extends Animal {
	// 추상함수는 반드시 구현해야 한다.
	public String type(){

	}
}
```
