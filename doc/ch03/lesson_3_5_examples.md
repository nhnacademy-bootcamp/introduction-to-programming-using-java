# 3.5 if문 - 예제 모음

## 1. 기본 if문 예제

### 예제 1-1: 단순 조건 검사
```java
public class BasicIfExample {
    public static void main(String[] args) {
        int age = 20;
        double temperature = 36.5;
        boolean isRaining = false;
        
        // TODO: 단순 if
        // 힌트:
        // 1. age가 18 이상이면 "성인입니다." 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: if-else
        // 힌트:
        // 1. temperature가 37.5보다 크면 "발열이 있습니다." 출력
        // 2. 그렇지 않으면 "정상 체온입니다." 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: boolean 변수 사용
        // 힌트:
        // 1. isRaining이 false일 때 (!isRaining) "우산이 필요 없습니다." 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: 복합 조건
        // 힌트:
        // 1. age가 18 이상이고 65 미만일 때 "일반 성인 요금이 적용됩니다." 출력
        // 2. && 연산자 사용
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
성인입니다.
정상 체온입니다.
우산이 필요 없습니다.
일반 성인 요금이 적용됩니다.
```

### 예제 1-2: 숫자 분류
```java
import textio.TextIO;

public class NumberClassification {
    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요: ");
        double number = TextIO.getlnDouble();
        
        // TODO: 양수, 음수, 0 판별
        // 힌트:
        // 1. number > 0이면 "양수입니다." 출력
        //    - 추가로 1000보다 크면 "매우 큰 양수입니다."
        //    - 1보다 작으면 "0과 1 사이의 양수입니다."
        // 2. number < 0이면 "음수입니다." 출력
        //    - 추가로 -1000보다 작으면 "매우 작은 음수입니다."
        // 3. 그 외(0)이면 "0입니다." 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: 정수/실수 판별
        // 힌트:
        // 1. number를 int로 캐스팅한 값과 같으면 "정수입니다."
        // 2. 그렇지 않으면 "실수입니다."
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
숫자를 입력하세요: 1500
양수입니다.
매우 큰 양수입니다.
정수입니다.

숫자를 입력하세요: -0.5
음수입니다.
실수입니다.

숫자를 입력하세요: 0
0입니다.
정수입니다.
```

## 2. 다중 분기 (else-if) 예제

### 예제 2-1: 성적 등급 시스템
```java
import textio.TextIO;

public class GradeSystem {
    public static void main(String[] args) {
        System.out.print("점수를 입력하세요 (0-100): ");
        double score = TextIO.getlnDouble();
        
        String grade;
        String comment;
        
        // 입력 검증
        if (score < 0 || score > 100) {
            System.out.println("유효하지 않은 점수입니다!");
            return;
        }
        
        // TODO: 등급 결정
        // 힌트:
        // 1. score >= 95: grade = "A+", comment = "탁월합니다!"
        // 2. score >= 90: grade = "A", comment = "우수합니다!"
        // 3. score >= 85: grade = "B+", comment = "매우 좋습니다!"
        // 4. score >= 80: grade = "B", comment = "좋습니다!"
        // 5. score >= 75: grade = "C+", comment = "양호합니다."
        // 6. score >= 70: grade = "C", comment = "보통입니다."
        // 7. score >= 65: grade = "D+", comment = "노력이 필요합니다."
        // 8. score >= 60: grade = "D", comment = "많은 노력이 필요합니다."
        // 9. 그 외: grade = "F", comment = "재수강이 필요합니다."
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n=== 성적 결과 ===");
        System.out.printf("점수: %.1f%n", score);
        System.out.println("등급: " + grade);
        System.out.println("평가: " + comment);
        
        // TODO: 장학금 자격
        // 힌트:
        // 1. score가 90 이상이면 "🎉 장학금 대상자입니다!" 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
점수를 입력하세요 (0-100): 92.5

=== 성적 결과 ===
점수: 92.5
등급: A
평가: 우수합니다!
🎉 장학금 대상자입니다!
```

