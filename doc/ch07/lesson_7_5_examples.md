# 7.5 검색과 정렬 - 수업 실습

## 1. 검색 알고리즘 예제

### 예제 1-1: 선형 검색 (Linear Search)

```java
public class LinearSearchExample {
    public static void main(String[] args) {
        int[] numbers = {45, 23, 67, 12, 89, 34, 78};
        String[] names = {"김철수", "이영희", "박민수", "최지영", "홍길동"};
        
        // 숫자 검색
        int target = 67;
        int index = linearSearch(numbers, target);
        System.out.println(target + "의 위치: " + index);
        
        // 문자열 검색
        String targetName = "박민수";
        int nameIndex = linearSearchString(names, targetName);
        System.out.println(targetName + "의 위치: " + nameIndex);
        
        // 존재하지 않는 값 검색
        int notFound = linearSearch(numbers, 100);
        System.out.println("100의 위치: " + notFound + " (없음)");
    }
    
    // TODO: 정수 배열에서 선형 검색 메서드를 작성하세요
    // 메서드명: linearSearch, 매개변수: int[] array, int target
    // 반환값: 찾은 요소의 인덱스, 없으면 -1
    // 힌트: for 루프로 배열을 순차적으로 탐색
    public static int linearSearch(int[] array, int target) {
        
    }
    
    // TODO: 문자열 배열에서 선형 검색 메서드를 작성하세요
    // 메서드명: linearSearchString, 매개변수: String[] array, String target
    // 반환값: 찾은 요소의 인덱스, 없으면 -1
    // 힌트: String 비교시 equals() 메서드 사용
    public static int linearSearchString(String[] array, String target) {
        
    }
}
```

**실행 결과:**
```
67의 위치: 2
박민수의 위치: 2
100의 위치: -1 (없음)
```

### 예제 1-2: 이진 검색 (Binary Search)

```java
import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] numbers = {12, 23, 34, 45, 56, 67, 78, 89, 90};  // 정렬된 배열
        
        System.out.println("배열: " + Arrays.toString(numbers));
        
        // 다양한 값 검색
        int[] targets = {45, 78, 12, 90, 100, 1};
        
        for (int target : targets) {
            int index = binarySearch(numbers, target);
            System.out.printf("%d의 위치: %d%s\n", 
                target, index, (index == -1 ? " (없음)" : ""));
        }
        
        // Java 내장 이진 검색과 비교
        System.out.println("\n=== Java 내장 메서드와 비교 ===");
        for (int target : targets) {
            int ourResult = binarySearch(numbers, target);
            int javaResult = Arrays.binarySearch(numbers, target);
            System.out.printf("%d: 우리구현=%d, Java=%d\n", 
                target, ourResult, javaResult);
        }
    }
    
    // TODO: 이진 검색 메서드를 작성하세요
    // 메서드명: binarySearch, 매개변수: int[] array, int target
    // 전제조건: 배열이 정렬되어 있어야 함
    // 반환값: 찾은 요소의 인덱스, 없으면 -1
    public static int binarySearch(int[] array, int target) {
        // TODO: left와 right 변수를 초기화하세요
        int left = ;
        int right = ;
        
        // TODO: left가 right보다 작거나 같을 때까지 반복
        while () {
            // TODO: 중간 인덱스를 계산하세요
            int middle = ;
            
            System.out.printf("  검색 범위: [%d, %d], 중간값: %d\n", 
                left, right, array[middle]);
            
            // TODO: 중간값이 찾는 값과 같으면 middle 반환
            if () {
                
            }
            // TODO: 중간값이 찾는 값보다 크면 왼쪽 절반 검색
            else if () {
                
            }
            // TODO: 그렇지 않으면 오른쪽 절반 검색
            else {
                
            }
        }
        
        return -1;  // 찾지 못함
    }
}
```

**실행 결과:**
```
배열: [12, 23, 34, 45, 56, 67, 78, 89, 90]
  검색 범위: [0, 8], 중간값: 56
  검색 범위: [0, 3], 중간값: 23
  검색 범위: [2, 3], 중간값: 34
  검색 범위: [3, 3], 중간값: 45
45의 위치: 3

=== Java 내장 메서드와 비교 ===
45: 우리구현=3, Java=3
78: 우리구현=6, Java=6
12: 우리구현=0, Java=0
90: 우리구현=8, Java=8
100: 우리구현=-1, Java=-9
1: 우리구현=-1, Java=-1
```

### 예제 1-3: 조건부 검색

