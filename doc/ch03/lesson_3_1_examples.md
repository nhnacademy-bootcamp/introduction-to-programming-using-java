# 3.1 블록, 루프, 그리고 분기 - 예제 모음

## 1. 블록(Block) 예제

### 예제 1-1: 기본 블록 사용
```java
public class BlockExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        
        System.out.println("블록 실행 전: x = " + x + ", y = " + y);
        
        // TODO: 값을 교환하는 블록
        // 힌트:
        // 1. temp 변수를 선언하여 임시 저장
        // 2. x와 y의 값을 교환
        // 3. 블록이 끝나면 temp는 사용할 수 없음
        {
            // 여기에 코드를 작성하세요
        }
        // temp는 여기서 사용할 수 없음
        
        System.out.println("블록 실행 후: x = " + x + ", y = " + y);
    }
}
```

#### 실행 결과:
```
블록 실행 전: x = 10, y = 20
블록 실행 후: x = 20, y = 10
```

### 예제 1-2: 변수 범위(Scope) 이해하기
```java
public class ScopeExample {
    public static void main(String[] args) {
        int outer = 100;  // 외부 변수
        
        System.out.println("외부 변수: " + outer);
        
        {
            // 내부 블록
            int inner = 200;  // 내부 변수
            System.out.println("블록 내부에서:");
            System.out.println("  outer = " + outer);  // 접근 가능
            System.out.println("  inner = " + inner);  // 접근 가능
            
            // 외부 변수 수정
            outer = 150;
        }
        
        System.out.println("블록 밖에서:");
        System.out.println("  outer = " + outer);  // 수정된 값
        // System.out.println("  inner = " + inner);  // 오류! inner는 접근 불가
    }
}
```

#### 실행 결과:
```
외부 변수: 100
블록 내부에서:
  outer = 100
  inner = 200
블록 밖에서:
  outer = 150
```

### 예제 1-3: 중첩된 블록
```java
public class NestedBlocks {
    public static void main(String[] args) {
        int level1 = 1;
        
        {
            int level2 = 2;
            System.out.println("레벨 2: " + level1 + ", " + level2);
            
            {
                int level3 = 3;
                System.out.println("레벨 3: " + level1 + ", " + level2 + ", " + level3);
            }
            // level3는 여기서 접근 불가
        }
        // level2와 level3는 여기서 접근 불가
    }
}
```

#### 실행 결과:
```
레벨 2: 1, 2
레벨 3: 1, 2, 3
```

## 2. While 루프 예제

### 예제 2-1: 카운트다운
```java
public class CountDown {
    public static void main(String[] args) {
        int count = 10;
        
        System.out.println("카운트다운 시작!");
        
        // TODO: 카운트다운 루프
        // 힌트:
        // 1. count가 0보다 큰 동안 반복
        // 2. count 값 출력 ("..." 포함)
        // 3. count를 1씩 감소
        // 4. Thread.sleep(1000)으로 1초 대기
        
        // 여기에 코드를 작성하세요
        
        System.out.println("발사! 🚀");
    }
}
```

#### 실행 결과:
```
카운트다운 시작!
10...
9...
8...
7...
6...
5...
4...
3...
2...
1...
발사! 🚀
```

### 예제 2-2: 숫자 맞추기 게임
```java
import textio.TextIO;

public class GuessNumber {
    public static void main(String[] args) {
        int secretNumber = (int)(Math.random() * 100) + 1;  // 1~100
        int guess;
        int attempts = 0;
        
        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");
        
        // TODO: 숫자 맞추기 루프
        // 힌트:
        // 1. while(true) 무한 루프
        // 2. 사용자로부터 추측 입력받기
        // 3. attempts 증가
        // 4. 정답이면 축하 메시지 후 break
        // 5. 추측이 작으면 "더 큰 수입니다."
        // 6. 추측이 크면 "더 작은 수입니다."
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
1부터 100 사이의 숫자를 맞춰보세요!
추측: 50
더 작은 수입니다.
추측: 25
더 큰 수입니다.
추측: 37
더 작은 수입니다.
추측: 31
더 큰 수입니다.
추측: 34

정답! 34입니다. 5번 만에 맞췄습니다!
축하합니다! 🎉
```

### 예제 2-3: 팩토리얼 계산
```java
public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int factorial = 1;
        int counter = 1;
        
        System.out.print(n + "! = ");
        
        // TODO: 팩토리얼 계산 루프
        // 힌트:
        // 1. counter가 n 이하인 동안 반복
        // 2. factorial에 counter를 곱하기
        // 3. counter 출력 (n보다 작으면 " × " 추가)
        // 4. counter를 1 증가
        
        // 여기에 코드를 작성하세요
        
        System.out.println(" = " + factorial);
    }
}
```

#### 실행 결과:
```
5! = 1 × 2 × 3 × 4 × 5 = 120
```

