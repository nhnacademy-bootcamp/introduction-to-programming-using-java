# 4.5 람다 표현식(Lambda Expressions) - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 람다 표현식의 개념과 필요성을 이해한다
- 함수형 인터페이스를 정의하고 사용할 수 있다
- 다양한 형태의 람다 표현식을 작성할 수 있다
- 메서드 참조를 이해하고 활용할 수 있다
- 람다 표현식을 실제 프로그래밍에 적용할 수 있다

## 1. 람다 표현식이란?

### 1.1 기본 개념
**람다 표현식**은 이름이 없는 함수(익명 함수)를 간단하게 표현하는 방법입니다.

```java
// 기존 방식 - 이름이 있는 메서드
static int add(int a, int b) {
    return a + b;
}

// 람다 표현식 - 이름이 없는 함수
(a, b) -> a + b
```

### 1.2 왜 람다 표현식이 필요한가?
1. **간결한 코드**: 불필요한 코드를 줄임
2. **함수를 값처럼 전달**: 메서드의 매개변수로 동작을 전달
3. **일회성 사용**: 한 번만 사용할 간단한 기능

비유: 람다 표현식은 "일회용 도구"와 같습니다
```
일반 메서드 = 공구상자의 망치 (이름이 있고 여러 번 사용)
람다 표현식 = 일회용 도구 (필요할 때 만들어 사용)
```

## 2. 함수형 인터페이스

### 2.1 함수형 인터페이스란?
**함수형 인터페이스**는 단 하나의 추상 메서드만 가지는 인터페이스입니다.

```java
// 함수형 인터페이스 정의
public interface Calculator {
    int calculate(int a, int b);
}

// 함수형 인터페이스 사용
Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(5, 3));      // 8
System.out.println(multiply.calculate(5, 3)); // 15
```

### 2.2 주요 함수형 인터페이스 예제
```java
// 1. 매개변수와 반환값이 있는 경우
public interface Function<T, R> {
    R apply(T t);
}

// 2. 매개변수만 있는 경우
public interface Consumer<T> {
    void accept(T t);
}

// 3. 반환값만 있는 경우
public interface Supplier<T> {
    T get();
}

// 4. 조건을 검사하는 경우
public interface Predicate<T> {
    boolean test(T t);
}
```

## 3. 람다 표현식 문법

### 3.1 기본 문법
```java
(매개변수) -> { 실행문 }
```

### 3.2 문법 단순화 규칙
```java
// 1. 전체 문법
(int x, int y) -> { return x + y; }

// 2. 타입 추론 가능시 타입 생략
(x, y) -> { return x + y; }

// 3. 실행문이 하나면 중괄호와 return 생략
(x, y) -> x + y

// 4. 매개변수가 하나면 괄호 생략
x -> x * x

// 5. 매개변수가 없으면 빈 괄호 필수
() -> System.out.println("Hello")
```

### 3.3 다양한 람다 표현식 예제
```java
// 예제 1: 숫자 제곱
Function<Integer, Integer> square = x -> x * x;

// 예제 2: 문자열 출력
Consumer<String> printer = message -> System.out.println(message);

// 예제 3: 난수 생성
Supplier<Double> random = () -> Math.random();

// 예제 4: 짝수 판별
Predicate<Integer> isEven = n -> n % 2 == 0;

// 예제 5: 두 문자열 연결
BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
```

## 4. 람다 표현식 활용

### 4.1 변수에 할당
```java
// 인터페이스 정의
interface MathOperation {
    int operate(int a, int b);
}

// 람다 표현식을 변수에 할당
MathOperation addition = (a, b) -> a + b;
MathOperation subtraction = (a, b) -> a - b;
MathOperation multiplication = (a, b) -> a * b;
MathOperation division = (a, b) -> a / b;

// 사용
int result1 = addition.operate(10, 5);      // 15
int result2 = subtraction.operate(10, 5);   // 5
```

### 4.2 매개변수로 전달
```java
// 메서드 정의
static void processArray(int[] array, ArrayProcessor processor) {
    processor.process(array);
}

// 인터페이스
interface ArrayProcessor {
    void process(int[] array);
}

// 사용 예
int[] numbers = {1, 2, 3, 4, 5};

// 배열 출력
processArray(numbers, arr -> {
    for (int n : arr) {
        System.out.print(n + " ");
    }
    System.out.println();
});

// 배열 합계
processArray(numbers, arr -> {
    int sum = 0;
    for (int n : arr) {
        sum += n;
    }
    System.out.println("합계: " + sum);
});
```

### 4.3 반환값으로 사용
```java
// 연산 생성 메서드
static MathOperation getOperation(String operator) {
    switch (operator) {
        case "+": return (a, b) -> a + b;
        case "-": return (a, b) -> a - b;
        case "*": return (a, b) -> a * b;
        case "/": return (a, b) -> a / b;
        default: return (a, b) -> 0;
    }
}

// 사용
MathOperation op = getOperation("+");
System.out.println(op.operate(10, 5)); // 15
```

## 5. 실용적인 예제

### 5.1 리스트 정렬
```java
import java.util.*;

public class LambdaSorting {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("김철수", "이영희", "박민수", "최지우");
        
        // 람다로 정렬 기준 지정
        // 1. 이름 길이순
        names.sort((name1, name2) -> name1.length() - name2.length());
        System.out.println("길이순: " + names);
        
        // 2. 알파벳순
        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println("알파벳순: " + names);
        
        // 3. 역순
        names.sort((name1, name2) -> name2.compareTo(name1));
        System.out.println("역순: " + names);
    }
}
```

