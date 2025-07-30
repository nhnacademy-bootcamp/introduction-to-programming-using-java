# 4.7 프로그램 설계 - 수업 실습

## 1. 사전 조건과 사후 조건 실습

### 실습 1-1: 기본적인 사전/사후 조건 작성하기

#### 요구사항
- 메서드의 사전 조건과 사후 조건을 명확히 정의하고 구현
- 팩토리얼 계산 메서드 구현
- 음수 입력에 대한 예외 처리

```java
public class PreconditionPostconditionExample {
    public static void main(String[] args) {
        System.out.println("=== 사전/사후 조건 예제 ===\n");
        
        // TODO 1: factorial 메서드 테스트하기
        // System.out.println("5! = " + factorial(5));  // 120
        // System.out.println("0! = " + factorial(0));  // 1
        
        // TODO 2: 예외 상황 테스트하기
        // try {
        //     System.out.println("(-3)! = " + factorial(-3));  // 예외 발생
        // } catch (IllegalArgumentException e) {
        //     System.out.println("오류: " + e.getMessage());
        // }
    }
    
    // TODO 3: factorial 메서드 구현하기
    /**
     * 숫자의 팩토리얼을 계산합니다.
     * 
     * 사전 조건: n >= 0 (음수가 아니어야 함)
     * 사후 조건: 반환값 = n! = n × (n-1) × ... × 2 × 1
     * 
     * @param n 팩토리얼을 계산할 숫자
     * @return n의 팩토리얼
     * @throws IllegalArgumentException n이 음수일 때
     */
    public static long factorial(int n) {
        // 사전 조건 검사: n이 음수이면 예외 발생
        
        // 반복문으로 팩토리얼 계산
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 사전/사후 조건 예제 ===

5! = 120
0! = 1
오류: 음수의 팩토리얼은 정의되지 않습니다: -3
```

### 실습 1-2: 배열 관련 사전/사후 조건 구현하기

#### 요구사항
- 배열을 처리하는 메서드의 사전/사후 조건 구현
- 최대값 찾기 메서드 구현 (null 및 빈 배열 처리)
- 배열 뒤집기 메서드 구현

```java
import java.util.Arrays;

public class ArrayPreconditionExample {
    public static void main(String[] args) {
        System.out.println("=== 배열 사전/사후 조건 예제 ===\n");
        
        // TODO 4: 배열 메서드들 테스트하기
        int[] numbers = {3, 7, 2, 9, 1, 5};
        
        // System.out.println("원본 배열: " + Arrays.toString(numbers));
        // System.out.println("최대값: " + findMax(numbers));
        
        // reverseArray(numbers);
        // System.out.println("뒤집은 배열: " + Arrays.toString(numbers));
    }
    
    // TODO 5: findMax 메서드 구현하기
    /**
     * 배열에서 최대값을 찾습니다.
     * 
     * 사전 조건: 
     *   - array != null
     *   - array.length > 0
     * 사후 조건: 
     *   - 반환값 >= array[i] (모든 i에 대해)
     *   - 반환값은 배열의 원소 중 하나
     * 
     * @param array 검색할 배열
     * @return 배열의 최대값
     * @throws IllegalArgumentException 배열이 null이거나 비어있을 때
     */
    public static int findMax(int[] array) {
        // 사전 조건 검사
        
        // 최대값 찾기
        
    }
    
    // TODO 6: reverseArray 메서드 구현하기
    /**
     * 배열을 뒤집습니다.
     * 
     * 사전 조건: array != null
     * 사후 조건: array[i] = 원래 array[n-1-i] (모든 i에 대해, n은 배열 길이)
     * 
     * @param array 뒤집을 배열
     */
    public static void reverseArray(int[] array) {
        // 사전 조건 검사
        
        // 배열 뒤집기 (두 포인터 사용)
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 배열 사전/사후 조건 예제 ===

원본 배열: [3, 7, 2, 9, 1, 5]
최대값: 9
뒤집은 배열: [5, 1, 9, 2, 7, 3]
```

