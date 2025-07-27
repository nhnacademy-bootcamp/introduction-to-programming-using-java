# 9.4 이진 트리 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 이진 트리의 개념과 구조를 이해하고 설명한다
- 트리 순회(전위, 중위, 후위)를 구현하고 활용한다
- 이진 정렬 트리(BST)를 이해하고 검색/삽입 연산을 구현한다
- 수식 트리를 사용하여 수학 표현식을 표현하고 계산한다
- 재귀를 사용하여 트리 관련 문제를 해결한다

## 1. 이진 트리란?

### 1.1 기본 개념

**이진 트리(Binary Tree)**는 각 노드가 최대 두 개의 자식을 가질 수 있는 트리 구조입니다.

```java
class TreeNode {
    int item;        // 노드의 데이터
    TreeNode left;   // 왼쪽 자식을 가리키는 포인터
    TreeNode right;  // 오른쪽 자식을 가리키는 포인터
}
```

### 1.2 트리의 특징

1. **루트(Root)**: 부모가 없는 최상위 노드
2. **자식(Child)**: 어떤 노드로부터 연결된 아래쪽 노드
3. **부모(Parent)**: 어떤 노드를 가리키는 위쪽 노드
4. **잎(Leaf)**: 자식이 없는 노드

시각적 표현:
```
        1          <- 루트
       / \
      2   3        <- 1의 자식들
     / \   \
    4   5   6      <- 잎 노드들
```

### 1.3 이진 트리의 규칙

1. **단일 루트**: 부모가 없는 노드는 정확히 하나
2. **단일 부모**: 루트를 제외한 모든 노드는 정확히 하나의 부모를 가짐
3. **순환 없음**: 어떤 경로도 같은 노드로 돌아오지 않음

## 2. 트리 순회(Tree Traversal)

### 2.1 재귀적 접근

이진 트리는 재귀적 구조를 가지므로, 재귀를 사용하여 효과적으로 처리할 수 있습니다.

#### 노드 개수 세기
```java
public static int countNodes(TreeNode root) {
    if (root == null) {
        return 0;  // 빈 트리는 노드가 0개
    }
    
    // 1(현재 노드) + 왼쪽 서브트리 노드 수 + 오른쪽 서브트리 노드 수
    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

#### 트리 높이 구하기
```java
public static int getHeight(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    
    return 1 + Math.max(leftHeight, rightHeight);
}
```

### 2.2 세 가지 순회 방법

#### 1. 전위 순회(Preorder Traversal)
**순서**: 루트 → 왼쪽 → 오른쪽

```java
public static void preorderPrint(TreeNode root) {
    if (root != null) {
        System.out.print(root.item + " ");  // 1. 루트 방문
        preorderPrint(root.left);           // 2. 왼쪽 서브트리
        preorderPrint(root.right);          // 3. 오른쪽 서브트리
    }
}
```

#### 2. 중위 순회(Inorder Traversal)
**순서**: 왼쪽 → 루트 → 오른쪽

```java
public static void inorderPrint(TreeNode root) {
    if (root != null) {
        inorderPrint(root.left);            // 1. 왼쪽 서브트리
        System.out.print(root.item + " ");  // 2. 루트 방문
        inorderPrint(root.right);           // 3. 오른쪽 서브트리
    }
}
```

#### 3. 후위 순회(Postorder Traversal)
**순서**: 왼쪽 → 오른쪽 → 루트

```java
public static void postorderPrint(TreeNode root) {
    if (root != null) {
        postorderPrint(root.left);          // 1. 왼쪽 서브트리
        postorderPrint(root.right);         // 2. 오른쪽 서브트리
        System.out.print(root.item + " ");  // 3. 루트 방문
    }
}
```

### 2.3 순회 예시

다음 트리를 각 방법으로 순회하면:
```
        1
       / \
      2   3
     / \   \
    4   5   6
```

- **전위 순회**: 1 2 4 5 3 6
- **중위 순회**: 4 2 5 1 3 6
- **후위 순회**: 4 5 2 6 3 1

## 3. 이진 정렬 트리(Binary Sort Tree, BST)

### 3.1 BST의 특성

이진 정렬 트리는 다음 규칙을 따르는 특별한 이진 트리입니다:
- 각 노드의 왼쪽 서브트리의 모든 값은 해당 노드보다 작음
- 각 노드의 오른쪽 서브트리의 모든 값은 해당 노드보다 큼

```
        50
       /  \
     30    70
    /  \   /  \
   20  40 60  80
