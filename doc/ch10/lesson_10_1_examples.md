# 10.1 제네릭 프로그래밍 - 예제 모음

## 1. 제네릭 클래스 사용하기

### 예제 1-1: 기본 제네릭 클래스

```java
/**
 * 제네릭 Box 클래스 - 어떤 타입의 객체든 저장 가능
 */
public class GenericBox<T> {
    private T content;
    
    public void put(T item) {
        this.content = item;
    }
    
    public T get() {
        return content;
    }
    
    public boolean isEmpty() {
        return content == null;
    }
    
    public static void main(String[] args) {
        // String을 저장하는 Box
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.put("Hello, Generics!");
        String message = stringBox.get();  // 캐스팅 불필요
        System.out.println("String Box: " + message);
        
        // Integer를 저장하는 Box
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.put(42);
        int number = intBox.get();  // 오토언박싱
        System.out.println("Integer Box: " + number);
        
        // 커스텀 객체를 저장하는 Box
        GenericBox<Person> personBox = new GenericBox<>();
        personBox.put(new Person("홍길동", 25));
        Person person = personBox.get();
        System.out.println("Person Box: " + person);
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return name + " (" + age + "세)";
    }
}
```

### 예제 1-2: 여러 타입 매개변수

```java
/**
 * 키-값 쌍을 저장하는 제네릭 클래스
 */
public class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
    
    public void setValue(V value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
    
    public static void main(String[] args) {
        // 학번과 이름
        Pair<String, String> student = new Pair<>("2024001", "김철수");
        System.out.println("학생: " + student);
        
        // 상품명과 가격
        Pair<String, Double> product = new Pair<>("노트북", 1500000.0);
        System.out.println("상품: " + product);
        
        // 좌표
        Pair<Integer, Integer> coordinate = new Pair<>(10, 20);
        System.out.println("좌표: " + coordinate);
    }
}
```

## 2. 컬렉션 프레임워크 활용

### 예제 2-1: ArrayList 활용

```java
import java.util.*;

public class ArrayListExample {
    
    public static void main(String[] args) {
        // 문자열 리스트
        ArrayList<String> fruits = new ArrayList<>();
        
        // 추가
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        fruits.add(1, "딸기");  // 특정 위치에 추가
        
        System.out.println("과일 목록: " + fruits);
        
        // 접근
        String firstFruit = fruits.get(0);
        System.out.println("첫 번째 과일: " + firstFruit);
        
        // 수정
        fruits.set(2, "키위");
        System.out.println("수정 후: " + fruits);
        
        // 삭제
        fruits.remove("딸기");
        fruits.remove(0);  // 인덱스로 삭제
        System.out.println("삭제 후: " + fruits);
        
        // 검색
        boolean hasOrange = fruits.contains("오렌지");
        int kiwIndex = fruits.indexOf("키위");
        System.out.println("오렌지 있음? " + hasOrange);
        System.out.println("키위의 위치: " + kiwIndex);
        
        // 정렬
        Collections.sort(fruits);
        System.out.println("정렬 후: " + fruits);
        
        // 크기와 비우기
        System.out.println("크기: " + fruits.size());
        fruits.clear();
        System.out.println("비운 후 비어있음? " + fruits.isEmpty());
    }
}
```

### 예제 2-2: HashSet 활용

```java
import java.util.*;

public class HashSetExample {
    
    public static void main(String[] args) {
        // 중복 제거를 위한 Set
        HashSet<String> uniqueWords = new HashSet<>();
        
        String text = "the quick brown fox jumps over the lazy dog the fox";
        String[] words = text.split(" ");
        
        // 단어 추가 (중복 자동 제거)
        for (String word : words) {
            uniqueWords.add(word);
        }
        
        System.out.println("고유한 단어들: " + uniqueWords);
        System.out.println("고유한 단어 수: " + uniqueWords.size());
        
        // 집합 연산
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // 합집합
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("합집합: " + union);
        
        // 교집합
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("교집합: " + intersection);
        
        // 차집합
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("차집합 (set1 - set2): " + difference);
    }
}
```

## 3. Iterator 패턴

