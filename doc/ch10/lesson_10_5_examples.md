# 10.5 제네릭 클래스 및 메서드 작성하기 - 예제 모음

## 1. 제네릭 클래스 예제

### 예제 1-1: 제네릭 큐 (Queue) 구현

```java
import java.util.*;

public class GenericQueue<T> {
    private LinkedList<T> items;
    
    public GenericQueue() {
        items = new LinkedList<>();
    }
    
    // 큐에 요소 추가 (enqueue)
    public void enqueue(T item) {
        items.addLast(item);
    }
    
    // 큐에서 요소 제거 (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("큐가 비어있습니다");
        }
        return items.removeFirst();
    }
    
    // 큐의 첫 번째 요소 확인 (peek)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("큐가 비어있습니다");
        }
        return items.getFirst();
    }
    
    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    // 큐의 크기
    public int size() {
        return items.size();
    }
    
    // 모든 요소를 다른 컬렉션에 추가
    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            enqueue(item);
        }
    }
    
    // 큐의 모든 요소를 다른 컬렉션으로 이동
    public void drainTo(Collection<? super T> collection) {
        while (!isEmpty()) {
            collection.add(dequeue());
        }
    }
    
    @Override
    public String toString() {
        return "Queue" + items.toString();
    }
    
    public static void main(String[] args) {
        // String 큐 테스트
        GenericQueue<String> stringQueue = new GenericQueue<>();
        stringQueue.enqueue("첫 번째");
        stringQueue.enqueue("두 번째");
        stringQueue.enqueue("세 번째");
        
        System.out.println("String 큐: " + stringQueue);
        System.out.println("Dequeue: " + stringQueue.dequeue());
        System.out.println("Peek: " + stringQueue.peek());
        
        // Integer 큐 테스트
        GenericQueue<Integer> intQueue = new GenericQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);
        
        System.out.println("\nInteger 큐: " + intQueue);
        System.out.println("크기: " + intQueue.size());
        
        // 컬렉션 추가 테스트
        List<Integer> numbers = Arrays.asList(40, 50, 60);
        intQueue.addAll(numbers);
        System.out.println("addAll 후: " + intQueue);
        
        // 다른 컬렉션으로 이동
        List<Integer> result = new ArrayList<>();
        intQueue.drainTo(result);
        System.out.println("drainTo 결과: " + result);
        System.out.println("큐 상태: " + intQueue);
    }
}
```

### 예제 1-2: 제네릭 스택 (Stack) 구현

```java
import java.util.*;

public class GenericStack<T> {
    private ArrayList<T> items;
    
    public GenericStack() {
        items = new ArrayList<>();
    }
    
    public GenericStack(int initialCapacity) {
        items = new ArrayList<>(initialCapacity);
    }
    
    // 스택에 요소 추가 (push)
    public void push(T item) {
        items.add(item);
    }
    
    // 스택에서 요소 제거 (pop)
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }
    
    // 스택의 최상위 요소 확인 (peek)
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }
    
    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    // 스택의 크기
    public int size() {
        return items.size();
    }
    
    // 특정 요소 검색 (인덱스 반환)
    public int search(T item) {
        if (item == null) {
            for (int i = items.size() - 1; i >= 0; i--) {
                if (items.get(i) == null) {
                    return items.size() - i; // 1-based 인덱스
                }
            }
        } else {
            for (int i = items.size() - 1; i >= 0; i--) {
                if (item.equals(items.get(i))) {
                    return items.size() - i; // 1-based 인덱스
                }
            }
        }
        return -1; // 찾지 못함
    }
    
    // 스택 복사
    public GenericStack<T> copy() {
        GenericStack<T> newStack = new GenericStack<>();
        newStack.items = new ArrayList<>(this.items);
        return newStack;
    }
    
    @Override
    public String toString() {
        return "Stack" + items.toString();
    }
    
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        
        // 요소 추가
        stack.push("bottom");
        stack.push("middle");
        stack.push("top");
        
        System.out.println("스택: " + stack);
        System.out.println("크기: " + stack.size());
        
        // peek과 pop
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("스택: " + stack);
        
        // 검색
        System.out.println("'middle' 위치: " + stack.search("middle"));
        System.out.println("'bottom' 위치: " + stack.search("bottom"));
        System.out.println("'없음' 위치: " + stack.search("없음"));
        
        // 스택 복사
        GenericStack<String> copied = stack.copy();
        System.out.println("복사된 스택: " + copied);
    }
}
```

