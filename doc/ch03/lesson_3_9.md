# 3.9 GUI 프로그래밍 소개

## 학습 목표
- JavaFX를 사용한 GUI 프로그래밍의 기본 개념 이해
- 그래픽 컨텍스트와 좌표 시스템 학습
- 기본 도형 그리기와 색상 설정 방법 습득
- 애니메이션의 기본 원리와 구현 방법 이해

## 주요 개념

### 1. GUI 프로그래밍과 JavaFX

**GUI (Graphical User Interface)**
- 사용자와 프로그램이 그래픽 요소를 통해 상호작용
- 창, 버튼, 메뉴 등의 시각적 요소로 구성
- JavaFX: Java의 GUI 프로그래밍 툴킷

**JavaFX 특징**
- GUI 프로그램 작성을 위한 클래스 라이브러리
- 다양한 그래픽 요소와 애니메이션 지원
- 이벤트 처리 및 사용자 상호작용 지원

**참고**
- [JavaFX 가이드](./java_fx_guide.md)

### 2. JavaFX 개발 환경 설정

#### IntelliJ IDEA에서 JavaFX 프로젝트 생성

**1. 새 프로젝트 생성**
- File → New → Project 선택
- 좌측 메뉴에서 "JavaFX" 선택
- Project SDK: Java 17 이상 선택
- JavaFX 버전 선택 (예: 17.0.2)
- Next 클릭

**2. 프로젝트 설정**
- Project name: 프로젝트 이름 입력
- Project location: 프로젝트 저장 위치 선택
- Base package: 패키지명 입력 (예: com.example)
- Finish 클릭

**3. JavaFX 라이브러리 설정 (수동 설정이 필요한 경우)**
- File → Project Structure (Ctrl+Alt+Shift+S)
- Libraries → + 버튼 → Java 선택
- JavaFX lib 폴더 선택 (다운로드한 JavaFX SDK의 lib 폴더)
- Apply → OK

**4. 실행 구성 설정**
- Run → Edit Configurations
- VM options에 다음 추가:
```
--module-path "JavaFX경로/lib" --add-modules javafx.controls,javafx.fxml
```

#### Visual Studio Code에서 JavaFX 프로젝트 설정

**1. 필수 확장 프로그램 설치**
- Extension Pack for Java 설치
- JavaFX Support 확장 프로그램 설치

**2. 프로젝트 폴더 구조 생성**
```
my-javafx-project/
├── src/
│   └── Main.java
├── lib/
│   └── (JavaFX jar 파일들)
└── .vscode/
    ├── settings.json
    └── launch.json
```

