# 3.7 예외와 try..catch - 예제 모음

## 1. 기본 예외 처리 예제

### 예제 1-1: 숫자 변환 예외 처리
```java
import textio.TextIO;

public class NumberParsingExample {
    public static void main(String[] args) {
        System.out.println("=== 숫자 변환 예제 ===");
        
        String[] testInputs = {"123", "45.67", "abc", "12x", "", "  ", "-789"};
        
        for (String input : testInputs) {
            System.out.println("\n입력: '" + input + "'");
            
            // TODO: Integer 변환 시도
            // 힌트:
            // 1. try 블록 시작
            // 2. Integer.parseInt(input)으로 변환
            // 3. 성공하면 "✅ Integer 성공: " + 변환된 값 출력
            // 4. catch (NumberFormatException e)로 예외 처리
            // 5. 실패하면 "❌ Integer 실패: " + e.getMessage() 출력
            
            // 여기에 Integer 변환 코드를 작성하세요
            
            // TODO: Double 변환 시도
            // 힌트:
            // 1. try 블록 시작
            // 2. Double.parseDouble(input)으로 변환
            // 3. 성공하면 "✅ Double 성공: " + 변환된 값 출력
            // 4. catch (NumberFormatException e)로 예외 처리
            // 5. 실패하면 "❌ Double 실패: " + e.getMessage() 출력
            
            // 여기에 Double 변환 코드를 작성하세요
        }
    }
}
```

#### 실행 결과:
```
=== 숫자 변환 예제 ===

입력: '123'
✅ Integer 성공: 123
✅ Double 성공: 123.0

입력: '45.67'
❌ Integer 실패: For input string: "45.67"
✅ Double 성공: 45.67

입력: 'abc'
❌ Integer 실패: For input string: "abc"
❌ Double 실패: For input string: "abc"

입력: '12x'
❌ Integer 실패: For input string: "12x"
❌ Double 실패: For input string: "12x"

입력: ''
❌ Integer 실패: For input string: ""
❌ Double 실패: empty String

입력: '  '
❌ Integer 실패: For input string: "  "
❌ Double 실패: For input string: "  "

입력: '-789'
✅ Integer 성공: -789
✅ Double 성공: -789.0
```

### 예제 1-2: 안전한 나눗셈
```java
import textio.TextIO;

public class SafeDivisionExample {
    public static void main(String[] args) {
        System.out.println("=== 안전한 나눗셈 예제 ===");
        
        while (true) {
            try {
                System.out.print("첫 번째 숫자 (또는 'quit'): ");
                String input1 = TextIO.getln();
                
                if (input1.equalsIgnoreCase("quit")) {
                    break;
                }
                
                System.out.print("두 번째 숫자: ");
                String input2 = TextIO.getln();
                
                // TODO: 숫자 변환과 나눗셈 수행
                // 힌트:
                // 1. Double.parseDouble()로 input1, input2를 변환
                // 2. safeDivide() 메서드 호출
                // 3. 결과를 printf로 출력 (형식: "결과: %.2f ÷ %.2f = %.2f%n")
                
                // 여기에 코드를 작성하세요
                
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("❌ 계산 오류: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        System.out.println("계산기를 종료합니다.");
    }
    
    public static double safeDivide(double dividend, double divisor) {
        // TODO: 안전한 나눗셈 구현
        // 힌트:
        // 1. divisor가 0.0인지 확인
        // 2. 0이면 throw new ArithmeticException("0으로 나눌 수 없습니다")
        // 3. 0이 아니면 dividend / divisor 반환
        
        // 여기에 코드를 작성하세요
        return 0; // 임시 반환값
    }
}
```

#### 실행 결과:
```
=== 안전한 나눗셈 예제 ===
첫 번째 숫자 (또는 'quit'): 10
두 번째 숫자: 2
결과: 10.00 ÷ 2.00 = 5.00

첫 번째 숫자 (또는 'quit'): 7.5
두 번째 숫자: 0
❌ 계산 오류: 0으로 나눌 수 없습니다

첫 번째 숫자 (또는 'quit'): abc
두 번째 숫자: 5
❌ 올바른 숫자를 입력해주세요.

첫 번째 숫자 (또는 'quit'): quit
계산기를 종료합니다.
```

## 2. 사용자 입력 검증 예제

