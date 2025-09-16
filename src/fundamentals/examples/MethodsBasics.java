package fundamentals.examples;

import java.util.Arrays;

/**
 * Métodos e Funções - Conceitos Fundamentais
 * 
 * Demonstra:
 * - Declaração e chamada de métodos
 * - Parâmetros e tipos de retorno
 * - Métodos static vs instance
 * - Sobrecarga de métodos (method overloading)
 * - Passagem de parâmetros (por valor vs referência)
 * - Métodos com arrays e aplicações práticas
 * 
 * @author Emilio - DevPHP to DevJava Journey
 * @since Java 17
 */
public class MethodsBasics {

    public static void main(String[] args) {
        System.out.println("=== MÉTODOS E FUNÇÕES - CONCEITOS FUNDAMENTAIS ===\n");
        
        // 1. MÉTODOS BÁSICOS - VOID E COM RETORNO
        demonstrarMetodosBasicos();
        
        // 2. MÉTODOS COM PARÂMETROS
        demonstrarParametros();
        
        // 3. SOBRECARGA DE MÉTODOS (METHOD OVERLOADING)
        demonstrarSobrecarga();
        
        // 4. MÉTODOS COM ARRAYS
        demonstrarMetodosComArrays();
        
        // 5. PASSAGEM POR VALOR VS REFERÊNCIA
        demonstrarPassagemParametros();
        
        // 6. APLICAÇÃO PRÁTICA - CALCULADORA CIENTÍFICA
        calculadoraCientifica();
        
        // 7. APLICAÇÃO PRÁTICA - SISTEMA DE ANÁLISE DE DADOS
        sistemaAnaliseEstatistica();
    }
    
    /**
     * Demonstra métodos básicos void e com retorno
     */
    private static void demonstrarMetodosBasicos() {
        System.out.println("🔧 1. MÉTODOS BÁSICOS - VOID E COM RETORNO");
        System.out.println("-".repeat(50));
        
        // Chamando método void (sem retorno)
        exibirMensagemBemVindo();
        
        // Chamando métodos com retorno
        int numeroAleatorio = gerarNumeroAleatorio();
        System.out.println("Número aleatório gerado: " + numeroAleatorio);
        
        String saudacao = obterSaudacao();
        System.out.println("Saudação: " + saudacao);
        
        boolean ehPar = verificarSePar(numeroAleatorio);
        System.out.printf("O número %d é par? %s%n", numeroAleatorio, ehPar ? "Sim" : "Não");
        
        System.out.println();
    }
    
    /**
     * Método void - não retorna valor
     */
    private static void exibirMensagemBemVindo() {
        System.out.println("🎉 Bem-vindo ao mundo dos métodos Java!");
        System.out.println("   Modularização é a chave para código limpo!");
    }
    
    /**
     * Método que retorna int
     */
    private static int gerarNumeroAleatorio() {
        return (int) (Math.random() * 100) + 1;  // 1 a 100
    }
    
    /**
     * Método que retorna String
     */
    private static String obterSaudacao() {
        return "Olá, desenvolvedor Java em formação!";
    }
    
    /**
     * Método que retorna boolean
     */
    private static boolean verificarSePar(int numero) {
        return numero % 2 == 0;
    }
    
    /**
     * Demonstra métodos com diferentes tipos de parâmetros
     */
    private static void demonstrarParametros() {
        System.out.println("📝 2. MÉTODOS COM PARÂMETROS");
        System.out.println("-".repeat(50));
        
        // Método com um parâmetro
        cumprimentarPessoa("Ana Silva");
        
        // Método com múltiplos parâmetros
        int soma = somar(15, 27);
        System.out.println("Soma: " + soma);
        
        double media = calcularMedia(8.5, 7.2, 9.1, 6.8);
        System.out.printf("Média: %.2f%n", media);
        
        // Método com parâmetros de tipos diferentes
        String relatorio = gerarRelatorioVenda("Notebook Dell", 2499.99, 3);
        System.out.println(relatorio);
        
        System.out.println();
    }
    
    /**
     * Método com um parâmetro String
     */
    private static void cumprimentarPessoa(String nome) {
        System.out.println("👋 Olá, " + nome + "! Como está?");
    }
    
    /**
     * Método com dois parâmetros int
     */
    private static int somar(int a, int b) {
        return a + b;
    }
    
    /**
     * Método com múltiplos parâmetros (varargs)
     */
    private static double calcularMedia(double... numeros) {
        if (numeros.length == 0) return 0;
        
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        return soma / numeros.length;
    }
    