**3. JavaFX 다운로드 및 설정**
- [OpenJFX 웹사이트](https://openjfx.io)에서 JavaFX SDK 다운로드
- 압축 해제 후 lib 폴더의 내용을 프로젝트의 lib 폴더로 복사

**4. VS Code 설정 파일 구성**

**.vscode/settings.json**:
```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

**.vscode/launch.json**:
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch JavaFX App",
            "request": "launch",
            "mainClass": "Main",
            "vmArgs": "--module-path lib --add-modules javafx.controls,javafx.fxml"
        }
    ]
}
```

**5. 샘플 코드 작성 (src/Main.java)**
```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello JavaFX!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("My JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

#### 명령줄에서 JavaFX 프로그램 실행

**컴파일**:
```bash
javac --module-path /path/to/javafx/lib --add-modules javafx.controls Main.java
```

**실행**:
```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls Main
```

### 3. JavaFX Application 기본 구조

**JavaFX 프로그램의 기본 구조**
```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyFirstGUI extends Application {

    public static void main(String[] args) {
        launch(args);  // JavaFX 애플리케이션 시작
    }

    @Override
    public void start(Stage stage) {
        // 캔버스 생성 (그리기 영역)
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext g = canvas.getGraphicsContext2D();

        // 그리기 작업 수행
        drawPicture(g, 600, 400);

        // 레이아웃에 캔버스 추가
        BorderPane root = new BorderPane(canvas);

        // Scene 생성 및 Stage에 설정
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("나의 첫 JavaFX 프로그램");
        stage.show();
    }

    private void drawPicture(GraphicsContext g, int width, int height) {
        // 배경 채우기
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 간단한 도형 그리기
        g.setFill(Color.BLUE);
        g.fillOval(100, 100, 200, 200);  // 파란색 원

        g.setStroke(Color.RED);
        g.setLineWidth(3);
        g.strokeRect(200, 150, 150, 100);  // 빨간색 사각형 윤곽선
    }
}
```

**주요 구성 요소**
1. **Application 클래스 상속**
   - JavaFX 애플리케이션은 `Application` 클래스를 상속
   - `start()` 메서드를 반드시 재정의

2. **main 메서드**
   - `launch(args)`를 호출하여 JavaFX 애플리케이션 시작
   - JavaFX 런타임이 `start()` 메서드를 자동으로 호출

3. **start 메서드**
   - Stage: 애플리케이션 창
   - Scene: 창의 내용물을 담는 컨테이너
   - Canvas: 실제 그리기가 수행되는 영역

4. **GraphicsContext**
   - Canvas에서 `getGraphicsContext2D()`로 획득
   - 모든 그리기 작업은 이 객체를 통해 수행

**애니메이션을 위한 구조**
```java
import javafx.animation.AnimationTimer;

public class AnimatedGUI extends Application {

    private int frameNumber = 0;
    private long startTime;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext g = canvas.getGraphicsContext2D();

        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("애니메이션 예제");
        stage.show();

        // 애니메이션 타이머 시작
        startTime = System.nanoTime();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double elapsedSeconds = (now - startTime) / 1e9;
                drawFrame(g, frameNumber++, elapsedSeconds, 600, 400);
            }
        };
        timer.start();
    }

    private void drawFrame(GraphicsContext g, int frameNumber,
                          double elapsedSeconds, int width, int height) {
        // 프레임마다 호출되는 그리기 메서드
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 애니메이션 그리기 코드
    }
}
```

### 4. 픽셀과 좌표 시스템

**픽셀 (Pixel)**
- 화면을 구성하는 가장 작은 단위
- 일반적으로 1인치당 약 100픽셀
- 각 픽셀은 색상 정보를 가짐

**좌표 시스템**
```
(0,0) ────────> X축 (증가)
  │
  │
  ↓
Y축 (증가)
```
- 왼쪽 상단이 원점 (0,0)
- X 좌표: 왼쪽에서 오른쪽으로 증가
- Y 좌표: 위에서 아래로 증가

### 5. 그래픽 컨텍스트 (GraphicsContext)

**그래픽 컨텍스트란?**
- 그리기 작업을 수행하는 객체
- 그리기 도구와 설정을 포함
- 변수 타입: `GraphicsContext`

**주요 구성 요소**
- 그리기 메서드: 선, 사각형, 원 등을 그리는 서브루틴
- 색상 설정: 채우기 색상과 윤곽선 색상
- 선 속성: 선 너비, 스타일 등
- 그리기 표면: 실제 그림이 그려지는 영역

### 6. 색상 설정

**채우기 색상 (Fill Color)**
```java
g.setFill(Color.RED);     // 빨간색으로 채우기 색상 설정
g.fillRect(x, y, w, h);   // 빨간색으로 채워진 사각형
```

**윤곽선 색상 (Stroke Color)**
```java
g.setStroke(Color.BLUE);  // 파란색으로 윤곽선 색상 설정
g.strokeRect(x, y, w, h); // 파란색 윤곽선 사각형
```

**표준 색상**
- 기본 색상: BLACK, WHITE, RED, GREEN, BLUE, YELLOW
- 추가 색상: CORNFLOWERBLUE 등 다양한 색상명 지원

### 7. 기본 도형 그리기

**선 그리기**
```java
g.strokeLine(x1, y1, x2, y2);  // (x1,y1)에서 (x2,y2)로 선 그리기
```

**사각형 그리기**
```java
g.strokeRect(x, y, width, height);  // 윤곽선만
g.fillRect(x, y, width, height);    // 채워진 사각형
```

**타원/원 그리기**
```java
g.strokeOval(x, y, width, height);  // 윤곽선만
g.fillOval(x, y, width, height);    // 채워진 타원
// 원을 그리려면 width와 height를 같게 설정
```

**선 너비 설정**
```java
g.setLineWidth(3);  // 3픽셀 너비의 선
```

## 프로그래밍 패턴

### 1. 반복 패턴을 이용한 그리기

**평행선 그리기 예제**
```java
// 10개의 평행선 그리기
for (int y = 50; y <= 140; y += 10) {
    g.strokeLine(100, y, 300, y);
}
```

**패턴의 특징**
- 반복되는 도형의 규칙 찾기
- 변하는 값을 변수로 처리
- for 루프를 사용한 반복

### 2. 무작위 요소 활용

**무작위 색상 선택**
```java
switch ((int)(4 * Math.random())) {
    case 0 -> g.setFill(Color.RED);
    case 1 -> g.setFill(Color.GREEN);
    case 2 -> g.setFill(Color.BLUE);
    case 3 -> g.setFill(Color.YELLOW);
}
```

**무작위 위치 선택**
```java
int centerX = (int)(width * Math.random());
int centerY = (int)(height * Math.random());
```

### 3. 프로그램 구조

**그리기 서브루틴**
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // 배경 채우기
    g.setFill(Color.WHITE);
    g.fillRect(0, 0, width, height);

    // 그리기 코드
    // ...
}
```

