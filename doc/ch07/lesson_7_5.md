# 7.5 검색과 정렬 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 선형 검색과 이진 검색의 원리를 이해한다
- 삽입 정렬과 선택 정렬 알고리즘을 구현한다
- 연관 리스트(Association List)의 개념과 구현 방법을 안다
- 정렬된 데이터와 정렬되지 않은 데이터에서의 검색 전략을 구분한다
- 배열을 무작위로 섞는 알고리즘을 구현한다

## 1. 검색(Searching)이란?

### 1.1 검색의 개념

검색은 **배열에서 특정 조건을 만족하는 항목을 찾는 것**입니다.

```java
// 예시: 숫자 7을 찾기
int[] numbers = {3, 1, 7, 2, 9, 5};
// 목표: 7의 위치(인덱스 2)를 찾기
```

### 1.2 검색이 필요한 상황

- 학생 명단에서 특정 학생 찾기
- 전화번호부에서 이름으로 번호 찾기
- 상품 목록에서 특정 상품 찾기
- 게임에서 최고 점수 찾기

## 2. 선형 검색 (Linear Search)

### 2.1 선형 검색 원리

배열의 **처음부터 끝까지 하나씩 확인**하는 방법입니다.

```java
/**
 * 선형 검색 - 배열에서 특정 값 찾기
 * @param array 검색할 배열
 * @param target 찾을 값
 * @return 값의 인덱스 (없으면 -1)
 */
public static int linearSearch(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == target) {
            return i;  // 찾았음!
        }
    }
    return -1;  // 못 찾음
}
```

### 2.2 선형 검색 예제

```java
public class LinearSearchExample {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 91};
        
        // 96점을 찾기
        int index = linearSearch(scores, 96);
        
        if (index != -1) {
            System.out.println("96점은 " + index + "번째 위치에 있습니다");
        } else {
            System.out.println("96점을 찾을 수 없습니다");
        }
    }
    
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

### 2.3 선형 검색의 특징

**장점**:
- 구현이 간단함
- 정렬되지 않은 배열에서도 사용 가능
- 모든 상황에서 동작

**단점**:
- 속도가 느림 (최악의 경우 모든 요소 확인)
- 배열이 클수록 비효율적

## 3. 이진 검색 (Binary Search)

### 3.1 이진 검색 원리

**정렬된 배열**에서 중간값을 확인하여 검색 범위를 절반씩 줄이는 방법입니다.

```java
/**
 * 이진 검색 - 정렬된 배열에서 값 찾기
 * @param array 정렬된 배열
 * @param target 찾을 값
 * @return 값의 인덱스 (없으면 -1)
 */
public static int binarySearch(int[] array, int target) {
    int left = 0;                    // 왼쪽 끝
    int right = array.length - 1;    // 오른쪽 끝
    
    while (left <= right) {
        int middle = (left + right) / 2;  // 중간 위치
        
        if (array[middle] == target) {
            return middle;  // 찾았음!
        } else if (array[middle] > target) {
            right = middle - 1;  // 왼쪽 절반에서 찾기
        } else {
            left = middle + 1;   // 오른쪽 절반에서 찾기
        }
    }
    
    return -1;  // 못 찾음
}
```

### 3.2 이진 검색 과정 예시

```java
// 정렬된 배열: [1, 3, 5, 7, 9, 11, 13, 15]
// 찾는 값: 7

// 1단계: middle = 4, array[4] = 9
//        9 > 7이므로 오른쪽 절반 제거
//        범위: [1, 3, 5, 7]

// 2단계: middle = 1, array[1] = 3  
//        3 < 7이므로 왼쪽 절반 제거
//        범위: [5, 7]

