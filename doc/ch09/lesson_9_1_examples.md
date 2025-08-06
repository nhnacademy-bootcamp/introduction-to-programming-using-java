# 9.1 재귀(Recursion) - 예제 모음

## 1. 기초 재귀 예제들

### 예제 1-1: 팩토리얼 계산

```java
public class FactorialExample {
    
    /**
     * 재귀를 사용한 팩토리얼 계산
     * n! = n × (n-1) × (n-2) × ... × 1
     */
    public static long factorial(int n) {
        // TODO 1: 입력 검증 - n이 음수인 경우 IllegalArgumentException 던지기
        
        // TODO 2: 기저 사례 구현
        // 힌트: 0! = 1, 1! = 1
        
        // TODO 3: 재귀 사례 구현
        // 힌트: n! = n × (n-1)!
        
        return 0; // 임시 반환값
    }
    
    /**
     * 재귀 과정을 시각화하는 팩토리얼
     */
    public static long factorialWithTrace(int n, String indent) {
        System.out.println(indent + "factorial(" + n + ") 계산 시작");
        
        // TODO: 기저 사례와 재귀 사례를 구현하면서 각 단계를 출력
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        System.out.println("=== 팩토리얼 예제 ===");
        
        // 실행 결과:
        // 0! = 1
        // 1! = 1
        // 2! = 2
        // 3! = 6
        // 4! = 24
        // 5! = 120
        
        System.out.println("\n=== 재귀 과정 추적 ===");
        // factorial(4) 계산 시작
        //   factorial(3) 계산 시작
        //     factorial(2) 계산 시작
        //       factorial(1) 계산 시작
        //       기저 사례: factorial(1) = 1
        //     factorial(2) = 2 × 1 = 2
        //   factorial(3) = 3 × 2 = 6
        // factorial(4) = 4 × 6 = 24
    }
}
```

### 예제 1-2: 피보나치 수열

```java
public class FibonacciExample {
    
    /**
     * 기본 재귀 피보나치 (비효율적)
     * F(n) = F(n-1) + F(n-2)
     */
    public static long fibonacciSimple(int n) {
        // TODO 1: 기저 사례 구현
        // 힌트: F(0) = 0, F(1) = 1
        
        // TODO 2: 재귀 사례 구현
        // 힌트: F(n) = F(n-1) + F(n-2)
        
        return 0; // 임시 반환값
    }
    
    /**
     * 메모이제이션을 사용한 효율적인 재귀 피보나치
     */
    public static long fibonacciMemo(int n) {
        long[] memo = new long[n + 1];
        return fibonacciMemoHelper(n, memo);
    }
    
    private static long fibonacciMemoHelper(int n, long[] memo) {
        // TODO 1: 기저 사례
        
        // TODO 2: 이미 계산된 값이 있는지 확인
        // 힌트: memo[n] != 0이면 이미 계산됨
        
        // TODO 3: 계산 후 메모에 저장
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        System.out.println("=== 피보나치 수열 예제 ===");
        
        // 실행 결과:
        // F(0) = 0
        // F(1) = 1
        // F(2) = 1
        // F(3) = 2
        // F(4) = 3
        // F(5) = 5
        // F(6) = 8
        // F(7) = 13
        // F(8) = 21
        // F(9) = 34
        
        System.out.println("\n=== 성능 비교 ===");
        // F(20) 계산:
        // 단순 재귀: 6765 (약 10ms, 21891회 호출)
        // 메모이제이션: 6765 (약 0.1ms)
    }
}
```

### 예제 1-3: 문자열 뒤집기

```java
public class StringReverseExample {
    
    /**
     * 재귀를 사용한 문자열 뒤집기
     */
    public static String reverseString(String str) {
        // TODO 1: 기저 사례 구현
        // 힌트: 빈 문자열 또는 한 글자인 경우 그대로 반환
        
        // TODO 2: 재귀 사례 구현
        // 힌트: 첫 글자를 맨 뒤로 보내고, 나머지는 재귀적으로 뒤집기
        // str.substring(1) - 첫 글자를 제외한 나머지
        // str.charAt(0) - 첫 글자
        
        return ""; // 임시 반환값
    }
    
    /**
     * 회문(palindrome) 검사
     */
    public static boolean isPalindrome(String str) {
        // 전처리: 소문자 변환, 공백/특수문자 제거
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isPalindromeHelper(cleaned, 0, cleaned.length() - 1);
    }
    
    private static boolean isPalindromeHelper(String str, int left, int right) {
        // TODO 1: 기저 사례 - 포인터가 만나거나 교차
        
        // TODO 2: 양 끝 문자가 다르면 false
        
        // TODO 3: 재귀 호출 - 한 칸씩 안쪽으로
        
        return false; // 임시 반환값
    }
    
    public static void main(String[] args) {
        System.out.println("=== 문자열 뒤집기 예제 ===");
        
        // 실행 결과:
        // "hello" → "olleh"
        // "Java" → "avaJ"
        // "recursion" → "noisrucer"
        // "a" → "a"
        // "" → ""
        
        System.out.println("\n=== 회문 검사 ===");
        // "racecar" → 회문
        // "A man a plan a canal Panama" → 회문
        // "race a car" → 회문 아님
        // "hello" → 회문 아님
    }
}
```

## 2. 고급 재귀 예제들

### 예제 2-1: 재귀적 이진 탐색

