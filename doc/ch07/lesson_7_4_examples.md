# 7.4 레코드 - 수업 실습

## 1. 레코드 기본 사용 예제

### 예제 1-1: 간단한 레코드 정의와 사용

```java
public class BasicRecordExample {
    // TODO: 2D 좌표를 나타내는 레코드를 정의하세요
    // 레코드명: Point, 매개변수: int x, int y
    
    
    // TODO: 사각형을 나타내는 레코드를 정의하세요
    // 레코드명: Rectangle, 매개변수: Point topLeft, Point bottomRight
    record Rectangle(Point topLeft, Point bottomRight) {
        // TODO: 너비 계산 메서드를 작성하세요
        // 메서드명: width, 반환값: bottomRight.x() - topLeft.x()
        
        
        // TODO: 높이 계산 메서드를 작성하세요
        // 메서드명: height, 반환값: bottomRight.y() - topLeft.y()
        
        
        // TODO: 면적 계산 메서드를 작성하세요
        // 메서드명: area, 반환값: width() * height()
        
    }
    
    public static void main(String[] args) {
        // TODO: 레코드를 생성하세요
        // Point p1 (10, 20), Point p2 (50, 80), Rectangle rect (p1, p2)
        Point p1 = ;
        Point p2 = ;
        Rectangle rect = ;
        
        // 필드 접근
        System.out.println("점 1: x=" + p1.x() + ", y=" + p1.y());
        System.out.println("점 2: x=" + p2.x() + ", y=" + p2.y());
        
        // toString() 자동 구현
        System.out.println("점 1: " + p1);
        System.out.println("사각형: " + rect);
        
        // 메서드 호출
        System.out.println("사각형 너비: " + rect.width());
        System.out.println("사각형 높이: " + rect.height());
        System.out.println("사각형 면적: " + rect.area());
        
        // TODO: equals() 테스트를 수행하세요
        // p1과 같은 값을 가진 새로운 Point p3를 생성하고 equals 비교
        Point p3 = ;
        System.out.println("p1.equals(p3): " + p1.equals(p3));  // true
        System.out.println("p1 == p3: " + (p1 == p3));          // false
    }
}
```

**실행 결과:**
```
점 1: x=10, y=20
점 2: x=50, y=80
점 1: Point[x=10, y=20]
사각형: Rectangle[topLeft=Point[x=10, y=20], bottomRight=Point[x=50, y=80]]
사각형 너비: 40
사각형 높이: 60
사각형 면적: 2400
p1.equals(p3): true
p1 == p3: false
```

### 예제 1-2: 다양한 타입의 필드를 가진 레코드

```java
import java.time.LocalDate;
import java.util.List;

public class ComplexRecordExample {
    // TODO: 학생 정보 레코드를 정의하세요
    // 레코드명: Student
    // 필드: String name, int id, LocalDate birthDate, List<String> courses, double gpa
    record Student(
        String name,
        int id,
        LocalDate birthDate,
        List<String> courses,
        double gpa
    ) {
        // TODO: 나이 계산 메서드를 작성하세요
        // 메서드명: age, 반환값: 현재 연도 - 생년
        
        
        // TODO: 수강 과목 수 메서드를 작성하세요
        // 메서드명: courseCount, courses가 null이 아니면 크기 반환, null이면 0 반환
        
    }
    
    public static void main(String[] args) {
        // TODO: 학생 레코드를 생성하세요
        // 이름: "김철수", ID: 20210001, 생년월일: 2000-03-15
        // 과목: ["자바", "데이터베이스", "웹프로그래밍"], GPA: 4.2
        Student student = new Student(
            
        );
        
        // 정보 출력
        System.out.println("학생 정보: " + student);
        System.out.println("이름: " + student.name());
        System.out.println("나이: " + student.age() + "세");
        System.out.println("수강 과목 수: " + student.courseCount());
        
        // TODO: 수강 과목을 출력하세요
        // for-each 루프 사용
        System.out.println("\n수강 과목:");
        
    }
}
```

