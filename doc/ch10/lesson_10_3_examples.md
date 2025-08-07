# 10.3 맵(Maps) - 예제 모음

## 1. Map 인터페이스 기본 사용

### 예제 1-1: 기본 맵 연산

```java
import java.util.*;

public class BasicMapOperations {
    
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> inventory = new HashMap<>();
        
        // 1. put - 항목 추가
        System.out.println("=== 재고 추가 ===");
        inventory.put("사과", 50);
        inventory.put("바나나", 30);
        inventory.put("오렌지", 40);
        inventory.put("포도", 25);
        System.out.println("초기 재고: " + inventory);
        
        // 2. get - 값 조회
        System.out.println("\n=== 재고 조회 ===");
        Integer appleCount = inventory.get("사과");
        System.out.println("사과 재고: " + appleCount);
        
        // 존재하지 않는 키
        Integer mangoCount = inventory.get("망고");
        System.out.println("망고 재고: " + mangoCount);  // null
        
        // 3. getOrDefault - 기본값과 함께 조회
        int kiwiCount = inventory.getOrDefault("키위", 0);
        System.out.println("키위 재고: " + kiwiCount);  // 0
        
        // 4. put - 값 수정
        System.out.println("\n=== 재고 수정 ===");
        Integer oldValue = inventory.put("사과", 60);
        System.out.println("이전 사과 재고: " + oldValue);
        System.out.println("현재 사과 재고: " + inventory.get("사과"));
        
        // 5. putIfAbsent - 없을 때만 추가
        inventory.putIfAbsent("사과", 100);  // 이미 있으므로 무시됨
        inventory.putIfAbsent("망고", 20);   // 추가됨
        System.out.println("putIfAbsent 후: " + inventory);
        
        // 6. remove - 제거
        System.out.println("\n=== 항목 제거 ===");
        Integer removed = inventory.remove("포도");
        System.out.println("제거된 포도 재고: " + removed);
        System.out.println("제거 후: " + inventory);
        
        // 7. containsKey, containsValue
        System.out.println("\n=== 존재 확인 ===");
        System.out.println("'바나나' 키 존재? " + inventory.containsKey("바나나"));
        System.out.println("재고 30개 존재? " + inventory.containsValue(30));
        
        // 8. size, isEmpty
        System.out.println("\n=== 크기 정보 ===");
        System.out.println("전체 품목 수: " + inventory.size());
        System.out.println("비어있나? " + inventory.isEmpty());
        
        // 9. clear
        inventory.clear();
        System.out.println("\n모두 제거 후: " + inventory);
        System.out.println("비어있나? " + inventory.isEmpty());
    }
}
```

### 예제 1-2: null 값 처리

```java
import java.util.*;

public class MapNullHandling {
    
    public static void main(String[] args) {
        // HashMap은 null 키와 값을 허용
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "null 키의 값");
        hashMap.put("키1", null);
        hashMap.put("키2", "정상 값");
        
        System.out.println("HashMap:");
        System.out.println("null 키: " + hashMap.get(null));
        System.out.println("키1: " + hashMap.get("키1"));
        System.out.println("전체: " + hashMap);
        
        // TreeMap은 null 키를 허용하지 않음
        Map<String, String> treeMap = new TreeMap<>();
        // treeMap.put(null, "값");  // NullPointerException!
        treeMap.put("키1", null);  // null 값은 가능
        treeMap.put("키2", "정상 값");
        
        System.out.println("\nTreeMap:");
        System.out.println("키1: " + treeMap.get("키1"));
        System.out.println("전체: " + treeMap);
    }
}
```

## 2. HashMap vs TreeMap 비교

### 예제 2-1: 순서 비교

