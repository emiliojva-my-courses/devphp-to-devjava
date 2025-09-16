# 📖 **Capítulo 04: Fundamentos Java** 

> **Pré-requisitos essenciais: como dominar o "PHP básico" do mundo Java**

---

## 🎯 **OBJETIVO DO CAPÍTULO**

Dominar os fundamentos do Java SE que são pré-requisitos para Spring Boot, similar a como você precisa conhecer PHP básico antes de usar Laravel.

**Analogia:** Este capítulo é como aprender PHP puro antes de Laravel - sintaxe, tipos, OOP, arrays, etc.

---

## ⚔️ **1. SINTAXE BÁSICA E TIPOS**

### **1.1 Declaração de Variáveis**

**PHP (tipagem fraca):**
```php
$nome = "João";           // String
$idade = 30;              // Integer
$ativo = true;            // Boolean
$preco = 29.99;           // Float
$tags = ["java", "php"];  // Array
```

**Java (tipagem forte):**
```java
// Tipos primitivos (mais eficientes)
String nome = "João";           // String (objeto)
int idade = 30;                 // Integer primitivo
boolean ativo = true;           // Boolean primitivo
double preco = 29.99;           // Double primitivo
String[] tags = {"java", "php"}; // Array de String

// Tipos wrapper (objetos)
Integer idadeObj = 30;          // Pode ser null
Boolean ativoObj = true;        // Pode ser null
Double precoObj = 29.99;        // Pode ser null
```

### **Principais Diferenças:**

| Aspecto | PHP | Java |
|---------|-----|------|
| **Declaração** | `$var = valor` | `Tipo var = valor` |
| **Tipagem** | Dinâmica/fraca | Estática/forte |
| **Null** | `null` funciona sempre | Só objetos podem ser `null` |
| **Arrays** | `$arr = []` | `String[] arr = {}` (tipado) |

### **1.2 Constantes**

**PHP:**
```php
define('API_URL', 'https://api.exemplo.com');
const MAX_USERS = 100;
```

**Java:**
```java
// Constantes de classe
public static final String API_URL = "https://api.exemplo.com";
public static final int MAX_USERS = 100;

// Variável final (só pode ser atribuída uma vez)
final String nome = "João"; // Como const no JavaScript
```

---

## 🔄 **2. ESTRUTURAS DE CONTROLE**

### **2.1 Condicionais**

**PHP:**
```php
if ($idade >= 18) {
    echo "Maior de idade";
} elseif ($idade >= 16) {
    echo "Pode votar";
} else {
    echo "Menor de idade";
}

// Operador ternário
$status = $ativo ? "Ativo" : "Inativo";
```

**Java:**
```java
if (idade >= 18) {
    System.out.println("Maior de idade");
} else if (idade >= 16) {
    System.out.println("Pode votar");
} else {
    System.out.println("Menor de idade");
}

// Operador ternário
String status = ativo ? "Ativo" : "Inativo";

// Switch moderno (Java 14+)
String resultado = switch (idade) {
    case 18, 19, 20 -> "Jovem adulto";
    case 21, 22, 23 -> "Adulto jovem";
    default -> "Outras idades";
};
```

### **2.2 Loops**

**PHP:**
```php
// For tradicional
for ($i = 0; $i < 10; $i++) {
    echo $i;
}

// Foreach
$nomes = ["Ana", "João", "Maria"];
foreach ($nomes as $nome) {
    echo $nome;
}

// Foreach com índice
foreach ($nomes as $index => $nome) {
    echo "$index: $nome";
}
```

**Java:**
```java
// For tradicional
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// Enhanced for (foreach)
String[] nomes = {"Ana", "João", "Maria"};
for (String nome : nomes) {
    System.out.println(nome);
}

// Com List (mais comum)
List<String> nomes = List.of("Ana", "João", "Maria");
for (String nome : nomes) {
    System.out.println(nome);
}

// Com índice (mais verboso)
for (int i = 0; i < nomes.size(); i++) {
    System.out.println(i + ": " + nomes.get(i));
}
```

---

## 🏗️ **3. ORIENTAÇÃO A OBJETOS**

### **3.1 Classes e Objetos Básicos**

**PHP:**
```php
class Usuario {
    private $nome;
    private $email;
    
    public function __construct($nome, $email) {
        $this->nome = $nome;
        $this->email = $email;
    }
    
    public function getNome() {
        return $this->nome;
    }
    
    public function setNome($nome) {
        $this->nome = $nome;
    }
}

$user = new Usuario("João", "joao@email.com");
```

