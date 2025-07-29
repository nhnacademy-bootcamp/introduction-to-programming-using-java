# 3.4 for 문 - 예제 모음

## 1. 기본 for 루프 예제

### 예제 1-1: 숫자 출력
```java
public class BasicForLoop {
    public static void main(String[] args) {
        // TODO: 1부터 10까지 출력
        // 힌트:
        // 1. "1부터 10까지:" 출력
        // 2. for 루프로 i를 1부터 10까지 반복
        // 3. i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 0부터 9까지 출력 (프로그래머 스타일)
        // 힌트:
        // 1. "\n0부터 9까지:" 출력
        // 2. for 루프로 i를 0부터 9까지 반복 (i < 10)
        // 3. i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 10부터 1까지 역순
        // 힌트:
        // 1. "\n10부터 1까지:" 출력
        // 2. for 루프로 i를 10부터 1까지 감소시키며 반복
        // 3. i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
1부터 10까지:
1 2 3 4 5 6 7 8 9 10 

0부터 9까지:
0 1 2 3 4 5 6 7 8 9 

10부터 1까지:
10 9 8 7 6 5 4 3 2 1 
```

### 예제 1-2: 다양한 증가값
```java
public class ForLoopIncrements {
    public static void main(String[] args) {
        // TODO: 짝수 출력
        // 힌트:
        // 1. "0부터 20까지 짝수:" 출력
        // 2. for 루프로 i를 0부터 20까지 2씩 증가 (i += 2)
        // 3. i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 홀수 출력
        // 힌트:
        // 1. "\n1부터 20까지 홀수:" 출력
        // 2. for 루프로 i를 1부터 20까지 2씩 증가
        // 3. i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 5의 배수
        // 힌트:
        // 1. "\n5의 배수 (5부터 50까지):" 출력
        // 2. for 루프로 i를 5부터 50까지 5씩 증가
        // 3. i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 제곱수
        // 힌트:
        // 1. "\n제곱수:" 출력
        // 2. for 루프로 i를 1부터 10까지 반복
        // 3. i * i와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
0부터 20까지 짝수:
0 2 4 6 8 10 12 14 16 18 20 

1부터 20까지 홀수:
1 3 5 7 9 11 13 15 17 19 

5의 배수 (5부터 50까지):
5 10 15 20 25 30 35 40 45 50 

제곱수:
1 4 9 16 25 36 49 64 81 100 
```

## 2. while 루프를 for 루프로 변환

### 예제 2-1: 이자 계산
```java
public class InterestCalculation {
    public static void main(String[] args) {
        double principal = 1000.0;  // 원금
        double rate = 0.05;         // 이자율 5%
        
        System.out.println("=== while 루프 버전 ===");
        double balance1 = principal;
        int year1 = 0;
        while (year1 < 5) {
            double interest = balance1 * rate;
            balance1 += interest;
            year1++;
            System.out.printf("%d년 후: $%.2f%n", year1, balance1);
        }
        
        System.out.println("\n=== for 루프 버전 ===");
        double balance2 = principal;
        
        // TODO: for 루프로 이자 계산
        // 힌트:
        // 1. year2를 1부터 5까지 반복
        // 2. 각 년도마다:
        //    - interest = balance2 * rate
        //    - balance2에 interest를 더하기
        //    - 결과 출력 (printf 사용)
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== while 루프 버전 ===
1년 후: $1050.00
2년 후: $1102.50
3년 후: $1157.63
4년 후: $1215.51
5년 후: $1276.28

=== for 루프 버전 ===
1년 후: $1050.00
2년 후: $1102.50
3년 후: $1157.63
4년 후: $1215.51
5년 후: $1276.28
```

