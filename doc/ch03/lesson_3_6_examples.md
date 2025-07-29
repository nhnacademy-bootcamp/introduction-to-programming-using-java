# 3.6 switch문 - 예제 모음

## 1. 기본 switch문 예제

### 예제 1-1: 숫자 분류기
```java
public class NumberClassifier {
    public static void main(String[] args) {
        int number = 3;
        
        System.out.println("숫자 " + number + " 분석:");
        
        // TODO: 숫자 분류 switch문
        // 힌트:
        // 1. number가 1일 때: "첫 번째 숫자입니다."
        // 2. number가 2, 4, 6, 8 중 하나일 때:
        //    - "짝수입니다."
        //    - "2의 배수입니다."
        // 3. number가 3, 5, 7, 9 중 하나일 때:
        //    - "홀수입니다."
        //    - "소수일 가능성이 있습니다."
        // 4. number가 0일 때: "영(零)입니다."
        // 5. 그 외: "범위를 벗어난 숫자입니다."
        // ※ -> 연산자 사용
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
숫자 3 분석:
홀수입니다.
소수일 가능성이 있습니다.
```

### 예제 1-2: 문자 종류 판별
```java
import textio.TextIO;

public class CharacterAnalyzer {
    public static void main(String[] args) {
        System.out.print("문자를 입력하세요: ");
        char ch = TextIO.getlnChar();
        
        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> {
                System.out.println(ch + "는 소문자 모음입니다.");
            }
            case 'A', 'E', 'I', 'O', 'U' -> {
                System.out.println(ch + "는 대문자 모음입니다.");
            }
            default -> {
                if (Character.isLetter(ch)) {
                    System.out.println(ch + "는 자음입니다.");
                } else if (Character.isDigit(ch)) {
                    System.out.println(ch + "는 숫자입니다.");
                } else {
                    System.out.println(ch + "는 특수문자입니다.");
                }
            }
        }
    }
}
```

#### 실행 결과:
```
문자를 입력하세요: a
a는 소문자 모음입니다.

문자를 입력하세요: K
K는 자음입니다.

문자를 입력하세요: 7
7는 숫자입니다.
```

## 2. 문자열 switch 예제

### 예제 2-1: 언어 인사말
```java
import textio.TextIO;

public class LanguageGreeting {
    public static void main(String[] args) {
        System.out.print("언어를 입력하세요 (한국어/영어/일본어/중국어): ");
        String language = TextIO.getln().toLowerCase();
        
        String greeting = switch (language) {
            case "한국어", "korean", "kr" -> "안녕하세요!";
            case "영어", "english", "en" -> "Hello!";
            case "일본어", "japanese", "jp" -> "こんにちは!";
            case "중국어", "chinese", "cn" -> "你好!";
            case "프랑스어", "french", "fr" -> "Bonjour!";
            case "독일어", "german", "de" -> "Guten Tag!";
            case "스페인어", "spanish", "es" -> "¡Hola!";
            default -> "지원하지 않는 언어입니다.";
        };
        
        System.out.println("인사말: " + greeting);
        
        // 추가 정보
        switch (language) {
            case "한국어", "korean", "kr" -> {
                System.out.println("한국은 동아시아의 반도 국가입니다.");
                System.out.println("한글은 세종대왕이 창제했습니다.");
            }
            case "영어", "english", "en" -> {
                System.out.println("영어는 전 세계에서 가장 널리 사용되는 언어입니다.");
                System.out.println("국제 공용어 역할을 합니다.");
            }
            case "일본어", "japanese", "jp" -> {
                System.out.println("일본어는 히라가나, 가타카나, 한자를 사용합니다.");
                System.out.println("일본의 공용어입니다.");
            }
            default -> {
                // 다른 언어에 대한 정보는 생략
            }
        }
    }
}
```

#### 실행 결과:
```
언어를 입력하세요 (한국어/영어/일본어/중국어): 한국어
인사말: 안녕하세요!
한국은 동아시아의 반도 국가입니다.
한글은 세종대왕이 창제했습니다.

언어를 입력하세요 (한국어/영어/일본어/중국어): english
인사말: Hello!
영어는 전 세계에서 가장 널리 사용되는 언어입니다.
국제 공용어 역할을 합니다.
```

