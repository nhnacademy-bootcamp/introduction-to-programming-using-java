# 4.2 정적 서브루틴과 정적 변수 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 정적(static) 서브루틴의 개념과 특징을 이해한다
- 서브루틴을 정의하고 호출할 수 있다
- 정적 멤버 변수와 지역 변수의 차이를 구분한다
- 여러 서브루틴이 있는 프로그램을 작성할 수 있다
- 메서드와 서브루틴의 용어를 이해한다

## 1. Java의 서브루틴 특징

### 1.1 모든 서브루틴은 클래스 내부에
Java의 **모든 서브루틴은 반드시 클래스 내부에 정의**되어야 합니다.

```java
// ❌ 불가능 - Java에서는 클래스 밖에 서브루틴을 둘 수 없음
void doSomething() {
    // ...
}

// ✅ 올바른 방법 - 클래스 내부에 정의
public class MyClass {
    void doSomething() {
        // ...
    }
}
```

### 1.2 정적 vs 비정적 서브루틴
**정적(static) 서브루틴**:
- 클래스 자체에 속함
- 클래스명으로 호출 가능
- 객체 없이 사용 가능

**비정적(non-static) 서브루틴**:
- 객체에 속함
- 객체를 생성해야 사용 가능
- 이 장에서는 다루지 않음

```java
public class Example {
    // 정적 서브루틴
    public static void staticMethod() {
        System.out.println("정적 메서드입니다");
    }
    
    // 비정적 서브루틴 (이번 장에서는 다루지 않음)
    public void nonStaticMethod() {
        System.out.println("비정적 메서드입니다");
    }
}

// 호출 방법
Example.staticMethod();  // 클래스명으로 직접 호출
```

### 1.3 용어 정리
- **서브루틴(Subroutine)**: 일반적인 용어
- **메서드(Method)**: Java에서 선호하는 용어
- **함수(Function)**: 값을 반환하는 서브루틴
- **프로시저(Procedure)**: 다른 언어에서 사용하는 용어

💡 **Java에서는 "서브루틴"과 "메서드"를 같은 의미로 사용합니다!**

## 2. 서브루틴 정의

### 2.1 기본 구조
```java
modifiers  return-type  subroutine-name  ( parameter-list ) {
    statements
}
```

각 부분의 의미:
- **modifiers**: public, private, static 등의 수정자
- **return-type**: 반환하는 값의 타입 (없으면 void)
- **subroutine-name**: 서브루틴의 이름
- **parameter-list**: 매개변수 목록
- **statements**: 실행할 명령문들

### 2.2 정의 예제
```java
// 예제 1: 매개변수와 반환값이 없는 메서드
public static void sayHello() {
    System.out.println("안녕하세요!");
}

// 예제 2: 매개변수가 있는 메서드
public static void greet(String name) {
    System.out.println("안녕하세요, " + name + "님!");
}

// 예제 3: 반환값이 있는 메서드
public static int add(int a, int b) {
    return a + b;
}

// 예제 4: 여러 매개변수
public static double calculateAverage(double x, double y, double z) {
    return (x + y + z) / 3.0;
}
```

### 2.3 수정자(Modifiers)
주요 수정자들:
- **public**: 어디서든 접근 가능
- **private**: 같은 클래스 내에서만 접근 가능
- **static**: 정적 메서드 (클래스에 속함)
- **(없음)**: 같은 패키지 내에서 접근 가능

```java
public class AccessExample {
    public static void publicMethod() {
        // 어디서든 호출 가능
    }
    
    private static void privateMethod() {
        // 이 클래스 내에서만 호출 가능
    }
    
    static void packageMethod() {
        // 같은 패키지에서 호출 가능
    }
}
```

### 2.4 반환 타입
- **void**: 아무것도 반환하지 않음
- **기본 타입**: int, double, boolean 등
- **참조 타입**: String, 배열 등

```java
// void - 반환값 없음
public static void printMessage() {
    System.out.println("메시지");
    // return 문이 없어도 됨
}

// int 반환
public static int getRandomNumber() {
    return (int)(Math.random() * 100);
}

// String 반환
public static String getGreeting() {
    return "안녕하세요!";
}

// 배열 반환
public static int[] createArray() {
    int[] arr = {1, 2, 3, 4, 5};
    return arr;
}
```

## 3. 서브루틴 호출

### 3.1 같은 클래스 내에서 호출
```java
public class Calculator {
    public static void main(String[] args) {
        // 같은 클래스의 메서드는 이름만으로 호출
        int result = add(5, 3);
        System.out.println("5 + 3 = " + result);
        
        printResult(result);
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static void printResult(int value) {
        System.out.println("결과: " + value);
    }
}
```

