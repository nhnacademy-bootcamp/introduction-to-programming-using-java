# 2.4 텍스트 입력과 출력 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- System.out.print와 println의 차이를 이해하고 사용할 수 있다
- printf를 사용하여 서식을 지정한 출력을 만들 수 있다
- TextIO를 사용하여 사용자 입력을 받을 수 있다
- 다양한 데이터 타입의 입력을 처리할 수 있다
- 파일 입출력의 기본 개념을 이해한다
- Scanner 클래스를 사용한 입력 방법을 안다

## 1. 기본 출력 메소드

### 1.1 print vs println

```java
// print: 줄바꿈 없이 출력
System.out.print("Hello");
System.out.print("World");
// 출력: HelloWorld

// println: 출력 후 줄바꿈
System.out.println("Hello");
System.out.println("World");
// 출력: Hello
//       World
```

### 1.2 println()의 활용
```java
// 빈 줄 출력
System.out.println();

// print + println 조합
System.out.print("결과: ");
System.out.println(42);
// 출력: 결과: 42
```

## 2. 서식 지정 출력 (printf)

### 2.1 기본 서식 지정자

| 서식 지정자 | 설명 | 예시 |
|------------|------|------|
| `%d` | 정수 (decimal) | `printf("%d", 42)` → 42 |
| `%f` | 실수 (float) | `printf("%f", 3.14)` → 3.140000 |
| `%s` | 문자열 (string) | `printf("%s", "Java")` → Java |
| `%c` | 문자 (char) | `printf("%c", 'A')` → A |
| `%b` | 불린 (boolean) | `printf("%b", true)` → true |
| `%%` | % 기호 | `printf("%%")` → % |
| `%n` | 줄바꿈 | `printf("Hello%nWorld")` → Hello<br>World |

### 2.2 숫자 서식 지정

#### 정수 서식
```java
int num = 42;

// 기본 출력
System.out.printf("%d%n", num);      // 42

// 최소 너비 지정 (오른쪽 정렬)
System.out.printf("%5d%n", num);     // "   42"

// 왼쪽 정렬
System.out.printf("%-5d%n", num);    // "42   "

// 천 단위 구분
System.out.printf("%,d%n", 1234567); // 1,234,567
```

#### 실수 서식
```java
double pi = 3.141592653589793;

// 기본 출력
System.out.printf("%f%n", pi);        // 3.141593

// 소수점 자릿수 지정
System.out.printf("%.2f%n", pi);      // 3.14
System.out.printf("%.4f%n", pi);      // 3.1416

// 최소 너비와 소수점 자릿수
System.out.printf("%10.2f%n", pi);    // "      3.14"

// 지수 표기법
System.out.printf("%e%n", pi);        // 3.141593e+00
System.out.printf("%.2e%n", pi);      // 3.14e+00
```

### 2.3 문자열 서식
```java
String name = "Java";

// 기본 출력
System.out.printf("%s%n", name);      // Java

// 최소 너비 지정
System.out.printf("%10s%n", name);    // "      Java"

// 왼쪽 정렬
System.out.printf("%-10s%n", name);   // "Java      "
```

### 2.4 복합 서식 예제
```java
String product = "커피";
int quantity = 3;
double price = 4500.0;
double total = quantity * price;

System.out.printf("제품: %s%n", product);
System.out.printf("수량: %d개%n", quantity);
System.out.printf("단가: %,.0f원%n", price);
System.out.printf("총액: %,.0f원%n", total);
System.out.printf("%n영수증:%n");
System.out.printf("%-10s %3d개 x %,7.0f원 = %,10.0f원%n", 
                  product, quantity, price, total);
```

## 3. TextIO를 사용한 입력

### 3.1 TextIO 설정
```java
// 프로그램 시작 부분에 import
import textio.TextIO;
```

### 3.2 기본 입력 함수들

| 함수 | 반환 타입 | 설명 |
|------|-----------|------|
| `TextIO.getlnInt()` | int | 정수 입력 |
| `TextIO.getlnDouble()` | double | 실수 입력 |
| `TextIO.getlnBoolean()` | boolean | true/false 입력 |
| `TextIO.getlnChar()` | char | 문자 하나 입력 |
| `TextIO.getlnWord()` | String | 단어 하나 입력 |
| `TextIO.getln()` | String | 한 줄 전체 입력 |

### 3.3 입력 예제
```java
// 정수 입력
System.out.print("나이를 입력하세요: ");
int age = TextIO.getlnInt();

// 실수 입력
System.out.print("키를 입력하세요(cm): ");
double height = TextIO.getlnDouble();

// 문자열 입력
System.out.print("이름을 입력하세요: ");
String name = TextIO.getln();

// boolean 입력 (yes/no, true/false, y/n 등)
System.out.print("학생입니까? (yes/no): ");
boolean isStudent = TextIO.getlnBoolean();
```

### 3.4 getln vs get 함수
- `getln` 함수: 한 줄 전체를 소비
- `get` 함수: 값만 읽고 나머지는 버퍼에 보관

