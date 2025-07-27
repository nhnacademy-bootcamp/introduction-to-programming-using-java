# Java Enum

## 1. Enum(Enumeration)이란?

- 서로 관련된 **상수들의 집합** 을 정의할 때 사용하는 특별한 **클래스**
- 타입 안정성(Type Safety) 제공

### 왜 Enum을 사용하나요?

```java
// 기존 방식 - 상수 사용
public static final int MONDAY = 1;
public static final int TUESDAY = 2;
public static final int WEDNESDAY = 3;

// 문제점: 아무 정수나 전달 가능
setDay(999); // 컴파일 에러 없음!
```

```java
// Enum 사용
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// 장점: 정의된 값만 사용 가능
setDay(Day.MONDAY); // OK
setDay(999); // 컴파일 에러!
```

## 2. 기본 문법

### 2.1 Enum 선언

```java
// 간단한 Enum
public enum Season {
    SPRING, SUMMER, FALL, WINTER
}

// 별도 파일로 선언
// Season.java
public enum Season {
    SPRING, SUMMER, FALL, WINTER
}

// 클래스 내부에 선언
public class Weather {
    public enum Season {
        SPRING, SUMMER, FALL, WINTER
    }
}
```

### 2.2 Enum 사용

```java
public class EnumExample {
    public static void main(String[] args) {
        // Enum 변수 선언
        Season currentSeason = Season.SUMMER;

        // 비교
        if (currentSeason == Season.SUMMER) {
            System.out.println("여름입니다!");
        }

        // Switch 문에서 사용
        switch (currentSeason) {
            case SPRING:
                System.out.println("봄");
                break;
            case SUMMER:
                System.out.println("여름");
                break;
            case FALL:
                System.out.println("가을");
                break;
            case WINTER:
                System.out.println("겨울");
                break;
        }
    }
}
```

## 3. Enum의 주요 메서드

### 3.1 기본 제공 메서드

```java
public class EnumMethods {
    public static void main(String[] args) {
        Season season = Season.SPRING;

        // name(): Enum 상수의 이름 반환
        System.out.println(season.name()); // "SPRING"

        // ordinal(): Enum 상수의 순서 반환 (0부터 시작)
        System.out.println(season.ordinal()); // 0

        // valueOf(): 문자열로 Enum 상수 얻기
        Season summer = Season.valueOf("SUMMER");

        // values(): 모든 Enum 상수 배열로 얻기
        Season[] seasons = Season.values();
        for (Season s : seasons) {
            System.out.println(s);
        }

        // compareTo(): Enum 상수 비교
        int result = Season.SPRING.compareTo(Season.WINTER);
        System.out.println(result); // 음수 (SPRING이 WINTER보다 앞)
    }
}
```

### 3.2 Enum 메서드 상세 설명

#### 3.2.1 name() 메서드
- **기능**: Enum 상수의 이름을 String으로 반환
- **반환값**: 상수 이름의 정확한 문자열
- **특징**: final 메서드로 오버라이드 불가

```java
public class NameMethodExample {
    public static void main(String[] args) {
        System.out.println(Season.SPRING.name()); // "SPRING"
        System.out.println(Season.WINTER.name()); // "WINTER"
        
        // name()과 toString() 비교
        System.out.println(Season.SPRING.toString()); // 기본적으로 name()과 같음
    }
}
```

#### 3.2.2 ordinal() 메서드
- **기능**: Enum 상수의 선언 순서를 정수로 반환 (0부터 시작)
- **주의**: ordinal() 값에 의존한 코드는 위험함

```java
public class OrdinalMethodExample {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season.name() + ": " + season.ordinal());
        }
        // 출력:
        // SPRING: 0
        // SUMMER: 1
        // FALL: 2
        // WINTER: 3
        
        // ordinal() 사용 시 주의사항
        // Enum 순서가 바뀌면 ordinal 값도 변경됨!
    }
}
```

#### 3.2.3 valueOf() 메서드
- **기능**: 문자열을 받아 해당하는 Enum 상수 반환
- **예외**: IllegalArgumentException (잘못된 이름 시)

