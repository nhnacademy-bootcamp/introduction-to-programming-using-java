# 9.3 스택, 큐, 그리고 ADTs - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 추상 데이터 타입(ADT)의 개념을 이해하고 설명한다
- 스택의 동작 원리를 이해하고 구현한다
- 큐의 동작 원리를 이해하고 구현한다
- 스택과 큐의 차이점을 설명하고 적절한 상황에서 사용한다
- 후위 표기법을 이해하고 스택을 사용하여 계산한다

## 1. 추상 데이터 타입(Abstract Data Type, ADT)

### 1.1 ADT란 무엇인가?

**추상 데이터 타입(ADT)**은 데이터와 그 데이터에 대한 연산을 추상적으로 정의한 것입니다.

중요한 특징:
- **구현과 분리**: 어떻게 구현하는지가 아니라 무엇을 하는지에 집중
- **인터페이스 정의**: 사용 가능한 연산들의 목록
- **동작 명세**: 각 연산이 수행하는 작업의 설명

```java
// ADT의 예: 정렬된 문자열 리스트
public interface SortedStringList {
    void insert(String item);     // 정렬된 순서로 삽입
    void remove(String item);     // 항목 제거
    boolean contains(String item); // 항목 존재 확인
    int size();                   // 리스트 크기
}
```

### 1.2 ADT의 장점

1. **구현 독립성**: 내부 구현을 변경해도 사용하는 코드는 영향받지 않음
2. **재사용성**: 같은 ADT를 다양한 방식으로 구현 가능
3. **유지보수성**: 인터페이스가 명확하여 디버깅과 수정이 용이

```java
// 같은 ADT의 두 가지 구현
class ArrayStringList implements SortedStringList {
    private String[] array;
    // 배열을 사용한 구현
}

class LinkedStringList implements SortedStringList {
    private Node head;
    // 연결 리스트를 사용한 구현
}
```

## 2. 스택(Stack)

### 2.1 스택의 개념

스택은 **LIFO(Last In, First Out)** 원칙을 따르는 자료구조입니다.

시각적 표현:
```
     TOP
      ↓
    [5]  ← push(5)
    [3]
    [1]
    ---
   BOTTOM
```

실생활 예시:
- 접시 더미: 맨 위에 놓고, 맨 위에서 가져감
- 브라우저 뒤로 가기: 최근 방문 페이지부터 돌아감
- 실행 취소(Undo): 최근 작업부터 취소

### 2.2 스택의 기본 연산

```java
public interface Stack<T> {
    void push(T item);    // 맨 위에 항목 추가
    T pop();             // 맨 위 항목 제거 및 반환
    T peek();            // 맨 위 항목 확인(제거하지 않음)
    boolean isEmpty();   // 스택이 비어있는지 확인
    int size();         // 스택의 크기
}
```

### 2.3 연결 리스트로 스택 구현

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
    
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
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
```

### 2.4 배열로 스택 구현

```java
public class ArrayStack<T> {
    private T[] items;
    private int top;
    
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        items = (T[]) new Object[capacity];
        top = 0;
    }
    
    public void push(T item) {
        if (top == items.length) {
            resize();  // 배열 크기 증가
        }
        items[top++] = item;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다");
        }
        T item = items[--top];
        items[top] = null;  // 가비지 컬렉션을 위해
        return item;
    }
    
    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }
}
```

### 2.5 스택의 시간 복잡도

| 연산 | 연결 리스트 | 배열 |
|------|------------|------|
| push | O(1) | O(1)* |
| pop | O(1) | O(1) |
| peek | O(1) | O(1) |

*배열이 꽉 찬 경우 O(n)이지만, 평균적으로 O(1)

## 3. 큐(Queue)

### 3.1 큐의 개념

큐는 **FIFO(First In, First Out)** 원칙을 따르는 자료구조입니다.

시각적 표현:
```
enqueue →  [5] [3] [1] [7]  → dequeue
          rear          front
```

실생활 예시:
- 줄 서기: 먼저 온 사람이 먼저 서비스받음
- 프린터 대기열: 먼저 요청한 문서부터 인쇄
- 콜센터: 먼저 전화한 고객부터 상담

### 3.2 큐의 기본 연산

```java
public interface Queue<T> {
    void enqueue(T item);  // 뒤쪽에 항목 추가
    T dequeue();          // 앞쪽 항목 제거 및 반환
    T peek();             // 앞쪽 항목 확인
    boolean isEmpty();    // 큐가 비어있는지 확인
    int size();          // 큐의 크기
}
```

### 3.3 연결 리스트로 큐 구현

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
    
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        
        if (rear == null) {
            // 큐가 비어있는 경우
            front = rear = newNode;
        } else {
            // 뒤쪽에 추가
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
            // 큐가 비게 된 경우
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
```

### 3.4 큐의 활용 예시

```java
// 작업 처리 시스템
public class TaskProcessor {
    private Queue<Task> taskQueue = new LinkedQueue<>();
    
    public void submitTask(Task task) {
        taskQueue.enqueue(task);
        System.out.println("작업 추가: " + task.getName());
    }
    
    public void processNextTask() {
        if (!taskQueue.isEmpty()) {
            Task task = taskQueue.dequeue();
            System.out.println("작업 처리 중: " + task.getName());
            task.execute();
        }
    }
}
```