### 예제 2-2: 온도에 따른 조언
```java
import textio.TextIO;

public class TemperatureAdvice {
    public static void main(String[] args) {
        System.out.print("현재 온도를 입력하세요 (섭씨): ");
        double temp = TextIO.getlnDouble();
        
        String advice;
        String clothing;
        
        // TODO: 온도에 따른 조언과 복장 추천
        // 힌트:
        // 1. temp < -10: advice = "매우 춥습니다. 외출을 자제하세요.", clothing = "두꺼운 코트, 목도리, 장갑, 모자"
        // 2. temp < 0: advice = "춥습니다. 따뜻하게 입으세요.", clothing = "겨울 코트, 목도리"
        // 3. temp < 10: advice = "쌀쌀합니다.", clothing = "자켓이나 가디건"
        // 4. temp < 20: advice = "선선합니다.", clothing = "긴팔 셔츠"
        // 5. temp < 25: advice = "쾌적한 날씨입니다.", clothing = "반팔이나 긴팔"
        // 6. temp < 30: advice = "따뜻합니다.", clothing = "반팔 셔츠"
        // 7. temp < 35: advice = "덥습니다. 수분을 충분히 섭취하세요.", clothing = "가벼운 옷"
        // 8. 그 외: advice = "매우 덥습니다. 야외 활동을 자제하세요.", clothing = "최대한 가벼운 옷"
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n=== 날씨 정보 ===");
        System.out.printf("온도: %.1f°C%n", temp);
        System.out.println("조언: " + advice);
        System.out.println("추천 복장: " + clothing);
        
        // TODO: 추가 경고
        // 힌트:
        // 1. temp가 -20 미만이거나 40 초과이면 "⚠️ 극한 날씨 주의!" 출력
        // 2. || 연산자 사용
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
현재 온도를 입력하세요 (섭씨): 23

=== 날씨 정보 ===
온도: 23.0°C
조언: 쾌적한 날씨입니다.
추천 복장: 반팔이나 긴팔

현재 온도를 입력하세요 (섭씨): -15

=== 날씨 정보 ===
온도: -15.0°C
조언: 매우 춥습니다. 외출을 자제하세요.
추천 복장: 두꺼운 코트, 목도리, 장갑, 모자
⚠️ 극한 날씨 주의!
```

## 3. 중첩된 if문 예제

### 예제 3-1: 로그인 시스템
```java
import textio.TextIO;

public class LoginSystem {
    public static void main(String[] args) {
        // 미리 설정된 사용자 정보
        String validUsername = "admin";
        String validPassword = "1234";
        boolean isAccountLocked = false;
        int loginAttempts = 0;
        
        System.out.println("=== 로그인 시스템 ===");
        
        if (isAccountLocked) {
            System.out.println("계정이 잠겨 있습니다. 관리자에게 문의하세요.");
        } else {
            System.out.print("사용자명: ");
            String username = TextIO.getln();
            
            // TODO: 로그인 처리
            // 힌트:
            // 1. username이 validUsername과 같으면:
            //    - "비밀번호: " 프롬프트 출력
            //    - password 입력받기
            //    - password가 validPassword와 같으면:
            //      * "로그인 성공! 환영합니다, [username]님!" 출력
            //      * username이 "admin"이면 "관리자 권한이 있습니다." 출력
            //      * 그렇지 않으면 "일반 사용자 권한입니다." 출력
            //    - password가 틀리면:
            //      * "비밀번호가 틀렸습니다." 출력
            //      * loginAttempts 증가
            //      * loginAttempts가 3 이상이면 "3회 실패로 계정이 잠겼습니다." 출력
            // 2. username이 틀리면 "존재하지 않는 사용자명입니다." 출력
            
            // 여기에 코드를 작성하세요
        }
    }
}
```

#### 실행 결과:
```
=== 로그인 시스템 ===
사용자명: admin
비밀번호: 1234
로그인 성공! 환영합니다, admin님!
관리자 권한이 있습니다.

=== 로그인 시스템 ===
사용자명: user
존재하지 않는 사용자명입니다.
```

### 예제 3-2: 세 수 정렬하기
```java
import textio.TextIO;

public class SortThreeNumbers {
    public static void main(String[] args) {
        System.out.println("세 개의 숫자를 입력하면 오름차순으로 정렬합니다.");
        
        System.out.print("첫 번째 숫자: ");
        int x = TextIO.getlnInt();
        System.out.print("두 번째 숫자: ");
        int y = TextIO.getlnInt();
        System.out.print("세 번째 숫자: ");
        int z = TextIO.getlnInt();
        
        System.out.print("\n정렬 결과: ");
        
        // TODO: 세 수 정렬 로직
        // 힌트:
        // 1. x가 가장 작은 경우 (x <= y && x <= z):
        //    - x 출력 후 y와 z 비교하여 순서대로 출력
        // 2. x가 가장 큰 경우 (x >= y && x >= z):
        //    - y와 z를 먼저 비교하여 출력 후 x 출력
        // 3. x가 중간인 경우:
        //    - y와 z를 비교하여 작은 것, x, 큰 것 순으로 출력
        
        // 여기에 코드를 작성하세요
        
        // TODO: 추가 정보 계산
        // 힌트:
        // 1. min을 x로 초기화
        // 2. max를 x로 초기화
        // 3. y가 min보다 작으면 min = y
        // 4. z가 min보다 작으면 min = z
        // 5. y가 max보다 크면 max = y
        // 6. z가 max보다 크면 max = z
        // 7. 최솟값, 최댓값, 범위(max-min) 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
세 개의 숫자를 입력하면 오름차순으로 정렬합니다.
첫 번째 숫자: 7
두 번째 숫자: 3
세 번째 숫자: 9

정렬 결과: 3 7 9

최솟값: 3
최댓값: 9
범위: 6
```