### 예제 1-3: 제네릭 Pair 클래스

```java
import java.util.*;

public class Pair<T, S> {
    private T first;
    private S second;
    
    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
    
    // Getter와 Setter
    public T getFirst() {
        return first;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
    public S getSecond() {
        return second;
    }
    
    public void setSecond(S second) {
        this.second = second;
    }
    
    // 값 교환
    public Pair<S, T> swap() {
        return new Pair<>(second, first);
    }
    
    // 첫 번째와 두 번째가 같은지 비교
    public boolean isEqual() {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        return first.equals(second);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(first, pair.first) && 
               Objects.equals(second, pair.second);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    
    // 정적 팩토리 메서드
    public static <T, S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }
    
    public static void main(String[] args) {
        // 다양한 타입 조합
        Pair<String, Integer> nameAge = new Pair<>("김철수", 25);
        Pair<Double, Double> coordinates = new Pair<>(3.14, 2.71);
        Pair<String, String> keyValue = new Pair<>("name", "홍길동");
        
        System.out.println("이름-나이: " + nameAge);
        System.out.println("좌표: " + coordinates);
        System.out.println("키-값: " + keyValue);
        
        // 값 교환
        Pair<Integer, String> swapped = nameAge.swap();
        System.out.println("교환된 값: " + swapped);
        
        // 같은 값인지 확인
        System.out.println("keyValue 같은 값? " + keyValue.isEqual());
        
        Pair<String, String> same = new Pair<>("test", "test");
        System.out.println("same 같은 값? " + same.isEqual());
        
        // 정적 메서드 사용
        Pair<Integer, Boolean> numFlag = Pair.of(42, true);
        System.out.println("정적 생성: " + numFlag);
        
        // 컬렉션에서 사용
        List<Pair<String, Integer>> scores = Arrays.asList(
            Pair.of("Alice", 95),
            Pair.of("Bob", 87),
            Pair.of("Charlie", 92)
        );
        
        System.out.println("\n점수 목록:");
        for (Pair<String, Integer> score : scores) {
            System.out.println(score.getFirst() + ": " + score.getSecond() + "점");
        }
    }
}
```

### 예제 1-4: 제네릭 캐시 시스템

```java
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GenericCache<K, V> {
    private final Map<K, CacheEntry<V>> cache;
    private final int maxSize;
    private final long ttlMillis; // Time To Live
    
    private static class CacheEntry<V> {
        final V value;
        final long createdTime;
        
        CacheEntry(V value) {
            this.value = value;
            this.createdTime = System.currentTimeMillis();
        }
        
        boolean isExpired(long ttlMillis) {
            return ttlMillis > 0 && 
                   (System.currentTimeMillis() - createdTime) > ttlMillis;
        }
    }
    
    public GenericCache(int maxSize) {
        this(maxSize, -1); // TTL 없음
    }
    
    public GenericCache(int maxSize, long ttlMillis) {
        this.cache = new ConcurrentHashMap<>();
        this.maxSize = maxSize;
        this.ttlMillis = ttlMillis;
    }
    
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("키는 null일 수 없습니다");
        }
        
        // 캐시 크기 확인
        if (cache.size() >= maxSize) {
            evictOldest();
        }
        
        cache.put(key, new CacheEntry<>(value));
    }
    
    public V get(K key) {
        if (key == null) {
            return null;
        }
        
        CacheEntry<V> entry = cache.get(key);
        if (entry == null) {
            return null;
        }
        
        // TTL 확인
        if (entry.isExpired(ttlMillis)) {
            cache.remove(key);
            return null;
        }
        
        return entry.value;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public V remove(K key) {
        CacheEntry<V> entry = cache.remove(key);
        return entry != null ? entry.value : null;
    }
    
    public void clear() {
        cache.clear();
    }
    
    public int size() {
        cleanupExpired();
        return cache.size();
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    // 만료된 항목 정리
    private void cleanupExpired() {
        if (ttlMillis <= 0) return;
        
        cache.entrySet().removeIf(entry -> 
            entry.getValue().isExpired(ttlMillis));
    }
    
    // 가장 오래된 항목 제거 (LRU 대신 단순 구현)
    private void evictOldest() {
        if (cache.isEmpty()) return;
        
        K oldestKey = null;
        long oldestTime = Long.MAX_VALUE;
        
        for (Map.Entry<K, CacheEntry<V>> entry : cache.entrySet()) {
            if (entry.getValue().createdTime < oldestTime) {
                oldestTime = entry.getValue().createdTime;
                oldestKey = entry.getKey();
            }
        }
        
        if (oldestKey != null) {
            cache.remove(oldestKey);
        }
    }
    
    // 통계 정보
    public void printStats() {
        cleanupExpired();
        System.out.println("캐시 통계:");
        System.out.println("  현재 크기: " + cache.size());
        System.out.println("  최대 크기: " + maxSize);
        System.out.println("  TTL: " + (ttlMillis > 0 ? ttlMillis + "ms" : "무제한"));
    }
    
    public static void main(String[] args) throws InterruptedException {
        // 기본 캐시 테스트
        GenericCache<String, Integer> cache = new GenericCache<>(3);
        
        cache.put("one", 1);
        cache.put("two", 2);
        cache.put("three", 3);
        
        System.out.println("캐시 값들:");
        System.out.println("one: " + cache.get("one"));
        System.out.println("two: " + cache.get("two"));
        System.out.println("three: " + cache.get("three"));
        
        // 크기 초과 테스트
        cache.put("four", 4); // 가장 오래된 항목 제거됨
        System.out.println("\n크기 초과 후:");
        System.out.println("one: " + cache.get("one")); // null일 수 있음
        System.out.println("four: " + cache.get("four"));
        
        cache.printStats();
        
        // TTL 테스트
        System.out.println("\n=== TTL 테스트 ===");
        GenericCache<String, String> ttlCache = new GenericCache<>(5, 1000); // 1초 TTL
        
        ttlCache.put("temp", "임시 데이터");
        System.out.println("즉시 조회: " + ttlCache.get("temp"));
        
        Thread.sleep(1100); // 1.1초 대기
        
        System.out.println("1.1초 후 조회: " + ttlCache.get("temp")); // null
        ttlCache.printStats();
    }
}
```

