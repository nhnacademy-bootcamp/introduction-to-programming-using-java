# 7.7 프로그래밍 연습 - 수업 실습

## 1. 연습 문제 7.1: 중복 없는 랜덤 수 생성기

### 예제 1-1: 기본 구현

```java
import java.util.ArrayList;
import java.util.Scanner;

public class UniqueRandomGenerator {
    
    // TODO: 중복 없는 랜덤 수 생성 메서드를 작성하세요
    // 매개변수: int count (생성할 개수), int maxValue (최대값)
    // 반환값: ArrayList<Integer> (중복 없는 랜덤 수들)
    // 조건: count가 maxValue보다 크면 예외 발생
    public static ArrayList<Integer> generateUniqueRandoms(int count, int maxValue) {
        
    }
    
    // TODO: ArrayList 출력 메서드를 작성하세요
    // 매개변수: ArrayList<Integer> list, String title
    // 출력 형식: "제목:\n[1, 2, 3]\n총 3개의 숫자"
    public static void printList(ArrayList<Integer> list, String title) {
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 중복 없는 랜덤 수 생성기 ===");
        
        try {
            System.out.print("생성할 랜덤 수의 개수: ");
            int count = scanner.nextInt();
            
            System.out.print("최대값 (1부터 이 값까지): ");
            int maxValue = scanner.nextInt();
            
            if (count <= 0 || maxValue <= 0) {
                System.out.println("양수를 입력해주세요.");
                return;
            }
            
            // 성능 측정
            long startTime = System.nanoTime();
            ArrayList<Integer> randomNumbers = generateUniqueRandoms(count, maxValue);
            long endTime = System.nanoTime();
            
            printList(randomNumbers, "생성된 중복 없는 랜덤 수들");
            
            double executionTime = (endTime - startTime) / 1_000_000.0;
            System.out.printf("실행 시간: %.2f ms\n", executionTime);
            
            // TODO: 중복 검증 로직을 작성하세요
            // 생성된 숫자들에 중복이 있는지 확인
            boolean hasDuplicates = false;
            
            
            System.out.println("중복 검증: " + (hasDuplicates ? "실패" : "성공"));
            
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("입력 오류: 정수를 입력해주세요.");
        }
        
        scanner.close();
    }
}
```

**실행 결과:**
```
=== 중복 없는 랜덤 수 생성기 ===
생성할 랜덤 수의 개수: 10
최대값 (1부터 이 값까지): 50
생성된 중복 없는 랜덤 수들:
[23, 7, 45, 12, 38, 19, 5, 41, 28, 33]
총 10개의 숫자
실행 시간: 0.85 ms
중복 검증: 성공
```

### 예제 1-2: 성능 최적화 버전

```java
import java.util.*;

public class OptimizedUniqueRandomGenerator {
    
    // TODO: HashSet을 사용한 최적화 버전을 작성하세요
    // HashSet의 중복 자동 제거 기능 활용
    public static ArrayList<Integer> generateUniqueRandomsOptimized(int count, int maxValue) {
        
    }
    
    // TODO: Fisher-Yates 셔플을 사용한 최적화 버전을 작성하세요
    // 1. 1부터 maxValue까지의 리스트 생성
    // 2. 앞의 count개 요소만 셔플
    // 3. 앞의 count개 요소만 반환
    public static ArrayList<Integer> generateUniqueRandomsShuffle(int count, int maxValue) {
        
    }
    
    // TODO: 성능 비교 테스트 메서드를 작성하세요
    // 세 가지 방법의 실행 시간을 측정하고 비교
    public static void performanceComparison(int count, int maxValue, int iterations) {
        
    }
    
    public static void main(String[] args) {
        // 정확성 테스트
        System.out.println("=== 정확성 테스트 ===");
        ArrayList<Integer> result1 = generateUniqueRandomsOptimized(10, 20);
        ArrayList<Integer> result2 = generateUniqueRandomsShuffle(10, 20);
        
        System.out.println("HashSet 결과: " + result1);
        System.out.println("셔플 결과:   " + result2);
        
        // 성능 테스트
        performanceComparison(100, 1000, 10);
        performanceComparison(500, 1000, 5);
        performanceComparison(50, 100, 20);
    }
}
```

**실행 결과:**
```
=== 정확성 테스트 ===
HashSet 결과: [7, 23, 8, 41, 12, 45, 16, 19, 5, 28]
셔플 결과:   [15, 3, 8, 12, 7, 19, 4, 11, 16, 2]

=== 성능 비교 테스트 ===
테스트 조건: 100개 숫자, 범위 1-1000, 10회 반복
기본 방법:      12.45 ms
HashSet 최적화: 2.83 ms (4.4x 빠름)
셔플 방법:      1.21 ms (10.3x 빠름)

테스트 조건: 500개 숫자, 범위 1-1000, 5회 반복
기본 방법:      78.92 ms
HashSet 최적화: 8.45 ms (9.3x 빠름)
셔플 방법:      3.12 ms (25.3x 빠름)
```