### 실습 1-3: 문자열 처리의 사전/사후 조건 구현하기

#### 요구사항
- 문자열을 처리하는 메서드의 계약 정의 및 구현
- 회문(palindrome) 검사 메서드 구현
- 공백 제거 메서드 구현

```java
public class StringPreconditionExample {
    public static void main(String[] args) {
        System.out.println("=== 문자열 사전/사후 조건 예제 ===\n");
        
        // TODO 7: 문자열 메서드들 테스트하기
        // String test1 = "level";
        // String test2 = "hello";
        // String test3 = "a man a plan a canal panama";
        
        // System.out.println("'" + test1 + "' 회문인가? " + isPalindrome(test1));
        // System.out.println("'" + test2 + "' 회문인가? " + isPalindrome(test2));
        
        // String result = removeSpaces(test3);
        // System.out.println("공백 제거: '" + result + "'");
    }
    
    // TODO 8: isPalindrome 메서드 구현하기
    /**
     * 문자열이 회문(palindrome)인지 검사합니다.
     * 
     * 사전 조건: str != null
     * 사후 조건: 
     *   - true 반환: str을 뒤집어도 같음
     *   - false 반환: str을 뒤집으면 다름
     * 
     * @param str 검사할 문자열
     * @return 회문이면 true
     */
    public static boolean isPalindrome(String str) {
        // 사전 조건 검사
        
        // 두 포인터로 양쪽에서 비교
        
    }
    
    // TODO 9: removeSpaces 메서드 구현하기
    /**
     * 문자열에서 모든 공백을 제거합니다.
     * 
     * 사전 조건: str != null
     * 사후 조건: 반환된 문자열에는 공백 문자가 없음
     * 
     * @param str 처리할 문자열
     * @return 공백이 제거된 문자열
     */
    public static String removeSpaces(String str) {
        // 사전 조건 검사
        
        // StringBuilder를 사용하여 공백이 아닌 문자만 추가
        
    }
}
```

#### 실행 결과 (참고용):
```
=== 문자열 사전/사후 조건 예제 ===

'level' 회문인가? true
'hello' 회문인가? false
공백 제거: 'amanaplanacanalpanama'
```

## 2. 단계적 세분화 실습

### 실습 2-1: 숫자 맞추기 게임 설계하기

#### 요구사항
- 복잡한 프로그램을 단계적으로 세분화하여 설계
- 1-100 사이의 숫자 맞추기 게임 구현
- 게임 흐름 제어와 사용자 입력 처리
- 힌트 제공 및 결과 표시

