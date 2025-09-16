# 🏗️ **OOP JAVA: PRINCÍPIOS E PADRÕES**

> **Da teoria SOLID à prática: construindo código robusto e manutenível**

---

## 🎯 **ORIENTAÇÃO A OBJETOS: ALÉM DO BÁSICO**

### **💡 DIFERENÇA FUNDAMENTAL**

**PHP OOP** → Funcional com recursos OOP  
**Java OOP** → Fundamentalmente orientado a objetos desde o core

```php
// PHP: Pode misturar paradigmas
function calcular($a, $b) { return $a + $b; }  // Funcional
class Calculadora { ... }                       // OOP

$result = calcular(2, 3);                       // Funcional
$calc = new Calculadora();                      // OOP
```

```java
// Java: Tudo é orientado a objetos
public class MathUtils {
    public static int calcular(int a, int b) { return a + b; }  // Método estático
}

public class Calculadora {
    public int calcular(int a, int b) { return a + b; }         // Método de instância
}

// Uso sempre através de classes
int result = MathUtils.calcular(2, 3);          // Classe utilitária
Calculadora calc = new Calculadora();           // Instância
```

---

## 🏛️ **OS 4 PILARES DA OOP**

### **🔒 1. ENCAPSULAMENTO**

#### **💡 CONCEITO**
**Esconder detalhes internos** e expor apenas o que é necessário através de uma interface controlada.

#### **🎯 QUANDO APLICAR**
- ✅ Proteger **estado interno** de modificações indevidas
- ✅ Controlar **como** dados são acessados/modificados  
- ✅ Permitir **evolução** sem quebrar código cliente
- ✅ Aplicar **validações** em mudanças de estado

#### **📖 COMPARAÇÃO LARAVEL**
```php
// Laravel: Encapsulamento básico
class Usuario {
    private $senha;  // Privado
    
    public function setSenha($novaSenha) {
        $this->senha = password_hash($novaSenha, PASSWORD_DEFAULT);
    }
    
    public function verificarSenha($senha) {
        return password_verify($senha, $this->senha);
    }
}
```

```java
// Java: Encapsulamento robusto
public class Usuario {
    private String senha;           // Campo privado
    private LocalDateTime ultimoLogin;
    
    // Setter com validação
    public void setSenha(String novaSenha) {
        if (novaSenha == null || novaSenha.length() < 8) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 8 caracteres");
        }
        this.senha = BCrypt.hashpw(novaSenha, BCrypt.gensalt());
    }
    
    // Getter controlado (não expor senha diretamente)
    public boolean verificarSenha(String senha) {
        return BCrypt.checkpw(senha, this.senha);
    }
    
    // Acesso controlado a data
    public LocalDateTime getUltimoLogin() {
        return ultimoLogin != null ? ultimoLogin : LocalDateTime.of(1970, 1, 1, 0, 0);
    }
}
```

#### **🏆 BOAS PRÁTICAS**
```java
// ✅ BOM: Encapsulamento completo
public class fundamentals.ContaBancaria {
    private BigDecimal saldo;           // Nunca público
    private List<Transacao> historico;  // Coleção protegida
    
    public BigDecimal getSaldo() {
        return saldo;                   // Retorna cópia (BigDecimal é imutável)
    }
    
    public List<Transacao> getHistorico() {
        return Collections.unmodifiableList(historico);  // Lista não modificável
    }
    
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        saldo = saldo.add(valor);
        historico.add(new Transacao(TipoTransacao.DEPOSITO, valor));
    }
}

// ❌ RUIM: Exposição desnecessária
public class ContaRuim {
    public BigDecimal saldo;            // Público - qualquer um pode modificar!
    public List<Transacao> historico;   // Lista modificável exposta
}
```

### **🧬 2. HERANÇA**

#### **💡 CONCEITO**
**Reutilizar** código e estabelecer **relacionamento "é-um"** entre classes.

#### **🎯 QUANDO APLICAR**
- ✅ Relação **"é-um"** clara (Cachorro é-um Animal)
- ✅ **Compartilhar** comportamento comum
- ✅ **Especializar** comportamento existente
- ✅ Aplicar **polimorfismo**

