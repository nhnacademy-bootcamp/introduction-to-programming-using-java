# 4.2 정적 서브루틴과 정적 변수 - 수업 실습

## 1. 서브루틴 정의와 호출 실습

### 실습 1-1: 다양한 서브루틴 정의하기

#### 요구사항
- 다양한 형태의 서브루틴을 정의하고 호출하는 방법 익히기
- 매개변수와 반환값의 유무에 따른 메서드 구현
- 다양한 타입의 매개변수와 반환값 처리

```java
public class SubroutineBasics {
    public static void main(String[] args) {
        System.out.println("=== 서브루틴 기본 예제 ===\n");
        
        // TODO 1: 매개변수와 반환값이 없는 메서드 호출하기
        // printWelcome();
        
        // TODO 2: 매개변수가 있는 메서드 호출하기
        // greetUser("홍길동");
        // greetUser("김철수");
        
        // TODO 3: 반환값이 있는 메서드 호출하기
        // int sum = add(10, 20);
        // System.out.println("10 + 20 = " + sum);
        
        // TODO 4: 여러 매개변수와 반환값이 있는 메서드 호출하기
        // double avg = calculateAverage(85, 92, 78);
        // System.out.println("평균 점수: " + avg);
        
        // TODO 5: 문자열을 반환하는 메서드 호출하기
        // String message = createMessage("Java", "재미있다");
        // System.out.println(message);
    }
    
    // TODO 6: void 메서드 구현하기 (반환값 없음)
    public static void printWelcome() {
        // "프로그램에 오신 것을 환영합니다!"와 "즐거운 시간 되세요." 출력
    }
    
    // TODO 7: 매개변수가 있는 void 메서드 구현하기
    public static void greetUser(String name) {
        // "안녕하세요, [이름]님!" 형태로 인사말 출력
    }
    
    // TODO 8: int를 반환하는 메서드 구현하기
    public static int add(int a, int b) {
        // 두 수의 합을 계산하여 반환
    }
    
    // TODO 9: double을 반환하는 메서드 구현하기
    public static double calculateAverage(int score1, int score2, int score3) {
        // 세 점수의 평균을 계산하여 반환 (주의: 정수 나눗셈 피하기)
    }
    
    // TODO 10: String을 반환하는 메서드 구현하기
    public static String createMessage(String subject, String description) {
        // "[subject]은(는) [description]!" 형태의 문자열 반환
    }
}
```

#### 실행 결과 (참고용):
```
=== 서브루틴 기본 예제 ===

프로그램에 오신 것을 환영합니다!
즐거운 시간 되세요.

안녕하세요, 홍길동님!
안녕하세요, 김철수님!
10 + 20 = 30
평균 점수: 85.0
Java은(는) 재미있다!
```

### 실습 1-2: 메서드 호출 순서와 흐름 이해하기

#### 요구사항
- 메서드가 호출되는 순서와 실행 흐름 이해
- 메서드 호출 스택의 동작 방식 확인
- 중첩된 메서드 호출 구현

```java
public class MethodFlow {
    public static void main(String[] args) {
        System.out.println("=== 메서드 호출 흐름 ===\n");
        System.out.println("1. main 시작");
        
        // TODO 11: methodA 호출하기
        // methodA();
        
        System.out.println("6. main 종료");
    }
    
    // TODO 12: methodA 구현하기
    public static void methodA() {
        // "2. methodA 시작" 출력
        // methodB() 호출
        // "5. methodA 종료" 출력
    }
    
    // TODO 13: methodB 구현하기
    public static void methodB() {
        // "3. methodB 시작" 출력
        // methodC() 호출
        // "4. methodB 종료" 출력
    }
    
    // TODO 14: methodC 구현하기
    public static void methodC() {
        // "3.5. methodC 실행" 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 메서드 호출 흐름 ===

1. main 시작
2. methodA 시작
3. methodB 시작
3.5. methodC 실행
4. methodB 종료
5. methodA 종료
6. main 종료
```

