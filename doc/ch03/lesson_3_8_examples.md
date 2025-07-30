# 3.8 배열 소개 - 예제 모음

## 1. 배열 기본 예제

### 예제 1-1: 배열 선언과 생성

#### 요구사항
- int[] numbers1 선언 후 new int[5]로 생성
- int[] numbers2를 크기 10으로 선언과 동시에 생성
- int[] numbers3를 {10, 20, 30, 40, 50}으로 초기화
- String 배열 names를 크기 3으로 생성
- double 배열 prices를 크기 7로 생성
- boolean 배열 flags를 크기 4로 생성

#### 예제 코드
```java
public class ArrayBasicsExample {
    public static void main(String[] args) {
        System.out.println("=== 배열 기본 예제 ===");

        // TODO: 배열 선언과 생성
        // 힌트: 배열 생성 문법

        // 여기에 코드를 작성하세요

        // 2. 기본값 확인
        System.out.println("=== 자동 초기화된 값 ===");
        System.out.println("int 배열: " + numbers1[0]);      // 0
        System.out.println("String 배열: " + names[0]);      // null
        System.out.println("double 배열: " + prices[0]);     // 0.0
        System.out.println("boolean 배열: " + flags[0]);     // false

        // 3. 배열 길이 확인
        System.out.println("\n=== 배열 길이 ===");
        System.out.println("numbers1 길이: " + numbers1.length);
        System.out.println("numbers2 길이: " + numbers2.length);
        System.out.println("numbers3 길이: " + numbers3.length);

        // TODO: 배열 값 설정과 읽기
        // 힌트: 인덱스 사용
        System.out.println("\n=== 배열 요소 접근 ===");

        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 배열 기본 예제 ===
=== 자동 초기화된 값 ===
int 배열: 0
String 배열: null
double 배열: 0.0
boolean 배열: false

=== 배열 길이 ===
numbers1 길이: 5
numbers2 길이: 10
numbers3 길이: 5

=== 배열 요소 접근 ===
첫 번째 요소: 100
마지막 요소: 500
```

### 예제 1-2: 배열 초기화 방법들

#### 요구사항
- int[] multiples = new int[10] 생성
- for 루프로 i를 0부터 multiples.length미만까지 반복
- multiples[i]에 (i + 1) * 5 할당 (5의 배수)

#### 예제 코드
```java
public class ArrayInitializationExample {
    public static void main(String[] args) {
        System.out.println("=== 배열 초기화 방법들 ===");

        // 방법 1: 초기값 리스트 사용
        int[] ages = {18, 21, 25, 30, 35};
        String[] cities = {"서울", "부산", "대구", "인천", "광주"};

        // 방법 2: new 연산자와 초기값 리스트
        int[] scores = new int[]{85, 92, 78, 96, 88};

        // TODO: 방법 3 - 반복문으로 초기화
        // 힌트: for 루프

        // 여기에 코드를 작성하세요

        // 방법 4: Arrays.fill() 메서드 사용
        int[] sameValues = new int[8];
        java.util.Arrays.fill(sameValues, 99);  // 모든 요소를 99로 초기화

        // 결과 출력
        System.out.println("ages: " + java.util.Arrays.toString(ages));
        System.out.println("cities: " + java.util.Arrays.toString(cities));
        System.out.println("scores: " + java.util.Arrays.toString(scores));
        System.out.println("multiples: " + java.util.Arrays.toString(multiples));
        System.out.println("sameValues: " + java.util.Arrays.toString(sameValues));
    }
}
```

#### 실행 결과:
```
=== 배열 초기화 방법들 ===
ages: [18, 21, 25, 30, 35]
cities: [서울, 부산, 대구, 인천, 광주]
scores: [85, 92, 78, 96, 88]
multiples: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
sameValues: [99, 99, 99, 99, 99, 99, 99, 99]
```

## 2. 배열 처리 예제

### 예제 2-1: 기본 배열 처리 - 합계, 평균, 최대값, 최소값

#### 요구사항
- sum을 0으로 초기화
- for 루프로 temperatures 배열의 모든 값을 sum에 누적
- 합계 출력 (printf 사용, 형식: "\n주간 온도 합계: %.1f°C%n")
- average = sum / temperatures.length로 평균 계산
- 평균 출력 (printf 사용, 형식: "주간 평균 온도: %.1f°C%n")

