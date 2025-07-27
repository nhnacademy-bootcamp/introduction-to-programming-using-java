# 10.6 스트림 API 소개 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 스트림 API의 개념과 장점을 이해한다
- 제네릭 함수형 인터페이스를 활용할 수 있다
- 다양한 방법으로 스트림을 생성할 수 있다
- 중간 연산과 종단 연산을 구분하여 사용한다
- 병렬 처리를 통한 성능 향상을 체험한다

## 1. 스트림 API 개요

### 1.1 스트림 API란?

**스트림 API**는 Java 8에서 도입된 데이터 컬렉션 처리를 위한 새로운 방법입니다.

**핵심 목적**:
- **병렬 처리**: 여러 프로세서에서 동시 실행으로 성능 향상
- **함수형 프로그래밍**: 선언적이고 간결한 코드 작성
- **체이닝**: 연산들을 연결하여 가독성 향상

### 1.2 전통적 방법 vs 스트림 API

**문제**: 문자열 리스트에서 길이의 평균 구하기

```java
// 전통적인 for-each 루프 방식
List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date");

int lengthSum = 0;
for (String str : stringList) {
    lengthSum = lengthSum + str.length();
}
double average = (double)lengthSum / stringList.size();
System.out.println("평균 길이: " + average); // 4.5
```

```java
// 스트림 API 방식
int lengthSum = stringList.parallelStream()
                          .mapToInt(str -> str.length())
                          .sum();
double average = (double)lengthSum / stringList.size();
System.out.println("평균 길이: " + average); // 4.5
```

**스트림 방식의 장점**:
- 병렬 처리 가능 (`parallelStream()`)
- 함수 체이닝으로 가독성 향상
- 큰 데이터셋에서 성능 향상

### 1.3 스트림의 특징

```java
public class StreamCharacteristics {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // 1. 스트림은 일회용
        Stream<Integer> stream = numbers.stream();
        stream.forEach(System.out::println);
        // stream.forEach(System.out::println); // 오류! 이미 사용됨
        
        // 2. 지연 평가 (Lazy Evaluation)
        Stream<Integer> lazyStream = numbers.stream()
            .filter(n -> {
                System.out.println("필터 처리: " + n);
                return n > 2;
            })
            .map(n -> {
                System.out.println("매핑 처리: " + n);
                return n * 2;
            });
        
        System.out.println("스트림 생성 완료, 아직 실행 안됨");
        lazyStream.forEach(System.out::println); // 이때 실제 실행
        
        // 3. 순차 vs 병렬
        System.out.println("\n순차 스트림:");
        numbers.stream().forEach(System.out::print);
        
        System.out.println("\n병렬 스트림:");
        numbers.parallelStream().forEach(System.out::print); // 순서 보장 안됨
    }
}
```

## 2. 제네릭 함수형 인터페이스

### 2.1 주요 함수형 인터페이스

Java의 `java.util.function` 패키지에는 다양한 함수형 인터페이스가 있습니다:

| 인터페이스 | 메서드 | 설명 | 예제 |
|-----------|--------|------|------|
| `Predicate<T>` | `boolean test(T t)` | 조건 판별 | `s -> s.length() > 5` |
| `Function<T,R>` | `R apply(T t)` | 변환 | `s -> s.length()` |
| `Consumer<T>` | `void accept(T t)` | 소비 | `s -> System.out.println(s)` |
| `Supplier<T>` | `T get()` | 공급 | `() -> new ArrayList<>()` |
| `UnaryOperator<T>` | `T apply(T t)` | 단항 연산 | `x -> x * 2` |
| `BinaryOperator<T>` | `T apply(T t1, T t2)` | 이항 연산 | `(a, b) -> a + b` |

### 2.2 기본 타입 특화 인터페이스

박싱/언박싱 오버헤드를 피하기 위한 특화 인터페이스들:

