# 3.5 if문 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- if문의 구조와 동작 원리를 완전히 이해한다
- else-if를 사용한 다중 분기를 구현할 수 있다
- 중첩된 if문을 올바르게 작성할 수 있다
- 달랑거리는 else 문제를 이해하고 해결할 수 있다
- 빈 명령문의 개념과 주의사항을 안다

## 1. if문의 기본 구조

### 1.1 기본 형태
```java
if (조건식) {
    // 조건이 true일 때 실행되는 코드
}
```

### 1.2 if-else 형태
```java
if (조건식) {
    // 조건이 true일 때 실행
} else {
    // 조건이 false일 때 실행
}
```

### 1.3 실행 흐름
```
조건식 평가
   ↓
true면 → if 블록 실행
   ↓
false면 → else 블록 실행 (있는 경우)
   ↓
다음 코드로 진행
```

## 2. 달랑거리는 else 문제 (Dangling else)

### 2.1 문제 상황
```java
// 들여쓰기가 의도를 나타내지만...
if (x > 0)
    if (y > 0)
        System.out.println("둘 다 양수");
else
    System.out.println("뭔가 음수");  // 어느 if와 연결?
```

### 2.2 실제 해석
Java는 else를 **가장 가까운 if**와 연결합니다:
```java
if (x > 0)
    if (y > 0)
        System.out.println("둘 다 양수");
    else  // y <= 0일 때
        System.out.println("뭔가 음수");
```

### 2.3 해결 방법
중괄호를 사용하여 명확하게:
```java
if (x > 0) {
    if (y > 0)
        System.out.println("둘 다 양수");
} else {  // x <= 0일 때
    System.out.println("x가 음수");
}
```

## 3. 다중 분기 (Multiway Branching)

### 3.1 else-if 체인
```java
if (조건1) {
    // 조건1이 true일 때
} else if (조건2) {
    // 조건1은 false, 조건2가 true일 때
} else if (조건3) {
    // 조건1,2는 false, 조건3이 true일 때
} else {
    // 모든 조건이 false일 때
}
```

### 3.2 특징
- **순차적 평가**: 위에서부터 순서대로 조건 검사
- **첫 번째 true에서 중단**: 하나만 실행됨
- **else는 선택사항**: 없으면 모든 조건이 false일 때 아무것도 실행 안 함

### 3.3 예제: 성적 등급
```java
if (score >= 90) {
    grade = "A";
} else if (score >= 80) {
    grade = "B";
} else if (score >= 70) {
    grade = "C";
} else if (score >= 60) {
    grade = "D";
} else {
    grade = "F";
}
```

## 4. 중첩된 if문

### 4.1 기본 개념
if문 안에 또 다른 if문이 있는 구조

### 4.2 예제: 세 수 정렬
```java
// x, y, z를 오름차순으로 정렬
if (x < y && x < z) {        // x가 가장 작음
    if (y < z) {
        System.out.println(x + " " + y + " " + z);
    } else {
        System.out.println(x + " " + z + " " + y);
    }
} else if (x > y && x > z) {  // x가 가장 큼
    if (y < z) {
        System.out.println(y + " " + z + " " + x);
    } else {
        System.out.println(z + " " + y + " " + x);
    }
} else {                      // x가 중간
    if (y < z) {
        System.out.println(y + " " + x + " " + z);
    } else {
        System.out.println(z + " " + x + " " + y);
    }
}
```

## 5. 조건식 작성 팁

### 5.1 복합 조건
```java
// AND 연산 (둘 다 true여야 함)
if (age >= 18 && hasLicense) {
    System.out.println("운전 가능");
}

// OR 연산 (하나만 true여도 됨)
if (isWeekend || isHoliday) {
    System.out.println("쉬는 날");
}

// NOT 연산 (조건 반전)
if (!isRaining) {
    System.out.println("우산 필요 없음");
}
```

### 5.2 범위 검사
```java
// 잘못된 방법 (Java에서는 불가능)
// if (0 < x < 10)  // 오류!

// 올바른 방법
if (0 < x && x < 10) {
    System.out.println("x는 0과 10 사이");
}
```

