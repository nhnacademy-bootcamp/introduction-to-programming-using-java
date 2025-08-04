# 5.1 객체, 인스턴스 메서드, 그리고 인스턴스 변수 - 수업 실습

## 1. 기본 클래스와 객체 생성

### 실습 1-1: 간단한 Person 클래스
**목표**: 기본적인 클래스 정의와 인스턴스 변수, 인스턴스 메서드를 작성해보세요.

```java
/**
 * 사람을 나타내는 기본 클래스
 */
public class Person {
    // TODO 1: 인스턴스 변수 선언하기
    // name (문자열), age (정수), email (문자열) 변수를 public으로 선언
    
    // TODO 2: 자기소개 메서드 구현하기
    public void introduce() {
        // "안녕하세요! 저는 [이름]입니다."와 "나이는 [나이]살입니다." 출력
    }
    
    // TODO 3: 생일 메서드 구현하기
    public void haveBirthday() {
        // age를 1 증가시키고 "[이름]님의 생일을 축하합니다! 이제 [나이]살이 되었습니다." 출력
    }
    
    // TODO 4: 이메일 유효성 확인 메서드 구현하기
    public boolean hasValidEmail() {
        // email이 null이 아니고 "@"를 포함하면 true, 아니면 false 반환
    }
}

// TODO 5: 사용 예제 완성하기
public class PersonExample {
    public static void main(String[] args) {
        // TODO 6: 첫 번째 객체 생성하고 정보 설정하기
        // Person 객체를 생성하고 name = "김철수", age = 25, email = "kim@example.com"으로 설정
        
        // TODO 7: 두 번째 객체 생성하고 정보 설정하기
        // Person 객체를 생성하고 name = "이영희", age = 23, email = "lee@example.com"으로 설정
        
        // TODO 8: 메서드 호출하기
        // 두 사람의 introduce() 메서드 호출
        
        // TODO 9: 생일 축하하기
        // person1의 haveBirthday() 메서드 호출
        
        // TODO 10: 이메일 유효성 확인하기
        // person1의 이메일이 유효하면 "[이름]님의 이메일은 유효합니다." 출력
    }
}
```

#### 실행 결과 (참고용):
```
안녕하세요! 저는 김철수입니다.
나이는 25살입니다.
안녕하세요! 저는 이영희입니다.
나이는 23살입니다.
김철수님의 생일을 축하합니다! 이제 26살이 되었습니다.
김철수님의 이메일은 유효합니다.
```

### 실습 1-2: 도서 관리 클래스
**목표**: 더 복잡한 클래스를 만들고 boolean 필드를 활용해보세요.
```java
/**
 * 도서 정보를 관리하는 클래스
 */
public class Book {
    // TODO 11: 인스턴스 변수 선언하기
    // title(제목), author(저자), isbn, pages(페이지수), isAvailable(대출가능여부) 변수를 public으로 선언
    
    // TODO 12: 도서 정보 출력 메서드 구현하기
    public void displayInfo() {
        // "=== 도서 정보 ===" 출력
        // "제목: [제목]", "저자: [저자]", "ISBN: [isbn]", "페이지: [페이지수]" 출력
        // "대출 가능: [예/아니오]" 출력 (isAvailable이 true면 "예", false면 "아니오")
    }
    
    // TODO 13: 대출 처리 메서드 구현하기
    public void borrowBook() {
        // isAvailable이 true면:
        //   - isAvailable을 false로 변경
        //   - "'[제목]' 도서가 대출되었습니다." 출력
        // 아니면:
        //   - "'[제목]' 도서는 현재 대출 중입니다." 출력
    }
    
    // TODO 14: 반납 처리 메서드 구현하기
    public void returnBook() {
        // isAvailable을 true로 변경
        // "'[제목]' 도서가 반납되었습니다." 출력
    }
}

// TODO 15: 도서관 시스템 완성하기
public class LibrarySystem {
    public static void main(String[] args) {
        // TODO 16: 첫 번째 도서 객체 생성하고 정보 설정하기
        // Book 객체를 생성하고 다음 정보로 설정:
        // title = "Java의 정석", author = "남궁성", isbn = "978-89-968088-0-1"
        // pages = 1022, isAvailable = true
        
        // TODO 17: 두 번째 도서 객체 생성하고 정보 설정하기
        // Book 객체를 생성하고 다음 정보로 설정:
        // title = "Clean Code", author = "Robert C. Martin", isbn = "978-89-966260-2-3"
        // pages = 464, isAvailable = true
        
        // TODO 18: 도서 정보 표시하기
        // book1의 displayInfo() 메서드 호출하고 빈 줄 출력
        
        // TODO 19: 대출 시뮬레이션하기
        // book1.borrowBook() 두 번 호출 (두 번째는 실패해야 함)
        
        // TODO 20: 반납하고 정보 다시 표시하기
        // book1을 반납하고 displayInfo() 다시 호출
    }
}
```

