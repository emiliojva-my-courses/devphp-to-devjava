# 🚨 **EXCEPTION HANDLING: DESIGN E ESTRATÉGIAS**

> **Criando sistemas robustos: da estratégia de error handling à arquitetura de recuperação**

---

## 🎯 **FILOSOFIA DE EXCEPTION HANDLING**

### **💡 MINDSET FUNDAMENTAL**

**Exceptions não são "erros"** - são **eventos excepcionais** que requerem **tratamento específico**.

```php
// PHP: Exceptions como "último recurso"
try {
    $resultado = dividir($a, $b);
    return $resultado;
} catch (Exception $e) {
    error_log($e->getMessage());
    return null;  // Valor "padrão"
}
```

```java
// Java: Exceptions como parte do design
public BigDecimal dividir(BigDecimal a, BigDecimal b) throws DivisaoPorZeroException {
    if (b.equals(BigDecimal.ZERO)) {
        throw new DivisaoPorZeroException("Divisão por zero: " + a + " / " + b);
    }
    return a.divide(b, 2, RoundingMode.HALF_UP);
}

// Cliente é FORÇADO a tratar
try {
    BigDecimal resultado = calculadora.dividir(x, y);
    // Código só executa se deu certo
} catch (DivisaoPorZeroException e) {
    // Tratamento específico para este caso
}
```

### **🎯 HIERARQUIA CONCEITUAL**

```
Throwable (nunca capturar diretamente)
├── Error (problemas do sistema - não capturar)
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception (problemas da aplicação)
    ├── IOException (checked - obrigatório tratar)
    ├── SQLException (checked)
    ├── ClassNotFoundException (checked)
    │
    └── RuntimeException (unchecked - opcional tratar)
        ├── NullPointerException
        ├── IllegalArgumentException
        ├── IllegalStateException
        └── BusinessRuleException (custom)
```

---

## 🏗️ **CHECKED vs UNCHECKED: QUANDO USAR**

### **✅ CHECKED EXCEPTIONS: Para condições recuperáveis**

#### **💡 QUANDO USAR**
- ✅ **Condições esperadas** que podem ser recuperadas
- ✅ **Recursos externos** (arquivo, rede, banco)
- ✅ **Validações de entrada** críticas
- ✅ **Forçar** o cliente a decidir o que fazer

```java
// ✅ BOM: Condição recuperável esperada
public class fundamentals.

ContaBancaria {

    public void sacar (BigDecimal valor) throws legacy.fundamentals.SaldoInsuficienteException {
        if (valor.compareTo(saldo) > 0) {
            // Condição esperada que pode ser recuperada
            throw new legacy.fundamentals.SaldoInsuficienteException(
                    String.format("Saldo insuficiente. Disponível: %s, Solicitado: %s",
                            saldo, valor)
            );
        }
        saldo = saldo.subtract(valor);
    }
}

// Cliente DEVE decidir como tratar
try{
        conta.

sacar(new BigDecimal("1000"));

exibirSucesso("Saque realizado");
}catch(
legacy.fundamentals.SaldoInsuficienteException e){

// Recuperação: oferecer opções ao usuário
exibirOpcoes("Saldo insuficiente",Arrays.asList(
        "Sacar valor disponível: "+conta.getSaldo(),
        "Cancelar operação",
                "Transferir de outra conta"
                ));
                }
```

#### **🏗️ DESIGN DE CHECKED EXCEPTIONS**

