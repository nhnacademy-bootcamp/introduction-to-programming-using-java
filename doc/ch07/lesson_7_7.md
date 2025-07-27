# 7.7 프로그래밍 연습 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 배열과 ArrayList를 활용한 복합적인 프로그램을 설계한다
- 정렬과 검색 알고리즘을 실제 문제에 적용한다
- 이차원 배열을 사용한 게임과 시뮬레이션을 구현한다
- 파일 입출력과 데이터 처리를 결합한 프로그램을 작성한다
- 사용자 인터페이스와 데이터 구조를 통합한 완전한 애플리케이션을 개발한다

## 연습 문제들의 개요

7장에서 학습한 배열, ArrayList, 정렬, 검색 등의 개념들을 종합적으로 활용하는 7개의 연습 문제를 다룹니다. 각 문제는 실제 프로그래밍에서 자주 마주치는 상황들을 기반으로 구성되어 있습니다.

### 문제 유형별 분류

**기초 데이터 구조 활용**
- 연습 7.1: ArrayList를 활용한 중복 없는 랜덤 수 생성
- 연습 7.5: 배열을 사용한 직접 정렬 구현

**알고리즘 성능 분석**
- 연습 7.3: 정렬 알고리즘 성능 비교 및 측정

**이차원 배열 응용**
- 연습 7.2: 행렬 전치 연산 구현
- 연습 7.7: 오목 게임 구현

**파일 처리와 데이터 분석**
- 연습 7.6: 텍스트 파일의 단어 추출 및 정렬

**GUI와 데이터 구조 통합**
- 연습 7.4: 드래그 가능한 다중 사각형 시스템

---

## 연습 문제 7.1: 중복 없는 랜덤 수 생성기

### 문제 분석
지정된 범위에서 중복되지 않는 랜덤 정수들을 ArrayList에 저장하는 서브루틴을 구현하는 문제입니다.

### 핵심 개념
- **ArrayList 활용**: 동적 크기 조정이 가능한 리스트
- **중복 제거 알고리즘**: contains() 메서드 활용
- **랜덤 수 생성**: Math.random() 또는 Random 클래스 사용

### 구현 전략

```java
import java.util.ArrayList;

public class UniqueRandomGenerator {
    /**
     * 지정된 개수만큼 중복 없는 랜덤 정수를 생성
     * @param count 생성할 정수의 개수
     * @param maxValue 허용되는 최대값 (1부터 maxValue까지)
     * @return 중복 없는 랜덤 정수들의 ArrayList
     */
    public static ArrayList<Integer> generateUniqueRandoms(int count, int maxValue) {
        if (count > maxValue) {
            throw new IllegalArgumentException("요청한 개수가 가능한 범위를 초과합니다.");
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (result.size() < count) {
            int randomNum = (int)(Math.random() * maxValue) + 1;
            
            // 중복 확인 후 추가
            if (!result.contains(randomNum)) {
                result.add(randomNum);
            }
        }
        
        return result;
    }
}
```

### 성능 최적화 방안

**문제점**: contains() 메서드를 사용한 중복 확인은 O(n) 시간 복잡도를 가집니다.

**개선 방법 1 - HashSet 활용**:
```java
import java.util.*;

public static ArrayList<Integer> generateUniqueRandomsOptimized(int count, int maxValue) {
    Set<Integer> uniqueSet = new HashSet<>();
    
    while (uniqueSet.size() < count) {
        int randomNum = (int)(Math.random() * maxValue) + 1;
        uniqueSet.add(randomNum);  // Set은 자동으로 중복 제거
    }
    
    return new ArrayList<>(uniqueSet);
}
```

**개선 방법 2 - Fisher-Yates 셔플**:
```java
public static ArrayList<Integer> generateUniqueRandomsShuffle(int count, int maxValue) {
    // 1부터 maxValue까지의 모든 수를 배열에 저장
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= maxValue; i++) {
        numbers.add(i);
    }
    
    // 처음 count개만 셔플
    Random random = new Random();
    for (int i = 0; i < count; i++) {
        int randomIndex = i + random.nextInt(maxValue - i);
        Collections.swap(numbers, i, randomIndex);
    }
    
    // 처음 count개만 반환
    return new ArrayList<>(numbers.subList(0, count));
}
```

