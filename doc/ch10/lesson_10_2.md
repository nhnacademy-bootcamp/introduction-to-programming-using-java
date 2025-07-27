# 10.2 목록과 집합 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- ArrayList와 LinkedList의 차이점을 이해하고 적절히 선택한다
- 컬렉션의 정렬 방법을 안다
- TreeSet과 HashSet의 특징과 사용법을 이해한다
- 우선순위 큐의 개념과 활용법을 익힌다

## 1. List 인터페이스의 두 구현체

### 1.1 ArrayList vs LinkedList

두 클래스 모두 `List<T>` 인터페이스를 구현하지만, 내부 구조가 다릅니다:

**ArrayList**:
- 내부적으로 배열 사용
- 장점: 인덱스로 빠른 접근 O(1)
- 단점: 중간 삽입/삭제 느림 O(n)

**LinkedList**:
- 내부적으로 이중 연결 리스트 사용
- 장점: 시작/중간 삽입/삭제 빠름 O(1)
- 단점: 인덱스 접근 느림 O(n)

### 1.2 성능 비교

| 연산 | ArrayList | LinkedList |
|------|-----------|------------|
| get(index) | O(1) | O(n) |
| add(끝) | O(1)* | O(1) |
| add(중간) | O(n) | O(1) |
| remove(중간) | O(n) | O(1) |
| contains() | O(n) | O(n) |

*평균적으로 O(1), 배열 확장 시 O(n)

### 1.3 선택 기준

**ArrayList를 선택하는 경우**:
- 인덱스로 자주 접근
- 주로 끝에 추가/삭제
- 크기가 예측 가능

**LinkedList를 선택하는 경우**:
- 시작/중간에 자주 삽입/삭제
- 큐나 스택으로 사용
- 크기가 크게 변동

## 2. List 인터페이스의 주요 메서드

### 2.1 기본 메서드

```java
List<String> list = new ArrayList<>();  // 또는 LinkedList<>();

// 추가
list.add("항목");           // 끝에 추가
list.add(0, "첫번째");      // 특정 위치에 삽입

// 접근
String item = list.get(2);   // 인덱스로 접근
int index = list.indexOf("항목");  // 항목의 위치 찾기

// 수정
list.set(1, "새값");        // 특정 위치 값 변경

// 삭제
list.remove(0);             // 인덱스로 삭제
list.remove("항목");        // 객체로 삭제
```

### 2.2 LinkedList 전용 메서드

```java
LinkedList<String> linkedList = new LinkedList<>();

// 처음과 끝 작업
linkedList.addFirst("첫번째");
linkedList.addLast("마지막");
String first = linkedList.getFirst();
String last = linkedList.removeLast();

// 스택처럼 사용
linkedList.push("스택항목");
String popped = linkedList.pop();

// 큐처럼 사용
linkedList.offer("큐항목");
String polled = linkedList.poll();
```

## 3. ListIterator

### 3.1 양방향 순회

ListIterator는 일반 Iterator와 달리 양방향으로 이동 가능합니다:

```java
List<String> list = Arrays.asList("A", "B", "C", "D");
ListIterator<String> iter = list.listIterator();

// 앞으로 이동
while (iter.hasNext()) {
    System.out.println(iter.next());
}

// 뒤로 이동
while (iter.hasPrevious()) {
    System.out.println(iter.previous());
}
```

### 3.2 ListIterator의 위치 개념

ListIterator는 요소 **사이**에 위치합니다:

```
[시작] | A | B | C | D | [끝]
   ^     ^   ^   ^   ^     ^
```

### 3.3 정렬된 리스트에 삽입

```java
// 정렬된 상태를 유지하며 삽입
ListIterator<String> iter = sortedList.listIterator();
String newItem = "새항목";

while (iter.hasNext()) {
    String current = iter.next();
    if (newItem.compareTo(current) <= 0) {
        iter.previous();  // 한 칸 뒤로
        break;
    }
}
iter.add(newItem);  // 현재 위치에 삽입
```

## 4. 컬렉션 정렬

### 4.1 Collections.sort()

```java
List<String> names = new ArrayList<>();
names.add("홍길동");
names.add("김철수");
names.add("이영희");

// 기본 정렬 (Comparable 사용)
Collections.sort(names);

// Comparator를 사용한 정렬
Collections.sort(names, (a, b) -> b.compareTo(a));  // 역순

// Java 8+ 스타일
names.sort(String::compareTo);
names.sort(Comparator.reverseOrder());
```

### 4.2 Collections 유틸리티 메서드

```java
// 섞기
Collections.shuffle(list);

// 뒤집기
Collections.reverse(list);

// 회전
Collections.rotate(list, 2);  // 오른쪽으로 2칸

// 채우기
Collections.fill(list, "기본값");

// 최대/최소
String max = Collections.max(list);
String min = Collections.min(list);
```