### 예제 2-1: 범위 검증 입력
```java
import textio.TextIO;

public class RangeValidationExample {
    public static void main(String[] args) {
        System.out.println("=== 범위 검증 입력 예제 ===");
        
        int age = getValidAge();
        int score = getValidScore();
        
        System.out.println("입력 완료!");
        System.out.println("나이: " + age + "세");
        System.out.println("점수: " + score + "점");
        
        // 등급 계산
        String grade = calculateGrade(score);
        System.out.println("등급: " + grade);
    }
    
    public static int getValidAge() {
        while (true) {
            System.out.print("나이를 입력하세요 (1-150): ");
            String input = TextIO.getln();
            
            // TODO: 나이 검증 로직
            // 힌트:
            // 1. try 블록에서 Integer.parseInt(input)으로 변환
            // 2. age가 1보다 작거나 150보다 크면:
            //    - 오류 메시지 출력
            //    - continue로 다시 시도
            // 3. 유효하면 "✅ 유효한 나이입니다." 출력 후 age 반환
            // 4. catch (NumberFormatException e)로 예외 처리
            //    - "❌ 숫자를 입력해주세요." 출력
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static int getValidScore() {
        while (true) {
            System.out.print("점수를 입력하세요 (0-100): ");
            String input = TextIO.getln();
            
            // TODO: 점수 검증 로직
            // 힌트:
            // 1. try 블록에서 Integer.parseInt(input)으로 변환
            // 2. score가 0보다 작거나 100보다 크면:
            //    - 오류 메시지 출력
            //    - continue로 다시 시도
            // 3. 유효하면 "✅ 유효한 점수입니다." 출력 후 score 반환
            // 4. catch (NumberFormatException e)로 예외 처리
            //    - "❌ 숫자를 입력해주세요." 출력
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static String calculateGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
}
```

#### 실행 결과:
```
=== 범위 검증 입력 예제 ===
나이를 입력하세요 (1-150): 25
✅ 유효한 나이입니다.
점수를 입력하세요 (0-100): 85
✅ 유효한 점수입니다.
입력 완료!
나이: 25세
점수: 85점
등급: B
```

### 예제 2-2: 이메일 형식 검증
```java
import textio.TextIO;

public class EmailValidationExample {
    public static void main(String[] args) {
        System.out.println("=== 이메일 검증 예제 ===");
        
        String email = getValidEmail();
        System.out.println("등록된 이메일: " + email);
        
        // 이메일 정보 분석
        analyzeEmail(email);
    }
    
    public static String getValidEmail() {
        while (true) {
            System.out.print("이메일 주소를 입력하세요: ");
            String input = TextIO.getln().trim();
            
            // TODO: 이메일 검증 시도
            // 힌트:
            // 1. try 블록에서 validateEmail(input) 호출
            // 2. 성공하면 "✅ 유효한 이메일입니다." 출력 후 input 반환
            // 3. catch (IllegalArgumentException e)로 예외 처리
            //    - "❌ " + e.getMessage() 출력
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static void validateEmail(String email) {
        // TODO: 이메일 유효성 검증
        // 힌트:
        // 1. email이 null이거나 비어있으면 예외 던지기
        // 2. @ 기호가 없으면 예외 던지기
        // 3. email.split("@")로 분리하여 parts 배열 생성
        // 4. parts.length가 2가 아니면 예외 던지기
        // 5. localPart (parts[0])가 비어있으면 예외 던지기
        // 6. domainPart (parts[1])가 비어있으면 예외 던지기
        // 7. domainPart에 .이 없으면 예외 던지기
        // 8. domainPart가 .으로 시작하거나 끝나면 예외 던지기
        // 모든 예외는 IllegalArgumentException 사용
        
        // 여기에 코드를 작성하세요
    }
    
    public static void analyzeEmail(String email) {
        String[] parts = email.split("@");
        String username = parts[0];
        String domain = parts[1];
        
        System.out.println("\n📧 이메일 분석:");
        System.out.println("사용자명: " + username);
        System.out.println("도메인: " + domain);
        
        // 도메인 분석
        if (domain.endsWith(".com")) {
            System.out.println("종류: 상업적 도메인");
        } else if (domain.endsWith(".edu")) {
            System.out.println("종류: 교육기관 도메인");
        } else if (domain.endsWith(".gov")) {
            System.out.println("종류: 정부기관 도메인");
        } else if (domain.endsWith(".org")) {
            System.out.println("종류: 비영리기관 도메인");
        } else {
            System.out.println("종류: 기타 도메인");
        }
    }
}
```

