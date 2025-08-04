# 5.6 this와 super - 수업 실습

## 1. this 키워드 기본 예제

### 실습 1-1: this를 사용한 변수 구분
**목표**: this 키워드를 사용하여 매개변수와 인스턴스 변수를 구분하는 방법을 익혀보세요.

```java
/**
 * this를 사용하여 매개변수와 인스턴스 변수를 구분하는 예제
 */
public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    
    // 생성자에서 this 사용
    public Book(String title, String author, int pages, double price) {
        // TODO 1: this를 사용하여 매개변수와 인스턴스 변수 구분하기
        // 매개변수 title을 인스턴스 변수 title에 할당
        // 매개변수 author를 인스턴스 변수 author에 할당
        // 매개변수 pages를 인스턴스 변수 pages에 할당
        // 매개변수 price를 인스턴스 변수 price에 할당
    }
    
    // setter 메서드에서 this 사용
    public void setTitle(String title) {
        // TODO 2: this를 사용하여 title 설정하기
    }
    
    public void setPrice(double price) {
        // TODO 3: price가 0보다 크면 this.price에 설정하기
    }
    
    // this 없이도 가능한 경우 (이름이 다를 때)
    public void updatePrice(double newPrice) {
        price = newPrice;  // this.price와 동일
    }
    
    @Override
    public String toString() {
        // TODO 4: "책: [제목] (저자: [저자])" 형식으로 반환하기
        // this를 사용하여 인스턴스 변수에 접근
        return "";
    }
}

// 테스트
public class ThisExample1 {
    public static void main(String[] args) {
        // TODO 5: Book 객체 생성하고 출력하기
        // 제목: "자바의 정석", 저자: "남궁성", 페이지: 1000, 가격: 30000
        
        // TODO 6: 제목을 "이펙티브 자바"로, 가격을 45000으로 변경하고 출력하기
    }
}

#### 실행 결과 (참고용):
```
책: 자바의 정석 (저자: 남궁성)
책: 이펙티브 자바 (저자: 남궁성)
```
```

### 실습 1-2: this를 사용한 메서드 체이닝
**목표**: this를 반환하여 메서드 체이닝을 구현하는 방법을 익혀보세요.

```java
/**
 * 메서드 체이닝을 구현하는 StringBuilder 스타일 클래스
 */
public class MessageBuilder {
    private StringBuilder message;
    
    public MessageBuilder() {
        this.message = new StringBuilder();
    }
    
    public MessageBuilder append(String text) {
        // TODO 7: message에 text를 추가하고 this를 반환하기
        // 메서드 체이닝을 위해 자기 자신을 반환
    }
    
    public MessageBuilder appendLine(String text) {
        // TODO 8: message에 text와 줄바꿈 문자를 추가하고 this를 반환하기
    }
    
    public MessageBuilder appendWithSpace(String text) {
        // TODO 9: message가 비어있지 않으면 공백 추가 후 text 추가하기
        // this를 반환하여 체이닝 가능하게 하기
    }
    
    public MessageBuilder reset() {
        // TODO 10: message를 비우고 this를 반환하기
    }
    
    @Override
    public String toString() {
        return message.toString();
    }
}

// 테스트
public class ChainingExample {
    public static void main(String[] args) {
        // TODO 11: MessageBuilder 객체 생성하기
        
        // TODO 12: 메서드 체이닝을 사용하여 문자열 구성하기
        // "안녕하세요 여러분!\n오늘은 좋은 날씨입니다."
        // append(), appendWithSpace(), appendLine() 활용
        
        // TODO 13: 리셋 후 다시 사용하기
        // "메서드 체이닝은 편리합니다!"
    }
}

#### 실행 결과 (참고용):
```
안녕하세요 여러분!
오늘은 좋은 날씨입니다.
메서드 체이닝은 편리합니다!
```
```

### 실습 1-3: this를 매개변수로 전달
**목표**: this를 다른 객체에 전달하는 방법을 익혀보세요.

