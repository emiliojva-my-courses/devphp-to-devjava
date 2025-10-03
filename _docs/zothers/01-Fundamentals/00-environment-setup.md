# 📖 **Capítulo 00: Configuração do Ambiente**

> **Preparando seu dojo para a jornada Java**

---

## 🎯 **OBJETIVO DO CAPÍTULO**

Configurar um ambiente completo de desenvolvimento Java/Spring Boot no Windows 11 com WSL2, comparando com seu ambiente PHP/Laravel atual.

---

## 🛠️ **AMBIENTE DO SAMURAI**

### **Configuração Windows 11 + WSL2**

```bash
# Verificar instalações existentes
java -version        # JDK 21+
mvn --version        # Maven 3.9+
docker --version     # Docker 24+
git --version        # Git 2.40+
```

### **Analogia Laravel:**
Se você já tem PHP + Composer + Docker configurados, agora vamos adicionar Java + Maven + JDK ao seu arsenal.

---

## 📦 **INSTALAÇÃO PASSO A PASSO**

### **1. JDK (Java Development Kit)**

```bash
# Instalar OpenJDK 21 (recomendado)
sudo apt update
sudo apt install openjdk-21-jdk

# Verificar instalação
java -version
javac -version

# Configurar JAVA_HOME
echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64' >> ~/.zshrc
echo 'export PATH=$PATH:$JAVA_HOME/bin' >> ~/.zshrc
source ~/.zshrc
```

**Analogia Laravel:** O JDK é como ter PHP + extensões + ferramentas de desenvolvimento.

### **2. Maven (Gerenciador de Dependências)**

```bash
# Instalar Maven
sudo apt install maven

# Verificar instalação
mvn --version

# Configurar settings (opcional)
mkdir -p ~/.m2
```

**Analogia Laravel:** Maven é exatamente como Composer - gerencia suas dependências e autoloading.

### **3. IDE - IntelliJ IDEA ou VS Code**

**Para IntelliJ IDEA (recomendado):**
```bash
# Via snap (mais fácil)
sudo snap install intellij-idea-community --classic
```

**Para VS Code (se você já usa):**
```bash
# Extensões essenciais
code --install-extension vscjava.vscode-java-pack
code --install-extension pivotal.vscode-spring-boot
```

### **4. Docker para Bancos de Dados**

```bash
# Já deve ter Docker, mas vamos configurar para Java
# Criar docker-compose.yml para desenvolvimento
```

---

## 🗂️ **ESTRUTURA DE PASTAS RECOMENDADA**

```bash
# Criar estrutura organizada
mkdir -p ~/java-projects/{class-01,labs,docker}
cd ~/java-projects
```

**Estrutura final:**
```
~/java-projects/
├── class-01/           # Projetos das aulas
├── labs/              # Experimentos e testes
├── docker/            # Compose files
└── tools/             # Scripts úteis
```

**Analogia Laravel:** Similar ao seu `~/php-projects/` ou `~/laravel-projects/`.

---

## 🐳 **DOCKER COMPOSE PARA DESENVOLVIMENTO**

Crie o arquivo `~/java-projects/docker/docker-compose.yml`:

```yaml
version: '3.8'

services:
  # PostgreSQL - equivale ao seu MySQL/Postgres do Laravel
  postgres:
    image: postgres:15
    container_name: java-postgres
    environment:
      POSTGRES_DB: dojo
      POSTGRES_USER: samurai
      POSTGRES_PASSWORD: secret
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  # Redis - cache e sessões
  redis:
    image: redis:7-alpine
    container_name: java-redis
    ports:
      - "6379:6379"

  # MySQL (se preferir)
  mysql:
    image: mysql:8.0
    container_name: java-mysql
    environment:
      MYSQL_ROOT_PASSWORD: secret
      MYSQL_DATABASE: dojo
      MYSQL_USER: samurai
      MYSQL_PASSWORD: secret
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  postgres_data:
  mysql_data:
```

**Subir os serviços:**
```bash
cd ~/java-projects/docker
docker-compose up -d
```

---

## 🔧 **CONFIGURAÇÕES ADICIONAIS**

### **Git (se ainda não configurado)**
```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu@email.com"
```

### **Aliases úteis para .zshrc**
```bash
# Adicionar ao ~/.zshrc
alias jprojects="cd ~/java-projects"
alias mvnrun="mvn spring-boot:run"
alias mvntest="mvn test"
alias mvnclean="mvn clean compile"

# Recarregar
source ~/.zshrc
```

---

## ✅ **VERIFICAÇÃO FINAL**

Execute este script para verificar se tudo está funcionando:

```bash
# Verificar Java
echo "=== JAVA ==="
java -version
javac -version
echo $JAVA_HOME

# Verificar Maven
echo "=== MAVEN ==="
mvn --version

# Verificar Docker
echo "=== DOCKER ==="
docker --version
docker-compose --version

# Testar conexão com banco
echo "=== DATABASE ==="
docker ps | grep postgres
```

**Saída esperada:** Todas as versões devem aparecer sem erros.

---

## 🎯 **PRIMEIRO PROJETO TESTE**

Vamos criar um "Hello World" para testar:

```bash
cd ~/java-projects/class-01
mvn archetype:generate \
  -DgroupId=com.dojo \
  -DartifactId=hello-world \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

cd hello-world
mvn compile
mvn exec:java -Dexec.mainClass="com.dojo.App"
```

**Analogia Laravel:** Como fazer `laravel new project` e `php artisan serve`.

---

## 🚀 **PRÓXIMOS PASSOS**

Agora que seu ambiente está configurado:

1. ✅ JDK 21 instalado e configurado
2. ✅ Maven funcionando
3. ✅ Docker com bancos de dados
4. ✅ IDE configurada
5. ✅ Primeiro projeto criado

**Próximo capítulo:** [Capítulo 01: Ecossistema Java](01-java-ecosystem.md)

---

## 🆘 **TROUBLESHOOTING COMUM**

### **JAVA_HOME não encontrado**
```bash
# Encontrar onde Java foi instalado
sudo find /usr -name "java" -type f 2>/dev/null | grep bin
# Usar o caminho encontrado
export JAVA_HOME=/caminho/para/java
```

### **Maven não encontra JDK**
```bash
# Forçar Maven a usar JDK específico
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
mvn --version
```

### **Permissões Docker**
```bash
# Adicionar usuário ao grupo docker
sudo usermod -aG docker $USER
# Logout e login novamente
```

---

🏮 **AMBIENTE CONFIGURADO! AGORA VAMOS ENTENDER O ECOSSISTEMA JAVA!** 🐉
