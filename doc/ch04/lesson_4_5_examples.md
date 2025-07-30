# 4.5 람다 표현식 - 수업 실습

## 1. 기본 람다 표현식 실습

### 실습 1-1: 간단한 람다 표현식 만들기

#### 요구사항
- 기본적인 람다 표현식 문법 익히기
- 함수형 인터페이스를 활용한 람다 구현
- 덧셈, 곱셈, 최대값, 인사말, 짝수 판별 람다 구현

```java
// 함수형 인터페이스 정의 (이미 구현됨)
interface Calculator {
    int calculate(int a, int b);
}

interface Greeting {
    void sayHello(String name);
}

interface NumberTest {
    boolean test(int n);
}

public class BasicLambdaExample {
    public static void main(String[] args) {
        System.out.println("=== 기본 람다 표현식 ===\n");
        
        // TODO 1: 덧셈 람다 구현하기
        // Calculator add = 
        // System.out.println("10 + 5 = " + add.calculate(10, 5));
        
        // TODO 2: 곱셈 람다 구현하기  
        // Calculator multiply = 
        // System.out.println("10 × 5 = " + multiply.calculate(10, 5));
        
        // TODO 3: 최대값 람다 구현하기
        // Calculator max = 
        // System.out.println("max(10, 5) = " + max.calculate(10, 5));
        
        // TODO 4: 인사 람다 구현하기
        // Greeting greeting = 
        // greeting.sayHello("김철수");
        
        // TODO 5: 짝수 판별 람다 구현하기
        // NumberTest isEven = 
        // System.out.println("8은 짝수인가? " + isEven.test(8));
        // System.out.println("7은 짝수인가? " + isEven.test(7));
    }
}
```

#### 실행 결과 (참고용):
```
=== 기본 람다 표현식 ===

10 + 5 = 15
10 × 5 = 50
max(10, 5) = 10
안녕하세요, 김철수님!
8은 짝수인가? true
7은 짝수인가? false
```

### 실습 1-2: 람다 표현식 문법 변형 연습

#### 요구사항
- 람다 표현식의 다양한 문법 형태 이해
- 전체 문법, 타입 추론, 간단한 형태 비교
- 복잡한 로직의 람다 표현식 구현

```java
interface MathOperation {
    double operate(double a, double b);
}

public class LambdaSyntaxVariations {
    public static void main(String[] args) {
        System.out.println("=== 람다 표현식 문법 변형 ===\n");
        
        // TODO 6: 전체 문법으로 덧셈 람다 구현하기
        // MathOperation op1 = 
        // System.out.println("전체 문법: " + op1.operate(10, 5));
        
        // TODO 7: 타입 추론을 사용한 덧셈 람다 구현하기
        // MathOperation op2 = 
        // System.out.println("타입 추론: " + op2.operate(10, 5));
        
        // TODO 8: 간단한 형태의 덧셈 람다 구현하기
        // MathOperation op3 = 
        // System.out.println("간단한 형태: " + op3.operate(10, 5));
        
        // TODO 9: 복잡한 로직의 평균 람다 구현하기
        // MathOperation op4 = 
        // System.out.println("평균: " + op4.operate(10, 5));
    }
}
```

#### 실행 결과 (참고용):
```
=== 람다 표현식 문법 변형 ===

전체 문법: 15.0
타입 추론: 15.0
간단한 형태: 15.0
평균: 7.5
```

## 2. 함수형 인터페이스 실습

### 실습 2-1: 표준 함수형 인터페이스 흉내내기

#### 요구사항
- Java의 표준 함수형 인터페이스를 직접 만들어보고 사용
- Function, Consumer, Supplier, Predicate 인터페이스 구현
- 각 인터페이스의 특징과 사용법 이해