```java
import java.util.*;

public class HashMapVsTreeMap {
    
    public static void main(String[] args) {
        // 같은 데이터를 두 맵에 추가
        String[] fruits = {"banana", "apple", "cherry", "date", "elderberry"};
        int[] prices = {1500, 2000, 3000, 2500, 4000};
        
        // HashMap - 순서 보장 없음
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            hashMap.put(fruits[i], prices[i]);
        }
        
        // TreeMap - 키로 정렬
        Map<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < fruits.length; i++) {
            treeMap.put(fruits[i], prices[i]);
        }
        
        // LinkedHashMap - 삽입 순서 유지
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            linkedHashMap.put(fruits[i], prices[i]);
        }
        
        System.out.println("=== HashMap (순서 없음) ===");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n=== TreeMap (키로 정렬) ===");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n=== LinkedHashMap (삽입 순서) ===");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

### 예제 2-2: TreeMap의 추가 기능

```java
import java.util.*;

public class TreeMapFeatures {
    
    public static void main(String[] args) {
        TreeMap<String, Integer> scores = new TreeMap<>();
        scores.put("김철수", 85);
        scores.put("이영희", 92);
        scores.put("박민수", 78);
        scores.put("정지원", 95);
        scores.put("홍길동", 88);
        
        System.out.println("전체 점수: " + scores);
        
        // NavigableMap 메서드들
        System.out.println("\n=== NavigableMap 기능 ===");
        System.out.println("첫 번째 학생: " + scores.firstEntry());
        System.out.println("마지막 학생: " + scores.lastEntry());
        
        System.out.println("\n'박민수' 바로 앞: " + scores.lowerEntry("박민수"));
        System.out.println("'박민수' 또는 바로 앞: " + scores.floorEntry("박민수"));
        System.out.println("'박민수' 바로 뒤: " + scores.higherEntry("박민수"));
        System.out.println("'박민수' 또는 바로 뒤: " + scores.ceilingEntry("박민수"));
        
        // 역순 맵
        NavigableMap<String, Integer> reverseScores = scores.descendingMap();
        System.out.println("\n역순: " + reverseScores);
        
        // 커스텀 Comparator
        TreeMap<String, Integer> customOrder = new TreeMap<>(
            Comparator.reverseOrder()
        );
        customOrder.putAll(scores);
        System.out.println("\n역순 정렬: " + customOrder);
    }
}
```

## 3. 맵의 뷰(Views) 활용

### 예제 3-1: keySet(), values(), entrySet()

```java
import java.util.*;

public class MapViews {
    
    public static void main(String[] args) {
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("노트북", 1500000.0);
        productPrices.put("마우스", 30000.0);
        productPrices.put("키보드", 80000.0);
        productPrices.put("모니터", 400000.0);
        productPrices.put("스피커", 150000.0);
        
        // 1. keySet() - 키 집합
        System.out.println("=== 키 집합 (keySet) ===");
        Set<String> products = productPrices.keySet();
        System.out.println("제품 목록: " + products);
        
        // 키를 통한 순회
        System.out.println("\n제품별 가격:");
        for (String product : products) {
            System.out.printf("%s: %,.0f원%n", product, productPrices.get(product));
        }
        
        // 2. values() - 값 컬렉션
        System.out.println("\n=== 값 컬렉션 (values) ===");
        Collection<Double> prices = productPrices.values();
        
        // 가격 통계
        double total = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        
        for (Double price : prices) {
            total += price;
            max = Math.max(max, price);
            min = Math.min(min, price);
        }
        
        System.out.printf("총액: %,.0f원%n", total);
        System.out.printf("평균: %,.0f원%n", total / prices.size());
        System.out.printf("최고가: %,.0f원%n", max);
        System.out.printf("최저가: %,.0f원%n", min);
        
        // 3. entrySet() - 엔트리 집합
        System.out.println("\n=== 엔트리 집합 (entrySet) ===");
        Set<Map.Entry<String, Double>> entries = productPrices.entrySet();
        
        // 가격 인상 (10%)
        System.out.println("10% 가격 인상:");
        for (Map.Entry<String, Double> entry : entries) {
            double oldPrice = entry.getValue();
            double newPrice = oldPrice * 1.1;
            entry.setValue(newPrice);
            System.out.printf("%s: %,.0f원 → %,.0f원%n", 
                entry.getKey(), oldPrice, newPrice);
        }
        
        // 뷰의 특성 - 원본 맵과 연결됨
        System.out.println("\n=== 뷰의 특성 ===");
        System.out.println("키 집합에서 제거:");
        products.remove("스피커");
        System.out.println("맵에도 반영됨: " + productPrices);
    }
}
```

### 예제 3-2: 뷰를 활용한 필터링

```java
import java.util.*;