```java
public class ConditionalSearchExample {
    static class Student {
        String name;
        int score;
        String major;
        
        Student(String name, int score, String major) {
            this.name = name;
            this.score = score;
            this.major = major;
        }
        
        @Override
        public String toString() {
            return String.format("%s(%d점, %s)", name, score, major);
        }
    }
    
    public static void main(String[] args) {
        Student[] students = {
            new Student("김철수", 85, "컴퓨터공학"),
            new Student("이영희", 92, "수학"),
            new Student("박민수", 78, "컴퓨터공학"),
            new Student("최지영", 95, "물리학"),
            new Student("홍길동", 88, "컴퓨터공학")
        };
        
        // 이름으로 학생 찾기
        Student found = findStudentByName(students, "이영희");
        System.out.println("찾은 학생: " + found);
        
        // 90점 이상인 학생들 찾기
        Student[] highScorers = findStudentsByScore(students, 90);
        System.out.println("\n90점 이상 학생들:");
        for (Student s : highScorers) {
            System.out.println("  " + s);
        }
        
        // 컴퓨터공학과 학생들 찾기
        Student[] csStudents = findStudentsByMajor(students, "컴퓨터공학");
        System.out.println("\n컴퓨터공학과 학생들:");
        for (Student s : csStudents) {
            System.out.println("  " + s);
        }
    }
    
    // TODO: 이름으로 학생 찾기 메서드를 작성하세요
    // 메서드명: findStudentByName, 매개변수: Student[] students, String name
    // 반환값: 찾은 Student 객체, 없으면 null
    public static Student findStudentByName(Student[] students, String name) {
        
    }
    
    // TODO: 최소 점수 이상인 학생들 찾기 메서드를 작성하세요
    // 메서드명: findStudentsByScore, 매개변수: Student[] students, int minScore
    // 반환값: 조건을 만족하는 Student 배열
    // 힌트: 먼저 조건을 만족하는 학생 수를 세고, 배열을 생성한 후 채우기
    public static Student[] findStudentsByScore(Student[] students, int minScore) {
        // TODO: 먼저 조건을 만족하는 학생 수를 세세요
        int count = 0;
        
        
        // TODO: 결과 배열을 생성하세요
        Student[] result = new Student[count];
        
        // TODO: 조건을 만족하는 학생들을 결과 배열에 추가하세요
        int index = 0;
        
        
        return result;
    }
    
    // TODO: 전공으로 학생들 찾기 메서드를 작성하세요
    // 메서드명: findStudentsByMajor, 매개변수: Student[] students, String major
    // 반환값: 해당 전공의 Student 배열
    public static Student[] findStudentsByMajor(Student[] students, String major) {
        // TODO: 조건을 만족하는 학생 수 세기
        int count = 0;
        
        
        // TODO: 결과 배열 생성 및 채우기
        Student[] result = new Student[count];
        int index = 0;
        
        
        return result;
    }
}
```

**실행 결과:**
```
찾은 학생: 이영희(92점, 수학)

90점 이상 학생들:
  이영희(92점, 수학)
  최지영(95점, 물리학)

컴퓨터공학과 학생들:
  김철수(85점, 컴퓨터공학)
  박민수(78점, 컴퓨터공학)
  홍길동(88점, 컴퓨터공학)
```

## 2. 연관 리스트 예제

### 예제 2-1: 전화번호부

