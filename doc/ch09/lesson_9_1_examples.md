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
        // 입력 검증
        if (n < 0) {
            throw new IllegalArgumentException("음수는 팩토리얼을 계산할 수 없습니다.");
        }
        
        // 기저 사례: 0! = 1, 1! = 1
        if (n <= 1) {
            return 1;
        }
        
        // 재귀 사례: n! = n × (n-1)!
        return n * factorial(n - 1);
    }
    
    /**
     * 반복문을 사용한 팩토리얼 계산 (비교용)
     */
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수는 팩토리얼을 계산할 수 없습니다.");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * 재귀 과정을 시각화하는 팩토리얼
     */
    public static long factorialWithTrace(int n, String indent) {
        System.out.println(indent + "factorial(" + n + ") 계산 시작");
        
        if (n <= 1) {
            System.out.println(indent + "기저 사례: factorial(" + n + ") = 1");
            return 1;
        }
        
        long result = n * factorialWithTrace(n - 1, indent + "  ");
        System.out.println(indent + "factorial(" + n + ") = " + n + " × " + 
                          factorial(n-1) + " = " + result);
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 팩토리얼 예제 ===");
        
        // 기본 팩토리얼 계산
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d! = %d%n", i, factorial(i));
        }
        
        System.out.println("\n=== 성능 비교 ===");
        int n = 15;
        
        // 재귀 버전 성능 측정
        long startTime = System.nanoTime();
        long result1 = factorial(n);
        long endTime = System.nanoTime();
        System.out.printf("재귀 버전: %d! = %d (%.2f μs)%n", 
                         n, result1, (endTime - startTime) / 1000.0);
        
        // 반복문 버전 성능 측정
        startTime = System.nanoTime();
        long result2 = factorialIterative(n);
        endTime = System.nanoTime();
        System.out.printf("반복문 버전: %d! = %d (%.2f μs)%n", 
                         n, result2, (endTime - startTime) / 1000.0);
        
        System.out.println("\n=== 재귀 과정 추적 ===");
        factorialWithTrace(5, "");
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
        if (n <= 1) {
            return n;  // F(0) = 0, F(1) = 1
        }
        return fibonacciSimple(n - 1) + fibonacciSimple(n - 2);
    }
    
    /**
     * 메모이제이션을 사용한 효율적인 재귀 피보나치
     */
    public static long fibonacciMemo(int n) {
        long[] memo = new long[n + 1];
        return fibonacciMemoHelper(n, memo);
    }
    
    private static long fibonacciMemoHelper(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        
        // 이미 계산된 값이 있으면 재사용
        if (memo[n] != 0) {
            return memo[n];
        }
        
        // 계산 후 메모에 저장
        memo[n] = fibonacciMemoHelper(n - 1, memo) + 
                  fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * 반복문을 사용한 피보나치 (가장 효율적)
     */
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    
    /**
     * 피보나치 호출 횟수 계산
     */
    private static int callCount = 0;
    
    public static long fibonacciWithCount(int n) {
        callCount++;
        if (n <= 1) {
            return n;
        }
        return fibonacciWithCount(n - 1) + fibonacciWithCount(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 피보나치 수열 예제 ===");
        
        // 피보나치 수열 출력
        System.out.println("첫 15개 피보나치 수:");
        for (int i = 0; i < 15; i++) {
            System.out.printf("F(%d) = %d%n", i, fibonacciMemo(i));
        }
        
        System.out.println("\n=== 성능 비교 ===");
        int[] testCases = {20, 25, 30, 35};
        
        for (int n : testCases) {
            System.out.printf("\nF(%d) 계산:%n", n);
            
            // 메모이제이션 재귀
            long startTime = System.nanoTime();
            long result1 = fibonacciMemo(n);
            long endTime = System.nanoTime();
            System.out.printf("메모이제이션 재귀: %d (%.2f ms)%n", 
                             result1, (endTime - startTime) / 1_000_000.0);
            
            // 반복문
            startTime = System.nanoTime();
            long result2 = fibonacciIterative(n);
            endTime = System.nanoTime();
            System.out.printf("반복문: %d (%.2f ms)%n", 
                             result2, (endTime - startTime) / 1_000_000.0);
            
            // 단순 재귀 (작은 값만 테스트)
            if (n <= 30) {
                callCount = 0;
                startTime = System.nanoTime();
                long result3 = fibonacciWithCount(n);
                endTime = System.nanoTime();
                System.out.printf("단순 재귀: %d (%.2f ms, %d회 호출)%n", 
                                 result3, (endTime - startTime) / 1_000_000.0, callCount);
            }
        }
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
        // 기저 사례: 빈 문자열 또는 한 글자
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        // 재귀 사례: 첫 글자를 맨 뒤로, 나머지는 재귀적으로 뒤집기
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * 더 효율적인 재귀 문자열 뒤집기 (StringBuilder 사용)
     */
    public static String reverseStringOptimized(String str) {
        if (str == null) return null;
        return reverseHelper(str, 0, new StringBuilder());
    }
    
    private static String reverseHelper(String str, int index, StringBuilder sb) {
        if (index >= str.length()) {
            return sb.toString();
        }
        
        return reverseHelper(str, index + 1, sb) + str.charAt(index);
    }
    
    /**
     * 재귀 과정을 보여주는 문자열 뒤집기
     */
    public static String reverseWithTrace(String str, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "reverse(\"" + str + "\") 호출");
        
        if (str == null || str.length() <= 1) {
            System.out.println(indent + "기저 사례: \"" + str + "\" 반환");
            return str;
        }
        
        char firstChar = str.charAt(0);
        String rest = str.substring(1);
        String reversedRest = reverseWithTrace(rest, depth + 1);
        String result = reversedRest + firstChar;
        
        System.out.println(indent + "\"" + str + "\" → \"" + result + "\"");
        return result;
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
        // 기저 사례: 포인터가 만나거나 교차하면 회문
        if (left >= right) {
            return true;
        }
        
        // 양 끝 문자가 다르면 회문 아님
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        
        // 한 칸씩 안쪽으로 이동하여 재귀 호출
        return isPalindromeHelper(str, left + 1, right - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 문자열 뒤집기 예제 ===");
        
        String[] testStrings = {"hello", "Java", "recursion", "a", "", "12345"};
        
        for (String str : testStrings) {
            String reversed = reverseString(str);
            System.out.printf("\"%s\" → \"%s\"%n", str, reversed);
        }
        
        System.out.println("\n=== 재귀 과정 추적 ===");
        reverseWithTrace("hello", 0);
        
        System.out.println("\n=== 회문 검사 ===");
        String[] palindromeTests = {
            "racecar", "A man a plan a canal Panama", 
            "race a car", "hello", "Madam", "12321"
        };
        
        for (String test : palindromeTests) {
            boolean result = isPalindrome(test);
            System.out.printf("\"%s\" → %s%n", test, result ? "회문" : "회문 아님");
        }
    }
}
```

## 2. 고급 재귀 예제들

### 예제 2-1: 완전한 재귀적 이진 탐색

```java
public class CompleteBinarySearch {
    
    /**
     * 재귀적 이진 탐색 - 인덱스 반환
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // 기저 사례: 탐색 범위가 유효하지 않음
        if (left > right) {
            return -1;  // 찾지 못함
        }
        
        int mid = left + (right - left) / 2;  // 오버플로우 방지
        
        // 기저 사례: 값을 찾음
        if (arr[mid] == target) {
            return mid;
        }
        
        // 재귀 사례
        if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }
    
    /**
     * 첫 번째 발생 위치 찾기 (중복값 있을 때)
     */
    public static int findFirst(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        // 값을 찾았지만 더 앞에 있을 수 있는지 확인
        if (arr[mid] == target) {
            int leftResult = findFirst(arr, target, left, mid - 1);
            return leftResult != -1 ? leftResult : mid;
        }
        
        if (target < arr[mid]) {
            return findFirst(arr, target, left, mid - 1);
        } else {
            return findFirst(arr, target, mid + 1, right);
        }
    }
    
    /**
     * 마지막 발생 위치 찾기 (중복값 있을 때)
     */
    public static int findLast(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        // 값을 찾았지만 더 뒤에 있을 수 있는지 확인
        if (arr[mid] == target) {
            int rightResult = findLast(arr, target, mid + 1, right);
            return rightResult != -1 ? rightResult : mid;
        }
        
        if (target < arr[mid]) {
            return findLast(arr, target, left, mid - 1);
        } else {
            return findLast(arr, target, mid + 1, right);
        }
    }
    
    /**
     * 탐색 과정을 시각화하는 이진 탐색
     */
    public static int binarySearchWithTrace(int[] arr, int target, int left, int right, int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s탐색 범위: [%d, %d]%n", indent, left, right);
        
        if (left > right) {
            System.out.println(indent + "범위 무효 → 찾지 못함");
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        System.out.printf("%smid = %d, arr[%d] = %d%n", indent, mid, mid, arr[mid]);
        
        if (arr[mid] == target) {
            System.out.println(indent + "찾음! 인덱스 " + mid);
            return mid;
        }
        
        if (target < arr[mid]) {
            System.out.printf("%s%d < %d이므로 왼쪽 절반 탐색%n", indent, target, arr[mid]);
            return binarySearchWithTrace(arr, target, left, mid - 1, depth + 1);
        } else {
            System.out.printf("%s%d > %d이므로 오른쪽 절반 탐색%n", indent, target, arr[mid]);
            return binarySearchWithTrace(arr, target, mid + 1, right, depth + 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 재귀적 이진 탐색 예제 ===");
        
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25};
        System.out.println("배열: " + java.util.Arrays.toString(arr));
        
        int[] targets = {7, 15, 25, 1, 26, 0};
        
        for (int target : targets) {
            int result = binarySearch(arr, target, 0, arr.length - 1);
            System.out.printf("%d 찾기: %s%n", target, 
                             result >= 0 ? "인덱스 " + result : "찾지 못함");
        }
        
        System.out.println("\n=== 중복값이 있는 배열 ===");
        int[] arrWithDuplicates = {1, 2, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6};
        System.out.println("배열: " + java.util.Arrays.toString(arrWithDuplicates));
        
        int target = 5;
        int first = findFirst(arrWithDuplicates, target, 0, arrWithDuplicates.length - 1);
        int last = findLast(arrWithDuplicates, target, 0, arrWithDuplicates.length - 1);
        
        System.out.printf("%d의 첫 번째 인덱스: %d%n", target, first);
        System.out.printf("%d의 마지막 인덱스: %d%n", target, last);
        System.out.printf("%d의 개수: %d%n", target, last - first + 1);
        
        System.out.println("\n=== 탐색 과정 추적 ===");
        binarySearchWithTrace(arr, 13, 0, arr.length - 1, 0);
    }
}
```

### 예제 2-2: 향상된 하노이의 탑

```java
public class AdvancedTowersOfHanoi {
    
    private static int moveCount = 0;
    
    /**
     * 기본 하노이의 탑 해결
     */
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            moveCount++;
            System.out.printf("이동 %d: 원반 1을 %c에서 %c로%n", moveCount, from, to);
            return;
        }
        
        // 1. 위쪽 n-1개를 목적지를 임시로 사용하여 보조 기둥으로
        hanoi(n - 1, from, aux, to);
        
        // 2. 가장 큰 원반을 목적지로
        moveCount++;
        System.out.printf("이동 %d: 원반 %d을 %c에서 %c로%n", moveCount, n, from, to);
        
        // 3. 보조 기둥의 n-1개를 출발지를 임시로 사용하여 목적지로
        hanoi(n - 1, aux, to, from);
    }
    
    /**
     * 하노이의 탑 상태를 시각화
     */
    static class HanoiVisualizer {
        private java.util.Stack<Integer>[] towers;
        private int maxDisk;
        
        @SuppressWarnings("unchecked")
        public HanoiVisualizer(int n) {
            this.maxDisk = n;
            towers = new java.util.Stack[3];
            for (int i = 0; i < 3; i++) {
                towers[i] = new java.util.Stack<>();
            }
            
            // 첫 번째 기둥에 모든 원반 배치 (큰 것부터)
            for (int i = n; i >= 1; i--) {
                towers[0].push(i);
            }
        }
        
        public void move(char from, char to) {
            int fromIndex = from - 'A';
            int toIndex = to - 'A';
            
            if (towers[fromIndex].isEmpty()) {
                System.out.println("오류: 빈 기둥에서 원반을 가져올 수 없습니다!");
                return;
            }
            
            int disk = towers[fromIndex].pop();
            
            if (!towers[toIndex].isEmpty() && towers[toIndex].peek() < disk) {
                System.out.println("오류: 큰 원반을 작은 원반 위에 놓을 수 없습니다!");
                towers[fromIndex].push(disk);  // 원복
                return;
            }
            
            towers[toIndex].push(disk);
            System.out.printf("원반 %d을 %c에서 %c로 이동%n", disk, from, to);
            printTowers();
            System.out.println();
        }
        
        public void printTowers() {
            System.out.println("현재 상태:");
            
            // 각 기둥의 높이 찾기
            int maxHeight = 0;
            for (int i = 0; i < 3; i++) {
                maxHeight = Math.max(maxHeight, towers[i].size());
            }
            
            // 위에서부터 출력
            for (int level = maxHeight - 1; level >= 0; level--) {
                for (int tower = 0; tower < 3; tower++) {
                    if (towers[tower].size() > level) {
                        int disk = towers[tower].get(level);
                        String diskStr = "*".repeat(disk);
                        System.out.printf("%10s ", diskStr);
                    } else {
                        System.out.printf("%10s ", "|");
                    }
                }
                System.out.println();
            }
            
            System.out.println("----------+----------+----------");
            System.out.println("    A     |    B     |    C    ");
        }
        
        public void solveVisually(int n, char from, char to, char aux) {
            if (n == 1) {
                move(from, to);
                return;
            }
            
            solveVisually(n - 1, from, aux, to);
            move(from, to);
            solveVisually(n - 1, aux, to, from);
        }
    }
    
    /**
     * 4기둥 하노이의 탑 (Reve's puzzle)
     */
    public static void hanoi4Towers(int n, int from, int to, int aux1, int aux2) {
        if (n == 1) {
            System.out.printf("원반 1을 기둥 %d에서 기둥 %d로%n", from, to);
            return;
        }
        
        if (n == 2) {
            System.out.printf("원반 1을 기둥 %d에서 기둥 %d로%n", from, aux1);
            System.out.printf("원반 2를 기둥 %d에서 기둥 %d로%n", from, to);
            System.out.printf("원반 1을 기둥 %d에서 기둥 %d로%n", aux1, to);
            return;
        }
        
        // 최적의 분할점 k 찾기 (간단한 휴리스틱)
        int k = n / 2;
        
        // 1. 위쪽 k개를 aux1으로 (4개 기둥 사용)
        hanoi4Towers(k, from, aux1, aux2, to);
        
        // 2. 아래쪽 n-k개를 to로 (3개 기둥 사용)
        hanoi3Towers(n - k, from, to, aux2);
        
        // 3. aux1의 k개를 to로 (4개 기둥 사용)
        hanoi4Towers(k, aux1, to, aux2, from);
    }
    
    private static void hanoi3Towers(int n, int from, int to, int aux) {
        if (n == 1) {
            System.out.printf("원반 %d을 기둥 %d에서 기둥 %d로%n", n, from, to);
            return;
        }
        
        hanoi3Towers(n - 1, from, aux, to);
        System.out.printf("원반 %d을 기둥 %d에서 기둥 %d로%n", n, from, to);
        hanoi3Towers(n - 1, aux, to, from);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 하노이의 탑 예제 ===");
        
        int n = 4;
        moveCount = 0;
        
        System.out.printf("%d개 원반 하노이의 탑 해결:%n", n);
        hanoi(n, 'A', 'C', 'B');
        System.out.printf("총 %d번의 이동 (이론값: %d)%n", moveCount, (1 << n) - 1);
        
        System.out.println("\n=== 시각화된 하노이의 탑 ===");
        HanoiVisualizer visualizer = new HanoiVisualizer(3);
        System.out.println("초기 상태:");
        visualizer.printTowers();
        System.out.println("\n해결 과정:");
        visualizer.solveVisually(3, 'A', 'C', 'B');
        
        System.out.println("\n=== 이동 횟수 비교 ===");
        for (int disks = 1; disks <= 10; disks++) {
            long moves = (1L << disks) - 1;
            double seconds = moves / (24.0 * 3600);  // 하루에 1초에 1번 이동
            double years = seconds / (365.25 * 24 * 3600);
            
            System.out.printf("%2d개 원반: %,10d 이동", disks, moves);
            if (years > 1) {
                System.out.printf(" (약 %.1f년)", years);
            } else if (seconds > 1) {
                System.out.printf(" (약 %.1f초)", seconds);
            }
            System.out.println();
        }
        
        System.out.println("\n=== 4기둥 하노이의 탑 ===");
        System.out.println("4개 원반을 4개 기둥으로:");
        hanoi4Towers(4, 1, 4, 2, 3);
    }
}
```

### 예제 2-3: 고급 퀵정렬 구현

```java
import java.util.Arrays;
import java.util.Random;

public class AdvancedQuickSort {
    
    private static int comparisons = 0;
    private static int swaps = 0;
    
    /**
     * 기본 퀵정렬
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 개선된 퀵정렬 - 랜덤 피벗
     */
    public static void quickSortRandomPivot(int[] arr, int low, int high) {
        if (low < high) {
            // 랜덤 피벗 선택
            randomizePivot(arr, low, high);
            int pivotIndex = partition(arr, low, high);
            quickSortRandomPivot(arr, low, pivotIndex - 1);
            quickSortRandomPivot(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 3-way 퀵정렬 (중복값이 많을 때 효율적)
     */
    public static void quickSort3Way(int[] arr, int low, int high) {
        if (low >= high) return;
        
        int[] bounds = partition3Way(arr, low, high);
        int lt = bounds[0];  // less than
        int gt = bounds[1];  // greater than
        
        quickSort3Way(arr, low, lt - 1);
        quickSort3Way(arr, gt + 1, high);
    }
    
    /**
     * 하이브리드 퀵정렬 - 작은 배열에는 삽입정렬 사용
     */
    public static void quickSortHybrid(int[] arr, int low, int high) {
        if (low < high) {
            // 작은 배열에는 삽입정렬 사용
            if (high - low < 10) {
                insertionSort(arr, low, high);
                return;
            }
            
            randomizePivot(arr, low, high);
            int pivotIndex = partition(arr, low, high);
            quickSortHybrid(arr, low, pivotIndex - 1);
            quickSortHybrid(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 표준 분할 (Lomuto partition)
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    /**
     * 3-way 분할 (Dijkstra's Dutch flag algorithm)
     */
    private static int[] partition3Way(int[] arr, int low, int high) {
        int pivot = arr[low];
        int lt = low;      // arr[low..lt-1] < pivot
        int gt = high;     // arr[gt+1..high] > pivot
        int i = low;       // arr[lt..i-1] == pivot
        
        while (i <= gt) {
            comparisons++;
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        
        return new int[]{lt, gt};
    }
    
    /**
     * 랜덤 피벗 선택
     */
    private static void randomizePivot(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);
        swap(arr, randomIndex, high);
    }
    
    /**
     * 삽입정렬 (작은 배열용)
     */
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= low && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }
            
            arr[j + 1] = key;
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        swaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * 정렬 과정 시각화
     */
    public static void quickSortWithVisualization(int[] arr, int low, int high, int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s정렬 범위: [%d, %d] - %s%n", 
                         indent, low, high, 
                         Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)));
        
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            System.out.printf("%s피벗 %d가 인덱스 %d에 최종 배치%n", 
                             indent, arr[pivotIndex], pivotIndex);
            
            quickSortWithVisualization(arr, low, pivotIndex - 1, depth + 1);
            quickSortWithVisualization(arr, pivotIndex + 1, high, depth + 1);
        }
    }
    
    /**
     * 성능 테스트
     */
    public static void performanceTest() {
        System.out.println("=== 퀵정렬 성능 비교 ===");
        
        int[] sizes = {1000, 5000, 10000};
        
        for (int size : sizes) {
            System.out.printf("\n배열 크기: %,d%n", size);
            
            // 테스트 데이터 생성
            int[] randomArray = generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, size);
            Arrays.sort(sortedArray);
            int[] reversedArray = new int[size];
            for (int i = 0; i < size; i++) {
                reversedArray[i] = sortedArray[size - 1 - i];
            }
            int[] duplicateArray = generateDuplicateArray(size);
            
            // 각 알고리즘 테스트
            testAlgorithm("기본 퀵정렬", randomArray.clone(), "랜덤", 1);
            testAlgorithm("기본 퀵정렬", sortedArray.clone(), "정렬됨", 1);
            testAlgorithm("랜덤 피벗", randomArray.clone(), "랜덤", 2);
            testAlgorithm("랜덤 피벗", sortedArray.clone(), "정렬됨", 2);
            testAlgorithm("3-way 퀵정렬", duplicateArray.clone(), "중복많음", 3);
            testAlgorithm("하이브리드", randomArray.clone(), "랜덤", 4);
        }
    }
    
    private static void testAlgorithm(String name, int[] arr, String type, int algorithm) {
        comparisons = 0;
        swaps = 0;
        
        long startTime = System.nanoTime();
        
        switch (algorithm) {
            case 1: quickSort(arr, 0, arr.length - 1); break;
            case 2: quickSortRandomPivot(arr, 0, arr.length - 1); break;
            case 3: quickSort3Way(arr, 0, arr.length - 1); break;
            case 4: quickSortHybrid(arr, 0, arr.length - 1); break;
        }
        
        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("%-15s %-10s: %6.2f ms, 비교:%7d, 교환:%7d%n", 
                         name, "(" + type + ")", timeMs, comparisons, swaps);
    }
    
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
    
    private static int[] generateDuplicateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10);  // 0-9 사이의 값만 (많은 중복)
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 고급 퀵정렬 예제 ===");
        
        int[] testArray = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30, 42, 88, 15};
        System.out.println("원본 배열: " + Arrays.toString(testArray));
        
        System.out.println("\n=== 정렬 과정 시각화 ===");
        int[] visualArray = testArray.clone();
        quickSortWithVisualization(visualArray, 0, visualArray.length - 1, 0);
        System.out.println("최종 결과: " + Arrays.toString(visualArray));
        
        System.out.println("\n=== 3-way 퀵정렬 테스트 ===");
        int[] duplicateArray = {5, 2, 8, 2, 9, 1, 5, 5, 2, 8, 1};
        System.out.println("중복 많은 배열: " + Arrays.toString(duplicateArray));
        quickSort3Way(duplicateArray, 0, duplicateArray.length - 1);
        System.out.println("3-way 정렬 결과: " + Arrays.toString(duplicateArray));
        
        // 성능 테스트
        performanceTest();
    }
}
```

### 예제 2-4: 고급 Blob 카운팅

```java
import java.util.*;

