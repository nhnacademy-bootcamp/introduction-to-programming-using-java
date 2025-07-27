# 2.3 문자열, 클래스, 객체 및 서브루틴 - 예제 모음

## 1. Math 클래스 예제

### 예제 1-1: 기본 수학 함수
```java
public class MathBasics {
    public static void main(String[] args) {
        // TODO: 절대값 예제를 출력하세요
        // 힌트:
        // 1. "절대값 예제:" 출력
        // 2. Math.abs(-10)의 결과 출력
        // 3. Math.abs(3.14)의 결과 출력
        // 4. Math.abs(-3.14)의 결과 출력
        
        // TODO: 제곱근과 거듭제곱 예제를 출력하세요
        // 힌트:
        // 1. "\n제곱근과 거듭제곱:" 출력
        // 2. Math.sqrt(16)의 결과 (4.0)
        // 3. Math.sqrt(2)의 결과 (1.414...)
        // 4. Math.pow(2, 3)의 결과 (8.0)
        // 5. Math.pow(10, -2)의 결과 (0.01)
        
        // TODO: 최대값과 최소값 예제를 출력하세요
        // 힌트:
        // 1. "\n최대값과 최소값:" 출력
        // 2. Math.max(10, 20)의 결과 (20)
        // 3. Math.min(10, 20)의 결과 (10)
        // 4. Math.max(-5, -10)의 결과 (-5)
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
절대값 예제:
10
3.14
3.14

제곱근과 거듭제곱:
4.0
1.4142135623730951
8.0
0.01

최대값과 최소값:
20
10
-5
```

### 예제 1-2: 반올림 함수들
```java
public class RoundingFunctions {
    public static void main(String[] args) {
        // TODO: 반올림 함수들을 테스트할 숫자 배열을 선언하세요
        // 힌트: double[] numbers = {3.14, 3.5, 3.8, -2.3, -2.7};
        
        // TODO: 테이블 헤더를 출력하세요
        // 힌트:
        // 1. "숫자\tround\tfloor\tceil" 출력
        // 2. 구분선 "----------------------------------------" 출력
        
        // TODO: 각 숫자에 대해 round, floor, ceil 결과를 출력하세요
        // 힌트:
        // for-each 루프를 사용하여 각 숫자에 대해
        // Math.round(), Math.floor(), Math.ceil() 결과를 탭으로 구분하여 출력
        
        // TODO: 특별한 경우들을 출력하세요
        // 힌트:
        // 1. "\n특별한 경우:" 출력
        // 2. Math.floor(5.0)의 결과 (5.0)
        // 3. Math.ceil(5.0)의 결과 (5.0)
        // 4. Math.round(5.5)의 결과 (6)
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
숫자	round	floor	ceil
----------------------------------------
3.14	3	3.0	4.0
3.5	4	3.0	4.0
3.8	4	3.0	4.0
-2.3	-2	-3.0	-2.0
-2.7	-3	-3.0	-2.0

특별한 경우:
5.0
5.0
6
```

### 예제 1-3: 삼각 함수
```java
public class TrigonometryDemo {
    public static void main(String[] args) {
        // TODO: 45도의 삼각함수 값을 계산하고 출력하세요
        // 힌트:
        // 1. degrees = 45 선언
        // 2. radians = Math.toRadians(degrees)로 라디안 변환
        // 3. "도의 삼각함수 값:" 출력
        // 4. sin, cos, tan 값을 각각 출력
        
        // TODO: 특별한 각도들의 삼각함수 값을 출력하세요
        // 힌트:
        // 1. "\n특별한 각도:" 출력
        // 2. sin(0°), sin(90°), cos(0°), cos(90°) 출력
        // Math.PI/2는 90도를 라디안으로 변환한 값
        
        // TODO: 역삼각 함수를 사용하여 각도를 구하세요
        // 힌트:
        // 1. value = 0.5 선언
        // 2. angle = Math.asin(value)로 역사인 계산
        // 3. 라디안과 도 단위로 출력 (Math.toDegrees 사용)
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
45도의 삼각함수 값:
sin(45°) = 0.7071067811865476
cos(45°) = 0.7071067811865476
tan(45°) = 0.9999999999999999

특별한 각도:
sin(0°) = 0.0
sin(90°) = 1.0
cos(0°) = 1.0
cos(90°) = 6.123233995736766E-17

asin(0.5) = 0.5235987755982989 라디안
asin(0.5) = 30.000000000000004 도
```

