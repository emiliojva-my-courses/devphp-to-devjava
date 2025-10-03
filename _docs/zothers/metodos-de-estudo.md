# 🎯 METODOLOGIA DE ESTUDO - FLUXO OPERACIONAL

## 📅 **CICLO DIÁRIO (2h/dia em 4 Pomodoros)**

```
┌─────────────────────────────────────────────────────────────┐
│                    DIA DE ESTUDO                            │
│                                                             │
│  🕐 MANHÃ ou 🌙 NOITE? Escolha seu melhor horário          │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│  POMODORO 1: LEITURA ATIVA (25min)                         │
├─────────────────────────────────────────────────────────────┤
│  1. Abra o capítulo no navegador/editor                    │
│  2. Leia seção "Perguntas Socráticas"                      │
│  3. PARE e responda em _docs/progress/socratic-answers.md  │
│  4. Continue lendo "Conceito Teórico"                      │
│  5. Anote dúvidas em tempo real                            │
│                                                             │
│  ✅ Checkpoint:                                             │
│  [ ] Li toda a teoria                                       │
│  [ ] Anotei 1-3 dúvidas específicas                        │
│  [ ] Entendi a analogia Laravel                            │
└─────────────────────────────────────────────────────────────┘
                            ↓
                    ☕ PAUSA 5min
                            ↓
┌─────────────────────────────────────────────────────────────┐
│  POMODORO 2: PRÁTICA GUIADA (25min)                        │
├─────────────────────────────────────────────────────────────┤
│  1. Abra IntelliJ IDEA                                      │
│  2. Crie arquivo em src/main/java/legacy.fundamentals/capXX/      │
│  3. Digite (NÃO copie!) o código do "Exercício Guiado"    │
│  4. Execute e observe erros                                 │
│  5. Corrija até funcionar                                   │
│                                                             │
│  ✅ Checkpoint:                                             │
│  [ ] Código compila sem erros                              │
│  [ ] Entendo cada linha (não decorei)                      │
│  [ ] Testei com valores diferentes                         │
└─────────────────────────────────────────────────────────────┘
                            ↓
                    ☕ PAUSA 5min
                            ↓
┌─────────────────────────────────────────────────────────────┐
│  POMODORO 3: EXERCÍCIOS PROGRESSIVOS (25min)               │
├─────────────────────────────────────────────────────────────┤
│  1. Faça Exercício 🥉 Bronze (básico)                      │
│  2. Se acertar rápido, faça 🥈 Prata                       │
│  3. Se errar, revise teoria e refaça                       │
│  4. Anote erros em learning-log.md                         │
│                                                             │
│  ✅ Checkpoint:                                             │
│  [ ] Bronze funcionando 100%                               │
│  [ ] Entendo POR QUÊ funciona (não só como)               │
│  [ ] Consegui explicar em voz alta                         │
└─────────────────────────────────────────────────────────────┘
                            ↓
                    ☕ PAUSA 5min
                            ↓
┌─────────────────────────────────────────────────────────────┐
│  POMODORO 4: CONSOLIDAÇÃO (25min)                          │
├─────────────────────────────────────────────────────────────┤
│  1. Atualize _docs/progress/learning-log.md                │
│  2. Compare sua resposta socrática com a teoria            │
│  3. Crie 1 pergunta para revisar D+1                       │
│  4. Agende revisão em spaced-repetition.md                 │
│  5. Commit no Git com mensagem clara                       │
│                                                             │
│  ✅ Checkpoint Final:                                       │
│  [ ] Todos os exercícios Bronze/Prata feitos              │
│  [ ] Git commit realizado                                  │
│  [ ] Revisão D+1 agendada                                  │
│  [ ] Pronto para próximo capítulo                          │
└─────────────────────────────────────────────────────────────┘
```

---

## 📖 **COMO SEGUIR CADA CAPÍTULO**

### **Estrutura de um Capítulo:**

```
Capítulo XX: Título
├── 🎯 Objetivos                    # Leia primeiro (sabe onde vai chegar)
├── 🗣️ Perguntas Socráticas        # RESPONDA antes da teoria!
├── 📖 Conceito Teórico             # Leia com atenção (faça anotações)
├── 🔄 Analogia Laravel             # Compare com o que você já sabe
├── 💻 Código Prático               # Digite (não copie!) e execute
├── ✅ Exercícios Progressivos      # Bronze obrigatório, Prata desejável
├── 📊 Checkpoint Estoico           # Autoavaliação honesta
└── 🔗 Próximos Passos              # Agende revisão + próximo capítulo
```

---

## 🔄 **FLUXO COMPLETO (Passo a Passo)**

### **FASE 1: PREPARAÇÃO (5min)**

