# 5.5 상속, 다형성, 추상 클래스 - 수업 실습

## 1. 상속의 기본 실습

### 실습 1-1: 기본 상속 구조 만들기
**목표**: 상속의 기본 개념을 이해하고 구현해보세요.

```java
/**
 * 상속의 기본 개념을 보여주는 예제
 */
// 부모 클래스
public class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        // TODO 1: name과 age 초기화하기
    }
    
    public void introduce() {
        // TODO 2: "안녕하세요, 저는 [이름]이고, [나이]살입니다." 출력하기
    }
    
    public void sleep() {
        // TODO 3: "[이름]이(가) 잠을 잡니다." 출력하기
    }
}

// 자식 클래스 1
public class Student extends Person {
    private String school;
    private int grade;
    
    public Student(String name, int age, String school, int grade) {
        // TODO 4: 부모 생성자 호출하고 school, grade 초기화하기
        // super() 사용
    }
    
    // 메서드 오버라이딩
    @Override
    public void introduce() {
        // TODO 5: 부모의 introduce() 호출 후 추가 정보 출력하기
        // super.introduce() 사용
        // "저는 [학교] [학년]학년입니다." 추가 출력
    }
    
    // 새로운 메서드 추가
    public void study() {
        // TODO 6: "[이름]이(가) 공부를 합니다." 출력하기
    }
}

// 자식 클래스 2
public class Teacher extends Person {
    private String subject;
    private int experience;
    
    public Teacher(String name, int age, String subject, int experience) {
        // TODO 7: 부모 생성자 호출하고 subject, experience 초기화하기
    }
    
    @Override
    public void introduce() {
        // TODO 8: 부모의 introduce() 호출 후 추가 정보 출력하기
        // "저는 [과목] 과목을 [경력]년간 가르쳤습니다." 추가 출력
    }
    
    public void teach() {
        // TODO 9: "[이름] 선생님이 [과목]을(를) 가르칩니다." 출력하기
    }
}

// 테스트 클래스
public class InheritanceExample {
    public static void main(String[] args) {
        // TODO 10: Person, Student, Teacher 객체 생성하기
        // Person: "김철수", 30
        // Student: "이영희", 16, "한국고등학교", 2
        // Teacher: "박교사", 45, "수학", 20
        
        // TODO 11: 각자 소개하기
        // 각 객체의 introduce() 메서드 호출
        
        // TODO 12: 공통 행동 실행하기
        // 모든 객체의 sleep() 메서드 호출
        
        // TODO 13: 특수 행동 실행하기
        // student.study()와 teacher.teach() 호출
    }
}
```

#### 실행 결과 (참고용):
```
=== 각자 소개하기 ===
안녕하세요, 저는 김철수이고, 30살입니다.

안녕하세요, 저는 이영희이고, 16살입니다.
저는 한국고등학교 2학년입니다.

안녕하세요, 저는 박교사이고, 45살입니다.
저는 수학 과목을 20년간 가르쳤습니다.

=== 공통 행동 ===
김철수이(가) 잠을 잡니다.
이영희이(가) 잠을 잡니다.
박교사이(가) 잠을 잡니다.

=== 특수 행동 ===
이영희이(가) 공부를 합니다.
박교사 선생님이 수학을(를) 가르칩니다.
```

### 실습 1-2: protected 접근 제어자 활용
**목표**: protected 접근 제어자의 활용법을 익혀보세요.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * protected 접근 제어자의 활용을 보여주는 예제
 */
public class BankAccount {
    private String accountNumber;
    protected double balance;  // 서브클래스에서 접근 가능
    protected List<String> transactionHistory;
    
    public BankAccount(String accountNumber, double initialBalance) {
        // TODO 14: 필드 초기화하기
        // accountNumber, balance 초기화
        // transactionHistory를 새 ArrayList로 초기화
        // addTransaction()으로 "계좌 개설: [초기잔액]원" 추가
    }
    
    public void deposit(double amount) {
        // TODO 15: 입금 기능 구현하기
        // amount > 0일 때만 처리
        // balance에 amount 추가
        // addTransaction()으로 "입금: [금액]원" 추가
    }
    
