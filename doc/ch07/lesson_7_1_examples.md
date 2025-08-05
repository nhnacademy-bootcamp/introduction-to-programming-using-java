# 7.1 배열 세부 사항 - 수업 실습

## 1. For-each 루프 예제

### 예제 1-1: 기본 배열 순회

```java
public class ForEachBasics {
    public static void main(String[] args) {
        // 정수 배열
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("=== 전통적인 for 루프 ===");
        // TODO: 전통적인 for 루프를 사용하여 배열의 인덱스와 값을 출력하세요
        // 형식: "numbers[인덱스] = 값"
        
        
        System.out.println("\n=== for-each 루프 ===");
        // TODO: for-each 루프를 사용하여 배열의 값들을 출력하세요
        // 형식: "값: 값"
        
        
        // 문자열 배열
        String[] days = {"월요일", "화요일", "수요일", "목요일", "금요일"};
        
        System.out.println("\n=== 요일 출력 ===");
        // TODO: for-each 루프를 사용하여 각 요일 뒤에 "입니다."를 붙여서 출력하세요
        
    }
}
```

**실행 결과:**
```
=== 전통적인 for 루프 ===
numbers[0] = 10
numbers[1] = 20
numbers[2] = 30
numbers[3] = 40
numbers[4] = 50

=== for-each 루프 ===
값: 10
값: 20
값: 30
값: 40
값: 50

=== 요일 출력 ===
월요일입니다.
화요일입니다.
수요일입니다.
목요일입니다.
금요일입니다.
```

### 예제 1-2: 배열 통계 계산

```java
public class ArrayStatistics {
    public static void main(String[] args) {
        double[] temperatures = {23.5, 25.2, 22.8, 24.1, 26.3, 23.9, 25.5};
        
        // TODO: for-each 루프를 사용하여 모든 온도의 합을 계산하세요
        double sum = 0;
        
        
        double average = sum / temperatures.length;
        
        // TODO: 최고/최저 온도를 찾으세요
        // 힌트: 첫 번째 요소로 초기화한 후 for-each 루프 사용
        double max = temperatures[0];
        double min = temperatures[0];
        
        
        System.out.println("=== 주간 온도 통계 ===");
        System.out.printf("평균 온도: %.1f°C\n", average);
        System.out.printf("최고 온도: %.1f°C\n", max);
        System.out.printf("최저 온도: %.1f°C\n", min);
        System.out.printf("온도 차이: %.1f°C\n", max - min);
    }
}
```

**실행 결과:**
```
=== 주간 온도 통계 ===
평균 온도: 24.5°C
최고 온도: 26.3°C
최저 온도: 22.8°C
온도 차이: 3.5°C
```

### 예제 1-3: 조건부 처리

```java
public class ConditionalProcessing {
    public static void main(String[] args) {
        int[] scores = {65, 78, 92, 55, 88, 73, 95, 81, 68, 87};
        
        // TODO: 합격자 수와 합격자 점수 총합을 계산하세요 (70점 이상)
        int passCount = 0;
        int totalPass = 0;
        
        System.out.println("=== 시험 결과 ===");
        // TODO: for-each 루프를 사용하여 각 점수에 대해 합격/불합격을 출력하세요
        // 70점 이상이면 "점수점: 합격", 미만이면 "점수점: 불합격"
        // 합격인 경우 passCount와 totalPass 업데이트
        
        
        System.out.println("\n=== 결과 요약 ===");
        System.out.println("전체 응시자: " + scores.length + "명");
        System.out.println("합격자: " + passCount + "명");
        System.out.println("불합격자: " + (scores.length - passCount) + "명");
        if (passCount > 0) {
            System.out.printf("합격자 평균: %.1f점\n", 
                            (double)totalPass / passCount);
        }
    }
}
```

**실행 결과:**
```
=== 시험 결과 ===
65점: 불합격
78점: 합격
92점: 합격
55점: 불합격
88점: 합격
73점: 합격
95점: 합격
81점: 합격
68점: 불합격
87점: 합격

=== 결과 요약 ===
전체 응시자: 10명
합격자: 7명
불합격자: 3명
합격자 평균: 84.6점
```

