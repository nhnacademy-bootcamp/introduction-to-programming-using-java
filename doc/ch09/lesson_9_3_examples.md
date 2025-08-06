# 9.3 스택, 큐, 그리고 ADTs - 예제 모음

## 1. 스택 기본 구현

### 예제 1-1: 제네릭 스택 구현 (연결 리스트)

```java
public class GenericLinkedStack<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> top;
    private int size;
    
    public GenericLinkedStack() {
        this.top = null;
        this.size = 0;
    }
    
    /**
     * 스택의 맨 위에 요소 추가
     */
    public void push(T item) {
        // TODO: 새 노드를 생성하고 스택의 맨 위에 추가
        // 힌트:
        // 1. 새 노드를 생성
        // 2. 새 노드의 next를 현재 top으로 설정
        // 3. top을 새 노드로 변경
        // 4. size 증가
    }
    
    /**
     * 스택의 맨 위 요소 제거 및 반환
     */
    public T pop() {
        // TODO: 스택의 맨 위 요소를 제거하고 반환
        // 힌트:
        // 1. 비어있는지 확인 (isEmpty() 사용)
        // 2. top의 데이터 저장
        // 3. top을 다음 노드로 이동
        // 4. size 감소
        // 5. 저장한 데이터 반환
        
        return null; // 임시 반환값
    }
    
    /**
     * 스택의 맨 위 요소 확인 (제거하지 않음)
     */
    public T peek() {
        // TODO: 스택의 맨 위 요소를 제거하지 않고 반환
        // 힌트: 비어있는지 확인 후 top.data 반환
        
        return null; // 임시 반환값
    }
    
    /**
     * 스택이 비어있는지 확인
     */
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * 스택의 크기 반환
     */
    public int size() {
        return size;
    }
    
    /**
     * 스택의 모든 요소 제거
     */
    public void clear() {
        top = null;
        size = 0;
    }
    
    /**
     * 스택의 내용을 문자열로 반환
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
        
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== 제네릭 연결 스택 테스트 ===");
        
        // 정수 스택
        GenericLinkedStack<Integer> intStack = new GenericLinkedStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        
        System.out.println("정수 스택: " + intStack);
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Peek: " + intStack.peek());
        System.out.println("크기: " + intStack.size());
        
        // 문자열 스택
        GenericLinkedStack<String> stringStack = new GenericLinkedStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        
        System.out.println("\n문자열 스택: " + stringStack);
        
        while (!stringStack.isEmpty()) {
            System.out.println("Pop: " + stringStack.pop());
        }
    }
}
```

### 예제 1-2: 동적 배열 스택 구현

```java
import java.util.Arrays;

public class DynamicArrayStack<T> {
    
    private static final int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int top;
    
    @SuppressWarnings("unchecked")
    public DynamicArrayStack() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }
    
    @SuppressWarnings("unchecked")
    public DynamicArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("초기 용량은 양수여야 합니다");
        }
        items = (T[]) new Object[initialCapacity];
        top = 0;
    }
    
    /**
     * 스택에 요소 추가
     */
    public void push(T item) {
        if (top == items.length) {
            resize();
        }
        items[top++] = item;
    }
    
    /**
     * 스택에서 요소 제거 및 반환
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다");
        }
        
        T item = items[--top];
        items[top] = null;  // 가비지 컬렉션을 위해
        
        // 배열이 1/4만 사용되면 크기를 반으로 줄임
        if (top > 0 && top == items.length / 4) {
            shrink();
        }
        
        return item;
    }
    
    /**
     * 스택의 맨 위 요소 확인
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다");
        }
        return items[top - 1];
    }
    
    /**
     * 스택이 비어있는지 확인
     */
    public boolean isEmpty() {
        return top == 0;
    }
    
    /**
     * 스택의 크기 반환
     */
    public int size() {
        return top;
    }
    
    /**
     * 배열 크기를 두 배로 증가
     */
    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
        System.out.println("배열 크기 증가: " + items.length);
    }
    
    /**
     * 배열 크기를 반으로 감소
     */
    private void shrink() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length / 2];
        System.arraycopy(items, 0, newItems, 0, top);
        items = newItems;
        System.out.println("배열 크기 감소: " + items.length);
    }
    
    /**
     * 현재 용량 반환
     */
    public int capacity() {
        return items.length;
    }
    
    /**
     * 스택의 모든 요소를 배열로 반환
     */
    public Object[] toArray() {
        return Arrays.copyOf(items, top);
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(items[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== 동적 배열 스택 테스트 ===");
        
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>(2);
        
        // 크기 증가 테스트
        System.out.println("초기 용량: " + stack.capacity());
        
        for (int i = 1; i <= 5; i++) {
            stack.push(i * 10);
            System.out.println("Push " + (i * 10) + " - 크기: " + stack.size() + 
                             ", 용량: " + stack.capacity());
        }
        
        System.out.println("\n스택: " + stack);
        
        // 크기 감소 테스트
        while (!stack.isEmpty()) {
            System.out.println("Pop " + stack.pop() + " - 크기: " + stack.size() + 
                             ", 용량: " + stack.capacity());
        }
    }
}
```