### 예제 2-4: 합계와 평균 계산
```java
import textio.TextIO;

public class SumAndAverage {
    public static void main(String[] args) {
        double sum = 0;
        int count = 0;
        double number;
        
        System.out.println("숫자를 입력하세요 (0 입력시 종료):");
        
        // TODO: 합계와 평균 계산 루프
        // 힌트:
        // 1. while(true) 무한 루프
        // 2. 숫자 입력받기
        // 3. 0이면 break로 루프 종료
        // 4. sum에 더하고 count 증가
        
        // 여기에 코드를 작성하세요
        
        if (count > 0) {
            double average = sum / count;
            System.out.println("\n입력한 숫자: " + count + "개");
            System.out.println("합계: " + sum);
            System.out.println("평균: " + average);
        } else {
            System.out.println("입력된 숫자가 없습니다.");
        }
    }
}
```

#### 실행 결과:
```
숫자를 입력하세요 (0 입력시 종료):
85
92
78
90
0

입력한 숫자: 4개
합계: 345.0
평균: 86.25
```

## 3. If 문 예제

### 예제 3-1: 절댓값 구하기
```java
public class AbsoluteValue {
    public static void main(String[] args) {
        int[] numbers = {-5, 3, -12, 0, 8, -1};
        
        System.out.println("절댓값 계산:");
        
        for (int num : numbers) {
            int absolute;
            
            // TODO: 절댓값 계산
            // 힌트:
            // 1. num이 음수면 -num
            // 2. 그렇지 않으면 num 그대로
            int absolute;
            
            // 여기에 코드를 작성하세요
            
            System.out.println("|" + num + "| = " + absolute);
        }
    }
}
```

#### 실행 결과:
```
절댓값 계산:
|-5| = 5
|3| = 3
|-12| = 12
|0| = 0
|8| = 8
|-1| = 1
```

### 예제 3-2: 성적 판정
```java
import textio.TextIO;

public class GradeChecker {
    public static void main(String[] args) {
        System.out.print("점수를 입력하세요 (0-100): ");
        int score = TextIO.getlnInt();
        
        String grade;
        String comment;
        
        // TODO: 성적 판정 로직
        // 힌트:
        // 90점 이상: A, "우수합니다!"
        // 80점 이상: B, "잘했습니다!"
        // 70점 이상: C, "보통입니다."
        // 60점 이상: D, "노력이 필요합니다."
        // 60점 미만: F, "재수강이 필요합니다."
        
        // 여기에 코드를 작성하세요
        
        System.out.println("학점: " + grade);
        System.out.println("평가: " + comment);
    }
}
```

#### 실행 결과:
```
점수를 입력하세요 (0-100): 85
학점: B
평가: 잘했습니다!
```

### 예제 3-3: 윤년 판별
```java
public class LeapYear {
    public static void main(String[] args) {
        int[] years = {2020, 2021, 2024, 2100, 2400};
        
        for (int year : years) {
            boolean isLeapYear;
            
            // TODO: 윤년 판별 로직
            // 힌트:
            // 1. 400으로 나누어 떨어지면 윤년
            // 2. 100으로 나누어 떨어지면 평년
            // 3. 4로 나누어 떨어지면 윤년
            // 4. 그 외는 평년
            
            // 여기에 코드를 작성하세요
            
            if (isLeapYear) {
                System.out.println(year + "년은 윤년입니다.");
            } else {
                System.out.println(year + "년은 평년입니다.");
            }
        }
    }
}
```

#### 실행 결과:
```
2020년은 윤년입니다.
2021년은 평년입니다.
2024년은 윤년입니다.
2100년은 평년입니다.
2400년은 윤년입니다.
```

## 4. 복합 예제

### 예제 4-1: 소수 판별 프로그램
```java
public class PrimeChecker {
    public static void main(String[] args) {
        int number = 17;
        boolean isPrime = true;
        
        if (number <= 1) {
            isPrime = false;
        } else {
            int divisor = 2;
            
            // TODO: 소수 판별 루프
            // 힌트:
            // 1. divisor가 number/2 이하인 동안 반복
            // 2. number가 divisor로 나누어 떨어지면:
            //    - isPrime을 false로 설정
            //    - break로 루프 종료
            // 3. divisor를 1 증가
            
            // 여기에 코드를 작성하세요
        }
        
        if (isPrime) {
            System.out.println(number + "은(는) 소수입니다.");
        } else {
            System.out.println(number + "은(는) 소수가 아닙니다.");
        }
    }
}
```

#### 실행 결과:
```
17은(는) 소수입니다.
```

### 예제 4-2: 구구단 출력
```java
public class MultiplicationTable {
    public static void main(String[] args) {
        int table = 7;  // 7단
        int multiplier = 1;
        
        System.out.println("=== " + table + "단 ===");
        
        // TODO: 구구단 출력 루프
        // 힌트:
        // 1. multiplier가 9 이하인 동안 반복
        // 2. result = table * multiplier
        // 3. 결과 출력 (형식: "7 × 3 = 21")
        // 4. multiplier를 1 증가
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 7단 ===
7 × 1 = 7
7 × 2 = 14
7 × 3 = 21
7 × 4 = 28
7 × 5 = 35
7 × 6 = 42
7 × 7 = 49
7 × 8 = 56
7 × 9 = 63
```

