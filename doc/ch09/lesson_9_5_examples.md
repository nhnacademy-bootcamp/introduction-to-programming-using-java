# 9.5 간단한 재귀 하강 파서 - 예제 모음

## 1. BNF 문법 예제

### 예제 1-1: 다양한 BNF 표현

```text
// 1. 간단한 정수
<integer> ::= <digit> | <digit> <integer>
<digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"

// 2. 부호있는 정수
<signed-integer> ::= [ "+" | "-" ] <integer>

// 3. 실수
<real-number> ::= <integer> [ "." <integer> ]

// 4. 변수명 (문자로 시작, 문자와 숫자 포함)
<identifier> ::= <letter> [ <letter> | <digit> ]...
<letter> ::= "a" | "b" | ... | "z" | "A" | "B" | ... | "Z"

// 5. 리스트
<list> ::= "[" [ <item> [ "," <item> ]... ] "]"
<item> ::= <integer> | <identifier>

// 6. 함수 호출
<function-call> ::= <identifier> "(" [ <argument> [ "," <argument> ]... ] ")"
<argument> ::= <expression>
```

### 예제 1-2: 프로그래밍 언어 구조

```text
// 간단한 프로그래밍 언어 문법
<program> ::= [ <statement> ]...

<statement> ::= <variable-declaration> |
                <assignment> |
                <if-statement> |
                <while-loop> |
                <print-statement>

<variable-declaration> ::= "var" <identifier> [ "=" <expression> ] ";"

<assignment> ::= <identifier> "=" <expression> ";"

<if-statement> ::= "if" "(" <condition> ")" <block>
                   [ "else" <block> ]

<while-loop> ::= "while" "(" <condition> ")" <block>

<print-statement> ::= "print" <expression> ";"

<block> ::= "{" [ <statement> ]... "}"

<condition> ::= <expression> <comparison-op> <expression>

<comparison-op> ::= "==" | "!=" | "<" | ">" | "<=" | ">="
```

## 2. 기본 파서 구현

### 예제 2-1: 파서 기본 구조

```java
public class BasicParser {
    private String input;
    private int position;
    
    // 파싱 예외
    static class ParseError extends Exception {
        public ParseError(String message) {
            super(message);
        }
    }
    
    // 기본 유틸리티 메서드
    private char peek() {
        if (position < input.length()) {
            return input.charAt(position);
        }
        return '\0';  // 입력 끝
    }
    
    private char next() {
        char ch = peek();
        position++;
        return ch;
    }
    
    private void skipWhitespace() {
        while (position < input.length() && 
               Character.isWhitespace(input.charAt(position))) {
            position++;
        }
    }
    
    private boolean isAtEnd() {
        skipWhitespace();
        return position >= input.length();
    }
    
    // 특정 문자 기대
    private void expect(char expected) throws ParseError {
        skipWhitespace();
        if (peek() != expected) {
            throw new ParseError("'" + expected + "'가 필요하지만 '" + 
                                peek() + "'를 발견했습니다.");
        }
        next();
    }
    
    // 문자열 매칭
    private boolean match(String str) {
        skipWhitespace();
        int savedPos = position;
        
        for (char ch : str.toCharArray()) {
            if (next() != ch) {
                position = savedPos;
                return false;
            }
        }
        
        return true;
    }
}
```

### 예제 2-2: 숫자 파서

