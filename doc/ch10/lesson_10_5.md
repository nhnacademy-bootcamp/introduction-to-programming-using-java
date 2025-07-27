# 10.5 제네릭 클래스 및 메서드 작성하기 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 제네릭 클래스를 직접 설계하고 구현한다
- 제네릭 메서드를 작성하고 활용한다
- 와일드카드 타입을 이해하고 적절히 사용한다
- 제한된 타입(Bounded Types)을 활용하여 타입 안전성을 보장한다

## 1. 제네릭 프로그래밍의 필요성

### 1.1 코드 중복 문제

제네릭을 사용하지 않으면 타입별로 동일한 클래스를 여러 개 만들어야 합니다:

```java
// String용 큐
class QueueOfStrings {
    private LinkedList<String> items = new LinkedList<>();
    
    public void enqueue(String item) {
        items.addLast(item);
    }
    
    public String dequeue() {
        return items.removeFirst();
    }
    
    public boolean isEmpty() {
        return items.size() == 0;
    }
}

// Integer용 큐 (거의 동일한 코드!)
class QueueOfIntegers {
    private LinkedList<Integer> items = new LinkedList<>();
    
    public void enqueue(Integer item) {
        items.addLast(item);
    }
    
    public Integer dequeue() {
        return items.removeFirst();
    }
    
    public boolean isEmpty() {
        return items.size() == 0;
    }
}
```

### 1.2 제네릭 솔루션

하나의 제네릭 클래스로 모든 타입을 처리할 수 있습니다:

```java
class Queue<T> {
    private LinkedList<T> items = new LinkedList<>();
    
    public void enqueue(T item) {
        items.addLast(item);
    }
    
    public T dequeue() {
        return items.removeFirst();
    }
    
    public boolean isEmpty() {
        return items.size() == 0;
    }
}

// 사용법
Queue<String> stringQueue = new Queue<>();
Queue<Integer> intQueue = new Queue<>();
Queue<Person> personQueue = new Queue<>();
```

## 2. 제네릭 클래스 작성하기

### 2.1 기본 구문

```java
class ClassName<TypeParameter> {
    // TypeParameter를 실제 타입처럼 사용
}
```

**핵심 포인트**:
- `<T>` 는 타입 매개변수 선언
- 클래스 내에서 `T`는 실제 타입처럼 사용
- 생성자 이름에는 타입 매개변수를 붙이지 않음

### 2.2 실전 예제: 제네릭 스택

```java
public class Stack<T> {
    private ArrayList<T> items;
    private int top;
    
    // 생성자 - 타입 매개변수 없음!
    public Stack() {
        items = new ArrayList<>();
        top = -1;
    }
    
    public void push(T item) {
        items.add(item);
        top++;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = items.get(top);
        items.remove(top);
        top--;
        return item;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(top);
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
}
```

### 2.3 다중 타입 매개변수

```java
public class Pair<T, S> {
    public T first;
    public S second;
    
    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
    public void setSecond(S second) {
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// 사용 예
Pair<String, Integer> nameAge = new Pair<>("김철수", 25);
Pair<Double, Double> coordinates = new Pair<>(3.14, 2.71);
```

### 2.4 제네릭 레코드 클래스

```java
// 간단한 제네릭 레코드
public record Point<T>(T x, T y) {
    // 추가 메서드 정의 가능
    public double distanceFromOrigin() {
        if (x instanceof Number && y instanceof Number) {
            double dx = ((Number) x).doubleValue();
            double dy = ((Number) y).doubleValue();
            return Math.sqrt(dx * dx + dy * dy);
        }
        throw new UnsupportedOperationException("숫자 타입만 지원");
    }
}

// 사용
Point<Integer> intPoint = new Point<>(3, 4);
Point<Double> doublePoint = new Point<>(1.5, 2.5);
```

### 2.5 타입 매개변수 명명 규칙

