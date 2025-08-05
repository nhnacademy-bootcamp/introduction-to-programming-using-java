# 10.6 스트림 API 소개 - 예제 모음

## 1. 기본 스트림 생성 및 조작

### 예제 1-1: 다양한 스트림 생성 방법

```java
import java.util.*;
import java.util.stream.*;

public class StreamCreationExamples {
    public static void main(String[] args) {
        System.out.println("=== 스트림 생성 방법들 ===");
        
        // 1. 컬렉션에서 스트림 생성
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("리스트에서 순차 스트림:");
        fruits.stream().forEach(System.out::println);
        
        System.out.println("\n리스트에서 병렬 스트림:");
        fruits.parallelStream().forEach(System.out::println);
        
        // 2. 배열에서 스트림 생성
        String[] colors = {"red", "green", "blue", "yellow"};
        System.out.println("\n배열에서 스트림:");
        Arrays.stream(colors).forEach(System.out::println);
        
        // 정수 배열
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("\n정수 배열에서 IntStream:");
        Arrays.stream(numbers).forEach(System.out::println);
        
        // 3. Stream.of()로 직접 생성
        System.out.println("\nStream.of()로 생성:");
        Stream.of("하나", "둘", "셋").forEach(System.out::println);
        
        // 4. Stream.generate()로 무한 스트림 생성
        System.out.println("\n무한 스트림 (첫 5개만):");
        Stream.generate(() -> "Hello")
              .limit(5)
              .forEach(System.out::println);
        
        // 5. Stream.iterate()로 수열 생성
        System.out.println("\n피보나치 수열 (첫 10개):");
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
              .limit(10)
              .mapToInt(fib -> fib[0])
              .forEach(System.out::println);
        
        // 6. IntStream.range()로 범위 생성
        System.out.println("\n범위 스트림 (1-5):");
        IntStream.range(1, 6).forEach(System.out::println);
        
        // 7. Random 스트림
        System.out.println("\n랜덤 정수 (5개):");
        new Random().ints(5, 1, 101)
                   .forEach(System.out::println);
    }
}
```

### 예제 1-2: 함수형 인터페이스 활용

```java
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "api", "functional", "programming");
        
        // 1. Predicate<T> - 조건 판별
        Predicate<String> longWord = s -> s.length() > 4;
        System.out.println("긴 단어들:");
        words.stream()
             .filter(longWord)
             .forEach(System.out::println);
        
        // 2. Function<T, R> - 변환
        Function<String, Integer> getLength = String::length;
        System.out.println("\n단어 길이들:");
        words.stream()
             .map(getLength)
             .forEach(System.out::println);
        
        // 3. Consumer<T> - 소비
        Consumer<String> printer = s -> System.out.println("처리중: " + s);
        System.out.println("\nConsumer 사용:");
        words.stream().forEach(printer);
        
        // 4. Supplier<T> - 공급
        Supplier<String> randomWord = () -> {
            String[] samples = {"hello", "world", "java", "stream"};
            return samples[new Random().nextInt(samples.length)];
        };
        
        System.out.println("\n랜덤 단어 5개:");
        Stream.generate(randomWord)
              .limit(5)
              .forEach(System.out::println);
        
        // 5. UnaryOperator<T> - 단항 연산
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println("\n대문자 변환:");
        words.stream()
             .map(toUpperCase)
             .forEach(System.out::println);
        
        // 6. BinaryOperator<T> - 이항 연산
        BinaryOperator<String> concat = (s1, s2) -> s1 + "-" + s2;
        System.out.println("\n단어 연결:");
        String result = words.stream()
                            .reduce(concat)
                            .orElse("없음");
        System.out.println(result);
        
        // 7. 메서드 조합 사용
        Predicate<String> startsWithJ = s -> s.startsWith("j");
        Predicate<String> hasMoreThan3Chars = s -> s.length() > 3;
        
        System.out.println("\n'j'로 시작하고 3글자 이상:");
        words.stream()
             .filter(startsWithJ.and(hasMoreThan3Chars))
             .forEach(System.out::println);
    }
}
```