```java
public class ValueOfMethodExample {
    public static void main(String[] args) {
        // 정상적인 사용
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring); // SPRING
        
        // 대소문자 구분함
        try {
            Season invalid = Season.valueOf("spring"); // 예외 발생!
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 Enum 이름: " + e.getMessage());
        }
        
        // 안전한 valueOf 구현
        Season safeSeason = safeValueOf("summer");
        System.out.println(safeSeason); // null
    }
    
    public static Season safeValueOf(String name) {
        try {
            return Season.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
```

#### 3.2.4 values() 메서드
- **기능**: 모든 Enum 상수를 배열로 반환
- **특징**: 컴파일러가 자동으로 생성하는 static 메서드

```java
public class ValuesMethodExample {
    public static void main(String[] args) {
        // 모든 계절 출력
        Season[] allSeasons = Season.values();
        System.out.println("총 계절 수: " + allSeasons.length);
        
        for (Season season : allSeasons) {
            System.out.println("계절: " + season + ", 순서: " + season.ordinal());
        }
        
        // 배열을 List로 변환
        List<Season> seasonList = Arrays.asList(Season.values());
        System.out.println("List로 변환: " + seasonList);
        
        // Stream API와 함께 사용
        Season[] warmSeasons = Arrays.stream(Season.values())
            .filter(s -> s == Season.SPRING || s == Season.SUMMER)
            .toArray(Season[]::new);
    }
}
```

#### 3.2.5 compareTo() 메서드
- **기능**: Enum 상수들을 선언 순서에 따라 비교
- **반환값**: 음수(앞), 0(같음), 양수(뒤)

```java
public class CompareToMethodExample {
    public static void main(String[] args) {
        // 계절 비교
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        Season winter = Season.WINTER;
        
        System.out.println(spring.compareTo(summer)); // -1 (SPRING이 SUMMER보다 앞)
        System.out.println(summer.compareTo(spring)); //  1 (SUMMER가 SPRING보다 뒤)
        System.out.println(spring.compareTo(spring)); //  0 (같음)
        
        // 정렬에 활용
        List<Season> seasons = Arrays.asList(Season.WINTER, Season.SPRING, Season.FALL, Season.SUMMER);
        Collections.sort(seasons);
        System.out.println("정렬된 계절: " + seasons);
        // 출력: [SPRING, SUMMER, FALL, WINTER]
    }
}
```

#### 3.2.6 toString() 메서드
- **기능**: Enum 상수의 문자열 표현 반환
- **특징**: 기본적으로 name()과 동일하지만 오버라이드 가능

```java
public enum Priority {
    LOW("낮음"),
    MEDIUM("보통"),
    HIGH("높음"),
    URGENT("긴급");
    
    private final String description;
    
    Priority(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return description; // name() 대신 한글 설명 반환
    }
}

public class ToStringMethodExample {
    public static void main(String[] args) {
        Priority priority = Priority.HIGH;
        
        System.out.println(priority.name());     // "HIGH"
        System.out.println(priority.toString()); // "높음" (오버라이드됨)
        
        // toString()이 오버라이드되어도 name()은 변경되지 않음
        for (Priority p : Priority.values()) {
            System.out.println("name: " + p.name() + ", toString: " + p.toString());
        }
    }
}
```

#### 3.2.7 equals() 메서드와 == 연산자
- **Enum의 특징**: == 연산자와 equals() 메서드 결과가 동일
- **권장사항**: == 연산자 사용 (더 빠르고 null-safe)

```java
public class EqualsMethodExample {
    public static void main(String[] args) {
        Season s1 = Season.SPRING;
        Season s2 = Season.SPRING;
        Season s3 = Season.valueOf("SPRING");
        
        // == 연산자와 equals() 결과가 동일
        System.out.println(s1 == s2);        // true
        System.out.println(s1.equals(s2));   // true
        System.out.println(s1 == s3);        // true
        System.out.println(s1.equals(s3));   // true
        
        // null 안전성
        Season nullSeason = null;
        System.out.println(s1 == nullSeason);        // false (안전)
        // System.out.println(s1.equals(nullSeason)); // false (안전)
        // System.out.println(nullSeason.equals(s1)); // NullPointerException!
        
        // 따라서 == 연산자 사용 권장
        if (s1 == Season.SPRING) {
            System.out.println("봄입니다!");
        }
    }
}
```

