# 🐉 **ECOSSISTEMA JAVA: A CAVERNA DO DRAGÃO**

**Roadmap** de um desenvolvedor PHP (Laravel) para dominar Java com Spring Boot.

> **Se você domina Laravel, este guia vai te ajudar a aprender Java traçando analogias diretas com o que você já conhece. Cada seção destaca o conceito equivalente no Laravel, para que você possa rapidamente mapear seu conhecimento e identificar as principais diferenças.**

---

## 📚 **GUIA DE ESTUDO ESTRUTURADO**

Este guia foi dividido em capítulos organizados para facilitar seu aprendizado progressivo:

### 🏗️ **Parte I: Fundamentos**
- [x] [📖 **Capítulo 00: Configuração do Ambiente**](./_docs/book/00-environment-setup.md)
- [x] [📖 **Capítulo 01: Ecossistema Java**](./_docs/book/01-java-ecosystem.md)
- [x] [📖 **Capítulo 02: Ferramentas e Infraestrutura**](./_docs/book/02-tools-infrastructure.md)

### ⚔️ **Parte II: Conhecimento Técnico**
- [x] [📖 **Capítulo 03: Camada de Dados**](./_docs/book/03-data-layer.md)
- [x] [📖 **Capítulo 04: Fundamentos Java**](./_docs/book/04-java-fundamentals.md)
- [x] [📖 **Capítulo 05: Arquitetura e Fluxo**](./_docs/book/05-architecture.md)

### 🌱 **Parte III: Spring Boot na Prática**
- [x] [📖 **Capítulo 06: Spring Boot Essencial**](./_docs/book/06-spring-boot-basics.md)
- [x] [📖 **Capítulo 07: Desafio Prático e Recursos**](./_docs/book/07-challenge-resources.md)

---

## 🎯 **CHECKLIST RÁPIDO**

Antes de começar, certifique-se de que entende estes conceitos:

- [ ] JDK ≠ JRE ≠ JVM (como engine PHP vs extensões vs ferramentas de dev)
- [ ] Maven/Gradle gerenciam dependências (como Composer)
- [ ] Tomcat é o servidor web embedado (como PHP-FPM ou built-in server)
- [ ] JPA é spec, Hibernate é implementation (como contrato Eloquent vs classe)
- [ ] Entity ≠ DTO (banco ≠ API resource)
- [ ] Java SE é suficiente para Spring Boot (como PHP core é suficiente para Laravel)

---

## 🏮 **SABEDORIA INICIAL DO SENSEI**

O ecossistema Java parece complexo porque **é robusto**. Cada camada resolve um problema específico de enterprise applications.

**Não decore - compreenda:**
- JDK é seu kit de ferramentas (como suas ferramentas de dev PHP)
- Maven é seu gestor de pacotes (como Composer)
- Tomcat é seu servidor (como PHP-FPM)
- JPA é sua interface de banco (como Eloquent)
- Spring é o framework que une tudo (como Laravel)

---

## 🎓 **COMO USAR ESTE GUIA**

1. **Leia sequencialmente** - Cada capítulo constrói sobre o anterior
2. **Pratique com analogias** - Compare cada conceito com Laravel
3. **Não pule o ambiente** - Configure tudo antes de continuar
4. **Faça o desafio** - A prática consolida o aprendizado
5. **Volte quando necessário** - Use como referência

---

🥋 **BOM ESTUDO, DISCÍPULO!** O dojo aguarda seu progresso! 🐉

---

## 📂 **ESTRUTURA COMPLETA DO PROJETO**