## 2. 제네릭 메서드 예제

### 예제 2-1: 배열 유틸리티 메서드들

```java
import java.util.*;
import java.util.function.Predicate;

public class GenericArrayUtils {
    
    // 배열에서 특정 요소 찾기
    public static <T> int indexOf(T[] array, T target) {
        if (array == null) {
            return -1;
        }
        
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], target)) {
                return i;
            }
        }
        return -1;
    }
    
    // 배열에서 특정 요소의 개수 세기
    public static <T> int countOccurrences(T[] array, T target) {
        if (array == null) {
            return 0;
        }
        
        int count = 0;
        for (T item : array) {
            if (Objects.equals(item, target)) {
                count++;
            }
        }
        return count;
    }
    
    // 배열 뒤집기
    public static <T> void reverse(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    
    // 배열에서 조건에 맞는 첫 번째 요소 찾기
    public static <T> T findFirst(T[] array, Predicate<T> predicate) {
        if (array == null || predicate == null) {
            return null;
        }
        
        for (T item : array) {
            if (predicate.test(item)) {
                return item;
            }
        }
        return null;
    }
    
    // 배열에서 조건에 맞는 모든 요소 필터링
    public static <T> List<T> filter(T[] array, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        
        if (array == null || predicate == null) {
            return result;
        }
        
        for (T item : array) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
    // 두 배열 합치기
    @SafeVarargs
    public static <T> List<T> concat(T[]... arrays) {
        List<T> result = new ArrayList<>();
        
        for (T[] array : arrays) {
            if (array != null) {
                Collections.addAll(result, array);
            }
        }
        return result;
    }
    
    // 배열을 문자열로 변환 (구분자 사용)
    public static <T> String join(T[] array, String delimiter) {
        if (array == null || array.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        
        for (int i = 1; i < array.length; i++) {
            sb.append(delimiter).append(array[i]);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // String 배열 테스트
        String[] words = {"apple", "banana", "cherry", "banana", "date"};
        
        System.out.println("원본 배열: " + Arrays.toString(words));
        System.out.println("'banana' 인덱스: " + indexOf(words, "banana"));
        System.out.println("'banana' 개수: " + countOccurrences(words, "banana"));
        
        // 배열 뒤집기
        String[] wordsCopy = words.clone();
        reverse(wordsCopy);
        System.out.println("뒤집힌 배열: " + Arrays.toString(wordsCopy));
        
        // 조건 검색
        String longWord = findFirst(words, word -> word.length() > 5);
        System.out.println("6글자 이상 첫 단어: " + longWord);
        
        // 필터링
        List<String> shortWords = filter(words, word -> word.length() <= 5);
        System.out.println("5글자 이하 단어들: " + shortWords);
        
        // 배열 합치기
        String[] fruits = {"apple", "banana"};
        String[] vegetables = {"carrot", "broccoli"};
        List<String> combined = concat(fruits, vegetables);
        System.out.println("합친 결과: " + combined);
        
        // 문자열 연결
        String joined = join(words, ", ");
        System.out.println("연결된 문자열: " + joined);
        
        // Integer 배열 테스트
        Integer[] numbers = {1, 2, 3, 2, 4, 5, 2};
        System.out.println("\n숫자 배열: " + Arrays.toString(numbers));
        System.out.println("2의 개수: " + countOccurrences(numbers, 2));
        
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("짝수들: " + evenNumbers);
    }
}
```