#### 실행 결과 (참고용):
```
=== 도서 정보 ===
제목: Java의 정석
저자: 남궁성
ISBN: 978-89-968088-0-1
페이지: 1022
대출 가능: 예

'Java의 정석' 도서가 대출되었습니다.
'Java의 정석' 도서는 현재 대출 중입니다.
'Java의 정석' 도서가 반납되었습니다.
=== 도서 정보 ===
제목: Java의 정석
저자: 남궁성
ISBN: 978-89-968088-0-1
페이지: 1022
대출 가능: 예
```

## 2. Static vs Instance 멤버

### 예제 2-1: 게임 캐릭터 클래스
```java
/**
 * 게임 캐릭터를 나타내는 클래스
 */
public class GameCharacter {
    // Static 변수 (클래스 변수)
    public static int totalCharacters = 0;
    public static int maxLevel = 100;
    
    // Instance 변수
    public String name;
    public int level;
    public int health;
    public int experience;
    
    // 생성자에서 총 캐릭터 수 증가
    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.experience = 0;
        totalCharacters++;  // static 변수 증가
    }
    
    // 경험치 획득
    public void gainExperience(int exp) {
        experience += exp;
        System.out.println(name + "이(가) " + exp + " 경험치를 획득했습니다.");
        
        // 레벨업 체크
        while (experience >= level * 100) {
            experience -= level * 100;
            levelUp();
        }
    }
    
    // 레벨업
    private void levelUp() {
        if (level < maxLevel) {
            level++;
            health += 10;
            System.out.println(name + "이(가) 레벨 " + level + "이(가) 되었습니다!");
        }
    }
    
    // 상태 출력
    public void showStatus() {
        System.out.println("=== " + name + "의 상태 ===");
        System.out.println("레벨: " + level + "/" + maxLevel);
        System.out.println("체력: " + health);
        System.out.println("경험치: " + experience);
    }
    
    // Static 메서드
    public static void showGameInfo() {
        System.out.println("=== 게임 정보 ===");
        System.out.println("총 캐릭터 수: " + totalCharacters);
        System.out.println("최대 레벨: " + maxLevel);
    }
}

// 사용 예제
public class GameExample {
    public static void main(String[] args) {
        // 게임 정보 표시 (객체 생성 전)
        GameCharacter.showGameInfo();
        
        // 캐릭터 생성
        GameCharacter warrior = new GameCharacter("전사");
        GameCharacter mage = new GameCharacter("마법사");
        GameCharacter archer = new GameCharacter("궁수");
        
        // 게임 정보 다시 표시
        GameCharacter.showGameInfo();
        
        // 캐릭터 플레이
        warrior.gainExperience(150);
        warrior.gainExperience(200);
        warrior.showStatus();
        
        mage.gainExperience(300);
        mage.showStatus();
        
        System.out.println("\n총 캐릭터 수: " + GameCharacter.totalCharacters);
    }
}
```

## 3. 참조와 Null