## 2. 접근 제어자 실습

### 실습 2-1: 접근 제어자 비교 실습

#### 요구사항
- public, private, 기본 접근 제어자의 차이점 이해
- 각 접근 제어자의 접근 범위 테스트
- private 메서드의 간접 호출 구현

```java
public class AccessModifierExample {
    // public - 어디서든 접근 가능 (이미 구현됨)
    public static void publicMethod() {
        System.out.println("Public 메서드 호출됨");
    }
    
    // TODO 15: private 메서드 구현하기
    private static void privateMethod() {
        // "Private 메서드 호출됨" 출력
    }
    
    // TODO 16: package 메서드 구현하기
    static void packageMethod() {
        // "Package 메서드 호출됨" 출력
    }
    
    public static void main(String[] args) {
        System.out.println("=== 접근 제어자 예제 ===\n");
        
        // TODO 17: 같은 클래스 내에서 모든 메서드 호출하기
        // publicMethod();
        // privateMethod();
        // packageMethod();
        
        // TODO 18: private 메서드를 public 메서드를 통해 간접 호출하기
        // usePrivateMethod();
    }
    
    // TODO 19: private 메서드를 사용하는 public 메서드 구현하기
    public static void usePrivateMethod() {
        // "\npublic 메서드에서 private 메서드 호출:" 출력
        // privateMethod() 호출
    }
}

// TODO 20: 다른 클래스에서 접근 테스트하기
class AccessTest {
    public static void testAccess() {
        // public 메서드는 접근 가능
        // AccessModifierExample.publicMethod();
        
        // package 메서드는 같은 패키지라면 접근 가능
        // AccessModifierExample.packageMethod();
        
        // private 메서드는 접근 불가 (주석으로 표시)
        // AccessModifierExample.privateMethod(); // 컴파일 오류!
    }
}
```

#### 실행 결과 (참고용):
```
=== 접근 제어자 예제 ===

Public 메서드 호출됨
Private 메서드 호출됨
Package 메서드 호출됨

public 메서드에서 private 메서드 호출:
Private 메서드 호출됨
```

## 3. 계산기 프로그램 실습

### 실습 3-1: 기본 계산기 만들기

#### 요구사항
- 다양한 수학 연산을 수행하는 계산기 구현
- 사칙연산 메서드 구현 (덧셈, 뺄셈, 곱셈, 나눗셈)
- 고급 연산 메서드 구현 (거듭제곱, 제곱근, 최대값, 최소값)
- 0으로 나누기 오류 처리

```java
public class Calculator {
    public static void main(String[] args) {
        System.out.println("=== 계산기 프로그램 ===\n");
        
        // TODO 21: 기본 연산 테스트하기
        int a = 15, b = 4;
        
        // System.out.println(a + " + " + b + " = " + add(a, b));
        // System.out.println(a + " - " + b + " = " + subtract(a, b));
        // System.out.println(a + " × " + b + " = " + multiply(a, b));
        // System.out.println(a + " ÷ " + b + " = " + divide(a, b));
        // System.out.println(a + " % " + b + " = " + modulo(a, b));
        
        // TODO 22: 고급 연산 테스트하기
        // System.out.println("\n고급 연산:");
        // System.out.println(a + "의 " + b + "제곱 = " + power(a, b));
        // System.out.println(a + "의 제곱근 = " + squareRoot(a));
        // System.out.println(a + "과 " + b + "의 최대값 = " + max(a, b));
        // System.out.println(a + "과 " + b + "의 최소값 = " + min(a, b));
    }
    
    // TODO 23: 기본 사칙연산 메서드들 구현하기
    public static int add(int x, int y) {
        // 덧셈 구현
    }
    
    public static int subtract(int x, int y) {
        // 뺄셈 구현
    }
    
    public static int multiply(int x, int y) {
        // 곱셈 구현
    }
    
    public static double divide(int x, int y) {
        // 나눗셈 구현 (0으로 나누기 방지)
        // y가 0이면 경고 메시지 출력하고 0 반환
    }
    
    public static int modulo(int x, int y) {
        // 나머지 연산 구현
    }
    
    // TODO 24: 고급 연산 메서드들 구현하기
    public static double power(int base, int exponent) {
        // 거듭제곱 구현 (Math.pow 사용)
    }
    
    public static double squareRoot(int number) {
        // 제곱근 구현 (Math.sqrt 사용)
    }
    
    public static int max(int a, int b) {
        // 최대값 구현 (삼항 연산자 또는 if문 사용)
    }
    
    public static int min(int a, int b) {
        // 최소값 구현
    }
}
```

