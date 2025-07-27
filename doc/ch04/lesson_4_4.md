# 4.4 반환값(Return Values) - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 함수와 일반 서브루틴의 차이를 이해한다
- return 문을 사용하여 값을 반환할 수 있다
- 다양한 반환 타입의 함수를 작성할 수 있다
- 함수의 반환값을 적절히 활용할 수 있다
- void 메서드에서 return 문을 사용할 수 있다

## 1. 함수(Function)의 개념

### 1.1 함수란?
**함수(Function)**는 값을 반환하는 특별한 서브루틴입니다.

```java
// 일반 서브루틴 (void)
static void printMessage() {
    System.out.println("Hello!");  // 출력만 하고 끝
}

// 함수 (값을 반환)
static int add(int a, int b) {
    return a + b;  // 계산 결과를 반환
}
```

### 1.2 함수의 특징
- **반환 타입**: 함수가 반환할 값의 타입
- **반환값**: 함수가 계산한 결과
- **사용 위치**: 값이 필요한 곳 어디서나 사용 가능

```java
// 함수 사용 예시
int result = add(5, 3);           // 변수에 저장
System.out.println(add(5, 3));    // 출력문에서 사용
int total = 10 + add(5, 3);      // 표현식에서 사용
if (add(5, 3) > 7) { ... }       // 조건문에서 사용
```

## 2. return 문

### 2.1 return 문의 구조
```java
return 표현식;  // 함수에서 사용
return;         // void 메서드에서 사용 (선택적)
```

### 2.2 return 문의 동작
1. 표현식을 평가
2. 그 값을 함수의 반환값으로 설정
3. 함수 실행을 즉시 종료
4. 호출한 곳으로 제어 반환

```java
static int max(int a, int b) {
    if (a > b) {
        return a;  // 여기서 함수 종료
    }
    return b;      // a <= b인 경우 실행
}
```

### 2.3 중요한 규칙
⚠️ **함수는 반드시 값을 반환해야 합니다!**

```java
// ❌ 잘못된 예 - 컴파일 오류!
static int calculate(int n) {
    if (n > 0) {
        return n * 2;
    }
    // n <= 0인 경우 반환값이 없음!
}

// ✅ 올바른 예
static int calculate(int n) {
    if (n > 0) {
        return n * 2;
    } else {
        return 0;  // 모든 경로에서 반환
    }
}
```

## 3. 다양한 반환 타입

### 3.1 기본 타입 반환
```java
// int 반환
static int square(int n) {
    return n * n;
}

// double 반환
static double average(int a, int b) {
    return (a + b) / 2.0;
}

// boolean 반환
static boolean isEven(int n) {
    return n % 2 == 0;
}

// char 반환
static char getGrade(int score) {
    if (score >= 90) return 'A';
    else if (score >= 80) return 'B';
    else if (score >= 70) return 'C';
    else if (score >= 60) return 'D';
    else return 'F';
}
```

### 3.2 String 반환
```java
// 문자열 반환
static String getDay(int dayNumber) {
    switch (dayNumber) {
        case 1: return "월요일";
        case 2: return "화요일";
        case 3: return "수요일";
        case 4: return "목요일";
        case 5: return "금요일";
        case 6: return "토요일";
        case 7: return "일요일";
        default: return "잘못된 요일";
    }
}
```

### 3.3 배열 반환
```java
// 배열도 반환 가능!
static int[] createArray(int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
        arr[i] = i + 1;
    }
    return arr;
}
```

## 4. 함수 작성 예제

### 4.1 수학 함수
```java
// 피타고라스 정리
static double pythagoras(double a, double b) {
    return Math.sqrt(a * a + b * b);
}

// 거듭제곱
static int power(int base, int exponent) {
    int result = 1;
    for (int i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
}

// 팩토리얼
static int factorial(int n) {
    if (n <= 1) {
        return 1;
    }
    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

### 4.2 문자열 처리 함수
```java
// 문자열 뒤집기
static String reverse(String str) {
    String result = "";
    for (int i = str.length() - 1; i >= 0; i--) {
        result += str.charAt(i);
    }
    return result;
}

// 회문(palindrome) 검사
static boolean isPalindrome(String word) {
    return word.equals(reverse(word));
}

// 모음 개수 세기
static int countVowels(String str) {
    int count = 0;
    str = str.toLowerCase();
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (ch == 'a' || ch == 'e' || ch == 'i' || 
            ch == 'o' || ch == 'u') {
            count++;
        }
    }
    return count;
}
```

### 4.3 소수 판별 함수
```java
/**
 * 주어진 수가 소수인지 판별합니다.
 * 소수: 1과 자기 자신만으로 나누어지는 1보다 큰 정수
 */