### 테스트 코드
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("생성할 랜덤 수의 개수: ");
    int count = scanner.nextInt();
    
    System.out.print("최대값 (1부터 이 값까지): ");
    int maxValue = scanner.nextInt();
    
    try {
        ArrayList<Integer> randomNumbers = generateUniqueRandoms(count, maxValue);
        
        System.out.println("\n생성된 중복 없는 랜덤 수들:");
        System.out.println(randomNumbers);
        
        // 성능 비교 테스트
        long startTime = System.nanoTime();
        generateUniqueRandoms(count, maxValue);
        long basicTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        generateUniqueRandomsOptimized(count, maxValue);
        long optimizedTime = System.nanoTime() - startTime;
        
        System.out.println("\n성능 비교:");
        System.out.println("기본 방법: " + basicTime + " ns");
        System.out.println("최적화 방법: " + optimizedTime + " ns");
        
    } catch (IllegalArgumentException e) {
        System.out.println("오류: " + e.getMessage());
    }
}
```

---

## 연습 문제 7.2: 행렬 전치 연산

### 문제 분석
2차원 배열(행렬)을 입력받아 전치행렬을 반환하는 함수를 구현하는 문제입니다.

### 핵심 개념
- **행렬 전치**: T[i][j] = M[j][i]
- **2차원 배열 조작**: 행과 열의 크기 처리
- **메모리 효율성**: 새로운 배열 생성 vs 제자리 연산

### 구현 전략

```java
public class MatrixTranspose {
    
    /**
     * 주어진 행렬의 전치행렬을 반환
     * @param matrix 원본 행렬
     * @return 전치행렬
     */
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // 전치행렬 생성 (행과 열이 바뀜)
        int[][] transposed = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
    
    /**
     * 정사각 행렬을 제자리에서 전치 (메모리 효율적)
     * @param matrix 정사각 행렬
     */
    public static void transposeInPlace(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("정사각 행렬이 아닙니다.");
        }
        
        int n = matrix.length;
        
        // 대각선 기준으로 상삼각 부분만 처리
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 대칭 위치의 원소들을 교환
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    /**
     * 행렬을 보기 좋게 출력
     * @param matrix 출력할 행렬
     * @param title 행렬 제목
     */
    public static void printMatrix(int[][] matrix, String title) {
        System.out.println("\n" + title + ":");
        
        if (matrix.length == 0) {
            System.out.println("빈 행렬");
            return;
        }
        
        // 각 열의 최대 너비 계산
        int[] columnWidths = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int width = String.valueOf(matrix[i][j]).length();
                if (width > columnWidths[j]) {
                    columnWidths[j] = width;
                }
            }
        }
        
        // 정렬된 형태로 출력
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%" + columnWidths[j] + "d", matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }
}
```

### 고급 기능 구현

**블록 전치 (Block Transpose)**: 큰 행렬의 성능 최적화
```java
public static int[][] transposeBlocked(int[][] matrix, int blockSize) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] transposed = new int[cols][rows];
    
    // 블록 단위로 처리하여 캐시 효율성 향상
    for (int i = 0; i < rows; i += blockSize) {
        for (int j = 0; j < cols; j += blockSize) {
            // 각 블록 내에서 전치
            for (int bi = i; bi < Math.min(i + blockSize, rows); bi++) {
                for (int bj = j; bj < Math.min(j + blockSize, cols); bj++) {
                    transposed[bj][bi] = matrix[bi][bj];
                }
            }
        }
    }
    
    return transposed;
}
```

### 테스트 및 성능 분석
```java
public static void main(String[] args) {
    // 테스트 케이스 1: 일반적인 직사각 행렬
    int[][] matrix1 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    
    printMatrix(matrix1, "원본 행렬");
    int[][] transposed1 = transpose(matrix1);
    printMatrix(transposed1, "전치 행렬");
    
    // 테스트 케이스 2: 정사각 행렬 제자리 전치
    int[][] matrix2 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    printMatrix(matrix2, "제자리 전치 전");
    transposeInPlace(matrix2);
    printMatrix(matrix2, "제자리 전치 후");
    
    // 성능 테스트
    performanceTest();
}

