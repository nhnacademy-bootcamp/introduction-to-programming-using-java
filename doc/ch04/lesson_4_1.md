# 4.1 블랙박스와 절차적 추상화 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 서브루틴의 개념과 중요성을 이해한다
- 블랙박스의 세 가지 규칙을 설명할 수 있다
- 인터페이스와 구현의 차이를 구분한다
- 절차적 추상화와 정보 은닉의 개념을 이해한다
- 서브루틴의 계약(contract)을 작성할 수 있다

## 1. 서브루틴과 복잡성 관리

### 1.1 서브루틴이란?
**서브루틴(Subroutine)**은 특정 작업을 수행하기 위한 명령어들을 하나로 묶어 이름을 붙인 것입니다.

```java
// 서브루틴 없이 같은 작업을 반복하는 경우
System.out.println("*****");
System.out.println("*   *");
System.out.println("*   *");
System.out.println("*****");

// ... 다른 코드 ...

System.out.println("*****");
System.out.println("*   *");
System.out.println("*   *");
System.out.println("*****");

// 서브루틴을 사용하는 경우
public static void drawBox() {
    System.out.println("*****");
    System.out.println("*   *");
    System.out.println("*   *");
    System.out.println("*****");
}

// 이제 간단히 호출만 하면 됨
drawBox();
// ... 다른 코드 ...
drawBox();
```

### 1.2 청킹(Chunking)의 개념
**청킹**은 복잡한 작업을 하나의 단순한 개념으로 만드는 것입니다.

실생활 예시:
- "커피 만들기" = 물 끓이기 + 커피 가루 넣기 + 물 붓기 + 설탕/크림 추가
- "운전하기" = 시동 걸기 + 기어 변속 + 액셀/브레이크 조작 + 핸들 조작

프로그래밍에서:
```java
// 복잡한 작업을 하나의 이름으로 표현
calculateAverage(scores);  // 평균 계산의 모든 세부사항을 숨김
sortArray(numbers);        // 정렬 알고리즘의 복잡성을 숨김
sendEmail(recipient);      // 이메일 전송의 모든 과정을 숨김
```

## 2. 블랙박스 개념

### 2.1 블랙박스란?
**블랙박스(Black Box)**는 내부 구조를 알 필요 없이 사용할 수 있는 장치나 시스템입니다.

![블랙박스 개념도]
```
     입력 → [블랙박스] → 출력
              ↑
          인터페이스
    (버튼, 다이얼, 슬롯)
```

### 2.2 실생활의 블랙박스 예시

#### TV
- **인터페이스**: 전원 버튼, 채널 버튼, 볼륨 조절, 리모컨
- **숨겨진 내부**: 회로, 화면 기술, 신호 처리
- **사용자 관점**: 버튼만 누르면 TV를 볼 수 있음

#### 스마트폰
- **인터페이스**: 터치스크린, 앱 아이콘, 제스처
- **숨겨진 내부**: CPU, 메모리, 운영체제, 네트워크 처리
- **사용자 관점**: 앱을 터치하면 실행됨

#### 자동차
- **인터페이스**: 핸들, 페달, 기어
- **숨겨진 내부**: 엔진, 변속기, 전자 제어 시스템
- **사용자 관점**: 운전 방법만 알면 됨

## 3. 블랙박스의 세 가지 규칙

### 3.1 규칙 1: 간단한 인터페이스
> **"블랙박스의 인터페이스는 간단하고, 명확하게 정의되며, 이해하기 쉬워야 한다."**

```java
// ❌ 나쁜 인터페이스 - 너무 복잡함
public static double calc(int[] a, boolean b, String c, int d, double e) {
    // 매개변수가 무엇을 의미하는지 불분명
}

// ✅ 좋은 인터페이스 - 간단하고 명확함
public static double calculateAverage(int[] numbers) {
    // 숫자 배열의 평균을 계산한다는 것이 명확
}
```

### 3.2 규칙 2: 구현 독립성
> **"블랙박스를 사용하기 위해 그 구현을 알 필요가 없다."**