#### 실행 결과 (참고용):
```
=== 계산기 프로그램 ===

15 + 4 = 19
15 - 4 = 11
15 × 4 = 60
15 ÷ 4 = 3.75
15 % 4 = 3

고급 연산:
15의 4제곱 = 50625.0
15의 제곱근 = 3.872983346207417
15과 4의 최대값 = 15
15과 4의 최소값 = 4
```

### 실습 3-2: 배열을 사용하는 계산기

#### 요구사항
- 배열의 통계를 계산하는 메서드들 구현
- 합계, 평균, 최대값, 최소값, 범위 계산
- 빈 배열에 대한 예외 처리
- 다른 메서드를 활용한 효율적인 구현

```java
public class ArrayCalculator {
    public static void main(String[] args) {
        System.out.println("=== 배열 계산기 ===\n");
        
        int[] numbers = {10, 25, 30, 15, 20};
        
        // TODO 25: 배열 출력하고 통계 계산하기
        System.out.println("배열: ");
        // printArray(numbers);
        
        // System.out.println("\n통계:");
        // System.out.println("합계: " + sum(numbers));
        // System.out.println("평균: " + average(numbers));
        // System.out.println("최대값: " + findMax(numbers));
        // System.out.println("최소값: " + findMin(numbers));
        // System.out.println("범위: " + range(numbers));
    }
    
    // TODO 26: 배열 출력 메서드 구현하기
    public static void printArray(int[] arr) {
        // 배열의 모든 요소를 공백으로 구분하여 출력
    }
    
    // TODO 27: 합계 계산 메서드 구현하기
    public static int sum(int[] arr) {
        // 배열의 모든 요소 합계 반환
    }
    
    // TODO 28: 평균 계산 메서드 구현하기
    public static double average(int[] arr) {
        // 배열이 비어있으면 0 반환, 아니면 평균 반환
        // sum 메서드 활용하기
    }
    
    // TODO 29: 최대값 찾기 메서드 구현하기
    public static int findMax(int[] arr) {
        // 배열이 비어있으면 Integer.MIN_VALUE 반환
        // 첫 번째 요소부터 시작해서 최대값 찾기
    }
    
    // TODO 30: 최소값 찾기 메서드 구현하기
    public static int findMin(int[] arr) {
        // 배열이 비어있으면 Integer.MAX_VALUE 반환
        // 첫 번째 요소부터 시작해서 최소값 찾기
    }
    
    // TODO 31: 범위 계산 메서드 구현하기
    public static int range(int[] arr) {
        // 범위 = 최대값 - 최소값
        // findMax와 findMin 메서드 활용하기
    }
}
```

#### 실행 결과 (참고용):
```
=== 배열 계산기 ===

배열: 
10 25 30 15 20 

통계:
합계: 100
평균: 20.0
최대값: 30
최소값: 10
범위: 20
```

## 4. 멤버 변수 활용 실습

### 실습 4-1: 카운터 프로그램 만들기

#### 요구사항
- 정적 멤버 변수를 사용하여 상태를 유지하는 프로그램 구현
- 전역 카운터와 메서드별 카운터 관리
- 메서드 호출 횟수 추적 및 출력
- 카운터 정보 표시 메서드 구현

