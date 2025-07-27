# 5.7 인터페이스(Interfaces) - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 인터페이스의 개념과 목적을 이해한다
- 인터페이스를 정의하고 구현할 수 있다
- 기본 메서드(default method)를 활용할 수 있다
- 인터페이스를 타입으로 사용할 수 있다
- 다중 인터페이스 구현의 장점을 이해한다

## 1. 인터페이스란?

### 1.1 인터페이스의 정의

**인터페이스(Interface)**는 클래스가 구현해야 할 메서드들의 집합을 정의하는 일종의 계약입니다.

```java
// 인터페이스 정의
public interface Drawable {
    void draw();  // 추상 메서드 (구현 없음)
}

// 인터페이스 구현
public class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("원을 그립니다.");
    }
}
```

### 1.2 왜 인터페이스가 필요한가?

**1. 다중 상속의 대안**:
- Java는 클래스의 다중 상속을 허용하지 않음
- 하지만 여러 인터페이스는 구현 가능

```java
// 여러 인터페이스 구현
public class SmartPhone implements Phone, Camera, GPS {
    // 세 가지 기능을 모두 가진 스마트폰
}
```

**2. 표준화된 계약**:
- 서로 다른 클래스들이 같은 방식으로 동작하도록 보장
- 코드의 일관성과 예측 가능성 향상

## 2. 인터페이스 정의하기

### 2.1 기본 문법

```java
public interface InterfaceName {
    // 상수 (public static final이 자동으로 적용)
    int MAX_SIZE = 100;
    
    // 추상 메서드 (public abstract가 자동으로 적용)
    void method1();
    String method2(int param);
    
    // Java 8부터: 기본 메서드
    default void defaultMethod() {
        System.out.println("기본 구현");
    }
    
    // Java 8부터: 정적 메서드
    static void staticMethod() {
        System.out.println("정적 메서드");
    }
}
```

### 2.2 실제 예제: Strokeable 인터페이스

```java
// 그래픽 객체를 위한 인터페이스
public interface Strokeable {
    // 객체의 외곽선을 그리는 메서드
    void stroke(GraphicsContext g);
}

// 구현 클래스 1: 선
public class Line implements Strokeable {
    private int x1, y1, x2, y2;
    
    @Override
    public void stroke(GraphicsContext g) {
        g.drawLine(x1, y1, x2, y2);
    }
}

// 구현 클래스 2: 사각형
public class Rectangle implements Strokeable {
    private int x, y, width, height;
    
    @Override
    public void stroke(GraphicsContext g) {
        g.drawRect(x, y, width, height);
    }
}
```

## 3. 다중 인터페이스 구현

### 3.1 여러 인터페이스 구현하기

```java
// 여러 인터페이스 정의
public interface Strokeable {
    void stroke(GraphicsContext g);
}

public interface Fillable {
    void fill(GraphicsContext g);
}

public interface Rotatable {
    void rotate(double angle);
}

// 모든 인터페이스 구현
public class FilledCircle extends Circle 
                         implements Strokeable, Fillable, Rotatable {
    
    @Override
    public void stroke(GraphicsContext g) {
        // 원의 외곽선 그리기
    }
    
    @Override
    public void fill(GraphicsContext g) {
        // 원 내부 채우기
    }
    
    @Override
    public void rotate(double angle) {
        // 원 회전 (원은 회전해도 같으므로 특별한 작업 불필요)
    }
}
```

### 3.2 인터페이스 상속

인터페이스도 다른 인터페이스를 확장할 수 있습니다:

```java
// 기본 인터페이스들
public interface Strokeable {
    void stroke(GraphicsContext g);
}

public interface Fillable {
    void fill(GraphicsContext g);
}

// 인터페이스 확장 (다중 상속 가능!)
public interface Drawable extends Strokeable, Fillable {
    void setColor(Color color);
}

// Drawable을 구현하면 세 메서드 모두 구현해야 함
public class Shape implements Drawable {
    private Color color;
    
    @Override
    public void stroke(GraphicsContext g) {
        // 외곽선 그리기
    }
    
    @Override
    public void fill(GraphicsContext g) {
        // 내부 채우기
    }
    
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
```