public class AdvancedBlobCounting {
    
    /**
     * 기본 Blob 카운터
     */
    static class BlobCounter {
        private final int[][] grid;
        private final boolean[][] visited;
        private final int rows, cols;
        
        // 8방향 이동 (상하좌우 + 대각선)
        private final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        private final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        public BlobCounter(int[][] grid) {
            this.grid = grid;
            this.rows = grid.length;
            this.cols = grid[0].length;
            this.visited = new boolean[rows][cols];
        }
        
        /**
         * 4방향 연결 blob 크기 계산
         */
        public int getBlobSize4(int row, int col) {
            if (row < 0 || row >= rows || col < 0 || col >= cols ||
                visited[row][col] || grid[row][col] == 0) {
                return 0;
            }
            
            visited[row][col] = true;
            int size = 1;
            
            // 4방향 탐색
            size += getBlobSize4(row - 1, col);  // 위
            size += getBlobSize4(row + 1, col);  // 아래
            size += getBlobSize4(row, col - 1);  // 왼쪽
            size += getBlobSize4(row, col + 1);  // 오른쪽
            
            return size;
        }
        
        /**
         * 8방향 연결 blob 크기 계산
         */
        public int getBlobSize8(int row, int col) {
            if (row < 0 || row >= rows || col < 0 || col >= cols ||
                visited[row][col] || grid[row][col] == 0) {
                return 0;
            }
            
            visited[row][col] = true;
            int size = 1;
            
            // 8방향 탐색
            for (int i = 0; i < 8; i++) {
                size += getBlobSize8(row + dx[i], col + dy[i]);
            }
            
            return size;
        }
        