```java
import java.util.Scanner;

public class NumberGuessingGame {
    // TODO 10: 게임 관련 변수들 선언하기
    // secretNumber (정수), attempts (정수), MAX_NUMBER (상수, 100)
    
    public static void main(String[] args) {
        // TODO 11: 게임 실행하기
        // playGame();
    }
    
    // TODO 12: playGame 메서드 구현하기 (전체 게임 흐름)
    /**
     * 게임의 전체 흐름을 제어합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 게임이 완료됨 (사용자가 숫자를 맞추거나 포기함)
     */
    static void playGame() {
        // 1. 게임 초기화
        // 2. 게임 설명 표시
        // 3. 추측 반복 (정답을 맞출 때까지)
        // 4. 결과 표시
    }
    
    // TODO 13: initializeGame 메서드 구현하기
    /**
     * 게임을 초기화합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: secretNumber가 1~100 사이의 값으로 설정됨, attempts = 0
     */
    static void initializeGame() {
        // Math.random()을 사용해 1~MAX_NUMBER 사이의 랜덤 숫자 생성
        // attempts를 0으로 초기화
    }
    
    // TODO 14: showInstructions 메서드 구현하기
    /**
     * 게임 설명을 표시합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 게임 방법이 화면에 표시됨
     */
    static void showInstructions() {
        // 게임 제목과 설명 출력
    }
    
    // TODO 15: getUserInput 메서드 구현하기
    /**
     * 사용자로부터 입력을 받습니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 1~MAX_NUMBER 사이의 유효한 정수가 반환됨
     * 
     * @return 사용자가 입력한 숫자
     */
    static int getUserInput() {
        // Scanner를 사용해 유효한 입력을 받을 때까지 반복
        // 예외 처리로 잘못된 입력 처리
    }
    
    // TODO 16: checkGuess 메서드 구현하기
    /**
     * 사용자의 추측을 확인합니다.
     * 
     * 사전 조건: 1 <= guess <= MAX_NUMBER
     * 사후 조건: 
     *   - attempts가 1 증가
     *   - 적절한 힌트가 표시됨
     * 
     * @param guess 사용자의 추측
     * @return 정답을 맞췄으면 true
     */
    static boolean checkGuess(int guess) {
        // attempts 증가
        // 추측과 정답 비교하여 힌트 제공
        // 정답이면 true, 아니면 false 반환
    }
    
    // TODO 17: showResults 메서드 구현하기
    /**
     * 게임 결과를 표시합니다.
     * 
     * 사전 조건: 게임이 완료됨
     * 사후 조건: 시도 횟수와 축하 메시지가 표시됨
     */
    static void showResults() {
        // 축하 메시지와 시도 횟수 출력
        // 시도 횟수에 따른 평가 메시지
    }
}
```

#### 실행 결과 (참고용):
```
=== 숫자 맞추기 게임 ===
1부터 100 사이의 숫자를 맞춰보세요!

추측한 숫자: 50
더 작은 수입니다.
추측한 숫자: 25
더 큰 수입니다.
추측한 숫자: 37
더 작은 수입니다.
추측한 숫자: 31
더 큰 수입니다.
추측한 숫자: 34
정답입니다!

축하합니다!
5번 만에 맞추셨습니다.
훌륭합니다!
```

### 실습 2-2: 성적 관리 프로그램 설계하기

#### 요구사항
- 메뉴 기반 프로그램을 단계적으로 설계
- 학생 추가, 전체 보기, 통계 기능 구현
- 평균 점수 계산 및 학점 부여
- 최대 100명 학생 관리

```java
import java.util.Scanner;

public class GradeManager {
    // TODO 18: 프로그램 변수들 선언하기
    // MAX_STUDENTS (상수, 100), names (문자열 배열), 
    // averages (실수 배열), studentCount (정수)
    
    public static void main(String[] args) {
        // TODO 19: 메인 프로그램 실행하기
        // runGradeManager();
    }
    
    // TODO 20: runGradeManager 메서드 구현하기
    /**
     * 프로그램의 메인 루프
     * 
     * 사전 조건: 없음
     * 사후 조건: 프로그램이 정상 종료됨
     */
    static void runGradeManager() {
        // 메뉴 반복 표시하고 사용자 선택 처리
        // 1: 학생 추가, 2: 전체 보기, 3: 통계, 4: 종료
    }
    
    // TODO 21: displayMenu 메서드 구현하기
    /**
     * 메뉴를 표시합니다.
     */
    static void displayMenu() {
        // 메뉴 옵션들 출력
    }
    
    // TODO 22: addStudent 메서드 구현하기
    /**
     * 새 학생을 추가합니다.
     * 
     * 사전 조건: studentCount < MAX_STUDENTS
     * 사후 조건: 새 학생이 배열에 추가되고 studentCount가 증가함
     */
    static void addStudent() {
        // 배열 공간 확인
        // 이름 입력받기
        // 점수 입력받고 평균 계산하기
        // 배열에 저장하고 카운트 증가
    }
    
    // TODO 23: inputAndCalculateAverage 메서드 구현하기
    /**
     * 점수를 입력받고 평균을 계산합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 0 <= 반환값 <= 100
     * 
     * @return 계산된 평균 점수
     */
    static double inputAndCalculateAverage() {
        // 3과목의 점수를 입력받아 평균 계산
        // 각 점수는 0-100 범위 검증
    }
    
    // TODO 24: displayAllStudents 메서드 구현하기
    /**
     * 모든 학생을 표시합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 모든 학생 정보가 화면에 표시됨
     */
    static void displayAllStudents() {
        // 학생 수 확인
        // 표 형태로 학생 정보와 학점 출력
    }
    
    // TODO 25: calculateGrade 메서드 구현하기
    /**
     * 평균 점수로 학점을 계산합니다.
     * 
     * 사전 조건: 0 <= average <= 100
     * 사후 조건: 반환값은 'A', 'B', 'C', 'D', 'F' 중 하나
     * 
     * @param average 평균 점수
     * @return 학점
     */
    static char calculateGrade(double average) {
        // 90이상: A, 80이상: B, 70이상: C, 60이상: D, 60미만: F
    }
    
    // TODO 26: displayStatistics 메서드 구현하기
    /**
     * 통계 정보를 표시합니다.
     * 
     * 사전 조건: studentCount > 0
     * 사후 조건: 평균, 최고점, 최저점이 표시됨
     */
    static void displayStatistics() {
        // 학생 수 확인
        // 전체 평균, 최고점, 최저점 계산하여 출력
    }
    
    // TODO 27: 통계 계산 보조 메서드들 구현하기
    static double calculateTotalAverage() { }
    static double findHighest() { }
    static double findLowest() { }
}
```