```java
public class PrimitiveInterfaces {
    public static void main(String[] args) {
        // IntPredicate - int 전용 조건 판별
        IntPredicate isEven = n -> n % 2 == 0;
        IntStream.range(1, 6)
                .filter(isEven)
                .forEach(System.out::println); // 2, 4
        
        // ToIntFunction - T를 int로 변환
        ToIntFunction<String> stringLength = String::length;
        Stream.of("hello", "world")
              .mapToInt(stringLength)
              .forEach(System.out::println); // 5, 5
        
        // IntSupplier - int 공급
        IntSupplier random = () -> (int)(Math.random() * 100);
        IntStream.generate(random)
                .limit(5)
                .forEach(System.out::println);
        
        // IntConsumer - int 소비
        IntConsumer printer = n -> System.out.println("Number: " + n);
        IntStream.of(1, 2, 3).forEach(printer);
        
        // IntUnaryOperator - int → int 변환
        IntUnaryOperator square = n -> n * n;
        IntStream.of(1, 2, 3, 4)
                .map(square)
                .forEach(System.out::println); // 1, 4, 9, 16
        
        // IntBinaryOperator - int, int → int 연산
        IntBinaryOperator multiply = (a, b) -> a * b;
        int result = IntStream.range(1, 5)
                            .reduce(1, multiply); // 1*2*3*4 = 24
        System.out.println("팩토리얼: " + result);
    }
}
```

### 2.3 실전 활용 예제

```java
public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // Predicate 조합
        Predicate<String> longWord = s -> s.length() > 5;
        Predicate<String> startsWithVowel = s -> "aeiou".indexOf(s.charAt(0)) >= 0;
        Predicate<String> longVowelWord = longWord.and(startsWithVowel);
        
        words.stream()
             .filter(longVowelWord)
             .forEach(System.out::println); // elderberry
        
        // Function 체이닝
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> addPrefix = s -> ">>> " + s;
        Function<String, String> transform = toUpper.andThen(addPrefix);
        
        words.stream()
             .map(transform)
             .forEach(System.out::println);
        
        // 커스텀 함수형 인터페이스 활용
        processStrings(words, 
                      s -> s.length() > 4,           // Predicate
                      s -> s.toUpperCase(),          // Function
                      s -> System.out.println(s));   // Consumer
    }
    
    // 함수형 인터페이스를 매개변수로 받는 메서드
    public static void processStrings(List<String> strings,
                                    Predicate<String> filter,
                                    Function<String, String> mapper,
                                    Consumer<String> action) {
        strings.stream()
               .filter(filter)
               .map(mapper)
               .forEach(action);
    }
}
```

## 3. 스트림 생성

### 3.1 컬렉션에서 스트림 생성

```java
public class StreamFromCollections {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
        
        // 순차 스트림
        Stream<String> sequentialStream = list.stream();
        sequentialStream.forEach(System.out::print); // abcd
        
        System.out.println();
        
        // 병렬 스트림
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::print); // 순서 보장 안됨
        
        System.out.println();
        
        // Set에서 스트림
        set.stream()
           .map(n -> n * 2)
           .forEach(System.out::println); // 2, 4, 6, 8, 10
        
        // 순차 → 병렬 변환
        list.stream()
            .parallel()
            .forEach(System.out::print);
        
        System.out.println();
        
        // 병렬 → 순차 변환
        list.parallelStream()
            .sequential()
            .forEach(System.out::print); // abcd
    }
}
```

### 3.2 배열에서 스트림 생성

```java
public class StreamFromArrays {
    public static void main(String[] args) {
        // 객체 배열
        String[] stringArray = {"apple", "banana", "cherry"};
        Arrays.stream(stringArray)
              .map(String::toUpperCase)
              .forEach(System.out::println);
        
        // 기본 타입 배열
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);
        System.out.println("합계: " + intStream.sum());
        
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        DoubleStream doubleStream = Arrays.stream(doubleArray);
        System.out.println("평균: " + doubleStream.average().orElse(0.0));
        
        // 배열의 일부분만
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(numbers, 2, 7) // 인덱스 2~6 (끝 제외)
              .forEach(System.out::print); // 34567
        
        System.out.println();
        
        // 병렬 스트림으로 변환
        Arrays.stream(intArray)
              .parallel()
              .map(n -> n * n)
              .forEach(System.out::println);
    }
}
```