```java
// 함수형 인터페이스들 (이미 구현됨)
interface Function<T, R> {
    R apply(T t);
}

interface Consumer<T> {
    void accept(T t);
}

interface Supplier<T> {
    T get();
}

interface Predicate<T> {
    boolean test(T t);
}

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        System.out.println("=== 함수형 인터페이스 예제 ===\n");
        
        // TODO 10: Function 예제 구현하기
        // Function<Integer, Integer> square = 
        // Function<String, Integer> length = 
        // System.out.println("5의 제곱: " + square.apply(5));
        // System.out.println("\"Hello\"의 길이: " + length.apply("Hello"));
        
        // TODO 11: Consumer 예제 구현하기
        // Consumer<String> printer = 
        // Consumer<Integer> doubler = 
        // printer.accept("Hello Lambda!");
        // doubler.accept(7);
        
        // TODO 12: Supplier 예제 구현하기
        // Supplier<Double> random = 
        // Supplier<String> greeting = 
        // System.out.println("난수: " + random.get());
        // System.out.println("인사: " + greeting.get());
        
        // TODO 13: Predicate 예제 구현하기
        // Predicate<Integer> isPositive = 
        // Predicate<String> isEmpty = 
        // System.out.println("10은 양수인가? " + isPositive.test(10));
        // System.out.println("\"\"은 비어있는가? " + isEmpty.test(""));
    }
}
```

#### 실행 결과 (참고용):
```
=== 함수형 인터페이스 예제 ===

5의 제곱: 25
"Hello"의 길이: 5
출력: Hello Lambda!
7의 2배는 14
난수: 0.7234567890123456
인사: 안녕하세요!
10은 양수인가? true
""은 비어있는가? true
```

### 실습 2-2: 커스텀 함수형 인터페이스 만들기

#### 요구사항
- 특별한 목적을 위한 함수형 인터페이스 설계
- 2개, 3개 매개변수를 받는 인터페이스 구현
- 조건 선택 함수형 인터페이스 구현

```java
// TODO 14: 두 개의 매개변수를 받는 함수형 인터페이스 만들기
interface BinaryOperator<T> {
    // T apply(T t1, T t2)
}

// TODO 15: 세 개의 매개변수를 받는 함수형 인터페이스 만들기
interface TriFunction<T, U, V, R> {
    // R apply(T t, U u, V v)
}

// TODO 16: 조건 선택 함수형 인터페이스 만들기
interface ConditionalSelector<T> {
    // T select(boolean condition, T ifTrue, T ifFalse)
}

public class CustomFunctionalInterfaces {
    public static void main(String[] args) {
        System.out.println("=== 커스텀 함수형 인터페이스 ===\n");
        
        // TODO 17: BinaryOperator 사용하기
        // BinaryOperator<Integer> max = 
        // BinaryOperator<String> concat = 
        // System.out.println("max(10, 20) = " + max.apply(10, 20));
        // System.out.println("concat(\"Hello\", \"World\") = " + concat.apply("Hello", "World"));
        
        // TODO 18: TriFunction 사용하기
        // TriFunction<Integer, Integer, Integer, Integer> sum3 = 
        // TriFunction<String, String, String, String> join = 
        // System.out.println("sum3(1, 2, 3) = " + sum3.apply(1, 2, 3));
        // System.out.println("join = " + join.apply("2024", "03", "15"));
        
        // TODO 19: ConditionalSelector 사용하기
        // ConditionalSelector<String> selector = 
        // System.out.println("선택 결과: " + selector.select(10 > 5, "크다", "작다"));
    }
}
```

#### 실행 결과 (참고용):
```
=== 커스텀 함수형 인터페이스 ===

max(10, 20) = 20
concat("Hello", "World") = HelloWorld
sum3(1, 2, 3) = 6
join = 2024-03-15
선택 결과: 크다
```

## 3. 람다를 매개변수로 전달하는 실습

### 실습 3-1: 배열 처리 메서드 만들기

#### 요구사항
- 람다를 매개변수로 받아 배열을 다양하게 처리하는 메서드 구현
- 배열 처리기(ArrayProcessor)를 사용한 유연한 처리
- 배열 변환기(ArrayTransformer)를 사용한 요소 변환

