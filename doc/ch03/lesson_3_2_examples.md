# 3.2 알고리즘 개발 - 예제 모음

## 1. 단계적 세분화 예제

### 예제 1-1: 평균 구하기 알고리즘
```java
// 1단계: 전체 설명
// "사용자가 입력한 숫자들의 평균 계산"

// 2단계: 주요 단계
// 입력 받기
// 합계 계산
// 평균 계산
// 결과 출력

// 3단계: 세부 단계
import textio.TextIO;

public class AverageCalculator {
    public static void main(String[] args) {
        // 변수 초기화
        double sum = 0;
        int count = 0;
        
        System.out.println("=== 평균 계산기 ===");
        System.out.println("숫자를 입력하세요 (0 입력 시 종료):");
        
        // TODO: 입력 및 합계 계산
        // 힌트: 
        // 1. while(true) 무한 루프를 사용
        // 2. 사용자로부터 숫자를 입력받기 (TextIO.getlnDouble())
        // 3. 입력값이 0이면 루프 종료 (break)
        // 4. 0이 아니면 sum과 count를 업데이트
        
        // 여기에 코드를 작성하세요
        
        // TODO: 평균 계산 및 출력
        // 힌트:
        // 1. count가 0보다 큰지 확인
        // 2. 평균 = sum / count
        // 3. 결과를 보기 좋게 출력
        // 4. count가 0이면 "입력된 숫자가 없습니다." 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과 예시:
```
=== 평균 계산기 ===
숫자를 입력하세요 (0 입력 시 종료):
숫자: 85.5
숫자: 90.0
숫자: 78.5
숫자: 92.3
숫자: 88.7
숫자: 0

=== 결과 ===
입력한 숫자: 5개
합계: 435.0
평균: 87.0
```

### 예제 1-2: 이자 계산 프로그램 개발 과정
```java
// 의사코드 단계
/*
pseudocode:
원금 입력받기
이자율 입력받기
기간 입력받기

for 각 년도 from 1 to 기간:
    이자 = 원금 * 이자율
    원금 = 원금 + 이자
    결과 출력
*/

// Java 구현
import textio.TextIO;

public class InterestCalculator {
    public static void main(String[] args) {
        double principal;  // 원금
        double rate;       // 이자율
        int years;         // 기간
        
        // 사용자 입력
        System.out.print("초기 투자 금액: $");
        principal = TextIO.getlnDouble();
        
        System.out.print("연간 이자율 (%): ");
        double percent = TextIO.getlnDouble();
        rate = percent / 100.0;  // 백분율을 소수로 변환
        
        System.out.print("투자 기간 (년): ");
        years = TextIO.getlnInt();
        
        System.out.println("\n년도\t투자 가치");
        System.out.println("----\t----------");
        
        // TODO: 계산 및 출력
        // 힌트:
        // 1. year 변수를 0으로 초기화
        // 2. while 루프로 year < years 동안 반복
        // 3. 각 반복에서:
        //    - year를 1 증가
        //    - 이자 = 원금 * 이자율
        //    - 원금 = 원금 + 이자
        //    - 결과 출력 (printf 사용)
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n최종 투자 가치: $" + 
                         String.format("%,.2f", principal));
    }
}
```

#### 실행 결과 예시:
```
초기 투자 금액: $1000
연간 이자율 (%): 5
투자 기간 (년): 3

년도	투자 가치
----	----------
1	$1,050.00
2	$1,102.50
3	$1,157.63

최종 투자 가치: $1,157.63
```

## 2. 3N+1 문제 구현

### 예제 2-1: 기본 3N+1 프로그램
```java
import textio.TextIO;