```java
public class NumberParser extends BasicParser {
    
    // <integer> ::= <digit> | <digit> <integer>
    public int parseInteger() throws ParseError {
        skipWhitespace();
        
        // TODO 1: 현재 문자가 숫자가 아니면 ParseError 던지기
        
        // TODO 2: 숫자를 읽어서 정수로 변환
        // 힌트: 반복문을 사용하여 연속된 숫자를 읽고,
        //      result = result * 10 + (next() - '0') 방식으로 값 축적
        
        return 0; // 임시 반환값
    }
    
    // <signed-integer> ::= [ "+" | "-" ] <integer>
    public int parseSignedInteger() throws ParseError {
        skipWhitespace();
        
        // TODO 1: 부호 처리
        // - '+' 또는 '-'가 있는지 확인
        // - '-'인 경우 negative 플래그 설정
        
        // TODO 2: parseInteger()를 호출하여 숫자 파싱
        
        // TODO 3: negative이면 음수로 변환하여 반환
        
        return 0; // 임시 반환값
    }
    
    // <real-number> ::= <integer> [ "." <integer> ]
    public double parseRealNumber() throws ParseError {
        // TODO 1: parseInteger()로 정수 부분 파싱
        
        // TODO 2: 소수점이 있는지 확인
        // TODO 3: 소수점이 있으면:
        //   - '.' 소비
        //   - 다음 문자가 숫자인지 확인 (아니면 예외)
        //   - 소수 부분 파싱 (반복문으로 숫자 읽기)
        //   - 힌트: fraction += (next() - '0') / divisor; divisor *= 10;
        
        return 0.0; // 임시 반현값
    }
    
    // 테스트
    public static void main(String[] args) {
        NumberParser parser = new NumberParser();
        
        try {
            parser.input = "123";
            parser.position = 0;
            System.out.println(parser.parseInteger());  // 123
            
            parser.input = "-456";
            parser.position = 0;
            System.out.println(parser.parseSignedInteger());  // -456
            
            parser.input = "3.14159";
            parser.position = 0;
            System.out.println(parser.parseRealNumber());  // 3.14159
            
        } catch (ParseError e) {
            System.err.println("파싱 오류: " + e.getMessage());
        }
    }
}
```

## 3. 수식 파서 (우선순위 처리)

### 예제 3-1: 완전한 수식 파서

```java
public class ExpressionParser extends BasicParser {
    
    // <expression> ::= <term> [ ("+" | "-") <term> ]...
    public double parseExpression() throws ParseError {
        // TODO 1: parseTerm()으로 첫 번째 항 파싱
        
        // TODO 2: '+' 또는 '-' 연산자가 있는 동안 반복:
        //   - 연산자 저장
        //   - parseTerm()으로 다음 항 파싱
        //   - 연산자에 따라 덧셈/뻔셈 수행
        
        return 0.0; // 임시 반환값
    }
    
    // <term> ::= <factor> [ ("*" | "/") <factor> ]...
    public double parseTerm() throws ParseError {
        // TODO 1: parseFactor()로 첫 번째 인수 파싱
        
        // TODO 2: '*' 또는 '/' 연산자가 있는 동안 반복:
        //   - 연산자 저장
        //   - parseFactor()로 다음 인수 파싱
        //   - 곱셈/나눗셈 수행 (나눗셈시 0 검사)
        
        return 0.0; // 임시 반환값
    }
    
    // <factor> ::= <number> | "(" <expression> ")" | "-" <factor>
    public double parseFactor() throws ParseError {
        skipWhitespace();
        
        // TODO 1: 음수 처리 - '-'로 시작하면 parseFactor() 재귀 호출
        
        // TODO 2: 괄호 처리 - '('로 시작하면:
        //   - '(' 소비
        //   - parseExpression() 호출
        //   - ')' 기대 (expect 메서드 사용)
        
        // TODO 3: 숫자 처리 - 숫자나 '.' 로 시작하면 parseNumber() 호출
        
        // TODO 4: 그 외의 경우 ParseError 던지기
        
        return 0.0; // 임시 반환값
    }
    
    // 숫자 파싱 (정수 또는 실수)
    private double parseNumber() throws ParseError {
        StringBuilder sb = new StringBuilder();
        
        // 정수 부분
        while (Character.isDigit(peek())) {
            sb.append(next());
        }
        
        // 소수 부분
        if (peek() == '.') {
            sb.append(next());
            
            if (!Character.isDigit(peek())) {
                throw new ParseError("소수점 뒤에 숫자가 필요합니다");
            }
            
            while (Character.isDigit(peek())) {
                sb.append(next());
            }
        }
        
        return Double.parseDouble(sb.toString());
    }
    
    // 편의 메서드: 전체 수식 파싱
    public double parse(String expression) throws ParseError {
        this.input = expression;
        this.position = 0;
        
        double result = parseExpression();
        
        if (!isAtEnd()) {
            throw new ParseError("예상치 못한 문자: " + peek());
        }
        
        return result;
    }
    
    // 테스트
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        
        String[] expressions = {
            "2 + 3",
            "2 + 3 * 4",
            "(2 + 3) * 4",
            "10 / 2 - 3",
            "3.14 * 2 * 2",
            "-5 + 3",
            "-(2 + 3) * 4",
            "1 + 2 * 3 - 4 / 2"
        };
        
        for (String expr : expressions) {
            try {
                double result = parser.parse(expr);
                System.out.printf("%s = %.2f%n", expr, result);
            } catch (ParseError e) {
                System.err.println(expr + " : " + e.getMessage());
            }
        }
    }
}
```

