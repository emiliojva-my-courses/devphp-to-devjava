# 🐉 **LIVRO: TRANSIÇÃO PHP/LARAVEL → JAVA/SPRING BOOT**

**Guia estruturado** em 4 pilares fundamentais para dominar o ecossistema Java.

> **Se você domina Laravel, este livro vai te ajudar a aprender Java traçando analogias diretas com o que você já conhece. Cada seção destaca o conceito equivalente no Laravel, para mapear rapidamente seu conhecimento.**

---

## 🏛️ **OS 4 PILARES DO APRENDIZADO**

### 🏗️ **PILAR I: FUNDAMENTALS (Java SE) - 70% CONCLUÍDO**

Fundamentos sólidos da linguagem Java, similar ao domínio de PHP antes de Laravel.

#### 📚 **Capítulos Disponíveis:**
- [📖 **00: Configuração do Ambiente**](./fundamentals/00-environment-setup.md) ✅
- [📖 **01: Ecossistema Java**](./fundamentals/01-java-ecosystem.md) ✅
- [📖 **02: Ferramentas e Infraestrutura**](./fundamentals/02-tools-infrastructure.md) ✅
- [📖 **03: Camada de Dados**](./fundamentals/03-data-layer.md) ✅
- [📖 **04: Fundamentos Java SE**](./fundamentals/04-java-fundamentals.md) ✅ **70% dominado**
- [📖 **05: Arquitetura e Padrões**](./fundamentals/05-architecture.md) ✅
- [📖 **07: Desafios e Recursos**](./fundamentals/07-challenge-resources.md) ✅

#### 🎯 **Progresso Atual:**
- ✅ Tipos primitivos e variáveis
- ✅ Estruturas condicionais (if/else/switch)
- ✅ Constantes e switch expressions (Java 14+)
- ✅ Estruturas de repetição (for/while/enhanced for)
- 🚧 **Próximo:** Arrays básicos e manipulação

### ⚔️ **PILAR II: ORIENTAÇÃO A OBJETOS - PLANEJADO**

POO aplicada com comparações diretas entre Java e PHP/Laravel.

#### 📚 **Capítulos Planejados:**
- [📖 **Classes e Objetos**](02-Object-Oriented-Programming/) *Em desenvolvimento*
- [📖 **Herança vs Traits PHP**](02-Object-Oriented-Programming/) *Em desenvolvimento*
- [📖 **Interfaces vs Contracts**](02-Object-Oriented-Programming/) *Em desenvolvimento*
- [📖 **Polimorfismo Prático**](02-Object-Oriented-Programming/) *Em desenvolvimento*
- [📖 **Encapsulamento e Boas Práticas**](02-Object-Oriented-Programming/) *Em desenvolvimento*

### 🗄️ **PILAR III: COLLECTIONS & ESTRUTURAS - PLANEJADO**

Estruturas de dados Java equivalentes aos arrays PHP e Collections Laravel.

#### 📚 **Capítulos Planejados:**
- [📖 **ArrayList vs Arrays PHP**] *Em desenvolvimento*
- [📖 **HashMap vs Arrays Associativos**] *Em desenvolvimento*
- [📖 **Sets e Unique Collections**] *Em desenvolvimento*
- [📖 **Streams vs Collection Methods**] *Em desenvolvimento*

### 🌱 **PILAR IV: SPRING BOOT FRAMEWORK - INICIADO**

Framework completo com analogias diretas ao Laravel.

#### 📚 **Capítulos Disponíveis:**
- [📖 **06: Spring Boot Essencial**](03-SpringBoot/06-spring-boot-basics.md) ✅

#### � **Capítulos Planejados:**
- [📖 **Controllers vs Laravel Controllers**] *Em desenvolvimento*
- [📖 **Services vs Laravel Services**] *Em desenvolvimento*
- [📖 **JPA/Hibernate vs Eloquent**] *Em desenvolvimento*
- [📖 **REST APIs vs Laravel API Resources**] *Em desenvolvimento*

---

---

## 🎯 **COMO USAR ESTE LIVRO**