```
devphp-to-devjava/
├── README.md                           # Este arquivo (índice)
├── README-EN-US.md                     # Versão em inglês
├── PLANO-REVISAO.md                    # Plano personalizado de estudos
├── _docs/
│   ├── book/                          # Livro estruturado
│   │   ├── 00-environment-setup.md    ✅
│   │   ├── 01-java-ecosystem.md       ✅
│   │   ├── 02-tools-infrastructure.md ✅
│   │   ├── 03-data-layer.md           ✅
│   │   ├── 04-java-legacy.fundamentals.md    ✅
│   │   ├── 05-architecture.md         ✅
│   │   ├── 06-spring-boot-basics.md   ✅
│   │   └── 07-challenge-resources.md  ✅
│   ├── HowToRunJavaOnWindows11WSL2.md
│   └── JavaLearningDojo.md
└── src/                               # Código + conceitos integrados
    ├── main.java.fundamentals.cap01.HelloWorld.java                 # Primeiro exemplo
    ├── main.java.zothers.exercises.Main.java                       # Template inicial
    ├── exercises.main.java.zothers.fundamentals.PrimitiveTypes.java             # Tipos básicos
    ├── legacy.fundamentals.CollectionsExample.java         # Collections vs PHP arrays
    ├── ObjectOrientedProgramming.main.java.zothers.fundamentals.OOPAdvancedExample.java         # OOP com analogias Laravel
    ├── legacy.fundamentals.ExceptionHandlingExample.java   # Exception handling
    └── concepts/                       # 🆕 GUIAS CONCEITUAIS
        ├── README.md                   # Índice de navegação
        ├── 01-Collections-Conceitual.md
        ├── 02-OOP-Conceitual.md
        ├── 03-Exception-Design.md
        └── 04-Exercicios-Progressivos.md
```

---

## 🎁 **VERSÕES DISPONÍVEIS**

- **🇧🇷 Português:** [README.md](./README.md) *(esta página)*
- **🇺🇸 English:** [README-EN-US.md](README-EN-US.md) *(para praticar inglês)*

```
[SEU CÓDIGO .java] → [COMPILADOR javac] → [BYTECODE .class] → [JVM] → [HARDWARE]
```

**Analogia Laravel:**
- PHP é interpretado linha por linha (Zend Engine), enquanto Java é compilado em bytecode e roda na JVM (Java Virtual Machine).
- Pense na JVM como o "motor" que executa seu código Java, similar a como o PHP-FPM executa seus scripts PHP.

---

## 📦 **2. JDK vs JRE vs JVM**

| Componente | Função | Analogia Laravel/PHP |
|------------|---------|---------------------|
| **JVM** (Java Virtual Machine) | Executa bytecode | PHP-FPM + Zend Engine |
| **JRE** (Java Runtime Environment) | JVM + Bibliotecas básicas | PHP + extensões básicas |
| **JDK** (Java Development Kit) | JRE + Ferramentas de desenvolvimento (compilador, debugger) | PHP + Composer + Xdebug |

```bash
# No seu WSL:
java -version   # JRE
javac -version  # JDK (compilador)
```

---

## 🌐 **3. EDITIONS: SE, EE, ME**

| Edição | Foco | Uso Comum |
|--------|------|-----------|
| **Java SE** (Standard Edition) | Desktop/Apps básicos | Aplicações Spring Boot (como apps Laravel) |
| **Java EE** (Enterprise Edition) | Sistemas corporativos | Grandes aplicações corporativas (pense em bancos) |
| **Java ME** (Micro Edition) | Dispositivos embarcados | IoT, celulares antigos |

**Analogia Laravel:**
- Java SE é como o PHP core que você usa na maioria dos projetos Laravel.
- Java EE é como um framework PHP empresarial full-stack com todos os módulos possíveis.

**Spring Boot ≡ Java SE com poderes empresariais**

---

## 🐘 **4. TOMCAT vs APACHE**

| Servidor | Função | Analogia Laravel/PHP |
|----------|---------|---------------------|
| **Tomcat** | Servlet Container | PHP-FPM + Nginx (executa o código da sua app) |
| **Jetty** | Servlet Container leve | PHP built-in server (para dev) |
| **WildFly** | Full Java EE Server | Apache + PHP + todos os módulos |

**Spring Boot:** Usa Tomcat **embedado** - você não instala separadamente! Assim como o servidor built-in do Laravel para desenvolvimento, mas também para produção.

---

## 📦 **5. MAVEN vs GRADLE**

### **Maven (XML) ≈ Composer (PHP)**
```xml
<!-- pom.xml -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.2.0</version>
    </dependency>
</dependencies>
```

### **Gradle (Kotlin/Groovy) ≈ Composer + Make**
```kotlin
// build.gradle.kts
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
}
```

**Analogia Laravel:**
- Maven é como o Composer para PHP: gerencia dependências e estrutura do projeto.
- Gradle é como Composer + uma ferramenta de build (como Make ou Gulp).

