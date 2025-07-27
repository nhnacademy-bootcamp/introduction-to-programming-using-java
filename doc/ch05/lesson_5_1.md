# 5.1 객체, 인스턴스 메서드, 그리고 인스턴스 변수 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 객체지향 프로그래밍의 기본 개념을 이해한다
- 클래스와 객체의 차이를 설명할 수 있다
- 인스턴스 변수와 인스턴스 메서드를 사용할 수 있다
- 객체 참조와 null의 개념을 이해한다
- getter와 setter 메서드의 목적을 설명할 수 있다

## 1. 객체지향 프로그래밍(OOP)의 이해

### 1.1 전통적 프로그래밍 vs 객체지향 프로그래밍

**전통적 프로그래밍**:
```
작업(task) 중심 → 명령어의 순서를 찾기
```

**객체지향 프로그래밍**:
```
객체(object) 중심 → 객체들의 상호작용 설계
```

### 1.2 객체란 무엇인가?
객체는 다음을 가진 독립적인 존재입니다:
- **상태**(State): 데이터/정보를 저장
- **행동**(Behavior): 작업을 수행하는 메서드
- **정체성**(Identity): 다른 객체와 구별되는 고유성

```java
// 예: 자동차 객체
class Car {
    // 상태 (인스턴스 변수)
    String color;
    int speed;
    
    // 행동 (인스턴스 메서드)
    void accelerate() {
        speed += 10;
    }
}
```

## 2. 클래스와 객체의 관계

### 2.1 클래스: 객체의 설계도

클래스는 객체를 만들기 위한 **템플릿** 또는 **청사진**입니다.

```java
// 클래스 정의 (설계도)
public class Student {
    // 인스턴스 변수 (각 객체가 가질 데이터)
    public String name;
    public double test1, test2, test3;
    
    // 인스턴스 메서드 (각 객체가 수행할 행동)
    public double getAverage() {
        return (test1 + test2 + test3) / 3;
    }
}
```

### 2.2 객체: 클래스의 인스턴스

객체는 클래스를 기반으로 생성된 **실체**입니다.

```java
// 객체 생성
Student student1 = new Student();  // 첫 번째 학생 객체
Student student2 = new Student();  // 두 번째 학생 객체

// 각 객체는 독립적인 데이터를 가짐
student1.name = "김철수";
student2.name = "이영희";
```

### 2.3 static vs non-static

| 구분 | static (정적) | non-static (비정적) |
|------|--------------|-------------------|
| 소속 | 클래스에 속함 | 객체에 속함 |
| 개수 | 하나만 존재 | 객체마다 존재 |
| 접근 | 클래스명.멤버 | 객체명.멤버 |
| 생성 시점 | 클래스 로드 시 | 객체 생성 시 |

```java
class PlayerData {
    static int playerCount;      // 클래스 변수 (모든 플레이어가 공유)
    String name;                 // 인스턴스 변수 (각 플레이어마다)
    int score;                   // 인스턴스 변수 (각 플레이어마다)
}
```

## 3. 객체의 생성과 사용

### 3.1 객체 생성: new 연산자

```java
// 1단계: 변수 선언 (참조 변수)
Student std;

// 2단계: 객체 생성 및 참조 할당
std = new Student();

// 또는 한 번에
Student std = new Student();
```

### 3.2 중요한 개념: 참조(Reference)

**⚠️ 핵심 원칙**: Java에서 변수는 객체 자체를 저장하지 않고, 객체에 대한 **참조(주소)**를 저장합니다.

```java
Student std1 = new Student();
Student std2 = std1;  // 참조 복사 (같은 객체를 가리킴)

std1.name = "홍길동";
System.out.println(std2.name);  // "홍길동" 출력
```

### 3.3 null 참조

객체를 가리키지 않는 상태를 나타냅니다.

```java
Student std = null;  // 아무 객체도 가리키지 않음

// null 체크
if (std != null) {
    System.out.println(std.name);  // 안전한 접근
} else {
    System.out.println("학생 객체가 없습니다.");
}

// null 참조 사용 시 오류
std.name = "김철수";  // NullPointerException 발생!
```

## 4. 인스턴스 변수와 메서드 사용

### 4.1 점(.) 연산자

객체의 멤버에 접근할 때 사용합니다.

```java
Student std = new Student();

// 인스턴스 변수 접근
std.name = "박영수";
std.test1 = 85.5;
std.test2 = 90.0;
std.test3 = 88.5;

// 인스턴스 메서드 호출
double avg = std.getAverage();
System.out.println(std.name + "의 평균: " + avg);
```

### 4.2 메서드에서 인스턴스 변수 사용

인스턴스 메서드는 자동으로 해당 객체의 인스턴스 변수에 접근할 수 있습니다.

