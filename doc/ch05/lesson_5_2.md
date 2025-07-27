# 5.2 생성자와 객체 초기화 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 생성자의 개념과 역할을 이해한다
- 다양한 형태의 생성자를 작성할 수 있다
- 인스턴스 변수의 초기화 방법을 안다
- 가비지 컬렉션의 개념을 이해한다
- 생성자를 활용한 안전한 객체 생성을 할 수 있다

## 1. 객체 생성과 초기화의 필요성

### 1.1 기본 타입 vs 객체 타입

**기본 타입**:
```java
int x = 10;  // 변수 선언과 동시에 값 할당
```

**객체 타입**:
```java
Student student;  // 변수 선언만, 객체는 아직 없음!
student = new Student();  // 객체 생성 필요
```

### 1.2 객체 생성 시 필요한 작업

1. **메모리 할당**: 힙에서 객체를 위한 공간 확보
2. **초기화**: 인스턴스 변수에 적절한 값 설정
3. **추가 설정**: 객체 생성 시 필요한 특별한 작업 수행

## 2. 인스턴스 변수 초기화

### 2.1 선언 시 초기화

```java
public class PairOfDice {
    // 인스턴스 변수 선언 시 초기값 설정
    public int die1 = 3;  // 첫 번째 주사위
    public int die2 = 4;  // 두 번째 주사위
    
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
}
```

**특징:**
- 객체가 생성될 때마다 실행됨
- 각 객체는 독립적인 초기값을 가짐

### 2.2 동적 초기화

```java
public class PairOfDice {
    // 매번 다른 랜덤 값으로 초기화
    public int die1 = (int)(Math.random() * 6) + 1;
    public int die2 = (int)(Math.random() * 6) + 1;
}
```

### 2.3 기본 초기값

초기값을 제공하지 않으면 자동으로 기본값이 설정됩니다:

| 타입 | 기본값 |
|------|--------|
| int, double, float, long | 0 |
| boolean | false |
| char | '\0' (유니코드 0) |
| 객체 타입 (String 포함) | null |

```java
public class Example {
    private int number;        // 0으로 초기화
    private boolean flag;      // false로 초기화
    private String text;       // null로 초기화
}
```

## 3. 생성자(Constructor)

### 3.1 생성자의 개념

생성자는 객체를 생성할 때 호출되는 **특별한 메서드**입니다.

**생성자의 특징:**
- 클래스 이름과 동일한 이름
- 반환 타입이 없음 (void도 아님)
- `new` 연산자를 통해서만 호출 가능
- static으로 선언될 수 없음

### 3.2 기본 생성자

클래스에 생성자를 정의하지 않으면 컴파일러가 **기본 생성자**를 자동 제공합니다.

```java
public class Student {
    public String name;
    public int age;
    
    // 기본 생성자 (컴파일러가 자동 생성)
    // public Student() { }
}

// 사용
Student student = new Student();  // 기본 생성자 호출
```

### 3.3 매개변수가 있는 생성자

```java
public class PairOfDice {
    public int die1;
    public int die2;
    
    // 매개변수가 있는 생성자
    public PairOfDice(int val1, int val2) {
        die1 = val1;
        die2 = val2;
    }
    
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
}

// 사용
PairOfDice dice = new PairOfDice(3, 4);  // 초기값 3, 4로 생성
```

### 3.4 생성자 오버로딩

하나의 클래스에 여러 개의 생성자를 정의할 수 있습니다.

```java
public class PairOfDice {
    public int die1;
    public int die2;
    
    // 기본 생성자 - 랜덤 초기화
    public PairOfDice() {
        roll();  // 메서드 호출을 통한 초기화
    }
    
    // 매개변수 생성자 - 특정 값으로 초기화
    public PairOfDice(int val1, int val2) {
        die1 = val1;
        die2 = val2;
    }
    
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
}

// 두 가지 방법 모두 사용 가능
PairOfDice dice1 = new PairOfDice();        // 랜덤 초기화
PairOfDice dice2 = new PairOfDice(1, 6);    // 특정 값으로 초기화
```

