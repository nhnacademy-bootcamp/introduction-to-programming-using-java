# 9.6 프로그래밍 연습 문제 - 예제 모음

## 1. 재귀 함수 구현

### 예제 1-1: 팩토리얼과 피보나치

```java
import java.math.BigInteger;

public class RecursiveFunctions {
    
    /**
     * 팩토리얼 계산 (long 버전)
     */
    public static long factorial(int n) {
        // TODO 1: n이 음수인 경우 IllegalArgumentException 던지기
        
        // TODO 2: 기본 경우 - n이 0이면 1 반환
        
        // TODO 3: 재귀 경우 - n * factorial(n-1) 반환
        
        return 0; // 임시 반환값
    }
    
    /**
     * 팩토리얼 계산 (BigInteger 버전)
     */
    public static BigInteger factorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수는 불가능합니다");
        }
        if (n == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialBig(n - 1));
    }
    
    /**
     * 피보나치 계산 (비효율적인 재귀 버전)
     */
    public static long fibonacci(int n) {
        // TODO 1: n이 음수인 경우 IllegalArgumentException 던지기
        
        // TODO 2: 기본 경우 - n이 0 또는 1이면 1 반환
        
        // TODO 3: 재귀 경우 - fibonacci(n-1) + fibonacci(n-2) 반환
        
        return 0; // 임시 반환값
    }
    
    /**
     * 피보나치 계산 (효율적인 반복 버전)
     */
    public static long fibonacciIterative(int n) {
        // TODO 1: n이 음수인 경우 예외 처리
        // TODO 2: n이 0 또는 1인 경우 1 반환
        
        // TODO 3: 이전 두 값을 저장할 변수 초기화 (prev1=1, prev2=1)
        // TODO 4: 2부터 n까지 반복하면서:
        //   - current = prev1 + prev2
        //   - prev2 = prev1
        //   - prev1 = current
        // TODO 5: current 반환
        
        return 0; // 임시 반환값
    }
    
    /**
     * 피보나치 계산 (메모이제이션 버전)
     */
    public static long fibonacciMemo(int n) {
        long[] memo = new long[n + 1];
        return fibonacciMemoHelper(n, memo);
    }
    
    private static long fibonacciMemoHelper(int n, long[] memo) {
        // TODO 1: 기본 경우 - n이 0 또는 1이면 1 반환
        
        // TODO 2: 이미 계산된 값이 있는지 확인 (memo[n] != 0)
        
        // TODO 3: 계산하고 memo에 저장:
        //   memo[n] = fibonacciMemoHelper(n-1, memo) + fibonacciMemoHelper(n-2, memo)
        
        // TODO 4: memo[n] 반환
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        // 팩토리얼 테스트
        System.out.println("=== 팩토리얼 ===");
        for (int i = 0; i <= 20; i++) {
            System.out.printf("%d! = %d%n", i, factorial(i));
        }
        
        // 큰 수의 팩토리얼
        System.out.println("\n=== 큰 수의 팩토리얼 ===");
        for (int i = 25; i <= 100; i += 25) {
            System.out.printf("%d! = %s%n", i, factorialBig(i));
        }
        
        // 피보나치 비교
        System.out.println("\n=== 피보나치 성능 비교 ===");
        long start, end;
        
        // 작은 수에서 테스트
        int n = 40;
        
        start = System.currentTimeMillis();
        long result1 = fibonacci(n);
        end = System.currentTimeMillis();
        System.out.printf("재귀: F(%d) = %d, 시간: %dms%n", 
                         n, result1, end - start);
        
        start = System.currentTimeMillis();
        long result2 = fibonacciIterative(n);
        end = System.currentTimeMillis();
        System.out.printf("반복: F(%d) = %d, 시간: %dms%n", 
                         n, result2, end - start);
        
        start = System.currentTimeMillis();
        long result3 = fibonacciMemo(n);
        end = System.currentTimeMillis();
        System.out.printf("메모: F(%d) = %d, 시간: %dms%n", 
                         n, result3, end - start);
    }
}
```