```java
public class CounterProgram {
    // TODO 32: 정적 멤버 변수 선언하기
    // globalCounter, methodACalls, methodBCalls 변수 선언
    
    public static void main(String[] args) {
        System.out.println("=== 카운터 프로그램 ===\n");
        
        System.out.println("초기 상태:");
        // printCounters();
        
        // TODO 33: 메서드들을 여러 번 호출하기
        // methodA(); methodA(); methodB(); methodA(); methodB(); methodB();
        
        System.out.println("\n최종 상태:");
        // printCounters();
    }
    
    // TODO 34: methodA 구현하기
    public static void methodA() {
        // methodACalls 증가
        // globalCounter 증가
        // "Method A 호출됨 (총 X번째)" 출력
    }
    
    // TODO 35: methodB 구현하기
    public static void methodB() {
        // methodBCalls 증가
        // globalCounter 증가
        // "Method B 호출됨 (총 X번째)" 출력
    }
    
    // TODO 36: printCounters 구현하기
    public static void printCounters() {
        // 전체 호출 횟수, Method A 호출 횟수, Method B 호출 횟수 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 카운터 프로그램 ===

초기 상태:
전체 호출 횟수: 0
Method A 호출: 0회
Method B 호출: 0회
Method A 호출됨 (총 1번째)
Method A 호출됨 (총 2번째)
Method B 호출됨 (총 1번째)
Method A 호출됨 (총 3번째)
Method B 호출됨 (총 2번째)
Method B 호출됨 (총 3번째)

최종 상태:
전체 호출 횟수: 6
Method A 호출: 3회
Method B 호출: 3회
```

### 실습 4-2: 은행 계좌 시뮬레이션

#### 요구사항
- 멤버 변수를 사용하여 계좌 정보를 관리하는 프로그램 구현
- 입금, 출금 기능 구현 (유효성 검사 포함)
- 잔액 부족 상황 처리
- 거래 통계 추적 및 표시
- 평균 거래액 계산

```java
public class BankSimulation {
    // TODO 37: 멤버 변수들 선언하기
    // accountHolder (문자열), balance (실수), transactionCount (정수),
    // totalDeposits (실수), totalWithdrawals (실수)
    
    public static void main(String[] args) {
        System.out.println("=== 은행 계좌 시뮬레이션 ===");
        // System.out.println("계좌 소유자: " + accountHolder);
        
        // TODO 38: 간단한 시뮬레이션 실행하기
        // 메뉴 방식 대신 직접 호출로 테스트
        // deposit(10000);
        // withdraw(3000);
        // deposit(5000);
        // withdraw(15000); // 잔액 부족
        // showStatistics();
    }
    
    // TODO 39: 입금 메서드 구현하기
    public static void deposit(double amount) {
        // amount가 0 이하면 "유효하지 않은 금액입니다." 출력하고 return
        // balance에 amount 추가
        // totalDeposits에 amount 추가
        // transactionCount 증가
        // 입금 완료 메시지와 현재 잔액 출력
    }
    
    // TODO 40: 출금 메서드 구현하기
    public static void withdraw(double amount) {
        // amount가 0 이하면 "유효하지 않은 금액입니다." 출력하고 return
        // amount가 balance보다 크면 "잔액이 부족합니다." 출력하고 return
        // balance에서 amount 차감
        // totalWithdrawals에 amount 추가
        // transactionCount 증가
        // 출금 완료 메시지와 현재 잔액 출력
    }
    
    // TODO 41: 잔액 조회 메서드 구현하기
    public static void checkBalance() {
        // 현재 잔액 출력
    }
    
    // TODO 42: 통계 보기 메서드 구현하기
    public static void showStatistics() {
        // 총 거래 횟수, 총 입금액, 총 출금액, 현재 잔액 출력
        // 거래 횟수가 0보다 크면 평균 거래액도 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 은행 계좌 시뮬레이션 ===
계좌 소유자: 홍길동
10000원이 입금되었습니다.
현재 잔액: 10000원
3000원이 출금되었습니다.
현재 잔액: 7000원
5000원이 입금되었습니다.
현재 잔액: 12000원
잔액이 부족합니다.

=== 거래 통계 ===
총 거래 횟수: 3
총 입금액: 15000원
총 출금액: 3000원
현재 잔액: 12000원
평균 거래액: 6000원
```