```java
/**
 * this를 다른 객체에 전달하는 예제
 */
// 이벤트 리스너 인터페이스
interface ClickListener {
    void onClick(Button source);
}

// 버튼 클래스
class Button {
    private String label;
    private ClickListener listener;
    
    public Button(String label) {
        this.label = label;
    }
    
    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }
    
    public void click() {
        System.out.println(label + " 버튼이 클릭되었습니다.");
        // TODO 14: listener가 null이 아니면 onClick 호출하기
        // this를 매개변수로 전달
    }
    
    public String getLabel() {
        return label;
    }
}

// 애플리케이션 클래스
class Application implements ClickListener {
    private Button saveButton;
    private Button cancelButton;
    
    public Application() {
        // TODO 15: 버튼들 생성하기
        // saveButton: "저장"
        // cancelButton: "취소"
        
        // TODO 16: 리스너 등록하기
        // this를 리스너로 등록
    }
    
    @Override
    public void onClick(Button source) {
        // TODO 17: source가 어떤 버튼인지 확인하고 처리하기
        // saveButton: "저장 작업을 수행합니다." 출력
        // cancelButton: "작업을 취소합니다." 출력
    }
    
    public void run() {
        // TODO 65-1: 버튼들 클릭하기
        // saveButton.click()
        // cancelButton.click()
    }
}

// 테스트
public class ThisAsParameterExample {
    public static void main(String[] args) {
        // TODO 18: Application 객체 생성하고 run() 호출하기
    }
}

#### 실행 결과 (참고용):
```
저장 버튼이 클릭되었습니다.
저장 작업을 수행합니다.
취소 버튼이 클릭되었습니다.
작업을 취소합니다.
```
```

## 2. super 키워드 기본 예제

### 실습 2-1: super로 부모 멤버 접근
**목표**: super를 사용하여 숨겨진 부모 클래스 멤버에 접근하는 방법을 익혀보세요.

```java
/**
 * super를 사용하여 숨겨진 부모 클래스 멤버에 접근하는 예제
 */
class Vehicle {
    protected String model = "일반 차량";
    protected int maxSpeed = 100;
    
    public void displayInfo() {
        System.out.println("차량 모델: " + model);
        System.out.println("최고 속도: " + maxSpeed + "km/h");
    }
    
    public void honk() {
        System.out.println("빵빵!");
    }
}

class SportsCar extends Vehicle {
    protected String model = "스포츠카";  // 부모의 model을 숨김
    private boolean turboMode = false;
    
    public SportsCar() {
        // TODO 19: 부모 클래스의 maxSpeed를 250으로 설정하기
        // super를 사용하여 부모의 필드에 접근
    }
    
    public void displayAllInfo() {
        System.out.println("=== 전체 정보 ===");
        // TODO 20: this.model과 super.model의 차이 출력하기
        // this.model: 자신의 model 필드
        // super.model: 부모의 model 필드
        // super.maxSpeed와 turboMode도 출력
    }
    
    @Override
    public void honk() {
        // TODO 21: 부모의 honk() 호출 후 추가 동작 수행하기
        // super.honk() 호출
        // "부웉!!" 출력
    }
}

// 테스트
public class SuperAccessExample {
    public static void main(String[] args) {
        // TODO 22: SportsCar 객체 생성하고 메서드들 호출하기
        // displayInfo() 호출 (부모의 메서드)
        // displayAllInfo() 호출
        // honk() 호출
    }
}

#### 실행 결과 (참고용):
```
차량 모델: 일반 차량
최고 속도: 250km/h

=== 전체 정보 ===
this.model: 스포츠카
super.model: 일반 차량
최고 속도: 250
터보 모드: false

빵빵!
부웉!!
```
```

### 실습 2-2: super로 메서드 확장
**목표**: 부모 클래스의 기능을 확장하는 방법을 익혀보세요.