### 예제 2-2: 웹 브라우저 감지
```java
import textio.TextIO;

public class BrowserDetector {
    public static void main(String[] args) {
        System.out.print("브라우저명을 입력하세요: ");
        String browser = TextIO.getln().toLowerCase();
        
        String engineInfo = switch (browser) {
            case "chrome", "chromium", "edge" -> {
                yield "Chromium 기반 브라우저입니다.\n" +
                      "Blink 렌더링 엔진을 사용합니다.\n" +
                      "V8 JavaScript 엔진을 사용합니다.";
            }
            case "firefox" -> {
                yield "Mozilla Foundation의 브라우저입니다.\n" +
                      "Gecko 렌더링 엔진을 사용합니다.\n" +
                      "SpiderMonkey JavaScript 엔진을 사용합니다.";
            }
            case "safari" -> {
                yield "Apple의 브라우저입니다.\n" +
                      "WebKit 렌더링 엔진을 사용합니다.\n" +
                      "JavaScriptCore 엔진을 사용합니다.";
            }
            case "opera" -> {
                yield "노르웨이의 Opera Software에서 개발했습니다.\n" +
                      "현재는 Chromium 기반입니다.\n" +
                      "독특한 UI와 기능을 제공합니다.";
            }
            default -> "알 수 없는 브라우저이거나 정보가 없습니다.";
        };
        
        System.out.println("\n브라우저 정보:");
        System.out.println(engineInfo);
        
        // 보안 등급 평가
        String securityLevel = switch (browser) {
            case "chrome", "firefox", "safari", "edge" -> "높음";
            case "opera" -> "보통";
            case "ie", "internet explorer" -> "낮음 (사용 중단 권장)";
            default -> "알 수 없음";
        };
        
        System.out.println("보안 수준: " + securityLevel);
    }
}
```

#### 실행 결과:
```
브라우저명을 입력하세요: chrome

브라우저 정보:
Chromium 기반 브라우저입니다.
Blink 렌더링 엔진을 사용합니다.
V8 JavaScript 엔진을 사용합니다.
보안 수준: 높음

브라우저명을 입력하세요: firefox

브라우저 정보:
Mozilla Foundation의 브라우저입니다.
Gecko 렌더링 엔진을 사용합니다.
SpiderMonkey JavaScript 엔진을 사용합니다.
보안 수준: 높음
```

## 3. enum을 사용한 switch 예제

### 예제 3-1: 요일별 활동 추천
```java
enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class WeeklySchedule {
    public static void main(String[] args) {
        DayOfWeek today = DayOfWeek.FRIDAY;
        
        System.out.println("오늘은 " + getDayNameInKorean(today) + "입니다.");
        
        // TODO: 요일별 활동 추천 switch문
        // 힌트:
        // 1. MONDAY:
        //    - "📝 주간 계획 세우기"
        //    - "💪 운동으로 한 주 시작"
        //    - "📚 새로운 학습 시작"
        // 2. TUESDAY, WEDNESDAY, THURSDAY:
        //    - "⚡ 업무에 집중하기"
        //    - "📖 꾸준한 학습 지속"
        //    - "🤝 동료들과 협업"
        // 3. FRIDAY:
        //    - "🎉 한 주 마무리하기"
        //    - "📊 주간 성과 정리"
        //    - "🍕 팀과 함께 저녁 식사"
        // 4. SATURDAY:
        //    - "🏠 집 정리하기"
        //    - "🎬 영화 감상"
        //    - "👨‍👩‍👧‍👦 가족과 시간 보내기"
        // 5. SUNDAY:
        //    - "😴 충분한 휴식"
        //    - "📝 다음 주 준비"
        //    - "🧘 명상이나 독서"
        
        // 여기에 코드를 작성하세요
        
        // 업무일/휴일 구분
        boolean isWorkday = switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
            case SATURDAY, SUNDAY -> false;
        };
        
        System.out.println(isWorkday ? "평일입니다." : "주말입니다.");
    }
    
    public static String getDayNameInKorean(DayOfWeek day) {
        return switch (day) {
            case MONDAY -> "월요일";
            case TUESDAY -> "화요일";
            case WEDNESDAY -> "수요일";
            case THURSDAY -> "목요일";
            case FRIDAY -> "금요일";
            case SATURDAY -> "토요일";
            case SUNDAY -> "일요일";
        };
    }
}
```

#### 실행 결과:
```
오늘은 금요일입니다.

=== 활동 추천 ===
🎉 한 주 마무리하기
📊 주간 성과 정리
🍕 팀과 함께 저녁 식사
평일입니다.
```

