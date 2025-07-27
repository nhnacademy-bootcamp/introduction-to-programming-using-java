# 7.6 이차원 배열 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 이차원 배열의 개념과 구조를 이해한다
- 이차원 배열을 생성하고 초기화한다
- 중첩 반복문을 사용하여 이차원 배열을 처리한다
- 이차원 배열을 활용한 실제 프로그램을 작성한다
- 게임과 시뮬레이션에서 이차원 배열을 활용한다

## 1. 이차원 배열이란?

### 1.1 이차원 배열의 개념

이차원 배열은 **행(row)과 열(column)로 구성된 격자 모양의 데이터 구조**입니다.

```java
// 3행 4열의 정수 이차원 배열
int[][] numbers = new int[3][4];

// 시각적 표현:
//     0열  1열  2열  3열
// 0행 [ 0][ 0][ 0][ 0]
// 1행 [ 0][ 0][ 0][ 0]  
// 2행 [ 0][ 0][ 0][ 0]
```

### 1.2 실생활에서의 예시

- **게임 보드**: 체스판, 바둑판, 틱택토
- **좌석 배치**: 극장, 교실, 버스
- **이미지**: 픽셀의 격자
- **표 데이터**: 성적표, 달력, 스프레드시트

```java
// 학급 성적표 예시
double[][] scores = new double[30][5]; // 30명 학생, 5과목
//     국어  영어  수학  과학  사회
// 학생0 [85][92][78][88][90]
// 학생1 [90][85][95][92][87]
// ...
```

## 2. 이차원 배열 생성과 초기화

### 2.1 배열 선언과 생성

```java
// 방법 1: 선언 후 생성
int[][] array;
array = new int[3][4];  // 3행 4열

// 방법 2: 선언과 동시에 생성
int[][] array = new int[3][4];

// 방법 3: 다른 타입의 이차원 배열
String[][] names = new String[2][3];
boolean[][] flags = new boolean[5][5];
double[][] matrix = new double[10][10];
```

### 2.2 배열 초기화

```java
// 방법 1: 초기화 리스트 사용
int[][] numbers = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// 방법 2: 나중에 초기화
int[][] matrix = new int[][] {
    {1, 0, -1},
    {0, 1, 0},
    {-1, 0, 1}
};

// 방법 3: 개별 요소 초기화
int[][] data = new int[2][3];
data[0][0] = 10;
data[0][1] = 20;
data[1][2] = 30;
```

### 2.3 이차원 배열 접근

```java
int[][] scores = {
    {85, 92, 78},
    {90, 85, 95},
    {88, 91, 87}
};

// 요소 읽기
int firstScore = scores[0][0];  // 85
int lastScore = scores[2][2];   // 87

// 요소 수정
scores[1][1] = 100;  // 두 번째 행, 두 번째 열을 100으로 변경

// 배열 크기 확인
int rows = scores.length;        // 행의 수: 3
int cols = scores[0].length;     // 열의 수: 3
```

## 3. 이차원 배열의 내부 구조

### 3.1 Java에서의 이차원 배열 구조

Java의 이차원 배열은 실제로는 **"배열의 배열"**입니다.

```java
int[][] matrix = new int[3][4];

// 실제 메모리 구조:
// matrix → [참조0] [참조1] [참조2]
//             ↓       ↓       ↓
//         [0][0][0][0] [0][0][0][0] [0][0][0][0]
//         0행 배열      1행 배열      2행 배열
```

### 3.2 가변 길이 배열

각 행의 길이가 다를 수 있습니다.

```java
// 삼각형 모양의 배열 생성
int[][] triangle = new int[4][];  // 4개의 행만 생성
triangle[0] = new int[1];  // 첫 번째 행: 1개 요소
triangle[1] = new int[2];  // 두 번째 행: 2개 요소
triangle[2] = new int[3];  // 세 번째 행: 3개 요소
triangle[3] = new int[4];  // 네 번째 행: 4개 요소

// 결과:
// triangle[0]: [0]
// triangle[1]: [0][0]
// triangle[2]: [0][0][0]
// triangle[3]: [0][0][0][0]
```