private static void performanceTest() {
    System.out.println("\n=== 성능 테스트 ===");
    
    int size = 1000;
    int[][] largeMatrix = new int[size][size];
    
    // 테스트 데이터 생성
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            largeMatrix[i][j] = i * size + j;
        }
    }
    
    // 일반 전치 성능 측정
    long startTime = System.nanoTime();
    transpose(largeMatrix);
    long normalTime = System.nanoTime() - startTime;
    
    // 블록 전치 성능 측정
    startTime = System.nanoTime();
    transposeBlocked(largeMatrix, 64);
    long blockedTime = System.nanoTime() - startTime;
    
    System.out.printf("일반 전치: %.2f ms\n", normalTime / 1_000_000.0);
    System.out.printf("블록 전치: %.2f ms\n", blockedTime / 1_000_000.0);
    System.out.printf("성능 개선: %.2f%%\n", 
        ((double)(normalTime - blockedTime) / normalTime) * 100);
}
```

---

## 연습 문제 7.3: 정렬 알고리즘 성능 비교

### 문제 분석
Arrays.sort()와 선택 정렬의 성능을 실제로 측정하여 비교하는 프로그램을 작성하는 문제입니다.

### 핵심 개념
- **시간 측정**: System.nanoTime() 활용
- **알고리즘 복잡도**: O(n log n) vs O(n²)
- **통계 분석**: 평균, 표준편차 계산
- **JVM 최적화**: 워밍업과 가비지 컬렉션 고려

### 구현 전략

```java
import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {
    
    /**
     * 선택 정렬 구현
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // 최솟값 찾기
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            // 교환
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    
    /**
     * 문자열 배열용 선택 정렬
     */
    public static void selectionSort(String[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                String temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    
    /**
     * 랜덤 정수 배열 생성
     */
    public static int[] generateRandomIntArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue);
        }
        
        return array;
    }
    
    /**
     * 랜덤 문자열 배열 생성
     */
    public static String[] generateRandomStringArray(int size, int maxLength) {
        Random random = new Random();
        String[] array = new String[size];
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < size; i++) {
            int length = random.nextInt(maxLength) + 1;
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < length; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            
            array[i] = sb.toString();
        }
        
        return array;
    }
}
```

### 정확한 성능 측정 구현

```java
public class AccuratePerformanceTester {
    
    /**
     * 정수 배열 정렬 성능 측정
     */
    public static void measureIntSortingPerformance(int arraySize, int iterations) {
        System.out.println("\n=== 정수 배열 정렬 성능 측정 ===");
        System.out.printf("배열 크기: %,d, 반복 횟수: %d\n", arraySize, iterations);
        
        long[] selectionTimes = new long[iterations];
        long[] arraysSortTimes = new long[iterations];
        
        // JVM 워밍업
        warmUp(arraySize);
        
        for (int i = 0; i < iterations; i++) {
            // 동일한 데이터로 테스트
            int[] originalArray = generateRandomIntArray(arraySize, 1000000);
            
            // 선택 정렬 측정
            int[] array1 = originalArray.clone();
            System.gc(); // 가비지 컬렉션 수행
            
            long startTime = System.nanoTime();
            selectionSort(array1);
            long endTime = System.nanoTime();
            selectionTimes[i] = endTime - startTime;
            
            // Arrays.sort() 측정
            int[] array2 = originalArray.clone();
            System.gc();
            
            startTime = System.nanoTime();
            Arrays.sort(array2);
            endTime = System.nanoTime();
            arraysSortTimes[i] = endTime - startTime;
            
            // 정렬 결과 검증
            if (!Arrays.equals(array1, array2)) {
                System.err.println("정렬 결과가 다릅니다!");
            }
        }
        
        // 통계 계산 및 출력
        printStatistics("선택 정렬", selectionTimes);
        printStatistics("Arrays.sort()", arraysSortTimes);
        
        double avgSelection = calculateAverage(selectionTimes);
        double avgArraysSort = calculateAverage(arraysSortTimes);
        double speedup = avgSelection / avgArraysSort;
        
        System.out.printf("\nArrays.sort()가 선택 정렬보다 %.2f배 빠릅니다.\n", speedup);
    }
    
