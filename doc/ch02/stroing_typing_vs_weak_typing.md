# String Typing vs Weak Typing

## Strong Typing (강타입)

**특징:**
- 타입 간의 암시적(implicit) 변환을 허용하지 않거나 매우 제한적으로 허용
- 타입 불일치 시 오류 발생
- 런타임 또는 컴파일 타임에 타입 안정성 보장

**예시 언어:** Python, Java, Ruby

```python
# Python (Strong Typing)
x = "5"
y = 10
# print(x + y)  # TypeError 발생
print(int(x) + y)  # 명시적 변환 필요: 15
```

```java
// Java (Strong Typing)
String x = "5";
int y = 10;
// System.out.println(x + y); // 컴파일 에러
System.out.println(Integer.parseInt(x) + y); // 15
```

## Weak Typing (약타입)

**특징:**
- 타입 간의 암시적 변환을 자유롭게 허용
- 서로 다른 타입 간의 연산이 가능
- 편리하지만 예상치 못한 결과를 초래할 수 있음

**예시 언어:** JavaScript, PHP, C

```javascript
// JavaScript (Weak Typing)
let x = "5";
let y = 10;
console.log(x + y);  // "510" (문자열 연결)
console.log(x - y);  // -5 (숫자 연산)
console.log(x * y);  // 50 (숫자 연산)
```

```php
// PHP (Weak Typing)
$x = "5";
$y = 10;
echo $x + $y;  // 15 (자동으로 숫자로 변환)
```

## 주요 차이점

| 구분           | Strong Typing    | Weak Typing      |
| -------------- | ---------------- | ---------------- |
| 타입 변환      | 명시적 변환 필요 | 암시적 변환 허용 |
| 타입 안정성    | 높음             | 낮음             |
| 오류 발견 시점 | 일찍 발견 가능   | 런타임에 발견    |
| 개발 편의성    | 엄격하지만 안전  | 유연하지만 위험  |

## 장단점

**Strong Typing 장점:**
- 타입 관련 버그 조기 발견
- 코드의 의도가 명확
- 대규모 프로젝트에서 유지보수 용이

**Strong Typing 단점:**
- 코드 작성 시 더 많은 타입 지정 필요
- 때로는 불필요하게 장황할 수 있음

**Weak Typing 장점:**
- 빠른 프로토타이핑 가능
- 코드가 간결
- 유연한 프로그래밍 가능

**Weak Typing 단점:**
- 예상치 못한 타입 변환으로 인한 버그
- 디버깅이 어려울 수 있음
- 코드의 의도 파악이 어려울 수 있음

## 혼동하기 쉬운 개념

Strong/Weak Typing은 종종 Static/Dynamic Typing과 혼동되지만, 이들은 다른 개념입니다:

- **Static/Dynamic Typing**: 타입 검사가 언제 일어나는지 (컴파일 타임 vs 런타임)
- **Strong/Weak Typing**: 타입 시스템이 얼마나 엄격한지

예를 들어, Python은 Dynamic + Strong Typing이고, JavaScript는 Dynamic + Weak Typing입니다.