## 5. 실용적인 프로그램 실습

### 실습 5-1: 성적 관리 프로그램 (기본 버전)

#### 요구사항
- 배열과 정적 변수를 사용하여 학생 성적을 관리하는 프로그램 구현
- 최대 30명의 학생 정보 저장 (이름, 점수)
- 학생 추가, 전체 조회, 통계 보기, 학생 검색 기능
- 점수에 따른 학점 계산 (A~F)
- 입력값 유효성 검사 (점수 범위, 배열 크기)

```java
public class GradeManager {
    // TODO 43: 멤버 변수들 선언하기
    // MAX_STUDENTS (상수, 30), names (문자열 배열), 
    // scores (정수 배열), studentCount (정수)
    
    public static void main(String[] args) {
        System.out.println("=== 성적 관리 프로그램 ===");
        
        // TODO 44: 샘플 학생들 추가하고 테스트하기
        // addStudent("김철수", 85);
        // addStudent("이영희", 92);
        // addStudent("박민수", 78);
        // addStudent("최유진", 88);
        // addStudent("정하늘", 95);
        
        // showAllStudents();
        // showStatistics();
        // findStudent("이영희");
        // findStudent("홍길동"); // 없는 학생
    }
    
    // TODO 45: 학생 추가 메서드 구현하기
    public static void addStudent(String name, int score) {
        // studentCount가 MAX_STUDENTS 이상이면 "더 이상 학생을 추가할 수 없습니다." 출력하고 return
        // score가 0~100 범위를 벗어나면 "점수는 0~100 사이여야 합니다." 출력하고 return
        // names와 scores 배열에 정보 저장
        // studentCount 증가
        // "학생이 추가되었습니다." 출력
    }
    
    // TODO 46: 전체 학생 조회 메서드 구현하기
    public static void showAllStudents() {
        // studentCount가 0이면 "등록된 학생이 없습니다." 출력하고 return
        // 표 형태로 학생 정보 출력 (번호, 이름, 점수, 학점)
    }
    
    // TODO 47: 통계 보기 메서드 구현하기
    public static void showStatistics() {
        // studentCount가 0이면 "등록된 학생이 없습니다." 출력하고 return
        // 학생 수, 평균 점수, 최고 점수, 최저 점수 계산하여 출력
    }
    
    // TODO 48: 학생 검색 메서드 구현하기
    public static void findStudent(String searchName) {
        // 이름으로 학생 검색
        // 찾으면 학생 정보 출력, 못 찾으면 "학생을 찾을 수 없습니다." 출력
    }
    
    // TODO 49: 학점 계산 메서드 구현하기
    public static String getGrade(int score) {
        // 90 이상: A, 80 이상: B, 70 이상: C, 60 이상: D, 60 미만: F
    }
}
```

#### 실행 결과 (참고용):
```
=== 성적 관리 프로그램 ===
학생이 추가되었습니다.
학생이 추가되었습니다.
학생이 추가되었습니다.
학생이 추가되었습니다.
학생이 추가되었습니다.

=== 전체 학생 목록 ===
번호	이름	점수	학점
------------------------------
1	김철수	85	B
2	이영희	92	A
3	박민수	78	C
4	최유진	88	B
5	정하늘	95	A

=== 성적 통계 ===
학생 수: 5
평균 점수: 87.6
최고 점수: 95
최저 점수: 78

=== 검색 결과 ===
이름: 이영희
점수: 92
학점: A
학생을 찾을 수 없습니다.
```

