# 4.4 반환값 - 수업 실습

## 1. 기본 반환 타입 실습

### 실습 1-1: 다양한 반환 타입 구현하기

#### 요구사항
- 다양한 데이터 타입을 반환하는 메서드 구현
- 기본 타입 반환: int, double, boolean, char
- 참조 타입 반환: String
- 각 타입에 맞는 적절한 계산 및 처리 로직 구현

```java
public class ReturnTypeExamples {
    public static void main(String[] args) {
        System.out.println("=== 다양한 반환 타입 예제 ===\n");
        
        // TODO 1: int 반환 메서드 테스트하기
        // int squareResult = square(5);
        // System.out.println("5의 제곱: " + squareResult);
        
        // TODO 2: double 반환 메서드 테스트하기
        // double avgResult = average(10, 20);
        // System.out.println("10과 20의 평균: " + avgResult);
        
        // TODO 3: boolean 반환 메서드 테스트하기
        // boolean evenCheck = isEven(7);
        // System.out.println("7은 짝수인가? " + evenCheck);
        
        // TODO 4: char 반환 메서드 테스트하기
        // char grade = getGrade(85);
        // System.out.println("85점의 학점: " + grade);
        
        // TODO 5: String 반환 메서드 테스트하기
        // String day = getDayName(3);
        // System.out.println("3번째 요일: " + day);
    }
    
    // TODO 6: int를 반환하는 함수 구현하기
    static int square(int n) {
        // n의 제곱 반환
    }
    
    // TODO 7: double을 반환하는 함수 구현하기
    static double average(int a, int b) {
        // 두 수의 평균 반환
    }
    
    // TODO 8: boolean을 반환하는 함수 구현하기
    static boolean isEven(int n) {
        // 짝수 여부 판단
    }
    
    // TODO 9: char를 반환하는 함수 구현하기
    static char getGrade(int score) {
        // 점수에 따른 학점 반환 (A~F)
    }
    
    // TODO 10: String을 반환하는 함수 구현하기
    static String getDayName(int dayNumber) {
        // 1~7을 요일명으로 변환
    }
}
```

#### 실행 결과 (참고용):
```
=== 다양한 반환 타입 예제 ===

5의 제곱: 25
10과 20의 평균: 15.0
7은 짝수인가? false
85점의 학점: B
3번째 요일: 수요일
```

### 실습 1-2: 함수 반환값 활용하기

#### 요구사항
- 반환값을 다양한 방식으로 활용하는 방법 익히기
- 반환값을 변수에 저장하여 사용
- 반환값을 표현식에서 직접 사용
- 반환값을 다른 함수의 매개변수로 전달

```java
public class UsingReturnValues {
    public static void main(String[] args) {
        System.out.println("=== 반환값 활용 예제 ===\n");
        
        // TODO 11: 변수에 저장하여 사용하기
        // int result = add(10, 20);
        // System.out.println("저장된 결과: " + result);
        
        // TODO 12: 직접 출력하기
        // System.out.println("직접 출력: " + add(30, 40));
        
        // TODO 13: 표현식에서 사용하기
        // int total = 100 + add(50, 60);
        // System.out.println("표현식 결과: " + total);
        
        // TODO 14: 조건문에서 사용하기
        // if (add(25, 25) > 40) {
        //     System.out.println("25 + 25는 40보다 큽니다.");
        // }
        
        // TODO 15: 다른 함수의 인자로 사용하기
        // int doubled = multiply(add(5, 7), 2);
        // System.out.println("(5 + 7) × 2 = " + doubled);
        
        // TODO 16: 반복문에서 사용하기
        // System.out.print("카운트다운: ");
        // for (int i = countdown(5); i > 0; i = countdown(i)) {
        //     System.out.print(i + " ");
        // }
        // System.out.println("발사!");
    }
    
    // TODO 17: 덧셈 메서드 구현하기
    static int add(int a, int b) {
        
    }
    
    // TODO 18: 곱셈 메서드 구현하기
    static int multiply(int a, int b) {
        
    }
    
    // TODO 19: 카운트다운 메서드 구현하기
    static int countdown(int n) {
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 반환값 활용 예제 ===

저장된 결과: 30
직접 출력: 70
표현식 결과: 210
25 + 25는 40보다 큽니다.
(5 + 7) × 2 = 24
카운트다운: 5 4 3 2 1 발사!
```

