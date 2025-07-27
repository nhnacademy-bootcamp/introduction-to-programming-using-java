# 2.5 표현식의 세부 사항 - 예제 모음

## 1. 산술 연산자 예제

### 예제 1-1: 기본 산술 연산
```java
public class ArithmeticOperators {
    public static void main(String[] args) {
        // TODO: 기본 산술 연산을 수행하고 결과를 출력하세요
        // 힌트:
        // 1. 정수 a=17, b=5 선언
        // 2. "=== 정수 연산 ===" 출력 후 a, b 값과 +, -, *, /, % 연산 결과 출력
        // 3. 실수 x=17.0, y=5.0 선언 후 실수 나눗셈과 나머지 연산 출력
        // 4. 음수와 양수의 나머지 연산 결과 확인 (17%5, -17%5, 17%-5, -17%-5)
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 정수 연산 ===
a = 17, b = 5
a + b = 22
a - b = 12
a * b = 85
a / b = 3
a % b = 2

=== 실수 연산 ===
x = 17.0, y = 5.0
x / y = 3.4
x % y = 2.0

=== 음수와 나머지 ===
17 % 5 = 2
-17 % 5 = -2
17 % -5 = 2
-17 % -5 = -2
```

### 예제 1-2: 정수 나눗셈의 함정
```java
public class IntegerDivisionPitfall {
    public static void main(String[] args) {
        // TODO: 정수 나눗셈의 문제점과 해결 방법을 보여주세요
        // 힌트:
        // 1. total=17, count=5로 선언
        // 2. 잘못된 평균: total / count를 double에 저장
        // 3. 올바른 평균: (double)total / count, total / (double)count, 1.0 * total / count
        // 4. 백분율 계산: score=85, totalScore=100일 때 잘못된 방법과 올바른 방법 비교
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
잘못된 평균: 3.0
올바른 평균1: 3.4
올바른 평균2: 3.4
올바른 평균3: 3.4

잘못된 백분율: 0.0%
올바른 백분율: 85.0%
```

### 예제 1-3: 나머지 연산자 활용
```java
public class ModuloOperator {
    public static void main(String[] args) {
        System.out.println("=== 나머지 연산자 활용 ===");
        
        // 1. 짝수/홀수 판별
        System.out.println("\n1. 짝수/홀수 판별:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "는 짝수");
            } else {
                System.out.println(i + "는 홀수");
            }
        }
        
        // 2. 자릿수 추출
        System.out.println("\n2. 자릿수 추출:");
        int number = 12345;
        System.out.println("숫자: " + number);
        System.out.println("1의 자리: " + (number % 10));
        System.out.println("10의 자리: " + (number / 10 % 10));
        System.out.println("100의 자리: " + (number / 100 % 10));
        
        // 3. 시간 변환
        System.out.println("\n3. 시간 변환:");
        int totalSeconds = 7265;  // 2시간 1분 5초
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        System.out.printf("%d초 = %d시간 %d분 %d초%n", 
                         totalSeconds, hours, minutes, seconds);
        
        // 4. 요일 계산
        System.out.println("\n4. 요일 계산:");
        String[] days = {"월", "화", "수", "목", "금", "토", "일"};
        int today = 3;  // 목요일
        int daysLater = 10;
        int futureDay = (today + daysLater) % 7;
        System.out.println("오늘이 " + days[today] + "요일이면");
        System.out.println(daysLater + "일 후는 " + days[futureDay] + "요일");
    }
}
```

## 2. 증가/감소 연산자 예제

### 예제 2-1: 전위와 후위의 차이
```java
public class IncrementDecrement {
    public static void main(String[] args) {
        // TODO: 전위/후위 증가/감소 연산자의 차이를 보여주세요
        // 힌트:
        // 1. "=== 증가/감소 연산자 ===" 출력
        // 2. 후위 증가(x++): x=5로 시작하여 사용 후 증가하는 과정 출력
        // 3. 전위 증가(++x): x=5로 시작하여 증가 후 사용하는 과정 출력
        // 4. 후위 감소(x--): x=5로 시작하여 사용 후 감소하는 과정 출력
        // 5. 전위 감소(--x): x=5로 시작하여 감소 후 사용하는 과정 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 증가/감소 연산자 ===

후위 증가 x++:
x = 5
x++ = 5
x = 6

전위 증가 ++x:
x = 5
++x = 6
x = 6

후위 감소 x--:
x = 5
x-- = 5
x = 4

전위 감소 --x:
x = 5
--x = 4
x = 4
```

