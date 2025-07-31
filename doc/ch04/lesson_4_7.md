# 4.7 More on Program Design(프로그램 설계)

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 사전 조건과 사후 조건의 개념을 이해한다
- 서브루틴을 사용한 프로그램 설계 방법을 익힌다
- 상향식과 하향식 설계 접근법을 이해한다
- 단계적 세분화 기법을 활용할 수 있다
- 실제 프로그램 설계 과정을 따라갈 수 있다

## 1. 프로그램 설계의 기본 개념

### 1.1 설계와 구현의 차이
프로그램이 **어떻게 작동하는지** 이해하는 것과 **프로그램을 설계**하는 것은 완전히 다릅니다.

```
이해하기 = 완성된 퍼즐을 보는 것
설계하기 = 퍼즐 조각을 맞추는 것
```

### 1.2 설계 접근법

#### 상향식 접근법 (Bottom-up)
```
기본 요소 → 조합 → 전체 프로그램
```
- 작은 부분부터 시작
- 점진적으로 큰 구조 구축

#### 하향식 접근법 (Top-down)
```
전체 구조 → 세분화 → 세부 구현
```
- 큰 그림부터 시작
- 점진적으로 세부사항 구현

### 1.3 서브루틴의 역할
서브루틴은 프로그램 설계의 기본 빌딩 블록입니다.

```java
// 복잡한 작업을 서브루틴으로 분리
public static void main(String[] args) {
    openWindow();
    initializeData();
    processUserInput();
    displayResults();
    cleanup();
}
```

## 2. 사전 조건과 사후 조건

### 2.1 사전 조건 (Precondition)
**사전 조건**은 서브루틴이 올바르게 작동하기 위해 호출 시점에 반드시 참이어야 하는 조건입니다.

```java
/**
 * 제곱근을 계산합니다.
 *
 * 사전 조건: x >= 0 (음수가 아니어야 함)
 */
public static double sqrt(double x) {
    // x가 음수면 올바른 결과를 보장할 수 없음
    return Math.sqrt(x);
}
```

### 2.2 사후 조건 (Postcondition)
**사후 조건**은 서브루틴이 실행된 후에 참이 되는 조건입니다.

```java
/**
 * 배열을 오름차순으로 정렬합니다.
 *
 * 사전 조건: array != null
 * 사후 조건: array[0] <= array[1] <= ... <= array[n-1]
 */
public static void sortArray(int[] array) {
    Arrays.sort(array);
}
```

### 2.3 계약으로서의 사전/사후 조건
사전 조건과 사후 조건은 서브루틴과 호출자 간의 **계약**입니다.

```
호출자의 책임: 사전 조건을 만족시키기
서브루틴의 책임: 사후 조건을 달성하기
```

### 2.4 실제 예제
```java
/**
 * 두 수를 나눕니다.
 *
 * 사전 조건: divisor != 0
 * 사후 조건: 반환값 * divisor = dividend (오차 범위 내)
 *
 * @param dividend 피제수
 * @param divisor 제수
 * @return dividend / divisor
 * @throws ArithmeticException divisor가 0일 때
 */
public static double divide(double dividend, double divisor) {
    if (divisor == 0) {
        throw new ArithmeticException("0으로 나눌 수 없습니다");
    }
    return dividend / divisor;
}
```

## 3. 단계적 세분화 (Stepwise Refinement)

### 3.1 개념
복잡한 문제를 점진적으로 더 작고 구체적인 단계로 나누는 방법입니다.

### 3.2 예제: 성적 처리 프로그램
```
1단계 (추상적):
    학생 성적을 처리한다

2단계 (조금 더 구체적):
    성적을 입력받는다
    평균을 계산한다
    학점을 부여한다
    결과를 출력한다

3단계 (더 구체적):
    반복: 학생 수만큼
        이름을 입력받는다
        점수를 입력받는다
        평균 = 점수들의 합 / 과목 수
        학점 = 평균에 따른 등급
        결과를 화면에 출력한다

4단계 (코드로 변환 가능):
    for (int i = 0; i < studentCount; i++) {
        String name = inputName();
        double[] scores = inputScores();
        double average = calculateAverage(scores);
        char grade = determineGrade(average);
        printResult(name, average, grade);
    }
```

## 4. 설계 예제: 모자이크 애니메이션

### 4.1 문제 정의
색상이 있는 격자를 표시하고, 무작위로 색상을 변경하는 애니메이션을 만들기

### 4.2 사용 가능한 도구 (API)
```java
// Mosaic 클래스의 주요 메서드들
Mosaic.open(rows, cols, width, height)  // 창 열기
Mosaic.setColor(row, col, r, g, b)      // 색상 설정
Mosaic.getRed(row, col)                 // 빨간색 값 얻기
Mosaic.delay(milliseconds)              // 지연
```

### 4.3 설계 과정

#### 1단계: 전체 구조
```
창을 연다
격자를 초기화한다
애니메이션을 실행한다
```