## 2. 수학 함수 실습

### 실습 2-1: 기본 수학 함수 구현하기

#### 요구사항
- 다양한 수학 연산을 수행하는 함수들 구현
- 기본 연산: 절댓값, 최대값, 최소값
- 고급 연산: 거듭제곱, 팩토리얼
- 수론 함수: 최대공약수, 최소공배수

```java
public class MathFunctions {
    public static void main(String[] args) {
        System.out.println("=== 수학 함수 예제 ===\n");
        
        // TODO 20: 절댓값 함수 테스트하기
        // System.out.println("|-5| = " + abs(-5));
        // System.out.println("|3| = " + abs(3));
        
        // TODO 21: 최대값, 최소값 함수 테스트하기
        // System.out.println("max(10, 7) = " + max(10, 7));
        // System.out.println("min(10, 7) = " + min(10, 7));
        
        // TODO 22: 거듭제곱 함수 테스트하기
        // System.out.println("2^10 = " + power(2, 10));
        // System.out.println("3^4 = " + power(3, 4));
        
        // TODO 23: 팩토리얼 함수 테스트하기
        // System.out.println("5! = " + factorial(5));
        // System.out.println("0! = " + factorial(0));
        
        // TODO 24: 최대공약수 함수 테스트하기
        // System.out.println("gcd(48, 18) = " + gcd(48, 18));
        
        // TODO 25: 최소공배수 함수 테스트하기
        // System.out.println("lcm(12, 18) = " + lcm(12, 18));
    }
    
    // TODO 26: 절댓값 함수 구현하기
    static int abs(int n) {
        
    }
    
    // TODO 27: 최대값 함수 구현하기
    static int max(int a, int b) {
        
    }
    
    // TODO 28: 최소값 함수 구현하기
    static int min(int a, int b) {
        
    }
    
    // TODO 29: 거듭제곱 함수 구현하기
    static int power(int base, int exponent) {
        // base^exponent 계산
    }
    
    // TODO 30: 팩토리얼 함수 구현하기
    static int factorial(int n) {
        // n! 계산
    }
    
    // TODO 31: 최대공약수 함수 구현하기
    static int gcd(int a, int b) {
        // 최대공약수 계산
    }
    
    // TODO 32: 최소공배수 함수 구현하기
    static int lcm(int a, int b) {
        // 최소공배수 계산
    }
}
```

#### 실행 결과 (참고용):
```
=== 수학 함수 예제 ===

|-5| = 5
|3| = 3
max(10, 7) = 10
min(10, 7) = 7
2^10 = 1024
3^4 = 81
5! = 120
0! = 1
gcd(48, 18) = 6
lcm(12, 18) = 36
```

### 실습 2-2: 기하학 함수 구현하기

#### 요구사항
- 기하학 계산을 수행하는 함수들 구현
- 피타고라스 정리를 이용한 빗변 계산
- 원의 면적과 둘레 계산
- 헤론의 공식을 이용한 삼각형 면적 계산
- 두 점 사이의 거리 계산

