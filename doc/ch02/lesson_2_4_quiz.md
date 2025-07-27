# 2.4 텍스트 입력과 출력 - 퀴즈

## 객관식 문제

### 1. 다음 중 줄바꿈을 하지 않는 출력 메소드는?
a) `System.out.println()`
b) `System.out.print()`
c) `System.out.printf()`
d) b와 c 모두

### 2. printf에서 정수를 출력하는 서식 지정자는?
a) `%i`
b) `%d`
c) `%n`
d) `%s`

### 3. `System.out.printf("%.2f", 3.14159)`의 출력 결과는?
a) 3.14159
b) 3.14
c) 3.1
d) 3

### 4. TextIO.getlnInt()가 하는 일은?
a) 정수를 출력한다
b) 정수를 입력받아 반환한다
c) 정수를 문자열로 변환한다
d) 정수의 줄 번호를 반환한다

### 5. 천 단위 구분 기호를 포함하여 숫자를 출력하는 서식은?
a) `%d`
b) `%,d`
c) `%$d`
d) `%#d`

### 6. TextIO.writeFile("output.txt") 호출 후 TextIO.putln()을 사용하면?
a) 화면에 출력된다
b) output.txt 파일에 쓰여진다
c) 오류가 발생한다
d) 아무 일도 일어나지 않는다

### 7. getln과 get 함수의 차이점은?
a) 반환 타입이 다르다
b) getln은 한 줄 전체를 소비한다
c) get은 더 빠르다
d) 차이가 없다

### 8. Scanner 클래스는 어느 패키지에 속해 있나요?
a) java.lang
b) java.util
c) java.io
d) java.scanner

### 9. printf에서 줄바꿈을 나타내는 서식 지정자는?
a) `\n`
b) `%n`
c) `\r`
d) `%r`

### 10. `System.out.printf("%5d", 42)`의 출력 결과는?
a) "42"
b) "42   "
c) "   42"
d) "00042"

## 주관식 문제

### 1. print(), println(), printf()의 차이점을 설명하시오.

### 2. 다음 코드의 출력 결과를 예측하시오.
```java
double price = 12345.678;
System.out.printf("가격: %,.2f원%n", price);
System.out.printf("정가: %10.0f원%n", price);
```

### 3. TextIO의 입력 함수에서 사용자가 잘못된 타입을 입력했을 때 어떻게 처리되는지 설명하시오.

## 학습 체크리스트

다음 항목들을 이해했는지 확인하세요:

- [ ] print()와 println()의 차이를 안다
- [ ] printf()로 서식을 지정한 출력을 할 수 있다
- [ ] 정수(%d), 실수(%f), 문자열(%s) 서식 지정자를 사용할 수 있다
- [ ] 너비와 정밀도를 지정할 수 있다
- [ ] TextIO로 다양한 타입의 입력을 받을 수 있다
- [ ] getln과 get의 차이를 이해한다
- [ ] 파일에 쓰고 읽을 수 있다
- [ ] 표준 입출력으로 복귀하는 방법을 안다
- [ ] Scanner 클래스의 기본 사용법을 안다
- [ ] 천 단위 구분과 같은 고급 서식을 사용할 수 있다