```java
import java.util.Scanner;

public class PhoneBookExample {
    static class PhoneEntry {
        String name;
        String phone;
        String email;
        
        PhoneEntry(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
        
        @Override
        public String toString() {
            return String.format("%-10s | %-15s | %s", name, phone, email);
        }
    }
    
    static class PhoneBook {
        private PhoneEntry[] entries;
        private int count;
        
        public PhoneBook(int capacity) {
            entries = new PhoneEntry[capacity];
            count = 0;
        }
        
        // TODO: 연락처 추가 메서드를 작성하세요
        // 매개변수: String name, String phone, String email
        // 반환값: 성공하면 true, 실패하면 false
        // 조건: 전화번호부가 가득 차거나 중복 이름이 있으면 실패
        public boolean addContact(String name, String phone, String email) {
            // TODO: 배열이 가득 찼는지 확인
            if () {
                System.out.println("전화번호부가 가득 찼습니다.");
                return false;
            }
            
            // TODO: 중복 이름 확인
            if () {
                System.out.println("이미 존재하는 이름입니다: " + name);
                return false;
            }
            
            // TODO: 새 연락처 추가
            
            return true;
        }
        
        // TODO: 이름으로 검색하는 메서드를 작성하세요
        // 매개변수: String name
        // 반환값: 찾은 PhoneEntry 객체, 없으면 null
        public PhoneEntry findByName(String name) {
            
        }
        
        // TODO: 전화번호로 검색하는 메서드를 작성하세요
        // 매개변수: String phone
        // 반환값: 찾은 PhoneEntry 객체, 없으면 null
        public PhoneEntry findByPhone(String phone) {
            
        }
        
        // TODO: 연락처 수정 메서드를 작성하세요
        // 매개변수: String name, String newPhone, String newEmail
        // 반환값: 성공하면 true, 실패하면 false
        public boolean updateContact(String name, String newPhone, String newEmail) {
            // TODO: 이름으로 연락처를 찾고 수정하세요
            
        }
        
        // TODO: 연락처 삭제 메서드를 작성하세요
        // 매개변수: String name
        // 반환값: 성공하면 true, 실패하면 false
        // 힌트: 삭제 후 뒤의 요소들을 앞으로 이동시켜야 함
        public boolean deleteContact(String name) {
            // TODO: 삭제할 연락처를 찾으세요
            for (int i = 0; i < count; i++) {
                if () {
                    // TODO: 뒤의 항목들을 앞으로 이동시키세요
                    for (int j = i; j < count - 1; j++) {
                        
                    }
                    // TODO: count를 줄이고 마지막 참조를 null로 설정
                    
                    return true;
                }
            }
            return false;
        }
        
        // 전체 목록 출력
        public void printAll() {
            if (count == 0) {
                System.out.println("전화번호부가 비어있습니다.");
                return;
            }
            
            System.out.println("=== 전화번호부 ===");
            System.out.println("이름       | 전화번호        | 이메일");
            System.out.println("----------------------------------------");
            for (int i = 0; i < count; i++) {
                System.out.println(entries[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook(100);
        Scanner scanner = new Scanner(System.in);
        
        // 샘플 데이터 추가
        phoneBook.addContact("김철수", "010-1234-5678", "kim@email.com");
        phoneBook.addContact("이영희", "010-2345-6789", "lee@email.com");
        phoneBook.addContact("박민수", "010-3456-7890", "park@email.com");
        
        while (true) {
            System.out.println("\n=== 전화번호부 메뉴 ===");
            System.out.println("1. 전체 목록");
            System.out.println("2. 이름으로 검색");
            System.out.println("3. 연락처 추가");
            System.out.println("4. 연락처 수정");
            System.out.println("5. 연락처 삭제");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 소비
            
            switch (choice) {
                case 1:
                    phoneBook.printAll();
                    break;
                case 2:
                    System.out.print("검색할 이름: ");
                    String searchName = scanner.nextLine();
                    PhoneEntry found = phoneBook.findByName(searchName);
                    if (found != null) {
                        System.out.println("검색 결과: " + found);
                    } else {
                        System.out.println("찾을 수 없습니다: " + searchName);
                    }
                    break;
                case 3:
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    System.out.print("전화번호: ");
                    String phone = scanner.nextLine();
                    System.out.print("이메일: ");
                    String email = scanner.nextLine();
                    
                    if (phoneBook.addContact(name, phone, email)) {
                        System.out.println("연락처가 추가되었습니다.");
                    }
                    break;
                case 4:
                    System.out.print("수정할 이름: ");
                    String updateName = scanner.nextLine();
                    System.out.print("새 전화번호: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("새 이메일: ");
                    String newEmail = scanner.nextLine();
                    
                    if (phoneBook.updateContact(updateName, newPhone, newEmail)) {
                        System.out.println("연락처가 수정되었습니다.");
                    } else {
                        System.out.println("찾을 수 없습니다: " + updateName);
                    }
                    break;
                case 5:
                    System.out.print("삭제할 이름: ");
                    String deleteName = scanner.nextLine();
                    
                    if (phoneBook.deleteContact(deleteName)) {
                        System.out.println("연락처가 삭제되었습니다.");
                    } else {
                        System.out.println("찾을 수 없습니다: " + deleteName);
                    }
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
```

### 예제 2-2: 단어 사전

```java
public class DictionaryExample {
    static class DictionaryEntry {
        String word;        // 영어 단어
        String meaning;     // 한국어 뜻
        String pronunciation; // 발음
        
        DictionaryEntry(String word, String meaning, String pronunciation) {
            this.word = word;
            this.meaning = meaning;
            this.pronunciation = pronunciation;
        }
        
        @Override
        public String toString() {
            return String.format("%s [%s] - %s", word, pronunciation, meaning);
        }
    }
    
    static class Dictionary {
        private DictionaryEntry[] entries;
        private int count;
        
        public Dictionary(int capacity) {
            entries = new DictionaryEntry[capacity];
            count = 0;
        }
        
        // 단어 추가
        public void addWord(String word, String meaning, String pronunciation) {
            entries[count++] = new DictionaryEntry(word.toLowerCase(), meaning, pronunciation);
        }
        
        // 단어 검색
        public DictionaryEntry lookupWord(String word) {
            String searchWord = word.toLowerCase();
            for (int i = 0; i < count; i++) {
                if (entries[i].word.equals(searchWord)) {
                    return entries[i];
                }
            }
            return null;
        }
        
        // 접두사로 시작하는 단어들 찾기
        public DictionaryEntry[] findWordsStartingWith(String prefix) {
            String searchPrefix = prefix.toLowerCase();
            
            // 먼저 개수 세기
            int matchCount = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].word.startsWith(searchPrefix)) {
                    matchCount++;
                }
            }
            
            // 결과 배열 생성
            DictionaryEntry[] results = new DictionaryEntry[matchCount];
            int resultIndex = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].word.startsWith(searchPrefix)) {
                    results[resultIndex++] = entries[i];
                }
            }
            
            return results;
        }
        
        // 뜻에서 키워드 검색
        public DictionaryEntry[] findByMeaning(String keyword) {
            int matchCount = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].meaning.contains(keyword)) {
                    matchCount++;
                }
            }
            
            DictionaryEntry[] results = new DictionaryEntry[matchCount];
            int resultIndex = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].meaning.contains(keyword)) {
                    results[resultIndex++] = entries[i];
                }
            }
            
            return results;
        }
    }
    
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(1000);
        
        // 샘플 단어들 추가
        dictionary.addWord("apple", "사과", "ˈæpl");
        dictionary.addWord("application", "신청, 지원", "ˌæplɪˈkeɪʃn");
        dictionary.addWord("apply", "적용하다, 신청하다", "əˈplaɪ");
        dictionary.addWord("book", "책", "bʊk");
        dictionary.addWord("computer", "컴퓨터", "kəmˈpjuːtər");
        dictionary.addWord("programming", "프로그래밍", "ˈproʊɡræmɪŋ");
        dictionary.addWord("java", "자바", "ˈdʒɑːvə");
        dictionary.addWord("algorithm", "알고리즘", "ˈælɡərɪðəm");
        
        // 단어 검색
        System.out.println("=== 단어 검색 ===");
        String[] searchWords = {"apple", "computer", "xyz"};
        
        for (String word : searchWords) {
            DictionaryEntry result = dictionary.lookupWord(word);
            if (result != null) {
                System.out.println(word + " → " + result);
            } else {
                System.out.println(word + " → 찾을 수 없음");
            }
        }
        
        // 접두사 검색
        System.out.println("\n=== 'app'로 시작하는 단어들 ===");
        DictionaryEntry[] appWords = dictionary.findWordsStartingWith("app");
        for (DictionaryEntry entry : appWords) {
            System.out.println(entry);
        }
        
        // 뜻으로 검색
        System.out.println("\n=== '프로그램'이 포함된 뜻을 가진 단어들 ===");
        DictionaryEntry[] programWords = dictionary.findByMeaning("프로그램");
        for (DictionaryEntry entry : programWords) {
            System.out.println(entry);
        }
    }
}
```