## 4. 달랑거리는 else 문제 예제

### 예제 4-1: 문제 시연
```java
public class DanglingElseDemo {
    public static void main(String[] args) {
        int x = 5;
        int y = -3;
        
        System.out.println("=== 달랑거리는 else 문제 시연 ===");
        System.out.println("x = " + x + ", y = " + y);
        
        // 문제가 있는 코드 (의도와 다르게 동작)
        System.out.println("\n1. 잘못된 들여쓰기:");
        if (x > 0)
            if (y > 0)
                System.out.println("  둘 다 양수");
        else  // 이 else는 if (y > 0)과 연결됨!
            System.out.println("  x가 음수");  // 실제로는 y가 음수일 때 실행
        
        // 올바른 코드 1: 중괄호 사용
        System.out.println("\n2. 중괄호로 명확하게:");
        if (x > 0) {
            if (y > 0)
                System.out.println("  둘 다 양수");
        } else {
            System.out.println("  x가 음수 또는 0");
        }
        
        // 올바른 코드 2: 모든 경우 처리
        System.out.println("\n3. 모든 경우 명시:");
        if (x > 0) {
            if (y > 0) {
                System.out.println("  둘 다 양수");
            } else {
                System.out.println("  x는 양수, y는 음수 또는 0");
            }
        } else {
            System.out.println("  x가 음수 또는 0");
        }
    }
}
```

#### 실행 결과:
```
=== 달랑거리는 else 문제 시연 ===
x = 5, y = -3

1. 잘못된 들여쓰기:
  x가 음수

2. 중괄호로 명확하게:

3. 모든 경우 명시:
  x는 양수, y는 음수 또는 0
```

## 5. 복잡한 조건 예제

### 예제 5-1: 윤년 판별
```java
import textio.TextIO;

public class LeapYearChecker {
    public static void main(String[] args) {
        System.out.print("년도를 입력하세요: ");
        int year = TextIO.getlnInt();
        
        boolean isLeapYear;
        String reason;
        
        // TODO: 윤년 판별 로직
        // 힌트:
        // 1. year % 400 == 0: isLeapYear = true, reason = "400으로 나누어떨어지므로"
        // 2. year % 100 == 0: isLeapYear = false, reason = "100으로 나누어떨어지지만 400으로는 안 되므로"
        // 3. year % 4 == 0: isLeapYear = true, reason = "4로 나누어떨어지고 100으로는 안 되므로"
        // 4. 그 외: isLeapYear = false, reason = "4로 나누어떨어지지 않으므로"
        
        // 여기에 코드를 작성하세요
        
        // 결과 출력
        if (isLeapYear) {
            System.out.println(year + "년은 윤년입니다.");
        } else {
            System.out.println(year + "년은 평년입니다.");
        }
        System.out.println("이유: " + reason);
        
        // 2월의 일수
        int daysInFebruary = isLeapYear ? 29 : 28;
        System.out.println(year + "년 2월은 " + daysInFebruary + "일입니다.");
    }
}
```

#### 실행 결과:
```
년도를 입력하세요: 2024
2024년은 윤년입니다.
이유: 400으로 나누어떨어지므로
2024년 2월은 29일입니다.

년도를 입력하세요: 1900
1900년은 평년입니다.
이유: 100으로 나누어떨어지지만 400으로는 안 되므로
1900년 2월은 28일입니다.
```

