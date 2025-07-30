# 4.3 매개변수 - 수업 실습

## 1. 매개변수 기본 실습

### 실습 1-1: 다양한 매개변수 타입 구현하기

#### 요구사항
- 다양한 타입의 매개변수를 사용하는 메서드 구현
- 기본 타입(int, double, boolean, char) 매개변수 처리
- 문자열과 배열 매개변수 처리
- 여러 개의 매개변수를 받는 메서드 구현

```java
public class ParameterTypes {
    public static void main(String[] args) {
        System.out.println("=== 매개변수 타입 예제 ===\n");

        // TODO 1: 기본 타입 매개변수 메서드들 호출하기

        // TODO 2: 문자열 매개변수 메서드 호출하기

        // TODO 3: 여러 매개변수 메서드 호출하기

        // TODO 4: 배열 매개변수 메서드 호출하기
        int[] numbers = {10, 20, 30, 40, 50};
    }

    // TODO 5: 정수를 출력하는 메서드 구현하기
    static void printNumber(int num) {

    }

    // TODO 6: 불린값을 출력하는 메서드 구현하기
    static void printBoolean(boolean value) {

    }

    // TODO 7: 문자를 출력하는 메서드 구현하기
    static void printCharacter(char ch) {

    }

    // TODO 8: 문자열을 출력하는 메서드 구현하기
    static void printMessage(String msg) {

    }

    // TODO 9: 개인 정보를 출력하는 메서드 구현하기
    static void printPersonInfo(String name, int age, double height) {

    }

    // TODO 10: 배열을 출력하는 메서드 구현하기
    static void printArray(int[] arr) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 매개변수 타입 예제 ===

정수: 42
불린값: true
문자: A
메시지: Hello Java!

=== 개인 정보 ===
이름: 김철수
나이: 25세
키: 175.5cm

배열 요소: 10 20 30 40 50
```

### 실습 1-2: 실제 매개변수의 다양한 형태

#### 요구사항
- 다양한 형태의 실제 매개변수 사용
- 리터럴 값, 변수, 표현식을 매개변수로 전달
- 메서드 반환값을 매개변수로 전달
- 복잡한 표현식을 매개변수로 전달

```java
public class ActualParameters {
    public static void main(String[] args) {
        System.out.println("=== 실제 매개변수 예제 ===\n");

        // TODO 11: 리터럴 값 전달하기

        // TODO 12: 변수 전달하기
        int x = 15;
        int y = 25;

        // TODO 13: 표현식 전달하기

        // TODO 14: 메서드 반환값 전달하기

        // TODO 15: 복잡한 표현식 전달하기
    }

    // TODO 16: calculate 메서드 구현하기
    static void calculate(int first, int second) {

    }

    // TODO 17: getNumber 메서드 구현하기
    static int getNumber() {

    }
}
```

#### 실행 결과 (참고용):
```
=== 실제 매개변수 예제 ===

10 + 20 = 30
10 - 20 = -10

15 + 25 = 40
15 - 25 = -10

20 + 50 = 70
20 - 50 = -30

20 + 2 = 22
20 - 2 = 18

42 + 52 = 94
42 - 52 = -10

20 + 30 = 50
20 - 30 = -10
```

## 2. 3N+1 시퀀스 실습

### 실습 2-1: 기본 3N+1 구현하기

#### 요구사항
- 3N+1 시퀀스 알고리즘 구현
- 짝수일 때: n/2, 홀수일 때: 3n+1
- 1에 도달할 때까지 시퀀스 출력
- 시퀀스 길이와 최대값 계산

