/**
 * 🏗️ OOP Avançado: PHP vs Java
 * 
 * Este exemplo mostra como implementar OOP robusto em Java,
 * sempre comparando com patterns que você conhece do PHP.
 * 
 * Tópicos: Classes, Herança, Interfaces, Polimorfismo, Encapsulamento
 */

// ==========================================
// 1. INTERFACE (Contrato)
// ==========================================

/**
 * 📋 INTERFACE: Como PHP Interface
 * 
 * PHP: interface RepositorioInterface { ... }
 * Java: public interface Repository<T> { ... }
 */
interface Repository<T> {
    void save(T entity);
    T findById(Long id);
    void delete(Long id);
    // Método default (novidade Java 8+, como trait PHP)
    default void logOperation(String operation) {
        System.out.println("🔍 Operação: " + operation);
    }
}

/**
 * 🎯 Interface para validação (como PHP Validator)
 */
interface Validatable {
    boolean isValid();
    String getValidationMessage();
}

// ==========================================
// 2. CLASSE ABSTRATA (Base)
// ==========================================

/**
 * 👤 PESSOA: Classe base abstrata
 * 
 * PHP: abstract class Pessoa { ... }
 * Java: public abstract class Pessoa { ... }
 */
abstract class Pessoa implements Validatable {
    protected String nome;
    protected int idade;
    protected String email;
    
    // Constructor (como PHP __construct)
    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
    
    // Método abstrato (deve ser implementado pelas filhas)
    public abstract String getTipo();
    
    // Método concreto (pode ser usado por todas as filhas)
    public String getInfo() {
        return String.format("%s: %s (%d anos) - %s", getTipo(), nome, idade, email);
    }
    
    // Implementação da validação
    @Override
    public boolean isValid() {
        return nome != null && !nome.trim().isEmpty() && 
               idade > 0 && idade < 120 &&
               email != null && email.contains("@");
    }
    
    @Override
    public String getValidationMessage() {
        if (!isValid()) {
            return "❌ Dados inválidos: nome, idade (1-119) e email são obrigatórios";
        }
        return "✅ Dados válidos";
    }
    
    // Getters e Setters (como PHP __get e __set, mas explícitos)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// ==========================================
// 3. CLASSES FILHAS (Herança)
// ==========================================

/**
 * 👨‍💻 DESENVOLVEDOR: Especialização de Pessoa
 * 
 * PHP: class Desenvolvedor extends Pessoa { ... }
 * Java: public class Desenvolvedor extends Pessoa { ... }
 */
class Desenvolvedor extends Pessoa {
    private String linguagemPrincipal;
    private int anosExperiencia;
    private double salario;
    
    public Desenvolvedor(String nome, int idade, String email, String linguagem, int experiencia, double salario) {
        super(nome, idade, email); // Chama constructor da classe pai
        this.linguagemPrincipal = linguagem;
        this.anosExperiencia = experiencia;
        this.salario = salario;
    }
    
    @Override
    public String getTipo() {
        return "Desenvolvedor " + linguagemPrincipal;
    }
    
    // Método específico desta classe
    public String getLevel() {
        if (anosExperiencia < 2) return "Junior";
        if (anosExperiencia < 5) return "Pleno";
        return "Senior";
    }
    
    public String getInfoCompleta() {
        return String.format("%s | Level: %s | Salário: R$ %.2f", 
                           getInfo(), getLevel(), salario);
    }
    
    // Override da validação (adiciona regras específicas)
    @Override
    public boolean isValid() {
        return super.isValid() && 
               linguagemPrincipal != null && !linguagemPrincipal.trim().isEmpty() &&
               anosExperiencia >= 0 && salario > 0;
    }
    
    // Getters específicos
    public String getLinguagemPrincipal() { return linguagemPrincipal; }
    public int getAnosExperiencia() { return anosExperiencia; }
    public double getSalario() { return salario; }
}

/**
 * 👩‍💼 GERENTE: Outra especialização de Pessoa
 */
class Gerente extends Pessoa {
    private String departamento;
    private int tamanhoEquipe;
    
    public Gerente(String nome, int idade, String email, String departamento, int tamanhoEquipe) {
        super(nome, idade, email);
        this.departamento = departamento;
        this.tamanhoEquipe = tamanhoEquipe;
    }
    
    @Override
    public String getTipo() {
        return "Gerente de " + departamento;
    }
    
    public String getInfoCompleta() {
        return String.format("%s | Equipe: %d pessoas", getInfo(), tamanhoEquipe);
    }
    
    // Getters específicos
    public String getDepartamento() { return departamento; }
    public int getTamanhoEquipe() { return tamanhoEquipe; }
}

// ==========================================
// 4. IMPLEMENTAÇÃO DE REPOSITORY
// ==========================================

/**
 * 🗄️ REPOSITORY: Implementação concreta
 * 
 * Como um Eloquent Model ou Repository Pattern do Laravel
 */
class PessoaRepository implements Repository<Pessoa> {
    private java.util.List<Pessoa> pessoas = new java.util.ArrayList<>();
    private Long proximoId = 1L;
    
    @Override
    public void save(Pessoa pessoa) {
        logOperation("SAVE - " + pessoa.getTipo());
        if (pessoa.isValid()) {
            pessoas.add(pessoa);
            System.out.println("✅ " + pessoa.getNome() + " salvo com sucesso!");
        } else {
            System.out.println("❌ Erro ao salvar: " + pessoa.getValidationMessage());
        }
    }
    
