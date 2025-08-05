# 7.6 이차원 배열 - 수업 실습

## 1. 기본 개념 예제

### 예제 1-1: 이차원 배열 생성과 초기화

```java
import java.util.Arrays;

public class Array2DBasicExample {
    public static void main(String[] args) {
        // 방법 1: 크기 지정으로 생성
        int[][] matrix1 = new int[3][4];  // 3행 4열 (모든 요소는 0)
        System.out.println("빈 3x4 배열 생성:");
        printArray2D(matrix1);
        
        // 방법 2: 초기화 리스트로 생성
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("\n초기화 리스트로 생성:");
        printArray2D(matrix2);
        
        // 방법 3: new 배열 리터럴
        int[][] matrix3 = new int[][] {
            {10, 20},
            {30, 40},
            {50, 60}
        };
        System.out.println("\n배열 리터럴로 생성:");
        printArray2D(matrix3);
        
        // 배열 정보 출력
        System.out.println("\n배열 정보:");
        System.out.println("matrix2 행 수: " + matrix2.length);
        System.out.println("matrix2 열 수: " + matrix2[0].length);
        System.out.println("matrix2[1][2] 값: " + matrix2[1][2]);
    }
    
    // TODO: 이차원 배열 출력 메서드를 작성하세요
    // 매개변수: int[][] array
    // 힌트: for-each 루프와 Arrays.toString() 사용
    public static void printArray2D(int[][] array) {
        
    }
}
```

**실행 결과:**
```
빈 3x4 배열 생성:
[0, 0, 0, 0]
[0, 0, 0, 0]
[0, 0, 0, 0]

초기화 리스트로 생성:
[1, 2, 3, 4]
[5, 6, 7, 8]
[9, 10, 11, 12]

배열 리터럴로 생성:
[10, 20]
[30, 40]
[50, 60]

배열 정보:
matrix2 행 수: 3
matrix2 열 수: 4
matrix2[1][2] 값: 7
```

### 예제 1-2: 가변 길이 배열

```java
public class JaggedArrayExample {
    public static void main(String[] args) {
        // 삼각형 모양의 배열 생성
        int[][] triangle = new int[5][];  // 5개의 행만 생성
        
        // 각 행을 다른 길이로 생성
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];  // i+1개의 요소
        }
        
        // 값 초기화
        int value = 1;
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = value++;
            }
        }
        
        System.out.println("삼각형 배열:");
        printJaggedArray(triangle);
        
        // 파스칼의 삼각형 만들기
        int[][] pascal = createPascalTriangle(6);
        System.out.println("\n파스칼의 삼각형:");
        printJaggedArray(pascal);
    }
    
    public static void printJaggedArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%3d", element);
            }
            System.out.println();
        }
    }
    
    // TODO: 파스칼의 삼각형 생성 메서드를 작성하세요
    // 매개변수: int rows
    // 반환값: int[][] (가변 길이 배열)
    // 규칙: pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
    public static int[][] createPascalTriangle(int rows) {
        // TODO: 가변 길이 배열 생성
        int[][] pascal = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            // TODO: 각 행의 길이를 i+1로 설정
            pascal[i] = new int[i + 1];
            
            // TODO: 첫 번째와 마지막 요소를 1로 설정
            
            
            // TODO: 중간 요소들을 계산하세요
            // 힌트: pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
            for (int j = 1; j < i; j++) {
                
            }
        }
        
        return pascal;
    }
}
```

**실행 결과:**
```
삼각형 배열:
  1
  2  3
  4  5  6
  7  8  9 10
 11 12 13 14 15

파스칼의 삼각형:
  1
  1  1
  1  2  1
  1  3  3  1
  1  4  6  4  1
  1  5 10 10  5  1
```

## 2. 순회와 처리 예제

### 예제 2-1: 다양한 순회 방법