#### 실행 결과 (참고용):
```
=== 성적 관리 시스템 ===
1. 학생 추가
2. 전체 학생 보기
3. 통계 보기
4. 종료
선택: 1

학생 이름: 김철수
3과목의 점수를 입력하세요:
과목 1: 85
과목 2: 90
과목 3: 78
학생이 추가되었습니다.

=== 전체 학생 목록 ===
이름               평균    학점
------------------------------
김철수            84.33     B
```

## 3. 모자이크 프로그램 설계 실습

### 실습 3-1: 체스판 패턴 모자이크 만들기

#### 요구사항
- 간단한 모자이크 프로그램을 단계적으로 설계
- 8x8 체스판 패턴 구현
- 흑백 교차 패턴 생성

```java
public class ChessboardMosaic {
    // TODO 28: 상수들 선언하기
    // ROWS (8), COLS (8), SQUARE_SIZE (50)
    
    public static void main(String[] args) {
        // TODO 29: 체스판 그리기 실행
        // drawChessboard();
    }
    
    // TODO 30: drawChessboard 메서드 구현하기
    /**
     * 체스판을 그립니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 8x8 체스판이 화면에 표시됨
     */
    static void drawChessboard() {
        // 1. 모자이크 창 열기
        // 2. 체스판 패턴 채우기
        // 3. 프로그램 유지 (무한 루프)
    }
    
    // TODO 31: fillChessboardPattern 메서드 구현하기
    /**
     * 체스판 패턴으로 채웁니다.
     * 
     * 사전 조건: 모자이크 창이 열려 있음
     * 사후 조건: 흑백 체스판 패턴이 그려짐
     */
    static void fillChessboardPattern() {
        // 이중 반복문으로 각 칸 채우기
        // (row + col) % 2로 흑백 패턴 결정
    }
}
```

### 실습 3-2: 그라데이션 모자이크 만들기

#### 요구사항
- 동적으로 변화하는 모자이크 패턴 구현
- 수평, 수직, 대각선 그라데이션
- 패턴 순환 애니메이션