## 4. 인터페이스의 상수

### 4.1 상수 정의

인터페이스의 모든 변수는 자동으로 `public static final`입니다:

```java
public interface ConversionFactors {
    // 모두 public static final
    int INCHES_PER_FOOT = 12;
    int FEET_PER_YARD = 3;
    int YARDS_PER_MILE = 1760;
    
    double KILOMETERS_PER_MILE = 1.60934;
    double POUNDS_PER_KILOGRAM = 2.20462;
}

// 사용 예
public class Converter implements ConversionFactors {
    public double milesToKilometers(double miles) {
        return miles * KILOMETERS_PER_MILE;
    }
    
    public int feetToInches(int feet) {
        return feet * INCHES_PER_FOOT;
    }
}
```

## 5. 기본 메서드 (Default Methods)

### 5.1 Java 8의 새로운 기능

Java 8부터 인터페이스에 구현을 가진 메서드를 포함할 수 있습니다:

```java
public interface Readable {
    // 추상 메서드
    char readChar();
    
    // 기본 메서드 - 구현 제공
    default String readLine() {
        StringBuilder line = new StringBuilder();
        char ch = readChar();
        while (ch != '\n') {
            line.append(ch);
            ch = readChar();
        }
        return line.toString();
    }
    
    // 또 다른 기본 메서드
    default String readWord() {
        StringBuilder word = new StringBuilder();
        char ch = readChar();
        
        // 공백 문자 건너뛰기
        while (Character.isWhitespace(ch)) {
            ch = readChar();
        }
        
        // 단어 읽기
        while (!Character.isWhitespace(ch)) {
            word.append(ch);
            ch = readChar();
        }
        
        return word.toString();
    }
}
```

### 5.2 기본 메서드 활용 예제

```java
// Readable 인터페이스 구현
public class Stars implements Readable {
    @Override
    public char readChar() {
        // 98% 확률로 '*', 2% 확률로 줄바꿈
        if (Math.random() > 0.02) {
            return '*';
        } else {
            return '\n';
        }
    }
    
    // readLine()과 readWord()는 자동으로 상속받음
}

// 사용 예
public class TestStars {
    public static void main(String[] args) {
        Stars stars = new Stars();
        
        // 기본 메서드 사용
        for (int i = 0; i < 10; i++) {
            String line = stars.readLine();
            System.out.println(line);
        }
    }
}
```

### 5.3 기본 메서드 오버라이드

필요하면 기본 메서드를 재정의할 수 있습니다:

```java
public class FileReader implements Readable {
    private String content;
    private int position = 0;
    
    public FileReader(String content) {
        this.content = content;
    }
    
    @Override
    public char readChar() {
        if (position < content.length()) {
            return content.charAt(position++);
        }
        return '\0';  // 파일 끝
    }
    
    // 더 효율적인 readLine() 구현
    @Override
    public String readLine() {
        int start = position;
        int end = content.indexOf('\n', start);
        
        if (end == -1) {
            position = content.length();
            return content.substring(start);
        }
        
        position = end + 1;
        return content.substring(start, end);
    }
}
```

## 6. 타입으로서의 인터페이스

### 6.1 인터페이스 타입 변수

인터페이스를 타입으로 사용할 수 있습니다:

```java
// Strokeable 타입의 변수
Strokeable figure;

// 다양한 구현체 할당 가능
figure = new Line();
figure.stroke(g);  // Line의 stroke() 호출

figure = new Rectangle();
figure.stroke(g);  // Rectangle의 stroke() 호출

figure = new Circle();
figure.stroke(g);  // Circle의 stroke() 호출
```

### 6.2 인터페이스 타입 배열