```java
// Hierarquia bem projetada
public abstract class ContaException extends Exception {
    private final String codigoConta;
    private final LocalDateTime timestamp;
    
    protected ContaException(String message, String codigoConta) {
        super(message);
        this.codigoConta = codigoConta;
        this.timestamp = LocalDateTime.now();
    }
    
    public abstract String getSugestaoRecuperacao();
    
    // Getters...
}

public class legacy.fundamentals.SaldoInsuficienteException extends ContaException {
    private final BigDecimal saldoDisponivel;
    private final BigDecimal valorSolicitado;
    
    public legacy.fundamentals.SaldoInsuficienteException(String codigoConta, BigDecimal disponivel, BigDecimal solicitado) {
        super(String.format("Saldo insuficiente na conta %s", codigoConta), codigoConta);
        this.saldoDisponivel = disponivel;
        this.valorSolicitado = solicitado;
    }
    
    @Override
    public String getSugestaoRecuperacao() {
        return String.format("Valor máximo disponível: %s", saldoDisponivel);
    }
}

public class ContaBloqueadaException extends ContaException {
    private final MotivosBloqueio motivo;
    
    public ContaBloqueadaException(String codigoConta, MotivosBloqueio motivo) {
        super(String.format("Conta %s bloqueada: %s", codigoConta, motivo), codigoConta);
        this.motivo = motivo;
    }
    
    @Override
    public String getSugestaoRecuperacao() {
        return switch (motivo) {
            case SUSPEITA_FRAUDE -> "Entre em contato com nossa central de segurança";
            case DOCUMENTOS_PENDENTES -> "Atualize seus documentos na agência";
            case MANUTENCAO -> "Tente novamente em alguns minutos";
        };
    }
}
```

### **⚡ UNCHECKED EXCEPTIONS: Para erros de programação**

#### **💡 QUANDO USAR**
- ✅ **Erros de programação** (bugs)
- ✅ **Violações de contrato** de método
- ✅ **Estados inválidos** que não deveriam ocorrer
- ✅ **Falhas rápidas** (fail-fast)

```java
// ✅ BOM: Erro de programação
public class ValidadorCPF {
    
    public boolean validar(String cpf) {
        // RuntimeException para entrada inválida (erro do programador)
        if (cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser null");
        }
        
        if (cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        
        // Validação real...
        return validarDigitos(cpf);
    }
}

// ✅ BOM: Estado inválido
public class Pedido {
    private StatusPedido status;
    
    public void confirmar() {
        // RuntimeException para estado inválido
        if (status == StatusPedido.CANCELADO) {
            throw new IllegalStateException(
                "Não é possível confirmar pedido cancelado: " + getId()
            );
        }
        
        if (status == StatusPedido.CONFIRMADO) {
            throw new IllegalStateException(
                "Pedido já confirmado: " + getId()
            );
        }
        
        this.status = StatusPedido.CONFIRMADO;
    }
}
```

#### **🏗️ UNCHECKED EXCEPTIONS CUSTOMIZADAS**

```java
// Base para exceptions de negócio
public abstract class BusinessException extends RuntimeException {
    private final String errorCode;
    private final Map<String, Object> context;
    
    protected BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.context = new HashMap<>();
    }
    
    public BusinessException addContext(String key, Object value) {
        context.put(key, value);
        return this;
    }
    
    public abstract HttpStatus getHttpStatus();
    public abstract String getUserMessage();
}

// Exceções específicas de domínio
public class ProdutoIndisponivelException extends BusinessException {
    
    public ProdutoIndisponivelException(String produtoId, int estoqueAtual) {
        super("PRODUTO_INDISPONIVEL", 
              String.format("Produto %s indisponível (estoque: %d)", produtoId, estoqueAtual));
        addContext("produtoId", produtoId);
        addContext("estoqueAtual", estoqueAtual);
    }
    
    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
    
    @Override
    public String getUserMessage() {
        return "Produto não disponível no momento. Tente novamente mais tarde.";
    }
}

public class UsuarioNaoAutorizadoException extends BusinessException {
    
    public UsuarioNaoAutorizadoException(String usuarioId, String recurso) {
        super("ACESSO_NEGADO", 
              String.format("Usuário %s não autorizado para %s", usuarioId, recurso));
        addContext("usuarioId", usuarioId);
        addContext("recurso", recurso);
    }
    
    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }
    
    @Override
    public String getUserMessage() {
        return "Você não tem permissão para realizar esta operação.";
    }
}
```

---

## 🏛️ **ARQUITETURA DE EXCEPTION HANDLING**

### **🎯 1. GLOBAL EXCEPTION HANDLER**