public class ThreeNPlusOne {
    public static void main(String[] args) {
        int N;           // 현재 숫자
        int counter;     // 단계 수
        
        // 입력 받기 (양수 검증 포함)
        System.out.print("시작 숫자 입력 (양수): ");
        N = TextIO.getlnInt();
        
        while (N <= 0) {
            System.out.print("양수를 입력해주세요: ");
            N = TextIO.getlnInt();
        }
        
        // TODO: 3N+1 수열 계산
        System.out.println("\n3N+1 수열:");
        System.out.print(N);  // 첫 번째 항 출력
        
        counter = 1;  // 첫 번째 항 포함
        
        // 힌트:
        // 1. N이 1이 아닌 동안 반복
        // 2. N이 짝수면: N = N / 2
        // 3. N이 홀수면: N = 3 * N + 1
        // 4. 각 단계마다 " -> " + N 출력
        // 5. counter 증가
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n\n수열의 길이: " + counter);
    }
}
```

#### 실행 결과 예시:
```
시작 숫자 입력 (양수): 13

3N+1 수열:
13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1

수열의 길이: 10
```

### 예제 2-2: 3N+1 분석 프로그램
```java
import textio.TextIO;

public class ThreeNPlusOneAnalysis {
    public static void main(String[] args) {
        System.out.println("=== 3N+1 수열 분석기 ===");
        System.out.println("1부터 지정한 숫자까지 모든 수의 수열 길이를 분석\n");
        
        System.out.print("분석할 최대 숫자: ");
        int maxNumber = TextIO.getlnInt();
        
        int longestLength = 0;
        int numberWithLongest = 0;
        
        // 각 숫자에 대해 수열 계산
        int startNumber = 1;
        while (startNumber <= maxNumber) {
            int N = startNumber;
            int length = 1;
            
            // TODO: 해당 숫자의 수열 길이 계산
            // 힌트: 앞의 3N+1 예제와 동일한 로직
            // 단, 수열을 출력하지 않고 길이만 계산
            
            // 여기에 코드를 작성하세요
            
            // 최대 길이 갱신
            if (length > longestLength) {
                longestLength = length;
                numberWithLongest = startNumber;
            }
            
            // 진행 상황 출력 (10의 배수마다)
            if (startNumber % 10 == 0) {
                System.out.println(startNumber + "까지 완료...");
            }
            
            startNumber = startNumber + 1;
        }
        
        // 결과 출력
        System.out.println("\n=== 분석 결과 ===");
        System.out.println("가장 긴 수열을 가진 숫자: " + numberWithLongest);
        System.out.println("수열의 길이: " + longestLength);
    }
}
```

#### 실행 결과 예시:
```
=== 3N+1 수열 분석기 ===
1부터 지정한 숫자까지 모든 수의 수열 길이를 분석

분석할 최대 숫자: 30
10까지 완료...
20까지 완료...
30까지 완료...

=== 분석 결과 ===
가장 긴 수열을 가진 숫자: 27
수열의 길이: 112
```

## 3. 입력 검증 예제

### 예제 3-1: 범위 검증
```java
import textio.TextIO;

public class InputValidation {
    public static void main(String[] args) {
        int age;
        double score;
        
        // 나이 입력 검증
        System.out.println("=== 나이 입력 ===");
        do {
            System.out.print("나이를 입력하세요 (1-120): ");
            age = TextIO.getlnInt();
            
            if (age < 1 || age > 120) {
                System.out.println("유효하지 않은 나이입니다!");
            }
        } while (age < 1 || age > 120);
        
        System.out.println("입력된 나이: " + age);
        
        // TODO: 점수 입력 검증
        System.out.println("\n=== 점수 입력 ===");
        // 힌트:
        // 1. while(true) 무한 루프 사용
        // 2. 점수 입력받기
        // 3. 0 <= score <= 100 이면 break
        // 4. 그렇지 않으면 오류 메시지 출력하고 계속
        
        // 여기에 코드를 작성하세요
        
        System.out.println("입력된 점수: " + score);
    }
}
```

#### 실행 결과 예시:
```
=== 나이 입력 ===
나이를 입력하세요 (1-120): 150
유효하지 않은 나이입니다!
나이를 입력하세요 (1-120): -5
유효하지 않은 나이입니다!
나이를 입력하세요 (1-120): 25
입력된 나이: 25