    /**
     * Método com parâmetros de tipos diferentes
     */
    private static String gerarRelatorioVenda(String produto, double preco, int quantidade) {
        double total = preco * quantidade;
        return String.format("📦 Produto: %s | Preço: R$ %.2f | Qtd: %d | Total: R$ %.2f", 
                           produto, preco, quantidade, total);
    }
    
    /**
     * Demonstra sobrecarga de métodos (method overloading)
     */
    private static void demonstrarSobrecarga() {
        System.out.println("🔄 3. SOBRECARGA DE MÉTODOS (METHOD OVERLOADING)");
        System.out.println("-".repeat(50));
        
        // Mesmo nome, diferentes parâmetros
        System.out.println("Área do quadrado: " + calcularArea(5));
        System.out.println("Área do retângulo: " + calcularArea(8, 12));
        System.out.println("Área do círculo: " + calcularArea(7.5));
        
        // Formatação de data com sobrecarga
        System.out.println("Data simples: " + formatarData(16, 9, 2025));
        System.out.println("Data completa: " + formatarData(16, 9, 2025, true));
        
        System.out.println();
    }
    
    /**
     * Sobrecarga - Área do quadrado
     */
    private static int calcularArea(int lado) {
        return lado * lado;
    }
    
    /**
     * Sobrecarga - Área do retângulo
     */
    private static int calcularArea(int largura, int altura) {
        return largura * altura;
    }
    
    /**
     * Sobrecarga - Área do círculo
     */
    private static double calcularArea(double raio) {
        return Math.PI * raio * raio;
    }
    
    /**
     * Sobrecarga - Data simples
     */
    private static String formatarData(int dia, int mes, int ano) {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }
    
    /**
     * Sobrecarga - Data completa
     */
    private static String formatarData(int dia, int mes, int ano, boolean formato24h) {
        String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun",
                         "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        
        if (formato24h) {
            return String.format("%02d de %s de %d", dia, meses[mes-1], ano);
        }
        return formatarData(dia, mes, ano);
    }
    
    /**
     * Demonstra métodos que trabalham com arrays
     */
    private static void demonstrarMetodosComArrays() {
        System.out.println("📊 4. MÉTODOS COM ARRAYS");
        System.out.println("-".repeat(50));
        
        int[] numeros = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50};
        System.out.println("Array original: " + Arrays.toString(numeros));
        
        // Métodos que analisam o array
        int maior = encontrarMaior(numeros);
        int menor = encontrarMenor(numeros);
        double mediaArray = calcularMediaArray(numeros);
        
        System.out.println("Maior elemento: " + maior);
        System.out.println("Menor elemento: " + menor);
        System.out.printf("Média: %.2f%n", mediaArray);
        
        // Método que modifica o array
        int[] arrayOrdenado = ordenarArray(numeros);
        System.out.println("Array ordenado: " + Arrays.toString(arrayOrdenado));
        
        // Método que filtra elementos
        int[] pares = filtrarPares(numeros);
        System.out.println("Números pares: " + Arrays.toString(pares));
        
