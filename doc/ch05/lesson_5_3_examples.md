# 5.3 객체로 프로그래밍하기 - 수업 실습

## 1. Java 내장 클래스 활용 실습

### 실습 1-1: StringBuilder로 효율적인 문자열 구성
**목표**: StringBuilder의 효율성을 이해하고 활용법을 익혀보세요.

```java
import java.util.Random;

/**
 * StringBuilder를 활용한 효율적인 문자열 처리 예제
 */
public class StringBuilderExample {
    
    // TODO 1: 비효율적인 방법 - String 연결 메서드 구현하기
    public static String createStringInefficient(int count) {
        // String result = ""로 시작
        // 반복문으로 i + " "를 result에 추가 (+ 연산자 사용)
        // result 반환
    }
    
    // TODO 2: 효율적인 방법 - StringBuilder 사용 메서드 구현하기
    public static String createStringEfficient(int count) {
        // StringBuilder builder = new StringBuilder() 생성
        // 반복문으로 builder.append(i).append(" ") 호출
        // builder.toString() 반환
    }
    
    // TODO 3: HTML 테이블 생성 메서드 구현하기
    public static String createHtmlTable(String[][] data) {
        // StringBuilder html 생성
        // "<table border='1'>\n" 추가
        // 이중 반복문으로 각 행과 열 처리
        //   - 각 행마다 "  <tr>\n" 추가
        //   - 각 셀마다 "    <td>" + 데이터 + "</td>\n" 추가
        //   - 행 끝에 "  </tr>\n" 추가
        // "</table>" 추가
        // html.toString() 반환
    }
    
    // TODO 4: 성능 비교 테스트 메서드 구현하기
    public static void performanceTest() {
        // int count = 10000으로 설정
        // System.currentTimeMillis()로 시작 시간 기록
        // createStringInefficient(count) 호출하고 시간 측정
        // createStringEfficient(count) 호출하고 시간 측정
        // 결과 출력:
        //   "=== 성능 비교 (반복 [count]회) ==="
        //   "String 연결: [inefficientTime]ms"
        //   "StringBuilder: [efficientTime]ms"
        //   "성능 향상: [inefficientTime/efficientTime]배"
    }
    
    // TODO 5: 사용 예제 완성하기
    public static void main(String[] args) {
        System.out.println("=== StringBuilder 사용 예제 ===\n");
        
        // TODO 6: StringBuilder 기본 사용법 테스트하기
        // StringBuilder로 "Hello" 생성
        // " ", "World", "!" 순서대로 append
        // 결과 출력
        
        // TODO 7: HTML 테이블 생성 테스트하기
        // tableData 배열 선언 (이름, 나이, 직업 데이터)
        // createHtmlTable() 호출하고 결과 출력
        
        // TODO 8: 성능 테스트 실행하기
        // performanceTest() 호출
    }
}
```

#### 실행 결과 (참고용):
```
=== StringBuilder 사용 예제 ===

Hello World!

=== 생성된 HTML 테이블 ===
<table border='1'>
  <tr>
    <td>이름</td>
    <td>나이</td>
    <td>직업</td>
  </tr>
  <tr>
    <td>김철수</td>
    <td>25</td>
    <td>프로그래머</td>
  </tr>
  <tr>
    <td>이영희</td>
    <td>23</td>
    <td>디자이너</td>
  </tr>
  <tr>
    <td>박민수</td>
    <td>30</td>
    <td>기획자</td>
  </tr>
</table>

=== 성능 비교 (반복 10000회) ===
String 연결: 245ms
StringBuilder: 2ms
성능 향상: 122.5배
```

### 실습 1-2: Random 클래스 활용
**목표**: Random 클래스를 사용하여 다양한 랜덤 데이터를 생성해보세요.