**Dica:** Comece com **Maven** (mais documentação, mais fácil para iniciantes).

---

## 🧩 **6. ESPECIFICAÇÕES (JSRs)**

Java é governado por **JSRs** (Java Specification Requests):

| Especificação | Função | Analogia Laravel |
|---------------|---------|------------------|
| **JPA** (JSR 338) | Persistência de dados | Eloquent ORM |
| **Servlet** (JSR 369) | Web applications | Rotas/Controllers |
| **Bean Validation** (JSR 380) | Validação de dados | Form Requests |
| **CDI** (JSR 365) | Injeção de dependência | Service Container |

---

## 🗃️ **7. ORM: JPA vs HIBERNATE**

### **JPA (Specification) ≈ Interface (contrato do Eloquent)**
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
}
```

### **Hibernate (Implementation) ≈ Classe concreta**
```java
// Hibernate é a implementação mais popular da JPA
// Spring Boot usa Hibernate por padrão
```

**Analogia Laravel:**
- JPA é como a interface do Eloquent ORM (o contrato), e Hibernate é como a implementação real do Eloquent.

**Outras implementações:** EclipseLink, OpenJPA

---

## 📨 **8. DTO (Data Transfer Object)**

```java
// ENTITY (Banco de dados)
@Entity
public class User {
    @Id
    private Long id;
    private String password; // ← Dado sensível!
}

// DTO (API Response)
public record UserDTO(Long id, String name) {}
// ≈ class com getters, equals, hashCode
```

**Analogia Laravel:**
- Entity = Eloquent Model (banco de dados)
- DTO = Resource/Transformer (resposta da API)

**Por que usar?**
- Segurança (esconder campos sensíveis)
- Performance (menos dados trafegados)
- Desacoplamento (mudar entidade ≠ mudar API)

---

## 🔄 **9. FLUXO COMPLETO REQUISIÇÃO SPRING**

```
HTTP Request → Tomcat → DispatcherServlet → Controller → Service → ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository → Database
                                                              ↓
                                                          Response → JSON
```

**Analogia Laravel:**
- Request → Nginx/Apache → index.php → Route → Controller → Service → Model → Database

---

## 📊 **10. TECNOLOGIAS COMUNS NO ECOSSISTEMA**

| Camada | Tecnologias Comuns | Analogia Laravel |
|--------|---------------------|-----------------|
| **Build** | Maven, Gradle | Composer |
| **Web** | Spring MVC, Jersey | Routing, Controllers |
| **Data** | JPA/Hibernate, JDBC, Spring Data | Eloquent ORM |
| **Security** | Spring Security, JWT | Laravel Auth, Sanctum |
| **Testing** | JUnit, Mockito, Testcontainers | PHPUnit, Mockery |
| **Deploy** | Docker, Kubernetes, JAR → Cloud | Docker, Forge |

---

## 🎯 **11. CHECKLIST DO DISCÍPULO**

Entenda estes conceitos antes de prosseguir:

- [ ] JDK ≠ JRE ≠ JVM (como engine PHP vs extensões vs ferramentas de dev)
- [ ] Maven/Gradle gerenciam dependências (como Composer)
- [ ] Tomcat é o servidor web embedado (como PHP-FPM ou built-in server)
- [ ] JPA é spec, Hibernate é implementation (como contrato Eloquent vs classe)
- [ ] Entity ≠ DTO (banco ≠ API resource)
- [ ] Java SE é suficiente para Spring Boot (como PHP core é suficiente para Laravel)

---

## 🏮 **SABEDORIA FINAL DO SENSEI**

O ecossistema Java parece complexo porque **é robusto**. Cada camada resolve um problema específico de enterprise applications.

**Não decore - compreenda:**
- JDK é seu kit de ferramentas (como suas ferramentas de dev PHP)
- Maven é seu gestor de pacotes (como Composer)
- Tomcat é seu servidor (como PHP-FPM)
- JPA é sua interface de banco (como Eloquent)
- Spring é o framework que une tudo (como Laravel)

--- 

🥋 **COM PRAZER, DISCÍPULO!** Eis o **Class-01: Transcendência do Laravel para Spring Boot** - sua apostila para dominar a arte Java.

---

# 🐉 Transcendência do Laravel para Spring Boot
**Data:** ${HOJE}  
**Sensei:** Java Spring Boot  
**Discípulo:** ${SEU_NOME}

---

## 📖 ÍNDICE
1. Filosofia da Transcendência
2. Mapeamento Mental: Laravel → Spring Boot
3. Ambiente do Samurai (Setup)
4. Java Puro: Fundamentos Essenciais
5. Spring Boot: A Magia que Funciona
6. Desafio do Dojo
7. Recursos do Aprendizado

---

## 1. 🧠 FILOSOFIA DA TRANSCENDÊNCIA

### **Mudança de Mentalidade**
```php
// LARAVEL: Dinâmico, ágil, flexível
$user = new User();
$user->name = 'João'; // Tipagem fraca
```

```java
// SPRING: Estruturado, tipado, robusto
User user = new User();
user.setName("João"); // Tipagem forte
```

### **Princípios do Caminho Java**
- ✅ **Tipagem é proteção** (não obstrução)
- ✅ **Verbosidade é clareza** (não burocracia)
- ✅ **Compilação é prevenção** (não lentidão)

---

## 2. 🗺️ MAPEAMENTO MENTAL

| Laravel (PHP) | Spring Boot (Java) | Diferença Chave |
|---------------|-------------------|-----------------|
| `<?php` | `public class` | Arquivo = Classe |
| `$var` | `String var` | Sem $, com tipo |
| `__construct()` | `ClassName()` | Nome da classe |
| `array()` | `ArrayList<>()` | Coleção tipada |
| `->` | `.` | Acesso a métodos |
| `composer.json` | `pom.xml` | Gerenciador de dependências |
| `Artisan` | `Spring Boot CLI` | Ferramentas CLI |
| `Eloquent` | `Spring Data JPA` | ORM |
| `Blade` | `Thymeleaf` | Template Engine |
| `Middleware` | `Interceptor/Filter` | Camada de requisição |

---

## 3. 🛠️ AMBIENTE DO SAMURAI

### **Configuração Windows 11 + WSL2**
```bash
# Verificar instalações
java -version        # JDK 21+
mvn --version        # Maven 3.9+
docker --version     # Docker 24+