```java
public class ThreeNPlusOne {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 시퀀스 프로그램 ===\n");

        // TODO 18: 예제 시퀀스 실행하기
        System.out.println("예제 시퀀스:");
        System.out.println();
        System.out.println();

        // TODO 19: 추가 정보 출력하기
        int start = 3;
        System.out.println("추가 정보:");
    }

    // TODO 20: 3N+1 시퀀스 출력 메서드 구현하기
    static void print3NSequence(int startingValue) {

    }

    // TODO 21: 시퀀스 길이 계산 메서드 구현하기
    static int getSequenceLength(int startingValue) {

    }

    // TODO 22: 시퀀스의 최대값 찾기 메서드 구현하기
    static int getMaxValue(int startingValue) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 3N+1 시퀀스 프로그램 ===

예제 시퀀스:
시작값 3의 3N+1 시퀀스:
3 → 10 → 5 → 16 → 8 → 4 → 2 → 1

시작값 7의 3N+1 시퀀스:
7 → 22 → 11 → 34 → 17 → 52 → 26 → 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

추가 정보:
시작값 3의 시퀀스 길이: 8
시작값 3의 최대값: 16
```

### 실습 2-2: 3N+1 통계 프로그램 만들기

#### 요구사항
- 범위 내의 모든 수에 대해 3N+1 시퀀스 분석
- 각 수의 시퀀스 길이와 최대값 출력
- 가장 긴 시퀀스를 가진 수 찾기
- 통계 정보를 표 형태로 출력

```java
public class ThreeNPlusOneStats {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 통계 분석 ===\n");

        // 범위 분석하기
        analyzeRange(1, 10);

        // 가장 긴 시퀀스 찾기
        findLongestSequence(1, 20);
    }

    // TODO 25: 범위 내 모든 수의 시퀀스 분석 메서드 구현하기
    static void analyzeRange(int start, int end) {

    }

    // TODO 26: 가장 긴 시퀀스 찾기 메서드 구현하기
    static void findLongestSequence(int start, int end) {

    }

    // TODO 27: 시퀀스 길이 계산 메서드 재구현하기
    static int getSequenceLength(int startingValue) {

    }

    // TODO 28: 최대값 계산 메서드 재구현하기
    static int getMaxValue(int startingValue) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 3N+1 통계 분석 ===

1부터 10까지의 시퀀스 길이:
시작값	길이	최대값
1	1	1
2	2	2
3	8	16
4	3	4
5	6	16
6	9	16
7	17	52
8	4	8
9	20	52
10	7	16

=== 가장 긴 시퀀스 ===
범위: 1 ~ 20
시작값: 18
길이: 21
```

## 3. 메서드 오버로딩 실습

### 실습 3-1: print 메서드 오버로딩하기

#### 요구사항
- 같은 이름의 메서드를 다양한 매개변수로 오버로딩
- 기본 타입(int, double, char, boolean) 출력 메서드
- 여러 개의 매개변수를 받는 출력 메서드
- 배열을 출력하는 메서드 (int[], String[])

```java
public class PrintOverloading {
    public static void main(String[] args) {
        System.out.println("=== print 메서드 오버로딩 ===\n");

        // TODO 29: 다양한 타입 출력 테스트하기

        // TODO 30: 여러 개 출력 테스트하기

        // TODO 31: 배열 출력 테스트하기
        int[] numbers = {5, 10, 15, 20};

        String[] words = {"Hello", "Java", "World"};
    }

    // TODO 32: 단일 값 출력 메서드들 구현하기
    static void print(int value) {

    }

    static void print(double value) {

    }

    static void print(String value) {

    }

    static void print(char value) {

    }

    static void print(boolean value) {

    }

    // TODO 33: 여러 값 출력 메서드들 구현하기
    static void print(int a, int b) {

    }

    static void print(String text, int number) {

    }

    static void print(int a, int b, int c) {

    }

    // TODO 34: 배열 출력 메서드들 구현하기
    static void print(int[] array) {

    }

    static void print(String[] array) {

    }
}
```

#### 실행 결과 (참고용):
```
=== print 메서드 오버로딩 ===

[정수] 42
[실수] 3.14159
[문자열] Hello World
[문자] X
[불린] true
[두 정수] 10, 20
[문자열과 정수] Java: 17
[세 정수] 1, 2, 3
[정수 배열] 5 10 15 20
[문자열 배열] Hello Java World
```

