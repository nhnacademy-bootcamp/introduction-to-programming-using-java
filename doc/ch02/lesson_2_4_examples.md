# 2.4 텍스트 입력과 출력 - 예제 모음

## 1. 기본 출력 예제

### 예제 1-1: print와 println의 차이
```java
public class PrintVsPrintln {
    public static void main(String[] args) {
        // TODO: print와 println의 차이를 보여주는 코드를 작성하세요
        // 힌트:
        // 1. print로 "첫 번째 ", "두 번째 ", "세 번째" 출력 후 println()으로 줄바꿈
        // 2. println으로 "첫 번째", "두 번째", "세 번째" 각각 출력
        // 3. print와 println 혼합: "이름: "(print) + "홍길동"(println), "나이: "(print) + 25(println)
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
첫 번째 두 번째 세 번째
첫 번째
두 번째
세 번째
이름: 홍길동
나이: 25
```

### 예제 1-2: 다양한 타입 출력
```java
public class OutputTypes {
    public static void main(String[] args) {
        // TODO: 다양한 타입의 변수를 생성하고 출력하세요
        // 힌트:
        // 1. 변수 생성: age=25, height=175.5, grade='A', isStudent=true, name="김철수"
        // 2. "=== 학생 정보 ===" 출력
        // 3. 각 변수를 "이름: "+name 형식으로 출력
        // 4. 한 줄 요약: name + ", " + age + "세, " + height + "cm, 학점 " + grade
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 학생 정보 ===
이름: 김철수
나이: 25
키: 175.5cm
학점: A
재학중: true

한 줄 요약:
김철수, 25세, 175.5cm, 학점 A
```

## 2. printf를 사용한 서식 지정 출력

### 예제 2-1: 기본 서식 지정자
```java
public class PrintfBasics {
    public static void main(String[] args) {
        // TODO: printf를 사용하여 다양한 타입을 서식에 맞게 출력하세요
        // 힌트:
        // 1. 변수 생성: intValue=42, doubleValue=3.14159, stringValue="Java", charValue='A', boolValue=true
        // 2. printf로 각 타입 출력: %d(정수), %f(실수), %s(문자열), %c(문자), %b(불린)
        // 3. 여러 값을 한 번에 출력: "Java 언어의 버전 42는 원주율 3.14를 지원합니다."
        // 4. 특수 문자: 백분율(%), 탭 문자, 따옴표 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
정수: 42
실수: 3.141590
문자열: Java
문자: A
불린: true

Java 언어의 버전 42는 원주율 3.14를 지원합니다.
백분율: 50%
탭 문자:	Hello	World
따옴표: "Java"
```

### 예제 2-2: 숫자 서식 지정
```java
public class NumberFormatting {
    public static void main(String[] args) {
        // TODO: 다양한 숫자 서식을 사용하여 출력하세요
        // 힌트:
        // 1. 정수 서식 (number=42): 기본, 5자리 정렬, 0으로 채우기
        // 2. 천단위 구분 (bigNumber=1234567890): %,d 사용
        // 3. 실수 서식 (pi=3.141592653589793, money=12345.678): 소수점 자릿수 조정
        // 4. 지수 표기법 (bigDouble=6.022e23): %e 사용
        // 5. g 서식으로 0.000123, 123.456, 1234567890.0 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 정수 서식 ===
기본: 42
5자리 오른쪽 정렬: '   42'
5자리 왼쪽 정렬: '42   '
빈자리 0으로 채우기: 00042
천단위 구분: 1,234,567,890

=== 실수 서식 ===
기본: 3.141593
소수점 2자리: 3.14
소수점 4자리: 3.1416
전체 10자리, 소수점 2자리:       3.14
금액 표시: 12,345.68원
지수 표기법: 6.022000e+23
지수 표기법 (2자리): 6.02e+23

=== g 서식 (자동 선택) ===
0.000123
123.456
1.23457e+09
```