### 예제 2-2: 증가/감소 연산자 함정
```java
public class IncrementPitfalls {
    public static void main(String[] args) {
        System.out.println("=== 증가/감소 연산자 함정 ===");
        
        // 함정 1: x = x++의 문제
        System.out.println("\n함정 1: x = x++");
        int x = 5;
        System.out.println("초기값: x = " + x);
        x = x++;  // x는 변하지 않음!
        System.out.println("x = x++ 후: x = " + x);  // 여전히 5
        
        // 올바른 사용
        x = 5;
        x++;  // 또는 x = x + 1;
        System.out.println("x++ 후: x = " + x);  // 6
        
        // 함정 2: 복잡한 표현식에서 사용
        System.out.println("\n함정 2: 복잡한 표현식");
        int a = 5, b = 5;
        int result1 = a++ * b++;  // 5 * 5 = 25
        System.out.println("a++ * b++ = " + result1);
        System.out.println("연산 후: a = " + a + ", b = " + b);  // 6, 6
        
        a = 5; b = 5;
        int result2 = ++a * ++b;  // 6 * 6 = 36
        System.out.println("++a * ++b = " + result2);
        System.out.println("연산 후: a = " + a + ", b = " + b);  // 6, 6
        
        // 함정 3: 같은 변수를 여러 번 수정
        System.out.println("\n함정 3: 혼란스러운 사용 (피해야 함)");
        int i = 1;
        int confusing = i++ + ++i + i++;  // 권장하지 않음!
        System.out.println("결과: " + confusing);
        System.out.println("i = " + i);
    }
}
```

### 예제 2-3: 실용적인 사용 예제
```java
public class IncrementPractical {
    public static void main(String[] args) {
        // 카운터로 사용
        System.out.println("=== 방문자 카운터 ===");
        int visitorCount = 0;
        
        System.out.println("현재 방문자: " + visitorCount);
        visitorCount++;  // 새 방문자
        System.out.println("방문자 1 입장: " + visitorCount);
        visitorCount++;  // 또 새 방문자
        System.out.println("방문자 2 입장: " + visitorCount);
        
        // 배열 인덱스로 사용
        System.out.println("\n=== 배열 순회 ===");
        int[] scores = {85, 90, 78, 92, 88};
        int index = 0;
        
        System.out.println("점수 목록:");
        System.out.println("학생 " + (index + 1) + ": " + scores[index++]);
        System.out.println("학생 " + (index + 1) + ": " + scores[index++]);
        System.out.println("학생 " + (index + 1) + ": " + scores[index++]);
        
        // 문자 증가
        System.out.println("\n=== 문자 증가 ===");
        char ch = 'A';
        System.out.println("현재 문자: " + ch);
        ch++;
        System.out.println("다음 문자: " + ch);  // 'B'
        
        // 알파벳 출력
        System.out.print("알파벳: ");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
```

## 3. 관계 연산자 예제

### 예제 3-1: 기본 비교 연산
```java
public class RelationalOperators {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 10;
        
        System.out.println("=== 관계 연산자 ===");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        
        // 동등 비교
        System.out.println("\n동등 비교:");
        System.out.println("a == b: " + (a == b));  // false
        System.out.println("a == c: " + (a == c));  // true
        System.out.println("a != b: " + (a != b));  // true
        System.out.println("a != c: " + (a != c));  // false
        
        // 크기 비교
        System.out.println("\n크기 비교:");
        System.out.println("a < b: " + (a < b));    // true
        System.out.println("a > b: " + (a > b));    // false
        System.out.println("a <= b: " + (a <= b));  // true
        System.out.println("a >= b: " + (a >= b));  // false
        System.out.println("a <= c: " + (a <= c));  // true
        System.out.println("a >= c: " + (a >= c));  // true
        
        // 문자 비교
        System.out.println("\n문자 비교:");
        char ch1 = 'A';
        char ch2 = 'B';
        char ch3 = 'a';
        
        System.out.println("'A' < 'B': " + (ch1 < ch2));   // true
        System.out.println("'A' < 'a': " + (ch1 < ch3));   // true (대문자가 먼저)
        System.out.println("'A'의 값: " + (int)ch1);       // 65
        System.out.println("'a'의 값: " + (int)ch3);       // 97
    }
}
```