## 5. Set 인터페이스

### 5.1 Set의 특징

- **중복 불허**: 같은 요소를 두 번 추가할 수 없음
- **순서**: 구현체에 따라 다름
  - HashSet: 순서 없음
  - TreeSet: 정렬된 순서
  - LinkedHashSet: 삽입 순서

### 5.2 집합 연산

```java
Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

// 합집합
Set<Integer> union = new HashSet<>(set1);
union.addAll(set2);  // {1, 2, 3, 4, 5, 6, 7, 8}

// 교집합
Set<Integer> intersection = new HashSet<>(set1);
intersection.retainAll(set2);  // {4, 5}

// 차집합
Set<Integer> difference = new HashSet<>(set1);
difference.removeAll(set2);  // {1, 2, 3}
```

## 6. TreeSet과 HashSet

### 6.1 TreeSet

**특징**:
- 자동 정렬
- Red-Black Tree 구조
- O(log n) 성능

**사용 예**:
```java
TreeSet<Integer> scores = new TreeSet<>();
scores.add(85);
scores.add(92);
scores.add(78);

// 자동으로 정렬됨: [78, 85, 92]
System.out.println(scores.first());  // 78
System.out.println(scores.last());   // 92

// 범위 검색
SortedSet<Integer> range = scores.subSet(80, 90);  // [85]
```

### 6.2 HashSet

**특징**:
- 해시 테이블 구조
- O(1) 평균 성능
- 순서 없음

**사용 예**:
```java
HashSet<String> uniqueWords = new HashSet<>();
String text = "the quick brown fox jumps over the lazy dog";

for (String word : text.split(" ")) {
    uniqueWords.add(word);  // 중복 자동 제거
}
```

### 6.3 선택 기준

**TreeSet 사용**:
- 정렬이 필요할 때
- 범위 검색이 필요할 때
- 최대/최소값을 자주 조회할 때

**HashSet 사용**:
- 빠른 성능이 중요할 때
- 순서가 중요하지 않을 때
- 단순 중복 제거가 목적일 때

## 7. 우선순위 큐 (PriorityQueue)

### 7.1 개념

우선순위 큐는 요소를 우선순위에 따라 처리하는 자료구조입니다:
- 삽입: 임의 위치
- 제거: 항상 최소값 (또는 최대값)

### 7.2 기본 사용법

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);

// 최소값부터 제거
while (!pq.isEmpty()) {
    System.out.println(pq.remove());  // 1, 3, 5
}
```

### 7.3 커스텀 우선순위

```java
// 최대 힙 (내림차순)
PriorityQueue<Integer> maxHeap = 
    new PriorityQueue<>(Comparator.reverseOrder());

// 커스텀 객체
class Task {
    String name;
    int priority;
    
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

// 우선순위가 낮은 작업부터 처리
PriorityQueue<Task> taskQueue = new PriorityQueue<>(
    Comparator.comparingInt(t -> t.priority)
);
```

### 7.4 활용 예시

**작업 스케줄링**:
```java
PriorityQueue<Task> scheduler = new PriorityQueue<>(
    Comparator.comparingInt(Task::getPriority)
);

scheduler.add(new Task("긴급", 1));
scheduler.add(new Task("보통", 5));
scheduler.add(new Task("낮음", 10));

// 우선순위 순으로 처리
while (!scheduler.isEmpty()) {
    Task task = scheduler.remove();
    processTask(task);
}
```

## 8. 성능 요약

### 8.1 시간 복잡도 비교

| 자료구조 | 추가 | 삭제 | 검색 | 정렬 |
|---------|------|------|------|------|
| ArrayList | O(1)* | O(n) | O(n) | X |
| LinkedList | O(1) | O(1) | O(n) | X |
| HashSet | O(1) | O(1) | O(1) | X |
| TreeSet | O(log n) | O(log n) | O(log n) | O(1) |
| PriorityQueue | O(log n) | O(log n) | O(n) | X |

### 8.2 메모리 사용량

- ArrayList: 연속된 메모리, 여유 공간
- LinkedList: 각 노드마다 추가 포인터
- HashSet: 해시 테이블, 로드 팩터
- TreeSet: 트리 구조, 각 노드 오버헤드

## 마무리

Java의 컬렉션 클래스들은 각각 장단점이 있습니다:

1. **ArrayList**: 일반적인 리스트 작업
2. **LinkedList**: 큐, 스택, 빈번한 삽입/삭제
3. **HashSet**: 빠른 중복 제거
4. **TreeSet**: 정렬된 집합
5. **PriorityQueue**: 우선순위 기반 처리

상황에 맞는 적절한 자료구조를 선택하는 것이 효율적인 프로그램의 핵심입니다!