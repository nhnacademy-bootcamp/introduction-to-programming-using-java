# 5.4 프로그래밍 예제: 카드, 손패, 덱 - 학습 자료

## 학습 목표
이 장을 마치면 다음을 할 수 있습니다:
- 실제 문제를 객체지향적으로 분석하고 설계할 수 있다
- 재사용 가능한 클래스를 설계하고 구현할 수 있다
- 클래스 간의 관계와 협력을 이해한다
- 불변 객체의 개념과 장점을 안다
- 완전한 카드 게임 시스템을 구현할 수 있다

## 1. 객체지향 설계 과정

### 1.1 문제 분석: 카드 게임 시스템

**문제 설명**:
"일반적인 카드 게임에서는 각 플레이어가 손패를 받습니다. 덱은 섞이고, 카드가 한 장씩 덱에서 나와 플레이어의 손패에 추가됩니다. 게임의 승패는 플레이어가 받은 카드의 값과 무늬에 따라 결정됩니다."

### 1.2 명사 찾기 (클래스 후보)

**주요 명사들**:
- **게임**(game) → Game 클래스
- **플레이어**(player) → Player 클래스
- **손패**(hand) → Hand 클래스
- **카드**(card) → Card 클래스
- **덱**(deck) → Deck 클래스
- **값**(value) → Card의 속성
- **무늬**(suit) → Card의 속성

### 1.3 동사 찾기 (메서드 후보)

**주요 동사들**:
- **섞다**(shuffle) → Deck.shuffle()
- **나누어주다**(deal) → Deck.dealCard()
- **추가하다**(add) → Hand.addCard()
- **제거하다**(remove) → Hand.removeCard()

### 1.4 클래스 선택 기준

**재사용성 우선순위**:
1. **Card 클래스** - 가장 기본적이고 재사용성 높음
2. **Deck 클래스** - 표준 덱 관리, 높은 재사용성
3. **Hand 클래스** - 카드 그룹 관리, 높은 재사용성
4. **Game/Player** - 특정 게임에 종속적, 재사용성 낮음

## 2. Card 클래스 설계와 구현

### 2.1 Card 클래스의 요구사항

**기본 속성**:
- 무늬(suit): 스페이드, 하트, 다이아몬드, 클럽, 조커
- 값(value): 에이스(1), 2-10, 잭(11), 퀸(12), 킹(13)

**설계 원칙**:
- **불변성**: 카드는 생성 후 변경되지 않음
- **상수 활용**: 무늬와 특별한 값들을 상수로 정의
- **편의 메서드**: 사람이 읽기 쉬운 형태로 출력

### 2.2 완전한 Card 클래스 구현

```java
/**
 * 표준 포커 덱의 카드를 나타내는 클래스
 * 불변 객체로 설계됨
 */
public class Card {
    
    // 무늬 상수 정의
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;
    public static final int JOKER = 4;
    
    // 특별한 값 상수 정의
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    // 인스턴스 변수 (final로 불변성 보장)
    private final int suit;   // 카드의 무늬
    private final int value;  // 카드의 값
    
    /**
     * 기본 생성자 - 값이 1인 조커 생성
     */
    public Card() {
        this.suit = JOKER;
        this.value = 1;
    }
    
    /**
     * 지정된 값과 무늬를 가진 카드 생성
     * @param value 카드의 값 (1-13, 조커의 경우 임의)
     * @param suit 카드의 무늬 (0-4)
     */
    public Card(int value, int suit) {
        // 유효성 검사
        if (suit < SPADES || suit > JOKER) {
            throw new IllegalArgumentException("잘못된 카드 무늬: " + suit);
        }
        if (suit != JOKER && (value < 1 || value > 13)) {
            throw new IllegalArgumentException("잘못된 카드 값: " + value);
        }
        
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * 카드의 값 반환
     */
    public int getValue() {
        return value;
    }
    
    /**
     * 카드의 무늬 반환
     */
    public int getSuit() {
        return suit;
    }
    
    /**
     * 무늬를 문자열로 반환
     */
    public String getSuitAsString() {
        switch (suit) {
            case SPADES:   return "스페이드";
            case HEARTS:   return "하트";
            case DIAMONDS: return "다이아몬드";
            case CLUBS:    return "클럽";
            default:       return "조커";
        }
    }
    
    /**
     * 값을 문자열로 반환
     */
    public String getValueAsString() {
        if (suit == JOKER) {
            return "조커" + (value == 1 ? "" : " #" + value);
        }
        
        switch (value) {
            case ACE:   return "에이스";
            case JACK:  return "잭";
            case QUEEN: return "퀸";
            case KING:  return "킹";
            default:    return String.valueOf(value);
        }
    }
    
    /**
     * 카드의 완전한 설명 반환
     */
    @Override
    public String toString() {
        if (suit == JOKER) {
            return getValueAsString();
        } else {
            return getSuitAsString() + " " + getValueAsString();
        }
    }
    
    /**
     * 카드 비교 (값과 무늬 모두 같아야 동일)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Card card = (Card) obj;
        return value == card.value && suit == card.suit;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }
    
    /**
     * 카드 게임에서 자주 사용되는 편의 메서드들
     */
    
    /**
     * 빨간색 카드인지 확인
     */
    public boolean isRed() {
        return suit == HEARTS || suit == DIAMONDS;
    }
    
    /**
     * 검은색 카드인지 확인
     */
    public boolean isBlack() {
        return suit == SPADES || suit == CLUBS;
    }
    
    /**
     * 그림 카드인지 확인 (잭, 퀸, 킹)
     */
    public boolean isFaceCard() {
        return value >= JACK && value <= KING && suit != JOKER;
    }
    
    /**
     * 에이스인지 확인
     */
    public boolean isAce() {
        return value == ACE && suit != JOKER;
    }
    
    /**
     * 조커인지 확인
     */
    public boolean isJoker() {
        return suit == JOKER;
    }
}
```