```bash
# 1. Abra o projeto no IntelliJ
cd devphp-to-devjava
idea .

# 2. Abra arquivos de progresso em abas separadas
_docs/progress/learning-log.md
_docs/progress/socratic-answers.md

# 3. Inicie timer Pomodoro
https://pomofocus.io
```

---

### **FASE 2: LEITURA ATIVA (Pomodoro 1)**

#### **Passo 1: Perguntas Socráticas (10min)**
```markdown
# Em _docs/progress/socratic-answers.md

## Capítulo 01: Sintaxe Java
Data: 2025-10-01

### Pergunta 1: Tipos
Minha resposta: [ESCREVA SUA RESPOSTA AQUI]

### Pergunta 2: Constantes
Minha resposta: [ESCREVA SUA RESPOSTA AQUI]

### Pergunta 3: Arrays
Minha resposta: [ESCREVA SUA RESPOSTA AQUI]
```

💡 **IMPORTANTE:** Escreva SEM consultar! Mesmo que erre.

---

#### **Passo 2: Leitura da Teoria (15min)**
- Leia seção "Conceito Teórico" completa
- Anote termos desconhecidos
- Compare com seção "Analogia Laravel"
- Se algo não faz sentido, anote dúvida específica

**Template de dúvida:**
```markdown
## Dúvida: [Título curto]
**Capítulo:** 01
**Seção:** Conceito Teórico - Arrays

**O que não entendi:**
Por que `idades.length` não tem parênteses mas `nome.length()` tem?

**Minha hipótese:**
Talvez length seja propriedade em array e método em String?

**Preciso perguntar para:**
[ ] Claude  [x] Líder do time  [ ] Google
```

---

### **FASE 3: PRÁTICA GUIADA (Pomodoro 2)**

#### **Passo 1: Crie o arquivo (2min)**
```
IntelliJ:
1. Clique direito em src/main/java/legacy.fundamentals/cap01/
2. New > Java Class
3. Nome: PrimitiveTypes
4. Enter
```

---

#### **Passo 2: Digite o código (18min)**

```java
package legacy.fundamentals.cap01;

public class PrimitiveTypes {
    public static void main(String[] args) {
        // Digite linha por linha
        // OBSERVE os erros do IntelliJ (sublinhado vermelho)
        // Corrija antes de executar
    }
}
```

💡 **Por que digitar e não copiar?**
- Ativa memória motora (neurociência!)
- Força você a ler cada caractere
- Erros de digitação ensinam sintaxe

---

#### **Passo 3: Execute e teste (5min)**
```
IntelliJ:
1. Clique direito no arquivo
2. Run 'PrimitiveTypes.main()'
3. Observe saída no console
4. Mude valores e execute novamente
```

---

### **FASE 4: EXERCÍCIOS (Pomodoro 3)**

#### **Exercício Bronze (Obrigatório - 15min)**
```java
// Crie: src/main/java/legacy.fundamentals/cap01/ExercicioBronze.java

// Tarefa: [Copie do capítulo]
// Implemente sozinho
// Consulte teoria SE travar
```

**Checklist antes de considerar "pronto":**
- [ ] Compila sem erros
- [ ] Funciona com 3 casos de teste diferentes
- [ ] Código está comentado
- [ ] Entendo cada linha (teste: explique em voz alta!)

---

#### **Exercício Prata (Opcional - 10min)**
```java
// Se Bronze foi fácil, tente Prata
// Se travou, pule e revise teoria
```

💡 **Regra:** Melhor dominar Bronze 100% do que fazer Prata pela metade.

---

### **FASE 5: CONSOLIDAÇÃO (Pomodoro 4)**

#### **Passo 1: Atualizar Learning Log (10min)**
```markdown
# Em _docs/progress/learning-log.md

## Data: 2025-10-01

### 📖 Capítulo Estudado:
01 - Sintaxe Java

### ⏱️ Pomodoros Completados:
- [x] Pomodoro 1: Leitura + Perguntas Socráticas
- [x] Pomodoro 2: Prática Guiada
- [x] Pomodoro 3: Exercícios Bronze + Prata
- [x] Pomodoro 4: Consolidação

### 💡 Principais Aprendizados:
1. Java tem tipos primitivos separados de objetos (PHP não)
2. Arrays têm tamanho fixo (diferente de PHP)
3. String tem métodos (length()) mas array tem propriedade (length)

### 🔗 Relação com Laravel:
- `static final` = `const` no PHP
- `int[]` = `array` PHP (mas fixo!)
- Switch expressions = `match()` PHP 8

### ❓ Dúvidas que Surgiram:
1. Por que `idades.length` sem parênteses?
   → Preciso perguntar ao líder

### ✅ Exercícios Completados:
- [x] Bronze: Declaração de variáveis
- [x] Prata: Constantes e switch
- [ ] Ouro: (pular por enquanto)

### 🎯 Próximo Passo:
Amanhã: Revisar Exercício Bronze (spaced repetition D+1)
Depois: Capítulo 02 - JDBC Básico
```

