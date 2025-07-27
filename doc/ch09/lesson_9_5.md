# 9.5 간단한 재귀 하강 파서 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- BNF(Backus-Naur Form) 문법을 이해하고 작성한다
- 재귀 하강 파싱의 원리를 이해한다
- 간단한 수식 파서를 구현한다
- 파싱을 통해 수식 트리를 생성한다
- 컴파일러의 기본 원리를 이해한다

## 1. 언어와 문법

### 1.1 프로그래밍 언어의 구조

프로그래밍 언어는 엄격한 규칙을 가진 인공 언어입니다:
- **구문(Syntax)**: 올바른 프로그램의 형태를 정의
- **의미(Semantics)**: 프로그램이 하는 일을 정의

컴파일러의 역할:
```
고급 언어 → 파싱 → 의미 분석 → 기계어 생성 → 실행 파일
```

### 1.2 파서(Parser)란?

**파서**는 텍스트를 분석하여 문법 구조를 파악하는 프로그램입니다.

예시: "2 + 3 * 4"를 파싱하면
```
      +
     / \
    2   *
       / \
      3   4
```

## 2. BNF (Backus-Naur Form)

### 2.1 BNF란?

BNF는 언어의 문법을 형식적으로 표현하는 방법입니다.

기본 요소:
- `<카테고리>`: 문법적 범주
- `::=`: "~일 수 있다"
- `|`: "또는"
- `" "`: 실제 문자
- `[ ]`: 선택사항
- `[ ]...`: 0회 이상 반복

### 2.2 BNF 예제

#### 간단한 수식 문법
```text
<expression> ::= <number> |
                 "(" <expression> <operator> <expression> ")"

<operator> ::= "+" | "-" | "*" | "/"

<number> ::= <digit> | <digit> <number>

<digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
```

#### 일반적인 수식 문법
```text
<expression> ::= [ "-" ] <term> [ ( "+" | "-" ) <term> ]...

<term> ::= <factor> [ ( "*" | "/" ) <factor> ]...

<factor> ::= <number> | "(" <expression> ")"
```

### 2.3 BNF의 재귀적 특성

BNF 규칙은 재귀적일 수 있습니다:

```text
<list> ::= <item> | <item> "," <list>
```

이는 "item" 또는 "item, item, item, ..."을 표현할 수 있습니다.

## 3. 재귀 하강 파싱

### 3.1 기본 원리

재귀 하강 파싱은 BNF 규칙을 직접 코드로 변환하는 방법입니다:
- 각 BNF 규칙 → 하나의 메서드
- 선택(|) → if-else 문
- 반복([...]...) → while 문
- 재귀 규칙 → 재귀 호출

### 3.2 간단한 예제: 연산자 파싱

BNF 규칙:
```text
<operator> ::= "+" | "-" | "*" | "/"
```

Java 코드:
```java
static char getOperator() throws ParseError {
    skipWhitespace();
    char ch = peek();  // 다음 문자 미리보기
    
    if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        getChar();  // 문자 읽기
        return ch;
    } else {
        throw new ParseError("연산자가 필요합니다");
    }
}
```

### 3.3 재귀적 파싱: 괄호 수식

BNF 규칙:
```text
<expression> ::= <number> |
                 "(" <expression> <operator> <expression> ")"
```

Java 코드:
```java
static double parseExpression() throws ParseError {
    skipWhitespace();
    
    if (Character.isDigit(peek())) {
        // 숫자인 경우
        return getNumber();
    } 
    else if (peek() == '(') {
        // 괄호 수식인 경우
        getChar();  // '(' 읽기
        double left = parseExpression();  // 재귀 호출!
        char op = getOperator();
        double right = parseExpression();  // 재귀 호출!
        
        skipWhitespace();
        if (peek() != ')') {
            throw new ParseError("')'가 필요합니다");
        }
        getChar();  // ')' 읽기
        
        // 계산
        switch (op) {
            case '+': return left + right;
            case '-': return left - right;
            case '*': return left * right;
            case '/': return left / right;
        }
    }
    else {
        throw new ParseError("예상치 못한 문자");
    }
}
```

## 4. 연산자 우선순위 처리

### 4.1 문제점

"2 + 3 * 4"는 14여야 하는데, 단순 파싱하면 20이 됩니다.

### 4.2 해결책: 문법 계층화

```text
<expression> ::= <term> [ ("+" | "-") <term> ]...
<term> ::= <factor> [ ("*" | "/") <factor> ]...
<factor> ::= <number> | "(" <expression> ")"
```

이렇게 하면 곱셈/나눗셈이 덧셈/뺄셈보다 먼저 처리됩니다.

### 4.3 구현 예제