### 예제 2-2: 컬렉션 유틸리티 메서드들

```java
import java.util.*;
import java.util.function.*;

public class GenericCollectionUtils {
    
    // 컬렉션에서 특정 요소 개수 세기
    public static <T> int countOccurrences(Collection<T> collection, T target) {
        if (collection == null) {
            return 0;
        }
        
        int count = 0;
        for (T item : collection) {
            if (Objects.equals(item, target)) {
                count++;
            }
        }
        return count;
    }
    
    // 두 컬렉션의 교집합
    public static <T> Set<T> intersection(Collection<T> col1, Collection<T> col2) {
        Set<T> result = new HashSet<>();
        
        if (col1 == null || col2 == null) {
            return result;
        }
        
        for (T item : col1) {
            if (col2.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
    // 두 컬렉션의 합집합
    public static <T> Set<T> union(Collection<T> col1, Collection<T> col2) {
        Set<T> result = new HashSet<>();
        
        if (col1 != null) {
            result.addAll(col1);
        }
        if (col2 != null) {
            result.addAll(col2);
        }
        
        return result;
    }
    
    // 두 컬렉션의 차집합 (col1 - col2)
    public static <T> Set<T> difference(Collection<T> col1, Collection<T> col2) {
        Set<T> result = new HashSet<>();
        
        if (col1 == null) {
            return result;
        }
        
        for (T item : col1) {
            if (col2 == null || !col2.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
    // 컬렉션 변환
    public static <T, R> List<R> map(Collection<T> collection, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        
        if (collection == null || mapper == null) {
            return result;
        }
        
        for (T item : collection) {
            result.add(mapper.apply(item));
        }
        return result;
    }
    
    // 컬렉션 필터링
    public static <T> List<T> filter(Collection<T> collection, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        
        if (collection == null || predicate == null) {
            return result;
        }
        
        for (T item : collection) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
    // 조건에 맞는 첫 번째 요소 찾기
    public static <T> Optional<T> findFirst(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null || predicate == null) {
            return Optional.empty();
        }
        
        for (T item : collection) {
            if (predicate.test(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
    
    // 모든 요소가 조건을 만족하는지 확인
    public static <T> boolean allMatch(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null || predicate == null) {
            return false;
        }
        
        for (T item : collection) {
            if (!predicate.test(item)) {
                return false;
            }
        }
        return true;
    }
    
    // 하나라도 조건을 만족하는지 확인
    public static <T> boolean anyMatch(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null || predicate == null) {
            return false;
        }
        
        for (T item : collection) {
            if (predicate.test(item)) {
                return true;
            }
        }
        return false;
    }
    
    // 컬렉션을 그룹핑
    public static <T, K> Map<K, List<T>> groupBy(Collection<T> collection, Function<T, K> keyExtractor) {
        Map<K, List<T>> result = new HashMap<>();
        
        if (collection == null || keyExtractor == null) {
            return result;
        }
        
        for (T item : collection) {
            K key = keyExtractor.apply(item);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // 테스트 데이터
        List<String> list1 = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> list2 = Arrays.asList("banana", "cherry", "elderberry", "fig");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        
        // 집합 연산
        System.out.println("\n=== 집합 연산 ===");
        System.out.println("교집합: " + intersection(list1, list2));
        System.out.println("합집합: " + union(list1, list2));
        System.out.println("차집합 (list1 - list2): " + difference(list1, list2));
        
        // 변환과 필터링
        System.out.println("\n=== 변환과 필터링 ===");
        List<String> upperCase = map(list1, String::toUpperCase);
        System.out.println("대문자 변환: " + upperCase);
        
        List<String> longWords = filter(list1, word -> word.length() > 5);
        System.out.println("6글자 이상: " + longWords);
        
        // 검색
        Optional<String> firstLongWord = findFirst(list1, word -> word.length() > 5);
        System.out.println("첫 번째 긴 단어: " + firstLongWord.orElse("없음"));
        
        // 조건 확인
        System.out.println("\n=== 조건 확인 ===");
        boolean allLong = allMatch(list1, word -> word.length() > 3);
        System.out.println("모든 단어가 4글자 이상? " + allLong);
        
        boolean anyLong = anyMatch(list1, word -> word.length() > 6);
        System.out.println("7글자 이상 단어 있나? " + anyLong);
        
        // 그룹핑
        System.out.println("\n=== 그룹핑 ===");
        Map<Integer, List<String>> wordsByLength = groupBy(list1, String::length);
        System.out.println("길이별 그룹핑: " + wordsByLength);
        
        // 숫자 테스트
        System.out.println("\n=== 숫자 테스트 ===");
        System.out.println("숫자: " + numbers);
        
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("짝수: " + evenNumbers);
        
        List<String> numberStrings = map(numbers, Object::toString);
        System.out.println("문자열로 변환: " + numberStrings);
        
        Map<Boolean, List<Integer>> evenOddGroups = groupBy(numbers, n -> n % 2 == 0);
        System.out.println("짝수/홀수 그룹: " + evenOddGroups);
    }
}
```

