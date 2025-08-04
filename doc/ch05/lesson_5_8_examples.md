# 5.8 중첩 클래스(Nested Classes) - 수업 실습

## 1. 정적 중첩 클래스 예제

### 실습 1-1: 좌표 시스템
**목표**: 정적 중첩 클래스를 사용하여 2D와 3D 좌표 시스템을 구현해보세요.

```java
/**
 * 2D와 3D 좌표를 다루는 좌표 시스템
 */
public class CoordinateSystem {
    
    // 2D 좌표를 나타내는 정적 중첩 클래스
    public static class Point2D {
        private double x, y;
        
        public Point2D(double x, double y) {
            // TODO 1: x와 y 좌표 초기화하기
        }
        
        public double distanceFromOrigin() {
            // TODO 2: 원점(0, 0)으로부터의 거리 계산하기
            // 피타고라스 정리 사용: sqrt(x² + y²)
            return 0;
        }
        
        public double distanceTo(Point2D other) {
            // TODO 3: 다른 점까지의 거리 계산하기
            // 두 점 사이의 거리 공식 사용
            return 0;
        }
        
        @Override
        public String toString() {
            // TODO 4: "(x, y)" 형식으로 좌표 반환하기
            // 소수점 2자리까지 표시
            return "";
        }
    }
    
    // 3D 좌표를 나타내는 정적 중첩 클래스
    public static class Point3D {
        private double x, y, z;
        
        public Point3D(double x, double y, double z) {
            // TODO 5: x, y, z 좌표 초기화하기
        }
        
        public double distanceFromOrigin() {
            // TODO 6: 3D 공간에서 원점으로부터의 거리 계산하기
            // sqrt(x² + y² + z²)
            return 0;
        }
        
        public Point2D projectToXY() {
            // TODO 7: XY 평면으로 투영하기 (z 좌표 무시)
            return null;
        }
        
        public Point2D projectToXZ() {
            // TODO 8: XZ 평면으로 투영하기 (y 좌표 무시)
            return null;
        }
        
        public Point2D projectToYZ() {
            // TODO 9: YZ 평면으로 투영하기 (x 좌표 무시)
            return null;
        }
        
        @Override
        public String toString() {
            // TODO 10: "(x, y, z)" 형식으로 좌표 반환하기
            return "";
        }
    }
    
    // 선분을 나타내는 정적 중첩 클래스
    public static class LineSegment {
        private Point3D start;
        private Point3D end;
        
        public LineSegment(Point3D start, Point3D end) {
            // TODO 11: 시작점과 끝점 초기화하기
        }
        
        public double getLength() {
            // TODO 12: 선분의 길이 계산하기
            // 두 점 사이의 3D 거리 공식 사용
            return 0;
        }
        
        public Point3D getMidpoint() {
            // TODO 13: 선분의 중점 계산하기
            // 각 좌표의 평균값
            return null;
        }
    }
}

// 테스트 클래스
class CoordinateTest {
    public static void main(String[] args) {
        // TODO 14: 2D 점 생성하기
        // p1: (3, 4), p2: (6, 8)
        
        // TODO 15: 2D 점 정보 출력하기
        // p1, p2 출력
        // 원점에서 p1까지의 거리
        // p1에서 p2까지의 거리
        
        // TODO 16: 3D 점 생성하기
        // p3d1: (1, 2, 3), p3d2: (4, 5, 6)
        
        // TODO 17: 3D 점 정보 출력하기
        // p3d1 출력
        // XY 평면으로의 투영 출력
        
        // TODO 18: 선분 생성하고 정보 출력하기
        // p3d1에서 p3d2로의 선분
        // 길이와 중점 출력
    }
}

#### 실행 결과 (참고용):
```
2D 점:
P1: (3.00, 4.00)
P2: (6.00, 8.00)
원점에서 P1까지의 거리: 5.0
P1에서 P2까지의 거리: 5.0

3D 점:
P3D1: (1.00, 2.00, 3.00)
XY 평면 투영: (1.00, 2.00)

선분:
길이: 5.196152422706632
중점: (2.50, 3.50, 4.50)
```
```

### 실습 1-2: 데이터베이스 연결 설정
**목표**: Builder 패턴을 사용한 정적 중첩 클래스로 설정 관리 시스템을 구현해보세요.

