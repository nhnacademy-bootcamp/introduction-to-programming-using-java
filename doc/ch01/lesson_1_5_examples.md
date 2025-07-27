# Lesson 1.5: 예제와 실습 코드

## 1. 개념적 예제 (의사코드)

### 예제 1: 간단한 클래스와 객체
```
// 클래스 정의
CLASS Dog
    // 속성 (데이터)
    name: String
    age: Integer
    breed: String
    
    // 메서드 (동작)
    METHOD bark()
        PRINT "Woof! Woof!"
    END METHOD
    
    METHOD eat(food: String)
        PRINT name + " is eating " + food
    END METHOD
    
    METHOD getInfo()
        RETURN "Name: " + name + ", Age: " + age + ", Breed: " + breed
    END METHOD
END CLASS

// 객체 생성 및 사용
myDog = NEW Dog()
myDog.name = "Buddy"
myDog.age = 3
myDog.breed = "Golden Retriever"

myDog.bark()                    // 출력: Woof! Woof!
myDog.eat("dog food")           // 출력: Buddy is eating dog food
PRINT myDog.getInfo()           // 출력: Name: Buddy, Age: 3, Breed: Golden Retriever
```

### 예제 2: 상속 관계
```
// 부모 클래스
CLASS Animal
    name: String
    age: Integer
    
    METHOD makeSound()
        PRINT "Some generic animal sound"
    END METHOD
    
    METHOD move()
        PRINT name + " is moving"
    END METHOD
END CLASS

// 자식 클래스 1
CLASS Cat EXTENDS Animal
    // Cat은 Animal의 모든 속성과 메서드를 상속받음
    
    // makeSound() 메서드를 재정의 (오버라이딩)
    METHOD makeSound()
        PRINT "Meow!"
    END METHOD
    
    // Cat만의 고유한 메서드
    METHOD scratch()
        PRINT name + " is scratching"
    END METHOD
END CLASS

// 자식 클래스 2
CLASS Bird EXTENDS Animal
    canFly: Boolean
    
    METHOD makeSound()
        PRINT "Tweet tweet!"
    END METHOD
    
    // move() 메서드를 재정의
    METHOD move()
        IF canFly THEN
            PRINT name + " is flying"
        ELSE
            PRINT name + " is walking"
        END IF
    END METHOD
END CLASS

// 객체 생성 및 사용
myCat = NEW Cat()
myCat.name = "Whiskers"
myCat.age = 2
myCat.makeSound()    // 출력: Meow!
myCat.move()         // 출력: Whiskers is moving
myCat.scratch()      // 출력: Whiskers is scratching

myBird = NEW Bird()
myBird.name = "Tweety"
myBird.age = 1
myBird.canFly = true
myBird.makeSound()   // 출력: Tweet tweet!
myBird.move()        // 출력: Tweety is flying
```

### 예제 3: 다형성 (Polymorphism)
```
// 도형 클래스 계층구조
CLASS Shape
    color: String
    
    METHOD draw()
        PRINT "Drawing a shape"
    END METHOD
    
    METHOD getArea()
        RETURN 0  // 기본값
    END METHOD
END CLASS

CLASS Circle EXTENDS Shape
    radius: Number
    
    METHOD draw()
        PRINT "Drawing a circle with radius " + radius
    END METHOD
    
    METHOD getArea()
        RETURN 3.14159 * radius * radius
    END METHOD
END CLASS

CLASS Rectangle EXTENDS Shape
    width: Number
    height: Number
    
    METHOD draw()
        PRINT "Drawing a rectangle " + width + " x " + height
    END METHOD
    
    METHOD getArea()
        RETURN width * height
    END METHOD
END CLASS

// 다형성 활용
shapes = []  // 도형들을 담을 배열

// 다양한 도형 객체 생성
circle1 = NEW Circle()
circle1.radius = 5
circle1.color = "Red"

rectangle1 = NEW Rectangle()
rectangle1.width = 10
rectangle1.height = 20
rectangle1.color = "Blue"

// 배열에 추가
shapes.add(circle1)
shapes.add(rectangle1)

// 모든 도형 그리기 - 다형성!
FOR EACH shape IN shapes DO
    shape.draw()        // 각 객체의 타입에 따라 다른 draw() 메서드 호출
    PRINT "Area: " + shape.getArea()
END FOR

// 출력:
// Drawing a circle with radius 5
// Area: 78.53975
// Drawing a rectangle 10 x 20
// Area: 200
```

