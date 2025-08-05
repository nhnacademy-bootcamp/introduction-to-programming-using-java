# 10.2 목록과 집합 - 예제 모음

## 1. ArrayList vs LinkedList 성능 비교

### 예제 1-1: 성능 측정 프로그램

```java
import java.util.*;

public class ListPerformanceTest {
    
    public static void main(String[] args) {
        int size = 100000;
        
        // ArrayList 테스트
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        System.out.println("=== 성능 비교 (요소 수: " + size + ") ===\n");
        
        // 1. 끝에 추가
        System.out.println("1. 끝에 추가:");
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayAddEnd = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedAddEnd = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayAddEnd / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedAddEnd / 1_000_000.0);
        
        // 2. 처음에 추가
        System.out.println("\n2. 처음에 추가 (1000개):");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList2.add(0, i);
        }
        long arrayAddFirst = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList2.addFirst(i);
        }
        long linkedAddFirst = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayAddFirst / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedAddFirst / 1_000_000.0);
        
        // 3. 임의 접근
        System.out.println("\n3. 임의 접근 (10000번):");
        Random rand = new Random();
        
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int index = rand.nextInt(size);
            arrayList.get(index);
        }
        long arrayGet = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int index = rand.nextInt(size);
            linkedList.get(index);
        }
        long linkedGet = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayGet / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedGet / 1_000_000.0);
        
        // 4. 중간 삭제
        System.out.println("\n4. 중간 삭제 (100개):");
        ArrayList<Integer> arrayList3 = new ArrayList<>(arrayList);
        LinkedList<Integer> linkedList3 = new LinkedList<>(linkedList);
        
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList3.remove(arrayList3.size() / 2);
        }
        long arrayRemoveMid = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        ListIterator<Integer> iter = linkedList3.listIterator(linkedList3.size() / 2);
        for (int i = 0; i < 100; i++) {
            if (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
        }
        long linkedRemoveMid = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayRemoveMid / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedRemoveMid / 1_000_000.0);
    }
}
```

### 예제 1-2: 사용 사례별 리스트 선택

```java
import java.util.*;

public class ListUseCases {
    
    // 사례 1: 대량 데이터 저장 및 조회 - ArrayList 적합
    static class DataRepository {
        private ArrayList<String> data = new ArrayList<>();
        
        public void loadData(List<String> items) {
            data.addAll(items);
        }
        
        public String getData(int index) {
            return data.get(index);
        }
        
        public List<String> search(String keyword) {
            List<String> results = new ArrayList<>();
            for (String item : data) {
                if (item.contains(keyword)) {
                    results.add(item);
                }
            }
            return results;
        }
    }
    
    // 사례 2: 작업 큐 - LinkedList 적합
    static class TaskQueue {
        private LinkedList<String> tasks = new LinkedList<>();
        
        public void addTask(String task) {
            tasks.addLast(task);  // 끝에 추가
        }
        
        public void addUrgentTask(String task) {
            tasks.addFirst(task);  // 앞에 추가
        }
        
        public String getNextTask() {
            return tasks.pollFirst();  // 첫 번째 제거 및 반환
        }
        
        public boolean hasTask() {
            return !tasks.isEmpty();
        }
    }
    
    // 사례 3: 브라우저 히스토리 - LinkedList 적합
    static class BrowserHistory {
        private LinkedList<String> history = new LinkedList<>();
        private int currentIndex = -1;
        
        public void visit(String url) {
            // 현재 위치 이후의 히스토리 삭제
            while (history.size() > currentIndex + 1) {
                history.removeLast();
            }
            history.add(url);
            currentIndex++;
        }
        
        public String back() {
            if (currentIndex > 0) {
                currentIndex--;
                return history.get(currentIndex);
            }
            return null;
        }
        
        public String forward() {
            if (currentIndex < history.size() - 1) {
                currentIndex++;
                return history.get(currentIndex);
            }
            return null;
        }
        
        public String current() {
            return currentIndex >= 0 ? history.get(currentIndex) : null;
        }
    }
    
    public static void main(String[] args) {
        // 데이터 저장소 테스트
        DataRepository repo = new DataRepository();
        repo.loadData(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));
        System.out.println("Index 2: " + repo.getData(2));
        System.out.println("Search 'err': " + repo.search("err"));
        
        // 작업 큐 테스트
        System.out.println("\n=== 작업 큐 ===");
        TaskQueue queue = new TaskQueue();
        queue.addTask("일반 작업 1");
        queue.addTask("일반 작업 2");
        queue.addUrgentTask("긴급 작업");
        
        while (queue.hasTask()) {
            System.out.println("처리: " + queue.getNextTask());
        }
        
        // 브라우저 히스토리 테스트
        System.out.println("\n=== 브라우저 히스토리 ===");
        BrowserHistory browser = new BrowserHistory();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("github.com");
        
        System.out.println("현재: " + browser.current());
        System.out.println("뒤로: " + browser.back());
        System.out.println("뒤로: " + browser.back());
        System.out.println("앞으로: " + browser.forward());
        browser.visit("stackoverflow.com");
        System.out.println("새 방문: " + browser.current());
    }
}
```