#### 예제 코드
```java
public class ArrayProcessingExample {
    public static void main(String[] args) {
        double[] temperatures = {23.5, 25.0, 22.8, 26.3, 24.1, 25.5, 23.9};
        String[] days = {"월", "화", "수", "목", "금", "토", "일"};

        System.out.println("=== 주간 온도 데이터 ===");

        // 1. 데이터 출력
        for (int i = 0; i < temperatures.length; i++) {
            System.out.printf("%s요일: %.1f°C%n", days[i], temperatures[i]);
        }

        // TODO: 합계와 평균 계산
        // 힌트: for 루프와 누적

        // 여기에 코드를 작성하세요

        // TODO: 최고 온도와 최저 온도 찾기
        // 힌트: 비교와 갱신

        // 여기에 코드를 작성하세요

        // TODO: 평균보다 높은 날 찾기
        // 힌트: 조건문과 카운터
        System.out.println("\n평균보다 높은 온도의 날:");

        // 여기에 코드를 작성하세요
    }
}
```

#### 실행 결과:
```
=== 주간 온도 데이터 ===
월요일: 23.5°C
화요일: 25.0°C
수요일: 22.8°C
목요일: 26.3°C
금요일: 24.1°C
토요일: 25.5°C
일요일: 23.9°C

주간 온도 합계: 171.1°C
주간 평균 온도: 24.4°C

최고 온도: 26.3°C (목요일)
최저 온도: 22.8°C (수요일)

평균보다 높은 온도의 날:
  화요일: 25.0°C (평균보다 +0.6°C)
  목요일: 26.3°C (평균보다 +1.9°C)
  토요일: 25.5°C (평균보다 +1.1°C)
총 3일
```

### 예제 2-2: 학생 성적 처리 시스템

#### 요구사항
- 학생 이름, 국어/수학/영어 점수 입력받기 ('quit'으로 종료)
- 각 학생의 총점과 평균 계산하여 성적표 출력
- 과목별 총점을 누적하여 과목별 평균 계산
- 최고 총점을 받은 학생 찾아 최우수 학생으로 표시
- 최대 30명까지 입력 가능

#### 예제 코드
```java
import textio.TextIO;

public class StudentGradeSystemExample {
    public static void main(String[] args) {
        final int MAX_STUDENTS = 30;
        String[] studentNames = new String[MAX_STUDENTS];
        int[] koreanScores = new int[MAX_STUDENTS];
        int[] mathScores = new int[MAX_STUDENTS];
        int[] englishScores = new int[MAX_STUDENTS];
        int studentCount = 0;

        System.out.println("=== 학생 성적 관리 시스템 ===");

        // 학생 정보 입력
        while (true) {
            System.out.print("\n학생 이름 (종료: 'quit'): ");
            String name = TextIO.getln();

            if (name.equalsIgnoreCase("quit")) {
                break;
            }

            if (studentCount >= MAX_STUDENTS) {
                System.out.println("더 이상 학생을 추가할 수 없습니다!");
                break;
            }

            studentNames[studentCount] = name;

            System.out.print("국어 점수: ");
            koreanScores[studentCount] = TextIO.getlnInt();

            System.out.print("수학 점수: ");
            mathScores[studentCount] = TextIO.getlnInt();

            System.out.print("영어 점수: ");
            englishScores[studentCount] = TextIO.getlnInt();

            studentCount++;
            System.out.println("✅ " + name + " 학생 정보가 추가되었습니다.");
        }

        // 성적 처리 및 출력
        if (studentCount > 0) {
            System.out.println("\n" + "=".repeat(70));
            System.out.println("📊 성적표");
            System.out.println("=".repeat(70));
            System.out.printf("%-10s %6s %6s %6s %6s %6s%n",
                "이름", "국어", "수학", "영어", "총점", "평균");
            System.out.println("-".repeat(70));

            int totalKorean = 0, totalMath = 0, totalEnglish = 0;

            // TODO: 학생별 성적 출력
            // 힌트: 총점 계산 및 출력

            // 여기에 코드를 작성하세요

            System.out.println("-".repeat(70));

            // 과목별 평균
            double avgKorean = (double) totalKorean / studentCount;
            double avgMath = (double) totalMath / studentCount;
            double avgEnglish = (double) totalEnglish / studentCount;

            System.out.printf("과목 평균  %6.1f %6.1f %6.1f%n",
                avgKorean, avgMath, avgEnglish);

            // TODO: 최고 점수 학생 찾기
            // 힌트: 최댓값 알고리즘

            // 여기에 코드를 작성하세요

            System.out.println("\n🏆 최우수 학생: " + studentNames[maxTotalIndex] +
                " (총점: " + maxTotal + "점)");
        } else {
            System.out.println("\n입력된 학생 정보가 없습니다.");
        }
    }
}
```