### 예제 3-2: 게임 상태 관리
```java
enum GameState {
    MAIN_MENU, LOADING, PLAYING, PAUSED, GAME_OVER, SETTINGS
}

enum PlayerAction {
    MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT, ATTACK, DEFEND, PAUSE
}

public class GameStateManager {
    private GameState currentState = GameState.MAIN_MENU;
    
    public static void main(String[] args) {
        GameStateManager game = new GameStateManager();
        
        // 상태 전환 시뮬레이션
        game.handleStateTransition(GameState.LOADING);
        game.handleStateTransition(GameState.PLAYING);
        game.handlePlayerAction(PlayerAction.PAUSE);
        game.handlePlayerAction(PlayerAction.MOVE_UP);
    }
    
    public void handleStateTransition(GameState newState) {
        System.out.println("\n=== 상태 전환: " + currentState + " → " + newState + " ===");
        
        // 이전 상태 정리
        switch (currentState) {
            case MAIN_MENU -> System.out.println("메인 메뉴 정리");
            case LOADING -> System.out.println("로딩 화면 종료");
            case PLAYING -> System.out.println("게임 일시정지");
            case PAUSED -> System.out.println("일시정지 해제");
            case GAME_OVER -> System.out.println("게임오버 화면 정리");
            case SETTINGS -> System.out.println("설정 저장");
        }
        
        // 새 상태 초기화
        currentState = newState;
        switch (currentState) {
            case MAIN_MENU -> {
                System.out.println("🏠 메인 메뉴 표시");
                System.out.println("배경 음악 재생");
            }
            case LOADING -> {
                System.out.println("⏳ 게임 데이터 로딩");
                System.out.println("진행률 표시");
            }
            case PLAYING -> {
                System.out.println("🎮 게임 플레이 시작");
                System.out.println("UI 활성화");
            }
            case PAUSED -> {
                System.out.println("⏸️ 게임 일시정지");
                System.out.println("일시정지 메뉴 표시");
            }
            case GAME_OVER -> {
                System.out.println("💀 게임 오버");
                System.out.println("점수 저장 및 표시");
            }
            case SETTINGS -> {
                System.out.println("⚙️ 설정 화면");
                System.out.println("현재 설정 로드");
            }
        }
    }
    
    public void handlePlayerAction(PlayerAction action) {
        System.out.println("\n플레이어 액션: " + action);
        
        switch (currentState) {
            case PLAYING -> {
                switch (action) {
                    case MOVE_UP -> System.out.println("위로 이동");
                    case MOVE_DOWN -> System.out.println("아래로 이동");
                    case MOVE_LEFT -> System.out.println("왼쪽으로 이동");
                    case MOVE_RIGHT -> System.out.println("오른쪽으로 이동");
                    case ATTACK -> System.out.println("공격!");
                    case DEFEND -> System.out.println("방어 자세");
                    case PAUSE -> handleStateTransition(GameState.PAUSED);
                }
            }
            case PAUSED -> {
                switch (action) {
                    case PAUSE -> handleStateTransition(GameState.PLAYING);
                    default -> System.out.println("게임이 일시정지 상태입니다.");
                }
            }
            case MAIN_MENU, LOADING, GAME_OVER, SETTINGS -> {
                System.out.println("현재 상태에서는 해당 액션을 수행할 수 없습니다.");
            }
        }
    }
}
```

#### 실행 결과:
```
=== 상태 전환: MAIN_MENU → LOADING ===
메인 메뉴 정리
⏳ 게임 데이터 로딩
진행률 표시

=== 상태 전환: LOADING → PLAYING ===
로딩 화면 종료
🎮 게임 플레이 시작
UI 활성화

플레이어 액션: PAUSE

=== 상태 전환: PLAYING → PAUSED ===
게임 일시정지
⏸️ 게임 일시정지
일시정지 메뉴 표시

플레이어 액션: MOVE_UP
게임이 일시정지 상태입니다.
```

## 4. 메뉴 처리 예제