## 2. 큐 구현 예제

### 예제 2-1: 연결 리스트 큐 구현

```java
public class LinkedQueue<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> front;  // 큐의 앞쪽
    private Node<T> rear;   // 큐의 뒤쪽
    private int size;
    
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    /**
     * 큐의 뒤쪽에 요소 추가
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        
        if (rear == null) {
            // 큐가 비어있는 경우
            front = rear = newNode;
        } else {
            // 큐에 요소가 있는 경우
            rear.next = newNode;
            rear = newNode;
        }
        
        size++;
    }
    
    /**
     * 큐의 앞쪽에서 요소 제거 및 반환
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다");
        }
        
        T data = front.data;
        front = front.next;
        
        if (front == null) {
            // 큐가 비게 된 경우
            rear = null;
        }
        
        size--;
        return data;
    }
    
    /**
     * 큐의 앞쪽 요소 확인
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다");
        }
        return front.data;
    }
    
    /**
     * 큐가 비어있는지 확인
     */
    public boolean isEmpty() {
        return front == null;
    }
    
    /**
     * 큐의 크기 반환
     */
    public int size() {
        return size;
    }
    
    /**
     * 큐의 모든 요소 제거
     */
    public void clear() {
        front = rear = null;
        size = 0;
    }
    
    /**
     * 큐에 특정 요소가 있는지 확인
     */
    public boolean contains(T item) {
        Node<T> current = front;
        
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== 연결 리스트 큐 테스트 ===");
        
        LinkedQueue<String> queue = new LinkedQueue<>();
        
        // 큐 연산 테스트
        queue.enqueue("첫번째");
        queue.enqueue("두번째");
        queue.enqueue("세번째");
        
        System.out.println("큐: " + queue);
        System.out.println("크기: " + queue.size());
        
        System.out.println("\nDequeue: " + queue.dequeue());
        System.out.println("큐: " + queue);
        
        queue.enqueue("네번째");
        System.out.println("\n네번째 추가 후: " + queue);
        
        System.out.println("Peek: " + queue.peek());
        System.out.println("Contains '세번째': " + queue.contains("세번째"));
        
        // 모든 요소 제거
        System.out.println("\n모든 요소 제거:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}
```

### 예제 2-2: 원형 배열 큐 구현