```java
/**
 * 데이터베이스 연결을 관리하는 클래스
 */
public class DatabaseManager {
    
    // 연결 설정을 저장하는 정적 중첩 클래스
    public static class ConnectionConfig {
        private String host;
        private int port;
        private String database;
        private String username;
        private String password;
        
        // Builder 패턴
        public static class Builder {
            private String host = "localhost";
            private int port = 3306;
            private String database;
            private String username;
            private String password;
            
            public Builder host(String host) {
                // TODO 19: host 설정하고 this 반환하기
                return null;
            }
            
            public Builder port(int port) {
                // TODO 20: port 설정하고 this 반환하기
                return null;
            }
            
            public Builder database(String database) {
                // TODO 21: database 설정하고 this 반환하기
                return null;
            }
            
            public Builder username(String username) {
                // TODO 22: username 설정하고 this 반환하기
                return null;
            }
            
            public Builder password(String password) {
                // TODO 23: password 설정하고 this 반환하기
                return null;
            }
            
            public ConnectionConfig build() {
                // TODO 24: ConnectionConfig 객체 생성하고 필드 설정하기
                // 모든 Builder 필드를 config에 복사
                return null;
            }
        }
        
        private ConnectionConfig() {} // private 생성자
        
        public String getConnectionUrl() {
            // TODO 25: JDBC 연결 URL 생성하기
            // 형식: "jdbc:mysql://host:port/database"
            return "";
        }
        
        @Override
        public String toString() {
            // TODO 26: "ConnectionConfig[username@host:port]" 형식으로 반환하기
            return "";
        }
    }
    
    // 쿼리 결과를 저장하는 정적 중첩 클래스
    public static class QueryResult {
        private List<Map<String, Object>> rows;
        private int affectedRows;
        private long executionTime;
        
        public QueryResult() {
            this.rows = new ArrayList<>();
        }
        
        public void addRow(Map<String, Object> row) {
            // TODO 27: rows에 row 추가하기
        }
        
        public int getRowCount() {
            // TODO 28: 행의 개수 반환하기
            return 0;
        }
        
        public List<Map<String, Object>> getRows() {
            // TODO 29: rows의 복사본 반환하기
            return null;
        }
    }
    
    private ConnectionConfig config;
    
    public DatabaseManager(ConnectionConfig config) {
        // TODO 30: config 초기화하기
    }
    
    public void connect() {
        System.out.println("데이터베이스 연결: " + config.getConnectionUrl());
    }
    
    public QueryResult executeQuery(String sql) {
        System.out.println("쿼리 실행: " + sql);
        // TODO 31: QueryResult 객체 생성하고 예시 데이터 추가하기
        // 예시: id=1, name="Test"를 가진 row 추가
        return null;
    }
}

// 테스트
class DatabaseTest {
    public static void main(String[] args) {
        // TODO 32: Builder 패턴으로 ConnectionConfig 생성하기
        // host: "192.168.1.100", port: 3306
        // database: "mydb", username: "admin", password: "secret"
        
        // TODO 33: 연결 설정 정보 출력하기
        // config와 연결 URL 출력
        
        // TODO 34: DatabaseManager 생성하고 연결하기
        
        // TODO 35: 쿼리 실행하고 결과 출력하기
        // "SELECT * FROM users" 쿼리 실행
        // 결과 행 수 출력
    }
}

#### 실행 결과 (참고용):
```
연결 설정: ConnectionConfig[admin@192.168.1.100:3306]
연결 URL: jdbc:mysql://192.168.1.100:3306/mydb
데이터베이스 연결: jdbc:mysql://192.168.1.100:3306/mydb
쿼리 실행: SELECT * FROM users
결과 행 수: 1
```
```

## 2. 내부 클래스 예제

### 실습 2-1: 리스트와 반복자
**목표**: 내부 클래스를 사용하여 연결 리스트와 반복자를 구현해보세요.