### 3.2 다른 클래스에서 호출
```java
// Math 클래스
public class MathUtils {
    public static int multiply(int a, int b) {
        return a * b;
    }
}

// 사용하는 클래스
public class TestProgram {
    public static void main(String[] args) {
        // 다른 클래스의 정적 메서드는 클래스명.메서드명으로 호출
        int result = MathUtils.multiply(4, 5);
        System.out.println("4 × 5 = " + result);
        
        // Java 내장 클래스의 예
        double sqrt = Math.sqrt(16);  // Math 클래스의 sqrt 메서드
        System.out.println("√16 = " + sqrt);
    }
}
```

### 3.3 호출 규칙
1. 매개변수 개수가 일치해야 함
2. 매개변수 타입이 일치해야 함
3. 순서가 중요함

```java
public static void showInfo(String name, int age, double height) {
    System.out.println(name + ", " + age + "세, " + height + "cm");
}

// 올바른 호출
showInfo("김철수", 20, 175.5);

// ❌ 잘못된 호출들
// showInfo(20, "김철수", 175.5);  // 순서 오류
// showInfo("김철수", 20);         // 매개변수 부족
// showInfo("김철수", "20", 175.5); // 타입 오류
```

## 4. 프로그램 예제: 숫자 맞추기 게임

### 4.1 프로그램 설계
1. 컴퓨터가 1~100 사이의 숫자를 선택
2. 사용자가 6번 이내에 맞춰야 함
3. 높은지 낮은지 힌트 제공
4. 여러 게임 반복 가능

### 4.2 전체 프로그램
```java
import textio.TextIO;

public class GuessingGame {
    
    public static void main(String[] args) {
        System.out.println("=== 숫자 맞추기 게임 ===");
        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");
        
        boolean playAgain;
        do {
            playGame();  // 게임 실행
            System.out.print("다시 하시겠습니까? ");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);
        
        System.out.println("게임을 종료합니다. 감사합니다!");
    }
    
    static void playGame() {
        int computerNumber = (int)(Math.random() * 100) + 1;
        int userGuess;
        int guessCount = 0;
        
        System.out.println("\n새 게임을 시작합니다!");
        System.out.print("첫 번째 추측: ");
        
        while (true) {
            userGuess = TextIO.getInt();
            guessCount++;
            
            if (userGuess == computerNumber) {
                System.out.println("정답! " + guessCount + "번 만에 맞추셨습니다!");
                break;
            }
            
            if (guessCount == 6) {
                System.out.println("아쉽게도 실패했습니다. 정답은 " + computerNumber + "였습니다.");
                break;
            }
            
            if (userGuess < computerNumber) {
                System.out.print("더 높습니다. 다시 시도: ");
            } else {
                System.out.print("더 낮습니다. 다시 시도: ");
            }
        }
    }
}
```

### 4.3 프로그램 구조 분석
```
main() 메서드
  ├─ 게임 소개 출력
  ├─ 반복 루프
  │    ├─ playGame() 호출
  │    └─ 계속할지 확인
  └─ 종료 메시지

playGame() 메서드
  ├─ 랜덤 숫자 생성
  ├─ 추측 루프
  │    ├─ 사용자 입력
  │    ├─ 정답 확인
  │    ├─ 횟수 확인
  │    └─ 힌트 제공
  └─ 게임 종료
```

## 5. 멤버 변수

### 5.1 멤버 변수 vs 지역 변수
**지역 변수(Local Variable)**:
- 서브루틴 내부에서 선언
- 서브루틴 실행 중에만 존재
- 서브루틴 밖에서 접근 불가

**멤버 변수(Member Variable)**:
- 클래스 레벨에서 선언
- 프로그램 실행 동안 존재
- 모든 메서드에서 공유

```java
public class VariableExample {
    // 멤버 변수 (전역 변수)
    static int globalCount = 0;
    
    public static void method1() {
        // 지역 변수
        int localVar = 10;
        globalCount++;  // 멤버 변수 사용
    }
    
    public static void method2() {
        // localVar는 여기서 사용할 수 없음 (method1의 지역 변수)
        globalCount++;  // 멤버 변수는 사용 가능
    }
}
```

### 5.2 정적 멤버 변수 선언
```java
public class GameStats {
    // 정적 멤버 변수 선언
    static int totalGames;
    public static int wins;
    private static double winRate;
    
    // 여러 변수를 한 줄에 선언 가능
    static int losses, draws;
}
```