    /**
     * 문자열 배열 정렬 성능 측정
     */
    public static void measureStringSortingPerformance(int arraySize, int iterations) {
        System.out.println("\n=== 문자열 배열 정렬 성능 측정 ===");
        System.out.printf("배열 크기: %,d, 반복 횟수: %d\n", arraySize, iterations);
        
        long[] selectionTimes = new long[iterations];
        long[] arraysSortTimes = new long[iterations];
        
        for (int i = 0; i < iterations; i++) {
            String[] originalArray = generateRandomStringArray(arraySize, 10);
            
            // 선택 정렬 측정
            String[] array1 = originalArray.clone();
            System.gc();
            
            long startTime = System.nanoTime();
            selectionSort(array1);
            long endTime = System.nanoTime();
            selectionTimes[i] = endTime - startTime;
            
            // Arrays.sort() 측정
            String[] array2 = originalArray.clone();
            System.gc();
            
            startTime = System.nanoTime();
            Arrays.sort(array2);
            endTime = System.nanoTime();
            arraysSortTimes[i] = endTime - startTime;
        }
        
        printStatistics("선택 정렬 (문자열)", selectionTimes);
        printStatistics("Arrays.sort() (문자열)", arraysSortTimes);
        
        double speedup = calculateAverage(selectionTimes) / calculateAverage(arraysSortTimes);
        System.out.printf("\nArrays.sort()가 선택 정렬보다 %.2f배 빠릅니다.\n", speedup);
    }
    
    /**
     * JVM 워밍업
     */
    private static void warmUp(int size) {
        System.out.print("JVM 워밍업 중...");
        
        for (int i = 0; i < 10; i++) {
            int[] array1 = generateRandomIntArray(size / 10, 1000);
            int[] array2 = array1.clone();
            
            selectionSort(array1);
            Arrays.sort(array2);
        }
        
        System.out.println(" 완료");
    }
    
    /**
     * 통계 정보 출력
     */
    private static void printStatistics(String algorithmName, long[] times) {
        double avg = calculateAverage(times);
        double stdDev = calculateStandardDeviation(times, avg);
        long min = Arrays.stream(times).min().orElse(0);
        long max = Arrays.stream(times).max().orElse(0);
        
        System.out.printf("\n%s 통계:\n", algorithmName);
        System.out.printf("  평균: %.2f ms\n", avg / 1_000_000.0);
        System.out.printf("  표준편차: %.2f ms\n", stdDev / 1_000_000.0);
        System.out.printf("  최소: %.2f ms\n", min / 1_000_000.0);
        System.out.printf("  최대: %.2f ms\n", max / 1_000_000.0);
    }
    
    private static double calculateAverage(long[] values) {
        return Arrays.stream(values).average().orElse(0.0);
    }
    
    private static double calculateStandardDeviation(long[] values, double mean) {
        double sum = 0.0;
        for (long value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / values.length);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 정렬 알고리즘 성능 비교 프로그램 ===");
        
        // 다양한 크기에서 성능 측정
        int[] sizes = {1000, 5000, 10000, 20000};
        int iterations = 5;
        
        for (int size : sizes) {
            measureIntSortingPerformance(size, iterations);
            measureStringSortingPerformance(size, iterations);
            System.out.println("\n" + "=".repeat(50));
        }
        
        // 복잡도 분석
        analyzeComplexity();
    }
    