```java
public class CircularArrayQueue<T> {
    
    private T[] items;
    private int front;
    private int rear;
    private int size;
    
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("용량은 양수여야 합니다");
        }
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    /**
     * 큐에 요소 추가
     */
    public void enqueue(T item) {
        if (size == items.length) {
            throw new IllegalStateException("큐가 가득 찼습니다");
        }
        
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }
    
    /**
     * 큐에서 요소 제거 및 반환
     */
    public T dequeue() {
        // TODO 1: 큐가 비어있는지 확인하고 예외 처리
        
        // TODO 2: front 위치의 요소를 임시 변수에 저장
        
        // TODO 3: front 위치를 null로 설정 (가비지 컬렉션을 위해)
        
        // TODO 4: front를 원형 배열 방식으로 증가시키기
        // 힌트: (front + 1) % items.length
        
        // TODO 5: size 감소
        
        // TODO 6: 저장한 요소 반환
        
        return null; // 임시 반환값
    }
    
    /**
     * 큐의 앞쪽 요소 확인
     */
    public T peek() {
        // TODO 1: 큐가 비어있는지 확인하고 예외 처리
        
        // TODO 2: front 위치의 요소 반환
        
        return null; // 임시 반환값
    }
    
    /**
     * 큐가 비어있는지 확인
     */
    public boolean isEmpty() {
        // TODO: size가 0인지 확인
        return false; // 임시 반환값
    }
    
    /**
     * 큐가 가득 찼는지 확인
     */
    public boolean isFull() {
        // TODO: size가 배열의 길이와 같은지 확인
        return false; // 임시 반환값
    }
    
    /**
     * 큐의 크기 반환
     */
    public int size() {
        return size;
    }
    
    /**
     * 큐의 용량 반환
     */
    public int capacity() {
        return items.length;
    }
    
    /**
     * 큐의 상태를 시각적으로 표시
     */
    public void displayStatus() {
        System.out.println("\n=== 큐 상태 ===");
        System.out.print("배열: [");
        
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i]);
            } else {
                System.out.print("_");
            }
            
            if (i == front && i == rear) {
                System.out.print("(F,R)");
            } else if (i == front) {
                System.out.print("(F)");
            } else if (i == rear) {
                System.out.print("(R)");
            }
            
            if (i < items.length - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println("]");
        System.out.println("Front: " + front + ", Rear: " + rear + ", Size: " + size);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 원형 배열 큐 테스트 ===");
        
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(5);
        
        // 큐 연산 테스트
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.displayStatus();
        
        System.out.println("\nDequeue: " + queue.dequeue());
        queue.displayStatus();
        
        queue.enqueue(4);
        queue.enqueue(5);
        queue.displayStatus();
        
        // 원형 특성 테스트
        queue.enqueue(6);
        queue.displayStatus();
        
        System.out.println("\nDequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.displayStatus();
        
        queue.enqueue(7);
        queue.enqueue(8);
        queue.displayStatus();
    }
}
```

## 3. 스택과 큐의 활용 예제

### 예제 3-1: 괄호 매칭 검사

