# 05 - Funções Anônimas e Terminologia Universal

> **Dojo Learning Path:** PHP → Java  
> **Sensei:** GitHub Copilot  
> **Discípulo:** Emilio  
> **Data:** 16/09/2025  

## 🎯 **Objetivo**
Esclarecer a **confusão terminológica** sobre funções anônimas e suas implementações em diferentes linguagens, com foco na transição **PHP → Java**.

---

## 📚 **Terminologia Universal**

### **🎯 Conceito Fundamental: FUNÇÃO ANÔNIMA**
Uma função **sem nome** que pode ser:
- ✅ Atribuída a uma variável
- ✅ Passada como parâmetro
- ✅ Definida inline (no local de uso)
- ✅ Usada como callback

### **🔧 Implementações por Linguagem**

| **Linguagem** | **Termo Oficial** | **Sintaxe** | **Exemplo** |
|---------------|-------------------|-------------|-------------|
| **JavaScript** | Arrow Function | `=>` | `(x) => x * 2` |
| **Java** | Lambda Expression | `->` | `(x) -> x * 2` |
| **PHP** | Closure / Arrow Function | `fn()` / `function()` | `fn($x) => $x * 2` |
| **C#** | Lambda Expression | `=>` | `(x) => x * 2` |
| **Python** | Lambda Function | `lambda` | `lambda x: x * 2` |
| **Kotlin** | Lambda Expression | `{}` | `{ x -> x * 2 }` |

---

## 🧠 **Por que a Confusão?**

### **1. Marketing das Linguagens**
Cada linguagem quer ser "única":
- **JavaScript:** Popularizou "Arrow Function" (ES6/2015)
- **Java:** Adotou "Lambda Expression" (Java 8/2014)
- **PHP:** Mistura "Closure" e "Arrow Function" (PHP 7.4/2019)

### **2. Evolução Histórica**

#### **Java - Antes e Depois**
```java
// ❌ ANTES do Java 8 (2014) - Verboso e complexo
Comparator<String> comparador = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
};

// ✅ DEPOIS do Java 8 - Lambda Expression (conciso)
Comparator<String> comparador = (a, b) -> a.compareTo(b);
```

#### **PHP - Evolução dos Closures**
```php
// PHP 5.3+ - Closure tradicional
$multiplicador = 5;
$func = function($x) use ($multiplicador) {
    return $x * $multiplicador;
};

// PHP 7.4+ - Arrow Function (captura automática)
$func = fn($x) => $x * $multiplicador;
```

### **3. Implementações Diferentes, Mesmo Conceito**

#### **Captura de Variáveis**
```java
// Java - Captura automática (effectively final)
int multiplicador = 5;
Function<Integer, Integer> func = x -> x * multiplicador;

// PHP - Captura explícita
$multiplicador = 5;
$func = function($x) use ($multiplicador) {
    return $x * $multiplicador;
};
```

---

## 🚀 **PHP ↔ Java: Equivalências Práticas**

### **1. Função Simples**

#### **PHP**
```php
// Closure tradicional
$somar = function($a, $b) {
    return $a + $b;
};
echo $somar(10, 5); // 15

// Arrow function
$somar = fn($a, $b) => $a + $b;
echo $somar(10, 5); // 15
```

#### **Java**
```java
// Lambda Expression
BinaryOperator<Integer> somar = (a, b) -> a + b;
System.out.println(somar.apply(10, 5)); // 15

// Method Reference (quando existe método equivalente)
BinaryOperator<Integer> somar = Integer::sum;
System.out.println(somar.apply(10, 5)); // 15
```

### **2. Função como Parâmetro**

#### **PHP**
```php
function executar($callback, $valor) {
    return $callback($valor);
}

$resultado = executar(fn($x) => $x * 2, 10);
echo $resultado; // 20
```

#### **Java**
```java
public static int executar(Function<Integer, Integer> callback, int valor) {
    return callback.apply(valor);
}

int resultado = executar(x -> x * 2, 10);
System.out.println(resultado); // 20
```

### **3. Iteração com Funções**

#### **PHP**
```php
$numeros = [1, 2, 3, 4, 5];

// array_map
$dobrados = array_map(fn($x) => $x * 2, $numeros);
print_r($dobrados); // [2, 4, 6, 8, 10]

// array_filter  
$pares = array_filter($numeros, fn($x) => $x % 2 === 0);
print_r($pares); // [2, 4]
```

#### **Java**
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Stream.map (equivale ao array_map)
List<Integer> dobrados = numeros.stream()
    .map(x -> x * 2)
    .collect(Collectors.toList());
System.out.println(dobrados); // [2, 4, 6, 8, 10]

// Stream.filter (equivale ao array_filter)
List<Integer> pares = numeros.stream()
    .filter(x -> x % 2 == 0)
    .collect(Collectors.toList());