```

### 3.2 BST에서 검색

```java
public static boolean treeContains(TreeNode root, int target) {
    if (root == null) {
        return false;  // 빈 트리
    }
    
    if (target == root.item) {
        return true;   // 찾았다!
    } else if (target < root.item) {
        return treeContains(root.left, target);   // 왼쪽 검색
    } else {
        return treeContains(root.right, target);  // 오른쪽 검색
    }
}
```

#### 비재귀적 검색
```java
public static boolean treeContainsIterative(TreeNode root, int target) {
    TreeNode current = root;
    
    while (current != null) {
        if (target == current.item) {
            return true;
        } else if (target < current.item) {
            current = current.left;
        } else {
            current = current.right;
        }
    }
    
    return false;
}
```

### 3.3 BST에 삽입

```java
public static TreeNode insert(TreeNode root, int value) {
    // 빈 위치에 도달하면 새 노드 생성
    if (root == null) {
        return new TreeNode(value);
    }
    
    // BST 규칙에 따라 적절한 위치 찾기
    if (value < root.item) {
        root.left = insert(root.left, value);
    } else if (value > root.item) {
        root.right = insert(root.right, value);
    }
    // 같은 값이면 중복 허용하지 않음
    
    return root;
}
```

### 3.4 BST의 장점

1. **효율적인 검색**: 평균 O(log n)
2. **정렬된 순서**: 중위 순회시 오름차순 출력
3. **동적 크기**: 필요에 따라 노드 추가/삭제

## 4. 수식 트리(Expression Tree)

### 4.1 수식 트리의 구조

수학 표현식을 트리로 표현할 수 있습니다:
- **잎 노드**: 숫자
- **내부 노드**: 연산자

예: `3 * (7 + 1)`
```
        *
       / \
      3   +
         / \
        7   1
```

### 4.2 수식 트리 노드 설계

```java
abstract class ExpNode {
    abstract double value();  // 이 노드의 값 계산
}

class NumberNode extends ExpNode {
    double number;
    
    NumberNode(double num) {
        this.number = num;
    }
    
    double value() {
        return number;
    }
}

class OperatorNode extends ExpNode {
    char operator;
    ExpNode left, right;
    
    OperatorNode(char op, ExpNode left, ExpNode right) {
        this.operator = op;
        this.left = left;
        this.right = right;
    }
    
    double value() {
        double leftVal = left.value();
        double rightVal = right.value();
        
        switch (operator) {
            case '+': return leftVal + rightVal;
            case '-': return leftVal - rightVal;
            case '*': return leftVal * rightVal;
            case '/': return leftVal / rightVal;
            default: throw new IllegalArgumentException();
        }
    }
}
```

### 4.3 수식 트리 활용

```java
// 수식 트리 생성: 3 * (7 + 1)
ExpNode tree = new OperatorNode('*',
    new NumberNode(3),
    new OperatorNode('+',
        new NumberNode(7),
        new NumberNode(1)
    )
);

// 값 계산
double result = tree.value();  // 24.0
```

## 5. 트리의 활용 예시

### 5.1 파일 시스템
```
    /root
    /    \
  home   usr
  /  \    |
user1 user2 bin
```

### 5.2 의사결정 트리
```
    날씨는?
    /      \
  맑음     비옴
   |        |
 야외활동  실내활동
```

### 5.3 가계도/조직도
```
      CEO
     /   \
   CTO   CFO
   / \    |
 개발 QA  회계
```

## 6. 실전 예제: BST 클래스 구현

```java
public class BinarySearchTree {
    private TreeNode root;
    
    // 노드 클래스
    private static class TreeNode {
        int data;
        TreeNode left, right;
        
        TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 삽입
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
        
        return node;
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

## 마무리

이진 트리는 컴퓨터 과학의 핵심 자료구조입니다:

1. **재귀적 구조**: 자연스럽게 재귀 알고리즘과 어울림
2. **다양한 응용**: 검색, 정렬, 수식 표현, 의사결정
3. **효율성**: 균형 잡힌 트리에서 O(log n) 성능
4. **확장성**: 다양한 변형(AVL, Red-Black Tree 등)

트리를 마스터하면 복잡한 계층적 데이터를 효과적으로 다룰 수 있습니다!