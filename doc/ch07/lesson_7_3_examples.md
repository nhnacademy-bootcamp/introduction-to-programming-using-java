# 7.3 ArrayList - 수업 실습

## 1. ArrayList 기본 사용 예제

### 예제 1-1: ArrayList 생성과 기본 조작

```java
import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        // TODO: ArrayList를 생성하세요
        // 제네릭 타입을 String으로 지정
        ArrayList<String> cities = ;
        
        // TODO: 요소들을 추가하세요
        // "서울", "부산", "대구", "인천" 순으로 추가
        
        
        System.out.println("초기 도시 목록: " + cities);
        
        // TODO: 특정 위치(인덱스 2)에 "광주"를 삽입하세요
        
        System.out.println("광주 추가 후: " + cities);
        
        // TODO: 첫 번째 요소를 가져와서 firstCity 변수에 저장하세요
        String firstCity = ;
        System.out.println("첫 번째 도시: " + firstCity);
        
        // TODO: 인덱스 1의 요소를 "울산"으로 수정하세요
        
        System.out.println("부산을 울산으로 변경: " + cities);
        
        // TODO: ArrayList의 크기를 출력하세요
        System.out.println("도시 개수: " + );
        
        // TODO: "서울"이 포함되어 있는지 확인하세요
        boolean hasSeoul = ;
        System.out.println("서울 포함 여부: " + hasSeoul);
        
        // TODO: "대구"의 인덱스를 찾으세요
        int daeguIndex = ;
        System.out.println("대구의 인덱스: " + daeguIndex);
        
        // TODO: "광주"를 제거하고 첫 번째 요소(인덱스 0)도 제거하세요
        
        
        System.out.println("삭제 후: " + cities);
        
        // TODO: 모든 요소를 제거하세요
        
        System.out.println("clear() 후 크기: " + cities.size());
    }
}
```

**실행 결과:**
```
초기 도시 목록: [서울, 부산, 대구, 인천]
광주 추가 후: [서울, 부산, 광주, 대구, 인천]
첫 번째 도시: 서울
부산을 울산으로 변경: [서울, 울산, 광주, 대구, 인천]
도시 개수: 5
서울 포함 여부: true
대구의 인덱스: 3
삭제 후: [울산, 대구, 인천]
clear() 후 크기: 0
```

### 예제 1-2: 다양한 타입의 ArrayList

```java
import java.util.ArrayList;

public class DifferentTypeArrayLists {
    public static void main(String[] args) {
        // TODO: 정수 ArrayList를 생성하고 10, 20, 30, 40, 50을 추가하세요
        ArrayList<Integer> numbers = new ArrayList<>();
        
        
        System.out.println("정수 리스트: " + numbers);
        
        // TODO: 실수 ArrayList를 생성하고 19.99, 35.50, 42.00을 추가하세요
        ArrayList<Double> prices = new ArrayList<>();
        
        
        System.out.println("가격 리스트: " + prices);
        
        // TODO: 문자 ArrayList를 생성하고 'A', 'B', 'C'를 추가하세요
        ArrayList<Character> grades = new ArrayList<>();
        
        
        System.out.println("등급 리스트: " + grades);
        
        // TODO: Boolean ArrayList를 생성하고 true, false, true를 추가하세요
        ArrayList<Boolean> answers = new ArrayList<>();
        
        
        System.out.println("답안 리스트: " + answers);
    }
}
```

**실행 결과:**
```
정수 리스트: [10, 20, 30, 40, 50]
가격 리스트: [19.99, 35.5, 42.0]
등급 리스트: [A, B, C]
답안 리스트: [true, false, true]
```

## 2. 래퍼 클래스와 오토박싱/언박싱 예제

### 예제 2-1: 오토박싱과 언박싱 동작

```java
import java.util.ArrayList;

public class AutoboxingExample {
    public static void main(String[] args) {
        // TODO: Integer ArrayList를 생성하세요
        ArrayList<Integer> scores = ;
        
        // TODO: 기본형 int 값들을 추가하세요 (오토박싱)
        // 95, 87, 92를 추가
        
        
        // TODO: 첫 번째 요소를 int 변수에 저장하세요 (언박싱)
        int firstScore = ;
        System.out.println("첫 번째 점수: " + firstScore);
        
        // TODO: for-each 루프를 사용하여 총점을 계산하세요
        // 언박싱이 자동으로 일어남
        int sum = 0;
        
        
        System.out.println("총점: " + sum);
        
        // TODO: null 값을 추가하세요
        
        System.out.println("null 포함 리스트: " + scores);
        
        // TODO: null 체크를 포함한 안전한 순회를 구현하세요
        System.out.println("=== 안전한 처리 ===");
        
    }
}
```