    /**
     * 시간 복잡도 분석
     */
    private static void analyzeComplexity() {
        System.out.println("\n=== 시간 복잡도 분석 ===");
        
        int[] sizes = {500, 1000, 2000, 4000, 8000};
        
        System.out.println("배열 크기\t선택 정렬 (ms)\tArrays.sort() (ms)\t비율");
        System.out.println("-".repeat(60));
        
        for (int size : sizes) {
            int[] array1 = generateRandomIntArray(size, 100000);
            int[] array2 = array1.clone();
            
            long startTime = System.nanoTime();
            selectionSort(array1);
            long selectionTime = System.nanoTime() - startTime;
            
            startTime = System.nanoTime();
            Arrays.sort(array2);
            long arraysTime = System.nanoTime() - startTime;
            
            double ratio = (double) selectionTime / arraysTime;
            
            System.out.printf("%,7d\t%12.2f\t%13.2f\t%8.2f\n", 
                size, 
                selectionTime / 1_000_000.0,
                arraysTime / 1_000_000.0,
                ratio);
        }
        
        System.out.println("\n분석 결과:");
        System.out.println("- 선택 정렬: O(n²) 시간 복잡도");
        System.out.println("- Arrays.sort(): O(n log n) 시간 복잡도 (TimSort 알고리즘)");
        System.out.println("- 배열 크기가 커질수록 성능 차이가 급격히 증가");
    }
}
```

---

## 연습 문제 7.4: 드래그 가능한 다중 사각형 시스템

### 문제 분석
사용자가 여러 개의 사각형을 생성하고 드래그할 수 있는 GUI 프로그램을 구현하는 문제입니다.

### 핵심 개념
- **GUI 프로그래밍**: Canvas, 마우스 이벤트 처리
- **객체 지향 설계**: 사각형 데이터를 위한 클래스 설계
- **ArrayList 활용**: 동적으로 변하는 사각형 목록 관리
- **이벤트 처리**: 마우스 클릭, 드래그 구분

### 사각형 데이터 클래스 설계

```java
import java.awt.Color;

/**
 * 드래그 가능한 사각형의 데이터를 저장하는 클래스
 */
class DraggableRectangle {
    private double centerX, centerY;  // 중심 좌표
    private double width, height;     // 크기
    private Color color;              // 색상
    private Color borderColor;        // 테두리 색상
    
    public DraggableRectangle(double centerX, double centerY, 
                            double width, double height, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.color = color;
        this.borderColor = Color.BLACK;
    }
    
    // Getter 메서드들
    public double getCenterX() { return centerX; }
    public double getCenterY() { return centerY; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public Color getColor() { return color; }
    public Color getBorderColor() { return borderColor; }
    
    // Setter 메서드들
    public void setCenterX(double centerX) { this.centerX = centerX; }
    public void setCenterY(double centerY) { this.centerY = centerY; }
    public void setColor(Color color) { this.color = color; }
    public void setBorderColor(Color borderColor) { this.borderColor = borderColor; }
    
    /**
     * 사각형의 경계를 계산
     */
    public double getLeft() { return centerX - width/2; }
    public double getRight() { return centerX + width/2; }
    public double getTop() { return centerY - height/2; }
    public double getBottom() { return centerY + height/2; }
    
    /**
     * 주어진 점이 이 사각형 안에 있는지 확인
     */
    public boolean contains(double x, double y) {
        return x >= getLeft() && x <= getRight() && 
               y >= getTop() && y <= getBottom();
    }
    
    /**
     * 사각형이 캔버스 영역을 벗어났는지 확인
     */
    public boolean isOutsideCanvas(double canvasWidth, double canvasHeight) {
        return getRight() < 0 || getLeft() > canvasWidth || 
               getBottom() < 0 || getTop() > canvasHeight;
    }
    
    /**
     * 사각형을 이동
     */
    public void move(double deltaX, double deltaY) {
        centerX += deltaX;
        centerY += deltaY;
    }
}
```

### 메인 GUI 구현

```java
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class MultiRectangleDrag extends JFrame {
    
    private Canvas canvas;
    
    public MultiRectangleDrag() {
        setTitle("드래그 가능한 다중 사각형");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);
        
        // 사용법 안내
        JLabel instructions = new JLabel(
            "<html><center>" +
            "일반 클릭: 새 사각형 추가<br>" +
            "Shift+클릭 또는 우클릭: 사각형 드래그<br>" +
            "사각형을 캔버스 밖으로 드래그하면 삭제됩니다" +
            "</center></html>"
        );
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(instructions, BorderLayout.SOUTH);
    }
    
