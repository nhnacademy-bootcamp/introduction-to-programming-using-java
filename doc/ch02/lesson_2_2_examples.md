# 2.2 변수와 기본 타입 - 예제 모음

## 1. 식별자 예제

### 예제 1-1: 유효한 식별자와 무효한 식별자
```java
public class IdentifierExamples {
    public static void main(String[] args) {
        // TODO: 유효한 식별자 예제를 작성하세요
        // 힌트:
        // 1. age = 25 (정수형 변수)
        // 2. _temperature = 36.5 (밑줄로 시작하는 변수)
        // 3. firstName = "John" (camelCase 변수)
        // 4. isStudent = true (boolean 변수)
        // 5. $currency = '$' (달러 기호로 시작, 권장하지 않음)
        
        // TODO: 대소문자 구분 예제를 작성하세요
        // 힌트:
        // 1. count = 10
        // 2. Count = 20 (count와 다른 변수)
        // 3. COUNT = 30 (count, Count와 다른 변수)
        // 4. 세 변수를 모두 출력하여 차이를 보여주세요
        
        // 주의: 아래는 무효한 식별자 예제입니다 (주석 처리됨)
        // int 3rdPlace = 3;        // 오류: 숫자로 시작
        // double my-score = 95.5;  // 오류: 하이픈 사용
        // String first name = "";  // 오류: 공백 포함
        // boolean class = true;    // 오류: 예약어 사용
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
count = 10
Count = 20
COUNT = 30
```

### 예제 1-2: 명명 규칙 실습
```java
public class NamingConventions {
    // TODO: 상수를 선언하세요 (모두 대문자, 밑줄로 구분)
    // 힌트:
    // 1. PI = 3.14159 (public static final double)
    // 2. MAX_STUDENTS = 100 (public static final int)
    // 3. DEFAULT_COUNTRY = "Korea" (public static final String)
    
    public static void main(String[] args) {
        // TODO: camelCase를 사용하여 변수를 선언하세요
        // 힌트:
        // 1. studentAge = 20 (학생 나이)
        // 2. averageScore = 85.5 (평균 점수)
        // 3. courseName = "Introduction to Java" (과목명)
        // 4. isPassed = true (합격 여부)
        
        // TODO: 여러 단어로 된 변수명을 작성하세요
        // 힌트:
        // 1. monthlyInterestRate = 0.01 (월 이자율)
        // 2. numberOfDaysInYear = 365 (연간 일수)
        // 3. currentUserName = "admin" (현재 사용자명)
        
        // TODO: 메소드를 호출하세요
        // 힌트:
        // 1. printStudentInfo 메소드 호출 (studentAge, averageScore 전달)
        // 2. calculateFinalScore 메소드 호출하여 결과를 finalScore에 저장
        
        // 여기에 코드를 작성하세요
    }
    
    // TODO: 학생 정보를 출력하는 메소드를 구현하세요
    // 힌트: "나이: [age], 점수: [score]" 형식으로 출력
    public static void printStudentInfo(int age, double score) {
        // 여기에 코드를 작성하세요
    }
    
    // TODO: 최종 점수를 계산하는 메소드를 구현하세요
    // 힌트: base + bonus를 반환
    public static double calculateFinalScore(double base, double bonus) {
        // 여기에 코드를 작성하세요
        return 0; // 임시 반환값
    }
}
```

