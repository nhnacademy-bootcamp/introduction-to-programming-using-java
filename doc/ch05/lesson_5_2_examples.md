# 5.2 생성자와 객체 초기화 - 수업 실습

## 1. 기본 생성자와 매개변수 생성자

### 실습 1-1: 학생 클래스의 생성자
**목표**: 다양한 형태의 생성자 오버로딩을 구현해보세요.

```java
/**
 * 다양한 생성자를 가진 Student 클래스
 */
public class Student {
    // TODO 1: private 인스턴스 변수 선언하기
    // name (String), age (int), studentId (String), gpa (double)
    
    // TODO 2: 기본 생성자 구현하기
    public Student() {
        // name = "미정", age = 20, studentId = "S000000", gpa = 0.0으로 초기화
        // "기본 생성자로 학생 객체가 생성되었습니다." 출력
    }
    
    // TODO 3: 이름만 받는 생성자 구현하기
    public Student(String name) {
        // this.name을 매개변수로 설정, age = 20, studentId = "S000000", gpa = 0.0
        // "[이름] 학생 객체가 생성되었습니다." 출력
    }
    
    // TODO 4: 이름과 나이를 받는 생성자 구현하기
    public Student(String name, int age) {
        // name과 age를 매개변수로 설정, studentId = "S000000", gpa = 0.0
        // "[이름] ([나이]세) 학생 객체가 생성되었습니다." 출력
    }
    
    // TODO 5: 모든 정보를 받는 생성자 구현하기
    public Student(String name, int age, String studentId, double gpa) {
        // 모든 매개변수로 인스턴스 변수 초기화
        // "완전한 정보로 [이름] 학생 객체가 생성되었습니다." 출력
    }
    
    // TODO 6: getter 메서드들 구현하기
    public String getName() { }
    public int getAge() { }
    public String getStudentId() { }
    public double getGpa() { }
    
    // TODO 7: 학생 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "이름: [이름], 나이: [나이], 학번: [학번], GPA: [GPA]" 형식으로 출력
    }
}

// TODO 8: 사용 예제 완성하기
public class StudentConstructorExample {
    public static void main(String[] args) {
        System.out.println("=== 다양한 생성자 사용 ===");
        
        // TODO 9: 각각 다른 생성자를 사용하여 Student 객체 생성하기
        // 기본 생성자로 student1 생성
        // 이름만 지정하여 student2 생성 ("김철수")
        // 이름과 나이를 지정하여 student3 생성 ("이영희", 22)
        // 모든 정보를 지정하여 student4 생성 ("박민수", 21, "S202301", 3.8)
        
        // TODO 10: 학생 정보 출력하기
        System.out.println("\n=== 학생 정보 출력 ===");
        // 모든 학생의 displayInfo() 메서드 호출
    }
}
```

#### 실행 결과 (참고용):
```
=== 다양한 생성자 사용 ===
기본 생성자로 학생 객체가 생성되었습니다.
김철수 학생 객체가 생성되었습니다.
이영희 (22세) 학생 객체가 생성되었습니다.
완전한 정보로 박민수 학생 객체가 생성되었습니다.

=== 학생 정보 출력 ===
이름: 미정, 나이: 20, 학번: S000000, GPA: 0.0
이름: 김철수, 나이: 20, 학번: S000000, GPA: 0.0
이름: 이영희, 나이: 22, 학번: S000000, GPA: 0.0
이름: 박민수, 나이: 21, 학번: S202301, GPA: 3.8
```

### 실습 1-2: 은행 계좌 클래스
**목표**: 유효성 검사를 포함한 안전한 생성자를 구현해보세요.