### 예제 3-2: 범위 검사
```java
public class RangeCheck {
    public static void main(String[] args) {
        // 나이별 그룹 분류
        System.out.println("=== 나이별 그룹 분류 ===");
        int[] ages = {5, 13, 18, 25, 65, 70};
        
        for (int age : ages) {
            System.out.print("나이 " + age + "세: ");
            
            if (age < 13) {
                System.out.println("어린이");
            } else if (age >= 13 && age < 20) {
                System.out.println("청소년");
            } else if (age >= 20 && age < 65) {
                System.out.println("성인");
            } else {
                System.out.println("노인");
            }
        }
        
        // 성적 등급
        System.out.println("\n=== 성적 등급 ===");
        int[] scores = {95, 87, 73, 68, 55};
        
        for (int score : scores) {
            System.out.print("점수 " + score + ": ");
            
            if (score >= 90) {
                System.out.println("A등급");
            } else if (score >= 80) {
                System.out.println("B등급");
            } else if (score >= 70) {
                System.out.println("C등급");
            } else if (score >= 60) {
                System.out.println("D등급");
            } else {
                System.out.println("F등급");
            }
        }
    }
}
```

## 4. 논리 연산자 예제

### 예제 4-1: AND, OR, NOT 연산
```java
public class LogicalOperators {
    public static void main(String[] args) {
        // TODO: 논리 연산자의 동작과 실제 활용 예제를 작성하세요
        // 힌트:
        // 1. "=== 논리 연산자 ===" 출력
        // 2. AND 연산(&&): true&&true, true&&false, false&&true, false&&false 결과 출력
        // 3. OR 연산(||): true||true, true||false, false||true, false||false 결과 출력
        // 4. NOT 연산(!): !true, !false 결과 출력
        // 5. 실제 예제: age=25, hasLicense=true, isInsured=false를 사용하여
        //    운전 가능 여부, 차량 대여 가능 여부, 할인 대상 여부 판별
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 논리 연산자 ===

AND 연산 (&&):
true && true = true
true && false = false
false && true = false
false && false = false

OR 연산 (||):
true || true = true
true || false = true
false || true = true
false || false = false

NOT 연산 (!):
!true = false
!false = true

=== 실제 예제 ===
운전 가능: true
차량 대여 가능: false
할인 대상: false
```

### 예제 4-2: 단축 평가 (Short-circuit)
```java
public class ShortCircuit {
    public static void main(String[] args) {
        System.out.println("=== 단축 평가 예제 ===");
        
        // && 단축 평가
        System.out.println("\n&& 단축 평가:");
        int x = 0;
        boolean result1 = (x != 0) && (10 / x > 1);
        System.out.println("x = " + x);
        System.out.println("(x != 0) && (10 / x > 1) = " + result1);
        System.out.println("0으로 나누기 오류가 발생하지 않음!");
        
        // || 단축 평가
        System.out.println("\n|| 단축 평가:");
        boolean hasPermission = true;
        boolean isAdmin = false;
        
        if (hasPermission || checkComplexCondition()) {
            System.out.println("접근 허용");
            // hasPermission이 true이므로 checkComplexCondition()은 호출되지 않음
        }
        
        // 단축 평가를 이용한 null 체크
        System.out.println("\n단축 평가로 안전한 검사:");
        String str = null;
        
        // 안전한 방법
        if (str != null && str.length() > 0) {
            System.out.println("문자열이 비어있지 않음");
        } else {
            System.out.println("문자열이 null이거나 비어있음");
        }
        
        // 위험한 방법 (NullPointerException 발생)
        // if (str.length() > 0 && str != null) { } // 오류!
    }
    
    static boolean checkComplexCondition() {
        System.out.println("복잡한 조건 검사 실행됨!");
        return true;
    }
}
```

## 5. 조건 연산자 예제

### 예제 5-1: 기본 사용법
```java
public class ConditionalOperator {
    public static void main(String[] args) {
        // TODO: 조건 연산자(?:)를 사용한 다양한 예제를 작성하세요
        // 힌트:
        // 1. "=== 조건 연산자 (? :) ===" 출력
        // 2. a=10, b=20일 때 최댓값과 최솟값 구하기
        // 3. number=-15의 절댓값 구하기
        // 4. 1부터 5까지 짝수/홀수 판별하여 출력
        // 5. score=85일 때 중첩된 조건 연산자로 등급(A/B/C/D/F) 구하기
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 조건 연산자 (? :) ===
a = 10, b = 20
최댓값: 20
최솟값: 10

-15의 절댓값: 15

짝수/홀수 판별:
1는 홀수
2는 짝수
3는 홀수
4는 짝수
5는 홀수

점수 85의 등급: B
```