### 예제 4-1: 레스토랑 주문 시스템
```java
import textio.TextIO;

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        System.out.println("🍽️ 레스토랑 주문 시스템에 오신 것을 환영합니다!");
        
        while (true) {
            showMainMenu();
            int choice = TextIO.getlnInt();
            
            if (choice == 0) {
                System.out.println("이용해 주셔서 감사합니다! 👋");
                break;
            }
            
            processMenuChoice(choice);
        }
    }
    
    public static void showMainMenu() {
        System.out.println("""
            
            === 메인 메뉴 ===
            1. 🍝 파스타 메뉴
            2. 🍕 피자 메뉴
            3. 🥗 샐러드 메뉴
            4. 🍰 디저트 메뉴
            5. ☕ 음료 메뉴
            6. 🛒 주문 확인
            7. 💳 결제하기
            0. 종료
            
            선택하세요: """);
    }
    
    public static void processMenuChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("🍝 파스타 메뉴");
                showSubMenu("파스타", new String[]{
                    "스파게티 까르보나라 - 15,000원",
                    "토마토 파스타 - 12,000원",
                    "크림 파스타 - 14,000원",
                    "페스토 파스타 - 16,000원"
                });
            }
            case 2 -> {
                System.out.println("🍕 피자 메뉴");
                showSubMenu("피자", new String[]{
                    "마르게리타 피자 - 18,000원",
                    "페퍼로니 피자 - 20,000원",
                    "하와이안 피자 - 19,000원",
                    "불고기 피자 - 22,000원"
                });
            }
            case 3 -> {
                System.out.println("🥗 샐러드 메뉴");
                showSubMenu("샐러드", new String[]{
                    "시저 샐러드 - 8,000원",
                    "그린 샐러드 - 7,000원",
                    "치킨 샐러드 - 12,000원",
                    "아보카도 샐러드 - 10,000원"
                });
            }
            case 4 -> {
                System.out.println("🍰 디저트 메뉴");
                showSubMenu("디저트", new String[]{
                    "티라미수 - 6,000원",
                    "초콜릿 케이크 - 7,000원",
                    "치즈케이크 - 6,500원",
                    "아이스크림 - 4,000원"
                });
            }
            case 5 -> {
                System.out.println("☕ 음료 메뉴");
                showSubMenu("음료", new String[]{
                    "아메리카노 - 3,000원",
                    "라떼 - 4,000원",
                    "주스 - 3,500원",
                    "탄산음료 - 2,500원"
                });
            }
            case 6 -> {
                System.out.println("🛒 주문 목록:");
                System.out.println("(주문 시스템 구현 예정)");
            }
            case 7 -> {
                System.out.println("💳 결제 진행:");
                processPayment();
            }
            default -> System.out.println("❌ 잘못된 선택입니다. 다시 선택해주세요.");
        }
    }
    
    public static void showSubMenu(String category, String[] items) {
        System.out.println("\n=== " + category + " 상세 메뉴 ===");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
        System.out.println("메인 메뉴로 돌아가려면 엔터를 누르세요.");
        TextIO.getln();
    }
    
    public static void processPayment() {
        System.out.print("결제 방법을 선택하세요 (card/cash/mobile): ");
        String paymentMethod = TextIO.getln().toLowerCase();
        
        String message = switch (paymentMethod) {
            case "card", "카드" -> {
                System.out.print("카드를 삽입해주세요...");
                yield "💳 카드 결제가 완료되었습니다.";
            }
            case "cash", "현금" -> {
                System.out.print("현금을 투입해주세요...");
                yield "💵 현금 결제가 완료되었습니다.";
            }
            case "mobile", "모바일", "페이" -> {
                System.out.print("QR 코드를 스캔해주세요...");
                yield "📱 모바일 결제가 완료되었습니다.";
            }
            default -> "❌ 지원하지 않는 결제 방법입니다.";
        };
        
        System.out.println(message);
        if (!message.startsWith("❌")) {
            System.out.println("주문이 접수되었습니다. 조리 시간은 15-20분입니다. 🍽️");
        }
    }
}
```

#### 실행 결과:
```
🍽️ 레스토랑 주문 시스템에 오신 것을 환영합니다!

=== 메인 메뉴 ===
1. 🍝 파스타 메뉴
2. 🍕 피자 메뉴
3. 🥗 샐러드 메뉴
4. 🍰 디저트 메뉴
5. ☕ 음료 메뉴
6. 🛒 주문 확인
7. 💳 결제하기
0. 종료

선택하세요: 1
🍝 파스타 메뉴

=== 파스타 상세 메뉴 ===
1. 스파게티 까르보나라 - 15,000원
2. 토마토 파스타 - 12,000원
3. 크림 파스타 - 14,000원
4. 페스토 파스타 - 16,000원
메인 메뉴로 돌아가려면 엔터를 누르세요.

=== 메인 메뉴 ===
1. 🍝 파스타 메뉴
2. 🍕 피자 메뉴
3. 🥗 샐러드 메뉴
4. 🍰 디저트 메뉴
5. ☕ 음료 메뉴
6. 🛒 주문 확인
7. 💳 결제하기
0. 종료

선택하세요: 7
💳 결제 진행:
결제 방법을 선택하세요 (card/cash/mobile): card
카드를 삽입해주세요...💳 카드 결제가 완료되었습니다.
주문이 접수되었습니다. 조리 시간은 15-20분입니다. 🍽️
```

## 5. switch 표현식 예제

