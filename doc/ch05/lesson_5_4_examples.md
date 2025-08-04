# 5.4 프로그래밍 예제: 카드, 손패, 덱 - 수업 실습

## 1. Card 클래스 구현 실습

### 실습 1-1: 기본 Card 클래스 만들기
**목표**: 트럼프 카드를 표현하는 Card 클래스를 구현해보세요.

```java
/**
 * 카드(트럼프 카드)를 나타내는 클래스
 */
public class Card {
    
    // 무늬를 나타내는 상수
    public final static int SPADES = 0;   // 스페이드
    public final static int HEARTS = 1;   // 하트
    public final static int DIAMONDS = 2; // 다이아몬드
    public final static int CLUBS = 3;    // 클럽
    
    // 카드 값을 나타내는 상수
    public final static int ACE = 1;      // 에이스
    public final static int JACK = 11;    // 잭
    public final static int QUEEN = 12;   // 퀸
    public final static int KING = 13;    // 킹
    
    // 카드의 무늬 (0-3 중 하나)
    private final int suit;
    
    // 카드의 값 (1-13 중 하나)
    private final int value;
    
    /**
     * 지정된 값과 무늬로 카드를 생성
     */
    public Card(int theValue, int theSuit) {
        // TODO 1: value와 suit 초기화하기
        // value = theValue
        // suit = theSuit
    }
    
    /**
     * 카드의 값을 반환
     */
    public int getValue() {
        // TODO 2: value 반환하기
    }
    
    /**
     * 카드의 무늬를 반환
     */
    public int getSuit() {
        // TODO 3: suit 반환하기
    }
    
    /**
     * 카드의 무늬를 문자열로 반환
     */
    public String getSuitAsString() {
        // TODO 4: suit 값에 따라 문자열 반환하기
        // switch문 사용
        // SPADES -> "스페이드"
        // HEARTS -> "하트"
        // DIAMONDS -> "다이아몬드"
        // CLUBS -> "클럽"
        // default -> "??"
    }
    
    /**
     * 카드의 값을 문자열로 반환
     */
    public String getValueAsString() {
        // TODO 5: value 값에 따라 문자열 반환하기
        // switch문 사용
        // 1 -> "에이스"
        // 2~10 -> 숫자 그대로
        // 11 -> "잭"
        // 12 -> "퀸"
        // 13 -> "킹"
        // default -> "??"
    }
    
    /**
     * 카드를 문자열로 표현
     */
    public String toString() {
        // TODO 6: 카드를 "값 무늬" 형식의 문자열로 반환하기
        // 예: "에이스 스페이드", "킹 하트"
    }
}

// 사용 예제
public class CardExample {
    public static void main(String[] args) {
        // TODO 7: 카드 객체 생성하기
        // card1: 에이스 스페이드 (1, Card.SPADES)
        // card2: 킹 하트 (13, Card.HEARTS)
        // card3: 7 다이아몬드 (7, Card.DIAMONDS)
        
        // TODO 8: 생성된 카드 출력하기
        // 각 카드를 "카드 N: [카드정보]" 형식으로 출력
        
        // TODO 9: 카드 1의 세부 정보 출력하기
        // getValue()와 getSuitAsString() 메서드 사용
    }
}
```

#### 실행 결과 (참고용):
```
카드 1: 에이스 스페이드
카드 2: 킹 하트
카드 3: 7 다이아몬드

카드 1의 값: 1
카드 1의 무늬: 스페이드
```

## 2. Deck 클래스 구현 실습

### 실습 2-1: 카드 덱 만들기
**목표**: 52장의 카드를 관리하는 Deck 클래스를 구현해보세요.