### 예제 2-2: 팩토리얼 계산
```java
public class FactorialComparison {
    public static void main(String[] args) {
        int n = 5;
        
        // while 루프 버전
        int factorial1 = 1;
        int i = 1;
        while (i <= n) {
            factorial1 *= i;
            i++;
        }
        System.out.println("while 루프: " + n + "! = " + factorial1);
        
        // TODO: for 루프 버전
        // 힌트:
        // 1. factorial2를 1로 초기화
        // 2. j를 1부터 n까지 반복
        // 3. factorial2에 j를 곱하기
        
        // 여기에 코드를 작성하세요
        
        // TODO: 계산 과정 보여주기
        // 힌트:
        // 1. "계산 과정: 5! = " 출력
        // 2. k를 1부터 n까지 반복하며:
        //    - k 출력
        //    - k < n이면 " × " 출력
        // 3. 마지막에 " = " + factorial2 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
while 루프: 5! = 120
for 루프: 5! = 120

계산 과정: 5! = 1 × 2 × 3 × 4 × 5 = 120
```

## 3. 문자와 문자열 처리

### 예제 3-1: 알파벳 출력
```java
public class AlphabetLoop {
    public static void main(String[] args) {
        // TODO: 대문자 알파벳
        // 힌트:
        // 1. "대문자 알파벳:" 출력
        // 2. for 루프로 ch를 'A'부터 'Z'까지 반복
        // 3. ch와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 소문자 알파벳
        // 힌트:
        // 1. "\n소문자 알파벳:" 출력
        // 2. for 루프로 ch를 'a'부터 'z'까지 반복
        // 3. ch와 공백 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // TODO: 알파벳과 ASCII 코드
        // 힌트:
        // 1. "\n알파벳과 ASCII 코드:" 출력
        // 2. for 루프로 ch를 'A'부터 'F'까지 반복
        // 3. ch + " = " + (int)ch 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
대문자 알파벳:
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 

소문자 알파벳:
a b c d e f g h i j k l m n o p q r s t u v w x y z 

알파벳과 ASCII 코드:
A = 65
B = 66
C = 67
D = 68
E = 69
F = 70
```

### 예제 3-2: 문자열 처리
```java
public class StringProcessing {
    public static void main(String[] args) {
        String text = "Hello, World!";
        
        // 문자열의 각 문자 출력
        System.out.println("문자열의 각 문자:");
        for (int i = 0; i < text.length(); i++) {
            System.out.println("인덱스 " + i + ": " + text.charAt(i));
        }
        
        // TODO: 문자열 역순 출력
        // 힌트:
        // 1. "역순: " 출력
        // 2. i를 text.length()-1부터 0까지 감소시키며:
        //    - text.charAt(i) 출력
        System.out.print("\n역순: ");
        
        // 여기에 코드를 작성하세요
        
        System.out.println();
        
        // TODO: 모음 개수 세기
        // 힌트:
        // 1. vowelCount를 0으로 초기화
        // 2. vowels = "aeiouAEIOU" 문자열 생성
        // 3. text의 각 문자에 대해:
        //    - 현재 문자가 vowels에 포함되면 vowelCount 증가
        //    - vowels.indexOf(ch) >= 0 사용
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n모음 개수: " + vowelCount);
    }
}
```

#### 실행 결과:
```
문자열의 각 문자:
인덱스 0: H
인덱스 1: e
인덱스 2: l
인덱스 3: l
인덱스 4: o
인덱스 5: ,
인덱스 6:  
인덱스 7: W
인덱스 8: o
인덱스 9: r
인덱스 10: l
인덱스 11: d
인덱스 12: !

역순: !dlroW ,olleH

모음 개수: 3
```

## 4. 약수 계산 예제

### 예제 4-1: 약수 찾기와 세기
```java
import textio.TextIO;

public class DivisorCalculator {
    public static void main(String[] args) {
        System.out.print("양의 정수를 입력하세요: ");
        int N = TextIO.getlnInt();
        
        // 입력 검증
        while (N <= 0) {
            System.out.print("양의 정수를 입력해주세요: ");
            N = TextIO.getlnInt();
        }
        
        System.out.println("\n" + N + "의 약수:");
        int divisorCount = 0;
        
        // TODO: 약수 찾기
        // 힌트:
        // 1. d를 1부터 N까지 반복
        // 2. N % d == 0 이면:
        //    - d 출력 (공백 포함)
        //    - divisorCount 증가
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n\n약수의 개수: " + divisorCount);
        
        // 소수 판별
        if (divisorCount == 2) {
            System.out.println(N + "은(는) 소수입니다!");
        } else if (divisorCount == 1) {
            System.out.println(N + "은(는) 1입니다.");
        } else {
            System.out.println(N + "은(는) 합성수입니다.");
        }
    }
}
```