### 예제 5-1: 성적 평가 시스템
```java
import textio.TextIO;

public class GradeEvaluationSystem {
    public static void main(String[] args) {
        System.out.print("점수를 입력하세요 (0-100): ");
        int score = TextIO.getlnInt();
        
        // TODO: switch 표현식으로 등급 결정
        // 힌트:
        // 1. score / 10을 사용
        // 2. case 10, 9 -> 'A'
        // 3. case 8 -> 'B'
        // 4. case 7 -> 'C'
        // 5. case 6 -> 'D'
        // 6. default -> 'F'
        char grade = // 여기에 switch 표현식을 작성하세요
        
        // TODO: switch 표현식으로 평가 메시지 생성 (yield 사용)
        // 힌트:
        // 1. case 'A':
        //    - "🌟 탁월한 성과입니다!" 출력
        //    - yield "최우수"
        // 2. case 'B':
        //    - "👍 우수한 성과입니다!" 출력
        //    - yield "우수"
        // 3. case 'C':
        //    - "😊 보통 수준입니다." 출력
        //    - yield "보통"
        // 4. case 'D':
        //    - "😅 조금 더 노력이 필요합니다." 출력
        //    - yield "미흉"
        // 5. default:
        //    - "😞 많은 노력이 필요합니다." 출력
        //    - yield "낙제"
        String evaluation = // 여기에 switch 표현식을 작성하세요
        
        // TODO: switch 표현식으로 학점 계산
        // 힌트:
        // 1. case 'A' -> 4.0
        // 2. case 'B' -> 3.0
        // 3. case 'C' -> 2.0
        // 4. case 'D' -> 1.0
        // 5. default -> 0.0
        double gpa = // 여기에 switch 표현식을 작성하세요
        
        // switch 표현식으로 조언 생성
        String advice = switch (grade) {
            case 'A' -> "현재 수준을 유지하면서 다른 분야로 확장해보세요.";
            case 'B' -> "조금만 더 집중하면 A등급도 가능할 것 같습니다.";
            case 'C' -> "기본기를 더 탄탄히 하고 꾸준히 학습하세요.";
            case 'D' -> "학습 방법을 바꿔보고 도움을 요청하는 것이 좋겠습니다.";
            default -> "기초부터 차근차근 다시 시작해보세요.";
        };
        
        System.out.println("\n=== 성적 결과 ===");
        System.out.printf("점수: %d점%n", score);
        System.out.printf("등급: %c (%s)%n", grade, evaluation);
        System.out.printf("학점: %.1f%n", gpa);
        System.out.println("조언: " + advice);
        
        // 장학금 자격 여부
        boolean scholarship = switch (grade) {
            case 'A' -> true;
            case 'B', 'C', 'D', 'F' -> false;
        };
        
        if (scholarship) {
            System.out.println("🎉 장학금 대상자입니다!");
        }
    }
}
```

#### 실행 결과:
```
점수를 입력하세요 (0-100): 85

=== 성적 결과 ===
점수: 85점
등급: B (👍 우수한 성과입니다!
우수)
학점: 3.0
조언: 조금만 더 집중하면 A등급도 가능할 것 같습니다.
```

### 예제 5-2: 계산기
```java
import textio.TextIO;

public class SwitchCalculator {
    public static void main(String[] args) {
        System.out.println("=== Switch 표현식 계산기 ===");
        
        System.out.print("첫 번째 숫자: ");
        double num1 = TextIO.getlnDouble();
        
        System.out.print("연산자 (+, -, *, /, %, ^): ");
        String operator = TextIO.getln().trim();
        
        System.out.print("두 번째 숫자: ");
        double num2 = TextIO.getlnDouble();
        
        // TODO: switch 표현식으로 계산 수행
        // 힌트:
        // 1. case "+":
        //    - "덧셈을 수행합니다." 출력
        //    - yield num1 + num2
        // 2. case "-":
        //    - "뺄셈을 수행합니다." 출력
        //    - yield num1 - num2
        // 3. case "*":
        //    - "곱셈을 수행합니다." 출력
        //    - yield num1 * num2
        // 4. case "/":
        //    - num2 == 0이면 "0으로 나눌 수 없습니다!" 출력하고 yield Double.NaN
        //    - 그렇지 않으면 "나눗셈을 수행합니다." 출력하고 yield num1 / num2
        // 5. case "%":
        //    - num2 == 0이면 "0으로 나눈 나머지를 구할 수 없습니다!" 출력하고 yield Double.NaN
        //    - 그렇지 않으면 "나머지를 구합니다." 출력하고 yield num1 % num2
        // 6. case "^":
        //    - "거뒭제곱을 계산합니다." 출력
        //    - yield Math.pow(num1, num2)
        // 7. default:
        //    - "알 수 없는 연산자입니다: " + operator 출력
        //    - yield Double.NaN
        double result = // 여기에 switch 표현식을 작성하세요
        
        // 결과 출력
        if (!Double.isNaN(result)) {
            System.out.printf("결과: %.2f %s %.2f = %.2f%n", 
                num1, operator, num2, result);
            
            // switch 표현식으로 결과 분석
            String analysis = switch (Double.compare(result, 0.0)) {
                case 1 -> "양수입니다.";
                case -1 -> "음수입니다.";
                default -> "0입니다.";
            };
            System.out.println("분석: " + analysis);
            
            // 정수 여부 확인
            String numberType = switch ((result == (long)result) ? "integer" : "decimal") {
                case "integer" -> "정수입니다: " + (long)result;
                case "decimal" -> String.format("소수입니다: %.6f", result);
                default -> "알 수 없는 타입입니다.";
            };
            System.out.println("타입: " + numberType);
        }
    }
}
```

