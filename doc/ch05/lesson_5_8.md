# 5.8 중첩 클래스(Nested Classes) - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 중첩 클래스의 개념과 종류를 이해한다
- 정적 중첩 클래스와 내부 클래스의 차이를 안다
- 익명 내부 클래스를 활용할 수 있다
- 로컬 클래스와 람다 표현식을 사용할 수 있다
- 각 중첩 클래스의 적절한 사용 시기를 판단할 수 있다

## 1. 중첩 클래스란?

### 1.1 중첩 클래스의 정의

**중첩 클래스(Nested Class)**는 다른 클래스 내부에 정의된 클래스입니다.

```java
public class OuterClass {
    // 외부 클래스의 멤버들
    
    class InnerClass {
        // 중첩 클래스의 멤버들
    }
}
```

### 1.2 왜 중첩 클래스를 사용하는가?

1. **논리적 그룹화**: 서로 밀접하게 관련된 클래스들을 그룹화
2. **캡슐화 향상**: 중첩 클래스는 외부 클래스의 private 멤버에 접근 가능
3. **코드 가독성**: 작은 도우미 클래스를 외부 클래스 안에 포함
4. **유지보수성**: 관련 코드를 한 곳에 모아 관리

### 1.3 중첩 클래스의 종류

```
중첩 클래스
├── 정적 중첩 클래스 (Static Nested Class)
└── 내부 클래스 (Inner Class)
    ├── 일반 내부 클래스 (Member Inner Class)
    ├── 로컬 클래스 (Local Class)
    └── 익명 내부 클래스 (Anonymous Inner Class)
```

## 2. 정적 중첩 클래스 (Static Nested Class)

### 2.1 정의와 특징

정적 중첩 클래스는 `static` 키워드로 선언된 중첩 클래스입니다.

```java
public class OuterClass {
    private static int staticVar = 10;
    private int instanceVar = 20;
    
    static class StaticNestedClass {
        void display() {
            // 외부 클래스의 static 멤버에만 접근 가능
            System.out.println("Static var: " + staticVar);
            // System.out.println(instanceVar); // 오류! 인스턴스 멤버 접근 불가
        }
    }
}
```

### 2.2 사용 방법

```java
// 정적 중첩 클래스의 객체 생성
OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
nested.display();
```

### 2.3 실제 예제: WireFrameModel

```java
public class WireFrameModel {
    private List<Line> lines;
    
    public WireFrameModel() {
        this.lines = new ArrayList<>();
    }
    
    // 정적 중첩 클래스 - 3D 공간의 선을 표현
    public static class Line {
        private double x1, y1, z1;  // 시작점
        private double x2, y2, z2;  // 끝점
        
        public Line(double x1, double y1, double z1, 
                   double x2, double y2, double z2) {
            this.x1 = x1; this.y1 = y1; this.z1 = z1;
            this.x2 = x2; this.y2 = y2; this.z2 = z2;
        }
        
        public double getLength() {
            double dx = x2 - x1;
            double dy = y2 - y1;
            double dz = z2 - z1;
            return Math.sqrt(dx*dx + dy*dy + dz*dz);
        }
        
        @Override
        public String toString() {
            return String.format("Line[(%.2f,%.2f,%.2f) to (%.2f,%.2f,%.2f)]",
                                x1, y1, z1, x2, y2, z2);
        }
    }
    
    public void addLine(Line line) {
        lines.add(line);
    }
    
    public void addLine(double x1, double y1, double z1,
                       double x2, double y2, double z2) {
        lines.add(new Line(x1, y1, z1, x2, y2, z2));
    }
}

// 사용 예
public class Example {
    public static void main(String[] args) {
        WireFrameModel model = new WireFrameModel();
        
        // 외부에서 Line 클래스 사용
        WireFrameModel.Line line1 = new WireFrameModel.Line(0, 0, 0, 1, 1, 1);
        model.addLine(line1);
        
        // 직접 좌표로 추가
        model.addLine(1, 1, 1, 2, 0, 1);
        
        System.out.println("Line length: " + line1.getLength());
    }
}
```

## 3. 내부 클래스 (Inner Class)

### 3.1 일반 내부 클래스

내부 클래스는 외부 클래스의 인스턴스와 연결되어 있습니다.

