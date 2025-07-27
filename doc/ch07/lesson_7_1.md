# 7.1 배열 세부 사항 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- for-each 루프를 사용하여 배열을 효과적으로 처리한다
- 가변 인수 메서드를 이해하고 활용한다
- 배열 리터럴을 다양한 상황에서 사용한다
- 배열의 고급 기능을 실무에 적용한다

## 1. 배열 기본 복습

### 1.1 배열의 핵심 개념

**배열(Array)** 은 같은 타입의 여러 값을 하나의 변수에 저장하는 데이터 구조입니다.

```java
// 배열 선언과 생성
int[] numbers = new int[5];  // 크기가 5인 정수 배열

// 배열 요소 접근
numbers[0] = 10;  // 첫 번째 요소에 10 저장
numbers[4] = 50;  // 마지막 요소에 50 저장

// 배열 길이 확인
int length = numbers.length;  // 5
```

### 1.2 배열의 특징

1. **인덱스는 0부터 시작**: 첫 번째 요소는 `array[0]`
2. **고정된 크기**: 생성 후 크기 변경 불가
3. **참조 타입**: 배열 변수는 배열 객체를 참조
4. **범위 검사**: 잘못된 인덱스 접근 시 `ArrayIndexOutOfBoundsException`

## 2. For-each 루프

### 2.1 전통적인 for 루프 vs for-each 루프

```java
String[] fruits = {"사과", "바나나", "오렌지", "포도"};

// 전통적인 for 루프
for (int i = 0; i < fruits.length; i++) {
    System.out.println(fruits[i]);
}

// for-each 루프 (향상된 for 루프)
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

### 2.2 for-each 루프의 문법

```java
for (타입 변수명 : 배열명) {
    // 각 요소에 대한 처리
}
```

### 2.3 for-each 루프의 장점

1. **간결한 코드**: 인덱스 관리 불필요
2. **가독성 향상**: 의도가 명확함
3. **오류 감소**: 인덱스 범위 오류 방지

### 2.4 실제 예제

```java
// 예제 1: 배열의 합계 구하기
int[] scores = {85, 90, 78, 92, 88};
int total = 0;

for (int score : scores) {
    total += score;
}

System.out.println("총점: " + total);
System.out.println("평균: " + (double)total / scores.length);

// 예제 2: 조건에 맞는 요소만 처리
String[] names = {"김철수", "이영희", "박민수", "김지은"};

System.out.println("김씨 성을 가진 사람:");
for (String name : names) {
    if (name.startsWith("김")) {
        System.out.println(name);
    }
}
```

### 2.5 for-each 루프의 제한사항

```java
int[] numbers = {1, 2, 3, 4, 5};

// ❌ 잘못된 사용: 배열 요소 수정 불가
for (int num : numbers) {
    num = num * 2;  // 배열은 변경되지 않음!
}

// ✅ 올바른 방법: 인덱스를 사용한 수정
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;
}
```

**주의사항**:
- 배열 요소의 값을 변경할 수 없음
- 인덱스가 필요한 경우 사용 불가
- 역순 처리나 부분 처리 어려움

## 3. 가변 인수 메서드 (Variable Arity Methods)

### 3.1 가변 인수란?

가변 인수를 사용하면 메서드에 전달하는 인수의 개수를 유연하게 할 수 있습니다.

```java
// 가변 인수 메서드 정의
public static int sum(int... numbers) {
    int total = 0;
    for (int num : numbers) {
        total += num;
    }
    return total;
}

// 다양한 방법으로 호출 가능
int result1 = sum(1, 2, 3);           // 3개 인수
int result2 = sum(10, 20, 30, 40);    // 4개 인수
int result3 = sum(5);                  // 1개 인수
int result4 = sum();                   // 0개 인수
```

### 3.2 가변 인수의 문법

```java
타입... 매개변수명
```

- `...`은 타입 뒤에 위치
- 메서드 내부에서는 배열로 처리
- 마지막 매개변수로만 사용 가능

### 3.3 실용적인 예제

```java
// 예제 1: 최댓값 찾기
public static int max(int first, int... rest) {
    int maximum = first;
    for (int value : rest) {
        if (value > maximum) {
            maximum = value;
        }
    }
    return maximum;
}

// 예제 2: 문자열 연결
public static String join(String separator, String... elements) {
    if (elements.length == 0) {
        return "";
    }

    StringBuilder result = new StringBuilder(elements[0]);
    for (int i = 1; i < elements.length; i++) {
        result.append(separator).append(elements[i]);
    }
    return result.toString();
}