```java
public class GeometryFunctions {
    public static void main(String[] args) {
        System.out.println("=== 기하학 함수 예제 ===\n");
        
        // TODO 33: 피타고라스 정리 테스트하기
        // double c = pythagoras(3, 4);
        // System.out.println("직각삼각형 (3, 4)의 빗변: " + c);
        
        // TODO 34: 원의 면적과 둘레 테스트하기
        // double radius = 5;
        // System.out.println("\n반지름 " + radius + "인 원:");
        // System.out.println("면적: " + circleArea(radius));
        // System.out.println("둘레: " + circlePerimeter(radius));
        
        // TODO 35: 삼각형 면적 테스트하기
        // double area = triangleArea(3, 4, 5);
        // System.out.println("\n변의 길이가 3, 4, 5인 삼각형의 면적: " + area);
        
        // TODO 36: 두 점 사이의 거리 테스트하기
        // double distance = distanceBetweenPoints(0, 0, 3, 4);
        // System.out.println("\n(0,0)과 (3,4) 사이의 거리: " + distance);
    }
    
    // TODO 37: 피타고라스 정리 함수 구현하기
    static double pythagoras(double a, double b) {
        // 빗변 길이 계산
    }
    
    // TODO 38: 원의 면적 함수 구현하기
    static double circleArea(double radius) {
        // 원의 면적 계산
    }
    
    // TODO 39: 원의 둘레 함수 구현하기
    static double circlePerimeter(double radius) {
        // 원의 둘레 계산
    }
    
    // TODO 40: 삼각형 면적 함수 구현하기
    static double triangleArea(double a, double b, double c) {
        // 세 변의 길이로 면적 계산
    }
    
    // TODO 41: 두 점 사이의 거리 함수 구현하기
    static double distanceBetweenPoints(double x1, double y1, double x2, double y2) {
        // 두 점 사이의 거리 계산
    }
}
```

#### 실행 결과 (참고용):
```
=== 기하학 함수 예제 ===

직각삼각형 (3, 4)의 빗변: 5.0

반지름 5.0인 원:
면적: 78.53981633974483
둘레: 31.41592653589793

변의 길이가 3, 4, 5인 삼각형의 면적: 6.0

(0,0)과 (3,4) 사이의 거리: 5.0
```

## 3. 문자열 처리 실습

### 실습 3-1: 문자열 분석 함수 구현하기

#### 요구사항
- 문자열을 분석하는 다양한 함수들 구현
- 문자열 길이, 모음/자음 개수 계산
- 숫자와 공백 개수 계산
- 단어 개수 계산 및 회문 검사
```java
public class StringAnalysis {
    public static void main(String[] args) {
        System.out.println("=== 문자열 분석 함수 ===\n");
        
        String text = "Hello World 2024!";
        
        // TODO 42: 문자열 분석 테스트하기
        // System.out.println("텍스트: \"" + text + "\"");
        // System.out.println("길이: " + length(text));
        // System.out.println("모음 개수: " + countVowels(text));
        // System.out.println("자음 개수: " + countConsonants(text));
        // System.out.println("숫자 개수: " + countDigits(text));
        // System.out.println("공백 개수: " + countSpaces(text));
        // System.out.println("단어 개수: " + countWords(text));
        
        // TODO 43: 회문 검사 테스트하기
        // String[] palindromes = {"radar", "hello", "level", "noon"};
        // System.out.println("\n=== 회문 검사 ===");
        // for (String word : palindromes) {
        //     System.out.println(word + " → " + 
        //         (isPalindrome(word) ? "회문입니다" : "회문이 아닙니다"));
        // }
    }
    
    // TODO 44: 문자열 길이 함수 구현하기
    static int length(String str) {
        // 길이 계산
    }
    
    // TODO 45: 모음 개수 함수 구현하기
    static int countVowels(String str) {
        // 모음 개수 세기
    }
    
    // TODO 46: 자음 개수 함수 구현하기
    static int countConsonants(String str) {
        // 자음 개수 세기
    }
    
    // TODO 47: 숫자 개수 함수 구현하기
    static int countDigits(String str) {
        // 숫자 개수 세기
    }
    
    // TODO 48: 공백 개수 함수 구현하기
    static int countSpaces(String str) {
        // 공백 개수 세기
    }
    
    // TODO 49: 단어 개수 함수 구현하기
    static int countWords(String str) {
        // 단어 개수 세기
    }
    
    // TODO 50: 회문 검사 함수 구현하기
    static boolean isPalindrome(String word) {
        // 회문 여부 판단
    }
    
    // TODO 51: 문자열 뒤집기 함수 구현하기
    static String reverse(String str) {
        // 문자열 뒤집기
    }
}
```

