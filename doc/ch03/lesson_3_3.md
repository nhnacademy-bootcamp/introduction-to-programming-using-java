# 3.3 while 및 do..while 문 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- while 루프의 동작 원리를 완전히 이해한다
- do..while 루프와 while 루프의 차이점을 설명할 수 있다
- break와 continue 문을 적절히 사용할 수 있다
- 루프 준비(priming)의 개념을 이해한다
- 센티넬 값을 사용한 반복 제어를 구현할 수 있다

## 1. while 문 심화

### 1.1 while 문의 구조
```java
while (조건식) {
    // 반복할 문장들
}
```

### 1.2 while 루프의 실행 과정
```
1. 조건식 평가
   ↓
2. true → 루프 본문 실행 → 1번으로
   ↓
3. false → 루프 종료
```

### 1.3 중요한 특징
- **사전 검사**: 조건을 먼저 검사하고 실행
- **0회 실행 가능**: 조건이 처음부터 false면 한 번도 실행 안 됨
- **조건 재평가**: 루프 본문 완료 후에만 조건 재검사

## 2. 루프 준비(Loop Priming)

### 2.1 루프 준비란?
while 루프의 조건이 처음 평가될 때 의미를 갖도록 사전 작업을 하는 것

### 2.2 준비가 필요한 경우
```java
// 잘못된 예
int number;
while (number != 0) {  // number가 초기화되지 않음!
    // ...
}

// 올바른 예 - 루프 준비
int number;
System.out.print("숫자 입력: ");
number = scanner.nextInt();  // 루프 준비
while (number != 0) {
    // 처리...
    System.out.print("숫자 입력: ");
    number = scanner.nextInt();
}
```

### 2.3 센티넬 값(Sentinel Value)
데이터의 끝을 표시하는 특별한 값

**예시**:
- 0: 양수 데이터의 끝
- -1: 점수 데이터의 끝
- "quit": 문자열 입력의 끝

## 3. 평균 계산 프로그램 분석

### 3.1 문제 정의
사용자가 입력한 양수들의 평균 계산 (0 입력시 종료)

### 3.2 알고리즘 개발 과정

**초기 알고리즘** (문제점 있음):
```pseudocode
sum = 0
count = 0
while 더 많은 정수가 있는 동안:
    정수 읽기
    합계에 더하기
    개수 세기
평균 계산 및 출력
```

**개선된 알고리즘** (루프 준비 포함):
```pseudocode
sum = 0
count = 0
정수 읽기  // 루프 준비!
while 정수 != 0:
    합계에 더하기
    개수 세기
    정수 읽기  // 다음을 위한 준비
평균 계산 및 출력
```

### 3.3 주의사항
- 센티넬 값은 처리하지 않음
- 정수 나눗셈 주의 (형변환 필요)
- 데이터가 없는 경우 처리

## 4. do..while 문

### 4.1 do..while 문의 구조
```java
do {
    // 반복할 문장들
} while (조건식);  // 세미콜론 필수!
```

### 4.2 do..while 루프의 실행 과정
```
1. 루프 본문 실행
   ↓
2. 조건식 평가
   ↓
3. true → 1번으로
   ↓
4. false → 루프 종료
```

### 4.3 while과 do..while의 차이점

| 특징 | while | do..while |
|------|-------|------------|
| 조건 검사 위치 | 시작 | 끝 |
| 최소 실행 횟수 | 0회 | 1회 |
| 사용 시기 | 실행 여부가 불확실할 때 | 최소 1회는 실행해야 할 때 |

### 4.4 do..while 사용 예시
```java
// 게임 반복 실행
boolean playAgain;
do {
    playGame();  // 게임 실행
    System.out.print("다시 하시겠습니까? (y/n): ");
    char answer = scanner.next().charAt(0);
    playAgain = (answer == 'y' || answer == 'Y');
} while (playAgain);
```

## 5. break와 continue

### 5.1 break 문
루프를 즉시 종료하고 루프 다음 문장으로 이동

**사용 예시**:
```java
while (true) {  // 무한 루프
    System.out.print("양수 입력: ");
    int n = scanner.nextInt();
    if (n > 0) {
        break;  // 올바른 입력시 루프 종료
    }
    System.out.println("양수를 입력해주세요!");
}
// break 후 여기서 계속
```

### 5.2 continue 문
현재 반복의 나머지를 건너뛰고 다음 반복으로

**사용 예시**:
```java
int sum = 0;
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // 짝수는 건너뛰기
    }
    sum += i;  // 홀수만 더하기
}
```

### 5.3 중첩 루프에서의 break
```java
// 레이블 없는 break - 가장 가까운 루프만 종료
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (i * j > 6) {
            break;  // 안쪽 루프만 종료
        }
        System.out.print(i * j + " ");
    }
    System.out.println();
}

// 레이블 있는 break - 지정된 루프 종료
outerLoop:
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (i * j > 6) {
            break outerLoop;  // 바깥 루프 종료
        }
        System.out.print(i * j + " ");
    }
}
```

## 6. 루프 선택 가이드

### 6.1 while 루프를 사용하는 경우
- 반복 횟수를 모를 때
- 특정 조건이 만족될 때까지 반복
- 한 번도 실행하지 않을 수 있을 때

### 6.2 do..while 루프를 사용하는 경우
- 최소 한 번은 실행해야 할 때
- 사용자 입력을 받고 검증하는 경우
- 메뉴 기반 프로그램

### 6.3 break를 사용하는 경우
- 루프 중간에서 종료 조건 검사
- 오류 발생시 즉시 종료
- 무한 루프에서 탈출

## 7. 일반적인 루프 패턴

### 7.1 카운터 제어 루프
```java
int count = 0;
while (count < 10) {
    // 작업 수행
    count++;
}
```

### 7.2 센티넬 제어 루프
```java
String input;
System.out.print("입력 (quit으로 종료): ");
input = scanner.nextLine();
while (!input.equals("quit")) {
    // 입력 처리
    System.out.print("입력 (quit으로 종료): ");
    input = scanner.nextLine();
}
```

### 7.3 플래그 제어 루프
```java
boolean found = false;
int i = 0;
while (i < array.length && !found) {
    if (array[i] == target) {
        found = true;
    } else {
        i++;
    }
}
```

## 실용적인 팁

### 루프 작성시 체크리스트
1. ✓ 루프 변수가 초기화되었는가?
2. ✓ 종료 조건이 명확한가?
3. ✓ 루프 변수가 적절히 갱신되는가?
4. ✓ 무한 루프 가능성은 없는가?
5. ✓ 경계값 처리가 올바른가?

### 디버깅 팁
```java
// 루프 진행 상황 추적
int iteration = 0;
while (condition) {
    System.out.println("반복 " + iteration + ": " + relevantVar);
    // 루프 본문
    iteration++;
    
    if (iteration > 1000) {  // 안전장치
        System.out.println("너무 많은 반복!");
        break;
    }
}
```

## 요약

- **while 루프**: 조건을 먼저 검사, 0회 이상 실행
- **do..while 루프**: 먼저 실행 후 조건 검사, 1회 이상 실행
- **루프 준비**: 첫 조건 검사가 의미 있도록 사전 작업
- **센티넬 값**: 데이터 끝을 표시하는 특별한 값
- **break**: 루프 즉시 종료
- **continue**: 현재 반복 건너뛰기

💡 **기억하세요**: 적절한 루프 선택은 코드의 명확성과 효율성을 높입니다!