## 2. ListIterator 활용

### 예제 2-1: 양방향 순회와 수정

```java
import java.util.*;

public class ListIteratorExample {
    
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        playlist.add("Song D");
        playlist.add("Song E");
        
        System.out.println("원본 재생목록: " + playlist);
        
        // ListIterator 생성
        ListIterator<String> iter = playlist.listIterator();
        
        // 앞으로 이동하며 출력
        System.out.println("\n=== 정방향 재생 ===");
        while (iter.hasNext()) {
            String song = iter.next();
            System.out.println("재생 중: " + song);
            
            // Song C 뒤에 새 곡 추가
            if (song.equals("Song C")) {
                iter.add("Song C-2");
                System.out.println("  -> 새 곡 추가됨");
            }
        }
        
        // 뒤로 이동하며 출력
        System.out.println("\n=== 역방향 재생 ===");
        while (iter.hasPrevious()) {
            String song = iter.previous();
            System.out.println("재생 중: " + song);
            
            // Song B를 새 버전으로 교체
            if (song.equals("Song B")) {
                iter.set("Song B (Remastered)");
                System.out.println("  -> 리마스터 버전으로 교체");
            }
        }
        
        System.out.println("\n최종 재생목록: " + playlist);
        
        // 특정 위치에서 시작
        System.out.println("\n=== 중간부터 재생 ===");
        ListIterator<String> midIter = playlist.listIterator(3);
        System.out.println("현재 위치: " + midIter.nextIndex());
        
        // 앞뒤로 한 곡씩
        if (midIter.hasNext()) {
            System.out.println("다음 곡: " + midIter.next());
        }
        if (midIter.hasPrevious()) {
            System.out.println("이전 곡: " + midIter.previous());
        }
    }
}
```

### 예제 2-2: 정렬된 리스트 유지

```java
import java.util.*;

public class SortedListMaintainer {
    
    // 정렬된 상태를 유지하며 삽입
    public static <T extends Comparable<T>> void insertSorted(List<T> list, T item) {
        ListIterator<T> iter = list.listIterator();
        
        while (iter.hasNext()) {
            T current = iter.next();
            if (item.compareTo(current) <= 0) {
                iter.previous();  // 한 칸 뒤로
                break;
            }
        }
        
        iter.add(item);  // 현재 위치에 삽입
    }
    
    // 병합 정렬 (두 정렬된 리스트 병합)
    public static <T extends Comparable<T>> List<T> mergeSortedLists(
            List<T> list1, List<T> list2) {
        
        List<T> result = new LinkedList<>();
        ListIterator<T> iter1 = list1.listIterator();
        ListIterator<T> iter2 = list2.listIterator();
        
        T item1 = iter1.hasNext() ? iter1.next() : null;
        T item2 = iter2.hasNext() ? iter2.next() : null;
        
        while (item1 != null || item2 != null) {
            if (item1 == null) {
                result.add(item2);
                item2 = iter2.hasNext() ? iter2.next() : null;
            } else if (item2 == null) {
                result.add(item1);
                item1 = iter1.hasNext() ? iter1.next() : null;
            } else if (item1.compareTo(item2) <= 0) {
                result.add(item1);
                item1 = iter1.hasNext() ? iter1.next() : null;
            } else {
                result.add(item2);
                item2 = iter2.hasNext() ? iter2.next() : null;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // 정렬된 삽입 테스트
        List<Integer> sortedList = new LinkedList<>();
        int[] values = {5, 2, 8, 1, 9, 3, 7};
        
        for (int value : values) {
            insertSorted(sortedList, value);
            System.out.println("삽입 " + value + " 후: " + sortedList);
        }
        
        // 병합 테스트
        List<String> list1 = Arrays.asList("apple", "cherry", "grape");
        List<String> list2 = Arrays.asList("banana", "date", "fig", "kiwi");
        
        List<String> merged = mergeSortedLists(list1, list2);
        System.out.println("\n병합 결과: " + merged);
    }
}
```

