# 5.7 인터페이스(Interfaces) - 수업 실습

## 1. 기본 인터페이스 예제

### 실습 1-1: 도형 그리기 인터페이스
**목표**: 인터페이스를 사용하여 도형의 다양한 기능을 구현해보세요.

```java
import java.awt.*;
import java.awt.geom.*;

/**
 * 그래픽 객체를 위한 기본 인터페이스들
 */
// 외곽선을 그릴 수 있는 객체
public interface Strokeable {
    void stroke(Graphics g);
    void setStrokeColor(Color color);
    void setStrokeWidth(int width);
}

// 내부를 채울 수 있는 객체
public interface Fillable {
    void fill(Graphics g);
    void setFillColor(Color color);
}

// 변형 가능한 객체
public interface Transformable {
    void translate(int dx, int dy);
    void rotate(double angle);
    void scale(double factor);
}

// Line 클래스 - Strokeable만 구현
public class Line implements Strokeable {
    private int x1, y1, x2, y2;
    private Color strokeColor = Color.BLACK;
    private int strokeWidth = 1;
    
    public Line(int x1, int y1, int x2, int y2) {
        // TODO 1: 좌표 초기화하기
    }
    
    @Override
    public void stroke(Graphics g) {
        // TODO 2: 선 그리기 구현하기
        // g.setColor()로 색상 설정
        // ((Graphics2D) g).setStroke()로 선 두께 설정
        // g.drawLine()으로 선 그리기
    }
    
    @Override
    public void setStrokeColor(Color color) {
        // TODO 3: 선 색상 설정하기
    }
    
    @Override
    public void setStrokeWidth(int width) {
        // TODO 4: 선 두께 설정하기
    }
}

// Rectangle 클래스 - 여러 인터페이스 구현
public class Rectangle implements Strokeable, Fillable, Transformable {
    private int x, y, width, height;
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private int strokeWidth = 1;
    
    public Rectangle(int x, int y, int width, int height) {
        // TODO 5: 사각형 속성 초기화하기
    }
    
    @Override
    public void stroke(Graphics g) {
        // TODO 6: 사각형 외곽선 그리기
        // g.setColor()로 색상 설정
        // ((Graphics2D) g).setStroke()로 선 두께 설정
        // g.drawRect()로 외곽선 그리기
    }
    
    @Override
    public void fill(Graphics g) {
        // TODO 7: 사각형 내부 채우기
        // g.setColor()로 채움 색상 설정
        // g.fillRect()로 사각형 채우기
    }
    
    @Override
    public void setStrokeColor(Color color) {
        // TODO 8: 외곽선 색상 설정하기
    }
    
    @Override
    public void setStrokeWidth(int width) {
        // TODO 9: 외곽선 두께 설정하기
    }
    
    @Override
    public void setFillColor(Color color) {
        // TODO 10: 채움 색상 설정하기
    }
    
    @Override
    public void translate(int dx, int dy) {
        // TODO 11: 위치 이동하기
        // x에 dx 더하기, y에 dy 더하기
    }
    
    @Override
    public void rotate(double angle) {
        // TODO 12: 회전 구현하기 (간단히 출력만)
        // "사각형을 [angle]도 회전합니다." 출력
    }
    
    @Override
    public void scale(double factor) {
        // TODO 13: 크기 조정하기
        // width와 height에 factor를 곱하기
    }
}

// 테스트 클래스
public class DrawingTest {
    public static void main(String[] args) {
        // TODO 14: Line과 Rectangle 객체 생성하기
        // Line: (10, 10)에서 (100, 100)
        // Rectangle: (50, 50) 위치, 너비 80, 높이 60
        
        // TODO 15: Strokeable 배열로 처리하기
        // 두 도형을 Strokeable 배열에 담기
        // 각각 색상을 RED로, 두께를 2로 설정
        
        // TODO 16: Rectangle을 Fillable로 형변환하여 처리하기
        // instanceof로 확인 후 Fillable로 형변환
        // 채움 색상을 BLUE로 설정
        
        // TODO 17: Rectangle을 Transformable로 형변환하여 처리하기
        // instanceof로 확인 후 Transformable로 형변환
        // (10, 20) 이동하고, 1.5배 확대하기
        
        // TODO 18: 설정된 값들 출력하기 (그래픽 없이)
        // "Line 생성 완료"
        // "Rectangle 생성 및 변형 완료"
    }
}

#### 실행 결과 (참고용):
```
Line 생성 완료
Rectangle 생성 및 변형 완료
사각형을 0.0도 회전합니다.
```

### 실습 1-2: 상수를 포함한 인터페이스
**목표**: 인터페이스의 상수를 활용한 게임 캐릭터 시스템을 구현해보세요.

```java
/**
 * 게임 설정을 위한 상수 인터페이스
 */