## 3. 와일드카드 타입 예제

### 예제 3-1: 도형 그리기 시스템

```java
import java.util.*;

// 기본 도형 클래스
abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public abstract void draw();
    public abstract double getArea();
    
    @Override
    public String toString() {
        return name;
    }
}

// 구체적인 도형들
class Rectangle extends Shape {
    private double width, height;
    
    public Rectangle(double width, double height) {
        super("사각형");
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("사각형을 그립니다 (" + width + " x " + height + ")");
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("원");
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("원을 그립니다 (반지름: " + radius + ")");
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    private double base, height;
    
    public Triangle(double base, double height) {
        super("삼각형");
        this.base = base;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("삼각형을 그립니다 (밑변: " + base + ", 높이: " + height + ")");
    }
    
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class WildcardShapeExample {
    
    // extends 와일드카드 - 읽기 전용
    public static void drawAllShapes(Collection<? extends Shape> shapes) {
        System.out.println("=== 모든 도형 그리기 ===");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    
    // extends 와일드카드 - 총 면적 계산
    public static double calculateTotalArea(Collection<? extends Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
    
    // super 와일드카드 - 쓰기 전용
    public static void addShapes(Collection<? super Rectangle> shapes) {
        shapes.add(new Rectangle(5, 3));
        shapes.add(new Rectangle(2, 4));
        // shapes.add(new Circle(3)); // 컴파일 오류!
    }
    
    // 복사 메서드 - PECS 패턴
    public static <T> void copy(Collection<? extends T> source, 
                               Collection<? super T> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }
    
    // 무제한 와일드카드
    public static void printCollection(Collection<?> collection) {
        System.out.println("컬렉션 내용:");
        for (Object item : collection) {
            System.out.println("  " + item);
        }
    }
    
    // 도형 필터링 (extends 와일드카드)
    public static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea) {
        List<Shape> filtered = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getArea() >= minArea) {
                filtered.add(shape);
            }
        }
        return filtered;
    }
    
    public static void main(String[] args) {
        // 다양한 도형 컬렉션 생성
        List<Rectangle> rectangles = Arrays.asList(
            new Rectangle(3, 4),
            new Rectangle(5, 2)
        );
        
        List<Circle> circles = Arrays.asList(
            new Circle(2),
            new Circle(3)
        );
        
        List<Triangle> triangles = Arrays.asList(
            new Triangle(4, 3),
            new Triangle(6, 5)
        );
        
        List<Shape> allShapes = new ArrayList<>();
        allShapes.addAll(rectangles);
        allShapes.addAll(circles);
        allShapes.addAll(triangles);
        
        // extends 와일드카드 테스트
        System.out.println("=== Rectangle 그리기 ===");
        drawAllShapes(rectangles);
        
        System.out.println("\n=== Circle 그리기 ===");
        drawAllShapes(circles);
        
        System.out.println("\n=== 모든 도형 그리기 ===");
        drawAllShapes(allShapes);
        
        // 면적 계산
        System.out.println("\n=== 면적 계산 ===");
        System.out.printf("사각형 총 면적: %.2f\n", calculateTotalArea(rectangles));
        System.out.printf("원 총 면적: %.2f\n", calculateTotalArea(circles));
        System.out.printf("전체 총 면적: %.2f\n", calculateTotalArea(allShapes));
        
        // super 와일드카드 테스트
        System.out.println("\n=== Super 와일드카드 테스트 ===");
        List<Shape> shapeList = new ArrayList<>();
        List<Rectangle> rectList = new ArrayList<>();
        
        addShapes(shapeList);  // Rectangle을 Shape 리스트에 추가
        addShapes(rectList);   // Rectangle을 Rectangle 리스트에 추가
        
        System.out.println("추가된 Shape 리스트:");
        printCollection(shapeList);
        
        // 복사 테스트 (PECS)
        System.out.println("\n=== 복사 테스트 ===");
        List<Shape> copiedShapes = new ArrayList<>();
        copy(rectangles, copiedShapes);  // Rectangle → Shape
        copy(circles, copiedShapes);     // Circle → Shape
        
        System.out.println("복사된 도형들:");
        printCollection(copiedShapes);
        
        // 필터링 테스트
        System.out.println("\n=== 필터링 테스트 ===");
        List<Shape> largeShapes = filterByMinArea(allShapes, 10.0);
        System.out.println("면적 10 이상인 도형들:");
        for (Shape shape : largeShapes) {
            System.out.printf("%s (면적: %.2f)\n", shape, shape.getArea());
        }
    }
}
```