## 4. 스택 vs 큐

### 4.1 주요 차이점

| 특성 | 스택 (Stack) | 큐 (Queue) |
|------|-------------|------------|
| 원칙 | LIFO | FIFO |
| 추가 위치 | 맨 위 | 뒤쪽 |
| 제거 위치 | 맨 위 | 앞쪽 |
| 주요 연산 | push/pop | enqueue/dequeue |
| 활용 예시 | 함수 호출, 괄호 매칭 | 작업 대기열, 이벤트 처리 |

### 4.2 선택 기준

**스택을 사용하는 경우**:
- 최근 항목을 먼저 처리해야 할 때
- 재귀적 구조를 다룰 때
- 역순 처리가 필요할 때

**큐를 사용하는 경우**:
- 공정한 순서 처리가 필요할 때
- 도착 순서대로 처리해야 할 때
- 버퍼링이 필요할 때

## 5. 후위 표기법(Postfix Notation)

### 5.1 표기법의 종류

1. **중위 표기법(Infix)**: `2 + 3`
   - 연산자가 피연산자 사이에 위치
   - 사람이 읽기 쉬움
   - 괄호와 우선순위 필요

2. **후위 표기법(Postfix)**: `2 3 +`
   - 연산자가 피연산자 뒤에 위치
   - 컴퓨터가 처리하기 쉬움
   - 괄호 불필요

3. **전위 표기법(Prefix)**: `+ 2 3`
   - 연산자가 피연산자 앞에 위치

### 5.2 후위 표기법 변환 예시

| 중위 표기법 | 후위 표기법 |
|------------|------------|
| `2 + 3` | `2 3 +` |
| `2 + 3 * 4` | `2 3 4 * +` |
| `(2 + 3) * 4` | `2 3 + 4 *` |
| `2 * (3 + 4)` | `2 3 4 + *` |

### 5.3 후위 표기법 계산 알고리즘

```java
public class PostfixCalculator {
    public double evaluate(String expression) {
        Stack<Double> stack = new LinkedStack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                // 숫자인 경우 스택에 푸시
                stack.push(Double.parseDouble(token));
            } else {
                // 연산자인 경우
                double b = stack.pop();
                double a = stack.pop();
                double result = calculate(a, b, token);
                stack.push(result);
            }
        }
        
        return stack.pop();
    }
    
    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "^": return Math.pow(a, b);
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
```

### 5.4 후위 표기법 계산 예시

`2 3 4 * +` 계산 과정:

```
1. 2를 읽음 → 스택: [2]
2. 3을 읽음 → 스택: [2, 3]
3. 4를 읽음 → 스택: [2, 3, 4]
4. *를 읽음 → 4와 3을 pop, 3*4=12를 push → 스택: [2, 12]
5. +를 읽음 → 12와 2를 pop, 2+12=14를 push → 스택: [14]
6. 결과: 14
```

## 6. 실제 활용 예시

### 6.1 괄호 매칭 검사 (스택 활용)

```java
public boolean isBalanced(String expression) {
    Stack<Character> stack = new LinkedStack<>();
    
    for (char ch : expression.toCharArray()) {
        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        } else if (ch == ')' || ch == '}' || ch == ']') {
            if (stack.isEmpty()) {
                return false;
            }
            
            char open = stack.pop();
            if (!isMatchingPair(open, ch)) {
                return false;
            }
        }
    }
    
    return stack.isEmpty();
}

private boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '{' && close == '}') ||
           (open == '[' && close == ']');
}
```

### 6.2 브라우저 히스토리 (스택 활용)

```java
public class BrowserHistory {
    private Stack<String> backStack = new LinkedStack<>();
    private Stack<String> forwardStack = new LinkedStack<>();
    private String currentPage;
    
    public void visit(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();  // 새 페이지 방문 시 앞으로 가기 기록 삭제
    }
    
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
    }
    
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
    }
}
```

### 6.3 프린터 대기열 (큐 활용)

```java
public class PrinterQueue {
    private Queue<PrintJob> jobQueue = new LinkedQueue<>();
    
    public void addJob(PrintJob job) {
        jobQueue.enqueue(job);
        System.out.println("인쇄 작업 추가: " + job.getDocumentName());
    }
    
    public void processJobs() {
        while (!jobQueue.isEmpty()) {
            PrintJob job = jobQueue.dequeue();
            System.out.println("인쇄 중: " + job.getDocumentName());
            // 실제 인쇄 로직
            job.print();
        }
    }
}
```

## 마무리

스택과 큐는 컴퓨터 과학의 기본적인 자료구조로, 많은 알고리즘과 시스템의 기초가 됩니다:

1. **추상 데이터 타입(ADT)**: 구현과 분리된 인터페이스 정의
2. **스택**: LIFO 원칙, 재귀와 역순 처리에 유용
3. **큐**: FIFO 원칙, 공정한 순서 처리에 유용
4. **후위 표기법**: 스택을 활용한 수식 계산의 예

이러한 자료구조들을 이해하고 적절히 활용하면, 효율적이고 우아한 프로그램을 작성할 수 있습니다.