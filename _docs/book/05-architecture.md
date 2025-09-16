# 📖 **Capítulo 05: Arquitetura e Fluxo**

> **Como uma requisição navega pelo ecossistema Spring Boot**

---

## 🎯 **OBJETIVO DO CAPÍTULO**

Entender o fluxo completo de uma requisição Spring Boot e como as tecnologias se integram, sempre comparando com o fluxo Laravel que você já conhece.

---

## 🔄 **1. FLUXO COMPLETO DE REQUISIÇÃO**

### **Laravel Request Flow:**
```
HTTP Request → Nginx/Apache → index.php → Kernel → Middleware → Router → Controller → Service → Model → Database
                                                                                ↓
                                                                            Response ← View/JSON
```

### **Spring Boot Request Flow:**
```
HTTP Request → Tomcat → DispatcherServlet → Interceptor → Controller → Service → Repository → Database
                                                                          ↓
                                                                      Response ← JSON/View
```

### **Comparação Detalhada:**

| Camada | Laravel | Spring Boot | Função |
|--------|---------|-------------|---------|
| **Web Server** | Nginx/Apache | Tomcat Embedado | Recebe requisição HTTP |
| **Entry Point** | `index.php` | `DispatcherServlet` | Ponto de entrada da aplicação |
| **Middleware** | Laravel Middleware | Interceptor/Filter | Processamento antes/depois |
| **Routing** | Route::get() | @GetMapping | Mapeia URL para método |
| **Controller** | Controller | @RestController | Lógica de apresentação |
| **Business Logic** | Service/Action | @Service | Regras de negócio |
| **Data Access** | Eloquent Model | @Repository | Acesso aos dados |
| **Response** | JSON/Blade | JSON/Thymeleaf | Resposta formatada |

---

## 🏗️ **2. ARQUITETURA EM CAMADAS**

### **Laravel Architecture:**
```
┌─────────────────┐
│   Routes/API    │ ← Definição de rotas
├─────────────────┤
│   Controllers   │ ← Lógica de apresentação
├─────────────────┤
│ Services/Actions│ ← Lógica de negócio
├─────────────────┤
│     Models      │ ← Acesso aos dados
├─────────────────┤
│    Database     │ ← Persistência
└─────────────────┘
```

### **Spring Boot Architecture:**
```
┌─────────────────┐
│  @RestController│ ← Controllers com anotações
├─────────────────┤
│    @Service     │ ← Lógica de negócio
├─────────────────┤
│   @Repository   │ ← Acesso aos dados (JPA)
├─────────────────┤
│    @Entity      │ ← Mapeamento de dados
├─────────────────┤
│    Database     │ ← Persistência
└─────────────────┘
```

### **Principais Diferenças:**

| Aspecto | Laravel | Spring Boot |
|---------|---------|-------------|
| **Roteamento** | Arquivo `routes/` | Anotações no controller |
| **DI Container** | Service Container | Spring Container |
| **ORM** | Eloquent | JPA/Hibernate |
| **Config** | Arrays PHP | Annotations + Properties |
| **Middleware** | Classes + Kernel | Interceptors + Filters |

---

## 📊 **3. TECNOLOGIAS COMUNS NO ECOSSISTEMA**

### **Mapeamento Laravel → Spring Boot:**

| Camada | Laravel Technologies | Spring Boot Technologies | Função |
|--------|---------------------|-------------------------|---------|
| **Build** | Composer | Maven, Gradle | Gerenciamento de dependências |
| **Web** | Routing, Controllers | Spring MVC, Jersey | Camada web |
| **Data** | Eloquent ORM | JPA/Hibernate, Spring Data | Persistência |
| **Security** | Laravel Auth, Sanctum | Spring Security, JWT | Autenticação/Autorização |
| **Testing** | PHPUnit, Mockery | JUnit, Mockito, Testcontainers | Testes |
| **Caching** | Redis, Memcached | Redis, Caffeine, Hazelcast | Cache |
| **Queue** | Laravel Queues | RabbitMQ, Kafka, Spring Cloud | Processamento assíncrono |
| **Deploy** | Docker, Forge | Docker, Kubernetes, JAR | Deploy e orquestração |

### **Detalhamento por Camada:**

#### **🔧 Build & Dependencies**
```xml
<!-- Maven (pom.xml) ≈ composer.json -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
</dependencies>
```

#### **🌐 Web Layer**
```java
// Spring MVC ≈ Laravel Controllers
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @GetMapping
    public List<UserDTO> index() {
        // ≈ UserController@index no Laravel
    }
    
    @PostMapping
    public UserDTO store(@RequestBody CreateUserDTO dto) {
        // ≈ UserController@store no Laravel
    }
}
```

#### **🗃️ Data Layer**
```java
// Spring Data JPA ≈ Eloquent
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // ≈ User::where('active', true)->get()
    List<User> findByActiveTrue();
    
    // ≈ User::where('email', $email)->first()
    Optional<User> findByEmail(String email);
}
```