## 2. 이진 정렬 트리를 사용한 단어 정렬

### 예제 2-1: BST 기반 단어 정렬기

```java
import java.io.*;
import java.util.*;

public class WordSorterBST {
    
    // 이진 트리 노드
    static class TreeNode {
        String word;
        TreeNode left, right;
        
        TreeNode(String word) {
            this.word = word.toLowerCase();
        }
    }
    
    // 이진 정렬 트리
    static class BinarySearchTree {
        private TreeNode root;
        private int size;
        
        /**
         * 단어 삽입
         */
        public void insert(String word) {
            root = insertRec(root, word.toLowerCase());
        }
        
        private TreeNode insertRec(TreeNode node, String word) {
            // TODO 1: 기본 경우 - node가 null이면 새 TreeNode 생성하고 size 증가
            
            // TODO 2: word와 node.word를 비교 (compareTo 사용)
            // TODO 3: word가 더 작으면 왼쪽 서브트리에 삽입
            // TODO 4: word가 더 크면 오른쪽 서브트리에 삽입
            // TODO 5: 같으면 중복이므로 무시
            
            // TODO 6: node 반환
            
            return null; // 임시 반환값
        }
        
        /**
         * 중위 순회로 정렬된 단어 출력
         */
        public void printInOrder(PrintWriter out) {
            printInOrderRec(root, out);
        }
        
        private void printInOrderRec(TreeNode node, PrintWriter out) {
            // TODO: 중위 순회로 단어 출력
            // 1. node가 null이 아니면:
            //    - 왼쪽 서브트리 순회
            //    - 현재 노드의 단어 출력
            //    - 오른쪽 서브트리 순회
        }
        
        /**
         * 단어를 리스트로 수집
         */
        public List<String> toList() {
            List<String> list = new ArrayList<>();
            collectWords(root, list);
            return list;
        }
        
        private void collectWords(TreeNode node, List<String> list) {
            if (node != null) {
                collectWords(node.left, list);
                list.add(node.word);
                collectWords(node.right, list);
            }
        }
        
        public int size() {
            return size;
        }
    }
    
    /**
     * 파일에서 단어를 읽어 정렬
     */
    public static void sortWordsFromFile(String inputFile, String outputFile) {
        BinarySearchTree bst = new BinarySearchTree();
        
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            // 단어 읽기
            while (scanner.hasNext()) {
                String word = scanner.next();
                // 문장부호 제거
                word = word.replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    bst.insert(word);
                }
            }
            
            // 결과 출력
            try (PrintWriter out = new PrintWriter(outputFile)) {
                out.println("총 " + bst.size() + "개의 고유한 단어:");
                out.println();
                bst.printInOrder(out);
            }
            
            System.out.println("정렬 완료: " + outputFile);
            
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + e.getMessage());
        }
    }
    
    /**
     * 성능 비교: BST vs ArrayList
     */
    public static void comparePerformance() {
        Random random = new Random();
        int[] sizes = {1000, 5000, 10000, 50000};
        
        System.out.println("=== BST vs ArrayList 성능 비교 ===");
        System.out.println("크기\tBST(ms)\tArrayList(ms)");
        
        for (int size : sizes) {
            // 랜덤 단어 생성
            String[] words = new String[size];
            for (int i = 0; i < size; i++) {
                words[i] = generateRandomWord(random, 5, 10);
            }
            
            // BST 테스트
            long startBST = System.currentTimeMillis();
            BinarySearchTree bst = new BinarySearchTree();
            for (String word : words) {
                bst.insert(word);
            }
            List<String> bstList = bst.toList();
            long endBST = System.currentTimeMillis();
            
            // ArrayList 테스트
            long startList = System.currentTimeMillis();
            List<String> arrayList = new ArrayList<>();
            for (String word : words) {
                if (!arrayList.contains(word)) {
                    arrayList.add(word);
                }
            }
            Collections.sort(arrayList);
            long endList = System.currentTimeMillis();
            
            System.out.printf("%d\t%d\t\t%d%n", 
                            size, endBST - startBST, endList - startList);
        }
    }
    
    private static String generateRandomWord(Random random, int minLen, int maxLen) {
        int len = random.nextInt(maxLen - minLen + 1) + minLen;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char)('a' + random.nextInt(26)));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // 성능 비교
        comparePerformance();
        
        // 파일 정렬 예제
        // sortWordsFromFile("input.txt", "sorted_words.txt");
    }
}
```

