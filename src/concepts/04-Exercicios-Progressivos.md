# 🎯 **EXERCÍCIOS PROGRESSIVOS: TEORIA → PRÁTICA**

> **Aplicação dirigida dos conceitos: do básico ao enterprise com exercícios crescentes**

---

## 🎓 **METODOLOGIA DOS EXERCÍCIOS**

### **📊 NÍVEIS DE PROGRESSÃO**

```
🥉 BRONZE (Fundamentos)
├── Aplicar conceito isoladamente
├── Código funcional básico
└── Analogias diretas com PHP

🥈 PRATA (Integração)
├── Combinar múltiplos conceitos
├── Boas práticas aplicadas
└── Refatoração de código

🥇 OURO (Enterprise)
├── Design patterns avançados
├── Performance e escalabilidade
└── Arquitetura robusta
```

### **🔄 CICLO DE APRENDIZADO**

1. **📖 CONCEITO** → Entender teoria
2. **🎯 EXERCÍCIO** → Aplicar na prática
3. **🔍 REVISÃO** → Analisar solução
4. **⚡ REFATORAÇÃO** → Melhorar design
5. **🚀 INTEGRAÇÃO** → Usar em projeto maior

---

## 🥉 **NÍVEL BRONZE: FUNDAMENTOS**

### **📦 1. COLLECTIONS - Sistema de Biblioteca**

#### **🎯 OBJETIVO**
Praticar List, Set, Map com um cenário real e progressivo.

#### **📋 EXERCÍCIO 1.1: Catálogo Básico**
```java
// Implemente um sistema básico de biblioteca
public class Biblioteca {
    // TODO: Declarar collections apropriadas
    
    // 1. Lista de livros (pode ter múltiplas cópias do mesmo título)
    // 2. Set de autores (únicos)
    // 3. Map de ISBN -> Livro (busca rápida)
    
    public void adicionarLivro(Livro livro) {
        // TODO: Implementar
        // - Adicionar à lista de livros
        // - Adicionar autor ao set
        // - Mapear ISBN -> Livro
    }
    
    public List<Livro> buscarPorAutor(String autor) {
        // TODO: Usar Stream API
        // Filtrar livros por autor
    }
    
    public boolean temLivroDisponivel(String isbn) {
        // TODO: Verificar se existe no Map
    }
}

// Classe Livro básica
public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private boolean emprestado = false;
    
    // TODO: Construtores, getters, setters
    // TODO: equals() e hashCode() baseados no ISBN
}
```

#### **🔍 VALIDAÇÃO BRONZE 1.1**
- [ ] Usou **List** para permitir múltiplas cópias
- [ ] Usou **Set** para autores únicos
- [ ] Usou **Map** para busca rápida por ISBN
- [ ] Implementou **equals/hashCode** no Livro
- [ ] Usou **Stream API** na busca

#### **📋 EXERCÍCIO 1.2: Operações Avançadas**
```java
public class BibliotecaAvancada extends Biblioteca {
    
    public Map<String, Integer> contarLivrosPorAutor() {
        // TODO: Usar Stream API + Collectors.groupingBy
        // Retornar Map<Autor, QuantidadeLivros>
    }
    
    public Set<String> autoresComMaisDe(int quantidade) {
        // TODO: Filtrar autores com mais de X livros
    }
    
    public List<Livro> top5LivrosMaisEmprestados() {
        // TODO: Ordenar por número de empréstimos (descendente)
        // Retornar apenas os 5 primeiros
    }
}
```

### **🏗️ 2. OOP - Sistema de E-commerce**

#### **🎯 OBJETIVO**
Aplicar herança, polimorfismo, encapsulamento e interfaces.