#### **🔒 Security Layer**
```java
// Spring Security ≈ Laravel Auth
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .build();
    }
}
```

---

## ⚡ **4. EXEMPLO PRÁTICO: FLUXO COMPLETO**

### **Cenário:** API para gerenciar usuários

#### **Laravel Implementation:**
```php
// routes/api.php
Route::apiResource('users', UserController::class);

// app/Http/Controllers/UserController.php
class UserController extends Controller {
    public function index() {
        $users = User::all();
        return UserResource::collection($users);
    }
    
    public function store(StoreUserRequest $request) {
        $user = User::create($request->validated());
        return new UserResource($user);
    }
}

// app/Models/User.php
class User extends Model {
    protected $fillable = ['name', 'email'];
}
```

#### **Spring Boot Implementation:**
```java
// UserController.java
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<UserDTO> index() {
        return userService.findAll();
    }
    
    @PostMapping
    public UserDTO store(@Valid @RequestBody CreateUserDTO dto) {
        return userService.create(dto);
    }
}

// UserService.java
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    public UserDTO create(CreateUserDTO dto) {
        User user = new User(dto.getName(), dto.getEmail());
        User saved = userRepository.save(user);
        return toDTO(saved);
    }
    
    private UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName());
    }
}

// User.java (Entity)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    // Construtores, getters, setters...
}

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```

---

## 🚦 **5. INTERCEPTORS E FILTERS (MIDDLEWARE)**

### **Laravel Middleware:**
```php
// app/Http/Middleware/EnsureApiKey.php
class EnsureApiKey {
    public function handle($request, Closure $next) {
        if (!$request->header('X-API-KEY')) {
            return response()->json(['error' => 'API key required'], 401);
        }
        return $next($request);
    }
}

// Aplicar no Kernel ou Route
Route::middleware('api.key')->group(function () {
    Route::get('/users', [UserController::class, 'index']);
});
```

### **Spring Boot Interceptor:**
```java
// ApiKeyInterceptor.java
@Component
public class ApiKeyInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler) throws Exception {
        
        String apiKey = request.getHeader("X-API-KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("{\"error\":\"API key required\"}");
            return false;
        }
        return true;
    }
}

// WebConfig.java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Autowired
    private ApiKeyInterceptor apiKeyInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiKeyInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public/**");
    }
}
```

---

## 🔍 **6. CONFIGURAÇÃO E PROFILES**

### **Laravel Environments:**
```bash
# .env
APP_ENV=production
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
CACHE_DRIVER=redis
```

### **Spring Boot Profiles:**
```properties
# application.properties (default)
spring.profiles.active=development
server.port=8080

# application-development.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.show-sql=true

# application-production.properties
spring.datasource.url=jdbc:postgresql://prod-db:5432/myapp
spring.jpa.show-sql=false
logging.level.com.myapp=WARN
```

**Ativação de profiles:**
```bash
# Desenvolvimento
java -jar app.jar --spring.profiles.active=development

# Produção
java -jar app.jar --spring.profiles.active=production
```

---

## ✅ **CHECKLIST DO CAPÍTULO**

Certifique-se de que entende:

- [ ] **Fluxo de requisição** Spring Boot vs Laravel
- [ ] **Arquitetura em camadas** com anotações
- [ ] **Tecnologias equivalentes** em cada camada
- [ ] **Interceptors** como middleware
- [ ] **Profiles** para diferentes ambientes
- [ ] **Separação clara** de responsabilidades

---

## 🎓 **EXERCÍCIO PRÁTICO**

Mapear um projeto Laravel existente para Spring Boot:

1. **Identifique as camadas** do seu projeto Laravel
2. **Liste as tecnologias** usadas em cada camada
3. **Encontre os equivalentes** Spring Boot
4. **Desenhe o fluxo** de uma requisição complexa
5. **Compare a configuração** de ambientes

---

## 🚀 **PRÓXIMO CAPÍTULO**

Agora que você entende a arquitetura, vamos colocar a mão na massa:

**Próximo:** [Capítulo 06: Spring Boot na Prática](./06-spring-boot-basics.md)

---

## 🧠 **RESUMO EXECUTIVO**

**Arquitetura Spring Boot vs Laravel:**

✅ **Fluxo similar** mas com anotações em vez de arquivos  
✅ **Camadas bem definidas** com responsabilidades claras  
✅ **Tecnologias equivalentes** para cada necessidade  
✅ **Interceptors** = middleware robusto  
✅ **Profiles** = ambientes configuráveis  

**A estrutura é familiar, mas mais robusta e tipada!** 🐉

---

🏮 **ARQUITETURA COMPREENDIDA! VAMOS À PRÁTICA!** 🐉
