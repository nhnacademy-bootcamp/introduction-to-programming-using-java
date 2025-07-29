# 3.3 while 및 do..while 문 - 예제 모음

## 1. while 루프 기본 예제

### 예제 1-1: 카운터 루프
```java
public class CounterLoop {
    public static void main(String[] args) {
        // 1부터 10까지 출력
        System.out.println("=== 1부터 10까지 출력 ===");
        
        // TODO: 1부터 10까지 출력하기
        // 힌트:
        // 1. count 변수를 1로 초기화
        // 2. count가 10 이하인 동안 반복
        // 3. count를 출력하고 1씩 증가
        
        // 여기에 코드를 작성하세요
        
        // 10부터 1까지 역순 출력
        System.out.println("\n=== 10부터 1까지 출력 ===");
        
        // TODO: 10부터 1까지 역순으로 출력
        // 힌트:
        // 1. count를 10으로 초기화
        // 2. count가 1 이상인 동안 반복
        // 3. count를 출력하고 1씩 감소
        
        // 여기에 코드를 작성하세요
        System.out.println();
    }
}
```

#### 실행 결과:
```
=== 1부터 10까지 출력 ===
1 2 3 4 5 6 7 8 9 10 

=== 10부터 1까지 출력 ===
10 9 8 7 6 5 4 3 2 1 
```

### 예제 1-2: 합계 계산
```java
public class SumCalculator {
    public static void main(String[] args) {
        // TODO: 1부터 100까지의 합 계산
        // 힌트:
        // 1. n을 1로, sum을 0으로 초기화
        // 2. n이 100 이하인 동안:
        //    - sum에 n을 더하기
        //    - n을 1 증가
        int n = 1;
        int sum = 0;
        
        // 여기에 코드를 작성하세요
        
        System.out.println("1부터 100까지의 합: " + sum);
        
        // TODO: 1부터 100까지 짝수의 합 계산
        // 힌트:
        // 1. n을 2로, sum을 0으로 초기화
        // 2. n이 100 이하인 동안:
        //    - sum에 n을 더하기
        //    - n을 2 증가 (짝수만)
        n = 2;
        sum = 0;
        
        // 여기에 코드를 작성하세요
        
        System.out.println("1부터 100까지 짝수의 합: " + sum);
    }
}
```

#### 실행 결과:
```
1부터 100까지의 합: 5050
1부터 100까지 짝수의 합: 2550
```

## 2. 루프 준비(Loop Priming) 예제

### 예제 2-1: 평균 계산 프로그램
```java
import textio.TextIO;

public class AverageWithPriming {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        
        System.out.println("=== 평균 계산기 ===");
        System.out.println("양수를 입력하세요 (0 입력시 종료):");
        
        // 루프 준비 - 첫 번째 입력
        System.out.print("숫자: ");
        int number = TextIO.getlnInt();
        
        // TODO: 센티넬 값(0)이 아닐 때까지 반복
        // 힌트:
        // 1. number가 0이 아닌 동안 반복
        // 2. number가 양수이면:
        //    - sum에 더하기
        //    - count 증가
        // 3. 음수이면 오류 메시지
        // 4. 다음 입력을 받기
        
        // 여기에 코드를 작성하세요
        
        // 결과 출력
        if (count == 0) {
            System.out.println("\n입력된 데이터가 없습니다!");
        } else {
            double average = (double) sum / count;
            System.out.println("\n=== 결과 ===");
            System.out.println("입력한 숫자: " + count + "개");
            System.out.println("합계: " + sum);
            System.out.printf("평균: %.2f%n", average);
        }
    }
}
```

#### 실행 결과:
```
=== 평균 계산기 ===
양수를 입력하세요 (0 입력시 종료):
숫자: 85
숫자: 92
숫자: -5
양수만 입력해주세요!
숫자: 78
숫자: 90
숫자: 0

=== 결과 ===
입력한 숫자: 4개
합계: 345
평균: 86.25
```