```java
public class Array2DTraversalExample {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        System.out.println("원본 배열:");
        printMatrix(matrix);
        
        System.out.println("\n=== 다양한 순회 방법 ===");
        
        // 행 우선 순회
        System.out.println("행 우선 순회 (Row-major):");
        traverseRowMajor(matrix);
        
        // 열 우선 순회
        System.out.println("\n열 우선 순회 (Column-major):");
        traverseColumnMajor(matrix);
        
        // 대각선 순회
        System.out.println("\n대각선 순회:");
        traverseDiagonal(matrix);
        
        // 나선형 순회
        System.out.println("\n나선형 순회:");
        traverseSpiral(matrix);
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d", element);
            }
            System.out.println();
        }
    }
    
    // TODO: 행 우선 순회 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 순서: 왼쪽에서 오른쪽으로, 위에서 아래로
    public static void traverseRowMajor(int[][] matrix) {
        
    }
    
    // TODO: 열 우선 순회 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 순서: 위에서 아래로, 왼쪽에서 오른쪽으로
    public static void traverseColumnMajor(int[][] matrix) {
        
    }
    
    // TODO: 대각선 순회 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 순서: [0][0], [1][1], [2][2], ...
    public static void traverseDiagonal(int[][] matrix) {
        // TODO: 최소 차원 구하기 (정사각형이 아닐 수 있음)
        int minDim = ;
        
        // TODO: 대각선 요소들 출력
        
    }
    
    public static void traverseSpiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // 위쪽 행 (왼쪽에서 오른쪽)
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;
            
            // 오른쪽 열 (위에서 아래)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            // 아래쪽 행 (오른쪽에서 왼쪽)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }
            
            // 왼쪽 열 (아래에서 위)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}
```

### 예제 2-2: 배열 연산

```java
public class Array2DOperationsExample {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        System.out.println("행렬 1:");
        printMatrix(matrix1);
        
        System.out.println("\n행렬 2:");
        printMatrix(matrix2);
        
        // 행렬 덧셈
        int[][] sum = addMatrices(matrix1, matrix2);
        System.out.println("\n행렬 덧셈 결과:");
        printMatrix(sum);
        
        // 행렬 전치
        int[][] transposed = transpose(matrix1);
        System.out.println("\n행렬 1의 전치:");
        printMatrix(transposed);
        
        // 행렬 곱셈
        int[][] product = multiplyMatrices(matrix1, matrix2);
        System.out.println("\n행렬 곱셈 결과:");
        printMatrix(product);
        
        // 통계 계산
        System.out.println("\n=== 통계 정보 ===");
        System.out.println("행렬 1 합계: " + calculateSum(matrix1));
        System.out.println("행렬 1 평균: " + calculateAverage(matrix1));
        System.out.println("행렬 1 최대값: " + findMax(matrix1));
        System.out.println("행렬 1 최소값: " + findMin(matrix1));
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }
    
    // TODO: 행렬 덧셈 메서드를 작성하세요
    // 매개변수: int[][] a, int[][] b
    // 반환값: int[][] (a + b)
    // 조건: 두 행렬의 크기가 같아야 함
    public static int[][] addMatrices(int[][] a, int[][] b) {
        // TODO: 크기 검사
        if () {
            throw new IllegalArgumentException("행렬 크기가 다릅니다");
        }
        
        // TODO: 결과 행렬 생성
        int[][] result = new int[a.length][a[0].length];
        
        // TODO: 각 요소를 더하기
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                
            }
        }
        return result;
    }
    
    // TODO: 행렬 전치 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 반환값: int[][] (행과 열이 바뀐 행렬)
    public static int[][] transpose(int[][] matrix) {
        // TODO: 전치 행렬 생성 (행과 열 크기 바뀜)
        int[][] result = new int[matrix[0].length][matrix.length];
        
        // TODO: 요소들을 행↔열로 바꿔서 복사
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                
            }
        }
        return result;
    }
    
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("행렬 곱셈이 불가능합니다");
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
    
    // TODO: 행렬의 모든 요소 합 계산 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 반환값: int (모든 요소의 합)
    public static int calculateSum(int[][] matrix) {
        int sum = 0;
        // TODO: for-each 루프로 모든 요소 더하기
        
        return sum;
    }
    
    // TODO: 행렬의 평균값 계산 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 반환값: double (평균값)
    public static double calculateAverage(int[][] matrix) {
        int sum = calculateSum(matrix);
        // TODO: 전체 요소 개수 계산
        int totalElements = ;
        return (double) sum / totalElements;
    }
    
    // TODO: 행렬에서 최댓값 찾기 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 반환값: int (최댓값)
    public static int findMax(int[][] matrix) {
        // TODO: 첫 번째 요소로 초기화
        int max = ;
        
        // TODO: 모든 요소와 비교하여 최댓값 찾기
        
        return max;
    }
    
    // TODO: 행렬에서 최솟값 찾기 메서드를 작성하세요
    // 매개변수: int[][] matrix
    // 반환값: int (최솟값)
    public static int findMin(int[][] matrix) {
        // TODO: 첫 번째 요소로 초기화
        int min = ;
        
        // TODO: 모든 요소와 비교하여 최솟값 찾기
        
        return min;
    }
}
```

