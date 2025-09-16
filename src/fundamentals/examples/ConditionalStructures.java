package fundamentals.examples;

/**
 * Exercise 4: Conditional Structures in Java
 * 
 * Objectives:
 * - Master if/else statements (simple and nested)
 * - Understand switch statements for multiple conditions
 * - Apply logical operators (&&, ||, !)
 * - Implement data validation and decision making
 * 
 * Concepts Applied:
 * - if/else (simple, nested, else if)
 * - switch statement with break
 * - Logical operators: && (AND), || (OR), ! (NOT)
 * - Comparison operators: ==, !=, <, >, <=, >=
 * - Ternary operator (condition ? true : false)
 * 
 * PHP/Laravel Equivalent:
 * - Similar syntax but PHP uses elseif (one word) vs else if (two words)
 * - PHP switch doesn't require break for each case (but recommended)
 * - PHP has loose typing, Java requires exact type matching
 */
public class ConditionalStructures {

    public static void main(String[] args) {
        
        System.out.println("===============================");
        System.out.println("Exercise 4: Conditional Structures");
        System.out.println("===============================");
        System.out.println();

        // ========================================
        // 1. SIMPLE IF/ELSE - Age Classification
        // ========================================
        System.out.println("=== 1. Age Classification System ===");
        
        int ageMateus = 5;
        int ageBernardo = 3;
        int myAge = 35;
        
        // Simple if/else
        if (ageMateus > ageBernardo) {
            System.out.println("Mateus (" + ageMateus + ") is older than Bernardo (" + ageBernardo + ")");
        } else {
            System.out.println("Bernardo is older than or same age as Mateus");
        }
        
        // Multiple conditions with else if
        if (myAge < 18) {
            System.out.println("I am a minor");
        } else if (myAge < 30) {
            System.out.println("I am a young adult");
        } else if (myAge < 60) {
            System.out.println("I am an adult");
        } else {
            System.out.println("I am a senior");
        }
        
        System.out.println();
        
        // ========================================
        // 2. LOGICAL OPERATORS
        // ========================================
        System.out.println("=== 2. Logical Operators Examples ===");
        
        boolean isWeekend = true;
        boolean hasHomework = false;
        boolean isRaining = true;
        
        // AND operator (&&) - Both conditions must be true
        if (isWeekend && !hasHomework) {
            System.out.println("Perfect! Weekend and no homework - time to play!");
        }
        
        // OR operator (||) - At least one condition must be true
        if (isRaining || isWeekend) {
            System.out.println("Good day to stay home (raining or weekend)");
        }
        
        // NOT operator (!) - Inverts the boolean value
        if (!hasHomework) {
            System.out.println("No homework today! 🎉");
        }
        
        // Complex logical expression
        if ((isWeekend || !hasHomework) && !isRaining) {
            System.out.println("Great day to go to the park!");
        } else {
            System.out.println("Better to stay home today");
        }
        
        System.out.println();
        
        // ========================================
        // 3. NESTED IF/ELSE - Grade System
        // ========================================
        System.out.println("=== 3. Nested Conditions - Grade System ===");
        
        double mathGrade = 8.5;
        double portugueseGrade = 7.0;
        double averageGrade = (mathGrade + portugueseGrade) / 2;
        
        System.out.println("Math grade: " + mathGrade);
        System.out.println("Portuguese grade: " + portugueseGrade);
        System.out.println("Average: " + averageGrade);
        
        if (averageGrade >= 7.0) {
            System.out.println("✅ APPROVED!");
            
            if (averageGrade >= 9.0) {
                System.out.println("🏆 Excellent performance!");
            } else if (averageGrade >= 8.0) {
                System.out.println("⭐ Very good performance!");
            } else {
                System.out.println("👍 Good performance!");
            }
            
        } else {
            System.out.println("❌ FAILED");
            
            if (averageGrade >= 5.0) {
                System.out.println("📚 You can take a make-up exam");
            } else {
                System.out.println("📖 You need to repeat the course");
            }
        }
        
        System.out.println();
        
        // ========================================
        // 4. SWITCH STATEMENT - Menu Calculator
        // ========================================
        System.out.println("=== 4. Switch Statement - Simple Calculator ===");
        
        int number1 = 10;
        int number2 = 3;
        char operation = '+'; // Options: +, -, *, /, %
        
        System.out.println("Calculating: " + number1 + " " + operation + " " + number2);
        
        switch (operation) {
            case '+':
                int sum = number1 + number2;
                System.out.println("Result: " + sum);
                break;
                
            case '-':
                int subtraction = number1 - number2;
                System.out.println("Result: " + subtraction);
                break;
                
            case '*':
                int multiplication = number1 * number2;
                System.out.println("Result: " + multiplication);
                break;
                
            case '/':
                if (number2 != 0) {
                    double division = (double) number1 / number2;
                    System.out.println("Result: " + division);
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
                
            case '%':
                if (number2 != 0) {
                    int remainder = number1 % number2;
                    System.out.println("Result: " + remainder);
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
                
            default:
                System.out.println("Error: Unknown operation '" + operation + "'");
                System.out.println("Supported operations: +, -, *, /, %");
        }
        
        System.out.println();
        
        // ========================================
        // 5. SWITCH WITH MULTIPLE CASES - Day Type
        // ========================================
        System.out.println("=== 5. Switch Multiple Cases - Day Classification ===");
        
        int dayOfWeek = 6; // 1=Monday, 2=Tuesday, ..., 7=Sunday
        
        System.out.println("Day number: " + dayOfWeek);
        
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("It's a weekday - work/school day");
                System.out.println("⏰ Wake up early!");
                break;
                
            case 6:
            case 7:
                System.out.println("It's weekend - rest day");
                System.out.println("😴 Sleep in and relax!");
                break;
                
            default:
                System.out.println("Invalid day number! Use 1-7");
        }
        
        System.out.println();
        
        // ========================================
        // 6. TERNARY OPERATOR - Quick Decisions
        // ========================================
        System.out.println("=== 6. Ternary Operator Examples ===");
        
        int temperature = 25;
        
        // Ternary operator: condition ? valueIfTrue : valueIfFalse
        String weather = (temperature > 20) ? "warm" : "cold";
        System.out.println("Temperature: " + temperature + "°C - It's " + weather);
        
        // Nested ternary (use sparingly for readability)
        String clothing = (temperature > 30) ? "light clothes" : 
                         (temperature > 15) ? "normal clothes" : "warm clothes";
        System.out.println("Recommended clothing: " + clothing);
        
        // Ternary with different data types
        int maxAge = (ageMateus > ageBernardo) ? ageMateus : ageBernardo;
        System.out.println("Older child age: " + maxAge);
        
        System.out.println();
        
        // ========================================
        // 7. DATA VALIDATION EXAMPLE
        // ========================================
        System.out.println("=== 7. Data Validation System ===");
        
        String userName = "Emilio";
        String password = "12345678";
        int loginAttempts = 2;
        boolean isAccountLocked = false;
        
        System.out.println("Login attempt for user: " + userName);
        
        // Validation chain
        if (isAccountLocked) {
            System.out.println("❌ Account is locked. Contact support.");
        } else if (userName == null || userName.trim().isEmpty()) {
            System.out.println("❌ Username cannot be empty");
        } else if (password == null || password.length() < 6) {
            System.out.println("❌ Password must have at least 6 characters");
        } else if (loginAttempts >= 3) {
            System.out.println("❌ Too many login attempts. Account will be locked.");
        } else {
            // Simulate password check
            boolean passwordCorrect = password.equals("12345678");
            
            if (passwordCorrect && loginAttempts < 3) {
                System.out.println("✅ Login successful! Welcome, " + userName + "!");
            } else {
                System.out.println("❌ Invalid credentials. Attempts remaining: " + (3 - loginAttempts - 1));
            }
        }
        
        System.out.println();
        System.out.println("===============================");
        System.out.println("✅ Exercise 4 completed!");
        System.out.println("Concepts mastered:");
        System.out.println("- if/else statements");
        System.out.println("- Logical operators (&&, ||, !)");
        System.out.println("- switch statements");
        System.out.println("- Ternary operator");
        System.out.println("- Data validation patterns");
        System.out.println("===============================");
    }
}