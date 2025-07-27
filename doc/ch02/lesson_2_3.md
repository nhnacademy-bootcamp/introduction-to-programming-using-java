# 2.3 문자열, 클래스, 객체 및 서브루틴 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 내장 서브루틴과 함수의 차이를 이해하고 사용할 수 있다
- Math 클래스의 주요 함수들을 활용할 수 있다
- 클래스와 객체의 기본 개념을 이해한다
- String 클래스의 다양한 메소드를 활용할 수 있다
- 텍스트 블록을 사용하여 여러 줄 문자열을 작성할 수 있다
- 열거형(enum)을 정의하고 사용할 수 있다

## 1. 내장 서브루틴과 함수

### 1.1 서브루틴(Subroutine)이란?
서브루틴은 특정 작업을 수행하는 명령어들의 집합입니다. 이름이 부여되어 필요할 때마다 호출할 수 있습니다.

```java
// 서브루틴 호출의 예
System.out.println("Hello World!");  // println은 서브루틴
System.exit(0);                      // exit는 서브루틴
```

### 1.2 함수(Function)란?
함수는 값을 계산하고 반환하는 특별한 종류의 서브루틴입니다.

```java
// 함수 호출의 예
double x = Math.sqrt(25);    // sqrt는 함수, 5.0을 반환
int len = "Hello".length();  // length는 함수, 5를 반환
```

### 1.3 정적 멤버
클래스의 정적(static) 멤버는 클래스 이름을 통해 직접 접근합니다.

```java
// 정적 변수
double pi = Math.PI;        // Math 클래스의 정적 변수
double e = Math.E;          // 자연로그의 밑 e

// 정적 메소드
Math.sqrt(16);              // Math 클래스의 정적 메소드
System.exit(0);             // System 클래스의 정적 메소드
```

## 2. Math 클래스

### 2.1 Math 클래스의 상수
```java
Math.PI    // 3.141592653589793 (원주율)
Math.E     // 2.718281828459045 (자연로그의 밑)
```

### 2.2 주요 수학 함수들

#### 기본 수학 함수
| 함수            | 설명      | 예시                   |
| --------------- | --------- | ---------------------- |
| `Math.abs(x)`   | 절대값    | `Math.abs(-5)` → 5     |
| `Math.sqrt(x)`  | 제곱근    | `Math.sqrt(16)` → 4.0  |
| `Math.pow(x,y)` | x의 y제곱 | `Math.pow(2,3)` → 8.0  |
| `Math.max(x,y)` | 최대값    | `Math.max(10,20)` → 20 |
| `Math.min(x,y)` | 최소값    | `Math.min(10,20)` → 10 |

#### 반올림 함수
| 함수            | 설명   | 예시                    |
| --------------- | ------ | ----------------------- |
| `Math.round(x)` | 반올림 | `Math.round(3.7)` → 4   |
| `Math.floor(x)` | 내림   | `Math.floor(3.7)` → 3.0 |
| `Math.ceil(x)`  | 올림   | `Math.ceil(3.2)` → 4.0  |

#### 삼각 함수 (라디안 단위)
```java
Math.sin(x)     // 사인
Math.cos(x)     // 코사인
Math.tan(x)     // 탄젠트
Math.asin(x)    // 아크사인
Math.acos(x)    // 아크코사인
Math.atan(x)    // 아크탄젠트
```

#### 기타 함수
```java
Math.exp(x)     // e의 x제곱
Math.log(x)     // 자연로그
Math.log10(x)   // 상용로그
Math.random()   // 0.0 이상 1.0 미만의 난수
```

### 2.3 Math.random() 활용
```java
// 0.0 이상 1.0 미만의 난수
double rand = Math.random();

// 1부터 10까지의 정수 난수
int randomInt = (int)(Math.random() * 10) + 1;

// a부터 b까지의 정수 난수 (a <= b)
int randomRange = (int)(Math.random() * (b - a + 1)) + a;
```

**참고**
- [Oracle - class Math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)

## 3. 클래스와 객체

### 3.1 클래스의 두 가지 역할
1. **정적 멤버의 컨테이너**: Math, System처럼 정적 변수와 메소드를 모아놓은 것
2. **객체의 설계도**: String, PrintStream처럼 객체를 생성하기 위한 템플릿

### 3.2 객체란?
객체는 데이터(변수)와 기능(메소드)을 함께 가지고 있는 독립적인 단위입니다.

```java
// String 객체 생성
String message = "Hello World";

// 객체의 메소드 호출
int length = message.length();
char firstChar = message.charAt(0);
```

### 3.3 System.out.println 이해하기
```java
System.out.println("Hello");
```
- `System`: 클래스
- `out`: System 클래스의 정적 변수 (PrintStream 객체)
- `println`: PrintStream 객체의 메소드

## 4. String 클래스

### 4.1 String은 객체
String은 기본 타입이 아니라 클래스이며, String 타입의 값은 객체입니다.

```java
String name = "Java";  // String 객체 생성
```

### 4.2 주요 String 메소드

#### 길이와 문자 접근
```java
String str = "Hello Java";

// 문자열 길이
int len = str.length();              // 10

// 특정 위치의 문자 (0부터 시작)
char first = str.charAt(0);          // 'H'
char last = str.charAt(len - 1);     // 'a'
```

