# 7.2 배열 처리 - 수업 실습

## 1. 배열 인덱스 처리 예제

### 예제 1-1: 인덱스 범위 오류와 해결

```java
public class IndexBoundaryExamples {
    public static void main(String[] args) {
        // 예제 1: 연속된 중복 찾기
        String[] words = {"apple", "banana", "banana", "cherry", "cherry", "cherry"};
        
        // ❌ 잘못된 방법
        try {
            boolean found = false;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(words[i + 1])) {  // 오류 발생!
                    found = true;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
        
        // TODO: 올바른 방법으로 연속된 중복을 찾는 코드를 작성하세요
        // 힌트: 루프 조건을 words.length - 1로 설정
        boolean hasDuplicate = false;
        
        
        if (!hasDuplicate) {
            System.out.println("연속된 중복이 없습니다.");
        }
    }
}
```

**실행 결과:**
```
오류 발생: Index 6 out of bounds for length 6
중복 발견: banana (인덱스 1, 2)
중복 발견: cherry (인덱스 3, 4)
중복 발견: cherry (인덱스 4, 5)
```

### 예제 1-2: 배열 요소 비교

```java
public class ArrayComparison {
    // TODO: 배열에서 가장 큰 차이를 가진 인접 요소 찾기 메서드를 작성하세요
    // 메서드명: findMaxDifference, 매개변수: int[] numbers
    // 배열 길이가 2 미만이면 "비교할 요소가 부족합니다." 출력
    // 인접한 요소들의 절댓값 차이를 계산하여 최대 차이와 인덱스 출력
    
    
    // TODO: 배열에서 패턴을 찾는 메서드를 작성하세요
    // 메서드명: findPattern, 매개변수: int[] array, int[] pattern
    // pattern이 array보다 길면 "패턴이 배열보다 깁니다." 출력
    // 패턴이 발견되면 위치를 출력, 없으면 "패턴을 찾을 수 없습니다." 출력
    
    
    public static void main(String[] args) {
        int[] values = {10, 15, 8, 23, 19, 30, 12};
        findMaxDifference(values);
        
        System.out.println("\n=== 패턴 검색 ===");
        int[] data = {1, 2, 3, 4, 2, 3, 4, 5, 2, 3};
        int[] pattern = {2, 3, 4};
        findPattern(data, pattern);
    }
}
```

**실행 결과:**
```
최대 차이: 15 (인덱스 2와 3 사이)
값: 8와 23

=== 패턴 검색 ===
패턴 발견 위치: 1
패턴 발견 위치: 4
```

## 2. 부분적으로 채워진 배열 예제

### 예제 2-1: 도서관 시스템

```java
public class LibrarySystem {
    private static class Book {
        String title;
        String author;
        int year;
        boolean isAvailable;
        
        Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.isAvailable = true;
        }
        
        @Override
        public String toString() {
            return String.format("%s - %s (%d) [%s]", 
                title, author, year, isAvailable ? "대출가능" : "대출중");
        }
    }
    
    private Book[] books;
    private int bookCount;
    
    public LibrarySystem(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }
    
    // TODO: 책 추가 메서드를 작성하세요
    // 메서드명: addBook, 매개변수: String title, String author, int year
    // 배열이 가득 찬 경우 "도서관이 가득 찼습니다!" 출력하고 false 반환
    // 성공적으로 추가하면 "책 추가됨: 제목" 출력하고 true 반환
    
    
    // TODO: 책 제거 메서드를 작성하세요 (순서 유지)
    // 메서드명: removeBook, 매개변수: String title
    // 책을 찾지 못하면 "책을 찾을 수 없습니다: 제목" 출력하고 false 반환
    // 뒤의 책들을 앞으로 이동시켜 순서 유지
    // 성공적으로 제거하면 "책 제거됨: 제목" 출력하고 true 반환
    
    
    // TODO: 책 검색 헬퍼 메서드를 작성하세요
    // 메서드명: findBookIndex, 매개변수: String title
    // 대소문자 구분 없이 검색하여 인덱스 반환, 없으면 -1 반환
    
    
    // TODO: 대출 처리 메서드를 작성하세요
    // 메서드명: borrowBook, 매개변수: String title
    // 책이 없거나 이미 대출 중이면 적절한 메시지 출력하고 false 반환
    // 대출 가능하면 "대출 완료: 제목" 출력하고 true 반환
    
    
    // TODO: 반납 처리 메서드를 작성하세요
    // 메서드명: returnBook, 매개변수: String title
    // 책이 없거나 이미 반납된 경우 적절한 메시지 출력하고 false 반환
    // 반납 가능하면 "반납 완료: 제목" 출력하고 true 반환
    
    
    // TODO: 전체 도서 목록 출력 메서드를 작성하세요
    // 메서드명: listAllBooks
    // "=== 도서 목록 (총 X권) ===" 형태로 제목 출력
    // 각 책을 번호와 함께 출력
    
    
    // TODO: 대출 가능한 책만 출력하는 메서드를 작성하세요
    // 메서드명: listAvailableBooks
    // "=== 대출 가능한 도서 ===" 제목 출력
    // 대출 가능한 책들만 출력하고 마지막에 "대출 가능: X권" 출력
    
    
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem(10);
        
        // 책 추가
        library.addBook("자바의 정석", "남궁성", 2020);
        library.addBook("이펙티브 자바", "조슈아 블로크", 2018);
        library.addBook("클린 코드", "로버트 마틴", 2013);
        library.addBook("디자인 패턴", "GoF", 1994);
        
        library.listAllBooks();
        
        // 대출/반납 테스트
        library.borrowBook("자바의 정석");
        library.borrowBook("클린 코드");
        library.borrowBook("자바의 정석");  // 실패
        
        library.listAvailableBooks();
        
        library.returnBook("자바의 정석");
        library.removeBook("디자인 패턴");
        
        library.listAllBooks();
    }
}
```