```java
import java.util.Random;

/**
 * Random 클래스의 다양한 활용 예제
 */
public class RandomExample {
    private static Random random = new Random();
    
    /**
     * 주사위 시뮬레이션 클래스
     */
    public static class DiceSimulator {
        private Random rand;
        
        // TODO 9: 생성자 구현하기
        public DiceSimulator() {
            // Random 객체 생성
        }
        
        // TODO 10: 주사위 하나 굴리기 메서드 구현하기
        public int rollDie() {
            // rand.nextInt(6) + 1 반환 (1-6 사이의 값)
        }
        
        // TODO 11: 주사위 여러 개 굴리기 메서드 구현하기
        public int rollDice(int count) {
            // sum을 0으로 초기화
            // count번 rollDie() 호출하여 합계 계산
            // 합계 반환
        }
        
        // TODO 12: 주사위 통계 시뮬레이션 메서드 구현하기
        public void simulateRolls(int times) {
            // int[] counts = new int[13] 생성 (2-12 합계 카운트)
            // times번 반복:
            //   - 주사위 2개 굴리기 (rollDie() + rollDie())
            //   - 합계에 해당하는 counts 배열 요소 증가
            // 결과 출력:
            //   - "=== 주사위 2개 굴리기 [times]회 결과 ==="
            //   - 2부터 12까지 각 합계의 회수와 퍼센트 출력
        }
    }
    
    /**
     * 랜덤 문자열 생성기 클래스
     */
    public static class RandomStringGenerator {
        private static final String CHARACTERS = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // TODO 13: 비밀번호 생성 메서드 구현하기
        public static String generatePassword(int length) {
            // StringBuilder password 생성
            // Random rand 생성
            // length번 반복:
            //   - CHARACTERS에서 랜덤 인덱스 선택
            //   - 해당 문자를 password에 추가
            // password.toString() 반환
        }
    }
    
    /**
     * 랜덤 데이터 생성기 클래스
     */
    public static class RandomDataGenerator {
        private static final String[] FIRST_NAMES = 
            {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임"};
        private static final String[] LAST_NAMES = 
            {"철수", "영희", "민수", "지영", "현우", "수진", "준호", "은영", "태현", "소영"};
        
        // TODO 14: 랜덤 이름 생성 메서드 구현하기
        public static String generateName() {
            // FIRST_NAMES에서 랜덤 선택
            // LAST_NAMES에서 랜덤 선택
            // 성 + 이름 조합하여 반환
        }
        
        // TODO 15: 랜덤 나이 생성 메서드 구현하기
        public static int generateAge(int min, int max) {
            // min과 max 사이의 랜덤 나이 반환
        }
    }
    
    // TODO 16: 사용 예제 완성하기
    public static void main(String[] args) {
        System.out.println("=== Random 클래스 활용 예제 ===\n");
        
        // TODO 17: 주사위 시뮬레이션 테스트하기
        // DiceSimulator 객체 생성
        // simulateRolls(10000) 호출
        
        // TODO 18: 랜덤 비밀번호 생성 테스트하기
        // generatePassword(8) 호출하여 비밀번호 생성
        // 결과 출력
        
        // TODO 19: 랜덤 사용자 데이터 생성 테스트하기
        // 5명의 랜덤 사용자 데이터 생성:
        //   - 이름, 나이(20-30) 생성
        //   - 출력 형식: "이름 (나이세)"
    }
}
```

#### 실행 결과 (참고용):
```
=== Random 클래스 활용 예제 ===

=== 주사위 2개 굴리기 10000회 결과 ===
합계  2:   278회 (2.8%)
합계  3:   556회 (5.6%)
합계  4:   833회 (8.3%)
합계  5:  1111회 (11.1%)
합계  6:  1389회 (13.9%)
합계  7:  1667회 (16.7%)
합계  8:  1389회 (13.9%)
합계  9:  1111회 (11.1%)
합계 10:   833회 (8.3%)
합계 11:   556회 (5.6%)
합계 12:   278회 (2.8%)

=== 랜덤 비밀번호 생성 ===
간단한 비밀번호: aB7xK2mP

=== 랜덤 사용자 데이터 ===
김철수 (25세)
이영희 (28세)
박민수 (22세)
최지영 (30세)
정현우 (27세)
```

## 2. Object 클래스 메서드 재정의 실습

### 실습 2-1: toString()과 equals() 구현
**목표**: Object 클래스의 주요 메서드를 올바르게 재정의해보세요.

