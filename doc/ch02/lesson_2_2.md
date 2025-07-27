# 2.2 변수와 기본 타입 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- Java에서 유효한 식별자를 작성할 수 있다
- 8가지 기본 타입의 특징과 사용법을 이해한다
- 변수를 선언하고 값을 할당할 수 있다
- 다양한 리터럴을 올바르게 사용할 수 있다
- 강타입 언어인 Java의 타입 시스템을 이해한다

## 1. 식별자 (Identifiers)

### 1.1 식별자란?
식별자는 프로그램에서 클래스, 변수, 메소드 등의 이름을 지정하는 데 사용되는 이름입니다.

### 1.2 식별자 규칙
```
✅ 유효한 식별자:
- 문자(a-z, A-Z) 또는 밑줄(_)로 시작
- 이후에는 문자, 숫자(0-9), 밑줄 사용 가능
- 대소문자 구분
- 길이 제한 없음

❌ 무효한 식별자:
- 숫자로 시작 불가
- 공백 포함 불가
- 예약어 사용 불가
- 특수문자 사용 불가 (밑줄 제외)
```

### 1.3 유효한 식별자 예시
```java
// 유효한 식별자들
N
n
rate
x15
quite_a_long_name
HelloWorld
myVariable
_temp
$price  // $도 사용 가능하지만 권장하지 않음

// 무효한 식별자들
3rd_value      // 숫자로 시작
Hello World    // 공백 포함
my-variable    // 하이픈 사용
class          // 예약어
```

### 1.4 명명 규칙 (Naming Conventions)
Java 프로그래머들이 따르는 일반적인 규칙:

| 종류   | 규칙                     | 예시                            |
| ------ | ------------------------ | ------------------------------- |
| 클래스 | 대문자로 시작, CamelCase | `HelloWorld`, `Student`         |
| 변수   | 소문자로 시작, camelCase | `interestRate`, `studentName`   |
| 메소드 | 소문자로 시작, camelCase | `calculateTotal()`, `getName()` |
| 상수   | 모두 대문자, 밑줄로 구분 | `MAX_VALUE`, `PI`               |

### 1.5 복합 이름 (Compound Names)
점(.)으로 연결된 여러 개의 이름:
```java
System.out.println
// System: 클래스
// out: System 클래스의 변수
// println: out의 메소드
```