### 예제 3-1: 참조 복사와 객체 복사의 차이
```java
/**
 * 좌표를 나타내는 클래스
 */
public class Point {
    public int x;
    public int y;
    
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void display() {
        System.out.println("좌표: (" + x + ", " + y + ")");
    }
    
    // 객체 복사를 위한 메서드
    public Point copy() {
        Point newPoint = new Point();
        newPoint.x = this.x;
        newPoint.y = this.y;
        return newPoint;
    }
}

// 참조 실험
public class ReferenceExample {
    public static void main(String[] args) {
        // 1. 참조 복사
        System.out.println("=== 참조 복사 ===");
        Point p1 = new Point();
        p1.setLocation(10, 20);
        
        Point p2 = p1;  // 참조 복사 (같은 객체를 가리킴)
        
        System.out.println("p1:"); 
        p1.display();
        System.out.println("p2:"); 
        p2.display();
        
        p2.move(5, 5);  // p2를 통해 이동
        
        System.out.println("\np2 이동 후:");
        System.out.println("p1:"); 
        p1.display();  // p1도 변경됨!
        System.out.println("p2:"); 
        p2.display();
        
        // 2. 객체 복사
        System.out.println("\n=== 객체 복사 ===");
        Point p3 = new Point();
        p3.setLocation(30, 40);
        
        Point p4 = p3.copy();  // 새로운 객체 생성
        
        System.out.println("p3:"); 
        p3.display();
        System.out.println("p4:"); 
        p4.display();
        
        p4.move(5, 5);  // p4만 이동
        
        System.out.println("\np4 이동 후:");
        System.out.println("p3:"); 
        p3.display();  // p3는 그대로
        System.out.println("p4:"); 
        p4.display();  // p4만 변경됨
        
        // 3. null 참조
        System.out.println("\n=== null 참조 ===");
        Point p5 = null;
        
        if (p5 == null) {
            System.out.println("p5는 null입니다.");
        }
        
        // 안전한 null 체크
        Point p6 = getPoint(false);
        if (p6 != null) {
            p6.display();
        } else {
            System.out.println("포인트가 생성되지 않았습니다.");
        }
    }
    
    // null을 반환할 수 있는 메서드
    public static Point getPoint(boolean create) {
        if (create) {
            Point p = new Point();
            p.setLocation(100, 100);
            return p;
        }
        return null;
    }
}
```

## 4. Getter와 Setter

### 예제 4-1: 은행 계좌 클래스 (완전한 캡슐화)
```java
/**
 * 은행 계좌 클래스 - 완전한 캡슐화 예제
 */
public class BankAccount {
    // Private 인스턴스 변수
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String password;
    private boolean isLocked;
    
    // 생성자
    public BankAccount(String accountNumber, String accountHolder, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.password = password;
        this.balance = 0.0;
        this.isLocked = false;
    }
    
    // Getter 메서드들
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        if (isLocked) {
            System.out.println("계좌가 잠겨있습니다.");
            return 0;
        }
        return balance;
    }
    
    public boolean isLocked() {
        return isLocked;
    }
    
    // Setter 메서드들 (제한적)
    public void setAccountHolder(String newHolder) {
        if (newHolder != null && !newHolder.trim().isEmpty()) {
            this.accountHolder = newHolder;
            System.out.println("계좌 소유자가 변경되었습니다.");
        } else {
            System.out.println("유효하지 않은 이름입니다.");
        }
    }
    
    // 비밀번호 변경 (기존 비밀번호 확인 필요)
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            if (newPassword.length() >= 4) {
                this.password = newPassword;
                System.out.println("비밀번호가 변경되었습니다.");
                return true;
            } else {
                System.out.println("비밀번호는 4자 이상이어야 합니다.");
            }
        } else {
            System.out.println("기존 비밀번호가 일치하지 않습니다.");
        }
        return false;
    }
    
    // 입금 메서드
    public void deposit(double amount) {
        if (isLocked) {
            System.out.println("계좌가 잠겨있어 입금할 수 없습니다.");
            return;
        }
        
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다. 잔액: " + balance);
        } else {
            System.out.println("입금액은 0보다 커야 합니다.");
        }
    }
    
    // 출금 메서드 (비밀번호 확인)
    public boolean withdraw(double amount, String password) {
        if (isLocked) {
            System.out.println("계좌가 잠겨있어 출금할 수 없습니다.");
            return false;
        }
        
        if (!this.password.equals(password)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
        
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 잔액: " + balance);
            return true;
        } else {
            System.out.println("출금액이 잘못되었거나 잔액이 부족합니다.");
            return false;
        }
    }
    
    // 계좌 잠금/해제
    public void lockAccount() {
        isLocked = true;
        System.out.println("계좌가 잠겼습니다.");
    }
    
    public void unlockAccount(String password) {
        if (this.password.equals(password)) {
            isLocked = false;
            System.out.println("계좌 잠금이 해제되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}

// 사용 예제
public class BankingExample {
    public static void main(String[] args) {
        // 계좌 생성
        BankAccount account = new BankAccount("123-456-789", "김철수", "1234");
        
        // 계좌 정보 확인
        System.out.println("계좌번호: " + account.getAccountNumber());
        System.out.println("예금주: " + account.getAccountHolder());
        System.out.println("잔액: " + account.getBalance());
        
        // 거래
        account.deposit(100000);
        account.withdraw(30000, "1234");  // 성공
        account.withdraw(20000, "0000");  // 실패 (잘못된 비밀번호)
        
        // 비밀번호 변경
        account.changePassword("1234", "5678");
        
        // 계좌 잠금
        account.lockAccount();
        account.deposit(50000);  // 실패 (계좌 잠김)
        
        // 계좌 잠금 해제
        account.unlockAccount("5678");
        account.deposit(50000);  // 성공
    }
}
```