    public void withdraw(double amount) {
        // TODO 16: 출금 기능 구현하기
        // amount > 0이고 amount <= balance일 때만 처리
        // balance에서 amount 차감
        // addTransaction()으로 "출금: [금액]원" 추가
    }
    
    protected void addTransaction(String transaction) {
        // TODO 17: 거래 내역 추가하기
        // transactionHistory에 현재 시간과 transaction 추가
        // 형식: "날짜시간 - 거래내용"
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void printTransactionHistory() {
        // TODO 18: 거래 내역 출력하기
        // "=== 거래 내역 ===" 출력
        // transactionHistory의 모든 항목 출력
    }
}

// 프리미엄 계좌 - 특별 기능 추가
public class PremiumAccount extends BankAccount {
    private double creditLimit;
    private double interestRate;
    
    public PremiumAccount(String accountNumber, double initialBalance, 
                         double creditLimit, double interestRate) {
        // TODO 19: 부모 생성자 호출하고 추가 필드 초기화하기
    }
    
    // 오버라이딩: 마이너스 통장 기능
    @Override
    public void withdraw(double amount) {
        // TODO 20: 신용 한도를 포함한 출금 기능 구현하기
        // amount > 0이고 amount <= balance + creditLimit일 때 처리
        // balance -= amount (protected이므로 직접 접근 가능)
        // addTransaction()으로 "출금: [금액]원 (잔액: [잔액]원)" 추가
        // balance < 0이면 "신용 한도 사용 중: [사용금액]원" 추가
        // 한도 초과 시 "출금 한도 초과!" 출력
    }
    
    // 새로운 기능: 이자 지급
    public void applyInterest() {
        // TODO 21: 이자 지급 기능 구현하기
        // balance > 0일 때만 처리
        // 이자 = balance * (interestRate / 100)
        // balance에 이자 추가
        // addTransaction()으로 "이자 지급: [이자]원" 추가
    }
    
    // 새로운 기능: VIP 혜택
    public void applyVIPBenefit() {
        // TODO 22: VIP 혜택금 지급하기
        // 혜택금 10000원을 balance에 추가
        // addTransaction()으로 "VIP 혜택금 지급: 10000원" 추가
    }
}

// 테스트
public class BankAccountTest {
    public static void main(String[] args) {
        // TODO 23: 일반 계좌와 프리미엄 계좌 생성하기
        // 일반 계좌: "1234", 100000원
        // 프리미엄 계좌: "5678", 100000원, 신용한도 50000, 이자율 2.5%
        
        // TODO 24: 일반 계좌 테스트하기
        // 50000원 입금, 30000원 출금, 200000원 출금 시도
        // 잔액 출력
        
        // TODO 25: 프리미엄 계좌 테스트하기
        // 50000원 입금, 170000원 출금(신용한도 사용)
        // 이자 지급, VIP 혜택 적용
        // 잔액 출력
        
        // TODO 26: 프리미엄 계좌 거래 내역 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
=== 일반 계좌 테스트 ===
잔액: 120000.0

=== 프리미엄 계좌 테스트 ===
출금 한도 초과!
잔액: -10000.0

=== 거래 내역 ===
Sun Nov 17 10:30:45 KST 2024 - 계좌 개설: 100000.0원
Sun Nov 17 10:30:45 KST 2024 - 입금: 50000.0원
Sun Nov 17 10:30:45 KST 2024 - 출금: 170000.0원 (잔액: -20000.0원)
Sun Nov 17 10:30:45 KST 2024 - 신용 한도 사용 중: 20000.0원
Sun Nov 17 10:30:45 KST 2024 - VIP 혜택금 지급: 10000원
```

## 2. 추상 클래스와 다형성 실습

### 실습 2-1: 동물 계층 구조 만들기
**목표**: 추상 클래스를 사용한 복잡한 계층 구조를 구현해보세요.

```java
/**
 * 복잡한 클래스 계층 구조를 보여주는 예제
 */
// 최상위 추상 클래스
public abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;
    
    public Animal(String name, int age, double weight) {
        // TODO 27: 필드 초기화하기
    }
    
    // 추상 메서드
    public abstract void makeSound();
    public abstract void move();
    public abstract String getHabitat();
    
    // 구체 메서드
    public void eat() {
        // TODO 28: "[이름]이(가) 먹이를 먹습니다." 출력하기
    }
    
    public void sleep() {
        // TODO 29: "[이름]이(가) 잠을 잡니다." 출력하기
    }
    
    @Override
    public String toString() {
        // TODO 30: "[이름] (나이: [나이], 체중: [체중]kg)" 형식으로 반환하기
        return "";
    }
}

// 포유류 추상 클래스
public abstract class Mammal extends Animal {
    protected boolean hasFur;
    