```java
/**
 * 간단한 연결 리스트 구현
 */
public class SimpleLinkedList<T> {
    private Node head;
    private int size;
    
    // 노드를 나타내는 내부 클래스
    private class Node {
        T data;
        Node next;
        
        Node(T data) {
            // TODO 36: data 초기화하고 next를 null로 설정하기
        }
    }
    
    // 반복자를 구현하는 내부 클래스
    public class ListIterator implements Iterator<T> {
        private Node current;
        private Node previous;
        
        public ListIterator() {
            // TODO 37: current를 head로, previous를 null로 초기화하기
        }
        
        @Override
        public boolean hasNext() {
            // TODO 38: 다음 요소가 있는지 확인하기
            return false;
        }
        
        @Override
        public T next() {
            // TODO 39: 다음 요소 반환하기
            // hasNext()가 false면 NoSuchElementException 던지기
            // current의 데이터 저장, previous와 current 업데이트
            return null;
        }
        
        // 현재 요소 삭제
        public void remove() {
            // TODO 40: 현재 위치의 요소 삭제하기
            // previous가 null이면 첫 번째 요소 삭제
            // 아니면 previous의 앞 노드 찾아서 연결 수정
            // size 감소
        }
        
        // 현재 위치에 삽입
        public void insert(T data) {
            // TODO 41: 현재 위치에 새 요소 삽입하기
            // 새 노드 생성
            // previous가 null이면 리스트 맨 앞에 삽입
            // 아니면 previous와 current 사이에 삽입
            // previous와 size 업데이트
        }
    }
    
    public void add(T data) {
        // TODO 42: 리스트 끝에 요소 추가하기
        // 새 노드 생성
        // head가 null이면 head로 설정
        // 아니면 마지막 노드 찾아서 연결
        // size 증가
    }
    
    public ListIterator iterator() {
        // TODO 43: 새로운 ListIterator 반환하기
        return null;
    }
    
    public int size() {
        // TODO 44: 리스트 크기 반환하기
        return 0;
    }
    
    @Override
    public String toString() {
        // TODO 45: 리스트를 "[item1, item2, ...]" 형식으로 반환하기
        // StringBuilder 사용
        // 모든 노드 순회하며 데이터 추가
        return "";
    }
}

// 테스트
class ListTest {
    public static void main(String[] args) {
        // TODO 46: SimpleLinkedList 생성하고 요소 추가하기
        // "첫번째", "두번째", "세번째" 추가
        
        // TODO 47: 초기 리스트 출력하기
        
        // TODO 48: 반복자로 순회하며 "두번째" 뒤에 "새로운" 삽입하기
        // ListIterator 사용
        // hasNext()와 next()로 순회
        // "두번째"를 찾으면 insert() 호출
        
        // TODO 49: 수정된 리스트 출력하기
    }
}

#### 실행 결과 (참고용):
```
초기 리스트: [첫번째, 두번째, 세번째]
요소: 첫번째
요소: 두번째
요소: 새로운
요소: 세번째
수정된 리스트: [첫번째, 두번째, 새로운, 세번째]
```
```

### 실습 2-2: GUI 컴포넌트와 이벤트 처리
**목표**: 내부 클래스를 사용하여 이벤트 처리 시스템을 구현해보세요.

