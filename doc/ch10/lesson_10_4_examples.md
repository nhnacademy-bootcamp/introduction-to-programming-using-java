# 10.4 Java 컬렉션 프레임워크로 프로그래밍하기 - 예제 모음

## 1. 심볼 테이블 구현

### 예제 1-1: 간단한 인터프리터

```java
import java.util.*;
import java.util.regex.*;

public class SimpleInterpreter {
    private Map<String, Double> symbolTable;
    
    public SimpleInterpreter() {
        symbolTable = new HashMap<>();
        // 기본 상수 정의
        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);
    }
    
    // let 명령 처리: let x = 10
    public void executeLet(String command) {
        Pattern pattern = Pattern.compile("let\\s+(\\w+)\\s*=\\s*(.+)");
        Matcher matcher = pattern.matcher(command);
        
        if (matcher.matches()) {
            // TODO 1: matcher에서 변수명(group 1) 추출
            // TODO 2: matcher에서 표현식(group 2) 추출
            
            try {
                // TODO 3: evaluateExpression으로 표현식 평가
                // TODO 4: symbolTable에 변수와 값 저장
                // TODO 5: 결과 출력 (형식: "변수명 = 값")
                
            } catch (Exception e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
    }
    
    // print 명령 처리: print x + 5
    public void executePrint(String command) {
        // TODO 6: "print " 이후의 표현식 추출 (substring 사용)
        
        try {
            // TODO 7: 표현식 평가하여 결과 계산
            // TODO 8: 계산 결과 출력
            
        } catch (Exception e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
    
    // 간단한 표현식 평가 (변수 치환만)
    private double evaluateExpression(String expression) {
        // 변수를 값으로 치환
        for (Map.Entry<String, Double> entry : symbolTable.entrySet()) {
            String var = entry.getKey();
            Double value = entry.getValue();
            expression = expression.replaceAll("\\b" + var + "\\b", 
                                             value.toString());
        }
        
        // 간단한 수식 계산 (실제로는 파서가 필요)
        return evaluateSimpleExpression(expression);
    }
    
    // 매우 간단한 수식 계산 (예시용)
    private double evaluateSimpleExpression(String expr) {
        // 실제 구현에서는 제대로 된 파서 필요
        // 여기서는 JavaScript 엔진 사용 예시
        try {
            javax.script.ScriptEngineManager manager = 
                new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = 
                manager.getEngineByName("JavaScript");
            return ((Number) engine.eval(expr)).doubleValue();
        } catch (Exception e) {
            throw new RuntimeException("수식 평가 실패: " + expr);
        }
    }
    
    public static void main(String[] args) {
        SimpleInterpreter interpreter = new SimpleInterpreter();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("간단한 인터프리터 (quit로 종료)");
        System.out.println("명령: let 변수 = 값, print 표현식");
        
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();
            
            if (command.equals("quit")) break;
            
            if (command.startsWith("let ")) {
                interpreter.executeLet(command);
            } else if (command.startsWith("print ")) {
                interpreter.executePrint(command);
            } else if (command.equals("vars")) {
                // 모든 변수 출력
                System.out.println("정의된 변수:");
                interpreter.symbolTable.forEach((k, v) -> 
                    System.out.println("  " + k + " = " + v));
            } else {
                System.out.println("알 수 없는 명령");
            }
        }
        
        scanner.close();
    }
}
```

### 예제 1-2: 함수 심볼 테이블

