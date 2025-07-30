# 4.1 블랙박스와 절차적 추상화 - 수업 실습

## 1. 블랙박스 개념 실습

### 실습 1-1: 일상생활의 블랙박스 만들기

#### 요구사항
- TV, 전자레인지, 계산기의 블랙박스 클래스 구현
- TV: 켜기/끄기, 채널 변경, 볼륨 조절 기능
- 전자레인지: 시간 설정, 출력 설정, 조리 시작 기능
- 계산기: 덧셈, 곱셈, 제곱근 계산 기능
- 각 클래스의 내부 상태는 private로 숨기고 public 메서드로만 접근

```java
public class DailyBlackBoxes {
    public static void main(String[] args) {
        System.out.println("=== 일상생활의 블랙박스 예제 ===");
        
        // TODO 1: TV 블랙박스 사용하기
        System.out.println("1. TV 사용하기:");
        // TV 객체를 생성하고 켜기, 채널 변경, 볼륨 조절, 끄기를 해보세요
        
        // TODO 2: 전자레인지 블랙박스 사용하기
        System.out.println("\n2. 전자레인지 사용하기:");
        // 전자레인지 객체를 생성하고 시간 설정, 출력 설정, 시작을 해보세요
        
        // TODO 3: 계산기 블랙박스 사용하기
        System.out.println("\n3. 계산기 사용하기:");
        // 계산기의 add, multiply, squareRoot 메서드를 사용해보세요
    }
}

// TODO 4: TV 블랙박스 클래스 완성하기
class TV {
    private boolean isOn = false;
    private int channel = 1;
    private int volume = 10;
    
    public void turnOn() {
        // TODO: TV를 켜는 기능을 구현하세요
        // isOn을 true로 설정하고 "TV가 켜졌습니다." 출력
    }
    
    public void turnOff() {
        // TODO: TV를 끄는 기능을 구현하세요
    }
    
    public void changeChannel(int newChannel) {
        // TODO: 채널을 변경하는 기능을 구현하세요
        // TV가 켜져있을 때만 작동해야 함
    }
    
    public void adjustVolume(int newVolume) {
        // TODO: 볼륨을 조절하는 기능을 구현하세요
    }
}

// TODO 5: 전자레인지 블랙박스 클래스 완성하기
class Microwave {
    private int minutes = 0;
    private int seconds = 0;
    private int powerLevel = 100;
    
    public void setTime(int min, int sec) {
        // TODO: 시간을 설정하는 기능을 구현하세요
    }
    
    public void setPower(int power) {
        // TODO: 출력을 설정하는 기능을 구현하세요
    }
    
    public void start() {
        // TODO: 조리를 시작하는 기능을 구현하세요
    }
}

// TODO 6: 계산기 블랙박스 클래스 완성하기
class Calculator {
    public static double add(double a, double b) {
        // TODO: 두 수를 더하는 기능을 구현하세요
    }
    
    public static double multiply(double a, double b) {
        // TODO: 두 수를 곱하는 기능을 구현하세요
    }
    
    public static double squareRoot(double number) {
        // TODO: 제곱근을 계산하는 기능을 구현하세요 (Math.sqrt 사용)
    }
    
    // TODO 7: 추가 기능 구현하기
    // subtract (빼기), divide (나누기) 메서드를 추가로 구현해보세요
}
```

#### 실행 결과 (참고용):
```
=== 일상생활의 블랙박스 예제 ===
1. TV 사용하기:
TV가 켜졌습니다.
채널 7번으로 변경했습니다.
볼륨을 15으로 조정했습니다.
TV가 꺼졌습니다.

2. 전자레인지 사용하기:
시간 설정: 2분 30초
출력 설정: 70%
조리를 시작합니다... (복잡한 내부 작동은 숨겨짐)

3. 계산기 사용하기:
10 + 20 = 30.0
5 × 8 = 40.0
√64 = 8.0
```

### 실습 1-2: 블랙박스의 구현 변경 실습

#### 요구사항
- 버블 정렬과 선택 정렬의 서로 다른 구현을 비교
- 두 정렬 알고리즘 모두 같은 sort() 메서드로 호출
- 배열을 출력하는 printArray() 메서드 구현
- 선택 정렬 알고리즘 구현 (최소값을 찾아 앞으로 이동)
- 같은 결과를 내지만 내부 구현이 다른 예제 작성