```java
/**
 * 카드 덱을 나타내는 클래스
 */
public class Deck {
    private Card[] deck;     // 카드 배열
    private int cardsUsed;   // 사용된 카드 수
    
    /**
     * 52장의 표준 카드 덱을 생성
     */
    public Deck() {
        // TODO 10: 52장의 카드로 이루어진 덱 생성하기
        // deck = new Card[52] 생성
        // 이중 for문 사용:
        //   - 바깥쪽: suit (0~3)
        //   - 안쪽: value (1~13)
        // 각 조합으로 Card 객체 생성하여 deck 배열에 저장
        // cardsUsed = 0으로 초기화
    }
    
    /**
     * 카드를 섞는다
     */
    public void shuffle() {
        // TODO 11: Fisher-Yates 셔플 알고리즘 구현하기
        // 배열의 끝에서부터 시작하여:
        //   - 현재 위치부터 시작까지의 랜덤 인덱스 선택
        //   - 현재 카드와 랜덤 위치의 카드 교환
        // cardsUsed = 0으로 리셋
    }
    
    /**
     * 남은 카드 수를 반환
     */
    public int cardsLeft() {
        // TODO 12: 남은 카드 수 반환하기
        // 전체 카드 수 - 사용된 카드 수
    }
    
    /**
     * 카드 한 장을 나누어준다
     */
    public Card dealCard() {
        // TODO 13: 카드 한 장 나누어주기
        // 카드가 없으면 IllegalStateException 발생
        // cardsUsed 증가시키고 해당 위치의 카드 반환
    }
    
    /**
     * 덱에 조커가 있는지 확인
     */
    public boolean hasJoker() {
        // TODO 14: 조커 포함 여부 반환하기 (기본 덱은 조커 없음)
    }
}

// 사용 예제
public class DeckExample {
    public static void main(String[] args) {
        // TODO 15: 덱 생성하고 셔플하기
        // Deck 객체 생성
        // shuffle() 메서드 호출
        
        // TODO 16: 카드 5장 뽑기
        // for문으로 5번 반복:
        //   - dealCard()로 카드 뽑기
        //   - "카드 N: [카드정보]" 형식으로 출력
        
        // TODO 17: 남은 카드 수 출력하기
        // cardsLeft() 메서드 사용
        
        // TODO 18: 덱 다시 셔플하기
        // shuffle() 호출하고 결과 확인
    }
}
```

#### 실행 결과 (참고용):
```
셔플된 덱에서 카드 5장 뽑기:
카드 1: 퀸 다이아몬드
카드 2: 3 클럽
카드 3: 에이스 하트
카드 4: 10 스페이드
카드 5: 잭 하트

남은 카드: 47장

덱을 다시 셔플합니다...
다시 셔플 후 남은 카드: 52장
```

## 3. Hand 클래스 구현 실습

### 실습 3-1: 손패 관리 클래스 만들기
**목표**: 플레이어의 손패를 관리하는 Hand 클래스를 구현해보세요.

```java
import java.util.ArrayList;

/**
 * 손에 든 카드들을 관리하는 클래스
 */
public class Hand {
    private ArrayList<Card> hand;  // 손에 든 카드들
    
    /**
     * 빈 손패를 생성
     */
    public Hand() {
        // TODO 19: ArrayList<Card> 생성하여 hand 초기화하기
    }
    
    /**
     * 손패를 비운다
     */
    public void clear() {
        // TODO 20: 손에 있는 모든 카드 제거하기
        // hand.clear() 호출
    }
    
    /**
     * 카드를 손패에 추가
     */
    public void addCard(Card c) {
        // TODO 21: 카드를 손에 추가하기
        // null 체크: null이면 NullPointerException 발생
        // hand에 카드 추가
    }
    
    /**
     * 특정 카드를 손패에서 제거
     */
    public void removeCard(Card c) {
        // TODO 22: 특정 카드를 손에서 제거하기
        // hand.remove(c) 호출
    }
    
    /**
     * 특정 위치의 카드를 제거
     */
    public void removeCard(int position) {
        // TODO 23: 특정 위치의 카드를 손에서 제거하기
        // 위치 유효성 검사: 범위를 벗어나면 IllegalArgumentException
        // hand.remove(position) 호출
    }
    
    /**
     * 손패의 카드 수 반환
     */
    public int getCardCount() {
        // TODO 24: 손에 있는 카드 수 반환하기
        // hand.size() 반환
    }
    
    /**
     * 특정 위치의 카드 반환
     */
    public Card getCard(int position) {
        // TODO 25: 특정 위치의 카드 반환하기
        // 위치 유효성 검사
        // hand.get(position) 반환
    }
    
    /**
     * 손패를 무늬별로 정렬
     */
    public void sortBySuit() {
        // TODO 26: 무늬별로 카드 정렬하기
        // 선택 정렬 알고리즘 사용:
        // - 새로운 ArrayList 생성
        // - 원래 hand가 빌 때까지:
        //   - 가장 작은 무늬/값의 카드 찾기
        //   - 해당 카드를 제거하고 새 리스트에 추가
        // - hand를 새 리스트로 교체
    }
    
    /**
     * 손패를 값별로 정렬
     */
    public void sortByValue() {
        // TODO 27: 값별로 카드 정렬하기
        // 선택 정렬 알고리즘 사용:
        // - 값이 작은 순서로 정렬
        // - 같은 값이면 무늬 순서로 정렬
    }
}

// 사용 예제
public class HandExample {
    public static void main(String[] args) {
        // TODO 28: 덱과 손 객체 생성하기
        // Deck 생성하고 셔플
        // Hand 객체 생성
        
        // TODO 29: 카드 5장 받기
        // for문으로 5번 반복:
        //   - dealCard()로 카드 받기
        //   - addCard()로 손에 추가
        //   - 받은 카드 출력
        
        // TODO 30: 손에 있는 카드 수 출력하기
        
        // TODO 31: 무늬별로 정렬하고 출력하기
        // sortBySuit() 호출
        // 모든 카드 출력
        
        // TODO 32: 값별로 정렬하고 출력하기
        // sortByValue() 호출
        // 모든 카드 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 카드 5장 받기 ===
받은 카드: 킹 하트
받은 카드: 3 스페이드
받은 카드: 에이스 다이아몬드
받은 카드: 잭 클럽
받은 카드: 7 하트

손에 있는 카드 수: 5

=== 무늬별로 정렬 ===
카드 1: 3 스페이드
카드 2: 킹 하트
카드 3: 7 하트
카드 4: 에이스 다이아몬드
카드 5: 잭 클럽

=== 값별로 정렬 ===
카드 1: 에이스 다이아몬드
카드 2: 3 스페이드
카드 3: 7 하트
카드 4: 잭 클럽
카드 5: 킹 하트
```