## 3. 연결 리스트 뒤집기

### 예제 3-1: 재귀적 리스트 뒤집기

```java
public class ListReversal {
    
    static class ListNode {
        int item;
        ListNode next;
        
        ListNode(int item) {
            this.item = item;
        }
    }
    
    /**
     * 리스트를 뒤집어서 복사 (재귀적 방법)
     */
    public static ListNode reverseRecursive(ListNode head) {
        // TODO 1: 기본 경우 - head가 null 또는 head.next가 null이면 
        //         copyNode(head) 반환
        
        // TODO 2: head.next부터 뒤집기 (재귀 호출)
        
        // TODO 3: 현재 노드를 복사하여 뒤집힌 리스트의 끝에 추가
        
        // TODO 4: 뒤집힌 리스트 반환
        
        return null; // 임시 반환값
    }
    
    /**
     * 리스트를 뒤집어서 복사 (반복적 방법)
     */
    public static ListNode reverseIterative(ListNode head) {
        // TODO 1: reversed를 null로 초기화
        // TODO 2: current를 head로 초기화
        
        // TODO 3: current가 null이 아닌 동안 반복:
        //   - 현재 노드의 값으로 새 노드 생성
        //   - 새 노드의 next를 reversed로 설정 (앞에 추가)
        //   - reversed를 새 노드로 업데이트
        //   - current를 다음 노드로 이동
        
        // TODO 4: reversed 반환
        
        return null; // 임시 반환값
    }
    
    /**
     * 더 효율적인 재귀적 뒤집기
     */
    public static ListNode reverseEfficient(ListNode head) {
        return reverseHelper(head, null);
    }
    
    private static ListNode reverseHelper(ListNode current, ListNode reversed) {
        // TODO 1: 기본 경우 - current가 null이면 reversed 반환
        
        // TODO 2: 현재 노드의 값으로 새 노드 생성
        // TODO 3: 새 노드의 next를 reversed로 설정
        
        // TODO 4: current.next와 새 노드로 재귀 호출
        
        return null; // 임시 반환값
    }
    
    // 헬퍼 메서드들
    private static ListNode copyNode(ListNode node) {
        if (node == null) return null;
        return new ListNode(node.item);
    }
    
    private static void appendToEnd(ListNode head, ListNode node) {
        if (head == null) return;
        
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }
    
    /**
     * 리스트 생성
     */
    public static ListNode createList(int... values) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    /**
     * 리스트 출력
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.item);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 테스트 리스트 생성
        ListNode original = createList(1, 2, 3, 4, 5);
        
        System.out.println("원본 리스트:");
        printList(original);
        
        // 재귀적 뒤집기
        ListNode reversed1 = reverseRecursive(original);
        System.out.println("\n재귀적 뒤집기:");
        printList(reversed1);
        
        // 반복적 뒤집기
        ListNode reversed2 = reverseIterative(original);
        System.out.println("\n반복적 뒤집기:");
        printList(reversed2);
        
        // 효율적인 재귀적 뒤집기
        ListNode reversed3 = reverseEfficient(original);
        System.out.println("\n효율적인 재귀적 뒤집기:");
        printList(reversed3);
        
        // 원본이 변경되지 않았는지 확인
        System.out.println("\n원본 리스트 (변경되지 않음):");
        printList(original);
    }
}
```

