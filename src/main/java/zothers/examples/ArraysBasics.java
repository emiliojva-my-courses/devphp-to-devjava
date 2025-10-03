package main.java.zothers.examples;

import java.util.Arrays;

/**
 * Arrays Básicos - Conceitos Fundamentais
 * 
 * Demonstra:
 * - Declaração e inicialização de arrays
 * - Acesso e modificação de elementos
 * - Percorrimento com loops tradicionais e enhanced for
 * - Arrays multidimensionais (matrizes)
 * - Métodos úteis da classe Arrays
 * 
 * @author Emilio - DevPHP to DevJava Journey
 * @since Java 17
 */
public class ArraysBasics {

    public static void main(String[] args) {
        System.out.println("=== ARRAYS BÁSICOS - CONCEITOS FUNDAMENTAIS ===\n");
        
        // 1. DECLARAÇÃO E INICIALIZAÇÃO
        demonstrarDeclaracaoInicializacao();
        
        // 2. ACESSO E MODIFICAÇÃO
        demonstrarAcessoModificacao();
        
        // 3. PERCORRIMENTO COM LOOPS
        demonstrarPercorrimento();
        
        // 4. ARRAYS MULTIDIMENSIONAIS
        demonstrarArraysMultidimensionais();
        
        // 5. MÉTODOS ÚTEIS DA CLASSE ARRAYS
        demonstrarUtilitariosArrays();
        
        // 6. APLICAÇÃO PRÁTICA - SISTEMA DE NOTAS
        sistemaNotasEstudantes();
    }
    
    /**
     * Demonstra diferentes formas de declarar e inicializar arrays
     */
    private static void demonstrarDeclaracaoInicializacao() {
        System.out.println("📋 1. DECLARAÇÃO E INICIALIZAÇÃO DE ARRAYS");
        System.out.println("-".repeat(50));
        
        // Forma 1: Declaração e inicialização separadas
        int[] numeros;                    // Declaração
        numeros = new int[5];            // Inicialização com tamanho 5
        System.out.println("Array 'numeros' inicializado com tamanho: " + numeros.length);
        
        // Forma 2: Declaração e inicialização juntas
        String[] nomes = new String[3];
        System.out.println("Array 'nomes' inicializado com tamanho: " + nomes.length);
        
        // Forma 3: Inicialização com valores (array literal)
        double[] precos = {19.99, 35.50, 8.75, 42.30};
        System.out.println("Array 'precos' com valores: " + Arrays.toString(precos));
        
        // Forma 4: Inicialização com new e valores
        char[] vogais = new char[]{'a', 'e', 'i', 'o', 'u'};
        System.out.println("Array 'vogais': " + Arrays.toString(vogais));
        
        // Forma 5: Array de objetos
        String[] linguagens = {"Java", "Python", "JavaScript", "C++", "Go"};
        System.out.println("Array 'linguagens': " + Arrays.toString(linguagens));
        
        System.out.println();
    }
    
    /**
     * Demonstra acesso e modificação de elementos do array
     */
    private static void demonstrarAcessoModificacao() {
        System.out.println("🔧 2. ACESSO E MODIFICAÇÃO DE ELEMENTOS");
        System.out.println("-".repeat(50));
        
        // Criando array de temperaturas
        double[] temperaturas = {23.5, 25.8, 22.1, 28.9, 24.3};
        
        System.out.println("Temperaturas originais: " + Arrays.toString(temperaturas));
        System.out.println("Primeira temperatura: " + temperaturas[0] + "°C");
        System.out.println("Última temperatura: " + temperaturas[temperaturas.length - 1] + "°C");
        
        // Modificando elementos
        temperaturas[0] = 20.5;  // Alterando primeira temperatura
        temperaturas[2] = 26.7;  // Alterando terceira temperatura
        
        System.out.println("Após modificações: " + Arrays.toString(temperaturas));
        
        // Calculando média das temperaturas
        double soma = 0;
        for (double temp : temperaturas) {
            soma += temp;
        }
        double media = soma / temperaturas.length;
        System.out.printf("Temperatura média: %.2f°C%n", media);
        
        System.out.println();
    }
    