#### 3.2.8 hashCode() 메서드
- **기능**: Enum 상수의 해시코드 반환
- **특징**: ordinal() 값과 동일하며, 일관성 보장

```java
public class HashCodeMethodExample {
    public static void main(String[] args) {
        Set<Season> seasonSet = new HashSet<>();
        seasonSet.add(Season.SPRING);
        seasonSet.add(Season.SUMMER);
        seasonSet.add(Season.SPRING); // 중복 - 추가되지 않음
        
        System.out.println("Set 크기: " + seasonSet.size()); // 2
        
        // HashMap의 키로 사용
        Map<Season, String> seasonMap = new HashMap<>();
        seasonMap.put(Season.SPRING, "봄");
        seasonMap.put(Season.SUMMER, "여름");
        
        System.out.println(seasonMap.get(Season.SPRING)); // "봄"
    }
}
```

### 3.3 Enum 메서드 활용 실전 예제

```java
public enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
    
    private final int code;
    private final String message;
    
    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
    
    // 코드로 HttpStatus 찾기
    public static HttpStatus fromCode(int code) {
        for (HttpStatus status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + code);
    }
    
    // 성공 상태인지 확인
    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }
    
    @Override
    public String toString() {
        return code + " " + message;
    }
}

public class HttpStatusExample {
    public static void main(String[] args) {
        // 기본 메서드 사용
        HttpStatus status = HttpStatus.OK;
        System.out.println("name(): " + status.name());
        System.out.println("ordinal(): " + status.ordinal());
        System.out.println("toString(): " + status.toString());
        
        // 커스텀 메서드 사용
        System.out.println("코드: " + status.getCode());
        System.out.println("성공 상태: " + status.isSuccess());
        
        // 코드로 찾기
        HttpStatus foundStatus = HttpStatus.fromCode(404);
        System.out.println("찾은 상태: " + foundStatus);
        
        // 모든 상태 출력
        System.out.println("\n모든 HTTP 상태:");
        for (HttpStatus s : HttpStatus.values()) {
            System.out.println(s.name() + " -> " + s);
        }
        
        // 비교 연산
        if (status == HttpStatus.OK) {
            System.out.println("정상 응답입니다.");
        }
    }
}
```

## 4. 고급 기능

### 4.1 필드와 생성자 추가

```java
public enum Planet {
    // 각 상수에 값 할당
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6);

    private final double mass;   // 질량 (kg)
    private final double radius; // 반지름 (m)

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    // Getter 메서드
    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    // 중력 계산 메서드
    public double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}
```

### 4.2 추상 메서드 구현

```java
public enum Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    // 추상 메서드
    public abstract double apply(double x, double y);

    // 사용 예
    public static void main(String[] args) {
        double result = Operation.PLUS.apply(5, 3); // 8.0
        System.out.println("5 + 3 = " + result);
    }
}
```

### 4.3 인터페이스 구현

```java
public interface Printable {
    void print();
}

public enum Document implements Printable {
    REPORT {
        @Override
        public void print() {
            System.out.println("보고서를 출력합니다.");
        }
    },
    INVOICE {
        @Override
        public void print() {
            System.out.println("청구서를 출력합니다.");
        }
    },
    RECEIPT {
        @Override
        public void print() {
            System.out.println("영수증을 출력합니다.");
        }
    }
}
```

## 5. 실무 활용 예제

### 5.1 상태 관리

```java
public enum OrderStatus {
    PENDING("주문 대기중"),
    PROCESSING("처리중"),
    SHIPPED("배송중"),
    DELIVERED("배송완료"),
    CANCELLED("취소됨");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // 다음 상태로 전환 가능한지 확인
    public boolean canTransitionTo(OrderStatus newStatus) {
        switch (this) {
            case PENDING:
                return newStatus == PROCESSING || newStatus == CANCELLED;
            case PROCESSING:
                return newStatus == SHIPPED || newStatus == CANCELLED;
            case SHIPPED:
                return newStatus == DELIVERED;
            case DELIVERED:
            case CANCELLED:
                return false; // 최종 상태
            default:
                return false;
        }
    }
}
```