## 4. 제한된 타입 (Bounded Types) 예제

### 예제 4-1: 숫자 연산 클래스

```java
import java.util.*;

public class NumberProcessor<T extends Number> {
    private List<T> numbers;
    
    public NumberProcessor() {
        this.numbers = new ArrayList<>();
    }
    
    public void add(T number) {
        if (number != null) {
            numbers.add(number);
        }
    }
    
    public void addAll(Collection<? extends T> collection) {
        numbers.addAll(collection);
    }
    
    // Number의 메서드들을 사용할 수 있음
    public double sum() {
        double total = 0.0;
        for (T number : numbers) {
            total += number.doubleValue();
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
    
    public T min() {
        if (numbers.isEmpty()) {
            return null;
        }
        
        T minimum = numbers.get(0);
        for (T number : numbers) {
            if (number.doubleValue() < minimum.doubleValue()) {
                minimum = number;
            }
        }
        return minimum;
    }
    
    // 통계 정보
    public void printStatistics() {
        if (numbers.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return;
        }
        
        System.out.println("=== 통계 정보 ===");
        System.out.println("개수: " + numbers.size());
        System.out.printf("합계: %.2f\n", sum());
        System.out.printf("평균: %.2f\n", average());
        System.out.println("최댓값: " + max());
        System.out.println("최솟값: " + min());
    }
    
    // 조건에 맞는 숫자들 필터링
    public List<T> filter(double minValue, double maxValue) {
        List<T> filtered = new ArrayList<>();
        for (T number : numbers) {
            double value = number.doubleValue();
            if (value >= minValue && value <= maxValue) {
                filtered.add(number);
            }
        }
        return filtered;
    }
    
    @Override
    public String toString() {
        return "NumberProcessor" + numbers.toString();
    }
    
    public static void main(String[] args) {
        // Integer 처리
        NumberProcessor<Integer> intProcessor = new NumberProcessor<>();
        intProcessor.add(10);
        intProcessor.add(20);
        intProcessor.add(15);
        intProcessor.add(30);
        intProcessor.add(5);
        
        System.out.println("Integer 프로세서: " + intProcessor);
        intProcessor.printStatistics();
        
        System.out.println("10~20 범위: " + intProcessor.filter(10, 20));
        
        // Double 처리
        System.out.println("\n" + "=".repeat(40));
        NumberProcessor<Double> doubleProcessor = new NumberProcessor<>();
        doubleProcessor.addAll(Arrays.asList(1.5, 2.3, 3.7, 1.2, 4.8));
        
        System.out.println("Double 프로세서: " + doubleProcessor);
        doubleProcessor.printStatistics();
        
        // Float 처리
        System.out.println("\n" + "=".repeat(40));
        NumberProcessor<Float> floatProcessor = new NumberProcessor<>();
        floatProcessor.add(1.1f);
        floatProcessor.add(2.2f);
        floatProcessor.add(3.3f);
        
        System.out.println("Float 프로세서: " + floatProcessor);
        floatProcessor.printStatistics();
        
        // 컬렉션 추가 테스트
        List<Integer> moreInts = Arrays.asList(100, 200, 300);
        intProcessor.addAll(moreInts);
        System.out.println("\n추가 후 Integer 프로세서: " + intProcessor);
        intProcessor.printStatistics();
    }
}
```