### 예제 4: 정보 은닉과 캡슐화
```
CLASS BankAccount
    // Private 데이터 (외부에서 직접 접근 불가)
    PRIVATE accountNumber: String
    PRIVATE balance: Number
    PRIVATE pin: String
    
    // 생성자
    CONSTRUCTOR(accNum: String, initialBalance: Number, pinCode: String)
        accountNumber = accNum
        balance = initialBalance
        pin = pinCode
    END CONSTRUCTOR
    
    // Public 메서드 (인터페이스)
    METHOD deposit(amount: Number)
        IF amount > 0 THEN
            balance = balance + amount
            PRINT "Deposited: $" + amount
            RETURN true
        ELSE
            PRINT "Invalid amount"
            RETURN false
        END IF
    END METHOD
    
    METHOD withdraw(amount: Number, enteredPin: String)
        IF enteredPin != pin THEN
            PRINT "Invalid PIN"
            RETURN false
        END IF
        
        IF amount > 0 AND amount <= balance THEN
            balance = balance - amount
            PRINT "Withdrawn: $" + amount
            RETURN true
        ELSE
            PRINT "Insufficient funds or invalid amount"
            RETURN false
        END IF
    END METHOD
    
    METHOD getBalance(enteredPin: String)
        IF enteredPin == pin THEN
            RETURN balance
        ELSE
            PRINT "Invalid PIN"
            RETURN -1
        END IF
    END METHOD
END CLASS

// 사용 예시
myAccount = NEW BankAccount("123456", 1000, "1234")

// 올바른 사용 (Public 메서드를 통한 접근)
myAccount.deposit(500)                    // 출력: Deposited: $500
myAccount.withdraw(200, "1234")          // 출력: Withdrawn: $200
PRINT myAccount.getBalance("1234")       // 출력: 1300

// 잘못된 PIN
myAccount.withdraw(100, "0000")          // 출력: Invalid PIN

// 직접 접근 시도 (불가능)
// myAccount.balance = 1000000           // 오류! Private 변수에 직접 접근 불가
// PRINT myAccount.pin                   // 오류! Private 변수에 직접 접근 불가
```

### 예제 5: 메시지 전달과 객체 간 상호작용
```
CLASS EmailService
    METHOD sendEmail(to: String, subject: String, body: String)
        PRINT "Sending email to: " + to
        PRINT "Subject: " + subject
        PRINT "Body: " + body
        PRINT "Email sent successfully!"
    END METHOD
END CLASS

CLASS User
    name: String
    email: String
    
    METHOD notifyUser(message: String, emailService: EmailService)
        // 다른 객체에게 메시지 전달
        emailService.sendEmail(
            email,
            "Notification for " + name,
            message
        )
    END METHOD
END CLASS

CLASS ShoppingCart
    items: Array
    user: User
    
    METHOD checkout(emailService: EmailService)
        total = calculateTotal()
        
        // 사용자에게 알림 (객체 간 협력)
        message = "Your order total is $" + total
        user.notifyUser(message, emailService)
    END METHOD
    
    METHOD calculateTotal()
        total = 0
        FOR EACH item IN items DO
            total = total + item.price
        END FOR
        RETURN total
    END METHOD
END CLASS

// 사용 예시
emailService = NEW EmailService()
user = NEW User()
user.name = "John Doe"
user.email = "john@example.com"

cart = NEW ShoppingCart()
cart.user = user
// 아이템 추가 코드 생략...

cart.checkout(emailService)
// 출력:
// Sending email to: john@example.com
// Subject: Notification for John Doe
// Body: Your order total is $XX.XX
// Email sent successfully!
```