#### 2단계: 세분화
```
모자이크 창을 연다
무작위 색상으로 격자를 채운다
무한 반복:
    무작위 위치를 선택한다
    해당 위치의 색상을 변경한다
    잠시 대기한다
```

#### 3단계: 더 구체적으로
```java
public static void main(String[] args) {
    // 16x20 격자, 각 셀은 25x25 픽셀
    Mosaic.open(16, 20, 25, 25);

    // 초기화
    fillWithRandomColors();

    // 애니메이션
    while (true) {
        int row = (int)(Math.random() * 16);
        int col = (int)(Math.random() * 20);
        changeToRandomColor(row, col);
        Mosaic.delay(10);
    }
}
```

### 4.4 서브루틴 설계

#### fillWithRandomColors 설계
```java
/**
 * 모든 격자를 무작위 색상으로 채웁니다.
 *
 * 사전 조건: 모자이크 창이 열려 있어야 함
 * 사후 조건: 모든 격자가 무작위 색상을 가짐
 */
static void fillWithRandomColors() {
    for (int row = 0; row < 16; row++) {
        for (int col = 0; col < 20; col++) {
            changeToRandomColor(row, col);
        }
    }
}
```

#### changeToRandomColor 설계
```java
/**
 * 지정된 위치의 색상을 무작위로 변경합니다.
 *
 * 사전 조건: row와 col이 유효한 범위 내에 있어야 함
 * 사후 조건: 지정된 위치가 새로운 무작위 색상을 가짐
 */
static void changeToRandomColor(int row, int col) {
    int red = (int)(256 * Math.random());
    int green = (int)(256 * Math.random());
    int blue = (int)(256 * Math.random());
    Mosaic.setColor(row, col, red, green, blue);
}
```

## 5. 실제 프로그램: RandomMosaicWalk

### 5.1 프로그램 개요
"교란"이 격자를 무작위로 돌아다니며 지나가는 곳의 색상을 변경하는 프로그램

### 5.2 주요 구성 요소
1. **전역 변수**: 현재 위치 추적
2. **main 메서드**: 전체 프로그램 제어
3. **fillWithRandomColors**: 초기화
4. **changeToRandomColor**: 색상 변경
5. **randomMove**: 위치 이동

### 5.3 randomMove 설계
```java
/**
 * 현재 위치를 인접한 셀로 이동시킵니다.
 *
 * 사전 조건: currentRow와 currentColumn이 유효한 위치
 * 사후 조건: 위치가 상하좌우 중 한 방향으로 이동됨
 */
static void randomMove() {
    int direction = (int)(4 * Math.random());

    switch (direction) {
        case 0:  // 위로
            currentRow--;
            if (currentRow < 0)
                currentRow = 15;  // 반대편으로 이동
            break;
        case 1:  // 오른쪽으로
            currentColumn++;
            if (currentColumn >= 20)
                currentColumn = 0;
            break;
        case 2:  // 아래로
            currentRow++;
            if (currentRow >= 16)
                currentRow = 0;
            break;
        case 3:  // 왼쪽으로
            currentColumn--;
            if (currentColumn < 0)
                currentColumn = 19;
            break;
    }
}
```

## 6. 설계 원칙과 모범 사례

### 6.1 좋은 설계의 특징
1. **모듈화**: 각 기능을 독립적인 서브루틴으로
2. **명확한 책임**: 각 서브루틴은 하나의 작업만
3. **재사용성**: 다른 프로그램에서도 사용 가능
4. **가독성**: 이해하기 쉬운 구조

### 6.2 설계 시 고려사항
- 각 서브루틴의 목적을 명확히
- 사전/사후 조건을 명시
- 적절한 추상화 수준 유지
- 테스트 가능한 단위로 분할

### 6.3 문서화의 중요성
```java
/**
 * 이 메서드가 무엇을 하는지 설명
 *
 * 사전 조건: 메서드 호출 전 만족해야 할 조건
 * 사후 조건: 메서드 실행 후 보장되는 조건
 *
 * @param 매개변수 설명
 * @return 반환값 설명
 * @throws 발생 가능한 예외
 */
```

## 요약

### 핵심 개념
- **사전 조건**: 서브루틴 호출 전 만족해야 할 조건
- **사후 조건**: 서브루틴 실행 후 보장되는 조건
- **단계적 세분화**: 복잡한 문제를 작은 단계로 나누기
- **상향식/하향식**: 두 가지 설계 접근법

### 설계 프로세스
1. 문제를 이해한다
2. 전체 구조를 스케치한다
3. 주요 컴포넌트를 식별한다
4. 각 컴포넌트를 세분화한다
5. 서브루틴으로 구현한다
6. 통합하고 테스트한다

### 성공적인 설계를 위한 팁
- 한 번에 하나의 문제에 집중
- 복잡한 것은 단순한 것들로 분해
- 재사용 가능한 컴포넌트 만들기
- 명확한 문서화

💡 **기억하세요**: 좋은 설계는 프로그램을 이해하기 쉽고, 수정하기 쉽고, 확장하기 쉽게 만듭니다!