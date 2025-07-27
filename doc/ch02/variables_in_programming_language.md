# 프로그래밍에서의 변수 분류

## 1. 스코프(Scope)에 따른 분류

### 전역 변수 (Global Variable)
- **정의**: 프로그램 전체에서 접근 가능한 변수
- **특징**: 프로그램 시작 시 생성, 종료 시 소멸
- **주의**: 과도한 사용은 코드 유지보수성 저하

```python
global_counter = 0  # 모든 함수에서 접근 가능

def increment():
    global global_counter
    global_counter += 1
```

### 지역 변수 (Local Variable)
- **정의**: 특정 함수나 메서드 내에서만 유효한 변수
- **특징**: 함수 호출 시 생성, 반환 시 소멸
- **장점**: 메모리 효율적, 이름 충돌 방지

```java
public void calculateSum() {
    int sum = 0;  // calculateSum 내에서만 유효
    for (int i = 0; i < 10; i++) {
        sum += i;
    }
}
```

### 블록 스코프 변수 (Block-scoped Variable)
- **정의**: 특정 블록({}) 내에서만 유효한 변수
- **특징**: 블록 진입 시 생성, 탈출 시 소멸
- **언어**: C++, Java, JavaScript(let, const)

```javascript
if (condition) {
    let blockVar = "only here";  // if 블록 내에서만 유효
    const MAX = 100;
}
// blockVar, MAX 접근 불가
```

## 2. 생명주기(Lifetime)에 따른 분류

### 정적 변수 (Static Variable)
- **정의**: 프로그램 실행 기간 동안 메모리에 유지
- **특징**: 한 번만 초기화, 함수 호출 간 값 유지
- **용도**: 상태 유지, 싱글톤 패턴

```c
void countCalls() {
    static int count = 0;  // 최초 1회만 초기화
    count++;
    printf("Called %d times\n", count);
}
```

### 자동 변수 (Automatic Variable)
- **정의**: 선언된 블록 내에서만 존재
- **특징**: 스택에 할당, 자동으로 메모리 해제
- **대부분의 지역 변수가 이에 해당**

```c
void function() {
    int auto_var = 10;  // 함수 종료 시 자동 소멸
    char buffer[100];   // 자동 변수
}
```

### 동적 변수 (Dynamic Variable)
- **정의**: 실행 중 동적으로 할당/해제되는 변수
- **특징**: 힙 메모리 사용, 명시적 해제 필요
- **위험**: 메모리 누수 가능성

```c++
int* dynamicArray = new int[size];  // 동적 할당
// 사용 후
delete[] dynamicArray;  // 명시적 해제 필요
```

## 3. 값의 저장 방식에 따른 분류

### 원시 타입 (Primitive Type)
- **정의**: 변수에 실제 값이 직접 저장
- **특징**:
  - 스택 메모리에 저장
  - 고정된 크기
  - 빠른 접근 속도
  - null 불가 (일부 언어 제외)

```java
// Java의 primitive types
byte b = 127;              // 1 byte
short s = 32767;           // 2 bytes
int i = 2147483647;        // 4 bytes
long l = 9223372036854775807L;  // 8 bytes
float f = 3.14f;           // 4 bytes
double d = 3.14159;        // 8 bytes
char c = 'A';              // 2 bytes
boolean flag = true;       // 1 bit (구현에 따라 다름)
```

### 참조 타입 (Reference Type)
- **정의**: 변수에 객체의 메모리 주소 저장
- **특징**:
  - 실제 데이터는 힙에 저장
  - 가변 크기 가능
  - null 가능
  - 간접 참조 오버헤드

```java
// Java의 reference types
String str = "Hello";              // 문자열 객체 참조
int[] array = new int[10];         // 배열 객체 참조
ArrayList<Integer> list = new ArrayList<>();  // 컬렉션 객체 참조
Object obj = new Object();         // 일반 객체 참조
```

### 메모리 구조 비교
```
Primitive Type:
스택: [x: 42] → 실제 값

Reference Type:
스택: [str: 0x1234] → 힙: [0x1234: "Hello World"]
```

## 4. 타입 체계에 따른 분류

### 정적 타입 변수 (Statically Typed)
- **정의**: 컴파일 시점에 타입 결정
- **특징**: 타입 안정성, 컴파일 시 오류 검출
- **언어**: Java, C++, C#, Go

```go
var count int = 10        // 타입 명시
var name string = "Alice"
// count = "text"  // 컴파일 오류
```

### 동적 타입 변수 (Dynamically Typed)
- **정의**: 실행 시점에 타입 결정
- **특징**: 유연성, 런타임 오류 가능성
- **언어**: Python, JavaScript, Ruby