#### 실행 결과:
```
양의 정수를 입력하세요: 24

24의 약수:
1 2 3 4 6 8 12 24 

약수의 개수: 8
24은(는) 합성수입니다.
```

### 예제 4-2: 완전수 찾기
```java
public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println("1부터 10000까지의 완전수:");
        System.out.println("(완전수: 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수)");
        
        for (int n = 1; n <= 10000; n++) {
            int sumOfDivisors = 0;
            
            // TODO: n의 진약수(자기 자신 제외) 합 구하기
            // 힌트:
            // 1. d를 1부터 n-1까지 반복
            // 2. n % d == 0 이면:
            //    - sumOfDivisors에 d를 더하기
            
            // 여기에 코드를 작성하세요
            
            // 완전수 확인 및 출력
            if (sumOfDivisors == n) {
                System.out.print("\n" + n + " = ");
                
                // TODO: 약수 출력
                // 힌트:
                // 1. first를 true로 초기화
                // 2. d를 1부터 n-1까지 반복
                // 3. n % d == 0 이면:
                //    - first가 false면 " + " 출력
                //    - d 출력
                //    - first를 false로 설정
                
                // 여기에 코드를 작성하세요
            }
        }
        System.out.println();
    }
}
```

#### 실행 결과:
```
1부터 10000까지의 완전수:
(완전수: 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수)

6 = 1 + 2 + 3
28 = 1 + 2 + 4 + 7 + 14
496 = 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248
8128 = 1 + 2 + 4 + 8 + 16 + 32 + 64 + 127 + 254 + 508 + 1016 + 2032 + 4064
```

## 5. 중첩된 for 루프

### 예제 5-1: 구구단 표
```java
public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("=== 구구단 표 (1-12) ===\n");
        
        // 헤더 출력
        System.out.print("    ");
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        
        // 구분선
        System.out.print("    ");
        for (int i = 1; i <= 12; i++) {
            System.out.print("----");
        }
        System.out.println();
        
        // TODO: 구구단 표 본문
        // 힌트:
        // 1. row를 1부터 12까지 반복 (외부 루프)
        // 2. 각 row에 대해:
        //    - row 번호 출력 (형식: "%2d |")
        //    - col을 1부터 12까지 반복 (내부 루프)
        //    - row * col 출력 (형식: "%4d")
        //    - 줄바꿈
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 구구단 표 (1-12) ===

       1   2   3   4   5   6   7   8   9  10  11  12
    ------------------------------------------------
 1 |   1   2   3   4   5   6   7   8   9  10  11  12
 2 |   2   4   6   8  10  12  14  16  18  20  22  24
 3 |   3   6   9  12  15  18  21  24  27  30  33  36
 4 |   4   8  12  16  20  24  28  32  36  40  44  48
 5 |   5  10  15  20  25  30  35  40  45  50  55  60
 6 |   6  12  18  24  30  36  42  48  54  60  66  72
 7 |   7  14  21  28  35  42  49  56  63  70  77  84
 8 |   8  16  24  32  40  48  56  64  72  80  88  96
 9 |   9  18  27  36  45  54  63  72  81  90  99 108
10 |  10  20  30  40  50  60  70  80  90 100 110 120
11 |  11  22  33  44  55  66  77  88  99 110 121 132
12 |  12  24  36  48  60  72  84  96 108 120 132 144
```