    /**
     * Demonstra diferentes formas de percorrer arrays
     */
    private static void demonstrarPercorrimento() {
        System.out.println("🔄 3. PERCORRIMENTO DE ARRAYS");
        System.out.println("-".repeat(50));
        
        String[] frutas = {"Maçã", "Banana", "Laranja", "Uva", "Manga"};
        
        // Método 1: Loop tradicional (for clássico)
        System.out.println("Método 1 - Loop tradicional:");
        for (int i = 0; i < frutas.length; i++) {
            System.out.printf("  [%d] %s%n", i, frutas[i]);
        }
        
        // Método 2: Enhanced for loop (for-each)
        System.out.println("\nMétodo 2 - Enhanced for loop:");
        for (String fruta : frutas) {
            System.out.println("  • " + fruta);
        }
        
        // Método 3: While loop
        System.out.println("\nMétodo 3 - While loop (frutas em maiúsculo):");
        int index = 0;
        while (index < frutas.length) {
            System.out.println("  → " + frutas[index].toUpperCase());
            index++;
        }
        
        System.out.println();
    }
    
    /**
     * Demonstra arrays multidimensionais (matrizes)
     */
    private static void demonstrarArraysMultidimensionais() {
        System.out.println("📊 4. ARRAYS MULTIDIMENSIONAIS (MATRIZES)");
        System.out.println("-".repeat(50));
        
        // Matriz 2D - Tabuleiro de Jogo da Velha
        char[][] jogoVelha = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'X', 'O'}
        };
        
        System.out.println("Tabuleiro Jogo da Velha:");
        for (int linha = 0; linha < jogoVelha.length; linha++) {
            System.out.print("  ");
            for (int coluna = 0; coluna < jogoVelha[linha].length; coluna++) {
                System.out.print(jogoVelha[linha][coluna]);
                if (coluna < jogoVelha[linha].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (linha < jogoVelha.length - 1) {
                System.out.println("  ---------");
            }
        }
        
        // Matriz 2D - Notas de estudantes por matéria
        double[][] notasEstudantes = {
            {8.5, 7.2, 9.1, 6.8},  // Estudante 1
            {7.8, 8.9, 7.5, 8.2},  // Estudante 2
            {9.2, 8.7, 9.5, 9.0}   // Estudante 3
        };
        
        String[] materias = {"Matemática", "Português", "História", "Ciências"};
        
        System.out.println("\nNotas dos Estudantes:");
        System.out.println("Matérias: " + Arrays.toString(materias));
        
        for (int estudante = 0; estudante < notasEstudantes.length; estudante++) {
            double somaNotas = 0;
            System.out.printf("Estudante %d: ", (estudante + 1));
            
            for (int materia = 0; materia < notasEstudantes[estudante].length; materia++) {
                System.out.printf("%.1f ", notasEstudantes[estudante][materia]);
                somaNotas += notasEstudantes[estudante][materia];
            }
            
            double media = somaNotas / notasEstudantes[estudante].length;
            System.out.printf("(Média: %.2f)%n", media);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstra métodos úteis da classe Arrays
     */
    private static void demonstrarUtilitariosArrays() {
        System.out.println("🛠️ 5. UTILITÁRIOS DA CLASSE ARRAYS");
        System.out.println("-".repeat(50));
        
        // Array de números para demonstração
        int[] numeros = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + Arrays.toString(numeros));
        
        // 1. Arrays.sort() - Ordenação
        int[] numerosOrdenados = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(numerosOrdenados);
        System.out.println("Array ordenado: " + Arrays.toString(numerosOrdenados));
        
        // 2. Arrays.binarySearch() - Busca binária (só funciona em array ordenado)
        int valorProcurado = 25;
        int indiceEncontrado = Arrays.binarySearch(numerosOrdenados, valorProcurado);
        System.out.printf("Índice do valor %d: %d%n", valorProcurado, indiceEncontrado);
        
        // 3. Arrays.fill() - Preenchimento
        int[] arrayPreenchido = new int[8];
        Arrays.fill(arrayPreenchido, 42);
        System.out.println("Array preenchido com 42: " + Arrays.toString(arrayPreenchido));
        
        // 4. Arrays.equals() - Comparação
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 6};
        
        System.out.println("Array1 equals Array2: " + Arrays.equals(array1, array2));
        System.out.println("Array1 equals Array3: " + Arrays.equals(array1, array3));
        
        // 5. Arrays.copyOf() - Cópia
        String[] nomes = {"Ana", "Bruno", "Carlos"};
        String[] copiaExpandida = Arrays.copyOf(nomes, 5);
        System.out.println("Cópia expandida: " + Arrays.toString(copiaExpandida));
        
        // 6. Arrays.copyOfRange() - Cópia de intervalo
        int[] subArray = Arrays.copyOfRange(numeros, 2, 5);
        System.out.println("Sub-array (índices 2-4): " + Arrays.toString(subArray));
        
        System.out.println();
    }
    
    /**
     * Aplicação prática: Sistema de notas de estudantes
     */
    private static void sistemaNotasEstudantes() {
        System.out.println("🎓 6. APLICAÇÃO PRÁTICA - SISTEMA DE NOTAS");
        System.out.println("-".repeat(50));
        
        // Dados do sistema
        String[] estudantes = {"Alice Santos", "Bruno Silva", "Carla Oliveira", "Diego Costa"};
        String[] disciplinas = {"Java", "Banco de Dados", "Spring Boot", "Testes"};
        
        // Matriz de notas [estudante][disciplina]
        double[][] notas = {
            {8.5, 7.8, 9.2, 8.0},  // Alice
            {7.2, 8.5, 7.9, 8.8},  // Bruno
            {9.1, 8.2, 8.7, 9.3},  // Carla
            {6.8, 7.5, 8.1, 7.2}   // Diego
        };
        
        System.out.println("📚 RELATÓRIO DE NOTAS - CURSO JAVA DEVELOPER");
        System.out.println("Disciplinas: " + Arrays.toString(disciplinas));
        System.out.println();
        
        // Array para armazenar médias dos estudantes
        double[] mediasEstudantes = new double[estudantes.length];
        
        // Calculando e exibindo dados de cada estudante
        for (int i = 0; i < estudantes.length; i++) {
            System.out.printf("👤 %s:%n", estudantes[i]);
            
            double somaNotas = 0;
            for (int j = 0; j < disciplinas.length; j++) {
                System.out.printf("  %-15s: %.1f%n", disciplinas[j], notas[i][j]);
                somaNotas += notas[i][j];
            }
            
            mediasEstudantes[i] = somaNotas / disciplinas.length;
            System.out.printf("  %-15s: %.2f%n", "MÉDIA GERAL", mediasEstudantes[i]);
            
            // Status do estudante
            String status = mediasEstudantes[i] >= 8.0 ? "APROVADO ✅" : 
                           mediasEstudantes[i] >= 6.0 ? "RECUPERAÇÃO ⚠️" : "REPROVADO ❌";
            System.out.printf("  %-15s: %s%n%n", "STATUS", status);
        }
        
        // Estatísticas da turma
        System.out.println("📊 ESTATÍSTICAS DA TURMA:");
        
        double melhorMedia = mediasEstudantes[0];
        double piorMedia = mediasEstudantes[0];
        double somaMedias = 0;
        
        for (double media : mediasEstudantes) {
            if (media > melhorMedia) melhorMedia = media;
            if (media < piorMedia) piorMedia = media;
            somaMedias += media;
        }
        
        double mediaTurma = somaMedias / mediasEstudantes.length;
        
        System.out.printf("  Melhor média: %.2f%n", melhorMedia);
        System.out.printf("  Pior média: %.2f%n", piorMedia);
        System.out.printf("  Média da turma: %.2f%n", mediaTurma);
        
        // Contando aprovados/reprovados
        int aprovados = 0, recuperacao = 0, reprovados = 0;
        
        for (double media : mediasEstudantes) {
            if (media >= 8.0) aprovados++;
            else if (media >= 6.0) recuperacao++;
            else reprovados++;
        }
        
        System.out.printf("  Aprovados: %d | Recuperação: %d | Reprovados: %d%n", 
                         aprovados, recuperacao, reprovados);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("🎯 Arrays básicos dominados! Próximo: Métodos e Funções");
    }
}