```python
x = 42          # 정수
x = "Hello"     # 문자열로 변경 가능
x = [1, 2, 3]   # 리스트로 변경 가능
```

## 5. 변경 가능성에 따른 분류

### 가변 변수 (Mutable Variable)
- **정의**: 선언 후 값 변경 가능
- **특징**: 일반적인 변수의 기본 동작

```rust
let mut counter = 0;  // Rust에서는 mut 키워드 필요
counter += 1;         // 변경 가능
```

### 불변 변수 (Immutable Variable)
- **정의**: 선언 후 값 변경 불가
- **특징**: 안전성, 동시성 프로그래밍에 유리
- **구현**: const, final, readonly 등

```java
final int MAX_SIZE = 100;  // 변경 불가
const double PI = 3.14159;  // C++

// JavaScript
const arr = [1, 2, 3];  // 참조는 불변, 내용은 가변
arr.push(4);  // 가능
// arr = [5, 6];  // 불가능
```

## 6. 메모리 위치에 따른 분류

### 스택 변수 (Stack Variable)
- **특징**: LIFO 구조, 빠른 할당/해제
- **용도**: 지역 변수, 함수 매개변수

```c
void function() {
    int stackVar = 10;     // 스택에 할당
    char buffer[256];      // 스택에 할당
}
```

### 힙 변수 (Heap Variable)
- **특징**: 동적 메모리 할당, 느린 접근
- **용도**: 큰 데이터, 동적 크기 구조

```c
int* heapVar = (int*)malloc(sizeof(int) * 100);  // 힙에 할당
free(heapVar);  // 명시적 해제
```

### 레지스터 변수 (Register Variable)
- **특징**: CPU 레지스터에 저장 시도
- **용도**: 자주 사용되는 변수 최적화

```c
register int counter = 0;  // 컴파일러에게 힌트 제공
```

## 7. 바인딩 시점에 따른 분류

### 정적 바인딩 (Static Binding)
- **정의**: 컴파일 시점에 변수와 메모리 주소 연결
- **특징**: 빠른 실행, 유연성 부족

```c++
int staticBind = 10;  // 컴파일 시 주소 결정
```

### 동적 바인딩 (Dynamic Binding)
- **정의**: 실행 시점에 변수와 메모리 주소 연결
- **특징**: 유연성, 런타임 오버헤드

```python
# 실행 중 변수 생성
var_name = "dynamic_var"
globals()[var_name] = 100
```

## 8. 접근 제어에 따른 분류

### 접근 제한자별 분류
```java
public class MyClass {
    public int publicVar = 1;      // 어디서든 접근
    protected int protectedVar = 2; // 패키지/상속 관계
    int packageVar = 3;            // 같은 패키지
    private int privateVar = 4;    // 클래스 내부만
}
```

## 9. 특수 목적 변수

### 환경 변수 (Environment Variable)
```bash
export DATABASE_URL="postgresql://localhost/mydb"
echo $PATH
```

### 스레드 로컬 변수 (Thread-Local Variable)
```java
private static ThreadLocal<SimpleDateFormat> dateFormat =
    ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
```

### 클로저 변수 (Closure Variable)
```javascript
function createCounter() {
    let count = 0;  // 클로저에 캡처됨
    return {
        increment: () => ++count,
        get: () => count
    };
}
```

## 변수 선택 가이드

1. **성능이 중요한 경우**: Primitive type, 스택 변수
2. **메모리 효율**: 적절한 스코프의 자동 변수
3. **안전성**: 불변 변수, private 접근 제어
4. **유연성**: 동적 타입, 참조 타입
5. **동시성**: 불변 변수, 스레드 로컬 변수

각 분류는 서로 독립적이지 않고 조합되어 사용됩니다. 예를 들어, Java의 `private static final int MAX = 100`은 private(접근제어), static(생명주기), final(불변성), int(원시타입)의 특성을 모두 가집니다# 프로그래밍에서의 변수 분류

## 1. 스코프(Scope)에 따른 분류

### 전역 변수 (Global Variable)
- **정의**: 프로그램 전체에서 접근 가능한 변수
- **특징**: 프로그램 시작 시 생성, 종료 시 소멸
- **주의**: 과도한 사용은 코드 유지보수성 저하

```java
// Java
public class GlobalExample {
    public static int globalCounter = 0;  // 전역 변수

    public static void increment() {
        globalCounter++;  // 어디서든 접근 가능
    }
}
```

```python
# Python
global_counter = 0  # 전역 변수

def increment():
    global global_counter
    global_counter += 1
```