### 예제 1-4: 난수 생성
```java
public class RandomNumbers {
    public static void main(String[] args) {
        // TODO: 난수 생성 예제 시작 메시지를 출력하세요
        // 힌트: "=== 난수 생성 예제 ==="
        
        // TODO: 기본 난수 5개를 생성하고 출력하세요
        // 힌트:
        // 1. "기본 난수 5개:" 출력
        // 2. for 루프로 5번 반복하여 Math.random() 결과 출력
        
        // TODO: 1부터 10까지의 난수 정수 10개를 생성하세요
        // 힌트:
        // 1. "\n1-10 사이의 정수:" 출력
        // 2. for 루프 10번 반복
        // 3. int num = (int)(Math.random() * 10) + 1; 사용
        // 4. 공백으로 구분하여 출력
        
        // TODO: 주사위 시뮬레이션 (1-6) 10번 수행하세요
        // 힌트:
        // 1. "\n\n주사위 10번 굴리기:" 출력
        // 2. int dice = (int)(Math.random() * 6) + 1; 사용
        // 3. 공백으로 구분하여 출력
        
        // TODO: 동전 던지기 시뮬레이션 20번 수행하세요
        // 힌트:
        // 1. "\n\n동전 던지기 20번:" 출력
        // 2. boolean heads = Math.random() < 0.5; 사용
        // 3. 삼항 연산자로 heads ? "앞 " : "뒤 " 출력
        // 4. 마지막에 줄바꿈 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 난수 생성 예제 ===
기본 난수 5개:
0.8394154748394725
0.4729282107456321
0.9456312847294863
0.2394856372946192
0.6847293745628394

1-10 사이의 정수:
7 3 9 1 5 8 2 6 4 10 

주사위 10번 굴리기:
4 6 2 1 5 3 6 4 2 1 

동전 던지기 20번:
앞 뒤 앞 앞 뒤 뒤 앞 뒤 앞 앞 뒤 앞 뒤 앞 앞 뒤 뒤 앞 뒤 앞 
```

### 예제 1-5: 실용적인 수학 계산
```java
public class PracticalMath {
    public static void main(String[] args) {
        // TODO: 피타고라스 정리를 사용하여 직각삼각형의 빗변을 계산하세요
        // 힌트:
        // 1. a = 3.0, b = 4.0 선언
        // 2. c = Math.sqrt(a*a + b*b) 계산
        // 3. "직각삼각형의 빗변: " + c 출력
        
        // TODO: 원의 넓이와 둘레를 계산하세요
        // 힌트:
        // 1. radius = 5.0 선언
        // 2. area = Math.PI * radius * radius 계산
        // 3. circumference = 2 * Math.PI * radius 계산
        // 4. 반지름, 넓이, 둘레 출력
        
        // TODO: 복리 계산을 수행하세요
        // 힌트:
        // 1. principal = 10000 (원금)
        // 2. rate = 0.05 (연이율 5%)
        // 3. years = 10 (기간)
        // 4. amount = principal * Math.pow(1 + rate, years) 계산
        // 5. 원금과 10년 후 금액 출력
        
        // TODO: 각도 변환을 수행하세요
        // 힌트:
        // 1. angleInDegrees = 180 선언
        // 2. angleInRadians = Math.toRadians(angleInDegrees) 변환
        // 3. 도와 라디안 값 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
직각삼각형의 빗변: 5.0
반지름 5.0인 원의 넓이: 78.53981633974483
반지름 5.0인 원의 둘레: 31.41592653589793
원금: $10000.0
10년 후 금액: $16288.946267774416
180도 = 3.141592653589793 라디안
```

## 2. String 클래스 예제