**서브루틴의 매개변수**
- `GraphicsContext g`: 그리기 도구
- `int width`: 그리기 영역의 너비
- `int height`: 그리기 영역의 높이

## 애니메이션

### 1. 애니메이션의 원리

**프레임 기반 애니메이션**
- 연속된 이미지(프레임)를 빠르게 표시
- 초당 약 60프레임 표시
- 프레임 간 작은 변화로 움직임 표현

### 2. 애니메이션 서브루틴

```java
public void drawFrame(GraphicsContext g, int frameNumber,
                     double elapsedSeconds, int width, int height) {
    // 프레임 그리기 코드
}
```

**애니메이션 매개변수**
- `frameNumber`: 현재 프레임 번호 (0, 1, 2, ...)
- `elapsedSeconds`: 경과 시간 (초)

### 3. 애니메이션 구현 기법

**프레임 번호 활용**
```java
int inset = frameNumber % 15;  // 0~14 반복
```

**시간 기반 애니메이션**
```java
double angle = elapsedSeconds * 60;  // 초당 60도 회전
```

## 실습 예제 분석

### 1. 평행선 그리기
- 고정된 시작점과 끝점
- 규칙적인 Y 좌표 증가
- for 루프를 통한 반복

### 2. 무작위 원 그리기
- 무작위 색상 선택 (4가지 중 1개)
- 무작위 위치 선택
- 고정된 크기 (반지름 50픽셀)
- 검은색 윤곽선 추가

### 3. 움직이는 사각형 애니메이션
- 중첩된 사각형 패턴
- 프레임마다 위치 이동
- while 루프를 통한 중첩 그리기
- 모듈로 연산으로 반복 효과

## 주의사항

1. **좌표 계산**
   - 도형의 기준점 이해 (왼쪽 상단)
   - 중심 좌표와 기준점 변환

2. **색상 설정**
   - 그리기 전에 색상 설정
   - 채우기와 윤곽선 색상 구분

3. **애니메이션 성능**
   - 효율적인 그리기 코드 작성
   - 불필요한 계산 최소화

## 요약

JavaFX를 사용한 GUI 프로그래밍은 그래픽 컨텍스트를 통해 다양한 도형을 그리고 애니메이션을 만들 수 있게 합니다. 좌표 시스템의 이해, 색상 설정, 기본 도형 그리기 메서드의 활용이 중요하며, 반복문과 조건문 등 기본 프로그래밍 구조를 활용하여 복잡한 그래픽과 애니메이션을 구현할 수 있습니다.