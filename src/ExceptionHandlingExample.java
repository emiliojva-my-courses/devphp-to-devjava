import java.io.*;
import java.util.*;

/**
 * 🚨 Exception Handling: PHP vs Java
 * 
 * Este exemplo mostra como lidar com erros e exceções em Java,
 * sempre comparando com try/catch do PHP que você já conhece.
 * 
 * Tópicos: Checked vs Unchecked, Custom Exceptions, Try-with-resources
 */

// ==========================================
// 1. CUSTOM EXCEPTIONS (PHP Exception)
// ==========================================

/**
 * 🔴 EXCEPTION CUSTOMIZADA: Como PHP Exception
 * 
 * PHP: class MinhaException extends Exception { ... }
 * Java: class MinhaException extends Exception { ... }
 */
class UsuarioInvalidoException extends Exception {
    private String campo;
    private Object valor;
    
    public UsuarioInvalidoException(String campo, Object valor, String mensagem) {
        super(mensagem);
        this.campo = campo;
        this.valor = valor;
    }
    
    public String getCampo() { return campo; }
    public Object getValor() { return valor; }
    
    @Override
    public String getMessage() {
        return String.format("❌ Campo '%s' inválido (valor: %s): %s", campo, valor, super.getMessage());
    }
}

/**
 * 🟠 RUNTIME EXCEPTION: Para erros de lógica
 */
class SaldoInsuficienteException extends RuntimeException {
    private double saldoAtual;
    private double valorSaque;
    
    public SaldoInsuficienteException(double saldoAtual, double valorSaque) {
        super(String.format("Saldo insuficiente: R$ %.2f (tentativa: R$ %.2f)", saldoAtual, valorSaque));
        this.saldoAtual = saldoAtual;
        this.valorSaque = valorSaque;
    }
    
    public double getSaldoAtual() { return saldoAtual; }
    public double getValorSaque() { return valorSaque; }
}

// ==========================================
// 2. CLASSE DE EXEMPLO (Simulando operações que podem falhar)
// ==========================================

/**
 * 💳 CONTA BANCÁRIA: Para demonstrar exceptions
 */
class ContaBancaria {
    private String titular;
    private double saldo;
    
    public ContaBancaria(String titular, double saldoInicial) throws UsuarioInvalidoException {
        // Validação que pode lançar exception
        if (titular == null || titular.trim().isEmpty()) {
            throw new UsuarioInvalidoException("titular", titular, "Nome do titular é obrigatório");
        }
        if (saldoInicial < 0) {
            throw new UsuarioInvalidoException("saldoInicial", saldoInicial, "Saldo inicial não pode ser negativo");
        }
        
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    public void sacar(double valor) {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        saldo -= valor;
        System.out.println(String.format("✅ Saque realizado: R$ %.2f (saldo: R$ %.2f)", valor, saldo));
    }
    
    public void depositar(double valor) throws UsuarioInvalidoException {
        if (valor <= 0) {
            throw new UsuarioInvalidoException("valor", valor, "Valor do depósito deve ser positivo");
        }
        saldo += valor;
        System.out.println(String.format("✅ Depósito realizado: R$ %.2f (saldo: R$ %.2f)", valor, saldo));
    }
    
    // Método que pode falhar ao acessar arquivo (IOException)
    public void salvarExtrato(String nomeArquivo) throws IOException {
        // Simula operação que pode falhar
        if (nomeArquivo.contains("*")) {
            throw new IOException("Nome de arquivo inválido: " + nomeArquivo);
        }
        
        // Não vamos realmente criar arquivo, só simular
        System.out.println("📄 Extrato salvo em: " + nomeArquivo);
    }
    
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
}

// ==========================================
// 3. SERVIÇO BANCÁRIO (Demonstrando diferentes tipos de exceptions)
// ==========================================

class ServicoBancario {
    
    /**
     * 🏦 CRIAR CONTA: Pode lançar checked exception
     */
    public ContaBancaria criarConta(String titular, double saldoInicial) throws UsuarioInvalidoException {
        System.out.println("🏦 Criando conta para: " + titular);
        return new ContaBancaria(titular, saldoInicial);
    }
    