        /**
         * 특정 값을 가진 blob만 카운트
         */
        public int getBlobSizeWithValue(int row, int col, int targetValue) {
            if (row < 0 || row >= rows || col < 0 || col >= cols ||
                visited[row][col] || grid[row][col] != targetValue) {
                return 0;
            }
            
            visited[row][col] = true;
            int size = 1;
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                size += getBlobSizeWithValue(row + dx[i*2], col + dy[i*2], targetValue);
            }
            
            return size;
        }
        
        /**
         * 모든 blob 정보 수집
         */
        public List<BlobInfo> findAllBlobs(boolean eightWay) {
            clearVisited();
            List<BlobInfo> blobs = new ArrayList<>();
            
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (!visited[r][c] && grid[r][c] != 0) {
                        int size = eightWay ? getBlobSize8(r, c) : getBlobSize4(r, c);
                        if (size > 0) {
                            blobs.add(new BlobInfo(r, c, size, grid[r][c]));
                        }
                    }
                }
            }
            
            return blobs;
        }
        
        /**
         * blob에 고유 ID 부여
         */
        public int[][] labelBlobs() {
            clearVisited();
            int[][] labels = new int[rows][cols];
            int currentLabel = 1;
            
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (!visited[r][c] && grid[r][c] != 0) {
                        labelBlobDFS(r, c, currentLabel, labels);
                        currentLabel++;
                    }
                }
            }
            
            return labels;
        }
        
        private void labelBlobDFS(int row, int col, int label, int[][] labels) {
            if (row < 0 || row >= rows || col < 0 || col >= cols ||
                visited[row][col] || grid[row][col] == 0) {
                return;
            }
            
            visited[row][col] = true;
            labels[row][col] = label;
            
            // 4방향 라벨링
            labelBlobDFS(row - 1, col, label, labels);
            labelBlobDFS(row + 1, col, label, labels);
            labelBlobDFS(row, col - 1, label, labels);
            labelBlobDFS(row, col + 1, label, labels);
        }
        
        public void clearVisited() {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    visited[r][c] = false;
                }
            }
        }
        
        public void printGrid() {
            System.out.println("격자 상태:");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.printf("%3d", grid[r][c]);
                }
                System.out.println();
            }
        }
        
        public void printLabels(int[][] labels) {
            System.out.println("Blob 라벨:");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.printf("%3d", labels[r][c]);
                }
                System.out.println();
            }
        }
    }
    
    /**
     * Blob 정보 클래스
     */
    static class BlobInfo {
        int startRow, startCol;
        int size;
        int value;
        
        public BlobInfo(int startRow, int startCol, int size, int value) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.size = size;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return String.format("Blob(위치:(%d,%d), 크기:%d, 값:%d)", 
                               startRow, startCol, size, value);
        }
    }
    
    /**
     * 미로 해결기 (재귀적 백트래킹)
     */
    static class MazeSolver {
        private final int[][] maze;
        private final boolean[][] visited;
        private final int rows, cols;
        private final List<int[]> path;
        
        public MazeSolver(int[][] maze) {
            this.maze = maze;
            this.rows = maze.length;
            this.cols = maze[0].length;
            this.visited = new boolean[rows][cols];
            this.path = new ArrayList<>();
        }
        
        public boolean solveMaze(int startR, int startC, int endR, int endC) {
            clearVisited();
            path.clear();
            return solveMazeRecursive(startR, startC, endR, endC);
        }
        
        private boolean solveMazeRecursive(int row, int col, int endR, int endC) {
            // 경계 체크 및 벽 체크
            if (row < 0 || row >= rows || col < 0 || col >= cols ||
                visited[row][col] || maze[row][col] == 1) {
                return false;
            }
            
            // 현재 위치 방문 표시
            visited[row][col] = true;
            path.add(new int[]{row, col});
            
            // 목적지 도달
            if (row == endR && col == endC) {
                return true;
            }
            
            // 4방향 탐색
            if (solveMazeRecursive(row - 1, col, endR, endC) ||  // 위
                solveMazeRecursive(row, col + 1, endR, endC) ||  // 오른쪽
                solveMazeRecursive(row + 1, col, endR, endC) ||  // 아래
                solveMazeRecursive(row, col - 1, endR, endC)) {  // 왼쪽
                return true;
            }
            
            // 백트래킹: 현재 경로가 막혔으므로 되돌아감
            path.remove(path.size() - 1);
            return false;
        }
        
        public void printMaze() {
            System.out.println("미로 (0=통로, 1=벽):");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.printf("%2d", maze[r][c]);
                }
                System.out.println();
            }
        }
        
        public void printSolution() {
            if (path.isEmpty()) {
                System.out.println("해결책이 없습니다.");
                return;
            }
            
            int[][] solution = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    solution[r][c] = maze[r][c];
                }
            }
            
            // 경로 표시
            for (int i = 0; i < path.size(); i++) {
                int[] pos = path.get(i);
                solution[pos[0]][pos[1]] = i == 0 ? 8 : i == path.size() - 1 ? 9 : 2;
            }
            
            System.out.println("해결책 (8=시작, 9=끝, 2=경로):");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.printf("%2d", solution[r][c]);
                }
                System.out.println();
            }
            
            System.out.println("경로 길이: " + path.size());
        }
        
        private void clearVisited() {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    visited[r][c] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 고급 Blob 카운팅 예제 ===");
        
        // 테스트 격자
        int[][] grid = {
            {1, 1, 0, 0, 2, 2},
            {1, 0, 1, 0, 2, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 3, 3, 3},
            {2, 0, 0, 3, 0, 3},
            {2, 2, 0, 3, 3, 3}
        };
        
        BlobCounter counter = new BlobCounter(grid);
        counter.printGrid();
        
        System.out.println("\n=== 4방향 연결 Blob 분석 ===");
        List<BlobInfo> blobs4 = counter.findAllBlobs(false);
        for (BlobInfo blob : blobs4) {
            System.out.println(blob);
        }
        
        System.out.println("\n=== 8방향 연결 Blob 분석 ===");
        List<BlobInfo> blobs8 = counter.findAllBlobs(true);
        for (BlobInfo blob : blobs8) {
            System.out.println(blob);
        }
        
        System.out.println("\n=== Blob 라벨링 ===");
        counter = new BlobCounter(grid);  // 새 인스턴스
        int[][] labels = counter.labelBlobs();
        counter.printLabels(labels);
        
        System.out.println("\n=== 미로 해결 예제 ===");
        int[][] maze = {
            {0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0}
        };
        
        MazeSolver solver = new MazeSolver(maze);
        solver.printMaze();
        
        System.out.println("\n미로 해결 시도 (0,0) → (5,5):");
        boolean solved = solver.solveMaze(0, 0, 5, 5);
        if (solved) {
            System.out.println("미로 해결 성공!");
            solver.printSolution();
        } else {
            System.out.println("미로 해결 실패!");
        }
        
        System.out.println("\n=== 통계 정보 ===");
        Map<Integer, Integer> valueCount = new HashMap<>();
        Map<Integer, Integer> sizeDistribution = new HashMap<>();
        
        for (BlobInfo blob : blobs4) {
            valueCount.put(blob.value, valueCount.getOrDefault(blob.value, 0) + 1);
            sizeDistribution.put(blob.size, sizeDistribution.getOrDefault(blob.size, 0) + 1);
        }
        
        System.out.println("값별 blob 개수:");
        valueCount.forEach((value, count) -> 
            System.out.printf("값 %d: %d개%n", value, count));
        
        System.out.println("\n크기별 blob 분포:");
        sizeDistribution.forEach((size, count) -> 
            System.out.printf("크기 %d: %d개%n", size, count));
    }
}
```

## 3. 재귀 최적화 및 디버깅

### 예제 3-1: 재귀 호출 추적기

```java
public class RecursionTracer {
    