```java
public class BankAccount {
    private double balance;  // 인스턴스 변수
    
    public void deposit(double amount) {
        balance += amount;   // 이 객체의 balance를 사용
    }
    
    public double getBalance() {
        return balance;      // 이 객체의 balance를 반환
    }
}
```

## 5. Getter와 Setter 메서드

### 5.1 캡슐화의 원칙

private 변수 + public 메서드 = 안전한 접근

```java
public class Student {
    // private 변수 (직접 접근 불가)
    private String name;
    private int age;
    
    // Getter 메서드 (읽기)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter 메서드 (쓰기)
    public void setName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            name = newName;
        }
    }
    
    public void setAge(int newAge) {
        if (newAge > 0 && newAge < 150) {
            age = newAge;
        }
    }
}
```

### 5.2 Getter/Setter의 장점

1. **유효성 검사**: 잘못된 값 방지
2. **접근 제어**: 읽기 전용/쓰기 전용 가능
3. **유연성**: 내부 구현 변경 시 인터페이스 유지
4. **추가 로직**: 로깅, 계산 등 추가 가능

## 6. 배열과 객체

### 6.1 객체 배열

```java
// 학생 30명을 저장할 배열
Student[] students = new Student[30];

// 주의: 배열만 생성됨, 객체는 아직 없음!
// 각 요소는 null로 초기화됨

// 객체 생성 필요
for (int i = 0; i < students.length; i++) {
    students[i] = new Student();
}

// 사용
students[0].name = "첫 번째 학생";
students[1].name = "두 번째 학생";
```

### 6.2 배열도 객체다

```java
int[] numbers = new int[5];     // 배열 객체 생성
int[] copy = numbers;           // 참조 복사

numbers[0] = 100;
System.out.println(copy[0]);    // 100 출력 (같은 배열)
```

## 7. 메서드 매개변수로 객체 전달

### 7.1 참조 전달의 효과

```java
public class Example {
    public static void changeStudent(Student s) {
        s.name = "변경된 이름";  // 원본 객체가 변경됨
    }
    
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "원래 이름";
        
        changeStudent(student);
        System.out.println(student.name);  // "변경된 이름" 출력
    }
}
```

### 7.2 final 객체 변수

```java
final Student student = new Student();

// 가능: 객체 내부 데이터 변경
student.name = "홍길동";
student.test1 = 90;

// 불가능: 다른 객체 참조
// student = new Student();  // 컴파일 오류!
```

## 실습 예제: 은행 계좌 관리

```java
public class BankAccount {
    // Private 인스턴스 변수
    private String accountNumber;
    private String owner;
    private double balance;
    
    // 생성자
    public BankAccount(String number, String owner) {
        this.accountNumber = number;
        this.owner = owner;
        this.balance = 0.0;
    }
    
    // Getter 메서드들
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // 입금 메서드
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다.");
        }
    }
    
    // 출금 메서드
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다.");
            return true;
        }
        System.out.println("출금 실패: 잔액 부족");
        return false;
    }
    
    // 정보 출력
    public void printInfo() {
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("소유자: " + owner);
        System.out.println("잔액: " + balance + "원");
    }
}

// 사용 예제
public class BankExample {
    public static void main(String[] args) {
        // 계좌 생성
        BankAccount account1 = new BankAccount("123-456", "김철수");
        BankAccount account2 = new BankAccount("789-012", "이영희");
        
        // 거래 수행
        account1.deposit(100000);
        account1.withdraw(30000);
        account1.printInfo();
        
        // 계좌 간 이체
        transfer(account1, account2, 20000);
        
        System.out.println("\n=== 이체 후 ===");
        account1.printInfo();
        account2.printInfo();
    }
    
    // 이체 메서드
    public static void transfer(BankAccount from, BankAccount to, double amount) {
        if (from.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("이체 완료: " + amount + "원");
        } else {
            System.out.println("이체 실패");
        }
    }
}
```

## 요약

### 핵심 개념
- **클래스**: 객체를 만들기 위한 설계도
- **객체**: 클래스의 인스턴스, 독립적인 상태와 행동을 가짐
- **참조**: 변수는 객체의 주소를 저장
- **null**: 객체를 가리키지 않는 상태
- **getter/setter**: 안전한 데이터 접근을 위한 메서드

### 주의사항
1. 객체 생성을 잊지 말 것 (`new` 연산자)
2. null 참조 사용 시 NullPointerException 주의
3. 객체 대입은 참조 복사임을 기억
4. private 변수에는 getter/setter 사용

💡 **기억하세요**: 객체지향 프로그래밍은 현실 세계를 모델링하는 방식입니다. 각 객체는 독립적인 존재로서 자신만의 데이터와 기능을 가집니다!