| 관례 | 의미 | 예시 |
|------|------|------|
| T | Type | `List<T>` |
| E | Element | `Set<E>` |
| K | Key | `Map<K, V>` |
| V | Value | `Map<K, V>` |
| N | Number | `Calculator<N>` |

## 3. 제네릭 메서드 작성하기

### 3.1 기본 구문

```java
public static <T> ReturnType methodName(T parameter) {
    // 메서드 본문
}
```

**주의사항**:
- `<T>`는 반환 타입 앞에 위치
- 인스턴스 메서드에서도 동일한 규칙 적용

### 3.2 실전 예제: 배열에서 특정 요소 개수 세기

```java
/**
 * 배열에서 특정 항목의 등장 횟수를 센다
 */
public static <T> int countOccurrences(T[] array, T target) {
    int count = 0;
    
    if (target == null) {
        for (T item : array) {
            if (item == null) {
                count++;
            }
        }
    } else {
        for (T item : array) {
            if (target.equals(item)) {
                count++;
            }
        }
    }
    
    return count;
}

// 사용 예
String[] words = {"apple", "banana", "apple", "cherry"};
int appleCount = countOccurrences(words, "apple"); // 2

Integer[] numbers = {1, 2, 3, 2, 4, 2};
int twoCount = countOccurrences(numbers, 2); // 3
```

### 3.3 컬렉션용 제네릭 메서드

```java
public static <T> int countOccurrences(Collection<T> collection, T target) {
    int count = 0;
    
    if (target == null) {
        for (T item : collection) {
            if (item == null) {
                count++;
            }
        }
    } else {
        for (T item : collection) {
            if (target.equals(item)) {
                count++;
            }
        }
    }
    
    return count;
}

// 다양한 컬렉션에서 사용 가능
List<String> stringList = Arrays.asList("a", "b", "a", "c");
Set<Integer> intSet = Set.of(1, 2, 3, 4, 5);

int aCount = countOccurrences(stringList, "a"); // 2
int fiveCount = countOccurrences(intSet, 5); // 1
```

### 3.4 타입 추론 (Type Inference)

```java
// 컴파일러가 타입을 자동으로 추론
String[] words = {"hello", "world"};
int count = countOccurrences(words, "hello"); // T는 String으로 추론

// 명시적 타입 지정도 가능 (하지만 불필요)
int count2 = Utils.<String>countOccurrences(words, "hello");
```

## 4. 와일드카드 타입 (Wildcard Types)

### 4.1 문제 상황

```java
public static void drawAll(Collection<Shape> shapes) {
    for (Shape s : shapes) {
        s.draw();
    }
}

// 이것이 왜 안 될까?
Collection<Rectangle> rectangles = new ArrayList<>();
drawAll(rectangles); // 컴파일 오류!
```

**문제**: `Rectangle`이 `Shape`의 하위 클래스라도, `Collection<Rectangle>`은 `Collection<Shape>`의 하위 타입이 아님

### 4.2 extends 와일드카드

```java
public static void drawAll(Collection<? extends Shape> shapes) {
    for (Shape s : shapes) {
        s.draw();
    }
}

// 이제 가능!
Collection<Rectangle> rectangles = new ArrayList<>();
Collection<Circle> circles = new ArrayList<>();
Collection<Shape> shapes = new ArrayList<>();

drawAll(rectangles); // OK
drawAll(circles);    // OK  
drawAll(shapes);     // OK
```

### 4.3 super 와일드카드

```java
public static void addNumbers(Collection<? super Integer> numbers) {
    numbers.add(42);        // Integer 추가 가능
    numbers.add(100);       // Integer 추가 가능
    // numbers.add("hello"); // 컴파일 오류!
}

// 사용 예
Collection<Integer> integers = new ArrayList<>();
Collection<Number> numbers = new ArrayList<>();
Collection<Object> objects = new ArrayList<>();

addNumbers(integers); // OK
addNumbers(numbers);  // OK - Number는 Integer의 슈퍼타입
addNumbers(objects);  // OK - Object는 Integer의 슈퍼타입
```