### 예제 5-2: 삼각형 판별
```java
import textio.TextIO;

public class TriangleClassifier {
    public static void main(String[] args) {
        System.out.println("=== 삼각형 판별기 ===");
        System.out.println("세 변의 길이를 입력하세요.");
        
        System.out.print("변 a: ");
        double a = TextIO.getlnDouble();
        System.out.print("변 b: ");
        double b = TextIO.getlnDouble();
        System.out.print("변 c: ");
        double c = TextIO.getlnDouble();
        
        // 삼각형 성립 조건 확인
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("변의 길이는 양수여야 합니다!");
        } else if (a + b <= c || b + c <= a || a + c <= b) {
            System.out.println("삼각형을 만들 수 없습니다!");
            System.out.println("(두 변의 합이 나머지 한 변보다 커야 합니다)");
        } else {
            System.out.println("삼각형을 만들 수 있습니다!");
            
            // TODO: 삼각형 종류 판별
            // 힌트:
            // 1. a == b && b == c: "종류: 정삼각형"
            // 2. a == b || b == c || a == c: "종류: 이등변삼각형"
            //    - 어느 두 변이 같은지 추가로 출력
            // 3. 그 외: "종류: 일반 삼각형"
            
            // 여기에 코드를 작성하세요
            
            // TODO: 직각삼각형 확인 (피타고라스 정리)
            // 힌트:
            // 1. a², b², c²을 계산
            // 2. a² + b² = c² 또는 b² + c² = a² 또는 a² + c² = b² 확인
            // 3. 부동소수점 오차를 고려하여 Math.abs() < 0.0001 사용
            // 4. 조건을 만족하면 "추가: 직각삼각형입니다!" 출력
            
            // 여기에 코드를 작성하세요
        }
    }
}
```

#### 실행 결과:
```
=== 삼각형 판별기 ===
세 변의 길이를 입력하세요.
변 a: 3
변 b: 4
변 c: 5
삼각형을 만들 수 있습니다!
종류: 일반 삼각형
추가: 직각삼각형입니다!

=== 삼각형 판별기 ===
세 변의 길이를 입력하세요.
변 a: 5
변 b: 5
변 c: 5
삼각형을 만들 수 있습니다!
종류: 정삼각형
```

## 6. 단위 변환기 예제

### 예제 6-1: 완전한 길이 단위 변환기
```java
import textio.TextIO;

public class LengthConverter {
    public static void main(String[] args) {
        System.out.println("=== 길이 단위 변환기 ===");
        System.out.println("사용법: 숫자와 단위를 입력 (예: 5.5 feet)");
        System.out.println("지원 단위: inch(in), feet(ft), yard(yd), mile(mi)");
        System.out.println("종료: 0 입력\n");
        
        while (true) {
            System.out.print("측정값 입력: ");
            double measurement = TextIO.getDouble();
            
            if (measurement == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            String unit = TextIO.getlnWord().toLowerCase();
            
            // TODO: 인치로 변환
            // 힌트:
            // 1. unit이 "inch", "inches", "in" 중 하나면: inches = measurement
            // 2. unit이 "foot", "feet", "ft" 중 하나면: inches = measurement * 12
            // 3. unit이 "yard", "yards", "yd" 중 하나면: inches = measurement * 36
            // 4. unit이 "mile", "miles", "mi" 중 하나면: inches = measurement * 12 * 5280
            // 5. 그 외: 오류 메시지 출력 후 continue
            double inches;
            
            // 여기에 코드를 작성하세요
            
            // 모든 단위로 변환
            double feet = inches / 12.0;
            double yards = inches / 36.0;
            double miles = inches / (12.0 * 5280.0);
            
            // 결과 출력
            System.out.println("\n변환 결과:");
            System.out.printf("  %,.2f inches%n", inches);
            System.out.printf("  %,.2f feet%n", feet);
            System.out.printf("  %,.2f yards%n", yards);
            System.out.printf("  %,.6f miles%n", miles);
            
            // TODO: 추가 정보
            // 힌트:
            // 1. inches < 12: "팁: 1피트보다 작습니다."
            // 2. inches < 36: "팁: 1야드보다 작습니다."
            // 3. miles >= 1: "팁: 1마일 이상입니다!"
            
            // 여기에 코드를 작성하세요
            
            System.out.println();
        }
    }
}
```

#### 실행 결과:
```
=== 길이 단위 변환기 ===
사용법: 숫자와 단위를 입력 (예: 5.5 feet)
지원 단위: inch(in), feet(ft), yard(yd), mile(mi)
종료: 0 입력

측정값 입력: 5.5 feet

변환 결과:
  66.00 inches
  5.50 feet
  1.83 yards
  0.001042 miles
팁: 1야드보다 큽니다.

측정값 입력: 1 mile

변환 결과:
  63,360.00 inches
  5,280.00 feet
  1,760.00 yards
  1.000000 miles
팁: 1마일 이상입니다!

측정값 입력: 0
프로그램을 종료합니다.
```

