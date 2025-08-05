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
            Employee current = this;
            System.out.println("=== " + name + "의 조직 체계 ===");
            
            while (current != null) {
                System.out.println(current.position + ": " + current.name);
                current = current.supervisor;
            }
        }
        
        // 사장까지의 거리 계산
        public int getDistanceToPresident() {
            if (supervisor == null) {
                return 0;  // 본인이 사장
            }
            return 1 + supervisor.getDistanceToPresident();  // 재귀
        }
        
        // 특정 직급까지의 거리 계산
        public int getDistanceToPosition(String targetPosition) {
            if (position.equals(targetPosition)) {
                return 0;
            }
            if (supervisor == null) {
                return -1;  // 찾지 못함
            }
            
            int distance = supervisor.getDistanceToPosition(targetPosition);
            return distance == -1 ? -1 : 1 + distance;
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
        
        // 테스트
        employee.printHierarchy();
        System.out.println("\n사장까지의 거리: " + employee.getDistanceToPresident());
        System.out.println("부사장까지의 거리: " + employee.getDistanceToPosition("부사장"));
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
        
        // 노드 정보 출력
        @Override
        public String toString() {
            return "Node[" + data + "]";
        }
    }
    
    /**
     * 제네릭 노드 - 어떤 타입이든 저장 가능
     */
    static class GenericNode<T> {
        T data;
        GenericNode<T> next;
        
        public GenericNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args) {
        // 문자열 노드 체인 만들기
        Node first = new Node("첫번째");
        Node second = new Node("두번째");
        Node third = new Node("세번째");
        
        first.next = second;
        second.next = third;
        
        // 체인 출력
        System.out.println("노드 체인:");
        Node current = first;
        while (current != null) {
            System.out.print(current + " ");
            if (current.next != null) {
                System.out.print("→ ");
            }
            current = current.next;
        }
        System.out.println();
        
        // 제네릭 노드 사용
        GenericNode<Integer> intNode1 = new GenericNode<>(10);
        GenericNode<Integer> intNode2 = new GenericNode<>(20);
        intNode1.next = intNode2;
        
        System.out.println("\n정수 노드: " + intNode1.data + " → " + intNode2.data);
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
        System.out.println("=== While 루프 순회 ===");
        Node runner = head;
        int position = 0;
        
        while (runner != null) {
            System.out.printf("[%d] %s%n", position, runner.data);
            runner = runner.next;
            position++;
        }
    }
    
    /**
     * for 루프를 사용한 순회
     */
    public static void traverseWithFor(Node head) {
        System.out.println("\n=== For 루프 순회 ===");
        int position = 0;
        
        for (Node runner = head; runner != null; runner = runner.next) {
            System.out.printf("[%d] %s%n", position++, runner.data);
        }
    }
    
    /**
     * 재귀를 사용한 순회
     */
    public static void traverseRecursive(Node head, int position) {
        if (head == null) {
            return;
        }
        
        System.out.printf("[%d] %s%n", position, head.data);
        traverseRecursive(head.next, position + 1);
    }
    
    /**
     * 역순 출력 (재귀)
     */
    public static void printReversed(Node head) {
        if (head == null) {
            return;
        }
        
        printReversed(head.next);  // 먼저 나머지를 역순으로 출력
        System.out.print(head.data + " ");
    }
    
    /**
     * 조건부 순회 - 특정 조건을 만족하는 노드만 처리
     */
    public static void conditionalTraversal(Node head) {
        System.out.println("\n=== 조건부 순회 (길이 > 3인 데이터만) ===");
        Node runner = head;
        
        while (runner != null) {
            if (runner.data.length() > 3) {
                System.out.println("찾음: " + runner.data);
            }
            runner = runner.next;
        }
    }
    
    public static void main(String[] args) {
        // 연결 리스트 생성
        Node head = new Node("A");
        head.next = new Node("BB");
        head.next.next = new Node("CCC");
        head.next.next.next = new Node("DDDD");
        head.next.next.next.next = new Node("EEEEE");
        
        // 다양한 순회 방법 테스트
        traverseWithWhile(head);
        traverseWithFor(head);
        
        System.out.println("\n=== 재귀 순회 ===");
        traverseRecursive(head, 0);
        
        System.out.println("\n=== 역순 출력 ===");
        printReversed(head);
        System.out.println();
        
        conditionalTraversal(head);
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
        int total = 0;
        IntNode runner = head;
        
        while (runner != null) {
            total += runner.value;
            runner = runner.next;
        }
        
        return total;
    }
    
    /**
     * 리스트의 평균 계산
     */
    public static double average(IntNode head) {
        if (head == null) {
            throw new IllegalArgumentException("빈 리스트입니다");
        }
        
        int sum = 0;
        int count = 0;
        IntNode runner = head;
        
        while (runner != null) {
            sum += runner.value;
            count++;
            runner = runner.next;
        }
        
        return (double) sum / count;
    }
    
    /**
     * 최대값 찾기
     */
    public static int findMax(IntNode head) {
        if (head == null) {
            throw new IllegalArgumentException("빈 리스트입니다");
        }
        
        int max = head.value;
        IntNode runner = head.next;
        
        while (runner != null) {
            if (runner.value > max) {
                max = runner.value;
            }
            runner = runner.next;
        }
        
        return max;
    }
    
    /**
     * 최소값 찾기
     */
    public static int findMin(IntNode head) {
        if (head == null) {
            throw new IllegalArgumentException("빈 리스트입니다");
        }
        
        int min = head.value;
        IntNode runner = head.next;
        
        while (runner != null) {
            if (runner.value < min) {
                min = runner.value;
            }
            runner = runner.next;
        }
        
        return min;
    }
    
    /**
     * 짝수만 카운트
     */
    public static int countEvens(IntNode head) {
        int count = 0;
        IntNode runner = head;
        
        while (runner != null) {
            if (runner.value % 2 == 0) {
                count++;
            }
            runner = runner.next;
        }
        
        return count;
    }
    
    /**
     * 리스트 출력
     */
    public static void printList(IntNode head) {
        IntNode runner = head;
        System.out.print("리스트: ");
        
        while (runner != null) {
            System.out.print(runner.value);
            if (runner.next != null) {
                System.out.print(" → ");
            }
            runner = runner.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 정수 리스트 생성: 3 → 7 → 2 → 9 → 4 → 6
        IntNode head = new IntNode(3);
        head.next = new IntNode(7);
        head.next.next = new IntNode(2);
        head.next.next.next = new IntNode(9);
        head.next.next.next.next = new IntNode(4);
        head.next.next.next.next.next = new IntNode(6);
        
        printList(head);
        
        System.out.println("합계: " + sum(head));
        System.out.println("평균: " + average(head));
        System.out.println("최대값: " + findMax(head));
        System.out.println("최소값: " + findMin(head));
        System.out.println("짝수 개수: " + countEvens(head));
    }
}
```

## 3. 연결 리스트 클래스 구현

### 예제 3-1: 완전한 StringList 클래스

```java
public class StringListComplete {
    