## 3. Collections 유틸리티 메서드

### 예제 3-1: 정렬과 검색

```java
import java.util.*;

public class CollectionsUtilExample {
    
    static class Student {
        String name;
        int score;
        
        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        @Override
        public String toString() {
            return name + "(" + score + ")";
        }
    }
    
    public static void main(String[] args) {
        // 1. 기본 정렬
        List<String> fruits = new ArrayList<>(
            Arrays.asList("banana", "apple", "cherry", "date", "elderberry")
        );
        
        System.out.println("원본: " + fruits);
        Collections.sort(fruits);
        System.out.println("정렬: " + fruits);
        
        // 2. 역순 정렬
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("역순: " + fruits);
        
        // 3. 커스텀 정렬
        List<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 85));
        students.add(new Student("이영희", 92));
        students.add(new Student("박민수", 85));
        students.add(new Student("정지원", 88));
        
        // 점수순 정렬 (높은 점수 우선)
        Collections.sort(students, (s1, s2) -> s2.score - s1.score);
        System.out.println("\n점수순: " + students);
        
        // 점수 같으면 이름순
        Collections.sort(students, (s1, s2) -> {
            int scoreCompare = Integer.compare(s2.score, s1.score);
            if (scoreCompare != 0) return scoreCompare;
            return s1.name.compareTo(s2.name);
        });
        System.out.println("점수순, 이름순: " + students);
        
        // 4. 이진 검색 (정렬된 리스트에서)
        Collections.sort(fruits);
        System.out.println("\n정렬된 과일: " + fruits);
        
        int index = Collections.binarySearch(fruits, "cherry");
        System.out.println("cherry의 위치: " + index);
        
        // 없는 항목 검색
        index = Collections.binarySearch(fruits, "grape");
        System.out.println("grape의 위치: " + index);
        if (index < 0) {
            int insertPoint = -index - 1;
            System.out.println("grape 삽입 위치: " + insertPoint);
        }
    }
}
```

### 예제 3-2: 리스트 조작 메서드

```java
import java.util.*;

public class ListManipulationExample {
    
    public static void main(String[] args) {
        // 1. 섞기 (Shuffle)
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        
        System.out.println("원본: " + numbers);
        Collections.shuffle(numbers);
        System.out.println("섞기 후: " + numbers);
        
        // 시드를 사용한 섞기 (재현 가능)
        Collections.shuffle(numbers, new Random(42));
        System.out.println("시드 섞기: " + numbers);
        
        // 2. 뒤집기 (Reverse)
        Collections.reverse(numbers);
        System.out.println("뒤집기: " + numbers);
        
        // 3. 회전 (Rotate)
        Collections.rotate(numbers, 3);  // 오른쪽으로 3칸
        System.out.println("회전 +3: " + numbers);
        
        Collections.rotate(numbers, -2);  // 왼쪽으로 2칸
        System.out.println("회전 -2: " + numbers);
        
        // 4. 채우기 (Fill)
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Collections.fill(list, "X");
        System.out.println("\n채우기: " + list);
        
        // 5. 교체 (Replace)
        list = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "A", "D"));
        Collections.replaceAll(list, "A", "Z");
        System.out.println("교체: " + list);
        
        // 6. 최대/최소값
        List<Integer> scores = Arrays.asList(85, 92, 78, 95, 88, 91);
        System.out.println("\n점수: " + scores);
        System.out.println("최고점: " + Collections.max(scores));
        System.out.println("최저점: " + Collections.min(scores));
        
        // 7. 빈도수
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", 
                                          "apple", "banana", "date");
        System.out.println("\n단어 목록: " + words);
        System.out.println("apple 개수: " + Collections.frequency(words, "apple"));
        
        // 8. 부분 리스트 위치 찾기
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 5, 6);
        List<Integer> target = Arrays.asList(3, 4, 5);
        
        int firstIndex = Collections.indexOfSubList(source, target);
        int lastIndex = Collections.lastIndexOfSubList(source, target);
        
        System.out.println("\n원본: " + source);
        System.out.println("찾을 패턴: " + target);
        System.out.println("첫 번째 위치: " + firstIndex);
        System.out.println("마지막 위치: " + lastIndex);
    }
}
```