### 예제 4-2: 학생 성적 관리 시스템
```java
/**
 * 학생 클래스 - 성적 관리 시스템
 */
public class Student {
    // Private 필드
    private String studentId;
    private String name;
    private int[] scores;  // 각 과목 점수
    private String[] subjects;  // 과목명
    
    // 생성자
    public Student(String studentId, String name, String[] subjects) {
        this.studentId = studentId;
        this.name = name;
        this.subjects = subjects;
        this.scores = new int[subjects.length];
    }
    
    // Getter 메서드
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    // 특정 과목의 점수 가져오기
    public int getScore(String subject) {
        int index = findSubjectIndex(subject);
        if (index != -1) {
            return scores[index];
        }
        return -1;  // 과목을 찾을 수 없음
    }
    
    // 평균 점수 계산 (계산된 속성)
    public double getAverage() {
        if (scores.length == 0) return 0;
        
        int sum = 0;
        int count = 0;
        for (int score : scores) {
            if (score > 0) {  // 점수가 입력된 과목만
                sum += score;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0;
    }
    
    // 최고 점수 과목 찾기
    public String getBestSubject() {
        if (subjects.length == 0) return "없음";
        
        int maxScore = scores[0];
        int maxIndex = 0;
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
        }
        
        return subjects[maxIndex] + " (" + maxScore + "점)";
    }
    
    // Setter 메서드 - 점수 설정
    public boolean setScore(String subject, int score) {
        if (score < 0 || score > 100) {
            System.out.println("점수는 0-100 사이여야 합니다.");
            return false;
        }
        
        int index = findSubjectIndex(subject);
        if (index != -1) {
            scores[index] = score;
            System.out.println(subject + " 과목 점수가 " + score + "점으로 설정되었습니다.");
            return true;
        } else {
            System.out.println(subject + " 과목을 찾을 수 없습니다.");
            return false;
        }
    }
    
    // 과목 인덱스 찾기 (private 도우미 메서드)
    private int findSubjectIndex(String subject) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                return i;
            }
        }
        return -1;
    }
    
    // 성적표 출력
    public void printReport() {
        System.out.println("\n=== 성적표 ===");
        System.out.println("학번: " + studentId);
        System.out.println("이름: " + name);
        System.out.println("\n과목별 성적:");
        
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("  %s: %d점\n", subjects[i], scores[i]);
        }
        
        System.out.printf("\n평균 점수: %.2f점\n", getAverage());
        System.out.println("최고 점수 과목: " + getBestSubject());
    }
}

// 성적 관리 시스템
public class GradeManagement {
    public static void main(String[] args) {
        // 과목 설정
        String[] subjects = {"국어", "영어", "수학", "과학", "사회"};
        
        // 학생 생성
        Student student1 = new Student("2024001", "김철수", subjects);
        Student student2 = new Student("2024002", "이영희", subjects);
        
        // 점수 입력
        student1.setScore("국어", 85);
        student1.setScore("영어", 92);
        student1.setScore("수학", 78);
        student1.setScore("과학", 88);
        student1.setScore("사회", 95);
        
        student2.setScore("국어", 90);
        student2.setScore("영어", 88);
        student2.setScore("수학", 95);
        student2.setScore("과학", 82);
        student2.setScore("사회", 87);
        
        // 성적표 출력
        student1.printReport();
        student2.printReport();
        
        // 특정 과목 점수 조회
        System.out.println("\n" + student1.getName() + "의 수학 점수: " + 
                          student1.getScore("수학"));
    }
}
```

