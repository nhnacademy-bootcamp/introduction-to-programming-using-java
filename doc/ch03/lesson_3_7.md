# 3.7 예외와 try..catch 소개 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 예외(Exception)의 개념과 필요성을 이해한다
- try..catch문의 기본 구조와 동작 원리를 안다
- NumberFormatException과 IllegalArgumentException을 처리할 수 있다
- 파일 입출력에서의 예외 처리 방법을 익힌다
- 예외를 활용한 프로그램 흐름 제어를 구현할 수 있다

## 1. 예외(Exception) 개념

### 1.1 예외란 무엇인가?
예외는 프로그램의 **정상적인 실행 흐름을 방해하는 예상치 못한 상황**입니다.

### 1.2 예외가 발생하는 상황들
```java
// 1. 숫자 변환 실패
String str = "abc";
int number = Integer.parseInt(str); // NumberFormatException 발생!

// 2. 0으로 나누기
int a = 10;
int b = 0;
int result = a / b; // ArithmeticException 발생!

// 3. 배열 범위 초과
int[] array = new int[5];
int value = array[10]; // ArrayIndexOutOfBoundsException 발생!

// 4. null 객체 접근
String text = null;
int length = text.length(); // NullPointerException 발생!
```

### 1.3 예외가 없다면?
```java
// 예외 처리가 없는 경우의 문제점
public class WithoutExceptionHandling {
    public static void main(String[] args) {
        String userInput = "잘못된숫자";
        
        // 이 코드는 프로그램을 강제 종료시킴
        int number = Integer.parseInt(userInput);
        
        // 이 부분은 절대 실행되지 않음
        System.out.println("숫자: " + number);
        System.out.println("프로그램 계속 진행...");
    }
}
```

## 2. try..catch 기본 구조

### 2.1 기본 문법
```java
try {
    // 예외가 발생할 수 있는 코드
    위험한_코드();
} catch (예외타입 변수명) {
    // 예외가 발생했을 때 실행할 코드
    예외_처리_코드();
}
// 예외 발생 여부와 상관없이 계속 실행되는 코드
```

### 2.2 실행 흐름
```
1. try 블록 시작
   ↓
2. 코드 실행
   ↓
3. 예외 발생? 
   ↓        ↓
  Yes      No
   ↓        ↓
4. catch   4. try 블록 완료
   블록       ↓
   실행    5. try..catch 이후 코드 계속
   ↓        ↑
5. ────────┘
```

### 2.3 간단한 예제
```java
import textio.TextIO;

public class SimpleExceptionExample {
    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요: ");
        String input = TextIO.getln();
        
        try {
            // 위험한 코드: 문자열을 숫자로 변환
            int number = Integer.parseInt(input);
            System.out.println("입력한 숫자: " + number);
            System.out.println("숫자의 2배: " + (number * 2));
        } catch (NumberFormatException e) {
            // 예외 처리: 숫자가 아닌 경우
            System.out.println("올바른 숫자를 입력해주세요!");
            System.out.println("입력값: '" + input + "'는 숫자가 아닙니다.");
        }
        
        System.out.println("프로그램이 정상적으로 계속 진행됩니다.");
    }
}
```

## 3. 주요 예외 타입들

### 3.1 NumberFormatException
**발생 상황**: 문자열을 숫자로 변환할 때 실패
```java
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        String[] testInputs = {"123", "abc", "12.34", "", "  ", "∞"};
        
        for (String input : testInputs) {
            System.out.println("\n입력: '" + input + "'");
            
            try {
                int number = Integer.parseInt(input);
                System.out.println("✅ 성공: " + number);
            } catch (NumberFormatException e) {
                System.out.println("❌ 실패: " + e.getMessage());
                System.out.println("원인: 정수로 변환할 수 없는 형식");
            }
        }
    }
}
```

### 3.2 IllegalArgumentException
**발생 상황**: 메서드에 잘못된 인수를 전달할 때
```java
public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        // 1. 음수에 대한 제곱근 계산 시뮬레이션
        try {
            double result = calculateSquareRoot(-5);
            System.out.println("제곱근: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
        
        // 2. 잘못된 범위의 값
        try {
            setAge(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
    
    public static double calculateSquareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 제곱근을 구할 수 없습니다: " + number);
        }
        return Math.sqrt(number);
    }
    
    public static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("나이는 0-150 사이여야 합니다: " + age);
        }
        System.out.println("나이 설정 완료: " + age);
    }
}
```

## 4. 실용적인 예외 처리 패턴