// 3단계: middle = 3, array[3] = 7
//        7 == 7이므로 찾음! 인덱스 3 반환
```

### 3.3 이진 검색의 특징

**장점**:
- 매우 빠름 (1000개 항목도 10단계면 충분)
- 효율적 (O(log n) 시간 복잡도)

**단점**:
- 배열이 정렬되어 있어야만 사용 가능
- 구현이 약간 복잡

**언제 사용할까?**
- 데이터가 이미 정렬되어 있을 때
- 검색을 자주 수행할 때
- 데이터량이 많을 때

## 4. 연관 리스트 (Association List)

### 4.1 연관 리스트란?

**키(Key)와 값(Value)을 쌍으로 저장**하는 데이터 구조입니다.

```java
// 예시: 전화번호부
// 키: 이름, 값: 전화번호
("김철수", "010-1234-5678")
("이영희", "010-2345-6789")
("박민수", "010-3456-7890")
```

### 4.2 전화번호부 구현 예제

```java
public class PhoneDirectory {
    // 전화번호 항목 클래스
    static class PhoneEntry {
        String name;        // 이름 (키)
        String phoneNumber; // 전화번호 (값)
        
        PhoneEntry(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
    
    private PhoneEntry[] entries;  // 전화번호부 배열
    private int count;             // 현재 저장된 항목 수
    
    public PhoneDirectory() {
        entries = new PhoneEntry[100];  // 최대 100개
        count = 0;
    }
    
    // 이름으로 전화번호 찾기 (검색)
    public String getPhoneNumber(String name) {
        for (int i = 0; i < count; i++) {
            if (entries[i].name.equals(name)) {
                return entries[i].phoneNumber;
            }
        }
        return null;  // 못 찾음
    }
    
    // 전화번호 추가/수정
    public void putPhoneNumber(String name, String phoneNumber) {
        // 기존에 있는지 확인
        for (int i = 0; i < count; i++) {
            if (entries[i].name.equals(name)) {
                entries[i].phoneNumber = phoneNumber;  // 수정
                return;
            }
        }
        
        // 새로 추가
        entries[count] = new PhoneEntry(name, phoneNumber);
        count++;
    }
}
```

### 4.3 연관 리스트 사용 예제

```java
public class PhoneDirectoryTest {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        
        // 전화번호 추가
        directory.putPhoneNumber("김철수", "010-1234-5678");
        directory.putPhoneNumber("이영희", "010-2345-6789");
        directory.putPhoneNumber("박민수", "010-3456-7890");
        
        // 전화번호 검색
        String phone = directory.getPhoneNumber("이영희");
        System.out.println("이영희의 전화번호: " + phone);
        
        // 전화번호 수정
        directory.putPhoneNumber("김철수", "010-9999-8888");
        System.out.println("김철수의 새 번호: " + directory.getPhoneNumber("김철수"));
    }
}
```

## 5. 정렬 (Sorting)

### 5.1 정렬이란?

배열의 모든 항목을 **오름차순 또는 내림차순으로 재배열**하는 것입니다.

```java
// 정렬 전: [5, 2, 8, 1, 9]
// 정렬 후: [1, 2, 5, 8, 9] (오름차순)
```

### 5.2 정렬이 필요한 이유

1. **검색 속도 향상**: 이진 검색 사용 가능
2. **데이터 분석**: 최대값, 최소값 쉽게 찾기
3. **사용자 편의**: 알파벳순, 점수순 정렬
4. **중복 제거**: 정렬된 데이터에서 중복 쉽게 발견

## 6. 삽입 정렬 (Insertion Sort)

### 6.1 삽입 정렬 원리

**이미 정렬된 부분에 새 항목을 올바른 위치에 삽입**하는 방법입니다.

트럼프 카드를 정렬하는 것과 같은 방식입니다:
1. 첫 번째 카드는 이미 정렬됨
2. 두 번째 카드를 올바른 위치에 삽입
3. 세 번째 카드를 올바른 위치에 삽입
4. 반복...

### 6.2 삽입 정렬 구현

```java
public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
        int key = array[i];  // 삽입할 값
        int j = i - 1;       // 정렬된 부분의 끝
        