### 4.4 PECS 원칙

**Producer Extends, Consumer Super**

```java
// Producer: 데이터를 제공 (읽기) → extends 사용
public static <T> void copy(Collection<? extends T> source, 
                           Collection<? super T> destination) {
    for (T item : source) {        // source에서 읽기
        destination.add(item);     // destination에 쓰기
    }
}

// 실제 사용
List<Integer> integers = Arrays.asList(1, 2, 3);
List<Number> numbers = new ArrayList<>();

copy(integers, numbers); // Integer를 Number 리스트로 복사
```

### 4.5 무제한 와일드카드

```java
public static void printCollection(Collection<?> collection) {
    for (Object item : collection) {
        System.out.println(item);
    }
}

// 모든 타입의 컬렉션 처리 가능
printCollection(Arrays.asList("a", "b", "c"));
printCollection(Arrays.asList(1, 2, 3));
printCollection(Arrays.asList(true, false));
```

## 5. 제한된 타입 (Bounded Types)

### 5.1 기본 개념

특정 타입의 하위 클래스로만 제한하는 문법:

```java
class Container<T extends SomeClass> {
    // T는 SomeClass 또는 그 하위 클래스만 가능
}
```

### 5.2 실전 예제: 숫자 계산기

```java
public class NumberCalculator<T extends Number> {
    private List<T> numbers;
    
    public NumberCalculator() {
        this.numbers = new ArrayList<>();
    }
    
    public void add(T number) {
        numbers.add(number);
    }
    
    // Number의 메서드 사용 가능
    public double sum() {
        double total = 0.0;
        for (T number : numbers) {
            total += number.doubleValue(); // Number 메서드 사용
        }
        return total;
    }
    
    public double average() {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        return sum() / numbers.size();
    }
    
    public T max() {
        if (numbers.isEmpty()) {
            return null;
        }
        
        T maximum = numbers.get(0);
        for (T number : numbers) {
            if (number.doubleValue() > maximum.doubleValue()) {
                maximum = number;
            }
        }
        return maximum;
    }
}

// 사용 예
NumberCalculator<Integer> intCalc = new NumberCalculator<>();
intCalc.add(10);
intCalc.add(20);
intCalc.add(30);
System.out.println("합계: " + intCalc.sum());      // 60.0
System.out.println("평균: " + intCalc.average());   // 20.0

NumberCalculator<Double> doubleCalc = new NumberCalculator<>();
doubleCalc.add(1.5);
doubleCalc.add(2.5);
System.out.println("최대값: " + doubleCalc.max()); // 2.5
```

### 5.3 인터페이스 제한

```java
public class ComparableList<T extends Comparable<T>> {
    private List<T> items;
    
    public ComparableList() {
        this.items = new ArrayList<>();
    }
    
    public void add(T item) {
        items.add(item);
    }
    
    // Comparable 인터페이스 메서드 사용 가능
    public void sort() {
        Collections.sort(items); // T가 Comparable이므로 정렬 가능
    }
    
    public T findMin() {
        if (items.isEmpty()) {
            return null;
        }
        
        T min = items.get(0);
        for (T item : items) {
            if (item.compareTo(min) < 0) { // compareTo 사용 가능
                min = item;
            }
        }
        return min;
    }
}

// 사용 예
ComparableList<String> strings = new ComparableList<>();
strings.add("zebra");
strings.add("apple");
strings.add("banana");
strings.sort();
System.out.println("최소값: " + strings.findMin()); // "apple"
```

### 5.4 다중 제한