public class MapViewFiltering {
    
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("김철수", 85);
        studentScores.put("이영희", 92);
        studentScores.put("박민수", 78);
        studentScores.put("정지원", 95);
        studentScores.put("홍길동", 88);
        studentScores.put("강민준", 73);
        studentScores.put("최서연", 91);
        
        // 90점 이상 학생 찾기
        System.out.println("=== 90점 이상 학생 ===");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() >= 90) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        
        // 특정 점수 구간 학생 찾기
        System.out.println("\n=== 80-89점 학생 ===");
        List<String> midRangeStudents = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            int score = entry.getValue();
            if (score >= 80 && score < 90) {
                midRangeStudents.add(entry.getKey());
            }
        }
        System.out.println(midRangeStudents);
        
        // 평균 계산
        // TODO 1: values()를 사용하여 모든 점수의 합계 구하기
        // TODO 2: 평균 계산 (합계 / 학생 수)
        
        int sum = 0; // 임시값
        double average = 0.0; // 임시값
        System.out.printf("\n평균 점수: %.1f점%n", average);
        
        // 평균 이상 학생
        System.out.println("\n=== 평균 이상 학생 ===");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() >= average) {
                System.out.printf("%s: %d점 (평균 +%.1f)%n", 
                    entry.getKey(), 
                    entry.getValue(), 
                    entry.getValue() - average);
            }
        }
    }
}
```

## 4. 서브맵(SubMap) 활용

### 예제 4-1: TreeMap의 서브맵

```java
import java.util.*;

public class SubMapExample {
    
