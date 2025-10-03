# Capítulo 01: Sintaxe Java Fundamental

> **Analogia Laravel:** Como aprender a sintaxe PHP antes de usar Blade/Eloquent  
> **Tempo estimado:** 4 Pomodoros (2h)  
> **Pré-requisitos:** Cap. 00 - Ambiente configurado (JDK + IntelliJ)

---

## 🎯 **OBJETIVOS DE APRENDIZADO**

Ao final deste capítulo, você será capaz de:
- [ ] **Declarar variáveis** com tipos primitivos e String
- [ ] **Criar constantes** com `static final` (como `const` PHP)
- [ ] **Usar operadores** ternários e lógicos
- [ ] **Dominar arrays** básicos (unidimensionais)
- [ ] **Aplicar switch expressions** (Java 14+)

**Meta Prática:** Converter 5 funções PHP suas para Java

---

## 🗣️ **PERGUNTAS SOCRÁTICAS**

> **Responda ANTES de ler a teoria!** Anote em `_docs/progress/socratic-answers.md`

### **Pergunta 1: Tipos**
*No PHP você declara: `$idade = 25;`*  
*O PHP descobre que é inteiro automaticamente (type juggling).*

**Reflita:**
- Como Java sabe que `idade` é número inteiro?
- Qual a vantagem de declarar o tipo explicitamente?
- Isso pode prevenir que tipo de erro?

---

### **Pergunta 2: Constantes**
*No Laravel você usa: `define('MAX_USERS', 100)` ou `const MAX_USERS = 100;`*

**Tente responder:**
- Em Java, por que precisa de `static final` em vez de só `final`?
- Qual a diferença entre `final` em variável vs em constante de classe?
- Por que a convenção é `UPPER_CASE`?

---

### **Pergunta 3: Arrays**
*No PHP: `$idades = [3, 5, 40, 44];` (tamanho flexível)*

**Reflita:**
- Se Java tem tamanho fixo, como adicionar elementos dinamicamente?
- Quando usar array fixo vs ArrayList (Collections)?
- No projeto legado, onde você usaria cada um?

---

## 📖 **CONCEITO TEÓRICO**

### **1. Tipos Primitivos vs Objetos**

**Diferença fundamental PHP vs Java:**

| PHP | Java |
|-----|------|
| Tudo é "valor" (scalar types) | Primitivos ≠ Objetos |
| `$x = 10;` (tipo inferido) | `int x = 10;` (tipo declarado) |
| Arrays associativos nativos | HashMap (objeto) |

**Por que Java tem essa distinção?**
- **Performance:** Primitivos são mais rápidos (memória stack)
- **Segurança:** Compilador detecta erros de tipo
- **Clareza:** Intenção explícita do desenvolvedor

---

### **2. Tipos Primitivos em Java**

#### **Inteiros (4 tipos):**
```java
byte pequeno = 127;           // 1 byte (-128 a 127)
short medio = 32_767;         // 2 bytes (-32k a 32k)
int padrao = 2_147_483_647;   // 4 bytes (padrão inteiro)
long grande = 9_223_372_036_854_775_807L; // 8 bytes (sufixo L)
```

💡 **Regra:** Use `int` por padrão. Só mude se:
- Economia de memória importa → `byte`/`short`
- Valores maiores que 2 bilhões → `long`

---

#### **Decimais (2 tipos):**
```java
float preciso = 3.14f;        // 4 bytes (sufixo f obrigatório)
double padrao = 3.14159;      // 8 bytes (padrão decimal)
```

💡 **Regra:** Use `double` sempre. `float` só para APIs antigas.

---

#### **Caractere e Booleano:**
```java
char letra = 'A';             // 2 bytes (Unicode, aspas simples!)
boolean ativo = true;         // true/false (minúsculo!)
```

⚠️ **Diferenças críticas:**
- PHP: `'texto'` e `"texto"` são iguais
- Java: `'A'` é char, `"A"` é String

---