**실행 결과:**
```
학생 정보: Student[name=김철수, id=20210001, birthDate=2000-03-15, courses=[자바, 데이터베이스, 웹프로그래밍], gpa=4.2]
이름: 김철수
나이: 24세
수강 과목 수: 3

수강 과목:
- 자바
- 데이터베이스
- 웹프로그래밍
```

## 2. 레코드 생성자 커스터마이징 예제

### 예제 2-1: 유효성 검증이 있는 레코드

```java
public class ValidationRecordExample {
    // TODO: 이메일 주소 레코드를 정의하세요
    // 레코드명: Email, 매개변수: String address
    record Email(String address) {
        // TODO: 정식 생성자에서 유효성 검증을 작성하세요
        // address가 null이거나 빈 값이면 "이메일 주소는 비어있을 수 없습니다" 예외
        // "@"가 포함되지 않으면 "올바른 이메일 형식이 아닙니다" 예외
        public Email {
            
        }
        
        // TODO: 도메인 추출 메서드를 작성하세요
        // 메서드명: domain, "@" 이후의 문자열 반환
        
    }
    
    // TODO: 나이 레코드를 정의하세요
    // 레코드명: Age, 매개변수: int value
    record Age(int value) {
        // TODO: 정식 생성자에서 유효성 검증을 작성하세요
        // value가 0보다 작으면 "나이는 음수일 수 없습니다" 예외
        // value가 150보다 크면 "나이가 너무 큽니다" 예외
        public Age {
            
        }
        
        // TODO: 연령대 반환 메서드를 작성하세요
        // 메서드명: ageGroup
        // 20미만: "미성년", 30미만: "20대", 40미만: "30대", 50미만: "40대", 60미만: "50대", 그외: "60대 이상"
        
    }
    
    public static void main(String[] args) {
        try {
            // TODO: 올바른 이메일로 Email 객체를 생성하세요
            // "user@example.com"
            Email email1 = ;
            System.out.println("이메일: " + email1);
            System.out.println("도메인: " + email1.domain());
            
            // 잘못된 이메일 - 예외 발생
            // Email email2 = new Email("invalid-email");
            
            // TODO: 올바른 나이로 Age 객체를 생성하세요
            // 25세
            Age age1 = ;
            System.out.println("나이: " + age1.value() + " (" + age1.ageGroup() + ")");
            
            // 잘못된 나이 - 예외 발생
            // Age age2 = new Age(-5);
            
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}
```

**실행 결과:**
```
이메일: Email[address=user@example.com]
도메인: example.com
나이: 25 (20대)
```

### 예제 2-2: 추가 생성자가 있는 레코드

```java
public class MultipleConstructorsExample {
    // TODO: 이름 레코드를 정의하세요
    // 레코드명: FullName, 매개변수: String firstName, String lastName
    record FullName(String firstName, String lastName) {
        // 기본 정식 생성자는 자동 생성됨
        
        // TODO: 이름 하나만 받는 생성자를 작성하세요
        // 매개변수: String singleName, lastName은 빈 문자열로 설정
        
        
        // TODO: 전체 이름 반환 메서드를 작성하세요
        // 메서드명: displayName
        // lastName이 비어있으면 firstName만, 아니면 "firstName lastName" 형태
        
        
        // TODO: 커스텀 toString을 작성하세요
        // displayName() 결과를 반환
        
    }
    
    // TODO: 원 레코드를 정의하세요
    // 레코드명: Circle, 매개변수: double centerX, double centerY, double radius
    record Circle(double centerX, double centerY, double radius) {
        // TODO: 원점 중심의 원을 위한 생성자를 작성하세요
        // 매개변수: double radius, 중심은 (0, 0)으로 설정
        
        
        // TODO: 중심점과 반지름을 받는 대체 생성자를 작성하세요
        // 매개변수: Point center, double radius
        
        
        // TODO: 면적 계산 메서드를 작성하세요
        // 메서드명: area, 반환값: Math.PI * radius * radius
        
    }
    
    record Point(double x, double y) { }
    
    public static void main(String[] args) {
        // TODO: 다양한 생성자를 사용하여 이름 객체들을 생성하세요
        FullName name1 = ;  // "홍", "길동"
        FullName name2 = ;  // "Madonna"
        
        System.out.println("이름 1: " + name1);
        System.out.println("이름 2: " + name2);
        
        // TODO: 다양한 생성자를 사용하여 원 객체들을 생성하세요
        Circle circle1 = ;  // 반지름 5.0 (원점 중심)
        Circle circle2 = ;  // 중심 (10, 10), 반지름 3.0
        Circle circle3 = ;  // Point(20, 20) 중심, 반지름 4.0
        
        System.out.println("\n원 1: " + circle1);
        System.out.println("원 2: " + circle2);
        System.out.println("원 3: " + circle3);
        System.out.printf("원 1 면적: %.2f\n", circle1.area());
    }
}
```