### 예제 2-1: String 기본 메소드
```java
public class StringBasics {
    public static void main(String[] args) {
        // TODO: 문자열 선언하고 기본 정보를 출력하세요
        // 힌트:
        // 1. str = "Hello, Java Programming!" 선언
        // 2. 문자열과 길이 출력 (str.length() 사용)
        
        // TODO: 문자 접근 예제를 출력하세요
        // 힌트:
        // 1. "\n문자 접근:" 출력
        // 2. 첫 번째 문자: str.charAt(0)
        // 3. 마지막 문자: str.charAt(str.length() - 1)
        
        // TODO: 모든 문자를 한 글자씩 출력하세요
        // 힌트:
        // 1. "한 글자씩: " 출력 (print 사용, 줄바꿈 없이)
        // 2. for 루프로 str.charAt(i) 공백과 함께 출력
        // 3. 마지막에 줄바꿈 출력
        
        // TODO: 부분 문자열 예제를 출력하세요
        // 힌트:
        // 1. "\n부분 문자엱:" 출력
        // 2. substring(0, 5) 결과 출력
        // 3. substring(7) 결과 출력
        // 4. substring(7, 11) 결과 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
Hello, Java Programming!
길이: 24

문자 접근:
첫 번째 문자: H
마지막 문자: !
한 글자씩: H e l l o ,   J a v a   P r o g r a m m i n g ! 

부분 문자열:
Hello
Java Programming!
Java
```