**Java:**
```java
public class Usuario {
    private String nome;
    private String email;
    
    // Construtor
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

// Uso
Usuario user = new Usuario("João", "joao@email.com");
```

### **3.2 Herança**

**PHP:**
```php
class Pessoa {
    protected $nome;
    
    public function __construct($nome) {
        $this->nome = $nome;
    }
    
    public function apresentar() {
        return "Olá, eu sou " . $this->nome;
    }
}

class Desenvolvedor extends Pessoa {
    private $linguagem;
    
    public function __construct($nome, $linguagem) {
        parent::__construct($nome);
        $this->linguagem = $linguagem;
    }
    
    public function programar() {
        return "Programando em " . $this->linguagem;
    }
}
```

**Java:**
```java
// Classe pai
public class Pessoa {
    protected String nome;
    
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    public String apresentar() {
        return "Olá, eu sou " + nome;
    }
}

// Classe filha
public class Desenvolvedor extends Pessoa {
    private String linguagem;
    
    public Desenvolvedor(String nome, String linguagem) {
        super(nome); // Chama construtor da classe pai
        this.linguagem = linguagem;
    }
    
    public String programar() {
        return "Programando em " + linguagem;
    }
    
    // Override (sobrescrita)
    @Override
    public String apresentar() {
        return super.apresentar() + ", sou desenvolvedor";
    }
}
```

### **3.3 Interfaces**

**PHP:**
```php
interface Repositorio {
    public function salvar($dados);
    public function buscar($id);
}

class UsuarioRepositorio implements Repositorio {
    public function salvar($dados) {
        // Implementação
    }
    
    public function buscar($id) {
        // Implementação
    }
}
```

**Java:**
```java
// Interface
public interface Repositorio<T> {
    void salvar(T dados);
    T buscar(Long id);
    List<T> buscarTodos();
}

// Implementação
public class UsuarioRepositorio implements Repositorio<Usuario> {
    @Override
    public void salvar(Usuario dados) {
        // Implementação
    }
    
    @Override
    public Usuario buscar(Long id) {
        // Implementação
        return null;
    }
    
    @Override
    public List<Usuario> buscarTodos() {
        // Implementação
        return new ArrayList<>();
    }
}
```

---

## 📦 **4. COLLECTIONS (COLEÇÕES)**

### **4.1 Arrays vs Lists**

**PHP:**
```php
// Array simples
$numeros = [1, 2, 3, 4, 5];
$numeros[] = 6; // Adiciona elemento

// Array associativo
$usuario = [
    'nome' => 'João',
    'email' => 'joao@email.com'
];
```

**Java:**
```java
// Array (tamanho fixo)
int[] numeros = {1, 2, 3, 4, 5};
// numeros não pode crescer!

// ArrayList (tamanho dinâmico)
List<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.addAll(List.of(3, 4, 5));

// Map (como array associativo)
Map<String, String> usuario = new HashMap<>();
usuario.put("nome", "João");
usuario.put("email", "joao@email.com");

// Ou criação imutável
Map<String, String> usuario = Map.of(
    "nome", "João",
    "email", "joao@email.com"
);
```

### **4.2 Operações Comuns**

**PHP:**
```php
$nomes = ["Ana", "João", "Maria"];

// Adicionar
$nomes[] = "Pedro";
array_push($nomes, "Carlos");

// Buscar
$existe = in_array("João", $nomes);
$posicao = array_search("Maria", $nomes);

// Filtrar
$comJ = array_filter($nomes, function($nome) {
    return str_starts_with($nome, 'J');
});

// Mapear
$maiusculo = array_map('strtoupper', $nomes);
```

**Java:**
```java
List<String> nomes = new ArrayList<>(List.of("Ana", "João", "Maria"));

// Adicionar
nomes.add("Pedro");
nomes.addAll(List.of("Carlos", "Sofia"));

// Buscar
boolean existe = nomes.contains("João");
int posicao = nomes.indexOf("Maria");

// Filtrar com Stream API
List<String> comJ = nomes.stream()
    .filter(nome -> nome.startsWith("J"))
    .collect(Collectors.toList());

// Mapear
List<String> maiusculo = nomes.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

---

## 🌊 **5. STREAM API (COLLECTIONS MODERNAS)**

### **PHP (Laravel Collections) vs Java Streams**

**PHP/Laravel:**
```php
$users = collect([
    ['name' => 'João', 'age' => 25],
    ['name' => 'Ana', 'age' => 30],
    ['name' => 'Pedro', 'age' => 20]
]);