**실행 결과:**
```
이름 1: 홍 길동
이름 2: Madonna

원 1: Circle[centerX=0.0, centerY=0.0, radius=5.0]
원 2: Circle[centerX=10.0, centerY=10.0, radius=3.0]
원 3: Circle[centerX=20.0, centerY=20.0, radius=4.0]
원 1 면적: 78.54
```

## 3. 레코드와 컬렉션 활용 예제

### 예제 3-1: 레코드를 ArrayList에 저장

```java
import java.util.ArrayList;
import java.util.List;

public class RecordListExample {
    // TODO: 상품 레코드를 정의하세요
    // 레코드명: Product, 매개변수: String id, String name, double price, int stock
    record Product(String id, String name, double price, int stock) {
        // TODO: 재고 가치 계산 메서드를 작성하세요
        // 메서드명: stockValue, 반환값: price * stock
        
        
        // TODO: 재고 부족 여부 메서드를 작성하세요
        // 메서드명: isLowStock, 반환값: stock < 10
        
    }
    
    // 상품 관리 클래스
    static class ProductManager {
        private List<Product> products = new ArrayList<>();
        
        public void addProduct(Product product) {
            products.add(product);
        }
        
        // TODO: 재고 부족 상품 찾기 메서드를 작성하세요
        // 메서드명: getLowStockProducts
        // isLowStock()이 true인 상품들을 새 List에 담아 반환
        public List<Product> getLowStockProducts() {
            
        }
        
        // TODO: 총 재고 가치 계산 메서드를 작성하세요
        // 메서드명: getTotalStockValue
        // 모든 상품의 stockValue() 합계 반환
        public double getTotalStockValue() {
            
        }
        
        // TODO: 가격 범위로 상품 검색 메서드를 작성하세요
        // 메서드명: findByPriceRange, 매개변수: double min, double max
        // min <= price <= max 조건을 만족하는 상품들을 새 List에 담아 반환
        public List<Product> findByPriceRange(double min, double max) {
            
        }
    }
    
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        
        // TODO: 상품들을 추가하세요
        // P001, 노트북, 1200000, 5
        // P002, 마우스, 25000, 50
        // P003, 키보드, 85000, 8
        // P004, 모니터, 450000, 12
        // P005, USB, 15000, 3
        
        
        // 재고 부족 상품
        System.out.println("=== 재고 부족 상품 ===");
        for (Product p : manager.getLowStockProducts()) {
            System.out.printf("%s - %s: %d개\n", p.id(), p.name(), p.stock());
        }
        
        // 가격 범위 검색
        System.out.println("\n=== 10만원 이하 상품 ===");
        for (Product p : manager.findByPriceRange(0, 100000)) {
            System.out.printf("%s: %,.0f원\n", p.name(), p.price());
        }
        
        // 총 재고 가치
        System.out.printf("\n총 재고 가치: %,.0f원\n", manager.getTotalStockValue());
    }
}
```

**실행 결과:**
```
=== 재고 부족 상품 ===
P001 - 노트북: 5개
P003 - 키보드: 8개
P005 - USB: 3개

=== 10만원 이하 상품 ===
마우스: 25,000원
키보드: 85,000원
USB: 15,000원

총 재고 가치: 7,505,000원
```

### 예제 3-2: 레코드를 Map의 키로 사용