## 5. 객체 배열

### 예제 5-1: 도서관 관리 시스템
```java
/**
 * 도서관 클래스 - 여러 도서를 관리
 */
public class Library {
    private Book[] books;
    private int bookCount;
    private final int MAX_BOOKS = 100;
    
    // 생성자
    public Library() {
        books = new Book[MAX_BOOKS];
        bookCount = 0;
    }
    
    // 도서 추가
    public boolean addBook(String title, String author, String isbn) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("도서관이 가득 찼습니다.");
            return false;
        }
        
        // 새 도서 객체 생성
        Book newBook = new Book();
        newBook.title = title;
        newBook.author = author;
        newBook.isbn = isbn;
        newBook.pages = 0;  // 나중에 설정
        newBook.isAvailable = true;
        
        // 배열에 추가
        books[bookCount] = newBook;
        bookCount++;
        
        System.out.println("도서 '" + title + "'이(가) 추가되었습니다.");
        return true;
    }
    
    // ISBN으로 도서 찾기
    public Book findBookByISBN(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isbn.equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }
    
    // 제목으로 도서 검색 (부분 일치)
    public void searchByTitle(String keyword) {
        System.out.println("\n'" + keyword + "' 검색 결과:");
        boolean found = false;
        
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("- " + books[i].title + " (" + books[i].author + ")");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }
    
    // 대출 가능한 도서 목록
    public void showAvailableBooks() {
        System.out.println("\n=== 대출 가능한 도서 목록 ===");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable) {
                System.out.println((i + 1) + ". " + books[i].title + 
                                 " - " + books[i].author);
            }
        }
    }
    
    // 전체 도서 통계
    public void showStatistics() {
        int availableCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable) {
                availableCount++;
            }
        }
        
        System.out.println("\n=== 도서관 통계 ===");
        System.out.println("전체 도서 수: " + bookCount);
        System.out.println("대출 가능: " + availableCount);
        System.out.println("대출 중: " + (bookCount - availableCount));
    }
}

// 도서관 시스템 테스트
public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();
        
        // 도서 추가
        library.addBook("Java의 정석", "남궁성", "978-89-968088-0-1");
        library.addBook("Clean Code", "Robert C. Martin", "978-89-966260-2-3");
        library.addBook("Effective Java", "Joshua Bloch", "978-89-6848-047-4");
        library.addBook("Java Concurrency in Practice", "Brian Goetz", "978-89-6077-192-2");
        
        // 도서 검색
        library.searchByTitle("Java");
        
        // 대출 가능 목록
        library.showAvailableBooks();
        
        // 도서 대출
        Book book = library.findBookByISBN("978-89-968088-0-1");
        if (book != null) {
            book.borrowBook();
        }
        
        // 통계 표시
        library.showStatistics();
    }
}
```