public interface GameConstants {
    // 게임 설정 상수들 (모두 public static final)
    int MAX_PLAYERS = 4;
    int MIN_PLAYERS = 2;
    
    int BOARD_WIDTH = 10;
    int BOARD_HEIGHT = 10;
    
    int INITIAL_HEALTH = 100;
    int INITIAL_MANA = 50;
    
    // 게임 상태
    int STATE_WAITING = 0;
    int STATE_PLAYING = 1;
    int STATE_PAUSED = 2;
    int STATE_GAME_OVER = 3;
    
    // 방향
    int DIRECTION_UP = 0;
    int DIRECTION_RIGHT = 1;
    int DIRECTION_DOWN = 2;
    int DIRECTION_LEFT = 3;
}

// 게임 캐릭터 인터페이스
public interface GameCharacter extends GameConstants {
    void move(int direction);
    void attack(GameCharacter target);
    int getHealth();
    int getMana();
    boolean isAlive();
}

// 플레이어 구현
public class Player implements GameCharacter {
    private String name;
    private int health;
    private int mana;
    private int x, y;
    
    public Player(String name) {
        // TODO 19: 플레이어 초기화하기
        // name 설정
        // health를 INITIAL_HEALTH로 초기화
        // mana를 INITIAL_MANA로 초기화
        // x, y를 보드 중앙으로 설정 (BOARD_WIDTH/2, BOARD_HEIGHT/2)
    }
    
    @Override
    public void move(int direction) {
        // TODO 20: 방향에 따라 이동하기
        // DIRECTION_UP: y > 0이면 y--
        // DIRECTION_DOWN: y < BOARD_HEIGHT - 1이면 y++
        // DIRECTION_LEFT: x > 0이면 x--
        // DIRECTION_RIGHT: x < BOARD_WIDTH - 1이면 x++
        // "[name] 이동: (x, y)" 출력
    }
    
    @Override
    public void attack(GameCharacter target) {
        // TODO 21: 공격 구현하기
        // "[name]이(가) 공격!" 출력
    }
    
    @Override
    public int getHealth() {
        // TODO 22: health 반환하기
        return 0;
    }
    
    @Override
    public int getMana() {
        // TODO 23: mana 반환하기
        return 0;
    }
    
    @Override
    public boolean isAlive() {
        // TODO 24: health > 0인지 반환하기
        return false;
    }
}

// 게임 관리자
public class GameManager implements GameConstants {
    private GameCharacter[] players;
    private int gameState;
    private int playerCount;
    
    public GameManager() {
        // TODO 25: 게임 매니저 초기화하기
        // players를 MAX_PLAYERS 크기로 생성
        // gameState를 STATE_WAITING으로 설정
        // playerCount를 0으로 설정
    }
    
    public void addPlayer(GameCharacter player) {
        // TODO 26: 플레이어 추가하기
        // playerCount < MAX_PLAYERS이면 players 배열에 추가
        // playerCount 증가
    }
    
    public void startGame() {
        // TODO 27: 게임 시작하기
        // playerCount >= MIN_PLAYERS이면:
        //   gameState를 STATE_PLAYING으로 변경
        //   "게임 시작!" 출력
        // 아니면:
        //   "최소 [MIN_PLAYERS]명이 필요합니다." 출력
    }
    