```java
import java.util.HashMap;
import java.util.Map;

public class RecordAsKeyExample {
    // TODO: 체스 좌표 레코드를 정의하세요
    // 레코드명: ChessPosition, 매개변수: char file, int rank
    record ChessPosition(char file, int rank) {
        // TODO: 정식 생성자에서 유효성 검증을 작성하세요
        // file이 'a'보다 작거나 'h'보다 크면 "파일은 a-h 사이여야 합니다" 예외
        // rank가 1보다 작거나 8보다 크면 "랭크는 1-8 사이여야 합니다" 예외
        public ChessPosition {
            
        }
        
        // TODO: toString 메서드를 재정의하세요
        // file + rank 형태의 문자열 반환 (예: "e1")
        
    }
    
    // 체스 기물 열거형
    enum ChessPiece {
        KING("킹"), QUEEN("퀸"), ROOK("룩"), 
        BISHOP("비숍"), KNIGHT("나이트"), PAWN("폰");
        
        private final String korean;
        ChessPiece(String korean) { this.korean = korean; }
        public String getKorean() { return korean; }
    }
    
    public static void main(String[] args) {
        // TODO: 체스판을 생성하세요 (Map<ChessPosition, ChessPiece>)
        Map<ChessPosition, ChessPiece> board = ;
        
        // TODO: 백색 기물을 배치하세요
        // a1: ROOK, b1: KNIGHT, c1: BISHOP, d1: QUEEN, e1: KING, f1: BISHOP, g1: KNIGHT, h1: ROOK
        
        
        // TODO: 폰을 배치하세요 (a2~h2에 모두 PAWN)
        // for 루프 사용
        
        
        // TODO: 특정 위치의 기물을 확인하세요
        // e1 위치의 기물을 조회하고 출력
        ChessPosition pos1 = ;
        ChessPiece piece = ;
        System.out.println(pos1 + " 위치의 기물: " + piece.getKorean());
        
        // TODO: equals 테스트를 수행하세요
        // 같은 값의 새 객체로도 조회 가능한지 확인
        ChessPosition pos2 = ;
        System.out.println("pos1 == pos2: " + (pos1 == pos2));  // false
        System.out.println("pos1.equals(pos2): " + pos1.equals(pos2));  // true
        System.out.println("같은 위치 조회: " + board.get(pos2).getKorean());
        
        // TODO: 전체 보드를 출력하세요
        // 1, 2번 rank만 출력 (기물이 있는 곳만)
        System.out.println("\n=== 체스판 상태 ===");
        
    }
}
```

**실행 결과:**
```
e1 위치의 기물: 킹
pos1 == pos2: false
pos1.equals(pos2): true
같은 위치 조회: 킹

=== 체스판 상태 ===
a2: 폰  b2: 폰  c2: 폰  d2: 폰  e2: 폰  f2: 폰  g2: 폰  h2: 폰  
a1: 룩  b1: 나이트  c1: 비숍  d1: 퀸  e1: 킹  f1: 비숍  g1: 나이트  h1: 룩  
```

## 4. 불변성을 활용한 예제

### 예제 4-1: 불변 객체의 장점