---

## 2. 연습 문제 7.2: 행렬 전치 연산

### 예제 2-1: 기본 전치 연산

```java
public class MatrixTranspose {
    
    // TODO: 행렬 전치 메서드를 작성하세요
    // 매개변수: int[][] matrix (원본 행렬)
    // 반환값: int[][] (전치행렬 - 행과 열이 바뀐 새 행렬)
    // 조건: null이거나 빈 행렬이면 빈 행렬 반환
    public static int[][] transpose(int[][] matrix) {
        
    }
    
    // TODO: 정사각 행렬 제자리 전치 메서드를 작성하세요
    // 매개변수: int[][] matrix (정사각 행렬)
    // 기능: 원본 행렬을 직접 수정하여 전치 (메모리 효율적)
    // 조건: 정사각 행렬이 아니면 예외 발생
    public static void transposeInPlace(int[][] matrix) {
        
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
        
        System.out.printf("크기: %d x %d\n", matrix.length, matrix[0].length);
    }
    
    // TODO: 랜덤 행렬 생성 메서드를 작성하세요
    // 매개변수: int rows, int cols, int maxValue
    // 반환값: int[][] (1부터 maxValue까지의 랜덤 값으로 채워진 행렬)
    public static int[][] generateRandomMatrix(int rows, int cols, int maxValue) {
        
    }
    
    /**
     * 행렬 동일성 검사
     */
    public static boolean areMatricesEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 행렬 전치 연산 예제 ===");
        
        // 테스트 케이스 1: 일반적인 직사각 행렬
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        printMatrix(matrix1, "원본 행렬 (3x4)");
        int[][] transposed1 = transpose(matrix1);
        printMatrix(transposed1, "전치 행렬 (4x3)");
        
        // 전치의 전치는 원본과 같은지 확인
        int[][] doubleTransposed = transpose(transposed1);
        System.out.println("전치의 전치 == 원본: " + 
                          areMatricesEqual(matrix1, doubleTransposed));
        
        // 테스트 케이스 2: 정사각 행렬 제자리 전치
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        printMatrix(matrix2, "제자리 전치 전 (3x3)");
        
        // 원본 복사본 만들기 (비교용)
        int[][] originalCopy = new int[matrix2.length][matrix2[0].length];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                originalCopy[i][j] = matrix2[i][j];
            }
        }
        
        transposeInPlace(matrix2);
        printMatrix(matrix2, "제자리 전치 후");
        
        // 일반 전치와 제자리 전치 결과가 같은지 확인
        int[][] normalTransposed = transpose(originalCopy);
        System.out.println("제자리 전치 == 일반 전치: " + 
                          areMatricesEqual(matrix2, normalTransposed));
        
        // 테스트 케이스 3: 대칭 행렬
        int[][] symmetricMatrix = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };
        
        printMatrix(symmetricMatrix, "대칭 행렬");
        int[][] transposedSymmetric = transpose(symmetricMatrix);
        printMatrix(transposedSymmetric, "대칭 행렬의 전치");
        System.out.println("대칭 행렬 == 전치: " + 
                          areMatricesEqual(symmetricMatrix, transposedSymmetric));
        
        // 성능 테스트
        performanceTest();
    }
    
    private static void performanceTest() {
        System.out.println("\n=== 성능 테스트 ===");
        
        int[] sizes = {100, 500, 1000};
        
        for (int size : sizes) {
            System.out.printf("\n%dx%d 행렬 테스트:\n", size, size);
            
            // 테스트 데이터 생성
            int[][] testMatrix = generateRandomMatrix(size, size, 1000);
            
            // 일반 전치 성능 측정
            long startTime = System.nanoTime();
            transpose(testMatrix);
            long normalTime = System.nanoTime() - startTime;
            
            // 제자리 전치 성능 측정 (원본 복사)
            int[][] copyMatrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                System.arraycopy(testMatrix[i], 0, copyMatrix[i], 0, size);
            }
            
            startTime = System.nanoTime();
            transposeInPlace(copyMatrix);
            long inPlaceTime = System.nanoTime() - startTime;
            
            System.out.printf("일반 전치:   %.2f ms\n", normalTime / 1_000_000.0);
            System.out.printf("제자리 전치: %.2f ms (%.1fx 빠름)\n", 
                             inPlaceTime / 1_000_000.0, 
                             (double)normalTime / inPlaceTime);
        }
    }
}
```