## 4. 수식 트리 생성 파서

### 예제 4-1: 수식 트리 노드 클래스

```java
// 수식 트리의 기본 노드
abstract class ExprNode {
    abstract double evaluate();
    abstract String toInfix();
    abstract String toPrefix();
    abstract String toPostfix();
}

// 숫자 노드
class NumberNode extends ExprNode {
    private double value;
    
    public NumberNode(double value) {
        this.value = value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }
    
    @Override
    public String toInfix() {
        return String.valueOf(value);
    }
    
    @Override
    public String toPrefix() {
        return String.valueOf(value);
    }
    
    @Override
    public String toPostfix() {
        return String.valueOf(value);
    }
}

// 이항 연산자 노드
class BinaryOpNode extends ExprNode {
    private char operator;
    private ExprNode left;
    private ExprNode right;
    
    public BinaryOpNode(char op, ExprNode left, ExprNode right) {
        this.operator = op;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double evaluate() {
        double leftVal = left.evaluate();
        double rightVal = right.evaluate();
        
        switch (operator) {
            case '+': return leftVal + rightVal;
            case '-': return leftVal - rightVal;
            case '*': return leftVal * rightVal;
            case '/': 
                if (rightVal == 0) {
                    throw new ArithmeticException("0으로 나눔");
                }
                return leftVal / rightVal;
            default:
                throw new IllegalStateException("Unknown operator: " + operator);
        }
    }
    
    @Override
    public String toInfix() {
        return "(" + left.toInfix() + " " + operator + " " + right.toInfix() + ")";
    }
    
    @Override
    public String toPrefix() {
        return operator + " " + left.toPrefix() + " " + right.toPrefix();
    }
    
    @Override
    public String toPostfix() {
        return left.toPostfix() + " " + right.toPostfix() + " " + operator;
    }
}

// 단항 마이너스 노드
class UnaryMinusNode extends ExprNode {
    private ExprNode operand;
    
    public UnaryMinusNode(ExprNode operand) {
        this.operand = operand;
    }
    
    @Override
    public double evaluate() {
        return -operand.evaluate();
    }
    
    @Override
    public String toInfix() {
        return "-" + operand.toInfix();
    }
    
    @Override
    public String toPrefix() {
        return "- " + operand.toPrefix();
    }
    
    @Override
    public String toPostfix() {
        return operand.toPostfix() + " -";
    }
}
```

### 예제 4-2: 트리 생성 파서