#### 실행 결과:
```
=== 학생 성적 관리 시스템 ===

학생 이름 (종료: 'quit'): 김철수
국어 점수: 90
수학 점수: 85
영어 점수: 88
✅ 김철수 학생 정보가 추가되었습니다.

학생 이름 (종료: 'quit'): 이영희
국어 점수: 95
수학 점수: 92
영어 점수: 90
✅ 이영희 학생 정보가 추가되었습니다.

학생 이름 (종료: 'quit'): 박민준
국어 점수: 82
수학 점수: 88
영어 점수: 85
✅ 박민준 학생 정보가 추가되었습니다.

학생 이름 (종료: 'quit'): quit

======================================================================
📊 성적표
======================================================================
이름           국어   수학   영어   총점   평균
----------------------------------------------------------------------
김철수          90     85     88    263   87.7
이영희          95     92     90    277   92.3
박민준          82     88     85    255   85.0
----------------------------------------------------------------------
과목 평균    89.0   88.3   87.7

🏆 최우수 학생: 이영희 (총점: 277점)
```

## 3. 배열의 임의 접근 예제

### 예제 3-1: 로또 번호 생성기

#### 요구사항
- 1~45 범위의 중복되지 않는 6개 숫자 선택
- 선택된 숫자를 오름차순으로 정렬
- 5세트의 로또 번호 생성
- generateLottoNumbers() 메소드에서 랜덤 번호 생성 및 정렬 구현

#### 예제 코드
```java
public class LottoNumberGeneratorExample {
    public static void main(String[] args) {
        System.out.println("=== 로또 번호 생성기 ===");

        // 5세트의 로또 번호 생성
        for (int set = 1; set <= 5; set++) {
            int[] lottoNumbers = generateLottoNumbers();

            System.out.print("세트 " + set + ": ");
            for (int i = 0; i < lottoNumbers.length; i++) {
                System.out.printf("%2d ", lottoNumbers[i]);
            }
            System.out.println();
        }
    }

    public static int[] generateLottoNumbers() {
        boolean[] used = new boolean[46];  // 1~45 번호 사용 여부 (인덱스 0은 미사용)
        int[] numbers = new int[6];       // 선택된 6개 번호

        // TODO: 6개의 서로 다른 번호 선택
        // 힌트: do-while 루프와 중복 검사

        // 여기에 코드를 작성하세요

        // TODO: 번호 정렬 (버블 정렬)
        // 힌트: 이중 루프와 교환

        // 여기에 코드를 작성하세요

        return numbers;
    }
}
```

#### 실행 결과:
```
=== 로또 번호 생성기 ===
세트 1:  3  8 15 22 31 42
세트 2:  5 11 19 28 35 43
세트 3:  2 14 21 27 38 44
세트 4:  7 16 23 29 36 41
세트 5:  1  9 18 26 33 40
```

### 예제 3-2: 카드 덱 셔플링

#### 요구사항
- 52장의 트럼프 카드 덱 생성 (♠, ♥, ♦, ♣ 각 13장)
- Fisher-Yates 셔플 알고리즘으로 카드 섮기
- 원본 덱과 셔플된 덱 출력
- 셔플된 덱에서 상위 5장 뽑기
- shuffleDeck() 메소드에 셔플 알고리즘 구현

