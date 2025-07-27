# 2.6 프로그래밍 환경 - 예제 모음

## 1. 기본 Java 프로그램 예제

### 예제 1-1: Hello World 프로그램
```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        // TODO: "Hello World!" 출력
        // 힌트: System.out.println() 사용
        
        // TODO: 환영 메시지 출력
        // 힌트: "Java 프로그래밍에 오신 것을 환영합니다!" 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
Hello World!
Java 프로그래밍에 오신 것을 환영합니다!
```

**컴파일과 실행 (커맨드 라인)**
```bash
# 컴파일
javac HelloWorld.java

# 실행
java HelloWorld
```

### 예제 1-2: 기본 입출력 프로그램
```java
// SimpleInput.java
import java.util.Scanner;

public class SimpleInput {
    public static void main(String[] args) {
        // TODO: Scanner 객체 생성
        // 힌트: Scanner scanner = new Scanner(System.in);
        
        // TODO: 이름 입력받기
        // 힌트:
        // 1. "이름을 입력하세요: " 출력 (줄바꿈 없이)
        // 2. scanner.nextLine()으로 이름 입력받기
        
        // TODO: 나이 입력받기
        // 힌트:
        // 1. "나이를 입력하세요: " 출력 (줄바꿈 없이)
        // 2. scanner.nextInt()로 나이 입력받기
        
        // TODO: 입력된 정보 출력
        // 힌트:
        // 1. "\n=== 입력 정보 ===" 출력
        // 2. "이름: " + name 출력
        // 3. "나이: " + age + "세" 출력
        
        // TODO: Scanner 닫기
        // 힌트: scanner.close();
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
이름을 입력하세요: 김철수
나이를 입력하세요: 25

=== 입력 정보 ===
이름: 김철수
나이: 25세
```

## 2. TextIO 사용 예제

### 예제 2-1: TextIO 기본 사용
```java
// TextIOExample.java
import textio.TextIO;

public class TextIOExample {
    public static void main(String[] args) {
        // TODO: 프로그램 제목 출력
        // 힌트: "=== TextIO 테스트 프로그램 ==="
        
        // TODO: 정수 입력받기
        // 힌트:
        // 1. "정수를 입력하세요: " 출력 (줄바꿈 없이)
        // 2. TextIO.getlnInt()로 정수 입력
        
        // TODO: 실수 입력받기
        // 힌트:
        // 1. "실수를 입력하세요: " 출력
        // 2. TextIO.getlnDouble()로 실수 입력
        
        // TODO: 단어 입력받기
        // 힌트:
        // 1. "단어를 입력하세요: " 출력
        // 2. TextIO.getlnWord()로 단어 입력
        
        // TODO: 한 줄 입력받기
        // 힌트:
        // 1. "한 줄을 입력하세요: " 출력
        // 2. TextIO.getln()으로 전체 줄 입력
        
        // TODO: 입력된 값들 출력
        // 힌트:
        // 1. "\n입력된 값들:" 출력
        // 2. printf로 정수, 실수(소수점 2자리), 단어, 문장 출력
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== TextIO 테스트 프로그램 ===
정수를 입력하세요: 42
실수를 입력하세요: 3.14
단어를 입력하세요: Java
한 줄을 입력하세요: Hello World

입력된 값들:
정수: 42
실수: 3.14
단어: Java
문장: Hello World

### 예제 2-2: TextIO 파일 입출력
```java
// FileIOExample.java
import textio.TextIO;