=== 점수 입력 ===
점수를 입력하세요 (0-100): 150
점수는 0과 100 사이여야 합니다!
점수를 입력하세요 (0-100): 85.5
입력된 점수: 85.5
```

### 예제 3-2: 메뉴 선택 검증
```java
import textio.TextIO;

public class MenuValidation {
    public static void main(String[] args) {
        int choice;
        
        System.out.println("=== 계산기 메뉴 ===");
        
        do {
            System.out.println("\n1. 더하기");
            System.out.println("2. 빼기");
            System.out.println("3. 곱하기");
            System.out.println("4. 나누기");
            System.out.println("5. 종료");
            System.out.print("\n선택 (1-5): ");
            
            choice = TextIO.getlnInt();
            
            if (choice < 1 || choice > 5) {
                System.out.println("\n⚠️  1부터 5 사이의 숫자를 선택해주세요!");
                continue;
            }
            
            if (choice == 5) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            
            // 선택된 연산 수행
            System.out.print("첫 번째 숫자: ");
            double num1 = TextIO.getlnDouble();
            System.out.print("두 번째 숫자: ");
            double num2 = TextIO.getlnDouble();
            
            double result = 0;
            boolean validOperation = true;
            
            // TODO: choice에 따라 연산 수행
            // 힌트:
            // 1. choice가 1이면 더하기
            // 2. choice가 2이면 빼기
            // 3. choice가 3이면 곱하기
            // 4. choice가 4이면 나누기
            //    - 주의: num2가 0이면 오류 메시지 출력
            //    - validOperation을 false로 설정
            
            // 여기에 코드를 작성하세요
            
            if (validOperation) {
                System.out.println("결과: " + result);
            }
            
        } while (choice != 5);
    }
}
```

#### 실행 결과 예시:
```
=== 계산기 메뉴 ===

1. 더하기
2. 빼기
3. 곱하기
4. 나누기
5. 종료

선택 (1-5): 1
첫 번째 숫자: 10.5
두 번째 숫자: 5.5
결과: 16.0

1. 더하기
2. 빼기
3. 곱하기
4. 나누기
5. 종료

선택 (1-5): 4
첫 번째 숫자: 10
두 번째 숫자: 0
0으로 나눌 수 없습니다!

1. 더하기
2. 빼기
3. 곱하기
4. 나누기
5. 종료

선택 (1-5): 5

프로그램을 종료합니다.
```

## 4. 디버깅 예제

### 예제 4-1: 디버깅 출력문 사용
```java
public class DebuggingExample {
    public static void main(String[] args) {
        // 팩토리얼 계산 (오류가 있는 코드)
        int n = 5;
        int factorial = 0;  // 오류: 0으로 초기화
        int i = 1;
        
        System.out.println("DEBUG: 초기값 - n=" + n + ", factorial=" + factorial);
        
        while (i <= n) {
            System.out.println("DEBUG: 루프 시작 - i=" + i + ", factorial=" + factorial);
            
            factorial = factorial * i;  // 오류: 0 * i는 항상 0
            i = i + 1;
            
            System.out.println("DEBUG: 루프 끝 - i=" + i + ", factorial=" + factorial);
        }
        
        System.out.println("\n" + n + "! = " + factorial);
        System.out.println("(예상값: 120)");
    }
}
```

#### 실행 결과 예시:
```
DEBUG: 초기값 - n=5, factorial=0
DEBUG: 루프 시작 - i=1, factorial=0
DEBUG: 루프 끝 - i=2, factorial=0
DEBUG: 루프 시작 - i=2, factorial=0
DEBUG: 루프 끝 - i=3, factorial=0
DEBUG: 루프 시작 - i=3, factorial=0
DEBUG: 루프 끝 - i=4, factorial=0
DEBUG: 루프 시작 - i=4, factorial=0
DEBUG: 루프 끝 - i=5, factorial=0
DEBUG: 루프 시작 - i=5, factorial=0
DEBUG: 루프 끝 - i=6, factorial=0