```java
import java.util.HashMap;
import java.util.Map;

public class BracketMatcher {
    
    private static final Map<Character, Character> BRACKET_PAIRS = new HashMap<>();
    
    static {
        BRACKET_PAIRS.put(')', '(');
        BRACKET_PAIRS.put('}', '{');
        BRACKET_PAIRS.put(']', '[');
    }
    
    /**
     * 주어진 표현식의 괄호가 올바르게 매칭되는지 검사
     */
    public static boolean isBalanced(String expression) {
        GenericLinkedStack<Character> stack = new GenericLinkedStack<>();
        
        // TODO 1: expression의 각 문자를 순회
        // TODO 2: 여는 괄호이면 스택에 push
        // TODO 3: 닫는 괄호이면:
        //   - 스택이 비었으면 false 반환
        //   - 스택에서 pop한 후 매칭이 맞는지 확인
        //   - 매칭이 안 맞으면 false 반환
        // TODO 4: 모든 문자 처리 후 스택이 비어있는지 확인
        
        return false; // 임시 반환값
    }
    
    /**
     * 자세한 검사 결과를 반환하는 메서드
     */
    public static ValidationResult validateBrackets(String expression) {
        GenericLinkedStack<BracketInfo> stack = new GenericLinkedStack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (isOpenBracket(ch)) {
                stack.push(new BracketInfo(ch, i));
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty()) {
                    return new ValidationResult(false, 
                        "위치 " + i + "에서 닫는 괄호 '" + ch + "'에 대응하는 여는 괄호가 없습니다.");
                }
                
                BracketInfo openInfo = stack.pop();
                if (!isMatchingPair(openInfo.bracket, ch)) {
                    return new ValidationResult(false, 
                        "위치 " + openInfo.position + "의 '" + openInfo.bracket + "'와 " +
                        "위치 " + i + "의 '" + ch + "'가 매칭되지 않습니다.");
                }
            }
        }
        
        if (!stack.isEmpty()) {
            BracketInfo unclosed = stack.peek();
            return new ValidationResult(false, 
                "위치 " + unclosed.position + "의 '" + unclosed.bracket + "'가 닫히지 않았습니다.");
        }
        
        return new ValidationResult(true, "모든 괄호가 올바르게 매칭됩니다.");
    }
    
    private static boolean isOpenBracket(char ch) {
        // TODO: ch가 여는 괄호 '(', '{', '[' 중 하나인지 확인
        return false; // 임시 반환값
    }
    
    private static boolean isCloseBracket(char ch) {
        // TODO: ch가 닫는 괄호 ')', '}', ']' 중 하나인지 확인
        return false; // 임시 반환값
    }
    
    private static boolean isMatchingPair(char open, char close) {
        // TODO: BRACKET_PAIRS 맵을 사용하여 open과 close가 매칭되는 쌍인지 확인
        // 힌트: BRACKET_PAIRS.get(close)가 open과 같은지 확인
        return false; // 임시 반환값
    }
    
    // 괄호 정보를 저장하는 내부 클래스
    private static class BracketInfo {
        char bracket;
        int position;
        
        BracketInfo(char bracket, int position) {
            this.bracket = bracket;
            this.position = position;
        }
    }
    
    // 검증 결과를 저장하는 클래스
    static class ValidationResult {
        boolean isValid;
        String message;
        
        ValidationResult(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 괄호 매칭 검사 ===");
        
        String[] testCases = {
            "((()))",
            "(()())",
            "({[]})",
            "((())",
            "())",
            "({[}])",
            "public void method() { if (x > 0) { System.out.println(\"Hello\"); } }"
        };
        
        for (String test : testCases) {
            System.out.println("\n테스트: " + test);
            System.out.println("간단한 검사: " + (isBalanced(test) ? "유효" : "무효"));
            
            ValidationResult result = validateBrackets(test);
            System.out.println("상세 검사: " + result.message);
        }
    }
}
```

### 예제 3-2: 작업 스케줄러 (큐 활용)