### 예제 2-3: 문자열 서식 지정
```java
public class StringFormatting {
    public static void main(String[] args) {
        // TODO: 문자열 서식을 사용하여 테이블 형태로 출력하세요
        // 힌트:
        // 1. 배열 생성: names={"김철수", "이영희", "박민수", "최서연"}, ages={25, 30, 28, 22}, scores={85.5, 92.3, 78.9, 95.7}
        // 2. 헤더 출력: printf로 "이름", "나이", "점수"를 정렬하여 출력
        // 3. 구분선: "-".repeat(28) 출력
        // 4. 반복문으로 각 학생 정보를 printf로 정렬하여 출력
        // 5. 문자열 정렬 예제: "Java Programming"을 다양한 정렬로 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 학생 명단 ===
이름           나이     점수
----------------------------
김철수          25     85.5
이영희          30     92.3
박민수          28     78.9
최서연          22     95.7

=== 정렬 예제 ===
기본: 'Java Programming'
20자 오른쪽 정렬: '    Java Programming'
20자 왼쪽 정렬: 'Java Programming    '
```

### 예제 2-4: 텍스트 블록과 printf
```java
public class TextBlockPrintf {
    public static void main(String[] args) {
        // TODO: 텍스트 블록과 printf를 조합하여 영수증을 출력하세요
        // 힌트:
        // 1. 변수 생성: name="홍길동", itemCount=3, totalPrice=45000.0
        // 2. 텍스트 블록(""")을 사용하여 영수증 틀 만들기
        // 3. printf로 변수 값들을 서식에 맞게 출력
        // 4. 단가 계산: totalPrice / itemCount
        // 5. 상세 내역도 텍스트 블록으로 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
┌─────────────────────────┐
│       영수증            │
├─────────────────────────┤
│ 고객명: 홍길동           │
│ 구매 수량:   3개        │
│ 총 금액:     45,000원  │
└─────────────────────────┘

=== 상세 내역 ===
단가: 15,000원
수량: 3개
─────────────────
합계: 45,000원
```

## 3. TextIO 입력 예제

### 예제 3-1: 기본 입력
```java
import textio.TextIO;

public class BasicInput {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 다양한 타입의 입력을 받고 출력하세요
        // 힌트:
        // 1. "=== 기본 정보 입력 ===" 출력
        // 2. TextIO.getlnInt()로 나이 입력
        // 3. TextIO.getlnDouble()로 키 입력
        // 4. TextIO.getlnChar()로 혈액형 입력
        // 5. TextIO.getlnBoolean()로 학생 여부 입력
        // 6. TextIO.getlnWord()로 이름(성만) 입력
        // 7. TextIO.getln()으로 주소 입력
        // 8. printf로 결과를 서식에 맞게 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 기본 정보 입력 ===
나이를 입력하세요: 25
키를 입력하세요(cm): 175.5
혈액형을 입력하세요(A/B/O/AB 중 첫 글자): A
학생입니까? (yes/no): yes
이름을 입력하세요(성만): 김
주소를 입력하세요: 서울시 강남구

=== 입력된 정보 ===
이름: 김
나이: 25세
키: 175.5cm
혈액형: A형
학생 여부: 예
주소: 서울시 강남구
```

### 예제 3-2: 계산기 프로그램
```java
import textio.TextIO;

public class Calculator {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 간단한 계산기를 만드세요
        // 힌트:
        // 1. "=== 간단한 계산기 ===" 출력
        // 2. 첫 번째 숫자를 getlnDouble()로 입력받기
        // 3. 연산자를 getlnChar()로 입력받기 (+, -, *, /)
        // 4. 두 번째 숫자를 getlnDouble()로 입력받기
        // 5. switch문으로 연산 수행
        // 6. 0으로 나누기 오류 처리
        // 7. printf로 결과 출력: "숫자1 연산자 숫자2 = 결과"
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 간단한 계산기 ===
첫 번째 숫자: 10.5
연산자 (+, -, *, /): *
두 번째 숫자: 2.5

10.50 * 2.50 = 26.25
```

