# 3.9 GUI 프로그래밍 - 예제 모음

## 1. 기본 도형 그리기 예제

### 예제 1-1: 간단한 도형 그리기

#### 요구사항
- 화면에 다양한 기본 도형 그리기
- 수평선 하나와 대각선 하나 그리기
- 윤곽선만 있는 파란색 사각형 그리기
- 빨간색으로 채워진 사각형 그리기
- 노란색으로 채워진 사각형과 검은색 윤곽선 함께 그리기
- 초록색으로 채워진 원 그리기
- 보라색 윤곽선의 타원 그리기

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 선 그리기
    // 힌트: strokeLine() 사용
    
    // 여기에 코드를 작성하세요
    
    // TODO: 사각형 그리기
    // 힌트: strokeRect(), fillRect() 사용
    
    // 여기에 코드를 작성하세요
    
    // TODO: 원과 타원 그리기
    // 힌트: fillOval(), strokeOval() 사용
    
    // 여기에 코드를 작성하세요
}
```

### 예제 1-2: 집 모양 그리기

#### 요구사항
- 갈색 사각형으로 집 몸체 그리기 (200x150 크기)
- 빨간색 선으로 삼각형 지붕 그리기
- 진한 초록색으로 문 그리기 (40x80 크기)
- 하늘색으로 창문 2개 그리기 (각각 40x40 크기)

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 집 그리기
    // 힌트: 좌표를 잘 계산하여 각 부분이 적절히 배치되도록
    
    // 여기에 코드를 작성하세요
}
```

## 2. 반복문을 활용한 패턴 예제

### 예제 2-1: 격자 패턴 그리기

#### 요구사항
- 화면 전체에 20픽셀 간격의 격자 그리기
- 회색 선으로 그리기
- 선 두께는 1픽셀
- 화면 크기에 맞춰 자동으로 격자 수 조정

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 격자 패턴 그리기
    // 힌트: 두 개의 for 루프 사용 (세로선용, 가로선용)
    
    // 여기에 코드를 작성하세요
}
```

### 예제 2-2: 동심원 패턴

#### 요구사항
- 화면 중앙을 중심으로 하는 동심원 10개 그리기
- 가장 작은 원의 반지름은 10픽셀
- 각 원의 반지름은 20픽셀씩 증가
- 파란색 선으로 그리기, 선 두께 2픽셀

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 동심원 그리기
    // 힌트: 중심 좌표 계산, for 루프로 반지름 증가
    
    // 여기에 코드를 작성하세요
}
```

### 예제 2-3: 체스판 패턴

#### 요구사항
- 8x8 체스판 그리기
- 검은색과 흰색 사각형이 번갈아 나타나도록
- 각 사각형의 크기는 50x50 픽셀
- 첫 번째 사각형(0,0)은 흰색으로 시작

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 체스판 그리기
    // 힌트: 이중 for 루프, (i+j)%2로 색상 결정
    
    // 여기에 코드를 작성하세요
}
```

## 3. 무작위 요소 활용 예제

### 예제 3-1: 별이 빛나는 밤하늘

#### 요구사항
- 검은색 배경 (밤하늘)
- 흰색 또는 노란색 원으로 별 50개 그리기
- 별의 위치는 무작위
- 별의 크기는 2~6픽셀 사이에서 무작위

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 밤하늘과 별 그리기
    // 힌트: Math.random() 사용
    
    // 여기에 코드를 작성하세요
}
```

### 예제 3-2: 무지개 공 떨어뜨리기

#### 요구사항
- 화면 상단의 무작위 위치에서 공 20개 생성
- 각 공은 빨강, 주황, 노랑, 초록, 파랑 중 무작위 색상
- 공의 크기는 20~50픽셀 사이에서 무작위
- 공들이 겹쳐도 됨

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 무작위 색상과 크기의 공들 그리기
    // 힌트: switch문으로 색상 선택
    
    // 여기에 코드를 작성하세요
}
```

## 4. 복합 도형 예제

### 예제 4-1: 신호등 그리기

#### 요구사항
- 검은색 직사각형 몸체 (100x250 크기)
- 빨간불, 노란불, 초록불을 위에서부터 순서대로 배치
- 각 불은 지름 50픽셀의 원
- 불 사이 간격은 균등하게

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 신호등 그리기
    // 힌트: 각 불의 y 좌표를 잘 계산
    
    // 여기에 코드를 작성하세요
}
```

### 예제 4-2: 눈사람 그리기

