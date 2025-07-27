# 7.2 배열 처리 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 배열 처리 시 인덱스 범위 오류를 예방한다
- 부분적으로 채워진 배열을 효과적으로 관리한다
- Arrays 클래스의 유용한 메서드들을 활용한다
- 병렬 배열과 객체 배열의 장단점을 이해한다
- 동적 배열의 개념을 이해하고 구현한다

## 1. 배열 인덱스 처리 주의사항

### 1.1 인덱스 범위 오류

배열 처리에서 가장 흔한 오류는 **ArrayIndexOutOfBoundsException**입니다.

```java
// ❌ 잘못된 예제: 인덱스 범위 초과
String[] lines = {"A", "B", "C", "D", "E"};
boolean dupp = false;

for (int i = 0; i < lines.length; i++) {
    if (lines[i].equals(lines[i+1])) {  // 오류! i가 4일 때 lines[5] 접근
        dupp = true;
        break;
    }
}
```

### 1.2 올바른 해결 방법

```java
// ✅ 올바른 예제: 인덱스 범위 조정
boolean dupp = false;

for (int i = 0; i < lines.length - 1; i++) {  // length-1로 제한
    if (lines[i].equals(lines[i+1])) {
        dupp = true;
        break;
    }
}
```

**핵심 원칙**: 
- 배열의 마지막 인덱스는 `array.length - 1`
- `i+1`, `i-1` 등을 사용할 때는 범위 검사 필수

## 2. 부분적으로 채워진 배열 (Partially Filled Arrays)

### 2.1 개념과 필요성

배열의 크기는 고정되어 있지만, 실제 사용하는 요소의 수는 변할 수 있습니다.

```java
// 부분적으로 채워진 배열의 기본 구조
int maxSize = 100;           // 최대 크기
String[] items = new String[maxSize];  // 배열 생성
int itemCount = 0;           // 실제 사용 중인 요소 수

// 항목 추가
if (itemCount < maxSize) {
    items[itemCount] = "새 항목";
    itemCount++;
}
```

### 2.2 플레이어 관리 예제

```java
public class GamePlayerManager {
    private Player[] playerList = new Player[10];  // 최대 10명
    private int playerCt = 0;                      // 현재 플레이어 수
    
    // 플레이어 추가
    public void addPlayer(Player newPlayer) {
        if (playerCt < playerList.length) {
            playerList[playerCt] = newPlayer;
            playerCt++;
            System.out.println("플레이어 추가됨: " + newPlayer.getName());
        } else {
            System.out.println("플레이어 목록이 가득 찼습니다!");
        }
    }
    
    // 플레이어 제거 (순서 유지하지 않음)
    public void removePlayerQuick(int index) {
        if (index < 0 || index >= playerCt) {
            throw new IndexOutOfBoundsException("잘못된 인덱스");
        }
        
        // 마지막 플레이어를 삭제할 위치로 이동
        playerList[index] = playerList[playerCt - 1];
        playerList[playerCt - 1] = null;  // 참조 제거
        playerCt--;
    }
    
    // 플레이어 제거 (순서 유지)
    public void removePlayerOrdered(int index) {
        if (index < 0 || index >= playerCt) {
            throw new IndexOutOfBoundsException("잘못된 인덱스");
        }
        
        // 뒤의 요소들을 한 칸씩 앞으로 이동
        for (int i = index + 1; i < playerCt; i++) {
            playerList[i - 1] = playerList[i];
        }
        playerList[playerCt - 1] = null;
        playerCt--;
    }
}
```

### 2.3 배열 크기 동적 확장

배열이 가득 찼을 때 더 큰 배열로 교체하는 방법:

```java
public void addPlayerWithExpansion(Player newPlayer) {
    // 배열이 가득 찬 경우
    if (playerCt == playerList.length) {
        // 크기가 2배인 새 배열 생성
        Player[] temp = new Player[playerList.length * 2];
        
        // 기존 데이터 복사
        for (int i = 0; i < playerList.length; i++) {
            temp[i] = playerList[i];
        }
        
        // 새 배열로 교체
        playerList = temp;
        System.out.println("배열 크기 확장: " + playerList.length);
    }
    
    // 플레이어 추가
    playerList[playerCt] = newPlayer;
    playerCt++;
}
```

