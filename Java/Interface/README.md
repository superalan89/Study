## Interface
추상함수만갖고있는설계요소
```java
public interface City {
	// body{ } 가 없는 추상함수만 정의, 예약어인 abstract 가 생략된 형태
    public String name();
}

// 구현시 implements 사용
public class Seoul implements City {
	// 추상함수를 반드시 구현해야 한다.
	public String name(){

	}
}
```