### 지역 변수 (Local Variable)
- **정의**: 특정 함수나 메서드 내에서만 유효한 변수
- **특징**: 함수 호출 시 생성, 반환 시 소멸
- **장점**: 메모리 효율적, 이름 충돌 방지

```java
// Java
public class LocalExample {
    public void calculateSum() {
        int sum = 0;  // 지역 변수 - 메서드 내에서만 유효
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        // sum과 i는 메서드 종료 시 소멸
    }
}
```

### 블록 스코프 변수 (Block-scoped Variable)
- **정의**: 특정 블록({}) 내에서만 유효한 변수
- **특징**: 블록 진입 시 생성, 탈출 시 소멸

```java
// Java
public void processData() {
    if (true) {
        int blockVar = 100;  // if 블록 내에서만 유효
        final String MESSAGE = "Block scope";
    }
    // blockVar와 MESSAGE 접근 불가
}
```

```javascript
// JavaScript
if (condition) {
    let blockVar = "only here";  // let은 블록 스코프
    const MAX = 100;
}
```

## 2. 생명주기(Lifetime)에 따른 분류

### 정적 변수 (Static Variable)
- **정의**: 프로그램 실행 기간 동안 메모리에 유지
- **특징**: 한 번만 초기화, 메서드 호출 간 값 유지
- **용도**: 상태 유지, 싱글톤 패턴

```java
// Java
public class Counter {
    private static int count = 0;  // 클래스 레벨 정적 변수

    public void increment() {
        count++;  // 모든 인스턴스가 공유
    }

    public static int getCount() {
        return count;
    }
}
```

```c
// C
void countCalls() {
    static int count = 0;  // 함수 내 정적 변수
    count++;
    printf("Called %d times\n", count);
}
```

### 인스턴스 변수 (Instance Variable)
- **정의**: 객체의 생명주기와 동일
- **특징**: 각 인스턴스마다 독립적인 값

```java
// Java
public class Person {
    private String name;     // 인스턴스 변수
    private int age;         // 각 Person 객체마다 고유한 값

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

### 동적 변수 (Dynamic Variable)
- **정의**: 실행 중 동적으로 할당/해제되는 변수
- **특징**: 힙 메모리 사용, 가비지 컬렉션 또는 명시적 해제

```java
// Java (자동 메모리 관리)
public void createDynamicArray() {
    ArrayList<Integer> list = new ArrayList<>();  // 동적 할당
    list.add(10);
    list.add(20);
    // 가비지 컬렉터가 자동으로 메모리 해제
}
```

```c++
// C++ (수동 메모리 관리)
int* dynamicArray = new int[size];  // 동적 할당
delete[] dynamicArray;  // 명시적 해제 필요
```

## 3. 값의 저장 방식에 따른 분류

### 원시 타입 (Primitive Type)
- **정의**: 변수에 실제 값이 직접 저장
- **특징**: 스택 메모리, 고정 크기, 빠른 접근

```java
// Java의 8가지 primitive types
public class PrimitiveExample {
    byte byteVar = 127;                    // 1 byte (-128 ~ 127)
    short shortVar = 32767;                // 2 bytes
    int intVar = 2147483647;               // 4 bytes
    long longVar = 9223372036854775807L;   // 8 bytes
    float floatVar = 3.14f;                // 4 bytes
    double doubleVar = 3.14159;            // 8 bytes
    char charVar = 'A';                    // 2 bytes (Unicode)
    boolean boolVar = true;                // 1 bit (구현에 따라 다름)
}
```

### 참조 타입 (Reference Type)
- **정의**: 변수에 객체의 메모리 주소 저장
- **특징**: 힙 메모리, 가변 크기, null 가능

```java
// Java의 reference types
public class ReferenceExample {
    String str = "Hello";                          // String 객체 참조
    int[] array = new int[10];                     // 배열 객체 참조
    ArrayList<Integer> list = new ArrayList<>();   // 컬렉션 객체 참조
    Object obj = new Object();                     // 일반 객체 참조
    Integer boxedInt = 42;                         // Wrapper 클래스 참조

    // null 참조 가능
    String nullStr = null;
}
```

### 값 복사 동작의 차이

```java
// Java
public class CopyBehavior {
    public static void main(String[] args) {
        // Primitive - 값 복사
        int a = 10;
        int b = a;     // 값 10이 복사됨
        a = 20;        // b는 여전히 10

        // Reference - 주소 복사
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;    // 같은 배열 참조
        arr1[0] = 99;         // arr2[0]도 99가 됨
    }
}
```

## 4. 타입 체계에 따른 분류

### 정적 타입 변수 (Statically Typed)
- **정의**: 컴파일 시점에 타입 결정
- **특징**: 타입 안정성, 컴파일 시 오류 검출

```java
// Java - 강타입 정적 타입
public class StaticTyping {
    int count = 10;           // 타입 고정
    String name = "Alice";
    // count = "text";       // 컴파일 오류!

