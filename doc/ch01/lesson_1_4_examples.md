# 1.4장: 단계별 예제와 실습

## 1. 변수 선언과 할당 - 단계별 예제

### 예제 1-1: 기본 변수 선언과 할당

```java
public class VariableExample {
    public static void main(String[] args) {
        // 단계 1: 변수 선언
        int age;                    // 정수형 변수 선언
        
        // 단계 2: 변수에 값 할당
        age = 25;                   // age 변수에 25 저장
        
        // 단계 3: 변수 사용
        System.out.println("나이: " + age);
        
        // 단계 4: 변수 값 변경
        age = age + 1;              // 1살 증가
        System.out.println("내년 나이: " + age);
    }
}
```

**실행 과정 설명:**
1. `int age;` - 메모리에 정수를 저장할 공간 확보
2. `age = 25;` - 확보된 공간에 25라는 값 저장
3. `age + 1` - 현재 값(25)에 1을 더해 26 계산
4. `age = 26` - 계산된 값을 다시 age에 저장

### 예제 1-2: 여러 타입의 변수 활용

```java
public class MultipleVariables {
    public static void main(String[] args) {
        // 단계 1: 다양한 타입의 변수 선언과 초기화
        String name = "김철수";      // 문자열
        int age = 20;               // 정수
        double height = 175.5;      // 실수
        char grade = 'A';           // 문자
        boolean isStudent = true;   // 불린
        
        // 단계 2: 변수들을 활용한 계산
        int birthYear = 2024 - age;
        double heightInFeet = height / 30.48;  // cm를 feet로 변환
        
        // 단계 3: 결과 출력
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "세");
        System.out.println("출생년도: " + birthYear + "년");
        System.out.println("키: " + height + "cm (" + 
                          String.format("%.2f", heightInFeet) + " feet)");
        System.out.println("성적: " + grade);
        System.out.println("재학생 여부: " + isStudent);
    }
}
```

## 2. If-Else 문 실행 흐름 - 단계별 예제

### 예제 2-1: 간단한 조건문

```java
public class SimpleIfExample {
    public static void main(String[] args) {
        int score = 85;
        
        // 단계 1: 조건 검사
        System.out.println("점수: " + score);
        System.out.println("합격 기준: 70점");
        
        // 단계 2: if 문 실행
        if (score >= 70) {
            // 조건이 참일 때 실행
            System.out.println("조건 (score >= 70)이 참입니다.");
            System.out.println("축하합니다! 합격입니다.");
        } else {
            // 조건이 거짓일 때 실행
            System.out.println("조건 (score >= 70)이 거짓입니다.");
            System.out.println("아쉽지만 불합격입니다.");
        }
        
        System.out.println("프로그램 종료");
    }
}
```

### 예제 2-2: 복잡한 조건문 (이자 계산)

```java
public class InterestCalculator {
    public static void main(String[] args) {
        double principal = 15000;  // 원금
        double interestRate;       // 이자율
        double interest;           // 이자
        
        System.out.println("=== 이자 계산 프로그램 ===");
        System.out.println("원금: " + principal + "원");
        
        // 단계별 조건 검사
        System.out.println("\n조건 검사 시작...");
        
        if (principal > 10000) {
            System.out.println("원금이 10,000원보다 큽니다.");
            interestRate = 0.05;  // 5%
            System.out.println("적용 이자율: 5%");
        } else {
            System.out.println("원금이 10,000원 이하입니다.");
            interestRate = 0.04;  // 4%
            System.out.println("적용 이자율: 4%");
        }
        
        // 이자 계산
        interest = principal * interestRate;
        
        System.out.println("\n=== 계산 결과 ===");
        System.out.println("원금: " + principal + "원");
        System.out.println("이자율: " + (interestRate * 100) + "%");
        System.out.println("이자: " + interest + "원");
        System.out.println("총액: " + (principal + interest) + "원");
    }
}
```

## 3. 루프 실행 흐름 - 단계별 예제

### 예제 3-1: While 루프의 단계별 실행

```java
public class WhileLoopSteps {
    public static void main(String[] args) {
        int count = 0;
        
        System.out.println("=== While 루프 실행 추적 ===");
        
        while (count < 5) {
            System.out.println("\n[루프 시작]");
            System.out.println("현재 count: " + count);
            System.out.println("조건 (count < 5): " + (count < 5) + " - 계속 실행");
            
            // 루프 본문
            System.out.println("루프 본문 실행 중...");
            System.out.println("출력: count = " + count);
            
            // count 증가
            count++;
            System.out.println("count 증가 후: " + count);
            System.out.println("[루프 끝] - 조건 재검사로 이동");
        }
        
        System.out.println("\n최종 count: " + count);
        System.out.println("조건 (count < 5): " + (count < 5) + " - 루프 종료");
        System.out.println("프로그램 종료");
    }
}
```