```java
/**
 * 간단한 GUI 버튼 클래스
 */
public class CustomButton {
    private String text;
    private boolean enabled = true;
    private List<ClickListener> listeners;
    
    public CustomButton(String text) {
        // TODO 50: text 초기화하고 listeners를 새 ArrayList로 초기화하기
    }
    
    // 클릭 이벤트를 처리하는 내부 클래스
    public class ClickEvent {
        private long timestamp;
        private int x, y;  // 클릭 좌표
        
        public ClickEvent(int x, int y) {
            // TODO 51: timestamp를 현재 시간으로, x와 y 좌표 초기화하기
        }
        
        public String getButtonText() {
            // TODO 52: 외부 클래스의 text 반환하기
            return "";
        }
        
        public boolean isButtonEnabled() {
            // TODO 53: 외부 클래스의 enabled 상태 반환하기
            return false;
        }
        
        @Override
        public String toString() {
            // TODO 54: "ClickEvent[button=text, pos=(x,y), time=timestamp]" 형식으로 반환하기
            return "";
        }
    }
    
    // 클릭 리스너 인터페이스
    public interface ClickListener {
        void onClick(ClickEvent event);
    }
    
    public void addClickListener(ClickListener listener) {
        // TODO 55: listeners에 listener 추가하기
    }
    
    // 버튼 클릭 시뮬레이션
    public void click(int x, int y) {
        // TODO 56: 버튼 클릭 처리하기
        // enabled가 false면 "버튼이 비활성화되어 있습니다." 출력하고 리턴
        // ClickEvent 생성
        // 모든 listener에 onClick 호출
    }
    
    public void setEnabled(boolean enabled) {
        // TODO 57: enabled 상태 설정하기
    }
    
    public String getText() {
        // TODO 58: text 반환하기
        return "";
    }
}

// 테스트
class ButtonTest {
    public static void main(String[] args) {
        // TODO 59: CustomButton 생성하기 (텍스트: "확인")
        
        // TODO 60: 익명 클래스로 ClickListener 추가하기
        // onClick에서 "버튼 클릭됨: " + event 출력
        
        // TODO 61: 람다 표현식으로 ClickListener 추가하기
        // "람다 리스너: [button text] 클릭!" 출력
        
        // TODO 62: 버튼 클릭하기 (100, 50)
        
        // TODO 63: 버튼 비활성화 후 다시 클릭하기
    }
}

#### 실행 결과 (참고용):
```
버튼 클릭됨: ClickEvent[button=확인, pos=(100,50), time=1700000000000]
람다 리스너: 확인 클릭!
버튼이 비활성화되어 있습니다.
```
```

## 3. 익명 내부 클래스 예제

### 실습 3-1: 정렬과 필터링
**목표**: 익명 내부 클래스를 사용하여 정렬과 필터링 기능을 구현해보세요.

```java
/**
 * 학생 관리 시스템
 */
public class StudentManager {
    private List<Student> students = new ArrayList<>();
    
    static class Student {
        String name;
        int age;
        double gpa;
        
        Student(String name, int age, double gpa) {
            // TODO 64: name, age, gpa 초기화하기
        }
        
        @Override
        public String toString() {
            // TODO 65: "name (나이: age, 학점: gpa)" 형식으로 반환하기
            return "";
        }
    }
    
    public void addStudent(String name, int age, double gpa) {
        // TODO 66: 새 Student 객체 생성하여 students에 추가하기
    }
    
    // 다양한 정렬 방법
    public void sortByName() {
        // TODO 67: 익명 클래스로 Comparator 구현하여 이름순 정렬하기
        // s1.name.compareTo(s2.name) 사용
    }
    
    public void sortByAge() {
        // TODO 68: 익명 클래스로 Comparator 구현하여 나이순 정렬하기
        // Integer.compare(s1.age, s2.age) 사용
    }
    
    public void sortByGPA() {
        // TODO 69: 익명 클래스로 Comparator 구현하여 학점 내림차순 정렬하기
        // Double.compare(s2.gpa, s1.gpa) 사용 (내림차순)
    }
    
    // 필터링
    public List<Student> filterStudents(Predicate<Student> condition) {
        // TODO 70: 조건에 맞는 학생만 필터링하기
        // 새 리스트 생성
        // condition.test()로 각 학생 검사
        // 조건에 맞으면 리스트에 추가
        return null;
    }
    
    public void printStudents(String title) {
        // TODO 71: 학생 리스트 출력하기
        // "=== title ===" 출력
        // 모든 학생 출력
    }
}

// 테스트
class StudentTest {
    public static void main(String[] args) {
        // TODO 72: StudentManager 생성하고 학생 4명 추가하기
        // 김철수(22, 3.8), 이영희(21, 4.2)
        // 박민수(23, 3.5), 최지우(20, 4.0)
        
        // TODO 73: 원본 학생 리스트 출력하기
        
        // TODO 74: 이름순으로 정렬하고 출력하기
        
        // TODO 75: 학점순으로 정렬하고 출력하기
        
        // TODO 76: 익명 클래스로 GPA 4.0 이상 학생 필터링하기
        // Predicate<StudentManager.Student> 구현
        // test 메서드에서 s.gpa >= 4.0 검사
        
        // TODO 77: 필터링 결과 출력하기
        
        // TODO 78: 람다 표현식으로 21세 이하 학생 필터링하기
        // s -> s.age <= 21
        
        // TODO 79: 필터링 결과 출력하기
    }
}

#### 실행 결과 (참고용):
```
=== 원본 ===
김철수 (나이: 22, 학점: 3.80)
이영희 (나이: 21, 학점: 4.20)
박민수 (나이: 23, 학점: 3.50)
최지우 (나이: 20, 학점: 4.00)