### 예제 3-1: Iterator 사용

```java
import java.util.*;

public class IteratorExample {
    
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("C++");
        
        // 방법 1: 기본 Iterator
        System.out.println("=== Iterator 사용 ===");
        Iterator<String> iter = languages.iterator();
        while (iter.hasNext()) {
            String lang = iter.next();
            System.out.println(lang);
            
            // 조건부 삭제
            if (lang.startsWith("J")) {
                iter.remove();  // 안전한 삭제
            }
        }
        
        System.out.println("J로 시작하는 언어 삭제 후: " + languages);
        
        // 방법 2: for-each 루프
        languages.add("Java");
        languages.add("JavaScript");
        
        System.out.println("\n=== for-each 루프 ===");
        for (String lang : languages) {
            System.out.println(lang);
            // languages.remove(lang);  // 오류! ConcurrentModificationException
        }
        
        // 방법 3: ListIterator (양방향)
        System.out.println("\n=== ListIterator 사용 ===");
        ListIterator<String> listIter = languages.listIterator();
        
        // 앞으로 이동
        while (listIter.hasNext()) {
            System.out.println("→ " + listIter.next());
        }
        
        // 뒤로 이동
        while (listIter.hasPrevious()) {
            System.out.println("← " + listIter.previous());
        }
    }
}
```

### 예제 3-2: 커스텀 Iterable 클래스

```java
import java.util.*;

/**
 * Iterator를 구현하는 커스텀 클래스
 */
public class Range implements Iterable<Integer> {
    private int start;
    private int end;
    private int step;
    
    public Range(int start, int end) {
        this(start, end, 1);
    }
    
    public Range(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }
    
    private class RangeIterator implements Iterator<Integer> {
        private int current = start;
        
        @Override
        public boolean hasNext() {
            return step > 0 ? current < end : current > end;
        }
        
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int value = current;
            current += step;
            return value;
        }
    }
    
    public static void main(String[] args) {
        // 0부터 9까지
        System.out.print("Range(0, 10): ");
        for (int i : new Range(0, 10)) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 10부터 0까지 (역순)
        System.out.print("Range(10, 0, -1): ");
        for (int i : new Range(10, 0, -1)) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 0부터 20까지 짝수만
        System.out.print("Range(0, 21, 2): ");
        for (int i : new Range(0, 21, 2)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
```

## 4. 동등성과 비교

### 예제 4-1: equals()와 hashCode() 구현

```java
import java.util.*;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    
    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    // equals() 재정의
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Book book = (Book) obj;
        return isbn.equals(book.isbn);  // ISBN으로 비교
    }
    
    // hashCode() 재정의 (equals()와 일관성 유지)
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
    
    @Override
    public String toString() {
        return String.format("'%s' by %s (%d)", title, author, year);
    }
    
    public static void main(String[] args) {
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018);
        Book book2 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018);
        Book book3 = new Book("978-0135166307", "Clean Code", "Robert Martin", 2008);
        
        // equals() 테스트
        System.out.println("book1.equals(book2): " + book1.equals(book2));  // true
        System.out.println("book1.equals(book3): " + book1.equals(book3));  // false
        
        // HashSet에서 사용
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);  // 중복으로 추가되지 않음
        bookSet.add(book3);
        
        System.out.println("\nHashSet의 책들:");
        for (Book book : bookSet) {
            System.out.println(book);
        }
        
        // contains() 테스트
        Book searchBook = new Book("978-0134685991", "", "", 0);
        System.out.println("\nISBN 978-0134685991 찾기: " + bookSet.contains(searchBook));
    }
}
```

### 예제 4-2: Comparable 구현

```java
import java.util.*;

public class Student implements Comparable<Student> {
    private String studentId;
    private String name;
    private double gpa;
    
    public Student(String studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }
    
    // GPA로 내림차순 정렬 (높은 점수가 먼저)
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.gpa, this.gpa);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s (GPA: %.2f)", studentId, name, gpa);
    }
    
    // Getter 메서드들
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getStudentId() { return studentId; }
    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("2024001", "김철수", 3.8));
        students.add(new Student("2024002", "이영희", 4.2));
        students.add(new Student("2024003", "박민수", 3.5));
        students.add(new Student("2024004", "정지원", 4.0));
        
        System.out.println("정렬 전:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        // Comparable에 의한 정렬 (GPA 내림차순)
        Collections.sort(students);
        
        System.out.println("\nGPA 내림차순 정렬:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
```

