# 📖 **Capítulo 03: Camada de Dados**

> **JPA, Hibernate, DTOs e persistência de dados no mundo Java**

---

## 🎯 **OBJETIVO DO CAPÍTULO**

Entender como Java lida com bancos de dados, ORMs, e transferência de dados, sempre comparando com Eloquent e practices do Laravel.

---

## 🗃️ **1. ORM: JPA vs HIBERNATE**

### **Conceito Fundamental:**

**No Laravel você tem:**
```php
// Eloquent É o ORM
class User extends Model {
    protected $fillable = ['name', 'email'];
}

$user = User::find(1);
```

**No Java você tem:**
```java
// JPA = Especificação (contrato)
// Hibernate = Implementação mais popular

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String email;
}
```

### **Analogia Detalhada:**

| Conceito | Laravel | Java |
|----------|---------|------|
| **ORM Framework** | Eloquent (único) | JPA (especificação) |
| **Implementação** | Eloquent (uma só) | Hibernate, EclipseLink, OpenJPA |
| **Configuration** | `config/database.php` | `application.properties` |
| **Migrations** | `php artisan migrate` | Auto-DDL ou Flyway |

### **JPA (Specification) ≈ Interface do Eloquent**

```java
// JPA define COMO fazer, não FAZ
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true)
    private String email;
    
    // Construtores, getters, setters...
}
```

### **Hibernate (Implementation) ≈ Implementação Concreta**

```java
// Hibernate FAZ o trabalho pesado
// Spring Boot usa Hibernate por padrão
// Você raramente interage diretamente com Hibernate
```

**Analogia Laravel:** É como se o Eloquent fosse dividido em:
- **Interface:** Definindo contratos (`Model`, `Builder`, etc.)
- **Implementação:** Fazendo SQL queries, conexões, cache, etc.

---

## 📨 **2. DTO (Data Transfer Object)**

### **Problema que DTOs Resolvem:**

**Laravel sem Resources:**
```php
// PERIGOSO: Expõe dados sensíveis
return User::all(); // Inclui password, created_at, etc.
```

**Laravel com Resources:**
```php
// SEGURO: Controla o que é exposto
class UserResource extends JsonResource {
    public function toArray($request) {
        return [
            'id' => $this->id,
            'name' => $this->name,
            // password NÃO incluído
        ];
    }
}
```

**Java com DTOs:**
```java
// ENTITY (Banco de dados) - nunca expor diretamente
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String password; // ← Dado sensível!
    private LocalDateTime createdAt;
}

// DTO (API Response) - só dados seguros
public record UserDTO(Long id, String name) {}
// ou classe tradicional com getters/setters
```

### **Benefícios dos DTOs:**

| Benefício | Explicação | Analogia Laravel |
|-----------|------------|------------------|
| **Segurança** | Esconde campos sensíveis | `UserResource` |
| **Performance** | Menos dados na rede | `Resource::collection()` |
| **Desacoplamento** | Mudar entity ≠ mudar API | API Resources |
| **Versionamento** | APIs v1, v2 diferentes | Resource versioning |

### **DTOs na Prática:**

```java
// Controller não retorna Entity diretamente
@RestController
public class UserController {
    
    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        // Conversão Entity → DTO
        return new UserDTO(user.getId(), user.getName());
    }
    
    @PostMapping("/users")
    public UserDTO createUser(@RequestBody CreateUserDTO createDto) {
        User user = userService.create(createDto);
        return new UserDTO(user.getId(), user.getName());
    }
}
```

---

## 🔗 **3. RELACIONAMENTOS**

### **Laravel Relationships:**
```php
class User extends Model {
    public function posts() {
        return $this->hasMany(Post::class);
    }
}

class Post extends Model {
    public function user() {
        return $this->belongsTo(User::class);
    }
}

// Uso
$user = User::with('posts')->find(1);
```

### **JPA Relationships:**
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    // One-to-Many (hasMany)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();
}

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    
    // Many-to-One (belongsTo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