## 3. Arrays 클래스의 유용한 메서드들

### 3.1 Arrays.copyOf()

```java
// 배열 복사
int[] original = {1, 2, 3, 4, 5};

// 같은 크기로 복사
int[] copy1 = Arrays.copyOf(original, original.length);

// 더 큰 크기로 복사 (추가 공간은 0으로 채워짐)
int[] copy2 = Arrays.copyOf(original, 10);

// 더 작은 크기로 복사 (일부만 복사)
int[] copy3 = Arrays.copyOf(original, 3);  // {1, 2, 3}
```

### 3.2 Arrays.fill()

```java
// 배열을 특정 값으로 채우기
int[] numbers = new int[10];
Arrays.fill(numbers, 7);  // 모든 요소를 7로

// 부분적으로 채우기
int[] scores = new int[10];
Arrays.fill(scores, 0, 5, 100);  // 인덱스 0~4를 100으로
```

### 3.3 Arrays.sort()

```java
// 배열 정렬
int[] values = {5, 2, 8, 1, 9};
Arrays.sort(values);  // {1, 2, 5, 8, 9}

// 부분 정렬
String[] names = {"David", "Alice", "Charlie", "Bob", "Eve"};
Arrays.sort(names, 1, 4);  // 인덱스 1~3만 정렬
// 결과: {"David", "Alice", "Bob", "Charlie", "Eve"}
```

### 3.4 Arrays.toString()

```java
// 배열을 문자열로 변환
int[] array = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(array));  // [1, 2, 3, 4, 5]

String[] fruits = {"사과", "바나나", "오렌지"};
System.out.println(Arrays.toString(fruits));  // [사과, 바나나, 오렌지]
```

### 3.5 Arrays.binarySearch()

```java
// 이진 검색 (배열이 정렬되어 있어야 함)
int[] sorted = {1, 3, 5, 7, 9, 11, 13};
int index = Arrays.binarySearch(sorted, 7);  // 3 반환
int notFound = Arrays.binarySearch(sorted, 6);  // 음수 반환
```

## 4. 병렬 배열 vs 객체 배열

### 4.1 병렬 배열 (Parallel Arrays)

관련된 데이터를 여러 배열에 분산 저장하는 방식:

```java
// 학생 정보를 병렬 배열로 관리
String[] names = new String[30];
int[] ages = new int[30];
double[] grades = new double[30];
int studentCount = 0;

// 학생 추가
public void addStudent(String name, int age, double grade) {
    names[studentCount] = name;
    ages[studentCount] = age;
    grades[studentCount] = grade;
    studentCount++;
}

// 학생 정보 출력
public void printStudent(int index) {
    System.out.println("이름: " + names[index]);
    System.out.println("나이: " + ages[index]);
    System.out.println("성적: " + grades[index]);
}
```

### 4.2 객체 배열 (권장)

관련 데이터를 하나의 객체로 묶어 관리:

```java
// 학생 클래스
class Student {
    String name;
    int age;
    double grade;
    
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

// 객체 배열로 관리
Student[] students = new Student[30];
int studentCount = 0;

// 학생 추가
public void addStudent(String name, int age, double grade) {
    students[studentCount] = new Student(name, age, grade);
    studentCount++;
}

// 학생 정보 출력
public void printStudent(int index) {
    Student s = students[index];
    System.out.println("이름: " + s.name);
    System.out.println("나이: " + s.age);
    System.out.println("성적: " + s.grade);
}
```

### 4.3 장단점 비교

**병렬 배열의 단점**:
- 데이터 간의 관계가 명시적이지 않음
- 실수로 인덱스를 잘못 사용할 가능성
- 데이터 추가/삭제 시 모든 배열을 동기화해야 함

**객체 배열의 장점**:
- 데이터가 논리적으로 그룹화됨
- 타입 안정성 향상
- 코드 가독성과 유지보수성 향상

## 5. 동적 배열 (Dynamic Arrays)

### 5.1 동적 배열의 필요성

- 고정 크기 배열의 한계 극복
- 실행 시간에 크기 조정 가능
- 메모리 효율적 사용

### 5.2 동적 배열 클래스 구현

