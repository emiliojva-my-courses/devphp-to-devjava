package main.java.zothers.examples;

/**
 * Exercise 5: Loop Structures in Java
 * 
 * Objectives:
 * - Master for loops (traditional and enhanced)
 * - Understand while and do-while loops
 * - Apply break and continue statements
 * - Implement nested loops for complex scenarios
 * 
 * Concepts Applied:
 * - for loop (traditional): for(init; condition; increment)
 * - Enhanced for (foreach): for(Type item : collection)
 * - while loop: while(condition) 
 * - do-while loop: do { } while(condition)
 * - break: exit loop completely
 * - continue: skip current iteration
 * - Nested loops for matrices and complex data
 * 
 * PHP/Laravel Equivalent:
 * - PHP for: for($i = 0; $i < 10; $i++) vs Java for(int i = 0; i < 10; i++)
 * - PHP foreach: foreach($array as $item) vs Java for(Type item : array)
 * - PHP while: while($condition) (similar syntax)
 * - PHP break/continue: same keywords, same behavior
 */
public class LoopStructures {

    public static void main(String[] args) {
        
        System.out.println("===============================");
        System.out.println("Exercise 5: Loop Structures");
        System.out.println("===============================");
        System.out.println();

        // ========================================
        // 1. FOR LOOP TRADICIONAL
        // ========================================
        System.out.println("=== 1. Traditional For Loop ===");
        
        // Contagem simples
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        System.out.println();
        
        // Contagem decrescente
        System.out.println("Countdown from 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            System.out.println("Countdown: " + i);
        }
        
        System.out.println();
        
        // Incremento personalizado
        System.out.println("Even numbers from 0 to 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.println("Even: " + i);
        }
        
        System.out.println();
        
        // ========================================
        // 2. WHILE LOOP
        // ========================================
        System.out.println("=== 2. While Loop ===");
        
        int counter = 1;
        System.out.println("While loop - counting to 3:");
        while (counter <= 3) {
            System.out.println("While count: " + counter);
            counter++; // Importante: incrementar para evitar loop infinito
        }
        
        System.out.println();
        
        // Simulação de input do usuário
        int attempts = 0;
        int maxAttempts = 3;
        boolean success = false;
        
        System.out.println("Simulating login attempts:");
        while (attempts < maxAttempts && !success) {
            attempts++;
            System.out.println("Attempt " + attempts + "...");
            
            // Simular tentativa (seria input real em aplicação)
            if (attempts == 2) { // Simula sucesso na 2ª tentativa
                success = true;
                System.out.println("✅ Login successful!");
            } else {
                System.out.println("❌ Login failed");
            }
        }
        
        if (!success) {
            System.out.println("🔒 Account locked after " + maxAttempts + " attempts");
        }
        
        System.out.println();
        
        // ========================================
        // 3. DO-WHILE LOOP
        // ========================================
        System.out.println("=== 3. Do-While Loop ===");
        
        int menuChoice;
        int menuAttempt = 0;
        
        System.out.println("Menu simulation (executes at least once):");
        do {
            menuAttempt++;
            System.out.println("--- Menu Attempt " + menuAttempt + " ---");
            System.out.println("1. View Profile");
            System.out.println("2. Settings");
            System.out.println("3. Exit");
            
            // Simular escolha do usuário
            menuChoice = menuAttempt; // Simula diferentes escolhas
            System.out.println("User chose: " + menuChoice);
            
            if (menuChoice == 3) {
                System.out.println("👋 Goodbye!");
            } else {
                System.out.println("Invalid option, try again...");
            }
            
        } while (menuChoice != 3 && menuAttempt < 3); // Limita tentativas para exemplo
        
        System.out.println();
        
        // ========================================
        // 4. ENHANCED FOR (FOREACH)
        // ========================================
        System.out.println("=== 4. Enhanced For Loop (Foreach) ===");
        
        // Array de strings
        String[] nomes = {"Mateus", "Bernardo", "Papai", "Mamãe"};
        
        System.out.println("Family members:");
        for (String nome : nomes) {
            System.out.println("👨‍👩‍👧‍👦 " + nome);
        }
        
        System.out.println();
        
        // Array de números
        int[] idades = {5, 3, 35, 32};
        
        System.out.println("Ages in the family:");
        int totalIdade = 0;
        for (int idade : idades) {
            System.out.println("Age: " + idade + " years");
            totalIdade += idade;
        }
        System.out.println("Average age: " + (totalIdade / idades.length) + " years");
        
        System.out.println();
        
        // ========================================
        // 5. BREAK E CONTINUE
        // ========================================
        System.out.println("=== 5. Break and Continue Statements ===");
        
        System.out.println("Finding first number divisible by 7:");
        for (int i = 1; i <= 20; i++) {
            if (i % 7 == 0) {
                System.out.println("Found: " + i + " is divisible by 7");
                break; // Sai do loop completamente
            }
            System.out.println("Checking: " + i);
        }
        
        System.out.println();
        
        System.out.println("Printing only odd numbers from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Pula para próxima iteração
            }
            System.out.println("Odd number: " + i);
        }
        