    private Node head;
    private int size;  // 크기를 추적하여 성능 향상
    
    private static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public StringListComplete() {
        head = null;
        size = 0;
    }
    
    /**
     * 리스트가 비어있는지 확인
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * 리스트의 크기 반환
     */
    public int size() {
        return size;
    }
    
    /**
     * 맨 앞에 추가
     */
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * 맨 뒤에 추가
     */
    public void addLast(String data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        size++;
    }
    
    /**
     * 특정 인덱스에 추가
     */
    public void add(int index, String data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("인덱스: " + index + ", 크기: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node runner = head;
        
        // index-1 위치까지 이동
        for (int i = 0; i < index - 1; i++) {
            runner = runner.next;
        }
        
        newNode.next = runner.next;
        runner.next = newNode;
        size++;
    }
    
    /**
     * 특정 항목 검색
     */
    public boolean contains(String data) {
        Node runner = head;
        
        while (runner != null) {
            if (runner.data.equals(data)) {
                return true;
            }
            runner = runner.next;
        }
        
        return false;
    }
    
    /**
     * 인덱스로 항목 가져오기
     */
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("인덱스: " + index + ", 크기: " + size);
        }
        
        Node runner = head;
        for (int i = 0; i < index; i++) {
            runner = runner.next;
        }
        