```java
/**
 * 부모 클래스의 기능을 확장하는 예제
 */
class Employee {
    protected String name;
    protected double baseSalary;
    
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public double calculateSalary() {
        return baseSalary;
    }
    
    public void printPaySlip() {
        System.out.println("=== 급여 명세서 ===");
        System.out.println("직원명: " + name);
        System.out.println("기본급: " + baseSalary);
        System.out.println("총 급여: " + calculateSalary());
    }
}

class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }
    
    @Override
    public double calculateSalary() {
        // TODO 23: 부모의 급여 계산 결과에 bonus를 더하기
        // super.calculateSalary() 호출
        return 0;
    }
    
    @Override
    public void printPaySlip() {
        // TODO 24: 부모의 printPaySlip() 호출 후 추가 정보 출력하기
        // super.printPaySlip() 호출
        // "보너스: [bonus]" 출력
        // "=================" 출력
    }
}

class Developer extends Employee {
    private double overtimePay;
    private int overtimeHours;
    
    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
        this.overtimePay = 30000;  // 시간당 야근 수당
    }
    
    public void setOvertimeHours(int hours) {
        this.overtimeHours = hours;
    }
    
    @Override
    public double calculateSalary() {
        // TODO 25: 부모의 급여 계산 결과에 야근 수당 더하기
        // super.calculateSalary() + (overtimeHours * overtimePay)
        return 0;
    }
    
    @Override
    public void printPaySlip() {
        // TODO 26: 부모의 printPaySlip() 호출 후 야근 정보 출력하기
        // super.printPaySlip() 호출
        // "야근 시간: [overtimeHours]시간" 출력
        // "야근 수당: [overtimeHours * overtimePay]" 출력
        // "=================" 출력
    }
}

// 테스트
public class MethodExtensionExample {
    public static void main(String[] args) {
        // TODO 27: 세 타입의 직원 객체 생성하기
        // Employee: "김직원", 2500000
        // Manager: "이과장", 3500000, 1000000 (보너스)
        // Developer: "박개발", 3000000
        
        // TODO 28: 개발자의 야근 시간 20시간으로 설정하기
        
        // TODO 29: 각 직원의 급여 명세서 출력하기
    }
}

#### 실행 결과 (참고용):
```
일반 직원:
=== 급여 명세서 ===
직원명: 김직원
기본급: 2500000.0
총 급여: 2500000.0

관리자:
=== 급여 명세서 ===
직원명: 이과장
기본급: 3500000.0
총 급여: 4500000.0
보너스: 1000000.0
=================

개발자:
=== 급여 명세서 ===
직원명: 박개발
기본급: 3000000.0
총 급여: 3600000.0
야근 시간: 20시간
야근 수당: 600000.0
=================
```
```

## 3. 생성자에서 this()와 super() 사용

### 실습 3-1: this()를 사용한 생성자 오버로딩
**목표**: this()를 사용하여 생성자를 효율적으로 구현하는 방법을 익혀보세요.

```java
/**
 * 다양한 생성자를 제공하는 날짜 클래스
 */
public class SimpleDate {
    private int year;
    private int month;
    private int day;
    
    // 완전한 생성자
    public SimpleDate(int year, int month, int day) {
        // TODO 30: year, month, day 초기화하기
        // "날짜 생성: " + this 출력
    }
    
    // 년, 월만 지정 (일은 1일로)
    public SimpleDate(int year, int month) {
        // TODO 31: this()를 사용하여 완전한 생성자 호출하기
        // day는 1로 설정
    }
    
    // 년만 지정 (1월 1일로)
    public SimpleDate(int year) {
        // TODO 32: this()를 사용하여 다른 생성자 호출하기
        // month는 1로 설정
    }
    
    // 오늘 날짜로 생성
    public SimpleDate() {
        // TODO 33: this()를 사용하여 기본 날짜(2024, 1, 20) 설정하기
    }
    
    @Override
    public String toString() {
        // TODO 34: "[year]년 [month]월 [day]일" 형식으로 반환하기
        return "";
    }
}

// 테스트
public class ConstructorChainingExample {
    public static void main(String[] args) {
        // TODO 35: 다양한 생성자를 사용하여 SimpleDate 객체 생성하기
        // date1: 2024년 12월 25일
        // date2: 2024년 3월 1일
        // date3: 2024년 1월 1일
        // date4: 2024년 1월 20일
        
        // TODO 36: 생성된 날짜들 출력하기
    }
}

#### 실행 결과 (참고용):
```
날짜 생성: 2024년 12월 25일
날짜 생성: 2024년 3월 1일
날짜 생성: 2024년 1월 1일
날짜 생성: 2024년 1월 20일