## 3. 실용적인 응용 예제

### 예제 3-1: 학생 성적 관리 시스템

```java
import java.util.Scanner;

public class GradeManagementExample {
    public static void main(String[] args) {
        // 5명 학생, 3과목 성적
        double[][] scores = {
            {85.5, 92.0, 78.5},  // 학생 1
            {90.0, 85.5, 95.0},  // 학생 2
            {88.0, 91.0, 87.5},  // 학생 3
            {92.5, 88.5, 90.0},  // 학생 4
            {87.0, 89.5, 86.0}   // 학생 5
        };
        
        String[] students = {"김철수", "이영희", "박민수", "최지영", "홍길동"};
        String[] subjects = {"국어", "수학", "영어"};
        
        System.out.println("=== 학생 성적 관리 시스템 ===");
        
        // 성적표 출력
        printGradeTable(scores, students, subjects);
        
        // 학생별 평균 계산
        System.out.println("\n=== 학생별 평균 ===");
        for (int i = 0; i < students.length; i++) {
            double average = calculateStudentAverage(scores, i);
            System.out.printf("%s: %.1f점\n", students[i], average);
        }
        
        // 과목별 평균 계산
        System.out.println("\n=== 과목별 평균 ===");
        for (int j = 0; j < subjects.length; j++) {
            double average = calculateSubjectAverage(scores, j);
            System.out.printf("%s: %.1f점\n", subjects[j], average);
        }
        
        // 최고 점수와 최저 점수
        double[] minMax = findMinMaxScores(scores);
        System.out.printf("\n최고 점수: %.1f점\n", minMax[1]);
        System.out.printf("최저 점수: %.1f점\n", minMax[0]);
        
        // 등급 분포
        System.out.println("\n=== 등급 분포 ===");
        printGradeDistribution(scores, students);
    }
    
    public static void printGradeTable(double[][] scores, String[] students, String[] subjects) {
        System.out.printf("%8s", "학생");
        for (String subject : subjects) {
            System.out.printf("%8s", subject);
        }
        System.out.printf("%8s\n", "평균");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%8s", students[i]);
            double sum = 0;
            for (int j = 0; j < subjects.length; j++) {
                System.out.printf("%8.1f", scores[i][j]);
                sum += scores[i][j];
            }
            System.out.printf("%8.1f\n", sum / subjects.length);
        }
    }
    
    public static double calculateStudentAverage(double[][] scores, int studentIndex) {
        double sum = 0;
        for (int j = 0; j < scores[studentIndex].length; j++) {
            sum += scores[studentIndex][j];
        }
        return sum / scores[studentIndex].length;
    }
    
    public static double calculateSubjectAverage(double[][] scores, int subjectIndex) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][subjectIndex];
        }
        return sum / scores.length;
    }
    
    public static double[] findMinMaxScores(double[][] scores) {
        double min = scores[0][0];
        double max = scores[0][0];
        
        for (double[] row : scores) {
            for (double score : row) {
                if (score < min) min = score;
                if (score > max) max = score;
            }
        }
        
        return new double[]{min, max};
    }
    
    public static void printGradeDistribution(double[][] scores, String[] students) {
        int[] gradeCount = new int[5];  // A, B, C, D, F
        String[] grades = {"A", "B", "C", "D", "F"};
        
        for (int i = 0; i < students.length; i++) {
            double average = calculateStudentAverage(scores, i);
            int gradeIndex = getGradeIndex(average);
            gradeCount[gradeIndex]++;
            System.out.printf("%s: %.1f점 (%s등급)\n", 
                students[i], average, grades[gradeIndex]);
        }
        
        System.out.println("\n등급별 분포:");
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("%s등급: %d명\n", grades[i], gradeCount[i]);
        }
    }
    
    private static int getGradeIndex(double average) {
        if (average >= 90) return 0;  // A
        else if (average >= 80) return 1;  // B
        else if (average >= 70) return 2;  // C
        else if (average >= 60) return 3;  // D
        else return 4;  // F
    }
}
```