#### 실행 결과 (참고용):
```
=== 문자열 분석 함수 ===

텍스트: "Hello World 2024!"
길이: 18
모음 개수: 3
자음 개수: 7
숫자 개수: 4
공백 개수: 2
단어 개수: 3

=== 회문 검사 ===
radar → 회문입니다
hello → 회문이 아닙니다
level → 회문입니다
noon → 회문입니다
```

### 실습 3-2: 문자열 변환 함수 구현하기

#### 요구사항
- 문자열을 변환하는 다양한 함수들 구현
- 대소문자 변환 및 대소문자 반전
- 특정 문자 제거 및 추출
- 문자열 반복 기능
```java
public class StringTransformation {
    public static void main(String[] args) {
        System.out.println("=== 문자열 변환 함수 ===\n");
        
        // TODO 52: 대소문자 변환 테스트하기
        String text = "Hello World!";
        // System.out.println("원본: " + text);
        // System.out.println("대문자: " + toUpperCase(text));
        // System.out.println("소문자: " + toLowerCase(text));
        // System.out.println("대소문자 반전: " + swapCase(text));
        
        // TODO 53: 문자 제거/치환 테스트하기
        // System.out.println("\n=== 문자 처리 ===");
        // System.out.println("모음 제거: " + removeVowels("Hello World"));
        // System.out.println("공백 제거: " + removeSpaces("Hello World"));
        // System.out.println("숫자만 추출: " + extractDigits("abc123def456"));
        
        // TODO 54: 문자열 반복 테스트하기
        // System.out.println("\n=== 문자열 반복 ===");
        // System.out.println("repeat(\"Hi\", 3): " + repeat("Hi", 3));
        // System.out.println("repeat(\"*\", 10): " + repeat("*", 10));
    }
    
    // TODO 55: 대문자로 변환 함수 구현하기
    static String toUpperCase(String str) {
        // 대문자 변환
    }
    
    // TODO 56: 소문자로 변환 함수 구현하기
    static String toLowerCase(String str) {
        // 소문자 변환
    }
    
    // TODO 57: 대소문자 반전 함수 구현하기
    static String swapCase(String str) {
        // 대소문자 바꾸기
    }
    
    // TODO 58: 모음 제거 함수 구현하기
    static String removeVowels(String str) {
        // 모음 제거
    }
    
    // TODO 59: 공백 제거 함수 구현하기
    static String removeSpaces(String str) {
        // 공백 제거
    }
    
    // TODO 60: 숫자만 추출 함수 구현하기
    static String extractDigits(String str) {
        // 숫자만 추출
    }
    
    // TODO 61: 문자열 반복 함수 구현하기
    static String repeat(String str, int times) {
        // 문자열 반복
    }
}
```

#### 실행 결과 (참고용):
```
=== 문자열 변환 함수 ===

원본: Hello World!
대문자: HELLO WORLD!
소문자: hello world!
대소문자 반전: hELLO wORLD!

=== 문자 처리 ===
모음 제거: Hll Wrld
공백 제거: HelloWorld
숫자만 추출: 123456

=== 문자열 반복 ===
repeat("Hi", 3): HiHiHi
repeat("*", 10): **********
```

## 4. 소수와 수론 실습

### 실습 4-1: 소수 관련 함수 구현하기

#### 요구사항
- 소수를 처리하는 다양한 함수들 구현
- 소수 판별 함수 (효율적인 알고리즘 사용)
- n번째 소수 찾기 및 범위 내 소수 개수 계산
- 쌍둥이 소수 찾기