**실행 결과:**
```
책 추가됨: 자바의 정석
책 추가됨: 이펙티브 자바
책 추가됨: 클린 코드
책 추가됨: 디자인 패턴

=== 도서 목록 (총 4권) ===
1. 자바의 정석 - 남궁성 (2020) [대출가능]
2. 이펙티브 자바 - 조슈아 블로크 (2018) [대출가능]
3. 클린 코드 - 로버트 마틴 (2013) [대출가능]
4. 디자인 패턴 - GoF (1994) [대출가능]
대출 완료: 자바의 정석
대출 완료: 클린 코드
이미 대출 중입니다: 자바의 정석

=== 대출 가능한 도서 ===
- 이펙티브 자바 - 조슈아 블로크 (2018) [대출가능]
- 디자인 패턴 - GoF (1994) [대출가능]
대출 가능: 2권
반납 완료: 자바의 정석
책 제거됨: 디자인 패턴

=== 도서 목록 (총 3권) ===
1. 자바의 정석 - 남궁성 (2020) [대출가능]
2. 이펙티브 자바 - 조슈아 블로크 (2018) [대출가능]
3. 클린 코드 - 로버트 마틴 (2013) [대출중]
```

### 예제 2-2: 동적 크기 조정을 가진 재고 관리

```java
public class InventoryManager {
    private static class Item {
        String name;
        int quantity;
        double price;
        
        Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }
    
    private Item[] items;
    private int itemCount;
    
    public InventoryManager() {
        items = new Item[4];  // 작은 크기로 시작
        itemCount = 0;
    }
    
    // TODO: 항목 추가 메서드를 작성하세요 (자동 크기 조정)
    // 메서드명: addItem, 매개변수: String name, int quantity, double price
    // 이미 존재하는 항목이면 수량만 증가시키고 "기존 항목 수량 증가: 이름" 출력
    // 새 항목이면 배열이 가득 찬 경우 expandArray() 호출 후 추가
    // "새 항목 추가: 이름" 출력
    
    
    // TODO: 배열 크기 확장 메서드를 작성하세요
    // 메서드명: expandArray
    // "배열 크기 확장: 현재크기 -> 새크기" 출력
    // 현재 크기의 2배로 새 배열 생성하고 기존 항목들 복사
    
    
    // TODO: 항목 제거 메서드를 작성하세요
    // 메서드명: removeItem, 매개변수: String name
    // 찾은 항목을 마지막 항목으로 덮어써서 제거 (순서 무관)
    // 배열이 1/4 미만으로 사용되면 shrinkArray() 호출
    // 성공하면 "항목 제거됨: 이름" 출력하고 true 반환
    
    
    // TODO: 배열 크기 축소 메서드를 작성하세요
    // 메서드명: shrinkArray
    // "배열 크기 축소: 현재크기 -> 새크기" 출력
    // 현재 크기의 1/2로 새 배열 생성하고 기존 항목들 복사
    
    
    // TODO: 재고 현황 출력 메서드를 작성하세요
    // 메서드명: printInventory
    // "=== 재고 현황 ===" 제목과 "항목 수: X / 배열 크기: Y" 출력
    // 각 항목의 "이름: 수량개 × 가격원 = 총가격원" 형태로 출력
    // 마지막에 "총 재고 가치: X원" 출력
    
    
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        
        // 항목 추가 (배열 확장 테스트)
        inventory.addItem("노트북", 5, 1200000);
        inventory.addItem("마우스", 20, 30000);
        inventory.addItem("키보드", 15, 80000);
        inventory.addItem("모니터", 8, 350000);
        inventory.addItem("USB", 50, 15000);  // 배열 확장 발생
        
        inventory.printInventory();
        
        // 기존 항목 추가
        inventory.addItem("마우스", 10, 30000);
        
        // 항목 제거
        inventory.removeItem("USB");
        inventory.removeItem("모니터");
        inventory.removeItem("키보드");  // 배열 축소 발생
        
        inventory.printInventory();
    }
}
```