### 4.1 사용자 입력 검증
```java
import textio.TextIO;

public class InputValidationExample {
    public static void main(String[] args) {
        int number = getValidInteger("1부터 100 사이의 숫자를 입력하세요: ");
        System.out.println("입력받은 숫자: " + number);
    }
    
    public static int getValidInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = TextIO.getln();
            
            try {
                int number = Integer.parseInt(input);
                
                // 범위 검증
                if (number < 1 || number > 100) {
                    System.out.println("❌ 1부터 100 사이의 숫자를 입력해주세요.");
                    continue;
                }
                
                return number; // 성공적으로 반환
                
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력해주세요.");
                System.out.println("   입력값: '" + input + "'");
            }
        }
    }
}
```

### 4.2 계산기 예제
```java
import textio.TextIO;

public class SafeCalculator {
    public static void main(String[] args) {
        System.out.println("=== 안전한 계산기 ===");
        
        while (true) {
            try {
                System.out.print("첫 번째 숫자: ");
                double num1 = getDoubleInput();
                
                System.out.print("연산자 (+, -, *, /, %, 또는 'quit'): ");
                String operator = TextIO.getln().trim();
                
                if (operator.equalsIgnoreCase("quit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
                
                System.out.print("두 번째 숫자: ");
                double num2 = getDoubleInput();
                
                double result = performCalculation(num1, num2, operator);
                System.out.printf("결과: %.2f %s %.2f = %.2f%n", 
                    num1, operator, num2, result);
                
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("수학 오류: " + e.getMessage());
            }
            
            System.out.println(); // 빈 줄
        }
    }
    
    private static double getDoubleInput() {
        while (true) {
            String input = TextIO.getln().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("올바른 숫자를 입력하세요: ");
            }
        }
    }
    
    private static double performCalculation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return num1 / num2;
            case "%":
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눈 나머지를 구할 수 없습니다");
                }
                return num1 % num2;
            default:
                throw new IllegalArgumentException("알 수 없는 연산자: " + operator);
        }
    }
}
```

## 5. 파일 처리와 예외

### 5.1 파일 읽기에서의 예외 처리
```java
import textio.TextIO;

public class FileReadingExample {
    public static void main(String[] args) {
        // 1. 파일 열기
        String fileName = getValidFileName();
        
        // 2. 파일에서 숫자 읽기
        readNumbersFromFile(fileName);
    }
    
    private static String getValidFileName() {
        while (true) {
            System.out.print("파일 이름을 입력하세요: ");
            String fileName = TextIO.getln();
            
            try {
                TextIO.readFile(fileName);
                System.out.println("✅ 파일을 성공적으로 열었습니다.");
                return fileName;
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 파일을 열 수 없습니다: " + fileName);
                System.out.println("   원인: 파일이 존재하지 않거나 접근할 수 없습니다.");
                System.out.println("   다시 시도해주세요.\n");
            }
        }
    }
    
    private static void readNumbersFromFile(String fileName) {
        double sum = 0;
        int count = 0;
        
        System.out.println("\n파일에서 숫자를 읽는 중...");
        
        try {
            while (true) { // 파일 끝까지 읽기
                double number = TextIO.getDouble();
                sum += number;
                count++;
                System.out.println("읽은 숫자: " + number);
            }
        } catch (IllegalArgumentException e) {
            // 파일의 끝에 도달했을 때 발생
            System.out.println("✅ 파일 읽기 완료");
        }
        
        // 결과 출력
        System.out.println("\n=== 결과 ===");
        System.out.println("읽은 숫자 개수: " + count);
        System.out.println("총합: " + sum);
        
        if (count > 0) {
            double average = sum / count;
            System.out.printf("평균: %.2f%n", average);
        } else {
            System.out.println("파일에 유효한 숫자가 없습니다.");
        }
    }
}
```