```java
public class BlackBoxImplementationChange {
    public static void main(String[] args) {
        System.out.println("=== 블랙박스 구현 변경 예제 ===\n");
        
        // TODO 8: 두 가지 정렬 방식 테스트하기
        System.out.println("버전 1 정렬:");
        int[] numbers1 = {5, 2, 8, 1, 9};
        // SortingBlackBoxV1.sort(numbers1);
        // printArray(numbers1);
        
        System.out.println("\n버전 2 정렬:");
        int[] numbers2 = {5, 2, 8, 1, 9};
        // SortingBlackBoxV2.sort(numbers2);
        // printArray(numbers2);
    }
    
    // TODO 9: 배열을 출력하는 메서드를 구현하세요
    public static void printArray(int[] arr) {
        // for문을 사용하여 배열의 모든 요소를 출력하세요
    }
}

// 버블 정렬을 사용하는 블랙박스 (참고용 - 이미 구현됨)
class SortingBlackBoxV1 {
    public static void sort(int[] array) {
        System.out.println("(버블 정렬 사용 중...)");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

// TODO 10: 선택 정렬을 사용하는 블랙박스 완성하기
class SortingBlackBoxV2 {
    public static void sort(int[] array) {
        System.out.println("(선택 정렬 사용 중...)");
        // TODO: 선택 정렬 알고리즘을 구현하세요
        // 힌트: 최솟값을 찾아서 앞쪽으로 이동시키는 방식
    }
}
```

#### 실행 결과 (참고용):
```
=== 블랙박스 구현 변경 예제 ===
버전 1 정렬:
(버블 정렬 사용 중...)
1 2 5 8 9 

버전 2 정렬:
(선택 정렬 사용 중...)
1 2 5 8 9 
```

## 2. 서브루틴과 청킹 실습

### 실습 2-1: 청킹을 통한 복잡성 관리

#### 요구사항
- 복잡한 작업을 여러 개의 작은 서브루틴으로 분할
- 학생 성적 처리: 평균, 최고점, 최저점, 학점 결정 기능 구현
- 월간 보고서 생성: 단계별 처리 과정 출력
- 환영 이메일 발송: 이메일 발송 시뮬레이션
- 각 작업을 독립적인 서브루틴으로 구현하여 재사용성 향상

```java
public class ChunkingExample {
    public static void main(String[] args) {
        System.out.println("=== 청킹을 통한 복잡성 관리 ===\n");
        
        // TODO 11: 학생 성적 처리 기능 사용하기
        int[] scores = {85, 92, 78, 96, 88, 91, 83, 87};
        // processStudentGrades(scores);
        
        // TODO 12: 보고서 생성 기능 사용하기
        // generateMonthlyReport("2024년 1월");
        
        // TODO 13: 이메일 발송 기능 사용하기
        // sendWelcomeEmail("user@example.com", "홍길동");
    }
    
    // TODO 14: 학생 성적 처리 메서드 완성하기
    public static void processStudentGrades(int[] scores) {
        System.out.println("학생 성적 처리:");
        
        // TODO: 아래 메서드들을 호출하여 성적을 처리하고 결과를 출력하세요
        // 1. 평균 계산
        // 2. 최고 점수 찾기
        // 3. 최저 점수 찾기
        // 4. 학점 결정
        // 5. 결과 출력
    }
    
    // TODO 15: 평균 계산 메서드 구현하기
    private static double calculateAverage(int[] scores) {
        // 배열의 모든 점수를 더하고 개수로 나누어 평균을 계산하세요
    }
    
    // TODO 16: 최고 점수 찾기 메서드 구현하기
    private static int findHighestScore(int[] scores) {
        // 배열에서 가장 높은 점수를 찾아 반환하세요
    }
    
    // TODO 17: 최저 점수 찾기 메서드 구현하기
    private static int findLowestScore(int[] scores) {
        // 배열에서 가장 낮은 점수를 찾아 반환하세요
    }
    
    // TODO 18: 학점 결정 메서드 구현하기
    private static String determineGrade(double average) {
        // 평균에 따라 A, B, C, D, F 학점을 반환하세요
        // 90 이상: A, 80 이상: B, 70 이상: C, 60 이상: D, 60 미만: F
    }
    
    // TODO 19: 월간 보고서 생성 메서드 구현하기
    public static void generateMonthlyReport(String month) {
        // 보고서 생성 과정을 단계별로 출력하세요
    }
    
    // TODO 20: 이메일 발송 메서드 구현하기
    public static void sendWelcomeEmail(String email, String name) {
        // 이메일 발송 과정을 출력하세요
    }
}
```

#### 실행 결과 (참고용):
```
=== 청킹을 통한 복잡성 관리 ===

학생 성적 처리:
평균 점수: 87.5
최고 점수: 96
최저 점수: 78
학점: B

2024년 1월 보고서 생성:
1. 데이터 수집 중...
2. 통계 분석 중...
3. 차트 생성 중...
4. PDF 생성 중...
✅ 보고서가 완성되었습니다.

환영 이메일 발송:
수신자: user@example.com
이름: 홍길동
✅ 이메일이 발송되었습니다.
```