### 실습 3-2: 계산 메서드 오버로딩하기

#### 요구사항
- 계산기 메서드들을 다양한 매개변수로 오버로딩
- 두 수, 세 수의 합계 계산 (int, double)
- 배열의 합계 계산 (int[], double[])
- 평균 계산 메서드 오버로딩

```java
public class CalculatorOverloading {
    public static void main(String[] args) {
        System.out.println("=== 계산기 오버로딩 ===\n");

        // TODO 35: 두 수의 합 테스트하기

        // TODO 36: 세 수의 합 테스트하기

        // TODO 37: 배열의 합 테스트하기
        int[] intArray = {10, 20, 30, 40};
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};

        // TODO 38: 평균 계산 테스트하기
        System.out.println("\n평균 계산:");
    }

    // TODO 39: add 메서드들 구현하기
    static int add(int a, int b) {

    }

    static double add(double a, double b) {

    }

    static int add(int a, int b, int c) {

    }

    static double add(double a, double b, double c) {

    }

    static int add(int[] numbers) {

    }

    static double add(double[] numbers) {

    }

    // TODO 40: average 메서드들 구현하기
    static double average(int a, int b) {

    }

    static double average(int a, int b, int c) {

    }

    static double average(int[] numbers) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 계산기 오버로딩 ===

add(5, 3) = 8
add(5.5, 3.3) = 8.8
add(1, 2, 3) = 6
add(1.1, 2.2, 3.3) = 6.6
add(intArray) = 100
add(doubleArray) = 11.0

평균 계산:
average(80, 90) = 85.0
average(80, 90, 100) = 90.0
average(intArray) = 25.0
```

## 4. 배열 매개변수 실습

### 실습 4-1: 배열 처리 메서드 만들기

#### 요구사항
- 배열을 매개변수로 받아 다양한 처리를 하는 메서드들 구현
- 통계 계산: 합계, 평균, 최대값, 최소값, 범위
- 배열 조작: 2배 값, 특정 값 이상 필터링, 배열 복사
- 배열 정렬 기능

```java
public class ArrayParameters {
    public static void main(String[] args) {
        System.out.println("=== 배열 매개변수 예제 ===\n");

        int[] numbers = {15, 7, 23, 4, 18, 12, 9};

        // TODO 41: 배열 정보 출력하기
        System.out.print("원본 배열: ");

        // TODO 42: 통계 정보 출력하기
        System.out.println("\n=== 배열 통계 ===");

        // TODO 43: 배열 조작하기
        System.out.println("\n=== 배열 조작 ===");

        System.out.print("2배 값: ");

        System.out.print("10보다 큰 값: ");

        // 원본 배열 정렬
        System.out.print("정렬된 배열: ");

        // 원본은 변경되지 않음
        System.out.print("원본 배열: ");
    }

    // TODO 44: 배열 출력 메서드 구현하기
    static void printArray(int[] arr) {

    }

    // TODO 45: 통계 메서드들 구현하기
    static int sum(int[] arr) {

    }

    static double average(int[] arr) {

    }

    static int max(int[] arr) {

    }

    static int min(int[] arr) {

    }

    static int range(int[] arr) {

    }

    // TODO 46: 배열 조작 메서드들 구현하기
    static int[] doubleValues(int[] arr) {

    }

    static int[] filterGreaterThan(int[] arr, int threshold) {

    }

    static int[] copyArray(int[] arr) {

    }

    static void sortArray(int[] arr) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 배열 매개변수 예제 ===

원본 배열: [15, 7, 23, 4, 18, 12, 9]

=== 배열 통계 ===
합계: 88
평균: 12.571428571428571
최대값: 23
최소값: 4
범위: 19

=== 배열 조작 ===
2배 값: [30, 14, 46, 8, 36, 24, 18]
10보다 큰 값: [15, 23, 18, 12]
정렬된 배열: [4, 7, 9, 12, 15, 18, 23]
원본 배열: [15, 7, 23, 4, 18, 12, 9]
```