**실행 결과:**
```
새 항목 추가: 노트북
새 항목 추가: 마우스
새 항목 추가: 키보드
새 항목 추가: 모니터
배열 크기 확장: 4 -> 8
새 항목 추가: USB

=== 재고 현황 ===
항목 수: 5 / 배열 크기: 8
- 노트북: 5개 × 1200000원 = 6000000원
- 마우스: 20개 × 30000원 = 600000원
- 키보드: 15개 × 80000원 = 1200000원
- 모니터: 8개 × 350000원 = 2800000원
- USB: 50개 × 15000원 = 750000원
총 재고 가치: 11350000원
기존 항목 수량 증가: 마우스
항목 제거됨: USB
항목 제거됨: 모니터
배열 크기 축소: 8 -> 4
항목 제거됨: 키보드

=== 재고 현황 ===
항목 수: 2 / 배열 크기: 4
- 노트북: 5개 × 1200000원 = 6000000원
- 마우스: 30개 × 30000원 = 900000원
총 재고 가치: 6900000원
```

## 3. Arrays 클래스 활용 예제

### 예제 3-1: Arrays 메서드 종합 활용

```java
import java.util.Arrays;

public class ArraysClassDemo {
    public static void main(String[] args) {
        // 1. Arrays.copyOf 예제
        System.out.println("=== Arrays.copyOf 예제 ===");
        int[] original = {1, 2, 3, 4, 5};
        
        // TODO: Arrays.copyOf를 사용하여 다양한 크기로 배열을 복사하세요
        // 같은 크기, 더 큰 크기(8), 더 작은 크기(3)로 복사
        int[] copy1 = ;
        int[] copy2 = ;
        int[] copy3 = ;
        
        System.out.println("원본: " + Arrays.toString(original));
        System.out.println("복사본: " + Arrays.toString(copy1));
        System.out.println("확장 복사: " + Arrays.toString(copy2));
        System.out.println("축소 복사: " + Arrays.toString(copy3));
        
        // 2. Arrays.fill 예제
        System.out.println("\n=== Arrays.fill 예제 ===");
        // TODO: Arrays.fill을 사용하여 배열을 채우세요
        // 크기 10 배열을 7로 전체 채우기
        int[] array1 = new int[10];
        
        
        // 크기 10 배열의 인덱스 2~7을 99로 부분 채우기
        int[] array2 = new int[10];
        
        
        System.out.println("전체 채우기: " + Arrays.toString(array1));
        System.out.println("부분 채우기: " + Arrays.toString(array2));
        
        // 3. Arrays.sort 예제
        System.out.println("\n=== Arrays.sort 예제 ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("정렬 전: " + Arrays.toString(numbers));
        
        // TODO: Arrays.sort를 사용하여 배열을 정렬하세요
        
        System.out.println("정렬 후: " + Arrays.toString(numbers));
        
        // TODO: 부분 정렬을 구현하세요 (인덱스 2~6만 정렬)
        int[] partial = {5, 2, 8, 6, 1, 9, 4, 3, 7};
        
        System.out.println("부분 정렬: " + Arrays.toString(partial));
        
        // 4. Arrays.binarySearch 예제
        System.out.println("\n=== Arrays.binarySearch 예제 ===");
        int[] sorted = {11, 12, 22, 25, 34, 64, 90};
        
        // TODO: Arrays.binarySearch를 사용하여 값을 검색하세요
        // 25와 30을 검색
        int index1 = ;
        int index2 = ;
        
        System.out.println("25의 위치: " + index1);
        System.out.println("30의 위치: " + index2 + " (음수 = 없음)");
        
        // 5. 문자열 배열 처리
        System.out.println("\n=== 문자열 배열 처리 ===");
        String[] fruits = {"banana", "apple", "cherry", "date", "elderberry"};
        System.out.println("원본: " + Arrays.toString(fruits));
        
        // TODO: 문자열 배열을 정렬하고 "cherry"를 검색하세요
        
        System.out.println("정렬: " + Arrays.toString(fruits));
        
        int fruitIndex = ;
        System.out.println("cherry의 위치: " + fruitIndex);
    }
}
```