---

#### **Passo 2: Git Commit (5min)**
```bash
git add .
git commit -m "Cap 01: Sintaxe Java - Exercícios Bronze e Prata completos"
git push
```

---

#### **Passo 3: Agendar Revisão (5min)**
```markdown
# Em _docs/progress/spaced-repetition.md

## Agenda de Revisões

### Capítulo 01: Sintaxe Java
- [x] Estudo inicial: 2025-10-01
- [ ] Revisão D+1: 2025-10-02 (Refazer Exercício Bronze)
- [ ] Revisão D+3: 2025-10-04 (Explicar em voz alta)
- [ ] Revisão D+7: 2025-10-08 (Revisar anotações)
```

---

#### **Passo 4: Autoavaliação Estoica (5min)**
```markdown
## Checkpoint Estoico - Cap 01

[ ] Consigo explicar o conceito para um júnior sem consultar?
[ ] Reproduzi o código de memória (sem copiar)?
[ ] Entendo o POR QUÊ funciona (não só COMO)?
[ ] Consigo adaptar para outra situação?
[ ] Anotei minhas dúvidas específicas?

Resultado: X/5

Se < 4: Revisar teoria e refazer exercícios amanhã
Se ≥ 4: Pode avançar para próximo capítulo
```

---

## 🚦 **REGRAS DE TRANSIÇÃO**

### **Quando avançar para próximo capítulo?**

✅ **PODE AVANÇAR se:**
- [ ] Todos exercícios Bronze funcionam 100%
- [ ] Consegue explicar conceito em voz alta
- [ ] Checkpoint ≥ 4/5
- [ ] Git commit realizado
- [ ] Revisão D+1 agendada

❌ **NÃO AVANCE se:**
- [ ] Exercício Bronze não funciona
- [ ] Não entende o POR QUÊ (só copiou código)
- [ ] Checkpoint < 4/5
- [ ] Pulou etapas por pressa

💡 **Lembre-se:** Melhor 1 capítulo sólido por dia do que 3 capítulos pela metade.

---

## 📊 **SISTEMA DE TRACKING**

### **Tabela de Progresso (README.md principal):**
```markdown
| Cap | Título | Status | Data | Revisão D+1 | Revisão D+7 |
|-----|--------|--------|------|-------------|-------------|
| 01  | Sintaxe| ✅ 100%| 10/01| [ ] 10/02   | [ ] 10/08   |
| 02  | JDBC   | 🚧 50% | 10/02| [ ] 10/03   | [ ] 10/09   |
| 03  | CRUD   | ⏳     | -    | -           | -           |
```

**Legenda:**
- ⏳ Não iniciado
- 🚧 Em progresso (X%)
- ✅ Completo (100%)
- 🔄 Em revisão

---

## 🎯 **EXEMPLO: PRIMEIRO DIA COMPLETO**

### **Hoje (01/10/2025):**
```
08:00 - Café da manhã
09:00 - Pomodoro 1: Leitura Cap 01
09:30 - Pomodoro 2: Prática Guiada
10:00 - Pomodoro 3: Exercício Bronze
10:30 - Pomodoro 4: Consolidação + Git
11:00 - FIM! (2h bem investidas)
```

### **Amanhã (02/10/2025):**
```
09:00 - Revisão D+1: Refazer Exercício Bronze (15min)
09:15 - Iniciar Cap 02: JDBC Básico (2h)
```

### **Daqui 3 dias (04/10/2025):**
```
09:00 - Revisão D+3: Explicar Cap 01 em voz alta (10min)
09:10 - Continuar capítulo atual
```

---

## 🔥 **ÚLTIMA DICA: O SEGREDO DO BABY STEPS**

### **NÃO faça:**
❌ "Vou estudar 8h hoje e compensar a semana"  
❌ "Vou ler todos os capítulos primeiro e depois praticar"  
❌ "Pulei os exercícios porque entendi a teoria"

### **FAÇA:**
✅ 2h/dia consistentes (melhor que 8h irregular)  
✅ 1 capítulo por vez (teoria → prática → consolidação)  
✅ Exercícios obrigatórios (compreensão ≠ prática)

---

**🥋 "O mestre falhou mais vezes do que o iniciante tentou."**

💡 Próxima ação: Quer que eu crie os **templates de progress** prontos para você começar hoje?