## 3. 정렬 알고리즘 예제

### 예제 3-1: 삽입 정렬 상세 과정

```java
import java.util.Arrays;

public class InsertionSortDetailExample {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("초기 배열: " + Arrays.toString(array));
        insertionSortWithDetails(array);
        System.out.println("최종 정렬: " + Arrays.toString(array));
    }
    
    // TODO: 삽입 정렬 메서드를 작성하세요
    // 매개변수: int[] array
    // 알고리즘: 두 번째 요소부터 시작하여 앞의 정렬된 부분에 올바른 위치에 삽입
    public static void insertionSortWithDetails(int[] array) {
        // TODO: 두 번째 요소(인덱스 1)부터 마지막까지 반복
        for (int i = ; i < ; i++) {
            // TODO: 현재 요소를 key로 저장
            int key = ;
            int j = i - 1;
            
            System.out.printf("\n--- %d번째 단계 (key = %d) ---\n", i, key);
            System.out.printf("정렬된 부분: %s\n", 
                Arrays.toString(Arrays.copyOfRange(array, 0, i)));
            
            // TODO: key보다 큰 값들을 오른쪽으로 이동
            // j가 0 이상이고 array[j]가 key보다 클 때까지 반복
            while () {
                // TODO: array[j]를 오른쪽으로 이동
                
                j = j - 1;
                System.out.printf("  이동 후: %s\n", Arrays.toString(array));
            }
            
            // TODO: key를 올바른 위치에 삽입
            
            System.out.printf("삽입 완료: %s\n", Arrays.toString(array));
        }
    }
}
```

**실행 결과:**
```
초기 배열: [64, 34, 25, 12, 22, 11, 90]

--- 1번째 단계 (key = 34) ---
정렬된 부분: [64]
  이동 후: [64, 64, 25, 12, 22, 11, 90]
삽입 완료: [34, 64, 25, 12, 22, 11, 90]

--- 2번째 단계 (key = 25) ---
정렬된 부분: [34, 64]
  이동 후: [34, 64, 64, 12, 22, 11, 90]
  이동 후: [34, 34, 64, 12, 22, 11, 90]
삽입 완료: [25, 34, 64, 12, 22, 11, 90]
...
최종 정렬: [11, 12, 22, 25, 34, 64, 90]
```

### 예제 3-2: 선택 정렬 상세 과정

```java
import java.util.Arrays;

public class SelectionSortDetailExample {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        
        System.out.println("초기 배열: " + Arrays.toString(array));
        selectionSortWithDetails(array);
        System.out.println("최종 정렬: " + Arrays.toString(array));
    }
    
    // TODO: 선택 정렬 메서드를 작성하세요
    // 매개변수: int[] array
    // 알고리즘: 매번 남은 부분에서 최소값을 찾아 현재 위치와 교환
    public static void selectionSortWithDetails(int[] array) {
        // TODO: 배열의 첫 번째부터 마지막-1까지 반복
        for (int i = 0; i < ; i++) {
            // TODO: 현재 인덱스를 최소값 인덱스로 초기화
            int minIndex = ;
            
            System.out.printf("\n--- %d번째 단계 ---\n", i + 1);
            System.out.printf("정렬된 부분: %s\n", 
                Arrays.toString(Arrays.copyOfRange(array, 0, i)));
            System.out.printf("정렬할 부분: %s\n", 
                Arrays.toString(Arrays.copyOfRange(array, i, array.length)));
            
            // TODO: 나머지 부분에서 최소값 찾기
            // i+1부터 배열 끝까지 탐색
            for (int j = ; j < ; j++) {
                // TODO: 더 작은 값을 찾으면 minIndex 업데이트
                if () {
                    minIndex = j;
                    System.out.printf("  새로운 최소값: %d (인덱스 %d)\n", 
                        array[minIndex], minIndex);
                }
            }
            
            // TODO: 최소값과 현재 위치 교환
            if (minIndex != i) {
                System.out.printf("교환: %d ↔ %d\n", array[i], array[minIndex]);
                // TODO: 두 요소 교환하기
                int temp = ;
                
            } else {
                System.out.println("교환 불필요 (이미 최소값)");
            }
            
            System.out.printf("결과: %s\n", Arrays.toString(array));
        }
    }
}
```

