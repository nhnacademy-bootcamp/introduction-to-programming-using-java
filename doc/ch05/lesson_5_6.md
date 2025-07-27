# 5.6 this와 super - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- this 키워드의 의미와 사용법을 이해한다
- super 키워드를 사용하여 부모 클래스의 멤버에 접근할 수 있다
- 생성자에서 this()와 super()를 적절히 사용할 수 있다
- 메서드 오버라이딩 시 super를 활용하여 기능을 확장할 수 있다

## 1. 특수 변수 this

### 1.1 this란?

**this의 정의**:
`this`는 현재 객체 자신을 가리키는 참조 변수입니다. 인스턴스 메서드나 생성자 내에서 자동으로 생성됩니다.

```java
public class Person {
    private String name;
    private int age;
    
    public void introduce() {
        // this는 이 메서드를 호출한 객체를 가리킴
        System.out.println("안녕하세요, 저는 " + this.name + "입니다.");
    }
}
```

### 1.2 this의 주요 용도

#### 1. 인스턴스 변수와 매개변수 구분

가장 흔한 사용 사례는 매개변수와 인스턴스 변수의 이름이 같을 때입니다:

```java
public class Student {
    private String name;
    private int grade;
    
    // 생성자에서 this 사용
    public Student(String name, int grade) {
        this.name = name;    // this.name은 인스턴스 변수
        this.grade = grade;  // grade는 매개변수
    }
    
    // setter 메서드에서도 동일하게 사용
    public void setName(String name) {
        this.name = name;
    }
}
```

#### 2. 현재 객체를 메서드의 인자로 전달

```java
public class Button {
    private EventHandler handler;
    
    public void click() {
        if (handler != null) {
            handler.handleEvent(this);  // 자기 자신을 매개변수로 전달
        }
    }
}
```

#### 3. 메서드 체이닝 구현

```java
public class StringBuilder {
    private String value = "";
    
    public StringBuilder append(String str) {
        value += str;
        return this;  // 자기 자신을 반환
    }
    
    public StringBuilder appendLine(String str) {
        value += str + "\n";
        return this;  // 메서드 체이닝 가능
    }
}

// 사용 예:
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("World").appendLine("!");
```

### 1.3 this 사용 시 주의사항

1. **정적 메서드에서는 사용 불가**:
```java
public class Example {
    private int value;
    
    public static void staticMethod() {
        // this.value = 10;  // 오류! 정적 메서드에서는 this 사용 불가
    }
}
```

2. **this는 final 변수**:
```java
public void method() {
    // this = new Object();  // 오류! this의 값은 변경할 수 없음
}
```

## 2. 특수 변수 super

### 2.1 super란?

**super의 정의**:
`super`는 현재 객체를 부모 클래스의 인스턴스로 취급하는 참조 변수입니다.

```java
public class Animal {
    protected String name = "동물";
    
    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

public class Dog extends Animal {
    protected String name = "개";  // 부모의 name을 숨김
    
    public void printNames() {
        System.out.println("this.name: " + this.name);    // "개"
        System.out.println("super.name: " + super.name);  // "동물"
    }
}
```

### 2.2 super의 주요 용도

#### 1. 부모 클래스의 숨겨진 멤버 접근

```java
public class Vehicle {
    protected int speed = 0;
    
    public void accelerate() {
        speed += 10;
        System.out.println("속도 증가: " + speed);
    }
}

public class Car extends Vehicle {
    protected int speed = 0;  // 부모의 speed를 숨김
    
    public void turboAccelerate() {
        super.accelerate();     // 부모의 메서드 호출
        super.speed += 20;      // 부모의 speed 변수에 접근
        this.speed = super.speed;  // 동기화
    }
}
```

#### 2. 오버라이드된 메서드 호출

**메서드 확장 패턴**:
```java
public class Shape {
    protected String color = "검정";
    
    public void draw() {
        System.out.println(color + "색으로 도형을 그립니다.");
    }
}

public class Circle extends Shape {
    private double radius;
    
    @Override
    public void draw() {
        super.draw();  // 부모의 draw() 먼저 실행
        System.out.println("반지름 " + radius + "의 원입니다.");
    }
}
```

### 2.3 실전 예제: GraphicalDice