### 3.3 직접 생성하는 방법들

```java
public class StreamCreationMethods {
    public static void main(String[] args) {
        // 1. Stream.of() - 명시적 값들
        Stream<String> stream1 = Stream.of("a", "b", "c");
        stream1.forEach(System.out::println);
        
        // 2. Stream.empty() - 빈 스트림
        Stream<String> emptyStream = Stream.empty();
        System.out.println("빈 스트림 크기: " + emptyStream.count());
        
        // 3. Stream.generate() - 무한 스트림
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(5).forEach(System.out::println);
        
        // 4. Stream.iterate() - 수열 생성
        Stream<Integer> fibonacciStream = Stream.iterate(
            new int[]{0, 1}, 
            arr -> new int[]{arr[1], arr[0] + arr[1]}
        ).map(arr -> arr[0]);
        
        System.out.println("피보나치 수열:");
        fibonacciStream.limit(10).forEach(System.out::println);
        
        // 5. IntStream.range() - 정수 범위
        System.out.println("1부터 10까지:");
        IntStream.range(1, 11).forEach(System.out::println);
        
        System.out.println("1부터 10까지 (끝 포함):");
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        
        // 6. Random 클래스 활용
        Random random = new Random();
        
        // 무한 랜덤 double 스트림
        random.doubles()
              .limit(5)
              .forEach(System.out::println);
        
        // 범위 지정 랜덤 정수
        random.ints(5, 1, 101) // 5개, 1~100 범위
              .forEach(System.out::println);
        
        // 7. 문자열에서 스트림 (Java 11+)
        String text = "Hello\nWorld\nJava\nStream";
        text.lines().forEach(System.out::println);
        
        // 8. 파일에서 스트림 (예외 처리 필요)
        try {
            Files.lines(Paths.get("example.txt"))
                 .limit(10)
                 .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("파일을 읽을 수 없습니다.");
        }
    }
}
```

## 4. 스트림 연산

### 4.1 중간 연산 (Intermediate Operations)

중간 연산은 스트림을 반환하므로 체이닝이 가능합니다.

```java
public class IntermediateOperations {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", 
                                          "elderberry", "fig", "grape", "apple");
        
        // 1. filter() - 조건에 맞는 요소만 선택
        System.out.println("=== filter ===");
        words.stream()
             .filter(s -> s.length() > 5)
             .forEach(System.out::println); // banana, cherry, elderberry
        
        // 2. map() - 요소 변환
        System.out.println("\n=== map ===");
        words.stream()
             .map(String::length)
             .forEach(System.out::println); // 각 단어의 길이
        
        // 3. mapToInt() - int 스트림으로 변환
        System.out.println("\n=== mapToInt ===");
        int totalLength = words.stream()
                              .mapToInt(String::length)
                              .sum();
        System.out.println("총 길이: " + totalLength);
        
        // 4. distinct() - 중복 제거
        System.out.println("\n=== distinct ===");
        words.stream()
             .distinct()
             .forEach(System.out::println); // apple은 한 번만
        
        // 5. sorted() - 정렬
        System.out.println("\n=== sorted ===");
        words.stream()
             .distinct()
             .sorted()
             .forEach(System.out::println); // 알파벳순
        
        // 커스텀 정렬
        System.out.println("\n=== sorted with custom comparator ===");
        words.stream()
             .distinct()
             .sorted(Comparator.comparing(String::length).reversed())
             .forEach(System.out::println); // 길이 내림차순
        
        // 6. limit() - 개수 제한
        System.out.println("\n=== limit ===");
        words.stream()
             .limit(3)
             .forEach(System.out::println); // 처음 3개
        
        // 7. skip() - 건너뛰기
        System.out.println("\n=== skip ===");
        words.stream()
             .skip(2)
             .limit(3)
             .forEach(System.out::println); // 2개 건너뛰고 3개
        
        // 8. takeWhile() - 조건이 참인 동안 (Java 9+)
        System.out.println("\n=== takeWhile ===");
        Stream.of(1, 2, 3, 4, 5, 2, 1)
              .takeWhile(n -> n < 4)
              .forEach(System.out::println); // 1, 2, 3
        
        // 9. dropWhile() - 조건이 참인 동안 제거 (Java 9+)
        System.out.println("\n=== dropWhile ===");
        Stream.of(1, 2, 3, 4, 5, 2, 1)
              .dropWhile(n -> n < 4)
              .forEach(System.out::println); // 4, 5, 2, 1
        
        // 10. peek() - 중간 처리 (디버깅용)
        System.out.println("\n=== peek ===");
        words.stream()
             .filter(s -> s.length() > 4)
             .peek(s -> System.out.println("필터 통과: " + s))
             .map(String::toUpperCase)
             .peek(s -> System.out.println("대문자 변환: " + s))
             .collect(Collectors.toList());
    }
}
```