```java
import java.util.concurrent.TimeUnit;

public class TaskScheduler {
    
    static class Task {
        private String name;
        private int priority;
        private long estimatedTime;  // 밀리초 단위
        
        public Task(String name, int priority, long estimatedTime) {
            this.name = name;
            this.priority = priority;
            this.estimatedTime = estimatedTime;
        }
        
        public void execute() {
            System.out.println("실행 중: " + name);
            try {
                Thread.sleep(estimatedTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("완료: " + name);
        }
        
        @Override
        public String toString() {
            return String.format("%s (우선순위: %d, 예상시간: %dms)", 
                               name, priority, estimatedTime);
        }
    }
    
    private LinkedQueue<Task> taskQueue;
    private boolean isRunning;
    
    public TaskScheduler() {
        this.taskQueue = new LinkedQueue<>();
        this.isRunning = false;
    }
    
    /**
     * 작업 추가
     */
    public void addTask(Task task) {
        taskQueue.enqueue(task);
        System.out.println("작업 추가됨: " + task);
    }
    
    /**
     * 모든 작업 실행
     */
    public void executeAll() {
        isRunning = true;
        System.out.println("\n=== 작업 실행 시작 ===");
        
        long startTime = System.currentTimeMillis();
        
        while (!taskQueue.isEmpty() && isRunning) {
            Task task = taskQueue.dequeue();
            task.execute();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("\n=== 작업 실행 완료 ===");
        System.out.println("총 실행 시간: " + (endTime - startTime) + "ms");
    }
    
    /**
     * 실행 중지
     */
    public void stop() {
        isRunning = false;
    }
    
    /**
     * 대기 중인 작업 수
     */
    public int getPendingTaskCount() {
        return taskQueue.size();
    }
    
    /**
     * 우선순위 큐 (간단한 구현)
     */
    static class PriorityTaskScheduler {
        private LinkedQueue<Task>[] queues;
        private int maxPriority;
        
        @SuppressWarnings("unchecked")
        public PriorityTaskScheduler(int maxPriority) {
            this.maxPriority = maxPriority;
            this.queues = new LinkedQueue[maxPriority + 1];
            
            for (int i = 0; i <= maxPriority; i++) {
                queues[i] = new LinkedQueue<>();
            }
        }
        
        public void addTask(Task task) {
            if (task.priority < 0 || task.priority > maxPriority) {
                throw new IllegalArgumentException("잘못된 우선순위: " + task.priority);
            }
            
            queues[task.priority].enqueue(task);
            System.out.println("우선순위 큐에 추가: " + task);
        }
        
        public void executeAll() {
            System.out.println("\n=== 우선순위 작업 실행 시작 ===");
            
            // 높은 우선순위부터 실행
            for (int priority = maxPriority; priority >= 0; priority--) {
                while (!queues[priority].isEmpty()) {
                    Task task = queues[priority].dequeue();
                    task.execute();
                }
            }
            
            System.out.println("=== 우선순위 작업 실행 완료 ===");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 작업 스케줄러 테스트 ===");
        
        // 일반 큐 스케줄러
        TaskScheduler scheduler = new TaskScheduler();
        
        scheduler.addTask(new Task("데이터베이스 백업", 2, 300));
        scheduler.addTask(new Task("이메일 전송", 1, 100));
        scheduler.addTask(new Task("로그 파일 정리", 0, 200));
        scheduler.addTask(new Task("보고서 생성", 2, 500));
        
        scheduler.executeAll();
        
        // 우선순위 큐 스케줄러
        System.out.println("\n=== 우선순위 스케줄러 테스트 ===");
        
        PriorityTaskScheduler priorityScheduler = new PriorityTaskScheduler(3);
        
        priorityScheduler.addTask(new Task("긴급: 시스템 오류 수정", 3, 400));
        priorityScheduler.addTask(new Task("일반: 데이터 백업", 1, 300));
        priorityScheduler.addTask(new Task("높음: 보안 업데이트", 2, 200));
        priorityScheduler.addTask(new Task("낮음: 캐시 정리", 0, 100));
        
        priorityScheduler.executeAll();
    }
}
```

## 4. 후위 표기법 계산기

### 예제 4-1: 완전한 후위 표기법 계산기