```java
// 여러 인터페이스나 클래스로 제한
public class AdvancedContainer<T extends Serializable & Comparable<T> & Cloneable> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    // 모든 제한된 인터페이스의 메서드 사용 가능
    public T cloneItem() throws CloneNotSupportedException {
        return (T) ((Cloneable) item).clone();
    }
    
    public int compareWithOther(T other) {
        return item.compareTo(other);
    }
}
```

### 5.5 제네릭 메서드의 제한된 타입

```java
// 정렬된 리스트에 요소 삽입
public static <T extends Comparable<T>> void sortedInsert(List<T> sortedList, T newItem) {
    ListIterator<T> iterator = sortedList.listIterator();
    
    while (iterator.hasNext()) {
        T current = iterator.next();
        if (newItem.compareTo(current) <= 0) { // compareTo 사용 가능
            iterator.previous();
            break;
        }
    }
    
    iterator.add(newItem);
}

// 사용 예
List<String> sortedWords = new ArrayList<>(Arrays.asList("apple", "cherry", "grape"));
sortedInsert(sortedWords, "banana");
System.out.println(sortedWords); // [apple, banana, cherry, grape]
```

## 6. 실전 활용 가이드

### 6.1 언제 제네릭 클래스를 만들까?

**만들어야 하는 경우**:
- 동일한 로직이 다른 타입에 반복 적용될 때
- 타입 안전성이 중요한 컨테이너 클래스
- 재사용 가능한 유틸리티 클래스

```java
// 좋은 예: 제네릭 캐시
public class Cache<K, V> {
    private Map<K, V> cache = new HashMap<>();
    private int maxSize;
    
    public Cache(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public V get(K key) {
        return cache.get(key);
    }
    
    public void put(K key, V value) {
        if (cache.size() >= maxSize) {
            // 오래된 항목 제거 (LRU 등)
            removeOldest();
        }
        cache.put(key, value);
    }
    
    private void removeOldest() {
        // 구현 생략
    }
}
```

### 6.2 제네릭 vs 와일드카드 선택 기준

| 상황 | 사용 | 이유 |
|------|------|------|
| 클래스/인터페이스 정의 | 제네릭 타입 매개변수 | 타입 일관성 보장 |
| 메서드 매개변수 | 와일드카드 | 유연성 제공 |
| 여러 곳에서 같은 타입 참조 | 제네릭 타입 매개변수 | 타입 관계 유지 |
| 단순 읽기 전용 | `? extends` | 공변성 지원 |
| 쓰기 전용 | `? super` | 반공변성 지원 |

### 6.3 주의사항과 모범 사례

**주의사항**:
1. **타입 소거**: 런타임에 제네릭 정보 제거됨
2. **배열과 제네릭**: `new T[]` 불가능
3. **static 멤버**: 타입 매개변수 사용 불가
4. **예외 처리**: 제네릭 예외 클래스 불가

**모범 사례**:
```java
public class BestPracticeExample<T> {
    // 1. 의미있는 타입 매개변수 이름 사용
    private List<T> items;
    
    // 2. null 체크 포함
    public void add(T item) {
        if (item != null) {
            items.add(item);
        }
    }
    
    // 3. 제네릭 메서드로 유연성 제공
    public <U> List<U> transform(Function<T, U> mapper) {
        return items.stream()
                   .map(mapper)
                   .collect(Collectors.toList());
    }
    
    // 4. 와일드카드로 유연한 매개변수
    public void addAll(Collection<? extends T> collection) {
        items.addAll(collection);
    }
}
```

## 마무리

제네릭 프로그래밍은 Java의 핵심 기능 중 하나입니다:

1. **제네릭 클래스**: 타입 안전성과 재사용성 제공
2. **제네릭 메서드**: 유연하고 타입 안전한 메서드 작성
3. **와일드카드**: 매개변수 유연성 증대
4. **제한된 타입**: 특정 타입으로 제한하여 더 풍부한 API 제공

이러한 기법들을 적절히 조합하면 강건하고 재사용 가능한 코드를 작성할 수 있습니다!