### 4.2 종단 연산 (Terminal Operations)

종단 연산은 스트림이 아닌 결과를 반환합니다.

```java
public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // 1. forEach() - 각 요소에 동작 수행
        System.out.println("=== forEach ===");
        numbers.stream().forEach(System.out::print); // 12345678910
        System.out.println();
        
        // 2. forEachOrdered() - 순서 보장
        System.out.println("=== forEachOrdered ===");
        numbers.parallelStream().forEachOrdered(System.out::print); // 항상 12345678910
        System.out.println();
        
        // 3. count() - 개수
        System.out.println("=== count ===");
        long count = words.stream()
                         .filter(s -> s.length() > 5)
                         .count();
        System.out.println("길이 5 초과: " + count); // 3
        
        // 4. collect() - 컬렉션으로 수집
        System.out.println("=== collect ===");
        List<String> longWords = words.stream()
                                     .filter(s -> s.length() > 5)
                                     .collect(Collectors.toList());
        System.out.println("긴 단어들: " + longWords);
        
        // Set으로 수집
        Set<Integer> evenNumbers = numbers.stream()
                                         .filter(n -> n % 2 == 0)
                                         .collect(Collectors.toSet());
        System.out.println("짝수들: " + evenNumbers);
        
        // 5. reduce() - 누적 연산
        System.out.println("=== reduce ===");
        
        // 합계 (초기값 있음)
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("합계: " + sum);
        
        // 곱셈 (초기값 있음)
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("곱셈: " + product);
        
        // 최댓값 (Optional 반환)
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("최댓값: " + max.orElse(0));
        
        // 6. min() / max()
        System.out.println("=== min/max ===");
        Optional<String> shortest = words.stream()
                                        .min(Comparator.comparing(String::length));
        System.out.println("가장 짧은 단어: " + shortest.orElse("없음"));
        
        Optional<String> longest = words.stream()
                                       .max(Comparator.comparing(String::length));
        System.out.println("가장 긴 단어: " + longest.orElse("없음"));
        
        // 7. anyMatch() / allMatch() / noneMatch()
        System.out.println("=== match operations ===");
        boolean hasLongWord = words.stream().anyMatch(s -> s.length() > 8);
        System.out.println("8글자 초과 단어 있나? " + hasLongWord);
        
        boolean allLongWords = words.stream().allMatch(s -> s.length() > 3);
        System.out.println("모든 단어가 3글자 초과? " + allLongWords);
        
        boolean noShortWords = words.stream().noneMatch(s -> s.length() < 3);
        System.out.println("3글자 미만 단어 없나? " + noShortWords);
        
        // 8. findFirst() / findAny()
        System.out.println("=== find operations ===");
        Optional<String> firstLongWord = words.stream()
                                            .filter(s -> s.length() > 5)
                                            .findFirst();
        System.out.println("첫 번째 긴 단어: " + firstLongWord.orElse("없음"));
        
        Optional<String> anyLongWord = words.parallelStream()
                                          .filter(s -> s.length() > 5)
                                          .findAny();
        System.out.println("아무 긴 단어: " + anyLongWord.orElse("없음"));
        
        // 9. 기본 타입 스트림의 통계 연산
        System.out.println("=== IntStream operations ===");
        IntSummaryStatistics stats = numbers.stream()
                                           .mapToInt(Integer::intValue)
                                           .summaryStatistics();
        
        System.out.println("통계 정보:");
        System.out.println("  개수: " + stats.getCount());
        System.out.println("  합계: " + stats.getSum());
        System.out.println("  평균: " + stats.getAverage());
        System.out.println("  최솟값: " + stats.getMin());
        System.out.println("  최댓값: " + stats.getMax());
    }
}
```

