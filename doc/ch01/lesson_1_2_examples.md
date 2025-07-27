# 1.2 비동기 이벤트: 폴링 루프와 인터럽트 - 실습 예제

## 실습 예제 1: 폴링 vs 인터럽트 시뮬레이션

### 시나리오
간단한 텍스트 에디터를 만든다고 가정해봅시다. 사용자의 키보드 입력을 처리해야 합니다.

### 폴링 방식 (비효율적)
```java
// 의사코드 - 실제 Java 코드가 아닙니다
public class PollingTextEditor {
    public void run() {
        while (true) {
            // CPU가 계속 확인
            if (keyboard.hasInput()) {
                char key = keyboard.readKey();
                document.addCharacter(key);
            }
            
            // 아무 입력이 없어도 CPU는 계속 확인!
            // CPU 사용률: 100%
        }
    }
}
```

### 인터럽트 방식 (효율적)
```java
// 의사코드 - 실제 Java 코드가 아닙니다
public class InterruptTextEditor {
    private Document document = new Document();
    
    public void run() {
        // 키보드 인터럽트 핸들러 등록
        registerKeyboardHandler();
        
        // CPU는 다른 유용한 작업 수행
        while (true) {
            updateScreen();
            checkSpelling();
            autoSave();
            // CPU 사용률: 필요시에만 증가
        }
    }
    
    // 키보드 입력시 자동으로 호출됨
    @InterruptHandler
    public void onKeyboardInput(char key) {
        document.addCharacter(key);
    }
}
```

## 실습 예제 2: 멀티태스킹 시각화

### 단일 CPU에서의 시분할
```java
// 3개의 작업이 동시에 실행되는 것처럼 보이는 예제
public class MultitaskingDemo {
    public static void main(String[] args) {
        // 실제로는 순차적으로 실행되지만
        // 매우 빠르게 전환되어 동시 실행처럼 보임
        
        // 작업 1: 숫자 세기
        Thread counter = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("카운터: " + i);
                // 잠시 대기 (다른 스레드에게 기회 제공)
                Thread.sleep(10);
            }
        });
        
        // 작업 2: 현재 시간 표시
        Thread clock = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("시간: " + new Date());
                Thread.sleep(10);
            }
        });
        
        // 작업 3: 메시지 출력
        Thread messenger = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("메시지 #" + i);
                Thread.sleep(10);
            }
        });
        
        // 모든 작업 시작
        counter.start();
        clock.start();
        messenger.start();
    }
}
```

## 실습 예제 3: 디스크 I/O 시뮬레이션

### 동기식 (블로킹) 방식
```java
// CPU가 디스크 작업을 기다리는 비효율적인 예
public class SynchronousDiskRead {
    public void readFile() {
        System.out.println("파일 읽기 시작...");
        
        // CPU가 디스크 작업이 완료될 때까지 대기
        // 이 시간 동안 CPU는 아무것도 못함!
        byte[] data = disk.readFile("large_file.txt"); // 5초 소요
        
        System.out.println("파일 읽기 완료!");
        processData(data);
    }
}
```

### 비동기식 (논블로킹) 방식
```java
// CPU가 디스크 작업 중에도 다른 일을 하는 효율적인 예
public class AsynchronousDiskRead {
    public void readFile() {
        System.out.println("파일 읽기 요청...");
        
        // 디스크에 읽기 요청만 하고 바로 반환
        disk.requestReadFile("large_file.txt", this::onFileReady);
        
        // CPU는 다른 작업 계속 수행
        System.out.println("다른 작업 수행중...");
        doOtherWork();
    }
    
    // 디스크 읽기 완료시 인터럽트로 호출됨
    public void onFileReady(byte[] data) {
        System.out.println("파일 준비됨! 처리 시작...");
        processData(data);
    }
}
```

## 실습 예제 4: 스레드 상태 전이