### 예제 3-2: For 루프 구성 요소

```java
public class ForLoopComponents {
    public static void main(String[] args) {
        System.out.println("=== For 루프 구성 요소 ===");
        
        // for (초기화; 조건; 업데이트)
        System.out.println("for (int i = 0; i < 5; i++)");
        System.out.println("1. 초기화: int i = 0");
        System.out.println("2. 조건: i < 5");
        System.out.println("3. 업데이트: i++");
        System.out.println("\n실행 순서:");
        System.out.println("초기화 → 조건 검사 → 본문 실행 → 업데이트 → 조건 검사 → ...");
        
        System.out.println("\n=== 실제 실행 추적 ===");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("\n반복 " + (i + 1) + ":");
            System.out.println("  i = " + i);
            System.out.println("  조건 (i < 5): " + (i < 5));
            System.out.println("  본문 실행: Hello " + i);
            
            if (i < 4) {
                System.out.println("  i++ 실행 후 i = " + (i + 1));
            }
        }
        
        System.out.println("\n루프 종료 (i = 5, 조건 불만족)");
    }
}
```

### 예제 3-3: 중첩 루프 시각화

```java
public class NestedLoopVisualization {
    public static void main(String[] args) {
        System.out.println("=== 중첩 루프 실행 과정 ===");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n외부 루프 시작: i = " + i);
            
            for (int j = 1; j <= 3; j++) {
                System.out.println("  내부 루프: j = " + j);
                System.out.println("    출력: (" + i + ", " + j + ")");
            }
            
            System.out.println("외부 루프 계속...");
        }
        
        System.out.println("\n=== 구구단 예제 ===");
        for (int i = 2; i <= 4; i++) {
            System.out.println("\n" + i + "단:");
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%d × %d = %d\n", i, j, i * j);
            }
        }
    }
}
```

## 4. 서브루틴(메소드) 정의와 호출 - 단계별 예제

### 예제 4-1: 간단한 메소드

```java
public class SimpleMethodExample {
    // 단계 1: 메소드 정의
    public static void drawLine() {
        System.out.println("====================");
    }
    
    public static void drawBox() {
        drawLine();  // 다른 메소드 호출
        System.out.println("|                  |");
        System.out.println("|    HELLO JAVA    |");
        System.out.println("|                  |");
        drawLine();
    }
    
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        
        // 단계 2: 메소드 호출
        System.out.println("\ndrawLine() 호출:");
        drawLine();
        
        System.out.println("\ndrawBox() 호출:");
        drawBox();
        
        System.out.println("\n메소드를 여러 번 호출:");
        drawLine();
        System.out.println("첫 번째 상자");
        drawLine();
        System.out.println("두 번째 상자");
        drawLine();
        
        System.out.println("\n프로그램 종료");
    }
}
```

### 예제 4-2: 매개변수가 있는 메소드

```java
public class ParameterMethodExample {
    // 매개변수가 있는 메소드
    public static void printInfo(String name, int age) {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "세");
        
        if (age >= 18) {
            System.out.println(name + "님은 성인입니다.");
        } else {
            System.out.println(name + "님은 미성년자입니다.");
        }
    }
    
    // 반환값이 있는 메소드
    public static int calculateBirthYear(int age) {
        int currentYear = 2024;
        int birthYear = currentYear - age;
        return birthYear;  // 값 반환
    }
    
    // 여러 매개변수와 반환값
    public static double calculateBMI(double weight, double height) {
        // BMI = 체중(kg) / (키(m))²
        double heightInMeter = height / 100.0;
        double bmi = weight / (heightInMeter * heightInMeter);
        return bmi;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 메소드 호출 예제 ===\n");
        
        // 메소드 호출 1
        System.out.println("printInfo 메소드 호출:");
        printInfo("김철수", 25);
        
        System.out.println("\n다른 값으로 호출:");
        printInfo("이영희", 17);
        
        // 메소드 호출 2 - 반환값 받기
        System.out.println("\n출생년도 계산:");
        int birthYear = calculateBirthYear(25);
        System.out.println("25세의 출생년도: " + birthYear + "년");
        
        // 메소드 호출 3 - BMI 계산
        System.out.println("\nBMI 계산:");
        double bmi = calculateBMI(70.5, 175.0);
        System.out.printf("체중 70.5kg, 키 175cm의 BMI: %.2f\n", bmi);
        
        // 메소드의 반환값을 직접 사용
        System.out.println("\n직접 출력:");
        System.out.println("30세의 출생년도: " + calculateBirthYear(30));
    }
}
```