        System.out.println();
        
        // ========================================
        // 6. NESTED LOOPS (LOOPS ANINHADOS)
        // ========================================
        System.out.println("=== 6. Nested Loops ===");
        
        System.out.println("Multiplication table (3x3):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                int result = i * j;
                System.out.print(i + "x" + j + "=" + result + "\t");
            }
            System.out.println(); // Nova linha após cada linha da tabela
        }
        
        System.out.println();
        
        // Padrão de estrelas
        System.out.println("Star pattern:");
        for (int line = 1; line <= 4; line++) {
            // Espaços
            for (int space = 1; space <= (4 - line); space++) {
                System.out.print(" ");
            }
            // Estrelas
            for (int star = 1; star <= line; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        // ========================================
        // 7. EXERCÍCIO PRÁTICO: SISTEMA DE NOTAS
        // ========================================
        System.out.println("=== 7. Practical Exercise: Grade System ===");
        
        String[] materias = {"Math", "Portuguese", "Science", "History"};
        double[][] notasTurma = {
            {8.5, 7.0, 9.0, 6.5}, // Aluno 1
            {7.5, 8.0, 7.5, 8.5}, // Aluno 2
            {9.0, 9.5, 8.5, 9.0}, // Aluno 3
            {6.0, 6.5, 7.0, 6.5}  // Aluno 4
        };
        
        System.out.println("Class Grade Report:");
        System.out.println("==================");
        
        // Cabeçalho
        System.out.print("Student\t");
        for (String materia : materias) {
            System.out.print(materia + "\t");
        }
        System.out.println("Average");
        
        // Notas por aluno
        for (int aluno = 0; aluno < notasTurma.length; aluno++) {
            System.out.print("Student " + (aluno + 1) + "\t");
            
            double somaNotas = 0;
            for (int materia = 0; materia < notasTurma[aluno].length; materia++) {
                double nota = notasTurma[aluno][materia];
                System.out.print(nota + "\t\t");
                somaNotas += nota;
            }
            
            double media = somaNotas / notasTurma[aluno].length;
            System.out.printf("%.1f", media);
            
            // Status do aluno
            if (media >= 7.0) {
                System.out.println(" ✅ APPROVED");
            } else {
                System.out.println(" ❌ FAILED");
            }
        }
        
        // Média por matéria
        System.out.println("\nSubject Averages:");
        for (int materia = 0; materia < materias.length; materia++) {
            double somaMateria = 0;
            for (int aluno = 0; aluno < notasTurma.length; aluno++) {
                somaMateria += notasTurma[aluno][materia];
            }
            double mediaMateria = somaMateria / notasTurma.length;
            System.out.printf("%s: %.1f%n", materias[materia], mediaMateria);
        }
        
        System.out.println();
        System.out.println("===============================");
        System.out.println("✅ Exercise 5 completed!");
        System.out.println("Concepts mastered:");
        System.out.println("- for loops (traditional & enhanced)");
        System.out.println("- while and do-while loops");
        System.out.println("- break and continue statements");
        System.out.println("- nested loops and complex data");
        System.out.println("- practical application with arrays");
        System.out.println("===============================");
    }
}