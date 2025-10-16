# SETUP Spring Boot 

Setup de ambiente para desenvolvimento com Spring Boot em Linux (Ubuntu 22+).

```bash
# Atualizar o sistema
sudo apt update && sudo apt upgrade -y
sudo apt install -y build-essential curl file git
```

## JDK (Java Development Kit  17) 

O que é: Ambiente de desenvolvimento Java.
Objetivo: Fornecer as ferramentas necessárias para desenvolver e executar aplicações Java.
Responsável: Por compilar, depurar e executar aplicações Java.

> Equivalente ao PHP no desenvolvimento web, o JDK é essencial para criar aplicações Java.

Como instalar:

```bash
# Adicionar repositório do OpenJDK
sudo apt install -y openjdk-17-jdk
# Verificar instalação
java --version
javac --version
```
## Maven (Gerenciador de Dependências)

O que é: Gerenciador de dependências e ferramenta de construção para projetos Java.
Objetivo: Gerenciar dependências, compilar código, executar testes e empacotar aplicações.
Responsável: Por simplificar o processo de construção e gerenciamento de projetos Java.

> Equivalente ao Composer no PHP, o Maven gerencia dependências e o ciclo de build do projeto.

Como instalar:

```bash
# Instalar Maven
sudo apt install -y maven
# Verificar instalação
mvn -version
```

## IDES

1. IntelliJ IDEA
2. Visual Studio Code (VSCode)

## Variáveis de Ambiente

O que é: Configurações do sistema que afetam o comportamento de processos em execução.
Objetivo: Definir caminhos e configurações para ferramentas e bibliotecas.
Responsável: Por garantir que o sistema encontre as ferramentas necessárias.

> Equivalente ao PATH no Windows, as variáveis de ambiente são cruciais para o funcionamento correto das ferramentas.

Como configurar: 

```bash
# Adicionar JDK ao PATH (ou editar arquivo de configuração(~/.bashrc ou ~/.zshrc)
# export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64' >> ~/.bashrc
# export PATH=$PATH:$JAVA_HOME/bin
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
source ~/.bashrc
# Verificar configuração
echo $JAVA_HOME
# Verificação Completa
java --version
# Verificar Maven
mvn --version
```

## 🚀 Criação do Projeto Spring Boot

### Usando Spring Initializr
1. Acesse [Spring Initializr](https://start.spring.io/).
2. Configurações
    - Projeto: Maven
    - Linguagem: Java
    - Spring Boot 3.2+
    - Grupo: com.uerj.br
    - Artefato: sistema de frequencia
    - Dependências: 
      - Spring Web 
      - Spring Data JPA
      - Mysql Driver
      - Validation
   