### 예제 3-2: 이미지 처리 시뮬레이션

```java
import java.util.Random;

public class ImageProcessingExample {
    public static void main(String[] args) {
        int width = 8;
        int height = 8;
        
        // 흑백 이미지 생성 (0-9 값으로 단순화)
        int[][] image = generateRandomImage(width, height);
        
        System.out.println("원본 이미지:");
        printImage(image);
        
        // 이미지 반전
        int[][] inverted = invertImage(image);
        System.out.println("\n반전된 이미지:");
        printImage(inverted);
        
        // 이미지 회전 (90도 시계방향)
        int[][] rotated = rotateImage90(image);
        System.out.println("\n90도 회전된 이미지:");
        printImage(rotated);
        
        // 이미지 미러링 (좌우 반전)
        int[][] mirrored = mirrorImageHorizontal(image);
        System.out.println("\n좌우 반전된 이미지:");
        printImage(mirrored);
        
        // 블러 효과 (평균 필터)
        int[][] blurred = applyBlur(image);
        System.out.println("\n블러 효과 적용:");
        printImage(blurred);
        
        // 히스토그램 출력
        System.out.println("\n=== 원본 이미지 히스토그램 ===");
        printHistogram(image);
    }
    
    public static int[][] generateRandomImage(int width, int height) {
        int[][] image = new int[height][width];
        Random random = new Random();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image[i][j] = random.nextInt(10);  // 0-9 범위
            }
        }
        
        return image;
    }
    
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] invertImage(int[][] image) {
        int[][] result = new int[image.length][image[0].length];
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                result[i][j] = 9 - image[i][j];  // 0-9 범위에서 반전
            }
        }
        
        return result;
    }
    
    public static int[][] rotateImage90(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = image[i][j];
            }
        }
        
        return result;
    }
    
    public static int[][] mirrorImageHorizontal(int[][] image) {
        int[][] result = new int[image.length][image[0].length];
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                result[i][image[0].length - 1 - j] = image[i][j];
            }
        }
        
        return result;
    }
    
    public static int[][] applyBlur(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];
        
        // 경계는 그대로 유지, 내부만 블러 적용
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                int sum = 0;
                int count = 0;
                
                // 3x3 영역의 평균 계산
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        sum += image[i + di][j + dj];
                        count++;
                    }
                }
                
                result[i][j] = sum / count;
            }
        }
        
        // 경계 복사
        for (int i = 0; i < rows; i++) {
            result[i][0] = image[i][0];
            result[i][cols - 1] = image[i][cols - 1];
        }
        for (int j = 0; j < cols; j++) {
            result[0][j] = image[0][j];
            result[rows - 1][j] = image[rows - 1][j];
        }
        
        return result;
    }
    
    public static void printHistogram(int[][] image) {
        int[] histogram = new int[10];  // 0-9 값의 빈도
        
        // 히스토그램 계산
        for (int[] row : image) {
            for (int pixel : row) {
                histogram[pixel]++;
            }
        }
        
        // 히스토그램 출력
        for (int i = 0; i < histogram.length; i++) {
            System.out.printf("값 %d: %d개 ", i, histogram[i]);
            for (int j = 0; j < histogram[i]; j++) {
                System.out.print("■");
            }
            System.out.println();
        }
    }
}
```

## 4. 게임 구현 예제

### 예제 4-1: 간단한 틱택토 게임

