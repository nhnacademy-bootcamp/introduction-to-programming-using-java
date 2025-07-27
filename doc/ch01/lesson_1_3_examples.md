# 1.3 자바 가상 머신 - 실습 예제

## 예제 1: 플랫폼 정보 확인

```java
// PlatformInfo.java
public class PlatformInfo {
    public static void main(String[] args) {
        System.out.println("=== 플랫폼 정보 ===");
        System.out.println("운영체제: " + System.getProperty("os.name"));
        System.out.println("OS 버전: " + System.getProperty("os.version"));
        System.out.println("OS 아키텍처: " + System.getProperty("os.arch"));
        System.out.println();
        
        System.out.println("=== Java 정보 ===");
        System.out.println("Java 버전: " + System.getProperty("java.version"));
        System.out.println("Java 벤더: " + System.getProperty("java.vendor"));
        System.out.println("Java 홈: " + System.getProperty("java.home"));
        System.out.println();
        
        System.out.println("=== JVM 정보 ===");
        System.out.println("JVM 이름: " + System.getProperty("java.vm.name"));
        System.out.println("JVM 버전: " + System.getProperty("java.vm.version"));
        System.out.println("JVM 벤더: " + System.getProperty("java.vm.vendor"));
    }
}
```

## 예제 2: 메모리 사용량 확인

```java
// MemoryInfo.java
public class MemoryInfo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();
        
        System.out.println("=== JVM 메모리 정보 ===");
        System.out.println("총 메모리: " + formatBytes(totalMemory));
        System.out.println("사용 중인 메모리: " + formatBytes(usedMemory));
        System.out.println("여유 메모리: " + formatBytes(freeMemory));
        System.out.println("최대 메모리: " + formatBytes(maxMemory));
        
        // 가비지 컬렉션 실행
        System.out.println("\n가비지 컬렉션 실행 중...");
        runtime.gc();
        
        freeMemory = runtime.freeMemory();
        usedMemory = totalMemory - freeMemory;
        
        System.out.println("\n=== GC 후 메모리 정보 ===");
        System.out.println("사용 중인 메모리: " + formatBytes(usedMemory));
        System.out.println("여유 메모리: " + formatBytes(freeMemory));
    }
    
    private static String formatBytes(long bytes) {
        long mb = bytes / (1024 * 1024);
        return mb + " MB";
    }
}
```

## 예제 3: 성능 측정 (인터프리터 vs JIT)

```java
// PerformanceTest.java
public class PerformanceTest {
    public static void main(String[] args) {
        System.out.println("=== JIT 컴파일 성능 테스트 ===");
        
        // 워밍업 (JIT 컴파일 유도)
        System.out.println("워밍업 중...");
        for (int i = 0; i < 10000; i++) {
            calculateSum(1000);
        }
        
        // 첫 번째 측정 (대부분 인터프리터)
        long start1 = System.nanoTime();
        long sum1 = calculateSum(1000000);
        long end1 = System.nanoTime();
        long time1 = (end1 - start1) / 1000000; // 밀리초로 변환
        
        System.out.println("\n첫 번째 실행:");
        System.out.println("결과: " + sum1);
        System.out.println("소요 시간: " + time1 + " ms");
        
        // 반복 실행 (JIT 컴파일 활성화)
        System.out.println("\n반복 실행 중...");
        for (int i = 0; i < 100000; i++) {
            calculateSum(1000000);
        }
        
        // 두 번째 측정 (JIT 컴파일된 코드)
        long start2 = System.nanoTime();
        long sum2 = calculateSum(1000000);
        long end2 = System.nanoTime();
        long time2 = (end2 - start2) / 1000000;
        
        System.out.println("\nJIT 컴파일 후:");
        System.out.println("결과: " + sum2);
        System.out.println("소요 시간: " + time2 + " ms");
        
        double improvement = ((double)(time1 - time2) / time1) * 100;
        System.out.println("\n성능 향상: " + String.format("%.2f", improvement) + "%");
    }
    
    private static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
```

## 예제 4: 바이트코드 시각화

```java
// BytecodeExample.java
public class BytecodeExample {
    private int value;
    
    public BytecodeExample(int value) {
        this.value = value;
    }
    
    public int add(int x) {
        return value + x;
    }
    
    public static void main(String[] args) {
        BytecodeExample obj = new BytecodeExample(10);
        int result = obj.add(5);
        System.out.println("결과: " + result);
    }
}
```

컴파일 및 바이트코드 확인:
```bash
# 컴파일
javac BytecodeExample.java

# 바이트코드 확인
javap -c BytecodeExample

# 더 자세한 정보
javap -c -v BytecodeExample
```

## 예제 5: 다양한 JVM 언어 상호 운용

### Java 클래스
```java
// JavaClass.java
public class JavaClass {
    public String greet(String name) {
        return "Hello from Java, " + name + "!";
    }
    
    public int calculate(int a, int b) {
        return a + b;
    }
}
```

### Kotlin에서 Java 클래스 사용 (예시)
```kotlin
// KotlinExample.kt
fun main() {
    val javaObj = JavaClass()
    println(javaObj.greet("Kotlin"))
    println("계산 결과: ${javaObj.calculate(10, 20)}")
}
```

## 예제 6: 클래스 로딩 관찰

```java
// ClassLoadingDemo.java
public class ClassLoadingDemo {
    static {
        System.out.println("ClassLoadingDemo 클래스가 로드되었습니다!");
    }
    
    public static void main(String[] args) {
        System.out.println("main 메서드 시작");
        
        // 클래스가 처음 사용될 때 로드됨
        System.out.println("TestClass를 로드하려고 합니다...");
        TestClass test = new TestClass();
        test.printMessage();
        
        // 이미 로드된 클래스는 다시 로드되지 않음
        System.out.println("\n두 번째 객체 생성:");
        TestClass test2 = new TestClass();
        test2.printMessage();
    }
}

class TestClass {
    static {
        System.out.println("TestClass가 로드되었습니다!");
    }
    
    public TestClass() {
        System.out.println("TestClass 생성자 호출");
    }
    
    public void printMessage() {
        System.out.println("TestClass의 메서드 실행");
    }
}
```

## 실습 과제

### 과제 1: 플랫폼 독립성 테스트
1. PlatformInfo.java를 컴파일하세요.
2. 생성된 .class 파일을 다른 운영체제로 복사하세요.
3. 다른 운영체제에서 실행하여 결과를 비교하세요.

### 과제 2: 메모리 할당 실험
1. MemoryInfo.java를 다양한 JVM 옵션으로 실행하세요:
   ```bash
   java -Xms256m -Xmx512m MemoryInfo
   java -Xms512m -Xmx1024m MemoryInfo
   ```
2. 결과를 비교하고 분석하세요.

### 과제 3: JIT 컴파일 효과 측정
1. PerformanceTest.java를 JIT 컴파일 비활성화 옵션으로 실행:
   ```bash
   java -Xint PerformanceTest  # 인터프리터 모드만 사용
   ```
2. 일반 실행과 비교하여 성능 차이를 분석하세요.

### 과제 4: 바이트코드 분석
1. 간단한 Java 프로그램을 작성하세요.
2. javap를 사용하여 바이트코드를 분석하세요.
3. 각 바이트코드 명령어의 의미를 조사하세요.

## 참고 명령어

```bash
# Java 버전 확인
java -version

# JVM 옵션 확인
java -X

# 모든 시스템 속성 출력
java -XshowSettings:properties -version

# JVM 플래그 확인
java -XX:+PrintFlagsFinal -version | grep JIT
```