### 예제 4-3: Comparator 사용

```java
import java.util.*;

public class ComparatorExample {
    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("2024001", "김철수", 3.8));
        students.add(new Student("2024002", "이영희", 4.2));
        students.add(new Student("2024003", "박민수", 3.5));
        students.add(new Student("2024004", "정지원", 4.0));
        
        // 방법 1: 익명 클래스
        Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
        
        // 방법 2: 람다 표현식
        Comparator<Student> byId = (s1, s2) -> s1.getStudentId().compareTo(s2.getStudentId());
        
        // 방법 3: 메서드 레퍼런스
        Comparator<Student> byGpa = Comparator.comparingDouble(Student::getGpa);
        
        // 방법 4: 복합 정렬
        Comparator<Student> byGpaThenName = Comparator
            .comparingDouble(Student::getGpa).reversed()  // GPA 내림차순
            .thenComparing(Student::getName);             // 이름 오름차순
        
        // 이름으로 정렬
        Collections.sort(students, byName);
        System.out.println("이름순 정렬:");
        students.forEach(System.out::println);
        
        // 학번으로 정렬
        Collections.sort(students, byId);
        System.out.println("\n학번순 정렬:");
        students.forEach(System.out::println);
        
        // 복합 정렬
        Collections.sort(students, byGpaThenName);
        System.out.println("\nGPA 내림차순, 같으면 이름순:");
        students.forEach(System.out::println);
    }
}
```

## 5. 래퍼 클래스와 오토박싱

### 예제 5-1: 오토박싱/언박싱

```java
import java.util.*;

public class WrapperExample {
    
    public static void main(String[] args) {
        // 오토박싱
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);          // int → Integer (오토박싱)
        numbers.add(20);
        numbers.add(30);
        
        // 언박싱
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;           // Integer → int (언박싱)
        }
        System.out.println("합계: " + sum);
        
        // 래퍼 클래스의 유틸리티 메서드
        String binaryStr = Integer.toBinaryString(42);
        String hexStr = Integer.toHexString(42);
        int parsed = Integer.parseInt("123");
        
        System.out.println("42의 이진수: " + binaryStr);
        System.out.println("42의 16진수: " + hexStr);
        System.out.println("파싱된 값: " + parsed);
        
        // null 처리 주의
        Integer nullableInt = null;
        // int value = nullableInt;  // NullPointerException!
        
        // 안전한 처리
        int value = (nullableInt != null) ? nullableInt : 0;
        System.out.println("Nullable 값: " + value);
        
        // 캐싱 효과
        Integer a = 127;
        Integer b = 127;
        System.out.println("a == b (127): " + (a == b));  // true (캐싱)
        
        Integer c = 128;
        Integer d = 128;
        System.out.println("c == d (128): " + (c == d));  // false (캐싱 범위 초과)
        System.out.println("c.equals(d): " + c.equals(d));  // true
    }
}
```

### 예제 5-2: 제네릭과 기본 타입

```java
import java.util.*;

public class GenericPrimitiveExample {
    
    // 제네릭 메서드로 최대값 찾기
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다");
        }
        
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
    
    // 숫자 타입만 받는 제네릭 메서드
    public static <T extends Number> double sum(List<T> numbers) {
        double total = 0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }
    
    public static void main(String[] args) {
        // Integer 리스트
        List<Integer> intList = Arrays.asList(3, 7, 2, 9, 1);
        Integer maxInt = findMax(intList);
        System.out.println("최대 정수: " + maxInt);
        
        // Double 리스트
        List<Double> doubleList = Arrays.asList(3.14, 2.71, 1.41, 4.5);
        Double maxDouble = findMax(doubleList);
        System.out.println("최대 실수: " + maxDouble);
        
        // 합계 계산
        System.out.println("정수 합: " + sum(intList));
        System.out.println("실수 합: " + sum(doubleList));
        
        // 혼합 사용
        List<Number> mixedNumbers = new ArrayList<>();
        mixedNumbers.add(10);      // Integer
        mixedNumbers.add(20.5);    // Double
        mixedNumbers.add(30L);     // Long
        System.out.println("혼합 합: " + sum(mixedNumbers));
    }
}
```