```java
import java.util.*;

public class FunctionSymbolTable {
    
    // 함수 정보를 담는 클래스
    static class FunctionInfo {
        String name;
        List<String> parameters;
        String body;
        
        FunctionInfo(String name, List<String> parameters, String body) {
            this.name = name;
            this.parameters = parameters;
            this.body = body;
        }
        
        @Override
        public String toString() {
            return String.format("function %s(%s) { %s }", 
                name, String.join(", ", parameters), body);
        }
    }
    
    private Map<String, FunctionInfo> functions;
    
    public FunctionSymbolTable() {
        functions = new HashMap<>();
        
        // 기본 함수 정의
        defineFunction("abs", Arrays.asList("x"), 
                      "return x < 0 ? -x : x");
        defineFunction("max", Arrays.asList("a", "b"), 
                      "return a > b ? a : b");
    }
    
    // 함수 정의
    public void defineFunction(String name, List<String> params, String body) {
        // TODO 9: functions 맵에 이미 같은 이름의 함수가 있는지 확인
        // TODO 10: 있으면 경고 메시지 출력 ("경고: 함수 [이름] 재정의")
        // TODO 11: FunctionInfo 객체 생성하여 functions 맵에 저장
        
    }
    
    // 함수 호출
    public void callFunction(String name, List<Double> arguments) {
        // TODO 12: functions 맵에서 함수 정보 가져오기
        
        // TODO 13: 함수가 없으면 RuntimeException 던지기
        // 힌트: "정의되지 않은 함수: " + name
        
        // TODO 14: 매개변수 개수와 인자 개수가 다르면 RuntimeException 던지기
        // 힌트: String.format 사용하여 상세한 오류 메시지 생성
        
        // TODO 15: 함수 호출 정보 출력
        // - "함수 호출: " + 함수명 + 인자 리스트
        // - "함수 본문: " + 함수 본문
        
    }
    
    // 모든 함수 목록
    public void listFunctions() {
        System.out.println("정의된 함수:");
        TreeMap<String, FunctionInfo> sorted = new TreeMap<>(functions);
        for (FunctionInfo func : sorted.values()) {
            System.out.println("  " + func);
        }
    }
    
    public static void main(String[] args) {
        FunctionSymbolTable table = new FunctionSymbolTable();
        
        // 함수 정의
        table.defineFunction("square", Arrays.asList("x"), 
                           "return x * x");
        table.defineFunction("add", Arrays.asList("a", "b"), 
                           "return a + b");
        
        // 함수 목록
        table.listFunctions();
        
        // 함수 호출
        System.out.println("\n함수 호출:");
        table.callFunction("square", Arrays.asList(5.0));
        table.callFunction("add", Arrays.asList(3.0, 4.0));
        
        try {
            table.callFunction("unknown", Arrays.asList(1.0));
        } catch (RuntimeException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}
```

## 2. 맵 내부의 집합

### 예제 2-1: 책 인덱스 생성기

```java
import java.util.*;
import java.io.*;

public class BookIndexer {
    private TreeMap<String, TreeSet<Integer>> index;
    private Set<String> stopWords;  // 무시할 단어들
    
    public BookIndexer() {
        index = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        stopWords = new HashSet<>(Arrays.asList(
            "the", "a", "an", "and", "or", "but", "in", "on", 
            "at", "to", "for", "of", "with", "by", "is", "was"
        ));
    }
    
    // 페이지 처리
    public void processPage(int pageNumber, String content) {
        // TODO 16: content를 소문자로 변환하고 단어 단위로 분리
        // 힌트: split("\\W+") 사용
        
        // TODO 17: 각 단어에 대해 처리
        // - 단어 길이가 2보다 크고
        // - stopWords에 포함되지 않은 경우만
        // - addReference 메서드 호출
        
    }
    
    // 참조 추가
    private void addReference(String term, int pageNum) {
        index.computeIfAbsent(term, k -> new TreeSet<>())
             .add(pageNum);
    }
    
    // 인덱스 출력
    public void printIndex() {
        System.out.println("=== 인덱스 ===");
        
        for (Map.Entry<String, TreeSet<Integer>> entry : index.entrySet()) {
            String term = entry.getKey();
            TreeSet<Integer> pages = entry.getValue();
            
            // 최소 2페이지 이상에서 나타난 용어만 출력
            if (pages.size() >= 2) {
                System.out.printf("%-20s ", term);
                
                // 페이지 번호를 범위로 압축
                printCompressedPages(pages);
                System.out.println();
            }
        }
    }
    
    // 연속된 페이지를 범위로 표시
    private void printCompressedPages(TreeSet<Integer> pages) {
        Iterator<Integer> iter = pages.iterator();
        if (!iter.hasNext()) return;
        
        // TODO 18: 첫 번째 페이지를 start와 prev에 저장
        
        while (iter.hasNext()) {
            // TODO 19: 다음 페이지 번호 가져오기
            
            // TODO 20: 현재 페이지가 이전 페이지의 연속이 아니면
            // - start == prev인 경우: 단일 페이지 출력 (예: "5, ")
            // - start != prev인 경우: 범위 출력 (예: "5-7, ")
            // - start를 current로 업데이트
            
            // TODO 21: prev를 current로 업데이트
        }
        
        // TODO 22: 마지막 범위 출력 (쉼표 없이)
        // - start == prev: 단일 페이지
        // - start != prev: 범위
        
    }
    
    // 특정 용어 검색
    public void searchTerm(String term) {
        TreeSet<Integer> pages = index.get(term.toLowerCase());
        
        if (pages == null || pages.isEmpty()) {
            System.out.println("'" + term + "'를 찾을 수 없습니다.");
        } else {
            System.out.print("'" + term + "' 발견 페이지: ");
            printCompressedPages(pages);
            System.out.println(" (총 " + pages.size() + "페이지)");
        }
    }
    
    public static void main(String[] args) {
        BookIndexer indexer = new BookIndexer();
        
        // 샘플 페이지 처리
        indexer.processPage(15, "Java programming is powerful and versatile");
        indexer.processPage(23, "Object-oriented programming with Java");
        indexer.processPage(24, "Java collections framework provides data structures");
        indexer.processPage(25, "The Java programming language is platform independent");
        indexer.processPage(45, "Advanced Java programming techniques");
        indexer.processPage(67, "Java collections include List, Set, and Map");
        indexer.processPage(89, "Programming in Java requires understanding objects");
        
        // 인덱스 출력
        indexer.printIndex();
        
        // 특정 용어 검색
        System.out.println("\n=== 용어 검색 ===");
        indexer.searchTerm("Java");
        indexer.searchTerm("programming");
        indexer.searchTerm("Python");
    }
}
```