**실행 결과:**
```
초기 배열: [64, 25, 12, 22, 11]

--- 1번째 단계 ---
정렬된 부분: []
정렬할 부분: [64, 25, 12, 22, 11]
  새로운 최소값: 25 (인덱스 1)
  새로운 최소값: 12 (인덱스 2)
  새로운 최소값: 11 (인덱스 4)
교환: 64 ↔ 11
결과: [11, 25, 12, 22, 64]

--- 2번째 단계 ---
정렬된 부분: [11]
정렬할 부분: [25, 12, 22, 64]
  새로운 최소값: 12 (인덱스 2)
교환: 25 ↔ 12
결과: [11, 12, 25, 22, 64]
...
최종 정렬: [11, 12, 22, 25, 64]
```

### 예제 3-3: 객체 정렬

```java
import java.util.Arrays;

public class ObjectSortingExample {
    static class Product {
        String name;
        int price;
        int stock;
        
        Product(String name, int price, int stock) {
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
        
        @Override
        public String toString() {
            return String.format("%s(%d원, 재고:%d)", name, price, stock);
        }
    }
    
    public static void main(String[] args) {
        Product[] products = {
            new Product("노트북", 1200000, 5),
            new Product("마우스", 25000, 50),
            new Product("키보드", 85000, 20),
            new Product("모니터", 450000, 8)
        };
        
        System.out.println("원본 배열:");
        printProducts(products);
        
        // 가격순 정렬 (오름차순)
        sortByPrice(products);
        System.out.println("\n가격순 정렬 (오름차순):");
        printProducts(products);
        
        // 재고순 정렬 (내림차순)
        sortByStock(products);
        System.out.println("\n재고순 정렬 (내림차순):");
        printProducts(products);
        
        // 이름순 정렬 (알파벳/한글순)
        sortByName(products);
        System.out.println("\n이름순 정렬:");
        printProducts(products);
    }
    
    // TODO: 가격순 정렬 메서드를 작성하세요 (삽입 정렬 사용)
    // 매개변수: Product[] products
    // 오름차순으로 정렬
    public static void sortByPrice(Product[] products) {
        // TODO: 삽입 정렬 알고리즘을 사용하여 가격순 정렬
        for (int i = 1; i < products.length; i++) {
            Product key = products[i];
            int j = i - 1;
            
            // TODO: 현재 제품보다 가격이 높은 제품들을 오른쪽으로 이동
            while () {
                
                j = j - 1;
            }
            
            // TODO: 현재 제품을 올바른 위치에 삽입
            
        }
    }
    
    // TODO: 재고순 정렬 메서드를 작성하세요 (선택 정렬, 내림차순)
    // 매개변수: Product[] products
    // 재고가 많은 순서대로 정렬
    public static void sortByStock(Product[] products) {
        // TODO: 선택 정렬 알고리즘을 사용하여 재고순 정렬 (내림차순)
        for (int i = 0; i < products.length - 1; i++) {
            int maxIndex = i;
            
            // TODO: 나머지 부분에서 재고가 가장 많은 제품 찾기
            for (int j = i + 1; j < products.length; j++) {
                if () {
                    maxIndex = j;
                }
            }
            
            // TODO: 최대값과 현재 위치 교환
            
        }
    }
    
    // TODO: 이름순 정렬 메서드를 작성하세요 (삽입 정렬 사용)
    // 매개변수: Product[] products
    // 문자열 비교를 위해 compareTo() 메서드 사용
    public static void sortByName(Product[] products) {
        for (int i = 1; i < products.length; i++) {
            Product key = products[i];
            int j = i - 1;
            
            // TODO: 현재 제품보다 이름이 사전적으로 뒤에 오는 제품들을 오른쪽으로 이동
            // 힌트: String.compareTo() 메서드 사용
            while () {
                products[j + 1] = products[j];
                j = j - 1;
            }
            
            // TODO: 현재 제품을 올바른 위치에 삽입
            
        }
    }
    
    public static void printProducts(Product[] products) {
        for (Product product : products) {
            System.out.println("  " + product);
        }
    }
}
```

### 예제 3-4: 성능 비교