#### 실행 결과:
```
나이: 20, 점수: 85.5
```
```

## 2. 변수 선언과 할당 예제

### 예제 2-1: 기본 변수 선언과 할당
```java
public class VariableBasics {
    public static void main(String[] args) {
        // TODO: 변수를 선언만 하세요 (초기화하지 않음)
        // 힌트:
        // 1. count (int 타입)
        // 2. price (double 타입)
        // 3. isAvailable (boolean 타입)
        
        // TODO: 위에서 선언한 변수에 값을 할당하세요
        // 힌트:
        // 1. count = 10
        // 2. price = 29.99
        // 3. isAvailable = true
        
        // TODO: 선언과 동시에 초기화하세요
        // 힌트:
        // 1. quantity = 5 (int)
        // 2. discount = 0.15 (double)
        // 3. grade = 'A' (char)
        
        // TODO: 여러 변수를 동시에 선언하고 개별적으로 값을 할당하세요
        // 힌트:
        // 1. x, y, z를 int 타입으로 동시 선언
        // 2. x = 1, y = 2, z = 3 할당
        
        // TODO: 여러 변수를 동시에 선언하면서 초기화하세요
        // 힌트: width = 100, height = 200, depth = 50 (모두 int)
        
        // TODO: 결과를 출력하세요
        // 힌트:
        // 1. count 값 출력
        // 2. price 값 출력
        // 3. quantity × price 계산 결과 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
count = 10
price = 29.99
quantity × price = 149.95
```

### 예제 2-2: 변수 값 변경
```java
public class VariableUpdate {
    public static void main(String[] args) {
        // TODO: score 변수를 0으로 초기화하고 출력하세요
        // 힌트: "초기 점수: [score]" 형식
        
        // TODO: score를 10으로 변경하고 출력하세요
        // 힌트: "첫 번째 점수: [score]" 형식
        
        // TODO: score에 5를 더하고 출력하세요
        // 힌트: score = score + 5
        // 출력: "두 번째 점수: [score]"
        
        // TODO: score를 2배로 만들고 출력하세요
        // 힌트: score = score * 2
        // 출력: "최종 점수: [score]"
        
        // TODO: 계좌 잔액 시뮬레이션을 구현하세요
        // 힌트:
        // 1. balance = 1000.0 (초기 잔액)
        // 2. interestRate = 0.05 (이자율 5%)
        // 3. "\n계좌 잔액 변화:" 출력
        // 4. 초기 잔액 출력
        // 5. 이자 계산: interest = balance * interestRate
        // 6. 잔액에 이자 추가: balance = balance + interest
        // 7. 이자 후 잔액 출력
        // 8. withdrawal = 200.0 (출금액)
        // 9. 출금 처리: balance = balance - withdrawal
        // 10. 출금 후 잔액 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
초기 점수: 0
첫 번째 점수: 10
두 번째 점수: 15
최종 점수: 30

계좌 잔액 변화:
초기 잔액: $1000.0
이자 후 잔액: $1050.0
출금 후 잔액: $850.0
```

## 3. 기본 타입별 예제

### 예제 3-1: 정수형 타입 사용
```java
public class IntegerTypes {
    public static void main(String[] args) {
        // TODO: byte 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. age = 25 (byte 타입, -128 ~ 127 범위)
        // 2. temperature = -10 (byte 타입)
        // 주의: byte tooBig = 200은 범위 초과로 오류 발생
        
        // TODO: short 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. year = 2024 (short 타입, -32,768 ~ 32,767 범위)
        // 2. population = 30000 (short 타입)
        
        // TODO: int 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. salary = 50000000 (int 타입, 가장 많이 사용)
        // 2. distance = 384400 (지구에서 달까지 거리 km)
        
        // TODO: long 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. worldPopulation = 7_900_000_000L (L 접미사 필수)
        // 2. nationalDebt = 1_500_000_000_000L
        // 주의: 밑줄(_)은 숫자 가독성을 위해 사용 가능
        
        // TODO: 각 정수 타입의 최대/최소값을 출력하세요
        // 힌트:
        // 1. Byte.MIN_VALUE, Byte.MAX_VALUE
        // 2. Short.MIN_VALUE, Short.MAX_VALUE
        // 3. Integer.MIN_VALUE, Integer.MAX_VALUE
        // 4. Long.MIN_VALUE, Long.MAX_VALUE
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
byte 범위: -128 ~ 127
short 범위: -32768 ~ 32767
int 범위: -2147483648 ~ 2147483647
long 범위: -9223372036854775808 ~ 9223372036854775807
```

### 예제 3-2: 실수형 타입 사용
```java
public class FloatingPointTypes {
    public static void main(String[] args) {
        // TODO: float 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. pi = 3.14159f (F 접미사 필수)
        // 2. price = 19.99F (대문자 F도 가능)
        // 3. scientificNotation = 6.02e23f (과학적 표기법, 아보가드로 수)
        
        // TODO: double 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. e = 2.718281828459045 (자연상수, 더 정밀함)
        // 2. atomRadius = 1.2e-10 (원자 반지름, 미터 단위)
        // 3. lightSpeed = 299_792_458.0 (빛의 속도, m/s)
        
        // TODO: float와 double의 정밀도 차이를 비교하세요
        // 힌트:
        // 1. floatValue = 1.12345678901234567890f
        // 2. doubleValue = 1.12345678901234567890
        // 3. 두 값을 출력하여 정밀도 차이 확인
        
        // TODO: 원의 넓이를 계산하고 출력하세요
        // 힌트:
        // 1. radius = 5.0
        // 2. area = Math.PI * radius * radius
        // 3. "반지름 [radius]인 원의 넓이: [area]" 형식으로 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
float 정밀도: 1.1234568
double 정밀도: 1.1234567890123457
반지름 5.0인 원의 넓이: 78.53981633974483
```

### 예제 3-3: 문자형과 논리형
```java
public class CharAndBoolean {
    public static void main(String[] args) {
        // TODO: char 타입 변수들을 선언하고 값을 할당하세요
        // 힌트:
        // 1. grade = 'A' (문자 리터럴)
        // 2. digit = '7' (숫자 문자)
        // 3. space = ' ' (공백 문자)
        // 4. newline = '\n' (줄바꿈 이스케이프)
        // 5. tab = '\t' (탭 이스케이프)
        // 6. backslash = '\\' (역슬래시 이스케이프)
        // 7. quote = '\'' (작은따옴표 이스케이프)
        // 8. unicodeChar = '\u0041' ('A'의 유니코드)
        
        // TODO: char 변수들을 사용하여 출력하세요
        // 힌트:
        // 1. "성적: [grade]" 출력
        // 2. "특수문자 예제:" 출력
        // 3. "탭[tab]문자" 출력 (탭 문자 사용)
        // 4. "줄바꿈[newline]문자" 출력 (줄바꿈 문자 사용)
        // 5. "유니코드: [unicodeChar]" 출력
        
        // TODO: boolean 타입 변수를 선언하고 값을 할당하세요
        // 힌트:
        // 1. isStudent = true
        // 2. hasLicense = false
        
        // TODO: 나이를 기반으로 성인 여부를 판단하세요
        // 힌트:
        // 1. age = 20
        // 2. isAdult = age >= 18 (비교 연산 결과)
        
        // TODO: boolean 값들을 출력하세요
        // 힌트:
        // 1. "\n논리값 예제:" 출력
        // 2. "학생입니까? [isStudent]" 출력
        // 3. "성인입니까? [isAdult]" 출력
        
        // TODO: 논리 연산을 수행하고 결과를 출력하세요
        // 힌트:
        // 1. canDrive = isAdult && hasLicense (논리 AND 연산)
        // 2. "운전 가능? [canDrive]" 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
성적: A
특수문자 예제:
탭	문자
줄바꿈
문자
유니코드: A

논리값 예제:
학생입니까? true
성인입니까? true
운전 가능? false
```

## 4. 리터럴 예제

### 예제 4-1: 다양한 정수 리터럴
```java
public class IntegerLiterals {
    public static void main(String[] args) {
        // TODO: 다양한 진법의 정수 리터럴을 선언하고 255라는 같은 값을 표현하세요
        // 힌트:
        // 1. decimal = 255 (10진수)
        // 2. binary = 0b11111111 (2진수, 0b 접두사)
        // 3. octal = 0377 (8진수, 0 접두사)
        // 4. hexadecimal = 0xFF (16진수, 0x 접두사)
        
        // TODO: 각 진법의 값을 출력하고 모두 같은 값인지 확인하세요
        // 힌트:
        // 1. 각 진법별로 출력
        // 2. 모든 값이 같은지 비교 (decimal == binary && binary == octal && octal == hexadecimal)
        
        // TODO: 밑줄(_)을 사용하여 가독성을 향상시킨 리터럴을 작성하세요
        // 힌트:
        // 1. creditCardNumber = 1234_5678_9012_3456L (신용카드 번호 형식)
        // 2. rgbColor = 0xFF_FF_FF (RGB 흰색, 16진수)
        // 3. worldPopulation = 7_900_000_000L (세계 인구)
        
        // TODO: 가독성 향상 예제들을 출력하세요
        // 힌트:
        // 1. "\n가독성 향상 예제:" 출력
        // 2. 신용카드 번호와 RGB 색상 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 4-2: 문자열 리터럴과 이스케이프 문자
```java
public class StringLiterals {
    public static void main(String[] args) {
        // TODO: 기본 문자열 리터럴을 선언하세요
        // 힌트:
        // 1. greeting = "Hello, World!"
        // 2. name = "Java Programming"
        // 3. empty = "" (빈 문자열)
        
        // TODO: 이스케이프 문자를 사용한 문자열을 선언하세요
        // 힌트:
        // 1. quoted = "그가 말했다: \"안녕하세요!\"" (큰따옴표 이스케이프)
        // 2. path = "C:\\Users\\Documents\\file.txt" (역슬래시 이스케이프)
        // 3. multiline = "첫 번째 줄\n두 번째 줄\n세 번째 줄" (줄바꿈 이스케이프)
        // 4. tabbed = "이름\t나이\t성적\n홍길동\t20\tA" (탭과 줄바꿈 조합)
        
        // TODO: 문자열들을 출력하세요
        // 힌트:
        // 1. greeting 출력
        // 2. quoted 출력
        // 3. "파일 경로: " + path 출력
        // 4. "\n여러 줄 텍스트:" 출력 후 multiline 출력
        // 5. "\n탭으로 정렬:" 출력 후 tabbed 출력
        
        // TODO: 문자열 연결을 수행하고 출력하세요
        // 힌트:
        // 1. firstName = "홍"
        // 2. lastName = "길동"
        // 3. fullName = firstName + lastName
        // 4. "\n전체 이름: " + fullName 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

## 5. 타입 변환 예제

### 예제 5-1: 자동 타입 변환
```java
public class AutomaticTypeConversion {
    public static void main(String[] args) {
        // TODO: 작은 타입에서 큰 타입으로 자동 변환을 시연하세요
        // 힌트:
        // 1. byteValue = 100 (byte 타입)
        // 2. shortValue = byteValue (byte → short 자동 변환)
        // 3. intValue = shortValue (short → int 자동 변환)
        // 4. longValue = intValue (int → long 자동 변환)
        
        // TODO: 각 타입의 값을 출력하세요
        // 힌트: byte, short, int, long 값을 각각 출력
        
        // TODO: 정수에서 실수로 자동 변환을 시연하세요
        // 힌트:
        // 1. count = 10 (int 타입)
        // 2. doubleCount = count (int → double 자동 변환)
        // 3. "\n정수 → 실수 변환:" 출력
        // 4. 두 값을 버각 출력
        
        // TODO: 계산에서의 자동 변환을 시연하세요
        // 힌트:
        // 1. a = 10 (int 타입)
        // 2. b = 3.14 (double 타입)
        // 3. result = a + b (a가 double로 자동 변환되어 계산)
        // 4. "\n계산 시 자동 변환:" 출력
        // 5. 계산 과정과 결과 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 5-2: 명시적 타입 변환 (캐스팅)
```java
public class ExplicitTypeConversion {
    public static void main(String[] args) {
        // TODO: 큰 타입에서 작은 타입으로 명시적 변환(캐스팅)을 시연하세요
        // 힌트:
        // 1. pi = 3.14159 (double 타입)
        // 2. intPi = (int) pi (소수점 이하 버림)
        // 3. 두 값을 출력하여 차이 확인
        
        // TODO: 데이터 손실이 발생하는 캐스팅 예제를 시연하세요
        // 힌트:
        // 1. bigNumber = 300 (int 타입)
        // 2. smallByte = (byte) bigNumber (오버플로우 발생)
        // 3. "\n데이터 손실 예제:" 출력
        // 4. 원본과 변환된 값 출력 (예상과 다른 값 확인)
        
        // TODO: 실수 나눗셈을 위한 캐스팅을 시연하세요
        // 힌트:
        // 1. x = 7, y = 2 (int 타입)
        // 2. result1 = x / y (정수 나눗셈, 3.0)
        // 3. result2 = (double) x / y (실수 나눗셈, 3.5)
        // 4. "\n나눗셈 캐스팅:" 출력
        // 5. 두 결과를 비교하여 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

## 6. 종합 예제

### 예제 6-1: 은행 계좌 시뮬레이션
```java
public class BankAccount {
    public static void main(String[] args) {
        // TODO: 계좌 정보를 저장할 변수들을 선언하고 초기화하세요
        // 힌트:
        // 1. accountHolder = "홍길동" (예금주 이름)
        // 2. accountNumber = "1234-5678-9012" (계좌번호)
        // 3. balance = 10000.0 (초기 잔액)
        // 4. interestRate = 0.02 (연 2% 이자율)
        // 5. isActive = true (계좌 활성 상태)
        
        // TODO: 계좌 정보를 출력하세요
        // 힌트:
        // 1. "=== 은행 계좌 정보 ===" 출력
        // 2. 예금주, 계좌번호, 현재 잔액 출력
        // 3. 이자율을 백분율로 변환하여 출력 (interestRate * 100)
        // 4. 계좌 상태를 삼항 연산자로 출력 (isActive ? "활성" : "비활성")
        
        // TODO: 거래 시뮬레이션을 구현하세요
        // 힌트:
        // 1. "\n=== 거래 내역 ===" 출력
        // 2. deposit = 2500.0 (입금액)
        // 3. balance에 입금액 추가
        // 4. 입금 내역과 잔액 출력
        
        // TODO: 출금 처리를 구현하세요
        // 힌트:
        // 1. withdrawal = 1000.0 (출금액)
        // 2. if문으로 잔액 충분 여부 확인
        // 3. 충분하면 출금 처리 후 잔액 출력
        // 4. 부족하면 "잔액 부족!" 출력
        
        // TODO: 월 이자를 계산하고 적용하세요
        // 힌트:
        // 1. monthlyRate = interestRate / 12 (월 이자율)
        // 2. monthlyInterest = balance * monthlyRate (월 이자)
        // 3. balance에 이자 추가
        // 4. "\n=== 월 이자 적용 ===" 출력
        // 5. 월 이자율(백분율), 이자, 최종 잔액 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 6-2: 성적 관리 시스템
```java
public class GradeManagement {
    public static void main(String[] args) {
        // TODO: 학생 정보를 저장할 변수들을 선언하세요
        // 힌트:
        // 1. studentName = "김철수" (학생 이름)
        // 2. studentId = 20240001 (학번)
        
        // TODO: 과목별 점수를 저장할 변수들을 선언하세요
        // 힌트:
        // 1. korean = 85.5 (국어 점수)
        // 2. english = 92.0 (영어 점수)
        // 3. math = 78.5 (수학 점수)
        // 4. science = 88.0 (과학 점수)
        // 5. history = 91.5 (역사 점수)
        
        // TODO: 총점과 평균을 계산하세요
        // 힌트:
        // 1. totalScore = 모든 과목 점수의 합
        // 2. average = totalScore / 5
        
        // TODO: 평균 점수에 따라 학점을 결정하세요
        // 힌트:
        // 1. grade 변수 선언 (char 타입)
        // 2. if-else if 문 사용:
        //    - 90 이상: 'A'
        //    - 80 이상: 'B'
        //    - 70 이상: 'C'
        //    - 60 이상: 'D'
        //    - 60 미만: 'F'
        
        // TODO: 합격 여부를 다산하세요
        // 힌트: isPassed = average >= 60 (60점 이상이면 합격)
        
        // TODO: 성적표를 출력하세요
        // 힌트:
        // 1. "=== 성적표 ===" 출력
        // 2. 학생명, 학번 출력
        // 3. "\n과목별 점수:" 출력 후 모든 과목 점수 출력
        // 4. 총점, 평균, 학점 출력
        // 5. 합격 여부를 삼항 연산자로 출력
        
        // TODO: 장학금 자격을 확인하고 출력하세요
        // 힌트:
        // 1. scholarshipEligible = average >= 90.0
        // 2. if문으로 자격이 있으면 "\n🎉 장학금 수혜 자격이 있습니다!" 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

### 예제 6-3: 쇼핑 카트 계산
```java
public class ShoppingCart {
    public static void main(String[] args) {
        // TODO: 상품 정보를 저장할 변수들을 선언하세요
        // 힌트:
        // 상품 1: 노트북, 가격 1299.99, 수량 1
        // 상품 2: 마우스, 가격 29.99, 수량 2
        // 상품 3: 키보드, 가격 89.99, 수량 1
        // 각 상품마다 Name, Price, Quantity 변수 사용
        
        // TODO: 각 상품의 소계를 계산하세요
        // 힌트:
        // 1. subtotal1 = item1Price * item1Quantity
        // 2. subtotal2 = item2Price * item2Quantity
        // 3. subtotal3 = item3Price * item3Quantity
        // 4. subtotal = 모든 소계의 합
        
        // TODO: 할인과 세금을 계산하세요
        // 힌트:
        // 1. discountRate = 0.10 (10% 할인)
        // 2. taxRate = 0.08 (8% 세금)
        // 3. discount = subtotal * discountRate
        // 4. afterDiscount = subtotal - discount
        // 5. tax = afterDiscount * taxRate
        // 6. total = afterDiscount + tax
        
        // TODO: 영수증을 출력하세요
        // 힌트:
        // 1. "=== 쇼핑 카트 ===" 출력
        // 2. 헤더: "상품명\t\t단가\t수량\t소계" (탭 사용)
        // 3. 구분선: "----------------------------------------"
        // 4. 각 상품 정보를 탭으로 정렬하여 출력
        // 5. 구분선 출력
        // 6. 소계, 할인, 세금 출력
        // 7. "========================================" 출력
        // 8. 총액 출력
        
        // TODO: 결제 방법을 출력하세요
        // 힌트:
        // 1. useCredit = true (신용카드 사용 여부)
        // 2. 삼항 연산자로 "\n결제 방법: " + (useCredit ? "신용카드" : "현금") 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

## 디버깅 연습

### 예제 7-1: 일반적인 오류 찾기
```java
public class CommonErrors {
    public static void main(String[] args) {
        // TODO: 일반적인 오류들을 피하여 올바른 코드를 작성하세요
        
        // 주의: 아래는 오류 예시들입니다 (주석 처리됨)
        // 오류 1: 초기화하지 않은 변수 사용
        // int count;
        // System.out.println(count);  // 컴파일 오류
        
        // TODO: 오류 1 수정 - 변수를 초기화하고 출력하세요
        // 힌트: count = 0으로 초기화 후 출력
        
        // 오류 2: 타입 불일치
        // int number = 3.14;  // 컴파일 오류
        
        // TODO: 오류 2 수정 - 올바른 타입 사용
        // 힌트:
        // 1. double number = 3.14 (올바른 타입)
        // 2. 또는 int intNumber = (int) 3.14 (캐스팅 사용)
        
        // 오류 3: 범위 초과
        // byte bigByte = 200;  // 컴파일 오류 (byte 범위: -128~127)
        
        // TODO: 오류 3 수정 - 적절한 타입 사용
        // 힌트:
        // 1. short bigShort = 200 (더 큰 타입 사용)
        // 2. 또는 byte smallByte = (byte) 200 (캐스팅, 단 데이터 손실 주의)
        
        // 오류 4: 문자열과 문자 혼동
        // char initial = "A";  // 컴파일 오류
        
        // TODO: 오류 4 수정 - 문자와 문자열 구분
        // 힌트:
        // 1. char initial = 'A' (단일 문자는 작은따옴표)
        // 2. String initialString = "A" (문자열은 큰따옴표)
        
        // 오류 5: 예약어 사용
        // int class = 10;  // 컴파일 오류 (class는 예약어)
        
        // TODO: 오류 5 수정 - 예약어 피하기
        // 힌트: int classNumber = 10 (예약어가 아닌 이름 사용)
        
        // TODO: "모든 오류가 수정되었습니다!" 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
count: 0
모든 오류가 수정되었습니다!
```
