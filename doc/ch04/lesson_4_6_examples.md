# 4.6 API, 패키지, 모듈, Javadoc - 수업 실습

## 1. 패키지와 import 실습

### 실습 1-1: 기본 import 사용하기

#### 요구사항
- 다양한 클래스를 import하여 사용하는 방법 익히기
- Scanner로 사용자 입력 처리
- Random으로 난수 생성
- ArrayList로 데이터 관리

```java
// TODO 1: 필요한 클래스들을 개별적으로 import하기

public class BasicImportExample {
    public static void main(String[] args) {
        // TODO 2: Scanner 객체 생성하고 사용자 이름 입력받기
        
        // TODO 3: Random 객체로 1~100 사이의 행운의 숫자 생성하기
        
        // TODO 4: ArrayList 생성하고 취미 3개 추가하기
        
        // TODO 5: 결과 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
이름을 입력하세요: 홍길동
홍길동님의 행운의 숫자는 42입니다.
취미: [독서, 운동, 요리]
```

### 실습 1-2: 와일드카드 import 사용하기

#### 요구사항
- 패키지의 모든 클래스를 한 번에 import하는 방법 익히기
- List, Set, Map 컬렉션 사용
- File 클래스로 디렉토리 정보 확인

```java
// TODO 6: 와일드카드를 사용하여 패키지 전체 import하기

public class WildcardImportExample {
    public static void main(String[] args) {
        // TODO 7: List, Set, Map 컬렉션 생성하기
        
        // TODO 8: 데이터 추가하기
        
        // TODO 9: 결과 출력하기
        
        // TODO 10: File 객체로 현재 디렉토리 정보 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
숫자 리스트: [1, 2, 3, 4, 5]
고유 단어: [banana, apple]
점수: {김철수=90, 이영희=85}

현재 디렉토리: /Users/.../project
```

### 실습 1-3: 이름 충돌 해결하기

#### 요구사항
- 같은 이름의 클래스가 있을 때 해결 방법 익히기
- java.util.List와 java.awt.List 구분하여 사용
- 전체 클래스명으로 충돌 해결

```java
// TODO 11: java.util 패키지만 import하기 (java.awt는 주석)

public class NameConflictExample {
    public static void main(String[] args) {
        // TODO 12: java.util.List 사용하기
        
        // TODO 13: java.awt.List를 전체 이름으로 사용하기
        
        // TODO 14: 결과 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
util.List: [Java, Python]
awt.List 항목 수: 2
```

## 2. 정적 import 실습

### 실습 2-1: Math 클래스 정적 import

#### 요구사항
- Math 클래스의 메서드들을 정적 import로 간편하게 사용
- 원의 넓이와 둘레 계산
- 다양한 수학 함수 활용

```java
// TODO 15: Math 클래스의 모든 정적 멤버 import하기

public class StaticImportMath {
    public static void main(String[] args) {
        double radius = 5.0;
        
        // TODO 16: Math. 없이 원의 넓이와 둘레 계산하기
        
        // TODO 17: 결과 출력하기
        
        // TODO 18: 다른 Math 함수들 사용하기
    }
}
```

#### 실행 결과 (참고용):
```
반지름: 5.0
원의 넓이: 78.53981633974483
원의 둘레: 31.41592653589793

수학 함수 예제:
sqrt(16) = 4.0
sin(PI/2) = 1.0
max(10, 20) = 20
random() = 0.7234567890123456
```

### 실습 2-2: System.out 정적 import

#### 요구사항
- System.out을 정적 import하여 간편한 출력 구현
- 에러 스트림 사용
- printf 형식 출력

```java
// TODO 19: System.out과 System.err 정적 import하기

public class StaticImportSystem {
    public static void main(String[] args) {
        // TODO 20: System. 없이 출력하기
        
        // TODO 21: 에러 스트림 사용하기
        
        // TODO 22: printf 사용하기
    }
}
```

#### 실행 결과 (참고용):
```
일반 메시지
연속 출력
에러 메시지!
포맷된 출력: 3 + 4 = 7
```

