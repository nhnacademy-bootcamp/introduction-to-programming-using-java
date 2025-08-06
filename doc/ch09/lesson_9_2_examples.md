# 9.2 연결된 데이터 구조 - 예제 모음

## 1. 기본 노드와 연결 구조

### 예제 1-1: 재귀적 클래스 정의

```java
public class RecursiveClassExample {
    
    /**
     * 직원 클래스 - 감독자 관계를 표현
     */
    static class Employee {
        String name;
        String position;
        Employee supervisor;
        
        public Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }
        
        // 사장까지의 계층 구조를 출력
        public void printHierarchy() {
            // TODO: 현재 직원부터 사장까지의 조직 체계를 출력
            // 힌트: while 루프를 사용하여 supervisor가 null이 될 때까지 이동
        }
        
        // 사장까지의 거리 계산 (재귀)
        public int getDistanceToPresident() {
            // TODO: 재귀를 사용하여 사장까지의 거리 계산
            // 힌트: supervisor가 null이면 본인이 사장 (거리 0)
            //      아니면 1 + supervisor의 거리
            
            return 0; // 임시 반환값
        }
    }
    
    public static void main(String[] args) {
        // 조직 구조 생성
        Employee president = new Employee("김대표", "대표이사");
        Employee vicePresident = new Employee("이부사", "부사장");
        Employee director = new Employee("박이사", "이사");
        Employee manager = new Employee("최부장", "부장");
        Employee employee = new Employee("정사원", "사원");
        
        // 감독자 관계 설정
        employee.supervisor = manager;
        manager.supervisor = director;
        director.supervisor = vicePresident;
        vicePresident.supervisor = president;
        president.supervisor = null;
        
        // 실행 결과:
        // === 정사원의 조직 체계 ===
        // 사원: 정사원
        // 부장: 최부장
        // 이사: 박이사
        // 부사장: 이부사
        // 대표이사: 김대표
        //
        // 사장까지의 거리: 4
    }
}
```

### 예제 1-2: 기본 노드 구조

```java
public class BasicNodeExample {
    
    /**
     * 문자열을 저장하는 노드
     */
    static class Node {
        String data;
        Node next;
        
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * 노드 체인 출력하기
     */
    public static void printChain(Node head) {
        // TODO: 연결된 노드들을 순서대로 출력
        // 힌트: current가 null이 될 때까지 반복
    }
    
    /**
     * 체인의 길이 계산
     */
    public static int getChainLength(Node head) {
        // TODO: 연결된 노드의 개수 반환
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        // 노드 체인 만들기
        Node first = new Node("첫번째");
        Node second = new Node("두번째");
        Node third = new Node("세번째");
        
        first.next = second;
        second.next = third;
        
        // 실행 결과:
        // 노드 체인: Node[첫번째] → Node[두번째] → Node[세번째]
        // 체인 길이: 3
    }
}
```

## 2. 연결 리스트 순회

### 예제 2-1: 다양한 순회 방법

```java
public class LinkedListTraversalExample {
    
    static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
        }
    }
    
    /**
     * while 루프를 사용한 순회
     */
    public static void traverseWithWhile(Node head) {
        // TODO: while 루프로 리스트 순회하며 각 노드의 위치와 데이터 출력
        // 힌트: runner 변수와 position 변수 사용
    }
    
    /**
     * 재귀를 사용한 순회
     */
    public static void traverseRecursive(Node head, int position) {
        // TODO: 재귀를 사용하여 리스트 순회
        // 힌트: 기저 사례는 head == null
    }
    
    /**
     * 역순 출력 (재귀)
     */
    public static void printReversed(Node head) {
        // TODO: 재귀를 사용하여 리스트를 역순으로 출력
        // 힌트: 먼저 나머지를 재귀 호출한 후 현재 노드 출력
    }
    
    public static void main(String[] args) {
        // 연결 리스트 생성
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");
        
        // 실행 결과:
        // === While 루프 순회 ===
        // [0] A
        // [1] B
        // [2] C
        // [3] D
        //
        // === 재귀 순회 ===
        // [0] A
        // [1] B
        // [2] C
        // [3] D
        //
        // === 역순 출력 ===
        // D C B A
    }
}
```

### 예제 2-2: 정수 리스트 연산