## 2. 실세계 모델링 예제

### 예제 6: 도서관 시스템
```
CLASS Book
    isbn: String
    title: String
    author: String
    isAvailable: Boolean = true
    
    METHOD checkOut()
        IF isAvailable THEN
            isAvailable = false
            RETURN true
        ELSE
            RETURN false
        END IF
    END METHOD
    
    METHOD returnBook()
        isAvailable = true
    END METHOD
END CLASS

CLASS Member
    memberId: String
    name: String
    borrowedBooks: Array = []
    maxBooks: Integer = 3
    
    METHOD borrowBook(book: Book)
        IF borrowedBooks.length >= maxBooks THEN
            PRINT "Cannot borrow more than " + maxBooks + " books"
            RETURN false
        END IF
        
        IF book.checkOut() THEN
            borrowedBooks.add(book)
            PRINT name + " borrowed: " + book.title
            RETURN true
        ELSE
            PRINT "Book is not available"
            RETURN false
        END IF
    END METHOD
    
    METHOD returnBook(book: Book)
        IF borrowedBooks.contains(book) THEN
            borrowedBooks.remove(book)
            book.returnBook()
            PRINT name + " returned: " + book.title
            RETURN true
        ELSE
            PRINT "This book was not borrowed by " + name
            RETURN false
        END IF
    END METHOD
END CLASS

CLASS Library
    books: Array = []
    members: Array = []
    
    METHOD addBook(book: Book)
        books.add(book)
        PRINT "Added book: " + book.title
    END METHOD
    
    METHOD registerMember(member: Member)
        members.add(member)
        PRINT "Registered member: " + member.name
    END METHOD
    
    METHOD findAvailableBooks()
        availableBooks = []
        FOR EACH book IN books DO
            IF book.isAvailable THEN
                availableBooks.add(book)
            END IF
        END FOR
        RETURN availableBooks
    END METHOD
END CLASS

// 사용 예시
library = NEW Library()

// 책 추가
book1 = NEW Book()
book1.isbn = "978-1234567890"
book1.title = "Introduction to Programming"
book1.author = "John Smith"

book2 = NEW Book()
book2.isbn = "978-0987654321"
book2.title = "Data Structures"
book2.author = "Jane Doe"

library.addBook(book1)
library.addBook(book2)

// 회원 등록
member1 = NEW Member()
member1.memberId = "M001"
member1.name = "Alice"

library.registerMember(member1)

// 책 대출
member1.borrowBook(book1)  // 출력: Alice borrowed: Introduction to Programming
member1.borrowBook(book2)  // 출력: Alice borrowed: Data Structures

// 이용 가능한 책 확인
availableBooks = library.findAvailableBooks()
PRINT "Available books: " + availableBooks.length  // 출력: Available books: 0

// 책 반납
member1.returnBook(book1)  // 출력: Alice returned: Introduction to Programming
```

## 3. 핵심 개념 정리

### 객체 지향의 4대 원칙
1. **캡슐화 (Encapsulation)**: 데이터와 메서드를 하나로 묶고, 정보를 숨김
2. **상속 (Inheritance)**: 기존 클래스의 속성과 메서드를 물려받아 재사용
3. **다형성 (Polymorphism)**: 같은 인터페이스로 다른 구현을 제공
4. **추상화 (Abstraction)**: 복잡한 구현을 숨기고 필요한 부분만 노출

### 실습 과제
1. 위의 예제들을 참고하여 자신만의 클래스를 설계해보세요
2. 최소 2개 이상의 클래스가 상호작용하는 시스템을 만들어보세요
3. 상속 관계를 포함하여 설계해보세요
4. 정보 은닉을 적용하여 안전한 클래스를 만들어보세요