### 실습 2-3: 사용자 정의 클래스의 정적 import

#### 요구사항
- 직접 만든 유틸리티 클래스를 정적 import로 사용
- 수학 유틸리티 메서드 구현 (평균, 팩토리얼, 소수 판별)
- 상수 정의 및 활용

```java
// TODO 23: MathUtils 클래스 만들기
class MathUtils {
    // TODO 24: 황금비 상수 정의하기
    
    // TODO 25: 평균 계산 메서드 구현하기
    public static double average(double... numbers) {
        
    }
    
    // TODO 26: 팩토리얼 계산 메서드 구현하기
    public static int factorial(int n) {
        
    }
    
    // TODO 27: 소수 판별 메서드 구현하기
    public static boolean isPrime(int n) {
        
    }
}

// TODO 28: MathUtils 정적 import하기

public class CustomStaticImport {
    public static void main(String[] args) {
        // TODO 29: MathUtils. 없이 사용하기
        
        // TODO 30: 1-20 사이의 소수 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
황금비: 1.618033988749895
평균(1,2,3,4,5): 3.0
5! = 120

1-20 사이의 소수:
2 3 5 7 11 13 17 19 
```

## 3. Javadoc 실습

### 실습 3-1: 기본 Javadoc 주석 작성하기

#### 요구사항
- 간단한 계산기 클래스에 Javadoc 주석 추가
- 클래스, 메서드, 매개변수 문서화
- @author, @version, @since 태그 사용

```java
// TODO 31: 클래스에 대한 Javadoc 주석 작성하기
/**
 * 
 * @author 
 * @version 
 * @since 
 */
public class Calculator {
    
    // TODO 32: add 메서드에 Javadoc 주석 작성하기
    /**
     * @param a 
     * @param b 
     * @return 
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    // TODO 33: subtract 메서드에 Javadoc 주석 작성하기
    /**
     * @param a 
     * @param b 
     * @return 
     */
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    // TODO 34: divide 메서드에 Javadoc 주석 작성하기 (예외 포함)
    /**
     * @param dividend 
     * @param divisor 
     * @return 
     * @throws ArithmeticException 
     */
    public static double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return dividend / divisor;
    }
}
```

### 실습 3-2: 상세한 Javadoc 문서 작성하기

#### 요구사항
- HTML 태그와 다양한 어노테이션을 사용한 상세한 문서 작성
- 성적 관리 클래스 문서화
- 사용 예제 코드 포함
- @see 태그로 관련 클래스 참조

```java
// TODO 35: import문 추가하기

// TODO 36: 클래스에 상세한 Javadoc 주석 작성하기
/**
 * 
 * <p>
 * <ul>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 * </ul>
 * 
 * <p>사용 예제:
 * <pre>
 * </pre>
 * 
 * @author 
 * @version 
 * @see java.util.ArrayList
 */
public class GradeManager {
    private ArrayList<Integer> scores;
    
    // TODO 37: 생성자에 Javadoc 주석 작성하기
    /**
     * 
     */
    public GradeManager() {
        scores = new ArrayList<>();
    }
    
    // TODO 38: addScore 메서드에 Javadoc 주석 작성하기
    /**
     * @param score 
     * @throws IllegalArgumentException 
     */
    public void addScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                "점수는 0과 100 사이여야 합니다: " + score);
        }
        scores.add(score);
    }
    
    // TODO 39: getAverage 메서드에 Javadoc 주석 작성하기
    /**
     * @return 
     */
    public double getAverage() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }
    
    // TODO 40: getLetterGrade 메서드에 상세한 Javadoc 주석 작성하기
    /**
     * <p>학점 기준:
     * <ul>
     *   <li></li>
     *   <li></li>
     *   <li></li>
     *   <li></li>
     *   <li></li>
     * </ul>
     * 
     * @return 
     * @see #getAverage()
     */
    public char getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }
}
```

### 실습 3-3: HTML 태그를 활용한 Javadoc