### 실습 4-2: 배열 검색과 수정하기

#### 요구사항
- 여러 배열을 함께 처리하고 검색/수정하는 메서드들 구현
- 학생 이름과 점수 배열 출력
- 이름으로 학생 검색, 특정 점수 이상 학생 찾기
- 점수 업데이트, 전체 가산점 부여

```java
public class ArraySearch {
    public static void main(String[] args) {
        System.out.println("=== 배열 검색과 수정 ===\n");

        String[] names = {"김철수", "이영희", "박민수", "최지우", "정민호"};
        int[] scores = {85, 92, 78, 95, 88};

        // TODO 47: 배열 출력하기
        System.out.println("학생 성적:");

        // TODO 48: 검색 예제 실행하기
        System.out.println("\n=== 검색 ===");
        String searchName = "박민수";

        // TODO 49: 특정 점수 이상 학생 찾기
        System.out.println("\n90점 이상 학생:");

        // TODO 50: 배열 수정하기
        System.out.println("\n=== 점수 수정 ===");
        System.out.println("수정 후:");

        // TODO 51: 전체 점수 조정하기
        System.out.println("\n=== 가산점 부여 ===");
        System.out.println("5점 가산 후:");
    }

    // TODO 52: 학생 정보 출력 메서드 구현하기
    static void printStudents(String[] names, int[] scores) {

    }

    // TODO 53: 학생 검색 메서드 구현하기
    static int findStudent(String[] names, String target) {

    }

    // TODO 54: 특정 점수 이상 학생들의 인덱스 찾기 메서드 구현하기
    static int[] findScoresAbove(int[] scores, int threshold) {

    }

    // TODO 55: 점수 업데이트 메서드 구현하기
    static void updateScore(String[] names, int[] scores, String name, int newScore) {

    }

    // TODO 56: 가산점 부여 메서드 구현하기
    static void addBonus(int[] scores, int bonus) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 배열 검색과 수정 ===

학생 성적:
김철수: 85점
이영희: 92점
박민수: 78점
최지우: 95점
정민호: 88점

=== 검색 ===
박민수의 점수: 78

90점 이상 학생:
이영희: 92점
최지우: 95점

=== 점수 수정 ===
박민수의 점수가 78에서 85로 변경되었습니다.
수정 후:
김철수: 85점
이영희: 92점
박민수: 85점
최지우: 95점
정민호: 88점

=== 가산점 부여 ===
5점 가산 후:
김철수: 90점
이영희: 97점
박민수: 90점
최지우: 100점
정민호: 93점
```

## 5. 명령줄 인수 실습

### 실습 5-1: 기본 명령줄 인수 처리하기

#### 요구사항
- 명령줄에서 전달받은 인수들을 처리하는 프로그램 구현
- 인수 개수 확인 및 출력
- 인수가 없는 경우 처리
- 인수 타입 변환 (String to int)

```java
public class CommandLineBasic {
    public static void main(String[] args) {
        System.out.println("=== 명령줄 인수 처리 ===\n");

        // TODO 57: 인수 개수 확인하고 출력하기

        // TODO 58: 인수가 없는 경우 처리하기

        // TODO 59: 모든 인수 출력하기
        System.out.println("\n전달받은 인수:");

        // TODO 60: 인수 타입 변환하기
    }
}
```

#### 실행 결과 (참고용):
```
// java CommandLineBasic Hello 10 20 World
=== 명령줄 인수 처리 ===

전달받은 인수 개수: 4

전달받은 인수:
args[0] = Hello
args[1] = 10
args[2] = 20
args[3] = World

첫 두 인수가 숫자가 아닙니다.

// java CommandLineBasic 15 25 30
첫 두 인수의 합: 40
```

### 실습 5-2: 명령줄 계산기 만들기

#### 요구사항
- 명령줄 인수로 계산을 수행하는 계산기 구현
- 인수 형식: 숫자1 연산자 숫자2
- 지원 연산: +, -, *, x, /, %, ^
- 예외 처리: 숫자 변환 오류, 0으로 나누기 오류