#### 예제 코드
```java
public class CardDeckShuffleExample {
    public static void main(String[] args) {
        System.out.println("=== 카드 덱 셔플링 ===");

        // 카드 덱 생성 (52장)
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];

        // 덱 초기화
        int cardIndex = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[cardIndex] = suit + rank;
                cardIndex++;
            }
        }

        // 원본 덱 출력
        System.out.println("원본 덱:");
        printDeck(deck);

        // 셔플링
        shuffleDeck(deck);

        // 셔플된 덱 출력
        System.out.println("\n셔플된 덱:");
        printDeck(deck);

        // 5장 뽑기
        System.out.println("\n뽑은 카드 5장:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + deck[i]);
        }
    }

    public static void shuffleDeck(String[] deck) {
        // TODO: Fisher-Yates 셔플 알고리즘 구현
        // 힌트: 랜덤 교환

        // 여기에 코드를 작성하세요
    }

    public static void printDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + " ");
            if ((i + 1) % 13 == 0) {
                System.out.println();  // 13장마다 줄바꿈
            }
        }
    }
}
```

#### 실행 결과:
```
=== 카드 덱 셔플링 ===
원본 덱:
♠A ♠2 ♠3 ♠4 ♠5 ♠6 ♠7 ♠8 ♠9 ♠10 ♠J ♠Q ♠K
♥A ♥2 ♥3 ♥4 ♥5 ♥6 ♥7 ♥8 ♥9 ♥10 ♥J ♥Q ♥K
♦A ♦2 ♦3 ♦4 ♦5 ♦6 ♦7 ♦8 ♦9 ♦10 ♦J ♦Q ♦K
♣A ♣2 ♣3 ♣4 ♣5 ♣6 ♣7 ♣8 ♣9 ♣10 ♣J ♣Q ♣K

셔플된 덱:
♦5 ♣J ♦Q ♠7 ♥K ♣6 ♦8 ♣A ♦10 ♥2 ♣Q ♠9 ♥5
♣K ♠J ♠3 ♦A ♣♦9 ♠K ♠6 ♣7 ♥J ♣3 ♦K ♥Q ♠4
♣♦3 ♣4 ♦J ♥8 ♦♦6 ♥A ♣♦2 ♠2 ♠A ♦♦5 ♠Q ♦4 ♣♣8
♦♦9 ♦♦7 ♣♣5 ♣♣7 ♦♦3 ♣♦10 ♦♦10 ♦♦8 ♦♦2

뽑은 카드 5장:
1. ♦5
2. ♣J
3. ♦Q
4. ♠7
5. ♥K
```

## 4. 부분적으로 채워진 배열 예제

### 예제 4-1: 동적 목록 관리

#### 요구사항
- To-Do 리스트 관리 시스템 구현
- 항목 추가: 최대 100개까지 저장 가능
- 항목 목록 보기: 현재 저장된 모든 항목 표시
- 항목 삭제: 선택한 항목 삭제 후 배열 요소 재정렬
- 항목 완료 표시: 선택한 항목 앞에 ✓ 추가
- 메뉴 선택에 따른 작업 수행