    public static void main(String[] args) {
        TreeMap<String, String> dictionary = new TreeMap<>();
        
        // 사전 데이터 추가
        dictionary.put("apple", "사과");
        dictionary.put("banana", "바나나");
        dictionary.put("cherry", "체리");
        dictionary.put("date", "대추");
        dictionary.put("elderberry", "엘더베리");
        dictionary.put("fig", "무화과");
        dictionary.put("grape", "포도");
        dictionary.put("honeydew", "허니듀");
        
        System.out.println("전체 사전: " + dictionary);
        
        // 1. subMap - 범위 지정
        System.out.println("\n=== subMap ===");
        SortedMap<String, String> cToE = dictionary.subMap("c", "f");
        System.out.println("'c'부터 'f'이전: " + cToE);
        
        // 2. headMap - 특정 키 이전
        System.out.println("\n=== headMap ===");
        SortedMap<String, String> beforeD = dictionary.headMap("d");
        System.out.println("'d' 이전: " + beforeD);
        
        // 3. tailMap - 특정 키 이후
        System.out.println("\n=== tailMap ===");
        SortedMap<String, String> fromF = dictionary.tailMap("f");
        System.out.println("'f' 이후: " + fromF);
        
        // 서브맵 수정은 원본에 영향
        System.out.println("\n=== 서브맵 수정 ===");
        cToE.put("dragon", "용");
        System.out.println("서브맵에 추가: " + cToE);
        System.out.println("원본도 변경됨: " + dictionary);
    }
}
```

### 예제 4-2: 날짜 범위 검색

```java
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateRangeSearch {
    
    static class Event {
        String title;
        LocalDateTime dateTime;
        
        Event(String title, LocalDateTime dateTime) {
            this.title = title;
            this.dateTime = dateTime;
        }
        
        @Override
        public String toString() {
            return title + " (" + 
                dateTime.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")) + ")";
        }
    }
    
    public static void main(String[] args) {
        TreeMap<LocalDateTime, Event> calendar = new TreeMap<>();
        
        // 2024년 1월 이벤트 추가
        LocalDateTime base = LocalDateTime.of(2024, 1, 1, 0, 0);
        
        calendar.put(base.plusDays(0).plusHours(9), 
            new Event("새해 인사", base.plusDays(0).plusHours(9)));
        calendar.put(base.plusDays(2).plusHours(14), 
            new Event("프로젝트 회의", base.plusDays(2).plusHours(14)));
        calendar.put(base.plusDays(5).plusHours(10), 
            new Event("팀 미팅", base.plusDays(5).plusHours(10)));
        calendar.put(base.plusDays(7).plusHours(15), 
            new Event("고객 미팅", base.plusDays(7).plusHours(15)));
        calendar.put(base.plusDays(10).plusHours(11), 
            new Event("코드 리뷰", base.plusDays(10).plusHours(11)));
        calendar.put(base.plusDays(15).plusHours(13), 
            new Event("점심 약속", base.plusDays(15).plusHours(13)));
        
        // 전체 일정
        System.out.println("=== 전체 일정 ===");
        for (Map.Entry<LocalDateTime, Event> entry : calendar.entrySet()) {
            System.out.println(entry.getValue());
        }
        
        // 첫 주 일정 (1월 1일 ~ 1월 7일)
        LocalDateTime weekStart = base;
        LocalDateTime weekEnd = base.plusDays(7);
        
        System.out.println("\n=== 첫 주 일정 ===");
        SortedMap<LocalDateTime, Event> firstWeek = 
            calendar.subMap(weekStart, weekEnd);
        for (Event event : firstWeek.values()) {
            System.out.println(event);
        }
        
        // 특정 날짜의 일정
        LocalDateTime dayStart = base.plusDays(7);
        LocalDateTime dayEnd = dayStart.plusDays(1);
        
        System.out.println("\n=== 1월 8일 일정 ===");
        SortedMap<LocalDateTime, Event> dayEvents = 
            calendar.subMap(dayStart, dayEnd);
        if (dayEvents.isEmpty()) {
            System.out.println("일정 없음");
        } else {
            for (Event event : dayEvents.values()) {
                System.out.println(event);
            }
        }
        
        // 다음 일정 찾기
        LocalDateTime now = base.plusDays(3);
        System.out.println("\n=== 1월 4일 이후 일정 ===");
        SortedMap<LocalDateTime, Event> upcoming = calendar.tailMap(now);
        
        if (!upcoming.isEmpty()) {
            Map.Entry<LocalDateTime, Event> next = upcoming.firstEntry();
            System.out.println("다음 일정: " + next.getValue());
        }
    }
}
```

## 5. 고급 맵 활용

### 예제 5-1: compute 메서드들

```java
import java.util.*;

public class MapComputeMethods {
    
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        String text = "the quick brown fox jumps over the lazy dog " +
                     "the fox was very quick";
        
        // 1. compute - 키가 있든 없든 계산
        System.out.println("=== compute ===");
        for (String word : text.split(" ")) {
            wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
        }
        System.out.println("단어 빈도: " + wordCount);
        
        // 2. computeIfAbsent - 키가 없을 때만 계산
        System.out.println("\n=== computeIfAbsent ===");
        Map<String, List<Integer>> indexMap = new HashMap<>();
        String[] words = text.split(" ");
        
        // TODO 10: 각 단어가 나타나는 인덱스를 리스트로 저장
        // 힌트: computeIfAbsent를 사용하여 키가 없으면 새 ArrayList 생성
        //      그 리스트에 현재 인덱스 추가
        
        for (int i = 0; i < words.length; i++) {
            final int index = i;
            // TODO 구현
        }
        System.out.println("단어 위치: " + indexMap);
        