### 예제 5-2: 성적 처리 시스템 (2차원 배열)
```java
/**
 * 학급 성적 관리 시스템
 */
public class ClassGradeSystem {
    private Student[] students;
    private String[] subjects;
    private int studentCount;
    private final int MAX_STUDENTS = 40;
    
    // 생성자
    public ClassGradeSystem(String[] subjects) {
        this.subjects = subjects;
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }
    
    // 학생 추가
    public void addStudent(String id, String name) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("학급 정원이 초과되었습니다.");
            return;
        }
        
        students[studentCount] = new Student(id, name, subjects);
        studentCount++;
        System.out.println(name + " 학생이 등록되었습니다.");
    }
    
    // 학번으로 학생 찾기
    public Student findStudent(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                return students[i];
            }
        }
        return null;
    }
    
    // 전체 학급 평균
    public double getClassAverage() {
        if (studentCount == 0) return 0;
        
        double sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += students[i].getAverage();
        }
        return sum / studentCount;
    }
    
    // 과목별 평균
    public double getSubjectAverage(String subject) {
        if (studentCount == 0) return 0;
        
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < studentCount; i++) {
            int score = students[i].getScore(subject);
            if (score >= 0) {
                sum += score;
                count++;
            }
        }
        
        return count > 0 ? (double) sum / count : 0;
    }
    
    // 성적 순위 (평균 기준)
    public void printRanking() {
        // 학생 배열 복사 (원본 보존)
        Student[] sorted = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            sorted[i] = students[i];
        }
        
        // 버블 정렬 (평균 점수 기준 내림차순)
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - 1 - i; j++) {
                if (sorted[j].getAverage() < sorted[j + 1].getAverage()) {
                    Student temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        
        // 순위 출력
        System.out.println("\n=== 성적 순위 ===");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%d위: %s (%.2f점)\n", 
                i + 1, sorted[i].getName(), sorted[i].getAverage());
        }
    }
    
    // 전체 성적표
    public void printClassReport() {
        System.out.println("\n=== 학급 성적표 ===");
        System.out.println("학급 인원: " + studentCount + "명");
        System.out.printf("학급 평균: %.2f점\n", getClassAverage());
        
        System.out.println("\n과목별 평균:");
        for (String subject : subjects) {
            System.out.printf("  %s: %.2f점\n", subject, getSubjectAverage(subject));
        }
        
        printRanking();
    }
}

// 테스트
public class GradeSystemTest {
    public static void main(String[] args) {
        String[] subjects = {"국어", "영어", "수학", "과학"};
        ClassGradeSystem gradeSystem = new ClassGradeSystem(subjects);
        
        // 학생 등록
        gradeSystem.addStudent("2024001", "김철수");
        gradeSystem.addStudent("2024002", "이영희");
        gradeSystem.addStudent("2024003", "박민수");
        gradeSystem.addStudent("2024004", "정수진");
        
        // 점수 입력
        Student student1 = gradeSystem.findStudent("2024001");
        if (student1 != null) {
            student1.setScore("국어", 85);
            student1.setScore("영어", 90);
            student1.setScore("수학", 88);
            student1.setScore("과학", 92);
        }
        
        Student student2 = gradeSystem.findStudent("2024002");
        if (student2 != null) {
            student2.setScore("국어", 92);
            student2.setScore("영어", 88);
            student2.setScore("수학", 95);
            student2.setScore("과학", 90);
        }
        
        Student student3 = gradeSystem.findStudent("2024003");
        if (student3 != null) {
            student3.setScore("국어", 78);
            student3.setScore("영어", 82);
            student3.setScore("수학", 85);
            student3.setScore("과학", 80);
        }
        
        Student student4 = gradeSystem.findStudent("2024004");
        if (student4 != null) {
            student4.setScore("국어", 88);
            student4.setScore("영어", 95);
            student4.setScore("수학", 82);
            student4.setScore("과학", 87);
        }
        
        // 전체 성적표 출력
        gradeSystem.printClassReport();
    }
}
```

## 6. 메서드 매개변수로 객체 전달

### 예제 6-1: 객체 전달과 변경
```java
/**
 * 직원 정보 클래스
 */
public class Employee {
    private String name;
    private double salary;
    private String department;
    
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    // Getter/Setter
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    
    public void printInfo() {
        System.out.printf("%s (%s부서): %.0f원\n", name, department, salary);
    }
}

/**
 * 급여 관리 시스템
 */
public class SalaryManagement {
    // 급여 인상 (객체의 내부 데이터 변경)
    public static void raiseSalary(Employee emp, double percentage) {
        double currentSalary = emp.getSalary();
        double newSalary = currentSalary * (1 + percentage / 100);
        emp.setSalary(newSalary);
        System.out.printf("%s님의 급여가 %.1f%% 인상되었습니다.\n", 
                         emp.getName(), percentage);
    }
    
    // 부서 이동 (객체의 내부 데이터 변경)
    public static void transferDepartment(Employee emp, String newDept) {
        String oldDept = emp.getDepartment();
        emp.setDepartment(newDept);
        System.out.printf("%s님이 %s에서 %s(으)로 이동했습니다.\n", 
                         emp.getName(), oldDept, newDept);
    }
    
    // 두 직원의 급여 비교
    public static void compareSalaries(Employee emp1, Employee emp2) {
        double diff = Math.abs(emp1.getSalary() - emp2.getSalary());
        
        if (emp1.getSalary() > emp2.getSalary()) {
            System.out.printf("%s님이 %s님보다 %.0f원 더 많습니다.\n", 
                             emp1.getName(), emp2.getName(), diff);
        } else if (emp2.getSalary() > emp1.getSalary()) {
            System.out.printf("%s님이 %s님보다 %.0f원 더 많습니다.\n", 
                             emp2.getName(), emp1.getName(), diff);
        } else {
            System.out.println("두 직원의 급여가 같습니다.");
        }
    }
    
    // 팀 전체 급여 인상
    public static void raiseTeamSalary(Employee[] team, double percentage) {
        System.out.println("\n=== 팀 전체 급여 인상 ===");
        for (Employee emp : team) {
            if (emp != null) {
                raiseSalary(emp, percentage);
            }
        }
    }
    
    public static void main(String[] args) {
        // 직원 생성
        Employee emp1 = new Employee("김철수", 3000000, "개발");
        Employee emp2 = new Employee("이영희", 3500000, "마케팅");
        Employee emp3 = new Employee("박민수", 2800000, "인사");
        
        System.out.println("=== 초기 상태 ===");
        emp1.printInfo();
        emp2.printInfo();
        emp3.printInfo();
        
        // 개별 급여 인상
        raiseSalary(emp1, 10);
        
        // 부서 이동
        transferDepartment(emp2, "기획");
        
        // 급여 비교
        System.out.println("\n=== 급여 비교 ===");
        compareSalaries(emp1, emp2);
        
        // 팀 구성
        Employee[] devTeam = {emp1, emp3, null, null};
        devTeam[2] = new Employee("정수진", 2500000, "개발");
        devTeam[3] = new Employee("최민호", 2600000, "개발");
        
        // 팀 전체 급여 인상
        raiseTeamSalary(devTeam, 5);
        
        System.out.println("\n=== 최종 상태 ===");
        for (Employee emp : devTeam) {
            if (emp != null) {
                emp.printInfo();
            }
        }
    }
}
```

