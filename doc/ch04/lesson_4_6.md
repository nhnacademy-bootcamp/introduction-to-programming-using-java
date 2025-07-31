# 4.6 API, Packages, Modules, Javadoc

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- API의 개념과 중요성을 이해한다
- Java의 패키지 시스템을 활용할 수 있다
- import 문을 올바르게 사용할 수 있다
- Javadoc 주석을 작성하고 문서를 생성할 수 있다
- 모듈의 기본 개념을 이해한다

## 1. API란 무엇인가?

### 1.1 API의 개념
**API (Application Programming Interface)**는 프로그래머가 사용할 수 있는 도구 모음입니다.

비유: API는 공구상자와 같습니다
```
공구상자 = API
망치, 드라이버 = 개별 메서드/클래스
사용 설명서 = API 문서
```

### 1.2 API의 구성 요소
1. **인터페이스**: 사용 가능한 기능의 명세
2. **구현**: 실제 기능을 수행하는 코드
3. **문서**: 사용 방법 설명

```java
// API 사용 예
double result = Math.sqrt(16);  // Math API 사용
String upper = "hello".toUpperCase();  // String API 사용
```

## 2. Java의 패키지 시스템

### 2.1 패키지란?
**패키지**는 관련된 클래스들을 그룹화하는 방법입니다.

```
패키지 구조 예시:
java
├── lang        (기본 클래스들)
│   ├── String
│   ├── Math
│   └── System
├── util        (유틸리티 클래스들)
│   ├── Scanner
│   ├── ArrayList
│   └── Random
└── io          (입출력 클래스들)
    ├── File
    └── PrintWriter
```

### 2.2 주요 표준 패키지

#### java.lang - 기본 패키지
```java
// 자동으로 import되는 패키지
String text = "Hello";           // java.lang.String
int abs = Math.abs(-10);         // java.lang.Math
System.out.println("Hi");        // java.lang.System
```

#### java.util - 유틸리티 패키지
```java
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

Scanner input = new Scanner(System.in);
Random rand = new Random();
ArrayList<String> list = new ArrayList<>();
```

#### java.io - 입출력 패키지
```java
import java.io.File;
import java.io.PrintWriter;

File file = new File("data.txt");
PrintWriter writer = new PrintWriter(file);
```

## 3. import 문 사용하기

### 3.1 기본 import
```java
// 특정 클래스 import
import java.util.Scanner;

// 이제 간단한 이름 사용 가능
Scanner input = new Scanner(System.in);
```

### 3.2 와일드카드 import
```java
// 패키지의 모든 클래스 import
import java.util.*;

// 이제 java.util의 모든 클래스 사용 가능
Scanner input = new Scanner(System.in);
Random rand = new Random();
ArrayList<String> list = new ArrayList<>();
```

### 3.3 import 사용 시 주의사항
```java
// 이름 충돌 예제
import java.awt.*;    // List 클래스 포함
import java.util.*;   // List 클래스 포함

// List list = new List();  // 오류! 어떤 List인지 모호함

// 해결 방법: 전체 이름 사용
java.util.List<String> list1 = new java.util.ArrayList<>();
java.awt.List list2 = new java.awt.List();
```

### 3.4 정적 import
```java
// 정적 멤버 import
import static java.lang.Math.*;
import static java.lang.System.out;

public class StaticImportExample {
    public static void main(String[] args) {
        // Math. 없이 사용
        double result = sqrt(16);
        double angle = sin(PI / 2);

        // System. 없이 사용
        out.println("결과: " + result);
    }
}
```

## 4. Javadoc 문서화

### 4.1 Javadoc 주석이란?
**Javadoc**은 코드에서 자동으로 문서를 생성하는 시스템입니다.

```java
/**
 * 이것이 Javadoc 주석입니다.
 * 여러 줄로 작성할 수 있습니다.
 */
```

### 4.2 기본 Javadoc 작성
```java
/**
 * 원의 넓이를 계산합니다.
 *
 * @param radius 원의 반지름 (양수여야 함)
 * @return 원의 넓이
 * @throws IllegalArgumentException 반지름이 음수일 때
 */
public static double circleArea(double radius) {
    if (radius < 0) {
        throw new IllegalArgumentException("반지름은 음수일 수 없습니다");
    }
    return Math.PI * radius * radius;
}
```

### 4.3 Javadoc 태그

#### 주요 태그들
- `@param`: 매개변수 설명
- `@return`: 반환값 설명
- `@throws`: 예외 설명
- `@author`: 작성자

