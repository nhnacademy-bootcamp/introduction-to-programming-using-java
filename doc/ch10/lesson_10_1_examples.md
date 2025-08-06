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
        // TODO: item을 content에 저장
    }
    
    public T get() {
        // TODO: content를 반환
        return null; // 임시 반환값
    }
    
    public boolean isEmpty() {
        // TODO: content가 null인지 확인
        return true; // 임시 반환값
    }
    
    public static void main(String[] args) {
        // String을 저장하는 Box
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.put("Hello, Generics!");
        
        // Integer를 저장하는 Box
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.put(42);
        
        // 실행 결과:
        // String Box: Hello, Generics!
        // Integer Box: 42
        // Person Box: 홍길동 (25세)
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
        // TODO: key와 value 초기화
    }
    
    public K getKey() {
        // TODO: key 반환
        return null; // 임시 반환값
    }
    
    public V getValue() {
        // TODO: value 반환
        return null; // 임시 반환값
    }
    
    public void setValue(V value) {
        // TODO: value 설정
    }
    
    @Override
    public String toString() {
        // TODO: "(key, value)" 형식으로 문자열 반환
        return ""; // 임시 반환값
    }
    
    public static void main(String[] args) {
        // 실행 결과:
        // 학생: (2024001, 김철수)
        // 상품: (노트북, 1500000.0)
        // 좌표: (10, 20)
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
        
        // TODO: 과일 추가 - "사과", "바나나", "오렌지"
        // TODO: 인덱스 1에 "딸기" 추가
        
        // TODO: 첫 번째 과일 가져오기
        
        // TODO: 인덱스 2의 과일을 "키위"로 변경
        
        // TODO: "딸기" 삭제
        // TODO: 인덱스 0의 과일 삭제
        
        // TODO: "오렌지"가 있는지 확인
        // TODO: "키위"의 인덱스 찾기
        
        // TODO: fruits 리스트 정렬
        
        // 실행 결과:
        // 과일 목록: [사과, 딸기, 바나나, 오렌지]
        // 첫 번째 과일: 사과
        // 수정 후: [사과, 딸기, 키위, 오렌지]
        // 삭제 후: [키위, 오렌지]
        // 오렌지 있음? true
        // 키위의 위치: 0
        // 정렬 후: [오렌지, 키위]
        // 크기: 2
        // 비운 후 비어있음? true
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
        
        // TODO: words 배열의 각 단어를 uniqueWords에 추가
        
        // 집합 연산
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // TODO: set1과 set2의 합집합 구하기
        
        // TODO: set1과 set2의 교집합 구하기
        
        // TODO: set1 - set2 차집합 구하기
        
        // 실행 결과:
        // 고유한 단어들: [over, lazy, the, brown, quick, jumps, dog, fox]
        // 고유한 단어 수: 8
        // 합집합: [1, 2, 3, 4, 5, 6, 7, 8]
        // 교집합: [4, 5]
        // 차집합 (set1 - set2): [1, 2, 3]
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
        
        // TODO: Iterator를 사용하여 모든 언어 출력
        // TODO: "J"로 시작하는 언어는 삭제
        
        // 방법 2: ListIterator (양방향)
        System.out.println("\n=== ListIterator 사용 ===");
        ListIterator<String> listIter = languages.listIterator();
        
        // TODO: 앞으로 이동하며 출력
        
        // TODO: 뒤로 이동하며 출력
        
        // 실행 결과:
        // === Iterator 사용 ===
        // Java
        // Python
        // JavaScript
        // C++
        // J로 시작하는 언어 삭제 후: [Python, C++]
        //
        // === ListIterator 사용 ===
        // → Python
        // → C++
        // ← C++
        // ← Python
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
        // TODO: RangeIterator 인스턴스 반환
        return null; // 임시 반환값
    }
    
    private class RangeIterator implements Iterator<Integer> {
        private int current = start;
        
        @Override
        public boolean hasNext() {
            // TODO: 다음 요소가 있는지 확인
            // 힌트: step이 양수면 current < end, 음수면 current > end
            return false; // 임시 반환값
        }
        
        @Override
        public Integer next() {
            // TODO: 현재 값을 반환하고 current를 step만큼 증가
            // 힌트: hasNext()가 false면 NoSuchElementException 던지기
            return 0; // 임시 반환값
        }
    }
    
    public static void main(String[] args) {
        // 실행 결과:
        // Range(0, 10): 0 1 2 3 4 5 6 7 8 9
        // Range(10, 0, -1): 10 9 8 7 6 5 4 3 2 1
        // Range(0, 21, 2): 0 2 4 6 8 10 12 14 16 18 20
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
        // TODO: equals 메서드 구현
        // 1. 같은 객체인지 확인 (this == obj)
        // 2. null이거나 다른 클래스인지 확인
        // 3. ISBN으로 비교
        
        return false; // 임시 반환값
    }
    
    // hashCode() 재정의 (equals()와 일관성 유지)
    @Override
    public int hashCode() {
        // TODO: ISBN의 hashCode 반환
        return 0; // 임시 반환값
    }
    
    @Override
    public String toString() {
        return String.format("'%s' by %s (%d)", title, author, year);
    }
    
    public static void main(String[] args) {
        // 실행 결과:
        // book1.equals(book2): true
        // book1.equals(book3): false
        //
        // HashSet의 책들:
        // 'Effective Java' by Joshua Bloch (2018)
        // 'Clean Code' by Robert Martin (2008)
        //
        // ISBN 978-0134685991 찾기: true
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
        // TODO: GPA 기준 내림차순 비교
        // 힌트: Double.compare(other.gpa, this.gpa)
        return 0; // 임시 반환값
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
        // 실행 결과:
        // 정렬 전:
        // 2024001: 김철수 (GPA: 3.80)
        // 2024002: 이영희 (GPA: 4.20)
        // 2024003: 박민수 (GPA: 3.50)
        // 2024004: 정지원 (GPA: 4.00)
        //
        // GPA 내림차순 정렬:
        // 2024002: 이영희 (GPA: 4.20)
        // 2024004: 정지원 (GPA: 4.00)
        // 2024001: 김철수 (GPA: 3.80)
        // 2024003: 박민수 (GPA: 3.50)
    }
}
```

## 5. 래퍼 클래스와 오토박싱

### 예제 5-1: 오토박싱/언박싱

```java
import java.util.*;