```java
// 한 줄에 여러 값 입력받기
System.out.print("두 숫자를 입력하세요 (예: 10 20): ");
int num1 = TextIO.getInt();   // 첫 번째 숫자만 읽음
int num2 = TextIO.getInt();   // 두 번째 숫자 읽음
TextIO.getln();               // 남은 줄 제거
```

## 4. 파일 입출력

### 4.1 파일에 쓰기
```java
// 파일로 출력 전환
TextIO.writeFile("output.txt");

// 파일에 데이터 쓰기
TextIO.putln("Hello, File!");
TextIO.putf("숫자: %d%n", 42);

// 다시 표준 출력으로 전환
TextIO.writeStandardOutput();
```

### 4.2 파일에서 읽기
```java
// 파일에서 읽기 시작
TextIO.readFile("input.txt");

// 파일에서 데이터 읽기
String line = TextIO.getln();
int number = TextIO.getlnInt();

// 다시 표준 입력으로 전환
TextIO.readStandardInput();
```

### 4.3 사용자 선택 파일
```java
// 사용자가 파일 선택 대화상자로 파일 선택
if (TextIO.writeUserSelectedFile()) {
    TextIO.putln("사용자가 선택한 파일에 쓰기");
} else {
    System.out.println("파일 선택 취소됨");
}
```

## 5. Scanner 클래스 사용

### 5.1 Scanner 설정
```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        // Scanner 사용
        System.out.print("정수 입력: ");
        int num = stdin.nextInt();
        
        System.out.print("실수 입력: ");
        double dbl = stdin.nextDouble();
    }
}
```

### 5.2 Scanner vs TextIO
| 특징 | TextIO | Scanner |
|------|--------|---------|
| 표준 클래스 | 아니오 (별도 파일 필요) | 예 |
| 오류 처리 | 자동 재입력 요청 | 프로그램 종료 |
| 사용 편의성 | 초보자 친화적 | 표준적 |

## 6. 종합 예제: 성적 계산 프로그램

```java
import textio.TextIO;

public class GradeCalculator {
    public static void main(String[] args) {
        System.out.println("=== 성적 계산 프로그램 ===");
        
        // 학생 정보 입력
        System.out.print("학생 이름: ");
        String name = TextIO.getln();
        
        System.out.print("학번: ");
        int studentId = TextIO.getlnInt();
        
        // 점수 입력
        System.out.print("중간고사 점수: ");
        double midterm = TextIO.getlnDouble();
        
        System.out.print("기말고사 점수: ");
        double finalExam = TextIO.getlnDouble();
        
        System.out.print("과제 점수: ");
        double homework = TextIO.getlnDouble();
        
        // 평균 계산
        double average = (midterm * 0.3 + finalExam * 0.4 + homework * 0.3);
        
        // 학점 계산
        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 80) grade = "B";
        else if (average >= 70) grade = "C";
        else if (average >= 60) grade = "D";
        else grade = "F";
        
        // 결과 출력 (화면)
        System.out.println("\n=== 성적표 ===");
        System.out.printf("이름: %s (학번: %d)%n", name, studentId);
        System.out.printf("중간: %.1f, 기말: %.1f, 과제: %.1f%n", 
                         midterm, finalExam, homework);
        System.out.printf("평균: %.2f점%n", average);
        System.out.printf("학점: %s%n", grade);
        
        // 결과를 파일로 저장
        TextIO.writeFile("grade_" + studentId + ".txt");
        TextIO.putln("성적표");
        TextIO.putln("================");
        TextIO.putf("학생: %s%n", name);
        TextIO.putf("학번: %d%n", studentId);
        TextIO.putln("----------------");
        TextIO.putf("중간고사: %.1f점%n", midterm);
        TextIO.putf("기말고사: %.1f점%n", finalExam);
        TextIO.putf("과제: %.1f점%n", homework);
        TextIO.putln("----------------");
        TextIO.putf("평균: %.2f점%n", average);
        TextIO.putf("학점: %s%n", grade);
        
        // 다시 표준 출력으로
        TextIO.writeStandardOutput();
        System.out.println("\n성적이 grade_" + studentId + ".txt 파일에 저장되었습니다.");
    }
}
```

## 요약

### 출력 방법
1. **기본 출력**: `System.out.print()`, `System.out.println()`
2. **서식 지정 출력**: `System.out.printf()` 
   - 정수: `%d`, 실수: `%f`, 문자열: `%s`
   - 너비와 정밀도 지정 가능

### 입력 방법
1. **TextIO 사용**
   - 초보자 친화적, 오류 처리 자동
   - getln 함수: 한 줄 전체 처리
   - get 함수: 같은 줄에서 여러 값 읽기

2. **Scanner 사용**
   - Java 표준 클래스
   - 별도 파일 불필요

### 파일 입출력
- 파일 쓰기: `TextIO.writeFile()`
- 파일 읽기: `TextIO.readFile()`
- 사용자 선택: `TextIO.writeUserSelectedFile()`

### 실무 팁
- 사용자 입력 전에 항상 안내 메시지 출력
- 금액은 천 단위 구분과 소수점 2자리로 표시
- 파일 작업 후 표준 입출력으로 복귀
- 입력 검증과 오류 처리 고려