    private static int callDepth = 0;
    private static int totalCalls = 0;
    
    /**
     * 재귀 호출을 추적하는 팩토리얼
     */
    public static long factorialWithTrace(int n) {
        callDepth++;
        totalCalls++;
        String indent = "  ".repeat(callDepth - 1);
        System.out.printf("%s→ factorial(%d) 호출 (깊이: %d)%n", indent, n, callDepth);
        
        long result;
        if (n <= 1) {
            result = 1;
            System.out.printf("%s← factorial(%d) = %d (기저 사례)%n", indent, n, result);
        } else {
            result = n * factorialWithTrace(n - 1);
            System.out.printf("%s← factorial(%d) = %d%n", indent, n, result);
        }
        
        callDepth--;
        return result;
    }
    
    /**
     * 스택 오버플로우 안전한 팩토리얼
     */
    public static long factorialSafe(int n) {
        if (n > 20) {  // long 범위를 벗어남
            throw new IllegalArgumentException("너무 큰 값: " + n);
        }
        return factorialHelper(n);
    }
    
    private static long factorialHelper(int n) {
        if (n <= 1) return 1;
        return n * factorialHelper(n - 1);
    }
    
    /**
     * 재귀를 반복문으로 변환한 팩토리얼
     */
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * 메모리 사용량 측정
     */
    public static void measureMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        
        System.out.println("=== 메모리 사용량 비교 ===");
        
