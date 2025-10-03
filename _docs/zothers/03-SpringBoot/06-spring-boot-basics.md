# 📖 **Capítulo 06: Spring Boot na Prática**

> **Construindo sua primeira aplicação: do zero ao CRUD completo**

---

## 🎯 **OBJETIVO DO CAPÍTULO**

Criar uma aplicação Spring Boot completa do zero, implementando um CRUD funcional com todas as melhores práticas, sempre comparando com como você faria no Laravel.

---

## 🌱 **1. INICIALIZANDO O PROJETO**

### **Laravel Project Setup:**
```bash
# Laravel
composer create-project laravel/laravel blog-api
cd blog-api
cp .env.example .env
php artisan key:generate
php artisan migrate
php artisan serve
```

### **Spring Boot Project Setup:**
```bash
# Usando Spring Initializr (start.spring.io)
curl https://start.spring.io/starter.zip \
  -d dependencies=web,data-jpa,h2,validation \
  -d groupId=com.dojo \
  -d artifactId=blog-api \
  -d name=blog-api \
  -d packageName=com.dojo.blogapi \
  -d javaVersion=21 \
  -o blog-api.zip

unzip blog-api.zip
cd blog-api
mvn spring-boot:run
```

### **Estrutura Inicial:**
```
blog-api/
├── src/main/java/com/dojo/blogapi/
│   ├── BlogApiApplication.java     # ≈ bootstrap/app.php
│   ├── controller/                 # ≈ app/Http/Controllers/
│   ├── entity/                     # ≈ app/Models/
│   ├── repository/                 # ≈ app/Repositories/
│   ├── service/                    # ≈ app/Services/
│   └── dto/                        # ≈ app/Http/Resources/
├── src/main/resources/
│   ├── application.properties      # ≈ .env + config/
│   └── data.sql                    # ≈ database/seeders/
├── src/test/java/                  # ≈ tests/
└── pom.xml                         # ≈ composer.json
```

---

## 🗃️ **2. CONFIGURANDO O BANCO DE DADOS**

### **Laravel Configuration:**
```php
// .env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_DATABASE=blog
DB_USERNAME=root
DB_PASSWORD=secret

// config/database.php já configurado
```

### **Spring Boot Configuration:**
```properties
# src/main/resources/application.properties

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/blog
spring.datasource.username=samurai
spring.datasource.password=secret

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080
```

**Para desenvolvimento rápido (H2 in-memory):**
```properties
# H2 Database (como SQLite)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=create-drop
```

---

## 📝 **3. CRIANDO O MODEL/ENTITY**

### **Laravel Model:**
```php
// app/Models/Post.php
<?php

class Post extends Model
{
    protected $fillable = [
        'title',
        'content',
        'author_id',
        'published'
    ];

    protected $casts = [
        'published' => 'boolean',
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];

    public function author()
    {
        return $this->belongsTo(User::class, 'author_id');
    }
}
```

### **Spring Boot Entity:**
```java
// src/main/java/com/dojo/blogapi/entity/Post.java
package com.dojo.blogapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;
    
    @NotBlank(message = "Content is required")
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @NotNull(message = "Author is required")
    @Column(name = "author_id", nullable = false)
    private Long authorId;
    
    @Column(nullable = false)
    private Boolean published = false;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Construtores
    public Post() {}
    
    public Post(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.published = false;
    }
    
    // Métodos de ciclo de vida
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
    
    public Boolean getPublished() { return published; }
    public void setPublished(Boolean published) { this.published = published; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
```

---

## 📦 **4. CRIANDO DTOS (RESOURCES)**

### **Laravel Resources:**
```php
// app/Http/Resources/PostResource.php
class PostResource extends JsonResource
{
    public function toArray($request)
    {
        return [
            'id' => $this->id,
            'title' => $this->title,
            'content' => $this->content,
            'published' => $this->published,
            'created_at' => $this->created_at->toISOString(),
        ];
    }
}

// app/Http/Requests/StorePostRequest.php
class StorePostRequest extends FormRequest
{
    public function rules()
    {
        return [
            'title' => 'required|string|max:255',
            'content' => 'required|string',
            'author_id' => 'required|integer|exists:users,id',
        ];
    }
}
```