**참고**
- [Java Language Keywords](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

## 2. 변수 (Variables)

### 2.1 변수의 개념
변수는 메모리의 특정 위치를 가리키는 이름입니다. 프로그램 실행 중에 값을 저장하고 변경할 수 있는 "상자"라고 생각할 수 있습니다.

```
┌─────────────┐
│   Memory    │
├─────────────┤
│ rate: 0.07  │  ← 변수 rate가 가리키는 메모리 위치
├─────────────┤
│ count: 42   │  ← 변수 count가 가리키는 메모리 위치
├─────────────┤
│     ...     │
└─────────────┘
```

### 2.2 변수 선언
변수를 사용하기 전에 반드시 선언해야 합니다:

```java
// 기본 형식
타입 변수이름;

// 예시
int numberOfStudents;
double interestRate;
boolean isFinished;
char grade;

// 여러 변수 동시 선언
double x, y, z;
char firstInitial, middleInitial, lastInitial;
```

### 2.3 할당문 (Assignment Statement)
변수에 값을 저장하는 유일한 방법:

```java
// 기본 형식
variable = expression;

// 예시
rate = 0.07;
numberOfStudents = 30;
isFinished = true;
grade = 'A';

// 계산 결과 할당
interest = principal * rate;
total = price + tax;
```

**참고**
- [할당문에 변수에 값을 저장하는 유일한 방법인가?](./way_to_store_values_in_variables.md)

## 3. 기본 타입 (Primitive Types)

### 3.1 Java의 8가지 기본 타입

#### 정수형 (Integer Types)
| 타입  | 크기             | 범위                                                   | 예시                                  |
| ----- | ---------------- | ------------------------------------------------------ | ------------------------------------- |
| byte  | 1바이트 (8비트)  | -128 ~ 127                                             | `byte age = 25;`                      |
| short | 2바이트 (16비트) | -32,768 ~ 32,767                                       | `short year = 2024;`                  |
| int   | 4바이트 (32비트) | -2,147,483,648 ~ 2,147,483,647                         | `int population = 50000000;`          |
| long  | 8바이트 (64비트) | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 | `long worldPopulation = 7800000000L;` |

#### 실수형 (Floating-Point Types)
| 타입   | 크기    | 정밀도    | 예시                      |
| ------ | ------- | --------- | ------------------------- |
| float  | 4바이트 | 약 7자리  | `float pi = 3.14159f;`    |
| double | 8바이트 | 약 15자리 | `double e = 2.718281828;` |

#### 문자형 (Character Type)
| 타입 | 크기    | 설명               | 예시                |
| ---- | ------- | ------------------ | ------------------- |
| char | 2바이트 | 단일 유니코드 문자 | `char grade = 'A';` |

#### 논리형 (Boolean Type)
| 타입    | 크기                          | 값              | 예시                      |
| ------- | ----------------------------- | --------------- | ------------------------- |
| boolean | 1비트 (실제로는 더 많이 사용) | true 또는 false | `boolean isReady = true;` |

### 3.2 타입 선택 가이드
- **정수**: 일반적으로 `int` 사용
- **큰 정수**: `long` 사용
- **실수**: 일반적으로 `double` 사용
- **메모리 절약이 중요한 경우**: `byte`, `short`, `float` 고려

**참고**
- [프로그래밍에서의 변수 분류](./variables_in_programming_language.md)

## 4. 리터럴 (Literals)

### 4.1 정수 리터럴
```java
// 일반 정수 (int)
42
-100
0

// long 리터럴 (L 또는 l 접미사)
42L
1000000000000L

// 밑줄을 사용한 가독성 향상
1_000_000      // 1백만
2_147_483_647  // int 최대값

// 다른 진법
0xFF     // 16진수 (255)
0b1010   // 2진수 (10)
077      // 8진수 (63)
```

### 4.2 실수 리터럴
```java
// double 리터럴 (기본)
3.14159
-0.001
2.0

// float 리터럴 (F 또는 f 접미사)
3.14f
0.5F

// 지수 표기법
1.3e12    // 1.3 × 10^12
3.14E-10  // 3.14 × 10^-10
```

### 4.3 문자 리터럴
```java
'A'     // 대문자 A
'a'     // 소문자 a
'7'     // 숫자 문자
' '     // 공백
'\n'    // 줄바꿈
'\t'    // 탭
'\\'    // 백슬래시
'\''    // 작은따옴표
```

### 4.4 논리 리터럴
```java
true   // 참
false  // 거짓
```

### 4.5 문자열 리터럴
```java
"Hello World!"
"Java Programming"
""              // 빈 문자열
"A"             // 한 글자 문자열 (char 'A'와 다름)
"He said \"Hi\""  // 이스케이프 문자 사용
```

**참고**
- [Java 리터럴(Literal) 가이드](./java-literals-guide.md)

## 5. 강타입 시스템 (Strong Typing)

### 5.1 타입 안정성
Java는 강타입 언어로, 변수의 타입이 엄격하게 관리됩니다:

```java
int count = 10;      // OK
count = 3.14;        // 컴파일 오류! int 변수에 double 값 할당 불가
count = "Hello";     // 컴파일 오류! int 변수에 String 할당 불가

double price = 10;   // OK (int가 double로 자동 변환)
int value = 10.5;    // 컴파일 오류! double을 int에 할당 불가
```

### 5.2 타입 변환
```java
// 자동 타입 변환 (작은 타입 → 큰 타입)
int intValue = 100;
double doubleValue = intValue;  // OK: int → double

// 명시적 타입 변환 (캐스팅)
double pi = 3.14159;
int intPi = (int) pi;  // 3 (소수점 이하 버림)
```

**참고**
- [Strong Typing vs Weak Typing](./stroing_typing_vs_weak_typing.md)

## 6. 종합 예제: Interest 프로그램 분석

```java
/**
 * 이 클래스는 $17,000의 투자가 연이율 0.027로 1년 동안 발생하는 이자를 계산합니다.
 * 이자와 투자 후 1년 후의 금액을 표준 출력으로 표시합니다.
 */
public class Interest {

   public static void main(String[] args) {

       /* 변수 선언 */
       double principal;     // 투자 금액
       double rate;          // 연이율
       double interest;      // 1년 동안 발생한 이자

       /* 계산 수행 */
       principal = 17000;    // 리터럴 17000을 principal에 할당
       rate = 0.027;         // 리터럴 0.027을 rate에 할당
       interest = principal * rate;   // 계산 결과를 interest에 할당

       principal = principal + interest; // 원금에 이자를 더함

       /* 결과 출력 */
       System.out.print("이자는 $");      // 줄바꿈 없이 출력
       System.out.println(interest);      // 값 출력 후 줄바꿈
       System.out.print("1년 후 투자 가치는 $");
       System.out.println(principal);

   } // main() 끝

} // 클래스 Interest 끝
```

### 프로그램 실행 과정:
1. 세 개의 double 변수 선언 (메모리 할당)
2. principal에 17000 할당
3. rate에 0.027 할당
4. interest 계산: 17000 × 0.027 = 459.0
5. principal 업데이트: 17000 + 459.0 = 17459.0
6. 결과 출력:
   ```
   이자는 $459.0
   1년 후 투자 가치는 $17459.0
   ```

## 7. 프로그래밍 스타일 권장사항

### 7.1 변수 선언 시 주석 추가
```java
double principal;    // 투자 금액
double interestRate; // 비율을 백분율이 아닌 소수로 표시
int numberOfDays;    // 투자 기간 (일 단위)
```

### 7.2 의미 있는 변수명 사용
```java
// 좋은 예
double accountBalance;
int studentCount;
boolean isLoggedIn;

// 나쁜 예
double x;
int n;
boolean flag;
```

### 7.3 관련 변수 그룹화
```java
// 좌표 관련 변수
double x, y, z;

// 학생 정보 관련 변수
String studentName;
int studentId;
double studentGPA;
```

**참고**
- [Google Style Guide](https://google.github.io/styleguide/)

## 요약

- **식별자**: 프로그램 요소의 이름, 규칙을 따라야 함
- **변수**: 메모리 위치를 가리키는 이름, 선언 후 사용
- **기본 타입**: 8가지 (byte, short, int, long, float, double, char, boolean)
- **리터럴**: 프로그램에 직접 작성하는 값
- **강타입**: Java는 타입을 엄격하게 검사
- **스타일**: 명명 규칙과 가독성이 중요