```java
public class CommandLineCalculator {
    public static void main(String[] args) {
        // TODO 61: 인수 개수 검증하기

        // TODO 62: 계산 수행하기
        try {

        } catch (NumberFormatException e) {
            System.out.println("오류: 숫자를 올바르게 입력하세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    // TODO 63: 계산 메서드 구현하기
    static double calculate(double a, String op, double b) {

    }

    // TODO 64: 사용법 출력 메서드 구현하기
    static void printUsage() {

    }
}
```

#### 실행 결과 (참고용):
```
// java CommandLineCalculator 10 + 5
10.0 + 5.0 = 15.0

// java CommandLineCalculator 3.14 x 2
3.14 x 2.0 = 6.28

// java CommandLineCalculator 2 ^ 10
2.0 ^ 10.0 = 1024.0

// java CommandLineCalculator 10 / 0
오류: 0으로 나눌 수 없습니다

사용법: java CommandLineCalculator 숫자1 연산자 숫자2
연산자: + - * x / % ^
예: java CommandLineCalculator 10 + 5
    java CommandLineCalculator 3.14 x 2
    java CommandLineCalculator 2 ^ 10
```

## 6. 예외 발생 실습

### 실습 6-1: 매개변수 검증하기

#### 요구사항
- 매개변수 값을 검증하고 적절한 예외를 발생시키는 메서드들 구현
- 나이 검증: 음수 및 비현실적 값 처리
- 점수 검증: 0~100 범위 확인
- 이름 검증: null, 빈 문자열 처리

```java
public class ParameterValidation {
    public static void main(String[] args) {
        System.out.println("=== 매개변수 검증 예제 ===\n");

        // TODO 65: 정상적인 호출 테스트하기
        try {

        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }

        System.out.println("\n=== 잘못된 매개변수 ===");

        // TODO 66: 잘못된 호출들 테스트하기
    }

    // TODO 67: 나이 검증 메서드 구현하기
    static int validateAge(int age) {

    }

    // TODO 68: 점수 검증 메서드 구현하기
    static int validateScore(int score) {

    }

    // TODO 69: 이름 검증 메서드 구현하기
    static String validateName(String name) {

    }

    // TODO 70: 잘못된 값 테스트 헬퍼 메서드들 구현하기
    static void testInvalidAge(int age) {
        try {

        } catch (IllegalArgumentException e) {
            System.out.println("나이 " + age + ": " + e.getMessage());
        }
    }

    static void testInvalidScore(int score) {

    }

    static void testInvalidName(String name) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 매개변수 검증 예제 ===

나이: 25
점수: 85
이름: 홍길동

=== 잘못된 매개변수 ===
나이 -5: 나이는 음수일 수 없습니다: -5
나이 150: 나이가 비현실적입니다: 150
점수 -10: 점수는 0~100 사이여야 합니다: -10
점수 105: 점수는 0~100 사이여야 합니다: 105
이름 : 이름이 비어있습니다
이름 null: 이름이 null입니다
```

### 실습 6-2: 배열 처리 시 예외 처리하기

#### 요구사항
- 배열 처리 중 발생할 수 있는 다양한 예외 상황 처리
- null 배열, 빈 배열 처리
- 배열 인덱스 범위 검사
- 0으로 나누기 예외 처리