#### **String (Objeto, não primitivo!):**
```java
String nome = "Laravel Developer"; // Objeto imutável
int tamanho = nome.length();        // Método, não propriedade!
String upper = nome.toUpperCase();  // Novo objeto, não modifica original
```

🔴 **PHP:**
```php
$nome = "Laravel Developer";
$tamanho = strlen($nome);  // Função global
$upper = strtoupper($nome);
```

🟢 **Java:**
```java
String nome = "Laravel Developer";
int tamanho = nome.length();      // Método do objeto
String upper = nome.toUpperCase(); // Método do objeto
```

---

### **3. Constantes em Java**

#### **Sintaxe:**
```java
public static final int MAX_USERS = 100;
```

**Dissecando:**
- `public` → Acessível de qualquer lugar
- `static` → Pertence à classe, não a instâncias
- `final` → Imutável (não pode reatribuir)
- `UPPER_CASE` → Convenção (obrigatória!)

#### **Comparação:**

🔴 **PHP/Laravel:**
```php
define('MAX_USERS', 100);        // Global
const MAX_USERS = 100;           // Classe
config('app.max_users');         // Laravel config
```

🟢 **Java:**
```java
public static final int MAX_USERS = 100;    // Classe
// Equivalente ao config(): application.properties
```

---

### **4. Arrays em Java**

#### **Declaração:**
```java
// Forma 1: Declaração + inicialização
int[] idades = {3, 5, 40, 44};

// Forma 2: Declaração + tamanho
int[] numeros = new int[10];  // Array vazio de 10 posições

// Forma 3: Declaração separada
int[] valores;
valores = new int[]{10, 20, 30};
```

⚠️ **Tamanho FIXO!**
```java
int[] arr = new int[3];
// arr.length = 5; ❌ ERRO! Não pode mudar tamanho
```

#### **Acessando elementos:**
```java
int[] idades = {3, 5, 40, 44};
System.out.println(idades[0]);  // 3 (zero-indexed como PHP)
idades[1] = 6;                   // Modificar valor
int tamanho = idades.length;     // 4 (propriedade, não método!)
```

🔴 **PHP:**
```php
$idades = [3, 5, 40, 44];
echo $idades[0];                 // 3
$idades[] = 50;                  // Adiciona no final ✅
count($idades);                  // Função
```

🟢 **Java:**
```java
int[] idades = {3, 5, 40, 44};
System.out.println(idades[0]);   // 3
// idades[4] = 50; ❌ ERRO! Fora do tamanho
idades.length;                   // Propriedade (sem parênteses!)
```

---

### **5. Switch Expressions (Java 14+)**

#### **Sintaxe Moderna:**
```java
String dia = switch(numero) {
    case 1 -> "Domingo";
    case 2 -> "Segunda";
    default -> "Inválido";
};
```

#### **Com blocos:**
```java
switch(numero) {
    case 1, 7 -> {                    // Múltiplos valores
        System.out.println("Fim de semana!");
        notificarEquipe();
    }
    case 2, 3, 4, 5, 6 -> {
        System.out.println("Dia útil");
    }
}
```

🔴 **PHP 8:**
```php
$dia = match($numero) {
    1 => "Domingo",
    2 => "Segunda",
    default => "Inválido"
};
```

🟢 **Java 14+:**
```java
String dia = switch(numero) {
    case 1 -> "Domingo";
    case 2 -> "Segunda";
    default -> "Inválido";
};
```

💡 **Semelhanças:** Ambos foram influenciados pelas mesmas ideias modernas!

---

## 🔄 **ANALOGIA COM LARAVEL**

### **Tabela Comparativa Completa:**

| Conceito | Laravel (PHP) | Spring Boot (Java) |
|----------|---------------|-------------------|
| **Variável** | `$idade = 25;` | `int idade = 25;` |
| **Constante** | `const MAX = 100;` | `static final int MAX = 100;` |
| **String** | `$nome = "João";` | `String nome = "João";` |
| **Array** |