        System.out.println();
    }
    
    /**
     * Encontra o maior elemento do array
     */
    private static int encontrarMaior(int[] array) {
        if (array.length == 0) return 0;
        
        int maior = array[0];
        for (int numero : array) {
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }
    
    /**
     * Encontra o menor elemento do array
     */
    private static int encontrarMenor(int[] array) {
        if (array.length == 0) return 0;
        
        int menor = array[0];
        for (int numero : array) {
            if (numero < menor) {
                menor = numero;
            }
        }
        return menor;
    }
    
    /**
     * Calcula a média dos elementos do array
     */
    private static double calcularMediaArray(int[] array) {
        if (array.length == 0) return 0;
        
        long soma = 0;  // long para evitar overflow
        for (int numero : array) {
            soma += numero;
        }
        return (double) soma / array.length;
    }
    
    /**
     * Retorna uma cópia ordenada do array
     */
    private static int[] ordenarArray(int[] array) {
        int[] copia = Arrays.copyOf(array, array.length);
        Arrays.sort(copia);
        return copia;
    }
    
    /**
     * Filtra apenas números pares do array
     */
    private static int[] filtrarPares(int[] array) {
        // Primeiro, conta quantos pares existem
        int contador = 0;
        for (int numero : array) {
            if (numero % 2 == 0) {
                contador++;
            }
        }
        
        // Cria array com tamanho correto e preenche
        int[] pares = new int[contador];
        int indice = 0;
        for (int numero : array) {
            if (numero % 2 == 0) {
                pares[indice++] = numero;
            }
        }
        
        return pares;
    }
    
    /**
     * Demonstra passagem de parâmetros por valor vs referência
     */
    private static void demonstrarPassagemParametros() {
        System.out.println("🔀 5. PASSAGEM POR VALOR VS REFERÊNCIA");
        System.out.println("-".repeat(50));
        
        // Primitivos - passagem por valor
        int numero = 10;
        System.out.println("Antes da modificação: " + numero);
        tentarModificarPrimitivo(numero);
        System.out.println("Depois da modificação: " + numero + " (não mudou!)");
        
        // Arrays - passagem por referência
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array antes: " + Arrays.toString(array));
        modificarArray(array);
        System.out.println("Array depois: " + Arrays.toString(array) + " (mudou!)");
        
        // Strings - comportamento especial (imutáveis)
        String texto = "Original";
        System.out.println("String antes: " + texto);
        tentarModificarString(texto);
        System.out.println("String depois: " + texto + " (não mudou - imutável!)");
        
        System.out.println();
    }
    
    /**
     * Tenta modificar um primitivo (não funciona - cópia por valor)
     */
    private static void tentarModificarPrimitivo(int numero) {
        numero = 999;  // Modifica apenas a cópia local
        System.out.println("  Dentro do método: " + numero);
    }
    
    /**
     * Modifica um array (funciona - referência)
     */
    private static void modificarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 10;  // Multiplica cada elemento por 10
        }
        System.out.println("  Dentro do método: " + Arrays.toString(array));
    }
    
    /**
     * Tenta modificar uma String (não funciona - imutável)
     */
    private static void tentarModificarString(String texto) {
        texto = "Modificado";  // Cria nova String, não modifica a original
        System.out.println("  Dentro do método: " + texto);
    }
    
    /**
     * Aplicação prática: Calculadora científica
     */
    private static void calculadoraCientifica() {
        System.out.println("🧮 6. APLICAÇÃO PRÁTICA - CALCULADORA CIENTÍFICA");
        System.out.println("-".repeat(50));
        
        double a = 16.0, b = 4.0, angulo = 30.0;
        
        System.out.printf("Números: a = %.1f, b = %.1f, ângulo = %.1f°%n", a, b, angulo);
        System.out.println();
        
        // Operações básicas
        System.out.println("📋 Operações Básicas:");
        System.out.printf("  Soma: %.1f + %.1f = %.1f%n", a, b, operacaoBasica(a, b, '+'));
        System.out.printf("  Subtração: %.1f - %.1f = %.1f%n", a, b, operacaoBasica(a, b, '-'));
        System.out.printf("  Multiplicação: %.1f × %.1f = %.1f%n", a, b, operacaoBasica(a, b, '*'));
        System.out.printf("  Divisão: %.1f ÷ %.1f = %.2f%n", a, b, operacaoBasica(a, b, '/'));
        
        // Operações científicas
        System.out.println("\n🔬 Operações Científicas:");
        System.out.printf("  Potência: %.1f^%.1f = %.2f%n", a, b, potencia(a, b));
        System.out.printf("  Raiz quadrada de %.1f = %.2f%n", a, raizQuadrada(a));
        System.out.printf("  Logaritmo de %.1f = %.4f%n", a, logaritmo(a));
        
        // Funções trigonométricas
        System.out.println("\n📐 Trigonometria:");
        System.out.printf("  sen(%.1f°) = %.4f%n", angulo, seno(angulo));
        System.out.printf("  cos(%.1f°) = %.4f%n", angulo, cosseno(angulo));
        System.out.printf("  tan(%.1f°) = %.4f%n", angulo, tangente(angulo));
        
        System.out.println();
    }
    
    /**
     * Operações básicas com sobrecarga por char
     */
    private static double operacaoBasica(double a, double b, char operador) {
        return switch (operador) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : Double.NaN;
            default -> 0;
        };
    }
    
    private static double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }
    
    private static double raizQuadrada(double numero) {
        return Math.sqrt(numero);
    }
    
    private static double logaritmo(double numero) {
        return Math.log10(numero);
    }
    
    private static double seno(double anguloGraus) {
        return Math.sin(Math.toRadians(anguloGraus));
    }
    
    private static double cosseno(double anguloGraus) {
        return Math.cos(Math.toRadians(anguloGraus));
    }
    
    private static double tangente(double anguloGraus) {
        return Math.tan(Math.toRadians(anguloGraus));
    }
    
    /**
     * Aplicação prática: Sistema de análise estatística
     */
    private static void sistemaAnaliseEstatistica() {
        System.out.println("📊 7. SISTEMA DE ANÁLISE ESTATÍSTICA");
        System.out.println("-".repeat(50));
        
        // Dados de vendas mensais
        double[] vendasMensais = {45000, 52000, 38000, 61000, 47000, 55000, 
                                 49000, 58000, 42000, 63000, 51000, 59000};
        String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun",
                         "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        
        System.out.println("📈 RELATÓRIO ANUAL DE VENDAS - 2025");
        System.out.println("Dados: " + Arrays.toString(vendasMensais));
        System.out.println();
        
        // Análises estatísticas
        double media = calcularMediaVendas(vendasMensais);
        double maiorVenda = encontrarMaiorVenda(vendasMensais);
        double menorVenda = encontrarMenorVenda(vendasMensais);
        int indiceMelhorMes = encontrarIndiceMelhorMes(vendasMensais);
        int indicePiorMes = encontrarIndicePiorMes(vendasMensais);
        double totalAnual = calcularTotalAnual(vendasMensais);
        double desvioPadrao = calcularDesvioPadrao(vendasMensais, media);
        
        // Relatório formatado
        System.out.println("📊 ESTATÍSTICAS GERAIS:");
        System.out.printf("  💰 Total anual: R$ %.2f%n", totalAnual);
        System.out.printf("  📊 Média mensal: R$ %.2f%n", media);
        System.out.printf("  📈 Maior venda: R$ %.2f (%s)%n", maiorVenda, meses[indiceMelhorMes]);
        System.out.printf("  📉 Menor venda: R$ %.2f (%s)%n", menorVenda, meses[indicePiorMes]);
        System.out.printf("  📏 Desvio padrão: R$ %.2f%n", desvioPadrao);
        
        // Análise de performance
        System.out.println("\n🎯 ANÁLISE DE PERFORMANCE:");
        analisarPerformanceMensal(vendasMensais, meses, media);
        
        // Projeções
        System.out.println("\n🔮 PROJEÇÕES:");
        double crescimentoMedio = calcularCrescimentoMedio(vendasMensais);
        double projecaoProximoAno = totalAnual * (1 + crescimentoMedio / 100);
        System.out.printf("  📊 Crescimento médio: %.2f%% ao mês%n", crescimentoMedio);
        System.out.printf("  🎯 Projeção 2026: R$ %.2f%n", projecaoProximoAno);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("🎯 Métodos e Funções dominados! Próximo: Strings Avançado");
    }
    
    private static double calcularMediaVendas(double[] vendas) {
        double soma = 0;
        for (double venda : vendas) {
            soma += venda;
        }
        return soma / vendas.length;
    }
    
    private static double encontrarMaiorVenda(double[] vendas) {
        double maior = vendas[0];
        for (double venda : vendas) {
            if (venda > maior) maior = venda;
        }
        return maior;
    }
    
    private static double encontrarMenorVenda(double[] vendas) {
        double menor = vendas[0];
        for (double venda : vendas) {
            if (venda < menor) menor = venda;
        }
        return menor;
    }
    
    private static int encontrarIndiceMelhorMes(double[] vendas) {
        int indiceMelhor = 0;
        for (int i = 1; i < vendas.length; i++) {
            if (vendas[i] > vendas[indiceMelhor]) {
                indiceMelhor = i;
            }
        }
        return indiceMelhor;
    }
    
    private static int encontrarIndicePiorMes(double[] vendas) {
        int indicePior = 0;
        for (int i = 1; i < vendas.length; i++) {
            if (vendas[i] < vendas[indicePior]) {
                indicePior = i;
            }
        }
        return indicePior;
    }
    
    private static double calcularTotalAnual(double[] vendas) {
        double total = 0;
        for (double venda : vendas) {
            total += venda;
        }
        return total;
    }
    
    private static double calcularDesvioPadrao(double[] vendas, double media) {
        double somaQuadrados = 0;
        for (double venda : vendas) {
            somaQuadrados += Math.pow(venda - media, 2);
        }
        return Math.sqrt(somaQuadrados / vendas.length);
    }
    
    private static void analisarPerformanceMensal(double[] vendas, String[] meses, double media) {
        for (int i = 0; i < vendas.length; i++) {
            double diferenca = vendas[i] - media;
            double percentual = (diferenca / media) * 100;
            String status = diferenca >= 0 ? "✅" : "⚠️";
            
            System.out.printf("  %s %s: R$ %.0f (%+.1f%%)%n", 
                            status, meses[i], vendas[i], percentual);
        }
    }
    
    private static double calcularCrescimentoMedio(double[] vendas) {
        double somaVariacoes = 0;
        int contador = 0;
        
        for (int i = 1; i < vendas.length; i++) {
            double variacao = ((vendas[i] - vendas[i-1]) / vendas[i-1]) * 100;
            somaVariacoes += variacao;
            contador++;
        }
        
        return contador > 0 ? somaVariacoes / contador : 0;
    }
}