## 4. 카드 게임 실습

### 실습 4-1: High-Low 카드 게임
**목표**: 다음 카드가 현재 카드보다 높을지 낮을지 맞추는 게임을 구현해보세요.

```java
/**
 * High-Low 카드 게임
 */
public class HighLowGame {
    private Deck deck;
    private Card currentCard;
    private int correctGuesses;
    private boolean gameOver;
    
    /**
     * 새 게임을 시작
     */
    public HighLowGame() {
        // TODO 33: 게임 초기화하기
        // deck 생성하고 셔플
        // 첫 번째 카드 뽑기
        // correctGuesses = 0
        // gameOver = false
    }
    
    /**
     * 현재 카드 반환
     */
    public Card getCurrentCard() {
        // TODO 34: 현재 카드 반환하기
    }
    
    /**
     * 게임 종료 여부 확인
     */
    public boolean isGameOver() {
        // TODO 35: 게임 종료 여부 반환하기
    }
    
    /**
     * 현재 점수 반환
     */
    public int getScore() {
        // TODO 36: 현재 점수(맞춘 횟수) 반환하기
    }
    
    /**
     * "다음 카드가 더 높다"고 추측
     */
    public boolean guessHigher() {
        // TODO 37: "다음 카드가 더 높다"고 추측하기
        // 게임이 끝났으면 false 반환
        // 다음 카드 뽑기
        // 다음 카드 값이 현재 카드보다 큰지 확인
        // 맞으면 correctGuesses 증가
        // 틀리면 gameOver = true
        // currentCard 업데이트
        // 결과 반환
    }
    
    /**
     * "다음 카드가 더 낮다"고 추측
     */
    public boolean guessLower() {
        // TODO 38: "다음 카드가 더 낮다"고 추측하기
        // guessHigher()와 유사하지만 반대 조건
    }
}

// 게임 실행 예제
public class HighLowGameExample {
    public static void main(String[] args) {
        // TODO 39: High-Low 게임 실행하기
        // HighLowGame 객체 생성
        // 게임 설명 출력
        
        // TODO 40: 게임 루프 구현하기
        // while문: 게임이 끝나지 않고 점수가 10 미만일 때까지
        //   - 현재 카드 출력
        //   - 랜덤하게 Higher 또는 Lower 선택
        //   - 선택에 따라 guessHigher() 또는 guessLower() 호출
        //   - 결과 출력 (정답/오답)
        
        // TODO 41: 최종 점수 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
=== High-Low 카드 게임 ===
다음 카드가 현재 카드보다 높을지 낮을지 맞춰보세요!

현재 카드: 7 하트
추측: 다음 카드가 더 높다
다음 카드: 킹 스페이드
정답! 현재 점수: 1

현재 카드: 킹 스페이드
추측: 다음 카드가 더 낮다
다음 카드: 3 다이아몬드
정답! 현재 점수: 2

현재 카드: 3 다이아몬드
추측: 다음 카드가 더 높다
다음 카드: 2 클럽
틀렸습니다! 게임 종료

최종 점수: 2
```