```java
import java.util.ArrayList;
import java.util.List;

public class ImmutabilityExample {
    // TODO: 은행 계좌 거래 레코드를 정의하세요 (불변)
    // 레코드명: Transaction
    // 필드: String id, String accountNumber, String type, double amount, double balanceAfter, String timestamp
    
    
    // TODO: 계좌 상태 레코드를 정의하세요 (불변)
    // 레코드명: AccountState, 매개변수: String accountNumber, double balance
    record AccountState(String accountNumber, double balance) {
        // TODO: 입금 후 새 상태 반환 메서드를 작성하세요
        // 메서드명: deposit, 매개변수: double amount
        // 새로운 AccountState 객체를 반환 (balance + amount)
        
        
        // TODO: 출금 후 새 상태 반환 메서드를 작성하세요
        // 메서드명: withdraw, 매개변수: double amount
        // 잔액이 부족하면 "잔액 부족" 예외, 아니면 새로운 AccountState 반환
        
    }
    
    // 거래 처리기
    static class TransactionProcessor {
        private List<Transaction> transactions = new ArrayList<>();
        private int transactionId = 1;
        
        // TODO: 입금 처리 메서드를 작성하세요
        // 메서드명: processDeposit, 매개변수: AccountState account, double amount
        // 새로운 상태를 생성하고 거래 기록을 저장한 후 새 상태 반환
        public AccountState processDeposit(AccountState account, double amount) {
            
        }
        
        // TODO: 출금 처리 메서드를 작성하세요
        // 메서드명: processWithdrawal, 매개변수: AccountState account, double amount
        // 새로운 상태를 생성하고 거래 기록을 저장한 후 새 상태 반환
        public AccountState processWithdrawal(AccountState account, double amount) {
            
        }
        
        // TODO: 거래 내역 조회 메서드를 작성하세요
        // 메서드명: getTransactionHistory, 매개변수: String accountNumber
        // 해당 계좌번호의 모든 거래 내역을 List로 반환
        public List<Transaction> getTransactionHistory(String accountNumber) {
            
        }
    }
    
    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();
        
        // TODO: 초기 계좌 상태를 생성하세요
        // 계좌번호: "123-456-789", 잔액: 100000
        AccountState account = ;
        System.out.println("초기 상태: " + account);
        
        // TODO: 거래를 처리하세요 (각 거래마다 새로운 상태 생성)
        // 50000원 입금, 30000원 출금, 20000원 입금
        account = ;  // 입금
        System.out.println("입금 후: " + account);
        
        account = ;  // 출금
        System.out.println("출금 후: " + account);
        
        account = ;  // 입금
        System.out.println("입금 후: " + account);
        
        // 거래 내역 출력
        System.out.println("\n=== 거래 내역 ===");
        for (Transaction txn : processor.getTransactionHistory("123-456-789")) {
            System.out.printf("%s | %s | %,.0f원 | 잔액: %,.0f원\n",
                txn.id(), txn.type(), txn.amount(), txn.balanceAfter());
        }
    }
}
```

**실행 결과:**
```
초기 상태: AccountState[accountNumber=123-456-789, balance=100000.0]
입금 후: AccountState[accountNumber=123-456-789, balance=150000.0]
출금 후: AccountState[accountNumber=123-456-789, balance=120000.0]
입금 후: AccountState[accountNumber=123-456-789, balance=140000.0]

=== 거래 내역 ===
TXN1 | 입금 | 50,000원 | 잔액: 150,000원
TXN2 | 출금 | 30,000원 | 잔액: 120,000원
TXN3 | 입금 | 20,000원 | 잔액: 140,000원
```

### 예제 4-2: 복소수 연산 (교재 예제 확장)

```java
public class ComplexNumberExample {
    // TODO: 복소수 레코드를 정의하세요
    // 레코드명: Complex, 매개변수: double real, double imaginary
    record Complex(double real, double imaginary) {
        // 상수 정의
        public static final Complex ZERO = new Complex(0, 0);
        public static final Complex ONE = new Complex(1, 0);
        public static final Complex I = new Complex(0, 1);
        
        // TODO: 실수로부터 복소수 생성하는 생성자를 작성하세요
        // 매개변수: double real, imaginary는 0으로 설정
        
        
        // TODO: 덧셈 메서드를 작성하세요
        // 메서드명: add, 매개변수: Complex other
        // 새로운 Complex 객체 반환 (실부끼리, 허부끼리 더함)
        
        
        // TODO: 뺄셈 메서드를 작성하세요
        // 메서드명: subtract, 매개변수: Complex other
        // 새로운 Complex 객체 반환
        
        
        // TODO: 곱셈 메서드를 작성하세요
        // 메서드명: multiply, 매개변수: Complex other
        // 복소수 곱셈 공식: (a+bi)(c+di) = (ac-bd) + (ad+bc)i
        
        
        // TODO: 절댓값 메서드를 작성하세요
        // 메서드명: magnitude
        // sqrt(real² + imaginary²) 반환
        
        
        // TODO: 켤레 복소수 메서드를 작성하세요
        // 메서드명: conjugate
        // 허부의 부호를 바꾼 새 Complex 반환
        
        
        // TODO: 보기 좋은 문자열 표현 메서드를 작성하세요
        // toString 재정의
        // imaginary가 0이면 실부만, real이 0이면 허부만, 
        // imaginary가 음수면 "a - bi", 양수면 "a + bi" 형태
        
    }
    
    public static void main(String[] args) {
        // TODO: 복소수 객체들을 생성하세요
        Complex z1 = ;  // 3 + 4i
        Complex z2 = ;  // 1 - 2i
        
        System.out.println("z1 = " + z1);
        System.out.println("z2 = " + z2);
        
        // TODO: 연산을 수행하세요 (새로운 객체 생성)
        Complex sum = ;    // z1 + z2
        Complex diff = ;   // z1 - z2
        Complex prod = ;   // z1 * z2
        
        System.out.println("\nz1 + z2 = " + sum);
        System.out.println("z1 - z2 = " + diff);
        System.out.println("z1 * z2 = " + prod);
        
        System.out.println("\n|z1| = " + z1.magnitude());
        System.out.println("z1의 켤레 = " + z1.conjugate());
        
        // TODO: 복잡한 계산을 수행하세요: (z1 + z2) * I
        Complex result = ;
        System.out.println("\n(z1 + z2) * i = " + result);
        
        // TODO: 체인 연산을 수행하세요: (1 + i) * 2 - 1
        Complex chain = ;
        System.out.println("(1 + i) * 2 - 1 = " + chain);
    }
}
```