```java
interface ArrayProcessor {
    void process(int[] array);
}

interface ArrayTransformer {
    int transform(int element);
}

public class LambdaAsParameter {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("=== 람다를 매개변수로 전달 ===\n");
        
        // TODO 20: 원본 배열 출력하기
        System.out.print("원본 배열: ");
        // processArray(numbers, arr -> );
        
        // TODO 21: 제곱 출력하기
        System.out.print("제곱 출력: ");
        // processArray(numbers, arr -> );
        
        // TODO 22: 합계 계산하기
        // processArray(numbers, arr -> );
        
        // TODO 23: 배열 변환 테스트하기
        // int[] doubled = transformArray(numbers, n -> n * 2);
        // System.out.print("2배 변환: ");
        // printArray(doubled);
        
        // int[] squared = transformArray(numbers, );
        // System.out.print("제곱 변환: ");
        // printArray(squared);
    }
    
    // TODO 24: processArray 메서드 구현하기
    static void processArray(int[] array, ArrayProcessor processor) {
        // processor.process(array) 호출
    }
    
    // TODO 25: transformArray 메서드 구현하기
    static int[] transformArray(int[] array, ArrayTransformer transformer) {
        // 새 배열 생성하고 변환
    }
    
    static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
```

#### 실행 결과 (참고용):
```
=== 람다를 매개변수로 전달 ===

원본 배열: 1 2 3 4 5 
제곱 출력: 1 4 9 16 25 
합계: 15
2배 변환: 2 4 6 8 10 
제곱 변환: 1 4 9 16 25 
```

### 실습 3-2: 조건부 실행 구현하기

#### 요구사항
- 조건과 동작을 람다로 받아 유연한 실행 로직 구현
- 조건에 따른 선택적 실행
- 반복 실행 및 조건 선택 실행 기능

```java
interface Condition {
    boolean test();
}

interface Action {
    void perform();
}

public class ConditionalExecution {
    public static void main(String[] args) {
        System.out.println("=== 조건부 실행 예제 ===\n");
        
        int score = 85;
        
        // TODO 26: 조건부 실행 테스트하기
        // executeIf(() -> score >= 90, () -> System.out.println("A 학점입니다!"));
        // executeIf(, () -> System.out.println("B 학점입니다!"));
        
        // TODO 27: 반복 실행 테스트하기
        int count = 3;
        // repeatAction(count, () -> System.out.println("반복 실행!"));
        
        // TODO 28: 조건에 따른 선택 실행 테스트하기
        // chooseAction(score >= 60, , );
    }
    
    // TODO 29: executeIf 메서드 구현하기
    static void executeIf(Condition condition, Action action) {
        // 조건 확인 후 실행
    }
    
    // TODO 30: repeatAction 메서드 구현하기
    static void repeatAction(int times, Action action) {
        // times번 반복 실행
    }
    
    // TODO 31: chooseAction 메서드 구현하기
    static void chooseAction(boolean condition, Action ifTrue, Action ifFalse) {
        // 조건에 따라 선택 실행
    }
}
```

#### 실행 결과 (참고용):
```
=== 조건부 실행 예제 ===

B 학점입니다!
반복 실행!
반복 실행!
반복 실행!
합격입니다!
```

## 4. 람다를 반환하는 함수 실습

### 실습 4-1: 연산 생성기 만들기

#### 요구사항
- 특정 기능을 수행하는 람다를 동적으로 생성하는 팩토리 메서드 구현
- 덧셈기, 곱셈기, 범위 검사기 생성
- 연산자 문자열에 따른 연산 선택 기능

```java
interface Operation {
    int apply(int x);
}

interface BiOperation {
    int apply(int x, int y);
}

public class LambdaFactory {
    public static void main(String[] args) {
        System.out.println("=== 람다를 반환하는 함수 ===\n");
        
        // TODO 32: 단항 연산 생성 테스트하기
        // Operation addFive = makeAdder(5);
        // Operation multiplyByTen = makeMultiplier(10);
        // System.out.println("7 + 5 = " + addFive.apply(7));
        // System.out.println("7 × 10 = " + multiplyByTen.apply(7));
        
        // TODO 33: 범위 검사기 테스트하기
        // Operation inRange = makeRangeChecker(0, 100);
        // System.out.println("50은 0-100 범위? " + (inRange.apply(50) == 1));
        // System.out.println("150은 0-100 범위? " + (inRange.apply(150) == 1));
        
        // TODO 34: 이항 연산 선택 테스트하기
        // BiOperation op = getOperation("+");
        // System.out.println("10 + 5 = " + op.apply(10, 5));
    }
    
    // TODO 35: makeAdder 메서드 구현하기
    static Operation makeAdder(int n) {
        
    }
    
    // TODO 36: makeMultiplier 메서드 구현하기
    static Operation makeMultiplier(int n) {
        
    }
    
    // TODO 37: makeRangeChecker 메서드 구현하기
    static Operation makeRangeChecker(int min, int max) {
        
    }
    
    // TODO 38: getOperation 메서드 구현하기
    static BiOperation getOperation(String op) {
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 람다를 반환하는 함수 ===

7 + 5 = 12
7 × 10 = 70
50은 0-100 범위? true
150은 0-100 범위? false
10 + 5 = 15
```