### 예제 2-2: 역 인덱스 (Inverted Index)

```java
import java.util.*;

public class InvertedIndex {
    // 문서 ID → 문서 내용
    private Map<Integer, String> documents;
    // 단어 → 문서 ID 집합
    private TreeMap<String, TreeSet<Integer>> index;
    
    public InvertedIndex() {
        documents = new HashMap<>();
        index = new TreeMap<>();
    }
    
    // 문서 추가
    public void addDocument(int docId, String content) {
        documents.put(docId, content);
        
        // 단어 추출 및 인덱싱
        String[] words = content.toLowerCase().split("\\W+");
        for (String word : words) {
            if (!word.isEmpty()) {
                index.computeIfAbsent(word, k -> new TreeSet<>())
                     .add(docId);
            }
        }
    }
    
    // 단일 단어 검색
    public Set<Integer> search(String word) {
        TreeSet<Integer> result = index.get(word.toLowerCase());
        return result != null ? new TreeSet<>(result) : new TreeSet<>();
    }
    
    // AND 검색 (모든 단어를 포함하는 문서)
    public Set<Integer> searchAnd(String... words) {
        if (words.length == 0) return new TreeSet<>();
        
        // TODO 23: 첫 번째 단어로 검색한 결과를 result에 저장
        
        // TODO 24: 나머지 단어들에 대해 반복
        // - 각 단어로 검색한 결과와 result의 교집합 구하기 (retainAll 사용)
        // - result가 비어있으면 반복 중단
        
        return null; // 임시 반환값
    }
    
    // OR 검색 (하나 이상의 단어를 포함하는 문서)
    public Set<Integer> searchOr(String... words) {
        // TODO 25: 빈 TreeSet<Integer> 생성
        
        // TODO 26: 각 단어에 대해 반복
        // - 단어로 검색한 결과를 result에 추가 (addAll 사용)
        
        return null; // 임시 반환값
    }
    
    // NOT 검색 (특정 단어를 포함하지 않는 문서)
    public Set<Integer> searchNot(String word) {
        Set<Integer> allDocs = new TreeSet<>(documents.keySet());
        allDocs.removeAll(search(word));
        return allDocs;
    }
    
    // 검색 결과 출력
    public void printSearchResults(String query, Set<Integer> results) {
        System.out.println("\n검색어: " + query);
        System.out.println("결과: " + results.size() + "개 문서");
        
        for (Integer docId : results) {
            System.out.println("  문서 " + docId + ": " + 
                             documents.get(docId));
        }
    }
    
    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();
        
        // 문서 추가
        index.addDocument(1, "Java is a programming language");
        index.addDocument(2, "Python is also a programming language");
        index.addDocument(3, "Java is platform independent");
        index.addDocument(4, "Python has simple syntax");
        index.addDocument(5, "Both Java and Python are popular");
        
        // 단일 단어 검색
        index.printSearchResults("Java", index.search("Java"));
        
        // AND 검색
        index.printSearchResults("Java AND programming", 
                               index.searchAnd("Java", "programming"));
        
        // OR 검색
        index.printSearchResults("Java OR Python", 
                               index.searchOr("Java", "Python"));
        
        // NOT 검색
        index.printSearchResults("NOT Python", 
                               index.searchNot("Python"));
        
        // 복합 검색: programming AND (Java OR Python)
        Set<Integer> javaOrPython = index.searchOr("Java", "Python");
        Set<Integer> programming = index.search("programming");
        javaOrPython.retainAll(programming);
        index.printSearchResults("programming AND (Java OR Python)", 
                               javaOrPython);
    }
}
```