## 4. 생성자 활용 예제

### 4.1 안전한 Student 클래스

```java
public class Student {
    private String name;               // private으로 보호
    public double test1, test2, test3;
    
    // 생성자 - 이름 필수 입력
    public Student(String theName) {
        // 유효성 검사
        if (theName == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }
        name = theName;
    }
    
    // getter 메서드 - 이름 읽기
    public String getName() {
        return name;
    }
    
    // 평균 계산
    public double getAverage() {
        return (test1 + test2 + test3) / 3;
    }
}

// 사용
Student student = new Student("김철수");  // 반드시 이름 제공
System.out.println(student.getName());    // "김철수"
```

**장점:**
1. **강제 초기화**: 반드시 이름을 제공해야 함
2. **유효성 검사**: null 이름 방지
3. **데이터 보호**: private 변수로 불변성 보장

### 4.2 final 변수와 생성자

```java
public class Student {
    private final String name;  // final: 한 번 설정 후 변경 불가
    private final int id;
    
    public Student(String theName, int studentId) {
        // final 변수는 생성자에서 반드시 초기화
        name = theName;
        id = studentId;
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
    
    // setter 메서드 없음 - 변경 불가능
}
```

## 5. Static과 Instance의 조합

### 5.1 자동 ID 생성 시스템

```java
public class Student {
    private String name;
    private int id;                    // 각 학생의 고유 ID
    
    private static int nextUniqueID = 1000;  // 다음 사용할 ID (공유)
    
    public Student(String theName) {
        name = theName;
        id = nextUniqueID;            // 현재 ID 할당
        nextUniqueID++;               // 다음 ID를 위해 증가
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
    
    // 현재까지 생성된 학생 수
    public static int getTotalStudents() {
        return nextUniqueID - 1000;
    }
}

// 사용 예제
Student s1 = new Student("김철수");  // ID: 1000
Student s2 = new Student("이영희");  // ID: 1001
Student s3 = new Student("박민수");  // ID: 1002

System.out.println("총 학생 수: " + Student.getTotalStudents());  // 3
```

### 5.2 동작 원리

```
클래스 로드 시:
nextUniqueID = 1000 (static 변수 초기화, 한 번만)

첫 번째 객체 생성:
s1.name = "김철수"
s1.id = 1000
nextUniqueID = 1001

두 번째 객체 생성:
s2.name = "이영희" 
s2.id = 1001
nextUniqueID = 1002
```

## 6. 객체 생성 과정

### 6.1 생성자 호출 단계

```java
Student student = new Student("홍길동");
```

**실행 과정:**
1. **메모리 할당**: 힙에서 Student 객체 크기만큼 공간 확보
2. **변수 초기화**: 인스턴스 변수를 기본값 또는 선언 시 값으로 초기화
3. **매개변수 전달**: "홍길동"을 theName 매개변수에 할당
4. **생성자 실행**: 생성자 본문의 코드 실행
5. **참조 반환**: 생성된 객체의 참조를 반환

### 6.2 생성자에서 메서드 호출

```java
public class PairOfDice {
    public int die1, die2;
    
    public PairOfDice() {
        roll();  // 생성자에서 다른 메서드 호출 가능
    }
    
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
}
```

## 7. 가비지 컬렉션(Garbage Collection)

### 7.1 객체의 생명주기

```java
public class GarbageExample {
    public static void main(String[] args) {
        Student student = new Student("김철수");  // 객체 생성
        
        // student는 객체를 참조 중
        System.out.println(student.getName());
        
        student = null;  // 참조 제거
        // 이제 "김철수" 객체는 가비지가 됨
        
        student = new Student("이영희");  // 새 객체 생성
        // 기존 객체는 자동으로 정리됨
    }
}
```

### 7.2 가비지가 되는 경우

**1. 참조 변수에 null 할당:**
```java
Student s = new Student("홍길동");
s = null;  // 객체가 가비지가 됨
```

