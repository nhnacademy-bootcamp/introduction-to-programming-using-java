# 4.3 Parameters(매개변수)

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 매개변수의 개념과 역할을 이해한다
- 형식 매개변수와 실제 매개변수를 구분할 수 있다
- 메서드 오버로딩을 이해하고 활용할 수 있다
- 배열을 매개변수로 사용할 수 있다
- 예외를 발생시켜 오류를 처리할 수 있다
- 전역 변수와 지역 변수의 차이를 이해한다

## 1. 매개변수의 개념

### 1.1 매개변수란?
**매개변수(Parameter)** 는 외부에서 서브루틴 내부로 정보를 전달하는 메커니즘입니다.

비유: 온도 조절 장치
```
온도 조절 장치 = 블랙박스
설정 온도 다이얼 = 매개변수
→ 같은 작업(온도 유지)을 하지만 매개변수(설정값)에 따라 다르게 동작
```

### 1.2 매개변수의 역할
```java
// 매개변수 없는 메서드 - 항상 같은 동작
public static void printHello() {
    System.out.println("Hello!");  // 항상 "Hello!" 출력
}

// 매개변수 있는 메서드 - 매개변수에 따라 다른 동작
public static void printGreeting(String name) {
    System.out.println("Hello, " + name + "!");  // name에 따라 다른 출력
}

// 사용
printHello();           // "Hello!"
printGreeting("김철수");  // "Hello, 김철수!"
printGreeting("이영희");  // "Hello, 이영희!"
```

## 2. 매개변수 사용하기

### 2.1 3N+1 문제 예제
```java
/**
 * 3N+1 시퀀스를 출력하는 메서드
 * 규칙: N이 홀수면 3N+1, N이 짝수면 N/2
 * N이 1이 될 때까지 반복
 *
 * @param startingValue 시작값 (양의 정수여야 함)
 */
static void print3NSequence(int startingValue) {
    int N = startingValue;  // 매개변수 값을 지역 변수에 복사
    int count = 1;          // 시퀀스의 항 개수

    System.out.println("시작값 " + N + "의 3N+1 시퀀스:");
    System.out.println(N);  // 첫 번째 항 출력

    while (N > 1) {
        if (N % 2 == 1) {   // N이 홀수인가?
            N = 3 * N + 1;
        } else {
            N = N / 2;
        }
        count++;
        System.out.println(N);
    }

    System.out.println("시퀀스에는 " + count + "개의 항이 있습니다.");
}
```

### 2.2 메서드 호출하기
```java
public static void main(String[] args) {
    // 직접 값 전달
    print3NSequence(3);     // 3, 10, 5, 16, 8, 4, 2, 1

    // 변수를 통해 전달
    int num = 7;
    print3NSequence(num);   // 7, 22, 11, 34, 17, ...

    // 표현식으로 전달
    print3NSequence(2 * 5 + 1);  // 11로 시작하는 시퀀스
}
```

## 3. 형식 매개변수와 실제 매개변수

### 3.1 용어 정리
- **형식 매개변수(Formal Parameter)**: 메서드 정의에서 사용하는 매개변수
- **실제 매개변수(Actual Parameter)**: 메서드 호출 시 전달하는 값

```java
// 메서드 정의
static void greet(String name, int age) {  // name, age = 형식 매개변수
    System.out.println(name + "님은 " + age + "세입니다.");
}

// 메서드 호출
greet("홍길동", 25);  // "홍길동", 25 = 실제 매개변수
```

### 3.2 매개변수 전달 과정
```java
static void doTask(int N, double x, boolean test) {
    // 메서드 본문
    System.out.println("N = " + N);
    System.out.println("x = " + x);
    System.out.println("test = " + test);
}

// 호출
int z = 5;
doTask(17, Math.sqrt(z+1), z >= 10);

// 실행 과정:
// 1. N = 17 할당
// 2. x = Math.sqrt(6) = 2.449... 할당
// 3. test = false (5 >= 10은 false) 할당
// 4. 메서드 본문 실행
```

### 3.3 중요한 원칙
⚠️ **형식 매개변수는 메서드가 시작될 때 이미 값을 가지고 있습니다!**

```java
// ❌ 잘못된 예 - 매개변수에 값을 다시 입력받지 마세요!
static void wrongMethod(int value) {
    System.out.print("값을 입력하세요: ");
    value = TextIO.getInt();  // 잘못됨! value는 이미 값을 가지고 있음
}

// ✅ 올바른 예
static void rightMethod(int value) {
    // value는 이미 호출할 때 전달받은 값을 가지고 있음
    System.out.println("전달받은 값: " + value);
}
```

