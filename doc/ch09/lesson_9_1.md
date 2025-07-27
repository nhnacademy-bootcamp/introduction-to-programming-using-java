# 9.1 재귀(Recursion) - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 재귀의 개념과 동작 원리를 이해한다
- 재귀적 사고를 통해 복잡한 문제를 해결한다
- 기저 사례와 재귀 사례를 구분하여 올바른 재귀 함수를 작성한다
- 이진 탐색, 정렬, 그래프 탐색 등의 고전 알고리즘을 재귀로 구현한다
- 재귀의 장단점을 이해하고 적절한 상황에서 활용한다

## 1. 재귀란 무엇인가?

### 1.1 재귀의 정의

**재귀(Recursion)**는 어떤 문제를 해결하기 위해 **자기 자신을 부분적으로 사용하여 정의하는 방법**입니다.

#### 일상 생활의 재귀적 정의 예시

```
조상의 정의:
- 부모이거나
- 부모의 조상이다

디렉터리의 정의:
- 파일과 다른 디렉터리들을 포함할 수 있는 폴더이다

문장의 정의:
- 단순 문장이거나
- "그리고", "또는" 등으로 연결된 두 개의 문장이다
```

### 1.2 프로그래밍에서의 재귀

**재귀적 서브루틴**은 자신을 직접 또는 간접적으로 호출하는 메서드입니다.

```java
public class RecursionExample {
    
    // 직접 재귀: 메서드가 자기 자신을 호출
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;  // 기저 사례
        }
        return n * factorial(n - 1);  // 재귀 호출
    }
    
    // 간접 재귀: A가 B를 호출하고, B가 A를 호출
    public static boolean isEven(int n) {
        if (n == 0) return true;
        return isOdd(n - 1);
    }
    
    public static boolean isOdd(int n) {
        if (n == 0) return false;
        return isEven(n - 1);
    }
}
```

### 1.3 재귀의 두 가지 핵심 요소

#### 1) 기저 사례(Base Case)
- 재귀를 멈추는 조건
- 더 이상 자기 자신을 호출하지 않고 직접 답을 반환
- **반드시 하나 이상 존재해야 함**

#### 2) 재귀 사례(Recursive Case)
- 문제를 더 작은 문제로 나누어 자기 자신을 호출
- **매번 문제의 크기가 줄어들어야 함**

```java
public static int countdown(int n) {
    // 기저 사례: 0에 도달하면 멈춤
    if (n <= 0) {
        System.out.println("발사!");
        return 0;
    }
    
    // 재귀 사례: 숫자를 출력하고 n-1로 재귀 호출
    System.out.println(n);
    return countdown(n - 1);  // 문제 크기가 1씩 감소
}
```

## 2. 재귀적 이진 탐색

### 2.1 이진 탐색의 재귀적 사고

정렬된 배열에서 값을 찾는 이진 탐색을 재귀적으로 생각해보면:

1. **기저 사례**: 배열이 비어있으면 값이 없음
2. **재귀 사례**: 
   - 중간 값과 비교
   - 찾는 값이 더 작으면 앞쪽 절반에서 재귀 탐색
   - 찾는 값이 더 크면 뒤쪽 절반에서 재귀 탐색

### 2.2 구현

```java
public class RecursiveBinarySearch {
    
    /**
     * 재귀적 이진 탐색
     * @param arr 정렬된 배열
     * @param target 찾을 값
     * @param start 탐색 시작 인덱스
     * @param end 탐색 종료 인덱스
     * @return 값이 있으면 인덱스, 없으면 -1
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {
        // 기저 사례 1: 범위가 유효하지 않음
        if (start > end) {
            return -1;  // 값을 찾지 못함
        }
        
        int middle = (start + end) / 2;
        
        // 기저 사례 2: 값을 찾음
        if (arr[middle] == target) {
            return middle;
        }
        
        // 재귀 사례: 절반씩 나누어 탐색
        if (target < arr[middle]) {
            // 앞쪽 절반에서 탐색
            return binarySearch(arr, target, start, middle - 1);
        } else {
            // 뒤쪽 절반에서 탐색
            return binarySearch(arr, target, middle + 1, end);
        }
    }
    
    // 편의 메서드
    public static int search(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        
        System.out.println("배열: " + java.util.Arrays.toString(numbers));
        System.out.println("7 찾기: " + search(numbers, 7));    // 3
        System.out.println("4 찾기: " + search(numbers, 4));    // -1
        System.out.println("19 찾기: " + search(numbers, 19));  // 9
    }
}
```

### 2.3 재귀 vs 반복문 비교

```java
// 반복문 버전
public static int iterativeBinarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    
    while (start <= end) {
        int middle = (start + end) / 2;
        
        if (arr[middle] == target) {
            return middle;
        } else if (target < arr[middle]) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
    }
    return -1;
}
```

**재귀 버전의 장점:**
- 코드가 문제의 정의와 일치함
- 이해하기 쉬움
- 수학적 증명이 용이함