### 2.3 Card 클래스 사용 예제

```java
public class CardExample {
    public static void main(String[] args) {
        // 다양한 방법으로 카드 생성
        Card aceOfSpades = new Card(Card.ACE, Card.SPADES);
        Card queenOfHearts = new Card(Card.QUEEN, Card.HEARTS);
        Card tenOfDiamonds = new Card(10, Card.DIAMONDS);
        Card joker = new Card();
        
        // 카드 정보 출력
        System.out.println("카드들:");
        System.out.println("1. " + aceOfSpades);
        System.out.println("2. " + queenOfHearts);
        System.out.println("3. " + tenOfDiamonds);
        System.out.println("4. " + joker);
        
        // 카드 속성 확인
        System.out.println("\n카드 속성:");
        System.out.println(aceOfSpades + " - 빨간색? " + aceOfSpades.isRed());
        System.out.println(queenOfHearts + " - 그림카드? " + queenOfHearts.isFaceCard());
        System.out.println(aceOfSpades + " - 에이스? " + aceOfSpades.isAce());
        System.out.println(joker + " - 조커? " + joker.isJoker());
    }
}
```

## 3. Deck 클래스 설계와 구현

### 3.1 Deck 클래스의 요구사항

**핵심 기능**:
- 표준 52장 카드 덱 생성
- 카드 섞기 (shuffle)
- 카드 나누어주기 (deal)
- 남은 카드 수 확인

### 3.2 Deck 클래스 구현

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 표준 포커 덱을 나타내는 클래스
 */
public class Deck {
    private List<Card> cards;  // 덱의 카드들
    private int nextCardIndex; // 다음에 나누어줄 카드의 인덱스
    
    /**
     * 표준 52장 카드로 덱 생성
     */
    public Deck() {
        createStandardDeck();
    }
    
    /**
     * 조커 포함 여부를 선택할 수 있는 생성자
     */
    public Deck(boolean includeJokers) {
        createStandardDeck();
        if (includeJokers) {
            cards.add(new Card(1, Card.JOKER));
            cards.add(new Card(2, Card.JOKER));
        }
    }
    
