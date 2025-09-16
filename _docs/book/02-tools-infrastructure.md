# 📖 **Capítulo 02: Ferramentas e Infraestrutura**

> **Maven, Gradle, Tomcat e o ecossistema de ferramentas Java**

---

## 🎯 **OBJETIVO DO CAPÍTULO**

Dominar as ferramentas essenciais do ecossistema Java, sempre traçando paralelos com o que você já usa no Laravel/PHP.

---

## 🐘 **1. SERVIDORES: TOMCAT vs APACHE**

| Servidor | Função | Analogia Laravel/PHP |
|----------|---------|---------------------|
| **Tomcat** | Servlet Container | PHP-FPM + Nginx (executa o código da sua app) |
| **Jetty** | Servlet Container leve | PHP built-in server (para desenvolvimento) |
| **WildFly** | Full Java EE Server | Apache + PHP + todos os módulos enterprise |

### **Analogia Detalhada:**

**No Laravel você tem:**
```bash
# Desenvolvimento
php artisan serve  # Servidor built-in

# Produção
nginx + php-fpm   # Nginx serve estáticos, PHP-FPM executa PHP
```

**No Spring Boot você tem:**
```bash
# Desenvolvimento E produção
mvn spring-boot:run  # Tomcat embedado já incluso!
```

### **Spring Boot = Revolução**

**Laravel tradicional:** Você instala separadamente:
- Nginx/Apache (servidor web)
- PHP-FPM (processador PHP) 
- Sua aplicação

**Spring Boot:** Tudo vem junto!
- ✅ Tomcat embedado
- ✅ Sua aplicação
- ✅ Configuração automática

**Resultado:** Um único JAR que você pode executar em qualquer lugar com JRE!

---

## 📦 **2. GERENCIADORES DE DEPENDÊNCIA**

### **Maven (XML) ≈ Composer (PHP)**

**Laravel composer.json:**
```json
{
    "require": {
        "laravel/framework": "^10.0",
        "guzzlehttp/guzzle": "^7.0"
    }
}
```

**Java pom.xml:**
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
</dependencies>
```

### **Gradle (Kotlin/Groovy) ≈ Composer + Task Runner**

**Laravel com scripts:**
```json
{
    "scripts": {
        "test": "phpunit",
        "build": "npm run build"
    }
}
```

**Java build.gradle.kts:**
```kotlin
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}
```

### **Qual Escolher?**

| Ferramenta | Prós | Contras | Recomendação |
|------------|------|---------|--------------|
| **Maven** | Mais documentação, padrão de facto | XML verboso | ✅ **Iniciantes** |
| **Gradle** | Mais flexível, sintaxe limpa | Curva de aprendizado | ⚡ Projetos avançados |

**Para quem vem do Laravel:** Comece com **Maven** - é como o Composer, mas com superpoderes.

---

## 🧩 **3. ESPECIFICAÇÕES (JSRs) vs IMPLEMENTAÇÕES**

### **Conceito Fundamental:**

No PHP você tem:
```php
// Uma forma de fazer ORM
$user = User::find(1);  // Eloquent
```

No Java você tem:
```java
// JPA = Especificação (como "interface")
@Entity
public class User { ... }