## 3. Comparator 활용

### 예제 3-1: 다양한 정렬 기준

```java
import java.util.*;

public class ComparatorExamples {
    
    static class Student {
        String name;
        int grade;
        double gpa;
        
        Student(String name, int grade, double gpa) {
            this.name = name;
            this.grade = grade;
            this.gpa = gpa;
        }
        
        @Override
        public String toString() {
            return String.format("%s (학년:%d, GPA:%.2f)", 
                               name, grade, gpa);
        }
    }
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("김철수", 3, 3.5),
            new Student("이영희", 2, 4.0),
            new Student("박민수", 3, 3.8),
            new Student("정수진", 1, 3.9),
            new Student("김영희", 2, 3.7)
        );
        
        // 1. 이름순 정렬
        System.out.println("=== 이름순 정렬 ===");
        TreeSet<Student> byName = new TreeSet<>(
            Comparator.comparing((Student s) -> s.name)
        );
        byName.addAll(students);
        byName.forEach(System.out::println);
        
        // 2. GPA 내림차순 정렬
        System.out.println("\n=== GPA 내림차순 ===");
        TreeSet<Student> byGpaDesc = new TreeSet<>(
            Comparator.comparingDouble((Student s) -> s.gpa).reversed()
        );
        byGpaDesc.addAll(students);
        byGpaDesc.forEach(System.out::println);
        
        // 3. 학년순, 같으면 GPA순
        System.out.println("\n=== 학년순, GPA순 ===");
        TreeSet<Student> byGradeThenGpa = new TreeSet<>(
            Comparator.comparingInt((Student s) -> s.grade)
                      .thenComparingDouble(s -> s.gpa)
                      .reversed()  // 둘 다 내림차순
        );
        byGradeThenGpa.addAll(students);
        byGradeThenGpa.forEach(System.out::println);
        
        // 4. 커스텀 Comparator
        System.out.println("\n=== 이름 길이순, 같으면 알파벳순 ===");
        Comparator<Student> customComparator = (s1, s2) -> {
            int lengthCompare = s1.name.length() - s2.name.length();
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.name.compareTo(s2.name);
        };
        
        TreeSet<Student> byCustom = new TreeSet<>(customComparator);
        byCustom.addAll(students);
        byCustom.forEach(System.out::println);
        
        // 5. null 처리
        System.out.println("\n=== null 처리 ===");
        List<String> withNulls = Arrays.asList("apple", null, "banana", "cherry", null);
        
        // null을 마지막으로
        TreeSet<String> nullsLast = new TreeSet<>(
            Comparator.nullsLast(String::compareTo)
        );
        nullsLast.addAll(withNulls);
        System.out.println("null 마지막: " + nullsLast);
        
        // null을 처음으로
        TreeSet<String> nullsFirst = new TreeSet<>(
            Comparator.nullsFirst(String::compareTo)
        );
        nullsFirst.addAll(withNulls);
        System.out.println("null 처음: " + nullsFirst);
    }
}
```

### 예제 3-2: 대소문자 무시 정렬