    /**
     * 💰 TRANSFERÊNCIA: Múltiplas exceptions possíveis
     */
    public void transferir(ContaBancaria origem, ContaBancaria destino, double valor) 
            throws UsuarioInvalidoException {
        
        System.out.println(String.format("🔄 Transferindo R$ %.2f de %s para %s", 
                                        valor, origem.getTitular(), destino.getTitular()));
        
        // Pode lançar SaldoInsuficienteException (unchecked)
        origem.sacar(valor);
        
        // Pode lançar UsuarioInvalidoException (checked)
        destino.depositar(valor);
        
        System.out.println("✅ Transferência concluída!");
    }
    
    /**
     * 📊 RELATÓRIO: Try-with-resources (como PHP finally)
     */
    public void gerarRelatorio(List<ContaBancaria> contas) {
        System.out.println("📊 Gerando relatório de contas...");
        
        // Try-with-resources (fecha automaticamente)
        try (Scanner scanner = new Scanner(System.in)) {
            
            for (ContaBancaria conta : contas) {
                System.out.println(String.format("• %s: R$ %.2f", 
                                                conta.getTitular(), conta.getSaldo()));
                
                // Simula tentativa de salvar (pode falhar)
                try {
                    String nomeArquivo = "extrato_" + conta.getTitular().toLowerCase() + ".txt";
                    conta.salvarExtrato(nomeArquivo);
                } catch (IOException e) {
                    System.out.println("⚠️ Erro ao salvar extrato: " + e.getMessage());
                }
            }
            
        } // Scanner é fechado automaticamente aqui
        
        System.out.println("📊 Relatório concluído!");
    }
}

// ==========================================
// 4. CLASSE PRINCIPAL COM DEMONSTRAÇÕES
// ==========================================

public class ExceptionHandlingExample {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("🚨 EXCEPTION HANDLING: PHP → JAVA");
        System.out.println("========================================\n");
        
        ServicoBancario servico = new ServicoBancario();
        
        demonstrarCheckedExceptions(servico);
        demonstrarUncheckedExceptions(servico);
        demonstrarMultiplasExceptions(servico);
        demonstrarTryWithResources(servico);
        demonstrarBestPractices();
    }
    
    /**
     * ✅ CHECKED EXCEPTIONS: Obrigatório tratar
     */
    private static void demonstrarCheckedExceptions(ServicoBancario servico) {
        System.out.println("✅ 1. CHECKED EXCEPTIONS (obrigatório tratar)");
        System.out.println("PHP: try { ... } catch (Exception $e) { ... }");
        System.out.println("Java: try { ... } catch (UsuarioInvalidoException e) { ... }\n");
        
        try {
            // Tentativa 1: Dados válidos
            ContaBancaria conta1 = servico.criarConta("João Silva", 1000.0);
            System.out.println("✅ Conta criada: " + conta1.getTitular());
            
            // Tentativa 2: Nome inválido (vai dar erro)
            ContaBancaria conta2 = servico.criarConta("", 500.0);
            
        } catch (UsuarioInvalidoException e) {
            System.out.println("🔴 Erro capturado: " + e.getMessage());
            System.out.println("   Campo: " + e.getCampo());
            System.out.println("   Valor: " + e.getValor());
        }
        
        System.out.println();
    }
    