```java
// 사용자는 정렬이 어떻게 되는지 몰라도 됨
int[] numbers = {5, 2, 8, 1, 9};
Arrays.sort(numbers);  // 버블정렬? 퀵정렬? 상관없음!

// 구현이 바뀌어도 사용 방법은 동일
// 버전 1: 버블 정렬 사용
// 버전 2: 퀵 정렬로 변경 → 사용자는 모름
```

### 3.3 규칙 3: 사용 환경 독립성
> **"블랙박스 구현자는 블랙박스가 사용될 환경을 알 필요가 없다."**

```java
// Math.sqrt() 구현자는 이 메서드가 어디에 쓰일지 모름
double distance = Math.sqrt(x*x + y*y);        // 거리 계산
double standardDeviation = Math.sqrt(variance); // 표준편차 계산
double side = Math.sqrt(area);                 // 정사각형 한 변

// 모두 다른 용도지만 같은 블랙박스 사용
```

## 4. 인터페이스의 구성 요소

### 4.1 구문적(Syntactic) 구성 요소
서브루틴을 **어떻게** 호출하는지에 대한 규칙

```java
// 구문: 메서드명(매개변수 타입과 순서)
public static int add(int a, int b)

// 올바른 호출
int result = add(5, 3);

// 잘못된 호출 - 구문 오류
int result = add("5", 3);     // 타입 오류
int result = add(5);           // 매개변수 개수 오류
int result = add(5, 3, 2);     // 매개변수 개수 오류
```

### 4.2 의미적(Semantic) 구성 요소
서브루틴이 **무엇을** 하는지에 대한 설명

```java
/**
 * 두 정수의 합을 계산합니다.
 * @param a 첫 번째 정수
 * @param b 두 번째 정수
 * @return a와 b의 합
 */
public static int add(int a, int b) {
    return a + b;
}

/**
 * 배열에서 최대값을 찾습니다.
 * @param numbers 검색할 배열 (null이면 안됨, 비어있으면 안됨)
 * @return 배열의 최대값
 * @throws IllegalArgumentException 배열이 null이거나 비어있을 때
 */
public static int findMax(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
        throw new IllegalArgumentException("배열이 비어있습니다");
    }
    // 구현...
}
```

## 5. 서브루틴의 계약(Contract)

### 5.1 계약이란?
서브루틴의 계약은 "내가 보장하는 것"과 "당신이 지켜야 할 것"의 약속입니다.

```java
/**
 * 문자열을 정수로 변환합니다.
 * 
 * 계약:
 * - 사용자가 제공해야 할 것: 유효한 정수 형식의 문자열
 * - 메서드가 보장하는 것: 해당 문자열의 정수 값 반환
 * - 예외 상황: 잘못된 형식이면 NumberFormatException 발생
 * 
 * @param str 변환할 문자열
 * @return 문자열이 나타내는 정수 값
 * @throws NumberFormatException 문자열이 정수로 변환 불가능할 때
 */
public static int parseInt(String str) {
    // 구현...
}
```

### 5.2 좋은 계약의 예시
```java
/**
 * 은행 계좌에서 출금합니다.
 * 
 * 전제 조건 (사용자의 책임):
 * - amount > 0
 * - 계좌가 활성 상태여야 함
 * 
 * 사후 조건 (메서드의 보장):
 * - 잔액 >= amount이면 출금 성공, true 반환
 * - 잔액 < amount이면 출금 실패, false 반환, 잔액 변화 없음
 * 
 * @param amount 출금할 금액
 * @return 출금 성공 여부
 */
public boolean withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("출금액은 양수여야 합니다");
    }
    
    if (balance >= amount) {
        balance -= amount;
        return true;
    }
    return false;
}
```

## 6. 절차적 추상화

### 6.1 추상화의 개념
**추상화(Abstraction)**는 복잡한 구현 세부사항을 숨기고 본질적인 기능만 노출하는 것입니다.