```java
import java.util.*;

public class CaseInsensitiveExample {
    
    public static void main(String[] args) {
        // 문제: 기본 정렬은 대문자가 소문자보다 앞
        System.out.println("=== 기본 정렬 ===");
        TreeSet<String> defaultSort = new TreeSet<>();
        defaultSort.addAll(Arrays.asList(
            "Apple", "apple", "Banana", "banana", 
            "Cherry", "cherry", "APPLE"
        ));
        System.out.println(defaultSort);
        
        // 해결 1: CASE_INSENSITIVE_ORDER
        System.out.println("\n=== 대소문자 무시 정렬 ===");
        TreeSet<String> caseInsensitive = new TreeSet<>(
            String.CASE_INSENSITIVE_ORDER
        );
        caseInsensitive.addAll(Arrays.asList(
            "Apple", "apple", "Banana", "banana", 
            "Cherry", "cherry", "APPLE"
        ));
        System.out.println(caseInsensitive);
        System.out.println("크기: " + caseInsensitive.size());
        
        // 해결 2: compareToIgnoreCase
        System.out.println("\n=== compareToIgnoreCase ===");
        TreeSet<String> ignoreCase = new TreeSet<>(
            String::compareToIgnoreCase
        );
        ignoreCase.addAll(Arrays.asList(
            "Apple", "apple", "Banana", "banana", 
            "Cherry", "cherry", "APPLE"
        ));
        System.out.println(ignoreCase);
        
        // 해결 3: 소문자 변환 후 비교 (원본 유지)
        System.out.println("\n=== 소문자 변환 비교 (원본 유지) ===");
        TreeSet<String> lowerCaseCompare = new TreeSet<>(
            Comparator.comparing(String::toLowerCase)
        );
        lowerCaseCompare.addAll(Arrays.asList(
            "Apple", "apple", "Banana", "banana", 
            "Cherry", "cherry", "APPLE"
        ));
        System.out.println(lowerCaseCompare);
        
        // 응용: 한글 정렬
        System.out.println("\n=== 한글 정렬 ===");
        TreeSet<String> korean = new TreeSet<>(
            Collator.getInstance(Locale.KOREAN)
        );
        korean.addAll(Arrays.asList(
            "가나다", "다라마", "나다라", "라마바", "마바사"
        ));
        System.out.println(korean);
    }
}
```

## 4. 단어 개수 세기

### 예제 4-1: 기본 단어 카운터

```java
import java.util.*;
import java.io.*;

public class WordCounter {
    
    // 단어 정보 클래스
    static class WordData implements Comparable<WordData> {
        String word;
        int count;
        
        WordData(String word) {
            this.word = word;
            this.count = 1;
        }
        
        void increment() {
            count++;
        }
        
        // 빈도 내림차순, 같으면 알파벳순
        @Override
        public int compareTo(WordData other) {
            int countCompare = other.count - this.count;
            if (countCompare != 0) return countCompare;
            return this.word.compareTo(other.word);
        }
        
        @Override
        public String toString() {
            return String.format("%-15s %4d", word, count);
        }
    }
    
    private TreeMap<String, WordData> words;
    private int totalWords;
    
    public WordCounter() {
        // 대소문자 무시
        words = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        totalWords = 0;
    }
    
    // 텍스트 처리
    public void processText(String text) {
        // 단어 분리 (알파벳과 숫자만)
        String[] tokens = text.split("[^a-zA-Z0-9]+");
        
        for (String token : tokens) {
            if (!token.isEmpty()) {
                processWord(token.toLowerCase());
            }
        }
    }
    
    // 단어 처리
    private void processWord(String word) {
        totalWords++;
        
        WordData data = words.get(word);
        if (data == null) {
            words.put(word, new WordData(word));
        } else {
            data.increment();
        }
    }
    
    // 알파벳순 출력
    public void printAlphabetical() {
        System.out.println("=== 알파벳순 ===");
        for (WordData data : words.values()) {
            System.out.println(data);
        }
    }
    
    // 빈도순 출력
    public void printByFrequency(int minCount) {
        System.out.println("=== 빈도순 (최소 " + minCount + "회) ===");
        
        // TreeSet으로 정렬
        TreeSet<WordData> sorted = new TreeSet<>(words.values());
        
        for (WordData data : sorted) {
            if (data.count >= minCount) {
                System.out.println(data);
            }
        }
    }
    
    // 통계 출력
    public void printStatistics() {
        System.out.println("\n=== 통계 ===");
        System.out.println("전체 단어 수: " + totalWords);
        System.out.println("고유 단어 수: " + words.size());
        
        if (!words.isEmpty()) {
            // 가장 빈번한 단어
            WordData mostFrequent = Collections.max(
                words.values(), 
                Comparator.comparingInt(w -> w.count)
            );
            System.out.println("가장 빈번한 단어: " + mostFrequent);
            
            // 평균 빈도
            double avgFrequency = (double) totalWords / words.size();
            System.out.printf("평균 빈도: %.2f\n", avgFrequency);
        }
    }
    
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        
        String text = """
            Java is a high-level, class-based, object-oriented 
            programming language that is designed to have as few 
            implementation dependencies as possible. It is a 
            general-purpose programming language intended to let 
            programmers write once, run anywhere (WORA), meaning 
            that compiled Java code can run on all platforms that 
            support Java without the need to recompile.
            """;
        
        counter.processText(text);
        
        counter.printAlphabetical();
        System.out.println();
        counter.printByFrequency(2);
        counter.printStatistics();
    }
}
```