    public Mammal(String name, int age, double weight, boolean hasFur) {
        // TODO 31: 부모 생성자 호출하고 hasFur 초기화하기
    }
    
    public void nurse() {
        // TODO 32: "[이름]이(가) 새끼에게 젖을 먹입니다." 출력하기
    }
}

// 조류 추상 클래스
public abstract class Bird extends Animal {
    protected double wingspan;
    protected boolean canFly;
    
    public Bird(String name, int age, double weight, double wingspan, boolean canFly) {
        // TODO 33: 부모 생성자 호출하고 wingspan, canFly 초기화하기
    }
    
    public void layEggs() {
        // TODO 34: "[이름]이(가) 알을 낳습니다." 출력하기
    }
}

// 구체적인 동물 클래스들
public class Dog extends Mammal {
    private String breed;
    
    public Dog(String name, int age, double weight, String breed) {
        // TODO 35: 부모 생성자 호출(hasFur는 true)하고 breed 초기화하기
    }
    
    @Override
    public void makeSound() {
        // TODO 36: "멍멍!" 출력하기
    }
    
    @Override
    public void move() {
        // TODO 37: "[이름]이(가) 네 발로 뛰어다닙니다." 출력하기
    }
    
    @Override
    public String getHabitat() {
        // TODO 38: "인간과 함께 사는 집" 반환하기
        return "";
    }
    
    public void wagTail() {
        // TODO 39: "[이름]이(가) 꼬리를 흔듭니다." 출력하기
    }
}

public class Eagle extends Bird {
    private double huntingRange;
    
    public Eagle(String name, int age, double weight, double wingspan, double huntingRange) {
        // TODO 40: 부모 생성자 호출(canFly는 true)하고 huntingRange 초기화하기
    }
    
    @Override
    public void makeSound() {
        // TODO 41: "끼이익!" 출력하기
    }
    
    @Override
    public void move() {
        // TODO 42: "[이름]이(가) 하늘을 날아다닙니다." 출력하기
    }
    
    @Override
    public String getHabitat() {
        // TODO 43: "높은 산의 절벽" 반환하기
        return "";
    }
    
    public void hunt() {
        // TODO 44: "[이름]이(가) 사냥을 합니다. 사냥 범위: [사냥범위]km" 출력하기
    }
}

// 동물원 관리 시스템
public class Zoo {
    private List<Animal> animals;
    private String name;
    
    public Zoo(String name) {
        // TODO 45: name 초기화하고 animals를 새 ArrayList로 초기화하기
    }
    
    public void addAnimal(Animal animal) {
        // TODO 46: animals에 animal 추가하고
        // "[동물이름]이(가) [동물원이름]에 추가되었습니다." 출력하기
    }
    
    public void feedAllAnimals() {
        // TODO 47: 모든 동물에게 먹이 주기
        // "=== 모든 동물에게 먹이 주기 ===" 출력
        // 모든 동물의 eat() 메서드 호출
    }
    
    public void makeAllSounds() {
        // TODO 48: 모든 동물의 소리 듣기
        // "=== 동물들의 소리 ===" 출력
        // 각 동물에 대해 "[이름]: " 출력 후 makeSound() 호출
    }
    