        return runner.data;
    }
    
    /**
     * 첫 번째 항목 제거
     */
    public String removeFirst() {
        if (head == null) {
            throw new IllegalStateException("빈 리스트입니다");
        }
        
        String data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    /**
     * 마지막 항목 제거
     */
    public String removeLast() {
        if (head == null) {
            throw new IllegalStateException("빈 리스트입니다");
        }
        
        if (head.next == null) {
            String data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node runner = head;
        while (runner.next.next != null) {
            runner = runner.next;
        }
        
        String data = runner.next.data;
        runner.next = null;
        size--;
        return data;
    }
    
    /**
     * 특정 항목 제거
     */
    public boolean remove(String data) {
        if (head == null) {
            return false;
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        
        Node runner = head;
        while (runner.next != null) {
            if (runner.next.data.equals(data)) {
                runner.next = runner.next.next;
                size--;
                return true;
            }
            runner = runner.next;
        }
        
        return false;
    }
    
    /**
     * 리스트 비우기
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * 리스트를 배열로 변환
     */
    public String[] toArray() {
        String[] array = new String[size];
        Node runner = head;
        
        for (int i = 0; i < size; i++) {
            array[i] = runner.data;
            runner = runner.next;
        }
        
        return array;
    }
    
    /**
     * 리스트 출력
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
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
        StringListComplete list = new StringListComplete();
        
        System.out.println("=== StringList 테스트 ===");
        
        // 항목 추가
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");
        list.add(2, "B.5");
        
        System.out.println("리스트: " + list);
        System.out.println("크기: " + list.size());
        
        // 검색
        System.out.println("\n'C' 포함? " + list.contains("C"));
        System.out.println("'Z' 포함? " + list.contains("Z"));
        System.out.println("인덱스 2의 항목: " + list.get(2));
        
        // 제거
        System.out.println("\n첫 번째 제거: " + list.removeFirst());
        System.out.println("마지막 제거: " + list.removeLast());
        System.out.println("'B.5' 제거: " + list.remove("B.5"));
        
        System.out.println("최종 리스트: " + list);
        
        // 배열로 변환
        String[] array = list.toArray();
        System.out.print("배열: ");
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
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
        Node newNode = new Node(data);
        
        // 빈 리스트이거나 맨 앞에 삽입해야 하는 경우
        if (head == null || head.data.compareTo(data) >= 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        // 삽입 위치 찾기
        Node runner = head;
        while (runner.next != null && runner.next.data.compareTo(data) < 0) {
            runner = runner.next;
        }
        
        // runner와 runner.next 사이에 삽입
        newNode.next = runner.next;
        runner.next = newNode;
    }
    
    /**
     * 정렬된 리스트에서 이진 탐색처럼 효율적으로 검색
     * (실제로는 연결 리스트에서 이진 탐색은 불가능하지만, 
     *  조기 종료로 평균 성능 향상)
     */
    public boolean containsOptimized(String data) {
        Node runner = head;
        
        while (runner != null) {
            int comparison = runner.data.compareTo(data);
            
            if (comparison == 0) {
                return true;  // 찾음
            } else if (comparison > 0) {
                return false;  // 정렬된 리스트에서 이미 지나침
            }
            
            runner = runner.next;
        }
        
        return false;
    }
    
    /**
     * 두 정렬된 리스트를 병합
     */
    public static SortedStringList merge(SortedStringList list1, SortedStringList list2) {
        SortedStringList result = new SortedStringList();
        Node runner1 = list1.head;
        Node runner2 = list2.head;
        
        // 두 리스트를 동시에 순회하며 작은 것부터 추가
        while (runner1 != null && runner2 != null) {
            if (runner1.data.compareTo(runner2.data) <= 0) {
                result.insertAtEnd(runner1.data);
                runner1 = runner1.next;
            } else {
                result.insertAtEnd(runner2.data);
                runner2 = runner2.next;
            }
        }
        
        // 남은 요소들 추가
        while (runner1 != null) {
            result.insertAtEnd(runner1.data);
            runner1 = runner1.next;
        }
        
        while (runner2 != null) {
            result.insertAtEnd(runner2.data);
            runner2 = runner2.next;
        }
        
        return result;
    }
    
    // 내부 사용을 위한 끝에 추가 메서드 (이미 정렬된 데이터용)
    private void insertAtEnd(String data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node runner = head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
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
        SortedStringList list1 = new SortedStringList();
        
        // 무작위 순서로 삽입해도 정렬됨
        list1.insert("Dog");
        list1.insert("Cat");
        list1.insert("Elephant");
        list1.insert("Bird");
        list1.insert("Ant");
        
        System.out.println("정렬된 리스트1: " + list1);
        
        // 검색 테스트
        System.out.println("'Cat' 검색: " + list1.containsOptimized("Cat"));
        System.out.println("'Fish' 검색: " + list1.containsOptimized("Fish"));
        
        // 두 번째 리스트
        SortedStringList list2 = new SortedStringList();
        list2.insert("Bear");
        list2.insert("Duck");
        list2.insert("Fox");
        
        System.out.println("\n정렬된 리스트2: " + list2);
        
        // 병합
        SortedStringList merged = merge(list1, list2);
        System.out.println("\n병합된 리스트: " + merged);
    }
}
```

## 4. 고급 연결 리스트 연산

### 예제 4-1: 리스트 조작 연산

```java
public class AdvancedListOperations {
    
    static class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
        }
    }
    
    static class LinkedList {
        Node head;
        
        /**
         * 리스트 뒤집기 (반복)
         */
        public void reverseIterative() {
            Node previous = null;
            Node current = head;
            Node next = null;
            
            while (current != null) {
                next = current.next;      // 다음 노드 저장
                current.next = previous;  // 포인터 반전
                previous = current;       // 이동
                current = next;
            }
            
            head = previous;
        }
        
        /**
         * 리스트 뒤집기 (재귀)
         */
        public void reverseRecursive() {
            head = reverseRecursiveHelper(head);
        }
        
        private Node reverseRecursiveHelper(Node node) {
            // 기저 사례: 빈 리스트나 단일 노드
            if (node == null || node.next == null) {
                return node;
            }
            
            // 나머지 리스트를 재귀적으로 뒤집기
            Node reversedList = reverseRecursiveHelper(node.next);
            
            // 현재 노드를 뒤집힌 리스트의 끝에 추가
            node.next.next = node;
            node.next = null;
            
            return reversedList;
        }
        
        /**
         * 중복 제거 (정렬된 리스트)
         */
        public void removeDuplicatesSorted() {
            if (head == null) return;
            
            Node current = head;
            
            while (current.next != null) {
                if (current.data.equals(current.next.data)) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
        
        /**
         * 중복 제거 (정렬되지 않은 리스트)
         */
        public void removeDuplicatesUnsorted() {
            if (head == null) return;
            
            Node current = head;
            
            while (current != null) {
                Node runner = current;
                
                // current 이후의 모든 중복 제거
                while (runner.next != null) {
                    if (runner.next.data.equals(current.data)) {
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }
                }
                
                current = current.next;
            }
        }
        
        /**
         * k번째 마지막 요소 찾기
         */
        public String findKthFromEnd(int k) {
            if (k <= 0) {
                throw new IllegalArgumentException("k는 양수여야 합니다");
            }
            
            Node fast = head;
            Node slow = head;
            
            // fast를 k칸 앞으로 이동
            for (int i = 0; i < k; i++) {
                if (fast == null) {
                    throw new IllegalArgumentException("리스트가 너무 짧습니다");
                }
                fast = fast.next;
            }
            
            // fast와 slow를 함께 이동
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            
            return slow.data;
        }
        
        /**
         * 리스트의 중간 노드 찾기
         */
        public String findMiddle() {
            if (head == null) {
                throw new IllegalStateException("빈 리스트입니다");
            }
            
            Node slow = head;
            Node fast = head;
            
            // fast는 2칸씩, slow는 1칸씩 이동
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            
            return slow.data;
        }
        
        /**
         * 순환(cycle) 검출
         */
        public boolean hasCycle() {
            if (head == null) return false;
            
            Node slow = head;
            Node fast = head;
            
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                
                if (slow == fast) {
                    return true;  // 순환 발견
                }
            }
            
            return false;
        }
        
        /**
         * 리스트를 k개씩 그룹으로 뒤집기
         */
        public void reverseInGroups(int k) {
            head = reverseInGroupsHelper(head, k);
        }
        
        private Node reverseInGroupsHelper(Node head, int k) {
            Node current = head;
            Node next = null;
            Node prev = null;
            
            int count = 0;
            Node temp = head;
            
            // k개의 노드가 있는지 확인
            while (count < k && temp != null) {
                temp = temp.next;
                count++;
            }
            
            // k개 미만이면 그대로 반환
            if (count < k) {
                return head;
            }
            
            // k개의 노드를 뒤집기
            count = 0;
            while (count < k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            
            // 재귀적으로 나머지 처리
            if (next != null) {
                head.next = reverseInGroupsHelper(next, k);
            }
            
            return prev;
        }
        
        // 유틸리티 메서드들
        public void add(String data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = newNode;
                return;
            }
            
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        
        @Override
        public String toString() {
            if (head == null) return "[]";
            
            StringBuilder sb = new StringBuilder("[");
            Node runner = head;
            
            while (runner != null) {
                sb.append(runner.data);
                if (runner.next != null) {
                    sb.append(" → ");
                }
                runner = runner.next;
            }
            
            sb.append("]");
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // 리스트 생성
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        System.out.println("원본 리스트: " + list);
        
        // 뒤집기 테스트
        LinkedList list1 = new LinkedList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.reverseIterative();
        System.out.println("\n뒤집기 (반복): " + list1);
        
        LinkedList list2 = new LinkedList();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.reverseRecursive();
        System.out.println("뒤집기 (재귀): " + list2);
        
        // 중복 제거
        LinkedList list3 = new LinkedList();
        list3.add("A");
        list3.add("B");
        list3.add("B");
        list3.add("C");
        list3.add("A");
        list3.add("D");
        System.out.println("\n중복 있는 리스트: " + list3);
        list3.removeDuplicatesUnsorted();
        System.out.println("중복 제거 후: " + list3);
        
        // k번째 마지막 요소
        System.out.println("\n" + list + "에서");
        System.out.println("뒤에서 2번째: " + list.findKthFromEnd(2));
        System.out.println("중간 요소: " + list.findMiddle());
        
        // 그룹 뒤집기
        LinkedList list4 = new LinkedList();
        for (int i = 1; i <= 7; i++) {
            list4.add(String.valueOf(i));
        }
        System.out.println("\n원본: " + list4);
        list4.reverseInGroups(3);
        System.out.println("3개씩 뒤집기: " + list4);
    }
}
```

### 예제 4-2: 두 리스트 연산

```java
public class TwoListOperations {
    
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
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        Node dummy = new Node(0);  // 더미 노드로 코드 단순화
        Node current = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        
        // 남은 노드들 연결
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
        
        return dummy.next;
    }
    
    /**
     * 두 리스트의 교집합 찾기
     */
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node current = dummy;
        
        Node runner1 = head1;
        Node runner2 = head2;
        
        // 두 리스트가 정렬되어 있다고 가정
        while (runner1 != null && runner2 != null) {
            if (runner1.data == runner2.data) {
                current.next = new Node(runner1.data);
                current = current.next;
                runner1 = runner1.next;
                runner2 = runner2.next;
            } else if (runner1.data < runner2.data) {
                runner1 = runner1.next;
            } else {
                runner2 = runner2.next;
            }
        }
        
        return dummy.next;
    }
    
    /**
     * 두 리스트의 합집합 찾기 (중복 제거)
     */
    public static Node findUnion(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node current = dummy;
        
        Node runner1 = head1;
        Node runner2 = head2;
        
        // 두 리스트가 정렬되어 있다고 가정
        while (runner1 != null && runner2 != null) {
            if (runner1.data == runner2.data) {
                current.next = new Node(runner1.data);
                current = current.next;
                runner1 = runner1.next;
                runner2 = runner2.next;
            } else if (runner1.data < runner2.data) {
                current.next = new Node(runner1.data);
                current = current.next;
                runner1 = runner1.next;
            } else {
                current.next = new Node(runner2.data);
                current = current.next;
                runner2 = runner2.next;
            }
        }
        
        // 남은 요소들 추가
        while (runner1 != null) {
            current.next = new Node(runner1.data);
            current = current.next;
            runner1 = runner1.next;
        }
        
        while (runner2 != null) {
            current.next = new Node(runner2.data);
            current = current.next;
            runner2 = runner2.next;
        }
        
        return dummy.next;
    }
    
    /**
     * 두 리스트가 교차하는 노드 찾기 (실제 노드가 공유되는 경우)
     */
    public static Node findIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        
        // 각 리스트의 길이 계산
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        
        // 긴 리스트를 차이만큼 앞으로 이동
        Node runner1 = head1;
        Node runner2 = head2;
        
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                runner1 = runner1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                runner2 = runner2.next;
            }
        }
        
        // 같은 노드를 찾을 때까지 함께 이동
        while (runner1 != null && runner2 != null) {
            if (runner1 == runner2) {
                return runner1;
            }
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        
        return null;
    }
    
    private static int getLength(Node head) {
        int length = 0;
        Node runner = head;
        
        while (runner != null) {
            length++;
            runner = runner.next;
        }
        
        return length;
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
    
    public static Node createList(int[] values) {
        if (values.length == 0) return null;
        
        Node head = new Node(values[0]);
        Node current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        // 테스트용 리스트 생성
        Node list1 = createList(new int[]{1, 3, 5, 7, 9});
        Node list2 = createList(new int[]{2, 3, 6, 7, 10});
        
        printList("리스트1", list1);
        printList("리스트2", list2);
        
        // 병합
        Node merged = mergeSortedLists(
            createList(new int[]{1, 3, 5, 7, 9}),
            createList(new int[]{2, 3, 6, 7, 10})
        );
        printList("\n병합된 리스트", merged);
        
        // 교집합
        Node intersection = findIntersection(list1, list2);
        printList("\n교집합", intersection);
        
        // 합집합
        Node union = findUnion(
            createList(new int[]{1, 3, 5, 7, 9}),
            createList(new int[]{2, 3, 6, 7, 10})
        );
        printList("\n합집합", union);
        
        // 교차 노드 테스트
        System.out.println("\n=== 교차 노드 테스트 ===");
        Node common = new Node(99);
        common.next = new Node(100);
        
        Node list3 = createList(new int[]{1, 2, 3});
        Node list4 = createList(new int[]{10, 20});
        
        // list3의 끝에 common 연결
        Node runner = list3;
        while (runner.next != null) runner = runner.next;
        runner.next = common;
        
        // list4의 끝에 common 연결
        runner = list4;
        while (runner.next != null) runner = runner.next;
        runner.next = common;
        
        printList("리스트3", list3);
        printList("리스트4", list4);
        
        Node intersectionNode = findIntersectionNode(list3, list4);
        if (intersectionNode != null) {
            System.out.println("교차 노드의 값: " + intersectionNode.data);
        } else {
            System.out.println("교차 노드 없음");
        }
    }
}
```

## 5. 연결 리스트 응용

### 예제 5-1: 스택과 큐 구현

```java
public class LinkedListApplications {
    