### 예제 1-4: for-each의 한계

```java
public class ForEachLimitations {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        
        // 1. 배열 수정 시도 (실패)
        System.out.println("=== 배열 수정 시도 ===");
        System.out.println("수정 전: ");
        printArray(values);
        
        // TODO: for-each 루프를 사용하여 각 요소에 10을 곱해보세요
        // 주의: 이 방법으로는 배열이 변경되지 않습니다!
        
        
        System.out.println("for-each 후: ");
        printArray(values);  // 변경되지 않음
        
        // TODO: 올바른 방법으로 배열의 각 요소에 10을 곱하세요
        // 힌트: 인덱스를 사용한 일반 for 루프 사용
        
        
        System.out.println("인덱스 사용 후: ");
        printArray(values);  // 변경됨
        
        // 2. 인덱스가 필요한 경우
        String[] items = {"첫째", "둘째", "셋째", "넷째"};
        
        System.out.println("\n=== 인덱스가 필요한 경우 ===");
        // TODO: 인덱스를 사용하여 "번호번: 항목" 형식으로 출력하세요
        // 예: "1번: 첫째"
        
        
        // 3. 역순 처리
        System.out.println("\n=== 역순 처리 ===");
        // TODO: 배열을 역순으로 출력하세요
        
    }
    
    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
```

**실행 결과:**
```
=== 배열 수정 시도 ===
수정 전: 
1 2 3 4 5 
for-each 후: 
1 2 3 4 5 
인덱스 사용 후: 
10 20 30 40 50 

=== 인덱스가 필요한 경우 ===
1번: 첫째
2번: 둘째
3번: 셋째
4번: 넷째

=== 역순 처리 ===
넷째
셋째
둘째
첫째
```

## 2. 가변 인수 메서드 예제

### 예제 2-1: 기본 가변 인수

```java
public class VarArgsBasics {
    // TODO: 가변 인수를 사용한 합계 계산 메서드를 작성하세요
    // 메서드명: sum, 매개변수: int... numbers
    // 모든 숫자의 합을 반환
    
    
    // TODO: 가변 인수를 사용한 최댓값 찾기 메서드를 작성하세요
    // 메서드명: max, 매개변수: int... numbers
    // 숫자가 없으면 IllegalArgumentException 던지기
    
    
    // TODO: 가변 인수를 사용한 평균 계산 메서드를 작성하세요
    // 메서드명: average, 매개변수: double... values
    // 값이 없으면 0.0 반환
    
    
    public static void main(String[] args) {
        // 다양한 개수의 인수로 호출
        System.out.println("sum() = " + sum());  // 0
        System.out.println("sum(5) = " + sum(5));  // 5
        System.out.println("sum(1,2,3) = " + sum(1, 2, 3));  // 6
        System.out.println("sum(1,2,3,4,5) = " + sum(1, 2, 3, 4, 5));  // 15
        
        System.out.println("\nmax(10,5,8) = " + max(10, 5, 8));  // 10
        System.out.println("max(3,7,2,9,5) = " + max(3, 7, 2, 9, 5));  // 9
        
        System.out.printf("\naverage(85.5, 90.0, 78.5) = %.2f\n", 
                         average(85.5, 90.0, 78.5));
        
        // 배열을 가변 인수로 전달
        int[] array = {10, 20, 30, 40, 50};
        System.out.println("\n배열 전달: sum(array) = " + sum(array));
    }
}
```

**실행 결과:**
```
sum() = 0
sum(5) = 5
sum(1,2,3) = 6
sum(1,2,3,4,5) = 15

max(10,5,8) = 10
max(3,7,2,9,5) = 9

average(85.5, 90.0, 78.5) = 84.67

배열 전달: sum(array) = 150
```

### 예제 2-2: 혼합 매개변수