**실행 결과:**
```
첫 번째 점수: 95
총점: 274
null 포함 리스트: [95, 87, 92, null]
=== 안전한 처리 ===
점수: 95
점수: 87
점수: 92
점수: 미입력
```

### 예제 2-2: 래퍼 클래스 유틸리티 메서드

```java
import java.util.ArrayList;

public class WrapperUtilities {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // TODO: 문자열 배열을 숫자로 변환하여 ArrayList에 추가하세요
        String[] strNumbers = {"100", "200", "300"};
        
        
        // TODO: 래퍼 클래스의 상수들을 출력하세요
        System.out.println("최대 int 값: " + );
        System.out.println("최소 int 값: " + );
        
        // TODO: 진법 변환을 수행하세요
        int decimal = 42;
        System.out.println(decimal + "의 2진수: " + );
        System.out.println(decimal + "의 16진수: " + );
        
        // TODO: Double의 특수값들을 포함한 ArrayList를 생성하세요
        ArrayList<Double> measurements = new ArrayList<>();
        
        
        // TODO: 각 값의 타입을 확인하여 출력하세요
        
    }
}
```

**실행 결과:**
```
최대 int 값: 2147483647
최소 int 값: -2147483648
42의 2진수: 101010
42의 16진수: 2a
정상 값: 3.14
무한대 값 발견
NaN 값 발견
```

## 3. ArrayList 순회 및 처리 예제

### 예제 3-1: 다양한 순회 방법

```java
import java.util.ArrayList;

public class ArrayListIteration {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        // TODO: "사과", "바나나", "오렌지", "포도", "딸기"를 추가하세요
        
        
        // TODO: 전통적인 for 루프로 인덱스와 함께 출력하세요
        System.out.println("=== 전통적인 for 루프 ===");
        
        
        // TODO: for-each 루프로 출력하세요
        System.out.println("\n=== for-each 루프 ===");
        
        
        // TODO: 역순으로 순회하여 출력하세요
        System.out.println("\n=== 역순 순회 ===");
        
        
        // TODO: 3글자 이상인 과일만 출력하세요
        System.out.println("\n=== 3글자 이상만 출력 ===");
        
        
        // TODO: 짝수 인덱스의 과일만 출력하세요
        System.out.println("\n=== 짝수 인덱스만 ===");
        
    }
}
```

**실행 결과:**
```
=== 전통적인 for 루프 ===
0: 사과
1: 바나나
2: 오렌지
3: 포도
4: 딸기

=== for-each 루프 ===
사과
바나나
오렌지
포도
딸기

=== 역순 순회 ===
딸기
포도
오렌지
바나나
사과

=== 3글자 이상만 출력 ===
바나나
오렌지

=== 짝수 인덱스만 ===
0: 사과
2: 오렌지
4: 딸기
```

### 예제 3-2: ArrayList 필터링과 변환

```java
import java.util.ArrayList;

public class ArrayListProcessing {
    public static void main(String[] args) {
        // TODO: 1부터 20까지의 숫자로 ArrayList를 생성하세요
        ArrayList<Integer> numbers = new ArrayList<>();
        
        
        // TODO: 짝수만 필터링하여 새 ArrayList를 만드세요
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        
        
        System.out.println("짝수: " + evenNumbers);
        
        // TODO: 모든 숫자의 제곱수로 새 ArrayList를 만드세요
        ArrayList<Integer> squares = new ArrayList<>();
        
        
        System.out.println("제곱수: " + squares);
        
        // TODO: 숫자를 범주로 분류하여 새 ArrayList를 만드세요
        // 5 이하: "낮음", 15 이하: "중간", 그 외: "높음"
        ArrayList<String> categories = new ArrayList<>();
        
        
        System.out.println("카테고리: " + categories);
        
        // TODO: 합계와 평균을 계산하세요
        int sum = 0;
        
        
        double average = (double) sum / numbers.size();
        System.out.println("합계: " + sum + ", 평균: " + average);
    }
}
```