=== 이름순 정렬 ===
김철수 (나이: 22, 학점: 3.80)
박민수 (나이: 23, 학점: 3.50)
이영희 (나이: 21, 학점: 4.20)
최지우 (나이: 20, 학점: 4.00)

=== 학점순 정렬 ===
이영희 (나이: 21, 학점: 4.20)
최지우 (나이: 20, 학점: 4.00)
김철수 (나이: 22, 학점: 3.80)
박민수 (나이: 23, 학점: 3.50)

=== 학점 4.0 이상 ===
이영희 (나이: 21, 학점: 4.20)
최지우 (나이: 20, 학점: 4.00)

=== 21세 이하 ===
이영희 (나이: 21, 학점: 4.20)
최지우 (나이: 20, 학점: 4.00)
```
```

### 실습 3-2: 스레드와 타이머
**목표**: 익명 클래스와 람다 표현식을 사용하여 스레드와 타이머를 구현해보세요.

```java
/**
 * 익명 클래스를 사용한 스레드와 타이머 예제
 */
public class ThreadExample {
    
    public static void main(String[] args) {
        System.out.println("메인 스레드 시작");
        
        // TODO 80: 익명 클래스로 Thread 생성하기
        // Thread를 상속받아 run() 메서드 오버라이드
        // 1부터 5까지 "Worker 1: i" 출력 (1초마다)
        Thread worker1 = null;
        
        // TODO 81: 익명 클래스로 Runnable 구현하기
        // Runnable 인터페이스 구현
        // 1부터 5까지 "Worker 2: i" 출력 (1.5초마다)
        Thread worker2 = null;
        
        // TODO 82: 람다 표현식으로 스레드 생성하기
        // 1부터 5까지 "Worker 3: i" 출력 (2초마다)
        Thread worker3 = null;
        
        // TODO 83: Timer와 익명 클래스로 TimerTask 구현하기
        // Timer 생성
        // TimerTask를 익명 클래스로 구현
        // count 필드 유지, 실행마다 count 증가
        // "타이머 실행: count회" 출력
        // count가 3이 되면 timer.cancel()하고 "타이머 종료" 출력
        // 1초 후 시작, 2초마다 반복
        
        // TODO 84: 모든 스레드 시작하기
        // worker1, worker2, worker3 start() 호출
        
        System.out.println("모든 스레드 시작됨");
    }
}

#### 실행 결과 (참고용):
```
메인 스레드 시작
모든 스레드 시작됨
Worker 1: 1
타이머 실행: 1회
Worker 2: 1
Worker 1: 2
Worker 3: 1
Worker 2: 2
Worker 1: 3
타이머 실행: 2회
Worker 2: 3
Worker 1: 4
Worker 3: 2
Worker 1: 5
Worker 2: 4
타이머 실행: 3회
타이머 종료
Worker 2: 5
Worker 3: 3
Worker 3: 4
Worker 3: 5
```
```

## 4. 로컬 클래스와 람다 표현식 예제

### 실습 4-1: 함수 생성기
**목표**: 로컬 클래스를 사용하여 다양한 수학 함수를 생성해보세요.

