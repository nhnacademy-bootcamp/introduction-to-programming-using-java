# 3.8 배열 소개 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 배열의 개념과 필요성을 이해한다
- 배열을 선언하고 생성할 수 있다
- for 루프를 사용하여 배열을 처리할 수 있다
- 배열의 임의 접근과 순차 접근을 구분한다
- 부분적으로 채워진 배열을 관리할 수 있다
- 2차원 배열의 기본 개념을 이해한다

## 1. 배열의 기본 개념

### 1.1 데이터 구조와 배열
**데이터 구조(Data Structure)**는 여러 데이터를 함께 묶어 하나의 단위로 취급할 수 있도록 하는 구조입니다.

**배열(Array)**은 데이터가 번호가 매겨진 순서대로 배열된 구조로, 각 항목을 위치 번호로 참조할 수 있습니다.

### 1.2 배열의 핵심 용어
```java
String[] nameList = new String[5];  // 배열 선언과 생성
// nameList[0], nameList[1], nameList[2], nameList[3], nameList[4]
```

**주요 용어:**
- **길이(Length)**: 배열의 항목 수 (`nameList.length = 5`)
- **기본 타입(Base Type)**: 배열 항목의 유형 (`String`)
- **인덱스(Index)**: 항목의 위치 번호 (0, 1, 2, 3, 4)
- **요소(Element)**: 배열의 각 항목 (`nameList[0]`, `nameList[1]` 등)

### 1.3 배열의 특징
```java
// ✅ 배열의 장점
int[] scores = new int[1000];  // 1000개의 점수를 하나의 변수로 관리
System.out.println(scores.length);  // 배열 크기를 언제든 확인 가능

// ❌ 배열 없이 1000개의 변수 관리
int score1, score2, score3, ..., score1000;  // 너무 복잡!
```

**배열의 특징:**
- 모든 요소는 **동일한 타입**이어야 함
- 인덱스는 **0부터 시작**
- 배열 크기는 **생성 후 변경 불가능**
- 메모리에서 **연속적으로 저장**

## 2. 배열 생성과 사용

### 2.1 배열 선언
```java
// 배열 변수 선언 방법
int[] numbers;        // 권장 방식
String[] names;
double[] prices;
boolean[] flags;

// 또 다른 방식 (권장하지 않음)
int numbers[];
String names[];
```

### 2.2 배열 생성
```java
// new 연산자를 사용한 배열 생성
numbers = new int[5];        // 5개의 int를 저장할 배열
names = new String[100];     // 100개의 String을 저장할 배열
prices = new double[50];     // 50개의 double을 저장할 배열

// 선언과 생성을 동시에
int[] scores = new int[10];
String[] studentNames = new String[30];
```

### 2.3 배열의 초기화
```java
// 배열 생성 시 자동 초기화
int[] numbers = new int[5];     // 모든 요소가 0으로 초기화
boolean[] flags = new boolean[3]; // 모든 요소가 false로 초기화
String[] names = new String[4];  // 모든 요소가 null로 초기화

System.out.println("numbers[0] = " + numbers[0]);  // 출력: 0
System.out.println("flags[0] = " + flags[0]);      // 출력: false
System.out.println("names[0] = " + names[0]);      // 출력: null
```

**타입별 기본값:**
- `int`, `double`, `float`, `long`: `0`
- `boolean`: `false`  
- `char`: `'\u0000'` (유니코드 0)
- `String` 및 객체: `null`

### 2.4 배열 요소 접근
```java
int[] scores = new int[5];

// 배열 요소에 값 할당
scores[0] = 85;
scores[1] = 92;
scores[2] = 78;
scores[3] = 96;
scores[4] = 89;

// 배열 요소 값 읽기
System.out.println("첫 번째 점수: " + scores[0]);
System.out.println("마지막 점수: " + scores[4]);

// 배열 길이 확인
System.out.println("배열 크기: " + scores.length);

// 배열 요소를 다른 변수에서 사용
int totalScore = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];
int averageScore = totalScore / scores.length;
```

## 3. 배열과 반복문

### 3.1 for 루프를 이용한 배열 처리
```java
public class ArrayProcessingExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        // 1. 배열의 모든 요소 출력
        System.out.println("=== 배열 요소 출력 ===");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        // 2. 배열 요소의 합계 계산
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("합계: " + sum);
        
        // 3. 배열 요소의 평균 계산
        double average = (double) sum / numbers.length;
        System.out.println("평균: " + average);
    }
}
```