### 예제 5-2: 실용적인 활용
```java
public class ConditionalPractical {
    public static void main(String[] args) {
        // 할인 계산
        System.out.println("=== 할인 계산 ===");
        double price = 50000;
        boolean isVIP = true;
        double discount = isVIP ? 0.2 : 0.1;  // VIP는 20%, 일반은 10%
        double finalPrice = price * (1 - discount);
        
        System.out.printf("정가: %.0f원%n", price);
        System.out.printf("VIP 여부: %s%n", isVIP ? "예" : "아니오");
        System.out.printf("할인율: %.0f%%%n", discount * 100);
        System.out.printf("최종 가격: %.0f원%n", finalPrice);
        
        // 요일 표시
        System.out.println("\n=== 요일 표시 ===");
        int dayNumber = 5;  // 1=월, 2=화, ..., 7=일
        String dayName = (dayNumber == 1) ? "월요일" :
                        (dayNumber == 2) ? "화요일" :
                        (dayNumber == 3) ? "수요일" :
                        (dayNumber == 4) ? "목요일" :
                        (dayNumber == 5) ? "금요일" :
                        (dayNumber == 6) ? "토요일" :
                        (dayNumber == 7) ? "일요일" : "잘못된 날짜";
        System.out.println("오늘은 " + dayName);
        
        // 영업 시간 확인
        int hour = 15;  // 15시 (오후 3시)
        String status = (hour >= 9 && hour < 18) ? "영업중" : "영업종료";
        System.out.println("\n현재 " + hour + "시: " + status);
        
        // 온도에 따른 메시지
        int temperature = 28;
        String message = (temperature > 30) ? "매우 더움" :
                        (temperature > 20) ? "따뜻함" :
                        (temperature > 10) ? "선선함" :
                        (temperature > 0) ? "추움" : "매우 추움";
        System.out.println("\n온도 " + temperature + "°C: " + message);
    }
}
```

## 6. 타입 변환 예제

### 예제 6-1: 자동 타입 변환
```java
public class AutoTypeConversion {
    public static void main(String[] args) {
        System.out.println("=== 자동 타입 변환 ===");
        
        // 작은 타입에서 큰 타입으로
        byte byteValue = 100;
        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue;
        
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        
        // 연산 시 자동 변환
        System.out.println("\n=== 연산 시 자동 변환 ===");
        int x = 10;
        double y = 3.14;
        
        // int + double = double
        double result = x + y;
        System.out.println(x + " + " + y + " = " + result);
        
        // 문자의 자동 변환
        char ch = 'A';
        int chValue = ch;  // char → int
        System.out.println("\n'" + ch + "'의 숫자값: " + chValue);
    }
}
```

### 예제 6-2: 강제 타입 변환 (캐스팅)
```java
public class TypeCasting {
    public static void main(String[] args) {
        // TODO: 강제 타입 변환(캐스팅)의 다양한 예제를 작성하세요
        // 힌트:
        // 1. "=== 강제 타입 변환 ===" 출력
        // 2. pi=3.14159를 (int)로 캐스팅하여 소수부분 버림 확인
        // 3. bigNumber=130을 (byte)로 캐스팅하여 오버플로우 확인
        // 4. a=7, b=2의 정수 나눗셈과 (double)a/b 실수 나눗셈 비교
        // 5. letter='Z'를 ASCII 값으로 변환하고, +32하여 소문자로 변환
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 강제 타입 변환 ===
pi = 3.14159
(int)pi = 3

bigNumber = 130
(byte)bigNumber = -126

정수 나눗셈:
7 / 2 = 3.0
(double)7 / 2 = 3.5

문자 변환:
'Z' → 90
90 + 32 → 'z'
```