```java
import java.util.Objects;

/**
 * Object 클래스 메서드를 올바르게 재정의한 예제
 */
public class Person {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    
    // TODO 20: 생성자 구현하기
    public Person(String name, int age, String email, String phoneNumber) {
        // 모든 필드 초기화
    }
    
    // TODO 21: Getter 메서드들 구현하기
    public String getName() { }
    public int getAge() { }
    public String getEmail() { }
    public String getPhoneNumber() { }
    
    // TODO 22: toString() 메서드 재정의하기
    @Override
    public String toString() {
        // "Person{name='이름', age=나이, email='이메일', phone='전화번호'}" 형식으로 반환
    }
    
    // TODO 23: equals() 메서드 재정의하기
    @Override
    public boolean equals(Object obj) {
        // 1. this == obj인 경우 true 반환
        // 2. obj가 null이거나 다른 클래스인 경우 false 반환
        // 3. Person으로 캐스팅 후 모든 필드 비교
        // 4. 모든 필드가 같으면 true, 아니면 false 반환
    }
    
    // TODO 24: hashCode() 메서드 재정의하기
    @Override
    public int hashCode() {
        // Objects.hash()를 사용하여 모든 필드를 포함한 해시코드 생성
    }
}

// TODO 25: Person 클래스 테스트 완성하기
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("=== Person 클래스 테스트 ===\n");
        
        // TODO 26: 객체 생성하기
        // person1: "김철수", 25, "kim@email.com", "010-1234-5678"
        // person2: "이영희", 23, "lee@email.com", "010-9876-5432"
        // person3: person1과 같은 정보
        
        // TODO 27: toString() 테스트하기
        // person1, person2 출력
        
        // TODO 28: equals() 테스트하기
        // person1.equals(person2) 결과 출력
        // person1.equals(person3) 결과 출력
        // person1 == person3 결과 출력
        
        // TODO 29: hashCode() 테스트하기
        // 각 person의 hashCode 출력
        // person1과 person3의 hashCode가 같은지 확인
    }
}
```

#### 실행 결과 (참고용):
```
=== Person 클래스 테스트 ===

=== toString() 테스트 ===
person1: Person{name='김철수', age=25, email='kim@email.com', phone='010-1234-5678'}
person2: Person{name='이영희', age=23, email='lee@email.com', phone='010-9876-5432'}

=== equals() 테스트 ===
person1.equals(person2): false
person1.equals(person3): true
person1 == person3: false

=== hashCode() 테스트 ===
person1.hashCode(): 123456789
person2.hashCode(): 987654321
person3.hashCode(): 123456789
person1과 person3의 hashCode 같은가? true
```

### 실습 2-2: 다양한 클래스의 toString() 구현
**목표**: 여러 클래스에 적절한 toString() 메서드를 구현해보세요.

```java
/**
 * 책 정보를 나타내는 클래스
 */
public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    private boolean isAvailable;
    
    // TODO 30: 생성자 구현하기
    public Book(String title, String author, int pages, double price) {
        // 모든 필드 초기화
        // isAvailable은 true로 설정
    }
    
    // TODO 31: Getter 메서드들 구현하기
    public String getTitle() { }
    public String getAuthor() { }
    public int getPages() { }
    public double getPrice() { }
    public boolean isAvailable() { }
    
    // TODO 32: toString() 메서드 재정의하기
    @Override
    public String toString() {
        // "Book{title='제목', author='저자', pages=페이지수, price=가격원, available=O/X}" 형식
    }
}

/**
 * 좌표를 나타내는 클래스
 */
public class Point {
    private double x, y;
    
    // TODO 33: 생성자 구현하기
    public Point(double x, double y) {
        // x, y 초기화
    }
    
    // TODO 34: toString() 메서드 재정의하기
    @Override
    public String toString() {
        // "(x, y)" 형식으로 소수점 둘째자리까지 표시
    }
    
    // TODO 35: 다른 점까지의 거리 계산 메서드 구현하기
    public double distanceTo(Point other) {
        // 두 점 사이의 거리 계산
        // Math.sqrt((x차이)^2 + (y차이)^2)
    }
}

// TODO 36: 클래스들 테스트하기
public class ToStringExamples {
    public static void main(String[] args) {
        System.out.println("=== 다양한 toString() 구현 예제 ===\n");
        
        // TODO 37: Book 클래스 테스트하기
        // book1: "자바의 정석", "남궁성", 1200, 35000
        // book2: "클린 코드", "로버트 마틴", 584, 29000
        // 책 정보 출력
        
        // TODO 38: Point 클래스 테스트하기
        // p1: (3.5, 4.2)
        // p2: (-2.1, 1.8)
        // 좌표 출력 및 거리 계산
    }
}
```

