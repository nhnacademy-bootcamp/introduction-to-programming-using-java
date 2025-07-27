# 7.4 레코드 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 레코드의 개념과 필요성을 이해한다
- Java 레코드 클래스를 정의하고 사용한다
- 레코드의 불변성(immutability)을 이해한다
- 일반 클래스와 레코드 클래스의 차이점을 설명한다
- 레코드를 활용하여 데이터를 효율적으로 관리한다

## 1. 레코드란 무엇인가?

### 1.1 레코드의 개념

레코드(Record)는 **단순한 데이터 컨테이너**입니다. 관련된 데이터를 하나로 묶어서 저장하는 구조입니다.

```java
// 일반 클래스로 데이터 저장
class Person {
    private String name;
    private int age;
    
    // 생성자, getter, setter, toString, equals 등 필요...
}

// 레코드로 간단하게!
record Person(String name, int age) { }
```

### 1.2 레코드의 특징

1. **불변성(Immutable)**: 한 번 생성되면 내용을 변경할 수 없음
2. **간결성**: 보일러플레이트 코드 자동 생성
3. **투명성**: 데이터 구조가 명확하게 드러남
4. **타입 안정성**: 컴파일 시점 타입 체크

## 2. Java 레코드 기본 문법

### 2.1 레코드 정의

```java
// 기본 레코드 정의
public record Point(int x, int y) { }

// 여러 필드를 가진 레코드
public record Student(String name, int id, double grade) { }

// 다양한 타입의 필드
public record Book(String title, String author, int year, double price) { }
```

### 2.2 레코드 사용

```java
// 레코드 생성
Point p1 = new Point(10, 20);
Student s1 = new Student("김철수", 12345, 4.5);

// 필드 접근 (getter 메서드)
int xCoord = p1.x();        // 10
String name = s1.name();    // "김철수"

// toString() 자동 구현
System.out.println(p1);     // Point[x=10, y=20]
System.out.println(s1);     // Student[name=김철수, id=12345, grade=4.5]

// equals() 자동 구현
Point p2 = new Point(10, 20);
System.out.println(p1.equals(p2));  // true
```

## 3. 레코드가 자동으로 제공하는 것들

### 3.1 자동 생성되는 요소

레코드를 정의하면 컴파일러가 자동으로 다음을 생성합니다:

```java
// 이 간단한 레코드 정의가...
public record Person(String name, int age) { }

// 다음과 같은 클래스로 변환됩니다:
public final class Person {
    private final String name;
    private final int age;
    
    // 정식 생성자 (Canonical Constructor)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getter 메서드 (get 접두사 없음)
    public String name() { return name; }
    public int age() { return age; }
    
    // toString() 메서드
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
    
    // equals() 메서드
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name) && age == other.age;
    }
    
    // hashCode() 메서드
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

### 3.2 레코드의 제약사항

1. **final 클래스**: 상속 불가능
2. **final 필드**: 불변 객체
3. **다른 클래스 상속 불가**: Object만 상속
4. **인스턴스 필드 추가 불가**: 정의된 필드만 사용

## 4. 레코드 커스터마이징

### 4.1 생성자 검증 추가

```java
public record Age(int value) {
    // 정식 생성자 확장 (매개변수 목록 생략)
    public Age {
        if (value < 0 || value > 150) {
            throw new IllegalArgumentException("나이는 0-150 사이여야 합니다");
        }
    }
}
```

### 4.2 추가 생성자

```java
public record Rectangle(double width, double height) {
    // 정사각형을 위한 추가 생성자
    public Rectangle(double side) {
        this(side, side);  // 정식 생성자 호출
    }
}
```

### 4.3 메서드 추가

```java
public record Point(int x, int y) {
    // 원점으로부터의 거리 계산
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    
    // 다른 점까지의 거리
    public double distanceTo(Point other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    // 이동된 점 반환 (불변성 유지)
    public Point move(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }
}
```

### 4.4 toString() 재정의

```java
public record Money(long amount, String currency) {
    @Override
    public String toString() {
        return String.format("%,d %s", amount, currency);
    }
}

// 사용 예
Money money = new Money(1000000, "원");
System.out.println(money);  // 1,000,000 원
```

## 5. 레코드 vs 일반 클래스

### 5.1 언제 레코드를 사용할까?

**레코드가 적합한 경우**:
- 단순한 데이터 저장이 목적
- 불변 객체가 필요한 경우
- equals(), hashCode(), toString()이 필요한 경우
- 보일러플레이트 코드를 줄이고 싶을 때

**일반 클래스가 적합한 경우**:
- 가변 상태가 필요한 경우
- 상속 구조가 필요한 경우
- 복잡한 비즈니스 로직이 있는 경우
- 캡슐화가 중요한 경우

### 5.2 비교 예제

```java
// 일반 클래스 - 가변 상태
class BankAccount {
    private String accountNumber;
    private double balance;
    