public class WrapperExample {
    
    /**
     * 리스트의 합계 계산 (오토언박싱 활용)
     */
    public static int calculateSum(List<Integer> numbers) {
        // TODO: 향상된 for 루프를 사용하여 합계 계산
        // 힌트: 오토언박싱이 자동으로 발생
        
        return 0; // 임시 반환값
    }
    
    /**
     * null 안전하게 처리하는 메서드
     */
    public static int safeGetValue(Integer nullableInt, int defaultValue) {
        // TODO: nullableInt가 null이면 defaultValue 반환
        
        return 0; // 임시 반환값
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        // 실행 결과:
        // 합계: 60
        // 42의 이진수: 101010
        // 42의 16진수: 2a
        // 파싱된 값: 123
        // Nullable 값: 0
        // a == b (127): true
        // c == d (128): false
        // c.equals(d): true
    }
}
```

## 6. 제네릭 활용 종합 예제

### 예제 6-1: 간단한 성적 관리 시스템

```java
import java.util.*;

public class SimpleGradeSystem {
    
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
            // TODO: 과목과 성적을 grades Map에 추가
        }
        
        public double getAverageGrade() {
            // TODO: 모든 성적의 평균 계산
            // 힌트: grades가 비어있으면 0 반환
            
            return 0; // 임시 반환값
        }
        
        public String getId() { return id; }
        public String getName() { return name; }
    }
    
    private Map<String, Student> students;
    
    public SimpleGradeSystem() {
        this.students = new HashMap<>();
    }
    
    // 학생 추가
    public void addStudent(Student student) {
        // TODO: students Map에 학생 추가 (ID를 키로 사용)
    }
    
    // 성적 입력
    public void addGrade(String studentId, String subject, double grade) {
        // TODO: 해당 학생을 찾아서 성적 추가
        // 힌트: students.get(studentId) 사용
    }
    
    // 전체 학생 중 최고 평균 성적 학생 찾기
    public Student getTopStudent() {
        // TODO: 모든 학생 중 평균 성적이 가장 높은 학생 반환
        // 힌트: students.values()로 모든 학생 순회
        
        return null; // 임시 반환값
    }
    
    public static void main(String[] args) {
        SimpleGradeSystem system = new SimpleGradeSystem();
        
        // 학생 추가
        Student s1 = new Student("2024001", "김철수");
        Student s2 = new Student("2024002", "이영희");
        Student s3 = new Student("2024003", "박민수");
        
        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);
        
        // 성적 입력
        system.addGrade("2024001", "수학", 85);
        system.addGrade("2024001", "영어", 90);
        
        system.addGrade("2024002", "수학", 95);
        system.addGrade("2024002", "영어", 92);
        
        system.addGrade("2024003", "수학", 78);
        system.addGrade("2024003", "영어", 85);
        
        // 실행 결과:
        // 김철수 평균: 87.5
        // 이영희 평균: 93.5
        // 박민수 평균: 81.5
        // 최고 성적 학생: 이영희
    }
}
```