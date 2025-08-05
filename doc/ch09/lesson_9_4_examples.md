# 9.4 이진 트리 - 예제 모음

## 1. 기본 트리 구조와 생성

### 예제 1-1: 트리 노드 클래스

```java
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    // 생성자들
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
```

### 예제 1-2: 수동으로 트리 생성하기

```java
public class TreeCreationExample {
    public static void main(String[] args) {
        // 방법 1: 개별 노드 생성 후 연결
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // 방법 2: 중첩된 생성자 사용
        TreeNode tree = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5)
            ),
            new TreeNode(3,
                null,
                new TreeNode(6)
            )
        );
        
        System.out.println("트리가 생성되었습니다!");
        printTree(tree);
    }
    
    // 트리 시각화 (간단한 버전)
    public static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }
    
    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null) return;
        
        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.data);
        
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeHelper(node.left, prefix + (isLast ? "    " : "│   "), false);
            }
            if (node.right != null) {
                printTreeHelper(node.right, prefix + (isLast ? "    " : "│   "), true);
            }
        }
    }
}
```

## 2. 트리 순회 예제

### 예제 2-1: 모든 순회 방법 비교

```java
public class TreeTraversalExample {
    
    // 전위 순회 (루트 → 왼쪽 → 오른쪽)
    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    // 중위 순회 (왼쪽 → 루트 → 오른쪽)
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    // 후위 순회 (왼쪽 → 오른쪽 → 루트)
    public static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    // 레벨 순회 (너비 우선 탐색)
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
    
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, null, new TreeNode(6))
        );
        
        System.out.println("전위 순회: ");
        preorder(root);  // 1 2 4 5 3 6
        
        System.out.println("\n중위 순회: ");
        inorder(root);   // 4 2 5 1 3 6
        
        System.out.println("\n후위 순회: ");
        postorder(root); // 4 5 2 6 3 1
        
        System.out.println("\n레벨 순회: ");
        levelOrder(root); // 1 2 3 4 5 6
    }
}
```

### 예제 2-2: 순회를 활용한 트리 문제 해결

```java
public class TreeTraversalApplications {
    
    // 트리의 모든 노드 합계 구하기
    public static int sumTree(TreeNode root) {
        if (root == null) return 0;
        return root.data + sumTree(root.left) + sumTree(root.right);
    }
    
    // 트리의 최대값 찾기
    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }
    
    // 특정 값이 트리에 있는지 확인
    public static boolean contains(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        
        return contains(root.left, target) || contains(root.right, target);
    }
    
    // 트리의 높이 구하기
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    // 잎 노드의 개수 세기
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    // 모든 경로 출력하기
    public static void printPaths(TreeNode root) {
        int[] path = new int[1000];
        printPathsHelper(root, path, 0);
    }
    
    private static void printPathsHelper(TreeNode node, int[] path, int pathLen) {
        if (node == null) return;
        
        path[pathLen] = node.data;
        pathLen++;
        
        if (node.left == null && node.right == null) {
            // 잎 노드에 도달하면 경로 출력
            System.out.print("경로: ");
            for (int i = 0; i < pathLen; i++) {
                System.out.print(path[i]);
                if (i < pathLen - 1) System.out.print(" → ");
            }
            System.out.println();
        } else {
            printPathsHelper(node.left, path, pathLen);
            printPathsHelper(node.right, path, pathLen);
        }
    }
}
```

## 3. 이진 정렬 트리 구현

### 예제 3-1: 완전한 BST 클래스

```java
public class BinarySearchTree {
    private TreeNode root;
    
    private static class TreeNode {
        int data;
        TreeNode left, right;
        
        TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 삽입 (재귀적)
    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        
        if (value < node.data) {
            node.left = insertRec(node.left, value);
        } else if (value > node.data) {
            node.right = insertRec(node.right, value);
        }
        // 중복값은 무시
        
        return node;
    }
    
    // 삽입 (반복적)
    public void insertIterative(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        
        TreeNode current = root;
        TreeNode parent = null;
        
        while (current != null) {
            parent = current;
            if (value < current.data) {
                current = current.left;
            } else if (value > current.data) {
                current = current.right;
            } else {
                return; // 중복값
            }
        }
        
        if (value < parent.data) {
            parent.left = new TreeNode(value);
        } else {
            parent.right = new TreeNode(value);
        }
    }
    
    // 검색
    public boolean contains(int value) {
        return containsRec(root, value);
    }
    
    private boolean containsRec(TreeNode node, int value) {
        if (node == null) return false;
        if (value == node.data) return true;
        
        if (value < node.data) {
            return containsRec(node.left, value);
        } else {
            return containsRec(node.right, value);
        }
    }
    
    // 최소값 찾기
    public int findMin() {
        if (root == null) throw new IllegalStateException("트리가 비어있습니다");
        return findMinNode(root).data;
    }
    
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    // 최대값 찾기
    public int findMax() {
        if (root == null) throw new IllegalStateException("트리가 비어있습니다");
        
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }
    
    // 삭제 (복잡한 연산)
    public void delete(int value) {
        root = deleteRec(root, value);
    }
    
    private TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) return null;
        
        if (value < node.data) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRec(node.right, value);
        } else {
            // 삭제할 노드를 찾음
            
            // 경우 1: 잎 노드
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // 경우 2: 자식이 하나인 노드
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            
            // 경우 3: 자식이 둘인 노드
            // 오른쪽 서브트리의 최소값으로 대체
            TreeNode minNode = findMinNode(node.right);
            node.data = minNode.data;
            node.right = deleteRec(node.right, minNode.data);
        }
        
        return node;
    }
    
    // 중위 순회로 정렬된 출력
    public void printInOrder() {
        inOrderRec(root);
        System.out.println();
    }
    
    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }
}
```

