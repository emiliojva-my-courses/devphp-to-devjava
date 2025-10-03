# 📂 ESTRUTURA DO PROJETO: devphp-to-devjava

## 🗂️ **Estrutura Completa**

```
devphp-to-devjava/
├── README.md                           # Wiki principal (índice navegável)
├── .gitignore
├── pom.xml                             # Maven config (quando chegar em Spring Boot)
│
├── _docs/                              # 📚 Documentação e Wiki
│   │
│   ├── book/                           # 📖 Capítulos do Livro
│   │   │
│   │   ├── 00-prefacio/                # Parte 0: Apresentação
│   │   │   ├── README.md               # Índice desta seção
│   │   │   ├── 00-sobre-esta-wiki.md
│   │   │   ├── 01-metodologias.md
│   │   │   └── 02-roadmap-visual.md
│   │   │
│   │   ├── 01-fundamentos-jdbc/        # PARTE I: JDBC (Semanas 1-2)
│   │   │   ├── README.md               # Índice desta parte
│   │   │   ├── 00-ambiente-setup.md    # JDK + IntelliJ + Maven
│   │   │   ├── 01-sintaxe-java.md      # Tipos, loops, funções
│   │   │   ├── 02-jdbc-basico.md       # Conexão PostgreSQL
│   │   │   ├── 03-crud-jdbc.md         # INSERT, UPDATE, DELETE
│   │   │   └── 04-dao-pattern.md       # Organização de queries
│   │   │
│   │   ├── 02-spring-boot/             # PARTE II: Spring Boot (Semanas 3-5)
│   │   │   ├── README.md
│   │   │   ├── 05-controllers.md       # @RestController
│   │   │   ├── 06-services-di.md       # @Service + DI
│   │   │   ├── 07-validation.md        # Bean Validation
│   │   │   ├── 08-exceptions.md        # Exception Handling
│   │   │   └── 09-dtos.md              # DTOs vs Entities
│   │   │
│   │   └── 03-projeto-legado/          # PARTE III: Arquitetura (Semanas 6-8)
│   │       ├── README.md
│   │       ├── 10-analise-arquitetura.md
│   │       ├── 11-padroes-time.md
│   │       └── 12-primeiro-pr.md
│   │
│   ├── progress/                       # 📊 Acompanhamento Pessoal
│   │   ├── learning-log.md             # Diário diário
│   │   ├── spaced-repetition.md        # Agenda de revisões
│   │   ├── socratic-answers.md         # Suas respostas
│   │   ├── weekly-checkpoints.md       # Autoavaliação semanal
│   │   └── duvidas-time.md             # Perguntas para o líder
│   │
│   ├── templates/                      # 📝 Templates Reutilizáveis
│   │   ├── chapter-template.md         # Template de capítulo
│   │   ├── exercise-template.md        # Template de exercício
│   │   └── daily-log-template.md       # Template diário
│   │
│   └── resources/                      # 🔗 Recursos Externos
│       ├── links-uteis.md
│       ├── glossario.md                # Termos Java → Laravel
│       └── cheatsheet.md               # Comandos rápidos
│
├── src/                                # 💻 Código dos Exercícios
│   ├── main/
│   │   └── java/
│   │       │
│   │       ├── legacy.fundamentals/           # PARTE I: Fundamentos
│   │       │   ├── cap00/              # Capítulo 00: Hello World
│   │       │   ├── cap01/              # Capítulo 01: Sintaxe
│   │       │   │   ├── PrimitiveTypes.java
│   │       │   │   ├── Constants.java
│   │       │   │   ├── ArrayBasic.java
│   │       │   │   ├── Loops.java
│   │       │   │   └── Functions.java
│   │       │   ├── cap02/              # Capítulo 02: JDBC
│   │       │   │   ├── ConnectionTest.java
│   │       │   │   ├── FirstSelect.java
│   │       │   │   └── PreparedStatementDemo.java
│   │       │   ├── cap03/              # Capítulo 03: CRUD
│   │       │   │   ├── InsertExample.java
│   │       │   │   ├── UpdateExample.java
│   │       │   │   ├── DeleteExample.java
│   │       │   │   └── TransactionDemo.java
│   │       │   └── cap04/              # Capítulo 04: DAO
│   │       │       ├── User.java       # Entity (POJO)
│   │       │       ├── UserDAO.java    # Data Access Object
│   │       │       └── main.java.zothers.exercises.Main.java       # Teste do DAO
│   │       │
│   │       ├── springboot/             # PARTE II: Spring Boot
│   │       │   ├── cap05/              # Controllers
│   │       │   ├── cap06/              # Services
│   │       │   └── ...
│   │       │
│   │       └── utils/                  # 🛠️ Utilitários
│   │           ├── DatabaseConfig.java # Config conexão DB
│   │           └── Functions.java      # Funções auxiliares
│   │
│   └── test/                           # 🧪 Testes (Futuro)
│       └── java/
│
└── .idea/                              # IntelliJ IDEA config (gitignored)
```

