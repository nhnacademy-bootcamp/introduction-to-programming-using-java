# 3.7 예외와 try..catch - 예제 모음

## 1. 기본 예외 처리 예제

### 예제 1-1: 숫자 변환 예외 처리

#### 요구사항
- 문자열 배열의 각 요소를 Integer와 Double로 변환 시도
- 변환 성공 시 값 출력, 실패 시 오류 메시지 출력
- NumberFormatException 예외 처리

#### 예제 코드
```java
import textio.TextIO;

public class NumberParsingExample {
    public static void main(String[] args) {
        System.out.println("=== 숫자 변환 예제 ===");
        
        String[] testInputs = {"123", "45.67", "abc", "12x", "", "  ", "-789"};
        
        for (String input : testInputs) {
            System.out.println("\n입력: '" + input + "'");
            
            // TODO: Integer 변환 시도
            // 힌트: try-catch 구조 사용
            
            // 여기에 Integer 변환 코드를 작성하세요
            
            // TODO: Double 변환 시도
            // 힌트: try-catch 구조 사용
            
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

#### 요구사항
- 사용자로부터 두 숫자를 입력받아 나눗셈 수행
- 0으로 나누기 시도 시 ArithmeticException 발생
- 숫자 형식 오류 시 NumberFormatException 처리
- 'quit' 입력 시 프로그램 종료

#### 예제 코드
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
                // 힌트: parseDouble() 사용
                
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
        // 힌트: 0 검사 후 예외 발생
        
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

#### 요구사항
- 나이(1-150)와 점수(0-100)를 입력받아 검증
- 범위를 벗어나면 재입력 요구
- 숫자 형식이 아니면 NumberFormatException 처리
- 유효한 입력 후 등급 계산

#### 예제 코드
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
            // 힌트: 범위 검사 후 continue로 재시도
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static int getValidScore() {
        while (true) {
            System.out.print("점수를 입력하세요 (0-100): ");
            String input = TextIO.getln();
            
            // TODO: 점수 검증 로직
            // 힌트: 범위 검사 후 continue로 재시도
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static String calculateGrade(int score) {
        // TODO: 점수에 따른 등급 계산
        // 힌트: if-else if 체인
        
        // 여기에 코드를 작성하세요
        return ""; // 임시 반환값
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

#### 요구사항
- 이메일 주소 형식 검증
  - @ 기호 포함 여부
  - 로컬 부분과 도메인 부분 존재
  - 도메인에 .포함 여부
- 유효한 이메일 입력 후 사용자명과 도메인 분석

#### 예제 코드
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
            // 힌트: validateEmail() 호출
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static void validateEmail(String email) {
        // TODO: 이메일 유효성 검증
        // 힌트: IllegalArgumentException 사용
        
        // 여기에 코드를 작성하세요
    }
    
    public static void analyzeEmail(String email) {
        // TODO: 이메일 분석
        // 힌트: split("@") 사용하여 사용자명과 도메인 분리
        
        // 여기에 코드를 작성하세요
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

#### 요구사항
- 파일 이름을 입력받아 파일 열기 시도
- 파일이 없으면 IllegalArgumentException 처리
- 파일에서 숫자를 읽어 통계 계산
- 파일 끝에 도달하면 "past end of file" 메시지로 확인

#### 예제 코드
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
                // 힌트: TextIO.getDouble() 사용
                
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

#### 요구사항
- 파일 이름, 숫자 개수(1-1000), 최소/최대값 입력받기
- 범위 내 랜덤 숫자 생성하여 파일에 저장 (시뮬레이션)
- 숫자 형식 오류 시 NumberFormatException 처리
- 범위 검증 및 재입력 요구

#### 예제 코드
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
            // 힌트: parseInt() 사용
            
            // 여기에 코드를 작성하세요
        }
    }
    
    public static double getValidDouble(String prompt) {
        while (true) {
            // TODO: 실수 입력 받기
            // 힌트: parseDouble() 사용
            
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

#### 요구사항
- 메뉴 선택에 따라 다양한 예외 상황 테스트
- 배열 접근 테스트: 사용자가 입력한 인덱스로 배열 접근 시도
- 숫자 변환 테스트: 문자열을 Integer, Double, Boolean으로 변환 시도
- 나눗셈 테스트: 두 수를 입력받아 나눗셈 수행, 0으로 나누기 처리
- 복합 계산 테스트: 배열 크기를 입력받아 배열 생성 후 통계 계산
- 각 테스트에서 발생 가능한 예외를 적절히 처리

#### 예제 코드
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
        // 힌트: 다중 catch 블록 사용
        
        // 여기에 코드를 작성하세요
    }
    
    public static void testNumberParsing() {
        System.out.println("\n🔢 숫자 변환 테스트");
        
        System.out.print("변환할 문자열을 입력하세요: ");
        String input = TextIO.getln();
        
        // TODO: 여러 형태로 변환 시도
        // 힌트: 각각 독립된 try-catch 블록
        
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
            // 힌트: 0으로 나누기 검사
            
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
            // 힌트: 크기 검증, 표준편차 계산
            
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

#### 요구사항
- 학생 수 입력받기 (1-50명 범위 검증)
- 각 학생의 이름과 점수 입력받기
  - 이름: 빈 문자열 불가, 20자 이내, 숫자만으로 구성 불가
  - 점수: 0-100 범위 검증
- 점수에 따른 등급 계산 (A+: 95+, A: 90+, B+: 85+, B: 80+, C+: 75+, C: 70+, D: 60+, F: 60 미만)
- 전체 학생 성적 결과표 출력
- 통계 정보 계산 및 출력 (평균, 최고점, 최저점, 등급별 분포)

#### 예제 코드
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
                // 힌트: 범위 검사
                
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
                // 힌트: 비어있는지, 길이, 숫자만 있는지 검사
                
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
                // 힌트: 범위 검사
                
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
        // TODO: 세분화된 등급 계산
        // 힌트: if-else if 체인
        
        // 여기에 코드를 작성하세요
        return ""; // 임시 반환값
    }
    
    public static void displayResults(String[] names, double[] scores, String[] grades) {
        // TODO: 성적 결과 출력
        // 힌트: printf로 테이블 형태 출력
        
        // 여기에 코드를 작성하세요
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
            // 힌트: 점수 범위로 등급 구분
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