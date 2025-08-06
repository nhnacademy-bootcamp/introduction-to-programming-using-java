# 10.4 Java 컬렉션 프레임워크로 프로그래밍하기 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 심볼 테이블의 개념을 이해하고 Map으로 구현한다
- 맵 내부에 집합을 저장하는 복잡한 자료구조를 설계한다
- Comparator를 활용하여 정렬 기준을 커스터마이즈한다
- 실제 문제 해결에 컬렉션 프레임워크를 적용한다

## 1. 심볼 테이블 (Symbol Table)

### 1.1 심볼 테이블이란?

**심볼 테이블**은 컴파일러와 인터프리터에서 사용하는 핵심 자료구조입니다:
- **이름(식별자)** 과 **정의(정보)** 를 연결
- 변수명 → 값
- 함수명 → 함수 정보
- 클래스명 → 클래스 정보

### 1.2 Map을 사용한 구현

```java
// 간단한 변수 저장용 심볼 테이블
Map<String, Double> symbolTable = new HashMap<>();

// 변수 정의
symbolTable.put("x", 10.5);
symbolTable.put("y", 20.3);

// 변수 사용
Double xValue = symbolTable.get("x");
if (xValue == null) {
    // 정의되지 않은 변수
    throw new RuntimeException("변수 x가 정의되지 않았습니다");
}
```

### 1.3 실제 예제: 간단한 인터프리터

```java
// let x = 10
// let y = x + 5
// print y

public class SimpleInterpreter {
    private Map<String, Double> symbolTable;

    public SimpleInterpreter() {
        symbolTable = new HashMap<>();
        // 기본 상수 정의
        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);
    }

    // let 명령 처리
    public void executeLet(String varName, double value) {
        symbolTable.put(varName, value);
    }

    // 변수 값 가져오기
    public double getVariable(String varName) {
        Double value = symbolTable.get(varName);
        if (value == null) {
            throw new RuntimeException("정의되지 않은 변수: " + varName);
        }
        return value;
    }
}
```

## 2. 맵 내부의 집합 (Sets in Maps)

### 2.1 복잡한 자료구조의 필요성

책의 인덱스를 생각해보세요:
```
Java: 15, 23, 45, 89
프로그래밍: 12, 34, 56
컬렉션: 45, 67, 89, 101
```

이는 다음과 같이 표현됩니다:
- **용어** → **페이지 번호들의 집합**
- Map<String, Set<Integer>>

### 2.2 구현 예제

```java
// 책 인덱스 구조
TreeMap<String, TreeSet<Integer>> index = new TreeMap<>();

// 페이지 참조 추가
public void addReference(String term, int pageNum) {
    TreeSet<Integer> pages = index.get(term);

    if (pages == null) {
        // 첫 번째 참조
        pages = new TreeSet<>();
        pages.add(pageNum);
        index.put(term, pages);
    } else {
        // 기존 집합에 추가
        pages.add(pageNum);
    }
}

// 더 간결한 버전 (computeIfAbsent 사용)
public void addReference2(String term, int pageNum) {
    index.computeIfAbsent(term, k -> new TreeSet<>())
         .add(pageNum);
}
```

### 2.3 인덱스 출력

```java
public void printIndex() {
    for (Map.Entry<String, TreeSet<Integer>> entry : index.entrySet()) {
        String term = entry.getKey();
        TreeSet<Integer> pages = entry.getValue();

        System.out.print(term + ": ");

        // 쉼표로 구분하여 출력
        boolean first = true;
        for (int page : pages) {
            if (!first) System.out.print(", ");
            System.out.print(page);
            first = false;
        }
        System.out.println();
    }
}
```

## 3. Comparator 활용하기

### 3.1 정렬 문제

기본 String 정렬의 문제점:
```java
TreeSet<String> words = new TreeSet<>();
words.add("Apple");
words.add("apple");
words.add("Banana");

// 결과: [Apple, Banana, apple]
// 대문자가 소문자보다 앞에 옴!
```

### 3.2 Comparator로 해결

```java
// 대소문자 무시 정렬
TreeSet<String> words = new TreeSet<>(String::compareToIgnoreCase);
words.add("Apple");
words.add("apple");
words.add("Banana");

// 결과: [Apple, Banana] 또는 [apple, Banana]
// "Apple"과 "apple"은 같은 것으로 취급됨
```

### 3.3 커스텀 Comparator

```java
// 길이순 정렬, 같으면 알파벳순
Comparator<String> byLength = (s1, s2) -> {
    int lengthCompare = Integer.compare(s1.length(), s2.length());
    if (lengthCompare != 0) {
        return lengthCompare;
    }
    return s1.compareTo(s2);
};

TreeSet<String> words = new TreeSet<>(byLength);
```