    /**
     * 캔버스 내부 클래스
     */
    private class Canvas extends JPanel implements MouseListener, MouseMotionListener {
        
        private ArrayList<DraggableRectangle> rectangles;
        private DraggableRectangle draggedRect;
        private double lastMouseX, lastMouseY;
        private Random random;
        
        public Canvas() {
            rectangles = new ArrayList<>();
            random = new Random();
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.WHITE);
            
            // 초기 사각형 몇 개 추가
            addRandomRectangle(200, 150);
            addRandomRectangle(400, 300);
            addRandomRectangle(600, 200);
        }
        
        /**
         * 랜덤 색상 생성
         */
        private Color generateRandomColor() {
            float hue = random.nextFloat();
            float saturation = 0.7f + random.nextFloat() * 0.3f;  // 0.7-1.0
            float brightness = 0.6f + random.nextFloat() * 0.4f;  // 0.6-1.0
            return Color.getHSBColor(hue, saturation, brightness);
        }
        
        /**
         * 지정된 위치에 랜덤 사각형 추가
         */
        private void addRandomRectangle(double x, double y) {
            double width = 60 + random.nextDouble() * 80;   // 60-140
            double height = 40 + random.nextDouble() * 60;  // 40-100
            Color color = generateRandomColor();
            
            DraggableRectangle rect = new DraggableRectangle(x, y, width, height, color);
            rectangles.add(rect);
        }
        
        /**
         * 주어진 위치에서 사각형 찾기 (위에서부터)
         */
        private DraggableRectangle findRectangleAt(double x, double y) {
            // 뒤에서부터 검색 (위에 그려진 것부터)
            for (int i = rectangles.size() - 1; i >= 0; i--) {
                if (rectangles.get(i).contains(x, y)) {
                    return rectangles.get(i);
                }
            }
            return null;
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                               RenderingHints.VALUE_ANTIALIAS_ON);
            
            // 모든 사각형 그리기
            for (DraggableRectangle rect : rectangles) {
                // 사각형 채우기
                g2d.setColor(rect.getColor());
                g2d.fillRect((int)rect.getLeft(), (int)rect.getTop(), 
                           (int)rect.getWidth(), (int)rect.getHeight());
                
                // 테두리 그리기
                g2d.setColor(rect.getBorderColor());
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRect((int)rect.getLeft(), (int)rect.getTop(), 
                           (int)rect.getWidth(), (int)rect.getHeight());
            }
            
            // 사각형 개수 표시
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString("사각형 개수: " + rectangles.size(), 10, 25);
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            lastMouseX = e.getX();
            lastMouseY = e.getY();
            
            boolean isDragMode = e.isShiftDown() || 
                               SwingUtilities.isRightMouseButton(e);
            
            if (isDragMode) {
                // 드래그 모드: 사각형 선택
                draggedRect = findRectangleAt(lastMouseX, lastMouseY);
                if (draggedRect != null) {
                    // 드래그 중인 사각형을 맨 위로 이동
                    rectangles.remove(draggedRect);
                    rectangles.add(draggedRect);
                    
                    // 드래그 중임을 표시 (테두리 색상 변경)
                    draggedRect.setBorderColor(Color.RED);
                }
            } else {
                // 추가 모드: 새 사각형 생성
                addRandomRectangle(lastMouseX, lastMouseY);
                repaint();
            }
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            if (draggedRect != null) {
                double deltaX = e.getX() - lastMouseX;
                double deltaY = e.getY() - lastMouseY;
                
                draggedRect.move(deltaX, deltaY);
                
                lastMouseX = e.getX();
                lastMouseY = e.getY();
                
                repaint();
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            if (draggedRect != null) {
                // 테두리 색상 복원
                draggedRect.setBorderColor(Color.BLACK);
                
                // 캔버스 밖으로 나갔는지 확인
                if (draggedRect.isOutsideCanvas(getWidth(), getHeight())) {
                    rectangles.remove(draggedRect);
                    System.out.println("사각형이 삭제되었습니다.");
                }
                
                draggedRect = null;
                repaint();
            }
        }
        