```java
public class ArrayExceptions {
    public static void main(String[] args) {
        System.out.println("=== 배열 예외 처리 ===\n");

        // TODO 71: 정상적인 배열 처리하기
        int[] numbers = {10, 20, 30, 40, 50};

        // TODO 72: 빈 배열 처리하기
        int[] empty = {};
        try {

        } catch (IllegalArgumentException e) {
            System.out.println("빈 배열 오류: " + e.getMessage());
        }

        // TODO 73: null 배열 처리하기
        try {

        } catch (IllegalArgumentException e) {
            System.out.println("null 배열 오류: " + e.getMessage());
        }

        // TODO 74: 인덱스 범위 검사하기
        System.out.println("\n=== 인덱스 검사 ===");
        try {

        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 오류: " + e.getMessage());
        }

        // TODO 75: 배열 나누기 처리하기
        System.out.println("\n=== 배열 분할 ===");
        try {
            System.out.print("2로 나눈 결과: ");

        } catch (ArithmeticException e) {
            System.out.println("나누기 오류: " + e.getMessage());
        }
    }

    // TODO 76: 안전한 평균 계산 메서드 구현하기
    static double calculateAverage(int[] array) {

    }

    // TODO 77: 안전한 요소 접근 메서드 구현하기
    static int getElement(int[] array, int index) {

    }

    // TODO 78: 안전한 배열 나누기 메서드 구현하기
    static int[] divideArray(int[] array, int divisor) {

    }

    // TODO 79: 배열 출력 메서드 구현하기
    static void printArray(int[] array) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 배열 예외 처리 ===

정상 배열의 평균: 30.0
빈 배열 오류: 빈 배열의 평균은 계산할 수 없습니다
null 배열 오류: 배열이 null입니다

=== 인덱스 검사 ===
인덱스 2: 30
인덱스 오류: 인덱스가 범위를 벗어났습니다. 범위: 0~4, 요청된 인덱스: 10

=== 배열 분할 ===
2로 나눈 결과: 5 10 15 20 25
나누기 오류: 0으로 나눌 수 없습니다
```

## 7. 전역 변수와 지역 변수 실습

### 실습 7-1: 변수 범위 이해하기

#### 요구사항
- 전역 변수와 지역 변수의 차이점과 범위 이해
- 메서드 내부에서 전역 변수 접근 및 수정
- 지역 변수의 범위 테스트
- 매개변수와 지역 변수의 관계

```java
public class VariableScope {
    // TODO 80: 전역 변수들 선언하기

    public static void main(String[] args) {
        System.out.println("=== 변수 범위 예제 ===\n");

        // TODO 81: main의 지역 변수 선언하고 초기 상태 출력하기
        int localInMain = 100;

        System.out.println("main 시작:");

        // TODO 82: 메서드 호출하기

        System.out.println("\nmain 종료:");
    }

    // TODO 83: methodA 구현하기
    static void methodA() {

    }

    // TODO 84: methodB 구현하기
    static void methodB(int parameter) {

    }
}
```

#### 실행 결과 (참고용):
```
=== 변수 범위 예제 ===

main 시작:
globalCount = 0
localInMain = 100

methodA:
globalCount = 0
localInA = 200
내부 블록의 innerVar = 300

methodB:
parameter = 50
globalCount = 1
수정 후 parameter = 999
수정 후 globalCount = 11

main 종료:
globalCount = 11
localInMain = 100
```

### 실습 7-2: 전역 변수를 사용한 게임 점수 관리하기

#### 요구사항
- 전역 변수를 사용하여 게임 상태를 관리하는 프로그램 구현
- 플레이어와 컴퓨터의 점수 추적
- 5라운드 주사위 게임
- 최종 결과 및 승자 판정

```java
public class GameWithGlobalState {
    // TODO 85: 게임 상태 전역 변수들 선언하기

    public static void main(String[] args) {
        System.out.println("=== 주사위 게임 (전역 변수 사용) ===\n");

        // TODO 86: 게임 진행하기

        // TODO 87: 최종 결과 출력하기
    }

    // TODO 88: 한 라운드 플레이 메서드 구현하기
    static void playRound() {

    }

    // TODO 89: 주사위 굴리기 메서드 구현하기
    static int rollDice() {

    }

    // TODO 90: 현재 점수 출력 메서드 구현하기
    static void showCurrentScore() {

    }

    // TODO 91: 최종 결과 출력 메서드 구현하기
    static void showFinalResult() {

    }
}
```