## 4. Set 인터페이스 활용

### 예제 4-1: HashSet 기본 사용

```java
import java.util.*;

public class HashSetExample {
    
    public static void main(String[] args) {
        // 1. 중복 제거
        List<String> listWithDuplicates = Arrays.asList(
            "apple", "banana", "apple", "cherry", "banana", "date"
        );
        
        Set<String> uniqueItems = new HashSet<>(listWithDuplicates);
        System.out.println("원본 리스트: " + listWithDuplicates);
        System.out.println("중복 제거: " + uniqueItems);
        
        // 2. 집합 연산
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // 합집합
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("\nA ∪ B = " + union);
        
        // 교집합
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("A ∩ B = " + intersection);
        
        // 차집합
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("A - B = " + difference);
        
        // 대칭 차집합 (A ∪ B) - (A ∩ B)
        Set<Integer> symmetricDiff = new HashSet<>(setA);
        symmetricDiff.addAll(setB);
        Set<Integer> temp = new HashSet<>(setA);
        temp.retainAll(setB);
        symmetricDiff.removeAll(temp);
        System.out.println("A △ B = " + symmetricDiff);
        
        // 3. 포함 관계 확인
        Set<String> fruits = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        Set<String> subset = new HashSet<>(Arrays.asList("apple", "cherry"));
        
        System.out.println("\nfruits: " + fruits);
        System.out.println("subset: " + subset);
        System.out.println("subset ⊆ fruits? " + fruits.containsAll(subset));
        System.out.println("fruits ⊆ subset? " + subset.containsAll(fruits));
    }
}
```

### 예제 4-2: TreeSet - 정렬된 집합

```java
import java.util.*;

public class TreeSetExample {
    
    public static void main(String[] args) {
        // 1. 자동 정렬
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.addAll(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));
        
        System.out.println("TreeSet (자동 정렬): " + numbers);
        
        // 2. NavigableSet 메서드
        System.out.println("\n=== NavigableSet 메서드 ===");
        System.out.println("첫 번째: " + numbers.first());
        System.out.println("마지막: " + numbers.last());
        System.out.println("5보다 작은 가장 큰 수: " + numbers.lower(5));
        System.out.println("5 이하 가장 큰 수: " + numbers.floor(5));
        System.out.println("5보다 큰 가장 작은 수: " + numbers.higher(5));
        System.out.println("5 이상 가장 작은 수: " + numbers.ceiling(5));
        
        // 3. 부분 집합
        System.out.println("\n=== 부분 집합 ===");
        SortedSet<Integer> subset = numbers.subSet(3, 7);  // 3 이상, 7 미만
        System.out.println("subSet(3, 7): " + subset);
        
        SortedSet<Integer> headSet = numbers.headSet(5);  // 5 미만
        System.out.println("headSet(5): " + headSet);
        
        SortedSet<Integer> tailSet = numbers.tailSet(5);  // 5 이상
        System.out.println("tailSet(5): " + tailSet);
        
        // 4. 역순 뷰
        NavigableSet<Integer> descending = numbers.descendingSet();
        System.out.println("역순: " + descending);
        
        // 5. 커스텀 정렬
        TreeSet<String> words = new TreeSet<>(Comparator.reverseOrder());
        words.addAll(Arrays.asList("apple", "banana", "cherry", "date"));
        System.out.println("\n역순 정렬된 단어: " + words);
        
        // 6. 커스텀 객체
        TreeSet<Person> people = new TreeSet<>((p1, p2) -> {
            int ageCompare = Integer.compare(p1.age, p2.age);
            if (ageCompare != 0) return ageCompare;
            return p1.name.compareTo(p2.name);
        });
        
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 25));
        people.add(new Person("David", 20));
        
        System.out.println("\n나이순 정렬:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
    
    static class Person {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}
```