### 📖 **Ordem de Leitura Recomendada:**

1. **🏗️ PILAR I - FUNDAMENTALS (Prioridade máxima)**
   - Comece pelo Capítulo 00 (ambiente)
   - Siga sequencialmente até o 07
   - **Execute todos os códigos** em `src/`

2. **⚔️ PILAR II - OOP (Após 80% do Pilar I)**
   - Base sólida necessária
   - Comparações diretas com PHP

3. **🗄️ PILAR III - COLLECTIONS (Após Pilar II)**
   - Estruturas de dados avançadas
   - Equivalências com arrays PHP

4. **🌱 PILAR IV - SPRING BOOT (Final)**
   - Framework completo
   - Analogias com Laravel

### 💡 **Metodologia de Estudo:**

- **Leia + Pratique:** Teoria seguida de código imediato
- **Compare sempre:** PHP/Laravel vs Java/Spring Boot
- **Anote diferenças:** Use `_docs/prompts/learning-progress.md`
- **Revise constantemente:** Consolidação é fundamental

### 🎯 **Checklist de Pré-requisitos:**

- [x] JDK ≠ JRE ≠ JVM (como engine PHP vs extensões vs ferramentas de dev)
- [x] Maven/Gradle gerenciam dependências (como Composer)
- [x] Tomcat é o servidor web embedado (como PHP-FPM ou built-in server)
- [ ] JPA é spec, Hibernate é implementation (como contrato Eloquent vs classe)
- [ ] Entity ≠ DTO (banco ≠ API resource)
- [ ] Java SE é suficiente para Spring Boot (como PHP core é suficiente para Laravel)

---

## 🏮 **FILOSOFIA DO APRENDIZADO**

### 🧠 **"Sensei-Discípulo" Approach:**

**Não decore - compreenda:**
- JDK é seu kit de ferramentas (como suas ferramentas de dev PHP)
- Maven é seu gestor de pacotes (como Composer)
- Tomcat é seu servidor (como PHP-FPM)
- JPA é sua interface de banco (como Eloquent)
- Spring é o framework que une tudo (como Laravel)

### � **Learning by Doing:**

1. **Conceito teórico** → Leitura nos capítulos
2. **Código prático** → Implementação em `src/`
3. **Contextualização** → Comparação com Laravel/PHP
4. **Exercícios** → Desafios progressivos em `concepts/`
5. **Documentação** → Registro do progresso

---

## 📊 **ACOMPANHAMENTO DO PROGRESSO**

### 📝 **Arquivos de Monitoramento:**
- [`_docs/prompts/learning-progress.md`](../prompts/learning-progress.md) → Status detalhado
- [`_docs/prompts/conversation-summary.md`](../prompts/conversation-summary.md) → Resumo da jornada
- [`_docs/prompts/next-exercises.md`](../prompts/next-exercises.md) → Próximos exercícios

### 🎯 **Meta Final:**
**Primeira API REST Spring Boot funcional em 2 semanas**

---

🥋 **BOM ESTUDO, DISCÍPULO!** O caminho do dragão Java te aguarda! 🐉

---

## 📂 **ESTRUTURA COMPLETA DO PROJETO**

```
devphp-to-devjava/
├── README.md                           # Este arquivo (índice)
├── README-EN-US.md                     # Versão em inglês
├── _docs/
│   ├── book/                          # Livro estruturado
│   │   ├── 00-environment-setup.md
│   │   ├── 01-java-ecosystem.md
│   │   ├── 02-tools-infrastructure.md
│   │   ├── 03-data-layer.md
│   │   ├── 04-architecture.md
│   │   ├── 05-java-fundamentals.md
│   │   ├── 06-spring-boot-basics.md
│   │   └── 07-challenge-resources.md
│   ├── HowToRunJavaOnWindows11WSL2.md
│   └── JavaLearningDojo.md
└── src/                               # Código de exemplo
    ├── HelloWorld.java
    ├── Main.java
    └── fundamentals.exercises.PrimitiveTypes.java
```