**반복문 버전의 장점:**
- 메모리 사용량이 적음 (스택 오버플로우 위험 없음)
- 실행 속도가 약간 빠름

## 3. 하노이의 탑 (Towers of Hanoi)

### 3.1 문제 설명

세 개의 기둥과 크기가 다른 n개의 원반이 있습니다:
- 모든 원반은 처음에 첫 번째 기둥에 크기 순으로 쌓여 있음
- 목표: 모든 원반을 세 번째 기둥으로 옮기기
- 규칙:
  1. 한 번에 하나의 원반만 이동 가능
  2. 큰 원반을 작은 원반 위에 놓을 수 없음

### 3.2 재귀적 해결 방법

n개의 원반을 A에서 C로 옮기는 방법:
1. 위쪽 n-1개를 A에서 B로 옮김 (C를 임시 사용)
2. 가장 큰 원반을 A에서 C로 옮김
3. n-1개를 B에서 C로 옮김 (A를 임시 사용)

```java
public class TowersOfHanoi {
    
    /**
     * 하노이의 탑 해결
     * @param n 옮길 원반의 개수
     * @param from 출발 기둥
     * @param to 목표 기둥
     * @param temp 임시 기둥
     */
    public static void towersOfHanoi(int n, char from, char to, char temp) {
        // 기저 사례: 원반이 1개면 바로 옮김
        if (n == 1) {
            System.out.printf("원반 1을 %c에서 %c로 이동%n", from, to);
            return;
        }
        
        // 재귀 사례:
        // 1. 위쪽 n-1개를 목표 기둥을 임시로 사용해서 임시 기둥으로 옮김
        towersOfHanoi(n - 1, from, temp, to);
        
        // 2. 가장 큰 원반을 목표 기둥으로 옮김
        System.out.printf("원반 %d를 %c에서 %c로 이동%n", n, from, to);
        
        // 3. 임시 기둥의 n-1개를 출발 기둥을 임시로 사용해서 목표 기둥으로 옮김
        towersOfHanoi(n - 1, temp, to, from);
    }
    
    public static void main(String[] args) {
        int disks = 4;
        System.out.println(disks + "개 원반 하노이의 탑 해결:");
        towersOfHanoi(disks, 'A', 'C', 'B');
        
        // 필요한 이동 횟수 계산
        int moves = (int)Math.pow(2, disks) - 1;
        System.out.println("총 " + moves + "번의 이동이 필요합니다.");
    }
}
```

### 3.3 하노이의 탑의 복잡도

- **시간 복잡도**: O(2^n) - 지수적 증가
- **공간 복잡도**: O(n) - 재귀 호출 스택
- n개 원반 해결에 **2^n - 1**번의 이동 필요

```java
// 하노이의 탑 이동 횟수를 재귀로 계산
public static long hanoiMoves(int n) {
    if (n == 1) return 1;
    return 2 * hanoiMoves(n - 1) + 1;
}

// 또는 수학 공식 사용
public static long hanoiMovesFormula(int n) {
    return (1L << n) - 1;  // 2^n - 1
}
```

## 4. 재귀적 정렬 알고리즘 - 퀵정렬

### 4.1 퀵정렬의 아이디어

1. **분할(Divide)**: 피벗을 선택하여 배열을 둘로 나눔
2. **정복(Conquer)**: 각 부분을 재귀적으로 정렬
3. **결합(Combine)**: 이미 정렬된 부분들을 합침

### 4.2 구현

```java
public class QuickSort {
    
    /**
     * 퀵정렬 메인 메서드
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗의 최종 위치를 얻음
            int pivotIndex = partition(arr, low, high);
            
            // 피벗 앞부분을 재귀적으로 정렬
            quickSort(arr, low, pivotIndex - 1);
            
            // 피벗 뒷부분을 재귀적으로 정렬
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 배열을 피벗 기준으로 분할
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 마지막 원소를 피벗으로 선택
        int i = low - 1;        // 작은 원소들의 인덱스
        
        for (int j = low; j < high; j++) {
            // 현재 원소가 피벗보다 작거나 같으면
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // 피벗을 올바른 위치에 배치
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // 편의 메서드
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};
        
        System.out.println("정렬 전: " + java.util.Arrays.toString(numbers));
        sort(numbers);
        System.out.println("정렬 후: " + java.util.Arrays.toString(numbers));
    }
}
```

### 4.3 퀵정렬의 성능 분석

- **최선/평균의 경우**: O(n log n)
- **최악의 경우**: O(n²) - 이미 정렬된 배열
- **공간 복잡도**: O(log n) - 재귀 호출 스택

## 5. Blob 개수 세기 (Connected Components)

### 5.1 문제 설명

2차원 격자에서 연결된 채워진 칸들의 그룹(blob)을 찾고 크기를 세는 문제:
- 상하좌우로 인접한 채워진 칸들이 하나의 blob를 구성
- 재귀를 사용하여 각 blob의 크기를 계산

### 5.2 구현