    private int getPlayerCount() {
        return playerCount;
    }
}

// 테스트
public class GameTest {
    public static void main(String[] args) {
        // TODO 28: GameManager 생성하기
        
        // TODO 29: Player 생성하고 추가하기
        // "용사"와 "마법사" 플레이어 생성
        // GameManager에 추가
        
        // TODO 30: 게임 시작 시도하기
        
        // TODO 31: 플레이어들 이동시키기
        // 용사는 UP, RIGHT로 이동
        // 마법사는 DOWN, LEFT로 이동
        
        // TODO 32: 서로 공격하기
        // 용사가 마법사를 공격
        // 마법사가 용사를 공격
    }
}

#### 실행 결과 (참고용):
```
게임 시작!
용사 이동: (5, 4)
용사 이동: (6, 4)
마법사 이동: (5, 6)
마법사 이동: (4, 6)
용사이(가) 공격!
마법사이(가) 공격!
```

## 2. 기본 메서드(Default Methods) 예제

### 실습 2-1: Readable 인터페이스와 기본 메서드
**목표**: 기본 메서드를 활용한 읽기 인터페이스를 구현해보세요.

```java
/**
 * 읽기 가능한 소스를 나타내는 인터페이스
 */
public interface Readable {
    // 추상 메서드 - 구현 필수
    char readChar();
    
    // 기본 메서드 - 한 줄 읽기
    default String readLine() {
        StringBuilder line = new StringBuilder();
        try {
            char ch = readChar();
            while (ch != '\n' && ch != '\0') {
                line.append(ch);
                ch = readChar();
            }
        } catch (Exception e) {
            // 읽기 종료
        }
        return line.toString();
    }
    
    // 기본 메서드 - 단어 읽기
    default String readWord() {
        StringBuilder word = new StringBuilder();
        try {
            char ch = readChar();
            
            // 공백 건너뛰기
            while (Character.isWhitespace(ch)) {
                ch = readChar();
            }
            
            // 단어 읽기
            while (!Character.isWhitespace(ch) && ch != '\0') {
                word.append(ch);
                ch = readChar();
            }
        } catch (Exception e) {
            // 읽기 종료
        }
        return word.toString();
    }
    
    // 기본 메서드 - 모든 내용 읽기
    default String readAll() {
        StringBuilder all = new StringBuilder();
        try {
            String line;
            while (!(line = readLine()).isEmpty()) {
                all.append(line).append('\n');
            }
        } catch (Exception e) {
            // 읽기 종료
        }
        return all.toString();
    }
}

// 구현 예제 1: 문자열에서 읽기
public class StringReader implements Readable {
    private String content;
    private int position;
    
    public StringReader(String content) {
        // TODO 33: content와 position 초기화하기
    }
    
    @Override
    public char readChar() {
        // TODO 34: 문자 하나 읽기
        // position >= content.length()이면 '\0' 반환
        // 아니면 content.charAt(position) 반환하고 position 증가
        return '\0';
    }
}

// 구현 예제 2: 별 패턴 생성기
public class StarPattern implements Readable {
    private int currentLine = 0;
    private int currentPos = 0;
    private final int maxLines = 5;
    
    @Override
    public char readChar() {
        // TODO 35: 별 패턴 문자 생성하기
        // currentLine >= maxLines이면 '\0' 반환
        // currentPos <= currentLine이면:
        //   currentPos 증가하고 '*' 반환
        // 아니면:
        //   currentPos = 0, currentLine 증가하고 '\n' 반환
        return '\0';
    }
}

// 테스트 클래스
public class ReadableTest {
    public static void main(String[] args) {
        // TODO 36: StringReader 테스트하기
        // "Hello World\nJava Programming" 문자열로 생성
        // readLine()으로 첫 줄 읽고 출력
        // readWord()로 다음 단어 읽고 출력
        
        // TODO 37: StarPattern 테스트하기
        // StarPattern 객체 생성
        // readAll()로 전체 패턴 읽고 출력
    }
}

#### 실행 결과 (참고용):
```
첫 줄: Hello World
단어: Java

