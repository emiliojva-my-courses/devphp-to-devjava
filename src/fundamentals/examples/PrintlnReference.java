package fundamentals.examples;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * Explorando diferentes formas de criar referências para System.out.println
 * Curiosidade: Como criar um "atalho" para println em Java?
 */
public class PrintlnReference {

    public static void main(String[] args) {

        // ===== MÉTODO 1: Referência direta ao PrintStream =====
        PrintStream out = System.out;
        out.println("✅ Método 1: Usando PrintStream diretamente");
        out.println("Isso funciona perfeitamente!");

        System.out.println(); // Linha em branco

        // ===== MÉTODO 2: Method Reference (Java 8+) =====
        Consumer<String> println = System.out::println;
        println.accept("✅ Método 2: Usando Method Reference");
        println.accept("Mais funcional, estilo Java moderno!");

        System.out.println(); // Linha em branco

        // ===== MÉTODO 3: Variável estática (mais elegante) =====
        demonstrarMetodoEstatico();

        System.out.println(); // Linha em branco

        // ===== COMPARAÇÃO DE SINTAXES =====
        System.out.println("🔍 COMPARAÇÃO:");
        System.out.println("Normal:        System.out.println(\"texto\");");
        out.println("PrintStream:   out.println(\"texto\");");
        println.accept("Method Ref:    println.accept(\"texto\");");
        print("Método static: print(\"texto\");");

        // ===== TESTE COM VARIÁVEIS =====
        String nome = "Emilio";
        int idade = 35;

        System.out.println(); // Linha em branco
        System.out.println("🧪 TESTE COM VARIÁVEIS:");

        // Forma tradicional
        System.out.println("Tradicional: " + nome + " tem " + idade + " anos");

        // Com PrintStream
        out.println("PrintStream: " + nome + " tem " + idade + " anos");

        // Com Method Reference
        println.accept("Method Ref: " + nome + " tem " + idade + " anos");

        // Com método estático
        print("Método static: " + nome + " tem " + idade + " anos");
    }

    // Variável estática para uso global na classe
    private static final PrintStream out = System.out;

    // Método wrapper mais elegante
    public static void print(String text) {
        System.out.println(text);
    }

    public static void demonstrarMetodoEstatico() {
        out.println("✅ Método 3: Usando variável estática da classe");
        out.println("Acessível em qualquer método da classe!");
    }
}