---

## 🎯 **Convenções de Nomenclatura**

### **Arquivos Markdown:**
- `README.md` → Índice de cada seção
- `00-nome-capitulo.md` → Capítulos numerados
- `kebab-case` → Nomes de arquivos

### **Arquivos Java:**
- `PascalCase.java` → Classes
- `camelCase` → Métodos e variáveis
- `UPPER_CASE` → Constantes
- `capXX/` → Pasta por capítulo

### **Estrutura de Pastas:**
- `_docs/` → Tudo que é texto/documentação
- `src/main/java/` → Código executável
- `progress/` → Seus arquivos pessoais (não commitar se for público)

---

## 📦 **Git: O Que Commitar?**

### ✅ **Commitar:**
```
✓ README.md
✓ _docs/book/**/*.md
✓ _docs/templates/**
✓ _docs/resources/**
✓ src/**/*.java
✓ pom.xml
✓ .gitignore
```

### ❌ **Não Commitar (adicionar ao .gitignore):**
```
✗ _docs/progress/**           # Seu progresso pessoal
✗ .idea/**                    # Config do IntelliJ
✗ target/**                   # Build do Maven
✗ *.class                     # Compilados
✗ .DS_Store                   # macOS
```

---

## 🔄 **Migração do Seu Código Atual**

### **Antes (seu atual):**
```
src/
├── main.java.fundamentals.cap01.HelloWorld.java
├── main.java.zothers.exercises.Main.java
└── legacy.fundamentals/exercises/
    ├── PrimitiveTypes.java
    ├── ArrayBasic.java
    └── Constants.java
```

### **Depois (nova estrutura):**
```
src/main/java/
├── legacy.fundamentals/
│   └── cap01/              # Capítulo 01: Sintaxe Java
│       ├── PrimitiveTypes.java     # ✅ Migrar
│       ├── Constants.java          # ✅ Migrar
│       ├── ArrayBasic.java         # ✅ Migrar
│       ├── Loops.java              # 🆕 Criar
│       └── Functions.java          # 🆕 Criar
└── utils/
    └── Functions.java      # Utilitários globais
```

---

## 🚀 **Próximos Passos:**

1. **Reorganize pastas** seguindo estrutura acima
2. **Migre seus 3 arquivos** para `cap01/`
3. **Crie arquivo de progresso** inicial
4. **Commit inicial** da nova estrutura

---

## 💡 **Dica IntelliJ:**

Para criar a estrutura rapidamente:
1. Clique direito em `src/main/java/`
2. `New > Package` → Digite `legacy.fundamentals.cap01`
3. Arraste seus arquivos atuais para lá
4. Refatore imports se necessário (Alt+Enter)

---

**Quer que eu crie o `.gitignore` e o template de capítulo agora?** 🎯