```java
public class IntegerListOperations {
    
    static class IntNode {
        int value;
        IntNode next;
        
        IntNode(int value) {
            this.value = value;
        }
    }
    
    /**
     * 리스트의 합계 계산
     */
    public static int sum(IntNode head) {
        // TODO: 리스트의 모든 값을 합산
        
        return 0; // 임시 반환값
    }
    
    /**
     * 최대값 찾기
     */
    public static int findMax(IntNode head) {
        // TODO: 리스트에서 최대값 찾기
        // 힌트: 빈 리스트 처리 주의
        
        return 0; // 임시 반환값
    }
    
    /**
     * 짝수만 카운트
     */
    public static int countEvens(IntNode head) {
        // TODO: 짝수인 노드의 개수 카운트
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        // 정수 리스트 생성: 3 → 7 → 2 → 9 → 4 → 6
        IntNode head = new IntNode(3);
        head.next = new IntNode(7);
        head.next.next = new IntNode(2);
        head.next.next.next = new IntNode(9);
        head.next.next.next.next = new IntNode(4);
        head.next.next.next.next.next = new IntNode(6);
        
        // 실행 결과:
        // 리스트: 3 → 7 → 2 → 9 → 4 → 6
        // 합계: 31
        // 최대값: 9
        // 짝수 개수: 3
    }
}
```

## 3. 연결 리스트 클래스 구현

### 예제 3-1: 기본 StringList 클래스

```java
public class SimpleStringList {
    
    private Node head;
    
    private static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * 맨 앞에 추가
     */
    public void addFirst(String data) {
        // TODO: 새 노드를 리스트의 맨 앞에 추가
        // 힌트: 새 노드의 next를 현재 head로 설정
    }
    
    /**
     * 맨 뒤에 추가
     */
    public void addLast(String data) {
        // TODO: 새 노드를 리스트의 맨 뒤에 추가
        // 힌트: 빈 리스트와 그렇지 않은 경우를 구분
    }
    
    /**
     * 특정 항목 검색
     */
    public boolean contains(String data) {
        // TODO: 리스트에 해당 데이터가 있는지 확인
        
        return false; // 임시 반환값
    }
    
    /**
     * 첫 번째 항목 제거
     */
    public String removeFirst() {
        // TODO: 첫 번째 노드를 제거하고 데이터 반환
        // 힌트: 빈 리스트 처리 주의
        
        return null; // 임시 반환값
    }
    
    /**
     * 리스트 출력
     */
    @Override
    public String toString() {
        // TODO: 리스트를 문자열로 변환 [A, B, C] 형식
        
        return "[]"; // 임시 반환값
    }
    
    public static void main(String[] args) {
        SimpleStringList list = new SimpleStringList();
        
        // 실행 결과:
        // 초기 리스트: []
        // A, B 추가 후: [A, B]
        // C를 앞에 추가 후: [C, A, B]
        // D를 뒤에 추가 후: [C, A, B, D]
        // 'B' 포함? true
        // 'Z' 포함? false
        // 첫 번째 제거: C
        // 최종 리스트: [A, B, D]
    }
}
```

### 예제 3-2: 정렬된 리스트

```java
public class SortedStringList {
    
    private Node head;
    
    private static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
        }
    }
    
    /**
     * 정렬된 순서로 삽입
     */
    public void insert(String data) {
        // TODO: 알파벳 순서로 정렬된 위치에 삽입
        // 힌트: 
        // 1. 빈 리스트나 맨 앞에 삽입하는 경우
        // 2. 중간이나 끝에 삽입하는 경우
        // compareTo() 메서드 사용
    }
    
    /**
     * 정렬된 리스트에서 효율적 검색
     */
    public boolean containsOptimized(String data) {
        // TODO: 정렬된 특성을 활용한 검색
        // 힌트: 찾는 값보다 큰 값이 나오면 조기 종료
        
        return false; // 임시 반환값
    }
    
    @Override
    public String toString() {
        if (head == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node runner = head;
        
        while (runner != null) {
            sb.append(runner.data);
            if (runner.next != null) {
                sb.append(", ");
            }
            runner = runner.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SortedStringList list = new SortedStringList();
        
        // 무작위 순서로 삽입
        list.insert("Dog");
        list.insert("Cat");
        list.insert("Elephant");
        list.insert("Bird");
        list.insert("Ant");
        
        // 실행 결과:
        // 정렬된 리스트: [Ant, Bird, Cat, Dog, Elephant]
        // 'Cat' 검색: true
        // 'Fish' 검색: false
    }
}
```

## 4. 고급 연결 리스트 연산

### 예제 4-1: 리스트 뒤집기

```java
public class ListReversal {
    
    static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
        }
    }
    
    /**
     * 리스트 뒤집기 (반복)
     */
    public static Node reverseIterative(Node head) {
        // TODO: 반복문을 사용하여 리스트 뒤집기
        // 힌트: previous, current, next 포인터 사용
        
        return null; // 임시 반환값
    }
    
    /**
     * 리스트 뒤집기 (재귀)
     */
    public static Node reverseRecursive(Node head) {
        // TODO: 재귀를 사용하여 리스트 뒤집기
        // 힌트: 
        // 1. 기저 사례: 빈 리스트나 단일 노드
        // 2. 재귀 사례: 나머지를 뒤집고 현재 노드를 끝에 추가
        
        return null; // 임시 반환값
    }
    
    // 유틸리티 메서드
    public static void printList(String label, Node head) {
        System.out.print(label + ": ");
        Node runner = head;
        
        while (runner != null) {
            System.out.print(runner.data);
            if (runner.next != null) {
                System.out.print(" → ");
            }
            runner = runner.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 리스트 생성: A → B → C → D
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");
        
        // 실행 결과:
        // 원본: A → B → C → D
        // 반복 뒤집기: D → C → B → A
        // 재귀 뒤집기: D → C → B → A
    }
}
```