### 4.3 고급 수집 연산

```java
public class AdvancedCollectors {
    static class Person {
        String name;
        int age;
        String department;
        
        Person(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
        
        @Override
        public String toString() {
            return String.format("%s(%d, %s)", name, age, department);
        }
    }
    
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "Engineering"),
            new Person("Bob", 25, "Marketing"),
            new Person("Charlie", 35, "Engineering"),
            new Person("David", 28, "Sales"),
            new Person("Eve", 32, "Marketing")
        );
        
        // 1. groupingBy() - 그룹화
        System.out.println("=== groupingBy ===");
        Map<String, List<Person>> byDepartment = people.stream()
            .collect(Collectors.groupingBy(Person::getDepartment));
        
        byDepartment.forEach((dept, persons) -> {
            System.out.println(dept + ": " + persons);
        });
        
        // 2. partitioningBy() - 분할 (boolean 기준)
        System.out.println("\n=== partitioningBy ===");
        Map<Boolean, List<Person>> partitioned = people.stream()
            .collect(Collectors.partitioningBy(p -> p.getAge() >= 30));
        
        System.out.println("30세 이상: " + partitioned.get(true));
        System.out.println("30세 미만: " + partitioned.get(false));
        
        // 3. 그룹화 + 통계
        System.out.println("\n=== groupingBy with counting ===");
        Map<String, Long> countByDepartment = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.counting()
            ));
        
        countByDepartment.forEach((dept, count) -> {
            System.out.println(dept + ": " + count + "명");
        });
        
        // 4. 그룹화 + 평균
        System.out.println("\n=== groupingBy with averaging ===");
        Map<String, Double> avgAgeByDepartment = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.averagingInt(Person::getAge)
            ));
        
        avgAgeByDepartment.forEach((dept, avgAge) -> {
            System.out.printf("%s: %.1f세\n", dept, avgAge);
        });
        
        // 5. joining() - 문자열 결합
        System.out.println("\n=== joining ===");
        String names = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", "));
        System.out.println("모든 이름: " + names);
        
        String formattedNames = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("형식화된 이름: " + formattedNames);
        
        // 6. 중첩 그룹화
        System.out.println("\n=== nested grouping ===");
        Map<String, Map<Boolean, List<Person>>> nestedGrouping = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.partitioningBy(p -> p.getAge() >= 30)
            ));
        
        nestedGrouping.forEach((dept, ageGroups) -> {
            System.out.println(dept + ":");
            System.out.println("  30세 이상: " + ageGroups.get(true).size() + "명");
            System.out.println("  30세 미만: " + ageGroups.get(false).size() + "명");
        });
    }
}
```

## 5. 성능과 병렬 처리

### 5.1 순차 vs 병렬 스트림

