# 할당문에 변수에 값을 저장하는 유일한 방법인가?

## 1. **직접 할당문**
```java
int x;
x = 10; // 가장 기본적인 할당문
```

## 2. **선언과 동시에 초기화**
```java
int y = 20; // 선언과 함께 값 저장
String name = "Java";
```

## 3. **증감 연산자**
```java
int count = 5;
count++; // count = count + 1과 같음
count--; // count = count - 1과 같음
```

## 4. **복합 할당 연산자**
```java
int sum = 10;
sum += 5;  // sum = sum + 5
sum -= 3;  // sum = sum - 3
sum *= 2;  // sum = sum * 2
sum /= 4;  // sum = sum / 4
```

## 5. **생성자를 통한 초기화**
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;  // 생성자에서 값 저장
        this.age = age;
    }
}
```

## 6. **메서드 매개변수**
```java
public void setAge(int age) {
    this.age = age;  // 메서드를 통한 값 저장
}
```

## 7. **메서드 반환값**
```java
int result = calculateSum(5, 3); // 메서드 반환값을 변수에 저장
String text = scanner.nextLine(); // 입력값을 변수에 저장
```

## 8. **배열과 컬렉션**
```java
// 배열
int[] numbers = new int[5];
numbers[0] = 10; // 배열 요소에 값 저장

// ArrayList
List<String> list = new ArrayList<>();
list.add("Hello"); // 컬렉션에 값 추가
list.set(0, "Hi"); // 특정 위치의 값 변경
```

## 9. **삼항 연산자**
```java
int max = (a > b) ? a : b; // 조건에 따른 값 저장
```

## 10. **스트림과 람다**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, Integer::sum); // 스트림 연산 결과 저장
```

## 11. **리플렉션**
```java
Field field = obj.getClass().getDeclaredField("fieldName");
field.setAccessible(true);
field.set(obj, value); // 리플렉션을 통한 값 설정
```

이처럼 Java에서는 상황과 목적에 따라 다양한 방법으로 변수에 값을 저장할 수 있습니다. 할당문은 가장 기본적이고 직접적인 방법일 뿐입니다.