    public void performSpecialActions() {
        // TODO 49: 특별한 행동들 수행하기
        // "=== 특별한 행동들 ===" 출력
        // Dog이면 wagTail(), Eagle이면 hunt() 호출
        // instanceof 사용
    }
}

// 테스트
public class ZooTest {
    public static void main(String[] args) {
        // TODO 50: 동물원 생성하고 동물들 추가하기
        // Zoo: "행복한 동물원"
        // Dog: "바둑이", 5, 15.5, "진돗개"
        // Eagle: "독수리", 7, 6.8, 2.1, 50
        
        // TODO 51: 동물원 운영하기
        // feedAllAnimals(), makeAllSounds(), performSpecialActions() 호출
    }
}
```

#### 실행 결과 (참고용):
```
바둑이이(가) 행복한 동물원에 추가되었습니다.
독수리이(가) 행복한 동물원에 추가되었습니다.

=== 모든 동물에게 먹이 주기 ===
바둑이이(가) 먹이를 먹습니다.
독수리이(가) 먹이를 먹습니다.

=== 동물들의 소리 ===
바둑이: 멍멍!
독수리: 끼이익!

=== 특별한 행동들 ===
바둑이이(가) 꼬리를 흔듭니다.
독수리이(가) 사냥을 합니다. 사냥 범위: 50.0km
```

## 3. 다형성 활용 실습

### 실습 3-1: 게임 캐릭터 시스템
**목표**: 다형성을 활용한 게임 캐릭터 시스템을 구현해보세요.

```java
/**
 * 다형성을 활용한 게임 캐릭터 시스템
 */
public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int level;
    protected int attackPower;
    
    public GameCharacter(String name, int maxHealth, int attackPower) {
        // TODO 52: 필드 초기화하기
        // name, maxHealth, attackPower 초기화
        // health = maxHealth, level = 1로 설정
    }
    
    // 추상 메서드들
    public abstract void attack(GameCharacter target);
    public abstract void useSpecialSkill(GameCharacter target);
    public abstract String getClassName();
    
    // 공통 메서드들
    public void takeDamage(int damage) {
        // TODO 53: 피해 입기 구현하기
        // health에서 damage 차감 (0 미만이면 0으로)
        // "[이름]이(가) [피해]의 피해를 입었습니다! (남은 체력: [체력])" 출력
        // health가 0이면 "[이름]이(가) 쓰러졌습니다!" 추가 출력
    }
    
    public void heal(int amount) {
        // TODO 54: 체력 회복 구현하기
        // health에 amount 추가 (maxHealth 초과 시 maxHealth로)
        // "[이름]이(가) [회복량]의 체력을 회복했습니다! (현재 체력: [체력])" 출력
    }
    
    public boolean isAlive() {
        // TODO 55: 생존 여부 반환하기
        return false;
    }
    
    @Override
    public String toString() {
        // TODO 56: 캐릭터 정보 문자열 반환하기
        // "[이름] (Lv.[레벨] [직업]) - HP: [현재체력]/[최대체력], 공격력: [공격력]"
        return "";
    }
}

// 전사 클래스
public class Warrior extends GameCharacter {
    private int armor;
    
    public Warrior(String name) {
        // TODO 57: 부모 생성자 호출하기
        // maxHealth: 150, attackPower: 20
        // armor = 10으로 초기화
    }
    
    @Override
    public void attack(GameCharacter target) {
        // TODO 58: 기본 공격 구현하기
        // "[이름]이(가) [대상이름]을(를) 검으로 공격합니다!" 출력
        // target.takeDamage(attackPower) 호출
    }
    
    @Override
    public void useSpecialSkill(GameCharacter target) {
        // TODO 59: 특수 스킬 구현하기
        // "[이름]이(가) 광폭화를 사용합니다!" 출력
        // specialDamage = attackPower * 2
        // target.takeDamage(specialDamage) 호출
    }
    
    @Override
    public void takeDamage(int damage) {
        // TODO 60: 방어구 효과 적용하여 피해 입기
        // reducedDamage = damage - armor (최소 0)
        // "[이름]의 방어구가 [감소량]의 피해를 막았습니다!" 출력
        // super.takeDamage(reducedDamage) 호출
    }
    
    @Override
    public String getClassName() {
        // TODO 61: "전사" 반환하기
        return "";
    }
}

// 마법사 클래스
public class Mage extends GameCharacter {
    private int mana;
    private int maxMana;
    
    public Mage(String name) {
        // TODO 62: 부모 생성자 호출하기
        // maxHealth: 80, attackPower: 15
        // maxMana = 100, mana = maxMana로 초기화
    }
    
