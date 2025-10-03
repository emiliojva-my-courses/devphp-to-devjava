# 🐉 DO LARAVEL AO SPRING BOOT
## *Uma Jornada Pragmática de Transição de Ecossistemas*

---

## 📖 **SOBRE ESTA WIKI**

Esta não é apenas uma documentação técnica. É um **diário estruturado de aprendizado** que combina:
- **Pragmatismo:** Foco no que você vai usar no projeto real
- **Neurociência:** Técnicas comprovadas de retenção de conhecimento
- **Filosofia:** Estoicismo aplicado ao aprendizado técnico
- **Método Socrático:** Perguntas que constroem compreensão profunda

---

## 🗺️ **NAVEGAÇÃO RÁPIDA**

| Seção | Conteúdo | Status |
|-------|----------|--------|
| [📜 Prefácio](#-prefácio) | Por que este livro existe | ✅ |
| [🧭 Como Usar](#-como-usar-esta-wiki) | Metodologias de estudo | ✅ |
| [🗺️ Roadmap](#️-roadmap-da-jornada) | Visão geral das fases | ✅ |
| [📚 Capítulos](#-índice-de-capítulos) | Conteúdo técnico | 🚧 |
| [📊 Progresso](#-acompanhamento) | Seu checkpoint atual | 🚧 |
| [🔗 Recursos](#-recursos-externos) | Links e referências | ✅ |

---

## 📜 **PREFÁCIO**

### **O Dilema do Dev PHP em Terra Java**

Você domina Laravel. Conhece Eloquent como a palma da mão. Já construiu APIs REST, implementou autenticação, otimizou queries N+1. **Você é produtivo.**

Então te passam um projeto Java/Spring Boot legado. E de repente:
- Onde está meu `composer require`? (Maven? Gradle?)
- Por que preciso compilar? (PHP é interpretado!)
- O que é JDK vs JRE vs JVM? (No PHP eu só instalo e roda!)
- Onde ficam meus arrays associativos? (HashMap? Que isso?)

**Este livro existe para traduzir seu conhecimento Laravel para o ecossistema Java.**

### **Por Que Esta Abordagem é Diferente?**

#### ❌ **O que este livro NÃO é:**
- Tutorial genérico "Java para iniciantes"
- Documentação técnica seca
- Curso vendido com promessas mirabolantes
- Comparação depreciativa ("X é melhor que Y")

#### ✅ **O que este livro É:**
- **Ponte cognitiva:** Laravel → Spring Boot com analogias precisas
- **Pragmático:** Foco no que você vai usar NO PROJETO REAL
- **Científico:** Metodologias de neurociência aplicadas
- **Honesto:** "Isto é confuso mesmo, vamos dissecar junto"

### **Contexto Real: Seu Projeto**

Este livro foi escrito para **seu cenário específico:**
- ✅ Desenvolvedor Laravel experiente
- ✅ Projeto legado Spring Boot com queries plain (JDBC)
- ✅ PostgreSQL (não MySQL/Oracle genéricos)
- ✅ Arquitetura MVC simplória (sem microservices complexos)
- ✅ Prazo real: contribuir em ~6 semanas

**Não vamos perder tempo com teoria que você não vai usar esta sprint.**

---

## 🧭 **COMO USAR ESTA WIKI**

### **🧠 Metodologias Aplicadas**

#### 1️⃣ **Estoicismo Técnico**
> *"Controle o que está em seu poder: código e prática. Não controla: velocidade de aprendizado ou comparações."*

**Na prática:**
- ✅ Foque em **entender**, não em "ser rápido"
- ✅ Erros são **dados para análise**, não fracassos
- ✅ Compare-se **com você de ontem**, não com sêniores de 10 anos

#### 2️⃣ **KISS (Keep It Simple, Stupid)**
> *"Um conceito por sessão. Código mínimo viável. Sem over-engineering."*

**Na prática:**
- ✅ Sessões de 25min (Pomodoro)
- ✅ 1 conceito = 1 exemplo mínimo funcional
- ✅ Se não usa no projeto esta semana, **não estude ainda**

#### 3️⃣ **Neurociência do Aprendizado**
> *"Seu cérebro precisa de repetição espaçada, não de maratona."*

**Na prática:**
- ✅ **Spaced Repetition:** Revise em D+1, D+3, D+7
- ✅ **Interleaving:** Alterne teoria → prática → comparação
- ✅ **Retrieval Practice:** Explique ANTES de consultar
- ✅ **Sleep:** 7h+ de sono (consolidação de memória)

#### 4️⃣ **Método Socrático**
> *"Perguntas que te fazem pensar, não respostas prontas."*

**Na prática:**
- ✅ Cada capítulo começa com **perguntas que VOCÊ responde**
- ✅ Código vem **depois** da sua tentativa
- ✅ Compare sua resposta com a solução (metacognição)

#### 5️⃣ **Técnica Feynman**
> *"Se não consegue explicar simples, não entendeu ainda."*

**Na prática:**
- ✅ Explique em voz alta (rubber duck)
- ✅ Escreva exemplo de memória (sem copiar)
- ✅ Ensine para alguém (júnior, colega, pet)

---

### **⏱️ Ciclo de Estudo Ideal (2h/dia)**

```
┌─────────────────────────────────────────────┐
│  SESSÃO 1: TEORIA (25min)                  │
├─────────────────────────────────────────────┤
│  • Leia 1 conceito do capítulo              │
│  • Responda perguntas socráticas (sem cola) │
│  • Compare com Laravel (anote diferenças)   │
└─────────────────────────────────────────────┘
                    ↓ (5min pausa)
┌─────────────────────────────────────────────┐
│  SESSÃO 2: PRÁTICA (25min)                 │
├─────────────────────────────────────────────┤
│  • Implemente o código do conceito          │
│  • Execute e observe erros (debugging)      │
│  • Refatore até funcionar                   │
└─────────────────────────────────────────────┘
                    ↓ (5min pausa)
┌─────────────────────────────────────────────┐
│  SESSÃO 3: RETRIEVAL (25min)               │
├─────────────────────────────────────────────┤
│  • Explique em voz alta o que aprendeu      │
│  • Reescreva exemplo de memória (sem copiar)│
│  • Teste com variação do exercício          │
└─────────────────────────────────────────────┘
                    ↓ (5min pausa)
┌─────────────────────────────────────────────┐
│  SESSÃO 4: CONSOLIDAÇÃO (25min)            │
├─────────────────────────────────────────────┤
│  • Anotação no learning-log.md              │
│  • Crie 1 pergunta para revisar amanhã     │
│  • Defina próximo checkpoint                │
└─────────────────────────────────────────────┘
```

**💡 Dica:** Use [Pomofocus.io](https://pomofocus.io) ou app similar para timer.

---

### **📊 Sistema de Checkpoints Estoicos**

#### **Autoavaliação Semanal (Sextas-feiras):**
```
┌─────────────────────────────────────────────┐
│  ✅ CHECKPOINT: Semana X                    │
├─────────────────────────────────────────────┤
│  [ ] Consigo explicar para júnior?          │
│  [ ] Reproduzi código de memória?           │
│  [ ] Entendo o POR QUÊ (não só COMO)?       │
│  [ ] Consigo adaptar para outra situação?   │
│  [ ] Anotei dúvidas específicas?            │
├─────────────────────────────────────────────┤
│  🎯 Meta da próxima semana: ___________     │
│  📝 Dúvida para perguntar ao time: ______   │
└─────────────────────────────────────────────┘
```

#### **Revisão Espaçada (Spaced Repetition):**
- **D+1:** Refaça exercício principal
- **D+3:** Explique conceito em voz alta
- **D+7:** Revise anotações e corrija erros

---

## 🗺️ **ROADMAP DA JORNADA**

### **Visão Geral: 3 Fases x 8 Semanas**

```
┌─────────────────────────────────────────────────────────┐
│  FASE 1: FUNDAMENTOS JDBC (Semanas 1-2)                 │
│  🎯 Meta: CRUD funcional com queries raw                │
├─────────────────────────────────────────────────────────┤
│  ✓ Sintaxe Java vs PHP                                  │
│  ✓ JDBC puro + PostgreSQL                               │
│  ✓ PreparedStatement (SQL Injection)                    │
│  ✓ Transações (commit/rollback)                         │
│  ✓ Padrão DAO (seu "Repository")                        │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│  FASE 2: SPRING BOOT ESSENCIAL (Semanas 3-5)           │
│  🎯 Meta: API REST end-to-end funcional                 │
├─────────────────────────────────────────────────────────┤
│  ✓ @RestController (rotas)                              │
│  ✓ @Service + DI (Service Container)                    │
│  ✓ Bean Validation (Form Requests)                      │
│  ✓ Exception Handling global                            │
│  ✓ DTOs (API Resources)                                 │
└─────────────────────────────────────────────────────────┘
                          ↓
┌─────────────────────────────────────────────────────────┐
│  FASE 3: PROJETO LEGADO (Semanas 6-8)                  │
│  🎯 Meta: Primeiro PR aceito no projeto                 │
├─────────────────────────────────────────────────────────┤
│  ✓ Análise da arquitetura existente                     │
│  ✓ Padrões e convenções do time                         │
│  ✓ Refatoração de 1 endpoint (com testes)              │
│  ✓ Code review + feedback do time                       │
│  ✓ Documentação do que aprendeu                         │
└─────────────────────────────────────────────────────────┘
```

---

## 📚 **ÍNDICE DE CAPÍTULOS**

### **📘 PARTE I: FUNDAMENTOS JDBC**
*"Domine o SQL antes do ORM" (como você fez com Laravel)*

| # | Capítulo | Analogia Laravel | Status |
|---|----------|------------------|--------|
| 00 | [Ambiente: JDK + Maven](./fundamentals/00-environment-setup.md) | `composer install` + PHP | ✅ |
| 01 | [Sintaxe Java Básica](./fundamentals/01-java-syntax.md) | Tipos, loops, funções PHP | ✅ |
| 02 | [JDBC: Conexão PostgreSQL](./fundamentals/02-jdbc-basics.md) | `DB::connection()` | 🚧 |
| 03 | [CRUD com PreparedStatement](./fundamentals/03-jdbc-crud.md) | `DB::table()->insert()` | 🚧 |
| 04 | [Padrão DAO](./fundamentals/04-dao-pattern.md) | Repository Pattern | 🚧 |

### **📗 PARTE II: SPRING BOOT ESSENCIAL**
*"Framework sem magia - compreenda cada anotação"*

| # | Capítulo | Analogia Laravel | Status |
|---|----------|------------------|--------|
| 05 | [Controllers REST](./spring/05-controllers.md) | `Route::resource()` | 🚧 |
| 06 | [Services + DI](./spring/06-services-di.md) | Service Container | 🚧 |
| 07 | [Bean Validation](./spring/07-validation.md) | Form Requests | 🚧 |
| 08 | [Exception Handling](./spring/08-exceptions.md) | `Handler.php` | 🚧 |
| 09 | [DTOs: Request/Response](./spring/09-dtos.md) | API Resources | 🚧 |

### **📕 PARTE III: ARQUITETURA DO LEGADO**
*"Organize o código que você vai manter"*

| # | Capítulo | Objetivo | Status |
|---|----------|----------|--------|
| 10 | [Análise de Arquitetura](./architecture/10-analysis.md) | Mapear camadas MVC | 🚧 |
| 11 | [Padrões do Time](./architecture/11-conventions.md) | Code style + estrutura | 🚧 |
| 12 | [Primeiro PR](./architecture/12-first-pr.md) | Contribuir com segurança | 🚧 |

---

## 🎯 **EXERCÍCIOS PROGRESSIVOS**

### **🥉 NÍVEL BRONZE: JDBC Puro (Semanas 1-2)**
```java
// ✅ Exercício 1: Hello PostgreSQL
// Conecte e liste todas as tabelas do schema public

// ✅ Exercício 2: Primeiro SELECT
// Busque 10 registros de 1 tabela e imprima no console

// ✅ Exercício 3: INSERT Seguro
// Adicione 1 registro usando PreparedStatement

// ✅ Exercício 4: UPDATE Condicional
// Atualize campo WHERE id = X

// ✅ Exercício 5: Transação Atômica
// INSERT + UPDATE em transação (commit/rollback)
```

### **🥈 NÍVEL PRATA: Spring Boot (Semanas 3-5)**
```java
// ✅ Exercício 6: GET /users
// Endpoint que retorna JSON de lista de usuários

// ✅ Exercício 7: POST /users
// Crie usuário com validação de email

// ✅ Exercício 8: PUT /users/{id}
// Atualize 1 campo com validação

// ✅ Exercício 9: DELETE Lógico
// Soft delete (campo deleted_at como Laravel)

// ✅ Exercício 10: Exception Customizada
// Trate "User not found" com HTTP 404
```

### **🥇 NÍVEL OURO: Projeto Real (Semanas 6-8)**
```java
// ✅ Exercício 11: Clone Endpoint do Legado
// Reproduza 1 endpoint existente do zero

// ✅ Exercício 12: Validação BR
// Valide CPF, CEP, telefone brasileiro

// ✅ Exercício 13: Paginação
// Implemente LIMIT/OFFSET vs Laravel paginate()

// ✅ Exercício 14: DTO com Esconder Campos
// Crie DTO que oculta senha (makeHidden Laravel)

// ✅ Exercício 15: Documentação
// Documente 1 fluxo completo (Controller → DAO → DB)
```

---

## 📊 **ACOMPANHAMENTO**

### **Arquivos de Progresso:**
```
_docs/progress/
├── learning-log.md          # Diário de bordo diário
├── spaced-repetition.md     # Agenda de revisões
├── socratic-answers.md      # Suas respostas às perguntas
└── weekly-checkpoints.md    # Autoavaliação semanal
```

### **Template: learning-log.md**
```markdown
## Data: YYYY-MM-DD

### ⏱️ Sessões Hoje:
- [ ] Pomodoro 1: _____________________
- [ ] Pomodoro 2: _____________________

### 💡 Aprendi:
-

### ❓ Dúvidas:
-

### 🔗 Relação com Laravel:
-

### 🎯 Amanhã:
-
```

---

## 🔗 **RECURSOS EXTERNOS**

### **📚 Documentação Oficial:**
- [Java SE Docs](https://docs.oracle.com/en/java/javase/)
- [Spring Boot Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/documentation/)

### **🎥 Canais Recomendados:**
- [Amigoscode](https://www.youtube.com/@amigoscode) - Spring Boot prático
- [Java Brains](https://www.youtube.com/@Java.Brains) - Conceitos detalhados

### **📖 Livros (Opcional):**
- *Effective Java* (Joshua Bloch) - Boas práticas
- *Spring Boot in Action* - Guia prático

---

## 🔥 **REGRAS DE OURO**

1. **🧘 Estoico:** Não compare sua velocidade com outros devs
2. **💡 KISS:** Se não usa no projeto esta semana, não estude ainda
3. **🧠 Neurociência:** Durma 7h+ (consolidação de memória)
4. **🗣️ Socrático:** Sempre pergunte "por quê?" antes de copiar código
5. **📝 Feynman:** Se não consegue explicar simples, não entendeu

---

## 🚀 **COMECE AGORA**

### **Próximos 3 Passos:**
1. [ ] Configure JDK + Maven → [Cap. 00](./fundamentals/00-environment-setup.md)
2. [ ] Converta 3 funções PHP para Java → [Cap. 01](./fundamentals/01-java-syntax.md)
3. [ ] Conecte PostgreSQL via JDBC → [Cap. 02](./fundamentals/02-jdbc-basics.md)

### **Pergunta Socrática Inicial:**
> *"Qual a MENOR coisa que você pode fazer HOJE para estar 1% mais próximo de contribuir no projeto legado?"*

**Responda em:** `_docs/progress/socratic-answers.md`

---

🥋 **"A jornada de mil linhas de código começa com um `public static void main`"** 🐉

**Última atualização:** 2025-10-01  
**Progresso:** FASE 1 - Capítulo 01/12