#### **⚠️ QUANDO NÃO USAR**
- ❌ Relação **"tem-um"** (usar composição)
- ❌ **Forçar** reutilização de código não relacionado
- ❌ Criar **hierarquias muito profundas**

#### **📖 EXEMPLO PRÁTICO**
```java
// Hierarquia bem projetada
public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    
    // Comportamento comum
    public void ligar() {
        System.out.println("Veículo ligado");
    }
    
    // Método abstrato - cada tipo implementa diferente
    public abstract double calcularConsumo(double distancia);
    
    // Template Method Pattern
    public final void iniciarViagem() {
        verificarCombustivel();
        ligar();
        ajustarRetrovisores();
    }
    
    protected abstract void verificarCombustivel();
    protected abstract void ajustarRetrovisores();
}

public class Carro extends Veiculo {
    private int numeroPortas;
    
    @Override
    public double calcularConsumo(double distancia) {
        return distancia / 12.0;  // 12 km/l
    }
    
    @Override
    protected void verificarCombustivel() {
        System.out.println("Verificando tanque de gasolina");
    }
    
    @Override
    protected void ajustarRetrovisores() {
        System.out.println("Ajustando retrovisores do carro");
    }
}

public class Moto extends Veiculo {
    private boolean temBagageiro;
    
    @Override
    public double calcularConsumo(double distancia) {
        return distancia / 35.0;  // 35 km/l
    }
    
    @Override
    protected void verificarCombustivel() {
        System.out.println("Verificando tanque da moto");
    }
    
    @Override
    protected void ajustarRetrovisores() {
        System.out.println("Ajustando espelhos da moto");
    }
}
```

### **🎭 3. POLIMORFISMO**

#### **💡 CONCEITO**
**Mesmo método, comportamentos diferentes** baseado no tipo real do objeto em runtime.

#### **🎯 VANTAGENS**
- ✅ **Flexibilidade** - adicionar novos tipos sem modificar código existente
- ✅ **Manutenibilidade** - mudanças localizadas
- ✅ **Testabilidade** - mock objects
- ✅ **Extensibilidade** - Open/Closed Principle

#### **📖 EXEMPLO PRÁTICO**
```java
// Interface comum
public interface ProcessadorPagamento {
    ResultadoPagamento processar(BigDecimal valor, DadosPagamento dados);
    boolean suportaMoeda(Moeda moeda);
}

// Implementações específicas
public class ProcessadorCartao implements ProcessadorPagamento {
    @Override
    public ResultadoPagamento processar(BigDecimal valor, DadosPagamento dados) {
        // Lógica específica para cartão
        return validarCartao(dados) ? 
            new ResultadoPagamento(true, "Pagamento aprovado") :
            new ResultadoPagamento(false, "Cartão recusado");
    }
}

public class ProcessadorPix implements ProcessadorPagamento {
    @Override
    public ResultadoPagamento processar(BigDecimal valor, DadosPagamento dados) {
        // Lógica específica para PIX
        return gerarQRCode(valor, dados);
    }
}

// Uso polimórfico
public class ServicoCobranca {
    private List<ProcessadorPagamento> processadores;
    
    public ResultadoPagamento cobrar(BigDecimal valor, TipoPagamento tipo, DadosPagamento dados) {
        // Polimorfismo em ação - mesmo método, comportamentos diferentes
        ProcessadorPagamento processador = escolherProcessador(tipo);
        return processador.processar(valor, dados);  // Método polimórfico
    }
    
    // Fácil adicionar novos tipos sem modificar este código
    private ProcessadorPagamento escolherProcessador(TipoPagamento tipo) {
        return processadores.stream()
            .filter(p -> p.suportaTipo(tipo))
            .findFirst()
            .orElseThrow(() -> new UnsupportedOperationException("Tipo não suportado: " + tipo));
    }
}
```

### **🧩 4. ABSTRAÇÃO**

#### **💡 CONCEITO**
**Focar no "que" ao invés do "como"** - esconder complexidade e expor apenas o essencial.

