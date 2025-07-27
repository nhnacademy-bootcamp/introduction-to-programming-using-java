# 2.6 프로그래밍 환경 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- JDK를 다운로드하고 설치할 수 있다
- 커맨드 라인 환경에서 Java 프로그램을 컴파일하고 실행할 수 있다
- Eclipse IDE를 사용하여 Java 프로그램을 개발할 수 있다
- BlueJ를 사용하여 프로그래밍을 학습할 수 있다
- 패키지 구조를 이해하고 사용할 수 있다
- JavaFX를 설정하고 GUI 프로그램을 실행할 수 있다

## 1. Java 개발 환경 개요

### 1.1 두 가지 접근 방식
1. **커맨드 라인 환경**
   - 명령어를 직접 입력
   - 컴퓨터가 텍스트로 응답
   - 전통적이고 강력한 방법

2. **통합 개발 환경(IDE)**
   - 그래픽 사용자 인터페이스
   - 마우스와 키보드로 상호작용
   - 초보자에게 친숙한 환경

### 1.2 필요한 구성 요소
- **JDK (Java Development Kit)**: Java 프로그램 개발 도구
- **텍스트 편집기** 또는 **IDE**: 코드 작성
- **JavaFX** (선택사항): GUI 프로그램 개발

## 2. JDK 설치하기

### 2.1 JDK vs JRE
- **JDK**: 개발 도구 + 실행 환경
- **JRE**: 실행 환경만 포함
- 프로그래밍을 위해서는 반드시 JDK가 필요!

### 2.2 OpenJDK 다운로드
1. **Adoptium 사이트 방문**
   ```
   https://adoptium.net/
   ```

2. **자동 감지 시스템**
   - 운영체제 자동 감지
   - CPU 타입 자동 감지
   - "최신 릴리스" 버튼 클릭

3. **수동 선택 시**
   - **Windows/Mac**: x64 아키텍처
   - **M1 Mac**: aarch64 아키텍처
   - **버전**: Java 17 이상 (LTS 권장)

### 2.3 설치 과정
```text
Windows: .msi 파일 실행
MacOS: .pkg 파일 실행
Linux: 패키지 관리자 사용 또는 압축 파일 해제
```

## 3. 커맨드 라인 환경

### 3.1 터미널 열기
```text
Windows: cmd 실행
MacOS: Terminal 앱 실행
Linux: 터미널 또는 xterm 실행
```

### 3.2 기본 명령어
```bash
# 현재 디렉토리 확인
pwd    # Mac/Linux
cd     # Windows (인자 없이)

# 파일 목록 보기
ls     # Mac/Linux
dir    # Windows

# 디렉토리 이동
cd 디렉토리명

# 디렉토리 만들기
mkdir javawork

# Java 버전 확인
java -version
javac -version
```

### 3.3 Java 프로그램 컴파일과 실행
```bash
# 컴파일
javac HelloWorld.java

# 실행
java HelloWorld

# TextIO 사용 프로그램
javac Interest2.java
java Interest2
```

### 3.4 TextIO 설정
1. 작업 디렉토리에 `textio` 폴더 생성
2. `TextIO.java` 파일을 폴더에 복사
3. 자동으로 함께 컴파일됨

## 4. Eclipse IDE

### 4.1 Eclipse 다운로드
```text
https://www.eclipse.org/downloads/packages/
```
- "Eclipse IDE for Java Developers" 선택
- 운영체제와 CPU에 맞는 버전 다운로드

### 4.2 Eclipse 기본 구조
```
┌─────────────────────────────────────┐
│  메뉴바                              │
├──────────┬─────────────────┬────────┤
│          │                 │        │
│  패키지  │   편집기 영역    │  기타  │
│  탐색기  │                 │  뷰   │
│          │                 │        │
├──────────┴─────────────────┴────────┤
│  콘솔 / 문제 / 기타 뷰              │
└─────────────────────────────────────┘
```

### 4.3 프로젝트 생성
1. File → New → Java Project
2. 프로젝트 이름 입력
3. JRE 버전 선택 (Java 17+)
4. **중요**: "Create module-info.java" 체크 해제!

### 4.4 프로그램 작성과 실행
```java
// 1. 새 클래스 생성
File → New → Class

// 2. 클래스 이름 입력
// 3. 코드 작성
// 4. 실행: 우클릭 → Run As → Java Application
```