    @Override
    public Pessoa findById(Long id) {
        logOperation("FIND_BY_ID - " + id);
        // Simulação simples (na prática viria do banco)
        if (id <= pessoas.size()) {
            return pessoas.get(id.intValue() - 1);
        }
        return null;
    }
    
    @Override
    public void delete(Long id) {
        logOperation("DELETE - " + id);
        // Implementação simplificada
        System.out.println("🗑️ Pessoa com ID " + id + " removida");
    }
    
    // Métodos extras (como Query Scopes do Laravel)
    public java.util.List<Pessoa> findAll() {
        logOperation("FIND_ALL");
        return new java.util.ArrayList<>(pessoas);
    }
    
    public java.util.List<Desenvolvedor> findDesenvolvedoresByLinguagem(String linguagem) {
        logOperation("FIND_DEVS_BY_LANGUAGE - " + linguagem);
        return pessoas.stream()
            .filter(p -> p instanceof Desenvolvedor)
            .map(p -> (Desenvolvedor) p)
            .filter(dev -> dev.getLinguagemPrincipal().equalsIgnoreCase(linguagem))
            .collect(java.util.stream.Collectors.toList());
    }
}

// ==========================================
// 5. CLASSE PRINCIPAL COM EXEMPLOS
// ==========================================

public class OOPAdvancedExample {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("🏗️ OOP AVANÇADO: DO PHP PARA JAVA");
        System.out.println("========================================\n");
        
        // Criando repository (como injeção de dependência)
        PessoaRepository repository = new PessoaRepository();
        
        demonstrarHeranca(repository);
        demonstrarPolimorfismo(repository);
        demonstrarEncapsulamento(repository);
        demonstrarInterface(repository);
    }
    
    /**
     * 🧬 DEMONSTRAÇÃO: Herança
     */
    private static void demonstrarHeranca(PessoaRepository repository) {
        System.out.println("🧬 1. HERANÇA (extends)");
        System.out.println("PHP: class Desenvolvedor extends Pessoa");
        System.out.println("Java: class Desenvolvedor extends Pessoa\n");
        
        // Criando objetos de classes filhas
        Desenvolvedor dev1 = new Desenvolvedor("João", 28, "joao@email.com", "Java", 3, 5500.00);
        Desenvolvedor dev2 = new Desenvolvedor("Maria", 32, "maria@email.com", "PHP", 6, 7200.00);
        Gerente gerente = new Gerente("Pedro", 40, "pedro@email.com", "Tecnologia", 15);
        
        // Salvando no repository
        repository.save(dev1);
        repository.save(dev2);
        repository.save(gerente);
        
        System.out.println();
    }
    
    /**
     * 🎭 DEMONSTRAÇÃO: Polimorfismo
     */
    private static void demonstrarPolimorfismo(PessoaRepository repository) {
        System.out.println("🎭 2. POLIMORFISMO (mesmo método, comportamentos diferentes)");
        System.out.println("Método getTipo() tem implementação diferente em cada classe:\n");
        
        // Polimorfismo: mesma referência (Pessoa), comportamentos diferentes
        java.util.List<Pessoa> todasPessoas = repository.findAll();
        
        for (Pessoa pessoa : todasPessoas) {
            System.out.println("👤 " + pessoa.getInfo()); // Chama método polimórfico
            
            // Type checking e casting (como instanceof PHP)
            if (pessoa instanceof Desenvolvedor) {
                Desenvolvedor dev = (Desenvolvedor) pessoa;
                System.out.println("   💻 " + dev.getInfoCompleta());
            } else if (pessoa instanceof Gerente) {
                Gerente ger = (Gerente) pessoa;
                System.out.println("   👔 " + ger.getInfoCompleta());
            }
            
            System.out.println("   " + pessoa.getValidationMessage());
            System.out.println();
        }
    }
    
    /**
     * 🔒 DEMONSTRAÇÃO: Encapsulamento
     */
    private static void demonstrarEncapsulamento(PessoaRepository repository) {
        System.out.println("🔒 3. ENCAPSULAMENTO (private, protected, public)");
        System.out.println("Acessando dados através de getters/setters:\n");
        
        Pessoa pessoa = repository.findById(1L);
        if (pessoa != null) {
            // Não posso acessar pessoa.nome diretamente (é protected)
            // Tenho que usar getter/setter
            System.out.println("Nome atual: " + pessoa.getNome());
            
            pessoa.setNome("João Silva"); // Setter
            System.out.println("Nome atualizado: " + pessoa.getNome()); // Getter
            
            System.out.println("Validação: " + pessoa.getValidationMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 📋 DEMONSTRAÇÃO: Interfaces
     */
    private static void demonstrarInterface(PessoaRepository repository) {
        System.out.println("📋 4. INTERFACES (contratos)");
        System.out.println("Repository implementa interface Repository<Pessoa>:\n");
        
        // Busca específica usando método customizado
        java.util.List<Desenvolvedor> devsJava = repository.findDesenvolvedoresByLinguagem("Java");
        java.util.List<Desenvolvedor> devsPHP = repository.findDesenvolvedoresByLinguagem("PHP");
        
        System.out.println("🔍 Desenvolvedores Java: " + devsJava.size());
        devsJava.forEach(dev -> System.out.println("   " + dev.getInfoCompleta()));
        
        System.out.println("\n🔍 Desenvolvedores PHP: " + devsPHP.size());
        devsPHP.forEach(dev -> System.out.println("   " + dev.getInfoCompleta()));
        
        System.out.println("\n🎉 OOP Avançado dominado! Próximo: Exception Handling");
    }
}