### 예제 3-3: 성적 처리 프로그램
```java
import textio.TextIO;

public class GradeProcessor {
    public static void main(String[] args) {
        // TODO: 성적 처리 프로그램을 만드세요
        // 힌트:
        // 1. "=== 성적 처리 프로그램 ===" 출력
        // 2. 학생 이름(getln)과 학번(getlnInt) 입력
        // 3. 4과목 점수 입력 (국어, 영어, 수학, 과학)
        // 4. 평균 계산: (국어+영어+수학+과학) / 4.0
        // 5. 학점 계산: 90이상=A, 80이상=B, 70이상=C, 60이상=D, 그외=F
        // 6. 성적표를 printf로 서식에 맞게 출력
        // 7. 평균에 따른 평가 메시지 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 성적 처리 프로그램 ===
학생 이름: 김철수
학번: 20240001

과목별 점수를 입력하세요 (0-100):
국어: 85.5
영어: 92.0
수학: 78.5
과학: 88.0

=== 성적표 ===
이름: 김철수 (학번: 20240001)
──────────────────────────────
국어:   85.5점
영어:   92.0점
수학:   78.5점
과학:   88.0점
──────────────────────────────
평균:   86.0점
학점: B

좋은 성적입니다. 계속 노력하세요!
```

### 예제 3-4: 한 줄에서 여러 값 입력
```java
import textio.TextIO;

public class MultipleInputs {
    public static void main(String[] args) {
        // TODO: TextIO의 getln과 get의 차이를 활용하여 좌표 입력 프로그램을 만드세요
        // 힌트:
        // 1. "=== 좌표 입력 프로그램 ===" 출력
        // 2. 방법1: getlnInt()로 x, y 각각 입력받기
        // 3. 방법2: getInt()로 x, y를 한 줄에 입력받기 (getln()으로 줄 정리)
        // 4. 방법3: getInt()로 x, y, z를 한 줄에 입력받기
        // 5. Math.sqrt()를 사용하여 원점에서의 거리 계산
        // 6. printf로 좌표와 거리를 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 좌표 입력 프로그램 ===

[방법 1] 각 값을 별도의 줄에 입력:
x 좌표: 3
y 좌표: 4
입력된 좌표: (3, 4)

[방법 2] 한 줄에 두 값 입력 (공백으로 구분):
x y 좌표 입력: 5 12
입력된 좌표: (5, 12)

[방법 3] 3차원 좌표 입력:
x y z 좌표 입력: 3 4 5
입력된 3D 좌표: (3, 4, 5)

2D 원점으로부터의 거리: 13.00
3D 원점으로부터의 거리: 7.07
```

## 4. 파일 입출력 예제

### 예제 4-1: 파일에 쓰기
```java
import textio.TextIO;

public class WriteToFile {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 일기를 파일에 저장하는 프로그램을 만드세요
        // 힌트:
        // 1. "=== 일기장 프로그램 ===" 출력
        // 2. 날짜와 날씨를 getln()으로 입력받기
        // 3. while문으로 일기 내용을 여러 줄 입력받기 (빈 줄까지)
        // 4. TextIO.writeFile()로 파일 출력 모드로 전환
        // 5. TextIO.putln()으로 일기 내용을 파일에 출력
        // 6. TextIO.writeStandardOutput()으로 표준 출력으로 복귀
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 일기장 프로그램 ===
날짜 (예: 2024-01-15): 2024-01-15
날씨: 맑음
일기 내용을 입력하세요 (종료: 빈 줄 입력):
오늘은 날씨가 참 좋았다.
Java 프로그래밍을 열심히 공부했다.
파일 입출력에 대해 배웠다.

일기가 diary_2024-01-15.txt 파일에 저장되었습니다.
```