### 예제 3-2: BST 활용 예제

```java
public class BSTApplicationExample {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // 데이터 삽입
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35};
        for (int val : values) {
            bst.insert(val);
        }
        
        // 정렬된 출력
        System.out.print("정렬된 순서: ");
        bst.printInOrder();  // 10 20 25 30 35 40 50 60 70 80
        
        // 검색
        System.out.println("25가 있나요? " + bst.contains(25));  // true
        System.out.println("45가 있나요? " + bst.contains(45));  // false
        
        // 최소/최대값
        System.out.println("최소값: " + bst.findMin());  // 10
        System.out.println("최대값: " + bst.findMax());  // 80
        
        // 삭제
        bst.delete(30);  // 자식이 둘인 노드 삭제
        System.out.print("30 삭제 후: ");
        bst.printInOrder();  // 10 20 25 35 40 50 60 70 80
    }
}
```

## 4. 수식 트리 예제

### 예제 4-1: 객체지향적 수식 트리

```java
// 추상 클래스
abstract class ExprNode {
    abstract double evaluate();
    abstract String toInfix();
    abstract String toPostfix();
}

// 숫자 노드
class NumberNode extends ExprNode {
    private double value;
    
    public NumberNode(double value) {
        this.value = value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }
    
    @Override
    public String toInfix() {
        return String.valueOf(value);
    }
    
    @Override
    public String toPostfix() {
        return String.valueOf(value);
    }
}

// 이항 연산자 노드
class BinaryOpNode extends ExprNode {
    private char operator;
    private ExprNode left;
    private ExprNode right;
    
    public BinaryOpNode(char op, ExprNode left, ExprNode right) {
        this.operator = op;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        
        switch (operator) {
            case '+': return leftVal + rightVal;
            case '-': return leftVal - rightVal;
            case '*': return leftVal * rightVal;
            case '/': 
                if (rightVal == 0) throw new ArithmeticException("0으로 나눔");
                return leftVal / rightVal;
            case '^': return Math.pow(leftVal, rightVal);
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    @Override
    public String toInfix() {
        return "(" + left.toInfix() + " " + operator + " " + right.toInfix() + ")";
    }
    
    @Override
    public String toPostfix() {
        return left.toPostfix() + " " + right.toPostfix() + " " + operator;
    }
}

// 단항 연산자 노드
class UnaryOpNode extends ExprNode {
    private String operator;
    private ExprNode operand;
    
    public UnaryOpNode(String op, ExprNode operand) {
        this.operator = op;
        this.operand = operand;
    }
    
    @Override
    public double evaluate() {
        double val = operand.evaluate();
        
        switch (operator) {
            case "-": return -val;
            case "sqrt": return Math.sqrt(val);
            case "abs": return Math.abs(val);
            case "sin": return Math.sin(val);
            case "cos": return Math.cos(val);
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    @Override
    public String toInfix() {
        return operator + "(" + operand.toInfix() + ")";
    }
    
    @Override
    public String toPostfix() {
        return operand.toPostfix() + " " + operator;
    }
}
```

### 예제 4-2: 수식 트리 사용 예제

```java
public class ExpressionTreeExample {
    public static void main(String[] args) {
        // 수식: (3 + 4) * 5
        ExprNode expr1 = new BinaryOpNode('*',
            new BinaryOpNode('+',
                new NumberNode(3),
                new NumberNode(4)
            ),
            new NumberNode(5)
        );
        
        System.out.println("수식 1:");
        System.out.println("중위 표기법: " + expr1.toInfix());
        System.out.println("후위 표기법: " + expr1.toPostfix());
        System.out.println("계산 결과: " + expr1.evaluate());
        
        // 수식: sqrt(16) + 3^2
        ExprNode expr2 = new BinaryOpNode('+',
            new UnaryOpNode("sqrt", new NumberNode(16)),
            new BinaryOpNode('^', new NumberNode(3), new NumberNode(2))
        );
        
        System.out.println("\n수식 2:");
        System.out.println("중위 표기법: " + expr2.toInfix());
        System.out.println("계산 결과: " + expr2.evaluate());
        
        // 복잡한 수식: ((10 - 5) * 2) / (3 + 1)
        ExprNode expr3 = new BinaryOpNode('/',
            new BinaryOpNode('*',
                new BinaryOpNode('-',
                    new NumberNode(10),
                    new NumberNode(5)
                ),
                new NumberNode(2)
            ),
            new BinaryOpNode('+',
                new NumberNode(3),
                new NumberNode(1)
            )
        );
        
        System.out.println("\n수식 3:");
        System.out.println("중위 표기법: " + expr3.toInfix());
        System.out.println("후위 표기법: " + expr3.toPostfix());
        System.out.println("계산 결과: " + expr3.evaluate());
    }
}
```