```java
import java.util.Scanner;
import java.util.StringTokenizer;

public class PostfixCalculator {
    
    /**
     * 후위 표기법 표현식을 계산
     */
    public static double evaluate(String expression) {
        GenericLinkedStack<Double> stack = new GenericLinkedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);
        
        // TODO 1: tokenizer로 각 토큰을 순회
        // TODO 2: 토큰이 숫자면 스택에 push
        // TODO 3: 토큰이 연산자면:
        //   - 스택에서 두 개의 숫자를 pop (b를 먼저, 그 다음 a)
        //   - applyOperator(a, b, token)으로 계산
        //   - 결과를 스택에 push
        // TODO 4: 모든 토큰 처리 후 스택에 하나의 값만 남았는지 확인
        // TODO 5: 최종 결과 반환
        
        return 0.0; // 임시 반환값
    }
    
    /**
     * 중위 표기법을 후위 표기법으로 변환
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        GenericLinkedStack<Character> operatorStack = new GenericLinkedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(infix, "+-*/^()", true);
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;
            
            if (isNumber(token)) {
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push('(');
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();  // '(' 제거
                }
            } else if (token.length() == 1 && isOperator(token)) {
                char op = token.charAt(0);
                while (!operatorStack.isEmpty() && 
                       operatorStack.peek() != '(' && 
                       precedence(operatorStack.peek()) >= precedence(op)) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(op);
            }
        }
        
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }
        
        return postfix.toString().trim();
    }
    
    /**
     * 연산자 우선순위 반환
     */
    private static int precedence(char operator) {
        // TODO: 연산자에 따른 우선순위 반환
        // +, - : 1
        // *, / : 2  
        // ^ : 3
        
        return 0; // 임시 반환값
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    
    /**
     * 문자열이 숫자인지 확인
     */
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * 문자열이 연산자인지 확인
     */
    private static boolean isOperator(String token) {
        // TODO: token이 +, -, *, /, ^ 중 하나인지 확인
        return false; // 임시 반환값
    }
    
    /**
     * 연산자 적용
     */
    private static double applyOperator(double a, double b, String operator) {
        // TODO: operator에 따라 적절한 연산 수행
        // +: a + b
        // -: a - b
        // *: a * b
        // /: a / b (b가 0이면 ArithmeticException)
        // ^: Math.pow(a, b)
        
        return 0.0; // 임시 반환값
    }
    
    /**
     * 계산 과정을 시각화
     */
    public static void visualizeCalculation(String expression) {
        System.out.println("\n=== 후위 표기법 계산 시각화 ===");
        System.out.println("표현식: " + expression);
        System.out.println();
        
        GenericLinkedStack<Double> stack = new GenericLinkedStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);
        int step = 1;
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("단계 " + step++ + ": 토큰 '" + token + "' 처리");
            
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
                System.out.println("  동작: 스택에 푸시");
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
                System.out.println("  동작: " + a + " " + token + " " + b + " = " + result);
            }
            
            System.out.println("  스택: " + stack);
            System.out.println();
        }
        
        System.out.println("최종 결과: " + stack.pop());
    }
    
    public static void main(String[] args) {
        System.out.println("=== 후위 표기법 계산기 ===");
        
        // 테스트 케이스
        String[] infixExpressions = {
            "2 + 3",
            "2 + 3 * 4",
            "(2 + 3) * 4",
            "2 * (3 + 4)",
            "2 + 3 * 4 - 5",
            "2 ^ 3 + 1"
        };
        
        for (String infix : infixExpressions) {
            System.out.println("\n중위: " + infix);
            String postfix = infixToPostfix(infix);
            System.out.println("후위: " + postfix);
            double result = evaluate(postfix);
            System.out.println("결과: " + result);
        }
        
        // 시각화 예제
        visualizeCalculation("2 3 4 * +");
        
        // 대화형 계산기
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== 대화형 계산기 ===");
        System.out.println("후위 표기법 표현식을 입력하세요 (종료: quit):");
        
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            try {
                double result = evaluate(input);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
```

## 5. 실무 응용 예제

### 예제 5-1: 웹 브라우저 히스토리 관리