```java
public class OuterClass {
    private int value = 10;
    
    class InnerClass {
        void display() {
            // 외부 클래스의 모든 멤버에 접근 가능
            System.out.println("Value: " + value);
        }
        
        void changeValue(int newValue) {
            // 외부 클래스의 멤버 수정 가능
            value = newValue;
        }
    }
    
    public void test() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}
```

### 3.2 실제 예제: PokerGame

```java
public class PokerGame {
    private Deck deck;
    private int pot;  // 베팅된 금액
    private List<Player> players;
    
    public PokerGame() {
        this.deck = new Deck();
        this.pot = 0;
        this.players = new ArrayList<>();
    }
    
    // 내부 클래스 - 게임의 플레이어
    class Player {
        private String name;
        private Hand hand;
        private int chips;
        private boolean folded;
        
        public Player(String name, int startingChips) {
            this.name = name;
            this.chips = startingChips;
            this.hand = new Hand();
            this.folded = false;
        }
        
        public void bet(int amount) {
            if (amount > chips) {
                throw new IllegalArgumentException("칩이 부족합니다!");
            }
            chips -= amount;
            pot += amount;  // 외부 클래스의 pot에 직접 접근
            System.out.println(name + "이(가) " + amount + " 베팅. 팟: " + pot);
        }
        
        public void drawCards(int count) {
            for (int i = 0; i < count; i++) {
                Card card = deck.dealCard();  // 외부 클래스의 deck 사용
                hand.addCard(card);
            }
        }
        
        public void fold() {
            folded = true;
            System.out.println(name + "이(가) 폴드했습니다.");
        }
        
        public boolean isActive() {
            return !folded && chips > 0;
        }
    }
    
    public void addPlayer(String name, int chips) {
        players.add(new Player(name, chips));
    }
    
    public void startNewRound() {
        deck.shuffle();
        pot = 0;
        
        // 각 플레이어에게 카드 분배
        for (Player player : players) {
            if (player.isActive()) {
                player.drawCards(5);
            }
        }
    }
}

// 사용 예
public class Example {
    public static void main(String[] args) {
        PokerGame game = new PokerGame();
        game.addPlayer("Alice", 1000);
        game.addPlayer("Bob", 1000);
        
        game.startNewRound();
        
        // 외부에서 Player 객체 생성 (드물게 사용)
        PokerGame.Player newPlayer = game.new Player("Charlie", 1500);
    }
}
```

## 4. 익명 내부 클래스 (Anonymous Inner Class)

### 4.1 기본 문법

익명 내부 클래스는 이름이 없는 클래스로, 선언과 동시에 객체를 생성합니다.

```java
// 인터페이스 기반
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("익명 클래스 실행!");
    }
};

// 클래스 기반
Thread t = new Thread() {
    @Override
    public void run() {
        System.out.println("익명 Thread 실행!");
    }
};
```

### 4.2 실제 예제: Drawable 인터페이스

```java
public interface Drawable {
    void draw(GraphicsContext g);
}

public class DrawingExample {
    public static void main(String[] args) {
        // 익명 클래스로 빨간 사각형 그리기
        Drawable redSquare = new Drawable() {
            @Override
            public void draw(GraphicsContext g) {
                g.setFill(Color.RED);
                g.fillRect(10, 10, 100, 100);
            }
        };
        
        // 익명 클래스로 파란 원 그리기
        Drawable blueCircle = new Drawable() {
            @Override
            public void draw(GraphicsContext g) {
                g.setFill(Color.BLUE);
                g.fillOval(50, 50, 80, 80);
            }
        };
        
        // 메서드 매개변수로 익명 클래스 전달
        drawTwice(g1, g2, new Drawable() {
            @Override
            public void draw(GraphicsContext g) {
                g.setStroke(Color.GREEN);
                g.strokeLine(0, 0, 100, 100);
            }
        });
    }
    
    static void drawTwice(GraphicsContext g1, GraphicsContext g2, Drawable figure) {
        figure.draw(g1);
        figure.draw(g2);
    }
}
```

### 4.3 이벤트 처리에서의 활용

```java
public class ButtonExample {
    public static void main(String[] args) {
        Button button = new Button("클릭하세요");
        
        // 익명 클래스로 이벤트 리스너 등록
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼이 클릭되었습니다!");
            }
        });
        
        // Java 8+ : 람다 표현식으로 간단히
        button.setOnAction(event -> System.out.println("버튼 클릭!"));
    }
}
```

## 5. 로컬 클래스 (Local Class)

### 5.1 메서드 내부의 클래스