### 5.2 설정 값 관리

```java
public enum DatabaseConfig {
    DEV("localhost", 5432, "dev_db"),
    STAGING("staging.example.com", 5432, "staging_db"),
    PRODUCTION("prod.example.com", 5432, "prod_db");

    private final String host;
    private final int port;
    private final String dbName;

    DatabaseConfig(String host, int port, String dbName) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
    }

    public String getConnectionUrl() {
        return String.format("jdbc:postgresql://%s:%d/%s", host, port, dbName);
    }
}
```

### 5.3 전략 패턴 구현

```java
public enum PaymentMethod {
    CREDIT_CARD {
        @Override
        public void processPayment(double amount) {
            System.out.println("신용카드로 " + amount + "원 결제");
            // 신용카드 결제 로직
        }

        @Override
        public double calculateFee(double amount) {
            return amount * 0.03; // 3% 수수료
        }
    },
    BANK_TRANSFER {
        @Override
        public void processPayment(double amount) {
            System.out.println("계좌이체로 " + amount + "원 결제");
            // 계좌이체 로직
        }

        @Override
        public double calculateFee(double amount) {
            return 500; // 고정 수수료
        }
    },
    CASH {
        @Override
        public void processPayment(double amount) {
            System.out.println("현금으로 " + amount + "원 결제");
            // 현금 결제 로직
        }

        @Override
        public double calculateFee(double amount) {
            return 0; // 수수료 없음
        }
    };

    public abstract void processPayment(double amount);
    public abstract double calculateFee(double amount);
}
```

## 6. Enum 실무 활용 패턴

### 6.1 상태 머신 패턴

```java
public enum OrderState {
    PENDING {
        @Override
        public OrderState nextState(OrderEvent event) {
            switch (event) {
                case PAYMENT_CONFIRMED:
                    return PROCESSING;
                case CANCELLED:
                    return CANCELLED;
                default:
                    throw new IllegalStateException("Invalid transition from " + this + " with " + event);
            }
        }
    },
    PROCESSING {
        @Override
        public OrderState nextState(OrderEvent event) {
            switch (event) {
                case SHIPPED:
                    return SHIPPED;
                case CANCELLED:
                    return CANCELLED;
                default:
                    throw new IllegalStateException("Invalid transition from " + this + " with " + event);
            }
        }
    },
    SHIPPED {
        @Override
        public OrderState nextState(OrderEvent event) {
            if (event == OrderEvent.DELIVERED) {
                return DELIVERED;
            }
            throw new IllegalStateException("Invalid transition from " + this + " with " + event);
        }
    },
    DELIVERED {
        @Override
        public OrderState nextState(OrderEvent event) {
            throw new IllegalStateException("Order already delivered, no further transitions allowed");
        }
    },
    CANCELLED {
        @Override
        public OrderState nextState(OrderEvent event) {
            throw new IllegalStateException("Cancelled order cannot transition to other states");
        }
    };

    public abstract OrderState nextState(OrderEvent event);

    public enum OrderEvent {
        PAYMENT_CONFIRMED, SHIPPED, DELIVERED, CANCELLED
    }
}
```

### 6.2 설정 관리 패턴

```java
public enum Environment {
    DEVELOPMENT("dev", "localhost", 8080, false),
    STAGING("stage", "staging.company.com", 8080, true),
    PRODUCTION("prod", "api.company.com", 443, true);

    private final String name;
    private final String host;
    private final int port;
    private final boolean sslEnabled;

    Environment(String name, String host, int port, boolean sslEnabled) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.sslEnabled = sslEnabled;
    }

    public String getBaseUrl() {
        String protocol = sslEnabled ? "https" : "http";
        return String.format("%s://%s:%d", protocol, host, port);
    }

    public String getName() { return name; }
    public String getHost() { return host; }
    public int getPort() { return port; }
    public boolean isSslEnabled() { return sslEnabled; }

    // 현재 환경 가져오기
    public static Environment current() {
        String env = System.getProperty("app.environment", "DEVELOPMENT");
        return Environment.valueOf(env.toUpperCase());
    }
}
```