```java
public class GradientMosaic {
    // TODO 32: 상수들 선언하기
    // ROWS (20), COLS (30), SIZE (20)
    
    public static void main(String[] args) {
        // TODO 33: 그라데이션 디스플레이 실행
        // createGradientDisplay();
    }
    
    // TODO 34: createGradientDisplay 메서드 구현하기
    /**
     * 그라데이션 디스플레이를 생성합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 여러 그라데이션 패턴이 순환하며 표시됨
     */
    static void createGradientDisplay() {
        // 모자이크 창 열기
        // 무한 루프로 패턴 순환 (수평, 수직, 대각선)
    }
    
    // TODO 35: 그라데이션 패턴 메서드들 구현하기
    /**
     * 수평 그라데이션을 그립니다.
     * 
     * 사전 조건: 모자이크 창이 열려 있음
     * 사후 조건: 왼쪽에서 오른쪽으로 색상이 변하는 그라데이션
     */
    static void horizontalGradient() {
        // 열 위치에 따라 빨강-파랑 그라데이션
    }
    
    static void verticalGradient() {
        // 행 위치에 따라 초록-파랑 그라데이션
    }
    
    static void diagonalGradient() {
        // 대각선 위치에 따라 색상 변화
    }
}
```

### 실습 3-3: 상호작용 모자이크 만들기

#### 요구사항
- 여러 객체가 움직이는 애니메이션 모자이크 구현
- 다중 워커 시스템 구현
- 색상 흔적 남기기 기능
- 경계 처리 및 무한 반복

```java
public class MultiWalkerMosaic {
    // TODO 36: 상수와 변수들 선언하기
    // ROWS (25), COLS (40), SIZE (15), NUM_WALKERS (3)
    // walkerRows, walkerCols, walkerColors 배열들
    
    public static void main(String[] args) {
        // TODO 37: 멀티 워커 애니메이션 실행
        // runMultiWalkerAnimation();
    }
    
    // TODO 38: runMultiWalkerAnimation 메서드 구현하기
    /**
     * 다중 워커 애니메이션을 실행합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 프로그램이 사용자가 창을 닫을 때까지 실행됨
     */
    static void runMultiWalkerAnimation() {
        // 1. 디스플레이 초기화
        // 2. 워커들 초기화
        // 3. 무한 루프로 워커들 업데이트
    }
    
    // TODO 39: 초기화 메서드들 구현하기
    static void initializeDisplay() {
        // 모자이크 창 열고 어두운 배경 설정
    }
    
    static void initializeWalkers() {
        // 각 워커의 무작위 위치와 색상 설정
    }
    
    // TODO 40: 워커 업데이트 메서드들 구현하기
    static void updateAllWalkers() {
        // 모든 워커의 색상 흔적 남기고 이동
    }
    
    static void leaveColorTrail(int row, int col, int color) {
        // 현재 색상과 새 색상을 혼합하여 설정
    }
    
    static void moveWalker(int walkerIndex) {
        // 4방향 중 랜덤하게 이동 (경계에서 반대편으로 이동)
    }
}
```

## 4. 종합 설계 실습: 텍스트 RPG 게임

### 실습 4-1: 텍스트 RPG 게임 설계하기

#### 요구사항
- 복잡한 게임을 단계적 세분화와 모듈화로 설계
- 캐릭터 생성 및 상태 관리
- 던전 탐험, 전투, 상점 시스템 구현
- 레벨업 및 게임 오버 처리