#### 실행 결과:
```
=== 이메일 검증 예제 ===
이메일 주소를 입력하세요: user@example.com
✅ 유효한 이메일입니다.
등록된 이메일: user@example.com

📧 이메일 분석:
사용자명: user
도메인: example.com
종류: 상업적 도메인
```

## 3. 파일 처리 예외 예제

### 예제 3-1: 안전한 파일 읽기
```java
import textio.TextIO;

public class SafeFileReadingExample {
    public static void main(String[] args) {
        System.out.println("=== 안전한 파일 읽기 예제 ===");
        
        String fileName = getValidFileName();
        processNumbersFile(fileName);
    }
    
    public static String getValidFileName() {
        while (true) {
            System.out.print("파일 이름을 입력하세요: ");
            String fileName = TextIO.getln().trim();
            
            if (fileName.isEmpty()) {
                System.out.println("❌ 파일 이름을 입력해주세요.");
                continue;
            }
            
            try {
                // 파일 열기 시도
                TextIO.readFile(fileName);
                System.out.println("✅ 파일을 성공적으로 열었습니다: " + fileName);
                return fileName;
                
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 파일을 열 수 없습니다: " + fileName);
                System.out.println("   원인: 파일이 존재하지 않거나 접근할 수 없습니다.");
                
                System.out.print("다시 시도하시겠습니까? (y/n): ");
                String retry = TextIO.getln().toLowerCase();
                if (!retry.startsWith("y")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
            }
        }
    }
    
    public static void processNumbersFile(String fileName) {
        double sum = 0;
        int count = 0;
        int errorCount = 0;
        
        System.out.println("\n📄 파일 처리 중: " + fileName);
        System.out.println("-".repeat(40));
        
        try {
            while (true) {
                // TODO: 파일에서 숫자 읽기
                // 힌트:
                // 1. try 블록에서 TextIO.getDouble()로 숫자 읽기
                // 2. 읽은 숫자를 sum에 더하고 count 증가
                // 3. printf로 "읽은 숫자 %d: %.2f%n" 형식으로 출력
                // 4. catch (IllegalArgumentException e)로 예외 처리:
                //    - e.getMessage()에 "past end of file"이 포함되면 break
                //    - 그렇지 않으면 errorCount 증가하고 경고 메시지 출력
                
                // 여기에 코드를 작성하세요
            }
            
        } catch (Exception e) {
            System.out.println("❌ 파일 처리 중 예상치 못한 오류: " + e.getMessage());
        }
        
        // 결과 출력
        System.out.println("-".repeat(40));
        System.out.println("📊 처리 결과:");
        System.out.println("• 읽은 숫자 개수: " + count);
        System.out.println("• 오류 개수: " + errorCount);
        System.out.println("• 숫자 총합: " + sum);
        
        if (count > 0) {
            double average = sum / count;
            System.out.printf("• 평균: %.2f%n", average);
            System.out.printf("• 최대값 추정: %.2f (가정)%n", average * 2);
        } else {
            System.out.println("• 유효한 숫자가 없습니다.");
        }
    }
}
```

#### 실행 결과:
```
=== 안전한 파일 읽기 예제 ===
파일 이름을 입력하세요: numbers.txt
✅ 파일을 성공적으로 열었습니다: numbers.txt

📄 파일 처리 중: numbers.txt
----------------------------------------
읽은 숫자 1: 10.50
읽은 숫자 2: 20.75
읽은 숫자 3: 30.00
⚠️  잘못된 형식 무시: abc
읽은 숫자 4: 40.25
----------------------------------------
📊 처리 결과:
• 읽은 숫자 개수: 4
• 오류 개수: 1
• 숫자 총합: 101.5
• 평균: 25.38
• 최대값 추정: 50.75 (가정)
```