```java
/**
 * 안전한 생성자를 가진 BankAccount 클래스
 */
public class BankAccount {
    // TODO 11: private 인스턴스 변수 선언하기
    // accountNumber, ownerName (String), balance (double), bankName (String)
    
    // TODO 12: 기본 생성자 구현하기 - 0원 계좌
    public BankAccount(String accountNumber, String ownerName) {
        // 계좌번호와 예금주명이 null이거나 비어있으면 IllegalArgumentException 발생
        // this.accountNumber = accountNumber, this.ownerName = ownerName
        // this.balance = 0.0, this.bankName = "Java Bank"
        // "[예금주]님의 계좌([계좌번호])가 개설되었습니다." 출력
    }
    
    // TODO 13: 초기 입금액이 있는 생성자 구현하기
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        // 계좌번호와 예금주명 유효성 검사 (null이거나 비어있으면 예외)
        // initialBalance가 0보다 작으면 "초기 잔액은 0 이상이어야 합니다." 예외
        // 모든 필드 초기화
        // "[예금주]님의 계좌([계좌번호])가 [금액]원으로 개설되었습니다." 출력
    }
    
    // TODO 14: 은행명까지 지정하는 생성자 구현하기
    public BankAccount(String accountNumber, String ownerName, 
                      double initialBalance, String bankName) {
        // 모든 매개변수 유효성 검사
        // bankName이 null이거나 비어있으면 "Java Bank"로 설정
        // "[은행명]에서 [예금주]님의 계좌([계좌번호])가 [금액]원으로 개설되었습니다." 출력
    }
    
    // TODO 15: getter 메서드들 구현하기
    public String getAccountNumber() { }
    public String getOwnerName() { }
    public double getBalance() { }
    public String getBankName() { }
    
    // TODO 16: 입금 메서드 구현하기
    public void deposit(double amount) {
        // amount가 0보다 크면 balance에 추가
        // "[금액]원이 입금되었습니다. 현재 잔액: [잔액]원" 출력
    }
    
    // TODO 17: 계좌 정보 출력 메서드 구현하기
    public void displayAccountInfo() {
        // "=== 계좌 정보 ===" 출력
        // "은행: [은행명]", "계좌번호: [계좌번호]", "예금주: [예금주]", "잔액: [잔액]원" 출력
    }
}

// TODO 18: 사용 예제 완성하기
public class BankAccountExample {
    public static void main(String[] args) {
        try {
            // TODO 19: 다양한 생성자로 계좌 생성하기
            // account1: "123-456-789", "김철수"
            // account2: "987-654-321", "이영희", 100000
            // account3: "555-777-999", "박민수", 500000, "우리은행"
            
            // TODO 20: 계좌 정보 출력하기
            System.out.println("\n=== 계좌 정보 출력 ===");
            // 각 계좌의 displayAccountInfo() 호출하고 빈 줄 출력
            
            // TODO 21: 입금 테스트하기
            System.out.println("\n=== 입금 테스트 ===");
            // account1에 50000원 입금
            
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
```

#### 실행 결과 (참고용):
```
김철수님의 계좌(123-456-789)가 개설되었습니다.
이영희님의 계좌(987-654-321)가 100000원으로 개설되었습니다.
우리은행에서 박민수님의 계좌(555-777-999)가 500000원으로 개설되었습니다.

=== 계좌 정보 출력 ===
=== 계좌 정보 ===
은행: Java Bank
계좌번호: 123-456-789
예금주: 김철수
잔액: 0.0원

=== 계좌 정보 ===
은행: Java Bank
계좌번호: 987-654-321
예금주: 이영희
잔액: 100000.0원

=== 계좌 정보 ===
은행: 우리은행
계좌번호: 555-777-999
예금주: 박민수
잔액: 500000.0원

=== 입금 테스트 ===
50000.0원이 입금되었습니다. 현재 잔액: 50000.0원
```

## 2. 인스턴스 변수 초기화

### 실습 2-1: 초기화 블록과 생성자
**목표**: 다양한 초기화 방법의 실행 순서를 이해해보세요.