### 5.2 필터링
```java
interface Filter<T> {
    boolean accept(T item);
}

static <T> List<T> filter(List<T> list, Filter<T> filter) {
    List<T> result = new ArrayList<>();
    for (T item : list) {
        if (filter.accept(item)) {
            result.add(item);
        }
    }
    return result;
}

// 사용 예
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// 짝수만 필터링
List<Integer> evens = filter(numbers, n -> n % 2 == 0);
System.out.println("짝수: " + evens); // [2, 4, 6, 8, 10]

// 5보다 큰 수
List<Integer> greaterThan5 = filter(numbers, n -> n > 5);
System.out.println("5보다 큰 수: " + greaterThan5); // [6, 7, 8, 9, 10]
```

### 5.3 계산기 만들기
```java
public class LambdaCalculator {
    interface Operation {
        double calculate(double a, double b);
    }
    
    static class Calculator {
        private Map<String, Operation> operations = new HashMap<>();
        
        public Calculator() {
            // 람다로 연산 등록
            operations.put("+", (a, b) -> a + b);
            operations.put("-", (a, b) -> a - b);
            operations.put("*", (a, b) -> a * b);
            operations.put("/", (a, b) -> {
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다");
                return a / b;
            });
            operations.put("^", (a, b) -> Math.pow(a, b));
        }
        
        public double calculate(double a, String operator, double b) {
            Operation op = operations.get(operator);
            if (op == null) {
                throw new IllegalArgumentException("지원하지 않는 연산: " + operator);
            }
            return op.calculate(a, b);
        }
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("10 + 5 = " + calc.calculate(10, "+", 5));
        System.out.println("10 - 5 = " + calc.calculate(10, "-", 5));
        System.out.println("10 * 5 = " + calc.calculate(10, "*", 5));
        System.out.println("10 / 5 = " + calc.calculate(10, "/", 5));
        System.out.println("2 ^ 10 = " + calc.calculate(2, "^", 10));
    }
}
```

## 6. 메서드 참조

### 6.1 메서드 참조란?
이미 존재하는 메서드를 람다 표현식으로 사용하는 간단한 방법입니다.

```java
// 람다 표현식
x -> Math.sqrt(x)

// 메서드 참조
Math::sqrt
```

### 6.2 메서드 참조 종류
```java
// 1. 정적 메서드 참조
Function<Double, Double> sqrt = Math::sqrt;

// 2. 인스턴스 메서드 참조
String str = "Hello";
Supplier<Integer> length = str::length;

// 3. 특정 타입의 인스턴스 메서드 참조
Function<String, Integer> stringLength = String::length;

// 4. 생성자 참조
Supplier<ArrayList> listFactory = ArrayList::new;
```

### 6.3 메서드 참조 예제
```java
public class MethodReferenceExample {
    // 정적 메서드
    static int doubleIt(int n) {
        return n * 2;
    }
    
    // 인스턴스 메서드
    int tripleIt(int n) {
        return n * 3;
    }
    
    public static void main(String[] args) {
        // 1. 정적 메서드 참조
        Function<Integer, Integer> doubler = MethodReferenceExample::doubleIt;
        System.out.println(doubler.apply(5)); // 10
        
        // 2. 인스턴스 메서드 참조
        MethodReferenceExample obj = new MethodReferenceExample();
        Function<Integer, Integer> tripler = obj::tripleIt;
        System.out.println(tripler.apply(5)); // 15
        
        // 3. 기존 메서드 활용
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        
        // 람다 표현식
        words.forEach(word -> System.out.println(word));
        
        // 메서드 참조
        words.forEach(System.out::println);
    }
}
```

## 7. 람다 표현식의 제약사항

### 7.1 외부 변수 사용
람다 표현식에서 외부 변수를 사용할 때는 그 변수가 사실상 final이어야 합니다.

```java
// ❌ 컴파일 오류
int count = 0;
Runnable r = () -> {
    count++;  // 오류: 변경할 수 없음
};

// ✅ 올바른 사용
final int limit = 10;  // 또는 사실상 final
Predicate<Integer> isWithinLimit = n -> n < limit;
```

### 7.2 예외 처리
```java
// 체크 예외를 던지는 람다
interface ThrowingFunction<T, R> {
    R apply(T t) throws Exception;
}

// 사용시 try-catch 필요
ThrowingFunction<String, Integer> parser = s -> {
    return Integer.parseInt(s);  // NumberFormatException 가능
};
```

## 요약

### 핵심 개념
- **람다 표현식**: 이름 없는 함수를 간단히 표현
- **함수형 인터페이스**: 하나의 추상 메서드만 가진 인터페이스
- **메서드 참조**: 기존 메서드를 람다처럼 사용
- **간결한 문법**: 타입 추론, 괄호 생략 등

### 장점
1. 코드가 간결해짐
2. 함수를 값처럼 전달 가능
3. 병렬 처리에 유용
4. 함수형 프로그래밍 스타일 지원

### 사용 시기
- 간단한 기능을 한 번만 사용할 때
- 메서드의 매개변수로 동작을 전달할 때
- 컬렉션 정렬이나 필터링할 때
- 이벤트 처리나 콜백 함수가 필요할 때

💡 **팁**: 람다 표현식은 코드를 간결하게 만들지만, 복잡한 로직에는 일반 메서드가 더 적합할 수 있습니다. 가독성을 항상 고려하세요!