### 예제 3-2: 숫자 목록 파일 생성기
```java
import textio.TextIO;

public class NumberFileGeneratorExample {
    public static void main(String[] args) {
        System.out.println("=== 숫자 파일 생성기 ===");
        
        try {
            String fileName = createNumberFile();
            System.out.println("✅ 파일 생성 완료: " + fileName);
            
            // 생성된 파일 읽어보기
            readAndVerifyFile(fileName);
            
        } catch (Exception e) {
            System.out.println("❌ 프로그램 실행 중 오류: " + e.getMessage());
        }
    }
    
    public static String createNumberFile() {
        System.out.print("생성할 파일 이름: ");
        String fileName = TextIO.getln();
        
        System.out.print("숫자 개수: ");
        int count = getValidInteger("숫자 개수는 1-1000 사이여야 합니다", 1, 1000);
        
        System.out.print("최소값: ");
        double min = getValidDouble("최소값을 입력하세요");
        
        System.out.print("최대값: ");
        double max = getValidDouble("최대값을 입력하세요");
        
        if (min > max) {
            System.out.println("최소값과 최대값을 교환합니다.");
            double temp = min;
            min = max;
            max = temp;
        }
        
        // 파일 생성 (시뮬레이션)
        System.out.println("\n📝 파일 생성 중...");
        for (int i = 1; i <= count; i++) {
            double randomNumber = min + Math.random() * (max - min);
            System.out.printf("숫자 %d: %.2f (파일에 저장됨)%n", i, randomNumber);
            
            if (i % 10 == 0) {
                System.out.println("   ... " + i + "개 저장됨");
            }
        }
        
        return fileName;
    }
    
    public static int getValidInteger(String errorMessage, int min, int max) {
        while (true) {
            // TODO: 범위 내 정수 입력 받기
            // 힌트:
            // 1. try 블록에서 TextIO.getln()으로 입력 받기
            // 2. Integer.parseInt()로 변환
            // 3. value가 min보다 작거나 max보다 크면:
            //    - errorMessage 출력
            //    - "다시 입력: " 프롬프트 출력
            //    - continue로 재시도
            // 4. 유효하면 value 반환
            // 5. catch (NumberFormatException e)로 예외 처리
            //    - 오류 메시지와 재입력 프롬프트 출력
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static double getValidDouble(String prompt) {
        while (true) {
            // TODO: 실수 입력 받기
            // 힌트:
            // 1. try 블록에서 TextIO.getln()으로 입력 받기
            // 2. Double.parseDouble()로 변환 후 반환
            // 3. catch (NumberFormatException e)로 예외 처리
            //    - 오류 메시지 출력
            //    - prompt + ": " 출력하여 재입력 유도
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static void readAndVerifyFile(String fileName) {
        System.out.println("\n🔍 생성된 파일 검증 중...");
        
        try {
            // 실제로는 TextIO.readFile(fileName)을 호출
            System.out.println("✅ 파일 읽기 성공");
            
            // 시뮬레이션된 검증
            System.out.println("📊 검증 결과:");
            System.out.println("• 파일 형식: 올바름");
            System.out.println("• 데이터 무결성: 통과");
            System.out.println("• 접근 권한: 정상");
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 생성된 파일을 읽을 수 없습니다: " + e.getMessage());
        }
    }
}
```

#### 실행 결과:
```
=== 숫자 파일 생성기 ===
생성할 파일 이름: random_numbers.txt
숫자 개수: 10
숫자 개수는 1-1000 사이여야 합니다
다시 입력: 10
최소값: 0
최대값: 100

📝 파일 생성 중...
숫자 1: 42.35 (파일에 저장됨)
숫자 2: 78.92 (파일에 저장됨)
숫자 3: 15.67 (파일에 저장됨)
숫자 4: 91.23 (파일에 저장됨)
숫자 5: 33.45 (파일에 저장됨)
숫자 6: 56.78 (파일에 저장됨)
숫자 7: 24.91 (파일에 저장됨)
숫자 8: 87.34 (파일에 저장됨)
숫자 9: 9.12 (파일에 저장됨)
숫자 10: 65.56 (파일에 저장됨)
   ... 10개 저장됨
✅ 파일 생성 완료: random_numbers.txt

🔍 생성된 파일 검증 중...
✅ 파일 읽기 성공
📊 검증 결과:
• 파일 형식: 올바름
• 데이터 무결성: 통과
• 접근 권한: 정상
```

## 4. 고급 예외 처리 예제