```java
// Strokeable 객체들의 배열
Strokeable[] figures = new Strokeable[10];

// 다양한 도형 저장
figures[0] = new Line(0, 0, 100, 100);
figures[1] = new Rectangle(10, 10, 50, 30);
figures[2] = new Circle(50, 50, 25);

// 모든 도형 그리기
for (Strokeable fig : figures) {
    if (fig != null) {
        fig.stroke(g);  // 다형성!
    }
}
```

### 6.3 메서드 매개변수로 사용

```java
public class DrawingPanel {
    private List<Strokeable> shapes = new ArrayList<>();
    
    // Strokeable 인터페이스를 매개변수로 받음
    public void addShape(Strokeable shape) {
        shapes.add(shape);
    }
    
    // 모든 도형 그리기
    public void drawAll(GraphicsContext g) {
        for (Strokeable shape : shapes) {
            shape.stroke(g);
        }
    }
    
    // 특정 타입의 도형만 처리
    public void highlightCircles(Color highlightColor) {
        for (Strokeable shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                circle.setColor(highlightColor);
                circle.stroke(g);
            }
        }
    }
}
```

## 7. 실전 예제: 플러그인 시스템

```java
// 플러그인 인터페이스
public interface Plugin {
    String getName();
    String getVersion();
    void initialize();
    void execute();
    void shutdown();
}

// 기본 구현을 제공하는 추상 클래스
public abstract class AbstractPlugin implements Plugin {
    protected String name;
    protected String version;
    
    public AbstractPlugin(String name, String version) {
        this.name = name;
        this.version = version;
    }
    
    @Override
    public String getName() { return name; }
    
    @Override
    public String getVersion() { return version; }
    
    @Override
    public void initialize() {
        System.out.println(name + " 플러그인 초기화");
    }
    
    @Override
    public void shutdown() {
        System.out.println(name + " 플러그인 종료");
    }
}

// 구체적인 플러그인
public class SpellChecker extends AbstractPlugin {
    public SpellChecker() {
        super("맞춤법 검사기", "1.0");
    }
    
    @Override
    public void execute() {
        System.out.println("맞춤법 검사 실행중...");
        // 실제 맞춤법 검사 로직
    }
}

// 플러그인 관리자
public class PluginManager {
    private List<Plugin> plugins = new ArrayList<>();
    
    public void registerPlugin(Plugin plugin) {
        plugins.add(plugin);
        plugin.initialize();
    }
    
    public void executeAll() {
        for (Plugin plugin : plugins) {
            System.out.println("\n" + plugin.getName() + " 실행:");
            plugin.execute();
        }
    }
    
    public void shutdown() {
        for (Plugin plugin : plugins) {
            plugin.shutdown();
        }
    }
}
```

## 요약

### 인터페이스의 특징
1. **추상 메서드의 집합**: 구현 없이 선언만 존재
2. **다중 구현 가능**: 한 클래스가 여러 인터페이스 구현 가능
3. **타입으로 사용**: 변수, 매개변수, 반환 타입으로 사용
4. **상수 정의**: public static final 변수만 가능

### 인터페이스 vs 추상 클래스
| 특징 | 인터페이스 | 추상 클래스 |
|-----|----------|-----------|
| 다중 상속 | 가능 | 불가능 |
| 인스턴스 변수 | 불가능 | 가능 |
| 생성자 | 없음 | 있음 |
| 접근 제어자 | public만 | 모든 제어자 |
| 용도 | 계약 정의 | 공통 기능 제공 |

### 언제 인터페이스를 사용할까?
1. **다중 상속이 필요할 때**
2. **관련 없는 클래스들이 같은 기능을 가져야 할 때**
3. **특정 기능의 구현을 강제하고 싶을 때**
4. **다형성을 활용하고 싶을 때**

💡 **기억하세요**: 인터페이스는 "무엇을 할 수 있는가"를 정의하고, 클래스는 "어떻게 하는가"를 구현합니다!