# 🗺️ **PLANO DE REVISÃO PERSONALIZADO**

> **Roadmap otimizado para quem já praticou Java básico**

---

## 📊 **SEU STATUS ATUAL**

✅ **JÁ DOMINADO (prática):**
- ✅ Sintaxe Java (tipos, variáveis, operadores)
- ✅ OOP Avançado (classes, herança, interfaces, polimorfismo)
- ✅ Collections (List, Map, Set, Stream API)
- ✅ Exception Handling (try/catch, custom exceptions)

⚠️ **PRECISA REVISAR (teoria + contexto):**
- 🔍 Ambiente e ferramentas (Cap 00-02)
- 🗃️ Camada de dados JPA/Hibernate (Cap 03)
- 🏗️ Arquitetura Spring Boot (Cap 05)
- 🚀 Spring Boot prático (Cap 06-07)

---

## 🎯 **REVISÃO RÁPIDA (45 min)**

### **⚡ 1. AMBIENTE E FERRAMENTAS (15 min)**

**Cap 00-02: O que você PRECISA saber:**

#### **🔧 Verificar seu ambiente:**
```bash
# Teste rápido - execute no terminal:
java -version    # Precisa ser JDK 11+
mvn --version    # Maven instalado?
docker --version # Docker funcionando?
```

#### **📦 Maven vs Composer:**
| Laravel | Java/Maven | Função |
|---------|------------|---------|
| `composer.json` | `pom.xml` | Dependências |
| `composer install` | `mvn install` | Instalar deps |
| `vendor/` | `target/` | Libs baixadas |

#### **🏗️ Estrutura de projeto:**
```
Laravel:                    Spring Boot:
├── app/                   ├── src/main/java/
├── config/                ├── src/main/resources/
├── composer.json          ├── pom.xml
└── .env                   └── application.properties
```

### **⚡ 2. CAMADA DE DADOS (15 min)**

**Cap 03: JPA/Hibernate vs Eloquent**

#### **🗃️ Conceitos essenciais:**
```java
// Laravel: Model
class User extends Model {
    protected $fillable = ['name', 'email'];
}

// Java: Entity + DTO
@Entity
public class User {
    @Id private Long id;
    private String name;
    private String email;
}

// DTO (nunca expor Entity)
public record UserDTO(Long id, String name, String email) {}
```

#### **🔍 Repository Pattern:**
```php
// Laravel: Eloquent direto
$users = User::where('active', true)->get();

// Java: Repository interface
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByActiveTrue();
}
```

### **⚡ 3. ARQUITETURA SPRING BOOT (15 min)**

**Cap 05: Fluxo de requisição**

#### **🔄 Comparação de fluxo:**
```
Laravel:
Request → Router → Controller → Service → Model → DB

Spring Boot:
Request → @RestController → @Service → @Repository → Entity → DB
```

#### **📋 Anotações principais:**
| Laravel | Spring Boot | Função |
|---------|-------------|---------|
| Route::get() | @GetMapping | Mapear endpoint |
| Service class | @Service | Lógica de negócio |
| Repository | @Repository | Acesso dados |
| Model | @Entity | Mapeamento DB |

---

## 🚀 **PRÓXIMOS PASSOS PRÁTICOS**

### **1. 🧪 TESTE SEU AMBIENTE (5 min)**
```bash
cd /home/emilio/apps/learning/java/devphp-to-devjava/src
javac --version  # Funciona?
java PrimitiveTypes  # Seus exemplos rodam?
```

### **2. 📖 LEIA OS CAPÍTULOS ESTRATÉGICOS (30 min)**
- **Cap 03**: [Camada de Dados](./_docs/book/03-data-layer.md) - JPA vs Eloquent
- **Cap 05**: [Arquitetura](./_docs/book/05-architecture.md) - Fluxo Spring Boot
- **Cap 06**: [Spring Boot Básico](./_docs/book/06-spring-boot-basics.md) - CRUD prático

### **3. 🏗️ CRIAR PROJETO SPRING BOOT (Cap 06)**
Seguir o passo-a-passo do capítulo 06 para criar seu primeiro CRUD.

### **4. 🎯 DESAFIO PRÁTICO (Cap 07)**
Implementar um projeto completo usando tudo que aprendeu.

---

## 🎓 **CHECKLIST DE VALIDAÇÃO**

Antes de partir para Spring Boot, confirme que entende:

### **🔧 Ambiente:**
- [ ] JDK vs JRE vs JVM (como PHP vs Zend Engine)
- [ ] Maven vs Composer (gestão de dependências)
- [ ] Estrutura de projeto Java

### **🗃️ Dados:**
- [ ] Entity vs DTO (Model vs Resource)
- [ ] JPA vs Hibernate vs Spring Data
- [ ] Repository pattern

### **🏗️ Arquitetura:**
- [ ] @RestController vs Laravel Controller
- [ ] @Service vs Laravel Service
- [ ] @Repository vs Laravel Repository
- [ ] Fluxo de requisição completo

---

## 💡 **DICA DO SENSEI**

Você está em uma posição **privilegiada**: já sabe Java na prática, agora só precisa **contextualizar** com o ecossistema Spring Boot.

**É como saber PHP e agora aprender Laravel** - você já conhece a linguagem, só precisa entender o framework!

---

🎯 **PRÓXIMA AÇÃO:** Revisar Cap 03 (15 min) → Cap 05 (15 min) → Partir para Cap 06 (prática Spring Boot)!