    /**
     * 🔥 UNCHECKED EXCEPTIONS: Podem ou não ser tratadas
     */
    private static void demonstrarUncheckedExceptions(ServicoBancario servico) {
        System.out.println("🔥 2. UNCHECKED EXCEPTIONS (RuntimeException)");
        System.out.println("PHP: Pode capturar ou deixar 'explodir'");
        System.out.println("Java: Pode capturar ou deixar 'explodir'\n");
        
        try {
            ContaBancaria conta = servico.criarConta("Maria Santos", 100.0);
            
            // Tentativa de saque válido
            conta.sacar(50.0);
            
            // Tentativa de saque inválido (vai dar erro)
            conta.sacar(200.0);
            
        } catch (UsuarioInvalidoException e) {
            System.out.println("🔴 Erro ao criar conta: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("🔴 Erro no saque: " + e.getMessage());
            System.out.println("   Saldo atual: R$ " + String.format("%.2f", e.getSaldoAtual()));
            System.out.println("   Tentativa: R$ " + String.format("%.2f", e.getValorSaque()));
        }
        
        System.out.println();
    }
    
    /**
     * 🎯 MÚLTIPLAS EXCEPTIONS: Hierarquia de catch
     */
    private static void demonstrarMultiplasExceptions(ServicoBancario servico) {
        System.out.println("🎯 3. MÚLTIPLAS EXCEPTIONS (catch hierarchy)");
        System.out.println("PHP: catch (Exception $e) pega todas");
        System.out.println("Java: Ordem específica → geral\n");
        
        try {
            ContaBancaria origem = servico.criarConta("Pedro", 300.0);
            ContaBancaria destino = servico.criarConta("Ana", 200.0);
            
            // Transferência válida
            servico.transferir(origem, destino, 100.0);
            
            // Transferência inválida (saldo insuficiente)
            servico.transferir(origem, destino, 500.0);
            
        } catch (SaldoInsuficienteException e) {
            // Mais específica primeiro
            System.out.println("🔴 Saldo insuficiente: " + e.getMessage());
        } catch (UsuarioInvalidoException e) {
            // Menos específica depois
            System.out.println("🔴 Dados inválidos: " + e.getMessage());
        } catch (Exception e) {
            // Mais geral por último
            System.out.println("🔴 Erro inesperado: " + e.getMessage());
        } finally {
            // PHP: finally { ... }
            // Java: finally { ... }
            System.out.println("🔧 Limpeza sempre executada (finally)");
        }
        
        System.out.println();
    }
    
    /**
     * 🔄 TRY-WITH-RESOURCES: Auto-close (como PHP finally para recursos)
     */
    private static void demonstrarTryWithResources(ServicoBancario servico) {
        System.out.println("🔄 4. TRY-WITH-RESOURCES (auto-close)");
        System.out.println("PHP: finally { fclose($file); }");
        System.out.println("Java: try (Resource r = ...) { } // auto-close\n");
        
        List<ContaBancaria> contas = new ArrayList<>();
        
        try {
            contas.add(servico.criarConta("Cliente 1", 1000.0));
            contas.add(servico.criarConta("Cliente 2", 2000.0));
            contas.add(servico.criarConta("Cliente*Inválido", 500.0)); // Nome com * vai dar erro no arquivo
            
            servico.gerarRelatorio(contas);
            
        } catch (UsuarioInvalidoException e) {
            System.out.println("🔴 Erro ao criar conta: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 🎯 BEST PRACTICES: Dicas importantes
     */
    private static void demonstrarBestPractices() {
        System.out.println("🎯 5. BEST PRACTICES (dicas importantes)");
        
        System.out.println("\n📋 REGRAS DE OURO:");
        System.out.println("1. 🎯 Catch específico antes do genérico");
        System.out.println("2. 💬 Messages descritivas (não só \"erro\")");
        System.out.println("3. 🔍 Log exceptions importantes");
        System.out.println("4. 🧹 Use try-with-resources para recursos");
        System.out.println("5. ⚡ RuntimeException para erros de lógica");
        System.out.println("6. ✅ Checked Exception para erros recuperáveis");
        
        System.out.println("\n📊 COMPARAÇÃO FINAL:");
        System.out.println("┌─────────────────────┬─────────────────────┬─────────────────────┐");
        System.out.println("│        Aspecto      │         PHP         │        Java         │");
        System.out.println("├─────────────────────┼─────────────────────┼─────────────────────┤");
        System.out.println("│ Exception Base      │ Exception           │ Exception           │");
        System.out.println("│ Runtime Errors      │ Error (PHP 7+)      │ RuntimeException    │");
        System.out.println("│ Try/Catch           │ try/catch/finally   │ try/catch/finally   │");
        System.out.println("│ Custom Exception    │ extends Exception   │ extends Exception   │");
        System.out.println("│ Auto-cleanup        │ finally block       │ try-with-resources  │");
        System.out.println("│ Obrigatório tratar  │ Não                 │ Checked Exceptions  │");
        System.out.println("└─────────────────────┴─────────────────────┴─────────────────────┘");
        
        System.out.println("\n🎉 Exception Handling dominado! Próximo: Spring Boot prático!");
    }
}
