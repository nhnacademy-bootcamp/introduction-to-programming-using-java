# 5.3 객체로 프로그래밍하기 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- Java의 내장 클래스들을 효과적으로 활용한다
- Object 클래스의 역할과 중요성을 이해한다
- 실용적인 클래스를 설계하고 구현할 수 있다
- 객체지향 분석과 설계의 기본 원리를 안다
- 재사용 가능한 소프트웨어 구성 요소를 만들 수 있다

## 1. Java의 내장 클래스 활용

### 1.1 StringBuilder - 효율적인 문자열 구성

**문제 상황**:
```java
String result = "";
for (int i = 0; i < 1000; i++) {
    result = result + i + " ";  // 매번 새로운 String 객체 생성!
}
```

**해결책 - StringBuilder 사용**:
```java
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    builder.append(i).append(" ");  // 효율적인 문자열 구성
}
String result = builder.toString();
```

**StringBuilder의 주요 메서드**:
- `append(값)`: 문자열 끝에 값 추가
- `insert(위치, 값)`: 지정 위치에 값 삽입
- `delete(시작, 끝)`: 지정 범위 삭제
- `toString()`: 최종 문자열 반환

### 1.2 Random 클래스 - 다양한 난수 생성

```java
import java.util.Random;

Random random = new Random();

// 다양한 난수 생성
int dice = random.nextInt(6) + 1;           // 1-6 사이
double percentage = random.nextDouble();     // 0.0-1.0 사이
boolean coinFlip = random.nextBoolean();     // true 또는 false
int range = random.nextInt(50) + 100;       // 100-149 사이
```

### 1.3 Date 클래스 - 시간 다루기

```java
import java.util.Date;

// 현재 시간
Date now = new Date();
System.out.println("현재 시간: " + now);

// 특정 시간 (밀리초 단위)
Date specificTime = new Date(1234567890000L);
System.out.println("특정 시간: " + specificTime);
```

### 1.4 Color 클래스 - 색상 관리

```java
import javafx.scene.paint.Color;

// 미리 정의된 색상
Color red = Color.RED;
Color blue = Color.BLUE;

// 커스텀 색상 (R, G, B, Alpha)
Color customColor = new Color(0.8, 0.2, 0.5, 0.7);  // 반투명 핑크

// 색상 정보 얻기
double redValue = customColor.getRed();
double greenValue = customColor.getGreen();
double blueValue = customColor.getBlue();
double opacity = customColor.getOpacity();

System.out.println("빨강 성분: " + redValue);
```

## 2. Object 클래스 - 모든 클래스의 조상

### 2.1 Object 클래스의 특별함

Java의 모든 클래스는 Object 클래스를 상속받습니다:
```java
public class MyClass {  // 자동으로 extends Object
    // 클래스 내용
}

// 실제로는 이렇게 동작:
public class MyClass extends Object {
    // 클래스 내용
}
```

### 2.2 toString() 메서드

**기본 toString() 문제**:
```java
public class Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Student student = new Student("김철수", 20);
System.out.println(student);  // Student@1a2b3c4d (의미 없는 출력)
```

**toString() 재정의**:
```java
public class Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

Student student = new Student("김철수", 20);
System.out.println(student);  // Student{name='김철수', age=20}
```

### 2.3 equals() 메서드

**기본 equals() 문제**:
```java
Student s1 = new Student("김철수", 20);
Student s2 = new Student("김철수", 20);

System.out.println(s1 == s2);        // false (서로 다른 객체)
System.out.println(s1.equals(s2));   // false (기본 equals는 ==와 동일)
```

**equals() 재정의**:
```java
@Override
public boolean equals(Object obj) {
    // 1. 같은 객체 참조인지 확인
    if (this == obj) return true;
    
    // 2. null이거나 다른 클래스인지 확인
    if (obj == null || getClass() != obj.getClass()) return false;
    
    // 3. 타입 캐스팅하여 내용 비교
    Student student = (Student) obj;
    return age == student.age && 
           Objects.equals(name, student.name);
}
```

## 3. 실용적인 클래스 설계

### 3.1 원판(Circle) 클래스 예제