    public void deposit(double amount) {
        balance += amount;  // 상태 변경 가능
    }
    
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;  // 상태 변경 가능
        }
    }
}

// 레코드 - 불변 거래 기록
record Transaction(
    String accountNumber,
    String type,  // "입금", "출금"
    double amount,
    String timestamp
) { }
```

## 6. 레코드의 실용적 활용

### 6.1 설정 정보 저장

```java
record DatabaseConfig(
    String host,
    int port,
    String username,
    String database
) {
    // URL 생성 메서드
    public String getConnectionUrl() {
        return String.format("jdbc:mysql://%s:%d/%s", host, port, database);
    }
}

// 사용
DatabaseConfig config = new DatabaseConfig("localhost", 3306, "user", "mydb");
System.out.println(config.getConnectionUrl());
```

### 6.2 API 응답 데이터

```java
record ApiResponse(
    int statusCode,
    String message,
    Object data,
    String timestamp
) {
    // 성공 여부 확인
    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300;
    }
}
```

### 6.3 좌표와 도형

```java
record Point(double x, double y) { }

record Circle(Point center, double radius) {
    // 면적 계산
    public double area() {
        return Math.PI * radius * radius;
    }
    
    // 둘레 계산
    public double circumference() {
        return 2 * Math.PI * radius;
    }
    
    // 점이 원 안에 있는지 확인
    public boolean contains(Point p) {
        double dx = p.x() - center.x();
        double dy = p.y() - center.y();
        return dx * dx + dy * dy <= radius * radius;
    }
}
```

## 7. 레코드와 컬렉션

### 7.1 레코드를 ArrayList에 저장

```java
record Task(String id, String description, boolean completed) { }

ArrayList<Task> todoList = new ArrayList<>();
todoList.add(new Task("1", "Java 공부하기", false));
todoList.add(new Task("2", "운동하기", true));
todoList.add(new Task("3", "책 읽기", false));

// 완료되지 않은 작업 찾기
for (Task task : todoList) {
    if (!task.completed()) {
        System.out.println("TODO: " + task.description());
    }
}
```

### 7.2 레코드를 키로 사용

레코드는 equals()와 hashCode()가 자동 구현되므로 Map의 키로 사용하기 좋습니다:

```java
record Coordinate(int x, int y) { }

Map<Coordinate, String> map = new HashMap<>();
map.put(new Coordinate(0, 0), "원점");
map.put(new Coordinate(1, 0), "동쪽");
map.put(new Coordinate(0, 1), "북쪽");

// 동일한 좌표로 조회 가능
String location = map.get(new Coordinate(0, 0));  // "원점"
```

## 8. 레코드의 장점과 주의사항

### 8.1 장점

1. **코드 간결성**: 보일러플레이트 코드 제거
2. **가독성**: 데이터 구조가 명확
3. **안정성**: 불변 객체로 인한 안정성
4. **성능**: 컴파일러 최적화 가능

### 8.2 주의사항

1. **불변성**: 필드 값을 변경할 수 없음
2. **상속 제한**: final 클래스이므로 확장 불가
3. **Java 14+ 필요**: 이전 버전에서는 사용 불가

## 요약

### 핵심 포인트

1. **레코드는 불변 데이터 컨테이너**:
   - 간단한 데이터 저장용
   - 자동으로 많은 메서드 생성

2. **기본 문법**:
   - `record Name(Type field1, Type field2) { }`
   - 필드는 자동으로 private final

3. **자동 생성 요소**:
   - 생성자, getter, toString(), equals(), hashCode()

4. **커스터마이징 가능**:
   - 생성자 검증 추가
   - 메서드 추가
   - toString() 재정의

5. **사용 시기**:
   - 단순 데이터 저장
   - 불변 객체 필요
   - DTO, 설정, 좌표 등

💡 **기억하세요**: 레코드는 "데이터를 담는 그릇"입니다. 복잡한 로직보다는 데이터 자체에 집중할 때 사용하세요!