**실행 결과:**
```
짝수: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
제곱수: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400]
카테고리: [낮음, 낮음, 낮음, 낮음, 낮음, 중간, 중간, 중간, 중간, 중간, 중간, 중간, 중간, 중간, 중간, 높음, 높음, 높음, 높음, 높음]
합계: 210, 평균: 10.5
```

## 4. 객체 ArrayList 예제

### 예제 4-1: 사용자 정의 클래스와 ArrayList

```java
import java.util.ArrayList;

public class BookLibrary {
    static class Book {
        String title;
        String author;
        int year;
        double price;
        
        // TODO: 생성자를 작성하세요
        
        
        // TODO: toString 메서드를 작성하세요
        // 형식: "제목 - 저자 (연도) 가격원"
        
    }
    
    public static void main(String[] args) {
        // TODO: Book을 저장할 ArrayList를 생성하세요
        ArrayList<Book> library = ;
        
        // TODO: 다음 도서들을 추가하세요
        // "자바의 정석", "남궁성", 2020, 30000
        // "이펙티브 자바", "조슈아 블로크", 2018, 36000
        // "클린 코드", "로버트 마틴", 2013, 29700
        // "스프링 인 액션", "크레이그 월즈", 2020, 40000
        
        
        // TODO: 전체 도서를 출력하세요
        System.out.println("=== 전체 도서 목록 ===");
        
        
        // TODO: "남궁성" 저자의 책을 찾아서 출력하세요
        System.out.println("\n=== 남궁성 저자의 책 ===");
        
        
        // TODO: 30000원 이상의 책을 찾아서 출력하세요
        System.out.println("\n=== 30000원 이상의 책 ===");
        
        
        // TODO: 2020년 이후 출간 도서를 찾아서 출력하세요
        System.out.println("\n=== 2020년 이후 출간 도서 ===");
        
        
        // TODO: 모든 도서의 총 가격을 계산하세요
        double totalPrice = 0;
        
        
        System.out.println("\n도서 총 가격: " + totalPrice + "원");
    }
}
```

**실행 결과:**
```
=== 전체 도서 목록 ===
자바의 정석 - 남궁성 (2020) 30000원
이펙티브 자바 - 조슈아 블로크 (2018) 36000원
클린 코드 - 로버트 마틴 (2013) 29700원
스프링 인 액션 - 크레이그 월즈 (2020) 40000원

=== 남궁성 저자의 책 ===
자바의 정석 - 남궁성 (2020) 30000원

=== 30000원 이상의 책 ===
자바의 정석 - 남궁성 (2020) 30000원
이펙티브 자바 - 조슈아 블로크 (2018) 36000원
스프링 인 액션 - 크레이그 월즈 (2020) 40000원

=== 2020년 이후 출간 도서 ===
자바의 정석 - 남궁성 (2020) 30000원
스프링 인 액션 - 크레이그 월즈 (2020) 40000원

도서 총 가격: 135700.0원
```

### 예제 4-2: 복잡한 객체 관리

```java
import java.util.ArrayList;

public class StudentManagement {
    static class Course {
        String name;
        int credits;
        
        // TODO: Course 생성자를 작성하세요
        
    }
    
    static class Student {
        String name;
        int id;
        ArrayList<Course> courses;
        ArrayList<Double> grades;
        
        // TODO: Student 생성자를 작성하세요
        // courses와 grades는 새 ArrayList로 초기화
        
        
        // TODO: 과목 등록 메서드를 작성하세요
        // 메서드명: enrollCourse, 매개변수: Course course, double grade
        
        
        // TODO: GPA 계산 메서드를 작성하세요
        // 메서드명: calculateGPA
        // 가중평균: (성적 × 학점)의 합 / 전체 학점의 합
        
        
        // TODO: 성적표 출력 메서드를 작성하세요
        // 메서드명: printTranscript
        // 학생 정보, 각 과목의 성적, 평균 학점을 출력
        
    }
    
    public static void main(String[] args) {
        // TODO: 학생 목록을 저장할 ArrayList를 생성하세요
        ArrayList<Student> students = ;
        
        // TODO: 학생들을 생성하세요
        Student student1 = new Student("김철수", 20210001);
        Student student2 = new Student("이영희", 20210002);
        
        // TODO: 학생1에게 다음 과목들을 등록하세요
        // "자바 프로그래밍", 3학점, 4.0
        // "자료구조", 3학점, 3.5
        // "데이터베이스", 3학점, 4.5
        
        
        // TODO: 학생2에게 다음 과목들을 등록하세요
        // "자바 프로그래밍", 3학점, 4.5
        // "웹 프로그래밍", 3학점, 4.0
        // "알고리즘", 3학점, 3.0
        
        
        // TODO: 학생들을 목록에 추가하세요
        
        
        // TODO: 모든 학생의 성적표를 출력하세요
        
        
        // TODO: 평균 GPA가 3.5 이상인 학생을 찾아서 출력하세요
        System.out.println("\n=== 우수 학생 (GPA 3.5 이상) ===");
        
    }
}
```