#### 요구사항
- 흰색 원 3개로 몸통 구성 (아래에서 위로 크기 감소)
- 검은색 원으로 눈 2개
- 주황색 삼각형으로 코 (선으로 그리기)
- 검은색 원 여러 개로 입 표현

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 눈사람 그리기
    // 힌트: 각 부분의 크기와 위치를 적절히 계산
    
    // 여기에 코드를 작성하세요
}
```

## 5. 애니메이션 예제

### 예제 5-1: 좌우로 움직이는 공

#### 요구사항
- 빨간색 공이 화면을 좌우로 왕복
- 공의 크기는 40x40 픽셀
- 화면 끝에 닿으면 방향 전환
- 부드러운 움직임 구현

#### 예제 코드
```java
public void drawFrame(GraphicsContext g, int frameNumber,
                     double elapsedSeconds, int width, int height) {
    // 배경 지우기
    g.setFill(Color.WHITE);
    g.fillRect(0, 0, width, height);
    
    // TODO: 왕복하는 공 구현
    // 힌트: 삼각함수나 조건문으로 방향 전환
    
    // 여기에 코드를 작성하세요
}
```

### 예제 5-2: 회전하는 풍차

#### 요구사항
- 화면 중앙에 고정된 중심점
- 4개의 날개가 중심점을 기준으로 회전
- 각 날개는 서로 다른 색상
- 일정한 속도로 회전

#### 예제 코드
```java
public void drawFrame(GraphicsContext g, int frameNumber,
                     double elapsedSeconds, int width, int height) {
    // 배경 지우기
    g.setFill(Color.LIGHTBLUE);
    g.fillRect(0, 0, width, height);
    
    // TODO: 회전하는 풍차 구현
    // 힌트: 삼각함수로 회전 좌표 계산
    
    // 여기에 코드를 작성하세요
}
```

### 예제 5-3: 깜빡이는 별

#### 요구사항
- 5개의 별이 서로 다른 속도로 깜빡임
- 별의 크기가 주기적으로 변함 (최소 10픽셀, 최대 30픽셀)
- 각 별은 고정된 위치
- 부드러운 크기 변화

#### 예제 코드
```java
public void drawFrame(GraphicsContext g, int frameNumber,
                     double elapsedSeconds, int width, int height) {
    // 배경 지우기 (밤하늘)
    g.setFill(Color.BLACK);
    g.fillRect(0, 0, width, height);
    
    // TODO: 깜빡이는 별들 구현
    // 힌트: Math.sin()으로 부드러운 변화
    
    // 여기에 코드를 작성하세요
}
```

## 6. 종합 프로젝트

### 예제 6-1: 풍경화 그리기

#### 요구사항
- 하늘: 하늘색 배경
- 태양: 오른쪽 상단에 노란색 원
- 구름: 흰색 타원 여러 개를 조합하여 구름 2개
- 산: 갈색 삼각형 2개 (겹쳐서 원근감 표현)
- 잔디: 초록색 사각형
- 나무: 갈색 줄기와 초록색 잎
- 꽃: 빨강, 노랑, 분홍색 원으로 여러 개

#### 예제 코드
```java
public void drawPicture(GraphicsContext g, int width, int height) {
    // TODO: 아름다운 풍경화 그리기
    // 힌트: 뒤에서 앞으로 순서대로 그리기
    
    // 여기에 코드를 작성하세요
}
```

### 예제 6-2: 움직이는 자동차

#### 요구사항
- 도로: 회색 사각형과 흰색 중앙선
- 자동차: 빨간색 몸체, 검은색 바퀴 2개
- 자동차가 왼쪽에서 오른쪽으로 이동
- 화면을 벗어나면 다시 왼쪽에서 시작
- 중앙선도 움직여서 도로가 움직이는 효과

#### 예제 코드
```java
public void drawFrame(GraphicsContext g, int frameNumber,
                     double elapsedSeconds, int width, int height) {
    // 배경 (하늘)
    g.setFill(Color.SKYBLUE);
    g.fillRect(0, 0, width, height/2);
    
    // 도로
    g.setFill(Color.GRAY);
    g.fillRect(0, height/2, width, height/2);
    
    // TODO: 움직이는 중앙선
    // 힌트: 점선 효과를 위해 여러 개의 작은 사각형
    
    // 여기에 코드를 작성하세요
    
    // TODO: 움직이는 자동차
    // 힌트: 자동차의 각 부분을 상대 좌표로 그리기
    
    // 여기에 코드를 작성하세요
}
```

### 예제 6-3: 시계 만들기

#### 요구사항
- 원형 시계 테두리 (검은색)
- 12개의 시간 표시 (작은 선이나 점)
- 시침, 분침, 초침 (각각 다른 길이와 색상)
- 초침은 실제로 회전 (1초에 6도)
- 중앙에 작은 원 (축)

#### 예제 코드
```java
public void drawFrame(GraphicsContext g, int frameNumber,
                     double elapsedSeconds, int width, int height) {
    // 배경
    g.setFill(Color.WHITE);
    g.fillRect(0, 0, width, height);
    
    int centerX = width / 2;
    int centerY = height / 2;
    int radius = 150;
    
    // TODO: 시계 구현
    // 힌트: 각도를 라디안으로 변환, Math.cos()와 Math.sin() 사용
    
    // 여기에 코드를 작성하세요
}
```