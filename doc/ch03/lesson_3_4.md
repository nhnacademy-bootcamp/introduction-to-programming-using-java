# 3.4 for 문 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- for 루프의 구조와 동작 원리를 이해한다
- while 루프와 for 루프를 적절히 변환할 수 있다
- 카운팅 루프를 효과적으로 구현할 수 있다
- 중첩된 for 루프를 이해하고 활용할 수 있다
- for 루프를 사용한 다양한 알고리즘을 구현할 수 있다

## 1. for 루프의 개념

### 1.1 왜 for 루프가 필요한가?
많은 while 루프는 다음과 같은 패턴을 가집니다:
```java
초기화
while (조건) {
    문장들
    업데이트
}
```

for 루프는 이 패턴을 더 간결하게 표현합니다:
```java
for (초기화; 조건; 업데이트) {
    문장들
}
```

### 1.2 for 루프의 장점
- **명확성**: 루프 제어 요소가 한 곳에 모여 있음
- **가독성**: 루프의 시작, 끝, 진행 방식을 한눈에 파악
- **안전성**: 업데이트를 잊어버릴 가능성이 줄어듦

## 2. for 루프의 구조

### 2.1 기본 문법
```java
for (초기화; 지속조건; 업데이트) {
    // 반복할 문장들
}
```

### 2.2 실행 순서
```
1. 초기화 실행 (한 번만)
2. 조건 검사
   - true → 루프 본문 실행
   - false → 루프 종료
3. 루프 본문 실행
4. 업데이트 실행
5. 2번으로 돌아감
```

### 2.3 while 루프와의 비교

**while 루프 버전:**
```java
int i = 0;          // 초기화
while (i < 10) {    // 조건
    System.out.println(i);
    i++;            // 업데이트
}
```

**for 루프 버전:**
```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

## 3. 카운팅 루프

### 3.1 가장 일반적인 for 루프 패턴
```java
// 0부터 9까지
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// 1부터 10까지
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

### 3.2 역순 카운팅
```java
// 10부터 1까지
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

### 3.3 증가값 조정
```java
// 짝수만 출력 (0, 2, 4, 6, 8)
for (int i = 0; i < 10; i += 2) {
    System.out.println(i);
}

// 3의 배수만 출력
for (int i = 3; i <= 30; i += 3) {
    System.out.println(i);
}
```

## 4. for 루프의 변형

### 4.1 여러 변수 사용
```java
// 두 변수를 동시에 사용
for (int i = 0, j = 10; i < 10; i++, j--) {
    System.out.println("i = " + i + ", j = " + j);
}
```

### 4.2 빈 요소
```java
// 무한 루프
for (;;) {
    // break로 종료해야 함
}

// 조건만 있는 경우
int i = 0;
for (; i < 10; ) {
    System.out.println(i);
    i++;
}
```

### 4.3 문자형 루프 제어 변수
```java
// 알파벳 출력
for (char ch = 'A'; ch <= 'Z'; ch++) {
    System.out.print(ch + " ");
}
// 출력: A B C D E F ... Z
```

## 5. 중첩된 for 루프

### 5.1 기본 개념
한 for 루프 안에 다른 for 루프가 들어있는 구조

### 5.2 구구단 예제
```java
for (int i = 2; i <= 9; i++) {
    System.out.println(i + "단:");
    for (int j = 1; j <= 9; j++) {
        System.out.println(i + " × " + j + " = " + (i * j));
    }
    System.out.println();
}
```

### 5.3 표 형태 출력
```java
// 3×3 표 출력
for (int row = 1; row <= 3; row++) {
    for (int col = 1; col <= 3; col++) {
        System.out.printf("%4d", row * col);
    }
    System.out.println();
}
```

## 6. for 루프 활용 패턴

### 6.1 조건부 처리 패턴
```java
// 1부터 100까지 소수 찾기
for (int n = 2; n <= 100; n++) {
    boolean isPrime = true;
    for (int d = 2; d < n; d++) {
        if (n % d == 0) {
            isPrime = false;
            break;
        }
    }
    if (isPrime) {
        System.out.println(n);
    }
}
```

### 6.2 누적 패턴
```java
// 1부터 100까지의 합
int sum = 0;
for (int i = 1; i <= 100; i++) {
    sum += i;
}
System.out.println("합계: " + sum);
```

### 6.3 검색 패턴
```java
// 배열에서 특정 값 찾기
int[] numbers = {5, 3, 8, 2, 9};
int target = 8;
boolean found = false;

for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == target) {
        System.out.println("위치: " + i);
        found = true;
        break;
    }
}
```

## 7. 주의사항과 팁

### 7.1 off-by-one 오류
```java
// 잘못된 예: 11번 반복됨
for (int i = 0; i <= 10; i++) {
    // 0부터 10까지 (11개)
}

// 올바른 예: 10번 반복
for (int i = 0; i < 10; i++) {
    // 0부터 9까지 (10개)
}
```

### 7.2 루프 변수의 범위
```java
for (int i = 0; i < 10; i++) {
    // i는 여기서만 사용 가능
}
// i는 여기서 사용 불가

// 루프 밖에서도 사용하려면
int i;
for (i = 0; i < 10; i++) {
    // 작업
}
// i는 여기서도 사용 가능
```

### 7.3 break와 continue
```java
// break: 루프 즉시 종료
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;  // i가 5일 때 종료
    }
    System.out.println(i);
}

// continue: 다음 반복으로
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;  // 짝수는 건너뛰기
    }
    System.out.println(i);  // 홀수만 출력
}
```

## 8. 성능 고려사항

### 8.1 효율적인 루프
```java
// 비효율적 (length()를 매번 호출)
for (int i = 0; i < str.length(); i++) {
    // 작업
}

// 효율적 (length를 한 번만 계산)
int len = str.length();
for (int i = 0; i < len; i++) {
    // 작업
}
```

### 8.2 중첩 루프 최적화
```java
// O(n²) 복잡도 - 주의 필요
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // n이 크면 매우 느림
    }
}
```

## 실용적인 팁

### for 루프 선택 가이드
1. **반복 횟수를 아는 경우**: for 루프 사용
2. **특정 조건까지 반복**: while 루프 고려
3. **카운터가 필요한 경우**: for 루프가 명확
4. **컬렉션 순회**: for 루프 (또는 향상된 for 루프)

### 디버깅 팁
```java
// 루프 진행 상황 확인
for (int i = 0; i < 100; i++) {
    if (i % 10 == 0) {
        System.out.println("진행: " + i + "/100");
    }
    // 실제 작업
}
```

## 요약

- **for 루프**: 초기화, 조건, 업데이트를 한 줄에 표현
- **카운팅 루프**: 가장 일반적인 for 루프 사용법
- **중첩 루프**: 2차원 데이터나 복잡한 패턴 처리
- **주의사항**: off-by-one 오류, 변수 범위, 무한 루프
- **선택 기준**: 반복 횟수를 알 때 for 루프가 적합

💡 **기억하세요**: for 루프는 while 루프의 특별한 형태입니다. 모든 for 루프는 while 루프로 변환 가능하며, 그 반대도 가능합니다!