#### **Spring Boot - Tratamento Centralizado**

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    // Business exceptions (nossas)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        logger.warn("Business exception: {}", ex.getMessage(), ex);
        
        ErrorResponse error = ErrorResponse.builder()
            .code(ex.getErrorCode())
            .message(ex.getUserMessage())
            .timestamp(LocalDateTime.now())
            .context(ex.getContext())
            .build();
            
        return ResponseEntity.status(ex.getHttpStatus()).body(error);
    }
    
    // Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        logger.warn("Validation error: {}", ex.getMessage());
        
        Map<String, String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage
            ));
        
        ErrorResponse error = ErrorResponse.builder()
            .code("VALIDATION_ERROR")
            .message("Dados inválidos")
            .timestamp(LocalDateTime.now())
            .context(Map.of("fields", errors))
            .build();
            
        return ResponseEntity.badRequest().body(error);
    }
    
    // Database errors
    @ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorResponse> handleDataException(Exception ex) {
        logger.error("Database error: {}", ex.getMessage(), ex);
        
        ErrorResponse error = ErrorResponse.builder()
            .code("DATA_ERROR")
            .message("Erro na operação de dados")
            .timestamp(LocalDateTime.now())
            .build();
            
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    
    // Catch-all (nunca deveria chegar aqui)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error("Unexpected error: {}", ex.getMessage(), ex);
        
        ErrorResponse error = ErrorResponse.builder()
            .code("INTERNAL_ERROR")
            .message("Erro interno do servidor")
            .timestamp(LocalDateTime.now())
            .build();
            
        return ResponseEntity.internalServerError().body(error);
    }
}

// Response padronizada
@Data
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private LocalDateTime timestamp;
    private Map<String, Object> context;
}
```

### **🎯 2. TRY-WITH-RESOURCES AVANÇADO**

#### **💡 Auto-close para múltiplos recursos**

```java
// ✅ BOM: Múltiplos recursos auto-closed
public void processarArquivo(String inputPath, String outputPath) throws ProcessamentoException {
    
    try (
        FileInputStream input = new FileInputStream(inputPath);
        FileOutputStream output = new FileOutputStream(outputPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        PrintWriter writer = new PrintWriter(output)
    ) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String processada = processarLinha(linha);
            writer.println(processada);
        }
        
    } catch (IOException e) {
        throw new ProcessamentoException("Erro ao processar arquivo: " + inputPath, e);
    }
    // Todos os recursos fechados automaticamente, mesmo se houver exception
}

// Custom AutoCloseable
public class ConexaoBanco implements AutoCloseable {
    private Connection connection;
    private boolean transacaoAtiva = false;
    
    public void iniciarTransacao() throws SQLException {
        connection.setAutoCommit(false);
        transacaoAtiva = true;
    }
    
    public void commit() throws SQLException {
        if (transacaoAtiva) {
            connection.commit();
            transacaoAtiva = false;
        }
    }
    