=== 별 패턴 ===
*
**
***
****
*****
```

### 실습 2-2: 계산기 인터페이스와 기본 메서드
**목표**: 기본 메서드를 활용한 확장 가능한 계산기를 구현해보세요.

```java
/**
 * 계산기 인터페이스 - 기본 연산과 확장 연산
 */
public interface Calculator {
    // 기본 연산 (추상 메서드)
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
    
    // 확장 연산 (기본 메서드)
    default double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    default double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수의 제곱근은 계산할 수 없습니다.");
        }
        return Math.sqrt(number);
    }
    
    default double average(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double num : numbers) {
            sum = add(sum, num);  // 추상 메서드 사용
        }
        return divide(sum, numbers.length);
    }
    
    default double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수의 팩토리얼은 정의되지 않습니다.");
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result = multiply(result, i);  // 추상 메서드 사용
        }
        return result;
    }
}

// 기본 계산기 구현
public class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        // TODO 38: 덧셈 구현하기
        return 0;
    }
    
    @Override
    public double subtract(double a, double b) {
        // TODO 39: 뺄셈 구현하기
        return 0;
    }
    
    @Override
    public double multiply(double a, double b) {
        // TODO 40: 곱셈 구현하기
        return 0;
    }
    
    @Override
    public double divide(double a, double b) {
        // TODO 41: 나눗셈 구현하기
        // b가 0이면 ArithmeticException 던지기
        return 0;
    }
}

// 공학용 계산기 - 일부 기본 메서드 오버라이드
public class ScientificCalculator extends BasicCalculator {
    // 더 정확한 제곱근 계산 알고리즘 사용
    @Override
    public double squareRoot(double number) {
        // TODO 42: 개선된 제곱근 계산 구현하기
        // 음수 체크
        // Newton-Raphson 방법 구현 (또는 간단히 Math.sqrt 사용)
        // "개선된 알고리즘 사용" 출력 후 결과 반환
        return 0;
    }
    
    // 추가 메서드
    public double sin(double angle) {
        // TODO 43: 사인 함수 구현하기
        return 0;
    }
    
    public double cos(double angle) {
        // TODO 44: 코사인 함수 구현하기
        return 0;
    }
}

// 테스트
public class CalculatorTest {
    public static void main(String[] args) {
        // TODO 45: BasicCalculator 테스트하기
        // 3 + 5, 10 - 4 계산하고 출력
        // average(2, 4, 6, 8) 계산하고 출력
        // 5! 계산하고 출력
        // √16 계산하고 출력
        
        // TODO 46: ScientificCalculator 테스트하기
        // √25 계산하고 출력
        // sin(π/2), cos(0) 계산하고 출력
    }
}

#### 실행 결과 (참고용):
```
=== 기본 계산기 ===
3 + 5 = 8.0
10 - 4 = 6.0
평균(2, 4, 6, 8) = 5.0
5! = 120.0
√16 = 4.0

=== 공학용 계산기 ===
개선된 알고리즘 사용
√25 = 5.0
sin(π/2) = 1.0
cos(0) = 1.0
```

## 3. 인터페이스 확장 예제

### 실습 3-1: 계층적 인터페이스 구조
**목표**: 인터페이스 상속을 활용한 동물 계층구조를 구현해보세요.