```java
/**
 * 다양한 수학 함수를 생성하는 클래스
 */
public class FunctionFactory {
    
    // 함수 인터페이스
    public interface MathFunction {
        double apply(double x);
        String getDescription();
    }
    
    // 다항식 생성
    public static MathFunction createPolynomial(final double... coefficients) {
        // TODO 85: 로컬 클래스 Polynomial 구현하기
        // MathFunction 인터페이스 구현
        // apply: coefficients[0] + coefficients[1]*x + coefficients[2]*x^2 + ...
        // getDescription: "f(x) = a + bx + cx^2 + ..." 형식
        return null;
    }
    
    // 삼각함수 조합 생성
    public static MathFunction createTrigFunction(
            final double amplitude, final double frequency, final double phase) {
        // TODO 86: 익명 클래스로 MathFunction 구현하기
        // apply: amplitude * sin(frequency * x + phase)
        // getDescription: "f(x) = A * sin(Fx + P)" 형식
        return null;
    }
    
    // 함수 배열 생성 (람다와 로컬 클래스 혼합)
    public static MathFunction[] createFunctionArray() {
        MathFunction[] functions = new MathFunction[5];
        
        // TODO 87: 로컬 클래스 SquareFunction 구현하기
        // apply: x * x
        // getDescription: "f(x) = x²"
        
        // TODO 88: 익명 클래스로 세제곱 함수 구현하기
        // apply: x * x * x
        // getDescription: "f(x) = x³"
        
        // TODO 89: 함수 배열 완성하기
        // functions[0]: SquareFunction
        // functions[1]: 세제곱 함수 (익명 클래스)
        // functions[2]: createPolynomial(0, 1) - f(x) = x
        // functions[3]: createPolynomial(1, 2, 1) - f(x) = 1 + 2x + x²
        // functions[4]: createTrigFunction(2, 1, 0) - f(x) = 2sin(x)
        
        return functions;
    }
    
    public static void main(String[] args) {
        // TODO 90: 다항식 함수 테스트하기
        // createPolynomial(1, -2, 1) - x² - 2x + 1
        // getDescription()과 apply(3) 출력
        
        // TODO 91: 삼각함수 테스트하기
        // createTrigFunction(1, 2*Math.PI, 0)
        // getDescription()과 apply(0.25) 출력
        
        // TODO 92: 함수 배열 테스트하기
        // createFunctionArray() 호출
        // x = 2.0에 대한 모든 함수의 결과 출력
    }
}

#### 실행 결과 (참고용):
```
f(x) = 1.0 + -2.0x + 1.0x^2
f(3) = 4.0

f(x) = 1.00 * sin(6.28x + 0.00)
f(0.25) = -2.4492935982947064E-16

=== 함수 배열 ===
f(x) = x²: f(2.0) = 4.00
f(x) = x³: f(2.0) = 8.00
f(x) = 0.0 + 1.0x: f(2.0) = 2.00
f(x) = 1.0 + 2.0x + 1.0x^2: f(2.0) = 9.00
f(x) = 2.00 * sin(1.00x + 0.00): f(2.0) = 1.82
```
}
```

### 실습 4-2: 이벤트 처리 시스템
**목표**: 로컬 클래스와 익명 클래스를 사용한 이벤트 시스템을 구현해보세요.

