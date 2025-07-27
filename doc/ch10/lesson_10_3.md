# 10.3 맵(Maps) - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 맵의 개념과 키-값 쌍 구조를 이해한다
- HashMap과 TreeMap의 차이점을 안다
- 맵의 뷰(view) 개념을 이해하고 활용한다
- 해시 테이블의 동작 원리를 이해한다

## 1. 맵이란 무엇인가?

### 1.1 맵의 개념

맵은 **일반화된 배열**입니다:
- 배열: 인덱스(0, 1, 2...)로 값에 접근
- 맵: 키(key)로 값(value)에 접근

```java
// 배열
String[] arr = new String[10];
arr[0] = "첫 번째";  // 인덱스 0에 저장

// 맵
Map<String, Integer> map = new HashMap<>();
map.put("사과", 1000);  // "사과"라는 키에 1000 저장
```

### 1.2 키-값 쌍

맵의 핵심 특징:
- 각 키는 **하나의 값**만 가질 수 있음
- 같은 값이 여러 키와 연결될 수 있음
- 키는 중복될 수 없음

```java
Map<String, String> phoneBook = new HashMap<>();
phoneBook.put("김철수", "010-1234-5678");
phoneBook.put("이영희", "010-2345-6789");
phoneBook.put("박민수", "010-1234-5678");  // 같은 번호 가능
phoneBook.put("김철수", "010-9999-9999");  // 기존 값 덮어씀
```

## 2. Map 인터페이스

### 2.1 제네릭 타입 매개변수

```java
Map<K, V>
```
- K: 키의 타입
- V: 값의 타입

예시:
```java
Map<String, Integer> ages;      // 이름 → 나이
Map<Date, String> schedule;     // 날짜 → 일정
Map<Integer, List<String>> groups;  // 그룹번호 → 멤버목록
```

### 2.2 주요 메서드

| 메서드 | 설명 | 예시 |
|--------|------|------|
| `put(key, value)` | 키-값 쌍 추가/수정 | `map.put("key", "value")` |
| `get(key)` | 키로 값 조회 | `String val = map.get("key")` |
| `remove(key)` | 키-값 쌍 제거 | `map.remove("key")` |
| `containsKey(key)` | 키 존재 확인 | `if (map.containsKey("key"))` |
| `containsValue(value)` | 값 존재 확인 | `if (map.containsValue("val"))` |
| `size()` | 맵 크기 | `int count = map.size()` |
| `isEmpty()` | 비어있는지 확인 | `if (map.isEmpty())` |
| `clear()` | 모든 항목 제거 | `map.clear()` |

### 2.3 사용 예시

```java
// 학생 점수 관리
Map<String, Integer> scores = new HashMap<>();

// 점수 입력
scores.put("김철수", 95);
scores.put("이영희", 88);
scores.put("박민수", 92);

// 점수 조회
Integer kimScore = scores.get("김철수");  // 95
Integer leeScore = scores.get("이영희");  // 88

// 존재하지 않는 키
Integer unknown = scores.get("홍길동");  // null

// 점수 수정
scores.put("이영희", 90);  // 88 → 90

// 학생 확인
if (scores.containsKey("박민수")) {
    System.out.println("박민수의 점수: " + scores.get("박민수"));
}
```

## 3. HashMap vs TreeMap

### 3.1 HashMap

**특징**:
- 해시 테이블 기반
- 순서 보장 없음
- O(1) 성능 (평균)
- null 키 허용 (하나만)

**언제 사용?**
- 빠른 조회가 중요할 때
- 순서가 필요 없을 때
- 대부분의 일반적인 경우

### 3.2 TreeMap

**특징**:
- Red-Black Tree 기반
- 키로 정렬됨
- O(log n) 성능
- null 키 불가

**언제 사용?**
- 정렬된 순서가 필요할 때
- 범위 검색이 필요할 때
- 최소/최대 키를 자주 조회할 때

### 3.3 비교 예시

```java
// HashMap - 순서 없음
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("banana", 2);
hashMap.put("apple", 1);
hashMap.put("cherry", 3);
// 출력 순서: 예측 불가

// TreeMap - 키로 정렬
Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("banana", 2);
treeMap.put("apple", 1);
treeMap.put("cherry", 3);
// 출력 순서: apple, banana, cherry
```

## 4. 맵의 뷰(Views)

### 4.1 keySet() - 키 집합

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

Set<String> keys = map.keySet();
// keys = {"A", "B", "C"}

// 키 순회
for (String key : keys) {
    System.out.println(key + " -> " + map.get(key));
}
```

### 4.2 values() - 값 컬렉션

```java
Collection<Integer> values = map.values();
// values = [1, 2, 3]