## 5. 트리 관련 고급 문제

### 예제 5-1: 트리 비교와 변환

```java
public class TreeAdvancedOperations {
    
    // 두 트리가 동일한지 확인
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        return p.data == q.data 
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
    
    // 트리가 대칭인지 확인
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        return t1.data == t2.data
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
    
    // 트리 뒤집기 (좌우 반전)
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
    }
    
    // 배열을 균형 BST로 변환
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
    
    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        
        return node;
    }
    
    // 트리를 연결 리스트로 평탄화 (전위 순회 순서)
    public static void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = temp;
    }
}
```

### 예제 5-2: 트리 경로 문제

```java
public class TreePathProblems {
    
    // 루트에서 잎까지의 모든 경로 반환
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfsPath(root, "", paths);
        }
        return paths;
    }
    
    private static void dfsPath(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.data);
            return;
        }
        
        if (node.left != null) {
            dfsPath(node.left, path + node.data + "->", paths);
        }
        if (node.right != null) {
            dfsPath(node.right, path + node.data + "->", paths);
        }
    }
    
    // 경로 합계가 특정 값인지 확인
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }
        
        return hasPathSum(root.left, targetSum - root.data)
            || hasPathSum(root.right, targetSum - root.data);
    }
    
    // 모든 경로의 합계 중 최대값
    public static int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSumHelper(root, max);
        return max[0];
    }
    
    private static int maxPathSumHelper(TreeNode node, int[] max) {
        if (node == null) return 0;
        
        int left = Math.max(0, maxPathSumHelper(node.left, max));
        int right = Math.max(0, maxPathSumHelper(node.right, max));
        
        max[0] = Math.max(max[0], left + right + node.data);
        
        return Math.max(left, right) + node.data;
    }
    
    // 가장 낮은 공통 조상(LCA) 찾기
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
```

## 6. 실전 응용: 파일 시스템 트리

```java
import java.io.File;

public class FileSystemTree {
    
    static class FileNode {
        String name;
        boolean isDirectory;
        long size;
        List<FileNode> children;
        
        FileNode(String name, boolean isDirectory) {
            this.name = name;
            this.isDirectory = isDirectory;
            this.children = new ArrayList<>();
        }
    }
    
    // 디렉토리를 트리로 변환
    public static FileNode buildFileTree(String path) {
        File file = new File(path);
        return buildFileTreeHelper(file);
    }
    
    private static FileNode buildFileTreeHelper(File file) {
        FileNode node = new FileNode(file.getName(), file.isDirectory());
        
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File child : files) {
                    node.children.add(buildFileTreeHelper(child));
                }
            }
        } else {
            node.size = file.length();
        }
        
        return node;
    }
    
    // 트리 형태로 출력
    public static void printFileTree(FileNode node, String indent) {
        System.out.println(indent + (node.isDirectory ? "[D] " : "[F] ") + 
                          node.name + (node.isDirectory ? "" : " (" + node.size + " bytes)"));
        
        for (int i = 0; i < node.children.size(); i++) {
            boolean isLast = (i == node.children.size() - 1);
            printFileTree(node.children.get(i), 
                         indent + (isLast ? "    " : "│   "));
        }
    }
    
    // 특정 확장자의 파일 찾기
    public static List<String> findFilesByExtension(FileNode root, String extension) {
        List<String> result = new ArrayList<>();
        findFilesByExtensionHelper(root, extension, "", result);
        return result;
    }
    
    private static void findFilesByExtensionHelper(FileNode node, String extension, 
                                                  String path, List<String> result) {
        String currentPath = path.isEmpty() ? node.name : path + "/" + node.name;
        
        if (!node.isDirectory && node.name.endsWith(extension)) {
            result.add(currentPath);
        }
        
        for (FileNode child : node.children) {
            findFilesByExtensionHelper(child, extension, currentPath, result);
        }
    }
    
    // 디렉토리 크기 계산
    public static long calculateSize(FileNode node) {
        if (!node.isDirectory) {
            return node.size;
        }
        
        long totalSize = 0;
        for (FileNode child : node.children) {
            totalSize += calculateSize(child);
        }
        
        node.size = totalSize;  // 캐싱
        return totalSize;
    }
}
```

이러한 예제들은 이진 트리의 다양한 활용 방법을 보여줍니다. 기본적인 순회부터 복잡한 수식 계산, 파일 시스템 표현까지 트리는 매우 유용한 자료구조입니다.