#### 예제 코드
```java
import textio.TextIO;

public class DynamicListExample {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        String[] todoList = new String[MAX_SIZE];
        int itemCount = 0;

        System.out.println("=== To-Do 리스트 관리 ===");

        while (true) {
            System.out.println("\n메뉴:");
            System.out.println("1. 항목 추가");
            System.out.println("2. 항목 목록 보기");
            System.out.println("3. 항목 삭제");
            System.out.println("4. 완료된 항목 표시");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = TextIO.getlnInt();

            switch (choice) {
                case 1: // 항목 추가
                    if (itemCount >= MAX_SIZE) {
                        System.out.println("❌ 리스트가 가득 찼습니다!");
                    } else {
                        System.out.print("추가할 항목: ");
                        String newItem = TextIO.getln();
                        todoList[itemCount] = newItem;
                        itemCount++;
                        System.out.println("✅ 항목이 추가되었습니다.");
                    }
                    break;

                case 2: // 목록 보기
                    if (itemCount == 0) {
                        System.out.println("📋 리스트가 비어있습니다.");
                    } else {
                        System.out.println("\n📋 To-Do 리스트 (" + itemCount + "개):");
                        for (int i = 0; i < itemCount; i++) {
                            System.out.println((i + 1) + ". " + todoList[i]);
                        }
                    }
                    break;

                case 3: // 항목 삭제
                    if (itemCount == 0) {
                        System.out.println("❌ 삭제할 항목이 없습니다.");
                    } else {
                        System.out.print("삭제할 항목 번호 (1-" + itemCount + "): ");
                        int deleteIndex = TextIO.getlnInt() - 1;

                        if (deleteIndex >= 0 && deleteIndex < itemCount) {
                            // TODO: 항목 삭제 로직
                            // 힌트: 배열 요소 이동

                            // 여기에 코드를 작성하세요
                        } else {
                            System.out.println("❌ 잘못된 번호입니다.");
                        }
                    }
                    break;

                case 4: // 완료 표시
                    if (itemCount == 0) {
                        System.out.println("❌ 표시할 항목이 없습니다.");
                    } else {
                        System.out.print("완료할 항목 번호 (1-" + itemCount + "): ");
                        int completeIndex = TextIO.getlnInt() - 1;

                        if (completeIndex >= 0 && completeIndex < itemCount) {
                            if (!todoList[completeIndex].startsWith("✓ ")) {
                                todoList[completeIndex] = "✓ " + todoList[completeIndex];
                                System.out.println("✅ 완료로 표시되었습니다.");
                            } else {
                                System.out.println("ℹ️ 이미 완료된 항목입니다.");
                            }
                        } else {
                            System.out.println("❌ 잘못된 번호입니다.");
                        }
                    }
                    break;

                case 0: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("❌ 잘못된 선택입니다.");
            }
        }
    }
}
```

#### 실행 결과:
```
=== To-Do 리스트 관리 ===

메뉴:
1. 항목 추가
2. 항목 목록 보기
3. 항목 삭제
4. 완료된 항목 표시
0. 종료
선택: 1
추가할 항목: 알고리즘 공부하기
✅ 항목이 추가되었습니다.

메뉴:
1. 항목 추가
2. 항목 목록 보기
3. 항목 삭제
4. 완료된 항목 표시
0. 종료
선택: 1
추가할 항목: 프로젝트 마무리
✅ 항목이 추가되었습니다.

메뉴:
1. 항목 추가
2. 항목 목록 보기
3. 항목 삭제
4. 완료된 항목 표시
0. 종료
선택: 2

📋 To-Do 리스트 (2개):
1. 알고리즘 공부하기
2. 프로젝트 마무리

메뉴:
1. 항목 추가
2. 항목 목록 보기
3. 항목 삭제
4. 완료된 항목 표시
0. 종료
선택: 4
완료할 항목 번호 (1-2): 1
✅ 완료로 표시되었습니다.

메뉴:
1. 항목 추가
2. 항목 목록 보기
3. 항목 삭제
4. 완료된 항목 표시
0. 종료
선택: 2

📋 To-Do 리스트 (2개):
1. ✓ 알고리즘 공부하기
2. 프로젝트 마무리
```

### 예제 4-2: 성적 통계 계산기

#### 요구사항
- 점수 입력받기 (0 이하 입력 시 종료, 100점 초과 불가)
- 통계 계산: 합계, 평균, 최고점, 최저점, 표준편차
- 등급별 분포 계산: A(90-100), B(80-89), C(70-79), D(60-69), F(0-59)
- 각 등급의 학생 수와 비율 계산
- 막대 그래프로 등급별 분포 시각화
- 최대 50개 점수 입력 가능