### 3.2 배열에서 최대값/최소값 찾기
```java
public class FindMaxMinExample {
    public static void main(String[] args) {
        double[] values = {3.5, 1.8, 9.2, 2.1, 7.4, 5.6};
        
        // 최대값 찾기
        double max = values[0];  // 첫 번째 요소를 초기값으로 설정
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        System.out.println("최대값: " + max);
        
        // 최소값 찾기
        double min = values[0];  // 첫 번째 요소를 초기값으로 설정
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        System.out.println("최소값: " + min);
        
        // 최대값과 최소값의 위치(인덱스) 찾기
        int maxIndex = 0;
        int minIndex = 0;
        
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
            if (values[i] < values[minIndex]) {
                minIndex = i;
            }
        }
        
        System.out.println("최대값 위치: " + maxIndex);
        System.out.println("최소값 위치: " + minIndex);
    }
}
```

### 3.3 조건부 배열 처리
```java
public class ConditionalArrayProcessing {
    public static void main(String[] args) {
        int[] numbers = {12, -5, 8, 0, -3, 15, 22, -1, 9};
        
        // 양수만 처리하기
        System.out.println("=== 양수만 처리 ===");
        int positiveSum = 0;
        int positiveCount = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {  // 양수만 선택
                System.out.println("양수: " + numbers[i]);
                positiveSum += numbers[i];
                positiveCount++;
            }
        }
        
        if (positiveCount > 0) {
            double positiveAverage = (double) positiveSum / positiveCount;
            System.out.println("양수 개수: " + positiveCount);
            System.out.println("양수 합계: " + positiveSum);
            System.out.printf("양수 평균: %.2f%n", positiveAverage);
        }
        
        // 짝수와 홀수 분류
        System.out.println("\n=== 짝수와 홀수 분류 ===");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.println(numbers[i] + "는 짝수");
            } else {
                System.out.println(numbers[i] + "는 홀수");
            }
        }
    }
}
```

## 4. 배열의 접근 방식

### 4.1 순차 접근 vs 임의 접근

**순차 접근(Sequential Access):**
```java
// 배열 요소를 순서대로 처리
int[] data = {10, 20, 30, 40, 50};

for (int i = 0; i < data.length; i++) {
    System.out.println("순서대로: " + data[i]);
}
```

**임의 접근(Random Access):**
```java
// 배열 요소를 무작위 순서로 접근
int[] data = {10, 20, 30, 40, 50};

// 특정 위치에 바로 접근
System.out.println("마지막 요소: " + data[4]);
System.out.println("중간 요소: " + data[2]);
System.out.println("첫 번째 요소: " + data[0]);

// 무작위 인덱스로 접근
int randomIndex = (int)(Math.random() * data.length);
System.out.println("무작위 요소: " + data[randomIndex]);
```

### 4.2 생일 문제 시뮬레이션
```java
public class BirthdayProblemSimulation {
    public static void main(String[] args) {
        System.out.println("=== 생일 문제 시뮬레이션 ===");
        
        // 여러 번 실험하여 평균값 구하기
        int experiments = 1000;
        int totalPeople = 0;
        
        for (int experiment = 1; experiment <= experiments; experiment++) {
            int peopleNeeded = runSingleExperiment();
            totalPeople += peopleNeeded;
            
            if (experiment % 100 == 0) {
                System.out.printf("실험 %d회 완료%n", experiment);
            }
        }
        
        double average = (double) totalPeople / experiments;
        System.out.printf("%n%d회 실험 결과:%n", experiments);
        System.out.printf("평균적으로 %.1f명을 확인하면 중복 생일을 발견합니다.%n", average);
    }
    
    public static int runSingleExperiment() {
        boolean[] used = new boolean[365];  // 사용된 생일 추적
        int count = 0;
        
        while (true) {
            // 0~364 범위에서 무작위 생일 선택
            int birthday = (int)(Math.random() * 365);
            count++;
            
            // 이미 사용된 생일인지 확인
            if (used[birthday]) {
                // 중복 생일 발견!
                break;
            }
            
            // 생일을 사용된 것으로 표시
            used[birthday] = true;
        }
        
        return count;
    }
}
```

## 5. 부분적으로 채워진 배열