```java
public class ExpressionTreeParser extends BasicParser {
    
    // <expression> ::= <term> [ ("+" | "-") <term> ]...
    public ExprNode parseExpression() throws ParseError {
        // TODO 1: parseTerm()으로 첫 번째 항을 트리로 파싱
        
        // TODO 2: '+' 또는 '-' 연산자가 있는 동안 반복:
        //   - 연산자 저장
        //   - parseTerm()으로 다음 항 파싱
        //   - BinaryOpNode로 새 트리 노드 생성
        //   - left를 새 노드로 업데이트
        
        return null; // 임시 반환값
    }
    
    // <term> ::= <factor> [ ("*" | "/") <factor> ]...
    public ExprNode parseTerm() throws ParseError {
        // TODO 1: parseFactor()로 첫 번째 인수를 트리로 파싱
        
        // TODO 2: '*' 또는 '/' 연산자가 있는 동안 반복:
        //   - 연산자 저장
        //   - parseFactor()로 다음 인수 파싱
        //   - BinaryOpNode로 새 트리 노드 생성
        //   - left를 새 노드로 업데이트
        
        return null; // 임시 반환값
    }
    
    // <factor> ::= <number> | "(" <expression> ")" | "-" <factor>
    public ExprNode parseFactor() throws ParseError {
        skipWhitespace();
        
        // TODO 1: 음수 처리 - '-'로 시작하면 UnaryMinusNode 생성
        
        // TODO 2: 괄호 처리 - '('로 시작하면:
        //   - '(' 소비
        //   - parseExpression() 호출
        //   - ')' 기대
        
        // TODO 3: 숫자 처리 - 숫자나 '.' 로 시작하면 NumberNode 생성
        
        // TODO 4: 그 외의 경우 ParseError 던지기
        
        // 단항 마이너스
        if (peek() == '-') {
            next();
            ExprNode operand = parseFactor();
            return new UnaryMinusNode(operand);
        }
        
        // 괄호
        if (peek() == '(') {
            next();
            ExprNode expr = parseExpression();
            expect(')');
            return expr;
        }
        
        // 숫자
        if (Character.isDigit(peek()) || peek() == '.') {
            return new NumberNode(parseNumber());
        }
        
        throw new ParseError("예상치 못한 문자: " + peek());
    }
    
    private double parseNumber() throws ParseError {
        StringBuilder sb = new StringBuilder();
        
        while (Character.isDigit(peek())) {
            sb.append(next());
        }
        
        if (peek() == '.') {
            sb.append(next());
            while (Character.isDigit(peek())) {
                sb.append(next());
            }
        }
        
        return Double.parseDouble(sb.toString());
    }
    
    // 트리 시각화
    public static void printTree(ExprNode node, String prefix, boolean isLast) {
        if (node == null) return;
        
        System.out.println(prefix + (isLast ? "└── " : "├── ") + 
                          nodeToString(node));
        
        if (node instanceof BinaryOpNode) {
            BinaryOpNode binNode = (BinaryOpNode) node;
            String childPrefix = prefix + (isLast ? "    " : "│   ");
            
            printTree(getLeft(binNode), childPrefix, false);
            printTree(getRight(binNode), childPrefix, true);
        } else if (node instanceof UnaryMinusNode) {
            UnaryMinusNode unaryNode = (UnaryMinusNode) node;
            String childPrefix = prefix + (isLast ? "    " : "│   ");
            
            printTree(getOperand(unaryNode), childPrefix, true);
        }
    }
    
    // 리플렉션을 사용한 private 필드 접근 (데모용)
    private static ExprNode getLeft(BinaryOpNode node) {
        try {
            var field = BinaryOpNode.class.getDeclaredField("left");
            field.setAccessible(true);
            return (ExprNode) field.get(node);
        } catch (Exception e) {
            return null;
        }
    }
    
    private static ExprNode getRight(BinaryOpNode node) {
        try {
            var field = BinaryOpNode.class.getDeclaredField("right");
            field.setAccessible(true);
            return (ExprNode) field.get(node);
        } catch (Exception e) {
            return null;
        }
    }
    
    private static ExprNode getOperand(UnaryMinusNode node) {
        try {
            var field = UnaryMinusNode.class.getDeclaredField("operand");
            field.setAccessible(true);
            return (ExprNode) field.get(node);
        } catch (Exception e) {
            return null;
        }
    }
    
    private static String nodeToString(ExprNode node) {
        if (node instanceof NumberNode) {
            return "Num: " + node.toInfix();
        } else if (node instanceof BinaryOpNode) {
            try {
                var field = BinaryOpNode.class.getDeclaredField("operator");
                field.setAccessible(true);
                char op = (char) field.get(node);
                return "Op: " + op;
            } catch (Exception e) {
                return "Op: ?";
            }
        } else if (node instanceof UnaryMinusNode) {
            return "Unary: -";
        }
        return "?";
    }
    
    // 테스트
    public static void main(String[] args) {
        ExpressionTreeParser parser = new ExpressionTreeParser();
        
        String[] expressions = {
            "2 + 3 * 4",
            "(2 + 3) * 4",
            "-5 + 3",
            "1 + 2 * 3 - 4 / 2"
        };
        
        for (String expr : expressions) {
            try {
                parser.input = expr;
                parser.position = 0;
                
                ExprNode tree = parser.parseExpression();
                
                System.out.println("\n수식: " + expr);
                System.out.println("계산 결과: " + tree.evaluate());
                System.out.println("중위 표기: " + tree.toInfix());
                System.out.println("전위 표기: " + tree.toPrefix());
                System.out.println("후위 표기: " + tree.toPostfix());
                System.out.println("트리 구조:");
                printTree(tree, "", true);
                
            } catch (ParseError e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
    }
}
```