### 예제 4-3: LinkedHashSet - 순서 보장

```java
import java.util.*;

public class LinkedHashSetExample {
    
    public static void main(String[] args) {
        // HashSet vs LinkedHashSet vs TreeSet
        String[] data = {"banana", "apple", "cherry", "date", "elderberry"};
        
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        
        for (String item : data) {
            hashSet.add(item);
            linkedHashSet.add(item);
            treeSet.add(item);
        }
        
        System.out.println("HashSet (순서 없음): " + hashSet);
        System.out.println("LinkedHashSet (삽입 순서): " + linkedHashSet);
        System.out.println("TreeSet (정렬됨): " + treeSet);
        
        // LRU 캐시 구현
        System.out.println("\n=== LRU 캐시 예제 ===");
        
        class LRUCache<K, V> extends LinkedHashMap<K, V> {
            private final int maxSize;
            
            public LRUCache(int maxSize) {
                super(16, 0.75f, true);  // true = access-order
                this.maxSize = maxSize;
            }
            
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        }
        
        LRUCache<String, String> cache = new LRUCache<>(3);
        
        cache.put("A", "Data A");
        cache.put("B", "Data B");
        cache.put("C", "Data C");
        System.out.println("캐시: " + cache);
        
        cache.get("A");  // A 접근
        cache.put("D", "Data D");  // B가 제거됨
        System.out.println("D 추가 후: " + cache);
        
        cache.get("C");  // C 접근
        cache.put("E", "Data E");  // D가 제거됨
        System.out.println("E 추가 후: " + cache);
    }
}
```

## 5. PriorityQueue 활용

### 예제 5-1: 기본 우선순위 큐

```java
import java.util.*;

public class PriorityQueueBasic {
    
    public static void main(String[] args) {
        // 1. 기본 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] values = {5, 2, 8, 1, 9, 3, 7};
        
        for (int val : values) {
            minHeap.offer(val);
        }
        
        System.out.println("최소 힙 (작은 값 우선):");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
        
        // 2. 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : values) {
            maxHeap.offer(val);
        }
        
        System.out.println("\n최대 힙 (큰 값 우선):");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // 3. 문자열 우선순위
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.addAll(Arrays.asList("Charlie", "Alice", "Bob", "David"));
        
        System.out.println("\n문자열 (사전순):");
        while (!stringQueue.isEmpty()) {
            System.out.print(stringQueue.poll() + " ");
        }
        System.out.println();
    }
}
```

### 예제 5-2: 작업 스케줄러

```java
import java.util.*;
import java.time.LocalTime;

public class TaskScheduler {
    
    static class Task {
        String name;
        int priority;  // 낮을수록 우선순위 높음
        LocalTime deadline;
        
        Task(String name, int priority, LocalTime deadline) {
            this.name = name;
            this.priority = priority;
            this.deadline = deadline;
        }
        
        @Override
        public String toString() {
            return String.format("%s (우선순위: %d, 마감: %s)", 
                name, priority, deadline);
        }
    }
    
    public static void main(String[] args) {
        // 우선순위 기반 스케줄러
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> {
            // 우선순위가 같으면 마감시간 순
            if (t1.priority != t2.priority) {
                return Integer.compare(t1.priority, t2.priority);
            }
            return t1.deadline.compareTo(t2.deadline);
        });
        
        // 작업 추가
        taskQueue.offer(new Task("버그 수정", 1, LocalTime.of(14, 0)));
        taskQueue.offer(new Task("기능 구현", 3, LocalTime.of(17, 0)));
        taskQueue.offer(new Task("문서 작성", 2, LocalTime.of(16, 0)));
        taskQueue.offer(new Task("코드 리뷰", 2, LocalTime.of(15, 0)));
        taskQueue.offer(new Task("회의 준비", 1, LocalTime.of(13, 0)));
        
        System.out.println("=== 작업 처리 순서 ===");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("처리: " + task);
        }
        
        // 이벤트 처리 시뮬레이션
        System.out.println("\n=== 이벤트 처리 시뮬레이션 ===");
        
        class Event implements Comparable<Event> {
            int time;
            String description;
            
            Event(int time, String description) {
                this.time = time;
                this.description = description;
            }
            
            @Override
            public int compareTo(Event other) {
                return Integer.compare(this.time, other.time);
            }
            
            @Override
            public String toString() {
                return String.format("시간 %d: %s", time, description);
            }
        }
        
        PriorityQueue<Event> eventQueue = new PriorityQueue<>();
        eventQueue.offer(new Event(5, "사용자 로그인"));
        eventQueue.offer(new Event(2, "서버 시작"));
        eventQueue.offer(new Event(8, "데이터 백업"));
        eventQueue.offer(new Event(3, "캐시 초기화"));
        eventQueue.offer(new Event(7, "로그 파일 생성"));
        
        int currentTime = 0;
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            currentTime = event.time;
            System.out.println(event);
        }
    }
}
```