### 예제 4-1: 다중 예외 처리
```java
import textio.TextIO;

public class MultipleExceptionHandlingExample {
    public static void main(String[] args) {
        System.out.println("=== 다중 예외 처리 예제 ===");
        
        while (true) {
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 배열 접근 테스트");
            System.out.println("2. 숫자 변환 테스트");
            System.out.println("3. 나눗셈 테스트");
            System.out.println("4. 복합 계산 테스트");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            
            try {
                int choice = Integer.parseInt(TextIO.getln());
                
                switch (choice) {
                    case 1 -> testArrayAccess();
                    case 2 -> testNumberParsing();
                    case 3 -> testDivision();
                    case 4 -> testComplexCalculation();
                    case 0 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("❌ 올바른 메뉴를 선택하세요.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("❌ 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println("❌ 예상치 못한 오류: " + e.getMessage());
            }
        }
    }
    
    public static void testArrayAccess() {
        System.out.println("\n🔍 배열 접근 테스트");
        
        // TODO: 배열 접근 예외 처리
        // 힌트:
        // 1. try 블록에서:
        //    - int[] numbers = {10, 20, 30, 40, 50} 배열 생성
        //    - 인덱스 입력 받기
        //    - Integer.parseInt()로 변환
        //    - numbers[index] 접근하여 값 출력
        // 2. catch (NumberFormatException e)로 숫자 형식 오류 처리
        // 3. catch (ArrayIndexOutOfBoundsException e)로 배열 범위 오류 처리
        // 4. catch (Exception e)로 기타 오류 처리
        
        // 여기에 코드를 작성하세요
    }
    
    public static void testNumberParsing() {
        System.out.println("\n🔢 숫자 변환 테스트");
        
        System.out.print("변환할 문자열을 입력하세요: ");
        String input = TextIO.getln();
        
        // TODO: 여러 형태로 변환 시도
        // 힌트:
        // 1. 정수 변환 try-catch:
        //    - Integer.parseInt(input) 시도
        //    - 성공하면 "✅ 정수 변환 성공: " 출력
        //    - NumberFormatException 발생시 "❌ 정수 변환 실패" 출력
        // 2. 실수 변환 try-catch:
        //    - Double.parseDouble(input) 시도
        //    - 성공하면 "✅ 실수 변환 성공: " 출력
        //    - NumberFormatException 발생시 "❌ 실수 변환 실패" 출력
        // 3. 불린 변환 try-catch:
        //    - Boolean.parseBoolean(input) 시도
        //    - 결과를 "✅ 불린 변환 결과: " 와 함께 출력
        //    - Exception 발생시 실패 메시지 출력
        
        // 여기에 코드를 작성하세요
    }
    
    public static void testDivision() {
        System.out.println("\n➗ 나눗셈 테스트");
        
        try {
            System.out.print("피제수 (나눠지는 수): ");
            double dividend = Double.parseDouble(TextIO.getln());
            
            System.out.print("제수 (나누는 수): ");
            double divisor = Double.parseDouble(TextIO.getln());
            
            // TODO: 나눗셈 수행 및 결과 분석
            // 힌트:
            // 1. divisor가 0이면 ArithmeticException 던지기
            // 2. result = dividend / divisor 계산
            // 3. printf로 결과 출력 (형식: "✅ 결과: %.2f ÷ %.2f = %.2f%n")
            // 4. 결과에 따른 추가 정보 출력:
            //    - result > 1: "ℹ️  결과가 1보다 큽니다."
            //    - result == 1: "ℹ️  두 수가 같습니다."
            //    - result == 0: "ℹ️  피제수가 0입니다."
            //    - 그 외: "ℹ️  결과가 1보다 작습니다."
            
            // 여기에 코드를 작성하세요
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 숫자 형식 오류: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("❌ 산술 오류: " + e.getMessage());
        }
    }
    
    public static void testComplexCalculation() {
        System.out.println("\n🧮 복합 계산 테스트");
        
        try {
            System.out.print("배열 크기를 입력하세요: ");
            int size = Integer.parseInt(TextIO.getln());
            
            // TODO: 배열 생성 및 통계 계산
            // 힌트:
            // 1. size 검증:
            //    - size <= 0이면 "배열 크기는 양수여야 합니다" 예외
            //    - size > 100이면 "배열 크기가 너무 큽니다 (최대 100)" 예외
            // 2. double[] numbers = new double[size] 배열 생성
            // 3. for 루프로 숫자 입력 받기:
            //    - Double.parseDouble()로 변환
            //    - 배열에 저장하고 sum에 누적
            // 4. average = sum / size 계산
            // 5. 결과 출력 (합계, 평균)
            // 6. 표준편차 계산:
            //    - variance 계산 (각 값과 평균의 차이 제곱의 평균)
            //    - standardDeviation = Math.sqrt(variance)
            //    - 분산과 표준편차 출력
            
            // 여기에 코드를 작성하세요
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 숫자 형식 오류: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 잘못된 인수: " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("❌ 배열 크기 오류: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("❌ 메모리 부족: 배열 크기를 줄이세요");
        } catch (Exception e) {
            System.out.println("❌ 예상치 못한 오류: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
```