## 2. 중간 연산 (Intermediate Operations)

### 예제 2-1: 필터링과 매핑

```java
import java.util.*;
import java.util.stream.*;

public class IntermediateOperationsExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("김철수", 85, "컴퓨터공학"),
            new Student("이영희", 92, "수학"),
            new Student("박민수", 78, "컴퓨터공학"),
            new Student("최유진", 88, "수학"),
            new Student("정현우", 95, "물리학"),
            new Student("김영희", 82, "컴퓨터공학")
        );
        
        System.out.println("=== 중간 연산 예제 ===");
        
        // 1. filter() - 조건에 맞는 요소만 선택
        System.out.println("컴퓨터공학과 학생들:");
        students.stream()
                .filter(s -> s.getMajor().equals("컴퓨터공학"))
                .forEach(System.out::println);
        
        // 2. map() - 요소 변환
        System.out.println("\n학생 이름들:");
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);
        
        // 3. mapToInt() - 기본형으로 변환
        System.out.println("\n점수들:");
        students.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);
        
        // 4. distinct() - 중복 제거
        System.out.println("\n전공 목록 (중복 제거):");
        students.stream()
                .map(Student::getMajor)
                .distinct()
                .forEach(System.out::println);
        
        // 5. sorted() - 정렬
        System.out.println("\n점수 순 정렬:");
        students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .forEach(System.out::println);
        
        // 6. limit() - 개수 제한
        System.out.println("\n상위 3명:");
        students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .limit(3)
                .forEach(System.out::println);
        
        // 7. skip() - 요소 건너뛰기
        System.out.println("\n상위 2명 제외한 나머지:");
        students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .skip(2)
                .forEach(System.out::println);
        
        // 8. 복합 연산
        System.out.println("\n컴퓨터공학과 중 80점 이상 학생 이름:");
        students.stream()
                .filter(s -> s.getMajor().equals("컴퓨터공학"))
                .filter(s -> s.getScore() >= 80)
                .map(Student::getName)
                .sorted()
                .forEach(System.out::println);
    }
}

class Student {
    private String name;
    private int score;
    private String major;
    
    public Student(String name, int score, String major) {
        this.name = name;
        this.score = score;
        this.major = major;
    }
    
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getMajor() { return major; }
    
    @Override
    public String toString() {
        return String.format("%s(%d점, %s)", name, score, major);
    }
}
```

### 예제 2-2: flatMap과 복잡한 변환

```java
import java.util.*;
import java.util.stream.*;

public class FlatMapExample {
    public static void main(String[] args) {
        // 1. 문자열을 문자로 분해
        List<String> words = Arrays.asList("hello", "world", "java", "stream");
        
        System.out.println("=== flatMap 예제 ===");
        
        // 잘못된 방법: map만 사용
        System.out.println("map만 사용 (Stream<Stream<Character>>):");
        words.stream()
             .map(word -> word.chars().mapToObj(c -> (char) c))
             .forEach(stream -> {
                 System.out.print("스트림: ");
                 stream.forEach(System.out::print);
                 System.out.println();
             });
        
        // 올바른 방법: flatMap 사용
        System.out.println("\nflatMap 사용 (모든 문자):");
        words.stream()
             .flatMap(word -> word.chars().mapToObj(c -> (char) c))
             .forEach(System.out::print);
        System.out.println();
        
        // 2. 중첩된 리스트 평면화
        List<List<Integer>> nestedNumbers = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        
        System.out.println("\n중첩 리스트 평면화:");
        nestedNumbers.stream()
                    .flatMap(List::stream)
                    .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 3. 학생-과목 관계 예제
        List<Student2> students = Arrays.asList(
            new Student2("김철수", Arrays.asList("수학", "영어", "과학")),
            new Student2("이영희", Arrays.asList("국어", "수학", "역사")),
            new Student2("박민수", Arrays.asList("영어", "과학", "체육"))
        );
        
        System.out.println("\n모든 수강 과목 (중복 포함):");
        students.stream()
                .flatMap(s -> s.getSubjects().stream())
                .forEach(subject -> System.out.print(subject + " "));
        System.out.println();
        
        System.out.println("\n고유한 수강 과목:");
        students.stream()
                .flatMap(s -> s.getSubjects().stream())
                .distinct()
                .sorted()
                .forEach(subject -> System.out.print(subject + " "));
        System.out.println();
        
        // 4. 문자열 분할과 단어 카운트
        List<String> sentences = Arrays.asList(
            "Java is powerful",
            "Stream API is useful",
            "Programming is fun"
        );
        
        System.out.println("\n모든 단어들:");
        Map<String, Long> wordCount = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                    word -> word,
                    Collectors.counting()
                ));
        
        wordCount.forEach((word, count) -> 
            System.out.println(word + ": " + count + "번"));
    }
}

class Student2 {
    private String name;
    private List<String> subjects;
    
    public Student2(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    
    public String getName() { return name; }
    public List<String> getSubjects() { return subjects; }
}
```