### 6.3 에러 코드 관리 패턴

```java
public enum ErrorCode {
    // 인증 관련 에러 (1000번대)
    UNAUTHORIZED(1001, "인증이 필요합니다", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN(1002, "유효하지 않은 토큰입니다", HttpStatus.UNAUTHORIZED),
    EXPIRED_TOKEN(1003, "만료된 토큰입니다", HttpStatus.UNAUTHORIZED),

    // 사용자 관련 에러 (2000번대)
    USER_NOT_FOUND(2001, "사용자를 찾을 수 없습니다", HttpStatus.NOT_FOUND),
    DUPLICATE_EMAIL(2002, "이미 존재하는 이메일입니다", HttpStatus.CONFLICT),
    INVALID_PASSWORD(2003, "잘못된 비밀번호입니다", HttpStatus.BAD_REQUEST),

    // 시스템 에러 (9000번대)
    INTERNAL_ERROR(9001, "내부 서버 오류", HttpStatus.INTERNAL_SERVER_ERROR),
    DATABASE_ERROR(9002, "데이터베이스 오류", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
    public HttpStatus getHttpStatus() { return httpStatus; }

    // 카테고리 확인 메서드들
    public boolean isAuthError() {
        return code >= 1000 && code < 2000;
    }

    public boolean isUserError() {
        return code >= 2000 && code < 3000;
    }

    public boolean isSystemError() {
        return code >= 9000;
    }

    // 코드로 ErrorCode 찾기
    public static ErrorCode fromCode(int code) {
        return Arrays.stream(values())
                .filter(error -> error.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown error code: " + code));
    }
}
```

## 7. 주의사항 및 Best Practices

### 7.1 ordinal() 사용 주의

```java
// 나쁜 예 - ordinal()에 의존
public enum Status {
    NEW, IN_PROGRESS, COMPLETED
}

// DB에 ordinal 값 저장
saveToDatabase(status.ordinal()); // 위험!

// 좋은 예 - 명시적 코드 사용
public enum Status {
    NEW(10), IN_PROGRESS(20), COMPLETED(30);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
```

### 7.2 Null 체크

```java
public void processDay(Day day) {
    // Enum도 null이 될 수 있음
    if (day == null) {
        throw new IllegalArgumentException("Day cannot be null");
    }

    // 또는 Optional 사용
    Optional.ofNullable(day)
            .orElseThrow(() -> new IllegalArgumentException("Day cannot be null"));
}
```

### 7.3 역직렬화 시 주의

```java
public enum Color {
    RED, GREEN, BLUE;

    // 문자열을 Enum으로 안전하게 변환
    public static Color fromString(String value) {
        if (value == null) {
            return null;
        }

        try {
            return Color.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            // 기본값 반환 또는 예외 처리
            return null;
        }
    }
}
```

## 8. 성능 고려사항

1. **Enum은 싱글톤**: 각 Enum 상수는 JVM 내에서 단 하나의 인스턴스만 존재
2. **== 연산자 사용**: equals() 대신 == 사용 가능 (더 빠름)
3. **Switch 문 최적화**: Enum을 사용한 switch 문은 JVM에 의해 최적화됨
4. **메모리 효율성**: 상수를 static final로 선언하는 것보다 메모리 효율적

## 9. 마무리

Enum은 단순한 상수 집합이 아닌, Java의 강력한 기능입니다. 다음과 같은 경우에 적극 활용하세요:

- 고정된 상수 집합이 필요할 때
- 타입 안정성이 중요할 때
- 각 상수가 고유한 동작을 가져야 할 때
- 상태 머신이나 전략 패턴을 구현할 때

Enum을 잘 활용하면 더 안전하고 읽기 쉬운 코드를 작성할 수 있습니다!