#### 실행 결과:
```
=== 다중 예외 처리 예제 ===

메뉴를 선택하세요:
1. 배열 접근 테스트
2. 숫자 변환 테스트
3. 나눗셈 테스트
4. 복합 계산 테스트
0. 종료
선택: 1

🔍 배열 접근 테스트
인덱스를 입력하세요 (0-4): 2
✅ numbers[2] = 30

메뉴를 선택하세요:
1. 배열 접근 테스트
2. 숫자 변환 테스트
3. 나눗셈 테스트
4. 복합 계산 테스트
0. 종료
선택: 3

➗ 나눗셈 테스트
피제수 (나눠지는 수): 10
제수 (나누는 수): 3
✅ 결과: 10.00 ÷ 3.00 = 3.33
ℹ️  결과가 1보다 큽니다.
```

## 5. 실전 응용 예제

### 예제 5-1: 성적 관리 시스템
```java
import textio.TextIO;

public class GradeManagementExample {
    public static void main(String[] args) {
        System.out.println("=== 성적 관리 시스템 ===");
        
        try {
            int studentCount = getStudentCount();
            processStudentGrades(studentCount);
            
        } catch (Exception e) {
            System.out.println("❌ 시스템 오류: " + e.getMessage());
        }
    }
    
    public static int getStudentCount() {
        while (true) {
            try {
                System.out.print("학생 수를 입력하세요 (1-50): ");
                String input = TextIO.getln();
                int count = Integer.parseInt(input);
                
                // TODO: 학생 수 검증
                // 힌트:
                // 1. count가 1보다 작거나 50보다 크면
                //    IllegalArgumentException 던지기
                // 2. 유효하면 count 반환
                
                // 여기에 코드를 작성하세요
                return 0; // 임시 반환값
                
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
    
    public static void processStudentGrades(int studentCount) {
        String[] studentNames = new String[studentCount];
        double[] scores = new double[studentCount];
        String[] grades = new String[studentCount];
        
        // 학생 정보 입력
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n--- 학생 " + (i + 1) + " ---");
            
            studentNames[i] = getStudentName(i + 1);
            scores[i] = getValidScore(studentNames[i]);
            grades[i] = calculateGrade(scores[i]);
        }
        
        // 결과 출력
        displayResults(studentNames, scores, grades);
        
        // 통계 계산
        calculateStatistics(scores);
    }
    
    public static String getStudentName(int studentNumber) {
        while (true) {
            try {
                System.out.print("학생 이름: ");
                String name = TextIO.getln().trim();
                
                // TODO: 이름 유효성 검증
                // 힌트:
                // 1. name이 비어있으면 "이름을 입력해주세요" 예외
                // 2. name.length() > 20이면 "이름이 너무 깁니다 (최대 20자)" 예외
                // 3. name.matches("\\d+")가 true면 
                //    "이름은 숫자만으로 구성될 수 없습니다" 예외
                // 4. 모든 검증 통과시 name 반환
                
                // 여기에 코드를 작성하세요
                return ""; // 임시 반환값
                
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
    
    public static double getValidScore(String studentName) {
        while (true) {
            try {
                System.out.print(studentName + " 학생의 점수 (0-100): ");
                String input = TextIO.getln();
                double score = Double.parseDouble(input);
                
                // TODO: 점수 유효성 검증
                // 힌트:
                // 1. score가 0보다 작거나 100보다 크면
                //    "점수는 0-100 사이여야 합니다" 예외 던지기
                // 2. 유효하면 score 반환
                
                // 여기에 코드를 작성하세요
                return 0; // 임시 반환값
                
            } catch (NumberFormatException e) {
                System.out.println("❌ 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
    
    public static String calculateGrade(double score) {
        if (score >= 97) return "A+";
        else if (score >= 93) return "A";
        else if (score >= 90) return "A-";
        else if (score >= 87) return "B+";
        else if (score >= 83) return "B";
        else if (score >= 80) return "B-";
        else if (score >= 77) return "C+";
        else if (score >= 73) return "C";
        else if (score >= 70) return "C-";
        else if (score >= 67) return "D+";
        else if (score >= 63) return "D";
        else if (score >= 60) return "D-";
        else return "F";
    }
    
    public static void displayResults(String[] names, double[] scores, String[] grades) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📊 성적 결과");
        System.out.println("=".repeat(50));
        System.out.printf("%-15s %8s %6s%n", "이름", "점수", "등급");
        System.out.println("-".repeat(50));
        
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-15s %8.1f %6s%n", names[i], scores[i], grades[i]);
        }
        System.out.println("-".repeat(50));
    }
    
    public static void calculateStatistics(double[] scores) {
        try {
            double sum = 0;
            double max = scores[0];
            double min = scores[0];
            
            for (double score : scores) {
                sum += score;
                if (score > max) max = score;
                if (score < min) min = score;
            }
            
            double average = sum / scores.length;
            
            // TODO: 등급별 통계 계산
            // 힌트:
            // 1. int[] gradeCount = new int[5] 배열 생성 (A, B, C, D, F)
            // 2. scores 배열의 각 점수에 대해:
            //    - score >= 90: gradeCount[0]++ (A)
            //    - score >= 80: gradeCount[1]++ (B)
            //    - score >= 70: gradeCount[2]++ (C)
            //    - score >= 60: gradeCount[3]++ (D)
            //    - 그 외: gradeCount[4]++ (F)
            int[] gradeCount = new int[5];
            
            // 여기에 코드를 작성하세요
            
            System.out.println("\n📈 통계 정보:");
            System.out.printf("• 평균: %.2f점%n", average);
            System.out.printf("• 최고점: %.1f점%n", max);
            System.out.printf("• 최저점: %.1f점%n", min);
            System.out.printf("• 점수 범위: %.1f점%n", max - min);
            
            System.out.println("\n📊 등급별 분포:");
            String[] gradeNames = {"A (90-100)", "B (80-89)", "C (70-79)", "D (60-69)", "F (0-59)"};
            for (int i = 0; i < gradeNames.length; i++) {
                double percentage = (gradeCount[i] * 100.0) / scores.length;
                System.out.printf("• %s: %d명 (%.1f%%)%n", gradeNames[i], gradeCount[i], percentage);
            }
            
        } catch (Exception e) {
            System.out.println("❌ 통계 계산 중 오류: " + e.getMessage());
        }
    }
}
```