### 5.3 문자열 비교
```java
String answer = "yes";

// 올바른 방법
if (answer.equals("yes")) {
    System.out.println("동의함");
}

// 대소문자 무시
if (answer.equalsIgnoreCase("YES")) {
    System.out.println("동의함");
}

// 잘못된 방법 (== 사용)
// if (answer == "yes")  // 위험!
```

## 6. 빈 명령문 (Empty Statement)

### 6.1 정의
세미콜론만으로 이루어진 명령문
```java
;  // 빈 명령문 - 아무것도 하지 않음
```

### 6.2 의도적 사용
```java
if (isReady)
    ;  // 준비되었으면 아무것도 안 함
else
    System.out.println("아직 준비 안 됨");
```

### 6.3 실수로 인한 오류
```java
// 주의! 실수하기 쉬운 부분
if (x > 0);  // 빈 명령문 (실수!)
{
    System.out.println("양수");  // 항상 실행됨!
}

// 올바른 코드
if (x > 0) {  // 세미콜론 없음
    System.out.println("양수");
}
```

## 7. if문 사용 패턴

### 7.1 입력 검증
```java
System.out.print("나이 입력: ");
int age = scanner.nextInt();

if (age < 0) {
    System.out.println("나이는 음수일 수 없습니다!");
} else if (age > 150) {
    System.out.println("유효하지 않은 나이입니다!");
} else {
    System.out.println("나이: " + age);
}
```

### 7.2 상태 확인
```java
if (isLoggedIn) {
    if (hasPermission) {
        showContent();
    } else {
        System.out.println("권한이 없습니다");
    }
} else {
    System.out.println("먼저 로그인하세요");
}
```

### 7.3 오류 처리
```java
if (denominator == 0) {
    System.out.println("0으로 나눌 수 없습니다!");
} else {
    double result = numerator / denominator;
    System.out.println("결과: " + result);
}
```

## 8. 실전 예제: 단위 변환기

```java
// 길이 단위 변환
double measurement = scanner.nextDouble();
String unit = scanner.next().toLowerCase();

double inches;

if (unit.equals("inch") || unit.equals("in")) {
    inches = measurement;
} else if (unit.equals("feet") || unit.equals("ft")) {
    inches = measurement * 12;
} else if (unit.equals("yard") || unit.equals("yd")) {
    inches = measurement * 36;
} else if (unit.equals("mile") || unit.equals("mi")) {
    inches = measurement * 12 * 5280;
} else {
    System.out.println("알 수 없는 단위: " + unit);
    return;  // 프로그램 종료
}

// 변환 결과 출력
double feet = inches / 12.0;
double yards = inches / 36.0;
double miles = inches / (12.0 * 5280.0);

System.out.printf("%.2f inches%n", inches);
System.out.printf("%.2f feet%n", feet);
System.out.printf("%.2f yards%n", yards);
System.out.printf("%.5f miles%n", miles);
```

## 실용적인 팁

### if문 작성 가이드
1. **명확한 조건**: 조건식을 읽기 쉽게 작성
2. **중괄호 사용**: 한 줄이어도 중괄호 권장
3. **적절한 순서**: 가장 가능성 높은 조건을 먼저
4. **중복 제거**: 공통 코드는 if문 밖으로
5. **깊이 제한**: 중첩을 3단계 이하로

### 디버깅 팁
```java
// 조건 확인용 출력
if (debug) {
    System.out.println("x = " + x + ", y = " + y);
}

if (x > 0 && y > 0) {
    // 실제 코드
}
```

## 요약

- **if문**: 조건에 따라 다른 코드 실행
- **else-if**: 여러 조건을 순차적으로 검사
- **중첩**: if문 안에 if문 가능
- **달랑거리는 else**: 가장 가까운 if와 연결
- **빈 명령문**: 주의해서 사용
- **조건식**: 복합 조건 사용 가능

💡 **기억하세요**: if문은 프로그램의 흐름을 제어하는 가장 기본적이고 중요한 도구입니다!