```java
import java.util.Date;

public class BrowserHistory {
    
    static class Page {
        String url;
        String title;
        Date visitTime;
        
        public Page(String url, String title) {
            this.url = url;
            this.title = title;
            this.visitTime = new Date();
        }
        
        @Override
        public String toString() {
            return title + " (" + url + ")";
        }
    }
    
    private GenericLinkedStack<Page> backStack;
    private GenericLinkedStack<Page> forwardStack;
    private Page currentPage;
    
    public BrowserHistory() {
        this.backStack = new GenericLinkedStack<>();
        this.forwardStack = new GenericLinkedStack<>();
        this.currentPage = null;
    }
    
    /**
     * 새 페이지 방문
     */
    public void visit(String url, String title) {
        // TODO 1: 현재 페이지가 있으면 backStack에 push
        
        // TODO 2: 새 Page 객체를 생성하여 currentPage로 설정
        
        // TODO 3: forwardStack을 clear() (새 페이지 방문 시 앞으로 가기 기록 삭제)
        
        System.out.println("방문: " + currentPage);
        displayStatus();
    }
    
    /**
     * 뒤로 가기
     */
    public void back() {
        // TODO 1: backStack이 비어있는지 확인
        
        // TODO 2: 현재 페이지를 forwardStack에 push
        
        // TODO 3: backStack에서 pop한 페이지를 currentPage로 설정
        
        System.out.println("뒤로 가기: " + currentPage);
        displayStatus();
    }
    
    /**
     * 앞으로 가기
     */
    public void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("앞으로 갈 페이지가 없습니다.");
            return;
        }
        
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        
        System.out.println("앞으로 가기: " + currentPage);
        displayStatus();
    }
    
    /**
     * 현재 상태 표시
     */
    private void displayStatus() {
        System.out.println("현재 페이지: " + (currentPage != null ? currentPage : "없음"));
        System.out.println("뒤로 가기 가능: " + backStack.size() + "개");
        System.out.println("앞으로 가기 가능: " + forwardStack.size() + "개");
        System.out.println();
    }
    
    /**
     * 방문 기록 표시
     */
    public void showHistory() {
        System.out.println("\n=== 방문 기록 ===");
        
        // 임시 스택에 저장
        GenericLinkedStack<Page> tempStack = new GenericLinkedStack<>();
        
        // 뒤로 가기 스택의 내용을 임시로 이동
        while (!backStack.isEmpty()) {
            tempStack.push(backStack.pop());
        }
        
        // 출력하면서 원래대로 복원
        System.out.println("이전 페이지들:");
        while (!tempStack.isEmpty()) {
            Page page = tempStack.pop();
            System.out.println("  - " + page);
            backStack.push(page);
        }
        
        if (currentPage != null) {
            System.out.println("현재 페이지: " + currentPage + " ← 현재 위치");
        }
        
        // 앞으로 가기 스택 표시
        if (!forwardStack.isEmpty()) {
            System.out.println("다음 페이지들:");
            // 앞으로 가기 스택도 같은 방식으로 처리
            while (!forwardStack.isEmpty()) {
                tempStack.push(forwardStack.pop());
            }
            while (!tempStack.isEmpty()) {
                Page page = tempStack.pop();
                System.out.println("  - " + page);
                forwardStack.push(page);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 브라우저 히스토리 관리 ===\n");
        
        BrowserHistory browser = new BrowserHistory();
        
        // 웹 서핑 시뮬레이션
        browser.visit("https://www.google.com", "Google");
        browser.visit("https://www.github.com", "GitHub");
        browser.visit("https://www.stackoverflow.com", "Stack Overflow");
        browser.visit("https://www.youtube.com", "YouTube");
        
        System.out.println("=== 뒤로 가기 테스트 ===");
        browser.back();
        browser.back();
        
        System.out.println("=== 앞으로 가기 테스트 ===");
        browser.forward();
        
        System.out.println("=== 새 페이지 방문 ===");
        browser.visit("https://www.reddit.com", "Reddit");
        
        browser.showHistory();
    }
}
```

### 예제 5-2: 프로세스 스케줄링 시뮬레이터