## 4. 큐를 사용한 트리 순회

### 예제 4-1: 레벨 순서 순회

```java
import java.util.*;

public class TreeLevelOrder {
    
    static class TreeNode {
        int item;
        TreeNode left, right;
        
        TreeNode(int item) {
            this.item = item;
        }
    }
    
    // 큐 구현 (연결 리스트 기반)
    static class Queue<T> {
        private static class Node<T> {
            T data;
            Node<T> next;
            
            Node(T data) {
                this.data = data;
            }
        }
        
        private Node<T> front, rear;
        private int size;
        
        public void enqueue(T item) {
            Node<T> newNode = new Node<>(item);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }
        
        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("큐가 비어있습니다");
            }
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return data;
        }
        
        public boolean isEmpty() {
            return front == null;
        }
        
        public int size() {
            return size;
        }
    }
    
    /**
     * 큐를 사용한 레벨 순서 순회
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        
        System.out.println("레벨 순서 순회:");
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.print(node.item + " ");
            
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        System.out.println();
    }
    
    /**
     * 레벨별로 출력
     */
    public static void levelByLevel(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        
        System.out.println("레벨별 출력:");
        int level = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("레벨 " + level + ": ");
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.dequeue();
                System.out.print(node.item + " ");
                
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }
            System.out.println();
            level++;
        }
    }
    
    /**
     * 지그재그 레벨 순서 순회
     */
    public static void zigzagLevelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        boolean leftToRight = true;
        
        System.out.println("지그재그 순회:");
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.dequeue();
                levelValues.add(node.item);
                
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }
            
            if (!leftToRight) {
                Collections.reverse(levelValues);
            }
            
            for (int val : levelValues) {
                System.out.print(val + " ");
            }
            
            leftToRight = !leftToRight;
        }
        System.out.println();
    }
    
    /**
     * 다양한 순회 방법 비교
     */
    public static void compareTraversals(TreeNode root) {
        System.out.println("=== 순회 방법 비교 ===");
        
        // 전위 순회 (재귀)
        System.out.print("전위 순회: ");
        preorderTraversal(root);
        System.out.println();
        
        // 중위 순회 (재귀)
        System.out.print("중위 순회: ");
        inorderTraversal(root);
        System.out.println();
        
        // 후위 순회 (재귀)
        System.out.print("후위 순회: ");
        postorderTraversal(root);
        System.out.println();
        
        // 레벨 순서 순회
        levelOrderTraversal(root);
    }
    
    private static void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.item + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    
    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.item + " ");
            inorderTraversal(node.right);
        }
    }
    
    private static void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.item + " ");
        }
    }
    
    /**
     * 샘플 트리 생성
     */
    public static TreeNode createSampleTree() {
        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = createSampleTree();
        
        // 다양한 순회 방법 비교
        compareTraversals(root);
        
        System.out.println();
        
        // 레벨별 출력
        levelByLevel(root);
        
        System.out.println();
        
        // 지그재그 순회
        zigzagLevelOrder(root);
    }
}
```

## 5. 트리 균형 분석

### 예제 5-1: 트리 깊이 분석