### 3.3 대칭 행렬 구현 예제

```java
public class SymmetricMatrix {
    private double[][] data;  // 삼각형 배열로 저장
    
    public SymmetricMatrix(int size) {
        data = new double[size][];
        for (int i = 0; i < size; i++) {
            data[i] = new double[i + 1];  // 각 행의 크기를 증가
        }
    }
    
    public double get(int row, int col) {
        if (row >= col) {
            return data[row][col];
        } else {
            return data[col][row];  // 대칭성 이용
        }
    }
    
    public void set(int row, int col, double value) {
        if (row >= col) {
            data[row][col] = value;
        } else {
            data[col][row] = value;  // 대칭성 이용
        }
    }
}
```

## 4. 이차원 배열 순회

### 4.1 중첩 반복문 사용

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// 모든 요소 출력
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        System.out.print(matrix[row][col] + " ");
    }
    System.out.println();  // 행 끝에서 줄바꿈
}

// 출력 결과:
// 1 2 3 
// 4 5 6 
// 7 8 9 
```

### 4.2 Enhanced For Loop 사용

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// 각 행을 순회
for (int[] row : matrix) {
    // 각 행의 요소를 순회
    for (int element : row) {
        System.out.print(element + " ");
    }
    System.out.println();
}
```

### 4.3 다양한 순회 방법

```java
public class Array2DTraversal {
    public static void printMatrix(int[][] matrix) {
        // 행 우선 순회
        System.out.println("행 우선 순회:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void printColumnMajor(int[][] matrix) {
        // 열 우선 순회
        System.out.println("열 우선 순회:");
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void printDiagonal(int[][] matrix) {
        // 대각선 요소만 출력
        System.out.println("대각선 요소:");
        for (int i = 0; i < matrix.length && i < matrix[0].length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }
}
```

## 5. 이차원 배열 활용 예제

### 5.1 성적 관리 시스템

```java
public class GradeManager {
    private double[][] scores;  // [학생][과목]
    private String[] studentNames;
    private String[] subjectNames;
    
    public GradeManager(int studentCount, int subjectCount) {
        scores = new double[studentCount][subjectCount];
        studentNames = new String[studentCount];
        subjectNames = new String[subjectCount];
    }
    
    // 성적 입력
    public void setScore(int student, int subject, double score) {
        if (isValidIndex(student, subject)) {
            scores[student][subject] = score;
        }
    }
    
    // 학생별 평균 계산
    public double getStudentAverage(int student) {
        if (student < 0 || student >= scores.length) {
            return 0;
        }
        
        double sum = 0;
        for (int subject = 0; subject < scores[student].length; subject++) {
            sum += scores[student][subject];
        }
        return sum / scores[student].length;
    }
    
    // 과목별 평균 계산
    public double getSubjectAverage(int subject) {
        if (subject < 0 || subject >= scores[0].length) {
            return 0;
        }
        
        double sum = 0;
        for (int student = 0; student < scores.length; student++) {
            sum += scores[student][subject];
        }
        return sum / scores.length;
    }
    
    // 최고 점수 찾기
    public double findMaxScore() {
        double max = scores[0][0];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] > max) {
                    max = scores[i][j];
                }
            }
        }
        return max;
    }
    
    private boolean isValidIndex(int student, int subject) {
        return student >= 0 && student < scores.length &&
               subject >= 0 && subject < scores[0].length;
    }
}
```

### 5.2 이미지 처리 시뮬레이션