### 예제 4-3: 피보나치 수열
```java
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;  // 처음 10개 항
        int first = 0;
        int second = 1;
        int count = 0;
        
        System.out.println("피보나치 수열의 처음 " + n + "개 항:");
        
        while (count < n) {
            if (count == 0) {
                System.out.print(first);
            } else if (count == 1) {
                System.out.print(", " + second);
            } else {
                int next = first + second;
                System.out.print(", " + next);
                first = second;
                second = next;
            }
            count = count + 1;
        }
        System.out.println();
    }
}
```

#### 실행 결과:
```
피보나치 수열의 처음 10개 항:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34
```

## 5. 명확한 할당 예제

### 예제 5-1: 올바른 변수 초기화
```java
public class DefiniteAssignment {
    public static void main(String[] args) {
        int x = 5;
        int y;  // 선언만 하고 초기화하지 않음
        
        // 올바른 예: else가 있어서 y가 반드시 값을 가짐
        if (x > 0) {
            y = 1;
        } else {
            y = -1;
        }
        System.out.println("y = " + y);  // OK
        
        // 변수 z의 조건부 초기화
        int z;
        if (x > 0 && x < 10) {
            z = x * 2;
        } else if (x >= 10) {
            z = x + 5;
        } else {
            z = 0;
        }
        System.out.println("z = " + z);  // OK - 모든 경우 처리됨
    }
}
```

#### 실행 결과:
```
y = 1
z = 10
```

### 예제 5-2: 컴파일 오류를 피하는 방법
```java
public class AvoidCompileError {
    public static void main(String[] args) {
        int value = 7;
        
        // 방법 1: 초기값 설정
        int result1 = 0;  // 기본값 설정
        if (value > 5) {
            result1 = value * 2;
        }
        System.out.println("result1 = " + result1);
        
        // 방법 2: else 사용
        int result2;
        if (value > 5) {
            result2 = value * 2;
        } else {
            result2 = value;
        }
        System.out.println("result2 = " + result2);
        
        // 방법 3: 최종 변수 사용
        final int result3;
        if (value > 5) {
            result3 = value * 2;
        } else {
            result3 = value;
        }
        System.out.println("result3 = " + result3);
    }
}
```

#### 실행 결과:
```
result1 = 14
result2 = 14
result3 = 14
```

## 6. 실전 응용 예제

### 예제 6-1: 간단한 계산기
```java
import textio.TextIO;

public class SimpleCalculator {
    public static void main(String[] args) {
        double num1, num2, result = 0;
        char operator;
        boolean validOperation = true;
        
        System.out.println("=== 간단한 계산기 ===");
        
        System.out.print("첫 번째 숫자: ");
        num1 = TextIO.getlnDouble();
        
        System.out.print("연산자 (+, -, *, /): ");
        operator = TextIO.getlnChar();
        
        System.out.print("두 번째 숫자: ");
        num2 = TextIO.getlnDouble();
        
        // TODO: 연산자에 따른 계산
        // 힌트:
        // 1. '+' → 덧셈
        // 2. '-' → 뻔셈
        // 3. '*' → 곱셈
        // 4. '/' → 나눗셈 (0으로 나누기 처리 필요)
        // 5. 그 외 → 오류 메시지
        
        // 여기에 코드를 작성하세요
        
        if (validOperation) {
            System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);
        }
    }
}
```

#### 실행 결과:
```
=== 간단한 계산기 ===
첫 번째 숫자: 10.5
연산자 (+, -, *, /): +
두 번째 숫자: 5.5
결과: 10.5 + 5.5 = 16.0
```

### 예제 6-2: 패스워드 검증
```java
import textio.TextIO;

public class PasswordValidator {
    public static void main(String[] args) {
        String correctPassword = "java2024";
        int maxAttempts = 3;
        int attempts = 0;
        boolean loggedIn = false;
        
        System.out.println("시스템에 로그인하세요.");
        
        while (attempts < maxAttempts && !loggedIn) {
            System.out.print("패스워드: ");
            String inputPassword = TextIO.getln();
            attempts = attempts + 1;
            
            // TODO: 패스워드 검증
            // 힌트:
            // 1. 입력한 패스워드가 맞으면:
            //    - loggedIn = true
            //    - 성공 메시지 출력
            // 2. 틀리면:
            //    - 남은 기회 계산
            //    - 기회가 남아있으면 안내
            //    - 기회가 없으면 계정 잠김
            
            // 여기에 코드를 작성하세요
        }
        
        if (loggedIn) {
            System.out.println("환영합니다!");
            // 여기에 로그인 후 작업 추가
        }
    }
}
```

#### 실행 결과:
```
시스템에 로그인하세요.
패스워드: java
틀렸습니다! 남은 기회: 2번
패스워드: password
틀렸습니다! 남은 기회: 1번
패스워드: java2024

로그인 성공!
환영합니다!
```