#### 실행 결과:
```
=== Switch 표현식 계산기 ===
첫 번째 숫자: 10
연산자 (+, -, *, /, %, ^): +
두 번째 숫자: 5
덧셈을 수행합니다.
결과: 10.00 + 5.00 = 15.00
분석: 양수입니다.
타입: 정수입니다: 15

=== Switch 표현식 계산기 ===
첫 번째 숫자: 8
연산자 (+, -, *, /, %, ^): /
두 번째 숫자: 0
0으로 나눌 수 없습니다!
```

## 6. 전통적인 switch문 예제 (비교용)

### 예제 6-1: 전통적인 문법 vs 새로운 문법
```java
public class SwitchSyntaxComparison {
    public static void main(String[] args) {
        int dayOfWeek = 3;
        
        System.out.println("=== 전통적인 switch문 ===");
        traditionalSwitch(dayOfWeek);
        
        System.out.println("\n=== 새로운 switch문 ===");
        modernSwitch(dayOfWeek);
    }
    
    // 전통적인 switch문 (break 필수)
    public static void traditionalSwitch(int day) {
        switch (day) {
            case 1:
                System.out.println("월요일");
                System.out.println("새로운 주의 시작");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                System.out.println("주중");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                System.out.println("주말이 코앞!");
                break;
            case 6:
            case 7:
                System.out.println("주말");
                System.out.println("휴식 시간");
                break;
            default:
                System.out.println("잘못된 요일");
        }
    }
    
    // 새로운 switch문 (break 불필요)
    public static void modernSwitch(int day) {
        switch (day) {
            case 1 -> {
                System.out.println("월요일");
                System.out.println("새로운 주의 시작");
            }
            case 2 -> System.out.println("화요일");
            case 3 -> {
                System.out.println("수요일");
                System.out.println("주중");
            }
            case 4 -> System.out.println("목요일");
            case 5 -> {
                System.out.println("금요일");
                System.out.println("주말이 코앞!");
            }
            case 6, 7 -> {
                System.out.println("주말");
                System.out.println("휴식 시간");
            }
            default -> System.out.println("잘못된 요일");
        }
    }
}
```

#### 실행 결과:
```
=== 전통적인 switch문 ===
수요일
주중

=== 새로운 switch문 ===
수요일
주중
```

### 예제 6-2: Fall-through 예제 (전통적인 문법)
```java
public class FallThroughExample {
    public static void main(String[] args) {
        int month = 2;
        
        System.out.println("월: " + month);
        System.out.println("해당 월과 이후 월들:");
        
        // 의도적인 fall-through 사용
        switch (month) {
            case 1:
                System.out.println("1월 - 새해");
            case 2:
                System.out.println("2월 - 설날");
            case 3:
                System.out.println("3월 - 봄의 시작");
            case 4:
                System.out.println("4월 - 벚꽃");
            case 5:
                System.out.println("5월 - 어린이날");
            case 6:
                System.out.println("6월 - 호국보훈의 달");
            case 7:
                System.out.println("7월 - 여름 시작");
            case 8:
                System.out.println("8월 - 휴가철");
            case 9:
                System.out.println("9월 - 가을 시작");
            case 10:
                System.out.println("10월 - 단풍");
            case 11:
                System.out.println("11월 - 수능");
            case 12:
                System.out.println("12월 - 크리스마스");
                break;
            default:
                System.out.println("잘못된 월");
        }
    }
}
```

#### 실행 결과:
```
월: 2
해당 월과 이후 월들:
2월 - 설날
3월 - 봄의 시작
4월 - 벚꽃
5월 - 어린이날
6월 - 호국보훈의 달
7월 - 여름 시작
8월 - 휴가철
9월 - 가을 시작
10월 - 단풍
11월 - 수능
12월 - 크리스마스
```

## 7. 실무 활용 예제

