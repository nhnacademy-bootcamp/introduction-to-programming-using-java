# 3.6 switch문 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- switch문의 기본 구조와 동작 원리를 이해한다
- 새로운 문법과 전통적인 문법의 차이를 안다
- switch 표현식(Switch Expression)을 활용할 수 있다
- enum 타입과 switch문을 함께 사용할 수 있다
- 메뉴 처리와 다중 분기에서 switch문을 효과적으로 활용한다

## 1. switch문 개요

### 1.1 switch문이란?
switch문은 변수나 표현식의 값에 따라 여러 분기 중 하나를 선택하여 실행하는 제어문입니다.

### 1.2 if문과의 차이점
```java
// if문 사용
if (choice == 1) {
    System.out.println("첫 번째 선택");
} else if (choice == 2) {
    System.out.println("두 번째 선택");
} else if (choice == 3) {
    System.out.println("세 번째 선택");
}

// switch문 사용 (더 간결하고 명확)
switch (choice) {
    case 1 -> System.out.println("첫 번째 선택");
    case 2 -> System.out.println("두 번째 선택");
    case 3 -> System.out.println("세 번째 선택");
}
```

### 1.3 사용 가능한 데이터 타입
- **정수 타입**: `int`, `short`, `byte`
- **문자 타입**: `char`
- **문자열**: `String`
- **열거형**: `enum`
- **사용 불가**: `double`, `float`, `boolean`

## 2. 새로운 switch문 (Java 17+)

### 2.1 기본 구조
```java
switch (표현식) {
    case 값1 -> 명령문1;
    case 값2 -> 명령문2;
    case 값3, 값4 -> 명령문3;  // 여러 값 처리 가능
    default -> 기본명령문;     // 선택사항
}
```

### 2.2 화살표 표기법의 장점
- **간결함**: 불필요한 break문 없음
- **안전함**: fall-through 문제 방지
- **명확함**: 각 case가 독립적으로 실행

### 2.3 블록 사용
```java
switch (day) {
    case "월요일" -> {
        System.out.println("새로운 주의 시작!");
        System.out.println("열심히 해봅시다!");
    }
    case "금요일" -> {
        System.out.println("드디어 금요일!");
        System.out.println("주말이 얼마 안 남았네요!");
    }
    default -> System.out.println("평범한 하루입니다.");
}
```

## 3. switch 표현식 (Switch Expression)

### 3.1 값을 반환하는 switch
```java
// 변수에 직접 할당
String message = switch (grade) {
    case 'A' -> "탁월함";
    case 'B' -> "우수함";
    case 'C' -> "보통";
    case 'D' -> "미흡";
    default -> "재수강 필요";
};

// 메서드의 반환값으로 사용
public String getSeasonMessage(String season) {
    return switch (season.toLowerCase()) {
        case "봄" -> "따뜻한 봄이 왔습니다";
        case "여름" -> "더운 여름입니다";
        case "가을" -> "선선한 가을입니다";
        case "겨울" -> "추운 겨울입니다";
        default -> "알 수 없는 계절입니다";
    };
}
```

### 3.2 yield 키워드
복잡한 로직이 필요할 때 yield를 사용하여 값을 반환:
```java
int result = switch (operation) {
    case "add" -> {
        System.out.println("덧셈을 수행합니다");
        yield a + b;
    }
    case "multiply" -> {
        System.out.println("곱셈을 수행합니다");
        yield a * b;
    }
    default -> {
        System.out.println("알 수 없는 연산입니다");
        yield 0;
    }
};
```

## 4. enum과 switch문

### 4.1 enum 타입 정의
```java
enum Season {
    SPRING, SUMMER, FALL, WINTER
}

enum Priority {
    LOW, MEDIUM, HIGH, URGENT
}
```

### 4.2 enum을 사용한 switch문
```java
Season currentSeason = Season.SPRING;

switch (currentSeason) {
    case SPRING -> {  // Season.SPRING이 아닌 SPRING만 사용
        System.out.println("봄: 3월, 4월, 5월");
        System.out.println("꽃이 피는 계절");
    }
    case SUMMER -> {
        System.out.println("여름: 6월, 7월, 8월");
        System.out.println("휴가철");
    }
    case FALL -> {
        System.out.println("가을: 9월, 10월, 11월");
        System.out.println("단풍이 아름다운 계절");
    }
    case WINTER -> {
        System.out.println("겨울: 12월, 1월, 2월");
        System.out.println("추운 계절");
    }
}
```

## 5. 메뉴 처리에서의 활용

### 5.1 숫자 메뉴
```java
System.out.println("""
    === 계산기 메뉴 ===
    1. 덧셈
    2. 뺄셈
    3. 곱셈
    4. 나눗셈
    5. 종료
    선택: """);

int choice = scanner.nextInt();

switch (choice) {
    case 1 -> performAddition();
    case 2 -> performSubtraction();
    case 3 -> performMultiplication();
    case 4 -> performDivision();
    case 5 -> {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
    default -> System.out.println("잘못된 선택입니다!");
}
```

### 5.2 문자열 메뉴
```java
System.out.print("단위를 입력하세요 (inch/foot/yard/mile): ");
String unit = scanner.next().toLowerCase();

double inches = switch (unit) {
    case "inch", "inches", "in" -> measurement;
    case "foot", "feet", "ft" -> measurement * 12;
    case "yard", "yards", "yd" -> measurement * 36;
    case "mile", "miles", "mi" -> measurement * 12 * 5280;
    default -> {
        System.out.println("알 수 없는 단위: " + unit);
        yield -1; // 오류를 나타내는 값
    }
};
```