```java
import java.util.*;

public class TreeBalanceAnalysis {
    
    static class TreeNode {
        double item;
        TreeNode left, right;
        
        TreeNode(double item) {
            this.item = item;
        }
    }
    
    static class TreeAnalyzer {
        private int leafCount;
        private int totalLeafDepth;
        private int maxLeafDepth;
        
        /**
         * 트리 분석 수행
         */
        public void analyze(TreeNode root) {
            leafCount = 0;
            totalLeafDepth = 0;
            maxLeafDepth = 0;
            
            analyzeNode(root, 0);
        }
        
        private void analyzeNode(TreeNode node, int depth) {
            if (node == null) return;
            
            if (node.left == null && node.right == null) {
                // 리프 노드
                leafCount++;
                totalLeafDepth += depth;
                maxLeafDepth = Math.max(maxLeafDepth, depth);
            } else {
                // 내부 노드
                analyzeNode(node.left, depth + 1);
                analyzeNode(node.right, depth + 1);
            }
        }
        
        public double getAverageLeafDepth() {
            if (leafCount == 0) return 0;
            return (double) totalLeafDepth / leafCount;
        }
        
        public int getMaxLeafDepth() {
            return maxLeafDepth;
        }
        
        public int getLeafCount() {
            return leafCount;
        }
        
        /**
         * 트리의 높이 계산
         */
        public static int getHeight(TreeNode node) {
            if (node == null) return -1;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
        
        /**
         * 트리가 균형잡혀 있는지 확인
         */
        public static boolean isBalanced(TreeNode node) {
            return checkBalance(node) != -1;
        }
        
        private static int checkBalance(TreeNode node) {
            if (node == null) return 0;
            
            int leftHeight = checkBalance(node.left);
            if (leftHeight == -1) return -1;
            
            int rightHeight = checkBalance(node.right);
            if (rightHeight == -1) return -1;
            
            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
    
    /**
     * 무작위 이진 정렬 트리 생성
     */
    public static TreeNode createRandomBST(int nodeCount) {
        TreeNode root = null;
        Random random = new Random();
        
        for (int i = 0; i < nodeCount; i++) {
            double value = random.nextDouble() * 1000;
            root = insert(root, value);
        }
        
        return root;
    }
    
    private static TreeNode insert(TreeNode node, double value) {
        if (node == null) {
            return new TreeNode(value);
        }
        
        if (value < node.item) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        
        return node;
    }
    
    /**
     * 균형 분석 실행
     */
    public static void runBalanceExperiment(int trials, int nodeCount) {
        System.out.println("=== 트리 균형 실험 ===");
        System.out.printf("노드 수: %d, 시도 횟수: %d%n", nodeCount, trials);
        System.out.println("\n완벽히 균형잡힌 트리의 높이: " + 
                         (int)(Math.log(nodeCount) / Math.log(2)));
        
        double totalAvgDepth = 0;
        int totalMaxDepth = 0;
        int balancedCount = 0;
        
        for (int i = 0; i < trials; i++) {
            TreeNode root = createRandomBST(nodeCount);
            TreeAnalyzer analyzer = new TreeAnalyzer();
            analyzer.analyze(root);
            
            totalAvgDepth += analyzer.getAverageLeafDepth();
            totalMaxDepth += analyzer.getMaxLeafDepth();
            
            if (TreeAnalyzer.isBalanced(root)) {
                balancedCount++;
            }
        }
        
        System.out.printf("\n평균 리프 깊이: %.2f%n", totalAvgDepth / trials);
        System.out.printf("평균 최대 깊이: %.2f%n", (double)totalMaxDepth / trials);
        System.out.printf("균형잡힌 트리 비율: %.1f%%%n", 
                         (double)balancedCount / trials * 100);
    }
    
    /**
     * 트리 시각화 (작은 트리용)
     */
    public static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }
    
    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null) return;
        
        System.out.println(prefix + (isLast ? "└── " : "├── ") + 
                          String.format("%.1f", node.item));
        
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeHelper(node.left, prefix + (isLast ? "    " : "│   "), 
                              node.right == null);
            } else {
                System.out.println(prefix + (isLast ? "    " : "│   ") + 
                                 "└── null");
            }
            
            if (node.right != null) {
                printTreeHelper(node.right, prefix + (isLast ? "    " : "│   "), 
                              true);
            } else {
                System.out.println(prefix + (isLast ? "    " : "│   ") + 
                                 "└── null");
            }
        }
    }
    
    public static void main(String[] args) {
        // 1023개 노드로 실험
        runBalanceExperiment(100, 1023);
        
        System.out.println("\n=== 다양한 크기의 트리 비교 ===");
        int[] sizes = {15, 31, 63, 127, 255, 511, 1023};
        
        System.out.println("크기\t이상적 높이\t실제 평균 깊이\t실제 최대 깊이");
        for (int size : sizes) {
            TreeNode root = createRandomBST(size);
            TreeAnalyzer analyzer = new TreeAnalyzer();
            analyzer.analyze(root);
            
            int idealHeight = (int)(Math.log(size) / Math.log(2));
            System.out.printf("%d\t%d\t\t%.2f\t\t%d%n",
                            size, idealHeight,
                            analyzer.getAverageLeafDepth(),
                            analyzer.getMaxLeafDepth());
        }
        
        // 작은 트리 시각화
        System.out.println("\n=== 15개 노드 트리 예시 ===");
        TreeNode smallTree = createRandomBST(15);
        printTree(smallTree);
    }
}
```