```java
/**
 * 다양한 초기화 방법을 보여주는 클래스
 */
public class InitializationExample {
    // TODO 22: 인스턴스 변수 선언 시 초기화하기
    // private String name = "기본이름"
    // private int count = 0
    
    // TODO 23: 인스턴스 초기화 블록 구현하기
    {
        // "인스턴스 초기화 블록 실행" 출력
        // count = 10, name = "초기화블록에서설정"으로 변경
    }
    
    // TODO 24: static 변수와 static 초기화 블록 구현하기
    // private static String className 선언
    static {
        // "static 초기화 블록 실행" 출력
        // className = "InitializationExample"로 설정
    }
    
    // TODO 25: 기본 생성자 구현하기
    public InitializationExample() {
        // "기본 생성자 실행" 출력
        // name = "생성자에서설정", count = 100으로 변경
    }
    
    // TODO 26: 매개변수 생성자 구현하기
    public InitializationExample(String customName) {
        // "매개변수 생성자 실행" 출력
        // this.name = customName, this.count = 200으로 설정
    }
    
    // TODO 27: 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "클래스명: [className]", "이름: [name]", "카운트: [count]" 출력하고 빈 줄
    }
}

// TODO 28: 사용 예제 완성하기
public class InitializationOrderExample {
    public static void main(String[] args) {
        // TODO 29: 첫 번째 객체 생성하고 정보 출력하기
        System.out.println("=== 첫 번째 객체 생성 ===");
        // 기본 생성자로 obj1 생성하고 displayInfo() 호출
        
        // TODO 30: 두 번째 객체 생성하고 정보 출력하기
        System.out.println("=== 두 번째 객체 생성 ===");
        // "커스텀이름"으로 obj2 생성하고 displayInfo() 호출
    }
}
```

#### 실행 결과 (참고용):
```
static 초기화 블록 실행
=== 첫 번째 객체 생성 ===
인스턴스 초기화 블록 실행
기본 생성자 실행
클래스명: InitializationExample
이름: 생성자에서설정
카운트: 100

=== 두 번째 객체 생성 ===
인스턴스 초기화 블록 실행
매개변수 생성자 실행
클래스명: InitializationExample
이름: 커스텀이름
카운트: 200
```

### 실습 2-2: 동적 초기화 예제
**목표**: 생성 시마다 다른 값으로 초기화되는 객체를 만들어보세요.

```java
/**
 * 동적 초기화를 보여주는 주사위 클래스
 */
public class DynamicDice {
    // TODO 31: 동적으로 초기화되는 인스턴스 변수 선언하기
    // private int value = (int)(Math.random() * 6) + 1
    // private String createdTime = java.time.LocalTime.now().toString()
    // private static int totalDiceCount = 0
    // private int diceNumber
    
    // TODO 32: 생성자 구현하기
    public DynamicDice() {
        // totalDiceCount 증가
        // diceNumber = totalDiceCount로 설정
        // "[번호]번째 주사위 생성 - 초기값: [값] (생성시간: [시간])" 출력
    }
    
    // TODO 33: getter 메서드들 구현하기
    public int getValue() { }
    public String getCreatedTime() { }
    public int getDiceNumber() { }
    public static int getTotalDiceCount() { }
    
    // TODO 34: 주사위 굴리기 메서드 구현하기
    public void roll() {
        // value를 새로운 랜덤 값(1~6)으로 변경
        // "[번호]번 주사위를 굴렸습니다: [값]" 출력
    }
}

// TODO 35: 사용 예제 완성하기
public class DynamicInitializationExample {
    public static void main(String[] args) {
        System.out.println("=== 동적 초기화 테스트 ===");
        
        // TODO 36: 주사위 3개 생성하기
        // DynamicDice dice1, dice2, dice3 생성
        
        // TODO 37: 주사위 굴리기
        System.out.println("\n=== 주사위 굴리기 ===");
        // 각 주사위의 roll() 메서드 호출
        
        // TODO 38: 총 생성된 주사위 수 출력하기
        // "총 생성된 주사위 수: [개수]" 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 동적 초기화 테스트 ===
1번째 주사위 생성 - 초기값: 3 (생성시간: 14:30:15.123456)
2번째 주사위 생성 - 초기값: 5 (생성시간: 14:30:15.234567)
3번째 주사위 생성 - 초기값: 1 (생성시간: 14:30:15.345678)

=== 주사위 굴리기 ===
1번 주사위를 굴렸습니다: 4
2번 주사위를 굴렸습니다: 6
3번 주사위를 굴렸습니다: 2

총 생성된 주사위 수: 3
```

## 3. this 키워드 활용