```java
// 추상화 수준이 높은 코드
List<Student> topStudents = getTopStudents(students, 10);

// 추상화 없는 코드 - 모든 세부사항이 노출됨
List<Student> topStudents = new ArrayList<>();
for (int i = 0; i < students.size(); i++) {
    for (int j = i + 1; j < students.size(); j++) {
        if (students.get(i).getGrade() < students.get(j).getGrade()) {
            Student temp = students.get(i);
            students.set(i, students.get(j));
            students.set(j, temp);
        }
    }
}
for (int i = 0; i < 10 && i < students.size(); i++) {
    topStudents.add(students.get(i));
}
```

### 6.2 정보 은닉(Information Hiding)
구현의 세부사항을 외부로부터 숨기는 것

```java
public class BankAccount {
    private double balance;  // 외부에서 직접 접근 불가
    
    // 인터페이스를 통해서만 접근
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;  // 내부 구현
        }
    }
}
```

### 6.3 추상화의 장점
1. **복잡성 감소**: 사용자는 간단한 인터페이스만 알면 됨
2. **유지보수 용이**: 내부 구현 변경이 외부에 영향 없음
3. **재사용성**: 다양한 상황에서 동일한 추상화 사용 가능
4. **오류 감소**: 구현 세부사항 접근 제한으로 실수 방지

## 7. 실전 예제

### 7.1 블랙박스 서브루틴 설계
```java
/**
 * 이메일 주소의 유효성을 검사합니다.
 * 
 * 인터페이스 설계:
 * - 입력: 문자열 (이메일 주소)
 * - 출력: boolean (유효하면 true, 아니면 false)
 * - 구현 세부사항: 정규표현식, 도메인 확인 등은 숨김
 */
public static boolean isValidEmail(String email) {
    // 사용자는 이 복잡한 구현을 몰라도 됨
    if (email == null || email.isEmpty()) {
        return false;
    }
    
    // @ 기호 확인
    int atIndex = email.indexOf('@');
    if (atIndex <= 0 || atIndex == email.length() - 1) {
        return false;
    }
    
    // 도메인 부분 확인
    String domain = email.substring(atIndex + 1);
    return domain.contains(".") && !domain.startsWith(".") 
           && !domain.endsWith(".");
}

// 사용 예
String userEmail = "user@example.com";
if (isValidEmail(userEmail)) {
    System.out.println("유효한 이메일입니다.");
} else {
    System.out.println("잘못된 이메일 형식입니다.");
}
```

### 7.2 계층적 추상화
```java
// 높은 수준의 추상화
public static void processOrder(Order order) {
    if (validateOrder(order)) {
        chargePayment(order);
        shipOrder(order);
        sendConfirmation(order);
    }
}

// 중간 수준의 추상화
private static boolean validateOrder(Order order) {
    return checkInventory(order) && checkPaymentMethod(order);
}

// 낮은 수준의 추상화
private static boolean checkInventory(Order order) {
    // 실제 재고 확인 로직
    for (Item item : order.getItems()) {
        if (!isInStock(item)) {
            return false;
        }
    }
    return true;
}
```

## 요약

### 핵심 개념
- **서브루틴**: 작업을 묶어 이름을 붙인 재사용 가능한 코드 블록
- **블랙박스**: 내부 구현을 몰라도 사용할 수 있는 시스템
- **인터페이스**: 블랙박스와 외부 세계를 연결하는 경계
- **구현**: 블랙박스 내부의 실제 작동 방식
- **계약**: 서브루틴 사용 규칙과 보장 사항

### 블랙박스의 3대 규칙
1. 인터페이스는 간단하고 명확해야 함
2. 사용을 위해 구현을 알 필요 없음
3. 구현 시 사용 환경을 알 필요 없음

### 추상화의 중요성
- 복잡성을 관리하는 핵심 도구
- 정보 은닉을 통한 안전성 확보
- 재사용성과 유지보수성 향상

💡 **기억하세요**: 좋은 프로그램은 적절한 추상화 수준에서 블랙박스들을 조합하여 만들어집니다!