```java
public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println("=== 소수 관련 함수 ===\n");
        
        // TODO 62: 소수 판별 테스트하기
        // System.out.println("1~20까지의 소수:");
        // for (int i = 1; i <= 20; i++) {
        //     if (isPrime(i)) {
        //         System.out.print(i + " ");
        //     }
        // }
        // System.out.println("\n");
        
        // TODO 63: n번째 소수 찾기 테스트하기
        // System.out.println("처음 10개의 소수:");
        // for (int i = 1; i <= 10; i++) {
        //     System.out.print(nthPrime(i) + " ");
        // }
        // System.out.println("\n");
        
        // TODO 64: 소수 개수 세기 테스트하기
        // int limit = 100;
        // System.out.println("1~" + limit + " 사이의 소수 개수: " + 
        //                   countPrimes(limit));
        
        // TODO 65: 쌍둥이 소수 찾기 테스트하기
        // System.out.println("\n100 이하의 쌍둥이 소수:");
        // findTwinPrimes(100);
    }
    
    // TODO 66: 소수 판별 함수 구현하기
    static boolean isPrime(int n) {
        // 소수 여부 판단
    }
    
    // TODO 67: n번째 소수 구하기 함수 구현하기
    static int nthPrime(int n) {
        // n번째 소수 찾기
    }
    
    // TODO 68: 범위 내 소수 개수 함수 구현하기
    static int countPrimes(int limit) {
        // 소수 개수 세기
    }
    
    // TODO 69: 쌍둥이 소수 찾기 함수 구현하기
    static void findTwinPrimes(int limit) {
        // 차이가 2인 소수 쌍 찾기
    }
}
```

#### 실행 결과 (참고용):
```
=== 소수 관련 함수 ===

1~20까지의 소수:
2 3 5 7 11 13 17 19 

처음 10개의 소수:
2 3 5 7 11 13 17 19 23 29 

1~100 사이의 소수 개수: 25

100 이하의 쌍둥이 소수:
(3, 5)
(5, 7)
(11, 13)
(17, 19)
(29, 31)
(41, 43)
(59, 61)
(71, 73)
```

### 실습 4-2: 수론 함수 구현하기

#### 요구사항
- 수론과 관련된 다양한 함수들 구현
- 약수 개수와 약수 합 계산
- 완전수 판별 함수
- 친화수 찾기 함수

```java
public class NumberTheory {
    public static void main(String[] args) {
        System.out.println("=== 수론 함수 ===\n");
        
        // TODO 70: 약수 관련 테스트하기
        int n = 24;
        // System.out.println(n + "의 약수 개수: " + countDivisors(n));
        // System.out.println(n + "의 약수 합: " + sumDivisors(n));
        // System.out.print(n + "의 모든 약수: ");
        // printDivisors(n);
        // System.out.println("\n");
        
        // TODO 71: 완전수 판별 테스트하기
        // System.out.println("1~30 사이의 완전수:");
        // for (int i = 1; i <= 30; i++) {
        //     if (isPerfectNumber(i)) {
        //         System.out.println(i + " (약수: " + getDivisorList(i) + ")");
        //     }
        // }
        
        // TODO 72: 친화수 찾기 테스트하기
        // System.out.println("\n1000 이하의 친화수:");
        // findAmicableNumbers(1000);
    }
    
    // TODO 73: 약수 개수 함수 구현하기
    static int countDivisors(int n) {
        // 약수 개수 세기
    }
    
    // TODO 74: 약수 합 함수 구현하기
    static int sumDivisors(int n) {
        // 약수의 합 계산
    }
    
    // TODO 75: 약수 출력 함수 구현하기
    static void printDivisors(int n) {
        // 약수 출력
    }
    
    // TODO 76: 완전수 판별 함수 구현하기
    static boolean isPerfectNumber(int n) {
        // 완전수 여부 판단
    }
}
```

#### 실행 결과 (참고용):
```
=== 수론 함수 ===

24의 약수 개수: 8
24의 약수 합: 60
24의 모든 약수: 1 2 3 4 6 8 12 24 

1~30 사이의 완전수:
6 (약수: 1+2+3)
28 (약수: 1+2+4+7+14)

1000 이하의 친화수:
220와 284
```

## 5. 추가 실습 과제

### 실습 5-1: 3N+1 시퀀스 기본 함수 구현하기