```java
public class BlobCounter {
    private boolean[][] grid;      // 격자 (true = 채워짐, false = 비어있음)
    private boolean[][] visited;   // 방문 여부 체크
    private int rows, cols;
    
    public BlobCounter(boolean[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
    }
    
    /**
     * 특정 위치에서 시작하는 blob의 크기를 계산
     */
    public int getBlobSize(int row, int col) {
        // 경계 체크
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        
        // 이미 방문했거나 채워지지 않은 칸
        if (visited[row][col] || !grid[row][col]) {
            return 0;
        }
        
        // 현재 칸을 방문했다고 표시 (무한 재귀 방지)
        visited[row][col] = true;
        
        // 현재 칸 (1) + 인접한 4방향의 blob 크기들
        int size = 1;
        size += getBlobSize(row - 1, col);  // 위
        size += getBlobSize(row + 1, col);  // 아래
        size += getBlobSize(row, col - 1);  // 왼쪽
        size += getBlobSize(row, col + 1);  // 오른쪽
        
        return size;
    }
    
    /**
     * 모든 blob의 개수를 세기
     */
    public int countBlobs() {
        // visited 배열 초기화
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                visited[r][c] = false;
            }
        }
        
        int blobCount = 0;
        
        // 모든 위치를 확인
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int size = getBlobSize(r, c);
                if (size > 0) {
                    blobCount++;
                    System.out.println("Blob 발견: 위치(" + r + "," + c + 
                                     "), 크기=" + size);
                }
            }
        }
        
        return blobCount;
    }
    
    public static void main(String[] args) {
        // 예제 격자 (true = 채워짐, false = 비어있음)
        boolean[][] grid = {
            {true,  true,  false, false, true },
            {true,  false, true,  false, true },
            {false, true,  true,  false, false},
            {false, false, false, true,  true },
            {true,  false, false, true,  false}
        };
        
        BlobCounter counter = new BlobCounter(grid);
        
        // 격자 출력
        System.out.println("격자 상태 (■ = 채워짐, □ = 비어있음):");
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                System.out.print(grid[r][c] ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println();
        
        int totalBlobs = counter.countBlobs();
        System.out.println("총 blob 개수: " + totalBlobs);
    }
}
```

### 5.3 Blob 개수 세기의 핵심 아이디어

1. **무한 재귀 방지**: `visited` 배열로 이미 방문한 칸 표시
2. **연결성 탐색**: 상하좌우 4방향으로 재귀 호출
3. **경계 처리**: 격자 범위를 벗어나지 않도록 체크

## 6. 재귀 사용 시 주의사항

### 6.1 무한 재귀 방지

```java
// 잘못된 예: 기저 사례가 없음
public static void infiniteRecursion(int n) {
    System.out.println(n);
    infiniteRecursion(n - 1);  // 영원히 계속됨!
}

// 올바른 예: 기저 사례 존재
public static void correctRecursion(int n) {
    if (n <= 0) return;  // 기저 사례
    System.out.println(n);
    correctRecursion(n - 1);
}
```

### 6.2 스택 오버플로우 주의

```java
public class StackOverflowExample {
    public static void main(String[] args) {
        try {
            factorial(10000);  // 스택 오버플로우 발생 가능
        } catch (StackOverflowError e) {
            System.out.println("스택 오버플로우 발생!");
        }
    }
    
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
```

### 6.3 재귀 vs 반복문 선택 기준

**재귀를 사용하면 좋은 경우:**
- 문제가 자연스럽게 작은 문제로 나누어짐
- 트리나 그래프 구조를 다룰 때
- 수학적 정의가 재귀적일 때

**반복문을 사용하면 좋은 경우:**
- 메모리 사용량이 중요할 때
- 깊은 재귀가 예상될 때
- 성능이 매우 중요할 때

## 7. 재귀의 실행 과정 이해

### 7.1 팩토리얼 예제로 보는 재귀 실행

```java
public static int factorial(int n) {
    System.out.println("factorial(" + n + ") 호출");
    
    if (n <= 1) {
        System.out.println("기저 사례: factorial(" + n + ") = 1");
        return 1;
    }
    
    int result = n * factorial(n - 1);
    System.out.println("factorial(" + n + ") = " + result);
    return result;
}
```

**factorial(4) 실행 과정:**
```
factorial(4) 호출
factorial(3) 호출
factorial(2) 호출
factorial(1) 호출
기저 사례: factorial(1) = 1
factorial(2) = 2
factorial(3) = 6
factorial(4) = 24
```

### 7.2 메모리 스택 구조

```
|  factorial(4)  |  n=4, 대기 중
|  factorial(3)  |  n=3, 대기 중
|  factorial(2)  |  n=2, 대기 중
|  factorial(1)  |  n=1, 실행 중 (기저 사례)
+----------------+
```

## 마무리

재귀는 복잡한 문제를 해결하는 강력한 도구입니다. 핵심은:

1. **명확한 기저 사례** 정의
2. **문제 크기 감소** 보장
3. **자연스러운 문제 분할** 찾기

재귀를 마스터하면 트리, 그래프, 분할정복 알고리즘 등 고급 주제를 이해하는 데 큰 도움이 됩니다.