```java
import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceExample {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000};
        
        for (int size : sizes) {
            System.out.printf("\n=== 배열 크기: %d ===\n", size);
            
            // 테스트용 데이터 생성
            int[] original = generateRandomArray(size);
            
            // 삽입 정렬 테스트
            int[] array1 = Arrays.copyOf(original, original.length);
            long startTime = System.nanoTime();
            insertionSort(array1);
            long insertionTime = System.nanoTime() - startTime;
            
            // 선택 정렬 테스트
            int[] array2 = Arrays.copyOf(original, original.length);
            startTime = System.nanoTime();
            selectionSort(array2);
            long selectionTime = System.nanoTime() - startTime;
            
            // Java 내장 정렬 테스트
            int[] array3 = Arrays.copyOf(original, original.length);
            startTime = System.nanoTime();
            Arrays.sort(array3);
            long javaTime = System.nanoTime() - startTime;
            
            // 결과가 같은지 확인
            boolean same = Arrays.equals(array1, array2) && Arrays.equals(array2, array3);
            
            System.out.printf("삽입 정렬: %8.3f ms\n", insertionTime / 1_000_000.0);
            System.out.printf("선택 정렬: %8.3f ms\n", selectionTime / 1_000_000.0);
            System.out.printf("Java 정렬: %8.3f ms\n", javaTime / 1_000_000.0);
            System.out.printf("결과 일치: %s\n", same ? "예" : "아니오");
        }
    }
    
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
    
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            
            array[j + 1] = key;
        }
    }
    
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
```

## 4. 배열 섞기와 응용

### 예제 4-1: 카드 덱 섞기

```java
import java.util.Arrays;

public class CardShuffleExample {
    static class Card {
        String suit;  // 무늬: ♠, ♥, ♦, ♣
        String rank;  // 숫자: A, 2-10, J, Q, K
        
        Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }
        
        @Override
        public String toString() {
            return suit + rank;
        }
    }
    
    public static void main(String[] args) {
        // 52장의 카드 덱 생성
        Card[] deck = createDeck();
        
        System.out.println("새 덱 (정렬된 상태):");
        printDeck(deck, 13);  // 한 줄에 13장씩 출력
        
        // 카드 섞기
        shuffleDeck(deck);
        
        System.out.println("\n섞은 후:");
        printDeck(deck, 13);
        
        // 카드 나누기 (4명의 플레이어에게 5장씩)
        System.out.println("\n=== 카드 나누기 (4명 × 5장) ===");
        dealCards(deck, 4, 5);
    }
    
    public static Card[] createDeck() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        
        Card[] deck = new Card[52];
        int index = 0;
        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(suit, rank);
            }
        }
        
        return deck;
    }
    
    public static void shuffleDeck(Card[] deck) {
        for (int i = deck.length - 1; i > 0; i--) {
            int randomIndex = (int)(Math.random() * (i + 1));
            
            // 카드 교환
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
    
    public static void printDeck(Card[] deck, int cardsPerLine) {
        for (int i = 0; i < deck.length; i++) {
            System.out.printf("%-4s", deck[i]);
            if ((i + 1) % cardsPerLine == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void dealCards(Card[] deck, int players, int cardsPerPlayer) {
        for (int player = 1; player <= players; player++) {
            System.out.printf("플레이어 %d: ", player);
            
            for (int card = 0; card < cardsPerPlayer; card++) {
                int cardIndex = (player - 1) * cardsPerPlayer + card;
                System.out.printf("%-4s", deck[cardIndex]);
            }
            System.out.println();
        }
    }
}
```

### 예제 4-2: 퀴즈 문제 섞기