### 예제 7-1: HTTP 상태 코드 처리
```java
public class HttpStatusHandler {
    public static void main(String[] args) {
        int[] statusCodes = {200, 400, 401, 403, 404, 500, 503};
        
        for (int statusCode : statusCodes) {
            handleHttpStatus(statusCode);
        }
    }
    
    public static void handleHttpStatus(int statusCode) {
        String message = switch (statusCode / 100) {
            case 1 -> "정보 응답";
            case 2 -> "성공";
            case 3 -> "리다이렉션";
            case 4 -> "클라이언트 오류";
            case 5 -> "서버 오류";
            default -> "알 수 없는 상태";
        };
        
        String detail = switch (statusCode) {
            case 200 -> "OK - 요청 성공";
            case 201 -> "Created - 리소스 생성됨";
            case 400 -> "Bad Request - 잘못된 요청";
            case 401 -> "Unauthorized - 인증 필요";
            case 403 -> "Forbidden - 접근 금지";
            case 404 -> "Not Found - 리소스 없음";
            case 500 -> "Internal Server Error - 서버 내부 오류";
            case 503 -> "Service Unavailable - 서비스 사용 불가";
            default -> "기타 상태 코드";
        };
        
        boolean isError = switch (statusCode / 100) {
            case 4, 5 -> true;
            default -> false;
        };
        
        System.out.printf("[%d] %s - %s %s%n", 
            statusCode, message, detail, isError ? "⚠️" : "✅");
    }
}
```

#### 실행 결과:
```
[200] 성공 - OK - 요청 성공 ✅
[400] 클라이언트 오류 - Bad Request - 잘못된 요청 ⚠️
[401] 클라이언트 오류 - Unauthorized - 인증 필요 ⚠️
[403] 클라이언트 오류 - Forbidden - 접근 금지 ⚠️
[404] 클라이언트 오류 - Not Found - 리소스 없음 ⚠️
[500] 서버 오류 - Internal Server Error - 서버 내부 오류 ⚠️
[503] 서버 오류 - Service Unavailable - 서비스 사용 불가 ⚠️
```

### 예제 7-2: 파일 확장자 처리
```java
public class FileTypeProcessor {
    public static void main(String[] args) {
        String[] files = {
            "document.pdf", "image.jpg", "data.csv", 
            "script.js", "style.css", "page.html",
            "archive.zip", "video.mp4", "unknown.xyz"
        };
        
        for (String filename : files) {
            processFile(filename);
        }
    }
    
    public static void processFile(String filename) {
        String extension = getFileExtension(filename).toLowerCase();
        
        String fileType = switch (extension) {
            case "jpg", "jpeg", "png", "gif", "bmp" -> "이미지";
            case "mp4", "avi", "mov", "wmv", "flv" -> "비디오";
            case "mp3", "wav", "aac", "flac", "ogg" -> "오디오";
            case "pdf", "doc", "docx", "txt", "rtf" -> "문서";
            case "html", "htm", "xml" -> "웹 페이지";
            case "css", "js", "java", "py", "cpp" -> "코드";
            case "zip", "rar", "7z", "tar", "gz" -> "압축 파일";
            case "csv", "json", "xml" -> "데이터";
            default -> "알 수 없음";
        };
        
        String icon = switch (fileType) {
            case "이미지" -> "🖼️";
            case "비디오" -> "🎬";
            case "오디오" -> "🎵";
            case "문서" -> "📄";
            case "웹 페이지" -> "🌐";
            case "코드" -> "💻";
            case "압축 파일" -> "🗜️";
            case "데이터" -> "📊";
            default -> "❓";
        };
        
        String action = switch (fileType) {
            case "이미지" -> "이미지 뷰어로 열기";
            case "비디오" -> "미디어 플레이어로 재생";
            case "오디오" -> "음악 플레이어로 재생";
            case "문서" -> "문서 편집기로 열기";
            case "웹 페이지" -> "브라우저로 열기";
            case "코드" -> "IDE로 편집";
            case "압축 파일" -> "압축 해제";
            case "데이터" -> "데이터 분석 도구로 열기";
            default -> "시스템 기본 프로그램으로 열기";
        };
        
        System.out.printf("%s %s (%s) - %s%n", 
            icon, filename, fileType, action);
    }
    
    private static String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        return (lastDot > 0) ? filename.substring(lastDot + 1) : "";
    }
}
```

#### 실행 결과:
```
🖼️ document.pdf (문서) - 문서 편집기로 열기
🖼️ image.jpg (이미지) - 이미지 뷰어로 열기
📊 data.csv (데이터) - 데이터 분석 도구로 열기
💻 script.js (코드) - IDE로 편집
💻 style.css (코드) - IDE로 편집
🌐 page.html (웹 페이지) - 브라우저로 열기
🗜️ archive.zip (압축 파일) - 압축 해제
🎬 video.mp4 (비디오) - 미디어 플레이어로 재생
❓ unknown.xyz (알 수 없음) - 시스템 기본 프로그램으로 열기
```

## 8. 복합 switch 예제