#### 예제 코드
```java
import textio.TextIO;

public class GradeStatisticsExample {
    public static void main(String[] args) {
        final int MAX_SCORES = 50;
        double[] scores = new double[MAX_SCORES];
        int scoreCount = 0;

        System.out.println("=== 성적 통계 계산기 ===");
        System.out.println("점수를 입력하세요 (0 이하로 종료):");

        // 점수 입력
        while (scoreCount < MAX_SCORES) {
            System.out.print("점수 " + (scoreCount + 1) + ": ");
            double score = TextIO.getlnDouble();

            if (score <= 0) {
                break;
            }

            if (score > 100) {
                System.out.println("❌ 100점을 초과할 수 없습니다.");
                continue;
            }

            scores[scoreCount] = score;
            scoreCount++;
        }

        if (scoreCount == 0) {
            System.out.println("입력된 점수가 없습니다.");
            return;
        }

        // TODO: 통계 계산 (합계, 최대, 최소, 평균, 표준편차)
        // 힌트: 누적과 표준편차 공식

        // 여기에 코드를 작성하세요

        // TODO: 등급별 분포 계산
        // 힌트: else-if 체인

        // 여기에 코드를 작성하세요

        // 결과 출력
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📊 통계 결과");
        System.out.println("=".repeat(40));
        System.out.printf("입력된 점수 개수: %d개%n", scoreCount);
        System.out.printf("합계: %.2f점%n", sum);
        System.out.printf("평균: %.2f점%n", average);
        System.out.printf("최고점: %.2f점%n", max);
        System.out.printf("최저점: %.2f점%n", min);
        System.out.printf("표준편차: %.2f%n", standardDeviation);

        System.out.println("\n등급별 분포:");
        String[] grades = {"A (90-100)", "B (80-89)", "C (70-79)", "D (60-69)", "F (0-59)"};
        for (int i = 0; i < grades.length; i++) {
            double percentage = (gradeCount[i] * 100.0) / scoreCount;
            System.out.printf("%s: %d명 (%.1f%%)%n", grades[i], gradeCount[i], percentage);

            // 막대 그래프
            System.out.print("  ");
            int barLength = (int)(percentage / 2);  // 50% = 25개 문자
            for (int j = 0; j < barLength; j++) {
                System.out.print("█");
            }
            System.out.println();
        }
    }
}
```

#### 실행 결과:
```
=== 성적 통계 계산기 ===
점수를 입력하세요 (0 이하로 종료):
점수 1: 95.5
점수 2: 87.3
점수 3: 92.0
점수 4: 78.5
점수 5: 88.0
점수 6: 0

========================================
📊 통계 결과
========================================
입력된 점수 개수: 5개
합계: 441.30점
평균: 88.26점
최고점: 95.50점
최저점: 78.50점
표준편차: 6.26

등급별 분포:
A (90-100): 2명 (40.0%)
  ████████████████████
B (80-89): 2명 (40.0%)
  ████████████████████
C (70-79): 1명 (20.0%)
  ██████████
D (60-69): 0명 (0.0%)

F (0-59): 0명 (0.0%)

```

## 5. 2차원 배열 예제

### 예제 5-1: 좌석 예약 시스템

#### 요구사항
- 5행 × 6열 극장 좌석 배치
- 좌석 예약: 행과 열 번호 입력받아 예약 처리
- 예약 취소: 선택한 좌석 예약 취소
- 예약률 확인: 전체 예약률 및 행별 예약 현황 표시
- displaySeats() 메소드에 좌석 현황 출력 구현
- showReservationStats() 메소드에 예약된 좌석 수 계산 구현