### 실습 4-2: 간단한 블랙잭 게임
**목표**: 블랙잭 스타일의 간단한 카드 게임을 구현해보세요.

```java
/**
 * 블랙잭 스타일 손패 (에이스를 유연하게 처리)
 */
public class BlackjackHand extends Hand {
    
    /**
     * 블랙잭에서의 손패 값 계산
     */
    public int getBlackjackValue() {
        int val = 0;
        boolean ace = false;
        
        for (int i = 0; i < getCardCount(); i++) {
            Card card = getCard(i);
            int cardVal = card.getValue();
            
            if (cardVal > 10) {
                cardVal = 10;   // J, Q, K는 10으로 계산
            }
            if (cardVal == 1) {
                ace = true;     // 에이스 발견
            }
            val = val + cardVal;
        }
        
        // 에이스가 있고 11로 계산해도 21을 넘지 않으면
        if (ace && val + 10 <= 21) {
            val = val + 10;
        }
        
        return val;
    }
}

// 블랙잭 게임 예제
public class SimpleBlackjackExample {
    public static void main(String[] args) {
        System.out.println("=== 간단한 블랙잭 게임 ===");
        
        // TODO 42: 블랙잭 게임 5라운드 진행하기
        // 승리 카운터 초기화 (playerWins, dealerWins, ties)
        
        // TODO 43: 각 라운드 구현하기
        // for문으로 5라운드 반복:
        //   - 새 덱 생성하고 셔플
        //   - 플레이어와 딜러 손 생성
        //   - 초기 카드 2장씩 배분
        
        // TODO 44: 플레이어 턴 구현하기
        //   - 현재 카드와 합계 출력
        //   - 17 이하면 카드 더 받기
        //   - 21 초과하면 버스트
        
        // TODO 45: 딜러 턴 구현하기
        //   - 숨겨진 카드 공개
        //   - 16 이하면 카드 더 받기
        
        // TODO 46: 승부 판정하기
        //   - 플레이어 버스트 -> 딜러 승
        //   - 딜러 버스트 -> 플레이어 승
        //   - 값 비교로 승부 결정
        
        // TODO 47: 최종 통계 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
=== 간단한 블랙잭 게임 ===

=== 라운드 1 ===
플레이어 카드:
  7 하트
  킹 스페이드
플레이어 합계: 17

딜러 카드:
  9 다이아몬드
  [숨김]

플레이어가 카드를 받습니다: 3 클럽
플레이어 합계: 20

딜러의 숨겨진 카드: 퀸 하트
딜러 합계: 19

=== 결과 ===
플레이어 승리!

=== 최종 결과 ===
플레이어 승리: 3
딜러 승리: 1
무승부: 1
```

## 학습 포인트

### 1. 객체지향 설계
- **캡슐화**: private 필드와 public 메서드로 데이터 보호
- **재사용성**: Card, Deck, Hand 클래스의 다양한 활용
- **확장성**: 기본 클래스를 상속하여 특화된 기능 추가

### 2. 자료구조 활용
- **배열**: Deck 클래스에서 고정 크기 카드 관리
- **ArrayList**: Hand 클래스에서 가변 크기 카드 관리
- **알고리즘**: 셔플(Fisher-Yates), 정렬(선택 정렬)

### 3. 프로그래밍 패턴
- **상수 활용**: 카드 무늬와 특수 값을 상수로 정의
- **예외 처리**: 잘못된 입력에 대한 적절한 처리
- **게임 루프**: 반복적인 게임 진행 구조

카드 게임은 객체지향 프로그래밍을 학습하기에 매우 좋은 예제입니다. 간단한 클래스들이 조합되어 복잡한 게임 로직을 구현할 수 있음을 경험해보세요!