## 4. 메서드 오버로딩

### 4.1 오버로딩이란?
같은 이름의 메서드를 여러 개 정의하는 것. 단, **매개변수가 달라야 함**

```java
// 같은 이름 print, 다른 매개변수
static void print(int n) {
    System.out.println("정수: " + n);
}

static void print(double d) {
    System.out.println("실수: " + d);
}

static void print(String s) {
    System.out.println("문자열: " + s);
}

static void print(int a, int b) {
    System.out.println("두 정수: " + a + ", " + b);
}

// 사용
print(10);          // "정수: 10"
print(3.14);        // "실수: 3.14"
print("Hello");     // "문자열: Hello"
print(5, 7);        // "두 정수: 5, 7"
```

### 4.2 시그니처(Signature)
메서드를 구별하는 정보: **이름 + 매개변수 타입과 개수**

```java
// 시그니처가 다른 메서드들 (오버로딩 가능)
calculate(int)           // 시그니처: calculate(int)
calculate(double)        // 시그니처: calculate(double)
calculate(int, int)      // 시그니처: calculate(int, int)
calculate(double, int)   // 시그니처: calculate(double, int)
calculate(int, double)   // 시그니처: calculate(int, double)
```

### 4.3 오버로딩 규칙
```java
// ✅ 가능 - 매개변수가 다름
static int add(int a, int b) { return a + b; }
static double add(double a, double b) { return a + b; }

// ❌ 불가능 - 반환 타입만 다름 (시그니처가 같음)
static int getValue() { return 10; }
static double getValue() { return 3.14; }  // 오류!

// ✅ 실제 사용 예: System.out.println()
System.out.println(42);        // println(int)
System.out.println(3.14);      // println(double)
System.out.println("Hello");   // println(String)
System.out.println(true);      // println(boolean)
```

## 5. 서브루틴 작성 예제

### 5.1 약수 출력 메서드
```java
/**
 * N의 모든 약수를 출력합니다.
 * @param N 약수를 구할 양의 정수
 */
static void printDivisors(int N) {
    System.out.println(N + "의 약수:");

    for (int D = 1; D <= N; D++) {
        if (N % D == 0) {  // D가 N의 약수인가?
            System.out.println(D);
        }
    }
}

// 사용
printDivisors(12);  // 출력: 1, 2, 3, 4, 6, 12
```

### 5.2 문자 반복 출력 메서드
```java
/**
 * 지정된 문자를 N번 반복하여 한 줄로 출력합니다.
 * @param ch 출력할 문자
 * @param N 반복 횟수
 */
private static void printRow(char ch, int N) {
    for (int i = 0; i < N; i++) {
        System.out.print(ch);
    }
    System.out.println();  // 줄바꿈
}

// 사용
printRow('*', 10);    // **********
printRow('-', 20);    // --------------------
printRow('=', 5);     // =====
```

### 5.3 메서드를 사용하는 메서드
```java
/**
 * 문자열의 각 문자를 25번씩 반복하여 출력합니다.
 * @param str 출력할 문자열
 */
private static void printRowsFromString(String str) {
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        printRow(ch, 25);  // 위에서 정의한 printRow 사용
    }
}

// 사용
printRowsFromString("ABC");
// 출력:
// AAAAAAAAAAAAAAAAAAAAAAAAA
// BBBBBBBBBBBBBBBBBBBBBBBBB
// CCCCCCCCCCCCCCCCCCCCCCCCC
```

## 6. 배열 매개변수

### 6.1 배열을 매개변수로 전달
```java
/**
 * 정수 배열의 요소들을 출력합니다.
 * @param list 출력할 정수 배열
 */
static void printArray(int[] list) {
    System.out.print("[");
    for (int i = 0; i < list.length; i++) {
        if (i > 0) {
            System.out.print(", ");
        }
        System.out.print(list[i]);
    }
    System.out.println("]");
}

// 사용
int[] numbers = {10, 20, 30, 40, 50};
printArray(numbers);  // [10, 20, 30, 40, 50]
```

### 6.2 배열 처리 메서드들
```java
// 배열의 합계 계산
static int sum(int[] arr) {
    int total = 0;
    for (int value : arr) {
        total += value;
    }
    return total;
}

// 배열의 최대값 찾기
static int findMax(int[] arr) {
    if (arr.length == 0) {
        throw new IllegalArgumentException("빈 배열입니다");
    }

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

// 배열 뒤집기
static void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        // 두 요소 교환
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}
```