### 실습 3-1: this를 사용한 매개변수 구분
**목표**: this 키워드의 다양한 활용법을 익혀보세요.

```java
/**
 * this 키워드의 다양한 사용법을 보여주는 클래스
 */
public class Rectangle {
    // TODO 39: private 인스턴스 변수 선언하기
    // width, height (double), color (String)
    
    // TODO 40: this로 인스턴스 변수와 매개변수 구분하는 생성자 구현하기
    public Rectangle(double width, double height) {
        // this.width = width, this.height = height
        // this.color = "흰색"
    }
    
    // TODO 41: 색상까지 받는 생성자 구현하기
    public Rectangle(double width, double height, String color) {
        // 모든 매개변수로 인스턴스 변수 초기화
    }
    
    // TODO 42: this()를 사용한 생성자 체이닝 - 기본 생성자
    public Rectangle() {
        // this(1.0, 1.0, "흰색") 호출
    }
    
    // TODO 43: this()를 사용한 생성자 체이닝 - 정사각형 생성자
    public Rectangle(double size) {
        // this(size, size, "흰색") 호출
    }
    
    // TODO 44: 메서드 체이닝을 위한 setter 구현하기
    public Rectangle setWidth(double width) {
        // this.width = width 설정
        // return this
    }
    
    public Rectangle setHeight(double height) {
        // this.height = height 설정
        // return this
    }
    
    public Rectangle setColor(String color) {
        // this.color = color 설정
        // return this
    }
    
    // TODO 45: getter 메서드들 구현하기
    public double getWidth() { }
    public double getHeight() { }
    public String getColor() { }
    
    // TODO 46: 넓이 계산 메서드 구현하기
    public double getArea() {
        // width * height 반환
    }
    
    // TODO 47: 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "사각형 정보: [가로] x [세로] ([색상]), 넓이: [넓이]" 출력
    }
    
    // TODO 48: this를 매개변수로 사용하는 비교 메서드 구현하기
    public boolean isLargerThan(Rectangle other) {
        // this의 넓이가 other의 넓이보다 크면 true 반환
    }
}

// TODO 49: 사용 예제 완성하기
public class ThisKeywordExample {
    public static void main(String[] args) {
        System.out.println("=== this 키워드 활용 예제 ===");
        
        // TODO 50: 다양한 생성자로 사각형 생성하기
        // rect1: 기본 생성자
        // rect2: 크기 5.0인 정사각형
        // rect3: 3.0 x 4.0 사각형
        // rect4: 2.0 x 6.0 빨간색 사각형
        
        // TODO 51: 생성된 사각형 정보 출력하기
        System.out.println("\n=== 생성된 사각형들 ===");
        // 모든 사각형의 displayInfo() 호출
        
        // TODO 52: 메서드 체이닝 사용하기
        System.out.println("\n=== 메서드 체이닝 ===");
        // new Rectangle().setWidth(10.0).setHeight(5.0).setColor("파란색")으로 rect5 생성
        // rect5의 정보 출력
        
        // TODO 53: 크기 비교하기
        System.out.println("\n=== 크기 비교 ===");
        // rect3과 rect4를 비교하여 결과 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== this 키워드 활용 예제 ===

=== 생성된 사각형들 ===
사각형 정보: 1.0 x 1.0 (흰색), 넓이: 1.0
사각형 정보: 5.0 x 5.0 (흰색), 넓이: 25.0
사각형 정보: 3.0 x 4.0 (흰색), 넓이: 12.0
사각형 정보: 2.0 x 6.0 (빨간색), 넓이: 12.0

=== 메서드 체이닝 ===
사각형 정보: 10.0 x 5.0 (파란색), 넓이: 50.0

=== 크기 비교 ===
rect4가 rect3보다 크거나 같습니다.
```

## 4. final 변수와 생성자

### 실습 4-1: 불변 객체 설계
**목표**: final 필드를 가진 불변 객체를 설계해보세요.