```java
import java.util.Scanner;

public class TicTacToeExample {
    private static char[][] board = new char[3][3];
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== 틱택토 게임 ===");
        initializeBoard();
        
        char currentPlayer = PLAYER_X;
        boolean gameWon = false;
        int moves = 0;
        
        while (!gameWon && moves < 9) {
            printBoard();
            System.out.println("현재 플레이어: " + currentPlayer);
            
            if (makeMove(currentPlayer)) {
                moves++;
                gameWon = checkWinner(currentPlayer);
                
                if (gameWon) {
                    printBoard();
                    System.out.println("플레이어 " + currentPlayer + "가 승리했습니다!");
                } else {
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }
        }
        
        if (!gameWon) {
            printBoard();
            System.out.println("무승부입니다!");
        }
    }
    
    // TODO: 보드 초기화 메서드를 작성하세요
    // 3x3 보드의 모든 칸을 EMPTY로 설정
    public static void initializeBoard() {
        
    }
    
    // TODO: 보드 출력 메서드를 작성하세요
    // 행 번호와 열 번호를 포함하여 보드 출력
    public static void printBoard() {
        
    }
    
    public static boolean makeMove(char player) {
        System.out.print("행과 열을 입력하세요 (예: 1 2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        
        if (isValidMove(row, col)) {
            board[row][col] = player;
            return true;
        } else {
            System.out.println("잘못된 위치입니다. 다시 시도하세요.");
            return false;
        }
    }
    
    // TODO: 유효한 이동인지 확인하는 메서드를 작성하세요
    // 범위 검사와 빈 칸 검사 필요
    public static boolean isValidMove(int row, int col) {
        
    }
    
    // TODO: 승리 검사 메서드를 작성하세요
    // 행, 열, 대각선 검사 모두 구현
    public static boolean checkWinner(char player) {
        // 행 검사
        
        
        // 열 검사
        
        
        // 대각선 검사
        
        
        return false;
    }
}
```

**실행 결과:**
```
=== 틱택토 게임 ===

현재 보드:
  0   1   2
0   |   |   
  ---------
1   |   |   
  ---------
2   |   |   

현재 플레이어: X
행과 열을 입력하세요 (예: 1 2): 1 1

현재 보드:
  0   1   2
0   |   |   
  ---------
1   | X |   
  ---------
2   |   |   

현재 플레이어: O
행과 열을 입력하세요 (예: 1 2): 0 0

현재 보드:
  0   1   2
0 O |   |   
  ---------
1   | X |   
  ---------
2   |   |   

...

현재 보드:
  0   1   2
0 O | X | O
  ---------
1 X | X | X
  ---------
2 O |   |   

플레이어 X가 승리했습니다!
```

### 예제 4-2: Conway의 생명 게임

```java
import java.util.Random;

public class GameOfLifeExample {
    private boolean[][] grid;
    private int rows, cols;
    
    public GameOfLifeExample(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }
    
    public static void main(String[] args) {
        GameOfLifeExample game = new GameOfLifeExample(10, 20);
        
        System.out.println("=== Conway의 생명 게임 ===");
        
        // 글라이더 패턴 설정
        game.setGliderPattern(1, 1);
        
        // 5세대 진화 시뮬레이션
        for (int generation = 0; generation < 5; generation++) {
            System.out.println("세대 " + generation + ":");
            game.printGrid();
            System.out.println();
            
            game.nextGeneration();
            
            // 잠시 대기 (시각적 효과)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("세대 5:");
        game.printGrid();
    }
    
    public void setCell(int row, int col, boolean alive) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = alive;
        }
    }
    
    public void setGliderPattern(int startRow, int startCol) {
        // 글라이더 패턴:
        //  .X.
        //  ..X
        //  XXX
        setCell(startRow, startCol + 1, true);
        setCell(startRow + 1, startCol + 2, true);
        setCell(startRow + 2, startCol, true);
        setCell(startRow + 2, startCol + 1, true);
        setCell(startRow + 2, startCol + 2, true);
    }
    
    // TODO: 다음 세대 계산 메서드를 작성하세요
    // 모든 셀을 검사하여 생명 게임 규칙 적용
    public void nextGeneration() {
        
    }
    
    // TODO: 주변 이웃 개수 세기 메서드를 작성하세요
    // 8방향 이웃 셀 중 살아있는 셀의 개수 반환
    private int countNeighbors(int row, int col) {
        
    }
    
    // TODO: 격자 출력 메서드를 작성하세요
    // 살아있는 셀은 ●, 죽은 셀은 ○로 출력
    public void printGrid() {
        
    }
    
    // TODO: 랜덤 초기화 메서드를 작성하세요
    // 주어진 확률로 각 셀을 살아있게 설정
    public void randomize(double probability) {
        
    }
}
```