#### **📋 EXERCÍCIO 2.1: Hierarquia de Produtos**
```java
// TODO: Criar hierarquia usando conceitos OOP

// Interface base
public interface Produto {
    BigDecimal calcularPreco();
    String getDescricao();
    boolean podeSerEnviado();
}

// Classe abstrata
public abstract class ProdutoFisico implements Produto {
    protected String nome;
    protected BigDecimal precoBase;
    protected double peso;
    
    // TODO: Implementar métodos comuns
    
    // Método abstrato - cada tipo calcula diferente
    public abstract BigDecimal calcularFrete(String cep);
}

// Classes concretas
public class Livro extends ProdutoFisico {
    private String autor;
    private String isbn;
    
    @Override
    public BigDecimal calcularPreco() {
        // TODO: Preço base + possível desconto para livros
    }
    
    @Override
    public BigDecimal calcularFrete(String cep) {
        // TODO: Frete especial para livros (mais barato)
    }
}

public class Eletronico extends ProdutoFisico {
    private String marca;
    private int garantiaMeses;
    
    @Override
    public BigDecimal calcularPreco() {
        // TODO: Preço base + taxa de garantia
    }
    
    @Override
    public BigDecimal calcularFrete(String cep) {
        // TODO: Frete por peso (eletrônicos são pesados)
    }
}

// Produto digital (não herda de ProdutoFisico)
public class SoftwareLicenca implements Produto {
    private String chaveAtivacao;
    private int duracaoMeses;
    
    @Override
    public boolean podeSerEnviado() {
        return false; // Digital não precisa envio
    }
    
    // TODO: Implementar outros métodos
}
```

#### **🔍 VALIDAÇÃO BRONZE 2.1**
- [ ] **Interface** define contrato comum
- [ ] **Classe abstrata** compartilha código comum
- [ ] **Herança** usada para relação "é-um" verdadeira
- [ ] **Polimorfismo** - mesmo método, comportamentos diferentes
- [ ] **Encapsulamento** - campos privados, métodos públicos

#### **📋 EXERCÍCIO 2.2: Carrinho Polimórfico**
```java
public class CarrinhoCompras {
    private List<Produto> produtos = new ArrayList<>();
    
    public void adicionarProduto(Produto produto) {
        // TODO: Adicionar produto (polimorfismo em ação)
    }
    
    public BigDecimal calcularTotal() {
        // TODO: Usar polimorfismo para calcular preço
        // Cada produto calcula seu preço de forma diferente
    }
    
    public List<Produto> produtosQueNecessitamEnvio() {
        // TODO: Filtrar apenas produtos físicos
        // Usar polimorfismo: produto.podeSerEnviado()
    }
    
    public BigDecimal calcularFreteTotal(String cep) {
        // TODO: Somar frete apenas de produtos físicos
        // Usar instanceof e cast seguro
    }
}
```

### **🚨 3. EXCEPTIONS - Sistema Bancário**

#### **🎯 OBJETIVO**
Praticar hierarquia de exceções e estratégias de tratamento.

#### **📋 EXERCÍCIO 3.1: Hierarquia de Exceções**
```java
// TODO: Criar hierarquia bem projetada

// Exception base do domínio bancário
public abstract class ContaException extends Exception {
    private final String numeroConta;
    private final LocalDateTime timestamp;
    
    // TODO: Construtor, getters
    // TODO: Método abstrato getSugestaoRecuperacao()
}

// Exceções específicas (checked - condições recuperáveis)
public class SaldoInsuficienteException extends ContaException {
    private final BigDecimal saldoAtual;
    private final BigDecimal valorSolicitado;
    
    // TODO: Construtor com context rico
    // TODO: Implementar getSugestaoRecuperacao()
}

public class ContaInexistenteException extends ContaException {
    // TODO: Implementar
}

public class ContaBloqueadaException extends ContaException {
    private final MotivoBloqueio motivo;
    
    // TODO: Implementar com enum MotivoBloqueio
}

// Exception de programação (unchecked)
public class OperacaoInvalidaException extends RuntimeException {
    // TODO: Para erros de programação (valor negativo, etc)
}
```