        // key보다 큰 값들을 한 칸씩 뒤로 이동
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        
        // key를 올바른 위치에 삽입
        array[j + 1] = key;
    }
}
```

### 6.3 삽입 정렬 과정 예시

```java
// 초기 배열: [5, 2, 8, 1, 9]

// i=1: key=2, 정렬된 부분 [5]
//      5 > 2이므로 5를 뒤로 이동
//      결과: [2, 5, 8, 1, 9]

// i=2: key=8, 정렬된 부분 [2, 5]  
//      8 > 5이므로 그대로 유지
//      결과: [2, 5, 8, 1, 9]

// i=3: key=1, 정렬된 부분 [2, 5, 8]
//      모든 값이 1보다 크므로 맨 앞에 삽입
//      결과: [1, 2, 5, 8, 9]

// i=4: key=9, 정렬된 부분 [1, 2, 5, 8]
//      9 > 8이므로 그대로 유지
//      결과: [1, 2, 5, 8, 9]
```

## 7. 선택 정렬 (Selection Sort)

### 7.1 선택 정렬 원리

**가장 작은(또는 큰) 값을 찾아서 맨 앞으로 이동**시키는 방법입니다.

1. 전체에서 가장 작은 값을 찾아 첫 번째 위치로
2. 나머지에서 가장 작은 값을 찾아 두 번째 위치로
3. 반복...

### 7.2 선택 정렬 구현

```java
public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        // i번째 위치에 올 최소값의 인덱스 찾기
        int minIndex = i;
        
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        
        // 최소값과 i번째 값 교환
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
```

### 7.3 선택 정렬 과정 예시

```java
// 초기 배열: [5, 2, 8, 1, 9]

// i=0: 전체에서 최소값 1을 찾아 첫 번째와 교환
//      결과: [1, 2, 8, 5, 9]

// i=1: 나머지에서 최소값 2를 찾음 (이미 제자리)
//      결과: [1, 2, 8, 5, 9]

// i=2: 나머지에서 최소값 5를 찾아 세 번째와 교환
//      결과: [1, 2, 5, 8, 9]

// i=3: 나머지에서 최소값 8을 찾음 (이미 제자리)
//      결과: [1, 2, 5, 8, 9]
```

## 8. 정렬 알고리즘 비교

### 8.1 삽입 정렬 vs 선택 정렬

| 특징 | 삽입 정렬 | 선택 정렬 |
|------|-----------|-----------|
| 원리 | 정렬된 부분에 삽입 | 최소값을 선택하여 이동 |
| 장점 | 이미 정렬된 데이터에 빠름 | 항상 일정한 성능 |
| 단점 | 역순 데이터에 느림 | 이미 정렬된 데이터도 느림 |
| 교환 횟수 | 많을 수 있음 | 적음 |

### 8.2 언제 어떤 정렬을 사용할까?

**삽입 정렬**:
- 데이터가 거의 정렬되어 있을 때
- 작은 배열 (< 50개)
- 온라인 정렬 (데이터가 계속 들어올 때)

**선택 정렬**:
- 교환 비용이 클 때
- 메모리 사용량을 최소화할 때
- 간단한 구현이 필요할 때

## 9. 문자열 정렬

### 9.1 문자열 비교

문자열은 `compareTo()` 메서드를 사용하여 비교합니다.

```java
String str1 = "apple";
String str2 = "banana";

int result = str1.compareTo(str2);
// result < 0: str1이 str2보다 앞에 있음
// result = 0: str1과 str2가 같음
// result > 0: str1이 str2보다 뒤에 있음
```

### 9.2 문자열 배열 정렬

```java
public static void sortStringArray(String[] array) {
    for (int i = 1; i < array.length; i++) {
        String key = array[i];
        int j = i - 1;
        
        // 문자열 비교는 compareTo 사용
        while (j >= 0 && array[j].compareTo(key) > 0) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        
        array[j + 1] = key;
    }
}

