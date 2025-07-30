# 3.1 블록, 루프, 그리고 분기 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 블록의 개념과 사용법을 이해한다
- while 루프를 사용하여 반복 작업을 수행할 수 있다
- if 문을 사용하여 조건부 실행을 구현할 수 있다
- 제어 추상화의 개념을 이해한다
- 명확한 할당 규칙을 이해하고 적용한다

## 1. 제어 구조 개요

### 1.1 제어 구조란?
프로그램의 실행 흐름을 제어하는 구조적 문장들

### 1.2 Java의 6가지 제어 구조
1. **블록(Block)**: 여러 문장을 하나로 묶기
2. **while 루프**: 조건이 참인 동안 반복
3. **do..while 루프**: 최소 한 번은 실행하는 반복
4. **for 루프**: 정해진 횟수만큼 반복
5. **if 문**: 조건에 따른 분기
6. **switch 문**: 여러 경우 중 선택

💡 **핵심**: while 루프와 if 문만으로도 모든 프로그램을 작성할 수 있습니다!

## 2. 블록(Block)

### 2.1 블록이란?
여러 문장을 중괄호 `{}`로 묶어 하나의 문장처럼 취급하는 구조

### 2.2 블록의 형식
```java
{
    문장1;
    문장2;
    ...
}
```

### 2.3 블록의 특징
- **그룹화**: 여러 문장을 하나의 단위로 묶음
- **지역 변수**: 블록 내에서 선언된 변수는 블록 내에서만 유효
- **범위(Scope)**: 변수의 유효 범위를 제한

### 2.4 블록 예제
```java
// 빈 블록 (가끔 유용함)
{
}

// 값 교환 블록
{
    int temp;      // 블록 내 지역 변수
    temp = x;      // x의 값을 임시 저장
    x = y;         // y를 x에 복사
    y = temp;      // 임시값을 y에 복사
}
// temp는 여기서 접근 불가
```

### 2.5 변수의 범위
```
프로그램 시작
    ↓
    int x = 10;  ← x의 범위 시작
    {
        int y = 20;  ← y의 범위 시작
        // x와 y 모두 사용 가능
    }  ← y의 범위 끝
    // x만 사용 가능
프로그램 끝  ← x의 범위 끝
```

## 3. While 루프

### 3.1 while 루프란?
조건이 참인 동안 문장을 반복 실행하는 구조

### 3.2 while 루프의 형식
```java
while (조건식) {
    반복할 문장들;
}
```

### 3.3 while 루프의 실행 과정
```
1. 조건식 평가
2. 참이면 → 블록 실행 → 1번으로
3. 거짓이면 → 루프 종료
```

### 3.4 while 루프 예제
```java
// 1부터 5까지 출력
int number = 1;
while (number <= 5) {
    System.out.println(number);
    number = number + 1;
}
System.out.println("완료!");
```

**실행 과정**:
- number = 1: 1 <= 5 (참) → 1 출력, number = 2
- number = 2: 2 <= 5 (참) → 2 출력, number = 3
- number = 3: 3 <= 5 (참) → 3 출력, number = 4
- number = 4: 4 <= 5 (참) → 4 출력, number = 5
- number = 5: 5 <= 5 (참) → 5 출력, number = 6
- number = 6: 6 <= 5 (거짓) → 루프 종료

### 3.5 무한 루프 주의
```java
// 위험! 무한 루프
while (true) {
    System.out.println("계속 반복...");
}

// 조건이 변하지 않는 루프
int x = 1;
while (x < 10) {
    System.out.println(x);
    // x++ 를 빠뜨림!
}
```

💡 **팁**: Ctrl+C로 무한 루프 프로그램을 중단할 수 있습니다.

## 4. If 문

### 4.1 if 문이란?
조건에 따라 다른 코드를 실행하는 분기문

### 4.2 if 문의 두 가지 형식

**형식 1: if-else**
```java
if (조건식)
    statement // 조건이 참일 때 실행
else
    statement // 조건이 거짓일 때 실행
```