#### 예제 코드
```java
import textio.TextIO;

public class SeatReservationSystemExample {
    public static void main(String[] args) {
        final int ROWS = 5;
        final int COLS = 6;
        boolean[][] seats = new boolean[ROWS][COLS];  // false = 빈 좌석, true = 예약됨

        System.out.println("=== 극장 좌석 예약 시스템 ===");
        System.out.println("좌석 배치: " + ROWS + "행 × " + COLS + "열");

        while (true) {
            // 좌석 현황 표시
            displaySeats(seats);

            // 메뉴
            System.out.println("\n1. 좌석 예약");
            System.out.println("2. 예약 취소");
            System.out.println("3. 예약률 확인");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = TextIO.getlnInt();

            switch (choice) {
                case 1: // 예약
                    System.out.print("예약할 행 번호 (1-" + ROWS + "): ");
                    int row = TextIO.getlnInt() - 1;
                    System.out.print("예약할 열 번호 (1-" + COLS + "): ");
                    int col = TextIO.getlnInt() - 1;

                    if (isValidSeat(row, col, ROWS, COLS)) {
                        if (!seats[row][col]) {
                            seats[row][col] = true;
                            System.out.println("✅ 좌석이 예약되었습니다.");
                        } else {
                            System.out.println("❌ 이미 예약된 좌석입니다.");
                        }
                    } else {
                        System.out.println("❌ 유효하지 않은 좌석 번호입니다.");
                    }
                    break;

                case 2: // 취소
                    System.out.print("취소할 행 번호 (1-" + ROWS + "): ");
                    row = TextIO.getlnInt() - 1;
                    System.out.print("취소할 열 번호 (1-" + COLS + "): ");
                    col = TextIO.getlnInt() - 1;

                    if (isValidSeat(row, col, ROWS, COLS)) {
                        if (seats[row][col]) {
                            seats[row][col] = false;
                            System.out.println("✅ 예약이 취소되었습니다.");
                        } else {
                            System.out.println("❌ 예약되지 않은 좌석입니다.");
                        }
                    } else {
                        System.out.println("❌ 유효하지 않은 좌석 번호입니다.");
                    }
                    break;

                case 3: // 예약률
                    showReservationStats(seats);
                    break;

                case 0: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("❌ 잘못된 선택입니다.");
            }
        }
    }

    public static void displaySeats(boolean[][] seats) {
        System.out.println("\n=== 좌석 현황 ===");
        System.out.println("(□ = 빈 좌석, ■ = 예약된 좌석)");

        // TODO: 좌석 배치 출력
        // 힌트: 이중 루프와 조건문

        // 여기에 코드를 작성하세요
    }

    public static boolean isValidSeat(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
    }

    public static void showReservationStats(boolean[][] seats) {
        int totalSeats = seats.length * seats[0].length;
        int reservedSeats = 0;

        // TODO: 예약된 좌석 수 계산
        // 힌트: 이중 루프와 카운터

        // 여기에 코드를 작성하세요

        double reservationRate = (reservedSeats * 100.0) / totalSeats;

        System.out.println("\n=== 예약 통계 ===");
        System.out.println("전체 좌석: " + totalSeats + "석");
        System.out.println("예약된 좌석: " + reservedSeats + "석");
        System.out.println("빈 좌석: " + (totalSeats - reservedSeats) + "석");
        System.out.printf("예약률: %.1f%%%n", reservationRate);

        // 행별 예약률
        System.out.println("\n행별 예약 현황:");
        for (int row = 0; row < seats.length; row++) {
            int rowReserved = 0;
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col]) rowReserved++;
            }
            System.out.printf("%d행: %d/%d석 (%.0f%%)%n",
                row + 1, rowReserved, seats[row].length,
                (rowReserved * 100.0) / seats[row].length);
        }
    }
}
```

#### 실행 결과:
```
=== 극장 좌석 예약 시스템 ===
좌석 배치: 5행 × 6열

=== 좌석 현황 ===
(□ = 빈 좌석, ■ = 예약된 좌석)
   1  2  3  4  5  6
1행 [□][□][□][□][□][□]
2행 [□][□][□][□][□][□]
3행 [□][□][□][□][□][□]
4행 [□][□][□][□][□][□]
5행 [□][□][□][□][□][□]

1. 좌석 예약
2. 예약 취소
3. 예약률 확인
0. 종료
선택: 1
예약할 행 번호 (1-5): 2
예약할 열 번호 (1-6): 3
✅ 좌석이 예약되었습니다.

=== 좌석 현황 ===
(□ = 빈 좌석, ■ = 예약된 좌석)
   1  2  3  4  5  6
1행 [□][□][□][□][□][□]
2행 [□][□][■][□][□][□]
3행 [□][□][□][□][□][□]
4행 [□][□][□][□][□][□]
5행 [□][□][□][□][□][□]

1. 좌석 예약
2. 예약 취소
3. 예약률 확인
0. 종료
선택: 3

=== 예약 통계 ===
전체 좌석: 30석
예약된 좌석: 1석
빈 좌석: 29석
예약률: 3.3%

행별 예약 현황:
1행: 0/6석 (0%)
2행: 1/6석 (17%)
3행: 0/6석 (0%)
4행: 0/6석 (0%)
5행: 0/6석 (0%)
```