### 5.2 여러 타입의 예외 처리
```java
import textio.TextIO;

public class MultipleExceptionExample {
    public static void main(String[] args) {
        System.out.println("=== 다중 예외 처리 예제 ===");
        
        try {
            // 사용자로부터 배열 크기 입력
            System.out.print("배열 크기를 입력하세요: ");
            String sizeInput = TextIO.getln();
            int size = Integer.parseInt(sizeInput); // NumberFormatException 가능
            
            if (size <= 0) {
                throw new IllegalArgumentException("배열 크기는 양수여야 합니다.");
            }
            
            // 배열 생성
            int[] array = new int[size];
            
            // 배열 초기화
            for (int i = 0; i < size; i++) {
                System.out.print("array[" + i + "] = ");
                String valueInput = TextIO.getln();
                array[i] = Integer.parseInt(valueInput); // NumberFormatException 가능
            }
            
            // 특정 인덱스의 값 출력
            System.out.print("확인할 인덱스를 입력하세요: ");
            String indexInput = TextIO.getln();
            int index = Integer.parseInt(indexInput); // NumberFormatException 가능
            
            // 배열 접근
            int value = array[index]; // ArrayIndexOutOfBoundsException 가능
            System.out.println("array[" + index + "] = " + value);
            
            // 나눗셈 연산
            System.out.print("나눌 수를 입력하세요: ");
            String divisorInput = TextIO.getln();
            int divisor = Integer.parseInt(divisorInput); // NumberFormatException 가능
            
            int result = value / divisor; // ArithmeticException 가능
            System.out.println("결과: " + value + " / " + divisor + " = " + result);
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 숫자 형식 오류: 올바른 정수를 입력해주세요.");
            System.out.println("   오류 내용: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 잘못된 인수: " + e.getMessage());
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ 배열 범위 초과: 유효한 인덱스를 입력해주세요.");
            System.out.println("   오류 내용: " + e.getMessage());
            
        } catch (ArithmeticException e) {
            System.out.println("❌ 산술 오류: " + e.getMessage());
            
        } catch (Exception e) {
            // 예상치 못한 모든 예외 처리
            System.out.println("❌ 예상치 못한 오류가 발생했습니다.");
            System.out.println("   오류 타입: " + e.getClass().getSimpleName());
            System.out.println("   오류 내용: " + e.getMessage());
        }
        
        System.out.println("프로그램이 정상적으로 종료됩니다.");
    }
}
```

## 6. 예외 정보 활용하기

### 6.1 예외 객체의 유용한 메서드
```java
public class ExceptionInformationExample {
    public static void main(String[] args) {
        try {
            String invalidNumber = "12.34.56";
            int number = Integer.parseInt(invalidNumber);
            
        } catch (NumberFormatException e) {
            System.out.println("=== 예외 정보 분석 ===");
            
            // 1. 예외 메시지
            System.out.println("메시지: " + e.getMessage());
            
            // 2. 예외 타입
            System.out.println("예외 타입: " + e.getClass().getSimpleName());
            
            // 3. 전체 클래스명
            System.out.println("전체 클래스명: " + e.getClass().getName());
            
            // 4. toString() 메서드
            System.out.println("toString(): " + e.toString());
            
            // 5. 스택 트레이스 (디버깅용)
            System.out.println("\n스택 트레이스:");
            e.printStackTrace();
        }
    }
}
```

## 7. 실전 응용: 안전한 메뉴 시스템

### 7.1 견고한 메뉴 처리
```java
import textio.TextIO;

public class RobustMenuSystem {
    public static void main(String[] args) {
        System.out.println("=== 견고한 메뉴 시스템 ===");
        
        while (true) {
            showMenu();
            int choice = getMenuChoice();
            
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                break;
            }
            
            processMenuChoice(choice);
        }
    }
    
    private static void showMenu() {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("메뉴를 선택하세요:");
        System.out.println("1. 숫자 계산");
        System.out.println("2. 문자열 처리");
        System.out.println("3. 배열 작업");
        System.out.println("4. 파일 작업");
        System.out.println("0. 종료");
        System.out.println("=".repeat(30));
    }
    
    private static int getMenuChoice() {
        while (true) {
            System.out.print("선택 (0-4): ");
            
            try {
                String input = TextIO.getln().trim();
                int choice = Integer.parseInt(input);
                
                if (choice < 0 || choice > 4) {
                    System.out.println("❌ 0부터 4까지의 숫자를 입력해주세요.");
                    continue;
                }
                
                return choice;
                
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력해주세요.");
            }
        }
    }
    
    private static void processMenuChoice(int choice) {
        try {
            switch (choice) {
                case 1 -> handleNumberCalculation();
                case 2 -> handleStringProcessing();
                case 3 -> handleArrayOperation();
                case 4 -> handleFileOperation();
                default -> System.out.println("구현되지 않은 기능입니다.");
            }
        } catch (Exception e) {
            System.out.println("❌ 작업 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    private static void handleNumberCalculation() {
        System.out.println("\n🧮 숫자 계산 기능");
        
        try {
            System.out.print("첫 번째 숫자: ");
            double num1 = Double.parseDouble(TextIO.getln());
            
            System.out.print("두 번째 숫자: ");
            double num2 = Double.parseDouble(TextIO.getln());
            
            System.out.printf("덧셈: %.2f + %.2f = %.2f%n", num1, num2, num1 + num2);
            System.out.printf("뺄셈: %.2f - %.2f = %.2f%n", num1, num2, num1 - num2);
            System.out.printf("곱셈: %.2f × %.2f = %.2f%n", num1, num2, num1 * num2);
            
            if (num2 != 0) {
                System.out.printf("나눗셈: %.2f ÷ %.2f = %.2f%n", num1, num2, num1 / num2);
            } else {
                System.out.println("나눗셈: 0으로 나눌 수 없습니다.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 유효한 숫자를 입력해주세요.");
        }
    }
    
    private static void handleStringProcessing() {
        System.out.println("\n📝 문자열 처리 기능");
        
        System.out.print("문자열을 입력하세요: ");
        String text = TextIO.getln();
        
        if (text.trim().isEmpty()) {
            System.out.println("❌ 빈 문자열은 처리할 수 없습니다.");
            return;
        }
        
        System.out.println("길이: " + text.length());
        System.out.println("대문자: " + text.toUpperCase());
        System.out.println("소문자: " + text.toLowerCase());
        System.out.println("뒤집기: " + new StringBuilder(text).reverse().toString());
    }
    
    private static void handleArrayOperation() {
        System.out.println("\n📊 배열 작업 기능");
        
        try {
            System.out.print("배열 크기: ");
            int size = Integer.parseInt(TextIO.getln());
            
            if (size <= 0) {
                throw new IllegalArgumentException("배열 크기는 양수여야 합니다.");
            }
            
            int[] array = new int[size];
            int sum = 0;
            
            for (int i = 0; i < size; i++) {
                System.out.print("array[" + i + "] = ");
                array[i] = Integer.parseInt(TextIO.getln());
                sum += array[i];
            }
            
            System.out.println("배열: " + java.util.Arrays.toString(array));
            System.out.println("합계: " + sum);
            System.out.printf("평균: %.2f%n", (double) sum / size);
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 올바른 정수를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    
    private static void handleFileOperation() {
        System.out.println("\n📁 파일 작업 기능");
        System.out.println("(실제 파일 작업은 고급 과정에서 다룹니다)");
        
        System.out.print("파일 이름을 입력하세요: ");
        String fileName = TextIO.getln();
        
        if (fileName.trim().isEmpty()) {
            System.out.println("❌ 파일 이름을 입력해주세요.");
            return;
        }
        
        System.out.println("✅ 파일 '" + fileName + "'를 처리했다고 가정합니다.");
    }
}
```