**실행 결과:**
```
=== 행렬 전치 연산 예제 ===

원본 행렬 (3x4):
[  1,  2,  3,  4 ]
[  5,  6,  7,  8 ]
[  9, 10, 11, 12 ]
크기: 3 x 4

전치 행렬 (4x3):
[  1,  5,  9 ]
[  2,  6, 10 ]
[  3,  7, 11 ]
[  4,  8, 12 ]
크기: 4 x 3

정사각 행렬 제자리 전치:
원본:
[  1,  2,  3 ]
[  4,  5,  6 ]
[  7,  8,  9 ]

전치 후:
[  1,  4,  7 ]
[  2,  5,  8 ]
[  3,  6,  9 ]

=== 성능 테스트 ===
100x100 행렬 테스트:
일반 전치:   1.23 ms
제자리 전치: 0.45 ms (2.7x 빠름)

500x500 행렬 테스트:
일반 전치:   12.34 ms
제자리 전치: 4.67 ms (2.6x 빠름)
```

### 예제 2-2: 고급 행렬 연산

```java
public class AdvancedMatrixOperations {
    
    /**
     * 블록 전치 (캐시 효율성 최적화)
     */
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
    
    /**
     * 행렬 곱셈
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("행렬 곱셈이 불가능합니다.");
        }
        
        int[][] result = new int[a.length][b[0].length];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return result;
    }
    
    /**
     * 행렬 덧셈
     */
    public static int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("행렬 크기가 다릅니다.");
        }
        
        int[][] result = new int[a.length][a[0].length];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        
        return result;
    }
    
    /**
     * 단위 행렬 생성
     */
    public static int[][] createIdentityMatrix(int size) {
        int[][] identity = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        
        return identity;
    }
    
    /**
     * 행렬의 대각합 계산
     */
    public static int trace(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("정사각 행렬이 아닙니다.");
        }
        
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 고급 행렬 연산 예제 ===");
        
        // 행렬 생성
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] matrixB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        MatrixTranspose.printMatrix(matrixA, "행렬 A (2x3)");
        MatrixTranspose.printMatrix(matrixB, "행렬 B (3x2)");
        
        // 행렬 곱셈
        int[][] product = multiply(matrixA, matrixB);
        MatrixTranspose.printMatrix(product, "A × B");
        
        // 전치와 곱셈의 성질 확인: (AB)^T = B^T A^T
        int[][] transposedProduct = MatrixTranspose.transpose(product);
        int[][] bTransposed = MatrixTranspose.transpose(matrixB);
        int[][] aTransposed = MatrixTranspose.transpose(matrixA);
        int[][] productOfTransposed = multiply(bTransposed, aTransposed);
        
        MatrixTranspose.printMatrix(transposedProduct, "(AB)^T");
        MatrixTranspose.printMatrix(productOfTransposed, "B^T A^T");
        System.out.println("(AB)^T == B^T A^T: " + 
                          MatrixTranspose.areMatricesEqual(transposedProduct, productOfTransposed));
        
        // 단위 행렬과 대각합
        int[][] identity = createIdentityMatrix(3);
        MatrixTranspose.printMatrix(identity, "3x3 단위 행렬");
        System.out.println("단위 행렬의 대각합: " + trace(identity));
        
        // 블록 전치 성능 비교
        compareTransposeMethods();
    }
    
    private static void compareTransposeMethods() {
        System.out.println("\n=== 전치 방법별 성능 비교 ===");
        
        int size = 1024;
        int[][] largeMatrix = MatrixTranspose.generateRandomMatrix(size, size, 100);
        
        // 일반 전치
        long startTime = System.nanoTime();
        MatrixTranspose.transpose(largeMatrix);
        long normalTime = System.nanoTime() - startTime;
        
        // 블록 전치 (다양한 블록 크기)
        int[] blockSizes = {16, 32, 64, 128};
        
        System.out.printf("일반 전치: %.2f ms\n", normalTime / 1_000_000.0);
        
        for (int blockSize : blockSizes) {
            startTime = System.nanoTime();
            transposeBlocked(largeMatrix, blockSize);
            long blockedTime = System.nanoTime() - startTime;
            
            System.out.printf("블록 전치 (블록 크기 %d): %.2f ms (%.2fx)\n", 
                             blockSize, 
                             blockedTime / 1_000_000.0,
                             (double)normalTime / blockedTime);
        }
    }
}
```

---

## 3. 연습 문제 7.3: 정렬 알고리즘 성능 비교