static boolean isPrime(int n) {
    if (n <= 1) {
        return false;  // 1 이하는 소수가 아님
    }
    
    // 2부터 √n까지만 검사하면 충분
    int maxToCheck = (int)Math.sqrt(n);
    
    for (int divisor = 2; divisor <= maxToCheck; divisor++) {
        if (n % divisor == 0) {
            return false;  // 나누어떨어지면 소수가 아님
        }
    }
    
    return true;  // 약수를 찾지 못했으므로 소수
}
```

## 5. void 메서드에서의 return

### 5.1 조기 종료
```java
static void processNumber(int n) {
    if (n < 0) {
        System.out.println("음수는 처리할 수 없습니다.");
        return;  // 여기서 메서드 종료
    }
    
    // n이 0 이상인 경우만 실행됨
    System.out.println("처리 중: " + n);
    // ... 추가 처리
}
```

### 5.2 루프에서의 return
```java
static void findAndPrint(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == target) {
            System.out.println("찾았습니다! 인덱스: " + i);
            return;  // 찾으면 즉시 종료
        }
    }
    System.out.println("찾을 수 없습니다.");
}
```

## 6. 함수 활용 패턴

### 6.1 계산 결과 반환
```java
// 평균 계산
static double calculateAverage(int[] scores) {
    if (scores.length == 0) {
        return 0;  // 빈 배열 처리
    }
    
    int sum = 0;
    for (int score : scores) {
        sum += score;
    }
    return (double)sum / scores.length;
}
```

### 6.2 상태 확인
```java
// 유효성 검사
static boolean isValidEmail(String email) {
    return email.contains("@") && email.contains(".");
}

// 범위 확인
static boolean isInRange(int value, int min, int max) {
    return value >= min && value <= max;
}
```

### 6.3 변환 작업
```java
// 섭씨를 화씨로 변환
static double celsiusToFahrenheit(double celsius) {
    return celsius * 9.0 / 5.0 + 32;
}

// 문자를 대문자로 변환
static char toUpperCase(char ch) {
    if (ch >= 'a' && ch <= 'z') {
        return (char)(ch - 'a' + 'A');
    }
    return ch;
}
```

## 7. 3N+1 예제 개선

### 7.1 다음 항 계산 함수
```java
static int nextN(int currentN) {
    if (currentN % 2 == 1) {
        return 3 * currentN + 1;  // 홀수인 경우
    } else {
        return currentN / 2;      // 짝수인 경우
    }
}
```

### 7.2 시퀀스 길이 계산
```java
static int sequenceLength(int startingValue) {
    int n = startingValue;
    int count = 0;
    
    while (n != 1) {
        n = nextN(n);
        count++;
    }
    
    return count;
}
```

### 7.3 활용 예시
```java
public static void main(String[] args) {
    int start = 27;
    
    // 시퀀스 길이 출력
    int length = sequenceLength(start);
    System.out.println(start + "의 시퀀스 길이: " + length);
    
    // 시퀀스 출력
    System.out.print("시퀀스: " + start);
    int n = start;
    while (n != 1) {
        n = nextN(n);
        System.out.print(" → " + n);
    }
    System.out.println();
}
```

## 8. 흔한 실수와 해결책

### 8.1 반환 대신 출력
```java
// ❌ 잘못된 예 - 결과를 출력함
static void calculateSum(int a, int b) {
    System.out.println(a + b);  // 출력만 함
}

// ✅ 올바른 예 - 결과를 반환함
static int calculateSum(int a, int b) {
    return a + b;  // 값을 반환
}
```

### 8.2 반환값 무시
```java
// 함수 정의
static int getUserInput() {
    System.out.print("숫자 입력: ");
    return TextIO.getInt();
}

// ❌ 반환값 무시
getUserInput();  // 입력받은 값을 사용하지 않음

// ✅ 반환값 활용
int number = getUserInput();  // 값을 저장하여 사용
```

### 8.3 모든 경로에서 반환
```java
// ❌ 일부 경로에서 반환 누락
static int sign(int n) {
    if (n > 0) return 1;
    if (n < 0) return -1;
    // n == 0인 경우 반환값 없음!
}

// ✅ 모든 경로에서 반환
static int sign(int n) {
    if (n > 0) return 1;
    if (n < 0) return -1;
    return 0;  // n == 0인 경우
}
```

## 요약

### 핵심 개념
- **함수**: 값을 반환하는 서브루틴
- **반환 타입**: 함수가 반환하는 값의 타입
- **return 문**: 값을 반환하고 함수를 종료
- **활용**: 계산, 변환, 검증 등 다양한 용도

### 기억할 점
1. 함수는 반드시 선언된 타입의 값을 반환해야 함
2. return 문은 함수를 즉시 종료시킴
3. 모든 실행 경로에서 값을 반환해야 함
4. void 메서드에서도 return으로 조기 종료 가능
5. 반환값은 호출한 곳에서 사용됨

💡 **팁**: 함수는 한 가지 일만 잘 하도록 작성하세요. 복잡한 작업은 여러 함수로 나누면 이해하기 쉽고 재사용하기 좋습니다!