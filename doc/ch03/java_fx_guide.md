# JavaFX 가이드

## 목차
1. [JavaFX란?](#javafx란)
2. [개발 환경 설정](#개발-환경-설정)
3. [IntelliJ에서 JavaFX 프로젝트 생성](#intellij에서-javafx-프로젝트-생성)
4. [VSCode에서 JavaFX 프로젝트 생성](#vscode에서-javafx-프로젝트-생성)
5. [JavaFX 애플리케이션 기본 구조](#javafx-애플리케이션-기본-구조)
6. [주요 컴포넌트와 기능](#주요-컴포넌트와-기능)
7. [실전 예제](#실전-예제)
8. [자주 발생하는 문제와 해결 방법](#자주-발생하는-문제와-해결-방법)

## JavaFX란?

JavaFX는 Java로 풍부한 데스크톱 애플리케이션을 개발할 수 있는 현대적인 GUI 프레임워크입니다. Swing의 후계자로, 더 현대적이고 유연한 UI 개발을 지원합니다.

### 주요 특징
- **현대적인 UI**: CSS 스타일링 지원
- **FXML**: XML 기반의 UI 레이아웃 정의
- **Scene Graph**: 계층적 노드 구조
- **Rich Media**: 오디오, 비디오, 애니메이션 지원
- **WebView**: 웹 콘텐츠 통합

## 개발 환경 설정

### 필수 요구사항
1. **Java JDK**: JDK 11 이상 (권장: JDK 17 LTS)
2. **JavaFX SDK**: 별도 다운로드 필요
3. **IDE**: IntelliJ IDEA 또는 VSCode

### JavaFX SDK 다운로드
1. [OpenJFX 공식 사이트](https://openjfx.io/) 방문
2. Downloads 섹션에서 OS에 맞는 JavaFX SDK 다운로드
3. 압축 해제 후 적절한 위치에 저장 (예: `C:\javafx-21` 또는 `/usr/local/javafx-21`)

## IntelliJ에서 JavaFX 프로젝트 생성

### 1단계: 새 프로젝트 생성
1. IntelliJ IDEA 실행
2. **File → New → Project** 선택
3. 왼쪽 패널에서 **JavaFX** 선택
4. 프로젝트 정보 입력:
   - Name: `MyFirstJavaFXApp`
   - Location: 원하는 디렉토리
   - Language: Java
   - Build system: Maven 또는 Gradle (Maven 권장)
   - JDK: 설치된 JDK 선택

### 2단계: JavaFX 라이브러리 설정 (Maven 사용 시)
`pom.xml` 파일에 다음 의존성 추가:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>21</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>21</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>0.0.8</version>
            <configuration>
                <mainClass>com.example.myfirstjavafxapp.HelloApplication</mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### 3단계: 실행 구성
1. **Run → Edit Configurations** 선택
2. VM options에 다음 추가:
```
--module-path "경로/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
```

## VSCode에서 JavaFX 프로젝트 생성

### 1단계: 필수 확장 프로그램 설치
1. VSCode 열기
2. Extensions (Ctrl+Shift+X) 열기
3. 다음 확장 프로그램 설치:
   - Extension Pack for Java
   - JavaFX Support

### 2단계: 프로젝트 구조 생성
```
MyJavaFXProject/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   ├── App.java
│                   └── Controller.java
├── lib/
│   └── (JavaFX jar 파일들)
├── .vscode/
│   ├── settings.json
│   └── launch.json
└── module-info.java
```

### 3단계: VSCode 설정 파일 구성

**.vscode/settings.json:**
```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

**.vscode/launch.json:**
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch App",
            "request": "launch",
            "mainClass": "com.example.App",
            "vmArgs": "--module-path lib --add-modules javafx.controls,javafx.fxml"
        }
    ]
}
```

## JavaFX 애플리케이션 기본 구조

### 기본 애플리케이션 클래스
```java
package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 루트 컨테이너 생성
        StackPane root = new StackPane();

        // 라벨 생성 및 추가
        Label label = new Label("Hello, JavaFX!");
        root.getChildren().add(label);

        // Scene 생성 (너비: 300, 높이: 200)
        Scene scene = new Scene(root, 300, 200);

        // Stage 설정
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

### 핵심 개념 설명

#### 1. Application 클래스
- JavaFX 애플리케이션의 진입점
- `start()` 메서드: 애플리케이션 초기화 및 UI 구성
- `launch()` 메서드: JavaFX 런타임 시작

#### 2. Stage (무대)
- 최상위 컨테이너 (윈도우)
- 타이틀바, 최소화/최대화/닫기 버튼 포함
- 하나의 Scene을 포함

#### 3. Scene (장면)
- Stage 내부의 콘텐츠 컨테이너
- 루트 노드와 크기 정의
- CSS 스타일시트 적용 가능

#### 4. Node (노드)
- UI 요소의 기본 단위
- 모든 UI 컴포넌트는 Node를 상속
- Scene Graph 구조로 계층화

## 주요 컴포넌트와 기능

### 1. 레이아웃 컨테이너

#### VBox (수직 배치)
```java
VBox vbox = new VBox(10); // 10픽셀 간격
vbox.setPadding(new Insets(15));
vbox.getChildren().addAll(button1, button2, button3);
```

#### HBox (수평 배치)
```java
HBox hbox = new HBox(10);
hbox.setAlignment(Pos.CENTER);
hbox.getChildren().addAll(label, textField, button);
```

#### GridPane (격자 배치)
```java
GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.add(nameLabel, 0, 0);
grid.add(nameField, 1, 0);
grid.add(emailLabel, 0, 1);
grid.add(emailField, 1, 1);
```

### 2. 기본 컨트롤

#### Button
```java
Button btn = new Button("Click Me!");
btn.setOnAction(e -> {
    System.out.println("Button clicked!");
});
```

#### TextField
```java
TextField textField = new TextField();
textField.setPromptText("Enter your name");
String text = textField.getText();
```

#### Label
```java
Label label = new Label("Welcome!");
label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
```

#### ComboBox
```java
ComboBox<String> comboBox = new ComboBox<>();
comboBox.getItems().addAll("Option 1", "Option 2", "Option 3");
comboBox.setOnAction(e -> {
    String selected = comboBox.getValue();
    System.out.println("Selected: " + selected);
});
```

### 3. 이벤트 처리

#### 클릭 이벤트
```java
button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        // 이벤트 처리 코드
    }
});

// Lambda 표현식 사용
button.setOnAction(e -> {
    // 이벤트 처리 코드
});
```

#### 키보드 이벤트
```java
textField.setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.ENTER) {
        // Enter 키 처리
    }
});
```

#### 마우스 이벤트
```java
node.setOnMouseClicked(e -> {
    if (e.getButton() == MouseButton.PRIMARY) {
        // 왼쪽 클릭 처리
    }
});
```

## 실전 예제

### 간단한 로그인 화면
```java
package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Login");

        // GridPane 레이아웃 생성
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // 타이틀
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // 사용자명 라벨과 텍스트필드
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        // 비밀번호 라벨과 패스워드필드
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        // 로그인 버튼
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        // 액션 텍스트
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        // 버튼 이벤트 처리
        btn.setOnAction(e -> {
            String username = userTextField.getText();
            String password = pwBox.getText();

            if (username.isEmpty() || password.isEmpty()) {
                actiontarget.setText("Please enter credentials");
                actiontarget.setStyle("-fx-fill: red;");
            } else {
                actiontarget.setText("Login successful!");
                actiontarget.setStyle("-fx-fill: green;");
            }
        });

        // Scene 생성 및 표시
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

### FXML을 사용한 UI 분리

**LoginView.fxml:**
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.text.*?>

<GridPane alignment="center" hgap="10" vgap="10"
          xmlns:fx="http://javafx.com/fxml"
          fx:controller="com.example.LoginController">
    <padding>
        <Insets top="25" right="25" bottom="25" left="25"/>
    </padding>

    <Text text="Welcome" GridPane.columnIndex="0" GridPane.rowIndex="0"
          GridPane.columnSpan="2">
        <font>
            <Font name="Tahoma" size="20"/>
        </font>
    </Text>

    <Label text="User Name:" GridPane.columnIndex="0" GridPane.rowIndex="1"/>
    <TextField fx:id="userTextField" GridPane.columnIndex="1" GridPane.rowIndex="1"/>

    <Label text="Password:" GridPane.columnIndex="0" GridPane.rowIndex="2"/>
    <PasswordField fx:id="passwordField" GridPane.columnIndex="1" GridPane.rowIndex="2"/>

    <HBox spacing="10" alignment="bottom_right"
          GridPane.columnIndex="1" GridPane.rowIndex="4">
        <Button text="Sign In" onAction="#handleSubmitButtonAction"/>
    </HBox>

    <Text fx:id="actiontarget" GridPane.columnIndex="1" GridPane.rowIndex="6"/>
</GridPane>
```

**LoginController.java:**
```java
package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    @FXML private Text actiontarget;
    @FXML private TextField userTextField;
    @FXML private PasswordField passwordField;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        String username = userTextField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            actiontarget.setText("Please enter credentials");
            actiontarget.setStyle("-fx-fill: red;");
        } else {
            actiontarget.setText("Login successful!");
            actiontarget.setStyle("-fx-fill: green;");
        }
    }
}
```

**FXML 로드하는 메인 클래스:**
```java
package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLLoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginView.fxml"));

        Scene scene = new Scene(root, 300, 275);

        primaryStage.setTitle("FXML Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

## 자주 발생하는 문제와 해결 방법

### 1. "JavaFX runtime components are missing"
**원인**: JavaFX 모듈이 클래스패스에 없음
**해결**:
- VM 옵션에 `--module-path`와 `--add-modules` 추가
- Maven/Gradle 의존성 확인

### 2. "Location is required" (FXML 로드 시)
**원인**: FXML 파일 경로가 잘못됨
**해결**:
```java
// 클래스패스 루트부터 시작
Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
```

### 3. CSS 스타일이 적용되지 않음
**원인**: CSS 파일 경로 오류
**해결**:
```java
scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
```

### 4. Controller 클래스를 찾을 수 없음
**원인**: FXML의 controller 속성이 잘못됨
**해결**: 패키지명을 포함한 전체 클래스명 사용
```xml
fx:controller="com.example.controllers.MainController"
```

## 다음 단계

1. **고급 레이아웃**: BorderPane, AnchorPane 학습
2. **데이터 바인딩**: Properties와 Bindings API
3. **애니메이션**: Timeline, Transition 클래스
4. **차트와 그래프**: JavaFX Charts API
5. **CSS 스타일링**: 커스텀 스킨과 테마
6. **Scene Builder**: 비주얼 UI 디자이너 도구

## 유용한 리소스

- [OpenJFX 공식 문서](https://openjfx.io/)
- [JavaFX 튜토리얼](https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm)
- [Scene Builder 다운로드](https://gluonhq.com/products/scene-builder/)
- [JavaFX 샘플 프로젝트](https://github.com/openjfx/samples)
