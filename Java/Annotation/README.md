## Annotation
Retention범위까지속성에대한정보를유지하는설계요소

| 속성 | 내용 |
| :--- | :--- |
| @Target | 적용할 대상 : CONSTRUCTOR, FIELD, ENUM, LOCAL VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE\(Class\)|
| @Retention | 어노테이션 정보의 유지단계 : SOURCE, CLASS, RUNTIME |
| @Documented | javadoc등에 문서화되어져야하는 엘리먼트일 경우 |
| @Inherited | 자동으로 상속받는 어노테이션 타입일 경우 |

```java
// 1. 애너테이션 만들기
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation {  
    public String val() default "값";
    public String key();
}

// 2. 애너테이션 적용
@Annotation(key = "키값추가1") 
public class Main {

}

// 3. 애너테이션 값 참조
Main main = new Main();
// Main 클래스에 적용된 Annotation의 val 와 key 값을 꺼낸다
String anno_a = main. getClass().getAnnotation(Annotation.class).val();
String anno_b = main. getClass().getAnnotation(Annotation.class).key();
```