**실행 결과:**
```
z1 = 3.00 + 4.00i
z2 = 1.00 - 2.00i

z1 + z2 = 4.00 + 2.00i
z1 - z2 = 2.00 + 6.00i
z1 * z2 = 11.00 - 2.00i

|z1| = 5.0
z1의 켤레 = 3.00 - 4.00i

(z1 + z2) * i = -2.00 + 4.00i
(1 + i) * 2 - 1 = 1.00 + 2.00i
```

## 5. 실용적인 레코드 활용 예제

### 예제 5-1: 설정 관리 시스템

```java
import java.util.Map;

public class ConfigurationExample {
    // TODO: 데이터베이스 설정 레코드를 정의하세요
    // 레코드명: DatabaseConfig
    // 필드: String host, int port, String database, String username, String password, Map<String, String> options
    record DatabaseConfig(
        String host,
        int port,
        String database,
        String username,
        String password,
        Map<String, String> options
    ) {
        // TODO: 연결 URL 생성 메서드를 작성하세요
        // 메서드명: getConnectionUrl
        // "jdbc:mysql://host:port/database?option1=value1&option2=value2" 형태
        
    }
    
    // TODO: 서버 설정 레코드를 정의하세요
    // 레코드명: ServerConfig
    // 필드: int port, String contextPath, int maxConnections, int timeout
    
    
    // TODO: 애플리케이션 설정 레코드를 정의하세요
    // 레코드명: AppConfig
    // 필드: String appName, String version, DatabaseConfig database, ServerConfig server, boolean debugMode
    
    
    public static void main(String[] args) {
        // TODO: 설정 객체들을 생성하세요
        DatabaseConfig dbConfig = new DatabaseConfig(
            
        );
        
        ServerConfig serverConfig = new ServerConfig(
            
        );
        
        AppConfig appConfig = new AppConfig(
            
        );
        
        // 설정 정보 출력
        System.out.println("=== 애플리케이션 설정 ===");
        System.out.println("앱 이름: " + appConfig.appName());
        System.out.println("버전: " + appConfig.version());
        System.out.println("디버그 모드: " + appConfig.debugMode());
        
        System.out.println("\n=== 데이터베이스 설정 ===");
        System.out.println("호스트: " + appConfig.database().host());
        System.out.println("포트: " + appConfig.database().port());
        System.out.println("연결 URL: " + appConfig.database().getConnectionUrl());
        
        System.out.println("\n=== 서버 설정 ===");
        System.out.println("포트: " + appConfig.server().port());
        System.out.println("컨텍스트 경로: " + appConfig.server().contextPath());
        System.out.println("최대 연결 수: " + appConfig.server().maxConnections());
    }
}
```