### 실습 4-2: 정렬 비교기 생성하기

#### 요구사항
- 학생 객체를 다양한 기준으로 정렬할 수 있는 비교기 생성
- 이름순, 점수순 정렬 비교기 구현
- 오름차순/내림차순 선택 가능한 비교기

```java
interface Comparator<T> {
    int compare(T a, T b);
}

class Student {
    String name;
    int score;
    int age;
    
    Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }
    
    public String toString() {
        return name + "(점수:" + score + ", 나이:" + age + ")";
    }
}

public class ComparatorFactory {
    public static void main(String[] args) {
        Student[] students = {
            new Student("김철수", 85, 20),
            new Student("이영희", 92, 19),
            new Student("박민수", 78, 21),
            new Student("최지우", 92, 20)
        };
        
        System.out.println("=== 비교기 생성 예제 ===\n");
        
        // TODO 39: 이름순 정렬 테스트하기
        // sortStudents(students, getNameComparator());
        // System.out.println("이름순:");
        // printStudents(students);
        
        // TODO 40: 점수순 정렬 테스트하기
        // sortStudents(students, getScoreComparator(false));
        // System.out.println("\n점수순 (높은순):");
        // printStudents(students);
    }
    
    // TODO 41: getNameComparator 메서드 구현하기
    static Comparator<Student> getNameComparator() {
        
    }
    
    // TODO 42: getScoreComparator 메서드 구현하기
    static Comparator<Student> getScoreComparator(boolean ascending) {
        
    }
    
    // TODO 43: sortStudents 메서드 구현하기 (버블 정렬 사용)
    static void sortStudents(Student[] students, Comparator<Student> comp) {
        
    }
    
    static void printStudents(Student[] students) {
        for (Student s : students) {
            System.out.println("  " + s);
        }
    }
}
```

#### 실행 결과 (참고용):
```
=== 비교기 생성 예제 ===

이름순:
  김철수(점수:85, 나이:20)
  박민수(점수:78, 나이:21)
  이영희(점수:92, 나이:19)
  최지우(점수:92, 나이:20)

점수순 (높은순):
  이영희(점수:92, 나이:19)
  최지우(점수:92, 나이:20)
  김철수(점수:85, 나이:20)
  박민수(점수:78, 나이:21)
```

## 5. 메서드 참조 실습

### 실습 5-1: 정적 메서드 참조 사용하기

#### 요구사항
- 기존 메서드를 메서드 참조로 사용하는 방법 익히기
- Math 클래스의 메서드 참조 사용
- 사용자 정의 정적 메서드 참조 구현

```java
interface MathFunction {
    double apply(double x);
}

interface StringFunction {
    int apply(String s);
}

public class StaticMethodReference {
    public static void main(String[] args) {
        System.out.println("=== 정적 메서드 참조 ===\n");
        
        // TODO 44: Math 클래스의 메서드 참조 사용하기
        // MathFunction sqrt = ...;
        // MathFunction abs = ...;
        // System.out.println("sqrt(16) = " + sqrt.apply(16));
        // System.out.println("abs(-10) = " + abs.apply(-10));
        
        // TODO 45: Integer 클래스의 메서드 참조 사용하기
        // StringFunction parseInt = ...;
        // System.out.println("parseInt(\"123\") = " + parseInt.apply("123"));
        
        // TODO 46: 사용자 정의 정적 메서드 참조 사용하기
        // MathFunction doubleIt = ...;
        // MathFunction tripleIt = ...;
        // System.out.println("double(5) = " + doubleIt.apply(5));
        // System.out.println("triple(5) = " + tripleIt.apply(5));
    }
    
    // TODO 47: doubleValue 메서드 구현하기
    static double doubleValue(double x) {
        
    }
    
    // TODO 48: tripleValue 메서드 구현하기
    static double tripleValue(double x) {
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 정적 메서드 참조 ===

sqrt(16) = 4.0
abs(-10) = 10.0
parseInt("123") = 123
double(5) = 10.0
triple(5) = 15.0
```