### 실습 2-2: 서브루틴 없이 vs 서브루틴 사용

#### 요구사항
- 서브루틴 없이 코드 중복으로 사각형 그리기
- 서브루틴을 사용하여 코드 중복 제거
- 고정 크기와 매개변수화된 서브루틴 비교
- 사각형 그리기: '*'로 테두리, 내부는 공백
- 코드 재사용성과 유지보수성의 이점 체험

```java
public class WithoutVsWithSubroutines {
    public static void main(String[] args) {
        System.out.println("=== 서브루틴 없이 vs 서브루틴 사용 ===\n");
        
        // TODO 21: 서브루틴 없이 코드 작성하기
        System.out.println("방법 1: 서브루틴 없이");
        // 두 개의 동일한 10x5 사각형을 직접 출력해보세요 (코드 중복)
        
        System.out.println("\n방법 2: 서브루틴 사용");
        // TODO 22: 서브루틴을 사용하여 간단하게 작성하기
        // drawRectangle() 메서드를 두 번 호출해보세요
        
        System.out.println("\n방법 3: 매개변수화된 서브루틴");
        // TODO 23: 매개변수화된 서브루틴 사용하기
        // 다양한 크기의 사각형을 그려보세요
    }
    
    // TODO 24: 고정된 크기의 사각형 그리기 메서드 구현하기
    public static void drawRectangle() {
        // 10x5 크기의 사각형을 그리는 코드를 작성하세요
    }
    
    // TODO 25: 크기를 조절할 수 있는 사각형 그리기 메서드 구현하기
    public static void drawCustomRectangle(int width, int height) {
        // 매개변수로 받은 크기의 사각형을 그리는 코드를 작성하세요
        // 힌트: 상단 테두리, 중간 부분, 하단 테두리로 나누어 생각해보세요
    }
}
```

#### 실행 결과 (참고용):
```
=== 서브루틴 없이 vs 서브루틴 사용 ===

방법 1: 서브루틴 없이
**********
*        *
*        *
*        *
**********

**********
*        *
*        *
*        *
**********

방법 2: 서브루틴 사용
**********
*        *
*        *
*        *
**********

**********
*        *
*        *
*        *
**********

방법 3: 매개변수화된 서브루틴
*****
*   *
*   *
*   *
*****

********
*      *
*      *
********

************
*          *
*          *
*          *
*          *
************
```

## 3. 인터페이스와 구현 분리 실습

### 실습 3-1: 구문적/의미적 인터페이스

#### 요구사항
- 구문적 인터페이스: 메서드 시그니처 (이름, 매개변수, 반환타입)
- 의미적 인터페이스: 메서드가 하는 일과 제약사항
- add() 메서드: 두 수의 합 반환
- calculateAverage() 메서드: null 및 빈 배열 처리
- BankAccount 클래스: 출금 로직과 잔액 확인

```java
public class InterfaceExample {
    public static void main(String[] args) {
        System.out.println("=== 인터페이스 구성 요소 예제 ===\n");
        
        // TODO 26: 구문적 인터페이스 테스트하기
        System.out.println("1. 구문적 인터페이스 (올바른 사용):");
        // add 메서드와 calculateAverage 메서드를 호출해보세요
        
        // TODO 27: 의미적 인터페이스 이해하기
        System.out.println("\n2. 의미적 인터페이스 이해:");
        // BankAccount 객체를 생성하고 출금 기능을 테스트해보세요
    }
    
    // TODO 28: 두 정수를 더하는 메서드 구현하기
    /**
     * 두 정수를 더합니다.
     * 구문: add(int, int) -> int
     * 의미: 첫 번째 매개변수와 두 번째 매개변수의 합을 반환
     */
    public static int add(int a, int b) {
        // 두 수의 합을 반환하세요
    }
    
    // TODO 29: 배열의 평균을 계산하는 메서드 구현하기
    /**
     * 배열의 평균을 계산합니다.
     * 전제조건: 배열이 null이 아니고 비어있지 않아야 함
     */
    public static double calculateAverage(double[] numbers) {
        // 배열이 null이거나 비어있으면 예외를 발생시키고
        // 그렇지 않으면 평균을 계산하여 반환하세요
    }
}

// TODO 30: 은행 계좌 클래스 완성하기
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        // 초기 잔액을 설정하세요
    }
    
    /**
     * 계좌에서 돈을 출금합니다.
     * 
     * 의미적 계약:
     * - 잔액이 충분하면 출금하고 true 반환
     * - 잔액이 부족하면 출금하지 않고 false 반환
     * - 음수 금액은 허용하지 않음
     */
    public boolean withdraw(double amount) {
        // 출금 로직을 구현하세요
    }
    
    public double getBalance() {
        // 현재 잔액을 반환하세요
    }
}
```