```

### **Mapeamento de Relacionamentos:**

| Laravel | JPA | Descrição |
|---------|-----|-----------|
| `hasMany` | `@OneToMany` | 1 usuário → N posts |
| `belongsTo` | `@ManyToOne` | N posts → 1 usuário |
| `belongsToMany` | `@ManyToMany` | Users ↔ Roles |
| `hasOne` | `@OneToOne` | User → Profile |

---

## 🔍 **4. QUERIES E REPOSITÓRIOS**

### **Laravel Eloquent:**
```php
// Simple queries
$users = User::where('active', true)->get();
$user = User::find(1);

// Complex queries
$users = User::where('created_at', '>', '2023-01-01')
             ->whereHas('posts', function($q) {
                 $q->where('published', true);
             })
             ->orderBy('name')
             ->get();
```

### **Spring Data JPA:**
```java
// Repository interface (como Eloquent automático)
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Query methods (Spring gera SQL automaticamente)
    List<User> findByActiveTrue();
    Optional<User> findByEmail(String email);
    List<User> findByCreatedAtAfter(LocalDateTime date);
    
    // Custom queries (como raw SQL no Laravel)
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> findByNameContaining(@Param("name") String name);
}

// Uso no Service
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getActiveUsers() {
        return userRepository.findByActiveTrue(); // Gera: WHERE active = true
    }
}
```

### **Comparação Query Methods:**

| Laravel | Spring Data JPA | SQL Gerado |
|---------|-----------------|------------|
| `User::where('active', true)` | `findByActiveTrue()` | `WHERE active = true` |
| `User::where('email', $email)` | `findByEmail(email)` | `WHERE email = ?` |
| `User::orderBy('name')` | `findAllByOrderByNameAsc()` | `ORDER BY name ASC` |

---

## 🏭 **5. CONFIGURAÇÃO DE BANCO**

### **Laravel (.env):**
```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=laravel
DB_USERNAME=root
DB_PASSWORD=secret
```

### **Spring Boot (application.properties):**
```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/dojo
spring.datasource.username=samurai
spring.datasource.password=secret

# JPA/Hibernate config
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### **Opções de DDL (≈ Migrations):**

| Opção | Função | Laravel Equivalente |
|-------|---------|---------------------|
| `create-drop` | Recria BD a cada start | `migrate:fresh` sempre |
| `create` | Cria BD no start | `migrate` primeira vez |
| `update` | Atualiza schema | `migrate` automático |
| `validate` | Só valida | Não modifica BD |
| `none` | Não mexe no BD | Manual migrations |

---

## ✅ **CHECKLIST DO CAPÍTULO**

Certifique-se de que entende:

- [ ] **JPA é especificação, Hibernate é implementação** (como interface vs classe)
- [ ] **DTOs protegem dados sensíveis** (como Laravel Resources)
- [ ] **Relacionamentos JPA** são similares ao Eloquent
- [ ] **Query methods** geram SQL automaticamente
- [ ] **spring.jpa.hibernate.ddl-auto** controla migrações

---

## 🎓 **EXERCÍCIO PRÁTICO**

1. **Crie uma Entity:**
```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    
    // Getters e Setters
}
```

2. **Crie um DTO:**
```java
public record ProductDTO(Long id, String name, BigDecimal price) {}
```

3. **Compare com Laravel:**
```php
// Laravel Model
class Product extends Model {
    protected $fillable = ['name', 'price'];
}

// Laravel Resource  
class ProductResource extends JsonResource {
    public function toArray($request) {
        return [
            'id' => $this->id,
            'name' => $this->name,
            'price' => $this->price,
        ];
    }
}
```

---

## 🚀 **PRÓXIMO CAPÍTULO**

Agora que você entende como o Java lida com dados, vamos ver a arquitetura completa:

**Próximo:** [Capítulo 04: Arquitetura e Fluxo](./04-architecture.md)

---

## 🧠 **RESUMO EXECUTIVO**

**Para desenvolvedores Laravel:**

✅ **JPA ≈ Eloquent Interface** (especificação padrão)  
✅ **Hibernate ≈ Eloquent Implementation** (faz o trabalho)  
✅ **DTOs ≈ API Resources** (segurança e controle)  
✅ **Query Methods** = Eloquent scopes automáticos  
✅ **spring.jpa.hibernate.ddl-auto** = migrations automáticas  

**O ganho:** ORM padronizado + DTOs obrigatórios = APIs mais seguras.

---

🏮 **DADOS DOMINADOS! VAMOS À ARQUITETURA COMPLETA!** 🐉