#### 실행 결과:
```
=== 성적 관리 시스템 ===
학생 수를 입력하세요 (1-50): 3

--- 학생 1 ---
학생 이름: 김철수
김철수 학생의 점수 (0-100): 95.5

--- 학생 2 ---
학생 이름: 이영희
이영희 학생의 점수 (0-100): 87.3

--- 학생 3 ---
학생 이름: 박민준
박민준 학생의 점수 (0-100): 72.8

==================================================
📊 성적 결과
==================================================
이름              점수   등급
--------------------------------------------------
김철수            95.5    A
이영희            87.3    B+
박민준            72.8    C
--------------------------------------------------

📈 통계 정보:
• 평균: 85.20점
• 최고점: 95.5점
• 최저점: 72.8점
• 점수 범위: 22.7점

📊 등급별 분포:
• A (90-100): 1명 (33.3%)
• B (80-89): 1명 (33.3%)
• C (70-79): 1명 (33.3%)
• D (60-69): 0명 (0.0%)
• F (0-59): 0명 (0.0%)
```

이 예제들은 다양한 상황에서의 예윘 처리를 보여줍니다:

- **기본 예외 처리**: NumberFormatException, ArithmeticException
- **입력 검증**: 범위 확인, 형식 검증  
- **파일 처리**: IllegalArgumentException 활용
- **다중 예외**: 여러 예외 타입을 체계적으로 처리
- **실전 응용**: 복합적인 시스템에서의 예외 처리

각 예제는 실제 프로그래밍에서 자주 마주치는 상황들을 다루고 있어 실무에 도움이 됩니다.