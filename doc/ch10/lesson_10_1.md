# 10.1 제네릭 프로그래밍 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 제네릭 프로그래밍의 개념과 필요성을 이해한다
- Java의 제네릭 타입을 사용할 수 있다
- Java 컬렉션 프레임워크의 기본 구조를 이해한다
- Iterator와 for-each 루프를 활용한다
- 동등성과 비교를 올바르게 구현한다

## 1. 제네릭 프로그래밍이란?

### 1.1 기본 개념

**제네릭 프로그래밍**은 여러 데이터 타입에 대해 작동하는 코드를 작성하는 프로그래밍 기법입니다.

예시: 동적 배열
```java
// 제네릭이 없다면...
class IntArrayList { ... }     // 정수용
class StringArrayList { ... }  // 문자열용
class ColorArrayList { ... }   // 색상용

// 제네릭을 사용하면!
ArrayList<Integer> intList = new ArrayList<>();
ArrayList<String> stringList = new ArrayList<>();
ArrayList<Color> colorList = new ArrayList<>();
```

### 1.2 제네릭의 장점

1. **코드 재사용성**: 하나의 클래스로 여러 타입 처리
2. **타입 안전성**: 컴파일 시점에 타입 체크
3. **가독성**: 명확한 타입 표현
4. **성능**: 불필요한 타입 캐스팅 제거

## 2. 다른 언어의 제네릭 프로그래밍

### 2.1 Smalltalk 방식

**특징**:
- 변수에 타입이 없음
- 모든 연산은 메서드 호출
- 진정한 제네릭 프로그래밍

**장단점**:
- 장점: 매우 유연함
- 단점: 런타임 오류 가능성

### 2.2 C++ 템플릿

**템플릿 예시**:
```cpp
template<class T>
void sort(T arr[], int size) {
    // T 타입의 배열 정렬
}
```

**특징**:
- 컴파일 시점에 코드 생성
- 각 타입별로 별도의 코드 생성

### 2.3 Java 방식

**특징**:
- 타입 파라미터 사용
- 컴파일 시점 타입 체크
- 런타임에는 타입 정보 제거 (Type Erasure)

## 3. Java의 매개변수화된 타입

### 3.1 기본 사용법

```java
// 선언
ArrayList<String> names = new ArrayList<String>();

// Java 7 이후: 다이아몬드 연산자
ArrayList<String> names = new ArrayList<>();

// 사용
names.add("홍길동");
String name = names.get(0);  // 타입 캐스팅 불필요!
```

### 3.2 타입 매개변수 규칙

```java
// 단일 타입 매개변수
public class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
}

// 사용
Box<String> stringBox = new Box<>();
Box<Integer> intBox = new Box<>();
```

### 3.3 타입 소거 (Type Erasure)

Java의 제네릭은 컴파일 시점에만 존재하고 런타임에는 제거됩니다.

**제한사항**:
```java
// 불가능한 것들
if (list instanceof ArrayList<String>) { }  // 오류!
ArrayList<String>[] array = new ArrayList<String>[10];  // 오류!
```

## 4. Java 컬렉션 프레임워크 (JCF)

### 4.1 구조 개요

```
Collection<E>
    ├── List<E>
    │     ├── ArrayList<E>
    │     ├── LinkedList<E>
    │     └── Vector<E>
    └── Set<E>
          ├── HashSet<E>
          ├── TreeSet<E>
          └── LinkedHashSet<E>

Map<K,V>
    ├── HashMap<K,V>
    ├── TreeMap<K,V>
    └── LinkedHashMap<K,V>
```

### 4.2 Collection 인터페이스

**주요 메서드**:
```java
Collection<String> coll = new ArrayList<>();

// 크기 관련
int size = coll.size();
boolean empty = coll.isEmpty();

// 추가/제거
coll.add("항목");
coll.remove("항목");
coll.clear();

// 포함 여부
boolean contains = coll.contains("항목");

// 벌크 연산
coll.addAll(otherCollection);
coll.removeAll(otherCollection);
coll.retainAll(otherCollection);
```

### 4.3 List vs Set

**List**:
- 순서가 있음
- 중복 허용
- 인덱스로 접근 가능

**Set**:
- 순서가 없음 (또는 특별한 순서)
- 중복 불허
- 수학적 집합 개념

## 5. Iterator와 순회

### 5.1 Iterator 패턴

```java
Collection<String> names = new ArrayList<>();
names.add("홍길동");
names.add("김철수");

// Iterator 사용
Iterator<String> iter = names.iterator();
while (iter.hasNext()) {
    String name = iter.next();
    System.out.println(name);
}
```

### 5.2 for-each 루프

```java
// 간편한 방법
for (String name : names) {
    System.out.println(name);
}

// 배열에서도 사용 가능
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```

### 5.3 Iterator의 장점

1. **통일된 인터페이스**: 모든 컬렉션에 동일한 방법 적용
2. **안전한 제거**: 순회 중 요소 제거 가능
3. **구현 독립적**: 내부 구조와 무관하게 순회

## 6. 동등성과 비교

### 6.1 equals() 메서드

```java
public class Student {
    private String id;
    private String name;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return id.equals(student.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
```

### 6.2 Comparable 인터페이스

```java
public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    
    @Override
    public int compareTo(Student other) {
        // GPA로 비교 (내림차순)
        return Double.compare(other.gpa, this.gpa);
    }
}
```

### 6.3 Comparator 인터페이스

```java
// 이름으로 정렬하는 Comparator
Comparator<Student> byName = new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
};

// 람다 표현식 사용
Comparator<Student> byGpa = (s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa());
```

## 7. 래퍼 클래스와 오토박싱

### 7.1 기본 타입과 래퍼 클래스

| 기본 타입 | 래퍼 클래스 |
|-----------|-------------|
| int       | Integer     |
| double    | Double      |
| boolean   | Boolean     |
| char      | Character   |

### 7.2 오토박싱과 언박싱

```java
// 오토박싱: 기본 타입 → 래퍼 객체
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(42);  // int가 자동으로 Integer로 변환

// 언박싱: 래퍼 객체 → 기본 타입
int value = numbers.get(0);  // Integer가 자동으로 int로 변환
```

## 8. 제네릭 사용 시 주의사항

### 8.1 타입 제한

```java
// 기본 타입은 사용 불가
// ArrayList<int> list = new ArrayList<>();  // 오류!
ArrayList<Integer> list = new ArrayList<>();  // OK

// 와일드카드 사용
ArrayList<?> anyList;  // 모든 타입
ArrayList<? extends Number> numberList;  // Number의 하위 타입
ArrayList<? super Integer> integerOrSuper;  // Integer의 상위 타입
```

### 8.2 제네릭 메서드

```java
public static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
```

## 마무리

제네릭 프로그래밍은 현대 Java 프로그래밍의 핵심입니다:

1. **타입 안전성**: 컴파일 시점에 오류 발견
2. **코드 재사용**: 하나의 코드로 여러 타입 처리
3. **가독성**: 명확한 타입 표현
4. **성능**: 불필요한 캐스팅 제거

Java 컬렉션 프레임워크를 효과적으로 사용하려면 제네릭을 잘 이해해야 합니다!