# Estrutura de pastas
~/java-projects/
├── class-01/
├── labs/
└── docker-compose.yml
```

### **Docker Compose para Dev**
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: dojo
      POSTGRES_USER: samurai
      POSTGRES_PASSWORD: secret
    ports:
      - "5432:5432"

  redis:
    image: redis:7-alpine
    ports:
      - "6379:6379"
```

---

## 4. ⚔️ JAVA PURO: FUNDAMENTOS ESSENCIAIS

### **4.1 Tipos e Variáveis**
```java
// Tipos primitivos (não objetos)
int idade = 30;
double preco = 29.99;
boolean ativo = true;

// Objetos (classes wrapper)
Integer idadeObj = 30;
String nome = "João";
List<String> emails = new ArrayList<>();
```

### **Analogia Laravel:**
- Primitivos são como int, float, bool do PHP, mas Java é sempre explícito.
- Objetos são como classes do PHP, mas com tipagem rigorosa.

### **4.2 Estruturas de Controle**
```java
// If/Else (diferente do PHP)
if (idade >= 18) {
    System.out.println("Maior de idade");
} else {
    System.out.println("Menor de idade");
}

// For loop (diferente do foreach PHP)
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// ForEach moderno
List<String> nomes = List.of("Ana", "João");
for (String nome : nomes) {
    System.out.println(nome);
}
```

### **4.3 Classes e Objetos**
```java
public class User {
    // Atributos privados (encapsulamento)
    private String name;
    private List<String> emails;
    
    // Construtor (diferente do __construct)
    public User(String name) {
        this.name = name;
        this.emails = new ArrayList<>();
    }
    
    // Métodos públicos (controle de acesso)
    public void addEmail(String email) {
        if (email != null && email.contains("@")) {
            emails.add(email);
        }
    }
    
    // Getters (diferente de propriedades públicas)
    public String getName() { return name; }
    public List<String> getEmails() { return emails; }
}
```

### **Analogia Laravel:**
- Classes Java são como classes PHP, mas com visibilidade rigorosa e tipos.
- Getters/setters são obrigatórios para encapsulamento.