```java
public class MixedParameters {
    // TODO: 일반 매개변수와 가변 인수를 혼합한 메서드를 작성하세요
    // 메서드명: formatMessage
    // 매개변수: String prefix, String... items
    // 반환값: "prefix: item1, item2, item3" 형태의 문자열
    
    
    // TODO: 다양한 타입의 매개변수를 가진 메서드를 작성하세요
    // 메서드명: printReport
    // 매개변수: String title, int year, double... values
    // 출력: 제목, 각 월의 값, 연간 총계, 월 평균
    
    
    public static void main(String[] args) {
        // formatMessage 사용
        System.out.println(formatMessage("과일", "사과", "바나나", "오렌지"));
        System.out.println(formatMessage("색상", "빨강", "파랑"));
        System.out.println(formatMessage("숫자"));  // 가변 인수 0개
        
        System.out.println();
        
        // printReport 사용
        printReport("월별 매출", 2024, 
                   150.5, 180.3, 165.7, 195.2, 210.5, 188.9);
    }
}
```

**실행 결과:**
```
과일: 사과, 바나나, 오렌지
색상: 빨강, 파랑
숫자: 

=== 월별 매출 (2024년) ===
1월: 150.5
2월: 180.3
3월: 165.7
4월: 195.2
5월: 210.5
6월: 188.9
연간 총계: 1091.1
월 평균: 181.9
```

### 예제 2-3: 실용적인 유틸리티 메서드

```java
public class VarArgsUtilities {
    // TODO: 문자열 연결 메서드를 작성하세요
    // 메서드명: join
    // 매개변수: String delimiter, String... parts
    // 구분자로 문자열들을 연결하여 반환
    
    
    // TODO: 조건을 만족하는 개수 세기 메서드를 작성하세요
    // 메서드명: countPositive
    // 매개변수: int... numbers
    // 양수의 개수를 반환
    
    
    // TODO: 최소값과 최대값 동시에 찾기 메서드를 작성하세요
    // 메서드명: findMinMax
    // 매개변수: int... values
    // 반환값: int[] {최소값, 최대값}, 값이 없으면 null
    
    
    // TODO: 가변 인수로 배열 생성 메서드를 작성하세요
    // 메서드명: createArray
    // 매개변수: int... elements
    // 가변 인수의 복사본 배열을 반환
    
    
    public static void main(String[] args) {
        // join 사용
        System.out.println(join("-", "2024", "11", "15"));  // 2024-11-15
        System.out.println(join(" | ", "Home", "About", "Contact"));
        
        // countPositive 사용
        System.out.println("\n양수 개수: " + 
                         countPositive(-5, 3, 0, -2, 7, 1, -8));  // 3
        
        // findMinMax 사용
        int[] minMax = findMinMax(45, 12, 78, 34, 90, 23);
        if (minMax != null) {
            System.out.println("최소값: " + minMax[0]);  // 12
            System.out.println("최대값: " + minMax[1]);  // 90
        }
        
        // createArray 사용
        int[] myArray = createArray(10, 20, 30, 40);
        System.out.print("\n생성된 배열: ");
        for (int val : myArray) {
            System.out.print(val + " ");
        }
    }
}
```

**실행 결과:**
```
2024-11-15
Home | About | Contact

양수 개수: 3
최소값: 12
최대값: 90

생성된 배열: 10 20 30 40 
```

## 3. 배열 리터럴 예제

### 예제 3-1: 배열 리터럴 기본 사용

```java
public class ArrayLiterals {
    public static void main(String[] args) {
        // TODO: 배열 리터럴을 사용하여 소수 배열을 생성하세요
        int[] primes = ;
        
        // TODO: new 연산자와 함께 배열 리터럴을 사용하여 짝수 배열을 생성하세요
        int[] evens = ;
        
        // TODO: 변수에 나중에 배열 리터럴을 할당하세요 (피보나치 수열)
        int[] fibonacci;
        fibonacci = ;
        
        // TODO: 조건에 따른 배열 생성 (삼항 연산자 사용)
        boolean useSmallSet = true;
        int[] dataset = useSmallSet ? 
            : 
            ;
        
        // 5. 메서드 호출 시 직접 생성
        printArray("소수", primes);
        printArray("짝수", new int[] {2, 4, 6, 8, 10});
        
        // TODO: 다차원 배열 리터럴을 생성하세요 (3x3 행렬)
        int[][] matrix = {
            
        };
        
        System.out.println("\n3x3 행렬:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    private static void printArray(String label, int[] arr) {
        System.out.print(label + ": ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
```