## 6. 변수를 포함한 수식 파서

### 예제 6-1: 변수 지원 파서

```java
import java.util.*;

public class VariableExpressionParser {
    
    // 수식 트리 노드들
    abstract static class ExpNode {
        abstract double value(double xValue);
        abstract String toString();
    }
    
    static class ConstNode extends ExpNode {
        double number;
        
        ConstNode(double number) {
            this.number = number;
        }
        
        double value(double xValue) {
            return number;
        }
        
        public String toString() {
            return String.valueOf(number);
        }
    }
    
    static class VariableNode extends ExpNode {
        double value(double xValue) {
            return xValue;
        }
        
        public String toString() {
            return "x";
        }
    }
    
    static class BinOpNode extends ExpNode {
        char op;
        ExpNode left, right;
        
        BinOpNode(char op, ExpNode left, ExpNode right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }
        
        double value(double xValue) {
            double leftVal = left.value(xValue);
            double rightVal = right.value(xValue);
            
            switch (op) {
                case '+': return leftVal + rightVal;
                case '-': return leftVal - rightVal;
                case '*': return leftVal * rightVal;
                case '/': return leftVal / rightVal;
                default: throw new IllegalStateException("Unknown operator: " + op);
            }
        }
        
        public String toString() {
            return "(" + left + " " + op + " " + right + ")";
        }
    }
    
    static class UnaryMinusNode extends ExpNode {
        ExpNode operand;
        
        UnaryMinusNode(ExpNode operand) {
            this.operand = operand;
        }
        
        double value(double xValue) {
            return -operand.value(xValue);
        }
        
        public String toString() {
            return "-" + operand;
        }
    }
    
    // 파서
    private String input;
    private int pos;
    
    private void skipSpaces() {
        while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) {
            pos++;
        }
    }
    
    private char peek() {
        skipSpaces();
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }
    
    private char next() {
        skipSpaces();
        if (pos < input.length()) {
            return input.charAt(pos++);
        }
        return '\0';
    }
    
    /**
     * 수식 파싱
     */
    public ExpNode parseExpression() throws ParseError {
        ExpNode left = parseTerm();
        
        while (peek() == '+' || peek() == '-') {
            char op = next();
            ExpNode right = parseTerm();
            left = new BinOpNode(op, left, right);
        }
        
        return left;
    }
    
    /**
     * 항 파싱
     */
    private ExpNode parseTerm() throws ParseError {
        ExpNode left = parseFactor();
        
        while (peek() == '*' || peek() == '/') {
            char op = next();
            ExpNode right = parseFactor();
            left = new BinOpNode(op, left, right);
        }
        
        return left;
    }
    
    /**
     * 인수 파싱 (변수 지원)
     */
    private ExpNode parseFactor() throws ParseError {
        skipSpaces();
        
        // 단항 마이너스
        if (peek() == '-') {
            next();
            return new UnaryMinusNode(parseFactor());
        }
        
        // 괄호
        if (peek() == '(') {
            next();
            ExpNode expr = parseExpression();
            if (next() != ')') {
                throw new ParseError("닫는 괄호가 필요합니다");
            }
            return expr;
        }
        
        // 변수 x
        if (peek() == 'x' || peek() == 'X') {
            next();
            return new VariableNode();
        }
        
        // 숫자
        if (Character.isDigit(peek()) || peek() == '.') {
            return new ConstNode(parseNumber());
        }
        
        throw new ParseError("예상치 못한 문자: " + peek());
    }
    
    private double parseNumber() throws ParseError {
        StringBuilder sb = new StringBuilder();
        
        while (Character.isDigit(peek()) || peek() == '.') {
            sb.append(next());
        }
        
        try {
            return Double.parseDouble(sb.toString());
        } catch (NumberFormatException e) {
            throw new ParseError("잘못된 숫자 형식");
        }
    }
    
    static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }
    
    /**
     * 수식 파싱 및 평가
     */
    public void evaluateExpression(String expression) {
        // TODO 22: 입력 수식과 위치 초기화
        
        try {
            // TODO 23: parseExpression()을 호출하여 수식 트리 생성
            
            // TODO 24: 전체 수식이 파싱되었는지 확인
            // 힌트: pos < input.length()이면 예외 발생
            
            // TODO 25: 파싱 결과 출력
            // - 원본 수식
            // - 파싱된 트리
            // - x = 0, 1, 2, 3일 때의 값
            
            // TODO 26: 그래프용 데이터 생성
            // 힌트: x = -2부터 2까지 0.5 간격으로 계산
            
        } catch (ParseError e) {
            System.err.println("파싱 오류: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        VariableExpressionParser parser = new VariableExpressionParser();
        
        String[] expressions = {
            "x + 1",
            "2 * x",
            "x * x",
            "3 * (x - 1) * (x + 1)",
            "x * x + 2 * x + 1",
            "-x + 5",
            "(x + 1) / (x - 1)"
        };
        
        for (String expr : expressions) {
            System.out.println("\n" + "=".repeat(50));
            parser.evaluateExpression(expr);
        }
    }
}
```