```java
public class PairOfDice {
    protected int die1;
    protected int die2;
    
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
        System.out.println("주사위 굴림: " + die1 + ", " + die2);
    }
}

public class GraphicalDice extends PairOfDice {
    private Graphics graphics;
    
    @Override
    public void roll() {
        super.roll();  // 부모의 roll() 기능을 그대로 사용
        redraw();      // 추가 기능: 화면에 다시 그리기
    }
    
    private void redraw() {
        // 그래픽으로 주사위를 다시 그리는 코드
        System.out.println("주사위를 화면에 다시 그립니다.");
    }
}
```

## 3. 생성자에서 this()와 super() 사용

### 3.1 super() - 부모 생성자 호출

**기본 규칙**:
- 생성자의 첫 번째 문장이어야 함
- 명시하지 않으면 super()가 자동 호출됨

```java
public class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Student extends Person {
    private String school;
    
    public Student(String name, int age, String school) {
        super(name, age);  // 부모 생성자 호출 (반드시 첫 줄)
        this.school = school;
    }
    
    // super() 자동 호출 예
    public Student() {
        // super();  // 컴파일러가 자동으로 추가
        this.school = "미정";
    }
}
```

### 3.2 this() - 같은 클래스의 다른 생성자 호출

**생성자 오버로딩과 재사용**:
```java
public class Rectangle {
    private int width;
    private int height;
    private String color;
    
    // 메인 생성자
    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
        System.out.println("사각형 생성: " + width + "x" + height + ", " + color);
    }
    
    // 색상 기본값 제공
    public Rectangle(int width, int height) {
        this(width, height, "검정");  // 메인 생성자 호출
    }
    
    // 정사각형용 생성자
    public Rectangle(int size) {
        this(size, size);  // 위의 생성자 호출
    }
    
    // 기본 생성자
    public Rectangle() {
        this(1);  // 크기 1의 정사각형
    }
}
```

### 3.3 복잡한 생성자 체인

```java
public class Employee extends Person {
    private String department;
    private double salary;
    
    // 완전한 생성자
    public Employee(String name, int age, String department, double salary) {
        super(name, age);  // 부모 생성자 호출
        this.department = department;
        this.salary = salary;
    }
    
    // 부서만 지정
    public Employee(String name, int age, String department) {
        this(name, age, department, 30000);  // 기본 급여
    }
    
    // 이름과 나이만 지정
    public Employee(String name, int age) {
        this(name, age, "미정");  // 기본 부서
    }
}
```

## 4. 실전 예제: MosaicCanvas

```java
public class MosaicCanvas {
    private int rows;
    private int columns;
    private int blockWidth;
    private int blockHeight;
    private Color[][] colors;
    
    // 완전한 생성자 (메인)
    public MosaicCanvas(int rows, int columns, 
                       int blockWidth, int blockHeight) {
        this.rows = rows;
        this.columns = columns;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        this.colors = new Color[rows][columns];
        initializeColors();
        System.out.println("캔버스 생성: " + rows + "x" + columns);
    }
    
    // 블록 크기 기본값 사용
    public MosaicCanvas(int rows, int columns) {
        this(rows, columns, 16, 16);  // 기본 블록 크기
    }
    
    // 모든 기본값 사용
    public MosaicCanvas() {
        this(42, 42);  // 기본 크기
    }
    
    private void initializeColors() {
        // 모든 블록을 흰색으로 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                colors[i][j] = Color.WHITE;
            }
        }
    }
}
```

## 요약

### this 키워드
- **현재 객체 자신**을 가리키는 참조
- 주요 용도:
  - 매개변수와 인스턴스 변수 구분
  - 현재 객체를 매개변수로 전달
  - 메서드 체이닝
  - 생성자에서 다른 생성자 호출

### super 키워드
- **부모 클래스의 관점**에서 현재 객체를 가리키는 참조
- 주요 용도:
  - 숨겨진 부모 클래스 멤버 접근
  - 오버라이드된 메서드 호출
  - 부모 클래스 생성자 호출

### 생성자 호출 규칙
1. `super()` 또는 `this()`는 생성자의 **첫 번째 문장**이어야 함
2. 둘 중 하나만 사용 가능
3. 명시하지 않으면 `super()`가 자동 호출됨

💡 **기억하세요**: `this`와 `super`는 객체지향 프로그래밍에서 상속과 캡슐화를 효과적으로 구현하는 핵심 도구입니다!