5! = 0
(예상값: 120)
```

### 예제 4-2: 올바른 팩토리얼 코드
```java
public class FactorialFixed {
    public static void main(String[] args) {
        int n = 5;
        int factorial = 1;  // 수정: 1로 초기화
        int i = 1;
        
        System.out.println(n + "! 계산 과정:");
        System.out.print(n + "! = ");
        
        while (i <= n) {
            factorial = factorial * i;
            
            // 계산 과정 출력
            System.out.print(i);
            if (i < n) {
                System.out.print(" × ");
            }
            
            i = i + 1;
        }
        
        System.out.println(" = " + factorial);
    }
}
```

#### 실행 결과 예시:
```
5! 계산 과정:
5! = 1 × 2 × 3 × 4 × 5 = 120
```

## 5. 종합 예제

### 예제 5-1: 성적 처리 시스템
```java
import textio.TextIO;

public class GradeProcessingSystem {
    public static void main(String[] args) {
        // 변수 선언
        String studentName;
        int numberOfSubjects;
        double totalScore = 0;
        double average;
        String grade;
        
        System.out.println("=== 성적 처리 시스템 ===");
        
        // 학생 이름 입력
        System.out.print("학생 이름: ");
        studentName = TextIO.getln();
        
        // 과목 수 입력 (양수 검증)
        do {
            System.out.print("과목 수: ");
            numberOfSubjects = TextIO.getlnInt();
            
            if (numberOfSubjects <= 0) {
                System.out.println("과목 수는 1개 이상이어야 합니다!");
            }
        } while (numberOfSubjects <= 0);
        
        // 각 과목 점수 입력
        System.out.println("\n각 과목의 점수를 입력하세요 (0-100):");
        
        int subjectCount = 0;
        while (subjectCount < numberOfSubjects) {
            System.out.print("과목 " + (subjectCount + 1) + ": ");
            double score = TextIO.getlnDouble();
            
            // 점수 범위 검증
            if (score < 0 || score > 100) {
                System.out.println("잘못된 점수입니다. 다시 입력해주세요.");
                continue;
            }
            
            totalScore = totalScore + score;
            subjectCount = subjectCount + 1;
        }
        
        // TODO: 평균 및 학점 계산
        // 힌트:
        // 1. 평균 = totalScore / numberOfSubjects
        // 2. 학점 기준:
        //    - 90점 이상: A
        //    - 80점 이상: B
        //    - 70점 이상: C
        //    - 60점 이상: D
        //    - 60점 미만: F
        
        // 여기에 코드를 작성하세요
        
        // 결과 출력
        System.out.println("\n=== 성적 결과 ===");
        System.out.println("학생: " + studentName);
        System.out.println("총 과목 수: " + numberOfSubjects);
        System.out.printf("평균 점수: %.2f%n", average);
        System.out.println("학점: " + grade);
        
        // 추가 메시지
        if (grade.equals("A")) {
            System.out.println("축하합니다! 훌륭한 성적입니다! 🎆");
        } else if (grade.equals("F")) {
            System.out.println("더 노력이 필요합니다. 화이팅! 💪");
        }
    }
}
```

#### 실행 결과 예시:
```
=== 성적 처리 시스템 ===
학생 이름: 김철수
과목 수: 4

각 과목의 점수를 입력하세요 (0-100):
과목 1: 95
과목 2: 88
과목 3: 92
과목 4: 91