### 실습 5-2: 인스턴스 메서드 참조 사용하기

#### 요구사항
- 인스턴스 메서드를 참조하는 다양한 방법 익히기
- 특정 객체의 메서드 참조
- 특정 타입의 임의 객체의 인스턴스 메서드 참조

```java
interface StringOperation {
    String apply(String s);
}

interface IntSupplier {
    int get();
}

class StringProcessor {
    private String prefix;
    
    StringProcessor(String prefix) {
        this.prefix = prefix;
    }
    
    String addPrefix(String s) {
        return prefix + s;
    }
    
    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

public class InstanceMethodReference {
    public static void main(String[] args) {
        System.out.println("=== 인스턴스 메서드 참조 ===\n");
        
        // TODO 49: String 인스턴스의 메서드 참조 사용하기
        String str = "Hello World";
        // IntSupplier length = ...;
        // StringOperation toUpper = ...;
        // System.out.println("길이: " + length.get());
        // System.out.println("대문자: " + toUpper.apply(""));
        
        // TODO 50: 사용자 정의 클래스의 인스턴스 메서드 참조 사용하기
        StringProcessor processor = new StringProcessor("[접두사] ");
        // StringOperation addPre = ...;
        // StringOperation rev = ...;
        // System.out.println(addPre.apply("메시지"));
        // System.out.println(rev.apply("Hello"));
        
        // TODO 51: 특정 타입의 임의 객체의 인스턴스 메서드 참조 사용하기
        // StringOperation trim = ...;
        // StringOperation lower = ...;
        // System.out.println("trim: '" + trim.apply("  공백 제거  ") + "'");
        // System.out.println("lower: " + lower.apply("HELLO"));
    }
}
```

#### 실행 결과 (참고용):
```
=== 인스턴스 메서드 참조 ===

길이: 11
대문자: HELLO WORLD
[접두사] 메시지
olleH
trim: '공백 제거'
lower: hello
```

## 6. 실용적인 람다 활용 실습

### 실습 6-1: 필터링과 변환 구현하기

#### 요구사항
- 배열이나 리스트를 필터링하고 변환하는 유틸리티 메서드 구현
- 제네릭을 사용한 유연한 필터와 맵 메서드
- 숫자와 문자열 리스트에 대한 다양한 처리

```java
import java.util.*;

interface Filter<T> {
    boolean accept(T item);
}

interface Mapper<T, R> {
    R map(T item);
}

public class FilterAndMap {
    public static void main(String[] args) {
        System.out.println("=== 필터링과 변환 예제 ===\n");
        
        // 정수 리스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // TODO 52: 짝수 필터링하기
        // List<Integer> evens = filter(numbers, ...);
        // System.out.println("짝수: " + evens);
        
        // TODO 53: 5보다 큰 수 필터링하기
        // List<Integer> greaterThan5 = filter(numbers, ...);
        // System.out.println("5보다 큰 수: " + greaterThan5);
        
        // TODO 54: 제곱 변환하기
        // List<Integer> squares = map(numbers, ...);
        // System.out.println("제곱: " + squares);
        
        // 문자열 리스트
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        // TODO 55: 길이가 5 이상인 단어 필터링하기
        // List<String> longWords = filter(words, ...);
        // System.out.println("긴 단어: " + longWords);
        
        // TODO 56: 대문자로 변환하기
        // List<String> upperWords = map(words, ...);
        // System.out.println("대문자: " + upperWords);
    }
    
    // TODO 57: filter 메서드 구현하기
    static <T> List<T> filter(List<T> list, Filter<T> filter) {
        
    }
    
    // TODO 58: map 메서드 구현하기
    static <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 필터링과 변환 예제 ===

짝수: [2, 4, 6, 8, 10]
5보다 큰 수: [6, 7, 8, 9, 10]
제곱: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
긴 단어: [apple, banana, cherry]
대문자: [APPLE, BANANA, CHERRY, DATE]
```