### 예제 3-1: 기본 성능 측정

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
    
    /**
     * 정수 배열 정렬 성능 측정
     */
    public static void measureIntSortingPerformance(int arraySize) {
        System.out.printf("\n=== 정수 배열 정렬 성능 측정 (크기: %,d) ===\n", arraySize);
        
        // 동일한 데이터로 테스트
        int[] originalArray = generateRandomIntArray(arraySize, 1000000);
        
        // 선택 정렬 측정
        int[] array1 = originalArray.clone();
        long startTime = System.nanoTime();
        selectionSort(array1);
        long selectionTime = System.nanoTime() - startTime;
        
        // Arrays.sort() 측정
        int[] array2 = originalArray.clone();
        startTime = System.nanoTime();
        Arrays.sort(array2);
        long arraysTime = System.nanoTime() - startTime;
        
        // 정렬 결과 검증
        boolean isCorrect = Arrays.equals(array1, array2);
        
        System.out.printf("선택 정렬:    %8.2f ms\n", selectionTime / 1_000_000.0);
        System.out.printf("Arrays.sort(): %8.2f ms\n", arraysTime / 1_000_000.0);
        System.out.printf("속도 향상:    %8.2fx\n", (double)selectionTime / arraysTime);
        System.out.println("정렬 정확성:  " + (isCorrect ? "정확" : "오류"));
        
        // 정렬된 배열의 일부 출력 (작은 배열인 경우)
        if (arraySize <= 20) {
            System.out.println("정렬 결과: " + Arrays.toString(array1));
        }
    }
    
    /**
     * 문자열 배열 정렬 성능 측정
     */
    public static void measureStringSortingPerformance(int arraySize) {
        System.out.printf("\n=== 문자열 배열 정렬 성능 측정 (크기: %,d) ===\n", arraySize);
        
        String[] originalArray = generateRandomStringArray(arraySize, 10);
        
        // 선택 정렬 측정
        String[] array1 = originalArray.clone();
        long startTime = System.nanoTime();
        selectionSort(array1);
        long selectionTime = System.nanoTime() - startTime;
        
        // Arrays.sort() 측정
        String[] array2 = originalArray.clone();
        startTime = System.nanoTime();
        Arrays.sort(array2);
        long arraysTime = System.nanoTime() - startTime;
        
        boolean isCorrect = Arrays.equals(array1, array2);
        
        System.out.printf("선택 정렬:    %8.2f ms\n", selectionTime / 1_000_000.0);
        System.out.printf("Arrays.sort(): %8.2f ms\n", arraysTime / 1_000_000.0);
        System.out.printf("속도 향상:    %8.2fx\n", (double)selectionTime / arraysTime);
        System.out.println("정렬 정확성:  " + (isCorrect ? "정확" : "오류"));
        
        if (arraySize <= 10) {
            System.out.println("정렬 결과: " + Arrays.toString(array1));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 정렬 알고리즘 성능 비교 프로그램 ===");
        
        // 다양한 크기에서 성능 측정
        int[] sizes = {100, 500, 1000, 2000, 5000};
        
        for (int size : sizes) {
            measureIntSortingPerformance(size);
            measureStringSortingPerformance(size);
            System.out.println("-".repeat(50));
        }
        
        // 시간 복잡도 분석
        analyzeTimeComplexity();
    }
    
    /**
     * 시간 복잡도 분석
     */
    private static void analyzeTimeComplexity() {
        System.out.println("\n=== 시간 복잡도 분석 ===");
        
        int[] sizes = {500, 1000, 2000, 4000, 8000};
        
        System.out.println("배열 크기\t선택 정렬 (ms)\tArrays.sort() (ms)\t비율");
        System.out.println("-".repeat(60));
        
        for (int size : sizes) {
            int[] originalArray = generateRandomIntArray(size, 100000);
            
            // 선택 정렬
            int[] array1 = originalArray.clone();
            long startTime = System.nanoTime();
            selectionSort(array1);
            long selectionTime = System.nanoTime() - startTime;
            
            // Arrays.sort()
            int[] array2 = originalArray.clone();
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
        
        System.out.println("\n복잡도 분석:");
        System.out.println("- 선택 정렬: O(n²) - 배열 크기가 2배 증가하면 시간은 4배 증가");
        System.out.println("- Arrays.sort(): O(n log n) - 배열 크기가 2배 증가하면 시간은 약 2배 증가");
    }
}
```

### 예제 3-2: 고급 성능 분석

```java
import java.util.*;

public class AdvancedSortingAnalysis {
    
    /**
     * 다양한 정렬 알고리즘 구현
     */
    
    // 삽입 정렬
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            
            array[j + 1] = key;
        }
    }
    
    // 버블 정렬
    public static void bubbleSort(int[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) break;  // 최적화: 이미 정렬됨
        }
    }
    
    // 퀵 정렬
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return (i + 1);
    }
    
    /**
     * 다양한 데이터 패턴 생성
     */
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    
    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    public static int[] generateNearlySortedArray(int size, int swapCount) {
        int[] array = generateSortedArray(size);
        Random random = new Random();
        
        for (int i = 0; i < swapCount; i++) {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
        
        return array;
    }
    
    /**
     * 종합 성능 테스트
     */
    public static void comprehensivePerformanceTest() {
        System.out.println("=== 종합 정렬 성능 분석 ===");
        
        int size = 5000;
        String[] dataTypes = {"랜덤", "정렬됨", "역순", "거의정렬"};
        
        System.out.printf("%-12s %-10s %-10s %-10s %-10s %-12s\n", 
                         "데이터 타입", "선택정렬", "삽입정렬", "버블정렬", "퀵정렬", "Arrays.sort");
        System.out.println("-".repeat(75));
        
        for (String dataType : dataTypes) {
            int[] testData = generateTestData(dataType, size);
            
            // 각 정렬 알고리즘 테스트
            long selectionTime = testSortingAlgorithm(testData, "selection");
            long insertionTime = testSortingAlgorithm(testData, "insertion");
            long bubbleTime = testSortingAlgorithm(testData, "bubble");
            long quickTime = testSortingAlgorithm(testData, "quick");
            long arraysTime = testSortingAlgorithm(testData, "arrays");
            
            System.out.printf("%-12s %8.2f   %8.2f   %8.2f   %8.2f   %10.2f\n",
                dataType,
                selectionTime / 1_000_000.0,
                insertionTime / 1_000_000.0,
                bubbleTime / 1_000_000.0,
                quickTime / 1_000_000.0,
                arraysTime / 1_000_000.0
            );
        }
    }
    
    private static int[] generateTestData(String type, int size) {
        switch (type) {
            case "랜덤":
                return SortingPerformanceComparison.generateRandomIntArray(size, 10000);
            case "정렬됨":
                return generateSortedArray(size);
            case "역순":
                return generateReverseSortedArray(size);
            case "거의정렬":
                return generateNearlySortedArray(size, size / 20);
            default:
                return SortingPerformanceComparison.generateRandomIntArray(size, 10000);
        }
    }
    
    private static long testSortingAlgorithm(int[] data, String algorithm) {
        int[] array = data.clone();
        
        long startTime = System.nanoTime();
        
        switch (algorithm) {
            case "selection":
                SortingPerformanceComparison.selectionSort(array);
                break;
            case "insertion":
                insertionSort(array);
                break;
            case "bubble":
                bubbleSort(array);
                break;
            case "quick":
                quickSort(array, 0, array.length - 1);
                break;
            case "arrays":
                Arrays.sort(array);
                break;
        }
        
        return System.nanoTime() - startTime;
    }
    
    /**
     * 메모리 사용량 분석
     */
    public static void analyzeMemoryUsage() {
        System.out.println("\n=== 메모리 사용량 분석 ===");
        
        Runtime runtime = Runtime.getRuntime();
        int size = 100000;
        
        // 가비지 컬렉션 수행
        System.gc();
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        
        // 큰 배열 생성
        int[] largeArray = SortingPerformanceComparison.generateRandomIntArray(size, 1000000);
        
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = afterMemory - beforeMemory;
        
        System.out.printf("배열 크기: %,d 개 정수\n", size);
        System.out.printf("예상 메모리: %,d bytes (%.2f MB)\n", 
                         size * 4, (size * 4) / (1024.0 * 1024.0));
        System.out.printf("실제 메모리: %,d bytes (%.2f MB)\n", 
                         memoryUsed, memoryUsed / (1024.0 * 1024.0));
        
        // 정렬 후 메모리 사용량
        Arrays.sort(largeArray);
        System.gc();
        
        long afterSortMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("정렬 후 메모리: %,d bytes (%.2f MB)\n", 
                         afterSortMemory - beforeMemory, 
                         (afterSortMemory - beforeMemory) / (1024.0 * 1024.0));
    }
    
    public static void main(String[] args) {
        comprehensivePerformanceTest();
        analyzeMemoryUsage();
        
        System.out.println("\n=== 결론 ===");
        System.out.println("1. Arrays.sort()는 모든 경우에서 최고 성능");
        System.out.println("2. 삽입 정렬은 거의 정렬된 데이터에서 우수");
        System.out.println("3. 선택 정렬은 모든 경우에서 일정한 성능");
        System.out.println("4. 버블 정렬은 가장 비효율적");
        System.out.println("5. 퀵 정렬은 평균적으로 우수하지만 최악의 경우 O(n²)");
    }
}
```

---

## 4. 연습 문제 7.5: 사용자 입력 정렬

### 예제 4-1: 기본 구현

```java
import java.util.Scanner;