### 예제 2-2: 최댓값 찾기
```java
import textio.TextIO;

public class FindMaximum {
    public static void main(String[] args) {
        System.out.println("=== 최댓값 찾기 ===");
        System.out.println("숫자를 입력하세요 (-999 입력시 종료):");
        
        // 루프 준비
        System.out.print("숫자: ");
        double number = TextIO.getlnDouble();
        
        if (number == -999) {
            System.out.println("입력된 숫자가 없습니다!");
            return;
        }
        
        // 첫 번째 숫자를 최댓값으로 설정
        double max = number;
        
        // TODO: 나머지 숫자 처리
        // 힌트:
        // 1. number가 -999가 아닌 동안 반복
        // 2. number가 max보다 크면 max 업데이트
        // 3. 다음 숫자 입력받기
        
        // 여기에 코드를 작성하세요
        
        System.out.println("\n최댓값: " + max);
    }
}
```

#### 실행 결과:
```
=== 최댓값 찾기 ===
숫자를 입력하세요 (-999 입력시 종료):
숫자: 45.5
숫자: 78.2
숫자: 23.7
숫자: 89.1
숫자: 56.4
숫자: -999

최댓값: 89.1
```

## 3. do..while 루프 예제

### 예제 3-1: 메뉴 시스템
```java
import textio.TextIO;

public class MenuSystem {
    public static void main(String[] args) {
        int choice;
        
        System.out.println("=== 간단한 계산기 ===");
        
        do {
            // 메뉴 표시
            System.out.println("\n메뉴:");
            System.out.println("1. 두 수의 합");
            System.out.println("2. 두 수의 차");
            System.out.println("3. 두 수의 곱");
            System.out.println("4. 두 수의 몫");
            System.out.println("0. 종료");
            
            System.out.print("\n선택: ");
            choice = TextIO.getlnInt();
            
            if (choice >= 1 && choice <= 4) {
                System.out.print("첫 번째 숫자: ");
                double num1 = TextIO.getlnDouble();
                System.out.print("두 번째 숫자: ");
                double num2 = TextIO.getlnDouble();
                
                double result = 0;
                String operation = "";
                
                // TODO: choice에 따른 계산 수행
                // 힌트:
                // 1. choice가 1: 덧셈 (result = num1 + num2, operation = "+")
                // 2. choice가 2: 뻔셈 (result = num1 - num2, operation = "-")
                // 3. choice가 3: 곱셈 (result = num1 * num2, operation = "×")
                // 4. choice가 4: 나눗셈 
                //    - num2가 0이 아닌 경우: result = num1 / num2, operation = "÷"
                //    - num2가 0인 경우: 오류 메시지 출력 후 continue
                
                // 여기에 코드를 작성하세요
                
                System.out.printf("%.2f %s %.2f = %.2f%n", 
                                 num1, operation, num2, result);
            } else if (choice != 0) {
                System.out.println("잘못된 선택입니다!");
            }
            
        } while (choice != 0);
        
        System.out.println("\n프로그램을 종료합니다.");
    }
}
```

#### 실행 결과:
```
=== 간단한 계산기 ===

메뉴:
1. 두 수의 합
2. 두 수의 차
3. 두 수의 곱
4. 두 수의 몫
0. 종료

선택: 1
첫 번째 숫자: 10.5
두 번째 숫자: 5.5
10.50 + 5.50 = 16.00

메뉴:
1. 두 수의 합
2. 두 수의 차
3. 두 수의 곱
4. 두 수의 몫
0. 종료

선택: 0

프로그램을 종료합니다.
```

