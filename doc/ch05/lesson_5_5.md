# 5.5 상속, 다형성, 추상 클래스 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 상속의 개념을 이해하고 기존 클래스를 확장할 수 있다
- 클래스 계층 구조를 설계하고 구현할 수 있다
- 다형성의 원리를 이해하고 활용할 수 있다
- 추상 클래스와 추상 메서드를 적절히 사용할 수 있다
- final 수식어의 의미와 용도를 안다

## 1. 상속(Inheritance)의 기본 개념

### 1.1 상속이란?

**상속의 정의**:
상속은 한 클래스가 다른 클래스의 속성과 메서드를 물려받는 객체지향 프로그래밍의 핵심 개념입니다.

```java
// 기본 문법
public class 서브클래스 extends 슈퍼클래스 {
    // 추가 또는 수정할 내용
}
```

**핵심 용어**:
- **슈퍼클래스(부모 클래스)**: 상속을 제공하는 클래스
- **서브클래스(자식 클래스)**: 상속을 받는 클래스
- **extends**: 상속을 나타내는 Java 키워드

### 1.2 상속의 장점

1. **코드 재사용성**: 기존 코드를 다시 작성할 필요 없음
2. **확장성**: 기존 기능에 새로운 기능 추가 가능
3. **유지보수성**: 공통 코드를 한 곳에서 관리
4. **다형성 구현**: 하나의 인터페이스로 여러 구현 가능

## 2. 기존 클래스 확장하기

### 2.1 BlackjackHand 예제

일반 Hand 클래스를 확장하여 블랙잭 게임용 손패 만들기:

```java
public class BlackjackHand extends Hand {
    
    /**
     * 블랙잭 게임에서 이 손패의 값을 계산
     * 규칙:
     * - 숫자 카드: 액면가
     * - J, Q, K: 10
     * - A: 1 또는 11 (21을 넘지 않는 선에서 11)
     */
    public int getBlackjackValue() {
        int val = 0;      // 손패의 값
        boolean ace = false;  // 에이스 보유 여부
        int cards = getCardCount();  // Hand 클래스에서 상속받은 메서드
        
        for (int i = 0; i < cards; i++) {
            Card card = getCard(i);  // Hand 클래스에서 상속받은 메서드
            int cardVal = card.getValue();
            
            if (cardVal > 10) {
                cardVal = 10;  // J, Q, K는 10으로 계산
            }
            if (cardVal == 1) {
                ace = true;    // 에이스 발견
            }
            val = val + cardVal;
        }
        
        // 에이스가 있고, 11로 계산해도 21을 넘지 않으면
        if (ace == true && val + 10 <= 21) {
            val = val + 10;
        }
        
        return val;
    }
}
```

**상속의 특징**:
- `BlackjackHand`는 `Hand`의 모든 기능을 가짐
- 새로운 메서드 `getBlackjackValue()` 추가
- 부모 클래스의 메서드를 자유롭게 사용

### 2.2 접근 제어자와 상속

```java
public class Parent {
    private int privateVar;      // 서브클래스에서 접근 불가
    protected int protectedVar;  // 서브클래스에서 접근 가능
    public int publicVar;        // 어디서든 접근 가능
    int packageVar;              // 같은 패키지에서만 접근 가능
}

public class Child extends Parent {
    public void method() {
        // privateVar = 10;     // 오류! private은 접근 불가
        protectedVar = 20;      // OK! protected는 서브클래스에서 접근 가능
        publicVar = 30;         // OK! public은 어디서든 접근 가능
    }
}
```

## 3. 클래스 계층 구조

### 3.1 Vehicle 예제

차량 관리 시스템의 클래스 계층 구조:

```java
// 슈퍼클래스: 모든 차량의 공통 속성
class Vehicle {
    int registrationNumber;
    Person owner;
    
    void transferOwnership(Person newOwner) {
        owner = newOwner;
    }
}

// 서브클래스들: 각 차량 유형의 특수 속성
class Car extends Vehicle {
    int numberOfDoors;
    
    void openTrunk() {
        System.out.println("트렁크를 엽니다.");
    }
}

class Truck extends Vehicle {
    int numberOfAxles;
    double maxLoadWeight;
    
    void loadCargo(double weight) {
        if (weight <= maxLoadWeight) {
            System.out.println("화물을 적재합니다.");
        }
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;
    
    void doWheelie() {
        System.out.println("앞바퀴를 들어올립니다!");
    }
}
```

### 3.2 객체 타입과 형변환

