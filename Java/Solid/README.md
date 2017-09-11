# OOP_Solid
### OOP 정의
OOP(Object Oriented Programming) 객체지향 프로그래밍으로 앞에서 정의된 Object로 프로그램을 설계할 때 속성과 기능을 하나의 Class단위로 묶어주는 것을 의미


>**Class** : 변수와 함수의 모음을 하나의 클래스로 정의 (단, 변수의 속성(Property)이나 함수의 기능(Method)가 없을 수도 있음.) <br>
**Object** : 속성(Attribute)과 기능(Method)을 가지는 대상

**OOP의 개발과정**

1.계획 - 2.분석 - 3.설계 - 4.구현 - 5.테스트
- 그중에서 **설계**의 비중이 제일 높음

**OOP의 설계순서**

1.문제정의 - 2.요구사항 명세 - 3.Object 정의 - 4.인터페이스 정의 - 5.구현

## 1. SRP - Single Responsibility Principle

#### 단일 책임의 원칙
>하나의 클래스는 하나의 역할만 맡음
높은 응집도와 낮은 결합도를 추구

**장점**
- 코드 변경의 영향이 미치는 범위가 최소화
- 코드 응집성 향상
- 단위 테스트 용이

## 2. OCP - Open Closed Principle

#### 개방 폐쇄의 원칙 <br>
>자신의 확장에는 열려있고 주변의 변화에 대해선 닫혀져 있음

**주의할 점**
- Class 간 통신을 위한 인터페이스가 정해지면 수정되지 않음
- 표준화된 인터페이스의 경우 변경 비용이 큼
- 충분히 안정화 된 이후에 적용이 됨

## 3. LSP - Liskov Substitution Principle

#### 리스코프 교체
> “프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.” 계약에 의한 설계를 참고

- 파생 Class는 상위 클래스로 대체 가능
- 기반 Class의 기능을 파생 Class가 포함

**특징**
<br>
- 서브타입(파생클래스)는 자신의 기반타입(상위클래스)로 교체할 수 있어야 함
- 다형성 적용 : 상위클래스 a = new 하위클래스()

## 4. ISP - Interface Segregation Principle

#### 인터페이스 분리

>1. 클라이언트는 자신이 쓰지 않는 인터페이스에 의존하지 않음<br>
2. 특화된 여려개의 언터페이스가 범용 인터페이스 한개보다 낫다는 장점이 있음

## 5. DIP - Dependency Inversion Principle

#### 의존 관계 역전
>1. 상위 모듈이 하위 모듈에 의존할 수 없음
2. 클라이언트는 클래스에 직접적인 의존이 아닌 추상화 레이어(인터페이스)에 의존해야 함
3. 추상화된 것은 구체적인것에 의존할 수 없음
4. 자주변경되는 구체(Concrete) 클랫에 의존하면 안됨

참조링크
 https://github.com/superalan89/4th_OOP_Solid/blob/master/pdf/004_Class%EC%99%80Object%EC%97%90%EB%8C%80%ED%95%9C%EC%9D%B4%ED%95%B4.pdf
