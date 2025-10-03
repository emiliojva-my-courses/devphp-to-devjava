# Java Learning Dojo: From Zero to Spring

Welcome to your Java learning journey! This guide will help you build a strong foundation in Java before moving on to Spring Boot. Each section includes explanations, examples, and exercises to reinforce your understanding.

---

## 1. Variables and Types

**Concept:** Variables store data. Java has several types: `int` (integer), `double` (decimal), `boolean` (true/false), and `String` (text).

**Example:**
```java
int age = 25;
double price = 19.99;
boolean isActive = true;
String name = "Ana";
System.out.println(name + " is " + age + " years old.");
```

**Exercise:**
- Declare variables of types `int`, `double`, `boolean`, and `String`. Assign values and print them.

---

## 2. Control Structures

**Concept:** Control structures let you make decisions and repeat actions. Common ones are `if`, `for`, and `for-each`.

**Example:**
```java
int idade = 17;
if (idade >= 18) {
    System.out.println("Maior de idade");
} else {
    System.out.println("Menor de idade");
}

for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

List<String> nomes = List.of("Ana", "João", "Maria");
for (String nome : nomes) {
    System.out.println(nome);
}
```

**Exercises:**
- Write a program that checks if a person is of legal age (`idade >= 18`). Print "Maior de idade" or "Menor de idade".
- Create a for loop that prints numbers from 0 to 9.
- Use a for-each loop to print all names in a `List<String>`.

---

## 3. Classes and Objects

**Concept:** Classes define blueprints for objects. Objects are instances of classes. Use access modifiers (`private`, `public`) for encapsulation.

**Example:**
```java
public class User {
    private String name;
    private List<String> emails;

    public User(String name) {
        this.name = name;
        this.emails = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<String> getEmails() { return emails; }

    public void addEmail(String email) {
        if (email.contains("@")) {
            emails.add(email);
        }
    }
}
```

**Exercises:**
- Create a `User` class with private attributes `name` and `emails` (`List<String>`). Add a constructor and getter methods.
- Add a method `addEmail(String email)` that only adds valid emails (must contain `@`).
- Instantiate a `User`, set the name, add two emails, and print the user's name and emails.

---

## 4. Collections and Streams

**Concept:** Collections store groups of data. Streams let you process collections efficiently.

**Example:**
```java
List<String> names = List.of("Ana", "João", "Amanda", "Carlos");
names.stream()
    .filter(name -> name.startsWith("A"))
    .sorted()
    .forEach(System.out::println);
```

**Exercise:**
- Create a `List<String>` with several names. Use the Stream API to filter names starting with "A" and print them sorted.

---

## 5. Java Concepts

**Encapsulation and Access Modifiers:**
- Use `private`, `public`, `protected` to control visibility of class members.

**Immutability with Records:**
- Use `record` (Java 16+) for immutable data structures.
```java
public record UserDTO(Long id, String name) {}
```

**Exception Handling:**
- Use `try-catch` blocks to handle errors gracefully.
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
```

**Lambda Expressions and Functional Interfaces:**
- Use lambdas for concise code, especially with collections.
```java
List<String> names = List.of("Ana", "João");
names.forEach(name -> System.out.println(name));
```

**Dependency Injection in Spring:**
- Use `@Autowired` and `@Service` for object management in Spring Boot.
```java
@Service
public class EmailService {
    public void send(String to, String message) { /* ... */ }
}

@RestController
public class UserController {
    @Autowired
    private EmailService emailService;
}
```

---

**Next Steps:**
Complete these exercises in pure Java before moving to Spring Boot. Practice each concept and try to build small projects to reinforce your learning.

--- 

**Exercises**

Certainly! Here are practical exercises focused only on the selected topics (Java legacy.fundamentals, control structures, classes, objects, collections):

---

### 1. Variables and Types
- **Exercise:** Declare variables of types `int`, `double`, `boolean`, and `String`. Assign values and print them.

### 2. Control Structures
- **Exercise:** Write a program that checks if a person is of legal age (`idade >= 18`). Print "Maior de idade" or "Menor de idade".
- **Exercise:** Create a `for` loop that prints numbers from 0 to 9.
- **Exercise:** Use a `for-each` loop to print all names in a `List<String>`.

### 3. Classes and Objects
- **Exercise:** Create a `User` class with private attributes `name` and `emails` (`List<String>`). Add a constructor and getter methods.
- **Exercise:** Add a method `addEmail(String email)` that only adds valid emails (must contain `@`).
- **Exercise:** Instantiate a `User`, set the name, add two emails, and print the user's name and emails.

### 4. Collections and Streams
- **Exercise:** Create a `List<String>` with several names. Use the Stream API to filter names starting with "A" and print them sorted.

---

Complete these exercises in pure Java before moving to Spring Boot.