**형식 2: 단순 if**
```java
if (조건식)
    statement // 조건이 참일 때만 실행
```

### 4.3 if 문 예제
```java
// 큰 수를 앞으로 정렬
if (x > y) {
    int temp = x;
    x = y;
    y = temp;
}
// 이제 x <= y 보장됨

// 단수/복수 처리
if (count == 1) {
    System.out.println("1개의 항목");
} else {
    System.out.println(count + "개의 항목들");
}
```

### 4.4 제어 흐름 비교

**while 루프**: 반복 가능
```
조건 → 참 → 실행
 ↑           ↓
 ←───────────┘
```

**if 문**: 한 번만 실행
```
조건 → 참 → 실행 → 계속
  ↓
  거짓 → 계속
```

## 5. 실제 프로그램 예제

### 5.1 투자 이자 계산 프로그램
```java
import textio.TextIO;

public class Interest3 {
    public static void main(String[] args) {
        double principal;  // 원금
        double rate;       // 이자율

        // 입력 받기
        System.out.print("초기 투자 금액: ");
        principal = TextIO.getlnDouble();

        System.out.print("연간 이자율 (소수): ");
        rate = TextIO.getlnDouble();

        // 5년간 계산
        int years = 0;
        while (years < 5) {
            double interest = principal * rate;
            principal = principal + interest;
            years = years + 1;

            System.out.printf("%d년 후: $%.2f%n",
                            years, principal);
        }
    }
}
```

## 6. 제어 추상화

### 6.1 추상화란?
세부 구현을 몰라도 사용할 수 있게 하는 개념

### 6.2 제어 추상화의 예
- **고수준**: `while (조건) { ... }`
- **저수준**: 기계어의 조건부 점프 명령
- 우리는 기계어를 몰라도 while을 사용할 수 있음!

### 6.3 추상화의 이점
1. 복잡성 감소
2. 가독성 향상
3. 유지보수 용이
4. 오류 가능성 감소

## 7. 명확한 할당

### 7.1 명확한 할당 규칙
변수를 사용하기 전에 반드시 값이 할당되어야 함

### 7.2 컴파일 오류 예제
```java
// 오류 발생!
int y;
if (x < 0) {
    y = 1;
}
if (x >= 0) {
    y = 2;
}
System.out.println(y);  // 컴파일러는 y에 값이 있는지 확신 못함
```

### 7.3 올바른 코드
```java
// 정상 작동
int y;
if (x < 0) {
    y = 1;
} else {
    y = 2;
}
System.out.println(y);  // y는 반드시 값을 가짐
```

### 7.4 주의할 점
```java
// 두 코드의 차이점
// 코드 A                    // 코드 B
int x = -1;                  int x = -1;
if (x < 0)                   if (x < 0)
    x = 1;                       x = 1;
else                         if (x >= 0)
    x = 2;                       x = 2;
// 결과: x = 1               // 결과: x = 2
```

## 실용적인 팁

### 루프 작성 시 체크리스트
1. ✓ 초기값 설정했는가?
2. ✓ 종료 조건이 명확한가?
3. ✓ 루프 변수가 변경되는가?
4. ✓ 무한 루프 가능성은 없는가?

### 좋은 코딩 스타일
```java
// 권장: 명확한 들여쓰기
while (count < 10) {
    System.out.println(count);
    count++;
}

// 권장: 단일 문장도 중괄호 사용
if (x > 0) {
    x = x * 2;
}

// 권장: 의미 있는 변수명
int studentCount = 0;
while (studentCount < totalStudents) {
    // ...
}
```

## 요약

- **블록**: 여러 문장을 하나로 묶는 구조
- **while 루프**: 조건이 참인 동안 반복 실행
- **if 문**: 조건에 따라 다른 경로 실행
- **제어 추상화**: 복잡한 구현을 단순하게 사용
- **명확한 할당**: 변수 사용 전 값 할당 보장

이 세 가지 기본 구조만으로도 모든 프로그램을 작성할 수 있습니다!