#### 실행 결과 (참고용):
```
=== 주사위 게임 (전역 변수 사용) ===

=== 라운드 1 ===
플레이어: 4
컴퓨터: 2
플레이어 승리!
현재 점수 - 플레이어: 1, 컴퓨터: 0

=== 라운드 2 ===
플레이어: 3
컴퓨터: 5
컴퓨터 승리!
현재 점수 - 플레이어: 1, 컴퓨터: 1

... (라운드 3-5)

=== 최종 결과 ===
플레이어: 3승
컴퓨터: 2승
축하합니다! 당신이 이겼습니다!
```

### 실습 7-3: 전역 변수 vs 매개변수 방식 비교하기

#### 요구사항
- 전역 변수 방식과 매개변수 방식의 장단점 비교
- 은행 계좌 예제로 두 방식 구현
- 전역 변수의 부작용 시연
- 각 방식의 장단점 정리

```java
public class GlobalVsParameter {
    // TODO 92: 전역 변수 방식을 위한 변수 선언하기

    public static void main(String[] args) {
        System.out.println("=== 전역 변수 vs 매개변수 비교 ===\n");

        // TODO 93: 전역 변수 방식 테스트하기
        System.out.println("1. 전역 변수 방식:");

        // TODO 94: 매개변수 방식 테스트하기
        System.out.println("\n2. 매개변수 방식:");
        int balance = 1000;
        System.out.println("초기 잔액: " + balance);

        System.out.println("최종 잔액: " + balance);

        // TODO 95: 부작용 시연하기
        System.out.println("\n=== 비교 ===");
    }

    // TODO 96: 전역 변수 방식 메서드들 구현하기
    static void depositGlobal(int amount) {

    }

    static void withdrawGlobal(int amount) {

    }

    // TODO 97: 매개변수 방식 메서드들 구현하기
    static int depositParameter(int balance, int amount) {

    }

    static int withdrawParameter(int balance, int amount) {

    }

    // TODO 98: 부작용 시연 메서드들 구현하기
    static void demonstrateSideEffects() {

    }

    static void someComplexOperation() {

    }
}
```

#### 실행 결과 (참고용):
```
=== 전역 변수 vs 매개변수 비교 ===

1. 전역 변수 방식:
초기 잔액: 1000
500원 입금 (전역)
200원 출금 (전역)
최종 잔액: 1300

2. 매개변수 방식:
초기 잔액: 1000
500원 입금 (매개변수)
200원 출금 (매개변수)
최종 잔액: 1300

=== 비교 ===
전역 변수의 부작용 시연:
현재 전역 잔액: 1300
작업 후 전역 잔액: 1200
경고: 예상치 못한 잔액 변경 발생!
```

## 학습 포인트

### 1. 매개변수의 이해
- **다양한 타입**: 기본 타입, 문자열, 배열 등 다양한 매개변수 활용
- **실제 매개변수**: 리터럴, 변수, 표현식, 메서드 반환값 등 다양한 전달 방법
- **매개변수 검증**: 유효하지 않은 값에 대한 적절한 예외 처리

### 2. 메서드 오버로딩
- **같은 이름**: 매개변수 개수나 타입이 다르면 같은 이름 사용 가능
- **컴파일 시점 결정**: 호출 시 매개변수에 따라 적절한 메서드 선택
- **가독성 향상**: 유사한 기능을 하나의 이름으로 통일

### 3. 배열 매개변수
- **참조 전달**: 배열은 참조로 전달되어 원본 수정 가능
- **복사본 생성**: 원본 보호가 필요할 때는 복사본 생성
- **null 검사**: 배열 매개변수는 항상 null 검사 필요

### 4. 명령줄 인수
- **String 배열**: main 메서드의 args 매개변수 활용
- **타입 변환**: 문자열을 숫자로 변환할 때 예외 처리 필요
- **사용법 안내**: 잘못된 사용 시 명확한 안내 제공

### 5. 변수 범위
- **전역 변수**: 모든 메서드에서 접근 가능하지만 부작용 주의
- **지역 변수**: 선언된 블록 내에서만 접근 가능
- **매개변수**: 메서드의 지역 변수와 동일한 범위