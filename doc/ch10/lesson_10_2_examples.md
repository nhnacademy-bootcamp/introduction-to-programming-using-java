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
        // TODO: ArrayList에 0부터 size-1까지 추가
        
        long arrayAddEnd = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        // TODO: LinkedList에 0부터 size-1까지 추가
        
        long linkedAddEnd = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayAddEnd / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedAddEnd / 1_000_000.0);
        
        // 2. 처음에 추가
        System.out.println("\n2. 처음에 추가 (1000개):");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        
        startTime = System.nanoTime();
        // TODO: ArrayList의 맨 앞(인덱스 0)에 1000개 요소 추가
        
        long arrayAddFirst = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        // TODO: LinkedList의 맨 앞에 1000개 요소 추가 (addFirst 사용)
        
        long linkedAddFirst = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayAddFirst / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedAddFirst / 1_000_000.0);
        
        // 3. 임의 접근
        System.out.println("\n3. 임의 접근 (10000번):");
        Random rand = new Random();
        
        startTime = System.nanoTime();
        // TODO: ArrayList에서 무작위 인덱스로 10000번 접근
        
        long arrayGet = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        // TODO: LinkedList에서 무작위 인덱스로 10000번 접근
        
        long linkedGet = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayGet / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedGet / 1_000_000.0);
        
        // 4. 중간 삭제
        System.out.println("\n4. 중간 삭제 (100개):");
        ArrayList<Integer> arrayList3 = new ArrayList<>(arrayList);
        LinkedList<Integer> linkedList3 = new LinkedList<>(linkedList);
        
        startTime = System.nanoTime();
        // TODO: ArrayList의 중간 요소 100개 삭제
        
        long arrayRemoveMid = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        ListIterator<Integer> iter = linkedList3.listIterator(linkedList3.size() / 2);
        // TODO: LinkedList에서 Iterator를 사용하여 100개 요소 삭제
        
        long linkedRemoveMid = System.nanoTime() - startTime;
        
        System.out.printf("ArrayList: %.2f ms%n", arrayRemoveMid / 1_000_000.0);
        System.out.printf("LinkedList: %.2f ms%n", linkedRemoveMid / 1_000_000.0);
        
        // 실행 결과:
        // === 성능 비교 (요소 수: 100000) ===
        //
        // 1. 끝에 추가:
        // ArrayList: XX.XX ms
        // LinkedList: XX.XX ms
        //
        // 2. 처음에 추가 (1000개):
        // ArrayList: XX.XX ms (느림)
        // LinkedList: X.XX ms (빠름)
        //
        // 3. 임의 접근 (10000번):
        // ArrayList: X.XX ms (빠름)
        // LinkedList: XXX.XX ms (느림)
        //
        // 4. 중간 삭제 (100개):
        // ArrayList: XX.XX ms
        // LinkedList: X.XX ms
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
            // TODO: items의 모든 요소를 data에 추가
        }
        
        public String getData(int index) {
            // TODO: 지정된 인덱스의 데이터 반환
            return null; // 임시 반환값
        }
        
        public List<String> search(String keyword) {
            List<String> results = new ArrayList<>();
            // TODO: data에서 keyword를 포함하는 모든 항목을 results에 추가
            
            return results;
        }
    }
    
    // 사례 2: 작업 큐 - LinkedList 적합
    static class TaskQueue {
        private LinkedList<String> tasks = new LinkedList<>();
        
        public void addTask(String task) {
            // TODO: 일반 작업을 큐의 끝에 추가
        }
        
        public void addUrgentTask(String task) {
            // TODO: 긴급 작업을 큐의 앞에 추가
        }
        
        public String getNextTask() {
            // TODO: 첫 번째 작업을 제거하고 반환 (pollFirst 사용)
            return null; // 임시 반환값
        }
        
        public boolean hasTask() {
            // TODO: 작업이 남아있는지 확인
            return false; // 임시 반환값
        }
    }
    
    // 사례 3: 브라우저 히스토리 - LinkedList 적합
    static class BrowserHistory {
        private LinkedList<String> history = new LinkedList<>();
        private int currentIndex = -1;
        
        public void visit(String url) {
            // TODO: 현재 위치 이후의 히스토리 삭제
            // 힌트: history.size() > currentIndex + 1인 동안 removeLast()
            
            // TODO: 새 URL을 history에 추가하고 currentIndex 증가
        }
        
        public String back() {
            // TODO: 이전 페이지로 이동
            // 힌트: currentIndex > 0일 때만 가능
            
            return null; // 임시 반환값
        }
        
        public String forward() {
            // TODO: 다음 페이지로 이동
            // 힌트: currentIndex < history.size() - 1일 때만 가능
            
            return null; // 임시 반환값
        }
        
        public String current() {
            // TODO: 현재 페이지 URL 반환
            return null; // 임시 반환값
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
        
        // TODO: 정렬된 리스트에 적절한 위치에 item 삽입
        // 힌트: 
        // 1. iter.hasNext()로 순회
        // 2. item.compareTo(current) <= 0이면 iter.previous()후 break
        // 3. iter.add(item)으로 삽입
    }
    
    // 병합 정렬 (두 정렬된 리스트 병합)
    public static <T extends Comparable<T>> List<T> mergeSortedLists(
            List<T> list1, List<T> list2) {
        
        List<T> result = new LinkedList<>();
        ListIterator<T> iter1 = list1.listIterator();
        ListIterator<T> iter2 = list2.listIterator();
        
        T item1 = iter1.hasNext() ? iter1.next() : null;
        T item2 = iter2.hasNext() ? iter2.next() : null;
        
        // TODO: 두 정렬된 리스트를 하나의 정렬된 리스트로 병합
        // 힌트:
        // 1. item1과 item2가 모두 null이 될 때까지 반복
        // 2. null 체크하여 적절히 처리
        // 3. compareTo로 비교하여 작은 값을 result에 추가
        // 4. 다음 요소로 이동 (hasNext() 확인)
        
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
        
        // TODO: listWithDuplicates에서 중복을 제거하여 HashSet 생성
        Set<String> uniqueItems = null; // 임시 값
        
        System.out.println("원본 리스트: " + listWithDuplicates);
        System.out.println("중복 제거: " + uniqueItems);
        
        // 2. 집합 연산
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // 합집합
        Set<Integer> union = new HashSet<>(setA);
        // TODO: setB의 모든 요소를 union에 추가 (addAll 사용)
        
        System.out.println("\nA ∪ B = " + union);
        
        // 교집합
        Set<Integer> intersection = new HashSet<>(setA);
        // TODO: setA와 setB의 교집합 구하기 (retainAll 사용)
        
        System.out.println("A ∩ B = " + intersection);
        
        // 차집합
        Set<Integer> difference = new HashSet<>(setA);
        // TODO: setA에서 setB의 요소들을 제거 (removeAll 사용)
        
        System.out.println("A - B = " + difference);
        
        // 대칭 차집합 (A ∪ B) - (A ∩ B)
        Set<Integer> symmetricDiff = new HashSet<>(setA);
        // TODO: 대칭 차집합 구하기
        // 힌트: 
        // 1. symmetricDiff에 setB 추가 (addAll)
        // 2. temp에 setA와 setB의 교집합 저장
        // 3. symmetricDiff에서 temp 제거 (removeAll)
        
        System.out.println("A △ B = " + symmetricDiff);
        
        // 3. 포함 관계 확인
        Set<String> fruits = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        Set<String> subset = new HashSet<>(Arrays.asList("apple", "cherry"));
        
        System.out.println("\nfruits: " + fruits);
        System.out.println("subset: " + subset);
        // TODO: subset이 fruits의 부분집합인지 확인 (containsAll 사용)
        // TODO: fruits가 subset의 부분집합인지 확인
        
        // 실행 결과:
        // 원본 리스트: [apple, banana, apple, cherry, banana, date]
        // 중복 제거: [banana, apple, cherry, date]
        //
        // A ∪ B = [1, 2, 3, 4, 5, 6, 7, 8]
        // A ∩ B = [4, 5]
        // A - B = [1, 2, 3]
        // A △ B = [1, 2, 3, 6, 7, 8]
        //
        // fruits: [banana, apple, cherry]
        // subset: [apple, cherry]
        // subset ⊆ fruits? true
        // fruits ⊆ subset? false
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
        
        // TODO: 배열의 각 요소를 힙에 추가하고 크기 K 유지
        // 힌트:
        // 1. minHeap.offer(num)으로 추가
        // 2. 힙 크기가 k를 초과하면 poll()로 가장 작은 값 제거
        
        // 결과를 리스트로 변환 (내림차순)
        List<Integer> result = new ArrayList<>(minHeap);
        // TODO: result를 내림차순으로 정렬
        
        return result;
    }
    
    // K번째로 큰 요소 찾기
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // TODO: 최소 힙을 사용하여 K번째로 큰 요소 찾기
        // 힌트: findTopK와 유사하지만 peek()로 결과 반환
        
        return 0; // 임시 반환값
    }
    
    // 빈도수 기준 Top-K
    public static List<String> topKFrequent(String[] words, int k) {
        // 단어 빈도수 계산
        Map<String, Integer> count = new HashMap<>();
        // TODO: words 배열의 각 단어의 빈도수를 count Map에 저장
        // 힌트: getOrDefault(word, 0) + 1 사용
        
        // 최소 힙 (빈도수 기준, 같으면 사전순)
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = count.get(w1);
            int freq2 = count.get(w2);
            // TODO: 빈도수 기준 비교, 같으면 사전역순
            // 힌트:
            // 1. 빈도수가 다르면 freq1 - freq2 (오름차순)
            // 2. 같으면 w2.compareTo(w1) (사전역순)
            return 0; // 임시 반환값
        });
        
        // TODO: count의 모든 단어를 heap에 추가하고 크기 k 유지
        
        // 결과 정렬
        List<String> result = new ArrayList<>(heap);
        // TODO: result를 빈도수 내림차순, 같으면 사전순으로 정렬
        
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
        // TODO: bookDatabase에 ISBN을 키로 하여 도서 추가
        
        // TODO: 장르별 분류 - computeIfAbsent 사용
        // 힌트: booksByGenre.computeIfAbsent(book.genre, k -> new HashSet<>()).add(book)
        
        // TODO: 저자별 분류 - computeIfAbsent 사용
        
        // TODO: 평점별 정렬된 집합에 추가
        
        // TODO: 최근 추가 목록 관리
        // 힌트:
        // 1. recentlyAdded 맨 앞에 추가 (addFirst)
        // 2. 크기가 RECENT_LIMIT 초과하면 마지막 제거 (removeLast)
    }
    
    // 장르별 도서 검색
    public List<Book> getBooksByGenre(String genre) {
        // TODO: 해당 장르의 도서 목록 반환
        // 힌트: getOrDefault(genre, Collections.emptySet()) 사용
        return new ArrayList<>(); // 임시 반환값
    }
    
    // 저자별 도서 검색
    public List<Book> getBooksByAuthor(String author) {
        // TODO: 해당 저자의 도서 목록 반환
        return new ArrayList<>(); // 임시 반환값
    }
    
    // 평점 상위 N개
    public List<Book> getTopRatedBooks(int n) {
        List<Book> result = new ArrayList<>();
        // TODO: booksByRating에서 상위 n개의 도서를 result에 추가
        // 힌트: Iterator를 사용하여 n개만 가져오기
        
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