**실행 결과:**
```
=== Arrays.copyOf 예제 ===
원본: [1, 2, 3, 4, 5]
복사본: [1, 2, 3, 4, 5]
확장 복사: [1, 2, 3, 4, 5, 0, 0, 0]
축소 복사: [1, 2, 3]

=== Arrays.fill 예제 ===
전체 채우기: [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
부분 채우기: [0, 0, 99, 99, 99, 99, 99, 99, 0, 0]

=== Arrays.sort 예제 ===
정렬 전: [64, 34, 25, 12, 22, 11, 90]
정렬 후: [11, 12, 22, 25, 34, 64, 90]
부분 정렬: [5, 2, 1, 3, 4, 6, 8, 9, 7]

=== Arrays.binarySearch 예제 ===
25의 위치: 3
30의 위치: -5 (음수 = 없음)

=== 문자열 배열 처리 ===
원본: [banana, apple, cherry, date, elderberry]
정렬: [apple, banana, cherry, date, elderberry]
cherry의 위치: 2
```

### 예제 3-2: 실용적인 Arrays 활용

```java
import java.util.Arrays;

public class PracticalArraysUsage {
    // TODO: 배열 통계 계산 메서드를 작성하세요
    // 메서드명: arrayStatistics, 매개변수: int[] data
    // 원본을 복사하여 정렬하고 최소값, 최대값, 중앙값을 출력
    // 중앙값: 짝수 길이면 중간 두 값의 평균, 홀수 길이면 중간값
    
    
    // TODO: 배열에서 중복 제거 메서드를 작성하세요
    // 메서드명: removeDuplicates, 매개변수: int[] array
    // 정렬된 복사본을 만들고 중복이 아닌 요소만 세어서 새 배열 생성
    // 중복 제거된 배열을 반환
    
    
    // TODO: 두 배열 병합 메서드를 작성하세요
    // 메서드명: mergeArrays, 매개변수: int[] arr1, int[] arr2
    // System.arraycopy를 사용하여 두 배열을 병합한 새 배열 반환
    
    
    public static void main(String[] args) {
        // 통계 테스트
        int[] testData = {45, 23, 67, 89, 12, 34, 56, 78, 90, 23};
        arrayStatistics(testData);
        
        // 중복 제거 테스트
        System.out.println("\n=== 중복 제거 ===");
        int[] withDuplicates = {5, 2, 8, 2, 9, 5, 1, 8, 3};
        int[] unique = removeDuplicates(withDuplicates);
        System.out.println("원본: " + Arrays.toString(withDuplicates));
        System.out.println("중복 제거: " + Arrays.toString(unique));
        
        // 배열 병합 테스트
        System.out.println("\n=== 배열 병합 ===");
        int[] first = {1, 3, 5, 7};
        int[] second = {2, 4, 6, 8};
        int[] merged = mergeArrays(first, second);
        System.out.println("병합 결과: " + Arrays.toString(merged));
        Arrays.sort(merged);
        System.out.println("정렬된 병합: " + Arrays.toString(merged));
    }
}
```

**실행 결과:**
```
원본 데이터: [45, 23, 67, 89, 12, 34, 56, 78, 90, 23]
정렬된 데이터: [12, 23, 23, 34, 45, 56, 67, 78, 89, 90]
최소값: 12
최대값: 90
중앙값: 50.5

=== 중복 제거 ===
원본: [5, 2, 8, 2, 9, 5, 1, 8, 3]
중복 제거: [1, 2, 3, 5, 8, 9]

=== 배열 병합 ===
병합 결과: [1, 3, 5, 7, 2, 4, 6, 8]
정렬된 병합: [1, 2, 3, 4, 5, 6, 7, 8]
```