```java
public class ImageProcessor {
    private int[][] pixels;  // 흑백 이미지 (0-255)
    
    public ImageProcessor(int width, int height) {
        pixels = new int[height][width];
    }
    
    // 이미지 반전
    public void invert() {
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                pixels[row][col] = 255 - pixels[row][col];
            }
        }
    }
    
    // 이미지 회전 (90도 시계방향)
    public ImageProcessor rotate90() {
        int rows = pixels.length;
        int cols = pixels[0].length;
        
        ImageProcessor rotated = new ImageProcessor(rows, cols);
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotated.pixels[col][rows - 1 - row] = pixels[row][col];
            }
        }
        
        return rotated;
    }
    
    // 블러 효과 (간단한 평균 필터)
    public void blur() {
        int[][] original = copyArray();
        
        for (int row = 1; row < pixels.length - 1; row++) {
            for (int col = 1; col < pixels[row].length - 1; col++) {
                int sum = 0;
                // 3x3 영역의 평균 계산
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        sum += original[row + dr][col + dc];
                    }
                }
                pixels[row][col] = sum / 9;
            }
        }
    }
    
    private int[][] copyArray() {
        int[][] copy = new int[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                copy[i][j] = pixels[i][j];
            }
        }
        return copy;
    }
}
```

## 6. 게임 보드 구현

### 6.1 틱택토 게임

```java
public class TicTacToe {
    private char[][] board;
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    
    public TicTacToe() {
        board = new char[3][3];
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
    }
    
    // 말 놓기
    public boolean makeMove(int row, int col, char player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            return true;
        }
        return false;
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && 
               col >= 0 && col < 3 && 
               board[row][col] == EMPTY;
    }
    
    // 승리 조건 확인
    public char checkWinner() {
        // 행 확인
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != EMPTY && 
                board[row][0] == board[row][1] && 
                board[row][1] == board[row][2]) {
                return board[row][0];
            }
        }
        
        // 열 확인
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != EMPTY && 
                board[0][col] == board[1][col] && 
                board[1][col] == board[2][col]) {
                return board[0][col];
            }
        }
        
        // 대각선 확인
        if (board[0][0] != EMPTY && 
            board[0][0] == board[1][1] && 
            board[1][1] == board[2][2]) {
            return board[0][0];
        }
        
        if (board[0][2] != EMPTY && 
            board[0][2] == board[1][1] && 
            board[1][1] == board[2][0]) {
            return board[0][2];
        }
        
        return EMPTY;  // 승자 없음
    }
    
    // 보드 출력
    public void printBoard() {
        System.out.println("  0   1   2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) System.out.print(" | ");
            }
            System.out.println();
            if (row < 2) System.out.println("  ---------");
        }
    }
}
```

### 6.2 Conway's Game of Life

```java
public class GameOfLife {
    private boolean[][] grid;
    private int rows, cols;
    
    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }
    
    // 셀 상태 설정
    public void setCell(int row, int col, boolean alive) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = alive;
        }
    }
    
    // 다음 세대 계산
    public void nextGeneration() {
        boolean[][] nextGrid = new boolean[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int neighbors = countNeighbors(row, col);
                
                if (grid[row][col]) {
                    // 살아있는 셀: 2-3개 이웃이면 생존
                    nextGrid[row][col] = (neighbors == 2 || neighbors == 3);
                } else {
                    // 죽은 셀: 3개 이웃이면 탄생
                    nextGrid[row][col] = (neighbors == 3);
                }
            }
        }
        
        grid = nextGrid;
    }
    
    // 이웃 수 계산
    private int countNeighbors(int row, int col) {
        int count = 0;
        
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;  // 자기 자신 제외
                
                int newRow = row + dr;
                int newCol = col + dc;
                
                // 경계 처리 (토로이달 구조)
                newRow = (newRow + rows) % rows;
                newCol = (newCol + cols) % cols;
                
                if (grid[newRow][newCol]) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // 그리드 출력
    public void printGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(grid[row][col] ? "●" : "○");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // 랜덤 초기화
    public void randomize(double probability) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = Math.random() < probability;
            }
        }
    }
}
```

## 7. 이차원 배열 유틸리티 메서드

### 7.1 배열 복사