```java
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * 애니메이션에 사용되는 원판을 나타내는 클래스
 */
public class CircleInfo {
    public int radius;      // 반지름
    public int x, y;        // 중심 좌표
    public Color color;     // 색상
    
    /**
     * 원판 객체 생성자
     * @param centerX 중심 X 좌표
     * @param centerY 중심 Y 좌표
     * @param rad 반지름
     */
    public CircleInfo(int centerX, int centerY, int rad) {
        x = centerX;
        y = centerY;
        radius = rad;
        
        // 랜덤한 반투명 색상 생성
        double red = Math.random();
        double green = Math.random();
        double blue = Math.random();
        color = new Color(red, green, blue, 0.4);
    }
    
    /**
     * 원판을 화면에 그리기
     * @param g 그래픽 컨텍스트
     */
    public void draw(GraphicsContext g) {
        // 색상 설정 후 원 채우기
        g.setFill(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        
        // 검은색 테두리 그리기
        g.setStroke(Color.BLACK);
        g.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
    
    /**
     * 원판 크기 증가
     */
    public void grow() {
        radius++;
    }
    
    /**
     * 원판이 화면을 벗어났는지 확인
     */
    public boolean isOutOfBounds(int screenWidth, int screenHeight) {
        return x - radius > screenWidth || 
               y - radius > screenHeight || 
               x + radius < 0 || 
               y + radius < 0;
    }
    
    @Override
    public String toString() {
        return "Circle at (" + x + "," + y + ") with radius " + radius;
    }
}
```

### 3.2 주사위(Dice) 클래스 - 재사용 가능한 설계

```java
/**
 * 재사용 가능한 주사위 클래스
 */
public class PairOfDice {
    private int die1, die2;  // 캡슐화
    
    /**
     * 기본 생성자 - 랜덤 초기값
     */
    public PairOfDice() {
        roll();  // 생성 시 자동으로 굴리기
    }
    
    /**
     * 특정 값으로 초기화하는 생성자
     */
    public PairOfDice(int value1, int value2) {
        die1 = value1;
        die2 = value2;
    }
    
    /**
     * 주사위 굴리기
     */
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
    
    /**
     * 첫 번째 주사위 값
     */
    public int getDie1() {
        return die1;
    }
    
    /**
     * 두 번째 주사위 값
     */
    public int getDie2() {
        return die2;
    }
    
    /**
     * 두 주사위 합계
     */
    public int getSum() {
        return die1 + die2;
    }
    
    /**
     * 같은 값인지 확인
     */
    public boolean isDouble() {
        return die1 == die2;
    }
    
    @Override
    public String toString() {
        if (isDouble()) {
            return "double " + die1;
        } else {
            return die1 + " and " + die2;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        PairOfDice that = (PairOfDice) obj;
        return die1 == that.die1 && die2 == that.die2;
    }
}
```

### 3.3 클래스 사용 예제

```java
public class DiceGame {
    public static void main(String[] args) {
        System.out.println("=== 주사위 게임 ===");
        
        // 다양한 방법으로 주사위 생성
        PairOfDice dice1 = new PairOfDice();           // 랜덤
        PairOfDice dice2 = new PairOfDice(3, 4);       // 특정 값
        
        System.out.println("첫 번째 주사위: " + dice1);
        System.out.println("두 번째 주사위: " + dice2);
        
        // 주사위 굴리기
        dice1.roll();
        System.out.println("굴린 후: " + dice1);
        
        // 더블이 나올 때까지 굴리기
        int attempts = 0;
        while (!dice1.isDouble()) {
            dice1.roll();
            attempts++;
            System.out.println("시도 " + attempts + ": " + dice1);
        }
        
        System.out.println("더블 완성! " + attempts + "번 만에 성공!");
    }
}
```

## 4. 객체 배열 활용

### 4.1 객체 배열 생성과 초기화

```java
public class CircleAnimation {
    private CircleInfo[] circles;  // 객체 배열
    private int circleCount;
    
    public CircleAnimation(int maxCircles) {
        circles = new CircleInfo[maxCircles];  // 배열 생성
        circleCount = 0;
        
        // 각 요소에 객체 생성 및 할당
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new CircleInfo(
                (int)(800 * Math.random()),    // X 좌표
                (int)(600 * Math.random()),    // Y 좌표
                (int)(50 * Math.random())      // 반지름
            );
        }
        
        circleCount = maxCircles;
    }
    
    /**
     * 모든 원판 그리기
     */
    public void drawAll(GraphicsContext g) {
        for (int i = 0; i < circleCount; i++) {
            circles[i].draw(g);
        }
    }
    
    /**
     * 모든 원판 애니메이션 업데이트
     */
    public void updateAnimation() {
        for (int i = 0; i < circleCount; i++) {
            circles[i].grow();  // 크기 증가
            
            // 너무 크거나 화면 밖으로 나가면 새로 생성
            if (circles[i].radius > 100 || 
                circles[i].isOutOfBounds(800, 600)) {
                
                circles[i] = new CircleInfo(
                    (int)(800 * Math.random()),
                    (int)(600 * Math.random()),
                    1  // 작은 크기로 시작
                );
            }
        }
    }
}
```