#### **📋 EXERCÍCIO 3.2: Sistema de Conta**
```java
public class ContaBancaria {
    private String numero;
    private BigDecimal saldo;
    private boolean bloqueada = false;
    
    public void sacar(BigDecimal valor) throws ContaException {
        // TODO: Implementar validações com exceptions apropriadas
        // 1. Valor deve ser positivo (RuntimeException)
        // 2. Conta não pode estar bloqueada (ContaBloqueadaException)
        // 3. Saldo deve ser suficiente (SaldoInsuficienteException)
    }
    
    public void transferir(ContaBancaria destino, BigDecimal valor) throws ContaException {
        // TODO: Usar métodos que podem lançar exceptions
        // Pensar em: o que fazer se sacar funciona mas depositar falha?
    }
}

// Classe de uso
public class ServicoBancario {
    public void processarTransferencia(String contaOrigem, String contaDestino, BigDecimal valor) {
        try {
            // TODO: Implementar com tratamento adequado
            // Diferentes tipos de exception = diferentes tratamentos
            
        } catch (SaldoInsuficienteException e) {
            // TODO: Tratamento específico - oferecer opções
            
        } catch (ContaBloqueadaException e) {
            // TODO: Tratamento específico - notificar motivo
            
        } catch (ContaException e) {
            // TODO: Tratamento genérico para outras exceções de conta
            
        } catch (Exception e) {
            // TODO: Log e erro genérico
        }
    }
}
```

#### **🔍 VALIDAÇÃO BRONZE 3**
- [ ] **Hierarquia** lógica de exceções
- [ ] **Checked vs Unchecked** usado apropriadamente
- [ ] **Context rico** nas exceções
- [ ] **Tratamento específico** por tipo de exception
- [ ] **Exception chaining** preservando causa original

---

## 🥈 **NÍVEL PRATA: INTEGRAÇÃO**

### **🎯 PROJETO INTEGRADO: Sistema de Blog**

Combinar Collections + OOP + Exceptions em um projeto coeso.

#### **📋 EXERCÍCIO PRATA 1: Design Completo**
```java
// TODO: Implementar sistema completo aplicando todos os conceitos

// 1. HIERARQUIA OOP
public abstract class ConteudoBlog {
    protected Long id;
    protected String titulo;
    protected String autor;
    protected LocalDateTime dataPublicacao;
    protected Set<String> tags = new HashSet<>();
    
    // TODO: Métodos abstratos para polimorfismo
    public abstract String getTipoConteudo();
    public abstract int getTempoLeituraMinutos();
}

public class Post extends ConteudoBlog {
    private String corpo;
    private List<Comentario> comentarios = new ArrayList<>();
    
    // TODO: Implementar métodos abstratos
    // TODO: Métodos específicos de Post
}

public class Video extends ConteudoBlog {
    private String urlVideo;
    private int duracaoSegundos;
    
    // TODO: Implementar métodos abstratos
}

// 2. EXCEPTIONS ESPECÍFICAS
public class BlogException extends Exception {
    // TODO: Base para exceções do blog
}

public class ConteudoNaoEncontradoException extends BlogException {
    // TODO: Quando busca não encontra resultado
}

public class AutorizacaoException extends BlogException {
    // TODO: Quando usuário não pode fazer operação
}

// 3. COLLECTIONS E BUSINESS LOGIC
public class ServicoBlog {
    private Map<Long, ConteudoBlog> conteudos = new HashMap<>();
    private Map<String, Set<Long>> indiceAutores = new HashMap<>();
    private Map<String, Set<Long>> indiceTags = new HashMap<>();
    
    public void publicarConteudo(ConteudoBlog conteudo) throws BlogException {
        // TODO: 
        // 1. Validar conteúdo
        // 2. Adicionar aos Maps
        // 3. Atualizar índices
        // 4. Tratar exceções apropriadas
    }
    
    public List<ConteudoBlog> buscarPorAutor(String autor) {
        // TODO: Usar índice para busca eficiente
    }
    
    public List<ConteudoBlog> buscarPorTag(String tag) {
        // TODO: Interseção de Sets para múltiplas tags
    }
    
    public Map<String, Long> estatisticasPorTipo() {
        // TODO: Stream API + Collectors.groupingBy + counting
    }
}
```