### 예제 6-2: final 객체 변수
```java
/**
 * 설정 클래스 - 변경 가능한 설정값들
 */
public class Configuration {
    private String serverUrl;
    private int port;
    private boolean debugMode;
    
    public Configuration(String serverUrl, int port) {
        this.serverUrl = serverUrl;
        this.port = port;
        this.debugMode = false;
    }
    
    // Getter/Setter
    public String getServerUrl() { return serverUrl; }
    public void setServerUrl(String url) { this.serverUrl = url; }
    
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    
    public boolean isDebugMode() { return debugMode; }
    public void setDebugMode(boolean debug) { this.debugMode = debug; }
    
    public void printConfig() {
        System.out.println("Server: " + serverUrl + ":" + port);
        System.out.println("Debug Mode: " + debugMode);
    }
}

/**
 * 애플리케이션 클래스
 */
public class Application {
    // final 객체 변수 - 참조는 변경 불가, 내용은 변경 가능
    private final Configuration config;
    private final String appName;
    
    public Application(String appName) {
        this.appName = appName;
        // config 객체 생성 (이후 다른 객체로 변경 불가)
        this.config = new Configuration("localhost", 8080);
    }
    
    // 설정 변경 메서드들
    public void changeServer(String newUrl, int newPort) {
        // config = new Configuration(newUrl, newPort);  // 오류! final 변수
        
        // 하지만 객체 내부는 변경 가능
        config.setServerUrl(newUrl);
        config.setPort(newPort);
        System.out.println("서버 설정이 변경되었습니다.");
    }
    
    public void enableDebugMode() {
        config.setDebugMode(true);
        System.out.println("디버그 모드가 활성화되었습니다.");
    }
    
    public void showInfo() {
        System.out.println("\n=== " + appName + " 설정 ===");
        config.printConfig();
    }
    
    public static void main(String[] args) {
        Application app = new Application("MyApp");
        
        // 초기 설정
        app.showInfo();
        
        // 설정 변경 (가능)
        app.changeServer("192.168.1.100", 9090);
        app.enableDebugMode();
        
        // 변경된 설정
        app.showInfo();
        
        // final 배열 예제
        final int[] numbers = {1, 2, 3, 4, 5};
        // numbers = new int[10];  // 오류! final 변수
        
        // 하지만 배열 내용은 변경 가능
        numbers[0] = 10;
        numbers[1] = 20;
        
        System.out.println("\n변경된 배열:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
```

이러한 예제들은 객체지향 프로그래밍의 핵심 개념들을 실제 코드로 보여줍니다. 각 예제를 실행하고 수정해보면서 개념을 완전히 이해할 수 있습니다.