# 2.5 표현식의 세부 사항 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 산술 연산자를 사용하여 계산을 수행할 수 있다
- 증가/감소 연산자의 전위와 후위 형태를 이해한다
- 관계 연산자로 값을 비교할 수 있다
- 논리 연산자로 복잡한 조건을 만들 수 있다
- 조건 연산자를 사용할 수 있다
- 타입 변환과 타입 캐스팅을 이해한다
- 연산자 우선순위를 이해하고 적용한다

## 1. 표현식이란?

표현식(Expression)은 값을 나타내거나 계산하는 프로그램 코드의 일부입니다.

### 표현식의 구성 요소
1. **리터럴**: `42`, `3.14`, `true`, `'A'`, `"Hello"`
2. **변수**: `age`, `price`, `isStudent`
3. **함수 호출**: `Math.sqrt(16)`, `TextIO.getInt()`
4. **연산자와 피연산자**: `x + y`, `a > b`

### 수학 상수
```java
Math.PI    // 3.141592653589793 (원주율)
Math.E     // 2.718281828459045 (자연로그의 밑)

// 정수 범위
Integer.MAX_VALUE  // 2147483647
Integer.MIN_VALUE  // -2147483648

// 실수 특수값
Double.POSITIVE_INFINITY  // 양의 무한대
Double.NEGATIVE_INFINITY  // 음의 무한대
Double.NaN               // Not a Number
```

## 2. 산술 연산자

### 2.1 기본 산술 연산자

| 연산자 | 의미 | 예시 | 결과 |
|--------|------|------|------|
| `+` | 덧셈 | `5 + 3` | `8` |
| `-` | 뺄셈 | `5 - 3` | `2` |
| `*` | 곱셈 | `5 * 3` | `15` |
| `/` | 나눗셈 | `5 / 3` | `1` (정수) |
| `%` | 나머지 | `5 % 3` | `2` |

### 2.2 정수 나눗셈 주의사항
```java
// 정수 나눗셈
int a = 7;
int b = 2;
int result1 = a / b;        // 3 (소수부분 버림)
double result2 = a / b;     // 3.0 (여전히 정수 나눗셈)
double result3 = (double)a / b;  // 3.5 (실수 나눗셈)
```

### 2.3 나머지 연산자 활용
```java
// 짝수/홀수 판별
if (number % 2 == 0) {
    System.out.println("짝수");
} else {
    System.out.println("홀수");
}

// 10의 자리 추출
int tens = number / 10;
int ones = number % 10;

// 나누어떨어지는지 확인
if (n % 3 == 0) {
    System.out.println("3의 배수");
}
```

### 2.4 단항 연산자
```java
int x = 5;
int y = -x;    // y = -5 (단항 마이너스)
int z = +x;    // z = 5  (단항 플러스, 효과 없음)
```

## 3. 증가 및 감소 연산자

### 3.1 기본 사용법
```java
int count = 10;
count++;    // count = 11 (후위 증가)
++count;    // count = 12 (전위 증가)
count--;    // count = 11 (후위 감소)
--count;    // count = 10 (전위 감소)
```

### 3.2 전위 vs 후위
```java
int x = 5;
int y;

// 후위 증가: 사용 후 증가
y = x++;    // y = 5, x = 6

// 전위 증가: 증가 후 사용
x = 5;      // 다시 5로 설정
y = ++x;    // y = 6, x = 6
```

### 3.3 주의사항
```java
// 혼란스러운 예 (피해야 함)
int x = 5;
x = x++;    // x는 여전히 5! (증가 후 원래값으로 덮어씀)

// 권장하는 사용법
x++;        // 독립적인 문장으로 사용
```

## 4. 관계 연산자

### 4.1 비교 연산자

| 연산자 | 의미 | 예시 | 
|--------|------|------|
| `==` | 같음 | `a == b` |
| `!=` | 다름 | `a != b` |
| `<` | 작음 | `a < b` |
| `>` | 큼 | `a > b` |
| `<=` | 작거나 같음 | `a <= b` |
| `>=` | 크거나 같음 | `a >= b` |

### 4.2 사용 예제
```java
int age = 20;
boolean isAdult = age >= 18;        // true
boolean isTeenager = age >= 13 && age <= 19;  // false

// 문자 비교 (유니코드 값)
char grade = 'B';
boolean isPassing = grade <= 'C';    // true
```

### 4.3 문자열 비교 주의
```java
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");

// 잘못된 방법
if (s1 == s2) { }    // 같은 리터럴이므로 true일 수 있음
if (s1 == s3) { }    // false (다른 객체)

// 올바른 방법
if (s1.equals(s3)) { }  // true (내용 비교)
```

## 5. 논리 연산자 (Boolean 연산자)

### 5.1 기본 논리 연산자

| 연산자 | 의미 | 설명 |
|--------|------|------|
| `&&` | AND (그리고) | 둘 다 true일 때만 true |
| `||` | OR (또는) | 하나라도 true면 true |
| `!` | NOT (부정) | true를 false로, false를 true로 |

### 5.2 진리표
```java
// AND (&&)
true && true    // true
true && false   // false
false && true   // false
false && false  // false

// OR (||)
true || true    // true
true || false   // true
false || true   // true
false || false  // false

// NOT (!)
!true          // false
!false         // true
```