### 예제 4-2: 고급 단어 분석기

```java
import java.util.*;
import java.util.stream.*;

public class AdvancedWordAnalyzer {
    
    private Map<String, Integer> wordFrequency;
    private Map<Integer, Set<String>> frequencyWords;  // 빈도 → 단어들
    private Map<Character, Integer> firstLetterCount;   // 첫 글자 통계
    
    public AdvancedWordAnalyzer() {
        wordFrequency = new HashMap<>();
        frequencyWords = new TreeMap<>(Collections.reverseOrder());
        firstLetterCount = new TreeMap<>();
    }
    
    // 텍스트 분석
    public void analyze(String text) {
        Arrays.stream(text.toLowerCase().split("\\W+"))
              .filter(word -> word.length() > 0)
              .forEach(this::processWord);
        
        // 빈도별 그룹화
        buildFrequencyGroups();
    }
    
    private void processWord(String word) {
        // 빈도 계산
        wordFrequency.merge(word, 1, Integer::sum);
        
        // 첫 글자 통계
        if (!word.isEmpty()) {
            char firstChar = word.charAt(0);
            firstLetterCount.merge(firstChar, 1, Integer::sum);
        }
    }
    
    private void buildFrequencyGroups() {
        frequencyWords.clear();
        
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();
            
            frequencyWords.computeIfAbsent(count, k -> new TreeSet<>())
                         .add(word);
        }
    }
    
    // 상위 N개 단어
    public List<Map.Entry<String, Integer>> getTopWords(int n) {
        return wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(n)
            .collect(Collectors.toList());
    }
    
    // 특정 길이의 단어들
    public Set<String> getWordsByLength(int length) {
        return wordFrequency.keySet().stream()
            .filter(word -> word.length() == length)
            .collect(Collectors.toCollection(TreeSet::new));
    }
    
    // 빈도별 분포
    public void printFrequencyDistribution() {
        System.out.println("=== 빈도 분포 ===");
        
        for (Map.Entry<Integer, Set<String>> entry : frequencyWords.entrySet()) {
            int frequency = entry.getKey();
            Set<String> words = entry.getValue();
            
            System.out.printf("%d회: %d개 단어 ", frequency, words.size());
            
            // 샘플 출력 (최대 5개)
            List<String> sample = words.stream()
                .limit(5)
                .collect(Collectors.toList());
            System.out.println(sample);
        }
    }
    
    // 첫 글자 통계
    public void printFirstLetterStatistics() {
        System.out.println("\n=== 첫 글자 통계 ===");
        
        int total = firstLetterCount.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
        
        firstLetterCount.forEach((letter, count) -> {
            double percentage = (count * 100.0) / total;
            System.out.printf("%c: %3d (%.1f%%)\n", 
                            letter, count, percentage);
        });
    }
    
    // 단어 길이 분포
    public void printLengthDistribution() {
        System.out.println("\n=== 단어 길이 분포 ===");
        
        Map<Integer, Long> lengthCount = wordFrequency.keySet().stream()
            .collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.counting()
            ));
        
        lengthCount.forEach((length, count) -> {
            System.out.printf("%2d글자: %3d개\n", length, count);
        });
    }
    
    public static void main(String[] args) {
        AdvancedWordAnalyzer analyzer = new AdvancedWordAnalyzer();
        
        String text = """
            The Java programming language is a high-level, object-oriented 
            language. Java is designed to be platform independent, which 
            means that Java programs can run on any system that has a 
            Java Virtual Machine. The Java language is strongly typed 
            and has automatic memory management through garbage collection.
            """;
        
        analyzer.analyze(text);
        
        // 상위 10개 단어
        System.out.println("=== 상위 10개 단어 ===");
        analyzer.getTopWords(10).forEach(entry -> 
            System.out.printf("%-15s %d회\n", entry.getKey(), entry.getValue())
        );
        
        // 빈도 분포
        System.out.println();
        analyzer.printFrequencyDistribution();
        
        // 첫 글자 통계
        analyzer.printFirstLetterStatistics();
        
        // 길이 분포
        analyzer.printLengthDistribution();
        
        // 5글자 단어들
        System.out.println("\n=== 5글자 단어들 ===");
        System.out.println(analyzer.getWordsByLength(5));
    }
}
```