```java
public class ThreadStateDemo {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            System.out.println("1. 실행중 상태");
            
            try {
                // I/O 작업 시뮬레이션
                System.out.println("2. 대기중 상태로 전환 (I/O 대기)");
                Thread.sleep(1000); // 1초 대기
                
                System.out.println("3. 다시 준비됨 상태로");
                System.out.println("4. 다시 실행중 상태로");
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("5. 작업 완료");
        });
        
        System.out.println("스레드 상태: " + worker.getState()); // NEW
        
        worker.start();
        System.out.println("스레드 상태: " + worker.getState()); // RUNNABLE
        
        try {
            Thread.sleep(500);
            System.out.println("스레드 상태: " + worker.getState()); // TIMED_WAITING
            
            worker.join();
            System.out.println("스레드 상태: " + worker.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

## 실습 문제

### 문제 1: 폴링 효율성 계산
키보드 입력을 폴링으로 확인하는 프로그램이 있습니다.
- 폴링 주기: 1ms마다 확인
- 평균 타이핑 속도: 분당 40단어 (약 200자)
- 질문: CPU가 실제로 유용한 작업(키 입력 처리)을 하는 시간의 비율은?

**풀이 힌트:**
- 1분 = 60,000ms
- 200자 입력 = 200ms의 처리 시간
- 나머지 59,800ms는 불필요한 확인

### 문제 2: 인터럽트 우선순위
다음 인터럽트들이 동시에 발생했을 때, 어떤 순서로 처리되어야 할까요?
1. 키보드 입력
2. 하드웨어 오류
3. 타이머 인터럽트
4. 네트워크 패킷 도착

**정답 및 설명:**
1. 하드웨어 오류 (최우선 - 시스템 안정성)
2. 타이머 인터럽트 (시스템 시간 관리)
3. 네트워크 패킷 도착 (데이터 손실 방지)
4. 키보드 입력 (사용자 입력은 상대적으로 느림)

### 문제 3: 멀티태스킹 스케줄링
3개의 프로그램 A, B, C가 있습니다.
- A: 30ms 실행 필요
- B: 20ms 실행 필요
- C: 40ms 실행 필요
- 타임 슬라이스: 10ms

각 프로그램이 완료되는 시간을 계산하세요.

**풀이:**
```
시간:  0   10   20   30   40   50   60   70   80   90
실행:  A    B    C    A    B    C    A    C    C
완료:                      B완료      A완료      C완료
```
- B: 50ms에 완료 (총 20ms 실행)
- A: 70ms에 완료 (총 30ms 실행)
- C: 90ms에 완료 (총 40ms 실행)

### 문제 4: 장치 드라이버 역할
다음 상황에서 장치 드라이버가 하는 일을 설명하세요:
"USB 마우스를 컴퓨터에 연결했을 때"

**답안 예시:**
1. USB 컨트롤러가 새 장치 감지
2. 운영체제가 장치 정보 읽기
3. 적절한 마우스 드라이버 로드
4. 드라이버가 마우스와 통신 프로토콜 설정
5. 마우스 움직임을 좌표 데이터로 변환
6. 인터럽트를 통해 OS에 마우스 이벤트 전달

## 추가 학습 과제

### 과제 1: 실생활 예시 찾기
일상생활에서 폴링과 인터럽트의 예시를 각각 3개씩 찾아보세요.

**예시 답안:**
폴링:
1. 냄비의 물이 끓는지 계속 확인하기
2. 택배가 왔는지 현관문을 반복해서 확인하기
3. 친구의 답장을 기다리며 계속 휴대폰 확인하기

인터럽트:
1. 초인종이 울리면 문을 열어주기
2. 전화벨이 울리면 전화 받기
3. 화재경보기가 울리면 대피하기

### 과제 2: 운영체제 비교
Windows, macOS, Linux의 멀티태스킹 방식을 조사하고 비교해보세요.

### 과제 3: 프로그래밍 연습
간단한 타이머 프로그램을 만들어보세요:
- 1초마다 시간 표시
- 동시에 사용자 입력 받기
- 'q' 입력시 종료

```java
// 힌트: Thread 또는 Timer 클래스 사용
public class SimpleTimer {
    private static boolean running = true;
    
    public static void main(String[] args) {
        // 타이머 스레드
        Thread timer = new Thread(() -> {
            int seconds = 0;
            while (running) {
                System.out.println("경과 시간: " + seconds + "초");
                try {
                    Thread.sleep(1000);
                    seconds++;
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        
        timer.start();
        
        // 메인 스레드에서 입력 처리
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                running = false;
                break;
            }
        }
        
        System.out.println("프로그램 종료");
    }
}
```