**실행 결과:**
```
소수: 2 3 5 7 11 13 17 19 
짝수: 2 4 6 8 10 
피보나치: 1 1 2 3 5 8 13 21 
작은 세트: 1 2 3 

3x3 행렬:
1 2 3 
4 5 6 
7 8 9 
```

### 예제 3-2: 메서드에서 배열 리터럴 활용

```java
public class ArrayLiteralMethods {
    // TODO: 요일 이름 반환 메서드를 작성하세요
    // 메서드명: getDayName, 매개변수: int dayNumber
    // 배열 리터럴을 사용하여 요일 배열 생성 (일,월,화,수,목,금,토)
    // 유효한 번호면 "요일명요일" 반환, 아니면 "잘못된 요일" 반환
    
    
    // TODO: 월별 일수 반환 메서드를 작성하세요
    // 메서드명: getDaysInMonth, 매개변수: int month, boolean isLeapYear
    // 배열 리터럴로 각 월의 일수 정의
    // 2월이고 윤년이면 29일 반환
    
    
    // TODO: 점수에 따른 등급 반환 메서드를 작성하세요
    // 메서드명: getGrade, 매개변수: int score
    // 경계값 배열과 등급 배열을 사용하여 등급 결정
    
    
    // TODO: 메뉴 출력 메서드를 작성하세요
    // 메서드명: showMenu
    // 배열 리터럴을 직접 전달하여 printMenu 호출
    
    
    private static void printMenu(String title, String[] items) {
        System.out.println("=== " + title + " ===");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("================");
    }
    
    public static void main(String[] args) {
        // getDayName 테스트
        System.out.println("오늘은 " + getDayName(3));  // 수요일
        
        // getDaysInMonth 테스트
        System.out.println("\n2024년 2월: " + 
                         getDaysInMonth(2, true) + "일");  // 29일
        
        // getGrade 테스트
        int[] scores = {95, 82, 73, 65, 58};
        System.out.println("\n성적 평가:");
        for (int score : scores) {
            System.out.println(score + "점: " + getGrade(score) + "등급");
        }
        
        // showMenu 테스트
        System.out.println();
        showMenu();
    }
}
```

**실행 결과:**
```
오늘은 수요일
2024년 2월: 29일

성적 평가:
95점: A등급
82점: B등급
73점: C등급
65점: D등급
58점: F등급

=== 메인 메뉴 ===
1. 파일
2. 편집
3. 보기
4. 도움말
0. 종료
================
```

### 예제 3-3: 배열 반환 메서드

```java
public class ArrayReturningMethods {
    // TODO: 범위 내의 정수 배열 생성 메서드를 작성하세요
    // 메서드명: range, 매개변수: int start, int end
    // start부터 end까지의 숫자 배열 반환, start > end면 빈 배열
    
    
    // TODO: 배열 필터링 메서드를 작성하세요
    // 메서드명: filterPositive, 매개변수: int[] input
    // 양수만 포함하는 새 배열 반환
    
    
    // TODO: 두 배열 병합 메서드를 작성하세요
    // 메서드명: merge, 매개변수: int[] arr1, int[] arr2
    // 두 배열을 연결한 새 배열 반환
    
    
    // TODO: 배열 뒤집기 메서드를 작성하세요
    // 메서드명: reverse, 매개변수: int[] input
    // 역순으로 된 새 배열 반환
    
    
    public static void main(String[] args) {
        // range 테스트
        int[] numbers = range(5, 10);
        System.out.print("range(5, 10): ");
        printArray(numbers);
        
        // filterPositive 테스트
        int[] mixed = {-3, 5, 0, -7, 12, -1, 8};
        int[] positive = filterPositive(mixed);
        System.out.print("\n양수만: ");
        printArray(positive);
        
        // merge 테스트
        int[] first = {1, 3, 5};
        int[] second = {2, 4, 6};
        int[] merged = merge(first, second);
        System.out.print("\n병합: ");
        printArray(merged);
        
        // reverse 테스트
        int[] original = {1, 2, 3, 4, 5};
        int[] reversed = reverse(original);
        System.out.print("\n뒤집기: ");
        printArray(reversed);
    }
    
    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
```