**실행 결과:**
```
=== Conway의 생명 게임 ===
세대 0:
○●○○○○○○○○○○○○○○○○○○
○○○○○○○○○○○○○○○○○○○○
●●●○○○○○○○○○○○○○○○○○
○○○○○○○○○○○○○○○○○○○○
○○○○○○○○○○○○○○○○○○○○
...

세대 1:
○○○○○○○○○○○○○○○○○○○○
○●○○○○○○○○○○○○○○○○○○
○●●○○○○○○○○○○○○○○○○○
○●○○○○○○○○○○○○○○○○○○
○○○○○○○○○○○○○○○○○○○○
...

세대 5:
○○○○○○○○○○○○○○○○○○○○
○○○○○○○○○○○○○○○○○○○○
○○○○●○○○○○○○○○○○○○○○
○○○○○●○○○○○○○○○○○○○○
○○○●●●○○○○○○○○○○○○○○
○○○○○○○○○○○○○○○○○○○○
```

## 5. 대칭 행렬 구현 예제

### 예제 5-1: 효율적인 대칭 행렬

```java
public class SymmetricMatrixExample {
    
    // 대칭 행렬 클래스
    static class SymmetricMatrix {
        private double[][] data;  // 삼각형 배열로 저장
        private int size;
        
        // TODO: 생성자를 작성하세요
        // 삼각형 모양의 2차원 배열 생성 (메모리 절약)
        public SymmetricMatrix(int size) {
            
        }
        
        // TODO: 값 조회 메서드를 작성하세요
        // 대칭성을 이용하여 올바른 위치에서 값 반환
        public double get(int row, int col) {
            
        }
        
        // TODO: 값 설정 메서드를 작성하세요
        // 대칭성을 이용하여 올바른 위치에 값 저장
        public void set(int row, int col, double value) {
            
        }
        
        public int getSize() {
            return size;
        }
        
        // TODO: 행렬 출력 메서드를 작성하세요
        // 전체 대칭 행렬을 보기 좋게 출력
        public void printMatrix() {
            
        }
        
        // TODO: 저장 정보 출력 메서드를 작성하세요
        // 실제 저장된 요소 개수와 메모리 절약량 출력
        public void printStorageInfo() {
            
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 대칭 행렬 예제 ===");
        
        // 5x5 대칭 행렬 생성
        SymmetricMatrix matrix = new SymmetricMatrix(5);
        
        // 값 설정 (대칭으로 자동 저장됨)
        matrix.set(0, 0, 1.0);
        matrix.set(0, 1, 2.0);
        matrix.set(0, 2, 3.0);
        matrix.set(1, 1, 4.0);
        matrix.set(1, 2, 5.0);
        matrix.set(1, 3, 6.0);
        matrix.set(2, 2, 7.0);
        matrix.set(2, 3, 8.0);
        matrix.set(2, 4, 9.0);
        matrix.set(3, 3, 10.0);
        matrix.set(3, 4, 11.0);
        matrix.set(4, 4, 12.0);
        
        System.out.println("대칭 행렬:");
        matrix.printMatrix();
        
        System.out.println();
        matrix.printStorageInfo();
        
        // 대칭성 확인
        System.out.println("\n=== 대칭성 확인 ===");
        System.out.println("matrix[1][3] = " + matrix.get(1, 3));
        System.out.println("matrix[3][1] = " + matrix.get(3, 1));
        System.out.println("대칭? " + (matrix.get(1, 3) == matrix.get(3, 1)));
        
        // 상관관계 행렬 예제
        System.out.println("\n=== 상관관계 행렬 예제 ===");
        SymmetricMatrix correlation = createCorrelationMatrix();
        correlation.printMatrix();
    }
    
    public static SymmetricMatrix createCorrelationMatrix() {
        // 5개 변수간의 상관관계 행렬 (예시)
        SymmetricMatrix corr = new SymmetricMatrix(5);
        
        // 대각선은 1.0 (자기 자신과의 상관관계)
        for (int i = 0; i < 5; i++) {
            corr.set(i, i, 1.0);
        }
        
        // 상관관계 값들 설정
        corr.set(0, 1, 0.85);
        corr.set(0, 2, 0.72);
        corr.set(0, 3, 0.43);
        corr.set(0, 4, 0.67);
        corr.set(1, 2, 0.91);
        corr.set(1, 3, 0.58);
        corr.set(1, 4, 0.74);
        corr.set(2, 3, 0.39);
        corr.set(2, 4, 0.82);
        corr.set(3, 4, 0.51);
        
        return corr;
    }
}
```