## 5. 객체지향 분석과 설계

### 5.1 문제에서 클래스 찾아내기

**분석 과정**:
1. **명사 찾기** → 클래스 후보
2. **동사 찾기** → 메서드 후보
3. **관계 파악** → 클래스 간 연관성
4. **책임 분담** → 각 클래스의 역할

**예시: "학교에서 학생들이 과목을 수강하고 성적을 받는다"**

**명사 (클래스 후보)**:
- 학교 → School 클래스
- 학생 → Student 클래스  
- 과목 → Course 클래스
- 성적 → Grade 클래스

**동사 (메서드 후보)**:
- 수강하다 → enroll() 메서드
- 성적을 받다 → assignGrade() 메서드

### 5.2 좋은 클래스 설계 원칙

**1. 단일 책임 원칙**
```java
// 나쁜 예: 여러 책임을 가진 클래스
public class StudentManager {
    public void saveToDatabase() { }      // 데이터베이스 책임
    public void sendEmail() { }           // 이메일 책임
    public void calculateGPA() { }        // 성적 계산 책임
}

// 좋은 예: 책임을 분리
public class Student {
    public double calculateGPA() { }      // 학생의 핵심 책임
}

public class DatabaseManager {
    public void saveStudent(Student s) { } // 데이터베이스 전용
}

public class EmailService {
    public void sendNotification(Student s) { } // 이메일 전용
}
```

**2. 캡슐화**
```java
public class BankAccount {
    private double balance;  // 외부에서 직접 접근 불가
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance() {
        return balance;  // 읽기만 허용
    }
}
```

**3. 재사용성**
```java
// 재사용 가능한 Timer 클래스
public class Timer {
    private long startTime;
    private boolean running;
    
    public void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }
    
    public void stop() {
        running = false;
    }
    
    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        }
        return 0;
    }
    
    public String getElapsedTimeString() {
        long elapsed = getElapsedTime();
        long seconds = elapsed / 1000;
        long minutes = seconds / 60;
        return minutes + ":" + (seconds % 60);
    }
}
```

## 6. 실습 예제: 도서관 시스템

```java
/**
 * 도서 클래스
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }
    
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    public void returnBook() {
        isAvailable = true;
    }
    
    // getter 메서드들
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    
    @Override
    public String toString() {
        return title + " by " + author + " (" + 
               (isAvailable ? "Available" : "Borrowed") + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);  // ISBN으로 동일성 판단
    }
}

/**
 * 도서관 클래스
 */
public class Library {
    private Book[] books;
    private int bookCount;
    private String libraryName;
    
    public Library(String name, int capacity) {
        this.libraryName = name;
        this.books = new Book[capacity];
        this.bookCount = 0;
    }
    
    public boolean addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            return true;
        }
        return false;
    }
    
    public Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    
    public void displayAllBooks() {
        System.out.println("=== " + libraryName + " 도서 목록 ===");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
    
    public void displayAvailableBooks() {
        System.out.println("=== 대출 가능한 도서 ===");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println(books[i]);
            }
        }
    }
}
```

## 요약

### 핵심 개념
- **내장 클래스 활용**: StringBuilder, Random, Date, Color 등의 효과적 사용
- **Object 클래스**: 모든 클래스의 최상위 클래스, toString()과 equals() 재정의
- **실용적 설계**: 단일 책임, 캡슐화, 재사용성을 고려한 클래스 설계
- **객체 배열**: 여러 객체를 효율적으로 관리하는 방법

### 설계 원칙
1. **명확한 책임**: 각 클래스는 하나의 명확한 개념을 모델링
2. **적절한 캡슐화**: 데이터 보호와 안전한 접근 제공
3. **재사용성**: 다양한 프로젝트에서 수정 없이 사용 가능
4. **확장성**: 필요에 따라 기능을 추가하거나 수정 가능

### 개발 과정
1. **분석**: 문제에서 명사(클래스)와 동사(메서드) 식별
2. **설계**: 클래스 간 관계와 책임 분담 결정
3. **구현**: Java 코드로 클래스와 메서드 작성
4. **테스트**: 올바른 동작 확인 및 디버깅

💡 **기억하세요**: 좋은 객체지향 프로그램은 현실 세계의 개념을 자연스럽게 모델링하여, 이해하기 쉽고 유지보수가 용이한 코드를 만듭니다!