```java
// 업캐스팅: 서브클래스 → 슈퍼클래스 (자동)
Car myCar = new Car();
Vehicle myVehicle = myCar;  // OK! Car는 Vehicle이다

// 다운캐스팅: 슈퍼클래스 → 서브클래스 (명시적)
Vehicle someVehicle = new Car();
Car specificCar = (Car) someVehicle;  // 명시적 캐스팅 필요

// instanceof로 타입 확인
if (myVehicle instanceof Car) {
    Car car = (Car) myVehicle;
    System.out.println("문 개수: " + car.numberOfDoors);
}
```

### 3.3 Java 17의 패턴 매칭

```java
// 기존 방식
if (myVehicle instanceof Car) {
    Car car = (Car) myVehicle;
    System.out.println("문 개수: " + car.numberOfDoors);
}

// Java 17 패턴 매칭 (더 간결!)
if (myVehicle instanceof Car car) {
    System.out.println("문 개수: " + car.numberOfDoors);
}
```

## 4. 다형성(Polymorphism)

### 4.1 다형성이란?

다형성은 같은 메시지(메서드 호출)에 대해 객체가 각자의 방식으로 응답하는 능력입니다.

### 4.2 Shape 예제

```java
// 추상적인 도형 클래스
class Shape {
    Color color;
    
    void setColor(Color newColor) {
        color = newColor;
        redraw();  // 다형성 발생!
    }
    
    void redraw() {
        // 기본 구현 (또는 추상 메서드)
    }
}

// 구체적인 도형 클래스들
class Rectangle extends Shape {
    @Override
    void redraw() {
        System.out.println("사각형을 그립니다.");
        // 사각형 그리기 코드
    }
}

class Circle extends Shape {
    @Override
    void redraw() {
        System.out.println("원을 그립니다.");
        // 원 그리기 코드
    }
}

class Triangle extends Shape {
    @Override
    void redraw() {
        System.out.println("삼각형을 그립니다.");
        // 삼각형 그리기 코드
    }
}
```

### 4.3 다형성의 활용

```java
// 다형성을 활용한 도형 관리
public class ShapeManager {
    private Shape[] shapes = new Shape[100];
    private int count = 0;
    
    // 모든 종류의 도형을 추가할 수 있음
    public void addShape(Shape shape) {
        shapes[count++] = shape;
    }
    
    // 모든 도형을 그리기 - 각 도형은 자신만의 방식으로 그려짐
    public void drawAllShapes() {
        for (int i = 0; i < count; i++) {
            shapes[i].redraw();  // 다형성!
        }
    }
    
    // 모든 도형의 색상 변경
    public void changeAllColors(Color newColor) {
        for (int i = 0; i < count; i++) {
            shapes[i].setColor(newColor);
        }
    }
}

// 사용 예
ShapeManager manager = new ShapeManager();
manager.addShape(new Rectangle());
manager.addShape(new Circle());
manager.addShape(new Triangle());

manager.drawAllShapes();  // 각각 다른 방식으로 그려짐!
```

### 4.4 다형성의 장점

1. **확장성**: 새로운 도형 클래스를 추가해도 기존 코드 수정 불필요
2. **유연성**: 실행 시점에 동작이 결정됨
3. **코드 재사용**: 공통 인터페이스로 다양한 객체 처리

## 5. 추상 클래스(Abstract Classes)

### 5.1 추상 클래스란?

추상 클래스는 직접 객체를 생성할 수 없고, 오직 서브클래스를 만들기 위한 템플릿 역할을 합니다.

```java
// 추상 클래스 정의
public abstract class Animal {
    protected String name;
    
    // 일반 메서드
    public void sleep() {
        System.out.println(name + "이(가) 잠을 잡니다.");
    }
    
    // 추상 메서드 - 서브클래스에서 반드시 구현해야 함
    public abstract void makeSound();
    public abstract void move();
}

// 구체 클래스들
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }
    
    @Override
    public void move() {
        System.out.println("네 발로 뛰어다닙니다.");
    }
}

public class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("짹짹!");
    }
    
    @Override
    public void move() {
        System.out.println("날개로 날아다닙니다.");
    }
}
```

### 5.2 Shape 추상 클래스 완전한 예제

```java
public abstract class Shape {
    protected Color color;
    protected int x, y;  // 위치
    
    // 일반 메서드
    public void setColor(Color newColor) {
        color = newColor;
        redraw();
    }
    
    public void moveTo(int newX, int newY) {
        x = newX;
        y = newY;
        redraw();
    }
    
    // 추상 메서드들 - 서브클래스에서 구현
    public abstract void redraw();
    public abstract double getArea();
    public abstract double getPerimeter();
}

// 구체적인 도형 클래스
public class Rectangle extends Shape {
    private int width, height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void redraw() {
        System.out.println("사각형 그리기: " + width + "x" + height);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void redraw() {
        System.out.println("원 그리기: 반지름 " + radius);
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

### 5.3 추상 클래스의 특징

1. **객체 생성 불가**: `new Shape()` ❌
2. **참조 변수는 가능**: `Shape shape = new Circle(5);` ✅
3. **추상 메서드**: 구현 없이 선언만 있음
4. **일반 메서드**: 구현을 가질 수 있음
5. **상속 강제**: 서브클래스는 모든 추상 메서드를 구현해야 함

## 6. Object 클래스

### 6.1 모든 클래스의 조상

Java의 모든 클래스는 자동으로 Object 클래스를 상속받습니다.

```java
// 다음 두 선언은 동일
public class MyClass { }
public class MyClass extends Object { }
```

### 6.2 Object 클래스의 주요 메서드

```java
public class Student {
    private String name;
    private int id;
    