```java
public class BinarySearchExample {
    
    /**
     * 재귀적 이진 탐색 - 인덱스 반환
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // TODO 1: 기저 사례 - 탐색 범위가 유효하지 않은 경우
        // 힌트: left > right인 경우 -1 반환
        
        // TODO 2: 중간 인덱스 계산
        // 힌트: left + (right - left) / 2 사용 (오버플로우 방지)
        int mid = 0; // TODO: 계산하기
        
        // TODO 3: 기저 사례 - 값을 찾은 경우
        // 힌트: arr[mid]가 target과 같으면 mid 반환
        
        // TODO 4: 재귀 사례 - 왼쪽 또는 오른쪽 절반 탐색
        // 힌트: target < arr[mid]이면 왼쪽 절반 탐색
        //      그렇지 않으면 오른쪽 절반 탐색
        
        return -1; // 임시 반환값
    }
    
    public static void main(String[] args) {
        System.out.println("=== 재귀적 이진 탐색 예제 ===");
        
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        
        // 실행 결과:
        // 7 찾기: 인덱스 3
        // 15 찾기: 인덱스 7
        // 1 찾기: 인덱스 0
        // 19 찾기: 인덱스 9
        // 4 찾기: 찾지 못함
        // 20 찾기: 찾지 못함
    }
}
```

### 예제 2-2: 하노이의 탑

```java
public class TowersOfHanoi {
    
    private static int moveCount = 0;
    
    /**
     * 기본 하노이의 탑 해결
     */
    public static void hanoi(int n, char from, char to, char aux) {
        // TODO 1: 기저 사례 - n이 1인 경우
        // 힌트: 원반 1개를 from에서 to로 직접 이동
        
        // TODO 2: 재귀 사례 - 3단계로 해결
        // 단계 1: 위쪽 n-1개를 from에서 aux로 이동 (to를 임시로 사용)
        
        // 단계 2: 가장 큰 원반(n번)을 from에서 to로 이동
        
        // 단계 3: aux에 있는 n-1개를 to로 이동 (from을 임시로 사용)
    }
    
    public static void main(String[] args) {
        System.out.println("=== 하노이의 탑 예제 ===");
        
        // 3개 원반 실행 결과:
        // 이동 1: 원반 1을 A에서 C로
        // 이동 2: 원반 2를 A에서 B로
        // 이동 3: 원반 1을 C에서 B로
        // 이동 4: 원반 3을 A에서 C로
        // 이동 5: 원반 1을 B에서 A로
        // 이동 6: 원반 2를 B에서 C로
        // 이동 7: 원반 1을 A에서 C로
        // 총 7번의 이동 (이론값: 7)
    }
}
```

### 예제 2-3: 재귀적 퀵정렬

```java
public class QuickSortExample {
    
    /**
     * 기본 퀵정렬
     */
    public static void quickSort(int[] arr, int low, int high) {
        // TODO 1: 재귀 조건 확인
        // 힌트: low < high인 경우에만 진행
        
        // TODO 2: 분할(partition) 수행
        // int pivotIndex = partition(arr, low, high);
        
        // TODO 3: 피벗 기준으로 양쪽 재귀 호출
    }
    
    /**
     * 분할 함수 (Lomuto partition)
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        // TODO: 분할 로직 구현
        // 힌트: pivot보다 작은 요소는 왼쪽으로
        
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 퀵정렬 예제 ===");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // 실행 결과:
        // 원본: [64, 34, 25, 12, 22, 11, 90]
        // 정렬: [11, 12, 22, 25, 34, 64, 90]
    }
}
```

### 예제 2-4: Blob 카운팅

```java
public class BlobCounting {
    
    private static boolean[][] visited;
    
    /**
     * 4방향 연결 blob 크기 계산
     */
    public static int getBlobSize4(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // TODO 1: 경계 체크 및 기저 사례
        // 힌트: 범위를 벗어나거나, 이미 방문했거나, 0인 경우
        
        // TODO 2: 현재 위치 방문 표시
        
        // TODO 3: 4방향 재귀 호출
        // 힌트: 위, 아래, 왼쪽, 오른쪽
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        System.out.println("=== Blob 카운팅 예제 ===");
        
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };
        
        // 실행 결과:
        // (0,0) 위치의 blob 크기: 5
        // (2,4) 위치의 blob 크기: 4
        // (3,0) 위치의 blob 크기: 2
    }
}
```

## 3. 재귀 최적화 예제

### 예제 3-1: 꼬리 재귀 최적화

```java
public class TailRecursion {
    
    /**
     * 일반 재귀 팩토리얼
     */
    public static long factorialNormal(int n) {
        if (n <= 1) return 1;
        return n * factorialNormal(n - 1);
    }
    
    /**
     * 꼬리 재귀 팩토리얼
     */
    public static long factorialTail(int n) {
        return factorialTailHelper(n, 1);
    }
    
    private static long factorialTailHelper(int n, long acc) {
        // TODO: 꼬리 재귀 구현
        // 힌트: 누적값(acc)을 사용하여 계산
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        System.out.println("=== 꼬리 재귀 예제 ===");
        
        // 실행 결과:
        // 일반 재귀: 5! = 120
        // 꼬리 재귀: 5! = 120
        // (Java는 꼬리 재귀 최적화를 지원하지 않지만, 패턴 이해용)
    }
}
```