```java
public class StreamPerformanceComparison {
    public static void main(String[] args) {
        // 큰 데이터셋 생성
        List<Integer> largeList = IntStream.range(1, 10_000_000)
                                          .boxed()
                                          .collect(Collectors.toList());
        
        // 1. 순차 처리
        long startTime = System.currentTimeMillis();
        
        long sequentialSum = largeList.stream()
                                     .filter(n -> n % 2 == 0)
                                     .mapToLong(n -> n * n)
                                     .sum();
        
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("순차 처리 결과: " + sequentialSum);
        System.out.println("순차 처리 시간: " + sequentialTime + "ms");
        
        // 2. 병렬 처리
        startTime = System.currentTimeMillis();
        
        long parallelSum = largeList.parallelStream()
                                   .filter(n -> n % 2 == 0)
                                   .mapToLong(n -> n * n)
                                   .sum();
        
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("병렬 처리 결과: " + parallelSum);
        System.out.println("병렬 처리 시간: " + parallelTime + "ms");
        
        // 성능 비교
        double speedup = (double) sequentialTime / parallelTime;
        System.out.printf("성능 향상: %.2fx\n", speedup);
        
        // 3. 작은 데이터셋에서의 비교
        List<Integer> smallList = IntStream.range(1, 1000)
                                          .boxed()
                                          .collect(Collectors.toList());
        
        System.out.println("\n=== 작은 데이터셋 비교 ===");
        measureTime("순차", () -> smallList.stream().map(n -> n * n).sum());
        measureTime("병렬", () -> smallList.parallelStream().map(n -> n * n).sum());
    }
    
    private static void measureTime(String label, Supplier<Integer> operation) {
        long start = System.nanoTime();
        Integer result = operation.get();
        long end = System.nanoTime();
        
        System.out.printf("%s: %d (%d ns)\n", label, result, end - start);
    }
}
```

### 5.2 병렬 처리 주의사항

```java
public class ParallelStreamCaveats {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(1, 1000).boxed().collect(Collectors.toList());
        
        // 1. 순서가 중요한 경우
        System.out.println("=== 순서 문제 ===");
        System.out.print("순차: ");
        numbers.stream().limit(10).forEach(n -> System.out.print(n + " "));
        
        System.out.print("\n병렬: ");
        numbers.parallelStream().limit(10).forEach(n -> System.out.print(n + " "));
        
        System.out.print("\n병렬 순서 보장: ");
        numbers.parallelStream().limit(10).forEachOrdered(n -> System.out.print(n + " "));
        
        // 2. 상태 공유 문제 (피해야 할 패턴)
        System.out.println("\n\n=== 상태 공유 문제 ===");
        
        // 잘못된 예 - 외부 변수 수정
        List<Integer> wrongResult = new ArrayList<>();
        numbers.parallelStream()
               .filter(n -> n % 2 == 0)
               .limit(10)
               .forEach(wrongResult::add); // 스레드 안전하지 않음!
        
        System.out.println("잘못된 방법 크기: " + wrongResult.size()); // 예측 불가
        
        // 올바른 예 - collect 사용
        List<Integer> correctResult = numbers.parallelStream()
                                           .filter(n -> n % 2 == 0)
                                           .limit(10)
                                           .collect(Collectors.toList());
        
        System.out.println("올바른 방법 크기: " + correctResult.size()); // 10
        
        // 3. 병렬 처리에 적합하지 않은 연산
        System.out.println("\n=== 병렬 처리 적합성 ===");
        
        // I/O 작업은 병렬 처리 효과 제한적
        List<String> urls = Arrays.asList(
            "http://example1.com", "http://example2.com", "http://example3.com"
        );
        
        // 순차 처리가 더 나을 수 있음
        urls.stream().forEach(url -> {
            // 네트워크 I/O 시뮬레이션
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Processing: " + url);
        });
    }
}
```

### 5.3 실제 성능 측정 예제