### 예제 4-2: 파일에서 읽기
```java
import textio.TextIO;

public class ReadFromFile {
    public static void main(String[] args) {
        // TODO: TextIO를 사용하여 파일을 읽어오는 프로그램을 만드세요
        // 힌트:
        // 1. "=== 파일 읽기 프로그램 ===" 출력
        // 2. 파일 이름을 getln()으로 입력받기
        // 3. try-catch로 예외 처리
        // 4. TextIO.readFile()로 파일 입력 모드로 전환
        // 5. while(!TextIO.eof())로 파일 끝까지 읽기
        // 6. 줄 번호와 함께 내용 출력
        // 7. TextIO.readStandardInput()으로 표준 입력으로 복귀
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 파일 읽기 프로그램 ===
읽을 파일 이름: diary_2024-01-15.txt

=== 파일 내용 ===
  1: === 일기 ===
  2: 날짜: 2024-01-15
  3: 날씨: 맑음
  4: ──────────────────────────────
  5: 오늘은 날씨가 참 좋았다.
  6: Java 프로그래밍을 열심히 공부했다.
  7: 파일 입출력에 대해 배웠다.
  8: ──────────────────────────────

파일 읽기 완료!
```

### 예제 4-3: 학생 명부 관리
```java
import textio.TextIO;

public class StudentRoster {
    public static void main(String[] args) {
        System.out.println("=== 학생 명부 관리 시스템 ===");
        
        // 메뉴 선택
        System.out.println("1. 새 학생 추가");
        System.out.println("2. 명부 보기");
        System.out.print("선택: ");
        int choice = TextIO.getlnInt();
        
        if (choice == 1) {
            // 학생 정보 입력
            System.out.print("학번: ");
            int id = TextIO.getlnInt();
            System.out.print("이름: ");
            String name = TextIO.getln();
            System.out.print("학과: ");
            String major = TextIO.getln();
            System.out.print("학년: ");
            int year = TextIO.getlnInt();
            
            // 파일에 추가 (append 모드)
            TextIO.writeFile("students.txt");
            TextIO.putf("%d,%s,%s,%d%n", id, name, major, year);
            
            TextIO.writeStandardOutput();
            System.out.println("학생 정보가 추가되었습니다.");
            
        } else if (choice == 2) {
            // 명부 읽기
            try {
                TextIO.readFile("students.txt");
                
                System.out.println("\n=== 학생 명부 ===");
                System.out.printf("%-10s %-15s %-20s %s%n", 
                                 "학번", "이름", "학과", "학년");
                System.out.println("─".repeat(55));
                
                while (!TextIO.eof()) {
                    String line = TextIO.getln();
                    // 간단한 파싱 (실제로는 더 정교한 방법 필요)
                    System.out.println(line);
                }
                
                TextIO.readStandardInput();
            } catch (IllegalArgumentException e) {
                System.out.println("명부 파일이 없습니다.");
            }
        }
    }
}
```

## 5. Scanner 사용 예제

### 예제 5-1: Scanner 기본 사용
```java
import java.util.Scanner;

public class ScannerBasics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Scanner 입력 테스트 ===");
        
        // 정수 입력
        System.out.print("정수를 입력하세요: ");
        int intValue = input.nextInt();
        
        // 실수 입력
        System.out.print("실수를 입력하세요: ");
        double doubleValue = input.nextDouble();
        
        // 버퍼 비우기 (중요!)
        input.nextLine();
        
        // 문자열 입력
        System.out.print("이름을 입력하세요: ");
        String name = input.nextLine();
        
        // 단어 입력
        System.out.print("좋아하는 색을 입력하세요: ");
        String color = input.next();
        
        // 결과 출력
        System.out.println("\n=== 입력된 값 ===");
        System.out.printf("정수: %d%n", intValue);
        System.out.printf("실수: %.2f%n", doubleValue);
        System.out.printf("이름: %s%n", name);
        System.out.printf("색상: %s%n", color);
    }
}
```