### 5.3 초기화
**자동 초기화**:
- 숫자형: 0
- boolean: false
- char: '\u0000'
- 참조형: null

```java
public class AutoInit {
    static int number;        // 0으로 초기화
    static boolean flag;      // false로 초기화
    static String text;       // null로 초기화
    static double[] array;    // null로 초기화
    
    public static void main(String[] args) {
        System.out.println("number = " + number);  // 0
        System.out.println("flag = " + flag);      // false
        System.out.println("text = " + text);      // null
    }
}
```

### 5.4 개선된 숫자 맞추기 게임
통계 기능을 추가한 버전:

```java
import textio.TextIO;

public class GuessingGame2 {
    // 멤버 변수로 게임 통계 관리
    static int gamesPlayed;   // 총 게임 수
    static int gamesWon;      // 승리한 게임 수
    
    public static void main(String[] args) {
        System.out.println("=== 숫자 맞추기 게임 ===");
        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");
        
        boolean playAgain;
        do {
            playGame();
            System.out.print("다시 하시겠습니까? ");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);
        
        // 게임 통계 출력
        System.out.println("\n=== 게임 통계 ===");
        System.out.println("총 게임 수: " + gamesPlayed);
        System.out.println("승리한 게임: " + gamesWon);
        if (gamesPlayed > 0) {
            double winRate = (double)gamesWon / gamesPlayed * 100;
            System.out.printf("승률: %.1f%%\n", winRate);
        }
        System.out.println("게임을 종료합니다. 감사합니다!");
    }
    
    static void playGame() {
        gamesPlayed++;  // 게임 수 증가
        
        int computerNumber = (int)(Math.random() * 100) + 1;
        int userGuess;
        int guessCount = 0;
        
        System.out.println("\n게임 #" + gamesPlayed + " 시작!");
        System.out.print("첫 번째 추측: ");
        
        while (true) {
            userGuess = TextIO.getInt();
            guessCount++;
            
            if (userGuess == computerNumber) {
                System.out.println("정답! " + guessCount + "번 만에 맞추셨습니다!");
                gamesWon++;  // 승리 수 증가
                break;
            }
            
            if (guessCount == 6) {
                System.out.println("아쉽게도 실패했습니다. 정답은 " + computerNumber + "였습니다.");
                break;
            }
            
            if (userGuess < computerNumber) {
                System.out.print("더 높습니다. 다시 시도: ");
            } else {
                System.out.print("더 낮습니다. 다시 시도: ");
            }
        }
    }
}
```

## 6. 중요한 규칙과 팁

### 6.1 서브루틴 위치
```java
public class Example {
    // ✅ 올바른 구조
    public static void main(String[] args) {
        method1();
        method2();
    }
    
    static void method1() {
        // 구현
    }
    
    static void method2() {
        // 구현
    }
}

// ❌ 잘못된 구조 - 서브루틴은 중첩될 수 없음
public static void main(String[] args) {
    static void wrongMethod() {  // 오류!
        // ...
    }
}
```

### 6.2 접근 제어 권장사항
1. 꼭 필요한 경우가 아니면 **private** 사용
2. 다른 클래스에서 사용해야 하면 **public** 사용
3. 같은 패키지에서만 사용하면 수정자 생략

### 6.3 네이밍 규칙
- 메서드명: 소문자로 시작, camelCase 사용
- 의미 있는 이름 사용
- 동사로 시작 (예: calculate, print, get, set)

```java
// 좋은 예
calculateAverage()
printResult()
getUserName()

// 나쁜 예
calc()      // 너무 짧음
Method1()   // 의미 없음
PRINT()     // 대문자 사용
```

## 요약

### 핵심 개념
- **정적 서브루틴**: 클래스에 속하며 객체 없이 호출 가능
- **서브루틴 정의**: 수정자, 반환타입, 이름, 매개변수, 본문
- **서브루틴 호출**: 같은 클래스는 이름만, 다른 클래스는 클래스명.메서드명
- **멤버 변수**: 클래스 레벨 변수로 모든 메서드에서 공유
- **지역 변수**: 메서드 내부 변수로 메서드 실행 중에만 존재

### 기억할 점
1. Java의 모든 서브루틴은 클래스 내부에 있어야 함
2. static 서브루틴은 클래스명으로 호출
3. 멤버 변수는 자동으로 초기화됨
4. 한 서브루틴이 다른 서브루틴 내부에 중첩될 수 없음

💡 **팁**: 관련된 작업을 서브루틴으로 분리하면 프로그램이 더 이해하기 쉽고 관리하기 편해집니다!