```java
/**
 * final 필드를 가진 불변 Person 클래스
 */
public class ImmutablePerson {
    // TODO 54: final 필드 선언하기
    // private final String name, socialId (String), birthYear (int)
    // private int age (변경 가능)
    
    // TODO 55: 생성자 구현하기
    public ImmutablePerson(String name, String socialId, int birthYear) {
        // name이 null이거나 비어있으면 "이름은 필수입니다." 예외
        // socialId가 null이거나 13자리가 아니면 "주민번호는 13자리여야 합니다." 예외
        // birthYear가 1900보다 작거나 2023보다 크면 "출생연도가 유효하지 않습니다." 예외
        // final 필드들 초기화
        // age = 2023 - birthYear로 계산
    }
    
    // TODO 56: getter 메서드들 구현하기 (setter는 없음)
    public String getName() { }
    public String getSocialId() { }
    public int getBirthYear() { }
    public int getAge() { }
    
    // TODO 57: age 업데이트 메서드 구현하기
    public void updateAge(int currentYear) {
        // this.age = currentYear - birthYear
    }
    
    // TODO 58: 새로운 객체를 반환하는 방식으로 "변경" 구현하기
    public ImmutablePerson withNewAge(int currentYear) {
        // 같은 name, socialId, birthYear로 새 객체 생성
        // 새 객체의 age를 currentYear - birthYear로 설정
        // 새 객체 반환
    }
    
    // TODO 59: 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "이름: [이름], 주민번호: [앞6자리]-*******, 출생연도: [년도], 나이: [나이]" 출력
    }
}

// TODO 60: 사용 예제 완성하기
public class ImmutableObjectExample {
    public static void main(String[] args) {
        try {
            System.out.println("=== 불변 객체 예제 ===");
            
            // TODO 61: 불변 객체 생성하기
            // "김철수", "9001011234567", 1990으로 person 생성하고 정보 출력
            
            // TODO 62: age 업데이트하기
            // 2024년 기준으로 나이 업데이트하고 정보 출력
            
            // TODO 63: 새 객체 생성 방식 테스트하기
            // 2025년 기준으로 새 객체 생성
            // 원본 객체와 새 객체 정보 모두 출력
            
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
```

#### 실행 결과 (참고용):
```
=== 불변 객체 예제 ===
이름: 김철수, 주민번호: 900101-*******, 출생연도: 1990, 나이: 33

나이 업데이트 후:
이름: 김철수, 주민번호: 900101-*******, 출생연도: 1990, 나이: 34

새 객체 생성 후:
원본 객체:
이름: 김철수, 주민번호: 900101-*******, 출생연도: 1990, 나이: 34
새 객체:
이름: 김철수, 주민번호: 900101-*******, 출생연도: 1990, 나이: 35
```

## 5. 정적 변수와 자동 ID 생성

### 실습 5-1: 자동 ID 생성 시스템
**목표**: static 변수를 활용한 자동 ID 생성 시스템을 구현해보세요.