## 3. 종단 연산 (Terminal Operations)

### 예제 3-1: 수집과 집계

```java
import java.util.*;
import java.util.stream.*;

public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("노트북", 1200000, "전자제품"),
            new Product("마우스", 25000, "전자제품"),
            new Product("키보드", 80000, "전자제품"),
            new Product("의자", 150000, "가구"),
            new Product("책상", 300000, "가구"),
            new Product("모니터", 250000, "전자제품"),
            new Product("램프", 45000, "가구")
        );
        
        System.out.println("=== 종단 연산 예제 ===");
        
        // 1. forEach() - 각 요소에 작업 수행
        System.out.println("모든 제품:");
        products.stream().forEach(System.out::println);
        
        // 2. collect() - 리스트로 수집
        List<String> productNames = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("\n제품명 리스트: " + productNames);
        
        // 3. count() - 개수 세기
        long electronicCount = products.stream()
                .filter(p -> p.getCategory().equals("전자제품"))
                .count();
        System.out.println("\n전자제품 개수: " + electronicCount);
        
        // 4. min(), max() - 최솟값, 최댓값
        Optional<Product> cheapest = products.stream()
                .min(Comparator.comparing(Product::getPrice));
        cheapest.ifPresent(p -> System.out.println("가장 저렴한 제품: " + p));
        
        Optional<Product> mostExpensive = products.stream()
                .max(Comparator.comparing(Product::getPrice));
        mostExpensive.ifPresent(p -> System.out.println("가장 비싼 제품: " + p));
        
        // 5. reduce() - 집계
        int totalPrice = products.stream()
                .mapToInt(Product::getPrice)
                .reduce(0, Integer::sum);
        System.out.println("\n총 가격: " + totalPrice + "원");
        
        // 6. anyMatch(), allMatch(), noneMatch() - 조건 확인
        boolean hasExpensiveItem = products.stream()
                .anyMatch(p -> p.getPrice() > 1000000);
        System.out.println("100만원 이상 제품 존재: " + hasExpensiveItem);
        
        boolean allAffordable = products.stream()
                .allMatch(p -> p.getPrice() < 2000000);
        System.out.println("모든 제품이 200만원 미만: " + allAffordable);
        
        // 7. findFirst(), findAny() - 요소 찾기
        Optional<Product> firstFurniture = products.stream()
                .filter(p -> p.getCategory().equals("가구"))
                .findFirst();
        firstFurniture.ifPresent(p -> System.out.println("첫 번째 가구: " + p));
        
        // 8. 그룹화
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        System.out.println("\n카테고리별 제품:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(p -> System.out.println("  " + p));
        });
        
        // 9. 통계 수집
        IntSummaryStatistics priceStats = products.stream()
                .mapToInt(Product::getPrice)
                .summaryStatistics();
        
        System.out.println("\n가격 통계:");
        System.out.println("평균: " + priceStats.getAverage());
        System.out.println("최대: " + priceStats.getMax());
        System.out.println("최소: " + priceStats.getMin());
        System.out.println("합계: " + priceStats.getSum());
        System.out.println("개수: " + priceStats.getCount());
    }
}

class Product {
    private String name;
    private int price;
    private String category;
    
    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }
    
    @Override
    public String toString() {
        return String.format("%s(%d원, %s)", name, price, category);
    }
}
```