```java
public class DynamicArrayOfInt {
    private int[] items = new int[8];  // 초기 크기
    private int itemCt = 0;            // 실제 항목 수
    
    // 항목 추가
    public void add(int item) {
        // 배열이 가득 찬 경우 크기 확장
        if (itemCt == items.length) {
            items = Arrays.copyOf(items, 2 * items.length);
        }
        items[itemCt] = item;
        itemCt++;
    }
    
    // 항목 가져오기
    public int get(int index) {
        if (index < 0 || index >= itemCt) {
            throw new ArrayIndexOutOfBoundsException("잘못된 인덱스: " + index);
        }
        return items[index];
    }
    
    // 항목 설정
    public void set(int index, int item) {
        if (index < 0 || index >= itemCt) {
            throw new ArrayIndexOutOfBoundsException("잘못된 인덱스: " + index);
        }
        items[index] = item;
    }
    
    // 항목 제거
    public void remove(int index) {
        if (index < 0 || index >= itemCt) {
            throw new ArrayIndexOutOfBoundsException("잘못된 인덱스: " + index);
        }
        
        // 뒤의 요소들을 앞으로 이동
        for (int j = index + 1; j < itemCt; j++) {
            items[j - 1] = items[j];
        }
        itemCt--;
        
        // 배열이 너무 비어있으면 크기 축소 (선택사항)
        if (itemCt > 0 && itemCt < items.length / 4) {
            items = Arrays.copyOf(items, items.length / 2);
        }
    }
    
    // 크기 반환
    public int size() {
        return itemCt;
    }
    
    // 비어있는지 확인
    public boolean isEmpty() {
        return itemCt == 0;
    }
    
    // 모든 항목 제거
    public void clear() {
        itemCt = 0;
        items = new int[8];  // 초기 크기로 재설정
    }
}
```

### 5.3 동적 배열의 활용

```java
public class DynamicArrayExample {
    public static void main(String[] args) {
        DynamicArrayOfInt numbers = new DynamicArrayOfInt();
        
        // 항목 추가 (크기 제한 없음)
        for (int i = 1; i <= 100; i++) {
            numbers.add(i * i);  // 제곱수 추가
        }
        
        System.out.println("항목 수: " + numbers.size());
        
        // 항목 접근
        System.out.println("10번째 항목: " + numbers.get(9));
        
        // 항목 수정
        numbers.set(0, 999);
        
        // 항목 제거
        numbers.remove(5);
        
        // 모든 항목 출력
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
```

## 6. 실전 예제: RandomStrings 개선

### 6.1 병렬 배열에서 객체 배열로

```java
// 이전: 병렬 배열 사용
double[] x = new double[25];
double[] y = new double[25];
Color[] colors = new Color[25];
Font[] fonts = new Font[25];

// 개선: 객체 배열 사용
class StringData {
    double x, y;
    double dx, dy;  // 속도
    Color color;
    Font font;
}

StringData[] stringData = new StringData[25];
```

### 6.2 글꼴 배열 활용

```java
// 글꼴 배열 정의
private static final Font[] FONTS = {
    Font.font("Arial", FontWeight.BOLD, 20),
    Font.font("Times New Roman", 24),
    Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18),
    Font.font("Courier New", 22),
    Font.font("Georgia", 26)
};

// 무작위 글꼴 선택
Font randomFont = FONTS[(int)(Math.random() * FONTS.length)];
```

## 요약

### 핵심 포인트

1. **인덱스 범위 관리**:
   - 항상 배열 범위 확인
   - 특히 `i+1`, `i-1` 사용 시 주의

2. **부분적으로 채워진 배열**:
   - 실제 사용 크기를 별도로 관리
   - 동적으로 크기 조정 가능

3. **Arrays 클래스 활용**:
   - copyOf, fill, sort, toString 등
   - 배열 처리를 간편하게

4. **객체 배열 선호**:
   - 병렬 배열보다 객체 배열 사용
   - 데이터 구조화와 유지보수성 향상

5. **동적 배열**:
   - ArrayList의 기본 원리
   - 필요에 따라 크기 자동 조정

💡 **기억하세요**: 배열은 강력한 도구이지만, 인덱스 관리와 크기 제한에 주의해야 합니다. Java의 ArrayList 클래스는 이러한 문제를 해결한 표준 솔루션입니다!