// 사용 예
System.out.println(max(10, 5, 8, 12, 3));  // 12
System.out.println(join(", ", "사과", "바나나", "오렌지"));  // "사과, 바나나, 오렌지"
```

### 3.4 배열을 가변 인수로 전달

```java
int[] values = {10, 20, 30, 40, 50};
int total = sum(values);  // 배열을 직접 전달 가능
```

## 4. 배열 리터럴 (Array Literals)

### 4.1 배열 초기화의 다양한 방법

```java
// 방법 1: 선언과 동시에 초기화
int[] primes = {2, 3, 5, 7, 11};

// 방법 2: new 연산자와 함께 사용
int[] evens = new int[] {2, 4, 6, 8, 10};

// 방법 3: 크기만 지정하고 나중에 값 할당
int[] odds = new int[5];
odds[0] = 1;
odds[1] = 3;
// ...
```

### 4.2 배열 리터럴의 활용

```java
// 메서드 호출 시 직접 생성
printArray(new int[] {1, 2, 3, 4, 5});

// 조건에 따른 배열 할당
int[] numbers;
if (useEvenNumbers) {
    numbers = new int[] {2, 4, 6, 8};
} else {
    numbers = new int[] {1, 3, 5, 7};
}

// 메서드에서 배열 반환
public static int[] getFirstNPrimes(int n) {
    if (n == 3) {
        return new int[] {2, 3, 5};
    } else if (n == 5) {
        return new int[] {2, 3, 5, 7, 11};
    }
    // ... 더 복잡한 로직
}
```

### 4.3 실전 예제: 메뉴 생성

```java
// 메뉴 아이템 배열을 사용한 메뉴 생성
public static void createFileMenu() {
    String[] menuItems = new String[] {
        "새 파일",
        "열기",
        "저장",
        null,      // null은 구분선
        "종료"
    };

    for (String item : menuItems) {
        if (item == null) {
            System.out.println("----------");
        } else {
            System.out.println(item);
        }
    }
}
```

## 5. 실전 활용 예제

### 5.1 성적 처리 시스템

```java
public class GradeProcessor {
    // 가변 인수를 사용한 평균 계산
    public static double calculateAverage(double... scores) {
        if (scores.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    // 최고점과 최저점 제외한 평균
    public static double calculateTrimmedAverage(double... scores) {
        if (scores.length <= 2) {
            return calculateAverage(scores);
        }

        double max = scores[0];
        double min = scores[0];
        double sum = 0;

        for (double score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }

        return (sum - max - min) / (scores.length - 2);
    }

    public static void main(String[] args) {
        // 다양한 방법으로 호출
        System.out.println("평균: " + calculateAverage(85, 90, 78, 92, 88));

        double[] examScores = {75, 80, 85, 90, 95};
        System.out.println("평균: " + calculateAverage(examScores));

        System.out.println("보정 평균: " +
            calculateTrimmedAverage(60, 70, 80, 90, 100));
    }
}
```

### 5.2 유틸리티 메서드 모음

```java
public class ArrayUtils {
    // 배열 출력 (가변 인수)
    public static void printInts(String label, int... values) {
        System.out.print(label + ": ");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(values[i]);
        }
        System.out.println();
    }

    // 배열에서 특정 값 찾기
    public static boolean contains(int target, int... values) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    // 배열 복사 (for-each 사용)
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        int index = 0;
        for (int value : original) {
            copy[index++] = value;
        }
        return copy;
    }
}
```

## 요약

### 핵심 포인트

1. **for-each 루프**:
   - 배열의 모든 요소를 순회할 때 사용
   - 인덱스가 필요 없을 때 유용
   - 코드가 간결하고 읽기 쉬움

2. **가변 인수 메서드**:
   - `타입...` 문법 사용
   - 유연한 개수의 인수 전달 가능
   - 내부적으로 배열로 처리

3. **배열 리터럴**:
   - `new 타입[] {값들}`로 즉석에서 배열 생성
   - 메서드 호출 시 유용
   - 조건부 배열 할당 가능

### 주의사항

- for-each 루프로는 배열 요소를 수정할 수 없음
- 가변 인수는 메서드의 마지막 매개변수여야 함
- 배열은 생성 후 크기를 변경할 수 없음

💡 **기억하세요**: 이러한 고급 기능들을 활용하면 더 깔끔하고 유지보수하기 쉬운 코드를 작성할 수 있습니다!