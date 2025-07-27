# Java 리터럴(Literal) 가이드 ☕

## 목차
1. [리터럴이란?](#1-리터럴이란)
2. [리터럴의 종류](#2-리터럴의-종류)
3. [각 타입별 리터럴 상세](#3-각-타입별-리터럴-상세)
4. [리터럴과 상수의 차이](#4-리터럴과-상수의-차이)
5. [특수한 리터럴](#5-특수한-리터럴)
6. [리터럴 사용 시 주의사항](#6-리터럴-사용-시-주의사항)

---

## 1. 리터럴이란?

### 1.1 정의
**리터럴(Literal)**은 소스 코드에서 **고정된 값을 직접 표현한 것**입니다. 변수나 상수에 저장되는 실제 데이터 값 자체를 의미합니다.

### 1.2 리터럴 vs 변수
```java
int number = 42;        // 42가 리터럴
String text = "Hello";  // "Hello"가 리터럴
boolean flag = true;    // true가 리터럴

// number, text, flag는 변수
// 42, "Hello", true는 리터럴
```

### 1.3 리터럴의 특징
- ✅ 컴파일 시점에 값이 결정됨
- ✅ 프로그램 실행 중 값이 변하지 않음
- ✅ 메모리의 특정 영역(상수 풀)에 저장됨
- ✅ 코드에 직접 작성된 값

---

## 2. 리터럴의 종류

### 2.1 Java 리터럴 타입 분류

| 리터럴 타입       | 예시                      | 설명        |
| ----------------- | ------------------------- | ----------- |
| **정수 리터럴**   | `42`, `0xFF`, `0b1010`    | 정수 값     |
| **실수 리터럴**   | `3.14`, `2.5f`, `1.0e-5`  | 실수 값     |
| **문자 리터럴**   | `'A'`, `'\n'`, `'\u0041'` | 단일 문자   |
| **문자열 리터럴** | `"Hello"`, `"Java\n"`     | 문자열      |
| **논리 리터럴**   | `true`, `false`           | 불린 값     |
| **null 리터럴**   | `null`                    | 참조 없음   |
| **클래스 리터럴** | `String.class`            | 클래스 객체 |

---

## 3. 각 타입별 리터럴 상세

### 3.1 정수 리터럴 (Integer Literals)

```java
public class IntegerLiterals {
    public static void main(String[] args) {
        // 10진수 (Decimal)
        int decimal = 42;
        int negative = -100;

        // 2진수 (Binary) - 0b 또는 0B 접두사
        int binary = 0b101010;      // 42
        int binary2 = 0B11111111;   // 255

        // 8진수 (Octal) - 0 접두사
        int octal = 052;            // 42
        int octal2 = 0377;          // 255

        // 16진수 (Hexadecimal) - 0x 또는 0X 접두사
        int hex = 0x2A;             // 42
        int hex2 = 0xFF;            // 255

        // long 타입 - L 또는 l 접미사
        long bigNumber = 123456789L;
        long hexLong = 0xCAFEBABEL;

        // Java 7+ 언더스코어 사용 가능
        int million = 1_000_000;
        long creditCard = 1234_5678_9012_3456L;
        int binary3 = 0b1111_0000_1111_0000;

        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hex: " + hex);
    }
}
```

#### 정수 리터럴 규칙
- 기본 타입은 `int`
- 범위를 벗어나면 `long` 사용 (L 접미사)
- 언더스코어는 숫자 사이에만 사용 가능

### 3.2 실수 리터럴 (Floating-Point Literals)

```java
public class FloatingPointLiterals {
    public static void main(String[] args) {
        // double 타입 (기본)
        double d1 = 3.14;
        double d2 = 3.14159265359;
        double d3 = 3.0;            // .0 필수
        double d4 = .5;             // 0.5와 같음

        // float 타입 - f 또는 F 접미사
        float f1 = 3.14f;
        float f2 = 3.14F;

        // 과학적 표기법 (E-notation)
        double scientific1 = 1.23e4;    // 1.23 × 10^4 = 12300.0
        double scientific2 = 1.23E-4;   // 1.23 × 10^-4 = 0.000123
        float scientific3 = 3.14e2f;    // 314.0f

        // 16진수 실수 (Java 5+)
        double hexFloat = 0x1.8p1;      // 1.5 × 2^1 = 3.0

        // Java 7+ 언더스코어
        double pi = 3.141_592_653_589;
        float bigFloat = 1_234.567_89f;

        // 특수 값
        double infinity = Double.POSITIVE_INFINITY;
        double negInfinity = Double.NEGATIVE_INFINITY;
        double notANumber = Double.NaN;
    }
}
```

### 3.3 문자 리터럴 (Character Literals)

```java
public class CharacterLiterals {
    public static void main(String[] args) {
        // 일반 문자
        char letter = 'A';
        char digit = '7';
        char space = ' ';

        // 이스케이프 시퀀스
        char newline = '\n';        // 개행
        char tab = '\t';            // 탭
        char backslash = '\\';      // 백슬래시
        char singleQuote = '\'';    // 작은따옴표
        char doubleQuote = '\"';    // 큰따옴표
        char carriageReturn = '\r'; // 캐리지 리턴
        char backspace = '\b';      // 백스페이스
        char formFeed = '\f';       // 폼 피드

        // 유니코드 이스케이프
        char unicodeA = '\u0041';   // 'A'
        char korean = '\uAC00';     // '가'
        char emoji = '\u263A';      // '☺'

        // 8진수 이스케이프 (0~377)
        char octalChar = '\101';    // 'A' (8진수 101 = 10진수 65)

        System.out.println("Letter: " + letter);
        System.out.println("Unicode A: " + unicodeA);
        System.out.println("Korean: " + korean);
        System.out.println("Emoji: " + emoji);
    }
}
```

### 3.4 문자열 리터럴 (String Literals)

```java
public class StringLiterals {
    public static void main(String[] args) {
        // 기본 문자열
        String simple = "Hello, World!";
        String empty = "";

        // 이스케이프 시퀀스 포함
        String multiline = "First line\nSecond line";
        String tabbed = "Column1\tColumn2\tColumn3";
        String quoted = "She said, \"Hello!\"";
        String path = "C:\\Users\\Documents\\file.txt";

        // 유니코드 포함
        String unicode = "Java\u2122 Programming";  // Java™ Programming
        String korean = "\uC790\uBC14";             // "자바"

        // 긴 문자열 (연결)
        String longString = "This is a very long string that " +
                           "spans multiple lines in the source code " +
                           "but is actually a single string.";

        // Java 15+ Text Blocks (멀티라인 문자열)
        String textBlock = """
                          {
                              "name": "Java",
                              "version": 17,
                              "features": ["records", "sealed classes"]
                          }
                          """;

        // 문자열 풀 (String Pool)
        String s1 = "Java";  // 문자열 풀에 저장
        String s2 = "Java";  // 같은 객체 참조
        System.out.println(s1 == s2);  // true
    }
}
```

### 3.5 논리 리터럴 (Boolean Literals)

```java
public class BooleanLiterals {
    public static void main(String[] args) {
        // boolean 리터럴은 오직 두 개
        boolean isTrue = true;
        boolean isFalse = false;

        // 대소문자 구분 (TRUE, FALSE는 리터럴이 아님)
        // boolean wrong = TRUE;  // 컴파일 에러

        // 조건식에서 사용
        if (true) {
            System.out.println("Always executed");
        }

        while (false) {
            System.out.println("Never executed");
        }
    }
}
```

### 3.6 null 리터럴

```java
public class NullLiteral {
    public static void main(String[] args) {
        // 모든 참조 타입에 할당 가능
        String str = null;
        Integer number = null;
        Object obj = null;
        int[] array = null;

        // 기본 타입에는 할당 불가
        // int x = null;  // 컴파일 에러

        // null 체크
        if (str == null) {
            System.out.println("str is null");
        }

        // null과 문자열 연결
        String result = "Value: " + null;  // "Value: null"
        System.out.println(result);
    }
}
```

### 3.7 클래스 리터럴 (Class Literals)

```java
public class ClassLiterals {
    public static void main(String[] args) {
        // 클래스 리터럴
        Class<String> stringClass = String.class;
        Class<Integer> intClass = int.class;  // 기본 타입도 가능
        Class<?> objectClass = Object.class;

        // 배열 클래스 리터럴
        Class<int[]> intArrayClass = int[].class;
        Class<String[]> stringArrayClass = String[].class;

        // 사용 예
        System.out.println(String.class.getName());        // java.lang.String
        System.out.println(int.class.isPrimitive());       // true
        System.out.println(Integer.class.isPrimitive());   // false

        // 리플렉션에서 활용
        try {
            Object instance = String.class.newInstance();  // deprecated
            Object instance2 = String.class.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 4. 리터럴과 상수의 차이

### 4.1 개념 비교

```java
public class LiteralVsConstant {
    // 상수 (constant) - final 키워드 사용
    public static final double PI = 3.14159;  // 3.14159는 리터럴
    public static final String COMPANY = "OpenAI";  // "OpenAI"는 리터럴

    public static void main(String[] args) {
        // 리터럴 직접 사용
        double area1 = 3.14159 * 10 * 10;  // 3.14159는 리터럴

        // 상수 사용
        double area2 = PI * 10 * 10;       // PI는 상수

        // 리터럴은 값 자체, 상수는 값을 담는 불변 변수
        System.out.println(100);            // 100은 리터럴
        System.out.println(PI);             // PI는 상수
    }
}
```

### 4.2 주요 차이점

| 구분            | 리터럴                  | 상수                  |
| --------------- | ----------------------- | --------------------- |
| **정의**        | 코드에 직접 작성된 값   | final로 선언된 변수   |
| **예시**        | `42`, `"Hello"`, `true` | `final int MAX = 100` |
| **변경 가능성** | 불가능 (값 자체)        | 불가능 (final)        |
| **메모리**      | 리터럴 풀               | 변수 공간             |
| **재사용성**    | 매번 작성               | 이름으로 참조         |

---

## 5. 특수한 리터럴

### 5.1 Text Blocks (Java 15+)

```java
public class TextBlockExample {
    public static void main(String[] args) {
        // 전통적인 방식
        String json1 = "{\n" +
                      "  \"name\": \"Java\",\n" +
                      "  \"version\": 17\n" +
                      "}";

        // Text Block 방식
        String json2 = """
                      {
                        "name": "Java",
                        "version": 17
                      }
                      """;

        // HTML 예제
        String html = """
                     <html>
                         <body>
                             <h1>Hello, World!</h1>
                         </body>
                     </html>
                     """;

        // SQL 쿼리
        String query = """
                      SELECT id, name, email
                      FROM users
                      WHERE age > 18
                      ORDER BY name
                      """;
    }
}
```

### 5.2 Raw String Literals (제안 단계)

```java
// 미래의 Java에서 가능할 수도 있는 기능
// String regex = `\d{3}-\d{3}-\d{4}`;  // 이스케이프 불필요
// String path = `C:\Users\Documents`;   // 백슬래시 그대로
```

---

## 6. 리터럴 사용 시 주의사항

### 6.1 ⚠️ 주의사항

1. **정수 오버플로우**
   ```java
   // int max = 2147483648;  // 컴파일 에러 (int 범위 초과)
   long max = 2147483648L;   // L 접미사 필요
   ```

2. **8진수 실수**
   ```java
   int num1 = 010;   // 8 (8진수)
   int num2 = 10;    // 10 (10진수)
   // 실수하기 쉬운 부분!
   ```

3. **부동소수점 정밀도**
   ```java
   float f = 3.14;   // 컴파일 에러! double을 float에 할당
   float f = 3.14f;  // OK
   ```

4. **문자열 풀과 메모리**
   ```java
   String s1 = "Hello";        // 문자열 풀
   String s2 = new String("Hello");  // 힙 메모리
   System.out.println(s1 == s2);     // false
   ```

### 6.2 ✅ Best Practices

1. **매직 넘버 대신 상수 사용**
   ```java
   // Bad
   if (age > 18) { }

   // Good
   private static final int ADULT_AGE = 18;
   if (age > ADULT_AGE) { }
   ```

2. **가독성을 위한 언더스코어**
   ```java
   // Bad
   long worldPopulation = 7900000000L;

   // Good
   long worldPopulation = 7_900_000_000L;
   ```

3. **적절한 타입 선택**
   ```java
   // 정수
   byte small = 127;
   int normal = 1000;
   long big = 10_000_000_000L;

   // 실수
   float approximate = 3.14f;
   double precise = 3.141592653589793;
   ```

4. **Text Block으로 가독성 향상**
   ```java
   // Java 15+
   String sql = """
               SELECT * FROM users
               WHERE status = 'ACTIVE'
               AND created_at > ?
               """;
   ```

### 6.3 정리

리터럴은 Java 프로그래밍의 기본 구성 요소입니다. 코드에서 직접 표현되는 고정된 값으로, 변수와 상수에 할당되는 실제 데이터입니다. 각 타입별 리터럴의 규칙을 이해하고 적절히 사용하면 더 명확하고 유지보수하기 쉬운 코드를 작성할 수 있습니다.