## 7. 명령줄 인수

### 7.1 main 메서드의 매개변수
```java
public static void main(String[] args) {
    // args는 명령줄 인수를 담은 String 배열
    System.out.println("인수 개수: " + args.length);

    for (int i = 0; i < args.length; i++) {
        System.out.println("args[" + i + "] = " + args[i]);
    }
}
```

### 7.2 명령줄 인수 사용 예
프로그램 실행:
```bash
java MyProgram hello world 123
```

결과:
```
인수 개수: 3
args[0] = hello
args[1] = world
args[2] = 123
```

### 7.3 파일 복사 프로그램 예제
```java
public class FileCopy {
    public static void main(String[] args) {
        // 인수 확인
        if (args.length != 2) {
            System.out.println("사용법: java FileCopy 원본파일 대상파일");
            return;
        }

        String sourceFile = args[0];
        String destFile = args[1];

        System.out.println(sourceFile + "을(를) " + destFile + "로 복사합니다.");
        // 실제 파일 복사 코드...
    }
}
```

## 8. 예외 발생시키기

### 8.1 매개변수 검증
```java
/**
 * 정수의 제곱근을 계산합니다.
 * @param n 음이 아닌 정수
 * @return n의 제곱근
 * @throws IllegalArgumentException n이 음수일 때
 */
static double squareRoot(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("음수의 제곱근은 계산할 수 없습니다: " + n);
    }
    return Math.sqrt(n);
}
```

### 8.2 예외 처리 예제
```java
static void print3NSequence(int startingValue) {
    // 매개변수 검증
    if (startingValue <= 0) {
        throw new IllegalArgumentException(
            "시작값은 양수여야 합니다. 입력값: " + startingValue
        );
    }

    // 정상적인 처리
    int N = startingValue;
    // ... 나머지 코드
}

// 사용
try {
    print3NSequence(-5);  // 예외 발생!
} catch (IllegalArgumentException e) {
    System.out.println("오류: " + e.getMessage());
}
```

## 9. 전역 변수와 지역 변수

### 9.1 변수의 종류
```java
public class VariableScope {
    // 전역 변수 (정적 멤버 변수)
    static int globalCount = 0;

    public static void method(int parameter) {  // parameter = 매개변수
        // 지역 변수
        int localVar = 10;

        // 모든 변수 사용 가능
        globalCount++;      // 전역 변수 사용
        parameter *= 2;     // 매개변수 사용
        localVar += 5;      // 지역 변수 사용
    }

    public static void main(String[] args) {
        method(5);
        System.out.println("globalCount = " + globalCount);  // 1
        // System.out.println(localVar);  // 오류! 지역 변수는 접근 불가
        // System.out.println(parameter); // 오류! 매개변수도 접근 불가
    }
}
```

### 9.2 변수 범위 비교
| 변수 종류 | 선언 위치     | 생명 주기        | 접근 범위     |
| --------- | ------------- | ---------------- | ------------- |
| 지역 변수 | 메서드 내부   | 메서드 실행 중   | 해당 메서드만 |
| 매개변수  | 메서드 선언부 | 메서드 실행 중   | 해당 메서드만 |
| 전역 변수 | 클래스 레벨   | 프로그램 실행 중 | 모든 메서드   |

### 9.3 전역 변수 사용 시 주의사항
```java
public class GameScore {
    static int totalScore = 0;  // 전역 변수

    // ⚠️ 전역 변수를 변경하는 메서드
    static void addScore(int points) {
        totalScore += points;  // 외부에 영향을 줌
    }

    // ✅ 매개변수로 받아서 반환하는 메서드 (더 나은 방법)
    static int calculateNewScore(int currentScore, int points) {
        return currentScore + points;  // 외부에 영향 없음
    }
}
```

## 요약

### 핵심 개념
- **매개변수**: 외부에서 메서드로 정보를 전달하는 방법
- **형식 vs 실제 매개변수**: 정의할 때 vs 호출할 때
- **오버로딩**: 같은 이름, 다른 매개변수
- **배열 매개변수**: 배열 전체를 전달 가능
- **예외 발생**: 잘못된 매개변수 처리

### 기억할 점
1. 매개변수는 메서드 시작 시 이미 값을 가짐
2. 시그니처 = 이름 + 매개변수 (반환타입 제외)
3. 배열도 매개변수로 전달 가능
4. 잘못된 매개변수는 예외로 처리
5. 전역 변수 사용은 신중하게

💡 **팁**: 매개변수를 통한 정보 전달이 전역 변수보다 명확하고 안전합니다!