### 예제 5-2: 패턴 출력
```java
public class PatternPrinting {
    public static void main(String[] args) {
        // 패턴 1: 직각삼각형
        System.out.println("=== 패턴 1: 직각삼각형 ===");
        
        // TODO: 직각삼각형 패턴
        // 힌트:
        // 1. i를 1부터 5까지 반복 (줄 수)
        // 2. 각 줄에서 j를 1부터 i까지 반복
        // 3. "* " 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // 패턴 2: 역삼각형
        System.out.println("\n=== 패턴 2: 역삼각형 ===");
        
        // TODO: 역삼각형 패턴
        // 힌트:
        // 1. i를 5부터 1까지 감소시키며 반복
        // 2. 각 줄에서 j를 1부터 i까지 반복
        // 3. "* " 출력
        // 4. 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // 패턴 3: 피라미드
        System.out.println("\n=== 패턴 3: 피라미드 ===");
        int height = 5;
        
        // TODO: 피라미드 패턴
        // 힌트:
        // 1. i를 1부터 height까지 반복
        // 2. 각 줄에서:
        //    - 공백을 (height - i)개 출력
        //    - 별을 (2 * i - 1)개 출력
        //    - 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        // 패턴 4: 다이아몬드
        System.out.println("\n=== 패턴 4: 다이아몬드 ===");
        int size = 5;
        
        // TODO: 다이아몬드 패턴
        // 힌트:
        // 1. 상단부: i를 1부터 size까지
        //    - 공백 (size - i)개
        //    - 별 (2 * i - 1)개
        // 2. 하단부: i를 size-1부터 1까지
        //    - 공백 (size - i)개
        //    - 별 (2 * i - 1)개
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 패턴 1: 직각삼각형 ===
* 
* * 
* * * 
* * * * 
* * * * * 

=== 패턴 2: 역삼각형 ===
* * * * * 
* * * * 
* * * 
* * 
* 

=== 패턴 3: 피라미드 ===
    *
   ***
  *****
 *******
*********

=== 패턴 4: 다이아몬드 ===
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

## 6. 문자 분석 예제

### 예제 6-1: 문자열의 문자 찾기
```java
import textio.TextIO;