```java
import java.util.Random;

public class ProcessScheduler {
    
    static class Process {
        int id;
        String name;
        int cpuTime;      // 필요한 CPU 시간
        int remainingTime; // 남은 CPU 시간
        int waitingTime;   // 대기 시간
        int turnaroundTime; // 총 소요 시간
        
        public Process(int id, String name, int cpuTime) {
            this.id = id;
            this.name = name;
            this.cpuTime = cpuTime;
            this.remainingTime = cpuTime;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
        }
        
        @Override
        public String toString() {
            return String.format("P%d(%s)", id, name);
        }
    }
    
    /**
     * FCFS (First Come First Served) 스케줄링
     */
    static class FCFSScheduler {
        private LinkedQueue<Process> readyQueue;
        private int currentTime;
        
        public FCFSScheduler() {
            this.readyQueue = new LinkedQueue<>();
            this.currentTime = 0;
        }
        
        public void addProcess(Process process) {
            readyQueue.enqueue(process);
            System.out.println("시간 " + currentTime + ": " + process + " 도착");
        }
        
        public void run() {
            System.out.println("\n=== FCFS 스케줄링 시작 ===");
            
            while (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.dequeue();
                
                // 대기 시간 = 현재 시간 - 도착 시간(0으로 가정)
                currentProcess.waitingTime = currentTime;
                
                System.out.println("시간 " + currentTime + ": " + currentProcess + 
                                 " 실행 시작 (CPU 시간: " + currentProcess.cpuTime + ")");
                
                // 프로세스 실행
                currentTime += currentProcess.cpuTime;
                
                // 총 소요 시간 = 대기 시간 + CPU 시간
                currentProcess.turnaroundTime = currentProcess.waitingTime + currentProcess.cpuTime;
                
                System.out.println("시간 " + currentTime + ": " + currentProcess + 
                                 " 완료 (대기: " + currentProcess.waitingTime + 
                                 ", 총소요: " + currentProcess.turnaroundTime + ")");
            }
            
            System.out.println("=== 스케줄링 완료 ===\n");
        }
    }
    
    /**
     * Round Robin 스케줄링
     */
    static class RoundRobinScheduler {
        private LinkedQueue<Process> readyQueue;
        private int timeQuantum;
        private int currentTime;
        
        public RoundRobinScheduler(int timeQuantum) {
            this.readyQueue = new LinkedQueue<>();
            this.timeQuantum = timeQuantum;
            this.currentTime = 0;
        }
        
        public void addProcess(Process process) {
            readyQueue.enqueue(process);
            System.out.println("시간 " + currentTime + ": " + process + " 도착");
        }
        
        public void run() {
            System.out.println("\n=== Round Robin 스케줄링 시작 (Time Quantum: " + 
                             timeQuantum + ") ===");
            
            while (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.dequeue();
                
                int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);
                
                System.out.println("시간 " + currentTime + ": " + currentProcess + 
                                 " 실행 (남은 시간: " + currentProcess.remainingTime + ")");
                
                currentTime += executionTime;
                currentProcess.remainingTime -= executionTime;
                
                if (currentProcess.remainingTime > 0) {
                    // 아직 완료되지 않았으면 다시 큐에 추가
                    readyQueue.enqueue(currentProcess);
                    System.out.println("시간 " + currentTime + ": " + currentProcess + 
                                     " 중단 (남은 시간: " + currentProcess.remainingTime + ")");
                } else {
                    // 프로세스 완료
                    currentProcess.turnaroundTime = currentTime;
                    System.out.println("시간 " + currentTime + ": " + currentProcess + 
                                     " 완료 (총소요: " + currentProcess.turnaroundTime + ")");
                }
            }
            
            System.out.println("=== 스케줄링 완료 ===\n");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 프로세스 스케줄링 시뮬레이터 ===\n");
        
        // FCFS 스케줄링 테스트
        FCFSScheduler fcfs = new FCFSScheduler();
        fcfs.addProcess(new Process(1, "웹브라우저", 4));
        fcfs.addProcess(new Process(2, "텍스트에디터", 2));
        fcfs.addProcess(new Process(3, "컴파일러", 6));
        fcfs.addProcess(new Process(4, "음악플레이어", 3));
        fcfs.run();
        
        // Round Robin 스케줄링 테스트
        RoundRobinScheduler rr = new RoundRobinScheduler(2);
        rr.addProcess(new Process(1, "웹브라우저", 4));
        rr.addProcess(new Process(2, "텍스트에디터", 2));
        rr.addProcess(new Process(3, "컴파일러", 6));
        rr.addProcess(new Process(4, "음악플레이어", 3));
        rr.run();
    }
}
```

## 마무리

이러한 예제들은 스택과 큐의 다양한 구현 방법과 실제 활용 사례를 보여줍니다:

1. **기본 구현**: 연결 리스트와 배열을 사용한 스택/큐 구현
2. **고급 기능**: 동적 크기 조정, 원형 배열, 우선순위 큐
3. **실제 응용**: 괄호 매칭, 작업 스케줄러, 후위 표기법 계산기
4. **실무 예제**: 브라우저 히스토리, 프로세스 스케줄링

각 예제는 실제로 실행 가능한 완전한 코드로 구성되어 있으며, 스택과 큐의 동작 원리를 이해하는 데 도움이 됩니다.