### 예제 2-2: 문자열 검색
```java
public class StringSearch {
    public static void main(String[] args) {
        // TODO: 검색을 위한 텍스트를 선언하고 출력하세요
        // 힌트:
        // 1. text = "Java is a programming language. Java is popular." 선언
        // 2. 텍스트 내용 출력
        
        // TODO: indexOf 메소드를 사용하여 문자열 검색을 수행하세요
        // 힌트:
        // 1. "\nindexOf 예제:" 출력
        // 2. 'Java'의 첫 번째 위치 찾기
        // 3. 'is'의 첫 번째 위치 찾기
        // 4. 'Python'의 위치 찾기 (없으면 -1 반환)
        
        // TODO: 특정 위치부터 검색하여 두 번째 'Java'를 찾으세요
        // 힌트:
        // 1. firstJava = text.indexOf("Java")
        // 2. secondJava = text.indexOf("Java", firstJava + 1)
        // 3. 두 번째 'Java'의 위치 출력
        
        // TODO: 문자 검색을 수행하세요
        // 힌트:
        // 1. "\n문자 검색:" 출력
        // 2. 'a'의 첫 번째 위치 (indexOf)
        // 3. 'a'의 마지막 위치 (lastIndexOf)
        
        // TODO: while 루프를 사용하여 모든 'a'의 위치를 찾으세요
        // 힌트:
        // 1. "모든 'a'의 위치: " 출력 (print 사용)
        // 2. pos = -1 초기화
        // 3. while ((pos = text.indexOf('a', pos + 1)) != -1) 루프
        // 4. 각 위치를 공백과 함께 출력
        // 5. 마지막에 줄바꿈 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 2-3: 문자열 비교
```java
public class StringComparison {
    public static void main(String[] args) {
        // TODO: 비교를 위한 문자열 변수들을 선언하세요
        // 힌트:
        // s1 = "Hello", s2 = "Hello", s3 = "hello", s4 = "HELLO"
        // s5 = new String("Hello")
        // 모든 문자열 값 출력
        
        // TODO: equals 메소드로 비교하세요
        // 힌트:
        // 1. "\nequals 비교:" 출력
        // 2. s1.equals(s2), s1.equals(s3), s1.equals(s5) 결과 출력
        
        // TODO: equalsIgnoreCase 메소드로 비교하세요
        // 힌트:
        // 1. "\nequalsIgnoreCase 비교:" 출력
        // 2. s1.equalsIgnoreCase(s3), s1.equalsIgnoreCase(s4) 결과 출력
        
        // TODO: compareTo 메소드로 비교하세요
        // 힌트:
        // 1. "\ncompareTo 비교:" 출력
        // 2. s1.compareTo(s2), s1.compareTo(s3), s3.compareTo(s1) 결과 출력
        
        // TODO: 배열을 사전순으로 정렬하세요
        // 힌트:
        // 1. words 배열 = {"apple", "Banana", "cherry", "Apple", "banana"}
        // 2. 정렬 전 배열 출력
        // 3. 이중 for 루프로 버블 정렬 수행 (compareTo 사용)
        // 4. 정렬 후 배열 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 2-4: 문자열 변환
```java
public class StringTransformation {
    public static void main(String[] args) {
        // TODO: 변환을 위한 원본 문자열을 선언하고 정보를 출력하세요
        // 힌트:
        // 1. original = "  Java Programming Language  " 선언
        // 2. 원본 문자열과 길이 출력
        
        // TODO: 대소문자 변환을 수행하세요
        // 힌트:
        // 1. upper = original.toUpperCase()
        // 2. lower = original.toLowerCase()
        // 3. 대문자와 소문자 결과 출력
        
        // TODO: 공백 제거를 수행하세요
        // 힌트:
        // 1. trimmed = original.trim()
        // 2. trim 후 문자열과 길이 출력
        
        // TODO: 연쇄 변환을 수행하세요
        // 힌트:
        // result = original.trim().toLowerCase().substring(0, 4)
        // 연쇄 변환 결과 출력
        
        // TODO: replace 메소드를 사용하여 문자열 치환을 수행하세요
        // 힌트:
        // 1. text = "I love Java. Java is great!" 선언
        // 2. replaced = text.replace("Java", "Python")
        // 3. 원본과 치환 후 결과 출력
        
        // TODO: CSV 예제를 보여주세요
        // 힌트:
        // 1. csv = "apple,banana,cherry" 선언
        // 2. CSV 문자열 출력
        // 3. csv.substring(0, csv.indexOf(','))로 첫 번째 항목 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 2-5: 문자열 연결과 포맷팅
```java
public class StringConcatenation {
    public static void main(String[] args) {
        // TODO: 기본 문자열 연결을 수행하세요
        // 힌트:
        // 1. firstName = "홍", lastName = "길동"
        // 2. fullName = firstName + lastName
        // 3. 전체 이름 출력
        
        // TODO: 다양한 타입과 문자열을 연결하세요
        // 힌트:
        // 1. age = 25, height = 175.5, isStudent = true
        // 2. info 문자열에 모든 정보를 연결하여 저장
        // 3. info 출력
        
        // TODO: 숫자 계산과 문자열 연산의 차이를 보여주세요
        // 힌트:
        // 1. "\n문자열과 숫자 연산:" 출력
        // 2. "10 + 20 = " + 10 + 20 출력 (결과: "10 + 20 = 1020")
        // 3. "10 + 20 = " + (10 + 20) 출력 (결과: "10 + 20 = 30")
        
        // TODO: StringBuilder를 사용하여 효율적인 문자열 연결을 수행하세요
        // 힌트:
        // 1. StringBuilder sb = new StringBuilder()
        // 2. append로 "오늘은 ", 2024, "년 ", 11, "월입니다." 추가
        // 3. sb.toString() 결과 출력
        
        // TODO: String.format을 사용하여 포맷팅된 문자열을 만드세요
        // 힌트:
        // String.format("이름: %s, 나이: %d, 키: %.1fcm", fullName, age, height)
        // 포맷팅 결과 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

## 3. 텍스트 블록 예제

### 예제 3-1: 텍스트 블록 기본
```java
public class TextBlockBasics {
    public static void main(String[] args) {
        // TODO: 기존 방식으로 여러 줄 문자열을 만드세요
        // 힌트:
        // oldWay = "첫 번째 줄\n" + "두 번째 줄\n" + "세 번째 줄"
        
        // TODO: 텍스트 블록 방식으로 여러 줄 문자열을 만드세요
        // 힌트:
        // newWay = """ 사용하여 세 줄 텍스트 작성
        
        // TODO: 두 방식의 결과를 비교하여 출력하세요
        // 힌트:
        // 1. "기존 방식:" 출력 후 oldWay 출력
        // 2. "\n텍스트 블록:" 출력 후 newWay 출력
        
        // TODO: JSON 형식의 텍스트 블록을 만드세요
        // 힌트:
        // """ 사용하여 JSON 구조 작성 (name, age, address 포함)
        // JSON 데이터 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
기존 방식:
첫 번째 줄
두 번째 줄
세 번째 줄

텍스트 블록:
첫 번째 줄
두 번째 줄
세 번째 줄

{
    "name": "홍길동",
    "age": 30,
    "address": "서울시 강남구"
}
```

### 예제 3-2: 텍스트 블록 활용
```java
public class TextBlockExamples {
    public static void main(String[] args) {
        // TODO: HTML 템플릿을 텍스트 블록으로 작성하세요
        // 힌트:
        // String html = """ 사용하여 HTML 구조 작성
        // <!DOCTYPE html>, html, head, title, body, h1, p 태그 포함
        // "Hello, World!" 제목과 "This is a text block example." 문단 포함
        
        // TODO: HTML 템플릿을 출력하세요
        // 힌트:
        // 1. "HTML 템플릿:" 출력
        // 2. html 변수 출력
        
        // TODO: SQL 쿼리를 텍스트 블록으로 작성하세요
        // 힌트:
        // String sql = """ 사용하여 복잡한 SQL 쿼리 작성
        // SELECT, FROM, JOIN, WHERE, ORDER BY 포함
        // users와 orders 테이블 조인
        // 완료된 주문만 조회하고 날짜순 정렬
        
        // TODO: SQL 쿼리를 출력하세요
        // 힌트:
        // 1. "\nSQL 쿼리:" 출력
        // 2. sql 변수 출력
        
        // TODO: 프로그램 도움말을 텍스트 블록으로 작성하세요
        // 힌트:
        // String help = """ 사용하여 계산기 프로그램 도움말 작성
        // 사용법, 옵션, 연산자, 예시 포함
        // -h, --help, -v, --verbose 옵션
        // +, -, *, / 연산자
        // 사용 예시 2개
        
        // TODO: 프로그램 도움말을 출력하세요
        // 힌트:
        // 1. "\n프로그램 도움말:" 출력
        // 2. help 변수 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
HTML 템플릿:
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Hello, World!</h1>
    <p>This is a text block example.</p>
</body>
</html>

SQL 쿼리:
SELECT u.name, u.email, o.order_date, o.total
FROM users u
JOIN orders o ON u.id = o.user_id
WHERE o.status = 'completed'
    AND o.order_date >= '2024-01-01'
ORDER BY o.order_date DESC

프로그램 도움말:
사용법: java Calculator [옵션] <숫자1> <연산자> <숫자2>

옵션:
    -h, --help     도움말 표시
    -v, --verbose  자세한 정보 표시

연산자:
    +  덧셈
    -  뺄셈
    *  곱셈
    /  나눗셈

예시:
    java Calculator 10 + 20
    java Calculator -v 100 / 3
```

## 4. 열거형 예제

### 예제 4-1: 열거형 기본
```java
public class EnumBasics {
    // TODO: 요일 열거형을 정의하세요
    // 힌트: enum DayOfWeek { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }
    
    // TODO: 사이즈 열거형을 정의하세요
    // 힌트: enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE }
    
    public static void main(String[] args) {
        // TODO: 열거형 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. today = DayOfWeek.FRIDAY
        // 2. shirtSize = Size.LARGE
        
        // TODO: 열거형 값을 출력하세요
        // 힌트:
        // 1. "오늘은 " + today + "입니다." 출력
        // 2. "셔츠 사이즈: " + shirtSize 출력
        
        // TODO: ordinal() 메소드를 사용하여 순서를 출력하세요
        // 힌트:
        // 1. "\nordinal 값:" 출력
        // 2. today + "의 순서: " + today.ordinal() 출력
        // 3. shirtSize + "의 순서: " + shirtSize.ordinal() 출력
        
        // TODO: values() 메소드를 사용하여 모든 요일을 출력하세요
        // 힌트:
        // 1. "\n모든 요일:" 출력
        // 2. for (DayOfWeek day : DayOfWeek.values()) 반복문 사용
        // 3. day + " (인덱스: " + day.ordinal() + ")" 형식으로 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
오늘은 FRIDAY입니다.
셔츠 사이즈: LARGE

ordinal 값:
FRIDAY의 순서: 4
LARGE의 순서: 2

모든 요일:
MONDAY (인덱스: 0)
TUESDAY (인덱스: 1)
WEDNESDAY (인덱스: 2)
THURSDAY (인덱스: 3)
FRIDAY (인덱스: 4)
SATURDAY (인덱스: 5)
SUNDAY (인덱스: 6)
```

### 예제 4-2: 열거형 활용
```java
public class EnumApplication {
    // TODO: 신호등 열거형을 정의하세요
    // 힌트: enum TrafficLight { RED, YELLOW, GREEN }
    
    // TODO: 커피 사이즈 열거형을 정의하세요
    // 힌트: enum CoffeeSize { SMALL, MEDIUM, LARGE }
    
    public static void main(String[] args) {
        // TODO: 신호등 시뮬레이션을 구현하세요
        // 힌트:
        // 1. light = TrafficLight.RED로 설정
        // 2. "현재 신호: " + light 출력
        // 3. switch문으로 신호에 따른 메시지 출력:
        //    - RED: "정지하세요!"
        //    - YELLOW: "주의하세요!"
        //    - GREEN: "진행하세요!"
        
        // TODO: 커피 주문 시스템을 구현하세요
        // 힌트:
        // 1. myOrder = CoffeeSize.MEDIUM으로 설정
        // 2. price = 0으로 초기화
        // 3. switch문으로 사이즈에 따른 가격 설정:
        //    - SMALL: 3000원
        //    - MEDIUM: 4000원
        //    - LARGE: 5000원
        // 4. "\n커피 주문: " + myOrder 출력
        // 5. "가격: " + price + "원" 출력
        
        // TODO: 열거형 비교를 구현하세요
        // 힌트:
        // 1. yourOrder = CoffeeSize.MEDIUM으로 설정
        // 2. if (myOrder == yourOrder) 조건으로 비교
        // 3. 같으면 "같은 사이즈를 주문했습니다!" 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
현재 신호: RED
정지하세요!

커피 주문: MEDIUM
가격: 4000원
같은 사이즈를 주문했습니다!
```

### 예제 4-3: 계절과 월 열거형
```java
public class SeasonAndMonth {
    // TODO: 계절 열거형을 정의하세요
    // 힌트: enum Season { SPRING, SUMMER, FALL, WINTER }
    
    // TODO: 월 열거형을 정의하세요
    // 힌트: enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER }
    
    public static void main(String[] args) {
        // TODO: 현재 계절과 월을 설정하세요
        // 힌트:
        // 1. currentSeason = Season.FALL
        // 2. currentMonth = Month.NOVEMBER
        
        // TODO: 현재 계절과 월을 출력하세요
        // 힌트:
        // 1. "현재 계절: " + currentSeason 출력
        // 2. "현재 월: " + currentMonth 출력
        
        // TODO: 월에 따른 계절을 판단하고 출력하세요
        // 힌트:
        // 1. seasonForMonth = getSeasonForMonth(currentMonth) 호출
        // 2. currentMonth + "의 계절: " + seasonForMonth 출력
        
        // TODO: 계절별 활동을 switch문으로 출력하세요
        // 힌트:
        // switch (currentSeason) 사용하여
        // - SPRING: "봄 - 꽃구경 가기!"
        // - SUMMER: "여름 - 해수욕장 가기!"
        // - FALL: "가을 - 단풍구경 가기!"
        // - WINTER: "겨울 - 스키장 가기!"
        
        // 여기에 코드를 작성하세요
    }
    
    // TODO: 월에 따른 계절을 반환하는 메소드를 구현하세요
    // 힌트:
    // switch (month) 사용하여
    // - MARCH, APRIL, MAY: return Season.SPRING;
    // - JUNE, JULY, AUGUST: return Season.SUMMER;
    // - SEPTEMBER, OCTOBER, NOVEMBER: return Season.FALL;
    // - DECEMBER, JANUARY, FEBRUARY: return Season.WINTER;
    // - default: return null;
    public static Season getSeasonForMonth(Month month) {
        // 여기에 코드를 작성하세요
        return null; // 임시 반환값
    }
}
```

#### 실행 결과:
```
현재 계절: FALL
현재 월: NOVEMBER
NOVEMBER의 계절: FALL
가을 - 단풍구경 가기!
```

## 5. 종합 예제

### 예제 5-1: 시간 측정 프로그램
```java
public class TimeMeasurement {
    public static void main(String[] args) {
        // TODO: 프로그램 시작 시간을 기록하세요
        // 힌트:
        // 1. startTime = System.nanoTime() (나노초 정밀도)
        // 2. startMillis = System.currentTimeMillis() (밀리초 정밀도)
        
        // TODO: 프로그램 시작 메시지를 출력하세요
        // 힌트:
        // 1. "=== 시간 측정 프로그램 ===" 출력
        // 2. "시작 시간: " + new java.util.Date() 출력
        
        // TODO: 제곱근 합계 계산을 수행하세요
        // 힌트:
        // 1. sum = 0.0으로 초기화
        // 2. for (int i = 1; i <= 1000000; i++) 반복문
        // 3. sum += Math.sqrt(i) 누적
        // 4. "1부터 1,000,000까지 제곱근의 합: " + sum 출력
        
        // TODO: 파이 값을 라이프니츠 공식으로 계산하세요
        // 힌트:
        // 1. pi = 0.0으로 초기화
        // 2. for (int i = 0; i < 1000000; i++) 반복문
        // 3. pi += Math.pow(-1, i) / (2 * i + 1) 누적
        // 4. pi *= 4 (라이프니츠 공식 완성)
        // 5. "계산된 파이 값: " + pi 출력
        // 6. "실제 파이 값: " + Math.PI 출력
        // 7. "오차: " + Math.abs(pi - Math.PI) 출력
        
        // TODO: 실행 시간을 계산하고 출력하세요
        // 힌트:
        // 1. endTime = System.nanoTime()
        // 2. endMillis = System.currentTimeMillis()
        // 3. nanoSeconds = endTime - startTime
        // 4. milliSeconds = endMillis - startMillis
        // 5. "\n실행 시간:" 출력
        // 6. "나노초: " + nanoSeconds 출력
        // 7. "밀리초: " + milliSeconds 출력
        // 8. "초: " + (nanoSeconds / 1_000_000_000.0) 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 시간 측정 프로그램 ===
시작 시간: Sun Nov 24 14:30:25 KST 2024
1부터 1,000,000까지 제곱근의 합: 6.666666664666666E8
계산된 파이 값: 3.141591653589774
실제 파이 값: 3.141592653589793
오차: 9.999999919227063E-7

실행 시간:
나노초: 2.845671291E8
밀리초: 285.0
초: 0.285671291
```

### 예제 5-2: 문자열 처리 유틸리티
```java
public class StringUtility {
    public static void main(String[] args) {
        // TODO: 이메일 검증을 구현하세요
        // 힌트:
        // 1. email = "user@example.com"으로 설정
        // 2. "이메일 검증: " + email 출력
        // 3. "@ 포함: " + (email.indexOf('@') != -1) 출력
        // 4. ". 포함: " + (email.indexOf('.') != -1) 출력
        
        // TODO: 문장 분석을 구현하세요
        // 힌트:
        // 1. sentence = "Java is a powerful programming language!" 설정
        // 2. "\n문장 분석: \"" + sentence + "\"" 출력
        // 3. "길이: " + sentence.length() 출력
        // 4. "단어 수: " + countWords(sentence) 출력
        // 5. "대문자 수: " + countUpperCase(sentence) 출력
        // 6. "소문자 수: " + countLowerCase(sentence) 출력
        
        // TODO: 팰린드롬 검사를 구현하세요
        // 힌트:
        // 1. words = {"level", "hello", "radar", "java", "noon"} 배열 생성
        // 2. "\n팰린드롬 검사:" 출력
        // 3. for (String word : words) 반복문 사용
        // 4. word + ": " + isPalindrome(word) 형식으로 출력
        
        // 여기에 코드를 작성하세요
    }
    
    // TODO: 단어 수를 세는 메소드를 구현하세요
    // 힌트:
    // 1. count = 0, inWord = false로 초기화
    // 2. for 반복문으로 각 문자 확인
    // 3. 공백, 구두점이면 inWord = false
    // 4. 그 외 문자이고 !inWord면 count++, inWord = true
    // 5. count 반환
    public static int countWords(String text) {
        // 여기에 코드를 작성하세요
        return 0; // 임시 반환값
    }
    
    // TODO: 대문자 수를 세는 메소드를 구현하세요
    // 힌트:
    // 1. count = 0으로 초기화
    // 2. for 반복문으로 각 문자 확인
    // 3. if (c >= 'A' && c <= 'Z') 조건으로 대문자 확인
    // 4. 대문자면 count++
    // 5. count 반환
    public static int countUpperCase(String text) {
        // 여기에 코드를 작성하세요
        return 0; // 임시 반환값
    }
    
    // TODO: 소문자 수를 세는 메소드를 구현하세요
    // 힌트:
    // 1. count = 0으로 초기화
    // 2. for 반복문으로 각 문자 확인
    // 3. if (c >= 'a' && c <= 'z') 조건으로 소문자 확인
    // 4. 소문자면 count++
    // 5. count 반환
    public static int countLowerCase(String text) {
        // 여기에 코드를 작성하세요
        return 0; // 임시 반환값
    }
    
    // TODO: 팰린드롬 검사 메소드를 구현하세요
    // 힌트:
    // 1. left = 0, right = word.length() - 1로 초기화
    // 2. while (left < right) 반복문
    // 3. word.charAt(left) != word.charAt(right)면 false 반환
    // 4. left++, right-- 이동
    // 5. 반복문 완료시 true 반환
    public static boolean isPalindrome(String word) {
        // 여기에 코드를 작성하세요
        return false; // 임시 반환값
    }
}
```

#### 실행 결과:
```
이메일 검증: user@example.com
@ 포함: true
. 포함: true

문장 분석: "Java is a powerful programming language!"
길이: 41
단어 수: 6
대문자 수: 1
소문자 수: 32

팰린드롬 검사:
level: true
hello: false
radar: true
java: false
noon: true
```

### 예제 5-3: 게임 시뮬레이션
```java
public class GameSimulation {
    // TODO: 게임 상태 열거형을 정의하세요
    // 힌트: enum GameState { MENU, PLAYING, PAUSED, GAME_OVER }
    
    // TODO: 방향 열거형을 정의하세요
    // 힌트: enum Direction { NORTH, SOUTH, EAST, WEST }
    
    public static void main(String[] args) {
        // TODO: 게임 상태를 관리하세요
        // 힌트:
        // 1. state = GameState.MENU로 설정
        // 2. "게임 상태: " + state 출력
        
        // TODO: 게임을 시작하세요
        // 힌트:
        // 1. state = GameState.PLAYING으로 변경
        // 2. "게임 시작! 상태: " + state 출력
        
        // TODO: 플레이어 초기 위치를 설정하세요
        // 힌트:
        // 1. x = 5, y = 5로 설정
        // 2. "시작 위치: (" + x + ", " + y + ")" 출력
        
        // TODO: 랜덤 이동을 5번 수행하세요
        // 힌트:
        // 1. "\n랜덤 이동 5회:" 출력
        // 2. for (int i = 0; i < 5; i++) 반복문
        // 3. dir = getRandomDirection() 호출
        // 4. "이동 방향: " + dir 출력 (print 사용)
        // 5. switch문으로 방향에 따라 x, y 좌표 변경:
        //    - NORTH: y++
        //    - SOUTH: y--
        //    - EAST: x++
        //    - WEST: x--
        // 6. " -> 새 위치: (" + x + ", " + y + ")" 출력 (println)
        
        // TODO: 점수를 계산하고 게임을 종료하세요
        // 힌트:
        // 1. score = (int)(Math.random() * 1000) 랜덤 점수 생성
        // 2. "\n최종 점수: " + score 출력
        // 3. state = GameState.GAME_OVER로 변경
        // 4. "게임 종료! 상태: " + state 출력
        
        // 여기에 코드를 작성하세요
    }
    
    // TODO: 랜덤 방향을 생성하는 메소드를 구현하세요
    // 힌트:
    // 1. directions = Direction.values() 배열 획득
    // 2. index = (int)(Math.random() * directions.length) 랜덤 인덱스
    // 3. directions[index] 반환
    public static Direction getRandomDirection() {
        // 여기에 코드를 작성하세요
        return null; // 임시 반환값
    }
}
```

#### 실행 결과:
```
게임 상태: MENU
게임 시작! 상태: PLAYING
시작 위치: (5, 5)

랜덤 이동 5회:
이동 방향: EAST -> 새 위치: (6, 5)
이동 방향: NORTH -> 새 위치: (6, 6)
이동 방향: WEST -> 새 위치: (5, 6)
이동 방향: SOUTH -> 새 위치: (5, 5)
이동 방향: EAST -> 새 위치: (6, 5)

최종 점수: 742
게임 종료! 상태: GAME_OVER
```