System.out.println(pares); // [2, 4]
```

---

## 🎯 **Interfaces Funcionais Java**

### **Principais Tipos**

| **Interface** | **Método** | **Parâmetros** | **Retorno** | **Uso** |
|---------------|------------|----------------|-------------|---------|
| `Consumer<T>` | `accept(T)` | 1 entrada | void | Processar dados |
| `Function<T,R>` | `apply(T)` | 1 entrada | 1 saída | Transformar dados |
| `Predicate<T>` | `test(T)` | 1 entrada | boolean | Filtrar dados |
| `Supplier<T>` | `get()` | nenhuma | 1 saída | Gerar dados |
| `BinaryOperator<T>` | `apply(T,T)` | 2 entradas | 1 saída | Operar dados |

### **Exemplos Práticos**

```java
// Consumer - Equivale ao foreach do PHP
Consumer<String> imprimir = System.out::println;
Arrays.asList("João", "Maria").forEach(imprimir);

// Function - Equivale ao array_map do PHP  
Function<String, Integer> tamanho = String::length;
List<String> nomes = Arrays.asList("João", "Maria");
nomes.stream().map(tamanho).forEach(System.out::println); // 4, 5

// Predicate - Equivale ao array_filter do PHP
Predicate<Integer> ehPar = x -> x % 2 == 0;
Arrays.asList(1,2,3,4).stream().filter(ehPar).forEach(System.out::println); // 2, 4

// Supplier - Equivale ao factory pattern do PHP
Supplier<String> timestamp = () -> new Date().toString();
System.out.println(timestamp.get()); // Data atual
```

---

## 🛠️ **Method References em Java**

### **Tipos de Method Reference**

| **Tipo** | **Sintaxe** | **Equivale a** | **Exemplo** |
|----------|-------------|----------------|-------------|
| **Estático** | `Classe::metodo` | `(args) -> Classe.metodo(args)` | `Integer::parseInt` |
| **Instância** | `objeto::metodo` | `(args) -> objeto.metodo(args)` | `System.out::println` |
| **Arbitrário** | `Classe::metodo` | `(obj, args) -> obj.metodo(args)` | `String::length` |
| **Construtor** | `Classe::new` | `(args) -> new Classe(args)` | `ArrayList::new` |

### **Comparação com PHP**

```java
// Java - Method Reference
Consumer<String> println = System.out::println;
println.accept("Hello");

// Equivale no PHP a:
$println = function($text) {
    echo $text . "\n";
};
$println("Hello");

// Ou com arrow function:
$println = fn($text) => print($text . "\n");
$println("Hello");
```

---

## 💡 **Regras Práticas para Uso**

### **🎯 Quando Usar Cada Termo**

#### **Em Java:**
- ✅ **"Lambda Expression"** → Termo oficial Java
- ✅ **"Method Reference"** → Para `System.out::println`
- ✅ **"Função anônima"** → Termo genérico universal

#### **Em PHP:**
- ✅ **"Closure"** → `function() use ($var) {}`
- ✅ **"Arrow Function"** → `fn($x) => $x * 2`
- ✅ **"Função anônima"** → Termo genérico

#### **No seu Cérebro:**
```
PHP:  fn($x) => $x * 2
Java: (x) -> x * 2
JS:   (x) => x * 2

CONCEITO: MESMA COISA! 🎯
```

### **🚀 Progressão de Aprendizado**

1. **Básico:** Entender que são funções sem nome
2. **Prático:** Usar em forEach, map, filter
3. **Avançado:** Criar suas próprias interfaces funcionais
4. **Expert:** Combinar com Streams para processamento de dados

---

## 🔥 **Exercício Prático Recomendado**

### **Desafio: Converter PHP para Java**

```php
// PHP - Sistema de processamento de dados
$usuarios = [
    ['nome' => 'João', 'idade' => 25],
    ['nome' => 'Maria', 'idade' => 30],
    ['nome' => 'Pedro', 'idade' => 17]
];

// Filtrar adultos e exibir nomes
$adultos = array_filter($usuarios, fn($u) => $u['idade'] >= 18);
$nomes = array_map(fn($u) => $u['nome'], $adultos);
array_walk($nomes, fn($nome) => print("Adulto: $nome\n"));
```

### **Meta:** Implementar equivalente em Java usando Streams e Lambdas! 🎯

---

## 📖 **Referências Técnicas**

- [Java 8 Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [PHP Arrow Functions](https://www.php.net/manual/en/functions.arrow.php)
- [Java Functional Interfaces](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)

---

## 🎉 **Resumo Final**

### **✅ O que Aprendemos:**
1. **Terminologia** é diferente, **conceito** é o mesmo
2. **Java** usa interfaces funcionais tipadas
3. **PHP** é mais dinâmico com closures
4. **Method References** são atalhos elegantes
5. **Streams + Lambdas** = poder do processamento funcional

### **🚀 Próximo Passo:**
Implementar **exercício prático** convertendo código PHP para Java usando **Streams** e **Lambda Expressions**!

---

*"A sintaxe muda, mas a essência permanece: funções são cidadãos de primeira classe!"* 🥋