#### 실행 결과 (참고용):
```
=== 다양한 toString() 구현 예제 ===

=== 도서 정보 ===
Book{title='자바의 정석', author='남궁성', pages=1200, price=35000.0원, available=O}
Book{title='클린 코드', author='로버트 마틴', pages=584, price=29000.0원, available=O}

=== 좌표 정보 ===
p1: (3.50, 4.20)
p2: (-2.10, 1.80)
p1에서 p2까지: 6.26
```

## 3. 실용적인 클래스 설계 실습

### 실습 3-1: 간단한 원 클래스
**목표**: 애니메이션에 사용할 수 있는 원 클래스를 설계해보세요.

```java
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * 간단한 원 클래스
 */
public class SimpleCircle {
    private double x, y;
    private double radius;
    private Color color;
    
    // TODO 39: 생성자 구현하기
    public SimpleCircle(double x, double y, double radius, Color color) {
        // 모든 필드 초기화
    }
    
    // TODO 40: 원 그리기 메서드 구현하기
    public void draw(GraphicsContext g) {
        // g.setFill(color) 호출
        // g.fillOval(x-radius, y-radius, radius*2, radius*2) 호출
    }
    
    // TODO 41: 원 이동 메서드 구현하기
    public void move(double dx, double dy) {
        // x에 dx 더하기
        // y에 dy 더하기
    }
    
    // TODO 42: 다른 원과의 충돌 검사 메서드 구현하기
    public boolean collidesWith(SimpleCircle other) {
        // 두 원의 중심 사이 거리 계산
        // 거리가 두 원의 반지름 합보다 작으면 true
    }
    
    // TODO 43: Getter/Setter 메서드들 구현하기
    public double getX() { }
    public double getY() { }
    public double getRadius() { }
    public Color getColor() { }
    public void setPosition(double x, double y) { }
    public void setRadius(double radius) { }
    public void setColor(Color color) { }
}

// TODO 44: 원 애니메이션 관리 클래스 만들기
public class CircleManager {
    private SimpleCircle[] circles;
    private int circleCount;
    
    // TODO 45: 생성자 구현하기
    public CircleManager(int maxCircles) {
        // circles 배열 생성
        // circleCount = 0
    }
    
    // TODO 46: 원 추가 메서드 구현하기
    public void addCircle(SimpleCircle circle) {
        // circleCount < circles.length이면 추가
        // circles[circleCount] = circle
        // circleCount 증가
    }
    
    // TODO 47: 모든 원 그리기 메서드 구현하기
    public void drawAll(GraphicsContext g) {
        // 모든 원에 대해 draw() 호출
    }
    
    // TODO 48: 충돌 검사 메서드 구현하기
    public void checkCollisions() {
        // 이중 반복문으로 모든 원 쌍 검사
        // 충돌한 원들의 색상을 빨간색으로 변경
    }
}
```

#### 실행 결과 (참고용):
```
=== 원 클래스 테스트 ===
원1: 위치(100.0, 100.0), 반지름 50.0
원2: 위치(150.0, 150.0), 반지름 40.0
충돌 여부: true

원 이동 후:
원1: 위치(110.0, 110.0)
충돌 여부: false
```

## 학습 포인트

### 1. Java 내장 클래스 활용
- **StringBuilder**: 문자열 조작 시 성능 향상
- **Random**: 다양한 형태의 난수 생성
- **Date/Color**: 시간과 색상 관련 작업

### 2. Object 클래스 메서드 재정의
- **toString()**: 객체의 문자열 표현 제공
- **equals()**: 논리적 동등성 비교
- **hashCode()**: equals()와 일관성 있게 구현

### 3. 클래스 설계 원칙
- **캡슐화**: private 필드와 public 메서드
- **응집도**: 관련 기능을 하나의 클래스에
- **재사용성**: 범용적으로 사용 가능한 설계

객체지향 프로그래밍의 핵심은 잘 설계된 클래스를 통해 복잡한 문제를 단순하게 해결하는 것입니다!