**2. 참조 변수에 다른 객체 할당:**
```java
Student s = new Student("김철수");
s = new Student("이영희");  // "김철수" 객체가 가비지가 됨
```

**3. 지역 변수의 범위를 벗어남:**
```java
public void method() {
    Student s = new Student("박민수");
    // 메서드 종료 시 s가 사라지므로 객체가 가비지가 됨
}
```

### 7.3 가비지 컬렉션의 장점

**수동 메모리 관리의 문제점:**
- **댕글링 포인터**: 이미 삭제된 객체에 접근
- **메모리 누수**: 사용하지 않는 객체를 삭제하지 않음
- **이중 삭제**: 같은 객체를 두 번 삭제

**가비지 컬렉션의 장점:**
- 자동 메모리 관리
- 메모리 관련 버그 방지
- 프로그래머의 부담 감소

## 8. 실습 예제: 완전한 주사위 프로그램

```java
/**
 * 주사위 쌍을 나타내는 클래스
 */
public class PairOfDice {
    private int die1, die2;  // private으로 보호
    
    // 기본 생성자 - 랜덤 초기화
    public PairOfDice() {
        roll();
    }
    
    // 매개변수 생성자 - 특정 값으로 초기화
    public PairOfDice(int val1, int val2) {
        if (val1 < 1 || val1 > 6 || val2 < 1 || val2 > 6) {
            throw new IllegalArgumentException("주사위 값은 1-6 사이여야 합니다.");
        }
        die1 = val1;
        die2 = val2;
    }
    
    // 주사위 굴리기
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
    
    // getter 메서드들
    public int getDie1() { return die1; }
    public int getDie2() { return die2; }
    public int getSum() { return die1 + die2; }
    
    // 주사위 상태 출력
    public void display() {
        System.out.println("[" + die1 + "] [" + die2 + "] = " + getSum());
    }
    
    // 두 주사위가 같은 값인지 확인
    public boolean isDouble() {
        return die1 == die2;
    }
}

/**
 * 주사위 게임 프로그램
 */
public class DiceGame {
    public static void main(String[] args) {
        System.out.println("=== 주사위 게임 ===");
        
        // 다양한 방법으로 주사위 생성
        PairOfDice dice1 = new PairOfDice();        // 랜덤 초기화
        PairOfDice dice2 = new PairOfDice(3, 4);    // 특정 값으로 초기화
        
        System.out.println("첫 번째 주사위:");
        dice1.display();
        
        System.out.println("두 번째 주사위:");
        dice2.display();
        
        // 같은 값이 나올 때까지 굴리기
        System.out.println("\n더블이 나올 때까지 굴리기:");
        int rollCount = 0;
        
        while (!dice1.isDouble()) {
            dice1.roll();
            rollCount++;
            System.out.print("시도 " + rollCount + ": ");
            dice1.display();
        }
        
        System.out.println("더블 완성! " + rollCount + "번 만에 성공!");
    }
}
```

## 요약

### 핵심 개념
- **생성자**: 객체 생성 시 호출되는 특별한 메서드
- **초기화**: 인스턴스 변수의 적절한 초기값 설정
- **오버로딩**: 여러 개의 생성자로 다양한 초기화 방법 제공
- **가비지 컬렉션**: 사용하지 않는 객체의 자동 메모리 정리

### 생성자의 특징
1. 클래스 이름과 동일
2. 반환 타입 없음
3. `new` 연산자로만 호출
4. 매개변수 오버로딩 가능
5. 유효성 검사 가능

### 설계 원칙
1. **강제 초기화**: 필수 데이터는 생성자에서 받기
2. **유효성 검사**: 잘못된 데이터 방지
3. **불변성**: final 변수로 변경 방지
4. **캡슐화**: private 변수와 public 생성자 조합

💡 **기억하세요**: 생성자는 객체의 올바른 초기 상태를 보장하는 핵심 도구입니다. 적절한 생성자 설계로 안전하고 사용하기 쉬운 클래스를 만들 수 있습니다!