    /**
     * 연결 리스트를 사용한 스택 구현
     */
    static class LinkedStack<T> {
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
            Node<T> newNode = new Node<>(data);
            newNode.next = top;
            top = newNode;
            size++;
        }
        
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("스택이 비어있습니다");
            }
            
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
        
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("스택이 비어있습니다");
            }
            return top.data;
        }
        
        public boolean isEmpty() {
            return top == null;
        }
        
        public int size() {
            return size;
        }
    }
    
    /**
     * 연결 리스트를 사용한 큐 구현
     */
    static class LinkedQueue<T> {
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
            Node<T> newNode = new Node<>(data);
            
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
                throw new IllegalStateException("큐가 비어있습니다");
            }
            
            T data = front.data;
            front = front.next;
            
            if (front == null) {
                rear = null;
            }
            
            size--;
            return data;
        }
        
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("큐가 비어있습니다");
            }
            return front.data;
        }
        
        public boolean isEmpty() {
            return front == null;
        }
        
        public int size() {
            return size;
        }
    }
    
    /**
     * 양방향 연결 리스트 (Doubly Linked List)
     */
    static class DoublyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;
        
        private static class Node<T> {
            T data;
            Node<T> prev;
            Node<T> next;
            
            Node(T data) {
                this.data = data;
            }
        }
        
        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);
            
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }
        
        public void addLast(T data) {
            Node<T> newNode = new Node<>(data);
            
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }
        
        public T removeFirst() {
            if (head == null) {
                throw new IllegalStateException("리스트가 비어있습니다");
            }
            
            T data = head.data;
            head = head.next;
            
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            
            size--;
            return data;
        }
        
        public T removeLast() {
            if (tail == null) {
                throw new IllegalStateException("리스트가 비어있습니다");
            }
            
            T data = tail.data;
            tail = tail.prev;
            
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
            
            size--;
            return data;
        }
        
        public void printForward() {
            System.out.print("정방향: ");
            Node<T> runner = head;
            
            while (runner != null) {
                System.out.print(runner.data);
                if (runner.next != null) {
                    System.out.print(" ⇄ ");
                }
                runner = runner.next;
            }
            System.out.println();
        }
        
        public void printBackward() {
            System.out.print("역방향: ");
            Node<T> runner = tail;
            
            while (runner != null) {
                System.out.print(runner.data);
                if (runner.prev != null) {
                    System.out.print(" ⇄ ");
                }
                runner = runner.prev;
            }
            System.out.println();
        }
        
        public int size() {
            return size;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 연결 리스트 기반 스택 ===");
        LinkedStack<String> stack = new LinkedStack<>();
        
        stack.push("첫번째");
        stack.push("두번째");
        stack.push("세번째");
        
        System.out.println("스택 크기: " + stack.size());
        System.out.println("peek: " + stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }
        
        System.out.println("\n=== 연결 리스트 기반 큐 ===");
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("큐 크기: " + queue.size());
        System.out.println("peek: " + queue.peek());
        
        while (!queue.isEmpty()) {
            System.out.println("dequeue: " + queue.dequeue());
        }
        
        System.out.println("\n=== 양방향 연결 리스트 ===");
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        
        dll.addLast("B");
        dll.addFirst("A");
        dll.addLast("C");
        dll.addFirst("Z");
        
        dll.printForward();
        dll.printBackward();
        
        System.out.println("\n첫번째 제거: " + dll.removeFirst());
        System.out.println("마지막 제거: " + dll.removeLast());
        
        dll.printForward();
    }
}
```

이제 다음 파일들을 계속 작성하겠습니다.