### 예제 3-2: 입력 검증
```java
import textio.TextIO;

public class InputValidationDoWhile {
    public static void main(String[] args) {
        int age;
        char grade;
        String password;
        
        // 나이 입력 검증
        do {
            System.out.print("나이를 입력하세요 (1-120): ");
            age = TextIO.getlnInt();
            
            if (age < 1 || age > 120) {
                System.out.println("유효하지 않은 나이입니다!");
            }
        } while (age < 1 || age > 120);
        
        System.out.println("입력된 나이: " + age);
        
        // 학점 입력 검증
        do {
            System.out.print("\n학점을 입력하세요 (A-F): ");
            String input = TextIO.getln();
            
            if (input.length() == 0) {
                grade = ' ';
            } else {
                grade = input.toUpperCase().charAt(0);
            }
            
            if (grade < 'A' || grade > 'F' || grade == 'E') {
                System.out.println("유효하지 않은 학점입니다!");
            }
        } while (grade < 'A' || grade > 'F' || grade == 'E');
        
        System.out.println("입력된 학점: " + grade);
        
        // TODO: 비밀번호 강도 검증
        // 힌트:
        // 1. do-while 루프 사용
        // 2. 비밀번호 입력받기
        // 3. 길이가 8자 이상인지 확인
        // 4. 조건을 만족하지 않으면 오류 메시지 출력
        // 5. 조건을 만족할 때까지 반복
        boolean isValid;
        
        // 여기에 코드를 작성하세요
        
        System.out.println("비밀번호가 설정되었습니다.");
    }
}
```

#### 실행 결과:
```
나이를 입력하세요 (1-120): 150
유효하지 않은 나이입니다!
나이를 입력하세요 (1-120): 25
입력된 나이: 25

학점을 입력하세요 (A-F): G
유효하지 않은 학점입니다!

학점을 입력하세요 (A-F): B
입력된 학점: B

비밀번호를 입력하세요 (최소 8자): pass123
비밀번호는 최소 8자 이상이어야 합니다!

비밀번호를 입력하세요 (최소 8자): password123
비밀번호가 설정되었습니다.
```

## 4. break와 continue 예제

### 예제 4-1: break 사용
```java
import textio.TextIO;

public class BreakExample {
    public static void main(String[] args) {
        // TODO: 무한 루프에서 break 사용하여 양수 입력받기
        // 힌트:
        // 1. while(true) 무한 루프
        // 2. 숫자 입력받기
        // 3. 양수이면 break로 루프 종료
        // 4. 양수가 아니면 오류 메시지 출력
        System.out.println("=== 양수 입력 받기 ===");
        
        int positiveNumber;
        
        // 여기에 코드를 작성하세요
        
        System.out.println("입력된 양수: " + positiveNumber);
        
        // 검색에서 break 사용
        System.out.println("\n=== 특정 수 찾기 ===");
        int target = 7;
        int found = -1;
        int i = 1;
        
        while (i <= 100) {
            if (i * i == 49) {  // 7의 제곱 찾기
                found = i;
                break;  // 찾으면 즉시 종료
            }
            i++;
        }
        
        if (found != -1) {
            System.out.println(found + "의 제곱은 49입니다.");
        }
    }
}
```

#### 실행 결과:
```
=== 양수 입력 받기 ===
양수를 입력하세요: -5
양수가 아닙니다. 다시 입력해주세요!
양수를 입력하세요: 0
양수가 아닙니다. 다시 입력해주세요!
양수를 입력하세요: 42
입력된 양수: 42

=== 특정 수 찾기 ===
7의 제곱은 49입니다.
```

### 예제 4-2: continue 사용
```java
public class ContinueExample {
    public static void main(String[] args) {
        // TODO: 1부터 20까지 홀수만 출력
        // 힌트:
        // 1. n을 0으로 초기화
        // 2. n < 20 동안 반복
        // 3. n을 증가시킨 후
        // 4. n이 짝수면 continue로 건너뛰기
        // 5. 홀수면 출력
        System.out.println("=== 1부터 20까지 홀수 ===");
        
        // 여기에 코드를 작성하세요
        
        System.out.println();
        
        // TODO: 1부터 30까지 3의 배수를 제외한 합
        // 힌트:
        // 1. sum = 0, i = 1로 초기화
        // 2. i <= 30 동안 반복
        // 3. i가 3의 배수면:
        //    - i를 증가시키고
        //    - continue로 건너뛰기
        // 4. 3의 배수가 아니면 sum에 더하고 i 증가
        System.out.println("\n=== 3의 배수 제외 합계 ===");
        
        // 여기에 코드를 작성하세요
        
        System.out.println("1부터 30까지 3의 배수를 제외한 합: " + sum);
    }
}
```