## 6. 확정 할당 (Definite Assignment)

### 6.1 문제 상황
```java
String result;
switch ((int)(3 * Math.random())) {
    case 0 -> result = "바위";
    case 1 -> result = "보";
    case 2 -> result = "가위";
    // default가 없으면 컴파일 오류 발생!
}
System.out.println(result); // 오류: result가 초기화되지 않을 수 있음
```

### 6.2 해결 방법
```java
String result;
switch ((int)(3 * Math.random())) {
    case 0 -> result = "바위";
    case 1 -> result = "보";
    default -> result = "가위"; // default 사용으로 해결
}
System.out.println(result); // OK!

// 또는 switch 표현식 사용
String result2 = switch ((int)(3 * Math.random())) {
    case 0 -> "바위";
    case 1 -> "보";
    default -> "가위";
};
```

## 7. 전통적인 switch문 (Legacy)

### 7.1 전통적인 구조
```java
switch (expression) {
    case constant1:
        statements1
        break;
    case constant2:
        statements2
        break;
    default:
        defaultStatements
}
```

### 7.2 Fall-through 동작
```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("월요일");
        break;
    case 2:
        System.out.println("화요일");
        // break 없음 - fall through!
    case 3:
        System.out.println("수요일 또는 화요일");
        break;
    default:
        System.out.println("다른 요일");
}
// day가 2일 때: "화요일"과 "수요일 또는 화요일" 모두 출력
```

### 7.3 의도적인 Fall-through
```java
char grade = 'B';
switch (grade) {
    case 'A':
    case 'B':
    case 'C':
        System.out.println("합격");
        break;
    case 'D':
    case 'F':
        System.out.println("불합격");
        break;
    default:
        System.out.println("잘못된 등급");
}
```

## 8. switch문 사용 패턴

### 8.1 상태 처리
```java
enum GameState {
    MENU, PLAYING, PAUSED, GAME_OVER
}

GameState state = GameState.PLAYING;

switch (state) {
    case MENU -> showMainMenu();
    case PLAYING -> updateGame();
    case PAUSED -> showPauseScreen();
    case GAME_OVER -> showGameOverScreen();
}
```

### 8.2 에러 코드 처리
```java
public String getErrorMessage(int errorCode) {
    return switch (errorCode) {
        case 200 -> "성공";
        case 400 -> "잘못된 요청";
        case 401 -> "인증 필요";
        case 403 -> "권한 없음";
        case 404 -> "찾을 수 없음";
        case 500 -> "서버 오류";
        default -> "알 수 없는 오류: " + errorCode;
    };
}
```

### 8.3 계산기 패턴
```java
public double calculate(double a, double b, String operator) {
    return switch (operator) {
        case "+" -> a + b;
        case "-" -> a - b;
        case "*" -> a * b;
        case "/" -> {
            if (b == 0) {
                System.out.println("0으로 나눌 수 없습니다!");
                yield Double.NaN;
            }
            yield a / b;
        }
        default -> {
            System.out.println("알 수 없는 연산자: " + operator);
            yield Double.NaN;
        }
    };
}
```

## 9. 실용적인 팁

### 9.1 switch문 선택 기준
**switch문이 좋은 경우:**
- 비교할 값이 정수, 문자열, enum일 때
- 분기가 많고 각 분기가 단순할 때
- 메뉴 처리나 상태 전환

**if문이 좋은 경우:**
- 복잡한 조건식이 필요할 때
- 범위 비교가 필요할 때
- boolean 타입 처리

### 9.2 성능 고려사항
```java
// 많은 case가 있을 때 switch가 더 효율적
String getMonthName(int month) {
    return switch (month) {
        case 1 -> "1월";   case 2 -> "2월";   case 3 -> "3월";
        case 4 -> "4월";   case 5 -> "5월";   case 6 -> "6월";
        case 7 -> "7월";   case 8 -> "8월";   case 9 -> "9월";
        case 10 -> "10월"; case 11 -> "11월"; case 12 -> "12월";
        default -> "잘못된 월";
    };
}
```

### 9.3 가독성 향상 팁
```java
// 관련된 case들을 그룹화
switch (userInput.toLowerCase()) {
    // 긍정적 답변
    case "y", "yes", "예", "네" -> processYes();
    
    // 부정적 답변  
    case "n", "no", "아니오", "아니요" -> processNo();
    
    // 도움말
    case "h", "help", "도움말" -> showHelp();
    
    default -> System.out.println("yes 또는 no로 답해주세요.");
}
```

## 요약

### switch문의 특징
- **다중 분기**: 하나의 값에 따른 여러 분기 처리
- **효율성**: 많은 경우의 수에서 if문보다 빠름
- **가독성**: 메뉴나 상태 처리에서 코드가 명확

### 새로운 문법 vs 전통적인 문법
| 새로운 문법 | 전통적인 문법 |
|------------|-------------|
| `case 1 ->` | `case 1:` |
| break 불필요 | break 필수 |
| fall-through 없음 | fall-through 위험 |
| switch 표현식 지원 | 문장만 가능 |
| 여러 값 동시 처리 | 개별 case 필요 |

### 주요 키워드
- **case**: 각 분기 조건
- **default**: 기본 분기 (선택사항)
- **yield**: switch 표현식에서 값 반환
- **->**: 새로운 문법의 화살표 연산자

💡 **기억하세요**: switch문은 단순한 값 비교에 최적화되어 있으며, 복잡한 조건이나 범위 검사에는 if문이 더 적합합니다!