## 4. 병렬 배열 vs 객체 배열 예제

### 예제 4-1: 학생 관리 시스템 비교

```java
import java.util.Arrays;

public class StudentManagementComparison {
    // 방법 1: 병렬 배열 사용
    static class ParallelArrayApproach {
        private String[] names;
        private int[] studentIds;
        private double[] gpas;
        private String[] majors;
        private int studentCount;
        
        public ParallelArrayApproach(int capacity) {
            names = new String[capacity];
            studentIds = new int[capacity];
            gpas = new double[capacity];
            majors = new String[capacity];
            studentCount = 0;
        }
        
        // TODO: 학생 추가 메서드를 작성하세요
        // 메서드명: addStudent
        // 매개변수: String name, int id, double gpa, String major
        // 배열이 가득 찬 경우 "배열이 가득 찼습니다!" 출력하고 종료
        
        
        // TODO: 학생 목록 출력 메서드를 작성하세요
        // 메서드명: printStudents
        // "=== 병렬 배열 방식 ===" 제목 출력
        // 각 학생을 "번호. 이름 (ID: 학번, GPA: 평점, 전공: 전공명)" 형태로 출력
        
        
        // TODO: 평균 GPA 계산 메서드를 작성하세요
        // 메서드명: getAverageGPA
        // 학생이 없으면 0.0 반환, 있으면 GPA 평균 반환
        
    }
    
    // 방법 2: 객체 배열 사용
    static class ObjectArrayApproach {
        static class Student {
            String name;
            int studentId;
            double gpa;
            String major;
            
            Student(String name, int id, double gpa, String major) {
                this.name = name;
                this.studentId = id;
                this.gpa = gpa;
                this.major = major;
            }
            
            @Override
            public String toString() {
                return String.format("%s (ID: %d, GPA: %.2f, 전공: %s)",
                    name, studentId, gpa, major);
            }
        }
        
        private Student[] students;
        private int studentCount;
        
        public ObjectArrayApproach(int capacity) {
            students = new Student[capacity];
            studentCount = 0;
        }
        
        // TODO: 학생 추가 메서드를 작성하세요
        // 메서드명: addStudent
        // 매개변수: String name, int id, double gpa, String major
        // 배열이 가득 찬 경우 Arrays.copyOf로 크기를 2배로 확장
        
        
        // TODO: 학생 목록 출력 메서드를 작성하세요
        // 메서드명: printStudents
        // "\n=== 객체 배열 방식 ===" 제목 출력
        // 각 학생을 toString()으로 출력
        
        
        // TODO: 평균 GPA 계산 메서드를 작성하세요
        // 메서드명: getAverageGPA
        // 학생이 없으면 0.0 반환, 있으면 GPA 평균 반환
        
        
        // TODO: 특정 전공 학생들 필터링 메서드를 작성하세요
        // 메서드명: getStudentsByMajor, 매개변수: String major
        // 해당 전공 학생들만 담은 새 배열 반환
        
    }
    
    public static void main(String[] args) {
        // 병렬 배열 테스트
        ParallelArrayApproach parallel = new ParallelArrayApproach(5);
        parallel.addStudent("김철수", 20210001, 3.8, "컴퓨터공학");
        parallel.addStudent("이영희", 20210002, 4.0, "전자공학");
        parallel.addStudent("박민수", 20210003, 3.5, "컴퓨터공학");
        
        parallel.printStudents();
        System.out.printf("평균 GPA: %.2f\n", parallel.getAverageGPA());
        
        // 객체 배열 테스트
        ObjectArrayApproach object = new ObjectArrayApproach(3);
        object.addStudent("김철수", 20210001, 3.8, "컴퓨터공학");
        object.addStudent("이영희", 20210002, 4.0, "전자공학");
        object.addStudent("박민수", 20210003, 3.5, "컴퓨터공학");
        object.addStudent("최지은", 20210004, 3.9, "전자공학");  // 자동 확장
        
        object.printStudents();
        System.out.printf("평균 GPA: %.2f\n", object.getAverageGPA());
        
        // 전공별 필터링 (객체 배열의 장점)
        System.out.println("\n=== 컴퓨터공학 전공 학생들 ===");
        ObjectArrayApproach.Student[] csStudents = object.getStudentsByMajor("컴퓨터공학");
        for (ObjectArrayApproach.Student s : csStudents) {
            System.out.println(s);
        }
    }
}
```