$adultos = $users
    ->filter(function($user) { return $user['age'] >= 25; })
    ->map(function($user) { return $user['name']; })
    ->values()
    ->toArray();
```

**Java:**
```java
List<Map<String, Object>> users = List.of(
    Map.of("name", "João", "age", 25),
    Map.of("name", "Ana", "age", 30),
    Map.of("name", "Pedro", "age", 20)
);

List<String> adultos = users.stream()
    .filter(user -> (Integer) user.get("age") >= 25)
    .map(user -> (String) user.get("name"))
    .collect(Collectors.toList());

// Ou com objetos tipados (melhor prática)
List<Usuario> usuarios = List.of(
    new Usuario("João", 25),
    new Usuario("Ana", 30),
    new Usuario("Pedro", 20)
);

List<String> nomes = usuarios.stream()
    .filter(user -> user.getAge() >= 25)
    .map(Usuario::getName)
    .collect(Collectors.toList());
```

---

## 🔧 **6. TRATAMENTO DE ERROS**

### **6.1 Exceptions**

**PHP:**
```php
try {
    $result = dividir(10, 0);
} catch (DivisionByZeroError $e) {
    echo "Erro: " . $e->getMessage();
} catch (Exception $e) {
    echo "Erro geral: " . $e->getMessage();
} finally {
    echo "Sempre executa";
}

function dividir($a, $b) {
    if ($b == 0) {
        throw new InvalidArgumentException("Divisão por zero");
    }
    return $a / $b;
}
```

**Java:**
```java
try {
    double result = dividir(10, 0);
} catch (ArithmeticException e) {
    System.out.println("Erro: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Erro geral: " + e.getMessage());
} finally {
    System.out.println("Sempre executa");
}

public static double dividir(int a, int b) {
    if (b == 0) {
        throw new IllegalArgumentException("Divisão por zero");
    }
    return (double) a / b;
}
```

### **6.2 Optional (Evitando Null)**

**PHP (problema comum):**
```php
function buscarUsuario($id) {
    // Pode retornar null
    return $id > 0 ? ['name' => 'João'] : null;
}

$user = buscarUsuario(1);
if ($user !== null) {
    echo $user['name']; // Sempre verificar null
}
```

**Java (solução com Optional):**
```java
public Optional<Usuario> buscarUsuario(Long id) {
    if (id > 0) {
        return Optional.of(new Usuario("João"));
    }
    return Optional.empty();
}

// Uso seguro
Optional<Usuario> user = buscarUsuario(1L);
user.ifPresent(u -> System.out.println(u.getName()));

// Ou com default
String nome = buscarUsuario(1L)
    .map(Usuario::getName)
    .orElse("Usuário não encontrado");
```

---

## ✅ **CHECKLIST DO CAPÍTULO**

Certifique-se de que domina:

- [ ] **Tipagem forte** - declarar tipos explicitamente
- [ ] **Classes e objetos** - construtores, getters/setters
- [ ] **Herança e interfaces** - extends, implements, @Override
- [ ] **Collections** - List, Map, Set básicos
- [ ] **Stream API** - filter, map, collect
- [ ] **Exception handling** - try/catch/finally
- [ ] **Optional** - evitar NullPointerException

---

## 🎓 **EXERCÍCIO PRÁTICO**

Crie uma classe `Produto` completa:

```java
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private boolean ativo;
    
    // 1. Criar construtores
    // 2. Criar getters/setters
    // 3. Implementar toString()
    // 4. Criar método de validação
}

// Teste com List e Stream
List<Produto> produtos = new ArrayList<>();
// Adicionar produtos, filtrar por ativo, ordenar por preço
```

---

## 🚀 **PRÓXIMO CAPÍTULO**

Agora que você domina Java básico (equivalente ao PHP puro), vamos ver como tudo se conecta:

**Próximo:** [Capítulo 05: Arquitetura e Fluxo](./05-architecture.md)

---

## 🧠 **RESUMO EXECUTIVO**

**Fundamentos Java vs PHP:**

✅ **Tipagem forte** = menos erros em runtime  
✅ **OOP rigorosa** = código mais estruturado  
✅ **Collections tipadas** = dados mais seguros  
✅ **Stream API** = functional programming elegante  
✅ **Optional** = bye bye NullPointerException  

**Este é seu "PHP básico" para Spring Boot!** 🐉

---

🏮 **FUNDAMENTOS SÓLIDOS! AGORA VAMOS À ARQUITETURA!** 🐉