    // toString() 오버라이드
    @Override
    public String toString() {
        return "Student[name=" + name + ", id=" + id + "]";
    }
    
    // equals() 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return id == student.id && name.equals(student.name);
    }
    
    // hashCode() 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
```

## 7. Final 메서드와 클래스

### 7.1 final 키워드의 용도

```java
// final 클래스 - 상속 불가
public final class String {
    // String 클래스는 확장할 수 없음
}

// final 메서드 - 오버라이드 불가
public class Parent {
    public final void importantMethod() {
        // 이 메서드는 서브클래스에서 변경할 수 없음
    }
}

// final 변수 - 값 변경 불가
public class Constants {
    public static final double PI = 3.14159;
    public final int id;
    
    public Constants(int id) {
        this.id = id;  // 생성자에서 한 번만 초기화 가능
    }
}
```

### 7.2 final 사용 시 고려사항

1. **보안성**: 중요한 동작이 변경되지 않도록 보장
2. **성능**: 컴파일러 최적화 가능
3. **설계 의도**: 확장을 막아야 하는 명확한 이유가 있을 때만 사용

## 실전 예제: 도형 그리기 시스템

```java
// 완전한 도형 시스템 구현
public abstract class Shape {
    protected Color color = Color.BLACK;
    protected boolean filled = false;
    
    public Shape() { }
    
    public Shape(Color color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    // getter와 setter
    public Color getColor() { return color; }
    public void setColor(Color color) { 
        this.color = color; 
        redraw();
    }
    
    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { 
        this.filled = filled;
        redraw();
    }
    
    // 추상 메서드
    public abstract void draw(Graphics g);
    public abstract void redraw();
    public abstract boolean contains(int x, int y);
}

// 구체적인 도형들
public class Rectangle extends Shape {
    private int x, y, width, height;
    
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (filled) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }
    }
    
    @Override
    public void redraw() {
        // 화면 갱신 로직
    }
    
    @Override
    public boolean contains(int px, int py) {
        return px >= x && px <= x + width && 
               py >= y && py <= y + height;
    }
}

// 도형 관리자
public class DrawingPanel {
    private List<Shape> shapes = new ArrayList<>();
    
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }
    
    public void removeShape(Shape shape) {
        shapes.remove(shape);
        repaint();
    }
    
    public void drawAll(Graphics g) {
        for (Shape shape : shapes) {
            shape.draw(g);  // 다형성!
        }
    }
    
    public Shape getShapeAt(int x, int y) {
        // 뒤에서부터 검색 (위에 있는 도형 우선)
        for (int i = shapes.size() - 1; i >= 0; i--) {
            Shape shape = shapes.get(i);
            if (shape.contains(x, y)) {
                return shape;
            }
        }
        return null;
    }
}
```

## 요약

### 핵심 개념

**상속(Inheritance)**:
- 기존 클래스의 기능을 확장하거나 수정
- 코드 재사용과 계층 구조 표현
- `extends` 키워드 사용

**다형성(Polymorphism)**:
- 하나의 인터페이스로 여러 구현체 사용
- 실행 시점에 실제 메서드 결정
- 확장성과 유연성 제공

**추상 클래스(Abstract Class)**:
- 직접 인스턴스화할 수 없는 클래스
- 공통 인터페이스와 부분 구현 제공
- 서브클래스에서 추상 메서드 구현 강제

**final 수식어**:
- 클래스: 상속 불가
- 메서드: 오버라이드 불가
- 변수: 값 변경 불가

### 설계 원칙

1. **IS-A 관계**: 상속은 "~이다" 관계일 때 사용
2. **리스코프 치환 원칙**: 서브클래스는 슈퍼클래스를 대체할 수 있어야 함
3. **추상화 수준**: 공통 기능은 상위 클래스로, 특수 기능은 하위 클래스로

💡 **기억하세요**: 상속과 다형성은 객체지향 프로그래밍의 핵심입니다. 적절히 사용하면 유연하고 확장 가능한 프로그램을 만들 수 있습니다!