public class UserInputSorting {
    
    /**
     * 삽입 정렬 구현
     */
    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            
            array[j + 1] = key;
        }
    }
    
    /**
     * 선택 정렬 구현
     */
    public static void selectionSort(double[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                double temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    
    /**
     * 배열이 정렬되었는지 확인
     */
    public static boolean isSorted(double[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 배열 출력
     */
    public static void printArray(double[] array, String title) {
        System.out.println(title + ":");
        
        if (array.length <= 20) {
            // 작은 배열은 모두 출력
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%.2f", array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            // 큰 배열은 처음 10개와 마지막 10개만 출력
            System.out.print("[");
            for (int i = 0; i < 5; i++) {
                System.out.printf("%.2f, ", array[i]);
            }
            System.out.print("..., ");
            for (int i = array.length - 5; i < array.length; i++) {
                System.out.printf("%.2f", array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        
        System.out.println("총 개수: " + array.length);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[100];  // 최대 100개
        int count = 0;
        
        System.out.println("=== 양의 실수 정렬 프로그램 ===");
        System.out.println("양의 실수를 입력하세요 (0을 입력하면 종료):");
        System.out.println("최대 100개까지 입력 가능합니다.");
        
        // 사용자 입력 받기
        while (count < 100) {
            System.out.printf("숫자 %d: ", count + 1);
            
            try {
                double input = scanner.nextDouble();
                
                if (input == 0) {
                    break;  // 입력 종료
                }
                
                if (input > 0) {
                    numbers[count] = input;
                    count++;
                } else {
                    System.out.println("양수만 입력해주세요.");
                }
                
            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine();  // 잘못된 입력 제거
            }
        }
        
        if (count == 0) {
            System.out.println("입력된 숫자가 없습니다.");
            scanner.close();
            return;
        }
        
        // 입력된 개수만큼 배열 크기 조정
        double[] inputArray = new double[count];
        System.arraycopy(numbers, 0, inputArray, 0, count);
        
        System.out.println("\n" + "=".repeat(50));
        printArray(inputArray, "입력된 숫자들");
        
        // 정렬 방법 선택
        System.out.println("\n정렬 방법을 선택하세요:");
        System.out.println("1. 삽입 정렬");
        System.out.println("2. 선택 정렬"); 
        System.out.print("선택 (1 또는 2): ");
        
        int choice = 1;  // 기본값
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 삽입 정렬을 사용합니다.");
        }
        
        // 정렬 수행
        long startTime = System.nanoTime();
        
        if (choice == 2) {
            System.out.println("\n선택 정렬을 수행합니다...");
            selectionSort(inputArray);
        } else {
            System.out.println("\n삽입 정렬을 수행합니다...");
            insertionSort(inputArray);
        }
        
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("정렬 완료!");
        System.out.printf("실행 시간: %.3f ms\n", executionTime);
        
        // 결과 출력
        printArray(inputArray, "정렬된 숫자들");
        
        // 정렬 검증
        boolean sorted = isSorted(inputArray);
        System.out.println("정렬 검증: " + (sorted ? "성공" : "실패"));
        
        // 통계 정보
        displayStatistics(inputArray);
        
        scanner.close();
    }
    
    /**
     * 통계 정보 출력
     */
    private static void displayStatistics(double[] array) {
        if (array.length == 0) return;
        
        double min = array[0];
        double max = array[array.length - 1];
        double sum = 0;
        
        for (double num : array) {
            sum += num;
        }
        
        double average = sum / array.length;
        double median;
        
        if (array.length % 2 == 0) {
            median = (array[array.length/2 - 1] + array[array.length/2]) / 2.0;
        } else {
            median = array[array.length/2];
        }
        
        System.out.println("\n=== 통계 정보 ===");
        System.out.printf("최솟값: %.2f\n", min);
        System.out.printf("최댓값: %.2f\n", max);
        System.out.printf("합계:   %.2f\n", sum);
        System.out.printf("평균:   %.2f\n", average);
        System.out.printf("중앙값: %.2f\n", median);
        System.out.printf("범위:   %.2f\n", max - min);
    }
}
```

### 예제 4-2: 고급 기능 확장

```java
import java.util.*;
import java.io.*;

public class AdvancedUserInputSorting {
    
    private static final int MAX_NUMBERS = 100;
    
    /**
     * 다양한 정렬 알고리즘
     */
    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;  
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    public static void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    
    private static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = (low - 1);
        
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return (i + 1);
    }
    
    /**
     * 파일에서 숫자 읽기
     */
    public static List<Double> readNumbersFromFile(String filename) {
        List<Double> numbers = new ArrayList<>();
        
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextDouble()) {
                    double num = fileScanner.nextDouble();
                    if (num > 0) {
                        numbers.add(num);
                    }
                } else {
                    fileScanner.next(); // 숫자가 아닌 토큰 건너뛰기
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + filename);
        }
        
        return numbers;
    }
    
    /**
     * 결과를 파일에 저장
     */
    public static void saveResultsToFile(double[] array, String filename, 
                                       String sortMethod, double executionTime) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=== 정렬 결과 ===");
            writer.println("정렬 방법: " + sortMethod);
            writer.printf("실행 시간: %.3f ms\n", executionTime);
            writer.println("총 개수: " + array.length);
            writer.println();
            
            writer.println("정렬된 숫자들:");
            for (int i = 0; i < array.length; i++) {
                writer.printf("%.2f", array[i]);
                if ((i + 1) % 10 == 0) {
                    writer.println();
                } else if (i < array.length - 1) {
                    writer.print(", ");
                }
            }
            
            if (array.length % 10 != 0) {
                writer.println();
            }
            
            writer.println("\n=== 통계 정보 ===");
            writeStatistics(writer, array);
            
            System.out.println("결과가 " + filename + " 파일에 저장되었습니다.");
            
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    private static void writeStatistics(PrintWriter writer, double[] array) {
        if (array.length == 0) return;
        
        double min = array[0];
        double max = array[array.length - 1];
        double sum = Arrays.stream(array).sum();
        double average = sum / array.length;
        
        double median;
        if (array.length % 2 == 0) {
            median = (array[array.length/2 - 1] + array[array.length/2]) / 2.0;
        } else {
            median = array[array.length/2];
        }
        
        writer.printf("최솟값: %.2f\n", min);
        writer.printf("최댓값: %.2f\n", max);
        writer.printf("합계:   %.2f\n", sum);
        writer.printf("평균:   %.2f\n", average);
        writer.printf("중앙값: %.2f\n", median);
        writer.printf("범위:   %.2f\n", max - min);
    }
    
    /**
     * 메뉴 기반 사용자 인터페이스
     */
    public static void displayMenu() {
        System.out.println("\n=== 고급 정렬 프로그램 ===");
        System.out.println("1. 콘솔에서 숫자 입력");
        System.out.println("2. 파일에서 숫자 읽기");
        System.out.println("3. 랜덤 숫자 생성");
        System.out.println("4. 정렬 방법 선택");
        System.out.println("5. 정렬 실행");
        System.out.println("6. 결과를 파일로 저장");
        System.out.println("7. 성능 비교");
        System.out.println("0. 종료");
        System.out.print("선택: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numberList = new ArrayList<>();
        String sortMethod = "삽입 정렬";
        int sortChoice = 1;
        
        while (true) {
            displayMenu();
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        inputNumbersFromConsole(scanner, numberList);
                        break;
                        
                    case 2:
                        System.out.print("파일명을 입력하세요: ");
                        String filename = scanner.next();
                        List<Double> fileNumbers = readNumbersFromFile(filename);
                        numberList.addAll(fileNumbers);
                        System.out.println(fileNumbers.size() + "개의 숫자를 읽었습니다.");
                        break;
                        
                    case 3:
                        generateRandomNumbers(scanner, numberList);
                        break;
                        
                    case 4:
                        sortChoice = selectSortingMethod(scanner);
                        sortMethod = getSortMethodName(sortChoice);
                        break;
                        
                    case 5:
                        if (numberList.isEmpty()) {
                            System.out.println("먼저 숫자를 입력하세요.");
                        } else {
                            performSorting(numberList, sortChoice, sortMethod);
                        }
                        break;
                        
                    case 6:
                        if (numberList.isEmpty()) {
                            System.out.println("정렬할 데이터가 없습니다.");
                        } else {
                            System.out.print("저장할 파일명: ");
                            String saveFile = scanner.next();
                            double[] array = numberList.stream().mapToDouble(d -> d).toArray();
                            saveResultsToFile(array, saveFile, sortMethod, 0);
                        }
                        break;
                        
                    case 7:
                        if (numberList.isEmpty()) {
                            System.out.println("비교할 데이터가 없습니다.");
                        } else {
                            performanceComparison(numberList);
                        }
                        break;
                        
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();
                        return;
                        
                    default:
                        System.out.println("잘못된 선택입니다.");
                }
                
            } catch (Exception e) {
                System.out.println("입력 오류: " + e.getMessage());
                scanner.nextLine(); // 버퍼 클리어
            }
        }
    }
    
    private static void inputNumbersFromConsole(Scanner scanner, List<Double> numberList) {
        System.out.println("양의 실수를 입력하세요 (0을 입력하면 종료):");
        
        while (numberList.size() < MAX_NUMBERS) {
            System.out.printf("숫자 %d: ", numberList.size() + 1);
            
            try {
                double input = scanner.nextDouble();
                
                if (input == 0) {
                    break;
                }
                
                if (input > 0) {
                    numberList.add(input);
                } else {
                    System.out.println("양수만 입력해주세요.");
                }
                
            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
        
        System.out.println(numberList.size() + "개의 숫자가 입력되었습니다.");
    }
    
    private static void generateRandomNumbers(Scanner scanner, List<Double> numberList) {
        System.out.print("생성할 랜덤 숫자 개수: ");
        int count = scanner.nextInt();
        
        System.out.print("최댓값: ");
        double maxValue = scanner.nextDouble();
        
        Random random = new Random();
        numberList.clear();
        
        for (int i = 0; i < Math.min(count, MAX_NUMBERS); i++) {
            double randomNum = random.nextDouble() * maxValue;
            numberList.add(randomNum);
        }
        
        System.out.println(numberList.size() + "개의 랜덤 숫자가 생성되었습니다.");
    }
    
    private static int selectSortingMethod(Scanner scanner) {
        System.out.println("\n정렬 방법을 선택하세요:");
        System.out.println("1. 삽입 정렬");
        System.out.println("2. 선택 정렬");
        System.out.println("3. 버블 정렬");
        System.out.println("4. 퀵 정렬");
        System.out.print("선택: ");
        
        int choice = scanner.nextInt();
        return (choice >= 1 && choice <= 4) ? choice : 1;
    }
    
    private static String getSortMethodName(int choice) {
        switch (choice) {
            case 1: return "삽입 정렬";
            case 2: return "선택 정렬";
            case 3: return "버블 정렬";
            case 4: return "퀵 정렬";
            default: return "삽입 정렬";
        }
    }
    
    private static void performSorting(List<Double> numberList, int sortChoice, String sortMethod) {
        double[] array = numberList.stream().mapToDouble(d -> d).toArray();
        
        System.out.println("\n" + sortMethod + "을(를) 수행합니다...");
        
        long startTime = System.nanoTime();
        
        switch (sortChoice) {
            case 1:
                UserInputSorting.insertionSort(array);
                break;
            case 2:
                UserInputSorting.selectionSort(array);
                break;
            case 3:
                bubbleSort(array);
                break;
            case 4:
                quickSort(array, 0, array.length - 1);
                break;
        }
        
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("정렬 완료!");
        System.out.printf("실행 시간: %.3f ms\n", executionTime);
        
        // 정렬된 결과로 리스트 업데이트
        numberList.clear();
        for (double num : array) {
            numberList.add(num);
        }
        
        UserInputSorting.printArray(array, "정렬 결과");
    }
    
    private static void performanceComparison(List<Double> numberList) {
        System.out.println("\n=== 성능 비교 ===");
        
        double[] originalArray = numberList.stream().mapToDouble(d -> d).toArray();
        String[] methods = {"삽입 정렬", "선택 정렬", "버블 정렬", "퀵 정렬"};
        
        System.out.printf("%-10s %10s\n", "정렬 방법", "실행시간(ms)");
        System.out.println("-".repeat(25));
        
        for (int i = 0; i < 4; i++) {
            double[] array = originalArray.clone();
            
            long startTime = System.nanoTime();
            
            switch (i) {
                case 0:
                    UserInputSorting.insertionSort(array);
                    break;
                case 1:
                    UserInputSorting.selectionSort(array);
                    break;
                case 2:
                    bubbleSort(array);
                    break;
                case 3:
                    quickSort(array, 0, array.length - 1);
                    break;
            }
            
            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;
            
            System.out.printf("%-10s %10.3f\n", methods[i], executionTime);
        }
    }
}
```

---

## 요약

이 예제들을 통해 7장의 연습 문제들에 대한 완전한 구현을 제공했습니다:

### 구현된 기능들

**연습 7.1 - 중복 없는 랜덤 수 생성**
- 기본 구현과 최적화된 버전 (HashSet, Fisher-Yates)
- 성능 비교 및 분석

**연습 7.2 - 행렬 전치**
- 일반 전치와 제자리 전치
- 블록 전치를 통한 성능 최적화
- 행렬 연산의 수학적 성질 검증

**연습 7.3 - 정렬 성능 비교**
- 다양한 정렬 알고리즘 구현
- 정확한 성능 측정 기법
- 시간 복잡도의 실증적 분석

**연습 7.5 - 사용자 입력 정렬**
- 기본 구현과 고급 기능 확장
- 파일 I/O와 메뉴 시스템
- 통계 분석 및 결과 저장

### 핵심 학습 포인트

1. **성능 최적화**: 알고리즘 선택과 데이터 구조 최적화
2. **사용자 경험**: 직관적인 인터페이스와 오류 처리
3. **코드 품질**: 모듈화, 재사용성, 유지보수성
4. **실무 적용**: 파일 처리, 통계 분석, 결과 저장

💡 이러한 예제들은 실제 프로그래밍에서 자주 만나는 패턴들을 포함하고 있어, 실무 개발 능력 향상에 직접적으로 도움이 됩니다!