### **Spring Boot DTOs:**
```java
// src/main/java/com/dojo/blogapi/dto/PostDTO.java
package com.dojo.blogapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record PostDTO(
    Long id,
    String title,
    String content,
    Boolean published,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt
) {}

// src/main/java/com/dojo/blogapi/dto/CreatePostDTO.java
package com.dojo.blogapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePostDTO(
    @NotBlank(message = "Title is required")
    String title,
    
    @NotBlank(message = "Content is required")
    String content,
    
    @NotNull(message = "Author ID is required")
    Long authorId
) {}

// src/main/java/com/dojo/blogapi/dto/UpdatePostDTO.java
package com.dojo.blogapi.dto;

public record UpdatePostDTO(
    String title,
    String content,
    Boolean published
) {}
```

---

## 🗄️ **5. CRIANDO O REPOSITORY**

### **Laravel ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository Pattern (opcional):**
```php
// app/Repositories/PostRepository.php
class PostRepository
{
    public function findAll()
    {
        return Post::all();
    }
    
    public function findPublished()
    {
        return Post::where('published', true)->get();
    }
    
    public function findById($id)
    {
        return Post::findOrFail($id);
    }
}
```

### **Spring Boot ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository:**

```java
// src/main/java/com/dojo/blogapi/repository/PostRepository.java
package com.dojo.blogapi.repository;

import com.dojo.blogapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository;

import java.util.List;
import java.util.Optional;

@ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Query methods (Spring gera automaticamente)
    List<Post> findByPublishedTrue();

    List<Post> findByAuthorId(Long authorId);

    List<Post> findByTitleContainingIgnoreCase(String title);

    // Custom queries
    @Query("SELECT p FROM Post p WHERE p.published = true ORDER BY p.createdAt DESC")
    List<Post> findPublishedPostsOrderByCreatedAtDesc();

    @Query("SELECT p FROM Post p WHERE p.authorId = :authorId AND p.published = :published")
    List<Post> findByAuthorAndPublishedStatus(
            @Param("authorId") Long authorId,
            @Param("published") Boolean published
    );

    // Native query (quando necessário)
    @Query(value = "SELECT * FROM posts WHERE MATCH(title, content) AGAINST(?1 IN NATURAL LANGUAGE MODE)",
            nativeQuery = true)
    List<Post> searchByText(String searchText);
}
```

---

## 🔧 **6. CRIANDO O SERVICE**

### **Laravel Service:**
```php
// app/Services/PostService.php
class PostService
{
    public function __construct(
        private PostRepository $postRepository
    ) {}
    
    public function getAllPosts()
    {
        return $this->postRepository->findAll();
    }
    
    public function createPost(array $data)
    {
        return Post::create($data);
    }
    
    public function updatePost(Post $post, array $data)
    {
        $post->update($data);
        return $post;
    }
}
```

### **Spring Boot Service:**
```java
// src/main/java/com/dojo/blogapi/service/PostService.java
package com.dojo.blogapi.service;

import com.dojo.blogapi.dto.*;
import com.dojo.blogapi.entity.Post;
import com.dojo.blogapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    public List<PostDTO> findPublished() {
        return postRepository.findByPublishedTrue().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    public PostDTO findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return toDTO(post);
    }
    
    public PostDTO create(CreatePostDTO dto) {
        Post post = new Post(dto.title(), dto.content(), dto.authorId());
        Post saved = postRepository.save(post);
        return toDTO(saved);
    }
    
    public PostDTO update(Long id, UpdatePostDTO dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        
        if (dto.title() != null) {
            post.setTitle(dto.title());
        }
        if (dto.content() != null) {
            post.setContent(dto.content());
        }
        if (dto.published() != null) {
            post.setPublished(dto.published());
        }
        
        Post updated = postRepository.save(post);
        return toDTO(updated);
    }
    
    public void delete(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post not found");
        }
        postRepository.deleteById(id);
    }
    
    // Converter Entity para DTO
    private PostDTO toDTO(Post post) {
        return new PostDTO(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getPublished(),
            post.getCreatedAt()
        );
    }
}
```

---

## 🎮 **7. CRIANDO O CONTROLLER**