### 예제 4-2: 비교 가능한 요소들의 정렬된 리스트

```java
import java.util.*;

public class SortedList<T extends Comparable<T>> {
    private List<T> items;
    
    public SortedList() {
        this.items = new ArrayList<>();
    }
    
    // 요소를 정렬된 위치에 삽입
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("null 값은 추가할 수 없습니다");
        }
        
        int insertIndex = findInsertionPoint(item);
        items.add(insertIndex, item);
    }
    
    // 이진 탐색으로 삽입 위치 찾기
    private int findInsertionPoint(T item) {
        int left = 0;
        int right = items.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (items.get(mid).compareTo(item) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // 여러 요소 추가
    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }
    
    // 특정 요소 제거
    public boolean remove(T item) {
        return items.remove(item);
    }
    
    // 인덱스로 요소 제거
    public T remove(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("인덱스: " + index);
        }
        return items.remove(index);
    }
    
    // 특정 요소 포함 여부 확인
    public boolean contains(T item) {
        return binarySearch(item) >= 0;
    }
    
    // 이진 탐색
    public int indexOf(T item) {
        int index = binarySearch(item);
        return index >= 0 ? index : -1;
    }
    
    private int binarySearch(T item) {
        int left = 0;
        int right = items.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = items.get(mid).compareTo(item);
            
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // 특정 범위의 요소들 가져오기
    public List<T> subList(T fromElement, T toElement) {
        List<T> result = new ArrayList<>();
        
        for (T item : items) {
            if (item.compareTo(fromElement) >= 0 && item.compareTo(toElement) <= 0) {
                result.add(item);
            }
        }
        
        return result;
    }
    
    // 첫 번째와 마지막 요소
    public T first() {
        if (items.isEmpty()) {
            throw new NoSuchElementException("리스트가 비어있습니다");
        }
        return items.get(0);
    }
    
    public T last() {
        if (items.isEmpty()) {
            throw new NoSuchElementException("리스트가 비어있습니다");
        }
        return items.get(items.size() - 1);
    }
    
    // 크기와 빈 상태 확인
    public int size() {
        return items.size();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    // 모든 요소 제거
    public void clear() {
        items.clear();
    }
    
    // 복사본 만들기
    public SortedList<T> copy() {
        SortedList<T> newList = new SortedList<>();
        newList.items = new ArrayList<>(this.items);
        return newList;
    }
    
    // Iterator 제공
    public Iterator<T> iterator() {
        return items.iterator();
    }
    
    @Override
    public String toString() {
        return items.toString();
    }
    
    public static void main(String[] args) {
        // String 테스트
        SortedList<String> words = new SortedList<>();
        words.add("banana");
        words.add("apple");
        words.add("cherry");
        words.add("date");
        
        System.out.println("문자열 리스트: " + words);
        System.out.println("'cherry' 인덱스: " + words.indexOf("cherry"));
        System.out.println("'apple' 포함? " + words.contains("apple"));
        
        // 범위 검색
        List<String> range = words.subList("banana", "date");
        System.out.println("'banana'~'date' 범위: " + range);
        
        // Integer 테스트
        SortedList<Integer> numbers = new SortedList<>();
        numbers.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        
        System.out.println("\n정수 리스트: " + numbers);
        System.out.println("첫 번째: " + numbers.first());
        System.out.println("마지막: " + numbers.last());
        
        // 범위 검색
        List<Integer> numberRange = numbers.subList(3, 8);
        System.out.println("3~8 범위: " + numberRange);
        
        // 제거 테스트
        numbers.remove(Integer.valueOf(5));
        System.out.println("5 제거 후: " + numbers);
        
        // 반복자 테스트
        System.out.print("반복자로 출력: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 복사 테스트
        SortedList<Integer> copied = numbers.copy();
        copied.add(10);
        System.out.println("원본: " + numbers);
        System.out.println("복사본: " + copied);
    }
}
```