        // 3. computeIfPresent - 키가 있을 때만 계산
        System.out.println("\n=== computeIfPresent ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("김철수", 80);
        scores.put("이영희", 90);
        scores.put("박민수", 85);
        
        // 보너스 점수 추가 (10%)
        scores.computeIfPresent("김철수", (k, v) -> (int)(v * 1.1));
        scores.computeIfPresent("정지원", (k, v) -> (int)(v * 1.1)); // 없으므로 무시
        System.out.println("보너스 후: " + scores);
        
        // 4. merge - 값 병합
        System.out.println("\n=== merge ===");
        Map<String, Integer> inventory1 = new HashMap<>();
        inventory1.put("사과", 30);
        inventory1.put("바나나", 20);
        
        Map<String, Integer> inventory2 = new HashMap<>();
        inventory2.put("사과", 25);
        inventory2.put("오렌지", 15);
        
        // 두 재고 합치기
        for (Map.Entry<String, Integer> entry : inventory2.entrySet()) {
            inventory1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        System.out.println("합친 재고: " + inventory1);
    }
}
```

### 예제 5-2: 맵의 맵 (중첩 맵)

```java
import java.util.*;

public class NestedMapExample {
    
    public static void main(String[] args) {
        // 학생별, 과목별 점수
        Map<String, Map<String, Integer>> gradeBook = new HashMap<>();
        
        // 점수 추가 헬퍼 메서드
        addGrade(gradeBook, "김철수", "수학", 85);
        addGrade(gradeBook, "김철수", "영어", 90);
        addGrade(gradeBook, "김철수", "과학", 88);
        
        addGrade(gradeBook, "이영희", "수학", 92);
        addGrade(gradeBook, "이영희", "영어", 88);
        addGrade(gradeBook, "이영희", "과학", 95);
        
        addGrade(gradeBook, "박민수", "수학", 78);
        addGrade(gradeBook, "박민수", "영어", 85);
        addGrade(gradeBook, "박민수", "과학", 82);
        
        // 전체 성적표 출력
        System.out.println("=== 전체 성적표 ===");
        for (Map.Entry<String, Map<String, Integer>> student : gradeBook.entrySet()) {
            System.out.println(student.getKey() + ":");
            for (Map.Entry<String, Integer> subject : student.getValue().entrySet()) {
                System.out.printf("  %s: %d점%n", subject.getKey(), subject.getValue());
            }
            System.out.printf("  평균: %.1f점%n", calculateAverage(student.getValue()));
            System.out.println();
        }
        
        // 과목별 평균
        System.out.println("=== 과목별 평균 ===");
        Map<String, Double> subjectAverages = calculateSubjectAverages(gradeBook);
        for (Map.Entry<String, Double> entry : subjectAverages.entrySet()) {
            System.out.printf("%s: %.1f점%n", entry.getKey(), entry.getValue());
        }
        
        // 전체 평균이 가장 높은 학생
        System.out.println("\n=== 최우수 학생 ===");
        String topStudent = findTopStudent(gradeBook);
        System.out.println(topStudent);
    }
    
    private static void addGrade(Map<String, Map<String, Integer>> gradeBook, 
                                 String student, String subject, int score) {
        gradeBook.computeIfAbsent(student, k -> new HashMap<>())
                 .put(subject, score);
    }
    
    private static double calculateAverage(Map<String, Integer> scores) {
        return scores.values().stream()
                     .mapToInt(Integer::intValue)
                     .average()
                     .orElse(0.0);
    }
    
    private static Map<String, Double> calculateSubjectAverages(
            Map<String, Map<String, Integer>> gradeBook) {
        Map<String, List<Integer>> subjectScores = new HashMap<>();
        
        // 과목별로 점수 수집
        for (Map<String, Integer> studentScores : gradeBook.values()) {
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                subjectScores.computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                            .add(entry.getValue());
            }
        }
        
        // 평균 계산
        Map<String, Double> averages = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            double avg = entry.getValue().stream()
                              .mapToInt(Integer::intValue)
                              .average()
                              .orElse(0.0);
            averages.put(entry.getKey(), avg);
        }
        
