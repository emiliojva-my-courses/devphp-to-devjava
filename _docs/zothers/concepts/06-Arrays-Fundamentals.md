# Arrays em Java - Conceitos Fundamentais

## 📋 **Visão Geral**
Arrays são estruturas de dados que armazenam múltiplos valores do mesmo tipo em posições de memória contíguas. São fundamentais para processamento de coleções de dados.

## 🔤 **Sintaxe e Declaração**

### Formas de Declaração
```java
// Declaração simples
int[] numeros;
String[] nomes;
double valores[];  // Sintaxe alternativa (menos comum)

// Declaração com inicialização de tamanho
int[] numeros = new int[10];
String[] nomes = new String[5];

// Declaração com valores iniciais
int[] numeros = {1, 2, 3, 4, 5};
String[] nomes = {"João", "Maria", "Pedro"};
int[] valores = new int[]{10, 20, 30};
```

## 🔧 **Operações Fundamentais**

### Acesso e Modificação
```java
int[] array = {10, 20, 30, 40, 50};

// Acesso por índice (base 0)
int primeiro = array[0];      // 10
int ultimo = array[array.length - 1];  // 50

// Modificação
array[0] = 100;  // Altera primeiro elemento
array[2] = 300;  // Altera terceiro elemento
```

### Percorrimento
```java
// Loop tradicional
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}

// Enhanced for loop (recomendado para leitura)
for (int elemento : array) {
    System.out.println(elemento);
}

// While loop
int i = 0;
while (i < array.length) {
    System.out.println(array[i]);
    i++;
}
```

## 📊 **Arrays Multidimensionais**

### Arrays 2D (Matrizes)
```java
// Declaração de matriz
int[][] matriz = new int[3][4];  // 3 linhas, 4 colunas

// Inicialização com valores
int[][] matriz = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// Acesso aos elementos
int elemento = matriz[1][2];  // Linha 1, Coluna 2 = 7

// Percorrimento
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

## 🛠️ **Métodos Úteis da Classe Arrays**

```java
import java.util.Arrays;

int[] numeros = {64, 34, 25, 12, 22, 11, 90};

// Conversão para String
String repr = Arrays.toString(numeros);

// Ordenação
Arrays.sort(numeros);

// Busca binária (array deve estar ordenado)
int indice = Arrays.binarySearch(numeros, 25);

// Preenchimento
Arrays.fill(numeros, 0);  // Preenche com 0

// Comparação
boolean iguais = Arrays.equals(array1, array2);

// Cópia
int[] copia = Arrays.copyOf(numeros, numeros.length);
int[] subArray = Arrays.copyOfRange(numeros, 2, 5);
```

## ⚡ **Comparação: PHP vs Java**

| Aspecto | PHP | Java |
|---------|-----|------|
| **Declaração** | `$array = []` | `int[] array = new int[size]` |
| **Tipos mistos** | ✅ Permitido | ❌ Não permitido |
| **Tamanho dinâmico** | ✅ Flexível | ❌ Fixo após criação |
| **Índices associativos** | ✅ `$array['key']` | ❌ Apenas numéricos |
| **Funções built-in** | `array_map()`, `array_filter()` | `Arrays.sort()`, `Arrays.fill()` |
| **Performance** | 🟡 Boa | 🟢 Excelente |

## 🎯 **Boas Práticas**

### 1. **Verificação de Limites**
```java
if (indice >= 0 && indice < array.length) {
    // Acesso seguro
    int valor = array[indice];
}
```

### 2. **Uso do Enhanced For**
```java
// ✅ Recomendado para leitura
for (String nome : nomes) {
    System.out.println(nome);
}

// ❌ Evitar quando só precisar ler
for (int i = 0; i < nomes.length; i++) {
    System.out.println(nomes[i]);
}
```

### 3. **Inicialização Segura**
```java
// ✅ Inicialização explícita
String[] nomes = new String[5];
Arrays.fill(nomes, "");  // Evita nulls

// ✅ Com valores conhecidos
String[] cores = {"azul", "verde", "vermelho"};
```

## 🚫 **Limitações e Cuidados**

### Tamanho Fixo
```java
int[] array = new int[5];  // Tamanho fixo!
// Não é possível redimensionar

// Solução: Usar ArrayList para tamanho dinâmico
ArrayList<Integer> lista = new ArrayList<>();
```

### Tipos Homogêneos
```java
// ❌ Não permitido
Object[] misturado = {1, "texto", 3.14};  // Problemático

// ✅ Usar tipos específicos
int[] numeros = {1, 2, 3};
String[] textos = {"a", "b", "c"};
```

### NullPointerException
```java
String[] nomes = new String[3];  // Elementos são null
int tamanho = nomes[0].length();  // ❌ NullPointerException!

// ✅ Verificação
if (nomes[0] != null) {
    int tamanho = nomes[0].length();
}
```

## 🎓 **Aplicações Práticas**

### 1. **Processamento de Dados**
```java
double[] vendas = {1500.0, 2300.0, 1800.0, 2100.0};
double total = 0;
for (double venda : vendas) {
    total += venda;
}
double media = total / vendas.length;
```

### 2. **Matrizes para Jogos**
```java
char[][] tabuleiro = new char[8][8];  // Tabuleiro de xadrez
// Inicialização e lógica do jogo
```

### 3. **Dados Estruturados**
```java
String[][] planilha = {
    {"Nome", "Idade", "Salário"},
    {"João", "25", "3000"},
    {"Maria", "30", "4500"}
};
```

## 🔄 **Próximo Passo**
Com arrays dominados, o próximo conceito natural são **Métodos e Funções**, que nos permitirão modularizar operações sobre arrays e criar código mais organizado e reutilizável.