### 예제 5-2: 게임 보드 - 틱택토

#### 요구사항
- 3×3 틱택토 게임 보드 구현
- 두 플레이어가 번갈아 X와 O를 놓기
- 유효한 위치 입력 검증 (빈 칸인지 확인)
- 승리 조건 확인: 가로, 세로, 대각선 검사
- 9번 이동 후에도 승자가 없으면 무승부 처리
- checkWin() 메소드에 승리 조건 검사 구현

#### 예제 코드
```java
import textio.TextIO;

public class TicTacToeExample {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);

        System.out.println("=== 틱택토 게임 ===");
        System.out.println("플레이어 1: X, 플레이어 2: O");

        boolean player1Turn = true;
        int moves = 0;

        while (moves < 9) {
            displayBoard(board);

            char currentPlayer = player1Turn ? 'X' : 'O';
            System.out.println("\n플레이어 " + (player1Turn ? "1" : "2") + "의 차례 (" + currentPlayer + ")");

            // 유효한 위치 입력받기
            int row, col;
            while (true) {
                System.out.print("행 번호 (1-3): ");
                row = TextIO.getlnInt() - 1;
                System.out.print("열 번호 (1-3): ");
                col = TextIO.getlnInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    break;
                }
                System.out.println("❌ 유효하지 않은 위치입니다. 다시 입력하세요.");
            }

            // 수 놓기
            board[row][col] = currentPlayer;
            moves++;

            // 승리 확인
            if (checkWin(board, currentPlayer)) {
                displayBoard(board);
                System.out.println("\n🎉 플레이어 " + (player1Turn ? "1" : "2") + " 승리!");
                return;
            }

            // 턴 교체
            player1Turn = !player1Turn;
        }

        // 무승부
        displayBoard(board);
        System.out.println("\n🤝 무승부!");
    }

    public static void initializeBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("\n  1   2   3");
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < board[row].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < board.length - 1) {
                System.out.println("  ---|---|---");
            }
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        // TODO: 승리 조건 확인
        // 힌트: 행, 열, 대각선 검사

        // 여기에 코드를 작성하세요

        return false;
    }
}
```

#### 실행 결과:
```
=== 틱택토 게임 ===
플레이어 1: X, 플레이어 2: O

  1   2   3
| 1   |     |
| --- | --- | --- |
| 2   |     |
| --- | --- | --- |
| 3   |     |

플레이어 1의 차례 (X)
행 번호 (1-3): 2
열 번호 (1-3): 2

  1   2   3
| 1   |     |
| --- | --- | --- |
| 2   | X   |
| --- | --- | --- |
| 3   |     |

플레이어 2의 차례 (O)
행 번호 (1-3): 1
열 번호 (1-3): 1

  1   2   3
| 1 O |     |
| --- | --- | --- |
| 2   | X   |
| --- | --- | --- |
| 3   |     |

플레이어 1의 차례 (X)
행 번호 (1-3): 1
열 번호 (1-3): 2

  1   2   3
| 1 O | X   |
| --- | --- | --- |
| 2   | X   |
| --- | --- | --- |
| 3   |     |

플레이어 2의 차례 (O)
행 번호 (1-3): 3
열 번호 (1-3): 2

  1   2   3
| 1 O | X   |
| --- | --- | --- |
| 2   | X   |
| --- | --- | --- |
| 3   | O   |

플레이어 1의 차례 (X)
행 번호 (1-3): 3
열 번호 (1-3): 2

  1   2   3
| 1 O | X   |
| --- | --- | --- |
| 2   | X   |
| --- | --- | --- |
| 3   | X   |

🎉 플레이어 1 승리!
```

이 예제들은 배열의 다양한 활용 방법을 보여줍니다:

- **기본 배열**: 선언, 생성, 초기화, 접근
- **배열 처리**: 합계, 평균, 최대/최소값 찾기
- **임의 접근**: 로또 번호, 카드 셔플링
- **부분 채움**: 동적 크기 관리, 통계 계산
- **2차원 배열**: 좌석 예약, 게임 보드

각 예제는 실제 상황에서 배열을 어떻게 활용하는지 보여주며, 점진적으로 복잡도가 증가합니다.