// 값의 합계
int sum = 0;
for (Integer value : values) {
    sum += value;
}
```

### 4.3 entrySet() - 엔트리 집합

```java
Set<Map.Entry<String, Integer>> entries = map.entrySet();

// 더 효율적인 순회
for (Map.Entry<String, Integer> entry : entries) {
    String key = entry.getKey();
    Integer value = entry.getValue();
    System.out.println(key + " = " + value);
}
```

### 4.4 뷰의 특징

**중요**: 뷰는 원본 맵과 연결되어 있습니다!

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);

Set<String> keys = map.keySet();
keys.remove("A");  // 맵에서도 "A" 제거됨!

System.out.println(map);  // {"B"=2}
```

## 5. 서브맵(SubMap)

TreeMap에서만 사용 가능한 기능:

```java
TreeMap<String, Integer> scores = new TreeMap<>();
scores.put("김철수", 85);
scores.put("박민수", 92);
scores.put("이영희", 88);
scores.put("정지원", 95);
scores.put("홍길동", 78);

// "김"으로 시작하는 학생들
SortedMap<String, Integer> kimStudents = 
    scores.subMap("김", "나");
// {"김철수"=85}

// 90점 이상 학생들 (점수가 키라면)
TreeMap<Integer, String> byScore = new TreeMap<>();
// ... (점수를 키로 변환)
SortedMap<Integer, String> highScorers = 
    byScore.tailMap(90);
```

## 6. 해시 테이블의 원리

### 6.1 기본 개념

해시 테이블은 키를 배열 인덱스로 변환:
1. 키의 해시코드 계산
2. 해시코드를 배열 크기로 나눔
3. 나머지를 인덱스로 사용

```
키 "apple" → hashCode() → 12345 → 12345 % 10 → 5
→ 배열의 5번 위치에 저장
```

### 6.2 충돌 처리

여러 키가 같은 인덱스를 가질 때:

```
"apple" → 인덱스 5
"grape" → 인덱스 5 (충돌!)

해결: 각 위치에 연결 리스트 사용
배열[5] → ["apple", value1] → ["grape", value2]
```

### 6.3 equals()와 hashCode()

**중요 규칙**:
- equals()가 true면 hashCode()도 같아야 함
- hashCode()가 같아도 equals()는 다를 수 있음

```java
public class Student {
    private String id;
    private String name;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return id.equals(other.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
```

## 7. 실전 활용 예시

### 7.1 단어 빈도 계산

```java
String text = "the quick brown fox jumps over the lazy dog";
Map<String, Integer> wordCount = new HashMap<>();

for (String word : text.split(" ")) {
    wordCount.put(word, 
        wordCount.getOrDefault(word, 0) + 1);
}

// 결과: {"the"=2, "quick"=1, "brown"=1, ...}
```

### 7.2 그룹화

```java
List<Student> students = getStudents();
Map<String, List<Student>> byMajor = new HashMap<>();

for (Student s : students) {
    String major = s.getMajor();
    byMajor.computeIfAbsent(major, 
        k -> new ArrayList<>()).add(s);
}
```

### 7.3 캐시 구현

```java
Map<String, ExpensiveObject> cache = new HashMap<>();

public ExpensiveObject getObject(String key) {
    if (!cache.containsKey(key)) {
        cache.put(key, createExpensiveObject(key));
    }
    return cache.get(key);
}
```

## 8. 성능 고려사항

### 8.1 시간 복잡도

| 연산 | HashMap | TreeMap |
|------|---------|----------|
| put | O(1)* | O(log n) |
| get | O(1)* | O(log n) |
| remove | O(1)* | O(log n) |
| containsKey | O(1)* | O(log n) |

*평균적인 경우, 최악의 경우 O(n)

### 8.2 메모리 사용

- HashMap: 해시 테이블 + 연결 리스트
- TreeMap: 트리 노드 (더 많은 메모리)

### 8.3 선택 가이드

**HashMap 선택**:
- 일반적인 키-값 저장
- 빠른 조회가 중요
- 순서 불필요

**TreeMap 선택**:
- 정렬된 출력 필요
- 범위 검색 필요
- NavigableMap 기능 필요

## 마무리

맵은 Java에서 가장 유용한 자료구조 중 하나입니다:

1. **유연한 인덱싱**: 어떤 객체든 키로 사용 가능
2. **빠른 조회**: HashMap은 O(1) 성능
3. **다양한 활용**: 캐시, 인덱스, 그룹화 등
4. **두 가지 구현**: 상황에 맞게 선택

맵을 마스터하면 많은 프로그래밍 문제를 우아하게 해결할 수 있습니다!