### 예제 4-3: 메소드 실행 흐름 추적

```java
public class MethodFlowTrace {
    public static void method1() {
        System.out.println("  method1 시작");
        System.out.println("  method1에서 method2 호출");
        method2();
        System.out.println("  method1 종료");
    }
    
    public static void method2() {
        System.out.println("    method2 시작");
        System.out.println("    method2 실행 중...");
        System.out.println("    method2 종료");
    }
    
    public static int add(int a, int b) {
        System.out.println("  add 메소드 호출됨");
        System.out.println("  매개변수: a = " + a + ", b = " + b);
        int result = a + b;
        System.out.println("  계산 결과: " + result);
        System.out.println("  값 반환하고 종료");
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== 메소드 실행 흐름 추적 ===\n");
        
        System.out.println("main 시작");
        
        System.out.println("\n1. method1 호출:");
        method1();
        
        System.out.println("\n2. add 메소드 호출:");
        int sum = add(10, 20);
        System.out.println("main에서 받은 결과: " + sum);
        
        System.out.println("\nmain 종료");
    }
}
```

## 5. 종합 예제: 계산기 프로그램

```java
import java.util.Scanner;

public class CalculatorProgram {
    // 덧셈 메소드
    public static double add(double a, double b) {
        return a + b;
    }
    
    // 뺄셈 메소드
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    // 곱셈 메소드
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    // 나눗셈 메소드
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("오류: 0으로 나눌 수 없습니다!");
            return 0;
        }
        return a / b;
    }
    
    // 메뉴 출력 메소드
    public static void printMenu() {
        System.out.println("\n=== 계산기 메뉴 ===");
        System.out.println("1. 덧셈");
        System.out.println("2. 뺄셈");
        System.out.println("3. 곱셈");
        System.out.println("4. 나눗셈");
        System.out.println("5. 종료");
        System.out.print("선택: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1, num2, result;
        boolean running = true;
        
        System.out.println("=== 간단한 계산기 프로그램 ===");
        
        while (running) {
            printMenu();
            choice = scanner.nextInt();
            
            if (choice == 5) {
                System.out.println("프로그램을 종료합니다.");
                running = false;
                continue;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                continue;
            }
            
            // 숫자 입력 받기
            System.out.print("첫 번째 숫자: ");
            num1 = scanner.nextDouble();
            System.out.print("두 번째 숫자: ");
            num2 = scanner.nextDouble();
            
            // 선택에 따라 계산 수행
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.printf("%.2f × %.2f = %.2f\n", num1, num2, result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    if (num2 != 0) {
                        System.out.printf("%.2f ÷ %.2f = %.2f\n", num1, num2, result);
                    }
                    break;
            }
        }
        
        scanner.close();
    }
}
```

## 6. 디버깅 연습: 오류 찾기

다음 코드들에는 오류가 있습니다. 오류를 찾아 수정해보세요:

### 연습 문제 1
```java
public class ErrorExample1 {
    public static void main(String[] args) {
        int x = 10
        int y = 20;
        int sum = x + y
        System.out.println("합: " sum);
    }
}
```

**정답:**
```java
public class ErrorExample1 {
    public static void main(String[] args) {
        int x = 10;  // 세미콜론 추가
        int y = 20;
        int sum = x + y;  // 세미콜론 추가
        System.out.println("합: " + sum);  // + 연산자 추가
    }
}
```

### 연습 문제 2
```java
public class ErrorExample2 {
    public static void main(String[] args) {
        for (int i = 0, i < 5, i++) {
            System.out.println(i);
        }
    }
}
```

**정답:**
```java
public class ErrorExample2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {  // 쉼표를 세미콜론으로 변경
            System.out.println(i);
        }
    }
}
```

### 연습 문제 3
```java
public class ErrorExample3 {
    public static int add(int a, int b) {
        int sum = a + b;
        // return이 없음
    }
    
    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println(result);
    }
}
```

**정답:**
```java
public class ErrorExample3 {
    public static int add(int a, int b) {
        int sum = a + b;
        return sum;  // return 문 추가
    }
    
    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println(result);
    }
}
```

이러한 단계별 예제들을 통해 프로그래밍의 기본 구성 요소들이 어떻게 작동하는지 명확히 이해할 수 있습니다.