## 7. 도함수 계산기

### 예제 7-1: 수식의 도함수 계산

```java
public class DerivativeCalculator {
    
    // 기존 ExpNode 클래스들에 derivative() 메서드 추가
    abstract static class ExpNode {
        abstract double value(double xValue);
        abstract ExpNode derivative();
        abstract String toString();
        
        // 단순화 메서드
        ExpNode simplify() {
            return this;  // 기본적으로는 변경 없음
        }
    }
    
    static class ConstNode extends ExpNode {
        double number;
        
        ConstNode(double number) {
            this.number = number;
        }
        
        double value(double xValue) {
            return number;
        }
        
        ExpNode derivative() {
            // 상수의 도함수는 0
            return new ConstNode(0);
        }
        
        public String toString() {
            return String.valueOf(number);
        }
    }
    
    static class VariableNode extends ExpNode {
        double value(double xValue) {
            return xValue;
        }
        
        ExpNode derivative() {
            // x의 도함수는 1
            return new ConstNode(1);
        }
        
        public String toString() {
            return "x";
        }
    }
    
    static class BinOpNode extends ExpNode {
        char op;
        ExpNode left, right;
        
        BinOpNode(char op, ExpNode left, ExpNode right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }
        
        double value(double xValue) {
            double leftVal = left.value(xValue);
            double rightVal = right.value(xValue);
            
            switch (op) {
                case '+': return leftVal + rightVal;
                case '-': return leftVal - rightVal;
                case '*': return leftVal * rightVal;
                case '/': return leftVal / rightVal;
                default: throw new IllegalStateException();
            }
        }
        
        ExpNode derivative() {
            // TODO 27: 왼쪽과 오른쪽 자식의 도함수 계산
            
            // TODO 28: 연산자에 따라 도함수 규칙 적용
            // - 덧셈: (A + B)' = A' + B'
            // - 뺄셈: (A - B)' = A' - B'
            // - 곱셈: (A * B)' = A' * B + A * B'
            // - 나눗셈: (A / B)' = (A' * B - A * B') / (B * B)
            
            return null; // 임시 반환값
        }
        
        @Override
        ExpNode simplify() {
            ExpNode simpLeft = left.simplify();
            ExpNode simpRight = right.simplify();
            
            // 0과의 연산 단순화
            if (simpLeft instanceof ConstNode && ((ConstNode)simpLeft).number == 0) {
                switch (op) {
                    case '+': return simpRight;  // 0 + B = B
                    case '-': return new UnaryMinusNode(simpRight);  // 0 - B = -B
                    case '*': return new ConstNode(0);  // 0 * B = 0
                    case '/': return new ConstNode(0);  // 0 / B = 0
                }
            }
            
            if (simpRight instanceof ConstNode && ((ConstNode)simpRight).number == 0) {
                switch (op) {
                    case '+': return simpLeft;  // A + 0 = A
                    case '-': return simpLeft;  // A - 0 = A
                    case '*': return new ConstNode(0);  // A * 0 = 0
                }
            }
            
            // 1과의 곱셈 단순화
            if (op == '*') {
                if (simpLeft instanceof ConstNode && ((ConstNode)simpLeft).number == 1) {
                    return simpRight;  // 1 * B = B
                }
                if (simpRight instanceof ConstNode && ((ConstNode)simpRight).number == 1) {
                    return simpLeft;  // A * 1 = A
                }
            }
            
            return new BinOpNode(op, simpLeft, simpRight);
        }
        
        public String toString() {
            return "(" + left + " " + op + " " + right + ")";
        }
    }
    
    static class UnaryMinusNode extends ExpNode {
        ExpNode operand;
        
        UnaryMinusNode(ExpNode operand) {
            this.operand = operand;
        }
        
        double value(double xValue) {
            return -operand.value(xValue);
        }
        
        ExpNode derivative() {
            // (-A)' = -A'
            return new UnaryMinusNode(operand.derivative());
        }
        
        @Override
        ExpNode simplify() {
            ExpNode simpOperand = operand.simplify();
            
            // --A = A
            if (simpOperand instanceof UnaryMinusNode) {
                return ((UnaryMinusNode)simpOperand).operand;
            }
            
            return new UnaryMinusNode(simpOperand);
        }
        
        public String toString() {
            return "-" + operand;
        }
    }
    
    /**
     * 도함수 계산 및 테스트
     */
    public static void testDerivatives() {
        // 파서는 이전 예제의 것을 사용
        VariableExpressionParser parser = new VariableExpressionParser();
        
        String[] expressions = {
            "x",                    // x' = 1
            "5",                    // 5' = 0
            "x + 3",                // (x + 3)' = 1
            "2 * x",                // (2x)' = 2
            "x * x",                // (x²)' = 2x
            "x * x * x",            // (x³)' = 3x²
            "3 * x + 1",            // (3x + 1)' = 3
            "(x + 1) * (x - 1)",    // (x² - 1)' = 2x
            "1 / x"                 // (1/x)' = -1/x²
        };
        
        for (String expr : expressions) {
            parser.input = expr;
            parser.pos = 0;
            
            try {
                ExpNode tree = parser.parseExpression();
                ExpNode derivative = tree.derivative();
                ExpNode simplified = derivative.simplify();
                
                System.out.println("\n원식: " + expr);
                System.out.println("파싱: " + tree);
                System.out.println("도함수: " + derivative);
                System.out.println("단순화: " + simplified);
                
                // 특정 점에서의 값 확인
                System.out.println("x=2에서:");
                System.out.printf("  f(2) = %.2f%n", tree.value(2));
                System.out.printf("  f'(2) = %.2f%n", derivative.value(2));
                
            } catch (Exception e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        testDerivatives();
    }
}
```

이러한 예제들은 재귀, 트리 구조, 파싱 등의 고급 프로그래밍 개념을 실제로 구현하는 방법을 보여줍니다.