#### 요구사항
- 다양한 HTML 태그를 사용하여 보기 좋은 문서 작성
- 문자열 유틸리티 클래스 문서화
- 목록, 강조, 코드 블록 활용

```java
// TODO 41: StringUtils 클래스에 상세한 Javadoc 주석 작성하기
/**
 * <p>
 * <h2>주요 기능</h2>
 * <ol>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 * </ol>
 * 
 * <p><strong>참고:</strong> 
 * 
 * @since 
 */
public class StringUtils {
    
    // TODO 42: reverse 메서드에 예제가 포함된 Javadoc 주석 작성하기
    /**
     * <p>예제:
     * <blockquote>
     * <pre>
     * </pre>
     * </blockquote>
     * 
     * @param str 
     * @return 
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
    
    // TODO 43: isPalindrome 메서드에 Javadoc 주석 작성하기
    /**
     * <p>
     * <br>
     * 
     * @param str 
     * @return 
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = reverse(cleaned);
        return cleaned.equals(reversed);
    }
}
```

## 4. Collections API 실습

### 실습 4-1: List, Set, Map 활용하기

#### 요구사항
- 다양한 컬렉션 API를 사용하여 데이터 관리
- List로 순서 있는 데이터 관리
- Set으로 중복 제거
- Map으로 키-값 쌍 관리
- Collections 유틸리티 메서드 활용

```java
// TODO 44: 필요한 import문 추가하기

public class CollectionsAPIExample {
    public static void main(String[] args) {
        // TODO 45: List API 사용하기
        
        // TODO 46: Set API 사용하기
        
        // TODO 47: Map API 사용하기
        
        // TODO 48: Collections 유틸리티 사용하기
    }
}
```

#### 실행 결과 (참고용):
```
=== List API ===
과일 목록: [사과, 바나나, 포도]
첫 번째 과일: 사과
과일 개수: 3

=== Set API ===
고유 숫자: [1, 2, 3, 4]
3이 있나요? true

=== Map API ===
점수표: {김철수=90, 이영희=85, 박민수=92}
김철수의 점수: 90

정렬된 리스트: [1, 1, 3, 4, 5]
최대값: 5
최소값: 1
```

### 실습 4-2: Date/Time API 활용하기

#### 요구사항
- Java 8의 새로운 날짜/시간 API 사용
- LocalDate, LocalTime, LocalDateTime 활용
- 날짜 계산 및 기간 처리
- 날짜/시간 포맷팅

```java
// TODO 49: 날짜/시간 관련 import문 추가하기

public class DateTimeAPIExample {
    public static void main(String[] args) {
        // TODO 50: 현재 날짜와 시간 가져오기
        
        // TODO 51: 날짜 계산하기
        
        // TODO 52: 날짜/시간 포맷팅하기
    }
}
```

#### 실행 결과 (참고용):
```
=== 현재 시간 정보 ===
오늘 날짜: 2024-01-15
현재 시간: 14:30:25.123456
날짜와 시간: 2024-01-15T14:30:25.123456

=== 날짜 계산 ===
생일: 2000-05-15
25번째 생일: 2025-05-15
오늘부터 생일까지: P4M

=== 포맷팅 ===
포맷된 날짜/시간: 2024년 01월 15일 14시 30분
```

## 5. 종합 실습: 학생 관리 시스템

### 실습 5-1: 패키지 구조로 학생 관리 시스템 만들기

#### 요구사항
- 패키지, API, Javadoc을 모두 활용한 시스템 구현
- model 패키지에 Student 클래스 생성
- service 패키지에 StudentService 클래스 생성
- Collections API로 학생 데이터 관리
- 완전한 Javadoc 문서화

```java
// TODO 53: Student 클래스 만들기 (model 패키지)

// TODO 54: 필요한 import문 추가하기

// TODO 55: Student 클래스에 상세한 Javadoc 주석 작성하기
/**
 * @author 
 * @version 
 */
public class Student {
    // TODO 56: private 필드들 선언하기
    
    // TODO 57: 생성자에 Javadoc 주석과 구현 작성하기
    /**
     * @param studentId 
     * @param name 
     * @param age 
     * @param enrollDate 
     */
    public Student(String studentId, String name, int age, LocalDate enrollDate) {
        
    }
    
    // TODO 58: getter 메서드들 구현하기
    public String getStudentId() { }
    public String getName() { }
    public int getAge() { }
    public LocalDate getEnrollDate() { }
    
    // TODO 59: toString 메서드 구현하기
    @Override
    public String toString() {
        
    }
}
```