```java
/**
 * 학생 정보를 관리하는 클래스입니다.
 *
 * @author 김철수
 * @version 1.0
 */
public class Student {
    private String name;
    private int score;

    /**
     * 학생 객체를 생성합니다.
     *
     * @param name 학생 이름
     * @param score 학생 점수 (0-100)
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 학생의 학점을 계산합니다.
     *
     * @return 학점 (A, B, C, D, F)
     */
    public char getGrade() {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }
}
```

### 4.4 좋은 문서 작성 원칙
1. **명확하게**: 간단명료한 설명
2. **완전하게**: 모든 매개변수와 반환값 설명
3. **예제 포함**: 사용 예시 제공
4. **주의사항**: 특별한 제약사항 명시

```java
/**
 * 배열에서 최대값을 찾습니다.
 *
 * <p>사용 예제:
 * <pre>
 * int[] numbers = {3, 7, 2, 9, 1};
 * int max = findMax(numbers);  // 9 반환
 * </pre>
 *
 * @param array 검색할 배열 (null이거나 비어있으면 안됨)
 * @return 배열의 최대값
 * @throws IllegalArgumentException 배열이 null이거나 비어있을 때
 */
public static int findMax(int[] array) {
    if (array == null || array.length == 0) {
        throw new IllegalArgumentException("배열이 비어있습니다");
    }

    int max = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }
    return max;
}
```

## 5. 모듈 시스템 (Java 9+)

### 5.1 모듈이란?
**모듈**은 패키지들의 집합으로, 더 큰 단위의 코드 구성을 제공합니다.

```
계층 구조:
모듈 → 패키지 → 클래스 → 메서드/변수
```

### 5.2 모듈의 장점
1. **더 나은 캡슐화**: 패키지 수준의 접근 제어
2. **명확한 의존성**: 필요한 모듈 명시
3. **작은 런타임**: 필요한 모듈만 포함

### 5.3 주요 표준 모듈
- `java.base`: 기본 Java 클래스들
- `java.desktop`: Swing GUI 클래스들
- `javafx.graphics`: JavaFX 그래픽
- `javafx.controls`: JavaFX 컨트롤

## 6. 실용적인 패키지 구성

### 6.1 패키지 명명 규칙
```java
// 회사/조직의 도메인을 역순으로 사용
package com.mycompany.myproject;
package edu.university.course;
package org.opensource.library;
```

### 6.2 프로젝트 구조 예시
```
myproject/
├── src/
│   ├── com/
│   │   └── mycompany/
│   │       └── myproject/
│   │           ├── Main.java
│   │           ├── model/
│   │           │   ├── User.java
│   │           │   └── Product.java
│   │           ├── view/
│   │           │   └── MainWindow.java
│   │           └── util/
│   │               └── Helper.java
└── doc/
    └── javadoc/
```

### 6.3 패키지 사용 예제
```java
// Main.java
package com.mycompany.myproject;

import com.mycompany.myproject.model.User;
import com.mycompany.myproject.util.Helper;

public class Main {
    public static void main(String[] args) {
        User user = new User("김철수");
        Helper.printWelcome(user);
    }
}

// User.java
package com.mycompany.myproject.model;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Helper.java
package com.mycompany.myproject.util;

import com.mycompany.myproject.model.User;

public class Helper {
    public static void printWelcome(User user) {
        System.out.println("환영합니다, " + user.getName() + "님!");
    }
}
```

## 요약

### 핵심 개념
- **API**: 프로그래머가 사용할 수 있는 기능의 집합
- **패키지**: 관련 클래스들을 그룹화하는 방법
- **import**: 패키지의 클래스를 간단한 이름으로 사용
- **Javadoc**: 코드에서 자동으로 문서 생성
- **모듈**: 패키지들의 집합 (Java 9+)

### 중요한 패키지들
- `java.lang`: 자동 import, 기본 클래스들
- `java.util`: Scanner, Random, 컬렉션
- `java.io`: 파일 입출력

### 모범 사례
1. 명확한 패키지 구조 사용
2. 적절한 import 사용 (와일드카드 주의)
3. 모든 public 요소에 Javadoc 작성
4. API 문서를 자주 참조

💡 **팁**: 좋은 API는 사용하기 쉽고 오용하기 어렵습니다. 여러분의 코드도 다른 사람이 사용할 API라고 생각하고 작성하세요!