### 예제 4-3: 다중 제한 타입 예제

```java
import java.io.*;
import java.util.*;

// 직렬화 가능하고 비교 가능한 객체를 위한 저장소
public class PersistentSortedStorage<T extends Serializable & Comparable<T>> {
    private List<T> items;
    private String filename;
    
    public PersistentSortedStorage(String filename) {
        this.filename = filename;
        this.items = new ArrayList<>();
        loadFromFile();
    }
    
    // 요소 추가 (정렬된 순서 유지)
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("null 값은 추가할 수 없습니다");
        }
        
        int insertIndex = Collections.binarySearch(items, item);
        if (insertIndex < 0) {
            insertIndex = -insertIndex - 1;
        }
        items.add(insertIndex, item);
        
        saveToFile(); // 자동 저장
    }
    
    // 요소 제거
    public boolean remove(T item) {
        boolean removed = items.remove(item);
        if (removed) {
            saveToFile(); // 자동 저장
        }
        return removed;
    }
    
    // 검색
    public boolean contains(T item) {
        return Collections.binarySearch(items, item) >= 0;
    }
    
    public int indexOf(T item) {
        int index = Collections.binarySearch(items, item);
        return index >= 0 ? index : -1;
    }
    
    // 범위 검색
    public List<T> getRange(T from, T to) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.compareTo(from) >= 0 && item.compareTo(to) <= 0) {
                result.add(item);
            }
        }
        return result;
    }
    
    // 기본 정보
    public int size() {
        return items.size();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
    
    // 파일 저장
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(items);
        } catch (IOException e) {
            System.err.println("저장 실패: " + e.getMessage());
        }
    }
    
    // 파일 로드
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            items = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 파일이 없으면 빈 리스트로 시작
            items = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("로드 실패: " + e.getMessage());
            items = new ArrayList<>();
        }
    }
    
    // 수동 저장
    public void save() {
        saveToFile();
    }
    
    // 파일에서 다시 로드
    public void reload() {
        loadFromFile();
    }
    
    @Override
    public String toString() {
        return "PersistentSortedStorage" + items.toString();
    }
    
    public static void main(String[] args) {
        // String 저장소 테스트
        PersistentSortedStorage<String> stringStorage = 
            new PersistentSortedStorage<>("strings.dat");
        
        System.out.println("초기 문자열 저장소: " + stringStorage);
        
        // 데이터 추가
        stringStorage.add("banana");
        stringStorage.add("apple");
        stringStorage.add("cherry");
        stringStorage.add("date");
        
        System.out.println("추가 후: " + stringStorage);
        
        // 검색
        System.out.println("'cherry' 포함? " + stringStorage.contains("cherry"));
        System.out.println("'apple' 인덱스: " + stringStorage.indexOf("apple"));
        
        // 범위 검색
        List<String> range = stringStorage.getRange("banana", "date");
        System.out.println("'banana'~'date' 범위: " + range);
        
        // Integer 저장소 테스트
        System.out.println("\n" + "=".repeat(40));
        PersistentSortedStorage<Integer> intStorage = 
            new PersistentSortedStorage<>("integers.dat");
        
        System.out.println("초기 정수 저장소: " + intStorage);
        
        // 데이터 추가
        intStorage.add(5);
        intStorage.add(2);
        intStorage.add(8);
        intStorage.add(1);
        intStorage.add(9);
        
        System.out.println("추가 후: " + intStorage);
        
        // 제거
        intStorage.remove(5);
        System.out.println("5 제거 후: " + intStorage);
        
        // 새로운 인스턴스로 테스트 (파일에서 로드)
        PersistentSortedStorage<Integer> intStorage2 = 
            new PersistentSortedStorage<>("integers.dat");
        System.out.println("새 인스턴스 로드: " + intStorage2);
        
        // 정리
        new File("strings.dat").delete();
        new File("integers.dat").delete();
    }
}
```

이 예제들은 제네릭 프로그래밍의 다양한 측면을 보여줍니다:
- 제네릭 클래스와 메서드의 실제 구현
- 와일드카드 타입의 적절한 사용법
- 제한된 타입으로 타입 안전성 보장
- 실전에서 유용한 패턴들

각 예제는 점진적으로 복잡해지며, 실제 프로젝트에서 활용할 수 있는 실용적인 코드들로 구성되어 있습니다.