### 예제 5-3: Top-K 문제

```java
import java.util.*;

public class TopKElements {
    
    // K개의 가장 큰 요소 찾기
    public static List<Integer> findTopK(int[] nums, int k) {
        // 최소 힙 사용 (크기 K 유지)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // 가장 작은 것 제거
            }
        }
        
        // 결과를 리스트로 변환 (내림차순)
        List<Integer> result = new ArrayList<>(minHeap);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
    
    // K번째로 큰 요소 찾기
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    // 빈도수 기준 Top-K
    public static List<String> topKFrequent(String[] words, int k) {
        // 단어 빈도수 계산
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        // 최소 힙 (빈도수 기준, 같으면 사전순)
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            if (freq1 != freq2) {
                return freq1 - freq2;  // 빈도수 오름차순
            }
            return w2.compareTo(w1);  // 사전역순
        });
        
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        // 결과 정렬
        List<String> result = new ArrayList<>(heap);
        Collections.sort(result, (w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            if (freq1 != freq2) {
                return freq2 - freq1;  // 빈도수 내림차순
            }
            return w1.compareTo(w2);  // 사전순
        });
        
        return result;
    }
    
    public static void main(String[] args) {
        // Top-K 테스트
        int[] nums = {3, 2, 1, 5, 6, 4, 8, 7, 9};
        System.out.println("배열: " + Arrays.toString(nums));
        System.out.println("Top 3: " + findTopK(nums, 3));
        System.out.println("3번째로 큰 수: " + findKthLargest(nums, 3));
        
        // 빈도수 Top-K
        String[] words = {"apple", "banana", "apple", "cherry", "banana", 
                         "apple", "date", "banana", "cherry", "elderberry"};
        System.out.println("\n단어 배열: " + Arrays.toString(words));
        System.out.println("가장 빈번한 3개: " + topKFrequent(words, 3));
    }
}
```

## 6. 종합 예제: 도서 관리 시스템