```java
/**
 * 동물 행동을 나타내는 인터페이스 계층구조
 */
// 기본 동물 인터페이스
public interface Animal {
    String getName();
    void eat(String food);
    void sleep();
}

// 이동 가능한 동물
public interface Movable {
    void move(int distance);
    int getSpeed();
}

// 소리 낼 수 있는 동물
public interface Audible {
    void makeSound();
    void setVolume(int level);
}

// 육상 동물 - 여러 인터페이스 확장
public interface LandAnimal extends Animal, Movable, Audible {
    void run();
    void jump();
}

// 수중 동물
public interface AquaticAnimal extends Animal, Movable {
    void swim();
    void dive(int depth);
}

// 날 수 있는 동물
public interface FlyingAnimal extends Animal, Movable {
    void fly();
    void land();
    int getAltitude();
}

// 구체적인 구현 - 개
public class Dog implements LandAnimal {
    private String name;
    private int speed = 30;  // km/h
    private int volume = 5;
    
    public Dog(String name) {
        // TODO 47: name 초기화하기
    }
    
    @Override
    public String getName() {
        // TODO 48: name 반환하기
        return "";
    }
    
    @Override
    public void eat(String food) {
        // TODO 49: "[name]가 [food]를 먹습니다." 출력하기
    }
    
    @Override
    public void sleep() {
        // TODO 50: "[name]가 잠을 잡니다. Zzz..." 출력하기
    }
    
    @Override
    public void move(int distance) {
        // TODO 51: "[name]가 [distance]m 이동합니다." 출력하기
    }
    
    @Override
    public int getSpeed() {
        // TODO 52: speed 반환하기
        return 0;
    }
    
    @Override
    public void makeSound() {
        // TODO 53: "[name]가 짖습니다: 멍멍! (볼륨: [volume])" 출력하기
    }
    
    @Override
    public void setVolume(int level) {
        // TODO 54: volume 설정하기 (0~10 범위로 제한)
        // Math.max(0, Math.min(10, level)) 사용
    }
    
    @Override
    public void run() {
        // TODO 55: "[name]가 달립니다!" 출력하고
        // move(100) 호출하기
    }
    
    @Override
    public void jump() {
        // TODO 56: "[name]가 점프합니다!" 출력하기
    }
}

// 구체적인 구현 - 오리 (여러 능력)
public class Duck implements LandAnimal, AquaticAnimal, FlyingAnimal {
    private String name;
    private int landSpeed = 5;
    private int swimSpeed = 10;
    private int flySpeed = 40;
    private int currentSpeed;
    private int altitude = 0;
    private int volume = 3;
    
    public Duck(String name) {
        // TODO 57: name과 currentSpeed(landSpeed) 초기화하기
    }
    
    @Override
    public String getName() {
        // TODO 58: name 반환하기
        return "";
    }
    
    @Override
    public void eat(String food) {
        // TODO 59: "[name]가 [food]를 먹습니다." 출력하기
    }
    
    @Override
    public void sleep() {
        // TODO 60: "[name]가 물 위에서 잠을 잡니다." 출력하기
    }
    
    @Override
    public void move(int distance) {
        // TODO 61: "[name]가 [distance]m 이동합니다. (속도: [currentSpeed]km/h)" 출력하기
    }
    
    @Override
    public int getSpeed() {
        // TODO 62: currentSpeed 반환하기
        return 0;
    }
    
    @Override
    public void makeSound() {
        // TODO 63: "[name]: 꽥꽥! (볼륨: [volume])" 출력하기
    }
    
    @Override
    public void setVolume(int level) {
        // TODO 64: volume 설정하기 (0~10 범위로 제한)
    }
    
    @Override
    public void run() {
        // TODO 65: currentSpeed를 landSpeed로 설정하고
        // "[name]가 뒤뚱뒤뚱 걷습니다." 출력하기
    }
    
    @Override
    public void jump() {
        // TODO 66: "[name]가 폴짝 뜁니다." 출력하기
    }
    
    @Override
    public void swim() {
        // TODO 67: currentSpeed를 swimSpeed로 설정하고
        // "[name]가 우아하게 헤엄칩니다." 출력하기
    }
    
    @Override
    public void dive(int depth) {
        // TODO 68: "[name]가 [depth]m 깊이로 잠수합니다." 출력하기
    }
    
    @Override
    public void fly() {
        // TODO 69: currentSpeed를 flySpeed로 설정하고
        // altitude를 100으로 설정하고
        // "[name]가 날아오릅니다!" 출력하기
    }
    
    @Override
    public void land() {
        // TODO 70: altitude를 0으로, currentSpeed를 landSpeed로 설정하고
        // "[name]가 착륙합니다." 출력하기
    }
    
    @Override
    public int getAltitude() {
        // TODO 71: altitude 반환하기
        return 0;
    }
}

// 동물원 관리 시스템
public class Zoo {
    public static void main(String[] args) {
        // TODO 72: Dog과 Duck 객체 생성하기
        // Dog: "바둑이"
        // Duck: "도널드"
        
        // TODO 73: LandAnimal 배열로 처리하기
        // 두 동물을 LandAnimal 배열에 담고
        // 각각 run(), makeSound(), jump() 호출하기
        
        // TODO 74: 오리의 특별한 능력 테스트하기
        // swim(), dive(2), fly() 호출
        // 현재 고도 출력
        // land() 호출
    }
}

#### 실행 결과 (참고용):
```
=== 육상 동물 행동 ===
바둑이가 달립니다!
바둑이가 100m 이동합니다.
바둑이가 짖습니다: 멍멍! (볼륨: 5)
바둑이가 점프합니다!