### 5.1 동적 크기 관리
```java
import textio.TextIO;

public class PartiallyFilledArrayExample {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        int[] numbers = new int[MAX_SIZE];  // 최대 100개 저장 가능
        int count = 0;  // 실제 저장된 개수
        
        System.out.println("양의 정수를 입력하세요 (0으로 종료):");
        
        // 데이터 입력
        while (true) {
            System.out.print("숫자 " + (count + 1) + ": ");
            int num = TextIO.getlnInt();
            
            if (num <= 0) {
                break;  // 입력 종료
            }
            
            if (count >= MAX_SIZE) {
                System.out.println("배열이 가득 찼습니다!");
                break;
            }
            
            numbers[count] = num;  // count 위치에 저장
            count++;               // 개수 증가
        }
        
        // 결과 출력
        System.out.println("\n입력된 숫자 (" + count + "개):");
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // 역순 출력
        System.out.println("\n역순으로 출력:");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // 통계 계산
        if (count > 0) {
            int sum = 0;
            int max = numbers[0];
            int min = numbers[0];
            
            for (int i = 0; i < count; i++) {
                sum += numbers[i];
                if (numbers[i] > max) max = numbers[i];
                if (numbers[i] < min) min = numbers[i];
            }
            
            double average = (double) sum / count;
            
            System.out.println("\n통계:");
            System.out.println("개수: " + count);
            System.out.println("합계: " + sum);
            System.out.printf("평균: %.2f%n", average);
            System.out.println("최대값: " + max);
            System.out.println("최소값: " + min);
        }
    }
}
```

### 5.2 배열 크기 관리의 중요성
```java
public class ArrayBoundsExample {
    public static void main(String[] args) {
        int[] array = new int[5];  // 인덱스 0~4만 유효
        
        // ✅ 올바른 접근
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 10;
            System.out.println("array[" + i + "] = " + array[i]);
        }
        
        // ❌ 잘못된 접근 - ArrayIndexOutOfBoundsException 발생!
        try {
            array[5] = 100;  // 인덱스 5는 존재하지 않음
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("오류: " + e.getMessage());
        }
        
        try {
            int value = array[-1];  // 음수 인덱스 사용 불가
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
```

## 6. 2차원 배열 기초

### 6.1 2차원 배열의 개념
```java
// 2차원 배열은 행(row)과 열(column)으로 구성
int[][] matrix = new int[3][4];  // 3행 4열 배열

/*
  열: 0  1  2  3
행 0: [ 0  0  0  0 ]
행 1: [ 0  0  0  0 ]  
행 2: [ 0  0  0  0 ]
*/

// 각 요소에 접근: matrix[행][열]
matrix[0][0] = 1;   // 첫 번째 행, 첫 번째 열
matrix[1][2] = 5;   // 두 번째 행, 세 번째 열
matrix[2][3] = 9;   // 세 번째 행, 네 번째 열
```

### 6.2 2차원 배열 생성과 초기화
```java
public class TwoDimensionalArrayExample {
    public static void main(String[] args) {
        // 1. 선언과 생성
        int[][] numbers = new int[3][4];  // 3행 4열
        
        // 2. 초기값으로 배열 생성
        int[][] initializedArray = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // 3. 값 할당
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = row * 4 + col + 1;
            }
        }
        
        // 4. 배열 출력
        System.out.println("=== numbers 배열 ===");
        printMatrix(numbers);
        
        System.out.println("\n=== initializedArray 배열 ===");
        printMatrix(initializedArray);
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();  // 행 끝에서 줄바꿈
        }
    }
}
```

### 6.3 실용적인 2차원 배열 예제
```java
public class Store2DArrayExample {
    public static void main(String[] args) {
        // 25개 매장의 12개월 수익 데이터
        final int NUM_STORES = 25;
        final int NUM_MONTHS = 12;
        
        double[][] profit = new double[NUM_STORES][NUM_MONTHS];
        
        // 1. 가상의 데이터로 배열 채우기
        for (int store = 0; store < NUM_STORES; store++) {
            for (int month = 0; month < NUM_MONTHS; month++) {
                // 100,000 ~ 500,000 범위의 무작위 수익
                profit[store][month] = 100000 + Math.random() * 400000;
            }
        }
        
        // 2. 전체 연간 총 수익 계산
        double totalProfit = 0;
        for (int store = 0; store < NUM_STORES; store++) {
            for (int month = 0; month < NUM_MONTHS; month++) {
                totalProfit += profit[store][month];
            }
        }
        
        // 3. 12월 총 수익 계산 (특정 열만 처리)
        double decemberProfit = 0;
        for (int store = 0; store < NUM_STORES; store++) {
            decemberProfit += profit[store][11];  // 12월은 인덱스 11
        }
        
        // 4. 각 매장의 연간 수익 계산 (특정 행만 처리)
        System.out.println("=== 매장별 연간 수익 ===");
        for (int store = 0; store < NUM_STORES; store++) {
            double storeAnnualProfit = 0;
            for (int month = 0; month < NUM_MONTHS; month++) {
                storeAnnualProfit += profit[store][month];
            }
            System.out.printf("매장 %2d: $%,.0f%n", store, storeAnnualProfit);
        }
        
        // 5. 월별 전체 수익 계산
        System.out.println("\n=== 월별 전체 수익 ===");
        String[] monthNames = {"1월", "2월", "3월", "4월", "5월", "6월",
                              "7월", "8월", "9월", "10월", "11월", "12월"};
        
        for (int month = 0; month < NUM_MONTHS; month++) {
            double monthlyTotalProfit = 0;
            for (int store = 0; store < NUM_STORES; store++) {
                monthlyTotalProfit += profit[store][month];
            }
            System.out.printf("%s: $%,.0f%n", monthNames[month], monthlyTotalProfit);
        }
        
        // 6. 결과 요약
        System.out.println("\n=== 요약 ===");
        System.out.printf("전체 연간 총 수익: $%,.0f%n", totalProfit);
        System.out.printf("12월 총 수익: $%,.0f%n", decemberProfit);
        System.out.printf("월평균 수익: $%,.0f%n", totalProfit / NUM_MONTHS);
        System.out.printf("매장평균 수익: $%,.0f%n", totalProfit / NUM_STORES);
    }
}
```