로컬 클래스는 메서드 내부에 정의된 클래스입니다.

```java
public class Calculator {
    public IntOperation createAdder(final int increment) {
        // 로컬 클래스
        class Adder implements IntOperation {
            @Override
            public int operate(int x) {
                return x + increment;  // final 또는 effectively final 변수만 사용 가능
            }
        }
        
        return new Adder();
    }
    
    public IntOperation createMultiplier(final int factor) {
        // 익명 클래스 사용
        return new IntOperation() {
            @Override
            public int operate(int x) {
                return x * factor;
            }
        };
    }
}

interface IntOperation {
    int operate(int x);
}
```

### 5.2 람다 표현식과의 비교

```java
public class LambdaExample {
    public static void main(String[] args) {
        // 배열 생성: x를 i배 하는 함수들
        FunctionR2R[] multipliers = new FunctionR2R[10];
        
        // 람다 표현식 사용
        for (int i = 0; i < 10; i++) {
            final int n = i;  // effectively final
            multipliers[i] = x -> n * x;
        }
        
        // 익명 클래스 사용 (동일한 기능)
        for (int i = 0; i < 10; i++) {
            final int n = i;
            multipliers[i] = new FunctionR2R() {
                @Override
                public double valueAt(double x) {
                    return n * x;
                }
            };
        }
        
        // 사용
        System.out.println(multipliers[5].valueAt(10)); // 50.0
    }
}

interface FunctionR2R {
    double valueAt(double x);
}
```

## 6. 중첩 클래스 선택 가이드

### 6.1 언제 어떤 중첩 클래스를 사용할까?

| 상황 | 권장 클래스 종류 |
|-----|---------------|
| 외부 클래스의 인스턴스가 필요 없음 | 정적 중첩 클래스 |
| 외부 클래스의 인스턴스 멤버 접근 필요 | 내부 클래스 |
| 한 번만 사용하는 간단한 구현 | 익명 내부 클래스 |
| 메서드 내에서만 사용 | 로컬 클래스 |
| 함수형 인터페이스 구현 | 람다 표현식 |

### 6.2 실제 사용 예시

```java
public class DataProcessor {
    private List<Data> dataList = new ArrayList<>();
    
    // 정적 중첩 클래스: 독립적인 데이터 구조
    public static class Data {
        private String key;
        private int value;
        
        public Data(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // 내부 클래스: 외부 클래스의 데이터 처리
    public class DataIterator implements Iterator<Data> {
        private int index = 0;
        
        @Override
        public boolean hasNext() {
            return index < dataList.size();
        }
        
        @Override
        public Data next() {
            return dataList.get(index++);
        }
    }
    
    // 메서드에서 익명 클래스 사용
    public void sortByValue() {
        dataList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data d1, Data d2) {
                return Integer.compare(d1.value, d2.value);
            }
        });
        
        // 또는 람다 표현식
        dataList.sort((d1, d2) -> Integer.compare(d1.value, d2.value));
    }
}
```

## 7. 클래스 파일 생성

중첩 클래스를 컴파일하면 별도의 클래스 파일이 생성됩니다:

- 외부 클래스: `OuterClass.class`
- 정적 중첩 클래스: `OuterClass$StaticNested.class`
- 내부 클래스: `OuterClass$Inner.class`
- 익명 클래스: `OuterClass$1.class`, `OuterClass$2.class`, ...

## 요약

### 중첩 클래스의 특징 정리

1. **정적 중첩 클래스**:
   - 외부 클래스의 인스턴스와 무관
   - 외부 클래스의 static 멤버만 접근 가능
   - `OuterClass.StaticNested` 형태로 사용

2. **내부 클래스**:
   - 외부 클래스의 인스턴스와 연결
   - 외부 클래스의 모든 멤버 접근 가능
   - 외부 인스턴스 필요: `outer.new Inner()`

3. **익명 내부 클래스**:
   - 이름이 없는 일회용 클래스
   - 인터페이스나 클래스를 즉석에서 구현
   - 주로 이벤트 처리나 콜백에 사용

4. **로컬 클래스**:
   - 메서드 내부에 정의
   - final 또는 effectively final 변수만 접근
   - 메서드 내에서만 사용 가능

💡 **기억하세요**: 중첩 클래스는 관련 있는 클래스들을 논리적으로 그룹화하고, 캡슐화를 향상시키는 강력한 도구입니다!