        return averages;
    }
    
    private static String findTopStudent(Map<String, Map<String, Integer>> gradeBook) {
        String topStudent = null;
        double maxAverage = 0;
        
        for (Map.Entry<String, Map<String, Integer>> entry : gradeBook.entrySet()) {
            double avg = calculateAverage(entry.getValue());
            if (avg > maxAverage) {
                maxAverage = avg;
                topStudent = entry.getKey();
            }
        }
        
        return topStudent + " (평균: " + String.format("%.1f", maxAverage) + "점)";
    }
}
```

## 6. 해시 테이블 이해

### 예제 6-1: 커스텀 키 클래스

```java
import java.util.*;

public class CustomKeyExample {
    
    // 잘못된 예 - equals/hashCode 재정의 안 함
    static class BadKey {
        String name;
        int id;
        
        BadKey(String name, int id) {
            this.name = name;
            this.id = id;
        }
        
        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }
    
    // 올바른 예 - equals/hashCode 재정의
    static class GoodKey {
        String name;
        int id;
        
        GoodKey(String name, int id) {
            this.name = name;
            this.id = id;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof GoodKey)) return false;
            GoodKey other = (GoodKey) obj;
            return id == other.id && 
                   Objects.equals(name, other.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
        
        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }
    
    public static void main(String[] args) {
        // BadKey 사용 - 문제 발생
        System.out.println("=== BadKey 사용 ===");
        Map<BadKey, String> badMap = new HashMap<>();
        
        BadKey bad1 = new BadKey("Alice", 1);
        BadKey bad2 = new BadKey("Alice", 1);  // 같은 내용
        
        badMap.put(bad1, "첫 번째");
        System.out.println("bad1으로 조회: " + badMap.get(bad1));
        System.out.println("bad2으로 조회: " + badMap.get(bad2));  // null!
        System.out.println("bad1 == bad2? " + (bad1 == bad2));
        System.out.println("bad1.equals(bad2)? " + bad1.equals(bad2));
        
        // GoodKey 사용 - 정상 작동
        System.out.println("\n=== GoodKey 사용 ===");
        Map<GoodKey, String> goodMap = new HashMap<>();
        
        GoodKey good1 = new GoodKey("Alice", 1);
        GoodKey good2 = new GoodKey("Alice", 1);  // 같은 내용
        
        goodMap.put(good1, "첫 번째");
        System.out.println("good1으로 조회: " + goodMap.get(good1));
        System.out.println("good2으로 조회: " + goodMap.get(good2));  // 정상!
        System.out.println("good1 == good2? " + (good1 == good2));
        System.out.println("good1.equals(good2)? " + good1.equals(good2));
        System.out.println("good1.hashCode() == good2.hashCode()? " + 
                          (good1.hashCode() == good2.hashCode()));
    }
}
```

### 예제 6-2: 해시 충돌 시뮬레이션

```java
import java.util.*;

public class HashCollisionDemo {
    
    // 의도적으로 충돌을 만드는 키 클래스
    static class CollisionKey {
        String value;
        