**실행 결과:**
```
=== 성적표: 김철수 (ID: 20210001) ===
자바 프로그래밍 (3학점): 4.0
자료구조 (3학점): 3.5
데이터베이스 (3학점): 4.5
평균 학점: 4.00

=== 성적표: 이영희 (ID: 20210002) ===
자바 프로그래밍 (3학점): 4.5
웹 프로그래밍 (3학점): 4.0
알고리즘 (3학점): 3.0
평균 학점: 3.83

=== 우수 학생 (GPA 3.5 이상) ===
김철수: 4.0
이영희: 3.83
```

## 5. ArrayList의 고급 활용 예제

### 예제 5-1: 동적 2차원 배열

```java
import java.util.ArrayList;

public class Dynamic2DArray {
    public static void main(String[] args) {
        // TODO: 2차원 ArrayList를 생성하세요
        // ArrayList<ArrayList<Integer>> 타입
        ArrayList<ArrayList<Integer>> matrix = ;
        
        // TODO: 3x4 행렬을 초기화하세요
        // 각 행은 새 ArrayList이고, 값은 i * 4 + j + 1
        
        
        // TODO: 행렬을 출력하세요
        System.out.println("=== 초기 행렬 ===");
        printMatrix(matrix);
        
        // TODO: 특정 요소(1행 2열)를 99로 수정하세요
        
        System.out.println("\n=== 수정 후 행렬 ===");
        printMatrix(matrix);
        
        // TODO: 새로운 행을 추가하세요
        // 100, 101, 102, 103을 포함하는 행
        ArrayList<Integer> newRow = new ArrayList<>();
        
        
        System.out.println("\n=== 행 추가 후 ===");
        printMatrix(matrix);
        
        // TODO: 각 행의 끝에 0을 추가하세요 (열 추가)
        
        
        System.out.println("\n=== 열 추가 후 ===");
        printMatrix(matrix);
        
        // TODO: 행렬의 모든 요소의 합을 계산하세요
        int sum = 0;
        
        
        System.out.println("\n행렬의 모든 요소 합: " + sum);
    }
    
    // TODO: 행렬 출력 메서드를 작성하세요
    // 메서드명: printMatrix
    // 매개변수: ArrayList<ArrayList<Integer>> matrix
    // 각 요소를 4자리로 정렬하여 출력
    
}
```

**실행 결과:**
```
=== 초기 행렬 ===
   1   2   3   4
   5   6   7   8
   9  10  11  12

=== 수정 후 행렬 ===
   1   2   3   4
   5   6  99   8
   9  10  11  12

=== 행 추가 후 ===
   1   2   3   4
   5   6  99   8
   9  10  11  12
 100 101 102 103

=== 열 추가 후 ===
   1   2   3   4   0
   5   6  99   8   0
   9  10  11  12   0
 100 101 102 103   0

행렬의 모든 요소 합: 522
```

### 예제 5-2: 그래프 데이터 구조