**실행 결과:**
```
=== 대칭 행렬 예제 ===
대칭 행렬:
    1.00    2.00    3.00    0.00    0.00
    2.00    4.00    5.00    6.00    0.00
    3.00    5.00    7.00    8.00    9.00
    0.00    6.00    8.00   10.00   11.00
    0.00    0.00    9.00   11.00   12.00

=== 저장 정보 ===
행렬 크기: 5x5
전체 요소 수: 25
실제 저장된 요소 수: 15
메모리 절약률: 40.0%

=== 대칭성 확인 ===
matrix[1][3] = 6.0
matrix[3][1] = 6.0
대칭? true

=== 상관관계 행렬 예제 ===
    1.00    0.85    0.72    0.43    0.67
    0.85    1.00    0.91    0.58    0.74
    0.72    0.91    1.00    0.39    0.82
    0.43    0.58    0.39    1.00    0.51
    0.67    0.74    0.82    0.51    1.00
```

## 6. 성능 비교 예제

### 예제 6-1: 일차원 vs 이차원 배열 성능

```java
public class ArrayPerformanceExample {
    public static void main(String[] args) {
        int size = 1000;
        
        // 이차원 배열
        int[][] array2D = new int[size][size];
        
        // 일차원 배열 (같은 크기)
        int[] array1D = new int[size * size];
        
        System.out.println("=== 배열 성능 비교 ===");
        System.out.println("배열 크기: " + size + "x" + size);
        
        // TODO: 이차원 배열 초기화 시간을 측정하세요
        // System.nanoTime()을 사용하여 시작과 끝 시간 기록
        long start = System.nanoTime();
        
        long time2D = System.nanoTime() - start;
        
        // TODO: 일차원 배열 초기화 시간을 측정하세요
        start = System.nanoTime();
        
        long time1D = System.nanoTime() - start;
        
        System.out.println("초기화 시간:");
        System.out.printf("이차원 배열: %.2f ms\n", time2D / 1_000_000.0);
        System.out.printf("일차원 배열: %.2f ms\n", time1D / 1_000_000.0);
        System.out.printf("성능 비율: %.2fx\n", (double)time2D / time1D);
        
        // 순회 성능 비교
        compareTraversalMethods(array2D);
        
        // 메모리 사용량 정보
        printMemoryInfo(size);
    }
    
    // TODO: 순회 방법별 성능 비교 메서드를 작성하세요
    // 행 우선, 열 우선, enhanced for 순회의 성능 측정
    public static void compareTraversalMethods(int[][] array) {
        
    }
    
    // TODO: 메모리 사용량 정보 출력 메서드를 작성하세요
    // 이차원 배열의 메모리 사용량과 오버헤드 계산
    public static void printMemoryInfo(int size) {
        
    }
}
```

**실행 결과:**
```
=== 배열 성능 비교 ===
배열 크기: 1000x1000
초기화 시간:
이차원 배열: 12.45 ms
일차원 배열: 8.23 ms
성능 비율: 1.51x

=== 순회 방법별 성능 비교 ===
행 우선 순회: 3.21 ms (합계: 499500000)
열 우선 순회: 15.67 ms (합계: 499500000)
Enhanced for: 2.89 ms (합계: 499500000)
행 우선이 열 우선보다 4.88배 빠름

=== 메모리 사용 정보 ===
데이터 크기: 3 MB
참조 오버헤드: 7 KB
총 메모리 사용량: 3.81 MB
```

## 요약

이 예제들을 통해 이차원 배열의 다음 개념들을 학습할 수 있습니다:

### 핵심 개념
1. **기본 구조**: 생성, 초기화, 접근 방법
2. **순회 패턴**: 행 우선, 열 우선, 대각선, 나선형
3. **배열 연산**: 덧셈, 전치, 곱셈, 통계 계산
4. **실제 활용**: 성적 관리, 이미지 처리, 게임 보드

### 실무 기술
1. **효율적인 저장**: 대칭 행렬, 희소 행렬
2. **성능 최적화**: 순회 방법별 성능 차이
3. **메모리 관리**: 가변 길이 배열, 메모리 사용량
4. **알고리즘 구현**: 게임 로직, 시뮬레이션

💡 **다음 단계**: 이 예제들을 기반으로 더 복잡한 알고리즘(동적 프로그래밍, 그래프 알고리즘)과 자료구조(트리, 그래프)를 학습할 수 있습니다!