#### 실행 결과:
```
=== 1부터 20까지 홀수 ===
1 3 5 7 9 11 13 15 17 19 

=== 3의 배수 제외 합계 ===
1부터 30까지 3의 배수를 제외한 합: 310
```

### 예제 4-3: 중첩 루프와 레이블
```java
public class LabeledBreakExample {
    public static void main(String[] args) {
        System.out.println("=== 곱셈표 (곱이 50을 초과하면 중단) ===");
        
        outerLoop:
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int product = i * j;
                
                if (product > 50) {
                    System.out.println("\n곱이 50을 초과했습니다!");
                    break outerLoop;  // 바깥 루프까지 종료
                }
                
                System.out.printf("%2d × %2d = %2d  ", i, j, product);
            }
            System.out.println();
        }
        
        // 문자열에서 공통 문자 찾기
        System.out.println("\n=== 공통 문자 찾기 ===");
        String str1 = "hello";
        String str2 = "world";
        char commonChar = '\0';
        boolean found = false;
        
        searchLoop:
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    commonChar = str1.charAt(i);
                    found = true;
                    break searchLoop;  // 두 루프 모두 종료
                }
            }
        }
        
        if (found) {
            System.out.println("첫 번째 공통 문자: '" + commonChar + "'");
        } else {
            System.out.println("공통 문자가 없습니다.");
        }
    }
}
```

#### 실행 결과:
```
=== 곱셈표 (곱이 50을 초과하면 중단) ===
 1 ×  1 =  1   1 ×  2 =  2   1 ×  3 =  3   1 ×  4 =  4   1 ×  5 =  5   1 ×  6 =  6   1 ×  7 =  7   1 ×  8 =  8   1 ×  9 =  9  
 2 ×  1 =  2   2 ×  2 =  4   2 ×  3 =  6   2 ×  4 =  8   2 ×  5 = 10   2 ×  6 = 12   2 ×  7 = 14   2 ×  8 = 16   2 ×  9 = 18  
 3 ×  1 =  3   3 ×  2 =  6   3 ×  3 =  9   3 ×  4 = 12   3 ×  5 = 15   3 ×  6 = 18   3 ×  7 = 21   3 ×  8 = 24   3 ×  9 = 27  
 4 ×  1 =  4   4 ×  2 =  8   4 ×  3 = 12   4 ×  4 = 16   4 ×  5 = 20   4 ×  6 = 24   4 ×  7 = 28   4 ×  8 = 32   4 ×  9 = 36  
 5 ×  1 =  5   5 ×  2 = 10   5 ×  3 = 15   5 ×  4 = 20   5 ×  5 = 25   5 ×  6 = 30   5 ×  7 = 35   5 ×  8 = 40   5 ×  9 = 45  
 6 ×  1 =  6   6 ×  2 = 12   6 ×  3 = 18   6 ×  4 = 24   6 ×  5 = 30   6 ×  6 = 36   6 ×  7 = 42   6 ×  8 = 48   6 ×  9 = 54  
곱이 50을 초과했습니다!

=== 공통 문자 찾기 ===
첫 번째 공통 문자: 'l'
```

## 5. 센티넬 값 패턴