### 예제 6-3: 문자열 변환
```java
public class StringConversion {
    public static void main(String[] args) {
        System.out.println("=== 문자열 변환 ===");
        
        // 기본 타입 → String
        int num = 42;
        double pi = 3.14;
        boolean flag = true;
        char ch = 'A';
        
        // 방법 1: + 연산자
        String str1 = num + "";
        String str2 = "" + pi;
        
        // 방법 2: String.valueOf() (권장)
        String str3 = String.valueOf(flag);
        String str4 = String.valueOf(ch);
        
        System.out.println("int → String: " + str1);
        System.out.println("double → String: " + str2);
        System.out.println("boolean → String: " + str3);
        System.out.println("char → String: " + str4);
        
        // String → 기본 타입
        System.out.println("\n=== String → 기본 타입 ===");
        
        String numStr = "123";
        String doubleStr = "45.67";
        String boolStr = "true";
        
        int intValue = Integer.parseInt(numStr);
        double doubleValue = Double.parseDouble(doubleStr);
        boolean boolValue = Boolean.parseBoolean(boolStr);
        
        System.out.println("\"" + numStr + "\" → " + intValue);
        System.out.println("\"" + doubleStr + "\" → " + doubleValue);
        System.out.println("\"" + boolStr + "\" → " + boolValue);
        
        // 변환 오류 처리
        System.out.println("\n=== 변환 오류 예제 ===");
        String invalidNumber = "abc123";
        try {
            int value = Integer.parseInt(invalidNumber);
        } catch (NumberFormatException e) {
            System.out.println("\"" + invalidNumber + "\"는 숫자로 변환할 수 없습니다!");
        }
    }
}
```

## 7. 복합 할당 연산자 예제

### 예제 7-1: 기본 사용법
```java
public class CompoundAssignment {
    public static void main(String[] args) {
        System.out.println("=== 복합 할당 연산자 ===");
        
        // 숫자 연산
        int x = 10;
        System.out.println("초기값: x = " + x);
        
        x += 5;   // x = x + 5
        System.out.println("x += 5 → x = " + x);    // 15
        
        x -= 3;   // x = x - 3
        System.out.println("x -= 3 → x = " + x);    // 12
        
        x *= 2;   // x = x * 2
        System.out.println("x *= 2 → x = " + x);    // 24
        
        x /= 4;   // x = x / 4
        System.out.println("x /= 4 → x = " + x);    // 6
        
        x %= 4;   // x = x % 4
        System.out.println("x %= 4 → x = " + x);    // 2
        
        // 문자열 연결
        System.out.println("\n=== 문자열 연결 ===");
        String message = "Hello";
        System.out.println("초기값: \"" + message + "\"");
        
        message += " ";
        message += "World";
        message += "!";
        System.out.println("최종값: \"" + message + "\"");
        
        // 실제 활용 예
        System.out.println("\n=== 실제 활용 예 ===");
        
        // 누적 합계
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum);
        }
        
        // 할인 적용
        double price = 100000;
        System.out.println("\n원가: " + price + "원");
        price *= 0.9;  // 10% 할인
        System.out.println("10% 할인 후: " + price + "원");
        price *= 0.95; // 추가 5% 할인
        System.out.println("추가 5% 할인 후: " + price + "원");
    }
}
```

## 8. 연산자 우선순위 예제

### 예제 8-1: 우선순위 확인
```java
public class OperatorPrecedence {
    public static void main(String[] args) {
        System.out.println("=== 연산자 우선순위 ===");
        
        // 산술 연산자 우선순위
        int result1 = 2 + 3 * 4;        // 2 + 12 = 14
        int result2 = (2 + 3) * 4;      // 5 * 4 = 20
        int result3 = 10 / 2 * 3;       // 5 * 3 = 15 (왼쪽에서 오른쪽)
        int result4 = 10 / (2 * 3);     // 10 / 6 = 1
        
        System.out.println("2 + 3 * 4 = " + result1);
        System.out.println("(2 + 3) * 4 = " + result2);
        System.out.println("10 / 2 * 3 = " + result3);
        System.out.println("10 / (2 * 3) = " + result4);
        
        // 관계 연산자와 논리 연산자
        int x = 5, y = 3, z = 7;
        boolean test1 = x > y && y < z;     // true && true = true
        boolean test2 = x > y || y > z;     // true || false = true
        boolean test3 = x + y > z;          // 8 > 7 = true
        boolean test4 = x > y + z;          // 5 > 10 = false
        
        System.out.println("\nx = " + x + ", y = " + y + ", z = " + z);
        System.out.println("x > y && y < z = " + test1);
        System.out.println("x > y || y > z = " + test2);
        System.out.println("x + y > z = " + test3);
        System.out.println("x > y + z = " + test4);
        
        // 복잡한 예제
        int a = 5, b = 3, c = 2;
        int complex = a + b * c - a % b;  // 5 + 6 - 2 = 9
        System.out.println("\na = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a + b * c - a % b = " + complex);
        System.out.println("계산 순서: " + a + " + (" + b + " * " + c + 
                          ") - (" + a + " % " + b + ")");
        System.out.println("= " + a + " + " + (b * c) + " - " + (a % b));
        System.out.println("= " + a + " + 6 - 2 = " + complex);
    }
}
```