#### 부분 문자열
```java
String str = "Hello World";

// substring(시작인덱스, 끝인덱스)
String sub1 = str.substring(0, 5);   // "Hello"
String sub2 = str.substring(6);      // "World"
```

#### 문자열 비교
```java
String s1 = "Hello";
String s2 = "hello";

// 대소문자 구분 비교
boolean eq1 = s1.equals(s2);              // false
boolean eq2 = s1.equals("Hello");         // true

// 대소문자 무시 비교
boolean eq3 = s1.equalsIgnoreCase(s2);    // true

// 사전순 비교
int comp = s1.compareTo(s2);              // 음수 (H < h)
```

#### 검색
```java
String str = "Java Programming";

// 문자열 검색
int pos1 = str.indexOf("Pro");      // 5
int pos2 = str.indexOf("Python");   // -1 (없음)

// 문자 검색
int pos3 = str.indexOf('a');        // 1 (첫 번째 'a')
int pos4 = str.indexOf('a', 2);     // 3 (2번째 위치부터 검색)
```

#### 변환
```java
String str = "Java Programming";

// 대소문자 변환
String upper = str.toUpperCase();   // "JAVA PROGRAMMING"
String lower = str.toLowerCase();   // "java programming"

// 공백 제거
String spaced = "  Java  ";
String trimmed = spaced.trim();     // "Java"
```

### 4.3 문자열 연결
```java
// + 연산자 사용
String firstName = "홍";
String lastName = "길동";
String fullName = firstName + lastName;  // "홍길동"

// 다른 타입과의 연결
String message = "나이: " + 25;          // "나이: 25"
String calc = "결과: " + (10 + 20);      // "결과: 30"
```

### 4.4 String의 불변성
String 객체는 생성 후 변경할 수 없습니다. 모든 변환 메소드는 새로운 String을 반환합니다.

```java
String original = "Hello";
String upper = original.toUpperCase();

System.out.println(original);  // "Hello" (변경되지 않음)
System.out.println(upper);     // "HELLO"
```

**참고**
- [Oracle - class String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

## 5. 텍스트 블록 (Java 15+)

### 5.1 기존 방식의 문제점
```java
// 여러 줄 문자열을 표현하기 불편함
String json = "{\n" +
              "  \"name\": \"홍길동\",\n" +
              "  \"age\": 25\n" +
              "}";
```

### 5.2 텍스트 블록 사용
```java
// 텍스트 블록으로 간단하게 표현
String json = """
    {
      "name": "홍길동",
      "age": 25
    }""";

// HTML 예제
String html = """
    <html>
        <body>
            <h1>Welcome</h1>
            <p>Hello, World!</p>
        </body>
    </html>""";
```

### 5.3 텍스트 블록 규칙
- 시작: `"""` 다음에 줄바꿈
- 종료: `"""`
- 들여쓰기: 공통 들여쓰기는 제거됨
- 이스케이프: 일반 문자열과 동일

## 6. 열거형 (Enum)

### 6.1 열거형 정의
열거형은 정해진 값들의 집합을 나타내는 특별한 타입입니다.

```java
// 계절을 나타내는 열거형
enum Season {
    SPRING, SUMMER, FALL, WINTER
}

// 요일을 나타내는 열거형
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}
```

### 6.2 열거형 사용
```java
// 변수 선언
Season currentSeason;
Day today;

// 값 할당
currentSeason = Season.SUMMER;
today = Day.MONDAY;

// 출력
System.out.println(currentSeason);  // "SUMMER"
System.out.println(today);          // "MONDAY"
```

### 6.3 열거형 메소드
```java
// ordinal() - 순서 반환 (0부터 시작)
int seasonOrder = Season.FALL.ordinal();     // 2
int dayOrder = Day.FRIDAY.ordinal();         // 5

// 비교
if (today == Day.FRIDAY) {
    System.out.println("불금!");
}
```

### 6.4 열거형의 장점
- 타입 안정성: 정해진 값만 사용 가능
- 가독성: 의미 있는 이름 사용
- 오류 방지: 잘못된 값 할당 불가

**참고**:

- [Java Enum](./java-enum-guide.md)
- [Baeldung: A Guide to Java Enums](https://www.baeldung.com/a-guide-to-java-enums)

## 7. 종합 예제

### 예제: 시간 측정과 수학 계산
```java
public class MathDemo {
    public static void main(String[] args) {
        // 시작 시간 기록
        long startTime = System.nanoTime();

        // 삼각형의 빗변 계산
        double a = 3.0;
        double b = 4.0;
        double c = Math.sqrt(a*a + b*b);
        System.out.println("빗변의 길이: " + c);

        // 원의 넓이 계산
        double radius = 5.0;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("원의 넓이: " + area);

        // 난수 생성
        int dice = (int)(Math.random() * 6) + 1;
        System.out.println("주사위 결과: " + dice);

        // 실행 시간 계산
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("실행 시간: " + seconds + "초");
    }
}
```

## 요약

- **서브루틴**: 작업을 수행하는 명령어 집합
- **함수**: 값을 반환하는 서브루틴
- **Math 클래스**: 다양한 수학 함수 제공
- **String 클래스**: 문자열 처리를 위한 다양한 메소드 제공
- **텍스트 블록**: 여러 줄 문자열을 쉽게 작성
- **열거형**: 정해진 값들의 집합을 나타내는 타입