### **Laravel Controller:**
```php
// app/Http/Controllers/PostController.php
class PostController extends Controller
{
    public function __construct(
        private PostService $postService
    ) {}
    
    public function index()
    {
        $posts = $this->postService->getAllPosts();
        return PostResource::collection($posts);
    }
    
    public function store(StorePostRequest $request)
    {
        $post = $this->postService->createPost($request->validated());
        return new PostResource($post);
    }
    
    public function show(Post $post)
    {
        return new PostResource($post);
    }
    
    public function update(UpdatePostRequest $request, Post $post)
    {
        $updated = $this->postService->updatePost($post, $request->validated());
        return new PostResource($updated);
    }
    
    public function destroy(Post $post)
    {
        $post->delete();
        return response()->noContent();
    }
}
```

### **Spring Boot Controller:**
```java
// src/main/java/com/dojo/blogapi/controller/PostController.java
package com.dojo.blogapi.controller;

import com.dojo.blogapi.dto.*;
import com.dojo.blogapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*") // Para desenvolvimento
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @GetMapping
    public ResponseEntity<List<PostDTO>> index() {
        List<PostDTO> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }
    
    @GetMapping("/published")
    public ResponseEntity<List<PostDTO>> published() {
        List<PostDTO> posts = postService.findPublished();
        return ResponseEntity.ok(posts);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> show(@PathVariable Long id) {
        PostDTO post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
    @PostMapping
    public ResponseEntity<PostDTO> store(@Valid @RequestBody CreatePostDTO dto) {
        PostDTO created = postService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(
            @PathVariable Long id, 
            @Valid @RequestBody UpdatePostDTO dto) {
        PostDTO updated = postService.update(id, dto);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
```

---

## 🚀 **8. TESTANDO A API**

### **Executar a aplicação:**
```bash
mvn spring-boot:run
# ou
./mvnw spring-boot:run
```

### **Endpoints disponíveis:**
```bash
# Listar todos os posts
GET http://localhost:8080/api/posts

# Listar posts publicados
GET http://localhost:8080/api/posts/published

# Buscar post por ID
GET http://localhost:8080/api/posts/1

# Criar novo post
POST http://localhost:8080/api/posts
Content-Type: application/json

{
  "title": "Meu primeiro post",
  "content": "Conteúdo do post...",
  "authorId": 1
}

# Atualizar post
PUT http://localhost:8080/api/posts/1
Content-Type: application/json

{
  "title": "Título atualizado",
  "published": true
}

# Deletar post
DELETE http://localhost:8080/api/posts/1
```

---

## ✅ **CHECKLIST DO CAPÍTULO**

Certifique-se de que implementou:

- [ ] **Entity** com validações e timestamps
- [ ] **DTOs** para request e response
- [ ] **ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository** com query methods
- [ ] **Service** com lógica de negócio
- [ ] **Controller** com todos os endpoints CRUD
- [ ] **Configuração** de banco de dados
- [ ] **Validações** nos DTOs
- [ ] **Tratamento de erros** básico

---

## 🎓 **EXERCÍCIO PRÁTICO**

Estenda a aplicação com:

1. **Entity User** com relacionamento com Post
2. **Paginação** nos endpoints de listagem
3. **Busca** por título/conteúdo
4. **Validações customizadas**
5. **Exception handling** global
6. **Testes unitários** básicos

---

## 🚀 **PRÓXIMO CAPÍTULO**

Agora que você tem uma aplicação funcional, vamos aos desafios práticos:

**Próximo:** [Capítulo 07: Desafios e Recursos](../fundamentals/07-challenge-resources.md)

---

## 🧠 **RESUMO EXECUTIVO**

**Spring Boot CRUD vs Laravel:**

✅ **Estrutura similar** mas mais organizada em camadas  
✅ **DTOs obrigatórios** = APIs mais seguras  
✅ **ObjectOrientedProgramming.main.java.zothers.fundamentals.Repository pattern** nativo e poderoso  
✅ **Validações integradas** com Bean Validation  
✅ **Zero configuração** para funcionalidades básicas  

**Você acabou de criar uma API robusta e tipada!** 🐉

---

🏮 **APLICAÇÃO FUNCIONAL CRIADA! AGORA AOS DESAFIOS!** 🐉