### 5.3 단축 평가 (Short-circuit)
```java
// && : 첫 번째가 false면 두 번째 평가 안 함
int x = 0;
if (x != 0 && 10/x > 1) {  // 0으로 나누기 방지
    // x가 0이면 10/x는 실행되지 않음
}

// || : 첫 번째가 true면 두 번째 평가 안 함
if (isStudent || age < 18) {
    // isStudent가 true면 age 확인 안 함
}
```

## 6. 조건 연산자 (삼항 연산자)

### 6.1 기본 형식
```java
조건 ? 참일때값 : 거짓일때값
```

### 6.2 사용 예제
```java
// 최댓값 구하기
int max = (a > b) ? a : b;

// 짝수/홀수 문자열
String parity = (n % 2 == 0) ? "짝수" : "홀수";

// 할인 가격 계산
double price = isVIP ? originalPrice * 0.8 : originalPrice;

// 절댓값
int abs = (x >= 0) ? x : -x;
```

## 7. 타입 변환과 타입 캐스팅

### 7.1 자동 타입 변환 (묵시적 변환)
```java
// 작은 타입 → 큰 타입 (자동)
byte b = 10;
short s = b;    // byte → short
int i = s;      // short → int
long l = i;     // int → long
float f = l;    // long → float
double d = f;   // float → double

// 정수 + 실수 = 실수
int x = 5;
double y = 3.14;
double result = x + y;  // 8.14
```

### 7.2 강제 타입 변환 (명시적 변환)
```java
// 큰 타입 → 작은 타입 (명시적 캐스팅 필요)
double pi = 3.14159;
int intPi = (int)pi;        // 3 (소수부분 버림)

// 정보 손실 주의
int bigNumber = 100000;
short smallNumber = (short)bigNumber;  // -31072 (오버플로우)

// 문자와 숫자 변환
char ch = 'A';
int ascii = (int)ch;        // 65
char newCh = (char)(ascii + 2);  // 'C'
```

### 7.3 문자열 변환
```java
// 다른 타입 → String
int num = 42;
String str1 = "" + num;           // "42"
String str2 = String.valueOf(num); // "42" (권장)

// String → 다른 타입
String numStr = "123";
int value = Integer.parseInt(numStr);     // 123

String doubleStr = "3.14";
double dValue = Double.parseDouble(doubleStr);  // 3.14
```

## 8. 복합 할당 연산자

| 연산자 | 의미 | 예시 | 동일한 표현 |
|--------|------|------|------------|
| `+=` | 더하고 할당 | `x += 5` | `x = x + 5` |
| `-=` | 빼고 할당 | `x -= 3` | `x = x - 3` |
| `*=` | 곱하고 할당 | `x *= 2` | `x = x * 2` |
| `/=` | 나누고 할당 | `x /= 4` | `x = x / 4` |
| `%=` | 나머지 할당 | `x %= 3` | `x = x % 3` |

```java
// 사용 예제
int score = 100;
score += 10;    // 110
score -= 5;     // 105
score *= 2;     // 210
score /= 3;     // 70
score %= 20;    // 10

// 문자열에도 사용 가능
String message = "Hello";
message += " World";  // "Hello World"
```

## 9. 연산자 우선순위

### 9.1 우선순위 표 (높음 → 낮음)
1. **단항 연산자**: `++`, `--`, `!`, `-` (음수), `+` (양수), 타입 캐스트
2. **곱셈/나눗셈**: `*`, `/`, `%`
3. **덧셈/뺄셈**: `+`, `-`
4. **관계 연산자**: `<`, `>`, `<=`, `>=`
5. **동등/부등**: `==`, `!=`
6. **논리 AND**: `&&`
7. **논리 OR**: `||`
8. **조건 연산자**: `? :`
9. **할당 연산자**: `=`, `+=`, `-=`, `*=`, `/=`, `%=`

### 9.2 우선순위 예제
```java
// 곱셈이 덧셈보다 우선
int result1 = 2 + 3 * 4;        // 14 (2 + 12)
int result2 = (2 + 3) * 4;      // 20 (5 * 4)

// 관계 연산자가 논리 연산자보다 우선
boolean test1 = 5 > 3 && 2 < 4;  // true && true = true
boolean test2 = 5 > 3 || 2 > 4;  // true || false = true

// 복잡한 예제
int x = 5, y = 3, z = 2;
int result = x + y * z - x % y;   // 5 + 6 - 2 = 9
```

## 실용적인 예제

### 주사위 게임
```java
// 1~6 사이의 난수 생성
int dice = (int)(Math.random() * 6) + 1;

// 두 주사위의 합
int dice1 = (int)(Math.random() * 6) + 1;
int dice2 = (int)(Math.random() * 6) + 1;
int sum = dice1 + dice2;

// 더블 체크
boolean isDouble = dice1 == dice2;
```

### 성적 계산
```java
int midterm = 85;
int finalExam = 90;
int homework = 95;

// 가중 평균 (중간 30%, 기말 40%, 과제 30%)
double average = midterm * 0.3 + finalExam * 0.4 + homework * 0.3;

// 학점 계산
char grade = (average >= 90) ? 'A' :
             (average >= 80) ? 'B' :
             (average >= 70) ? 'C' :
             (average >= 60) ? 'D' : 'F';
```

## 요약

- **산술 연산자**: 기본 수학 연산 수행
- **증가/감소**: 변수값을 1씩 증가/감소
- **관계 연산자**: 값 비교, boolean 결과
- **논리 연산자**: boolean 값 결합
- **조건 연산자**: 간단한 if-else 대체
- **타입 변환**: 자동/강제 변환 이해 필요
- **우선순위**: 괄호로 명확하게 표현 권장