#### **🔍 VALIDAÇÃO PRATA**
- [ ] **OOP completo** - herança, polimorfismo, encapsulamento
- [ ] **Collections eficientes** - Map para busca, Set para unicidade
- [ ] **Exceptions contextuais** - hierarquia específica do domínio
- [ ] **Stream API avançada** - groupingBy, filtering, collecting
- [ ] **Design patterns** - Strategy, Observer (se aplicável)

---

## 🥇 **NÍVEL OURO: ENTERPRISE**

### **🚀 PROJETO ENTERPRISE: Sistema de E-commerce Completo**

Aplicar design patterns, performance e arquitetura robusta.

#### **📋 EXERCÍCIO OURO: Arquitetura Completa**
```java
// TODO: Implementar sistema enterprise com todos os conceitos avançados

// 1. DESIGN PATTERNS

// Factory Pattern
public class ProcessadorPagamentoFactory {
    public static ProcessadorPagamento criar(TipoPagamento tipo) {
        // TODO: Factory method com Strategy pattern
    }
}

// Observer Pattern para eventos
@Component
public class PublicadorEventos {
    @Autowired
    private ApplicationEventPublisher publisher;
    
    public void pedidoCriado(Pedido pedido) {
        // TODO: Publicar evento para múltiplos listeners
    }
}

// 2. EXCEPTION HANDLING ENTERPRISE
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        // TODO: Tratamento centralizado com logging e métricas
    }
    
    // TODO: Outros handlers específicos
}

// 3. COLLECTIONS OTIMIZADAS
@Service
public class CacheInteligente<K, V> {
    private final Map<K, V> cache = new ConcurrentHashMap<>();
    private final Map<K, LocalDateTime> timestamps = new ConcurrentHashMap<>();
    
    public Optional<V> get(K key) {
        // TODO: Cache com TTL, cleanup automático
    }
    
    // TODO: Métodos thread-safe para ambiente enterprise
}

// 4. ARQUITETURA ROBUSTA
@Service
@Transactional
public class ServicoVendas {
    
    // TODO: Combinar todos os conceitos:
    // - Repository pattern
    // - Exception handling robusto
    // - Business rules com Strategy
    // - Events para desacoplamento
    // - Caching inteligente
    // - Validações em camadas
    
    public Pedido processarVenda(DadosVenda dados) throws VendaException {
        // TODO: Implementação enterprise completa
    }
}
```

#### **🏆 OBJETIVOS ENTERPRISE**
- [ ] **Performance** - Collections otimizadas, caching
- [ ] **Concorrência** - Thread-safety onde necessário
- [ ] **Observabilidade** - Logging, métricas, tracing
- [ ] **Resilência** - Circuit breaker, retry, fallbacks
- [ ] **Manutenibilidade** - SOLID, Clean Code, testes

---

## 📚 **GUIA DE AUTOAVALIAÇÃO**

### **🎯 CHECKLIST POR NÍVEL**

#### **🥉 BRONZE: Dominei os fundamentos?**
- [ ] Escolho a Collection certa para cada cenário
- [ ] Aplico OOP básico com herança e polimorfismo
- [ ] Crio hierarquias de exceções lógicas
- [ ] Uso Stream API para operações básicas

#### **🥈 PRATA: Integro conceitos?**
- [ ] Combino Collections + OOP + Exceptions harmoniosamente
- [ ] Aplico design patterns básicos (Strategy, Factory)
- [ ] Penso em performance ao escolher implementações
- [ ] Trato exceptions de forma contextual

#### **🥇 OURO: Arquiteto soluções enterprise?**
- [ ] Projeto sistemas robustos e escaláveis
- [ ] Aplico patterns avançados apropriadamente
- [ ] Considero concorrência e thread-safety
- [ ] Implemento observabilidade e resilência

### **🚀 PRÓXIMOS PASSOS**
1. **Implemente os exercícios** progressivamente
2. **Compare suas soluções** com as boas práticas
3. **Refatore** aplicando conceitos mais avançados
4. **Integre** em um projeto Spring Boot real

---

🎯 **OBJETIVO FINAL:** Ter aplicado todos os conceitos fundamentais Java em projetos práticos, preparando-se para desenvolvimento Spring Boot enterprise!