#### **🎯 NÍVEIS DE ABSTRAÇÃO**
1. **Classes Abstratas** - Implementação parcial
2. **Interfaces** - Contratos puros  
3. **Métodos** - Encapsular operações complexas
4. **Packages** - Organizar funcionalidades

#### **📖 EXEMPLO PRÁTICO**
```java
// Abstração de alto nível
public interface RepositorioUsuario {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
    List<Usuario> buscarAtivos();
    void deletar(Long id);
}

// Implementação específica (escondida do cliente)
@ObjectOrientedProgramming.Repository
public class RepositorioUsuarioJPA implements RepositorioUsuario {
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Usuario salvar(Usuario usuario) {
        // Complexidade de JPA/Hibernate escondida
        if (usuario.getId() == null) {
            entityManager.persist(usuario);
        } else {
            usuario = entityManager.merge(usuario);
        }
        return usuario;
    }
    
    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        // Query complexa abstraída em método simples
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email AND u.ativo = true";
        List<Usuario> usuarios = entityManager
            .createQuery(jpql, Usuario.class)
            .setParameter("email", email)
            .getResultList();
        
        return usuarios.isEmpty() ? Optional.empty() : Optional.of(usuarios.get(0));
    }
}

// Cliente usa abstração simples
@Service
public class ServicoUsuario {
    private final RepositorioUsuario repositorio;
    
    public Usuario criarUsuario(String nome, String email) {
        // Cliente não precisa saber detalhes de persistência
        Usuario usuario = new Usuario(nome, email);
        return repositorio.salvar(usuario);  // Abstração limpa
    }
}
```

---

## 🎯 **PRINCÍPIOS SOLID**

### **📏 S - Single Responsibility Principle**

#### **💡 CONCEITO**
**Uma classe deve ter apenas um motivo para mudar.**

```java
// ❌ RUIM: Múltiplas responsabilidades
public class Usuario {
    private String nome;
    private String email;
    
    // Responsabilidade 1: Gerenciar dados do usuário
    public void setNome(String nome) { this.nome = nome; }
    
    // Responsabilidade 2: Persistência
    public void salvarNoBanco() { /* código SQL */ }
    
    // Responsabilidade 3: Validação
    public boolean emailValido() { /* regex */ }
    
    // Responsabilidade 4: Notificação
    public void enviarEmailBoasVindas() { /* código email */ }
}

// ✅ BOM: Responsabilidade única
public class Usuario {
    private String nome;
    private String email;
    // Apenas dados e comportamentos essenciais do usuário
}

@ObjectOrientedProgramming.Repository
public class RepositorioUsuario {
    // Apenas persistência
}

@Component
public class ValidadorUsuario {
    // Apenas validações
}

@Service
public class NotificadorUsuario {
    // Apenas notificações
}
```

### **🔓 O - Open/Closed Principle**

#### **💡 CONCEITO**
**Aberto para extensão, fechado para modificação.**

```java
// ✅ BOM: Design extensível
public abstract class CalculadoraDesconto {
    public final BigDecimal calcular(Pedido pedido) {
        if (!podeAplicarDesconto(pedido)) {
            return BigDecimal.ZERO;
        }
        return calcularDesconto(pedido);
    }
    
    protected abstract BigDecimal calcularDesconto(Pedido pedido);
    protected abstract boolean podeAplicarDesconto(Pedido pedido);
}

// Extensões sem modificar código existente
public class DescontoClienteVIP extends CalculadoraDesconto {
    @Override
    protected BigDecimal calcularDesconto(Pedido pedido) {
        return pedido.getValor().multiply(new BigDecimal("0.15"));  // 15%
    }
    
    @Override
    protected boolean podeAplicarDesconto(Pedido pedido) {
        return pedido.getCliente().isVIP();
    }
}

public class DescontoPrimeiraCompra extends CalculadoraDesconto {
    @Override
    protected BigDecimal calcularDesconto(Pedido pedido) {
        return new BigDecimal("50.00");  // R$ 50 fixo
    }
    
    @Override
    protected boolean podeAplicarDesconto(Pedido pedido) {
        return pedido.getCliente().isPrimeiraCompra();
    }
}
```