### 예제 8-2: 괄호의 중요성
```java
public class ParenthesesImportance {
    public static void main(String[] args) {
        System.out.println("=== 괄호의 중요성 ===");
        
        // 예제 1: 평균 계산
        int score1 = 80, score2 = 90, score3 = 70;
        
        // 잘못된 계산
        double wrongAvg = score1 + score2 + score3 / 3;  // 80 + 90 + 23.33...
        
        // 올바른 계산
        double correctAvg = (score1 + score2 + score3) / 3.0;
        
        System.out.println("점수: " + score1 + ", " + score2 + ", " + score3);
        System.out.println("잘못된 평균: " + wrongAvg);
        System.out.println("올바른 평균: " + correctAvg);
        
        // 예제 2: 조건식
        int age = 25;
        boolean hasLicense = true;
        boolean hasInsurance = false;
        
        // 의도가 불분명한 조건
        boolean unclear = age >= 18 && hasLicense || hasInsurance;
        
        // 명확한 조건 1
        boolean clear1 = (age >= 18 && hasLicense) || hasInsurance;
        
        // 명확한 조건 2
        boolean clear2 = age >= 18 && (hasLicense || hasInsurance);
        
        System.out.println("\nage = " + age + ", hasLicense = " + 
                          hasLicense + ", hasInsurance = " + hasInsurance);
        System.out.println("불명확: age >= 18 && hasLicense || hasInsurance = " + unclear);
        System.out.println("명확1: (age >= 18 && hasLicense) || hasInsurance = " + clear1);
        System.out.println("명확2: age >= 18 && (hasLicense || hasInsurance) = " + clear2);
        
        // 예제 3: 타입 캐스팅
        int a = 7, b = 2;
        
        // 잘못된 캐스팅
        double wrong = (double)(a / b);    // 3.0
        
        // 올바른 캐스팅
        double correct = (double)a / b;    // 3.5
        
        System.out.println("\n타입 캐스팅:");
        System.out.println("(double)(7 / 2) = " + wrong);
        System.out.println("(double)7 / 2 = " + correct);
    }
}
```

## 9. 종합 예제

### 예제 9-1: 계산기 프로그램
```java
public class CalculatorExample {
    public static void main(String[] args) {
        // TODO: 조건 연산자를 활용한 계산기를 만드세요
        // 힌트:
        // 1. "=== 계산기 예제 ===" 출력
        // 2. num1=10.5, num2=3.2, operator='*' 선언
        // 3. 조건 연산자를 사용하여 operator에 따라 사칙연산 수행
        // 4. validOperation으로 올바른 연산자인지 확인
        // 5. printf로 "10.5 * 3.2 = 결과" 형식으로 출력
        // 6. 나눗셈인 경우 나머지도 계산하여 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 계산기 예제 ===
10.5 * 3.2 = 33.60
```

### 예제 9-2: 성적 처리 시스템
```java
public class GradeSystem {
    public static void main(String[] args) {
        // TODO: 종합적인 성적 처리 시스템을 만드세요
        // 힌트:
        // 1. "=== 성적 처리 시스템 ===" 출력
        // 2. 학생 정보: name="김학생", midterm=85, finalExam=92, homework=88, attendance=95
        // 3. 가중치: 중간30%, 기말40%, 과제20%, 출석10%
        // 4. 총점 계산: 각 점수 × 가중치의 합
        // 5. 조건 연산자로 학점 계산 (95이상=A+, 90이상=A, 85이상=B+, ...)
        // 6. 장학금 자격: 총점 90이상 && 출석 90이상
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 성적 처리 시스템 ===

학생: 김학생
중간고사: 85 (30%)
기말고사: 92 (40%)
과제: 88 (20%)
출석: 95 (10%)
총점: 89.3
학점: B+
장학금 자격: 없음
```