생성된 날짜들:
date1: 2024년 12월 25일
date2: 2024년 3월 1일
date3: 2024년 1월 1일
date4: 2024년 1월 20일
```
```

### 실습 3-2: super()를 사용한 상속 생성자
**목표**: super()를 사용하여 부모 클래스의 생성자를 호출하는 방법을 익혀보세요.

```java
/**
 * 도형 클래스 계층구조에서 생성자 사용
 */
abstract class Shape {
    protected String color;
    protected boolean filled;
    
    // Shape의 생성자
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        System.out.println("Shape 생성자 호출");
    }
    
    public Shape(String color) {
        this(color, false);  // 다른 생성자 호출
    }
    
    public Shape() {
        this("검정");  // 기본값
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    // Rectangle의 완전한 생성자
    public Rectangle(double width, double height, String color, boolean filled) {
        // TODO 37: super()를 사용하여 부모 생성자 호출하기
        // color와 filled를 부모 생성자에 전달
        // width와 height 초기화
        // "Rectangle 생성자 호출" 출력
    }
    
    // 크기와 색상만 지정
    public Rectangle(double width, double height, String color) {
        // TODO 38: this()를 사용하여 완전한 생성자 호출하기
        // filled는 false로 설정
    }
    
    // 크기만 지정
    public Rectangle(double width, double height) {
        // TODO 39: super()를 사용하여 기본 Shape 생성자 호출하기
        // width와 height 초기화
        // "Rectangle 생성자 호출" 출력
    }
    
    @Override
    public String toString() {
        // TODO 40: "[color] 사각형 ([width] x [height])[채움 여부]" 형식으로 반환하기
        // filled가 true이면 " [채움]" 추가
        return "";
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius, String color, boolean filled) {
        // TODO 41: super()를 사용하여 부모 생성자 호출하기
        // radius 초기화
        // "Circle 생성자 호출" 출력
    }
    
    public Circle(double radius) {
        // TODO 42: this()를 사용하여 완전한 생성자 호출하기
        // 기본값: "빨강", true
    }
    
    @Override
    public String toString() {
        // TODO 43: "[color] 원 (반지름: [radius])[채움 여부]" 형식으로 반환하기
        return "";
    }
}

// 테스트
public class InheritanceConstructorExample {
    public static void main(String[] args) {
        // TODO 44: 다양한 생성자로 도형 객체 생성하기
        // Rectangle: 10, 5, "파랑", true
        // Rectangle: 7, 3 (기본 색상)
        // Circle: 5 (기본 설정)
        
        // TODO 45: 생성된 도형 정보 출력하기
    }
}

#### 실행 결과 (참고용):
```
=== Rectangle 생성 ===
Shape 생성자 호출
Rectangle 생성자 호출
파랑 사각형 (10.0 x 5.0) [채움]

=== Rectangle 생성 (크기만) ===
Shape 생성자 호출
Rectangle 생성자 호출
검정 사각형 (7.0 x 3.0)

=== Circle 생성 ===
Shape 생성자 호출
Circle 생성자 호출
빨강 원 (반지름: 5.0) [채움]
```
```

## 4. 실전 예제: 그래픽 컴포넌트 시스템