```java
// 낮은 우선순위: + -
static double parseExpression() throws ParseError {
    double result = parseTerm();  // 첫 번째 항
    
    skipWhitespace();
    while (peek() == '+' || peek() == '-') {
        char op = getChar();
        double nextTerm = parseTerm();
        
        if (op == '+') {
            result += nextTerm;
        } else {
            result -= nextTerm;
        }
        skipWhitespace();
    }
    
    return result;
}

// 높은 우선순위: * /
static double parseTerm() throws ParseError {
    double result = parseFactor();  // 첫 번째 인수
    
    skipWhitespace();
    while (peek() == '*' || peek() == '/') {
        char op = getChar();
        double nextFactor = parseFactor();
        
        if (op == '*') {
            result *= nextFactor;
        } else {
            result /= nextFactor;
        }
        skipWhitespace();
    }
    
    return result;
}

// 기본 단위: 숫자 또는 괄호
static double parseFactor() throws ParseError {
    skipWhitespace();
    
    if (Character.isDigit(peek())) {
        return getNumber();
    }
    else if (peek() == '(') {
        getChar();  // '(' 읽기
        double value = parseExpression();  // 재귀!
        skipWhitespace();
        if (peek() != ')') {
            throw new ParseError("')'가 필요합니다");
        }
        getChar();  // ')' 읽기
        return value;
    }
    else {
        throw new ParseError("숫자나 '('가 필요합니다");
    }
}
```

## 5. 수식 트리 생성

### 5.1 값 계산 대신 트리 생성

파서를 수정하여 계산 대신 트리를 만들 수 있습니다:

```java
static ExpNode parseExpression() throws ParseError {
    ExpNode left = parseTerm();
    
    skipWhitespace();
    while (peek() == '+' || peek() == '-') {
        char op = getChar();
        ExpNode right = parseTerm();
        
        // 새로운 노드를 만들어 트리 구성
        left = new BinOpNode(op, left, right);
        skipWhitespace();
    }
    
    return left;
}
```

### 5.2 수식 트리 활용

생성된 트리로 할 수 있는 일:
1. **계산**: 트리를 순회하며 값 계산
2. **변환**: 다른 표기법으로 변환
3. **최적화**: 트리 구조 개선
4. **코드 생성**: 기계어 명령 생성

## 6. 실전 예제: 간단한 계산기

```java
public class SimpleCalculator {
    private static String input;
    private static int pos;
    
    // 현재 문자 확인
    private static char peek() {
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }
    
    // 문자 읽기
    private static char getChar() {
        if (pos < input.length()) {
            return input.charAt(pos++);
        }
        return '\0';
    }
    
    // 공백 건너뛰기
    private static void skipWhitespace() {
        while (pos < input.length() && 
               Character.isWhitespace(input.charAt(pos))) {
            pos++;
        }
    }
    
    // 숫자 읽기
    private static double getNumber() {
        StringBuilder sb = new StringBuilder();
        
        while (Character.isDigit(peek()) || peek() == '.') {
            sb.append(getChar());
        }
        
        return Double.parseDouble(sb.toString());
    }
    
    // 메인 파싱 메서드들...
    
    public static double calculate(String expression) 
            throws ParseError {
        input = expression;
        pos = 0;
        double result = parseExpression();
        
        skipWhitespace();
        if (pos < input.length()) {
            throw new ParseError("예상치 못한 문자: " + peek());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(calculate("2 + 3 * 4"));  // 14
            System.out.println(calculate("(2 + 3) * 4"));  // 20
            System.out.println(calculate("10 / 2 - 3"));  // 2
        } catch (ParseError e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}
```

## 7. 컴파일러로의 확장

### 7.1 파서의 역할

실제 컴파일러에서 파서는:
1. **구문 분석**: 프로그램이 문법에 맞는지 확인
2. **파스 트리 생성**: 프로그램 구조를 트리로 표현
3. **의미 분석 준비**: 타입 검사 등을 위한 정보 수집

### 7.2 간단한 프로그래밍 언어 예제

```text
<program> ::= <statement> [ <statement> ]...

<statement> ::= <assignment> | <if-statement> | <while-loop>

<assignment> ::= <variable> "=" <expression> ";"

<if-statement> ::= "if" "(" <condition> ")" <statement>
                   [ "else" <statement> ]

<while-loop> ::= "while" "(" <condition> ")" <statement>
```

## 8. 파싱의 응용

### 8.1 다양한 활용 분야
- **컴파일러**: 프로그래밍 언어 → 기계어
- **인터프리터**: 코드를 직접 실행
- **IDE**: 구문 강조, 자동 완성
- **데이터 처리**: JSON, XML 파싱
- **자연어 처리**: 문장 구조 분석

### 8.2 파서 생성기

수동으로 파서를 작성하는 대신 도구를 사용할 수도 있습니다:
- **ANTLR**: 강력한 파서 생성기
- **JavaCC**: Java 컴파일러 컴파일러
- **Yacc/Bison**: 전통적인 파서 생성기

## 마무리

재귀 하강 파싱은:
1. **직관적**: BNF 규칙이 직접 코드로 변환됨
2. **이해하기 쉬움**: 재귀의 자연스러운 활용
3. **유연함**: 의미 분석을 쉽게 추가 가능
4. **실용적**: 많은 실제 컴파일러에서 사용

이제 여러분은 간단한 언어를 파싱하고, 컴파일러의 기본 원리를 이해할 수 있습니다!