### 예제 5-1: 다양한 센티넬 값
```java
import textio.TextIO;

public class SentinelPatterns {
    public static void main(String[] args) {
        // 숫자 센티넬 (0)
        System.out.println("=== 점수 입력 (0: 종료) ===");
        int scoreCount = 0;
        int scoreSum = 0;
        
        System.out.print("점수: ");
        int score = TextIO.getlnInt();
        
        while (score != 0) {
            if (score > 0 && score <= 100) {
                scoreSum += score;
                scoreCount++;
            } else if (score != 0) {
                System.out.println("유효하지 않은 점수입니다!");
            }
            
            System.out.print("점수: ");
            score = TextIO.getlnInt();
        }
        
        if (scoreCount > 0) {
            double average = (double) scoreSum / scoreCount;
            System.out.printf("평균 점수: %.2f%n", average);
        }
        
        // 문자열 센티넬 ("quit")
        System.out.println("\n=== 단어 입력 (quit: 종료) ===");
        int wordCount = 0;
        
        System.out.print("단어: ");
        String word = TextIO.getln();
        
        while (!word.equalsIgnoreCase("quit")) {
            wordCount++;
            System.out.println("입력한 단어: " + word);
            
            System.out.print("단어: ");
            word = TextIO.getln();
        }
        
        System.out.println("총 " + wordCount + "개의 단어를 입력했습니다.");
        
        // 특수 값 센티넬 (-1)
        System.out.println("\n=== 온도 입력 (-999: 종료) ===");
        double maxTemp = Double.NEGATIVE_INFINITY;
        double minTemp = Double.POSITIVE_INFINITY;
        boolean hasData = false;
        
        System.out.print("온도: ");
        double temp = TextIO.getlnDouble();
        
        while (temp != -999) {
            hasData = true;
            
            if (temp > maxTemp) {
                maxTemp = temp;
            }
            if (temp < minTemp) {
                minTemp = temp;
            }
            
            System.out.print("온도: ");
            temp = TextIO.getlnDouble();
        }
        
        if (hasData) {
            System.out.println("최고 온도: " + maxTemp);
            System.out.println("최저 온도: " + minTemp);
        } else {
            System.out.println("입력된 온도가 없습니다.");
        }
    }
}
```

#### 실행 결과:
```
=== 점수 입력 (0: 종료) ===
점수: 85
점수: 92
점수: 110
유효하지 않은 점수입니다!
점수: 78
점수: 0
평균 점수: 85.00

=== 단어 입력 (quit: 종료) ===
단어: hello
입력한 단어: hello
단어: world
입력한 단어: world
단어: quit
총 2개의 단어를 입력했습니다.

=== 온도 입력 (-999: 종료) ===
온도: 23.5
온도: 28.2
온도: 19.8
온도: -999
최고 온도: 28.2
최저 온도: 19.8
```

## 6. 일반적인 루프 패턴

### 예제 6-1: 플래그 제어 루프
```java
import textio.TextIO;

public class FlagControlledLoop {
    public static void main(String[] args) {
        // 소수 찾기 (플래그 사용)
        System.out.print("숫자를 입력하세요: ");
        int number = TextIO.getlnInt();
        
        boolean isPrime = true;  // 플래그
        int divisor = 2;
        
        if (number <= 1) {
            isPrime = false;
        }
        
        // TODO: 소수 판별 루프
        // 힌트:
        // 1. divisor가 number의 제곱근 이하이고 isPrime이 true인 동안
        // 2. number가 divisor로 나누어 떨어지면:
        //    - isPrime을 false로 설정
        // 3. divisor를 증가
        
        // 여기에 코드를 작성하세요
        
        if (isPrime) {
            System.out.println(number + "은(는) 소수입니다.");
        } else {
            System.out.println(number + "은(는) 소수가 아닙니다.");
        }
        
        // 검색 플래그
        System.out.println("\n=== 배열에서 값 찾기 ===");
        int[] numbers = {5, 12, 7, 23, 9, 14, 3};
        System.out.print("찾을 값: ");
        int target = TextIO.getlnInt();
        
        boolean found = false;  // 플래그
        int index = 0;
        
        // TODO: 배열에서 값 찾기
        // 힌트:
        // 1. index가 배열 길이보다 작고 found가 false인 동안
        // 2. numbers[index]가 target과 같으면:
        //    - found를 true로 설정
        // 3. 같지 않으면 index 증가
        
        // 여기에 코드를 작성하세요
        
        if (found) {
            System.out.println(target + "은(는) 인덱스 " + index + "에 있습니다.");
        } else {
            System.out.println(target + "을(를) 찾을 수 없습니다.");
        }
    }
}
```

#### 실행 결과:
```
숫자를 입력하세요: 17
17은(는) 소수입니다.

=== 배열에서 값 찾기 ===
찾을 값: 23
23은(는) 인덱스 3에 있습니다.
```

## 7. 실전 응용 예제