```java
/**
 * 이벤트 기반 시스템 구현
 */
public class EventSystem {
    
    // 이벤트 타입
    public enum EventType {
        CLICK, HOVER, KEY_PRESS, CUSTOM
    }
    
    // 이벤트 클래스
    public static class Event {
        private EventType type;
        private String source;
        private Object data;
        private long timestamp;
        
        public Event(EventType type, String source, Object data) {
            // TODO 93: Event 필드 초기화하기
            // type, source, data 설정
            // timestamp를 현재 시간으로 설정
        }
        
        // getters
        public EventType getType() { return type; }
        public String getSource() { return source; }
        public Object getData() { return data; }
        public long getTimestamp() { return timestamp; }
    }
    
    // 이벤트 핸들러 인터페이스
    public interface EventHandler {
        void handle(Event event);
    }
    
    private Map<EventType, List<EventHandler>> handlers = new HashMap<>();
    
    // 이벤트 핸들러 등록
    public void addHandler(EventType type, EventHandler handler) {
        // TODO 94: 이벤트 핸들러 등록하기
        // handlers 맵에 type에 해당하는 리스트가 없으면 새로 생성
        // 해당 리스트에 handler 추가
    }
    
    // 특정 조건의 핸들러 등록 (로컬 클래스 사용)
    public void addConditionalHandler(EventType type, 
                                     final Predicate<Event> condition,
                                     final EventHandler handler) {
        // TODO 95: 로컬 클래스로 조건부 핸들러 구현하기
        // ConditionalHandler 로컬 클래스 정의
        // EventHandler 인터페이스 구현
        // handle 메서드에서 condition.test() 확인 후 handler 호출
        // addHandler로 새 ConditionalHandler 등록
    }
    
    // 이벤트 발생
    public void fireEvent(Event event) {
        List<EventHandler> eventHandlers = handlers.get(event.getType());
        if (eventHandlers != null) {
            for (EventHandler handler : eventHandlers) {
                handler.handle(event);
            }
        }
    }
    
    public static void main(String[] args) {
        EventSystem system = new EventSystem();
        
        // 익명 클래스로 핸들러 등록
        system.addHandler(EventType.CLICK, new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("클릭 이벤트: " + event.getSource());
            }
        });
        
        // 람다로 핸들러 등록
        system.addHandler(EventType.HOVER, event -> {
            System.out.println("호버 이벤트: " + event.getSource());
        });
        
        // 조건부 핸들러 등록
        system.addConditionalHandler(
            EventType.KEY_PRESS,
            event -> "Enter".equals(event.getData()),  // Enter 키만 처리
            event -> System.out.println("Enter 키가 눌렸습니다!")
        );
        
        // 로컬 클래스로 복잡한 핸들러 생성
        EventHandler createComplexHandler(final String prefix) {
            class ComplexHandler implements EventHandler {
                private int count = 0;
                
                @Override
                public void handle(Event event) {
                    count++;
                    System.out.printf("%s [%d번째]: %s%n", 
                                    prefix, count, event.getSource());
                }
            }
            
            return new ComplexHandler();
        }
        
        system.addHandler(EventType.CUSTOM, createComplexHandler("커스텀 이벤트"));
        
        // 이벤트 발생 테스트
        system.fireEvent(new Event(EventType.CLICK, "버튼1", null));
        system.fireEvent(new Event(EventType.HOVER, "메뉴", null));
        system.fireEvent(new Event(EventType.KEY_PRESS, "텍스트필드", "A"));
        system.fireEvent(new Event(EventType.KEY_PRESS, "텍스트필드", "Enter"));
        system.fireEvent(new Event(EventType.CUSTOM, "커스텀소스", null));
        system.fireEvent(new Event(EventType.CUSTOM, "커스텀소스2", null));
    }
}
```

## 5. 복합 예제: 게임 시스템

### 예제 5-1: 카드 게임 프레임워크