    @Override
    public void attack(GameCharacter target) {
        // TODO 63: 마법 공격 구현하기
        // mana >= 10이면:
        //   "[이름]이(가) [대상이름]에게 파이어볼을 시전합니다!" 출력
        //   target.takeDamage(attackPower + 10) 호출
        //   mana -= 10
        // 아니면:
        //   "[이름]의 마나가 부족합니다! 기본 공격을 합니다." 출력
        //   target.takeDamage(attackPower) 호출
    }
    
    @Override
    public void useSpecialSkill(GameCharacter target) {
        // TODO 64: 메테오 스킬 구현하기
        // mana >= 30이면:
        //   "[이름]이(가) 메테오를 시전합니다!" 출력
        //   specialDamage = attackPower * 3
        //   target.takeDamage(specialDamage) 호출
        //   mana -= 30
        // 아니면:
        //   "마나가 부족합니다!" 출력
    }
    
    @Override
    public String getClassName() {
        // TODO 65: "마법사" 반환하기
        return "";
    }
}

// 간단한 전투 테스트
public class BattleTest {
    public static void main(String[] args) {
        // TODO 66: 전사와 마법사 생성하기
        // Warrior: "아서"
        // Mage: "멀린"
        
        // TODO 67: 캐릭터 정보 출력하기
        // 두 캐릭터의 toString() 결과 출력
        
        // TODO 68: 전투 시뮬레이션하기
        // 전사가 마법사를 공격
        // 마법사가 전사를 공격
        // 전사가 특수 스킬 사용
        // 마법사가 특수 스킬 사용
        
        // TODO 69: 최종 상태 출력하기
        // 두 캐릭터의 생존 여부와 현재 정보 출력
    }
}
```

#### 실행 결과 (참고용):
```
=== 초기 상태 ===
아서 (Lv.1 전사) - HP: 150/150, 공격력: 20
멀린 (Lv.1 마법사) - HP: 80/80, 공격력: 15

=== 전투 시작 ===
아서이(가) 멀린을(를) 검으로 공격합니다!
멀린이(가) 20의 피해를 입었습니다! (남은 체력: 60)

멀린이(가) 아서에게 파이어볼을 시전합니다!
아서의 방어구가 10의 피해를 막았습니다!
아서이(가) 15의 피해를 입었습니다! (남은 체력: 135)

아서이(가) 광폭화를 사용합니다!
멀린이(가) 40의 피해를 입었습니다! (남은 체력: 20)

멀린이(가) 메테오를 시전합니다!
아서의 방어구가 10의 피해를 막았습니다!
아서이(가) 35의 피해를 입었습니다! (남은 체력: 100)

=== 최종 상태 ===
아서: 생존 - 아서 (Lv.1 전사) - HP: 100/150, 공격력: 20
멀린: 생존 - 멀린 (Lv.1 마법사) - HP: 20/80, 공격력: 15
```

## 4. 종합 실습: 직원 관리 시스템

### 실습 4-1: 직원 관리 시스템 구현
**목표**: 상속, 다형성, 추상 클래스를 모두 활용한 시스템을 구현해보세요.

```java
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * 종합적인 직원 관리 시스템
 */
public abstract class Employee {
    protected String id;
    protected String name;
    protected String department;
    protected LocalDate hireDate;
    
    public Employee(String id, String name, String department) {
        // TODO 70: 필드 초기화하기
        // id, name, department 초기화
        // hireDate는 LocalDate.now()로 설정
    }
    
    // 추상 메서드
    public abstract double calculateMonthlySalary();
    public abstract String getPosition();
    
    // 공통 메서드
    public int getYearsOfService() {
        // TODO 71: 근속 연수 계산하기
        // Period.between(hireDate, LocalDate.now()).getYears() 반환
        return 0;
    }
    
    @Override
    public String toString() {
        // TODO 72: 직원 정보 문자열 반환하기
        // "[이름] ([ID]) - [직급], [부서]부서, 연차: [근속년수]년"
        return "";
    }
}

// 정규직 직원
public class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected double bonus;
    
    public FullTimeEmployee(String id, String name, String department, double baseSalary) {
        // TODO 73: 부모 생성자 호출하고 필드 초기화하기
        // baseSalary 초기화, bonus = 0
    }
    