## 8. 예외 처리 모범 사례

### 8.1 좋은 예외 처리 원칙
```java
public class ExceptionBestPractices {
    // ✅ 좋은 예외 처리
    public static int parsePositiveInteger(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 비어있습니다.");
        }
        
        try {
            int number = Integer.parseInt(input.trim());
            
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 허용됩니다: " + number);
            }
            
            return number;
            
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수 형식이 아닙니다: '" + input + "'");
        }
    }
    
    // ✅ 안전한 나눗셈
    public static double safeDivide(double dividend, double divisor) {
        if (divisor == 0.0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        
        return dividend / divisor;
    }
}
```

### 8.2 피해야 할 패턴
```java
public class BadExceptionPractices {
    // ❌ 나쁜 예: 예외를 무시
    public static void badExample1() {
        try {
            int number = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            // 아무것도 하지 않음 - 매우 위험!
        }
    }
    
    // ❌ 나쁜 예: 너무 광범위한 예외 처리
    public static void badExample2() {
        try {
            // 복잡한 코드...
            int number = Integer.parseInt("123");
            int[] array = new int[number];
            System.out.println(array[0]);
        } catch (Exception e) {
            // 모든 예외를 똑같이 처리 - 좋지 않음!
            System.out.println("뭔가 잘못됐습니다.");
        }
    }
}
```

## 요약

### 예외 처리의 핵심 개념
- **예외**: 프로그램 실행 중 발생하는 예상치 못한 상황
- **try..catch**: 예외를 잡아서 처리하는 구조
- **예외 타입**: NumberFormatException, IllegalArgumentException 등
- **예외 객체**: 오류 정보를 담고 있는 객체

### try..catch 구조
```java
try {
    // 위험할 수 있는 코드
} catch (구체적예외타입 e) {
    // 해당 예외에 대한 처리
} catch (일반예외타입 e) {
    // 기타 예외에 대한 처리
}
```

### 주요 활용 패턴
1. **사용자 입력 검증**: 잘못된 입력에 대한 안전한 처리
2. **파일 처리**: 파일 접근 실패에 대한 대응
3. **계산 안전성**: 나눗셈 등에서 오류 방지
4. **프로그램 견고성**: 예외로 인한 프로그램 종료 방지

### 모범 사례
- **구체적인 예외 타입** 사용하기
- **의미 있는 오류 메시지** 제공하기
- **예외를 무시하지 말고** 적절히 처리하기
- **사용자에게 친화적인** 오류 안내 제공하기

💡 **기억하세요**: 예외 처리는 프로그램을 더 견고하고 사용자 친화적으로 만드는 중요한 도구입니다!