# 7.3 ArrayList - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- ArrayList의 개념과 필요성을 이해한다
- 파라미터화된 타입(제네릭)을 활용한다
- 래퍼 클래스와 오토박싱/언박싱을 이해한다
- ArrayList를 사용하여 동적 데이터 구조를 구현한다
- 일반 배열과 ArrayList의 차이점을 이해한다

## 1. ArrayList 소개

### 1.1 ArrayList란?

ArrayList는 Java의 **동적 배열** 구현체입니다. 일반 배열과 달리 크기가 자동으로 조절됩니다.

```java
// 일반 배열 - 크기 고정
String[] names = new String[10];  // 10개만 저장 가능

// ArrayList - 크기 동적 조절
ArrayList<String> nameList = new ArrayList<String>();  // 제한 없음
```

### 1.2 ArrayList의 장점

1. **동적 크기 조절**: 요소 추가/삭제 시 자동으로 크기 조절
2. **편리한 메서드**: add(), remove(), contains() 등
3. **타입 안정성**: 제네릭을 통한 컴파일 시점 타입 체크
4. **Java Collection Framework**: 표준화된 인터페이스

## 2. 파라미터화된 타입 (제네릭)

### 2.1 제네릭 문법

```java
// 문자열을 저장하는 ArrayList
ArrayList<String> stringList = new ArrayList<String>();

// 정수를 저장하는 ArrayList
ArrayList<Integer> intList = new ArrayList<Integer>();

// 사용자 정의 클래스도 가능
ArrayList<Player> playerList = new ArrayList<Player>();
```

### 2.2 타입 안정성

```java
ArrayList<String> names = new ArrayList<String>();
names.add("홍길동");      // ✅ OK
names.add("김철수");      // ✅ OK
// names.add(123);       // ❌ 컴파일 오류 - String만 가능

String name = names.get(0);  // 형변환 불필요
```

### 2.3 var 키워드 사용

Java 10 이상에서는 var 키워드로 타입 추론이 가능합니다:

```java
// 기존 방식
ArrayList<String> list1 = new ArrayList<String>();

// var 사용 (타입 추론)
var list2 = new ArrayList<String>();  // list2의 타입은 ArrayList<String>
```

## 3. ArrayList 주요 메서드

### 3.1 기본 메서드

```java
ArrayList<String> fruits = new ArrayList<String>();

// 추가
fruits.add("사과");           // 끝에 추가
fruits.add(0, "바나나");      // 특정 위치에 추가

// 조회
String first = fruits.get(0);  // 인덱스로 조회
int size = fruits.size();      // 크기 반환

// 수정
fruits.set(1, "오렌지");      // 인덱스 1의 요소를 변경

// 삭제
fruits.remove(0);              // 인덱스로 삭제
fruits.remove("사과");         // 객체로 삭제 (첫 번째 일치 항목)
fruits.clear();                // 모든 요소 삭제

// 검색
int index = fruits.indexOf("오렌지");  // 인덱스 반환 (없으면 -1)
boolean exists = fruits.contains("사과");  // 포함 여부
```

### 3.2 메서드 상세 설명

| 메서드 | 설명 | 반환값 |
|--------|------|--------|
| add(E e) | 끝에 요소 추가 | boolean |
| add(int index, E e) | 특정 위치에 삽입 | void |
| get(int index) | 요소 조회 | E |
| set(int index, E e) | 요소 교체 | E (이전 값) |
| remove(int index) | 인덱스로 삭제 | E (삭제된 값) |
| remove(Object o) | 객체로 삭제 | boolean |
| size() | 크기 반환 | int |
| clear() | 모두 삭제 | void |
| indexOf(Object o) | 위치 검색 | int |
| contains(Object o) | 포함 여부 | boolean |

## 4. 래퍼 클래스 (Wrapper Classes)

### 4.1 기본형과 래퍼 클래스

ArrayList는 객체만 저장할 수 있으므로, 기본형을 저장하려면 래퍼 클래스가 필요합니다.

| 기본형 | 래퍼 클래스 |
|--------|------------|
| int | Integer |
| double | Double |
| boolean | Boolean |
| char | Character |
| long | Long |
| float | Float |
| byte | Byte |
| short | Short |

### 4.2 래퍼 클래스 사용

```java
// 수동 박싱
Integer num = Integer.valueOf(42);
int value = num.intValue();  // 언박싱

// 정적 메서드 활용
int parsed = Integer.parseInt("123");
String binary = Integer.toBinaryString(10);  // "1010"
```

## 5. 오토박싱과 언박싱

### 5.1 자동 변환

Java 5부터 기본형과 래퍼 클래스 간 자동 변환이 지원됩니다.