## 6. 제네릭 활용 종합 예제

### 예제 6-1: 학생 성적 관리 시스템

```java
import java.util.*;

public class GradeManagementSystem {
    
    // 학생 클래스
    static class Student {
        private String id;
        private String name;
        private Map<String, Double> grades;
        
        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.grades = new HashMap<>();
        }
        
        public void addGrade(String subject, double grade) {
            grades.put(subject, grade);
        }
        
        public double getAverageGrade() {
            if (grades.isEmpty()) return 0;
            return grades.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
        }
        
        // Getters
        public String getId() { return id; }
        public String getName() { return name; }
        public Map<String, Double> getGrades() { return new HashMap<>(grades); }
        
        @Override
        public String toString() {
            return String.format("%s (%s) - 평균: %.2f", name, id, getAverageGrade());
        }
    }
    
    private Map<String, Student> students;
    private Set<String> subjects;
    
    public GradeManagementSystem() {
        this.students = new HashMap<>();
        this.subjects = new HashSet<>();
    }
    
    // 학생 추가
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }
    
    // 성적 입력
    public void addGrade(String studentId, String subject, double grade) {
        Student student = students.get(studentId);
        if (student != null) {
            student.addGrade(subject, grade);
            subjects.add(subject);
        }
    }
    
    // 과목별 평균
    public double getSubjectAverage(String subject) {
        List<Double> grades = new ArrayList<>();
        for (Student student : students.values()) {
            Double grade = student.getGrades().get(subject);
            if (grade != null) {
                grades.add(grade);
            }
        }
        
        if (grades.isEmpty()) return 0;
        return grades.stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0);
    }
    
    // 상위 N명 학생
    public List<Student> getTopStudents(int n) {
        List<Student> allStudents = new ArrayList<>(students.values());
        allStudents.sort((s1, s2) -> 
            Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));
        
        return allStudents.subList(0, Math.min(n, allStudents.size()));
    }
    
    // 전체 통계
    public void printStatistics() {
        System.out.println("=== 성적 통계 ===");
        System.out.println("전체 학생 수: " + students.size());
        
        System.out.println("\n과목별 평균:");
        for (String subject : subjects) {
            System.out.printf("%s: %.2f%n", subject, getSubjectAverage(subject));
        }
        
        System.out.println("\n상위 3명:");
        List<Student> topStudents = getTopStudents(3);
        for (int i = 0; i < topStudents.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, topStudents.get(i));
        }
    }
    
    public static void main(String[] args) {
        GradeManagementSystem system = new GradeManagementSystem();
        
        // 학생 추가
        Student s1 = new Student("2024001", "김철수");
        Student s2 = new Student("2024002", "이영희");
        Student s3 = new Student("2024003", "박민수");
        Student s4 = new Student("2024004", "정지원");
        
        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);
        system.addStudent(s4);
        
        // 성적 입력
        system.addGrade("2024001", "수학", 85);
        system.addGrade("2024001", "영어", 90);
        system.addGrade("2024001", "과학", 88);
        
        system.addGrade("2024002", "수학", 95);
        system.addGrade("2024002", "영어", 92);
        system.addGrade("2024002", "과학", 94);
        
        system.addGrade("2024003", "수학", 78);
        system.addGrade("2024003", "영어", 85);
        system.addGrade("2024003", "과학", 80);
        
        system.addGrade("2024004", "수학", 88);
        system.addGrade("2024004", "영어", 87);
        system.addGrade("2024004", "과학", 90);
        
        // 통계 출력
        system.printStatistics();
    }
}
```

이러한 예제들은 Java의 제네릭 프로그래밍과 컬렉션 프레임워크의 다양한 활용 방법을 보여줍니다.