## 4. 병렬 처리와 성능

### 예제 4-1: 순차 vs 병렬 처리 성능 비교

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamPerformance {
    public static void main(String[] args) {
        // 큰 데이터셋 생성
        List<Integer> largeList = IntStream.range(1, 10000000)
                .boxed()
                .collect(Collectors.toList());
        
        System.out.println("데이터 크기: " + largeList.size());
        
        // 1. 순차 스트림으로 처리
        long startTime = System.currentTimeMillis();
        long sum1 = largeList.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(n -> n * n)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("순차 처리 시간: " + (endTime - startTime) + "ms");
        System.out.println("순차 처리 결과: " + sum1);
        
        // 2. 병렬 스트림으로 처리
        startTime = System.currentTimeMillis();
        long sum2 = largeList.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(n -> n * n)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("병렬 처리 시간: " + (endTime - startTime) + "ms");
        System.out.println("병렬 처리 결과: " + sum2);
        
        // 3. 작은 데이터셋에서의 비교
        List<Integer> smallList = IntStream.range(1, 1000)
                .boxed()
                .collect(Collectors.toList());
        
        System.out.println("\n=== 작은 데이터셋 (크기: " + smallList.size() + ") ===");
        
        // 순차 처리
        startTime = System.nanoTime();
        long smallSum1 = smallList.stream()
                .mapToLong(n -> n * n)
                .sum();
        endTime = System.nanoTime();
        System.out.println("순차 처리 시간: " + (endTime - startTime) + "ns");
        
        // 병렬 처리
        startTime = System.nanoTime();
        long smallSum2 = smallList.parallelStream()
                .mapToLong(n -> n * n)
                .sum();
        endTime = System.nanoTime();
        System.out.println("병렬 처리 시간: " + (endTime - startTime) + "ns");
        
        // 4. 병렬 처리에 적합한 연산 vs 부적합한 연산
        System.out.println("\n=== 병렬 처리 적합성 테스트 ===");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // 적합한 예: 독립적인 변환 작업
        System.out.println("병렬 처리 적합 - 독립적 변환:");
        words.parallelStream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
        
        // 부적합한 예: 순서 의존적 작업 (순서가 보장되지 않음)
        System.out.println("\n병렬 처리 부적합 - 순서 의존적:");
        words.parallelStream()
             .forEach(word -> System.out.print(word + " "));
        System.out.println();
        
        // 순서 보장이 필요한 경우 forEachOrdered 사용
        System.out.println("forEachOrdered로 순서 보장:");
        words.parallelStream()
             .forEachOrdered(word -> System.out.print(word + " "));
        System.out.println();
    }
}
```

### 예제 4-2: 병렬 처리 최적화 기법

```java
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ParallelOptimization {
    public static void main(String[] args) {
        // 1. ForkJoinPool 커스터마이징
        System.out.println("=== ForkJoinPool 커스터마이징 ===");
        
        List<Integer> numbers = IntStream.range(1, 1000000)
                .boxed()
                .collect(Collectors.toList());
        
        // 기본 스레드 풀 사용
        long result1 = numbers.parallelStream()
                .mapToLong(n -> heavyComputation(n))
                .sum();
        System.out.println("기본 풀 결과: " + result1);
        
        // 커스텀 스레드 풀 사용
        ForkJoinPool customThreadPool = new ForkJoinPool(8);
        try {
            long result2 = customThreadPool.submit(() ->
                numbers.parallelStream()
                       .mapToLong(n -> heavyComputation(n))
                       .sum()
            ).get();
            System.out.println("커스텀 풀 결과: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();
        }
        
        // 2. 데이터 분할 최적화
        System.out.println("\n=== 데이터 분할 최적화 ===");
        
        // ArrayList vs LinkedList 병렬 처리 성능
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        
        // ArrayList (분할이 효율적)
        long startTime = System.currentTimeMillis();
        long arraySum = arrayList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        long arrayTime = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList 병렬 처리 시간: " + arrayTime + "ms");
        
        // LinkedList (분할이 비효율적)
        startTime = System.currentTimeMillis();
        long linkedSum = linkedList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        long linkedTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList 병렬 처리 시간: " + linkedTime + "ms");
        
        // 3. 병렬 처리 적합성 판단
        demonstrateParallelSuitability();
    }
    
    private static long heavyComputation(int n) {
        // 무거운 계산을 시뮬레이션
        return n % 1000 == 0 ? 
               IntStream.range(1, 1000).sum() : n;
    }
    
    private static void demonstrateParallelSuitability() {
        System.out.println("\n=== 병렬 처리 적합성 가이드 ===");
        
        List<Integer> data = IntStream.range(1, 1000000)
                .boxed()
                .collect(Collectors.toList());
        
        // 적합한 케이스들
        System.out.println("1. CPU 집약적 작업 - 적합");
        long start = System.currentTimeMillis();
        data.parallelStream()
            .filter(n -> isPrime(n))
            .count();
        System.out.println("소수 찾기 시간: " + (System.currentTimeMillis() - start) + "ms");
        
        System.out.println("\n2. 독립적인 변환 작업 - 적합");
        start = System.currentTimeMillis();
        data.parallelStream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("제곱 계산 시간: " + (System.currentTimeMillis() - start) + "ms");
        
        System.out.println("\n3. 단순 집계 작업 - 적합");
        start = System.currentTimeMillis();
        data.parallelStream()
            .mapToLong(Integer::longValue)
            .sum();
        System.out.println("합계 계산 시간: " + (System.currentTimeMillis() - start) + "ms");
        
        // 부적합한 케이스들
        System.out.println("\n4. 순서 의존적 작업 - 부적합");
        System.out.println("순차: " + data.stream().limit(10).collect(Collectors.toList()));
        System.out.println("병렬: " + data.parallelStream().limit(10).collect(Collectors.toList()));
        
        System.out.println("\n5. I/O 작업 - 부적합 (여기서는 시뮬레이션)");
        start = System.currentTimeMillis();
        data.stream()
            .limit(1000)
            .map(n -> simulateIOOperation(n))
            .collect(Collectors.toList());
        System.out.println("순차 I/O 시간: " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private static String simulateIOOperation(int n) {
        // I/O 지연 시뮬레이션
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data" + n;
    }
}
```

## 5. 실전 활용 예제

### 예제 5-1: 데이터 분석 시스템

```java
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class DataAnalysisSystem {
    public static void main(String[] args) {
        // 샘플 주문 데이터 생성
        List<Order> orders = generateSampleOrders();
        
        DataAnalysisSystem analyzer = new DataAnalysisSystem();
        analyzer.performAnalysis(orders);
    }
    
    private void performAnalysis(List<Order> orders) {
        System.out.println("=== 주문 데이터 분석 시스템 ===");
        System.out.println("총 주문 수: " + orders.size());
        
        // 1. 월별 매출 분석
        System.out.println("\n1. 월별 매출:");
        Map<String, Double> monthlySales = orders.stream()
                .collect(Collectors.groupingBy(
                    order -> order.getDate().getYear() + "-" + 
                            String.format("%02d", order.getDate().getMonthValue()),
                    Collectors.summingDouble(Order::getAmount)
                ));
        
        monthlySales.entrySet().stream()
                   .sorted(Map.Entry.comparingByKey())
                   .forEach(entry -> 
                       System.out.printf("%s: %.0f원%n", entry.getKey(), entry.getValue()));
        
        // 2. 고객별 구매 패턴 분석
        System.out.println("\n2. 고객별 구매 통계:");
        Map<String, CustomerStats> customerStats = orders.stream()
                .collect(Collectors.groupingBy(
                    Order::getCustomerId,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        orderList -> new CustomerStats(
                            orderList.size(),
                            orderList.stream().mapToDouble(Order::getAmount).sum(),
                            orderList.stream().mapToDouble(Order::getAmount).average().orElse(0)
                        )
                    )
                ));
        
        customerStats.entrySet().stream()
                    .sorted(Map.Entry.<String, CustomerStats>comparingByValue(
                        Comparator.comparing(CustomerStats::getTotalAmount)).reversed())
                    .limit(5)
                    .forEach(entry -> 
                        System.out.printf("고객 %s: %d건, 총 %.0f원, 평균 %.0f원%n",
                            entry.getKey(),
                            entry.getValue().getOrderCount(),
                            entry.getValue().getTotalAmount(),
                            entry.getValue().getAverageAmount()));
        
        // 3. 제품 카테고리별 인기도
        System.out.println("\n3. 제품 카테고리별 판매량:");
        Map<String, Long> categoryPopularity = orders.stream()
                .collect(Collectors.groupingBy(
                    Order::getCategory,
                    Collectors.counting()
                ));
        
        categoryPopularity.entrySet().stream()
                         .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                         .forEach(entry -> 
                             System.out.printf("%s: %d건%n", entry.getKey(), entry.getValue()));
        
        // 4. 시간대별 주문 패턴
        System.out.println("\n4. 시간대별 주문 분포:");
        Map<Integer, Long> hourlyOrders = orders.stream()
                .collect(Collectors.groupingBy(
                    order -> order.getDate().getDayOfYear() % 24, // 간단한 시간 시뮬레이션
                    Collectors.counting()
                ));
        
        hourlyOrders.entrySet().stream()
                   .sorted(Map.Entry.comparingByKey())
                   .forEach(entry -> 
                       System.out.printf("%02d시: %d건%n", entry.getKey(), entry.getValue()));
        
        // 5. 고액 주문 분석
        System.out.println("\n5. 고액 주문 분석 (10만원 이상):");
        List<Order> highValueOrders = orders.stream()
                .filter(order -> order.getAmount() >= 100000)
                .sorted(Comparator.comparing(Order::getAmount).reversed())
                .collect(Collectors.toList());
        
        System.out.println("고액 주문 건수: " + highValueOrders.size());
        System.out.println("고액 주문 총액: " + 
            highValueOrders.stream().mapToDouble(Order::getAmount).sum() + "원");
        
        System.out.println("\n상위 5건:");
        highValueOrders.stream()
                      .limit(5)
                      .forEach(System.out::println);
        
        // 6. 성장률 분석
        System.out.println("\n6. 전월 대비 성장률:");
        List<String> months = monthlySales.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
        
        for (int i = 1; i < months.size(); i++) {
            String currentMonth = months.get(i);
            String previousMonth = months.get(i - 1);
            
            double currentSales = monthlySales.get(currentMonth);
            double previousSales = monthlySales.get(previousMonth);
            double growthRate = ((currentSales - previousSales) / previousSales) * 100;
            
            System.out.printf("%s: %.1f%%%n", currentMonth, growthRate);
        }
    }
    
    private static List<Order> generateSampleOrders() {
        Random random = new Random(42); // 재현 가능한 랜덤
        List<Order> orders = new ArrayList<>();
        
        String[] categories = {"전자제품", "의류", "도서", "식품", "생활용품"};
        String[] customers = {"C001", "C002", "C003", "C004", "C005", "C006", "C007", "C008", "C009", "C010"};
        
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        
        for (int i = 0; i < 1000; i++) {
            String orderId = "ORD" + String.format("%04d", i + 1);
            String customerId = customers[random.nextInt(customers.length)];
            String category = categories[random.nextInt(categories.length)];
            double amount = 10000 + random.nextDouble() * 190000; // 1만원 ~ 20만원
            LocalDate date = startDate.plusDays(random.nextInt(365));
            
            orders.add(new Order(orderId, customerId, category, amount, date));
        }
        
        return orders;
    }
}

class Order {
    private String orderId;
    private String customerId;
    private String category;
    private double amount;
    private LocalDate date;
    
    public Order(String orderId, String customerId, String category, double amount, LocalDate date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    
    @Override
    public String toString() {
        return String.format("주문 %s: 고객 %s, %s, %.0f원, %s", 
            orderId, customerId, category, amount, date);
    }
}

class CustomerStats {
    private int orderCount;
    private double totalAmount;
    private double averageAmount;
    
    public CustomerStats(int orderCount, double totalAmount, double averageAmount) {
        this.orderCount = orderCount;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }
    
    public int getOrderCount() { return orderCount; }
    public double getTotalAmount() { return totalAmount; }
    public double getAverageAmount() { return averageAmount; }
}
```

### 예제 5-2: 로그 분석 시스템

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class LogAnalysisSystem {
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}) (\\w+) (.+)"
    );
    
    public static void main(String[] args) {
        List<String> logLines = generateSampleLogs();
        
        LogAnalysisSystem analyzer = new LogAnalysisSystem();
        analyzer.analyzeLogs(logLines);
    }
    
    private void analyzeLogs(List<String> logLines) {
        System.out.println("=== 로그 분석 시스템 ===");
        System.out.println("총 로그 라인 수: " + logLines.size());
        
        // 로그 파싱
        List<LogEntry> logs = logLines.stream()
                .map(this::parseLogLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        
        System.out.println("파싱된 로그 수: " + logs.size());
        
        // 1. 로그 레벨별 통계
        System.out.println("\n1. 로그 레벨별 통계:");
        Map<String, Long> levelStats = logs.stream()
                .collect(Collectors.groupingBy(
                    LogEntry::getLevel,
                    Collectors.counting()
                ));
        
        levelStats.entrySet().stream()
                 .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                 .forEach(entry -> 
                     System.out.printf("%s: %d건%n", entry.getKey(), entry.getValue()));
        
        // 2. 시간대별 로그 분포
        System.out.println("\n2. 시간대별 로그 분포:");
        Map<Integer, Long> hourlyLogs = logs.stream()
                .collect(Collectors.groupingBy(
                    log -> log.getTimestamp().getHour(),
                    Collectors.counting()
                ));
        
        hourlyLogs.entrySet().stream()
                 .sorted(Map.Entry.comparingByKey())
                 .forEach(entry -> 
                     System.out.printf("%02d시: %d건%n", entry.getKey(), entry.getValue()));
        
        // 3. ERROR 로그 분석
        System.out.println("\n3. ERROR 로그 상세 분석:");
        List<LogEntry> errorLogs = logs.stream()
                .filter(log -> "ERROR".equals(log.getLevel()))
                .collect(Collectors.toList());
        
        System.out.println("총 ERROR 수: " + errorLogs.size());
        
        // ERROR 패턴 분석
        Map<String, Long> errorPatterns = errorLogs.stream()
                .map(log -> extractErrorType(log.getMessage()))
                .collect(Collectors.groupingBy(
                    errorType -> errorType,
                    Collectors.counting()
                ));
        
        System.out.println("ERROR 유형별 통계:");
        errorPatterns.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEach(entry -> 
                        System.out.printf("  %s: %d건%n", entry.getKey(), entry.getValue()));
        
        // 4. 성능 이슈 탐지 (연속된 ERROR나 WARN)
        System.out.println("\n4. 성능 이슈 탐지:");
        List<List<LogEntry>> issuePatterns = findConsecutiveIssues(logs);
        
        System.out.println("연속된 이슈 패턴 수: " + issuePatterns.size());
        issuePatterns.stream()
                    .limit(3)
                    .forEach(pattern -> {
                        System.out.printf("이슈 시작: %s, 지속: %d개 로그%n",
                            pattern.get(0).getTimestamp(),
                            pattern.size());
                    });
        
        // 5. 키워드 기반 검색
        System.out.println("\n5. 키워드 검색 결과:");
        searchKeywords(logs, Arrays.asList("exception", "timeout", "failed"));
        
        // 6. 로그 트렌드 분석 (시간당 ERROR 비율)
        System.out.println("\n6. 시간당 ERROR 비율:");
        Map<Integer, Double> errorRates = logs.stream()
                .collect(Collectors.groupingBy(
                    log -> log.getTimestamp().getHour(),
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        hourLogs -> {
                            long errorCount = hourLogs.stream()
                                    .filter(log -> "ERROR".equals(log.getLevel()))
                                    .count();
                            return (double) errorCount / hourLogs.size() * 100;
                        }
                    )
                ));
        
        errorRates.entrySet().stream()
                 .sorted(Map.Entry.comparingByKey())
                 .forEach(entry -> 
                     System.out.printf("%02d시: %.1f%%%n", entry.getKey(), entry.getValue()));
    }
    
    private LogEntry parseLogLine(String line) {
        var matcher = LOG_PATTERN.matcher(line);
        if (matcher.matches()) {
            try {
                LocalDateTime timestamp = LocalDateTime.parse(
                    matcher.group(1), 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                );
                String level = matcher.group(2);
                String message = matcher.group(3);
                return new LogEntry(timestamp, level, message);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
    
    private String extractErrorType(String message) {
        if (message.toLowerCase().contains("nullpointer")) return "NullPointerException";
        if (message.toLowerCase().contains("timeout")) return "TimeoutException";
        if (message.toLowerCase().contains("connection")) return "ConnectionException";
        if (message.toLowerCase().contains("sql")) return "SQLException";
        if (message.toLowerCase().contains("io")) return "IOException";
        return "Other";
    }
    
    private List<List<LogEntry>> findConsecutiveIssues(List<LogEntry> logs) {
        List<List<LogEntry>> issues = new ArrayList<>();
        List<LogEntry> currentIssue = new ArrayList<>();
        
        for (LogEntry log : logs) {
            if ("ERROR".equals(log.getLevel()) || "WARN".equals(log.getLevel())) {
                currentIssue.add(log);
            } else {
                if (currentIssue.size() >= 3) { // 3개 이상 연속된 이슈만 기록
                    issues.add(new ArrayList<>(currentIssue));
                }
                currentIssue.clear();
            }
        }
        
        if (currentIssue.size() >= 3) {
            issues.add(currentIssue);
        }
        
        return issues;
    }
    
    private void searchKeywords(List<LogEntry> logs, List<String> keywords) {
        keywords.forEach(keyword -> {
            long count = logs.stream()
                    .filter(log -> log.getMessage().toLowerCase().contains(keyword.toLowerCase()))
                    .count();
            System.out.printf("'%s': %d건%n", keyword, count);
        });
    }
    
    private static List<String> generateSampleLogs() {
        List<String> logs = new ArrayList<>();
        Random random = new Random(42);
        
        String[] levels = {"INFO", "WARN", "ERROR", "DEBUG"};
        String[] messages = {
            "Application started successfully",
            "User login: user123",
            "Database connection timeout",
            "NullPointerException in UserService",
            "Processing request: /api/users",
            "SQL query executed in 120ms",
            "Connection failed to external service",
            "Cache miss for key: user_123",
            "Memory usage: 75%",
            "IO Exception reading file config.xml"
        };
        
        LocalDateTime baseTime = LocalDateTime.of(2023, 12, 1, 0, 0);
        
        for (int i = 0; i < 1000; i++) {
            LocalDateTime timestamp = baseTime.plusMinutes(random.nextInt(1440)); // 하루 범위
            String level = levels[random.nextInt(levels.length)];
            String message = messages[random.nextInt(messages.length)];
            
            // ERROR 비율을 시간대별로 다르게 조정
            int hour = timestamp.getHour();
            if (hour >= 14 && hour <= 16) { // 오후 2-4시에 ERROR 증가
                if (random.nextDouble() < 0.3) {
                    level = "ERROR";
                }
            }
            
            String logLine = String.format("%s %s %s",
                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                level,
                message
            );
            
            logs.add(logLine);
        }
        
        return logs;
    }
}

class LogEntry {
    private LocalDateTime timestamp;
    private String level;
    private String message;
    
    public LogEntry(LocalDateTime timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getLevel() { return level; }
    public String getMessage() { return message; }
    
    @Override
    public String toString() {
        return String.format("%s %s %s", 
            timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
            level, message);
    }
}
```

이 예제 모음은 스트림 API의 다양한 기능과 실전 활용 방법을 보여줍니다. 각 예제는 점진적으로 복잡해지며, 실제 개발에서 자주 사용되는 패턴들을 포함하고 있습니다.