### 실습 4-1: GUI 컴포넌트 계층구조
**목표**: this와 super를 활용한 GUI 컴포넌트 시스템을 구현해보세요.

```java
/**
 * GUI 컴포넌트 시스템 구현
 */
// 기본 컴포넌트 클래스
abstract class Component {
    protected int x, y;
    protected int width, height;
    protected boolean visible;
    protected Component parent;
    
    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = true;
    }
    
    public void setParent(Component parent) {
        this.parent = parent;
    }
    
    public void show() {
        this.visible = true;
        redraw();
    }
    
    public void hide() {
        this.visible = false;
        if (parent != null) {
            parent.redraw();  // 부모에게 다시 그리기 요청
        }
    }
    
    public abstract void draw();
    
    public void redraw() {
        if (visible) {
            draw();
        }
    }
}

// 컨테이너 클래스
class Container extends Component {
    protected Component[] children;
    protected int childCount;
    
    public Container(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.children = new Component[10];
        this.childCount = 0;
    }
    
    public void add(Component child) {
        // TODO 46: 자식 컴포넌트 추가하기
        // childCount가 배열 크기보다 작으면:
        //   - children 배열에 child 추가
        //   - childCount 증가
        //   - child.setParent(this) 호출
    }
    
    @Override
    public void draw() {
        System.out.println("Container 그리기 at (" + x + ", " + y + ")");
        // TODO 47: 모든 자식 컴포넌트 그리기
        // childCount만큼 반복하면서 children[i].redraw() 호출
    }
    
    @Override
    public void redraw() {
        // TODO 48: super.redraw() 호출 후 부모에게 알리기
        // super.redraw() 호출
        // parent가 null이 아니면 parent.redraw() 호출
    }
}

// 버튼 클래스
class SimpleButton extends Component {
    private String text;
    
    public SimpleButton(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
    }
    
    public SimpleButton(int x, int y, String text) {
        // TODO 49: this()를 사용하여 기본 크기(100, 30) 설정하기
    }
    
    @Override
    public void draw() {
        // TODO 50: "Button [[text]] at ([x], [y])" 형식으로 출력하기
    }
    
    public void click() {
        System.out.println(text + " 버튼 클릭!");
        highlight();
    }
    
    private void highlight() {
        // TODO 51: "[text] 버튼 하이라이트" 출력 후 redraw() 호출하기
    }
}

// 텍스트 필드 클래스
class TextField extends Component {
    private String value;
    private String placeholder;
    
    public TextField(int x, int y, int width, String placeholder) {
        super(x, y, width, 25);  // 높이는 고정
        this.placeholder = placeholder;
        this.value = "";
    }
    
    public void setText(String value) {
        // TODO 52: value 설정하고 redraw() 호출하기
    }
    
    @Override
    public void draw() {
        // TODO 53: value가 비어있으면 placeholder, 아니면 value 표시하기
        // "TextField [[display]] at ([x], [y])" 형식으로 출력
    }
}

// 테스트
public class GUISystemExample {
    public static void main(String[] args) {
        // TODO 54: GUI 컴포넌트 계층 구조 만들기
        // mainPanel: 0, 0, 800, 600
        // loginForm: 100, 100, 300, 200
        // idField: 10, 10, 200, "아이디 입력"
        // pwField: 10, 50, 200, "비밀번호 입력"
        // loginBtn: 10, 100, "로그인"
        // cancelBtn: 120, 100, "취소"
        
        // TODO 55: 계층 구조 구성하기
        // loginForm에 모든 필드와 버튼 추가
        // mainPanel에 loginForm 추가
        
        // TODO 56: 전체 화면 그리기
        
        // TODO 57: 사용자 입력 시뮬레이션하기
        // idField에 "user123" 설정
        // loginBtn 클릭
    }
}

#### 실행 결과 (참고용):
```
=== 초기 화면 ===
Container 그리기 at (0, 0)
Container 그리기 at (100, 100)
TextField [아이디 입력] at (10, 10)
TextField [비밀번호 입력] at (10, 50)
Button [로그인] at (10, 100)
Button [취소] at (120, 100)