도널드가 뒤뚱뒤뚱 걷습니다.
도널드: 꽥꽥! (볼륨: 3)
도널드가 폴짝 뜁니다.

=== 오리의 특별한 능력 ===
도널드가 우아하게 헤엄칩니다.
도널드가 2m 깊이로 잠수합니다.
도널드가 날아오릅니다!
현재 고도: 100m
도널드가 착륙합니다.
```

## 4. 실전 응용 예제

### 실습 4-1: 이벤트 처리 시스템
**목표**: 인터페이스를 활용한 이벤트 처리 시스템을 구현해보세요.

```java
import java.util.*;

/**
 * 이벤트 처리를 위한 인터페이스 시스템
 */
// 이벤트 리스너 인터페이스
public interface EventListener {
    void onEvent(Event event);
}

// 이벤트 클래스
public class Event {
    private String type;
    private Object source;
    private long timestamp;
    private Map<String, Object> data;
    
    public Event(String type, Object source) {
        // TODO 75: type, source, timestamp 초기화하기
        // timestamp는 System.currentTimeMillis() 사용
        // data는 새 HashMap으로 초기화
    }
    
    // getter 메서드들
    public String getType() { return type; }
    public Object getSource() { return source; }
    public long getTimestamp() { return timestamp; }
    
    public void setData(String key, Object value) {
        // TODO 76: data에 key-value 추가하기
    }
    
    public Object getData(String key) {
        // TODO 77: data에서 key에 해당하는 값 반환하기
        return null;
    }
}

// 특정 이벤트 리스너들
public interface ClickListener extends EventListener {
    @Override
    default void onEvent(Event event) {
        if ("click".equals(event.getType())) {
            onClick(event);
        }
    }
    
    void onClick(Event event);
}

// 이벤트 발생자 인터페이스
public interface EventEmitter {
    void addEventListener(String eventType, EventListener listener);
    void removeEventListener(String eventType, EventListener listener);
    void emit(Event event);
}

// 버튼 클래스 - 이벤트 발생자
public class Button implements EventEmitter {
    private String text;
    private Map<String, List<EventListener>> listeners;
    
    public Button(String text) {
        // TODO 78: text 초기화하고
        // listeners를 새 HashMap으로 초기화하기
    }
    
    @Override
    public void addEventListener(String eventType, EventListener listener) {
        // TODO 79: 이벤트 리스너 등록하기
        // listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener)
    }
    
    @Override
    public void removeEventListener(String eventType, EventListener listener) {
        // TODO 80: 이벤트 리스너 제거하기
        // listeners.get(eventType)에서 listener 제거
    }
    
    @Override
    public void emit(Event event) {
        // TODO 81: 이벤트 발생시키기
        // event.getType()에 해당하는 리스너들을 찾아서
        // 각각의 onEvent(event) 호출하기
    }
    
    // 버튼 클릭 시뮬레이션
    public void click() {
        // TODO 82: 클릭 이벤트 생성하고 발생시키기
        // Event 생성 (type: "click", source: this)
        // event에 "button" 데이터로 text 추가
        // emit(event) 호출
    }
    
    public String getText() {
        return text;
    }
}