### **🔄 L - Liskov Substitution Principle**

#### **💡 CONCEITO**
**Objetos de classes filhas devem poder substituir objetos da classe pai sem alterar a correção do programa.**

```java
// ✅ BOM: Substituição válida
public abstract class Veiculo {
    protected int velocidade = 0;
    
    public void acelerar() {
        if (velocidade < getVelocidadeMaxima()) {
            velocidade += 10;
        }
    }
    
    public abstract int getVelocidadeMaxima();
    public int getVelocidade() { return velocidade; }
}

public class Carro extends Veiculo {
    @Override
    public int getVelocidadeMaxima() {
        return 200;  // Comportamento consistente
    }
}

public class Bicicleta extends Veiculo {
    @Override
    public int getVelocidadeMaxima() {
        return 30;   // Comportamento consistente
    }
}

// Código cliente funciona com qualquer veículo
public void testarVeiculo(Veiculo veiculo) {
    veiculo.acelerar();
    assertTrue(veiculo.getVelocidade() <= veiculo.getVelocidadeMaxima());
    // Funciona para Carro, Bicicleta e qualquer futuro Veiculo
}
```

### **🔌 I - Interface Segregation Principle**

#### **💡 CONCEITO**
**Clientes não devem depender de interfaces que não usam.**

```java
// ❌ RUIM: Interface "gorda"
public interface Trabalhador {
    void trabalhar();
    void comer();
    void dormir();
    void programar();      // Nem todo trabalhador programa
    void dirigir();        // Nem todo trabalhador dirige
}

// ✅ BOM: Interfaces segregadas
public interface Trabalhador {
    void trabalhar();
    void comer();
    void dormir();
}

public interface Programador {
    void programar();
    void debugar();
}

public interface Motorista {
    void dirigir();
    void estacionar();
}

// Classes implementam apenas o que precisam
public class DesenvolvedorMotorista implements Trabalhador, Programador, Motorista {
    // Implementa todas as interfaces que precisa
}

public class Designer implements Trabalhador {
    // Implementa apenas Trabalhador
}
```

### **⬇️ D - Dependency Inversion Principle**

#### **💡 CONCEITO**
**Depender de abstrações, não de implementações concretas.**

```java
// ❌ RUIM: Dependência de implementação concreta
public class ServicoEmail {
    private GmailSender gmailSender;  // Acoplado ao Gmail
    
    public ServicoEmail() {
        this.gmailSender = new GmailSender();  // Dependência hard-coded
    }
    
    public void enviar(String destinatario, String mensagem) {
        gmailSender.send(destinatario, mensagem);
    }
}

// ✅ BOM: Dependência de abstração
public interface EnviadorEmail {
    void enviar(String destinatario, String assunto, String corpo);
}

public class ServicoEmail {
    private final EnviadorEmail enviador;  // Depende da abstração
    
    // Inversão de dependência via construtor
    public ServicoEmail(EnviadorEmail enviador) {
        this.enviador = enviador;
    }
    
    public void enviarBoasVindas(Usuario usuario) {
        enviador.enviar(
            usuario.getEmail(),
            "Bem-vindo!",
            "Olá " + usuario.getNome()
        );
    }
}

// Implementações intercambiáveis
@Component
public class GmailSender implements EnviadorEmail {
    // Implementação Gmail
}

@Component  
public class SendGridSender implements EnviadorEmail {
    // Implementação SendGrid
}

// Spring Boot injeta automaticamente
@Service
public class ServicoUsuario {
    private final ServicoEmail servicoEmail;
    
    // Spring escolhe a implementação baseada na configuração
    public ServicoUsuario(ServicoEmail servicoEmail) {
        this.servicoEmail = servicoEmail;
    }
}
```

---

## 🏆 **PADRÕES DE DESIGN ESSENCIAIS**

### **🏭 1. Factory Pattern**

#### **💡 QUANDO USAR**
- ✅ **Criar objetos** com lógica complexa
- ✅ **Esconder** detalhes de criação
- ✅ **Centralizar** configurações