```java
/**
 * 카드 게임을 위한 프레임워크
 */
public abstract class CardGame {
    protected List<Player> players = new ArrayList<>();
    protected Deck deck;
    protected boolean gameInProgress = false;
    
    // 플레이어를 나타내는 내부 클래스
    public class Player {
        private String name;
        private Hand hand = new Hand();
        private int score = 0;
        
        public Player(String name) {
            this.name = name;
        }
        
        // 카드 받기
        public void receiveCard(Card card) {
            hand.add(card);
            onCardReceived(card);  // 외부 클래스의 추상 메서드 호출
        }
        
        // 턴 진행
        public void playTurn() {
            if (!gameInProgress) {
                throw new IllegalStateException("게임이 진행 중이 아닙니다.");
            }
            
            // 플레이어별 전략 실행
            PlayerStrategy strategy = getStrategy();
            Action action = strategy.decideAction(this, getGameState());
            executeAction(this, action);
        }
        
        public Hand getHand() { return hand; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public void addScore(int points) { score += points; }
    }
    
    // 플레이어 전략 인터페이스
    public interface PlayerStrategy {
        Action decideAction(Player player, GameState state);
    }
    
    // 게임 액션
    public static class Action {
        public enum Type { DRAW, PLAY, PASS, FOLD }
        private Type type;
        private Card card;
        
        public Action(Type type) {
            this.type = type;
        }
        
        public Action(Type type, Card card) {
            this.type = type;
            this.card = card;
        }
        
        public Type getType() { return type; }
        public Card getCard() { return card; }
    }
    
    // 게임 상태를 나타내는 정적 중첩 클래스
    public static class GameState {
        private int round;
        private int currentPlayerIndex;
        private List<Card> tableCards;
        
        public GameState(int round, int currentPlayerIndex) {
            this.round = round;
            this.currentPlayerIndex = currentPlayerIndex;
            this.tableCards = new ArrayList<>();
        }
        
        // getters...
    }
    
    // 추상 메서드들 - 서브클래스에서 구현
    protected abstract void onCardReceived(Card card);
    protected abstract PlayerStrategy getStrategy();
    protected abstract void executeAction(Player player, Action action);
    protected abstract GameState getGameState();
    
    // 게임 시작
    public void startGame() {
        if (players.size() < 2) {
            throw new IllegalStateException("최소 2명의 플레이어가 필요합니다.");
        }
        
        deck = new Deck();
        deck.shuffle();
        gameInProgress = true;
        
        // 초기 카드 분배
        dealInitialCards();
    }
    
    private void dealInitialCards() {
        // 로컬 클래스로 분배 규칙 정의
        class DealingRule {
            final int cardsPerPlayer;
            final boolean faceDown;
            
            DealingRule(int cardsPerPlayer, boolean faceDown) {
                this.cardsPerPlayer = cardsPerPlayer;
                this.faceDown = faceDown;
            }
            
            void deal() {
                for (int i = 0; i < cardsPerPlayer; i++) {
                    for (Player player : players) {
                        Card card = deck.dealCard();
                        if (!faceDown) {
                            System.out.println(player.getName() + 
                                             "가 받은 카드: " + card);
                        }
                        player.receiveCard(card);
                    }
                }
            }
        }
        
        // 기본 규칙: 각 플레이어에게 5장씩 분배
        new DealingRule(5, false).deal();
    }
    
    public void addPlayer(String name) {
        players.add(new Player(name));
    }
}

// 구체적인 게임 구현 예시
class SimpleCardGame extends CardGame {
    
    @Override
    protected void onCardReceived(Card card) {
        // 카드를 받았을 때의 처리
        System.out.println("카드 받음: " + card);
    }
    
    @Override
    protected PlayerStrategy getStrategy() {
        // 익명 클래스로 간단한 전략 구현
        return new PlayerStrategy() {
            @Override
            public Action decideAction(Player player, GameState state) {
                // 간단한 전략: 첫 번째 카드를 낸다
                if (!player.getHand().isEmpty()) {
                    return new Action(Action.Type.PLAY, 
                                    player.getHand().getCards().get(0));
                }
                return new Action(Action.Type.PASS);
            }
        };
    }
    
    @Override
    protected void executeAction(Player player, Action action) {
        switch (action.getType()) {
            case PLAY:
                System.out.println(player.getName() + "가 카드를 냅니다: " + 
                                 action.getCard());
                player.getHand().remove(action.getCard());
                player.addScore(10);
                break;
            case PASS:
                System.out.println(player.getName() + "가 패스합니다.");
                break;
            default:
                break;
        }
    }
    
    @Override
    protected GameState getGameState() {
        return new GameState(1, 0);
    }
    
    // 간단한 카드와 관련 클래스들
    static class Card {
        private String suit;
        private String rank;
        
        Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }
        
        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }
    
    static class Hand {
        private List<Card> cards = new ArrayList<>();
        
        void add(Card card) { cards.add(card); }
        void remove(Card card) { cards.remove(card); }
        boolean isEmpty() { return cards.isEmpty(); }
        List<Card> getCards() { return new ArrayList<>(cards); }
    }
    
    static class Deck {
        private List<Card> cards = new ArrayList<>();
        private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", 
                                 "9", "10", "J", "Q", "K", "A"};
        
        Deck() {
            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(new Card(suit, rank));
                }
            }
        }
        
        void shuffle() {
            Collections.shuffle(cards);
        }
        
        Card dealCard() {
            if (cards.isEmpty()) {
                throw new IllegalStateException("덱에 카드가 없습니다.");
            }
            return cards.remove(cards.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        SimpleCardGame game = new SimpleCardGame();
        game.addPlayer("Alice");
        game.addPlayer("Bob");
        
        game.startGame();
        
        // 첫 번째 플레이어의 턴
        game.players.get(0).playTurn();
    }
}
```

## 요약

이 예제들은 다음을 보여줍니다:

1. **정적 중첩 클래스**: 독립적인 데이터 구조와 설정 관리
2. **내부 클래스**: 외부 클래스와 밀접하게 연결된 구현
3. **익명 내부 클래스**: 일회성 구현과 이벤트 처리
4. **로컬 클래스**: 메서드 내부의 복잡한 로직 캡슐화
5. **실전 활용**: 게임, GUI, 데이터 구조 등에서의 활용