### 예제 4-2: 중복 제거

```java
public class RemoveDuplicates {
    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    /**
     * 정렬된 리스트에서 중복 제거
     */
    public static void removeDuplicatesSorted(Node head) {
        // TODO: 인접한 중복 요소 제거
        // 힌트: current와 current.next 비교
    }
    
    /**
     * 정렬되지 않은 리스트에서 중복 제거
     */
    public static void removeDuplicatesUnsorted(Node head) {
        // TODO: 모든 중복 요소 제거
        // 힌트: 각 노드에 대해 그 이후의 모든 노드와 비교
    }
    
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 정렬된 리스트: 1 → 1 → 2 → 3 → 3 → 3 → 4
        Node sorted = new Node(1);
        sorted.next = new Node(1);
        sorted.next.next = new Node(2);
        sorted.next.next.next = new Node(3);
        sorted.next.next.next.next = new Node(3);
        sorted.next.next.next.next.next = new Node(3);
        sorted.next.next.next.next.next.next = new Node(4);
        
        // 정렬되지 않은 리스트: 3 → 1 → 4 → 1 → 3 → 2
        Node unsorted = new Node(3);
        unsorted.next = new Node(1);
        unsorted.next.next = new Node(4);
        unsorted.next.next.next = new Node(1);
        unsorted.next.next.next.next = new Node(3);
        unsorted.next.next.next.next.next = new Node(2);
        
        // 실행 결과:
        // 정렬된 리스트 원본: 1 → 1 → 2 → 3 → 3 → 3 → 4
        // 중복 제거 후: 1 → 2 → 3 → 4
        //
        // 정렬되지 않은 리스트 원본: 3 → 1 → 4 → 1 → 3 → 2
        // 중복 제거 후: 3 → 1 → 4 → 2
    }
}
```

### 예제 4-3: 두 리스트 병합

```java
public class MergeLists {
    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    /**
     * 두 정렬된 리스트 병합
     */
    public static Node mergeSortedLists(Node head1, Node head2) {
        // TODO: 두 정렬된 리스트를 하나의 정렬된 리스트로 병합
        // 힌트:
        // 1. 빈 리스트 처리
        // 2. 더미 노드 사용으로 코드 단순화
        // 3. 두 리스트를 동시에 순회하며 작은 값 선택
        
        return null; // 임시 반환값
    }
    
    public static void printList(String label, Node head) {
        System.out.print(label + ": ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 리스트1: 1 → 3 → 5 → 7
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(7);
        
        // 리스트2: 2 → 4 → 6 → 8
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(8);
        
        // 실행 결과:
        // 리스트1: 1 → 3 → 5 → 7
        // 리스트2: 2 → 4 → 6 → 8
        // 병합 결과: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
    }
}
```

## 5. 연결 리스트 응용

### 예제 5-1: 연결 리스트 기반 스택

```java
public class LinkedStack<T> {
    
    private Node<T> top;
    private int size;
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
        }
    }
    
    public void push(T data) {
        // TODO: 스택의 맨 위에 요소 추가
    }
    
    public T pop() {
        // TODO: 스택의 맨 위 요소 제거 및 반환
        // 힌트: 빈 스택 처리
        
        return null; // 임시 반환값
    }
    
    public T peek() {
        // TODO: 스택의 맨 위 요소 확인 (제거하지 않음)
        
        return null; // 임시 반환값
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        
        // 실행 결과:
        // push: 첫번째, 두번째, 세번째
        // 스택 크기: 3
        // peek: 세번째
        // pop: 세번째
        // pop: 두번째
        // pop: 첫번째
        // 빈 스택? true
    }
}
```

### 예제 5-2: 연결 리스트 기반 큐

```java
public class LinkedQueue<T> {
    
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
        }
    }
    
    public void enqueue(T data) {
        // TODO: 큐의 뒤쪽에 요소 추가
        // 힌트: rear 포인터 활용, 빈 큐 처리
    }
    
    public T dequeue() {
        // TODO: 큐의 앞쪽에서 요소 제거 및 반환
        // 힌트: front 포인터 활용, 빈 큐 처리
        
        return null; // 임시 반환값
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        
        // 실행 결과:
        // enqueue: 10, 20, 30
        // 큐 크기: 3
        // dequeue: 10
        // dequeue: 20
        // enqueue: 40
        // dequeue: 30
        // dequeue: 40
        // 빈 큐? true
    }
}
```