### 3.4 역순 정렬

```java
// 숫자 역순 정렬 (큰 수부터)
TreeSet<Integer> numbers = new TreeSet<>(Comparator.reverseOrder());

// 커스텀 역순
Comparator<Student> byGradeDesc = (s1, s2) ->
    Double.compare(s2.getGrade(), s1.getGrade());
```

## 4. 단어 개수 세기 실전 예제

### 4.1 문제 분석

텍스트 파일에서:
1. 모든 단어를 추출
2. 각 단어의 출현 횟수 계산
3. 알파벳순으로 출력
4. 빈도순으로 출력

### 4.2 데이터 구조 설계

```java
// 단어 정보를 담는 클래스
class WordData {
    String word;
    int count;

    WordData(String word) {
        this.word = word;
        this.count = 1;
    }
}

// 단어 → 단어정보 맵
TreeMap<String, WordData> words = new TreeMap<>();
```

### 4.3 단어 카운팅

```java
public void processWord(String word) {
    word = word.toLowerCase();  // 소문자 변환

    WordData data = words.get(word);
    if (data == null) {
        // 새 단어
        words.put(word, new WordData(word));
    } else {
        // 기존 단어
        data.count++;
    }
}
```

### 4.4 빈도순 정렬

```java
// 모든 WordData를 리스트로 복사
ArrayList<WordData> wordList = new ArrayList<>(words.values());

// 빈도순 정렬 (높은 빈도부터)
Collections.sort(wordList, (a, b) -> b.count - a.count);

// 또는 Comparator 체인 사용
wordList.sort(
    Comparator.comparingInt((WordData w) -> w.count)
              .reversed()
              .thenComparing(w -> w.word)
);
```

## 5. 고급 기법들

### 5.1 compute 메서드 활용

```java
// 단어 카운팅 - compute 버전
Map<String, Integer> wordCount = new HashMap<>();

public void countWord(String word) {
    wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
}

// 또는 merge 사용
public void countWord2(String word) {
    wordCount.merge(word, 1, Integer::sum);
}
```

### 5.2 중첩 Map 구조

```java
// 카테고리 → 서브카테고리 → 아이템 목록
Map<String, Map<String, List<Item>>> catalog = new HashMap<>();

// 아이템 추가
public void addItem(String category, String subcategory, Item item) {
    catalog.computeIfAbsent(category, k -> new HashMap<>())
           .computeIfAbsent(subcategory, k -> new ArrayList<>())
           .add(item);
}
```

### 5.3 뷰(View) 활용

```java
// 특정 범위의 데이터만 처리
TreeMap<String, Integer> scores = new TreeMap<>();
// ... 데이터 추가 ...

// 'A'로 시작하는 항목만
SortedMap<String, Integer> aWords = scores.subMap("A", "B");

// 상위 점수만
SortedMap<String, Integer> highScores = scores.tailMap("B");
```

## 6. 성능 고려사항

### 6.1 자료구조 선택

| 용도           | 추천 자료구조 |
| -------------- | ------------- |
| 빠른 조회      | HashMap       |
| 정렬 필요      | TreeMap       |
| 삽입 순서 유지 | LinkedHashMap |
| 중복 제거      | HashSet       |
| 정렬된 집합    | TreeSet       |

### 6.2 초기 용량 설정

```java
// 예상 크기를 알 때
Map<String, Integer> bigMap = new HashMap<>(10000);

// 로드 팩터 조정 (기본 0.75)
Map<String, Integer> denseMap = new HashMap<>(1000, 0.9f);
```

## 7. 실전 팁

### 7.1 null 처리

```java
// getOrDefault 사용
int count = wordCount.getOrDefault(word, 0);

// computeIfAbsent로 초기화
List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
```

### 7.2 불변 컬렉션

```java
// 수정 불가능한 뷰
Map<String, Integer> readOnlyMap = Collections.unmodifiableMap(originalMap);

// Java 9+ 불변 컬렉션
Map<String, Integer> immutableMap = Map.of("a", 1, "b", 2);
```

### 7.3 스트림 API 연동

```java
// Map을 스트림으로 처리
map.entrySet().stream()
   .filter(e -> e.getValue() > 10)
   .sorted(Map.Entry.comparingByValue())
   .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
```

## 마무리

Java 컬렉션 프레임워크의 진정한 힘은 이들을 조합하여 복잡한 문제를 해결할 때 나타납니다:

1. **심볼 테이블**: Map의 기본 활용법
2. **중첩 구조**: Map<K, Collection<V>> 패턴
3. **Comparator**: 유연한 정렬 기준
4. **실전 응용**: 단어 카운팅, 인덱싱 등

이러한 패턴들을 익히면 복잡한 데이터 처리 문제도 우아하게 해결할 수 있습니다!