public class ListLettersInText {
    public static void main(String[] args) {
        System.out.println("텍스트를 입력하세요:");
        String str = TextIO.getln();
        
        // 대문자로 변환
        str = str.toUpperCase();
        
        int count = 0;
        System.out.println("\n입력한 텍스트에 포함된 문자:");
        
        // TODO: 각 알파벳 확인
        // 힌트:
        // 1. letter를 'A'부터 'Z'까지 반복
        // 2. 각 letter에 대해:
        //    - found를 false로 초기화
        //    - str의 각 문자를 확인하여 letter와 같은지 검사
        //    - 찾으면 found = true 설정하고 break
        //    - found가 true면 letter 출력하고 count 증가
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n\n서로 다른 문자의 개수: " + count);
        
        // TODO: 문자 빈도수 계산
        // 힌트:
        // 1. letter를 'A'부터 'Z'까지 반복
        // 2. 각 letter에 대해:
        //    - frequency를 0으로 초기화
        //    - str의 각 문자가 letter와 같으면 frequency 증가
        //    - frequency > 0이면 출력
        System.out.println("\n문자별 빈도수:");
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결곺:
```
텍스트를 입력하세요:
Hello, World!

입력한 텍스트에 포함된 문자:
D E H L O R W 

서로 다른 문자의 개수: 7

문자별 빈도수:
D: 1개
E: 1개
H: 1개
L: 3개
O: 2개
R: 1개
W: 1개
```

## 7. 복잡한 for 루프 예제

### 예제 7-1: 여러 변수 사용
```java
public class MultiVariableFor {
    public static void main(String[] args) {
        // TODO: 두 변수 동시 사용
        // 힌트:
        // 1. "두 변수 동시 변화:" 출력
        // 2. for 루프에서 i=0, j=10으로 시작
        // 3. i < 10 && j > 0 조건
        // 4. i++, j-- 로 변경
        // 5. printf로 i, j, i+j 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: 서로 다른 증가율
        // 힌트:
        // 1. "\n서로 다른 증가율:" 출력
        // 2. for 루프에서 x=1, y=1로 시작
        // 3. x <= 10 조건
        // 4. x++, y *= 2 로 변경
        // 5. printf로 x, y 출력 (형식: "x = %2d, y = %4d%n")
        
        // 여기에 코드를 작성하세요
        
        // TODO: 조건부 증가
        // 힌트:
        // 1. "\n조건부 증가:" 출력
        // 2. for 루프에서 a=0, b=0으로 시작
        // 3. a < 20 조건
        // 4. a += (b % 2 == 0 ? 2 : 1), b++
        // 5. printf로 a, b 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
두 변수 동시 변화:
i = 0, j = 10, 합 = 10
i = 1, j = 9, 합 = 10
i = 2, j = 8, 합 = 10
i = 3, j = 7, 합 = 10
i = 4, j = 6, 합 = 10
i = 5, j = 5, 합 = 10
i = 6, j = 4, 합 = 10
i = 7, j = 3, 합 = 10
i = 8, j = 2, 합 = 10
i = 9, j = 1, 합 = 10

서로 다른 증가율:
x =  1, y =    1
x =  2, y =    2
x =  3, y =    4
x =  4, y =    8
x =  5, y =   16
x =  6, y =   32
x =  7, y =   64
x =  8, y =  128
x =  9, y =  256
x = 10, y =  512

조건부 증가:
a =  0, b =  0
a =  2, b =  1
a =  3, b =  2
a =  5, b =  3
a =  6, b =  4
a =  8, b =  5
a =  9, b =  6
a = 11, b =  7
a = 12, b =  8
a = 14, b =  9
a = 15, b = 10
a = 17, b = 11
a = 18, b = 12
```

### 예제 7-2: 소수 찾기 (에라토스테네스의 체)
```java
public class PrimeSieve {
    public static void main(String[] args) {
        int limit = 100;
        boolean[] isPrime = new boolean[limit + 1];
        
        // 모든 수를 소수로 가정
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        
        // TODO: 에라토스테네스의 체 알고리즘
        // 힌트:
        // 1. i를 2부터 i*i <= limit까지 반복
        // 2. isPrime[i]가 true이면:
        //    - j를 i*i부터 limit까지 i씩 증가시키며
        //    - isPrime[j] = false 설정 (i의 배수 제거)
        
        // 여기에 코드를 작성하세요
        
        // 소수 출력
        System.out.println("2부터 " + limit + "까지의 소수:");
        int count = 0;
        
        // TODO: 소수 출력
        // 힌트:
        // 1. i를 2부터 limit까지 반복
        // 2. isPrime[i]가 true이면:
        //    - i를 형식 "%3d "로 출력
        //    - count 증가
        //    - count가 10의 배수면 줄바꿈
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n\n총 " + count + "개의 소수");
    }
}
```

#### 실행 결과:
```
2부터 100까지의 소수:
  2   3   5   7  11  13  17  19  23  29 
 31  37  41  43  47  53  59  61  67  71 
 73  79  83  89  97 

총 25개의 소수
```

## 8. 성능 측정 예제

### 예제 8-1: 루프 성능 비교
```java
public class LoopPerformance {
    public static void main(String[] args) {
        int n = 100000000;  // 1억
        long sum;
        
        // TODO: for 루프 성능 측정
        // 힌트:
        // 1. System.currentTimeMillis()로 시작 시간 기록
        // 2. sum = 0으로 초기화
        // 3. for 루프로 i를 1부터 n까지 반복하며 sum에 더하기
        // 4. 종료 시간 - 시작 시간으로 소요 시간 계산
        // 5. 결과와 소요 시간 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: while 루프 성능 측정
        // 힌트:
        // 1. 시작 시간 기록
        // 2. sum = 0, i = 1로 초기화
        // 3. while 루프로 i <= n 동안 sum += i, i++ 수행
        // 4. 소요 시간 계산
        // 5. 결과와 소요 시간 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: 수학 공식 사용
        // 힌트:
        // 1. 시작 시간 기록
        // 2. sum = (long)n * (n + 1) / 2 계산
        // 3. 소요 시간 계산
        // 4. 결과와 소요 시간 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
for 루프 결과: 5000000050000000
소요 시간: 342ms

while 루프 결과: 5000000050000000
소요 시간: 348ms

수학 공식 결과: 5000000050000000
소요 시간: 0ms
```