```java
/**
 * 자동 ID 생성 기능이 있는 Product 클래스
 */
public class Product {
    // TODO 64: static 변수 선언하기
    // private static int nextProductId = 1000
    // private static int totalProducts = 0
    
    // TODO 65: 인스턴스 변수 선언하기
    // private final int productId (변경 불가능)
    // private String name, category
    // private double price
    // private boolean inStock
    
    // TODO 66: 생성자 구현하기
    public Product(String name, double price, String category) {
        // name이 null이거나 비어있으면 "상품명은 필수입니다." 예외
        // price가 0보다 작으면 "가격은 0 이상이어야 합니다." 예외
        // productId = nextProductId++ (자동 ID 할당)
        // this.name = name, this.price = price
        // category가 null이면 "기타"로 설정
        // inStock = true
        // totalProducts 증가
        // "상품 생성: ID=[ID], 이름=[이름]" 출력
    }
    
    // TODO 67: static 메서드들 구현하기
    public static int getTotalProducts() { }
    public static int getNextProductId() { }
    public static void resetIdCounter(int startId) {
        // nextProductId = startId
    }
    
    // TODO 68: getter 메서드들 구현하기
    public int getProductId() { }
    public String getName() { }
    public double getPrice() { }
    public String getCategory() { }
    public boolean isInStock() { }
    
    // TODO 69: setter 메서드들 구현하기 (ID는 final이므로 setter 없음)
    public void setName(String name) {
        // name이 null이 아니고 비어있지 않으면 설정
    }
    
    public void setPrice(double price) {
        // price가 0 이상이면 설정
    }
    
    public void setInStock(boolean inStock) {
        // this.inStock = inStock
    }
    
    // TODO 70: 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "ID: [ID], 상품명: [이름], 가격: [가격]원, 카테고리: [카테고리], 재고: [있음/없음]" 출력
    }
}

// TODO 71: 사용 예제 완성하기
public class AutoIdExample {
    public static void main(String[] args) {
        System.out.println("=== 자동 ID 생성 시스템 ===");
        
        // TODO 72: 여러 상품 생성하기
        // product1: "노트북", 1500000, "전자제품"
        // product2: "마우스", 25000, "전자제품"
        // product3: "의자", 150000, "가구"
        // product4: "책", 15000, "도서"
        
        // TODO 73: 상품 정보 출력하기
        System.out.println("\n=== 상품 정보 ===");
        // 모든 상품의 displayInfo() 호출
        
        // TODO 74: 통계 정보 출력하기
        System.out.println("\n=== 통계 정보 ===");
        // "총 생성된 상품 수: [개수]", "다음 상품 ID: [ID]" 출력
        
        // TODO 75: ID 카운터 재설정 테스트하기
        System.out.println("\n=== ID 카운터 재설정 ===");
        // resetIdCounter(5000) 호출
        // product5: "키보드", 80000, "전자제품" 생성
        // product5 정보 출력
        // 총 상품 수 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 자동 ID 생성 시스템 ===
상품 생성: ID=1000, 이름=노트북
상품 생성: ID=1001, 이름=마우스
상품 생성: ID=1002, 이름=의자
상품 생성: ID=1003, 이름=책

=== 상품 정보 ===
ID: 1000, 상품명: 노트북, 가격: 1500000.0원, 카테고리: 전자제품, 재고: 있음
ID: 1001, 상품명: 마우스, 가격: 25000.0원, 카테고리: 전자제품, 재고: 있음
ID: 1002, 상품명: 의자, 가격: 150000.0원, 카테고리: 가구, 재고: 있음
ID: 1003, 상품명: 책, 가격: 15000.0원, 카테고리: 도서, 재고: 있음

=== 통계 정보 ===
총 생성된 상품 수: 4
다음 상품 ID: 1004

=== ID 카운터 재설정 ===
상품 생성: ID=5000, 이름=키보드
ID: 5000, 상품명: 키보드, 가격: 80000.0원, 카테고리: 전자제품, 재고: 있음
총 상품 수: 5
```

## 6. 복합 생성자 예제

### 실습 6-1: 온라인 주문 시스템
**목표**: 복잡한 비즈니스 로직이 포함된 생성자를 구현해보세요.