### 예제 8-1: 온라인 쇼핑몰 주문 처리
```java
enum OrderStatus {
    PENDING, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

enum PaymentMethod {
    CREDIT_CARD, DEBIT_CARD, PAYPAL, BANK_TRANSFER, CRYPTO
}

public class OrderProcessor {
    public static void main(String[] args) {
        processOrder("ORD001", OrderStatus.PROCESSING, PaymentMethod.CREDIT_CARD, 150000);
        processOrder("ORD002", OrderStatus.CANCELLED, PaymentMethod.PAYPAL, 85000);
        processOrder("ORD003", OrderStatus.DELIVERED, PaymentMethod.BANK_TRANSFER, 230000);
    }
    
    public static void processOrder(String orderId, OrderStatus status, 
                                   PaymentMethod payment, int amount) {
        System.out.println("\n=== 주문 처리: " + orderId + " ===");
        
        // 상태별 메시지
        String statusMessage = switch (status) {
            case PENDING -> "⏳ 주문 대기 중";
            case CONFIRMED -> "✅ 주문 확인됨";
            case PROCESSING -> "🔄 주문 처리 중";
            case SHIPPED -> "🚚 배송 중";
            case DELIVERED -> "📦 배송 완료";
            case CANCELLED -> "❌ 주문 취소됨";
        };
        
        // 결제 방법별 수수료
        double fee = switch (payment) {
            case CREDIT_CARD -> amount * 0.025; // 2.5%
            case DEBIT_CARD -> amount * 0.015;  // 1.5%
            case PAYPAL -> amount * 0.035;      // 3.5%
            case BANK_TRANSFER -> 1000;         // 고정 1000원
            case CRYPTO -> amount * 0.01;       // 1.0%
        };
        
        // 배송 예상 시간
        String deliveryTime = switch (status) {
            case PENDING, CONFIRMED -> "아직 배송 시작 안됨";
            case PROCESSING -> "1-2일 후 배송 시작";
            case SHIPPED -> {
                yield switch (payment) {
                    case CREDIT_CARD, DEBIT_CARD -> "1-2일 내 도착 예정";
                    case PAYPAL -> "2-3일 내 도착 예정";
                    case BANK_TRANSFER -> "3-5일 내 도착 예정";
                    case CRYPTO -> "당일 또는 다음날 도착 예정";
                };
            }
            case DELIVERED -> "이미 배송 완료";
            case CANCELLED -> "배송 취소";
        };
        
        // 사용자 액션
        String[] actions = switch (status) {
            case PENDING -> new String[]{"주문 확인", "주문 취소"};
            case CONFIRMED -> new String[]{"주문 상세보기", "주문 취소"};
            case PROCESSING -> new String[]{"주문 상세보기", "배송지 변경"};
            case SHIPPED -> new String[]{"배송 추적", "주문 상세보기"};
            case DELIVERED -> new String[]{"리뷰 작성", "교환/반품 신청"};
            case CANCELLED -> new String[]{"재주문", "취소 사유 확인"};
        };
        
        System.out.println("상태: " + statusMessage);
        System.out.printf("결제: %s (수수료: %.0f원)%n", 
            getPaymentName(payment), fee);
        System.out.printf("금액: %,d원 (총 %,d원)%n", 
            amount, Math.round(amount + fee));
        System.out.println("배송: " + deliveryTime);
        System.out.print("가능한 액션: ");
        for (int i = 0; i < actions.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(actions[i]);
        }
        System.out.println();
    }
    
    private static String getPaymentName(PaymentMethod payment) {
        return switch (payment) {
            case CREDIT_CARD -> "신용카드";
            case DEBIT_CARD -> "체크카드";
            case PAYPAL -> "페이팔";
            case BANK_TRANSFER -> "무통장입금";
            case CRYPTO -> "암호화폐";
        };
    }
}
```
#### 실행 결과:
```
=== 주문 처리: ORD001 ===
상태: 🔄 주문 처리 중
결제: 신용카드 (수수료: 3750원)
금액: 150,000원 (총 153,750원)
배송: 1-2일 후 배송 시작
가능한 액션: 주문 상세보기, 배송지 변경

=== 주문 처리: ORD002 ===
상태: ❌ 주문 취소됨
결제: 페이팔 (수수료: 2975원)
금액: 85,000원 (총 87,975원)
배송: 배송 취소
가능한 액션: 재주문, 취소 사유 확인

=== 주문 처리: ORD003 ===
상태: 📦 배송 완료
결제: 무통장입금 (수수료: 1000원)
금액: 230,000원 (총 231,000원)
배송: 이미 배송 완료
가능한 액션: 리뷰 작성, 교환/반품 신청
```