## 7. 배열 활용 패턴

### 7.1 배열 복사
```java
public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        
        // ❌ 잘못된 복사 - 참조만 복사됨
        int[] wrongCopy = original;
        wrongCopy[0] = 100;
        System.out.println("original[0] = " + original[0]);  // 100으로 변경됨!
        
        // ✅ 올바른 복사 방법 1: 수동 복사
        int[] correctCopy1 = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            correctCopy1[i] = original[i];
        }
        
        // ✅ 올바른 복사 방법 2: System.arraycopy 사용
        int[] correctCopy2 = new int[original.length];
        System.arraycopy(original, 0, correctCopy2, 0, original.length);
        
        // 복사본 수정이 원본에 영향을 주지 않는지 확인
        correctCopy1[0] = 200;
        correctCopy2[1] = 300;
        
        System.out.println("원본: " + java.util.Arrays.toString(original));
        System.out.println("복사본1: " + java.util.Arrays.toString(correctCopy1));
        System.out.println("복사본2: " + java.util.Arrays.toString(correctCopy2));
    }
}
```

### 7.2 배열 검색
```java
public class ArraySearchExample {
    public static void main(String[] args) {
        String[] names = {"김철수", "이영희", "박민수", "최자영", "정하늘"};
        
        // 선형 검색 (Linear Search)
        String target = "박민수";
        int foundIndex = linearSearch(names, target);
        
        if (foundIndex != -1) {
            System.out.println(target + "을(를) 인덱스 " + foundIndex + "에서 발견했습니다.");
        } else {
            System.out.println(target + "을(를) 찾을 수 없습니다.");
        }
        
        // 모든 요소 검색
        System.out.println("\n이름 목록:");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
    }
    
    public static int linearSearch(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;  // 발견한 인덱스 반환
            }
        }
        return -1;  // 찾지 못함
    }
}
```

### 7.3 배열 정렬 (간단한 버블 정렬)
```java
public class ArraySortExample {
    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("정렬 전:");
        printArray(numbers);
        
        bubbleSort(numbers);
        
        System.out.println("정렬 후:");
        printArray(numbers);
    }
    
    public static void bubbleSort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 두 요소 교환
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
```

## 요약

### 배열의 핵심 개념
- **배열**: 동일한 타입의 여러 데이터를 순서대로 저장하는 데이터 구조
- **인덱스**: 0부터 시작하는 배열 요소의 위치 번호
- **길이**: `array.length`로 접근 가능한 배열 크기

### 배열 사용 패턴
1. **선언**: `int[] array;`
2. **생성**: `array = new int[size];`
3. **초기화**: 자동으로 기본값으로 초기화
4. **접근**: `array[index]`로 읽기/쓰기

### 배열 처리 방법
- **순차 처리**: for 루프로 모든 요소를 순서대로 처리
- **임의 접근**: 필요한 인덱스에 직접 접근
- **조건부 처리**: 특정 조건을 만족하는 요소만 처리

### 주의사항
- **배열 크기**: 생성 후 변경 불가능
- **인덱스 범위**: 0 ≤ 인덱스 < 배열길이
- **예외 처리**: `ArrayIndexOutOfBoundsException` 주의

### 2차원 배열
- **구조**: 행과 열로 구성된 격자 형태
- **선언**: `int[][] matrix = new int[행수][열수];`
- **접근**: `matrix[행][열]`
- **처리**: 중첩 for 루프 사용

💡 **기억하세요**: 배열은 여러 데이터를 효율적으로 관리할 수 있는 강력한 도구입니다. 적절한 인덱스 관리와 반복문 활용이 핵심입니다!