### 실습 5-2: 간단한 주사위 게임

#### 요구사항
- 랜덤 함수와 정적 변수를 사용하여 주사위 게임 구현
- 플레이어와 컴퓨터가 각각 주사위 3번 굴리기
- 합계가 높은 쪽이 승리하는 규칙
- 게임 통계 추적 (승리/패배/무승부)
- 승률 계산 및 표시

```java
public class DiceGame {
    // TODO 50: 게임 통계 변수들 선언하기
    // gamesPlayed, playerWins, computerWins, draws
    
    public static void main(String[] args) {
        System.out.println("=== 주사위 게임 ===");
        System.out.println("주사위를 3번 굴려 합이 큰 쪽이 승리합니다!");
        
        // TODO 51: 게임을 여러 번 실행하기
        // playOneGame();
        // playOneGame();
        // playOneGame();
        // showFinalStatistics();
    }
    
    // TODO 52: 한 게임 플레이 메서드 구현하기
    public static void playOneGame() {
        // gamesPlayed 증가
        // 게임 번호 출력
        
        // 플레이어와 컴퓨터의 총점 계산
        // 각각 주사위를 3번 굴려서 합계 계산
        
        // 승부 판정하고 결과 출력
        // 해당 통계 변수 업데이트
    }
    
    // TODO 53: 주사위 굴리기 메서드 구현하기
    public static int rollDice() {
        // 1~6 사이의 랜덤 숫자 반환 (Math.random() 사용)
    }
    
    // TODO 54: 최종 통계 메서드 구현하기
    public static void showFinalStatistics() {
        // 총 게임 수, 플레이어 승리 수, 컴퓨터 승리 수, 무승부 수 출력
        // 게임 수가 0보다 크면 승률도 계산하여 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 주사위 게임 ===
주사위를 3번 굴려 합이 큰 쪽이 승리합니다!

=== 게임 #1 ===
플레이어 차례:
주사위 1: 4
주사위 2: 2
주사위 3: 6
플레이어 총점: 12

컴퓨터 차례:
주사위 1: 3
주사위 2: 5
주사위 3: 1
컴퓨터 총점: 9

=== 결과 ===
플레이어 승리!

=== 게임 #2 ===
플레이어 차례:
주사위 1: 2
주사위 2: 3
주사위 3: 4
플레이어 총점: 9

컴퓨터 차례:
주사위 1: 6
주사위 2: 5
주사위 3: 2
컴퓨터 총점: 13

=== 결과 ===
컴퓨터 승리!

=== 게임 #3 ===
플레이어 차례:
주사위 1: 5
주사위 2: 4
주사위 3: 3
플레이어 총점: 12

컴퓨터 차례:
주사위 1: 4
주사위 2: 4
주사위 3: 4
컴퓨터 총점: 12

=== 결과 ===
무승부!

=== 최종 통계 ===
총 게임 수: 3
플레이어 승리: 1
컴퓨터 승리: 1
무승부: 1
승률: 33.3%
```

## 학습 포인트

### 1. 정적 서브루틴의 특징
- **클래스 소속**: 객체 생성 없이 클래스명으로 직접 호출
- **매개변수와 반환값**: 다양한 형태의 입력과 출력 처리
- **접근 제어**: public, private, package 레벨 접근 제어

### 2. 정적 변수의 활용
- **상태 유지**: 프로그램 실행 중 값이 유지됨
- **공유**: 모든 메서드에서 접근 가능
- **초기화**: 클래스 로드 시 한 번만 초기화

### 3. 프로그램 설계 원칙
- **단일 책임**: 각 메서드는 하나의 명확한 기능 수행
- **재사용성**: 범용적으로 사용 가능한 메서드 설계
- **모듈화**: 관련 기능을 논리적으로 그룹화