**실행 결과:**
```
=== 병렬 배열 방식 ===
1. 김철수 (ID: 20210001, GPA: 3.80, 전공: 컴퓨터공학)
2. 이영희 (ID: 20210002, GPA: 4.00, 전공: 전자공학)
3. 박민수 (ID: 20210003, GPA: 3.50, 전공: 컴퓨터공학)
평균 GPA: 3.77

=== 객체 배열 방식 ===
1. 김철수 (ID: 20210001, GPA: 3.80, 전공: 컴퓨터공학)
2. 이영희 (ID: 20210002, GPA: 4.00, 전공: 전자공학)
3. 박민수 (ID: 20210003, GPA: 3.50, 전공: 컴퓨터공학)
4. 최지은 (ID: 20210004, GPA: 3.90, 전공: 전자공학)
평균 GPA: 3.80

=== 컴퓨터공학 전공 학생들 ===
김철수 (ID: 20210001, GPA: 3.80, 전공: 컴퓨터공학)
박민수 (ID: 20210003, GPA: 3.50, 전공: 컴퓨터공학)
```

## 5. 동적 배열 구현 예제

### 예제 5-1: 제네릭 동적 배열

```java
public class GenericDynamicArray<T> {
    private Object[] items;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public GenericDynamicArray() {
        items = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    // TODO: 요소 추가 메서드를 작성하세요
    // 메서드명: add, 매개변수: T item
    // ensureCapacity() 호출 후 요소를 배열 끝에 추가
    
    
    // TODO: 특정 위치에 요소 삽입 메서드를 작성하세요
    // 메서드명: insert, 매개변수: int index, T item
    // 인덱스가 범위를 벗어나면 IndexOutOfBoundsException 던지기
    // ensureCapacity() 호출 후 요소들을 뒤로 이동시키고 삽입
    
    
    // TODO: 요소 가져오기 메서드를 작성하세요
    // 메서드명: get, 매개변수: int index
    // 인덱스 검사 후 해당 요소를 T 타입으로 캐스팅하여 반환
    
    
    // TODO: 요소 설정 메서드를 작성하세요
    // 메서드명: set, 매개변수: int index, T item
    // 인덱스 검사 후 해당 위치의 요소를 교체
    
    
    // TODO: 요소 제거 메서드를 작성하세요
    // 메서드명: remove, 매개변수: int index
    // 인덱스 검사 후 해당 요소 제거하고 뒤의 요소들을 앞으로 이동
    // 배열이 1/4 미만으로 사용되면 resize(items.length / 2) 호출
    // 제거된 요소를 T 타입으로 반환
    
    
    // TODO: 크기 반환, 비어있는지 확인, 모든 요소 제거 메서드들을 작성하세요
    // 메서드명: size(), isEmpty(), clear()
    
    
    // TODO: 용량 확보 메서드를 작성하세요
    // 메서드명: ensureCapacity
    // size가 items.length와 같으면 resize(items.length * 2) 호출
    
    
    // TODO: 크기 조정 메서드를 작성하세요
    // 메서드명: resize, 매개변수: int newCapacity
    // 새 배열을 생성하고 기존 요소들을 복사
    // "배열 크기 조정: X" 메시지 출력
    
    
    // TODO: 인덱스 검사 메서드를 작성하세요
    // 메서드명: checkIndex, 매개변수: int index
    // 범위를 벗어나면 IndexOutOfBoundsException 던지기
    
    
    // TODO: toString 메서드를 작성하세요
    // 빈 배열이면 "[]" 반환
    // 그렇지 않으면 "[요소1, 요소2, ...]" 형태로 반환
    
    
    // 테스트
    public static void main(String[] args) {
        // 문자열 동적 배열
        GenericDynamicArray<String> strings = new GenericDynamicArray<>();
        
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        System.out.println("문자열 배열: " + strings);
        
        strings.insert(1, "Beautiful");
        System.out.println("삽입 후: " + strings);
        
        strings.remove(2);
        System.out.println("제거 후: " + strings);
        
        // 정수 동적 배열
        GenericDynamicArray<Integer> numbers = new GenericDynamicArray<>();
        
        for (int i = 1; i <= 15; i++) {
            numbers.add(i * i);  // 제곱수 추가
        }
        System.out.println("\n정수 배열: " + numbers);
        
        System.out.println("5번째 요소: " + numbers.get(4));
        numbers.set(4, 999);
        System.out.println("수정 후: " + numbers);
    }
}
```