```java
public class ProcessadorPagamentoFactory {
    
    public static ProcessadorPagamento criar(TipoPagamento tipo, Configuracao config) {
        return switch (tipo) {
            case CARTAO_CREDITO -> new ProcessadorCartao(
                config.getUrlGateway(),
                config.getChaveAPI(),
                config.getTimeoutSegundos()
            );
            
            case PIX -> new ProcessadorPix(
                config.getChavePix(),
                config.getBancoCredenciado()
            );
            
            case BOLETO -> new ProcessadorBoleto(
                config.getCodigoBanco(),
                config.getAgencia()
            );
            
            default -> throw new IllegalArgumentException("Tipo não suportado: " + tipo);
        };
    }
}

// Uso simplificado
ProcessadorPagamento processador = ProcessadorPagamentoFactory.criar(
    TipoPagamento.PIX, 
    configuracao
);
```

### **🎯 2. Strategy Pattern**

#### **💡 QUANDO USAR**
- ✅ **Algoritmos** intercambiáveis
- ✅ **Comportamentos** que mudam em runtime
- ✅ **Eliminar** if/else complexos

```java
public interface EstrategiaFrete {
    BigDecimal calcular(Pedido pedido);
}

public class FretePadrao implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return pedido.getPeso().multiply(new BigDecimal("2.50"));
    }
}

public class FreteExpresso implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return pedido.getPeso().multiply(new BigDecimal("5.00"));
    }
}

public class CalculadoraFrete {
    private EstrategiaFrete estrategia;
    
    public void setEstrategia(EstrategiaFrete estrategia) {
        this.estrategia = estrategia;
    }
    
    public BigDecimal calcularFrete(Pedido pedido) {
        return estrategia.calcular(pedido);
    }
}
```

### **👁️ 3. Observer Pattern**

#### **💡 QUANDO USAR**
- ✅ **Notificar** múltiplos objetos sobre mudanças
- ✅ **Desacoplar** produtor de eventos dos consumidores
- ✅ **Sistemas de eventos**

```java
// Spring Boot Events (Observer built-in)
@Component
public class PublicadorEventos {
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    public void criarUsuario(Usuario usuario) {
        // Criar usuário...
        
        // Publicar evento
        publisher.publishEvent(new UsuarioCriadoEvent(usuario));
    }
}

// Listeners (Observers)
@Component
public class NotificadorUsuario {
    
    @EventListener
    public void onUsuarioCriado(UsuarioCriadoEvent event) {
        // Enviar email de boas-vindas
        enviarEmailBoasVindas(event.getUsuario());
    }
}

@Component
public class ConfiguradorConta {
    
    @EventListener
    public void onUsuarioCriado(UsuarioCriadoEvent event) {
        // Configurar conta padrão
        criarContaPadrao(event.getUsuario());
    }
}
```

---

## 🎓 **CHECKLIST DE DOMÍNIO OOP**

### **🏛️ Pilares Fundamentais**
- [ ] **Encapsulamento**: Protejo estado interno com getters/setters apropriados
- [ ] **Herança**: Uso apenas para relações "é-um" verdadeiras
- [ ] **Polimorfismo**: Programo para interfaces, uso factory e strategy
- [ ] **Abstração**: Crio interfaces claras que escondem complexidade

### **🎯 Princípios SOLID**
- [ ] **SRP**: Cada classe tem uma responsabilidade única
- [ ] **OCP**: Adiciono funcionalidades sem modificar código existente
- [ ] **LSP**: Subclasses podem substituir superclasses perfeitamente
- [ ] **ISP**: Interfaces são pequenas e focadas
- [ ] **DIP**: Dependo de abstrações, não implementações

### **🏆 Padrões de Design**
- [ ] **Factory**: Para criação complexa de objetos
- [ ] **Strategy**: Para algoritmos intercambiáveis
- [ ] **Observer**: Para sistemas de eventos
- [ ] **Builder**: Para objetos com muitos parâmetros
- [ ] **ObjectOrientedProgramming.Repository**: Para abstração de persistência

---

🚀 **PRÓXIMA ETAPA:** **Exception Design Patterns** - Como criar hierarquias robustas de exceções e estratégias de error handling enterprise!