```java
import java.util.Scanner;

public class QuizShuffleExample {
    static class Question {
        String question;
        String[] options;
        int correctAnswer;  // 정답 인덱스 (0-3)
        
        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
        
        public void display(int questionNumber) {
            System.out.printf("\n%d. %s\n", questionNumber, question);
            for (int i = 0; i < options.length; i++) {
                System.out.printf("  %d) %s\n", i + 1, options[i]);
            }
        }
        
        public boolean isCorrect(int userAnswer) {
            return userAnswer - 1 == correctAnswer;  // 1-4를 0-3으로 변환
        }
        
        public String getCorrectAnswerText() {
            return options[correctAnswer];
        }
    }
    
    public static void main(String[] args) {
        // 퀴즈 문제들 생성
        Question[] questions = {
            new Question("Java에서 배열의 크기를 얻는 방법은?",
                new String[]{"array.size()", "array.length", "array.count()", "array.getSize()"},
                1),
            new Question("다음 중 올바른 변수명은?",
                new String[]{"2name", "class", "userName", "user-name"},
                2),
            new Question("Java에서 문자열을 비교할 때 사용하는 메서드는?",
                new String[]{"compare()", "equals()", "same()", "match()"},
                1),
            new Question("배열의 인덱스는 몇부터 시작하나요?",
                new String[]{"1", "0", "-1", "배열에 따라 다름"},
                1),
            new Question("다음 중 반복문이 아닌 것은?",
                new String[]{"for", "while", "if", "do-while"},
                2)
        };
        
        System.out.println("=== Java 기초 퀴즈 ===");
        System.out.println("총 " + questions.length + "문제입니다.");
        
        // 문제 순서 섞기
        shuffleQuestions(questions);
        
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        // 퀴즈 진행
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            q.display(i + 1);
            
            System.out.print("답 (1-4): ");
            int userAnswer = scanner.nextInt();
            
            if (q.isCorrect(userAnswer)) {
                System.out.println("정답입니다! ✓");
                score++;
            } else {
                System.out.println("틀렸습니다. ✗");
                System.out.println("정답: " + q.getCorrectAnswerText());
            }
        }
        
        // 결과 출력
        System.out.printf("\n=== 퀴즈 결과 ===\n");
        System.out.printf("점수: %d/%d (%.1f%%)\n", 
            score, questions.length, (score * 100.0 / questions.length));
        
        if (score == questions.length) {
            System.out.println("완벽합니다! 🎉");
        } else if (score >= questions.length * 0.8) {
            System.out.println("잘했습니다! 👍");
        } else if (score >= questions.length * 0.6) {
            System.out.println("괜찮습니다. 조금 더 공부해보세요!");
        } else {
            System.out.println("더 공부가 필요합니다. 화이팅! 💪");
        }
        
        scanner.close();
    }
    
    public static void shuffleQuestions(Question[] questions) {
        for (int i = questions.length - 1; i > 0; i--) {
            int randomIndex = (int)(Math.random() * (i + 1));
            
            // 문제 순서 섞기
            Question temp = questions[i];
            questions[i] = questions[randomIndex];
            questions[randomIndex] = temp;
        }
    }
}
```

## 5. 종합 예제: 학생 성적 관리 시스템

### 예제 5-1: 완전한 성적 관리 시스템