```java
import java.util.Scanner;

public class SimpleRPG {
    // TODO 41: 게임 상태 변수들 선언하기
    // playerName (문자열), playerHealth (정수, 100), 
    // playerLevel (정수, 1), playerExp (정수, 0), playerGold (정수, 50)
    
    // TODO 42: 게임 설정 상수들 선언하기
    // MAX_HEALTH (100), EXP_PER_LEVEL (100)
    
    public static void main(String[] args) {
        // TODO 43: 게임 실행
        // runGame();
    }
    
    // TODO 44: runGame 메서드 구현하기 (메인 게임 루프)
    /**
     * 게임의 메인 루프를 실행합니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 게임이 정상적으로 종료됨
     */
    static void runGame() {
        // 1. 게임 소개
        // 2. 캐릭터 생성
        // 3. 게임 루프 (체력이 0이 되거나 종료할 때까지)
        //    - 상태 표시
        //    - 메뉴 선택
        //    - 선택에 따른 행동 실행
        // 4. 게임 오버 처리
    }
    
    // TODO 45: 게임 초기화 메서드들 구현하기
    static void showIntro() {
        // 게임 제목과 간단한 설명 출력
    }
    
    static void createCharacter() {
        // 플레이어 이름 입력받기
    }
    
    // TODO 46: 게임 인터페이스 메서드들 구현하기
    static void showStatus() {
        // 현재 레벨, 체력, 경험치, 골드 표시
    }
    
    /**
     * 메인 메뉴를 표시하고 선택을 받습니다.
     * 
     * 사전 조건: 없음
     * 사후 조건: 1-4 사이의 유효한 선택이 반환됨
     * 
     * @return 사용자의 선택
     */
    static int showMainMenu() {
        // 1. 던전 탐험, 2. 상점 방문, 3. 휴식, 4. 게임 종료
        // 유효한 입력이 올 때까지 반복
    }
    
    // TODO 47: 게임 액션 메서드들 구현하기
    static void exploreDungeon() {
        // 랜덤 이벤트 (0: 몬스터, 1: 보물, 2: 빈 방)
    }
    
    static void encounterMonster() {
        // 몬스터와의 전투 시스템
        // 플레이어 공격과 몬스터 반격
        // 승리 시 경험치와 골드 획득
    }
    
    static void findTreasure() {
        // 랜덤한 골드 획득
    }
    
    static void findNothing() {
        // 아무것도 없는 방 메시지
    }
    
    // TODO 48: 캐릭터 관리 메서드들 구현하기
    static void checkLevelUp() {
        // 경험치가 충분하면 레벨업 처리
    }
    
    static void visitShop() {
        // 체력 포션 구매 시스템
    }
    
    static void rest() {
        // 체력 회복
    }
    
    static void showGameOver() {
        // 최종 결과 표시
    }
}
```

#### 실행 결과 (참고용):
```
=================================
    간단한 텍스트 RPG 게임
=================================
어둠의 던전에서 살아남으세요!

캐릭터 이름을 입력하세요: 용사

환영합니다, 용사님!
모험을 시작합니다...

--- 용사의 상태 ---
레벨: 1
체력: 100/100
경험치: 0/100
골드: 50
----------------

무엇을 하시겠습니까?
1. 던전 탐험
2. 상점 방문
3. 휴식
4. 게임 종료
선택: 1

던전에 들어갑니다...
몬스터를 만났습니다!

몬스터 체력: 40
1. 공격  2. 도망
1
15의 피해를 입혔습니다!
몬스터가 7의 피해를 입혔습니다!

몬스터를 물리쳤습니다!
경험치 +35
골드 +25
```

## 학습 포인트

### 1. 사전 조건과 사후 조건
- **사전 조건**: 메서드 실행 전에 만족되어야 하는 조건
- **사후 조건**: 메서드 실행 후에 보장되는 결과
- **계약 프로그래밍**: 명확한 인터페이스 정의

### 2. 단계적 세분화
- **하향식 설계**: 큰 문제를 작은 문제로 나누기
- **모듈화**: 각 기능을 독립적인 메서드로 분리
- **추상화**: 복잡한 구현을 간단한 인터페이스로 숨기기

### 3. 프로그램 설계 원칙
- **단일 책임**: 각 메서드는 하나의 명확한 역할
- **재사용성**: 범용적으로 사용 가능한 메서드 설계
- **유지보수성**: 수정과 확장이 쉬운 구조

### 4. 설계 과정
- **요구사항 분석**: 무엇을 만들 것인가?
- **전체 설계**: 큰 틀에서의 구조 설계
- **세부 설계**: 각 모듈의 상세 구현
- **테스트와 검증**: 설계가 요구사항을 만족하는가?

이러한 설계 원칙들을 통해 복잡한 프로그램도 체계적으로 개발할 수 있습니다!