### 예제 7-1: 구구단 게임
```java
import textio.TextIO;

public class MultiplicationGame {
    public static void main(String[] args) {
        System.out.println("=== 구구단 게임 ===");
        System.out.println("문제를 풀어보세요! (0 입력시 종료)");
        
        int correct = 0;
        int wrong = 0;
        boolean playing = true;
        
        do {
            // 랜덤 문제 생성
            int a = (int)(Math.random() * 9) + 1;
            int b = (int)(Math.random() * 9) + 1;
            int correctAnswer = a * b;
            
            System.out.print("\n" + a + " × " + b + " = ");
            int answer = TextIO.getlnInt();
            
            if (answer == 0) {
                playing = false;
            } else if (answer == correctAnswer) {
                System.out.println("정답! ✓");
                correct++;
            } else {
                System.out.println("틀렸습니다. 정답은 " + correctAnswer + "입니다.");
                wrong++;
            }
            
            // 계속할지 묻기
            if (playing && (correct + wrong) % 5 == 0) {
                System.out.print("\n계속하시겠습니까? (y/n): ");
                char response = TextIO.getlnChar();
                if (response != 'y' && response != 'Y') {
                    playing = false;
                }
            }
            
        } while (playing);
        
        // 결과 출력
        System.out.println("\n=== 게임 결과 ===");
        System.out.println("정답: " + correct + "개");
        System.out.println("오답: " + wrong + "개");
        
        if (correct + wrong > 0) {
            double percentage = (double) correct / (correct + wrong) * 100;
            System.out.printf("정답률: %.1f%%%n", percentage);
        }
    }
}
```

#### 실행 결과:
```
=== 구구단 게임 ===
문제를 풀어보세요! (0 입력시 종료)

7 × 8 = 56
정답! ✓

3 × 9 = 27
정답! ✓

6 × 7 = 45
틀렸습니다. 정답은 42입니다.

5 × 5 = 25
정답! ✓

2 × 9 = 18
정답! ✓

계속하시겠습니까? (y/n): y

4 × 6 = 0

=== 게임 결과 ===
정답: 4개
오답: 1개
정답률: 80.0%
```

### 예제 7-2: 숫자 맞추기 게임
```java
import textio.TextIO;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("=== 숫자 맞추기 게임 ===");
        
        boolean playAgain;
        
        do {
            // 1-100 사이의 랜덤 숫자 생성
            int secretNumber = (int)(Math.random() * 100) + 1;
            int attempts = 0;
            boolean guessed = false;
            
            System.out.println("\n1부터 100 사이의 숫자를 맞춰보세요!");
            
            while (!guessed) {
                System.out.print("추측: ");
                int guess = TextIO.getlnInt();
                attempts++;
                
                if (guess < 1 || guess > 100) {
                    System.out.println("1부터 100 사이의 숫자를 입력하세요!");
                    continue;
                }
                
                // TODO: 숫자 맞추기 로직
                // 힌트:
                // 1. guess가 secretNumber보다 작으면: "더 큰 숫자입니다."
                // 2. guess가 secretNumber보다 크면: "더 작은 숫자입니다."
                // 3. 같으면:
                //    - guessed를 true로 설정
                //    - 성공 메시지 출력
                //    - attempts에 따른 평가 메시지 출력
                
                // 여기에 코드를 작성하세요
            }
            
            // 다시 플레이할지 묻기
            System.out.print("\n다시 플레이하시겠습니까? (y/n): ");
            char answer = TextIO.getlnChar();
            playAgain = (answer == 'y' || answer == 'Y');
            
        } while (playAgain);
        
        System.out.println("\n게임을 종료합니다. 감사합니다!");
    }
}
```

#### 실행 결과:
```
=== 숫자 맞추기 게임 ===

1부터 100 사이의 숫자를 맞춰보세요!
추측: 50
더 큰 숫자입니다.
추측: 75
더 작은 숫자입니다.
추측: 62
더 큰 숫자입니다.
추측: 68
더 작은 숫자입니다.
추측: 65
더 큰 숫자입니다.
추측: 67

정답! 6번 만에 맞췄습니다!
잘했어요! 👍

다시 플레이하시겠습니까? (y/n): n

게임을 종료합니다. 감사합니다!
```