        @Override
        public void mouseClicked(MouseEvent e) { }
        
        @Override
        public void mouseEntered(MouseEvent e) { }
        
        @Override
        public void mouseExited(MouseEvent e) { }
        
        @Override
        public void mouseMoved(MouseEvent e) { }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new MultiRectangleDrag().setVisible(true);
        });
    }
}
```

### 고급 기능 추가

**1. 사각형 선택 및 다중 선택**
```java
// 선택된 사각형들을 관리하는 Set
private Set<DraggableRectangle> selectedRectangles = new HashSet<>();

// Ctrl+클릭으로 다중 선택
if (e.isControlDown()) {
    DraggableRectangle clicked = findRectangleAt(e.getX(), e.getY());
    if (clicked != null) {
        if (selectedRectangles.contains(clicked)) {
            selectedRectangles.remove(clicked);
        } else {
            selectedRectangles.add(clicked);
        }
    }
}
```

**2. 키보드 단축키 지원**
```java
// KeyListener 구현
@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
        rectangles.removeAll(selectedRectangles);
        selectedRectangles.clear();
        repaint();
    } else if (e.getKeyCode() == KeyEvent.VK_A && e.isControlDown()) {
        selectedRectangles.addAll(rectangles);
        repaint();
    }
}
```

**3. 사각형 속성 편집 다이얼로그**
```java
private void showEditDialog(DraggableRectangle rect) {
    JColorChooser colorChooser = new JColorChooser(rect.getColor());
    
    int result = JOptionPane.showConfirmDialog(
        this, 
        colorChooser, 
        "사각형 색상 선택", 
        JOptionPane.OK_CANCEL_OPTION
    );
    
    if (result == JOptionPane.OK_OPTION) {
        rect.setColor(colorChooser.getColor());
        repaint();
    }
}
```

---

## 종합 정리

### 핵심 학습 내용

**1. 데이터 구조 설계**
- ArrayList를 활용한 동적 데이터 관리
- 객체 지향적 데이터 모델링
- 효율적인 검색과 삭제 전략

**2. 알고리즘 구현**
- 정렬 알고리즘의 실제 구현과 최적화
- 성능 측정과 통계 분석
- 시간 복잡도의 실증적 검증

**3. 수학적 연산**
- 행렬 연산의 프로그래밍적 구현
- 메모리 효율성과 성능 최적화
- 수치 계산의 정확성 보장

**4. GUI 프로그래밍**
- 이벤트 기반 프로그래밍 패러다임
- 마우스와 키보드 입력 처리
- 그래픽 렌더링과 사용자 인터페이스 설계

### 실무 적용 포인트

**성능 고려사항**
```java
// 좋은 예: 지역성을 고려한 반복문
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        matrix[i][j] = value;  // 행 우선 접근
    }
}

// 나쁜 예: 캐시 미스가 많은 접근
for (int j = 0; j < cols; j++) {
    for (int i = 0; i < rows; i++) {
        matrix[i][j] = value;  // 열 우선 접근
    }
}
```

**메모리 관리**
```java
// 큰 객체는 사용 후 명시적으로 null 할당
bigDataStructure = null;
System.gc();  // 가비지 컬렉션 제안
```

**예외 처리**
```java
public static int[][] transpose(int[][] matrix) {
    if (matrix == null) {
        throw new IllegalArgumentException("행렬이 null입니다");
    }
    if (matrix.length == 0) {
        return new int[0][0];
    }
    // 구현...
}
```

### 다음 단계 학습 방향

1. **고급 자료구조**: TreeSet, HashMap, PriorityQueue
2. **알고리즘 최적화**: 동적 프로그래밍, 그리디 알고리즘
3. **병렬 처리**: 멀티스레딩을 활용한 성능 향상
4. **디자인 패턴**: MVC, Observer, Strategy 패턴
5. **GUI 프레임워크**: JavaFX, Swing 고급 기능

이러한 연습 문제들을 통해 7장에서 학습한 개념들을 실제 프로그래밍 상황에서 종합적으로 활용하는 능력을 기를 수 있습니다.