// 사용 예시
String[] names = {"홍길동", "김철수", "이영희", "박민수"};
sortStringArray(names);
// 결과: ["김철수", "박민수", "이영희", "홍길동"]
```

## 10. 배열 섞기 (Shuffling)

### 10.1 왜 배열을 섞나요?

- 카드 게임에서 카드 섞기
- 문제 순서 무작위화
- 데이터 샘플링
- 게임에서 적 출현 순서 랜덤화

### 10.2 Fisher-Yates 셔플 알고리즘

```java
public static void shuffle(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
        // 0부터 i까지 중 무작위 인덱스 선택
        int randomIndex = (int)(Math.random() * (i + 1));
        
        // 선택된 위치와 현재 위치 교환
        int temp = array[i];
        array[i] = array[randomIndex];
        array[randomIndex] = temp;
    }
}
```

### 10.3 셔플 예제

```java
public class ShuffleExample {
    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("원본: " + Arrays.toString(cards));
        
        shuffle(cards);
        
        System.out.println("섞은 후: " + Arrays.toString(cards));
    }
    
    public static void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int randomIndex = (int)(Math.random() * (i + 1));
            
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}
```

## 11. 실제 적용 예시

### 11.1 학생 성적 관리 시스템

```java
class Student {
    String name;
    int score;
    
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString() {
        return name + "(" + score + "점)";
    }
}

public class GradeManager {
    public static void sortByScore(Student[] students) {
        // 점수 기준 내림차순 정렬 (높은 점수가 앞에)
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            
            while (j >= 0 && students[j].score < key.score) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            
            students[j + 1] = key;
        }
    }
    
    public static Student findStudent(Student[] students, String name) {
        for (Student student : students) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }
}
```

## 12. Java 내장 정렬 메서드

### 12.1 Arrays.sort() 사용

```java
import java.util.Arrays;

public class JavaSortExample {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9};
        
        // Java 내장 정렬 (매우 빠름)
        Arrays.sort(numbers);
        
        System.out.println(Arrays.toString(numbers));
        // 출력: [1, 2, 5, 8, 9]
        
        String[] names = {"홍길동", "김철수", "이영희"};
        Arrays.sort(names);
        
        System.out.println(Arrays.toString(names));
        // 출력: [김철수, 이영희, 홍길동]
    }
}
```

### 12.2 Arrays.binarySearch() 사용

```java
import java.util.Arrays;

public class JavaSearchExample {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11, 13};  // 정렬된 배열
        
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("7의 위치: " + index);  // 3
        
        int notFound = Arrays.binarySearch(numbers, 6);
        System.out.println("6의 위치: " + notFound);  // 음수 (없음)
    }
}
```

## 요약

### 핵심 포인트

1. **검색 알고리즘**:
   - 선형 검색: 모든 요소 하나씩 확인 (O(n))
   - 이진 검색: 정렬된 배열에서 절반씩 제거 (O(log n))

2. **정렬 알고리즘**:
   - 삽입 정렬: 정렬된 부분에 새 요소 삽입
   - 선택 정렬: 최소값을 선택하여 앞으로 이동

3. **연관 리스트**:
   - 키-값 쌍으로 데이터 저장
   - 전화번호부, 사전 등에 활용

4. **언제 사용할까?**:
   - 작은 데이터: 간단한 정렬 알고리즘
   - 큰 데이터: Java 내장 메서드 (Arrays.sort)
   - 자주 검색: 데이터를 미리 정렬

5. **성능 고려사항**:
   - 데이터 크기에 따른 알고리즘 선택
   - 정렬 비용 vs 검색 속도 향상 트레이드오프

💡 **기억하세요**: 정렬과 검색은 프로그래밍의 기본기입니다. 원리를 이해하고 상황에 맞는 알고리즘을 선택하는 것이 중요합니다!