```java
public class RiemannSumExample {
    // 리만 합 계산을 통한 성능 비교
    
    // 전통적인 for 루프
    private static double riemannSumWithForLoop(
            DoubleUnaryOperator function, double start, double end, int divisions) {
        double sum = 0;
        double dx = (end - start) / divisions;
        
        for (int i = 0; i < divisions; i++) {
            sum += function.applyAsDouble(start + i * dx);
        }
        
        return sum * dx;
    }
    
    // 순차 스트림
    private static double riemannSumWithSequentialStream(
            DoubleUnaryOperator function, double start, double end, int divisions) {
        double dx = (end - start) / divisions;
        
        double sum = IntStream.range(0, divisions)
                             .mapToDouble(i -> function.applyAsDouble(start + i * dx))
                             .sum();
        
        return sum * dx;
    }
    
    // 병렬 스트림
    private static double riemannSumWithParallelStream(
            DoubleUnaryOperator function, double start, double end, int divisions) {
        double dx = (end - start) / divisions;
        
        double sum = IntStream.range(0, divisions)
                             .parallel()
                             .mapToDouble(i -> function.applyAsDouble(start + i * dx))
                             .sum();
        
        return sum * dx;
    }
    
    public static void main(String[] args) {
        DoubleUnaryOperator sineFunction = Math::sin;
        double start = 0;
        double end = Math.PI;
        int[] divisions = {100_000, 1_000_000, 10_000_000};
        
        System.out.println("sin(x)를 0부터 π까지 적분 (실제값: 2.0)");
        System.out.println();
        
        for (int n : divisions) {
            System.out.println("분할 수: " + n);
            
            // For 루프
            long start1 = System.currentTimeMillis();
            double result1 = riemannSumWithForLoop(sineFunction, start, end, n);
            long time1 = System.currentTimeMillis() - start1;
            
            // 순차 스트림
            long start2 = System.currentTimeMillis();
            double result2 = riemannSumWithSequentialStream(sineFunction, start, end, n);
            long time2 = System.currentTimeMillis() - start2;
            
            // 병렬 스트림
            long start3 = System.currentTimeMillis();
            double result3 = riemannSumWithParallelStream(sineFunction, start, end, n);
            long time3 = System.currentTimeMillis() - start3;
            
            System.out.printf("  For 루프:    %.6f (%3d ms)\n", result1, time1);
            System.out.printf("  순차 스트림:  %.6f (%3d ms)\n", result2, time2);
            System.out.printf("  병렬 스트림:  %.6f (%3d ms)\n", result3, time3);
            
            if (time1 > 0) {
                System.out.printf("  병렬 가속비: %.2fx\n", (double) time1 / time3);
            }
            
            System.out.println();
        }
        
        // 시스템 정보
        System.out.println("프로세서 코어 수: " + 
                          Runtime.getRuntime().availableProcessors());
    }
}
```

## 6. 실전 활용 예제

### 6.1 데이터 분석 예제