## 5. 변수를 포함한 수식 파서

### 예제 5-1: 변수 지원 수식 파서

```java
import java.util.*;

public class VariableExpressionParser extends BasicParser {
    private Map<String, Double> variables = new HashMap<>();
    
    // 변수 노드
    static class VariableNode extends ExprNode {
        private String name;
        private Map<String, Double> variables;
        
        public VariableNode(String name, Map<String, Double> variables) {
            this.name = name;
            this.variables = variables;
        }
        
        @Override
        public double evaluate() {
            if (!variables.containsKey(name)) {
                throw new RuntimeException("정의되지 않은 변수: " + name);
            }
            return variables.get(name);
        }
        
        @Override
        public String toInfix() {
            return name;
        }
        
        @Override
        public String toPrefix() {
            return name;
        }
        
        @Override
        public String toPostfix() {
            return name;
        }
    }
    
    // <factor> ::= <number> | <variable> | "(" <expression> ")" | "-" <factor>
    @Override
    public ExprNode parseFactor() throws ParseError {
        skipWhitespace();
        
        if (peek() == '-') {
            next();
            return new UnaryMinusNode(parseFactor());
        }
        
        if (peek() == '(') {
            next();
            ExprNode expr = parseExpression();
            expect(')');
            return expr;
        }
        
        if (Character.isDigit(peek()) || peek() == '.') {
            return new NumberNode(parseNumber());
        }
        
        if (Character.isLetter(peek())) {
            String varName = parseIdentifier();
            return new VariableNode(varName, variables);
        }
        
        throw new ParseError("예상치 못한 문자: " + peek());
    }
    
    // <identifier> ::= <letter> [ <letter> | <digit> ]...
    private String parseIdentifier() {
        StringBuilder sb = new StringBuilder();
        
        while (Character.isLetterOrDigit(peek())) {
            sb.append(next());
        }
        
        return sb.toString();
    }
    
    // 변수 설정
    public void setVariable(String name, double value) {
        variables.put(name, value);
    }
    
    // 테스트
    public static void main(String[] args) {
        VariableExpressionParser parser = new VariableExpressionParser();
        
        // 변수 설정
        parser.setVariable("x", 10);
        parser.setVariable("y", 5);
        parser.setVariable("pi", 3.14159);
        
        String[] expressions = {
            "x + y",
            "x * 2 + y",
            "pi * x * x",
            "(x + y) / 2",
            "x * x + y * y"
        };
        
        for (String expr : expressions) {
            try {
                parser.input = expr;
                parser.position = 0;
                
                ExprNode tree = parser.parseExpression();
                
                System.out.printf("%s = %.2f%n", expr, tree.evaluate());
                
            } catch (Exception e) {
                System.err.println(expr + " : " + e.getMessage());
            }
        }
    }
}
```

## 6. 간단한 프로그래밍 언어 파서

### 예제 6-1: 미니 언어 파서