**실행 결과:**
```
문자열 배열: [Hello, World, Java]
삽입 후: [Hello, Beautiful, World, Java]
제거 후: [Hello, Beautiful, Java]

배열 크기 조정: 20
정수 배열: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225]
5번째 요소: 25
수정 후: [1, 4, 9, 16, 999, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225]
```

### 예제 5-2: 특화된 동적 배열 - 문자열 빌더

```java
import java.util.Arrays;

public class DynamicStringArray {
    private String[] words;
    private int wordCount;
    
    public DynamicStringArray() {
        words = new String[8];
        wordCount = 0;
    }
    
    // TODO: 단어 추가 메서드를 작성하세요
    // 메서드명: addWord, 매개변수: String word
    // 배열이 가득 찬 경우 Arrays.copyOf로 크기를 2배로 확장
    
    
    // TODO: 여러 단어 한 번에 추가 메서드를 작성하세요
    // 메서드명: addWords, 매개변수: String... newWords
    // 가변 인수로 받은 단어들을 addWord로 하나씩 추가
    
    
    // TODO: 문장으로 추가 메서드를 작성하세요
    // 메서드명: addSentence, 매개변수: String sentence
    // 문장을 공백으로 분리(split("\\s+"))하여 addWords 호출
    
    
    // TODO: 특정 패턴의 단어 찾기 메서드를 작성하세요
    // 메서드명: findWordsMatching, 매개변수: String pattern
    // 정규식 패턴에 매칭되는 단어들을 배열로 반환
    // String.matches(pattern) 사용
    
    
    // TODO: 단어 빈도수 출력 메서드를 작성하세요
    // 메서드명: printWordFrequency
    // 단어가 없으면 "단어가 없습니다." 출력
    // Arrays.copyOf와 Arrays.sort로 정렬된 복사본 생성
    // 연속된 같은 단어의 개수를 세어서 "단어: X회" 형태로 출력
    
    
    // TODO: 모든 단어를 하나의 문자열로 결합하는 메서드를 작성하세요
    // 메서드명: join, 매개변수: String separator
    // StringBuilder를 사용하여 구분자로 단어들을 연결
    
    
    // TODO: 통계 정보 출력 메서드를 작성하세요
    // 메서드명: printStatistics
    // 총 단어 수, 배열 용량, 사용률(%), 평균 단어 길이, 가장 긴 단어 출력
    
    
    public static void main(String[] args) {
        DynamicStringArray dsa = new DynamicStringArray();
        
        // 단어 추가
        dsa.addWords("Java", "Python", "JavaScript", "Java", "C++");
        dsa.addSentence("Java is a popular programming language");
        dsa.addWord("Java");
        
        // 전체 단어 출력
        System.out.println("모든 단어: " + dsa.join(", "));
        
        // 빈도수 분석
        dsa.printWordFrequency();
        
        // 패턴 매칭
        System.out.println("\n=== 'Java'로 시작하는 단어 ===");
        String[] javaWords = dsa.findWordsMatching("Java.*");
        System.out.println(Arrays.toString(javaWords));
        
        // 통계
        dsa.printStatistics();
    }
}
```

**실행 결과:**
```
모든 단어: Java, Python, JavaScript, Java, C++, Java, is, a, popular, programming, language, Java

=== 단어 빈도수 ===
C++: 1회
Java: 4회
JavaScript: 1회
Python: 1회
a: 1회
is: 1회
language: 1회
popular: 1회
programming: 1회

=== 'Java'로 시작하는 단어 ===
[Java, JavaScript, Java, Java, Java]

=== 통계 정보 ===
총 단어 수: 12
배열 용량: 16
사용률: 75.0%
평균 단어 길이: 5.0
가장 긴 단어: programming (11글자)
```

이 예제들은 배열 처리의 다양한 측면을 연습할 수 있도록 구성되었습니다. 인덱스 범위 관리, 부분적으로 채워진 배열, Arrays 클래스 활용, 그리고 동적 배열 구현까지 실제 프로그래밍에서 자주 사용되는 패턴들을 각 TODO 주석을 참고하여 완성해보세요!