### 실습 6-2: 간단한 계산기 애플리케이션 만들기

#### 요구사항
- 람다를 사용하여 확장 가능한 계산기 구현
- Map을 사용한 연산 등록 및 관리
- 이항 연산과 단항 연산 지원
- 사용자 정의 연산 추가 기능

```java
import java.util.*;

interface BinaryOperation {
    double calculate(double a, double b);
}

interface UnaryOperation {
    double calculate(double x);
}

class Calculator {
    private Map<String, BinaryOperation> binaryOps = new HashMap<>();
    private Map<String, UnaryOperation> unaryOps = new HashMap<>();
    
    Calculator() {
        // TODO 59: 이항 연산들 등록하기
        // binaryOps.put("+", ...);
        // binaryOps.put("-", ...);
        // binaryOps.put("*", ...);
        // binaryOps.put("/", ...);
        
        // TODO 60: 단항 연산들 등록하기
        // unaryOps.put("sqrt", ...);
        // unaryOps.put("abs", ...);
        // unaryOps.put("square", ...);
    }
    
    // TODO 61: calculateBinary 메서드 구현하기
    double calculateBinary(double a, String op, double b) {
        
    }
    
    // TODO 62: calculateUnary 메서드 구현하기
    double calculateUnary(String op, double x) {
        
    }
    
    // TODO 63: addBinaryOperation 메서드 구현하기
    void addBinaryOperation(String name, BinaryOperation op) {
        
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        System.out.println("=== 계산기 애플리케이션 ===\n");
        
        Calculator calc = new Calculator();
        
        // TODO 64: 기본 이항 연산 테스트하기
        // System.out.println("10 + 5 = " + calc.calculateBinary(10, "+", 5));
        // System.out.println("10 * 5 = " + calc.calculateBinary(10, "*", 5));
        
        // TODO 65: 단항 연산 테스트하기
        // System.out.println("sqrt(16) = " + calc.calculateUnary("sqrt", 16));
        // System.out.println("square(5) = " + calc.calculateUnary("square", 5));
        
        // TODO 66: 사용자 정의 연산 추가하고 테스트하기
        // calc.addBinaryOperation("avg", ...);
        // System.out.println("avg(10, 20) = " + calc.calculateBinary(10, "avg", 20));
    }
}
```

#### 실행 결과 (참고용):
```
=== 계산기 애플리케이션 ===

10 + 5 = 15.0
10 * 5 = 50.0
sqrt(16) = 4.0
square(5) = 25.0
avg(10, 20) = 15.0
```

## 학습 포인트

### 1. 람다 표현식의 기본
- **문법**: `(매개변수) -> 표현식` 또는 `(매개변수) -> { 블록 }`
- **타입 추론**: 컴파일러가 타입을 자동으로 추론
- **간결성**: 익명 클래스보다 훨씬 간결한 코드

### 2. 함수형 인터페이스
- **단일 추상 메서드**: 하나의 추상 메서드만 가진 인터페이스
- **@FunctionalInterface**: 함수형 인터페이스임을 명시하는 어노테이션
- **표준 인터페이스**: Function, Consumer, Supplier, Predicate 등

### 3. 메서드 참조
- **정적 메서드**: `클래스명::메서드명`
- **인스턴스 메서드**: `객체::메서드명` 또는 `클래스명::메서드명`
- **생성자**: `클래스명::new`

### 4. 람다의 활용
- **고차 함수**: 함수를 매개변수로 받거나 반환하는 함수
- **함수 합성**: 여러 함수를 조합하여 새로운 함수 생성
- **이벤트 처리**: 콜백 함수로 활용

### 5. 실용적 사용
- **컬렉션 처리**: 필터링, 변환, 정렬 등
- **이벤트 핸들링**: GUI 이벤트 처리
- **함수형 프로그래밍**: 순수 함수와 불변성 강조

람다 표현식은 Java 8의 가장 중요한 기능 중 하나로, 코드를 더 간결하고 표현력 있게 만들어줍니다!