#### 실행 결과 (참고용):
```
=== 인터페이스 구성 요소 예제 ===

1. 구문적 인터페이스 (올바른 사용):
add(5, 3) = 8
평균 = 25.0

2. 의미적 인터페이스 이해:
초기 잔액: 1000.0
300원 출금 성공
현재 잔액: 700.0
800원 출금 실패 (잔액 부족)
최종 잔액: 700.0
```

### 실습 3-2: 서브루틴의 계약

#### 요구사항
- 사전조건, 사후조건, 예외 처리를 포함한 메서드 계약 구현
- safeDivide(): 0으로 나누기 방지, IllegalArgumentException 처리
- findElement(): null 배열 처리, 요소 찾기 구현 (없으면 -1 반환)
- isValidPassword(): 최소 6자, 문자와 숫자 포함 검사
- 각 메서드에 대한 테스트 코드 작성

```java
public class ContractExample {
    public static void main(String[] args) {
        System.out.println("=== 서브루틴의 계약 예제 ===\n");
        
        // TODO 31: 나누기 계약 테스트하기
        System.out.println("1. 나누기 계약:");
        // safeDivide 메서드를 사용해서 정상적인 나누기와 0으로 나누기를 테스트해보세요
        // try-catch를 사용하여 예외를 처리하세요
        
        // TODO 32: 배열 검색 계약 테스트하기
        System.out.println("\n2. 배열 검색 계약:");
        // findElement 메서드를 사용해서 요소 찾기를 테스트해보세요
        
        // TODO 33: 비밀번호 검증 계약 테스트하기
        System.out.println("\n3. 비밀번호 검증 계약:");
        // 여러 종류의 비밀번호를 테스트해보세요
    }
    
    // TODO 34: 안전한 나누기 연산 메서드 구현하기
    /**
     * 안전한 나누기 연산
     * 전제조건: divisor != 0
     * 사후조건: dividend / divisor의 정확한 결과 반환
     * 예외: divisor가 0이면 IllegalArgumentException 발생
     */
    public static double safeDivide(double dividend, double divisor) {
        // 0으로 나누기를 방지하는 안전한 나누기를 구현하세요
    }
    
    // TODO 35: 배열에서 요소 찾기 메서드 구현하기
    /**
     * 배열에서 요소 찾기
     * 전제조건: array != null
     * 사후조건: 요소를 찾으면 인덱스 반환, 못 찾으면 -1 반환
     * 보장: 배열의 내용은 변경되지 않음
     */
    public static int findElement(int[] array, int target) {
        // 배열에서 target을 찾는 메서드를 구현하세요 (null 검사 포함)
    }
    
    // TODO 36: 비밀번호 유효성 검사 메서드 구현하기
    /**
     * 비밀번호 유효성 검사
     * 규칙: 최소 6자 이상, 문자와 숫자 포함
     */
    public static boolean isValidPassword(String password) {
        // 비밀번호 유효성을 검사하는 메서드를 구현하세요
    }
    
    // TODO 37: 비밀번호 테스트 메서드 구현하기
    private static void testPassword(String password) {
        // 비밀번호를 테스트하고 결과를 출력하는 메서드를 구현하세요
    }
}
```

#### 실행 결과 (참고용):
```
=== 서브루틴의 계약 예제 ===

1. 나누기 계약:
10 ÷ 2 = 5.0
오류: 0으로 나눌 수 없습니다

2. 배열 검색 계약:
30의 위치: 2
99의 위치: -1 (찾지 못함)

3. 비밀번호 검증 계약:
비밀번호 'abc': ❌ 유효하지 않음
비밀번호 'password': ❌ 유효하지 않음
비밀번호 '12345678': ❌ 유효하지 않음
비밀번호 'Pass123': ✅ 유효함
```

## 학습 포인트

### 1. 블랙박스의 핵심
- 내부 구현을 숨기고 간단한 인터페이스만 제공
- 사용자는 **어떻게** 동작하는지 몰라도 **무엇을** 하는지만 알면 됨

### 2. 서브루틴의 이점
- **재사용성**: 같은 코드를 여러 번 사용
- **유지보수성**: 한 곳만 수정하면 모든 곳에 반영
- **가독성**: 복잡한 작업을 단순한 이름으로 표현

### 3. 계약 프로그래밍
- **사전조건**: 메서드 호출 전에 만족해야 할 조건
- **사후조건**: 메서드 완료 후 보장되는 결과
- **예외처리**: 계약 위반 시 적절한 대응