    @Override
    public double calculateMonthlySalary() {
        // TODO 74: 월급 계산하기
        // baseSalary + bonus 반환
        return 0;
    }
    
    @Override
    public String getPosition() {
        // TODO 75: "정규직" 반환하기
        return "";
    }
    
    public void setBonus(double bonus) {
        // TODO 76: 보너스 설정하기
    }
}

// 계약직 직원
public class ContractEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    
    public ContractEmployee(String id, String name, String department, double hourlyRate) {
        // TODO 77: 부모 생성자 호출하고 필드 초기화하기
        // hourlyRate 초기화, hoursWorked = 0
    }
    
    @Override
    public double calculateMonthlySalary() {
        // TODO 78: 월급 계산하기
        // hourlyRate * hoursWorked 반환
        return 0;
    }
    
    @Override
    public String getPosition() {
        // TODO 79: "계약직" 반환하기
        return "";
    }
    
    public void setHoursWorked(int hours) {
        // TODO 80: 근무 시간 설정하기
    }
}

// 직원 관리 시스템
public class EmployeeManagementSystem {
    private Map<String, Employee> employees;
    
    public EmployeeManagementSystem() {
        // TODO 81: employees를 새 HashMap으로 초기화하기
    }
    
    public void addEmployee(Employee employee) {
        // TODO 82: 직원 추가하기
        // employees Map에 employee.id를 키로 하여 추가
        // "직원 추가: [직원정보]" 출력
    }
    
    public double calculateTotalMonthlySalary() {
        // TODO 83: 전체 월급 총액 계산하기
        // 모든 직원의 calculateMonthlySalary() 합계 반환
        return 0;
    }
    
    public void displaySalaryReport() {
        // TODO 84: 급여 보고서 출력하기
        // "=== 급여 보고서 ===" 출력
        // 각 직원에 대해:
        //   "[이름] ([직급]): [월급]원" 출력
        // "전체 월 급여 총액: [총액]원" 출력
    }
}

// 테스트
public class CompanyTest {
    public static void main(String[] args) {
        // TODO 85: 직원 관리 시스템 생성하기
        
        // TODO 86: 다양한 직원 추가하기
        // 정규직: "E001", "김철수", "개발부", 3000000원
        // 계약직: "E002", "이영희", "디자인부", 50000원(시급)
        
        // TODO 87: 보너스와 근무시간 설정하기
        // 김철수 보너스: 500000원
        // 이영희 근무시간: 160시간
        
        // TODO 88: 급여 보고서 출력하기
    }
}
```

#### 실행 결과 (참고용):
```
직원 추가: 김철수 (E001) - 정규직, 개발부부서, 연차: 0년
직원 추가: 이영희 (E002) - 계약직, 디자인부부서, 연차: 0년

=== 급여 보고서 ===
김철수 (정규직): 3500000.0원
이영희 (계약직): 8000000.0원
전체 월 급여 총액: 11500000.0원
```

## 학습 포인트

### 1. 상속 (Inheritance)
- **코드 재사용**: 부모 클래스의 필드와 메서드를 자식 클래스가 물려받음
- **확장성**: 자식 클래스에서 새로운 기능 추가 가능
- **super 키워드**: 부모 클래스의 생성자나 메서드 호출

### 2. 다형성 (Polymorphism)
- **메서드 오버라이딩**: 부모 클래스의 메서드를 자식 클래스에서 재정의
- **타입 호환성**: 부모 타입 변수로 자식 객체 참조 가능
- **동적 바인딩**: 실행 시점에 실제 객체의 메서드 호출

### 3. 추상 클래스 (Abstract Classes)
- **추상 메서드**: 구현 없이 선언만 있는 메서드
- **구체 메서드**: 추상 클래스에도 일반 메서드 포함 가능
- **템플릿 역할**: 공통 구조를 정의하고 세부 구현은 자식에게 위임

### 4. 접근 제어자
- **protected**: 같은 패키지 또는 자식 클래스에서 접근 가능
- **캡슐화와 상속의 균형**: 필요한 만큼만 접근 허용

객체지향 프로그래밍의 핵심 개념들을 실습을 통해 체득해보세요!