### 예제 5-2: Scanner vs TextIO 비교
```java
import java.util.Scanner;
import textio.TextIO;

public class ScannerVsTextIO {
    public static void main(String[] args) {
        System.out.println("=== Scanner vs TextIO 비교 ===");
        
        // Scanner 사용
        System.out.println("\n[Scanner 사용]");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Scanner - 숫자 입력 (문자 입력시 오류): ");
        try {
            int num1 = scanner.nextInt();
            System.out.println("입력된 숫자: " + num1);
        } catch (Exception e) {
            System.out.println("오류 발생! Scanner는 재입력을 요구하지 않습니다.");
            scanner.nextLine(); // 버퍼 정리
        }
        
        // TextIO 사용
        System.out.println("\n[TextIO 사용]");
        System.out.print("TextIO - 숫자 입력 (문자 입력시 재입력 요구): ");
        int num2 = TextIO.getlnInt();
        System.out.println("입력된 숫자: " + num2);
        
        // 특징 비교
        System.out.println("\n=== 특징 비교 ===");
        System.out.println("Scanner:");
        System.out.println("- Java 표준 클래스");
        System.out.println("- 오류시 예외 발생");
        System.out.println("- import java.util.Scanner 필요");
        
        System.out.println("\nTextIO:");
        System.out.println("- 별도 클래스 파일 필요");
        System.out.println("- 자동 오류 처리 및 재입력");
        System.out.println("- import textio.TextIO 필요");
    }
}
```

## 6. 종합 예제

### 예제 6-1: 쇼핑 계산기
```java
import textio.TextIO;

public class ShoppingCalculator {
    public static void main(String[] args) {
        // TODO: 쇼핑 계산기 프로그램을 만드세요
        // 힌트:
        // 1. "=== 쇼핑 계산기 ===" 출력
        // 2. while문으로 상품명 입력 (quit 입력시 종료)
        // 3. 가격과 수량 입력받기
        // 4. 소계 계산하여 총액에 누적
        // 5. 영수증 출력 (총액 10만원 이상시 10% 할인)
        // 6. 파일 저장 여부 확인 후 저장
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 쇼핑 계산기 ===

상품명 (종료: 'quit'): 노트북
가격: 1200000
수량: 1
노트북 1개 = 1,200,000원

상품명 (종료: 'quit'): 마우스
가격: 50000
수량: 2
마우스 2개 = 100,000원

상품명 (종료: 'quit'): quit

==============================
영수증
==============================
구매 품목: 2개
총액: 1,300,000원
할인(10%): -130,000원
결제금액: 1,170,000원
==============================

영수증을 파일로 저장하시겠습니까? (yes/no): yes
영수증이 receipt.txt에 저장되었습니다.
```

### 예제 6-2: 단어 빈도 분석
```java
import textio.TextIO;

public class WordFrequency {
    public static void main(String[] args) {
        // TODO: 텍스트 분석 프로그램을 만드세요
        // 힌트:
        // 1. "=== 단어 빈도 분석 ===" 출력
        // 2. while문으로 여러 줄 텍스트 입력받기 (빈 줄까지)
        // 3. for문으로 문자별 분석: 문자 수, 모음 수, 문장 수 계산
        // 4. 단어 수 계산 (공백, 문장부호로 구분)
        // 5. 평균 단어 길이와 문장당 평균 단어 수 계산
        // 6. printf로 분석 결과를 서식에 맞게 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 단어 빈도 분석 ===
텍스트를 입력하세요 (종료: 빈 줄):
Hello World! This is a test.
Java programming is fun.

=== 분석 결과 ===
총 문자 수: 47
총 단어 수: 9
모음 개수: 14
문장 수: 2
평균 단어 길이: 5.2
문장당 평균 단어 수: 4.5
```