#### 요구사항
- 유명한 3N+1 시퀀스를 처리하는 함수들 구현
- 다음 항 계산 함수 (홀수: 3n+1, 짝수: n/2)
- 시퀀스 길이와 최대값 계산
- 시퀀스 출력 함수

```java
public class ThreeNPlusOneFunctions {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 시퀀스 함수 ===\n");
        
        // TODO 77: 3N+1 기본 테스트하기
        int start = 27;
        // System.out.println("시작값: " + start);
        // System.out.println("다음 항: " + nextN(start));
        // System.out.println("시퀀스 길이: " + sequenceLength(start));
        // System.out.println("최대값: " + maxInSequence(start));
        
        // TODO 78: 시퀀스 출력 테스트하기
        // System.out.print("\n시퀀스: ");
        // printSequence(start);
    }
    
    // TODO 79: 3N+1 다음 항 계산 함수 구현하기
    static int nextN(int n) {
        // 다음 항 계산
    }
    
    // TODO 80: 시퀀스 길이 계산 함수 구현하기
    static int sequenceLength(int start) {
        // 1까지의 단계 수 계산
    }
    
    // TODO 81: 시퀀스의 최대값 찾기 함수 구현하기
    static int maxInSequence(int start) {
        // 최대값 찾기
    }
    
    // TODO 82: 시퀀스 출력 함수 구현하기
    static void printSequence(int start) {
        // 시퀀스 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 3N+1 시퀀스 함수 ===

시작값: 27
다음 항: 82
시퀀스 길이: 112
최대값: 9232

시퀀스: 27 → 82 → 41 → 124 → 62 → 31 → 94 → 47 → 142 → 71 → 214 → 107 → 322 → 161 → 484 → 242 → 121 → 364 → 182 → 91 → 274 → 137 → 412 → 206 → 103 → 310 → 155 → 466 → 233 → 700 → 350 → 175 → 526 → 263 → 790 → 395 → 1186 → 593 → 1780 → 890 → 445 → 1336 → 668 → 334 → 167 → 502 → 251 → 754 → 377 → 1132 → 566 → 283 → 850 → 425 → 1276 → 638 → 319 → 958 → 479 → 1438 → 719 → 2158 → 1079 → 3238 → 1619 → 4858 → 2429 → 7288 → 3644 → 1822 → 911 → 2734 → 1367 → 4102 → 2051 → 6154 → 3077 → 9232 → 4616 → 2308 → 1154 → 577 → 1732 → 866 → 433 → 1300 → 650 → 325 → 976 → 488 → 244 → 122 → 61 → 184 → 92 → 46 → 23 → 70 → 35 → 106 → 53 → 160 → 80 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```
```

## 6. void 메서드에서의 return 실습

### 실습 6-1: 조건부 종료 구현하기

#### 요구사항
- void 메서드에서 return을 사용하여 조기 종료하는 방법 익히기
- 음수 입력 시 처리 중단
- 배열에서 값을 찾으면 즉시 종료
- 유효성 검사 실패 시 조기 종료
```java
public class VoidReturn {
    public static void main(String[] args) {
        System.out.println("=== void 메서드의 return ===\n");
        
        // TODO 83: 음수 처리 테스트하기
        // processPositiveOnly(10);
        // processPositiveOnly(-5);
        // processPositiveOnly(20);
        
        // TODO 84: 배열 검색 테스트하기
        // int[] numbers = {10, 20, 30, 40, 50};
        // searchAndPrint(numbers, 30);
        // searchAndPrint(numbers, 25);
        
        // TODO 85: 유효성 검사 테스트하기
        // validateAndProcess("user@email.com");
        // validateAndProcess("invalid-email");
    }
    
    // TODO 86: 양수만 처리 함수 구현하기
    static void processPositiveOnly(int n) {
        // 음수 처리
    }
    
    // TODO 87: 배열에서 값 찾기 함수 구현하기
    static void searchAndPrint(int[] array, int target) {
        // 배열 검색
    }
    