```java
// TODO 60: StudentService 클래스 만들기 (service 패키지)

// TODO 61: 필요한 import문 추가하기

// TODO 62: StudentService 클래스에 Javadoc 주석 작성하기
/**
 * <p>
 * <ul>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 * </ul>
 */
public class StudentService {
    // TODO 63: 학생 저장용 Map 선언하기
    
    // TODO 64: 생성자 구현하기
    public StudentService() {
        
    }
    
    // TODO 65: addStudent 메서드 구현하기
    /**
     * @param student 
     * @throws IllegalArgumentException 
     */
    public void addStudent(Student student) {
        
    }
    
    // TODO 66: findStudent 메서드 구현하기
    /**
     * @param studentId 
     * @return 
     */
    public Student findStudent(String studentId) {
        
    }
    
    // TODO 67: getAllStudents 메서드 구현하기
    /**
     * @return 
     */
    public List<Student> getAllStudents() {
        
    }
    
    // TODO 68: searchByName 메서드 구현하기
    /**
     * @param name 
     * @return 
     */
    public List<Student> searchByName(String name) {
        
    }
}
```

```java
// TODO 69: Main 클래스 만들기
// TODO 70: 필요한 import문 추가하기

// TODO 71: Main 클래스에 Javadoc 주석 작성하기
/**
 * 
 */
public class Main {
    public static void main(String[] args) {
        // TODO 72: StudentService 객체 생성하기
        
        // TODO 73: 학생들 추가하기
        
        // TODO 74: 모든 학생 출력하기
        
        // TODO 75: 특정 학생 검색하기
        
        // TODO 76: 이름으로 검색하기
    }
}
```

#### 실행 결과 (참고용):
```
=== 전체 학생 목록 ===
[S001] 김철수 (20세) - 입학일: 2023-03-01
[S002] 이영희 (19세) - 입학일: 2023-03-01
[S003] 박민수 (21세) - 입학일: 2022-09-01

=== 학생 검색 ===
찾은 학생: [S002] 이영희 (19세) - 입학일: 2023-03-01

=== 이름으로 검색 ===
[S001] 김철수 (20세) - 입학일: 2023-03-01
```

## 학습 포인트

### 1. 패키지와 import
- **패키지**: 관련된 클래스들을 논리적으로 그룹화
- **개별 import**: 필요한 클래스만 명시적으로 import
- **와일드카드 import**: 패키지의 모든 클래스를 한 번에 import
- **이름 충돌**: 전체 클래스명 사용으로 해결

### 2. 정적 import
- **정적 멤버 import**: 클래스명 없이 정적 메서드/필드 사용
- **가독성 향상**: 자주 사용하는 유틸리티 메서드에 유용
- **남용 주의**: 과도한 사용은 코드 이해를 어렵게 함

### 3. Javadoc
- **API 문서화**: 코드의 공식 문서 생성
- **표준 태그**: @param, @return, @throws, @see 등
- **HTML 태그**: 풍부한 문서 표현 가능
- **유지보수**: 코드와 문서의 일관성 유지

### 4. API 활용
- **Collections API**: List, Set, Map 등의 자료구조
- **Date/Time API**: 현대적인 날짜/시간 처리
- **File I/O API**: 파일 시스템 접근

### 5. 프로젝트 구조
- **패키지 분리**: model, service, util 등 역할별 분리
- **모듈화**: 기능별로 클래스를 분리하여 관리
- **문서화**: 각 클래스와 메서드의 역할을 명확히 기술

이러한 기능들을 활용하면 체계적이고 유지보수가 쉬운 Java 프로그램을 만들 수 있습니다!