**실행 결과:**
```
range(5, 10): 5 6 7 8 9 10 

양수만: 5 12 8 

병합: 1 3 5 2 4 6 

뒤집기: 5 4 3 2 1 
```

## 4. 종합 예제

### 예제 4-1: 학생 성적 관리 시스템

```java
public class StudentGradeSystem {
    // TODO: 가변 인수를 사용한 성적 입력 메서드를 작성하세요
    // 메서드명: inputGrades
    // 매개변수: String studentName, double... scores
    // 학생 이름과 각 과목 점수를 출력하고 배열 반환
    
    
    // TODO: 성적 통계 계산 메서드를 작성하세요
    // 메서드명: calculateStats
    // 매개변수: String name, double[] grades
    // for-each 루프로 평균, 최고점, 최저점 계산 및 출력
    
    
    // TODO: 평균 점수로 등급 계산하는 private 메서드를 작성하세요
    // 메서드명: getLetterGrade, 매개변수: double average
    // 90이상:A, 80이상:B, 70이상:C, 60이상:D, 그외:F
    
    
    // TODO: 우수 학생 선발 메서드를 작성하세요
    // 메서드명: selectHonorStudents
    // 매개변수: String[] names, double[] averages
    // 평균 85점 이상인 학생들을 출력
    
    
    public static void main(String[] args) {
        // 학생 데이터
        String[] students = {"김철수", "이영희", "박민수"};
        
        // 각 학생의 성적 입력 (가변 인수 사용)
        double[] kimScores = inputGrades("김철수", 85.5, 92.0, 78.5, 88.0, 91.5);
        double[] leeScores = inputGrades("이영희", 95.0, 88.5, 92.0, 87.5, 89.0);
        double[] parkScores = inputGrades("박민수", 78.0, 82.5, 75.0, 80.0, 77.5);
        
        // 통계 계산
        calculateStats("김철수", kimScores);
        calculateStats("이영희", leeScores);
        calculateStats("박민수", parkScores);
        
        // 평균 점수 배열 생성
        double[] averages = new double[] {
            average(kimScores),
            average(leeScores),
            average(parkScores)
        };
        
        // 우수 학생 선발
        selectHonorStudents(students, averages);
    }
    
    // TODO: 평균 계산 헬퍼 메서드를 작성하세요
    // 메서드명: average, 매개변수: double[] scores
    // for-each 루프로 평균 계산하여 반환
    
}
```

**실행 결과:**
```

김철수 학생의 성적:
과목 1: 85.5점
과목 2: 92.0점
과목 3: 78.5점
과목 4: 88.0점
과목 5: 91.5점

이영희 학생의 성적:
과목 1: 95.0점
과목 2: 88.5점
과목 3: 92.0점
과목 4: 87.5점
과목 5: 89.0점

박민수 학생의 성적:
과목 1: 78.0점
과목 2: 82.5점
과목 3: 75.0점
과목 4: 80.0점
과목 5: 77.5점

=== 김철수 성적 분석 ===
평균: 87.10점
최고점: 92.0점
최저점: 78.5점
등급: B

=== 이영희 성적 분석 ===
평균: 90.40점
최고점: 95.0점
최저점: 87.5점
등급: A

=== 박민수 성적 분석 ===
평균: 78.60점
최고점: 82.5점
최저점: 75.0점
등급: C

=== 우수 학생 명단 (평균 85점 이상) ===
김철수: 87.10점
이영희: 90.40점
```

이 예제들은 for-each 루프, 가변 인수 메서드, 배열 리터럴의 다양한 활용 방법을 연습할 수 있도록 구성되었습니다. 각 TODO 주석을 참고하여 코드를 완성해보세요!