    // 제네릭을 통한 타입 안정성
    List<String> names = new ArrayList<>();
    // names.add(123);       // 컴파일 오류!
}
```

### 동적 타입 변수 (Dynamically Typed)
- **정의**: 실행 시점에 타입 결정
- **특징**: 유연성, 런타임 타입 체크

```python
# Python
x = 42          # 정수
x = "Hello"     # 문자열로 변경 가능
x = [1, 2, 3]   # 리스트로 변경 가능
```

## 5. 변경 가능성에 따른 분류

### 가변 변수 (Mutable Variable)
- **정의**: 선언 후 값 변경 가능
- **특징**: 일반적인 변수의 기본 동작

```java
// Java
public class MutableExample {
    int counter = 0;
    counter = 10;      // 변경 가능
    counter += 5;      // 15

    StringBuilder sb = new StringBuilder("Hello");
    sb.append(" World");  // 내용 변경 가능
}
```

### 불변 변수 (Immutable Variable)
- **정의**: 선언 후 값 변경 불가
- **특징**: 스레드 안전성, 예측 가능한 동작

```java
// Java
public class ImmutableExample {
    final int MAX_SIZE = 100;     // 변경 불가
    final String NAME = "Java";   // 변경 불가

    final List<String> list = new ArrayList<>();
    list.add("item");  // 내용은 변경 가능
    // list = new ArrayList<>();  // 참조는 변경 불가!
}
```

## 6. 메모리 위치에 따른 분류

### 스택 변수 (Stack Variable)
- **특징**: LIFO 구조, 빠른 할당/해제
- **내용**: 지역 변수, primitive types, 참조 주소

```java
// Java
public void stackExample() {
    int localInt = 42;              // 스택에 값 저장
    String str = "Hello";           // 스택에 참조 저장
    double[] array = new double[5]; // 스택에 참조 저장
}
```

### 힙 변수 (Heap Variable)
- **특징**: 동적 메모리 할당, 가비지 컬렉션
- **내용**: 객체, 배열의 실제 데이터

```java
// Java
public class HeapExample {
    public void createObjects() {
        // 힙에 String 객체 생성
        String str = new String("Hello");

        // 힙에 배열 생성
        int[] numbers = new int[1000];

        // 힙에 커스텀 객체 생성
        Person person = new Person("John", 30);
    }
}
```

## 7. 접근 제어에 따른 분류

```java
// Java의 접근 제어자
public class AccessModifiers {
    public int publicVar = 1;        // 모든 곳에서 접근 가능
    protected int protectedVar = 2;  // 같은 패키지 + 상속 관계
    int packageVar = 3;              // 같은 패키지 (default)
    private int privateVar = 4;      // 같은 클래스 내부만

    // Getter/Setter를 통한 캡슐화
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
```

## 8. 특수 목적 변수

### 환경 변수 (Environment Variable)
```java
// Java에서 환경 변수 접근
public class EnvExample {
    public static void main(String[] args) {
        String path = System.getenv("PATH");
        String javaHome = System.getenv("JAVA_HOME");

        // 시스템 속성
        String osName = System.getProperty("os.name");
    }
}
```

### 스레드 로컬 변수 (Thread-Local Variable)
```java
// Java
public class ThreadLocalExample {
    private static ThreadLocal<SimpleDateFormat> dateFormat =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public String formatDate(Date date) {
        return dateFormat.get().format(date);  // 각 스레드별 독립적
    }
}
```

### 클로저 변수 (Closure Variable)
```java
// Java (effectively final)
public class ClosureExample {
    public Runnable createCounter() {
        final int[] count = {0};  // effectively final 배열

        return () -> {
            count[0]++;  // 클로저에서 캡처된 변수 수정
            System.out.println("Count: " + count[0]);
        };
    }
}
```

## 변수 선택 가이드

1. **성능 최적화**: primitive types, 지역 변수
2. **메모리 효율**: 적절한 스코프, primitive types
3. **스레드 안전성**: final 변수, 불변 객체, ThreadLocal
4. **캡슐화**: private 변수 + getter/setter
5. **유지보수성**: 명확한 스코프, 의미있는 이름

각 분류는 독립적이지 않고 조합되어 사용됩니다. 예를 들어:
```java
private static final int MAX_CONNECTIONS = 100;
```
이 변수는 private(접근제어), static(생명주기), final(불변성), int(원시타입)의 특성을 모두 가집니다..