        CollisionKey(String value) {
            this.value = value;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CollisionKey)) return false;
            return value.equals(((CollisionKey) obj).value);
        }
        
        @Override
        public int hashCode() {
            // 의도적으로 간단한 해시 함수 사용
            return value.length() % 3;  // 0, 1, 2만 반환
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    public static void main(String[] args) {
        Map<CollisionKey, Integer> map = new HashMap<>();
        
        String[] words = {"a", "bb", "ccc", "dddd", "eeeee", "ffffff"};
        
        System.out.println("=== 해시 충돌 데모 ===");
        for (String word : words) {
            CollisionKey key = new CollisionKey(word);
            int hash = key.hashCode();
            map.put(key, word.length());
            System.out.printf("키: %s, 해시코드: %d, 길이: %d%n", 
                word, hash, word.length());
        }
        
        System.out.println("\n=== 맵 내용 ===");
        for (Map.Entry<CollisionKey, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("\n=== 조회 테스트 ===");
        for (String word : words) {
            CollisionKey key = new CollisionKey(word);
            Integer value = map.get(key);
            System.out.printf("get(\"%s\") = %d%n", word, value);
        }
        
        // 해시코드 분포
        System.out.println("\n=== 해시코드 분포 ===");
        Map<Integer, List<String>> distribution = new HashMap<>();
        for (String word : words) {
            CollisionKey key = new CollisionKey(word);
            distribution.computeIfAbsent(key.hashCode(), k -> new ArrayList<>())
                       .add(word);
        }
        
        for (Map.Entry<Integer, List<String>> entry : distribution.entrySet()) {
            System.out.println("해시코드 " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

## 7. 실전 응용 예제

### 예제 7-1: 전화번호부 시스템

```java
import java.util.*;

public class PhoneBookSystem {
    
    private Map<String, String> phoneBook;
    private Map<String, Set<String>> reversePhoneBook;  // 전화번호 -> 이름들
    
    public PhoneBookSystem() {
        this.phoneBook = new TreeMap<>();  // 이름순 정렬
        this.reversePhoneBook = new HashMap<>();
    }
    
    // 전화번호 추가
    public void addContact(String name, String phoneNumber) {
        // TODO 3: 기존 번호가 있으면 역방향 맵에서 제거
        // 힌트: phoneBook에서 기존 번호 조회
        //      있으면 reversePhoneBook에서 해당 이름 제거
        //      Set이 비어있으면 해당 번호 키도 제거
        
        // TODO 4: 새 번호 추가
        // - phoneBook에 이름-번호 매핑 추가
        // - reversePhoneBook에 번호-이름 Set 매핑 추가
        //   (힌트: computeIfAbsent 사용)
    }
    
    // 이름으로 번호 찾기
    public String getNumber(String name) {
        return phoneBook.get(name);
    }
    
    // 번호로 이름 찾기
    public Set<String> getNames(String phoneNumber) {
        return reversePhoneBook.getOrDefault(phoneNumber, Collections.emptySet());
    }
    
    // 이름으로 검색
    public List<Map.Entry<String, String>> searchByName(String prefix) {
        List<Map.Entry<String, String>> results = new ArrayList<>();
        
        // TODO 5: TreeMap의 subMap을 사용하여 prefix로 시작하는 항목 찾기
        // 힌트: phoneBook이 TreeMap 인스턴스인지 확인
        //      prefix로 시작하여 prefix+"힣"으로 끝나는 범위 사용
        //      subMap의 모든 entry를 results에 추가
        
        return results;
    }
    
    // 연락처 삭제
    public boolean removeContact(String name) {
        String phoneNumber = phoneBook.remove(name);
        if (phoneNumber != null) {
            Set<String> names = reversePhoneBook.get(phoneNumber);
            if (names != null) {
                names.remove(name);
                if (names.isEmpty()) {
                    reversePhoneBook.remove(phoneNumber);
                }
            }
            return true;
        }
        return false;
    }
    
    // 전체 목록
    public void printAll() {
        System.out.println("=== 전화번호부 ===");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    // 중복 번호 찾기
    public Map<String, Set<String>> findDuplicateNumbers() {
        Map<String, Set<String>> duplicates = new HashMap<>();
        
        // TODO 6: reversePhoneBook에서 여러 이름이 있는 번호 찾기
        // 힌트: entrySet()을 순회하며 value Set의 크기가 1보다 큰 경우
        //      해당 번호와 이름 Set을 duplicates에 추가
        
        return duplicates;
    }
    
    public static void main(String[] args) {
        PhoneBookSystem phoneBook = new PhoneBookSystem();
        
        // 연락처 추가
        phoneBook.addContact("김철수", "010-1234-5678");
        phoneBook.addContact("이영희", "010-2345-6789");
        phoneBook.addContact("박민수", "010-3456-7890");
        phoneBook.addContact("김영희", "010-1234-5678");  // 같은 번호
        phoneBook.addContact("정지원", "010-4567-8901");
        phoneBook.addContact("김민준", "010-5678-9012");
        
        // 전체 목록
        phoneBook.printAll();
        
        // 검색
        System.out.println("\n=== '김'으로 시작하는 연락처 ===");
        List<Map.Entry<String, String>> kimContacts = phoneBook.searchByName("김");
        for (Map.Entry<String, String> entry : kimContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 역방향 검색
        System.out.println("\n=== 010-1234-5678 사용자 ===");
        Set<String> users = phoneBook.getNames("010-1234-5678");
        System.out.println(users);
        
        // 중복 번호
        System.out.println("\n=== 중복 전화번호 ===");
        Map<String, Set<String>> duplicates = phoneBook.findDuplicateNumbers();
        for (Map.Entry<String, Set<String>> entry : duplicates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

### 예제 7-2: 캐시 시스템

```java
import java.util.*;

public class CacheSystem<K, V> {
    
    private final int maxSize;
    private final Map<K, V> cache;
    private final Map<K, Long> accessTime;
    private final Map<K, Integer> accessCount;
    
    public CacheSystem(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new HashMap<>();
        this.accessTime = new HashMap<>();
        this.accessCount = new HashMap<>();
    }
    
    // 값 추가/조회
    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            // 접근 정보 업데이트
            accessTime.put(key, System.currentTimeMillis());
            accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
        }
        return value;
    }
    
    // 값 추가
    public void put(K key, V value) {
        // 캐시가 가득 차면 제거 정책 실행
        if (cache.size() >= maxSize && !cache.containsKey(key)) {
            evict();
        }
        
        cache.put(key, value);
        accessTime.put(key, System.currentTimeMillis());
        accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
    }
    
    // LRU (Least Recently Used) 제거
    private void evict() {
        K lruKey = null;
        long oldestTime = Long.MAX_VALUE;
        
        for (Map.Entry<K, Long> entry : accessTime.entrySet()) {
            if (entry.getValue() < oldestTime) {
                oldestTime = entry.getValue();
                lruKey = entry.getKey();
            }
        }
        
        if (lruKey != null) {
            cache.remove(lruKey);
            accessTime.remove(lruKey);
            accessCount.remove(lruKey);
            System.out.println("제거됨 (LRU): " + lruKey);
        }
    }
    
    // 캐시 통계
    public void printStatistics() {
        System.out.println("=== 캐시 통계 ===");
        System.out.println("크기: " + cache.size() + "/" + maxSize);
        
        // 가장 많이 접근된 항목
        if (!accessCount.isEmpty()) {
            Map.Entry<K, Integer> mostAccessed = Collections.max(
                accessCount.entrySet(), 
                Map.Entry.comparingByValue()
            );
            System.out.println("가장 많이 접근: " + mostAccessed.getKey() + 
                             " (" + mostAccessed.getValue() + "회)");
        }
        
        // 캐시 내용
        System.out.println("\n현재 캐시:");
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.printf("  %s -> %s (접근: %d회)%n", 
                entry.getKey(), 
                entry.getValue(),
                accessCount.get(entry.getKey()));
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        CacheSystem<String, String> cache = new CacheSystem<>(3);
        
        // 데이터 추가
        cache.put("user1", "Alice");
        Thread.sleep(100);
        cache.put("user2", "Bob");
        Thread.sleep(100);
        cache.put("user3", "Charlie");
        
        // 접근
        cache.get("user1");
        cache.get("user1");
        cache.get("user2");
        
        cache.printStatistics();
        
        // 캐시 초과
        System.out.println("\n새 사용자 추가:");
        cache.put("user4", "David");  // user3가 제거될 것
        
        cache.printStatistics();
    }
}
```

이러한 예제들은 Java Map의 다양한 기능과 활용 방법을 보여줍니다.