```java
public class Array2DUtils {
    // 이차원 배열 전체 복사
    public static int[][] copyArray(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = new int[original[i].length];
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
    
    // Arrays.copyOf를 사용한 행별 복사
    public static int[][] copyArrayEfficient(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = java.util.Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
    
    // 배열 비교
    public static boolean areEqual(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length) return false;
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) return false;
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }
    
    // 배열 출력
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }
}
```

### 7.2 행렬 연산

```java
public class Matrix {
    private double[][] data;
    
    public Matrix(int rows, int cols) {
        data = new double[rows][cols];
    }
    
    public Matrix(double[][] data) {
        this.data = new double[data.length][];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i].clone();
        }
    }
    
    // 행렬 덧셈
    public Matrix add(Matrix other) {
        if (data.length != other.data.length || 
            data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("행렬 크기가 다릅니다");
        }
        
        Matrix result = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }
    
    // 행렬 곱셈
    public Matrix multiply(Matrix other) {
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException("행렬 곱셈이 불가능합니다");
        }
        
        Matrix result = new Matrix(data.length, other.data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < other.data[0].length; j++) {
                for (int k = 0; k < data[0].length; k++) {
                    result.data[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }
    
    // 전치 행렬
    public Matrix transpose() {
        Matrix result = new Matrix(data[0].length, data.length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[j][i] = data[i][j];
            }
        }
        return result;
    }
}
```

## 8. 실무 활용 팁

### 8.1 메모리 효율성

```java
// 큰 배열을 다룰 때 메모리 고려사항
public class MemoryEfficientArray {
    
    // 희소 행렬 (sparse matrix) - 대부분이 0인 경우
    private static class SparseMatrix {
        private Map<String, Double> nonZeroElements;
        private int rows, cols;
        
        public SparseMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.nonZeroElements = new HashMap<>();
        }
        
        public void set(int row, int col, double value) {
            if (value != 0) {
                nonZeroElements.put(row + "," + col, value);
            } else {
                nonZeroElements.remove(row + "," + col);
            }
        }
        
        public double get(int row, int col) {
            return nonZeroElements.getOrDefault(row + "," + col, 0.0);
        }
    }
}
```

### 8.2 경계 검사

```java
public class SafeArray2D {
    private int[][] data;
    
    public SafeArray2D(int rows, int cols) {
        data = new int[rows][cols];
    }
    
    // 안전한 접근 메서드
    public boolean set(int row, int col, int value) {
        if (isValidIndex(row, col)) {
            data[row][col] = value;
            return true;
        }
        return false;
    }
    
    public int get(int row, int col) {
        if (isValidIndex(row, col)) {
            return data[row][col];
        }
        throw new IndexOutOfBoundsException(
            String.format("인덱스 [%d][%d]는 유효하지 않습니다", row, col));
    }
    
    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < data.length && 
               col >= 0 && col < data[0].length;
    }
}
```

## 요약

### 핵심 포인트

1. **이차원 배열 구조**:
   - Java에서는 "배열의 배열"로 구현
   - `dataType[][]` 형식으로 선언
   - 각 행이 별도의 배열 객체

2. **생성과 초기화**:
   - `new type[rows][cols]` 형식으로 생성
   - 초기화 리스트 사용 가능
   - 가변 길이 배열 생성 가능

3. **순회 방법**:
   - 중첩 for 루프 사용
   - Enhanced for loop 활용
   - 행 우선 vs 열 우선 순회

4. **활용 분야**:
   - 게임 보드 (체스, 틱택토)
   - 이미지 처리
   - 행렬 연산
   - 시뮬레이션 (생명 게임)

5. **주의사항**:
   - 배열 경계 확인 중요
   - 메모리 사용량 고려
   - null 포인터 예외 주의

💡 **기억하세요**: 이차원 배열은 표 형태의 데이터를 다루는 강력한 도구입니다. 게임, 시뮬레이션, 데이터 분석 등 다양한 분야에서 활용할 수 있습니다!