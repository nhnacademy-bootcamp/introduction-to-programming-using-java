## 스택 기반 명령어 - 조건문과 반복문 예제

### 1. **조건문 (if-else) 예제**

**Java 코드:**
```java
public class ConditionalExample {
    public int compareNumbers(int a, int b) {
        if (a > b) {
            return 1;
        } else {
            return -1;
        }
    }
}
```

**바이트코드와 스택 변화:**
```
// compareNumbers(int a, int b)의 바이트코드
0:  iload_1        // a를 스택에 push
1:  iload_2        // b를 스택에 push
2:  if_icmple 7    // 스택에서 두 값을 pop하여 비교, a <= b면 7번으로 점프
5:  iconst_1       // 1을 스택에 push
6:  ireturn        // 스택 top 값을 반환
7:  iconst_m1      // -1을 스택에 push
8:  ireturn        // 스택 top 값을 반환
```

**스택 변화 시각화 (a=5, b=3인 경우):**
```
명령어        스택 상태         설명
------        ---------        ----
시작          []               빈 스택
iload_1       [5]              a(5)를 push
iload_2       [5, 3]           b(3)를 push
if_icmple     []               5 > 3이므로 점프하지 않음
iconst_1      [1]              1을 push
ireturn       []               1을 반환하고 스택 비움
```

### 2. **for 반복문 예제**

**Java 코드:**
```java
public class ForLoopExample {
    public int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
```

**바이트코드와 스택 변화:**
```
// sumToN(int n)의 바이트코드
0:  iconst_0       // 0을 스택에 push
1:  istore_2       // sum = 0 (스택에서 pop하여 저장)
2:  iconst_1       // 1을 스택에 push
3:  istore_3       // i = 1 (스택에서 pop하여 저장)
4:  iload_3        // i를 스택에 push
5:  iload_1        // n을 스택에 push
6:  if_icmpgt 19   // i > n이면 19번으로 점프 (반복 종료)
9:  iload_2        // sum을 스택에 push
10: iload_3        // i를 스택에 push
11: iadd           // sum + i
12: istore_2       // 결과를 sum에 저장
13: iinc 3, 1      // i++ (스택 사용 없이 직접 증가)
16: goto 4         // 4번으로 점프 (반복)
19: iload_2        // sum을 스택에 push
20: ireturn        // sum 반환
```

**스택 변화 시각화 (n=3일 때 첫 번째 반복):**
```
명령어        스택 상태         지역변수               설명
------        ---------        --------              ----
초기          []               n=3
iconst_0      [0]              n=3
istore_2      []               n=3, sum=0
iconst_1      [1]              n=3, sum=0
istore_3      []               n=3, sum=0, i=1
iload_3       [1]              n=3, sum=0, i=1       i를 로드
iload_1       [1, 3]           n=3, sum=0, i=1       n을 로드
if_icmpgt     []               n=3, sum=0, i=1       1 <= 3, 계속 진행
iload_2       [0]              n=3, sum=0, i=1       sum을 로드
iload_3       [0, 1]           n=3, sum=0, i=1       i를 로드
iadd          [1]              n=3, sum=0, i=1       0 + 1 = 1
istore_2      []               n=3, sum=1, i=1       sum = 1
iinc 3, 1     []               n=3, sum=1, i=2       i++
goto 4        []               n=3, sum=1, i=2       반복 시작으로
```

### 3. **while 반복문 예제**

**Java 코드:**
```java
public class WhileLoopExample {
    public int factorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }
}
```

**바이트코드와 스택 변화:**
```
// factorial(int n)의 바이트코드
0:  iconst_1       // 1을 스택에 push
1:  istore_2       // result = 1
2:  iload_1        // n을 스택에 push
3:  ifle 14        // n <= 0이면 14번으로 점프
6:  iload_2        // result를 스택에 push
7:  iload_1        // n을 스택에 push
8:  imul           // result * n
9:  istore_2       // 결과를 result에 저장
10: iinc 1, -1     // n-- (스택 사용 없이 직접 감소)
13: goto 2         // 2번으로 점프 (조건 검사)
14: iload_2        // result를 스택에 push
15: ireturn        // result 반환
```

### 4. **중첩 조건문 예제**

**Java 코드:**
```java
public class NestedConditionExample {
    public String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else {
            return "C";
        }
    }
}
```

**바이트코드 (주요 부분):**
```
0:  iload_1          // score를 스택에 push
1:  bipush 90        // 90을 스택에 push
3:  if_icmplt 9      // score < 90이면 9번으로
6:  ldc #2           // "A" 문자열을 스택에 push
8:  areturn          // 문자열 반환
9:  iload_1          // score를 스택에 push
10: bipush 80        // 80을 스택에 push
12: if_icmplt 18     // score < 80이면 18번으로
15: ldc #3           // "B" 문자열을 스택에 push
17: areturn          // 문자열 반환
18: ldc #4           // "C" 문자열을 스택에 push
20: areturn          // 문자열 반환
```

### 5. **스택 기반 명령어의 특징**

**1. 비교 연산 패턴:**
```
// 항상 같은 패턴
값1 로드 → 값2 로드 → 비교 → 조건부 점프

iload_1
iload_2
if_icmpgt label  // greater than
if_icmplt label  // less than
if_icmpeq label  // equal
```

**2. 반복문 패턴:**
```
초기화
loop_start:
    조건 검사 (조건 불만족시 loop_end로 점프)
    반복 본문
    증감
    goto loop_start
loop_end:
```

**3. 스택 효율성:**
- 복잡한 표현식도 순차적으로 처리
- 임시 변수 없이 중간 결과 저장
- 메모리 접근 최소화

**예: `(a + b) * (c - d)` 계산**
```
iload_0     // a
iload_1     // b
iadd        // a + b
iload_2     // c
iload_3     // d
isub        // c - d
imul        // (a + b) * (c - d)
```