**실행 결과:**
```
=== 애플리케이션 설정 ===
앱 이름: MyApplication
버전: 1.0.0
디버그 모드: true

=== 데이터베이스 설정 ===
호스트: localhost
포트: 3306
연결 URL: jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8

=== 서버 설정 ===
포트: 8080
컨텍스트 경로: /api
최대 연결 수: 100
```

### 예제 5-2: 게임 데이터 관리

```java
import java.util.ArrayList;
import java.util.List;

public class GameDataExample {
    // TODO: 게임 캐릭터 스탯 레코드를 정의하세요
    // 레코드명: Stats, 매개변수: int health, int attack, int defense, int speed
    record Stats(int health, int attack, int defense, int speed) {
        // TODO: 전투력 계산 메서드를 작성하세요
        // 메서드명: combatPower, 공식: attack * 2 + defense + speed
        
    }
    
    // TODO: 아이템 레코드를 정의하세요
    // 레코드명: Item, 매개변수: String name, String type, int value, Stats bonusStats
    
    
    // TODO: 캐릭터 레코드를 정의하세요
    // 레코드명: Character, 매개변수: String name, String job, Stats baseStats, List<Item> inventory
    record Character(String name, String job, Stats baseStats, List<Item> inventory) {
        // TODO: 총 스탯 계산 메서드를 작성하세요 (기본 + 아이템 보너스)
        // 메서드명: totalStats
        // 기본 스탯에 모든 아이템의 bonusStats를 합산
        
        
        // TODO: 아이템 추가 메서드를 작성하세요 (새 캐릭터 반환)
        // 메서드명: addItem, 매개변수: Item item
        // 기존 inventory를 복사하고 새 아이템을 추가한 새로운 Character 반환
        
    }
    
    public static void main(String[] args) {
        // TODO: 아이템들을 생성하세요
        Item sword = ;   // "강철 검", "무기", 1000, Stats(0, 10, 0, 0)
        Item shield = ;  // "철 방패", "방어구", 800, Stats(0, 0, 8, 0)
        Item boots = ;   // "신속의 부츠", "신발", 500, Stats(0, 0, 2, 5)
        
        // TODO: 캐릭터를 생성하세요
        Character warrior = new Character(
            
        );
        
        // TODO: 아이템을 장착하세요 (불변성 유지)
        warrior = ;  // sword 추가
        warrior = ;  // shield 추가
        warrior = ;  // boots 추가
        
        // 캐릭터 정보 출력
        System.out.println("=== 캐릭터 정보 ===");
        System.out.println("이름: " + warrior.name());
        System.out.println("직업: " + warrior.job());
        
        System.out.println("\n기본 스탯:");
        Stats base = warrior.baseStats();
        System.out.printf("체력: %d, 공격력: %d, 방어력: %d, 속도: %d\n",
            base.health(), base.attack(), base.defense(), base.speed());
        
        System.out.println("\n장착 아이템:");
        for (Item item : warrior.inventory()) {
            System.out.println("- " + item.name() + " (" + item.type() + ")");
        }
        
        System.out.println("\n총 스탯:");
        Stats total = warrior.totalStats();
        System.out.printf("체력: %d, 공격력: %d, 방어력: %d, 속도: %d\n",
            total.health(), total.attack(), total.defense(), total.speed());
        System.out.println("전투력: " + total.combatPower());
    }
}
```

**실행 결과:**
```
=== 캐릭터 정보 ===
이름: 아서
직업: 전사

기본 스탯:
체력: 100, 공격력: 15, 방어력: 10, 속도: 5

장착 아이템:
- 강철 검 (무기)
- 철 방패 (방어구)
- 신속의 부츠 (신발)

총 스탯:
체력: 100, 공격력: 25, 방어력: 20, 속도: 10
전투력: 80
```

이 예제들은 Java 레코드의 다양한 활용 방법을 연습할 수 있도록 구성되었습니다. 레코드의 기본 사용법부터 생성자 커스터마이징, 컬렉션과의 활용, 불변성의 장점, 실용적인 응용까지 실제 프로그래밍에서 자주 사용되는 패턴들을 각 TODO 주석을 참고하여 완성해보세요!