// 애플리케이션 - 이벤트 처리
public class Application {
    private Button saveButton;
    private Button cancelButton;
    
    public Application() {
        // TODO 83: 버튼 생성하기
        // saveButton: "저장"
        // cancelButton: "취소"
        
        // TODO 84: 저장 버튼에 클릭 리스너 등록하기
        // ClickListener 구현체 생성 (익명 클래스)
        // onClick에서 "저장 버튼 클릭!" 출력하고 save() 호출
        
        // TODO 85: 취소 버튼에 클릭 리스너 등록하기
        // 람다 표현식 사용
        // "취소 버튼 클릭!" 출력하고 cancel() 호출
    }
    
    private void save() {
        System.out.println("데이터를 저장합니다...");
    }
    
    private void cancel() {
        System.out.println("작업을 취소합니다...");
    }
    
    public void run() {
        // TODO 86: 버튼 클릭 시뮬레이션하기
        // saveButton.click()
        // cancelButton.click()
    }
    
    public static void main(String[] args) {
        // TODO 87: Application 실행하기
        // Application 객체 생성하고 run() 호출
    }
}

#### 실행 결과 (참고용):
```
저장 버튼 클릭!
데이터를 저장합니다...
취소 버튼 클릭!
작업을 취소합니다...
```

## 5. 복합 예제: 파일 시스템

### 실습 5-1: 가상 파일 시스템 인터페이스
**목표**: 인터페이스를 활용한 간단한 파일 시스템을 구현해보세요.