    // TODO 88: 유효성 검사 함수 구현하기
    static void validateAndProcess(String email) {
        // 이메일 유효성 검사
    }
}
```

#### 실행 결과 (참고용):
```
=== void 메서드의 return ===

10을(를) 처리합니다...
결과: 20
-5은(는) 음수입니다. 처리하지 않습니다.
20을(를) 처리합니다...
결과: 40

30 찾기: 인덱스 2에서 발견!
25 찾기: 찾을 수 없습니다.

이메일 처리: user@email.com 처리 완료!
이메일 처리: 잘못된 이메일 형식입니다.
```

## 학습 포인트

### 1. 반환값의 다양성
- **기본 타입**: int, double, boolean, char
- **참조 타입**: String, 배열
- **사용 방법**: 변수 저장, 직접 사용, 표현식 내 사용

### 2. 수학 함수
- **기본 연산**: 절댓값, 최대/최소값, 거듭제곱, 팩토리얼
- **고급 연산**: 최대공약수, 최소공배수
- **기하학**: 피타고라스 정리, 원의 면적/둘레

### 3. 문자열 처리
- **분석**: 길이, 모음/자음/숫자 개수
- **변환**: 대소문자 변환, 문자 제거/추출
- **고급**: 회문 검사, 문자열 뒤집기

### 4. void 메서드의 return
- **조기 종료**: 조건에 따른 함수 종료
- **중첩 루프**: 여러 루프를 한 번에 종료
- **유효성 검사**: 잘못된 입력 처리

이 실습을 통해 다양한 형태의 반환값을 다루고, 실용적인 함수들을 구현해보세요!
```

## 7. 배열을 반환하는 함수

### 예제 7-1: 배열 생성 함수
```java
public class ArrayReturning {
    public static void main(String[] args) {
        System.out.println("=== 배열 반환 함수 ===\n");
        
        // 범위 배열 생성
        int[] range = createRange(5, 10);
        System.out.print("createRange(5, 10): ");
        printArray(range);
        
        // 피보나치 배열
        int[] fib = fibonacciArray(10);
        System.out.print("피보나치 수열 (10개): ");
        printArray(fib);
        
        // 소수 배열
        int[] primes = firstNPrimes(10);
        System.out.print("처음 10개의 소수: ");
        printArray(primes);
        
        // 배열 필터링
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = filterEven(numbers);
        System.out.print("짝수만: ");
        printArray(evens);
    }
    
    // 범위 배열 생성
    static int[] createRange(int start, int end) {
        int size = end - start + 1;
        int[] result = new int[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = start + i;
        }
        return result;
    }
    
    // 피보나치 배열
    static int[] fibonacciArray(int n) {
        if (n <= 0) return new int[0];
        
        int[] fib = new int[n];
        if (n >= 1) fib[0] = 1;
        if (n >= 2) fib[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }
    
    // 처음 n개의 소수
    static int[] firstNPrimes(int n) {
        int[] primes = new int[n];
        int count = 0;
        int num = 2;
        
        while (count < n) {
            if (isPrime(num)) {
                primes[count] = num;
                count++;
            }
            num++;
        }
        return primes;
    }
    
    // 소수 판별
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // 짝수만 필터링
    static int[] filterEven(int[] array) {
        // 먼저 짝수 개수 세기
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) count++;
        }
        
        // 짝수만 담을 배열 생성
        int[] result = new int[count];
        int index = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        return result;
    }
    
    // 배열 출력
    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
```

이 예제들은 반환값의 다양한 측면을 보여줍니다:

1. **기본 반환 타입** - int, double, boolean, char, String
2. **수학 함수** - 기본 연산, 기하학, 수론
3. **문자열 처리** - 분석, 변환, 조작
4. **소수와 수론** - 판별, 생성, 분석
5. **3N+1 시퀀스** - 계산, 분석, 통계
6. **void 메서드의 return** - 조건부 종료, 조기 반환
7. **배열 반환** - 동적 생성, 필터링, 변환

각 예제는 실습 가능한 완전한 프로그램으로 구성되어 있습니다.