        // 가비지 컬렉션 실행
        runtime.gc();
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // 재귀 실행
        factorialSafe(15);
        long memAfterRecursion = runtime.totalMemory() - runtime.freeMemory();
        
        // 반복문 실행
        factorialIterative(15);
        long memAfterIteration = runtime.totalMemory() - runtime.freeMemory();
        
        System.out.printf("시작 메모리: %,d bytes%n", memBefore);
        System.out.printf("재귀 후: %,d bytes (+%,d)%n", 
                         memAfterRecursion, memAfterRecursion - memBefore);
        System.out.printf("반복문 후: %,d bytes (+%,d)%n", 
                         memAfterIteration, memAfterIteration - memAfterRecursion);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 재귀 호출 추적 ===");
        
        totalCalls = 0;
        callDepth = 0;
        
        long result = factorialWithTrace(5);
        System.out.printf("최종 결과: %d%n", result);
        System.out.printf("총 호출 횟수: %d%n", totalCalls);
        
        System.out.println("\n=== 안전성 테스트 ===");
        try {
            factorialSafe(25);  // 예외 발생
        } catch (IllegalArgumentException e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
        
        // 메모리 사용량 측정
        measureMemoryUsage();
        
        System.out.println("\n=== 성능 비교 ===");
        int n = 20;
        int iterations = 1000000;
        
        // 재귀 성능
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            factorialSafe(n);
        }
        long recursiveTime = System.nanoTime() - startTime;
        
        // 반복문 성능
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            factorialIterative(n);
        }
        long iterativeTime = System.nanoTime() - startTime;
        
        System.out.printf("재귀 버전: %.2f ms%n", recursiveTime / 1_000_000.0);
        System.out.printf("반복문 버전: %.2f ms%n", iterativeTime / 1_000_000.0);
        System.out.printf("성능 차이: %.1fx%n", (double)recursiveTime / iterativeTime);
    }
}
```

이제 다음 파일들을 계속 작성하겠습니다.