```java
/**
 * 복잡한 생성자 로직을 가진 Order 클래스
 */
public class Order {
    // TODO 76: final 필드 선언하기
    // orderId, customerId, productName (String)
    // quantity (int), unitPrice, totalAmount (double)
    // orderDate, status (String)
    
    // TODO 77: static 변수 선언하기
    // private static int orderSequence = 1
    
    // TODO 78: 생성자 구현하기
    public Order(String customerId, String productName, int quantity, double unitPrice) {
        // 모든 매개변수 유효성 검사:
        // - customerId, productName이 null이거나 비어있으면 예외
        // - quantity가 0 이하면 "수량은 1 이상이어야 합니다." 예외
        // - unitPrice가 0보다 작으면 "단가는 0 이상이어야 합니다." 예외
        // 
        // orderId = generateOrderId() 호출하여 생성
        // 필드들 초기화
        // 
        // 총액 계산: double baseAmount = quantity * unitPrice
        // quantity >= 10이면 10% 할인 적용 (baseAmount * 0.9)
        // "10개 이상 주문으로 10% 할인이 적용되었습니다." 출력
        // 
        // orderDate = java.time.LocalDate.now().toString()
        // status = "주문완료"
        // 
        // "주문이 생성되었습니다: [주문ID]" 출력
    }
    
    // TODO 79: 주문 ID 생성 메서드 구현하기
    private static String generateOrderId() {
        // 오늘 날짜를 YYYYMMDD 형식으로 가져오기:
        // String today = java.time.LocalDate.now().toString().replace("-", "")
        // "ORD" + today + String.format("%04d", orderSequence++) 반환
    }
    
    // TODO 80: getter 메서드들 구현하기
    public String getOrderId() { }
    public String getCustomerId() { }
    public String getProductName() { }
    public int getQuantity() { }
    public double getUnitPrice() { }
    public double getTotalAmount() { }
    public String getOrderDate() { }
    public String getStatus() { }
    
    // TODO 81: 주문 정보 출력 메서드 구현하기
    public void displayOrderInfo() {
        // "=== 주문 정보 ===" 출력
        // 모든 필드 정보를 보기 좋게 출력
    }
}

// TODO 82: 사용 예제 완성하기
public class ComplexConstructorExample {
    public static void main(String[] args) {
        try {
            System.out.println("=== 온라인 주문 시스템 ===");
            
            // TODO 83: 다양한 주문 생성하기
            // order1: "CUST001", "노트북", 2, 1500000
            // order2: "CUST002", "마우스", 15, 25000 (할인 적용됨)
            // order3: "CUST001", "키보드", 5, 80000
            
            // TODO 84: 주문 상세 정보 출력하기
            System.out.println("\n=== 주문 상세 정보 ===");
            // 모든 주문의 displayOrderInfo() 호출하고 빈 줄 출력
            
        } catch (IllegalArgumentException e) {
            System.out.println("주문 생성 오류: " + e.getMessage());
        }
    }
}
```

#### 실행 결과 (참고용):
```
=== 온라인 주문 시스템 ===
주문이 생성되었습니다: ORD202401120001
10개 이상 주문으로 10% 할인이 적용되었습니다.
주문이 생성되었습니다: ORD202401120002
주문이 생성되었습니다: ORD202401120003

=== 주문 상세 정보 ===
=== 주문 정보 ===
주문 ID: ORD202401120001
고객 ID: CUST001
상품명: 노트북
수량: 2개
단가: 1500000.0원
총액: 3000000.0원
주문일: 2024-01-12
상태: 주문완료

=== 주문 정보 ===
주문 ID: ORD202401120002
고객 ID: CUST002
상품명: 마우스
수량: 15개
단가: 25000.0원
총액: 337500.0원
주문일: 2024-01-12
상태: 주문완료

=== 주문 정보 ===
주문 ID: ORD202401120003
고객 ID: CUST001
상품명: 키보드
수량: 5개
단가: 80000.0원
총액: 400000.0원
주문일: 2024-01-12
상태: 주문완료
```

## 학습 포인트

### 1. 생성자의 역할
- **객체 초기화**: 객체 생성 시 필드 초기값 설정
- **유효성 검사**: 잘못된 값으로 객체 생성 방지
- **필수값 보장**: 반드시 필요한 값들을 강제

### 2. 생성자 오버로딩
- **다양한 초기화 방법**: 상황에 따른 적절한 생성자 제공
- **기본값 제공**: 선택적 매개변수에 기본값 설정
- **생성자 체이닝**: this()를 통한 코드 재사용

### 3. final 필드와 불변 객체
- **불변성 보장**: 한 번 설정된 값 변경 불가
- **스레드 안전성**: 동시성 문제 해결
- **예측 가능한 동작**: 객체 상태가 변하지 않음

### 4. static 변수 활용
- **공유 데이터**: 모든 인스턴스가 공유하는 정보
- **자동 ID 생성**: 순차적이고 유일한 ID 보장
- **통계 정보**: 전체 객체 수 등 클래스 레벨 정보

### 5. this 키워드
- **명확한 구분**: 인스턴스 변수와 매개변수 구분
- **생성자 체이닝**: 다른 생성자 호출로 코드 중복 제거
- **메서드 체이닝**: 연속적인 메서드 호출 가능