## 5. 고급 기법

### 예제 5-1: compute 메서드 활용

```java
import java.util.*;

public class ComputeMethodExamples {
    
    public static void main(String[] args) {
        // 1. compute - 값 계산 및 수정
        System.out.println("=== compute ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 80);
        scores.put("Lee", 90);
        
        // 10점 보너스
        scores.compute("Kim", (k, v) -> (v == null) ? 10 : v + 10);
        scores.compute("Park", (k, v) -> (v == null) ? 10 : v + 10);
        System.out.println(scores);
        
        // 2. computeIfAbsent - 없을 때만 계산
        System.out.println("\n=== computeIfAbsent ===");
        Map<String, List<String>> groups = new HashMap<>();
        
        // 그룹에 멤버 추가
        groups.computeIfAbsent("TeamA", k -> new ArrayList<>()).add("Kim");
        groups.computeIfAbsent("TeamA", k -> new ArrayList<>()).add("Lee");
        groups.computeIfAbsent("TeamB", k -> new ArrayList<>()).add("Park");
        System.out.println(groups);
        
        // 3. computeIfPresent - 있을 때만 계산
        System.out.println("\n=== computeIfPresent ===");
        Map<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1000.0);
        prices.put("Banana", 500.0);
        
        // 10% 할인 (있는 항목만)
        prices.computeIfPresent("Apple", (k, v) -> v * 0.9);
        prices.computeIfPresent("Orange", (k, v) -> v * 0.9);  // 효과 없음
        System.out.println(prices);
        
        // 4. merge - 병합
        System.out.println("\n=== merge ===");
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apple", 10);
        
        // 재고 추가
        inventory.merge("Apple", 5, Integer::sum);   // 10 + 5
        inventory.merge("Banana", 3, Integer::sum);  // 0 + 3
        System.out.println(inventory);
        
        // 5. 실전 예제: 단어 그룹화
        System.out.println("\n=== 단어 그룹화 ===");
        String[] words = {"apple", "apricot", "banana", "berry", "cherry"};
        Map<Character, List<String>> wordsByFirstChar = new HashMap<>();
        
        for (String word : words) {
            char firstChar = word.charAt(0);
            wordsByFirstChar.computeIfAbsent(firstChar, k -> new ArrayList<>())
                           .add(word);
        }
        System.out.println(wordsByFirstChar);
        
        // 6. 복잡한 예제: 성적 통계
        System.out.println("\n=== 성적 통계 ===");
        Map<String, List<Integer>> studentScores = new HashMap<>();
        
        // 점수 추가
        addScore(studentScores, "Kim", 85);
        addScore(studentScores, "Kim", 90);
        addScore(studentScores, "Kim", 88);
        addScore(studentScores, "Lee", 92);
        addScore(studentScores, "Lee", 88);
        
        // 평균 계산
        Map<String, Double> averages = new HashMap<>();
        studentScores.forEach((name, scores2) -> {
            double avg = scores2.stream()
                               .mapToInt(Integer::intValue)
                               .average()
                               .orElse(0.0);
            averages.put(name, avg);
        });
        
        System.out.println("점수들: " + studentScores);
        System.out.println("평균: " + averages);
    }
    
    private static void addScore(Map<String, List<Integer>> map, 
                                String name, int score) {
        map.computeIfAbsent(name, k -> new ArrayList<>()).add(score);
    }
}
```

### 예제 5-2: 중첩 맵 구조