    @Override
    public void close() throws SQLException {
        try {
            if (transacaoAtiva) {
                connection.rollback();  // Rollback automático se não commitou
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}

// Uso: transação automática
public void transferirDinheiro(Long contaOrigem, Long contaDestino, BigDecimal valor) 
        throws TransferenciaException {
    
    try (ConexaoBanco conexao = new ConexaoBanco()) {
        conexao.iniciarTransacao();
        
        sacarDaConta(contaOrigem, valor, conexao);
        depositarNaConta(contaDestino, valor, conexao);
        
        conexao.commit();
        
    } catch (SQLException e) {
        // Rollback automático no close()
        throw new TransferenciaException("Erro na transferência", e);
    }
}
```

### **🎯 3. EXCEPTION CHAINING E WRAPPING**

#### **💡 Preservar contexto original**

```java
public class ServicoUsuario {
    
    public Usuario buscarPorEmail(String email) throws UsuarioNaoEncontradoException {
        try {
            // Pode lançar SQLException
            return repositorio.buscarPorEmail(email);
            
        } catch (SQLException e) {
            // Wrap preservando causa original
            throw new UsuarioNaoEncontradoException(
                "Erro ao buscar usuário por email: " + email, 
                e  // Causa original preservada
            );
        }
    }
}

// Exception handling com context
public class ProcessadorPedidos {
    
    public void processarPedido(Pedido pedido) throws ProcessamentoPedidoException {
        String step = "validacao";
        try {
            step = "validacao";
            validarPedido(pedido);
            
            step = "calculo";
            calcularTotais(pedido);
            
            step = "estoque";
            reservarEstoque(pedido);
            
            step = "pagamento";
            processarPagamento(pedido);
            
            step = "entrega";
            agendarEntrega(pedido);
            
        } catch (Exception e) {
            // Context rico na exception
            throw new ProcessamentoPedidoException(
                String.format("Erro no step '%s' do pedido %s", step, pedido.getId()),
                e
            ).addContext("step", step)
             .addContext("pedidoId", pedido.getId())
             .addContext("valorTotal", pedido.getValorTotal());
        }
    }
}
```

---

## 🎯 **PATTERNS DE EXCEPTION HANDLING**

### **🔄 1. RETRY PATTERN**

#### **💡 Para falhas transitórias**

```java
@Component
public class ServiceWithRetry {
    
    private static final int MAX_RETRIES = 3;
    private static final Duration WAIT_DURATION = Duration.ofSeconds(1);
    
    @Retryable(
        value = {TransientException.class},
        maxAttempts = MAX_RETRIES,
        backoff = @Backoff(delay = 1000)
    )
    public String chamarServicoExterno(String request) throws ServiceException {
        try {
            // Chamada que pode falhar temporariamente
            return httpClient.post("/api/service", request);
            
        } catch (IOException e) {
            throw new TransientException("Falha temporária na comunicação", e);
        }
    }
    
    @Recover
    public String recover(TransientException ex, String request) {
        logger.error("Falha após {} tentativas: {}", MAX_RETRIES, ex.getMessage());
        throw new ServiceException("Serviço indisponível após múltiplas tentativas", ex);
    }
}
```

### **💔 2. CIRCUIT BREAKER PATTERN**

#### **💡 Para proteção contra cascata de falhas**

```java
@Component
public class ServiceWithCircuitBreaker {
    
    private final CircuitBreaker circuitBreaker;
    
    public ServiceWithCircuitBreaker() {
        this.circuitBreaker = CircuitBreaker.ofDefaults("servicoExterno");
        
        circuitBreaker.getEventPublisher()
            .onStateTransition(event -> 
                logger.info("Circuit breaker transition: {} -> {}", 
                          event.getStateTransition().getFromState(), 
                          event.getStateTransition().getToState())
            );
    }
    
    public String chamarComProtecao(String request) {
        return circuitBreaker.executeSupplier(() -> {
            try {
                return servicoExterno.chamar(request);
            } catch (Exception e) {
                throw new RuntimeException("Falha no serviço externo", e);
            }
        });
    }
    
    public String chamarComFallback(String request) {
        try {
            return chamarComProtecao(request);
        } catch (CallNotPermittedException e) {
            // Circuit breaker aberto - usar fallback
            logger.warn("Circuit breaker aberto, usando fallback");
            return gerarRespostaFallback(request);
        }
    }
}
```

### **📊 3. EXCEPTION AGGREGATION**

#### **💡 Para coletar múltiplos erros**

```java
public class ValidadorCompleto {
    
    public void validarUsuario(Usuario usuario) throws ValidationException {
        ValidationContext context = new ValidationContext();
        
        // Coletar todos os erros, não parar no primeiro
        validarNome(usuario.getNome(), context);
        validarEmail(usuario.getEmail(), context);
        validarIdade(usuario.getIdade(), context);
        validarDocumentos(usuario.getDocumentos(), context);
        
        // Lançar se houver erros
        if (context.hasErrors()) {
            throw new ValidationException("Múltiplos erros de validação", context.getErrors());
        }
    }
    
    private void validarNome(String nome, ValidationContext context) {
        if (nome == null || nome.trim().isEmpty()) {
            context.addError("nome", "Nome é obrigatório");
        } else if (nome.length() < 2) {
            context.addError("nome", "Nome deve ter pelo menos 2 caracteres");
        }
    }
    
    // Outros validadores...
}

public class ValidationContext {
    private final Map<String, List<String>> errors = new HashMap<>();
    
    public void addError(String field, String message) {
        errors.computeIfAbsent(field, k -> new ArrayList<>()).add(message);
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
    
    public Map<String, List<String>> getErrors() {
        return Collections.unmodifiableMap(errors);
    }
}
```

---

## 🔍 **DEBUGGING E OBSERVABILIDADE**

### **📝 1. LOGGING ESTRUTURADO**

```java
@Service
public class ProcessadorPedidos {
    
    private static final Logger logger = LoggerFactory.getLogger(ProcessadorPedidos.class);
    
    public void processar(Pedido pedido) {
        MDC.put("pedidoId", pedido.getId().toString());
        MDC.put("usuarioId", pedido.getUsuarioId().toString());
        
        try {
            logger.info("Iniciando processamento do pedido");
            
            step("VALIDACAO", () -> validarPedido(pedido));
            step("ESTOQUE", () -> reservarEstoque(pedido));
            step("PAGAMENTO", () -> processarPagamento(pedido));
            
            logger.info("Pedido processado com sucesso");
            
        } catch (Exception e) {
            logger.error("Erro no processamento do pedido", e);
            throw e;
        } finally {
            MDC.clear();
        }
    }
    
    private void step(String stepName, Runnable action) {
        MDC.put("step", stepName);
        try {
            logger.debug("Iniciando step: {}", stepName);
            long start = System.currentTimeMillis();
            
            action.run();
            
            long duration = System.currentTimeMillis() - start;
            logger.debug("Step {} concluído em {}ms", stepName, duration);
            
        } catch (Exception e) {
            logger.error("Erro no step: {}", stepName, e);
            throw e;
        }
    }
}
```

### **📊 2. MÉTRICAS DE EXCEPTIONS**

```java
@Component
public class ExceptionMetrics {
    
    private final Counter.Builder exceptionCounter;
    private final Timer.Builder exceptionTimer;
    
    public ExceptionMetrics(MeterRegistry meterRegistry) {
        this.exceptionCounter = Counter.builder("exceptions_total")
            .description("Total de exceptions por tipo")
            .register(meterRegistry);
            
        this.exceptionTimer = Timer.builder("exception_handling_duration")
            .description("Tempo para tratar exceptions")
            .register(meterRegistry);
    }
    
    @EventListener
    public void onException(ExceptionEvent event) {
        exceptionCounter
            .tag("type", event.getException().getClass().getSimpleName())
            .tag("severity", event.getSeverity().name())
            .increment();
    }
}
```

---

## 🎓 **CHECKLIST DE EXCEPTION DESIGN**

### **🏗️ Design de Exceptions**
- [ ] **Hierarquia clara**: Base → Específicas
- [ ] **Checked vs Unchecked**: Decisão consciente baseada no cenário
- [ ] **Mensagens descritivas**: Context suficiente para debugging
- [ ] **Exception chaining**: Preservo causa original
- [ ] **Context rico**: Dados relevantes para análise

### **🎯 Estratégias de Handling**
- [ ] **Global handler**: Tratamento centralizado consistente
- [ ] **Try-with-resources**: Auto-cleanup de recursos
- [ ] **Fail-fast**: Falho rapidamente em estados inválidos
- [ ] **Graceful degradation**: Fallbacks quando possível
- [ ] **Retry strategies**: Para falhas transitórias

### **📊 Observabilidade**
- [ ] **Logging estruturado**: Context consistente
- [ ] **Métricas**: Tracking de exceptions
- [ ] **Alertas**: Notificação em exceptions críticas
- [ ] **Correlation IDs**: Rastreamento entre serviços
- [ ] **Health checks**: Monitoramento proativo

---

🚀 **PRÓXIMA ETAPA:** **Spring Boot Architecture** - Como integrar todo esse conhecimento OOP e Exception Handling em uma aplicação Spring Boot robusta e escalável!