public class FileIOExample {
    public static void main(String[] args) {
        // TODO: 파일에 쓰기
        // 힌트:
        // 1. TextIO.writeFile("output.txt")로 파일 출력 모드로 전환
        // 2. TextIO.putln()으로 "첫 번째 줄", "두 번째 줄" 출력
        // 3. TextIO.putf()로 "숫자: %d, 실수: %.2f" 형식으로 42, 3.14 출력
        // 4. TextIO.writeStandardOutput()로 표준 출력으로 복귀
        
        // TODO: 파일 작성 완료 메시지 출력
        // 힌트: "파일 작성 완료!" 출력
        
        // TODO: 파일 읽기
        // 힌트:
        // 1. TextIO.readFile("output.txt")로 파일 입력 모드로 전환
        // 2. "\n파일 내용:" 출력
        // 3. while (!TextIO.eof()) 루프로 파일 끝까지 읽기
        // 4. 각 줄을 "읽은 줄: " + line 형식으로 출력
        // 5. TextIO.readStandardInput()로 표준 입력으로 복귀
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
파일 작성 완료!

파일 내용:
읽은 줄: 첫 번째 줄
읽은 줄: 두 번째 줄
읽은 줄: 숫자: 42, 실수: 3.14

## 3. 패키지 사용 예제

### 예제 3-1: 패키지 구조
```java
// 파일: src/com/example/util/Calculator.java
package com.example.util;

public class Calculator {
    // TODO: 덧셈 메서드 작성
    // 힌트: public static int add(int a, int b) { return a + b; }
    
    // TODO: 뺄셈 메서드 작성
    // 힌트: public static int subtract(int a, int b) { return a - b; }
    
    // TODO: 곱셈 메서드 작성
    // 힌트: public static int multiply(int a, int b) { return a * b; }
    
    // TODO: 나눗셈 메서드 작성
    // 힌트:
    // 1. public static double divide(int a, int b)
    // 2. if (b == 0) 조건으로 0나눗셈 체크
    // 3. IllegalArgumentException 예외 발생
    // 4. (double) a / b 반환
    
    // 여기에 코드를 작성하세요
}
```

### 예제 3-2: 패키지 사용
```java
// 파일: src/com/example/main/MainApp.java
package com.example.main;

// TODO: Calculator 클래스 import
// 힌트: import com.example.util.Calculator;

public class MainApp {
    public static void main(String[] args) {
        // TODO: 테스트용 변수 선언
        // 힌트: int a = 10; int b = 5;
        
        // TODO: 계산기 테스트 제목 출력
        // 힌트: "=== 계산기 테스트 ==="
        
        // TODO: 각 연산 결과 출력
        // 힌트:
        // 1. printf로 "%d + %d = %d" 형식으로 Calculator.add() 호출
        // 2. printf로 "%d - %d = %d" 형식으로 Calculator.subtract() 호출
        // 3. printf로 "%d × %d = %d" 형식으로 Calculator.multiply() 호출
        // 4. printf로 "%d ÷ %d = %.2f" 형식으로 Calculator.divide() 호출
        
        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 계산기 테스트 ===
10 + 5 = 15
10 - 5 = 5
10 × 5 = 50
10 ÷ 5 = 2.00
```

**커맨드 라인에서 컴파일과 실행**
```bash
# src 디렉토리에서 실행
javac com/example/util/Calculator.java
javac com/example/main/MainApp.java

# 실행 (src 디렉토리에서)
java com.example.main.MainApp
```

## 4. JavaFX 예제

### 예제 4-1: 기본 JavaFX 프로그램
```java
// HelloFX.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // 레이블 생성
        Label label = new Label("Hello JavaFX!");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        // 레이아웃 생성
        StackPane root = new StackPane();
        root.getChildren().add(label);
        
        // 장면 생성
        Scene scene = new Scene(root, 300, 200);
        
        // 무대 설정
        primaryStage.setTitle("JavaFX 예제");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

### 예제 4-2: JavaFX 버튼 이벤트
```java
// ButtonExample.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class ButtonExample extends Application {
    
    private int clickCount = 0;
    
    @Override
    public void start(Stage primaryStage) {
        // UI 컴포넌트 생성
        Label label = new Label("버튼을 클릭하세요!");
        Button button = new Button("클릭!");
        
        // 버튼 이벤트 처리
        button.setOnAction(e -> {
            clickCount++;
            label.setText("클릭 횟수: " + clickCount);
        });
        
        // 레이아웃 설정
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(label, button);
        
        // 장면과 무대 설정
        Scene scene = new Scene(root, 250, 150);
        primaryStage.setTitle("버튼 이벤트 예제");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

## 5. 환경별 프로젝트 구조

### 예제 5-1: 커맨드 라인 프로젝트 구조
```
javawork/
├── HelloWorld.java
├── SimpleInput.java
├── textio/
│   └── TextIO.java
├── com/
│   └── example/
│       ├── util/
│       │   └── Calculator.java
│       └── main/
│           └── MainApp.java
└── output.txt
```

### 예제 5-2: Eclipse 프로젝트 구조
```
MyProject/
├── src/
│   ├── (default package)/
│   │   ├── HelloWorld.java
│   │   └── SimpleInput.java
│   ├── textio/
│   │   └── TextIO.java
│   └── com/
│       └── example/
│           ├── util/
│           │   └── Calculator.java
│           └── main/
│               └── MainApp.java
├── bin/  (컴파일된 클래스 파일)
└── .project (Eclipse 설정 파일)
```

## 6. 배치 스크립트/쉘 스크립트 예제

### 예제 6-1: Windows 배치 파일 (compile.bat)
```batch
@echo off
echo Java 파일 컴파일 중...
javac -encoding UTF-8 %1
if %errorlevel% == 0 (
    echo 컴파일 성공!
) else (
    echo 컴파일 실패!
)
```

### 예제 6-2: Linux/Mac 쉘 스크립트 (compile.sh)
```bash
#!/bin/bash
echo "Java 파일 컴파일 중..."
javac -encoding UTF-8 "$1"
if [ $? -eq 0 ]; then
    echo "컴파일 성공!"
else
    echo "컴파일 실패!"
fi
```

### 예제 6-3: JavaFX 실행 스크립트
**Windows (runfx.bat)**
```batch
@echo off
set JAVAFX_PATH=C:\javafx-sdk-17\lib
java --module-path "%JAVAFX_PATH%" --add-modules ALL-MODULE-PATH %1
```

**Linux/Mac (runfx.sh)**
```bash
#!/bin/bash
JAVAFX_PATH="/home/user/javafx-sdk-17/lib"
java --module-path "$JAVAFX_PATH" --add-modules ALL-MODULE-PATH "$1"
```

## 7. 환경 설정 예제

### 예제 7-1: .bashrc 설정 (Linux)
```bash
# Java 환경 변수
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH

# JavaFX 별칭
alias jfxc='javac --module-path /home/user/javafx-sdk-17/lib --add-modules ALL-MODULE-PATH'
alias jfx='java --module-path /home/user/javafx-sdk-17/lib --add-modules ALL-MODULE-PATH'

# 작업 디렉토리 별칭
alias javawork='cd ~/Documents/javawork'
```

### 예제 7-2: Eclipse 실행 구성
```xml
<!-- .metadata/.plugins/org.eclipse.debug.core/.launches/HelloFX.launch -->
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<launchConfiguration type="org.eclipse.jdt.launching.localJavaApplication">
    <stringAttribute key="org.eclipse.jdt.launching.MAIN_TYPE" value="HelloFX"/>
    <stringAttribute key="org.eclipse.jdt.launching.PROJECT_ATTR" value="MyProject"/>
    <stringAttribute key="org.eclipse.jdt.launching.VM_ARGUMENTS" 
                     value="--module-path /path/to/javafx/lib --add-modules ALL-MODULE-PATH"/>
</launchConfiguration>
```

## 8. 디버깅과 문제 해결

### 예제 8-1: 일반적인 오류와 해결
```java
// CommonErrors.java
public class CommonErrors {
    public static void main(String[] args) {
        // 1. NoClassDefFoundError 예방
        System.out.println("클래스패스: " + System.getProperty("java.class.path"));
        
        // 2. 인코딩 문제 확인
        System.out.println("파일 인코딩: " + System.getProperty("file.encoding"));
        
        // 3. Java 버전 확인
        System.out.println("Java 버전: " + System.getProperty("java.version"));
        
        // 4. 운영체제 정보
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));
        
        // 5. 현재 작업 디렉토리
        System.out.println("작업 디렉토리: " + System.getProperty("user.dir"));
    }
}
```

### 예제 8-2: 환경 검증 프로그램
```java
// EnvironmentCheck.java
import java.io.File;

public class EnvironmentCheck {
    public static void main(String[] args) {
        System.out.println("=== Java 환경 검증 ===\n");
        
        // Java 버전 확인
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java 버전: " + javaVersion);
        
        int majorVersion = Integer.parseInt(javaVersion.split("\\.")[0]);
        if (majorVersion >= 17) {
            System.out.println("✓ Java 17 이상 확인됨");
        } else {
            System.out.println("✗ Java 17 이상이 필요합니다!");
        }
        
        // TextIO 확인
        File textIODir = new File("textio");
        File textIOFile = new File("textio/TextIO.java");
        
        if (textIODir.exists() && textIOFile.exists()) {
            System.out.println("✓ TextIO 설정 확인됨");
        } else {
            System.out.println("✗ TextIO가 올바르게 설정되지 않았습니다!");
            System.out.println("  textio 폴더를 생성하고 TextIO.java를 넣어주세요.");
        }
        
        // JavaFX 확인 (선택사항)
        try {
            Class.forName("javafx.application.Application");
            System.out.println("✓ JavaFX 사용 가능");
        } catch (ClassNotFoundException e) {
            System.out.println("! JavaFX가 설정되지 않았습니다 (선택사항)");
        }
    }
}
```