```java
import java.util.*;

public class NestedMapExample {
    
    // 온라인 쇼핑몰 재고 관리
    // 카테고리 → 브랜드 → 제품 → 재고수
    static class InventorySystem {
        private Map<String, Map<String, Map<String, Integer>>> inventory;
        
        public InventorySystem() {
            inventory = new TreeMap<>();
        }
        
        // 제품 추가/수정
        public void updateProduct(String category, String brand, 
                                String product, int quantity) {
            inventory.computeIfAbsent(category, k -> new TreeMap<>())
                    .computeIfAbsent(brand, k -> new TreeMap<>())
                    .put(product, quantity);
        }
        
        // 재고 추가
        public void addStock(String category, String brand, 
                           String product, int quantity) {
            inventory.computeIfAbsent(category, k -> new TreeMap<>())
                    .computeIfAbsent(brand, k -> new TreeMap<>())
                    .merge(product, quantity, Integer::sum);
        }
        
        // 특정 카테고리의 전체 재고
        public int getCategoryTotal(String category) {
            Map<String, Map<String, Integer>> categoryMap = 
                inventory.get(category);
            
            if (categoryMap == null) return 0;
            
            return categoryMap.values().stream()
                .flatMap(brandMap -> brandMap.values().stream())
                .mapToInt(Integer::intValue)
                .sum();
        }
        
        // 브랜드별 제품 수
        public Map<String, Integer> getProductCountByBrand() {
            Map<String, Integer> result = new TreeMap<>();
            
            inventory.values().forEach(categoryMap ->
                categoryMap.forEach((brand, products) ->
                    result.merge(brand, products.size(), Integer::sum)
                )
            );
            
            return result;
        }
        
        // 재고 보고서
        public void printInventoryReport() {
            System.out.println("=== 재고 보고서 ===");
            
            inventory.forEach((category, brands) -> {
                System.out.println("\n카테고리: " + category);
                int categoryTotal = 0;
                
                brands.forEach((brand, products) -> {
                    System.out.println("  브랜드: " + brand);
                    int brandTotal = 0;
                    
                    products.forEach((product, quantity) -> {
                        System.out.printf("    %-20s %3d개\n", 
                                        product, quantity);
                    });
                    
                    brandTotal = products.values().stream()
                        .mapToInt(Integer::intValue).sum();
                    System.out.println("  브랜드 총계: " + brandTotal + "개");
                });
                
                categoryTotal = getCategoryTotal(category);
                System.out.println("카테고리 총계: " + categoryTotal + "개");
            });
        }
        
        // 품절 상품 찾기
        public List<String> findOutOfStock() {
            List<String> outOfStock = new ArrayList<>();
            
            inventory.forEach((category, brands) ->
                brands.forEach((brand, products) ->
                    products.forEach((product, quantity) -> {
                        if (quantity == 0) {
                            outOfStock.add(category + "/" + brand + 
                                         "/" + product);
                        }
                    })
                )
            );
            
            return outOfStock;
        }
    }
    
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        
        // 재고 입력
        system.updateProduct("전자제품", "삼성", "갤럭시S23", 50);
        system.updateProduct("전자제품", "삼성", "갤럭시버즈", 30);
        system.updateProduct("전자제품", "애플", "아이폰14", 40);
        system.updateProduct("전자제품", "애플", "에어팟", 25);
        
        system.updateProduct("의류", "나이키", "운동화", 100);
        system.updateProduct("의류", "나이키", "티셔츠", 80);
        system.updateProduct("의류", "아디다스", "운동화", 90);
        system.updateProduct("의류", "아디다스", "트레이닝복", 0);
        
        // 재고 추가
        system.addStock("전자제품", "삼성", "갤럭시S23", 20);
        
        // 보고서 출력
        system.printInventoryReport();
        
        // 통계
        System.out.println("\n=== 브랜드별 제품 수 ===");
        system.getProductCountByBrand().forEach((brand, count) ->
            System.out.println(brand + ": " + count + "개 제품")
        );
        
        // 품절 상품
        System.out.println("\n=== 품절 상품 ===");
        system.findOutOfStock().forEach(System.out::println);
    }
}
```

이 예제들은 Java 컬렉션 프레임워크의 고급 활용법을 보여줍니다. 심볼 테이블, 맵 내부의 집합, Comparator, 단어 카운팅 등 실제 프로그래밍에서 자주 사용되는 패턴들을 구현했습니다.