### 4.5 Eclipse 주요 기능
- **자동 컴파일**: 저장 시 자동
- **오류 표시**: 빨간 밑줄
- **자동 완성**: Ctrl+Space
- **빠른 수정**: 전구 아이콘 클릭

## 5. BlueJ

### 5.1 BlueJ 특징
- 교육용으로 설계된 간단한 IDE
- JavaFX 포함
- 개별 메소드 실행 가능

### 5.2 BlueJ 사용법
1. 프로젝트 생성: Project → New Project
2. 클래스 생성: "New Class" 버튼
3. 편집: 클래스 아이콘 더블클릭
4. 컴파일: "Compile" 버튼
5. 실행: 우클릭 → "void main(String[] args)"

## 6. 패키지 이해하기

### 6.1 패키지란?
```java
// 패키지 선언
package com.example.myapp;

// 패키지 임포트
import java.util.Scanner;
import textio.TextIO;
```

### 6.2 디렉토리 구조
```
프로젝트/
├── src/
│   ├── HelloWorld.java (기본 패키지)
│   ├── com/
│   │   └── example/
│   │       └── MyClass.java
│   └── textio/
│       └── TextIO.java
```

### 6.3 패키지 사용 규칙
- 클래스 파일은 패키지 구조와 일치하는 폴더에 위치
- 기본 패키지는 초보자에게 권장
- TextIO는 textio 패키지에 위치

## 7. JavaFX 설정

### 7.1 JavaFX 다운로드
```text
https://gluonhq.com/products/javafx/
```
- SDK 버전 선택 (JDK 버전과 일치)
- 운영체제와 아키텍처 확인

### 7.2 커맨드 라인에서 JavaFX
```bash
# 컴파일
javac --module-path=/path/to/javafx/lib --add-modules=ALL-MODULE-PATH MyFXApp.java

# 실행
java --module-path=/path/to/javafx/lib --add-modules=ALL-MODULE-PATH MyFXApp
```

### 7.3 Eclipse에서 JavaFX
1. **JRE 구성**
   - Window → Preferences → Java → Installed JREs
   - JRE 선택 → Duplicate
   - "Add External JARs" → JavaFX lib 폴더의 모든 .jar 파일 추가

2. **VM 인수 설정**
   ```
   --module-path=/path/to/javafx/lib --add-modules=ALL-MODULE-PATH
   ```

3. **프로젝트에서 사용**
   - 새 프로젝트 생성 시 JavaFX 지원 JRE 선택

## 8. jshell 사용하기

### 8.1 jshell이란?
- Java 코드를 즉시 실행할 수 있는 대화형 도구
- 파일 생성 없이 코드 테스트 가능

### 8.2 기본 사용법
```shell
$ jshell
jshell> System.out.println("Hello")
Hello

jshell> int x = 10
x ==> 10

jshell> x * x
$2 ==> 100

jshell> /exit
```

## 실용적인 팁

### 개발 환경 선택 가이드
1. **커맨드 라인**: 
   - 컴퓨터 과학 기초 학습
   - 시스템 이해도 향상
   - 모든 환경에서 사용 가능

2. **Eclipse**:
   - 전문적인 개발
   - 대규모 프로젝트
   - 다양한 도구 지원

3. **BlueJ**:
   - 프로그래밍 입문
   - 교육 목적
   - 간단한 인터페이스

### 일반적인 문제 해결

**"Command not found" 오류**
- JDK가 올바르게 설치되지 않음
- PATH 환경 변수 확인 필요

**컴파일 오류**
- 파일명과 클래스명 일치 확인
- .java 확장자 확인
- 대소문자 구분 확인

**실행 오류**
- 클래스명만 사용 (.class 제외)
- main 메소드 존재 확인
- 패키지 경로 확인

## 요약

- **JDK**: Java 개발의 필수 도구
- **개발 환경**: 커맨드 라인, Eclipse, BlueJ 중 선택
- **패키지**: 코드 구조화의 기본 단위
- **JavaFX**: GUI 프로그램 개발용 라이브러리
- **지속적 학습**: 한 가지 환경에 익숙해진 후 다른 환경도 시도