=== 성적 결과 ===
학생: 김철수
총 과목 수: 4
평균 점수: 91.50
학점: A
축하합니다! 훌륭한 성적입니다! 🎆
```

### 예제 5-2: 소수 판별 프로그램
```java
import textio.TextIO;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        System.out.println("=== 소수 판별 프로그램 ===");
        System.out.println("0을 입력하면 종료\n");
        
        while (true) {
            // 숫자 입력
            System.out.print("검사할 숫자: ");
            int number = TextIO.getlnInt();
            
            // 종료 조건
            if (number == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            // 음수 처리
            if (number < 0) {
                System.out.println("양수를 입력해주세요.\n");
                continue;
            }
            
            // TODO: 소수 판별 알고리즘
            boolean isPrime = true;
            
            // 힌트:
            // 1. 1 이하의 숫자는 소수가 아님
            // 2. 2부터 시작하여 divisor * divisor <= number 동안:
            //    - number가 divisor로 나누어 떨어지면 소수가 아님
            //    - divisor를 1씩 증가
            // 3. 최적화: 제곱근까지만 검사하면 충분
            
            // 여기에 코드를 작성하세요
            
            // 결과 출력
            if (isPrime) {
                System.out.println(number + "은(는) 소수입니다. ✓");
            } else {
                System.out.println(number + "은(는) 소수가 아닙니다. ✗");
                
                // 약수 출력
                if (number > 1) {
                    System.out.print("약수: ");
                    int factor = 1;
                    while (factor <= number) {
                        if (number % factor == 0) {
                            System.out.print(factor + " ");
                        }
                        factor = factor + 1;
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
```

#### 실행 결과 예시:
```
=== 소수 판별 프로그램 ===
0을 입력하면 종료

검사할 숫자: 17
17은(는) 소수입니다. ✓

검사할 숫자: 24
24은(는) 소수가 아닙니다. ✗
약수: 1 2 3 4 6 8 12 24 

검사할 숫자: 1
1은(는) 소수가 아닙니다. ✗

검사할 숫자: 0
프로그램을 종료합니다.
```

## 6. 테스트 케이스 예제

### 예제 6-1: 테스트 데이터로 프로그램 검증
```java
public class TestingExample {
    public static void main(String[] args) {
        System.out.println("=== 최대공약수(GCD) 계산 테스트 ===");
        
        // 테스트 케이스
        int[][] testCases = {
            {48, 18, 6},    // a, b, 예상 GCD
            {100, 50, 50},
            {17, 5, 1},     // 서로소
            {0, 5, 5},      // 특수 케이스
            {7, 7, 7}       // 같은 수
        };
        
        // 각 테스트 케이스 실행
        int testNumber = 1;
        while (testNumber <= testCases.length) {
            int a = testCases[testNumber - 1][0];
            int b = testCases[testNumber - 1][1];
            int expected = testCases[testNumber - 1][2];
            
            // TODO: 유클리드 호제법으로 GCD 계산
            int x = a;
            int y = b;
            
            // 힌트:
            // 1. x가 0이면 GCD는 y
            // 2. y가 0이 아닌 동안:
            //    - temp = y
            //    - y = x % y (나머지)
            //    - x = temp
            // 3. 최종적으로 x가 GCD
            
            // 여기에 코드를 작성하세요
            
            int result = x;
            
            // 결과 검증
            System.out.print("테스트 " + testNumber + ": ");
            System.out.print("GCD(" + a + ", " + b + ") = " + result);
            
            if (result == expected) {
                System.out.println(" ✅ 통과");
            } else {
                System.out.println(" ❌ 실패 (예상: " + expected + ")");
            }
            
            testNumber = testNumber + 1;
        }
    }
}
```

#### 실행 결과 예시:
```
=== 최대공약수(GCD) 계산 테스트 ===
테스트 1: GCD(48, 18) = 6 ✅ 통과
테스트 2: GCD(100, 50) = 50 ✅ 통과
테스트 3: GCD(17, 5) = 1 ✅ 통과
테스트 4: GCD(0, 5) = 5 ✅ 통과
테스트 5: GCD(7, 7) = 7 ✅ 통과
```