```java
import java.util.ArrayList;

public class GraphExample {
    static class Graph {
        private ArrayList<ArrayList<Integer>> adjacencyList;
        private int vertices;
        
        // TODO: 생성자를 작성하세요
        // 매개변수: int vertices
        // 각 정점에 대한 빈 ArrayList를 초기화
        
        
        // TODO: 간선 추가 메서드를 작성하세요 (무방향 그래프)
        // 메서드명: addEdge
        // 매개변수: int source, int destination
        // 양방향으로 연결 추가
        
        
        // TODO: 그래프 출력 메서드를 작성하세요
        // 메서드명: printGraph
        // 각 정점의 인접 정점들을 출력
        
        
        // TODO: 특정 정점의 차수 반환 메서드를 작성하세요
        // 메서드명: getDegree
        // 매개변수: int vertex
        // 연결된 간선 수를 반환
        
    }
    
    public static void main(String[] args) {
        // TODO: 5개 정점을 가진 그래프를 생성하세요
        Graph graph = ;
        
        // TODO: 다음 간선들을 추가하세요
        // 0-1, 0-2, 1-3, 2-3, 3-4
        
        
        // TODO: 그래프를 출력하세요
        
        
        // TODO: 각 정점의 차수를 출력하세요
        System.out.println("\n각 정점의 차수:");
        
    }
}
```

**실행 결과:**
```
정점 0의 인접 정점: 1 2 
정점 1의 인접 정점: 0 3 
정점 2의 인접 정점: 0 3 
정점 3의 인접 정점: 1 2 4 
정점 4의 인접 정점: 3 

각 정점의 차수:
정점 0: 2
정점 1: 2
정점 2: 2
정점 3: 3
정점 4: 1
```

## 6. 실전 응용: 간단한 그림판

```java
import java.util.ArrayList;

public class SimpleDrawing {
    // TODO: 점을 나타내는 클래스를 작성하세요
    static class Point {
        double x, y;
        
        // 생성자와 toString 메서드 작성
        
    }
    
    // TODO: 곡선 데이터 클래스를 작성하세요
    static class Curve {
        String color;
        ArrayList<Point> points;
        
        // 생성자 작성 (color 매개변수)
        
        
        // 점 추가 메서드 작성
        // 메서드명: addPoint, 매개변수: double x, double y
        
        
        // 곡선 출력 메서드 작성
        // 메서드명: printCurve
        // 색상과 모든 점들을 출력
        
    }
    
    public static void main(String[] args) {
        // TODO: 여러 곡선을 저장하는 ArrayList를 생성하세요
        ArrayList<Curve> drawing = ;
        
        // TODO: 첫 번째 곡선(빨간색)을 생성하고 점들을 추가하세요
        // (0,0), (10,10), (20,5), (30,15)
        Curve curve1 = ;
        
        
        // TODO: 두 번째 곡선(파란색)을 생성하고 점들을 추가하세요
        // (5,20), (15,25), (25,20)
        Curve curve2 = ;
        
        
        // TODO: 세 번째 곡선(초록색)을 생성하고 점들을 추가하세요
        // (0,30), (30,0)
        Curve curve3 = ;
        
        
        // TODO: 전체 그림을 출력하세요
        System.out.println("=== 전체 그림 ===");
        
        
        // TODO: 가장 많은 점을 가진 곡선을 찾으세요
        Curve maxPointsCurve = drawing.get(0);
        
        
        System.out.println("가장 많은 점을 가진 곡선: " + 
            maxPointsCurve.color + " (" + maxPointsCurve.points.size() + "개)");
        
        // TODO: 마지막 곡선을 제거하세요 (Undo 기능)
        
        
        // TODO: 남은 곡선 수를 출력하세요
        System.out.println("남은 곡선 수: " + drawing.size());
    }
}
```

**실행 결과:**
```
=== 전체 그림 ===
곡선 1:
색상: 빨간색
점들: (0.0, 0.0) (10.0, 10.0) (20.0, 5.0) (30.0, 15.0) 

곡선 2:
색상: 파란색
점들: (5.0, 20.0) (15.0, 25.0) (25.0, 20.0) 

곡선 3:
색상: 초록색
점들: (0.0, 30.0) (30.0, 0.0) 

가장 많은 점을 가진 곡선: 빨간색 (4개)

제거된 곡선: 초록색
남은 곡선 수: 2
```

이 예제들은 ArrayList의 다양한 활용 방법을 연습할 수 있도록 구성되었습니다. 기본 조작부터 복잡한 객체 관리, 2차원 구조, 그래프 데이터 구조까지 실제 프로그래밍에서 자주 사용되는 패턴들을 각 TODO 주석을 참고하여 완성해보세요!