```java
public class DataAnalysisExample {
    static class Sale {
        String product;
        String region;
        double amount;
        LocalDate date;
        
        Sale(String product, String region, double amount, LocalDate date) {
            this.product = product;
            this.region = region;
            this.amount = amount;
            this.date = date;
        }
        
        // getters
        public String getProduct() { return product; }
        public String getRegion() { return region; }
        public double getAmount() { return amount; }
        public LocalDate getDate() { return date; }
        
        @Override
        public String toString() {
            return String.format("%s in %s: $%.2f (%s)", 
                               product, region, amount, date);
        }
    }
    
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("iPhone", "North", 999.99, LocalDate.of(2023, 1, 15)),
            new Sale("Samsung", "South", 899.99, LocalDate.of(2023, 1, 16)),
            new Sale("iPhone", "East", 999.99, LocalDate.of(2023, 2, 10)),
            new Sale("Pixel", "West", 799.99, LocalDate.of(2023, 2, 12)),
            new Sale("iPhone", "North", 999.99, LocalDate.of(2023, 3, 5)),
            new Sale("Samsung", "East", 899.99, LocalDate.of(2023, 3, 8)),
            new Sale("Pixel", "South", 799.99, LocalDate.of(2023, 3, 20))
        );
        
        // 1. 총 매출액
        double totalSales = sales.stream()
                                .mapToDouble(Sale::getAmount)
                                .sum();
        System.out.printf("총 매출: $%.2f\n", totalSales);
        
        // 2. 제품별 매출 집계
        System.out.println("\n=== 제품별 매출 ===");
        Map<String, Double> salesByProduct = sales.stream()
            .collect(Collectors.groupingBy(
                Sale::getProduct,
                Collectors.summingDouble(Sale::getAmount)
            ));
        
        salesByProduct.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%s: $%.2f\n", entry.getKey(), entry.getValue())
            );
        
        // 3. 지역별 평균 판매액
        System.out.println("\n=== 지역별 평균 판매액 ===");
        Map<String, Double> avgByRegion = sales.stream()
            .collect(Collectors.groupingBy(
                Sale::getRegion,
                Collectors.averagingDouble(Sale::getAmount)
            ));
        
        avgByRegion.forEach((region, avg) -> 
            System.out.printf("%s: $%.2f\n", region, avg)
        );
        
        // 4. 월별 매출 통계
        System.out.println("\n=== 월별 매출 ===");
        Map<Integer, DoubleSummaryStatistics> monthlyStats = sales.stream()
            .collect(Collectors.groupingBy(
                sale -> sale.getDate().getMonthValue(),
                Collectors.summarizingDouble(Sale::getAmount)
            ));
        
        monthlyStats.forEach((month, stats) -> {
            System.out.printf("%d월: 건수=%d, 총액=$%.2f, 평균=$%.2f\n",
                             month, stats.getCount(), stats.getSum(), stats.getAverage());
        });
        
        // 5. 가장 비싼 제품 찾기
        System.out.println("\n=== 최고 매출 제품 ===");
        Optional<Sale> maxSale = sales.stream()
            .max(Comparator.comparing(Sale::getAmount));
        
        maxSale.ifPresent(sale -> 
            System.out.println("최고 매출: " + sale)
        );
        
        // 6. 특정 조건 필터링
        System.out.println("\n=== $900 이상 매출 ===");
        List<Sale> highValueSales = sales.stream()
            .filter(sale -> sale.getAmount() >= 900)
            .sorted(Comparator.comparing(Sale::getAmount).reversed())
            .collect(Collectors.toList());
        
        highValueSales.forEach(System.out::println);
        
        // 7. 복합 통계
        System.out.println("\n=== 복합 통계 ===");
        DoubleSummaryStatistics overallStats = sales.stream()
            .mapToDouble(Sale::getAmount)
            .summaryStatistics();
        
        System.out.println("전체 통계:");
        System.out.printf("  거래 건수: %d\n", overallStats.getCount());
        System.out.printf("  총 매출: $%.2f\n", overallStats.getSum());
        System.out.printf("  평균 매출: $%.2f\n", overallStats.getAverage());
        System.out.printf("  최고 매출: $%.2f\n", overallStats.getMax());
        System.out.printf("  최저 매출: $%.2f\n", overallStats.getMin());
    }
}
```

## 마무리

스트림 API는 Java 8의 혁신적인 기능으로, 다음과 같은 이점을 제공합니다:

### 주요 장점
1. **함수형 프로그래밍**: 선언적이고 간결한 코드
2. **병렬 처리**: 멀티코어 활용으로 성능 향상
3. **체이닝**: 연산들을 자연스럽게 연결
4. **지연 평가**: 필요할 때만 연산 수행

### 사용 시 고려사항
1. **데이터 크기**: 작은 데이터에서는 전통적 루프가 더 빠를 수 있음
2. **병렬 처리 적합성**: I/O 작업이나 순서 의존적 작업은 주의
3. **스트림 재사용**: 스트림은 일회용임을 기억
4. **상태 공유**: 병렬 스트림에서 외부 상태 수정 금지

스트림 API를 마스터하면 더 표현력 있고 효율적인 Java 코드를 작성할 수 있습니다!