## 7. 빈 명령문 예제

### 예제 7-1: 빈 명령문의 올바른 사용과 오류
```java
public class EmptyStatementExample {
    public static void main(String[] args) {
        int x = 10;
        boolean ready = true;
        
        System.out.println("=== 빈 명령문 예제 ===");
        
        // 의도적인 빈 명령문 사용
        if (ready)
            ;  // 준비되었으면 아무것도 안 함
        else
            System.out.println("아직 준비 안 됨");
        
        // 더 나은 방법
        if (!ready) {
            System.out.println("아직 준비 안 됨");
        }
        
        // 실수하기 쉬운 경우 1
        System.out.println("\n실수 예제 1:");
        for (int i = 0; i < 3; i++);  // 세미콜론 때문에 빈 루프
        {
            System.out.println("이 줄은 한 번만 실행됩니다!");
        }
        
        // 올바른 코드
        System.out.println("\n올바른 코드:");
        for (int i = 0; i < 3; i++) {
            System.out.println("반복 " + (i + 1));
        }
        
        // 실수하기 쉬운 경우 2
        System.out.println("\n실수 예제 2:");
        if (x > 5);  // 세미콜론 때문에 조건이 무의미
        {
            System.out.println("이 줄은 항상 실행됩니다!");
        }
        
        // while 루프에서의 의도적 사용
        System.out.println("\n의도적 사용:");
        int count = 0;
        while (++count < 5)
            ;  // 카운트만 증가
        System.out.println("최종 count: " + count);
    }
}
```

#### 실행 결과:
```
=== 빈 명령문 예제 ===

실수 예제 1:
이 줄은 한 번만 실행됩니다!

올바른 코드:
반복 1
반복 2
반복 3

실수 예제 2:
이 줄은 항상 실행됩니다!

의도적 사용:
최종 count: 5
```

## 8. 종합 예제

### 예제 8-1: 계산기 프로그램
```java
import textio.TextIO;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("=== 간단한 계산기 ===");
        
        System.out.print("첫 번째 숫자: ");
        double num1 = TextIO.getlnDouble();
        
        System.out.print("연산자 (+, -, *, /, %, ^): ");
        String operator = TextIO.getln().trim();
        
        System.out.print("두 번째 숫자: ");
        double num2 = TextIO.getlnDouble();
        
        double result = 0;
        boolean validOperation = true;
        String operation = "";
        
        // TODO: 연산자별 계산
        // 힌트:
        // 1. operator가 "+"이면: result = num1 + num2, operation = "덧셈"
        // 2. operator가 "-"이면: result = num1 - num2, operation = "뺄셈"
        // 3. operator가 "*"이면: result = num1 * num2, operation = "곱셈"
        // 4. operator가 "/"이면:
        //    - num2가 0이면 오류 메시지 출력하고 validOperation = false
        //    - 그렇지 않으면 result = num1 / num2, operation = "나눗셈"
        // 5. operator가 "%"이면:
        //    - num2가 0이면 오류 메시지 출력하고 validOperation = false
        //    - 그렇지 않으면 result = num1 % num2, operation = "나머지"
        // 6. operator가 "^"이면: result = Math.pow(num1, num2), operation = "거듭제곱"
        // 7. 그 외: 오류 메시지 출력하고 validOperation = false
        
        // 여기에 코드를 작성하세요
        
        if (validOperation) {
            System.out.println("\n=== 계산 결과 ===");
            System.out.println("연산: " + operation);
            System.out.printf("%.2f %s %.2f = %.2f%n", num1, operator, num2, result);
            
            // TODO: 추가 정보
            // 힌트:
            // 1. result가 정수값이면 (int로 캐스팅한 값과 같으면) 정수로 출력
            // 2. result < 0이면 "결과는 음수입니다."
            // 3. result > 0이면 "결과는 양수입니다."
            // 4. 그 외(0)이면 "결과는 0입니다."
            
            // 여기에 코드를 작성하세요
        }
    }
}
```

#### 실행 결과:
```
=== 간단한 계산기 ===
첫 번째 숫자: 10
연산자 (+, -, *, /, %, ^): +
두 번째 숫자: 5

=== 계산 결과 ===
연산: 덧셈
10.00 + 5.00 = 15.00
정수값: 15
결과는 양수입니다.

=== 간단한 계산기 ===
첫 번째 숫자: 8
연산자 (+, -, *, /, %, ^): /
두 번째 숫자: 0
0으로 나눌 수 없습니다\!
```