```java
import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeSystem {
    static class Student {
        String id;
        String name;
        int[] scores;  // 과목별 점수
        double average;
        
        Student(String id, String name, int subjectCount) {
            this.id = id;
            this.name = name;
            this.scores = new int[subjectCount];
            this.average = 0.0;
        }
        
        public void calculateAverage() {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            average = (double) sum / scores.length;
        }
        
        public String getGrade() {
            if (average >= 95) return "A+";
            else if (average >= 90) return "A";
            else if (average >= 85) return "B+";
            else if (average >= 80) return "B";
            else if (average >= 75) return "C+";
            else if (average >= 70) return "C";
            else if (average >= 65) return "D+";
            else if (average >= 60) return "D";
            else return "F";
        }
        
        @Override
        public String toString() {
            return String.format("%-8s %-10s %s 평균:%.1f(%s)", 
                id, name, Arrays.toString(scores), average, getGrade());
        }
    }
    
    static class GradeManager {
        private Student[] students;
        private int count;
        private String[] subjects;
        
        public GradeManager(int capacity, String[] subjects) {
            this.students = new Student[capacity];
            this.count = 0;
            this.subjects = subjects;
        }
        
        // 학생 추가
        public boolean addStudent(String id, String name) {
            if (count >= students.length) {
                System.out.println("더 이상 학생을 추가할 수 없습니다.");
                return false;
            }
            
            // 중복 ID 확인
            if (findStudentById(id) != null) {
                System.out.println("이미 존재하는 학번입니다: " + id);
                return false;
            }
            
            students[count++] = new Student(id, name, subjects.length);
            return true;
        }
        
        // 학번으로 학생 찾기
        public Student findStudentById(String id) {
            for (int i = 0; i < count; i++) {
                if (students[i].id.equals(id)) {
                    return students[i];
                }
            }
            return null;
        }
        
        // 성적 입력
        public boolean inputScores(String id, int[] scores) {
            Student student = findStudentById(id);
            if (student == null) {
                System.out.println("학생을 찾을 수 없습니다: " + id);
                return false;
            }
            
            if (scores.length != subjects.length) {
                System.out.println("과목 수가 맞지 않습니다.");
                return false;
            }
            
            for (int i = 0; i < scores.length; i++) {
                student.scores[i] = scores[i];
            }
            student.calculateAverage();
            return true;
        }
        
        // 평균 점수순 정렬 (내림차순)
        public void sortByAverage() {
            for (int i = 0; i < count - 1; i++) {
                int maxIndex = i;
                
                for (int j = i + 1; j < count; j++) {
                    if (students[j].average > students[maxIndex].average) {
                        maxIndex = j;
                    }
                }
                
                // 교환
                Student temp = students[i];
                students[i] = students[maxIndex];
                students[maxIndex] = temp;
            }
        }
        
        // 이름순 정렬
        public void sortByName() {
            for (int i = 1; i < count; i++) {
                Student key = students[i];
                int j = i - 1;
                
                while (j >= 0 && students[j].name.compareTo(key.name) > 0) {
                    students[j + 1] = students[j];
                    j = j - 1;
                }
                
                students[j + 1] = key;
            }
        }
        
        // 특정 점수 이상 학생 찾기
        public Student[] findStudentsByMinAverage(double minAverage) {
            int matchCount = 0;
            for (int i = 0; i < count; i++) {
                if (students[i].average >= minAverage) {
                    matchCount++;
                }
            }
            
            Student[] results = new Student[matchCount];
            int resultIndex = 0;
            for (int i = 0; i < count; i++) {
                if (students[i].average >= minAverage) {
                    results[resultIndex++] = students[i];
                }
            }
            
            return results;
        }
        
        // 통계 정보
        public void printStatistics() {
            if (count == 0) {
                System.out.println("등록된 학생이 없습니다.");
                return;
            }
            
            double totalAverage = 0;
            double maxAverage = students[0].average;
            double minAverage = students[0].average;
            
            for (int i = 0; i < count; i++) {
                totalAverage += students[i].average;
                if (students[i].average > maxAverage) {
                    maxAverage = students[i].average;
                }
                if (students[i].average < minAverage) {
                    minAverage = students[i].average;
                }
            }
            
            System.out.println("=== 통계 정보 ===");
            System.out.printf("총 학생 수: %d명\n", count);
            System.out.printf("전체 평균: %.2f점\n", totalAverage / count);
            System.out.printf("최고 점수: %.2f점\n", maxAverage);
            System.out.printf("최저 점수: %.2f점\n", minAverage);
        }
        
        // 전체 학생 목록 출력
        public void printAllStudents() {
            if (count == 0) {
                System.out.println("등록된 학생이 없습니다.");
                return;
            }
            
            System.out.println("=== 전체 학생 목록 ===");
            System.out.printf("%-8s %-10s", "학번", "이름");
            for (String subject : subjects) {
                System.out.printf(" %-4s", subject);
            }
            System.out.println(" 평균   등급");
            System.out.println("------------------------------------------------");
            
            for (int i = 0; i < count; i++) {
                System.out.printf("%-8s %-10s", 
                    students[i].id, students[i].name);
                for (int score : students[i].scores) {
                    System.out.printf(" %-4d", score);
                }
                System.out.printf(" %-6.1f %s\n", 
                    students[i].average, students[i].getGrade());
            }
        }
    }
    
    public static void main(String[] args) {
        String[] subjects = {"국어", "영어", "수학", "과학"};
        GradeManager manager = new GradeManager(100, subjects);
        Scanner scanner = new Scanner(System.in);
        
        // 샘플 데이터 추가
        manager.addStudent("20240001", "김철수");
        manager.addStudent("20240002", "이영희");
        manager.addStudent("20240003", "박민수");
        
        manager.inputScores("20240001", new int[]{85, 90, 88, 92});
        manager.inputScores("20240002", new int[]{95, 87, 93, 89});
        manager.inputScores("20240003", new int[]{78, 82, 85, 80});
        
        while (true) {
            System.out.println("\n=== 학생 성적 관리 시스템 ===");
            System.out.println("1. 학생 추가");
            System.out.println("2. 성적 입력");
            System.out.println("3. 전체 목록 (이름순)");
            System.out.println("4. 전체 목록 (성적순)");
            System.out.println("5. 학생 검색");
            System.out.println("6. 우수학생 (90점 이상)");
            System.out.println("7. 통계 정보");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 소비
            
            switch (choice) {
                case 1:
                    System.out.print("학번: ");
                    String id = scanner.nextLine();
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    
                    if (manager.addStudent(id, name)) {
                        System.out.println("학생이 추가되었습니다.");
                    }
                    break;
                    
                case 2:
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine();
                    
                    int[] scores = new int[subjects.length];
                    for (int i = 0; i < subjects.length; i++) {
                        System.out.printf("%s 점수: ", subjects[i]);
                        scores[i] = scanner.nextInt();
                    }
                    scanner.nextLine();  // 개행 문자 소비
                    
                    if (manager.inputScores(studentId, scores)) {
                        System.out.println("성적이 입력되었습니다.");
                    }
                    break;
                    
                case 3:
                    manager.sortByName();
                    manager.printAllStudents();
                    break;
                    
                case 4:
                    manager.sortByAverage();
                    manager.printAllStudents();
                    break;
                    
                case 5:
                    System.out.print("검색할 학번: ");
                    String searchId = scanner.nextLine();
                    Student found = manager.findStudentById(searchId);
                    
                    if (found != null) {
                        System.out.println("검색 결과: " + found);
                    } else {
                        System.out.println("학생을 찾을 수 없습니다.");
                    }
                    break;
                    
                case 6:
                    Student[] excellentStudents = manager.findStudentsByMinAverage(90.0);
                    System.out.println("=== 우수학생 (90점 이상) ===");
                    if (excellentStudents.length == 0) {
                        System.out.println("해당하는 학생이 없습니다.");
                    } else {
                        for (Student student : excellentStudents) {
                            System.out.println(student);
                        }
                    }
                    break;
                    
                case 7:
                    manager.printStatistics();
                    break;
                    
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
```

이 예제들은 검색과 정렬의 다양한 실제 응용을 보여줍니다. 각 예제는 점진적으로 복잡해지며, 실제 프로그래밍에서 자주 마주치는 상황들을 다룹니다.