### **4.4 Collections e Streams**
```java
// List vs Array
String[] array = {"a", "b"}; // Array fixo
List<String> list = new ArrayList<>(); // Lista dinâmica

// Stream API (como Laravel Collections)
List<String> filtrados = list.stream()
    .filter(nome -> nome.startsWith("A"))
    .sorted()
    .collect(Collectors.toList());
```

---

## 5. 🌱 SPRING BOOT: A MAGIA QUE FUNCIONA

### **5.1 Estrutura de Projeto**
```
src/main/java/com/dojo/
├── Application.java
├── controller/
├── entity/
├── repository/
├── service/
└── dto/
```

**Analogia Laravel:**
- `controller/` = `app/Http/Controllers/`
- `entity/` = `app/Models/`
- `repository/` = `app/Repositories/` (se você usa)
- `service/` = `app/Services/`
- `dto/` = `app/Http/Resources/` ou Transformers

### **5.2 Controller Básico**
```java
@RestController // ≈ Laravel Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired // ≈ Injeção de dependência
    private UserRepository userRepository;
    
    @GetMapping // ≈ Route::get()
    public List<User> getAll() {
        return userRepository.findAll(); // ≈ User::all()
    }
    
    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user); // ≈ User::create()
    }
}
```

### **5.3 Entidade JPA**
```java
@Entity // ≈ Eloquent Model
@Table(name = "users")
public class User {
    @Id // ≈ $primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false) // ≈ $fillable
    private String name;
    
    // Getters e Setters
}
```

---

## 6. 🎯 DESAFIO DO DOJO

### **Missão: Transcender um CRUD Laravel**
Recrie em Java/Spring Boot um CRUD que você já fez em Laravel (ex: Blog, Todo App).

**Requisitos:**
- [ ] Entidade com 3+ atributos (como um Model)
- [ ] Controller com GET, POST, PUT, DELETE
- [ ] Validações básicas (como FormRequest)
- [ ] ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository com 1 método custom
- [ ] Teste manual via Postman

**Tempo:** 7 dias

---

## 7. 📚 RECURSOS DO APRENDIZADO

### **Documentação Oficial**
- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)

### **Cursos Recomendados**
- Spring Boot 3 Tutorial (YouTube)
- Java Programming Masterclass (Udemy)

### **Livros**
- "Spring Boot in Action"
- "Effective Java"

---

## 🍵 PALAVRAS FINAIS DO SENSEI

Você deu o passo mais importante: **entender a essência**. Agora a prática levará à maestria.

**Lembre-se:** Cada erro de compilação é um ensinamento. Cada exception é uma oportunidade de crescimento.

O caminho do código é longo, mas você já começou a trilhá-lo com sabedoria.

**Próxima aula:** Spring Data JPA em profundidade - o Eloquent do mundo Java.

---

🏮 **ESTA APOSTILA É SEU GUIA. ESTUDE-A, PRATIQUE-A, TRANSCENDA-A.**

**O dojo aguarda seu progresso, discípulo!** 🐉

---

## Roadmap dev laravel(php) to java(spring boot) - Suggested Order of Topics

1. Philosophy & Mentality First:
   Start with the mindset and philosophy of Java vs PHP, to set the stage for the transition.
2. Environment & Setup:
   Move the practical setup (JDK, Maven, Docker, folder structure) right after the philosophy, so learners can get ready before diving into concepts.
3. Java Architecture & Editions:
   Introduce JVM, JDK/JRE, and Java editions (SE, EE, ME) after the environment, so the technical foundation is clear.
4. Tools & Build Systems:
   Present Maven/Gradle, Tomcat, and their analogies, so learners know how projects are built and run.
5. Specifications & Technologies:
   Explain JSRs, common technologies, and the ecosystem, so learners see the big picture.
6. Java Fundamentals:
   Cover Java syntax, types, control structures, and OOP basics.
7. Spring Boot Structure & Example:
   Show how a Spring Boot project is organized and provide a sample controller.
8. ORM, DTO, and Data Flow:
   Clarify JPA vs Hibernate, DTOs, and the request/response flow.
9. Challenge & Resources:
   End with the CRUD challenge, checklist, and learning resources.
10. Final Wisdom:
    Close with motivational advice and next steps.