=== 아이디 입력 ===
TextField [user123] at (10, 10)

=== 로그인 버튼 클릭 ===
로그인 버튼이 클릭되었습니다.
로그인 버튼 하이라이트
Button [로그인] at (10, 100)
```
```

## 5. 고급 예제: 빌더 패턴

### 실습 5-1: this를 활용한 빌더 패턴
**목표**: 빌더 패턴을 사용하여 복잡한 객체를 생성하는 방법을 익혀보세요.

```java
/**
 * 빌더 패턴을 사용한 복잡한 객체 생성
 */
public class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean onions;
    
    // private 생성자 - 빌더를 통해서만 생성 가능
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
    }
    
    // 정적 내부 빌더 클래스
    public static class Builder {
        private String size;
        private boolean cheese = true;  // 기본값
        private boolean pepperoni = false;
        private boolean mushrooms = false;
        private boolean onions = false;
        
        public Builder(String size) {
            this.size = size;
        }
        
        public Builder cheese(boolean value) {
            // TODO 58: cheese 설정하고 this 반환하기
        }
        
        public Builder pepperoni(boolean value) {
            // TODO 59: pepperoni 설정하고 this 반환하기
        }
        
        public Builder mushrooms(boolean value) {
            // TODO 60: mushrooms 설정하고 this 반환하기
        }
        
        public Builder onions(boolean value) {
            // TODO 61: onions 설정하고 this 반환하기
        }
        
        public Pizza build() {
            // TODO 62: new Pizza(this)로 피자 객체 생성하여 반환하기
            return null;
        }
    }
    
    @Override
    public String toString() {
        // TODO 63: 피자 정보를 문자열로 반환하기
        // "[size] 피자" + 선택된 토핑들
        // 예: "Large 피자 + 치즈 + 페퍼로니"
        return "";
    }
}

// 테스트
public class BuilderPatternExample {
    public static void main(String[] args) {
        // TODO 64: 빌더 패턴을 사용하여 피자 3개 만들기
        // pizza1: Large, 페퍼로니, 버섯
        // pizza2: Medium, 치즈 없음, 양파
        // pizza3: Small, 기본 설정(치즈만)
        
        // TODO 65: 주문한 피자들 출력하기
    }
}

#### 실행 결과 (참고용):
```
주문한 피자:
1. Large 피자 + 치즈 + 페퍼로니 + 버섯
2. Medium 피자 + 양파
3. Small 피자 + 치즈
```
```

## 학습 포인트

### 1. this 키워드
- **인스턴스 참조**: 현재 객체를 가리키는 참조
- **매개변수 구분**: 매개변수와 인스턴스 변수 이름이 같을 때 구분
- **메서드 체이닝**: this를 반환하여 연속적인 메서드 호출 가능
- **this()**: 같은 클래스의 다른 생성자 호출

### 2. super 키워드
- **부모 참조**: 부모 클래스의 멤버에 접근
- **메서드 확장**: 부모 메서드 호출 후 추가 기능 구현
- **숨겨진 필드**: 자식 클래스에서 같은 이름으로 숨겨진 부모 필드 접근
- **super()**: 부모 클래스의 생성자 호출

### 3. 생성자 체이닝
- **코드 재사용**: this()로 중복 코드 제거
- **유연한 객체 생성**: 다양한 매개변수 조합 제공
- **초기화 순서**: super()는 항상 첫 번째 줄에 위치

### 4. 실전 활용
- **GUI 시스템**: 컴포넌트 계층 구조에서 this와 super 활용
- **빌더 패턴**: this를 반환하여 플루언트 API 구현
- **이벤트 처리**: this를 리스너로 전달

this와 super는 객체지향 프로그래밍에서 필수적인 키워드입니다!