```java
import java.util.*;

public class BookManagementSystem {
    
    static class Book {
        String isbn;
        String title;
        String author;
        String genre;
        int year;
        double rating;
        
        Book(String isbn, String title, String author, String genre, int year, double rating) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.year = year;
            this.rating = rating;
        }
        
        @Override
        public String toString() {
            return String.format("%s by %s (%.1f★)", title, author, rating);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Book book = (Book) obj;
            return isbn.equals(book.isbn);
        }
        
        @Override
        public int hashCode() {
            return isbn.hashCode();
        }
    }
    
    private Map<String, Book> bookDatabase;
    private Map<String, Set<Book>> booksByGenre;
    private Map<String, Set<Book>> booksByAuthor;
    private TreeSet<Book> booksByRating;
    private LinkedList<Book> recentlyAdded;
    private static final int RECENT_LIMIT = 10;
    
    public BookManagementSystem() {
        this.bookDatabase = new HashMap<>();
        this.booksByGenre = new HashMap<>();
        this.booksByAuthor = new HashMap<>();
        this.booksByRating = new TreeSet<>((b1, b2) -> {
            int ratingCompare = Double.compare(b2.rating, b1.rating);
            if (ratingCompare != 0) return ratingCompare;
            return b1.title.compareTo(b2.title);
        });
        this.recentlyAdded = new LinkedList<>();
    }
    
    // 도서 추가
    public void addBook(Book book) {
        bookDatabase.put(book.isbn, book);
        
        // 장르별 분류
        booksByGenre.computeIfAbsent(book.genre, k -> new HashSet<>()).add(book);
        
        // 저자별 분류
        booksByAuthor.computeIfAbsent(book.author, k -> new HashSet<>()).add(book);
        
        // 평점별 정렬
        booksByRating.add(book);
        
        // 최근 추가 목록
        recentlyAdded.addFirst(book);
        if (recentlyAdded.size() > RECENT_LIMIT) {
            recentlyAdded.removeLast();
        }
    }
    
    // 장르별 도서 검색
    public List<Book> getBooksByGenre(String genre) {
        Set<Book> books = booksByGenre.getOrDefault(genre, Collections.emptySet());
        return new ArrayList<>(books);
    }
    
    // 저자별 도서 검색
    public List<Book> getBooksByAuthor(String author) {
        Set<Book> books = booksByAuthor.getOrDefault(author, Collections.emptySet());
        return new ArrayList<>(books);
    }
    
    // 평점 상위 N개
    public List<Book> getTopRatedBooks(int n) {
        List<Book> result = new ArrayList<>();
        Iterator<Book> iter = booksByRating.iterator();
        for (int i = 0; i < n && iter.hasNext(); i++) {
            result.add(iter.next());
        }
        return result;
    }
    
    // 최근 추가된 도서
    public List<Book> getRecentlyAddedBooks() {
        return new ArrayList<>(recentlyAdded);
    }
    
    // 통계
    public void printStatistics() {
        System.out.println("=== 도서관 통계 ===");
        System.out.println("총 도서 수: " + bookDatabase.size());
        System.out.println("장르 수: " + booksByGenre.size());
        System.out.println("저자 수: " + booksByAuthor.size());
        
        // 장르별 도서 수
        System.out.println("\n장르별 도서 수:");
        booksByGenre.forEach((genre, books) -> 
            System.out.println("  " + genre + ": " + books.size() + "권")
        );
        
        // 가장 많은 책을 쓴 저자
        String topAuthor = null;
        int maxBooks = 0;
        for (Map.Entry<String, Set<Book>> entry : booksByAuthor.entrySet()) {
            if (entry.getValue().size() > maxBooks) {
                maxBooks = entry.getValue().size();
                topAuthor = entry.getKey();
            }
        }
        System.out.println("\n가장 많은 책을 쓴 저자: " + topAuthor + " (" + maxBooks + "권)");
    }
    
    public static void main(String[] args) {
        BookManagementSystem system = new BookManagementSystem();
        
        // 도서 추가
        system.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch", 
                               "Programming", 2018, 4.8));
        system.addBook(new Book("978-0135166307", "Clean Code", "Robert Martin", 
                               "Programming", 2008, 4.5));
        system.addBook(new Book("978-0201616224", "The Pragmatic Programmer", 
                               "Andrew Hunt", "Programming", 1999, 4.6));
        system.addBook(new Book("978-0596009205", "Head First Java", "Kathy Sierra", 
                               "Programming", 2005, 4.3));
        system.addBook(new Book("978-1617292545", "Spring in Action", "Craig Walls", 
                               "Programming", 2018, 4.4));
        system.addBook(new Book("978-0134494166", "Clean Architecture", "Robert Martin", 
                               "Programming", 2017, 4.7));
        
        // 통계 출력
        system.printStatistics();
        
        // 평점 상위 3개
        System.out.println("\n=== 평점 상위 3개 도서 ===");
        List<Book> topRated = system.getTopRatedBooks(3);
        for (int i = 0; i < topRated.size(); i++) {
            System.out.println((i + 1) + ". " + topRated.get(i));
        }
        
        // Robert Martin의 책들
        System.out.println("\n=== Robert Martin의 도서 ===");
        List<Book> martinBooks = system.getBooksByAuthor("Robert Martin");
        martinBooks.forEach(System.out::println);
        
        // 최근 추가된 도서
        System.out.println("\n=== 최근 추가된 도서 ===");
        List<Book> recent = system.getRecentlyAddedBooks();
        recent.forEach(System.out::println);
    }
}
```

이러한 예제들은 Java의 List와 Set 인터페이스, 그리고 관련 클래스들의 다양한 활용 방법을 보여줍니다.