```java
public class MiniLanguageParser extends BasicParser {
    
    // Statement 추상 클래스
    abstract static class Statement {
        abstract void execute(Environment env);
    }
    
    // 환경 (변수 저장)
    static class Environment {
        private Map<String, Double> variables = new HashMap<>();
        
        public void setVariable(String name, double value) {
            variables.put(name, value);
        }
        
        public double getVariable(String name) {
            if (!variables.containsKey(name)) {
                throw new RuntimeException("정의되지 않은 변수: " + name);
            }
            return variables.get(name);
        }
    }
    
    // 할당문
    static class AssignmentStatement extends Statement {
        private String variable;
        private ExprNode expression;
        
        public AssignmentStatement(String var, ExprNode expr) {
            this.variable = var;
            this.expression = expr;
        }
        
        @Override
        public void execute(Environment env) {
            double value = expression.evaluate();
            env.setVariable(variable, value);
        }
    }
    
    // 출력문
    static class PrintStatement extends Statement {
        private ExprNode expression;
        
        public PrintStatement(ExprNode expr) {
            this.expression = expr;
        }
        
        @Override
        public void execute(Environment env) {
            double value = expression.evaluate();
            System.out.println(value);
        }
    }
    
    // If문
    static class IfStatement extends Statement {
        private ExprNode condition;
        private Statement thenStmt;
        private Statement elseStmt;
        
        public IfStatement(ExprNode cond, Statement then, Statement els) {
            this.condition = cond;
            this.thenStmt = then;
            this.elseStmt = els;
        }
        
        @Override
        public void execute(Environment env) {
            if (condition.evaluate() != 0) {
                thenStmt.execute(env);
            } else if (elseStmt != null) {
                elseStmt.execute(env);
            }
        }
    }
    
    // 블록문
    static class BlockStatement extends Statement {
        private List<Statement> statements;
        
        public BlockStatement(List<Statement> stmts) {
            this.statements = stmts;
        }
        
        @Override
        public void execute(Environment env) {
            for (Statement stmt : statements) {
                stmt.execute(env);
            }
        }
    }
    
    // <program> ::= [ <statement> ]...
    public List<Statement> parseProgram() throws ParseError {
        List<Statement> statements = new ArrayList<>();
        
        while (!isAtEnd()) {
            statements.add(parseStatement());
            skipWhitespace();
        }
        
        return statements;
    }
    
    // <statement> ::= <assignment> | <print> | <if-statement> | <block>
    public Statement parseStatement() throws ParseError {
        skipWhitespace();
        
        if (match("print")) {
            return parsePrintStatement();
        } else if (match("if")) {
            return parseIfStatement();
        } else if (peek() == '{') {
            return parseBlockStatement();
        } else {
            return parseAssignment();
        }
    }
    
    // <assignment> ::= <identifier> "=" <expression> ";"
    private Statement parseAssignment() throws ParseError {
        String var = parseIdentifier();
        expect('=');
        ExprNode expr = parseExpression();
        expect(';');
        return new AssignmentStatement(var, expr);
    }
    
    // <print> ::= "print" <expression> ";"
    private Statement parsePrintStatement() throws ParseError {
        ExprNode expr = parseExpression();
        expect(';');
        return new PrintStatement(expr);
    }
    
    // <if-statement> ::= "if" "(" <expression> ")" <statement> [ "else" <statement> ]
    private Statement parseIfStatement() throws ParseError {
        expect('(');
        ExprNode condition = parseExpression();
        expect(')');
        Statement thenStmt = parseStatement();
        Statement elseStmt = null;
        
        if (match("else")) {
            elseStmt = parseStatement();
        }
        
        return new IfStatement(condition, thenStmt, elseStmt);
    }
    
    // <block> ::= "{" [ <statement> ]... "}"
    private Statement parseBlockStatement() throws ParseError {
        expect('{');
        List<Statement> statements = new ArrayList<>();
        
        while (peek() != '}' && !isAtEnd()) {
            statements.add(parseStatement());
            skipWhitespace();
        }
        
        expect('}');
        return new BlockStatement(statements);
    }
    
    // 테스트
    public static void main(String[] args) {
        MiniLanguageParser parser = new MiniLanguageParser();
        
        String program = """
            x = 10;
            y = 20;
            sum = x + y;
            print sum;
            
            if (x < y) {
                print 1;
            } else {
                print 0;
            }
            """;
        
        try {
            parser.input = program;
            parser.position = 0;
            
            List<Statement> statements = parser.parseProgram();
            Environment env = new Environment();
            
            System.out.println("프로그램 실행:");
            for (Statement stmt : statements) {
                stmt.execute(env);
            }
            
        } catch (ParseError e) {
            System.err.println("파싱 오류: " + e.getMessage());
        }
    }
}
```

이러한 예제들은 재귀 하강 파싱의 다양한 응용을 보여줍니다. 간단한 수식부터 시작하여 변수와 제어 구조를 포함한 미니 프로그래밍 언어까지 파싱할 수 있습니다.