// Hibernate = Implementação mais popular
// EclipseLink = Outra implementação
// Ambos seguem o padrão JPA
```

### **Principais JSRs para Web Development:**

| JSR | Nome | Função | Analogia Laravel |
|-----|------|---------|------------------|
| **JSR 338** | JPA | Persistência de dados | Eloquent ORM |
| **JSR 369** | Servlet | Web applications | Rotas/Controllers |
| **JSR 380** | Bean Validation | Validação de dados | Form Requests |
| **JSR 365** | CDI | Injeção de dependência | Service Container |

### **Vantagem das Especificações:**

**Problema no PHP:**
```php
// Se você usar Doctrine em vez de Eloquent:
$em = $entityManager->find(User::class, 1);  // API diferente
```

**Solução no Java:**
```java
// Tanto Hibernate quanto EclipseLink usam JPA:
User user = entityManager.find(User.class, 1L);  // API padrão
```

**Resultado:** Você pode trocar de implementação sem reescrever código!

---

## 🛠️ **4. COMANDOS ESSENCIAIS**

### **Maven Commands (≈ Composer + Artisan)**

| Maven | Laravel Equivalente | Função |
|-------|-------------------|---------|
| `mvn clean` | `composer clear-cache` | Limpa cache |
| `mvn compile` | - | Compila código |
| `mvn test` | `php artisan test` | Executa testes |
| `mvn spring-boot:run` | `php artisan serve` | Inicia servidor |
| `mvn package` | - | Gera JAR |
| `mvn dependency:tree` | `composer show --tree` | Mostra dependências |

### **Gradle Commands**

| Gradle | Maven | Laravel | Função |
|--------|-------|---------|---------|
| `./gradlew build` | `mvn package` | - | Build completo |
| `./gradlew test` | `mvn test` | `php artisan test` | Testes |
| `./gradlew bootRun` | `mvn spring-boot:run` | `php artisan serve` | Servidor |
| `./gradlew dependencies` | `mvn dependency:tree` | `composer show` | Dependências |

---

## 🏗️ **5. ESTRUTURA DE PROJETO**

### **Laravel Structure:**
```
laravel-app/
├── app/
│   ├── Http/Controllers/
│   ├── Models/
│   └── Services/
├── composer.json
└── artisan
```

### **Spring Boot Structure:**
```
spring-app/
├── src/main/java/com/empresa/app/
│   ├── controller/
│   ├── entity/
│   ├── repository/
│   ├── service/
│   └── Application.java
├── pom.xml (ou build.gradle)
└── mvnw (Maven wrapper)
```

### **Mapeamento Direto:**

| Laravel | Spring Boot | Função |
|---------|-------------|---------|
| `app/Http/Controllers/` | `controller/` | Controllers |
| `app/Models/` | `entity/` | Models/Entities |
| `app/Services/` | `service/` | Business Logic |
| `app/Repositories/` | `repository/` | Data Access |
| `composer.json` | `pom.xml` | Dependencies |
| `artisan` | `mvnw` | CLI tool |

---

## 🎯 **6. WORKFLOW DE DESENVOLVIMENTO**

### **Laravel Workflow:**
```bash
# 1. Instalar dependências
composer install

# 2. Configurar ambiente
cp .env.example .env
php artisan key:generate

# 3. Executar migrações
php artisan migrate

# 4. Iniciar servidor
php artisan serve
```

### **Spring Boot Workflow:**
```bash
# 1. Instalar dependências (automático)
mvn clean compile

# 2. Configurar banco (application.properties)
# spring.datasource.url=jdbc:postgresql://localhost:5432/dojo

# 3. Executar aplicação (cria tabelas automaticamente)
mvn spring-boot:run
```

### **Diferenças Chave:**

| Aspecto | Laravel | Spring Boot |
|---------|---------|-------------|
| **Dependências** | Manual (`composer install`) | Automático (Maven/Gradle) |
| **Configuração** | Arquivo `.env` | `application.properties/yml` |
| **Migrações** | Manual (`artisan migrate`) | Automático (JPA/Hibernate) |
| **Servidor** | Externo (nginx) ou built-in | Sempre embedado |

---

## ✅ **CHECKLIST DO CAPÍTULO**

Certifique-se de que entende:

- [ ] **Tomcat é embedado no Spring Boot** (não precisa instalar separadamente)
- [ ] **Maven ≈ Composer** (gerencia dependências)
- [ ] **JSRs são especificações** (você pode trocar implementações)
- [ ] **Estrutura de projeto** é similar ao Laravel
- [ ] **Workflow é mais automatizado** que no Laravel

---

## 🎓 **EXERCÍCIO PRÁTICO**

1. **Crie um projeto Maven:**
```bash
cd ~/java-projects/labs
mvn archetype:generate \
  -DgroupId=com.dojo \
  -DartifactId=tools-demo \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

2. **Explore a estrutura:**
```bash
cd tools-demo
find . -name "*.xml" -o -name "*.java" | head -10
```

3. **Compare com Laravel:**
```bash
# No seu projeto Laravel
find . -name "composer.json" -o -name "*.php" | head -10
```

---

## 🚀 **PRÓXIMO CAPÍTULO**

Agora que você domina as ferramentas, vamos entender como o Java lida com dados:

**Próximo:** [Capítulo 03: Camada de Dados](./03-data-layer.md)

---

## 🧠 **RESUMO EXECUTIVO**

**Para desenvolvedores Laravel:**

✅ **Maven/Gradle** = Composer com superpoderes  
✅ **Tomcat embedado** = Nunca mais configurar nginx  
✅ **JSRs** = Padrões que garantem compatibilidade  
✅ **Workflow automatizado** = Menos configuração manual  
✅ **JAR único** = Deploy super simples  

**O ganho:** Infraestrutura muito mais robusta e padronizada.

---

🏮 **FERRAMENTAS DOMINADAS! AGORA VAMOS AOS DADOS!** 🐉