```java
// 오토박싱 (기본형 → 래퍼)
Integer num = 42;  // Integer.valueOf(42)와 동일

// 언박싱 (래퍼 → 기본형)
int value = num;   // num.intValue()와 동일

// ArrayList에서 활용
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);        // 오토박싱
int first = numbers.get(0);  // 언박싱
```

### 5.2 주의사항

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(null);  // null 저장 가능

// NullPointerException 주의!
// int value = list.get(0);  // null을 int로 언박싱 시도

// 안전한 처리
Integer value = list.get(0);
if (value != null) {
    int intValue = value;  // 안전한 언박싱
}
```

## 6. ArrayList와 배열 비교

### 6.1 주요 차이점

| 특징 | 배열 | ArrayList |
|------|------|-----------|
| 크기 | 고정 | 동적 |
| 타입 | 기본형/객체 | 객체만 |
| 성능 | 빠름 | 약간 느림 |
| 메서드 | 없음 | 다양함 |
| 문법 | array[i] | list.get(i) |

### 6.2 사용 예시 비교

```java
// 배열
int[] array = new int[5];
array[0] = 10;
int value = array[0];
int length = array.length;

// ArrayList
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
int value = list.get(0);
int size = list.size();
```

## 7. ArrayList 활용 패턴

### 7.1 for 루프 사용

```java
ArrayList<String> names = new ArrayList<>();
names.add("김철수");
names.add("이영희");
names.add("박민수");

// 인덱스 기반 for 루프
for (int i = 0; i < names.size(); i++) {
    System.out.println(i + ": " + names.get(i));
}

// for-each 루프
for (String name : names) {
    System.out.println(name);
}
```

### 7.2 조건부 처리

```java
ArrayList<Integer> scores = new ArrayList<>();
// 점수 추가...

// 80점 이상만 필터링
ArrayList<Integer> highScores = new ArrayList<>();
for (Integer score : scores) {
    if (score != null && score >= 80) {
        highScores.add(score);
    }
}
```

### 7.3 중첩된 데이터 구조

```java
// 2차원 동적 배열
ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

// 행 추가
for (int i = 0; i < 3; i++) {
    ArrayList<Integer> row = new ArrayList<>();
    for (int j = 0; j < 3; j++) {
        row.add(i * 3 + j);
    }
    matrix.add(row);
}

// 요소 접근
int value = matrix.get(1).get(2);  // 2행 3열
```

## 8. 실전 예제: 학생 관리 시스템

```java
public class StudentManager {
    private ArrayList<Student> students;
    
    // 학생 클래스
    static class Student {
        String name;
        int id;
        double grade;
        
        Student(String name, int id, double grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
    }
    
    public StudentManager() {
        students = new ArrayList<>();
    }
    
    // 학생 추가
    public void addStudent(String name, int id, double grade) {
        students.add(new Student(name, id, grade));
    }
    
    // ID로 학생 찾기
    public Student findById(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
    
    // 평균 성적 계산
    public double getAverageGrade() {
        if (students.isEmpty()) return 0.0;
        
        double sum = 0;
        for (Student s : students) {
            sum += s.grade;
        }
        return sum / students.size();
    }
    
    // 상위 N명 추출
    public ArrayList<Student> getTopStudents(int n) {
        // 성적순 정렬 (간단한 버블 정렬)
        ArrayList<Student> sorted = new ArrayList<>(students);
        
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j).grade < sorted.get(j + 1).grade) {
                    // 스왑
                    Student temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        
        // 상위 N명만 반환
        ArrayList<Student> top = new ArrayList<>();
        for (int i = 0; i < Math.min(n, sorted.size()); i++) {
            top.add(sorted.get(i));
        }
        return top;
    }
}
```

## 요약

### 핵심 포인트

1. **ArrayList는 동적 배열**:
   - 크기가 자동으로 조절됨
   - 다양한 편리한 메서드 제공

2. **제네릭 사용**:
   - 타입 안정성 보장
   - `ArrayList<타입>` 형식으로 선언

3. **래퍼 클래스**:
   - 기본형을 객체로 포장
   - 오토박싱/언박싱으로 편리하게 사용

4. **주요 메서드**:
   - add(), get(), set(), remove()
   - size(), contains(), indexOf()

5. **활용 패턴**:
   - for-each 루프 사용 가능
   - null 값 처리 주의
   - 중첩 구조 가능

💡 **기억하세요**: ArrayList는 배열의 단점을 보완한 강력한 데이터 구조입니다. 크기가 변하는 데이터를 다룰 때는 배열보다 ArrayList를 사용하는 것이 좋습니다!