```java
import java.util.*;

/**
 * 파일 시스템을 위한 인터페이스 설계
 */
// 파일 시스템 항목
public interface FileSystemItem {
    String getName();
    long getSize();
    Date getCreatedDate();
    Date getModifiedDate();
    String getPath();
}

// 읽기 가능
public interface Readable {
    byte[] read();
    String readAsString();
}

// 쓰기 가능
public interface Writable {
    void write(byte[] data);
    void writeString(String content);
    void append(byte[] data);
}

// 파일 인터페이스
public interface File extends FileSystemItem, Readable, Writable {
    String getExtension();
    String getMimeType();
}

// 디렉토리 인터페이스
public interface Directory extends FileSystemItem {
    List<FileSystemItem> listItems();
    void addItem(FileSystemItem item);
    void removeItem(String name);
    FileSystemItem findItem(String name);
}

// 텍스트 파일 구현
public class TextFile implements File {
    private String name;
    private String content;
    private Date createdDate;
    private Date modifiedDate;
    private String path;
    
    public TextFile(String name, String path) {
        // TODO 88: 필드 초기화하기
        // name, path 설정
        // content는 빈 문자열
        // createdDate, modifiedDate는 현재 시간
    }
    
    @Override
    public String getName() {
        // TODO 89: name 반환하기
        return "";
    }
    
    @Override
    public long getSize() {
        // TODO 90: content의 바이트 크기 반환하기
        // content.getBytes().length
        return 0;
    }
    
    @Override
    public Date getCreatedDate() {
        // TODO 91: createdDate 반환하기
        return null;
    }
    
    @Override
    public Date getModifiedDate() {
        // TODO 92: modifiedDate 반환하기
        return null;
    }
    
    @Override
    public String getPath() {
        // TODO 93: path 반환하기
        return "";
    }
    
    @Override
    public String getExtension() {
        // TODO 94: 파일 확장자 반환하기
        // name에서 마지막 '.' 이후 문자열
        // '.'이 없으면 빈 문자열
        return "";
    }
    
    @Override
    public String getMimeType() {
        // TODO 95: "text/plain" 반환하기
        return "";
    }
    
    @Override
    public byte[] read() {
        // TODO 96: content를 바이트 배열로 반환하기
        return null;
    }
    
    @Override
    public String readAsString() {
        // TODO 97: content 반환하기
        return "";
    }
    
    @Override
    public void write(byte[] data) {
        // TODO 98: data를 문자열로 변환하여 content에 저장하기
        // modifiedDate 업데이트
    }
    
    @Override
    public void writeString(String content) {
        // TODO 99: content 저장하고 modifiedDate 업데이트하기
    }
    
    @Override
    public void append(byte[] data) {
        // TODO 100: data를 문자열로 변환하여 content에 추가하기
        // modifiedDate 업데이트
    }
}

// 간단한 디렉토리 구현
public class SimpleDirectory implements Directory {
    private String name;
    private String path;
    private Date createdDate;
    private Date modifiedDate;
    private List<FileSystemItem> items;
    
    public SimpleDirectory(String name, String path) {
        // TODO 101: 필드 초기화하기
        // name, path 설정
        // createdDate, modifiedDate는 현재 시간
        // items는 새 ArrayList
    }
    
    @Override
    public String getName() {
        // TODO 102: name 반환하기
        return "";
    }
    
    @Override
    public long getSize() {
        // TODO 103: 모든 항목의 크기 합계 반환하기
        // items의 각 항목의 getSize() 합계
        return 0;
    }
    
    @Override
    public Date getCreatedDate() {
        // TODO 104: createdDate 반환하기
        return null;
    }
    
    @Override
    public Date getModifiedDate() {
        // TODO 105: modifiedDate 반환하기
        return null;
    }
    
    @Override
    public String getPath() {
        // TODO 106: path 반환하기
        return "";
    }
    
    @Override
    public List<FileSystemItem> listItems() {
        // TODO 107: items의 복사본 반환하기
        // new ArrayList<>(items)
        return null;
    }
    
    @Override
    public void addItem(FileSystemItem item) {
        // TODO 108: item 추가하고 modifiedDate 업데이트하기
    }
    
    @Override
    public void removeItem(String name) {
        // TODO 109: name과 일치하는 항목 제거하기
        // items.removeIf() 사용
        // modifiedDate 업데이트
    }
    
    @Override
    public FileSystemItem findItem(String name) {
        // TODO 110: name과 일치하는 항목 찾기
        // 없으면 null 반환
        return null;
    }
}

// 파일 시스템 테스트
public class FileSystemTest {
    public static void main(String[] args) {
        // TODO 111: 디렉토리와 파일 생성하기
        // root 디렉토리: "root", "/"
        // readme 파일: "README.txt", "/README.txt"
        // readme에 "이것은 읽어보기 파일입니다." 쓰기
        
        // TODO 112: 파일 시스템 구성하기
        // root에 readme 추가
        
        // TODO 113: 파일 시스템 정보 출력하기
        // "=== 파일 시스템 내용 ==="
        // root 디렉토리 이름과 크기 출력
        // readme 파일 이름, 크기, 내용 출력
    }
}

#### 실행 결과 (참고용):
```
=== 파일 시스템 내용 ===
디렉토리: root (39 bytes)
파일: README.txt (39 bytes)
내용: 이것은 읽어보기 파일입니다.
```

## 학습 포인트

### 1. 인터페이스 기본
- **추상 메서드**: 구현 없이 선언만 있는 메서드
- **다중 구현**: 한 클래스가 여러 인터페이스 구현 가능
- **타입으로 사용**: 인터페이스 타입 변수로 구현 객체 참조

### 2. 인터페이스 상수
- **public static final**: 모든 필드는 자동으로 상수
- **초기화 필수**: 선언 시 값 할당 필요
- **상속**: 구현 클래스에서 직접 사용 가능

### 3. 기본 메서드 (Java 8+)
- **default 키워드**: 구현이 있는 메서드
- **재사용**: 공통 기능을 인터페이스에 구현
- **오버라이드 가능**: 필요시 구현 클래스에서 재정의

### 4. 인터페이스 확장
- **extends**: 인터페이스끼리 상속 가능
- **다중 상속**: 여러 인터페이스 동시 확장
- **계층 구조**: 복잡한 타입 시스템 구축

### 5. 실전 활용
- **이벤트 처리**: 리스너 패턴
- **플러그인 시스템**: 확장 가능한 아키텍처
- **API 설계**: 구현과 분리된 계약 정의

인터페이스는 객체지향 프로그래밍의 핵심 도구입니다!