    /**
     * 표준 52장 카드 생성
     */
    private void createStandardDeck() {
        cards = new ArrayList<>();
        nextCardIndex = 0;
        
        // 4개 무늬 × 13개 값 = 52장
        for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
            for (int value = Card.ACE; value <= Card.KING; value++) {
                cards.add(new Card(value, suit));
            }
        }
    }
    
    /**
     * 덱을 무작위로 섞기
     */
    public void shuffle() {
        Collections.shuffle(cards);
        nextCardIndex = 0; // 섞은 후 처음부터 다시 시작
    }
    
    /**
     * 덱에서 다음 카드를 나누어주기
     * @return 나누어진 카드
     * @throws IllegalStateException 남은 카드가 없을 때
     */
    public Card dealCard() {
        if (nextCardIndex >= cards.size()) {
            throw new IllegalStateException("덱에 남은 카드가 없습니다!");
        }
        
        Card dealtCard = cards.get(nextCardIndex);
        nextCardIndex++;
        return dealtCard;
    }
    
    /**
     * 덱에 남은 카드 수 반환
     */
    public int cardsLeft() {
        return cards.size() - nextCardIndex;
    }
    
    /**
     * 덱이 비어있는지 확인
     */
    public boolean isEmpty() {
        return cardsLeft() == 0;
    }
    
    /**
     * 덱을 초기 상태로 리셋 (모든 카드 복구)
     */
    public void reset() {
        nextCardIndex = 0;
    }
    
    /**
     * 덱 정보 출력
     */
    public void printDeck() {
        System.out.println("=== 덱 상태 ===");
        System.out.println("총 카드 수: " + cards.size());
        System.out.println("남은 카드 수: " + cardsLeft());
        System.out.println("다음 카드 인덱스: " + nextCardIndex);
        
        if (!isEmpty()) {
            System.out.println("다음 카드: " + cards.get(nextCardIndex));
        }
    }
    
    /**
     * 남은 카드들을 모두 출력 (디버깅용)
     */
    public void printRemainingCards() {
        System.out.println("=== 남은 카드들 ===");
        for (int i = nextCardIndex; i < cards.size(); i++) {
            System.out.println((i - nextCardIndex + 1) + ". " + cards.get(i));
        }
    }
}
```

### 3.3 Deck 클래스 사용 예제

```java
public class DeckExample {
    public static void main(String[] args) {
        // 덱 생성 및 섞기
        Deck deck = new Deck();
        System.out.println("새 덱 생성:");
        deck.printDeck();
        
        System.out.println("\n덱 섞기:");
        deck.shuffle();
        deck.printDeck();
        
        // 카드 나누어주기
        System.out.println("\n카드 5장 나누어주기:");
        for (int i = 0; i < 5; i++) {
            Card card = deck.dealCard();
            System.out.println((i + 1) + ". " + card);
        }
        
        System.out.println("\n5장 나눈 후 덱 상태:");
        deck.printDeck();
        
        // 모든 카드 나누어주기
        System.out.println("\n모든 카드 나누어주기:");
        int count = 0;
        while (!deck.isEmpty()) {
            deck.dealCard();
            count++;
        }
        System.out.println("총 " + count + "장의 카드를 나누어줌");
        
        // 빈 덱에서 카드 나누려고 시도
        System.out.println("\n빈 덱에서 카드 나누기 시도:");
        try {
            deck.dealCard();
        } catch (IllegalStateException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        // 덱 리셋
        System.out.println("\n덱 리셋:");
        deck.reset();
        deck.printDeck();
    }
}
```

## 4. Hand 클래스 설계와 구현

### 4.1 Hand 클래스의 요구사항

**핵심 기능**:
- 카드 추가/제거
- 카드 수 확인
- 카드 정렬 (무늬별, 값별)
- 특정 위치의 카드 접근

### 4.2 Hand 클래스 구현

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * 플레이어의 손패를 나타내는 클래스
 */
public class Hand {
    private List<Card> cards;  // 손패의 카드들
    
    /**
     * 빈 손패 생성
     */
    public Hand() {
        cards = new ArrayList<>();
    }
    
    /**
     * 손패 비우기
     */
    public void clear() {
        cards.clear();
    }
    
    /**
     * 손패에 카드 추가
     * @param card 추가할 카드
     * @throws NullPointerException 카드가 null인 경우
     */
    public void addCard(Card card) {
        if (card == null) {
            throw new NullPointerException("null 카드는 추가할 수 없습니다!");
        }
        cards.add(card);
    }
    
    /**
     * 손패에서 특정 카드 제거
     * @param card 제거할 카드
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }
    
    /**
     * 손패에서 특정 위치의 카드 제거
     * @param position 제거할 카드의 위치 (0부터 시작)
     * @throws IllegalArgumentException 잘못된 위치인 경우
     */
    public void removeCard(int position) {
        if (position < 0 || position >= cards.size()) {
            throw new IllegalArgumentException("잘못된 카드 위치: " + position);
        }
        cards.remove(position);
    }
    
    /**
     * 손패의 카드 수 반환
     */
    public int getCardCount() {
        return cards.size();
    }
    
    /**
     * 특정 위치의 카드 반환
     * @param position 카드 위치 (0부터 시작)
     * @return 해당 위치의 카드
     * @throws IllegalArgumentException 잘못된 위치인 경우
     */
    public Card getCard(int position) {
        if (position < 0 || position >= cards.size()) {
            throw new IllegalArgumentException("잘못된 카드 위치: " + position);
        }
        return cards.get(position);
    }
    
    /**
     * 손패가 비어있는지 확인
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    /**
     * 특정 카드가 손패에 있는지 확인
     */
    public boolean contains(Card card) {
        return cards.contains(card);
    }
    
    /**
     * 무늬별로 카드 정렬 (무늬 내에서는 값순)
     */
    public void sortBySuit() {
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                // 먼저 무늬로 비교
                if (c1.getSuit() != c2.getSuit()) {
                    return Integer.compare(c1.getSuit(), c2.getSuit());
                }
                // 같은 무늬면 값으로 비교
                return Integer.compare(c1.getValue(), c2.getValue());
            }
        });
    }
    
    /**
     * 값별로 카드 정렬 (값이 같으면 무늬순)
     */
    public void sortByValue() {
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                // 먼저 값으로 비교
                if (c1.getValue() != c2.getValue()) {
                    return Integer.compare(c1.getValue(), c2.getValue());
                }
                // 같은 값이면 무늬로 비교
                return Integer.compare(c1.getSuit(), c2.getSuit());
            }
        });
    }
    
    /**
     * 손패의 모든 카드 출력
     */
    public void printHand() {
        System.out.println("=== 손패 (" + cards.size() + "장) ===");
        if (isEmpty()) {
            System.out.println("(빈 손패)");
        } else {
            for (int i = 0; i < cards.size(); i++) {
                System.out.println((i + 1) + ". " + cards.get(i));
            }
        }
    }
    
    /**
     * 한 줄로 손패 출력
     */
    public void printHandInLine() {
        System.out.print("손패: ");
        if (isEmpty()) {
            System.out.println("(비어있음)");
        } else {
            for (int i = 0; i < cards.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(cards.get(i));
            }
            System.out.println();
        }
    }
    
    /**
     * 손패의 통계 정보
     */
    public void printStatistics() {
        System.out.println("=== 손패 통계 ===");
        System.out.println("총 카드 수: " + cards.size());
        
        // 무늬별 카드 수
        int[] suitCounts = new int[5]; // 0-3: 일반 무늬, 4: 조커
        for (Card card : cards) {
            suitCounts[card.getSuit()]++;
        }
        
        String[] suitNames = {"스페이드", "하트", "다이아몬드", "클럽", "조커"};
        for (int i = 0; i < 5; i++) {
            if (suitCounts[i] > 0) {
                System.out.println(suitNames[i] + ": " + suitCounts[i] + "장");
            }
        }
        
        // 그림 카드 수
        long faceCardCount = cards.stream().filter(Card::isFaceCard).count();
        System.out.println("그림 카드: " + faceCardCount + "장");
        
        // 에이스 수
        long aceCount = cards.stream().filter(Card::isAce).count();
        System.out.println("에이스: " + aceCount + "장");
    }
    
    @Override
    public String toString() {
        return "Hand{" + cards.size() + " cards}";
    }
}
```

## 5. 실제 카드 게임 구현: HighLow

### 5.1 게임 규칙

**HighLow 게임**:
1. 덱에서 첫 번째 카드를 보여줌
2. 플레이어가 다음 카드가 더 높은지 낮은지 예측
3. 정답이면 계속, 틀리면 게임 종료
4. 점수는 연속으로 맞힌 횟수

### 5.2 HighLow 게임 구현

```java
import java.util.Scanner;

/**
 * HighLow 카드 게임 구현
 */
public class HighLowGame {
    private Scanner scanner;
    
    public HighLowGame() {
        scanner = new Scanner(System.in);
    }
    
    /**
     * 게임 설명 출력
     */
    private void printGameRules() {
        System.out.println("=== HighLow 카드 게임 ===");
        System.out.println("규칙:");
        System.out.println("1. 덱에서 카드 한 장이 나옵니다.");
        System.out.println("2. 다음 카드가 더 높은지(H) 낮은지(L) 예측하세요.");
        System.out.println("3. 맞히면 계속, 틀리면 게임 종료입니다.");
        System.out.println("4. 점수는 연속으로 맞힌 횟수입니다.");
        System.out.println("5. 같은 값이 나오면 무승부로 게임이 끝납니다.");
        System.out.println();
    }
    
    /**
     * 한 게임 플레이
     * @return 획득한 점수
     */
    public int playOneGame() {
        Deck deck = new Deck();
        deck.shuffle();
        
        Card currentCard = deck.dealCard();
        int correctGuesses = 0;
        
        System.out.println("첫 번째 카드: " + currentCard);
        
        while (!deck.isEmpty()) {
            // 사용자 예측 입력
            char guess = getPlayerGuess();
            
            // 다음 카드 뽑기
            Card nextCard = deck.dealCard();
            System.out.println("다음 카드: " + nextCard);
            
            // 결과 판정
            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("무승부! 게임 종료입니다.");
                break;
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (guess == 'H') {
                    System.out.println("정답! 다음 카드가 더 높았습니다.");
                    correctGuesses++;
                } else {
                    System.out.println("틀렸습니다. 다음 카드가 더 높았습니다.");
                    break;
                }
            } else { // nextCard.getValue() < currentCard.getValue()
                if (guess == 'L') {
                    System.out.println("정답! 다음 카드가 더 낮았습니다.");
                    correctGuesses++;
                } else {
                    System.out.println("틀렸습니다. 다음 카드가 더 낮았습니다.");
                    break;
                }
            }
            
            currentCard = nextCard;
            System.out.println("현재 카드: " + currentCard);
            System.out.println("현재 점수: " + correctGuesses);
            System.out.println();
        }
        
        if (deck.isEmpty()) {
            System.out.println("축하합니다! 모든 카드를 다 맞혔습니다!");
        }
        
        System.out.println("최종 점수: " + correctGuesses);
        return correctGuesses;
    }
    
    /**
     * 플레이어의 예측 입력 받기
     */
    private char getPlayerGuess() {
        char guess;
        do {
            System.out.print("다음 카드가 더 높을까요(H) 낮을까요(L)? ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (input.length() == 1 && (input.charAt(0) == 'H' || input.charAt(0) == 'L')) {
                guess = input.charAt(0);
                break;
            } else {
                System.out.println("H 또는 L로 입력해주세요!");
            }
        } while (true);
        
        return guess;
    }
    
    /**
     * 게임 메인 루프
     */
    public void playGame() {
        printGameRules();
        
        int totalGames = 0;
        int totalScore = 0;
        
        do {
            System.out.println("\n" + "=".repeat(30));
            System.out.println("게임 " + (totalGames + 1) + " 시작!");
            System.out.println("=".repeat(30));
            
            int score = playOneGame();
            totalGames++;
            totalScore += score;
            
            System.out.println("\n게임 종료! 이번 게임 점수: " + score);
            
            // 다시 플레이할지 묻기
            System.out.print("다시 플레이하시겠습니까? (Y/N): ");
            String playAgain = scanner.nextLine().trim().toUpperCase();
            
            if (!playAgain.equals("Y") && !playAgain.equals("YES")) {
                break;
            }
            
        } while (true);
        
        // 최종 통계
        System.out.println("\n" + "=".repeat(40));
        System.out.println("게임 통계");
        System.out.println("=".repeat(40));
        System.out.println("총 게임 수: " + totalGames);
        System.out.println("총 점수: " + totalScore);
        System.out.printf("평균 점수: %.2f\n", (double) totalScore / totalGames);
        System.out.println("게임을 종료합니다. 감사합니다!");
    }
    
    public static void main(String[] args) {
        HighLowGame game = new HighLowGame();
        game.playGame();
    }
}
```

## 요약

### 핵심 개념

**객체지향 설계 과정**:
1. **문제 분석**: 명사(클래스)와 동사(메서드) 식별
2. **재사용성 고려**: 범용적인 클래스 우선 설계
3. **단계적 구현**: 기본 클래스부터 복잡한 클래스로

**클래스 설계 원칙**:
- **단일 책임**: 각 클래스는 하나의 명확한 개념을 담당
- **불변성**: 데이터 무결성과 안전성 보장
- **캡슐화**: 내부 구현 숨기고 안전한 인터페이스 제공
- **재사용성**: 다양한 상황에서 활용 가능한 설계

**구현된 클래스들**:
- **Card**: 개별 카드의 불변 객체
- **Deck**: 카드 덱 관리 (섞기, 나누기)
- **Hand**: 카드 그룹 관리 (추가, 제거, 정렬)
- **HighLowGame**: 완전한 게임 로직 구현

### 학습 효과

**설계 능력 향상**:
- 실제 문제를 객체로 모델링하는 능력
- 클래스 간 관계와 협력 설계
- 재사용 가능한 구성 요소 개발

**구현 기술 습득**:
- 불변 객체 설계와 구현
- 예외 처리와 유효성 검사
- 컬렉션 활용과 정렬 알고리즘
- 완전한 애플리케이션 개발

💡 **기억하세요**: 좋은 객체지향 설계는 현실 세계의 개념을 자연스럽게 코드로 옮겨, 이해하기 쉽고 유지보수가 용이하며 재사용 가능한 소프트웨어를 만듭니다!