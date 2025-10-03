# Engenharia, Arquitetura e Desenvolvimento de software

- Conceitos
- Arquitetura
- Jargões comuns
- Práticas recomendadas
- Ferramentas
- Padrões

## **API (Application Programming Interface)**
Interface que permite comunicação entre diferentes sistemas/aplicações.
- **REST API**: Padrão de comunicação via HTTP
- **GraphQL**: Query language para APIs
- **Para que serve**: Integração entre sistemas, frontend-backend

## **CI/CD (Continuous Integration/Continuous Deployment)**
Práticas de automação de desenvolvimento:
- **CI**: Integração contínua do código
- **CD**: Deploy automático
- **Para que serve**: Reduz bugs, acelera entregas, qualidade

## **DevOps**
Cultura que une desenvolvimento (Dev) e operações (Ops).
- **Para que serve**: Deploy mais rápido, colaboração, automação de infraestrutura

## **Cloud Computing**
Computação em nuvem (AWS, Azure, Google Cloud).
- **IaaS**: Infraestrutura como serviço
- **PaaS**: Plataforma como serviço
- **SaaS**: Software como serviço
- **Para que serve**: Escalabilidade, redução de custos

## **Serverless**
Arquitetura onde você não gerencia servidores diretamente.
- **Exemplos**: AWS Lambda, Vercel Functions
- **Para que serve**: Foco no código, escalabilidade automática

## **Arquitetura Hexagonal (Ports & Adapters)**
Padrão que isola a lógica de negócio de detalhes externos.
- **Para que serve**: Testabilidade, flexibilidade, baixo acoplamento

## **DDD (Domain-Driven Design)**
Abordagem de design focada no domínio do negócio.
- **Para que serve**: Código que reflete o negócio, comunicação clara

## **SOLID**
Princípios de design de código:
- **S**ingle Responsibility, **O**pen/Closed, **L**iskov Substitution, **I**nterface Segregation, **D**ependency Inversion
- **Para que serve**: Código mais limpo e manutenível

## **Observabilidade**
Capacidade de entender o estado interno do sistema através de logs, métricas e traces.
- **Para que serve**: Debug em produção, monitoramento, performance

## **Infrastructure as Code (IaC)**
Gerenciar infraestrutura através de código (Terraform, CloudFormation).
- **Para que serve**: Reprodutibilidade, versionamento da infra

## **Event-Driven Architecture**
Arquitetura baseada em eventos e mensageria.
- **Para que serve**: Desacoplamento, reatividade, escalabilidade

Esses são os principais que completam o "vocabulário essencial" do dev moderno! 🎯

## **Três Camadas (Three-Tier Architecture)**
É um padrão arquitetural que divide a aplicação em três camadas distintas:
- **Apresentação** (Frontend): Interface do usuário
- **Lógica de Negócio** (Backend): Processamento e regras
- **Dados** (Database): Armazenamento e persistência

**Para que serve**: Separação de responsabilidades, facilita manutenção e escalabilidade.

## **Monólito**
Uma aplicação desenvolvida como uma única unidade deployável, onde todas as funcionalidades estão em um só projeto/codebase.

**Para que serve**:
- Simplicidade inicial de desenvolvimento
- Fácil deploy e debug
- Boa para projetos pequenos/médios
- **Desvantagem**: Pode ficar complexo conforme cresce

## **MonoRepo**
Estratégia onde múltiplos projetos relacionados ficam em um único repositório Git.

**Para que serve**:
- Compartilhamento de código comum
- Versionamento sincronizado
- Facilita refatorações cross-project
- **Exemplo**: Google, Facebook usam muito

## **Microsserviços**
Arquitetura onde a aplicação é dividida em pequenos serviços independentes que se comunicam via APIs.

**Para que serve**:
- Escalabilidade independente
- Times podem trabalhar em paralelo
- Tecnologias diferentes por serviço
- **Desvantagem**: Complexidade de infraestrutura

## **Containerizar**
Processo de empacotar uma aplicação com todas suas dependências em containers (Docker, por exemplo).

**Para que serve**:
- "Funciona na minha máquina" → Funciona em qualquer lugar
- Isolamento de ambiente
- Deploy consistente
- Facilita CI/CD

## **Engenharia (de Software)**

Disciplina que aplica princípios sistemáticos, quantificáveis e mensuráveis ao desenvolvimento de software.

**Para que serve**:
- Qualidade e confiabilidade
- Processos estruturados
- Métricas e monitoramento
- Manutenibilidade a longo prazo

## **Unit of Work Pattern**

O **Unit of Work** é um padrão de design que mantém uma lista de objetos afetados por uma transação de negócio 
e coordena a escrita das mudanças e a resolução de problemas de concorrência.

### **O que faz:**
- Agrupa operações de banco de dados em uma única transação
- Controla quando e como as mudanças são persistidas
- Garante consistência dos dados
- Gerencia o ciclo de vida das entidades

### **Como funciona:**

```java
// Exemplo conceitual em Java
public interface UnitOfWork extends AutoCloseable {
    UserRepository getUsers();
    OrderRepository getOrders();
    
    int saveChanges();
    void beginTransaction();
    void commit();
    void rollback();
    
    @Override
    void close(); // Para uso com try-with-resources
}
```

### **Cenário de uso:**
```java
public class OrderService {
    private final UnitOfWorkFactory unitOfWorkFactory;

    public OrderService(UnitOfWorkFactory unitOfWorkFactory) {
        this.unitOfWorkFactory = unitOfWorkFactory;
    }

    public void processOrder(CreateOrderDto dto) {
        // try-with-resources substitui o "using" do C#
        try (UnitOfWork uow = unitOfWorkFactory.create()) {
            uow.beginTransaction();
            try {
                // Múltiplas operações na mesma transação
                User user = uow.getUsers().findById(dto.getUserId());
                Order order = new Order(dto);

                uow.getOrders().save(order);
                user.updateLastOrderDate();

                // Todas as mudanças são salvas juntas
                uow.saveChanges();
                uow.commit();
            } catch (Exception e) {
                uow.rollback();
                throw new RuntimeException("Erro ao processar pedido", e);
            }
        }
    }
}

```

### **Vantagens:**
- **Consistência**: Garante que todas as operações sejam executadas ou nenhuma
- **Performance**: Agrupa operações, reduzindo round-trips ao banco
- **Transações**: Controle fino sobre transações de banco
- **Desacoplamento**: Separa lógica de negócio da persistência

### **Desvantagens:**
- **Complexidade**: Pode adicionar complexidade desnecessária em casos simples
- **Memory leak**: Se não gerenciado corretamente, pode acumular objetos
- **Overhead**: Para operações simples pode ser excessivo

### **Quando usar:**
- ✅ Operações que envolvem múltiplas entidades
- ✅ Necessidade de controle transacional
- ✅ Sistemas com regras de negócio complexas
- ❌ CRUD simples sem relacionamentos
- ❌ Operações de leitura apenas

### **Frameworks que implementam:**
- **Entity Framework** (SaveChanges é um Unit of Work)
- **NHibernate** (Session)
- **JPA/Hibernate** (EntityManager)
- **ActiveRecord** (Rails)

O Unit of Work é essencial para manter a integridade dos dados em operações complexas! 🎯

## **Truth**
No contexto de desenvolvimento de software, **Truth** refere-se à fonte única e confiável de dados ou estado em um sistema. É o ponto onde a informação é considerada correta e definitiva.

### **O que faz:**
- Centraliza o estado do sistema
- Evita inconsistências entre diferentes partes do sistema
- Facilita a sincronização de dados
### **Como funciona:**
```java
// Exemplo conceitual
public class TruthSource {
    private static TruthSource instance;
    private Map<String, Object> state;
    
    private TruthSource() {
        state = new HashMap<>();
    }
    
    public static synchronized TruthSource getInstance() {
        if (instance == null) {
            instance = new TruthSource();
        }
        return instance;
    }
    
    public Object getState(String key) {
        return state.get(key);
    }
    
    public void setState(String key, Object value) {
        state.put(key, value);
    }
}
```

**Resumo**: Esses conceitos ajudam a organizar, escalar e manter sistemas de software de forma mais eficiente e profissional! 🚀

## Jenkins
Ferramenta de automação open-source para CI/CD (Integração Contínua e Entrega Contínua).
- **Para que serve**: Automatiza builds, testes e deploys
- **Características**: Plugins, pipelines, fácil integração
- **Alternativas**: GitHub Actions, GitLab CI, CircleCI
- **Site oficial**: https://www.jenkins.io/

## Grafana
Plataforma open-source para visualização e monitoramento de métricas.
- **Para que serve**: Criação de dashboards, alertas
- **Características**: Suporte a múltiplas fontes de dados, personalização
- **Alternativas**: Kibana, Datadog, Prometheus (com UI)
- **Site oficial**: https://grafana.com/

## Elastic Search
Motor de busca e análise distribuído, baseado em Lucene.
- **Para que serve**: Busca rápida, análise de grandes volumes de dados
- **Características**: Escalável, RESTful API, suporte a JSON
- **Alternativas**: Solr, Algolia
- **Site oficial**: https://www.elastic.co/elasticsearch/

## Kibana
Ferramenta de visualização para dados armazenados no Elasticsearch.
- **Para que serve**: Criação de dashboards, análise de logs
- **Características**: Integração nativa com Elasticsearch, visualizações interativas
- **Alternativas**: Grafana, Datadog
- **Site oficial**: https://www.elastic.co/kibana/

## Logstash
Ferramenta de processamento de dados para coletar, transformar e enviar logs.
- **Para que serve**: Ingestão de dados, transformação, envio para destinos (Elasticsearch, etc.)
- **Características**: Plugins, pipeline configurável
- **Alternativas**: Fluentd, Beats
- **Site oficial**: https://www.elastic.co/logstash/

## Orquestradores
Ferramentas para gerenciar containers em larga escala (Kubernetes, Docker Swarm).
- **Para que serve**: Deploy, escalabilidade, gerenciamento de containers
- **Características**: Auto-scaling, load balancing, service discovery
- **Alternativas**: Nomad, Mesos
- **Site oficial**: https://kubernetes.io/, https://docs.docker.com/

## Docker
Ferramenta para criar, distribuir e rodar containers.
- **Para que serve**: Isolamento de aplicações, consistência entre ambientes
- **Características**: Imagens, containers, Docker Hub
- **Alternativas**: Podman, LXC
- **Site oficial**: https://www.docker.com/

### Docker Compose
Ferramenta para definir e rodar aplicações multi-container Docker.
- **Para que serve**: Orquestração local de múltiplos containers
- **Características**: Arquivo YAML, fácil configuração
- **Alternativas**: Kubernetes (para produção)
- **Site oficial**: https://docs.docker.com/compose/

### Dockerfile
Arquivo de configuração para criar imagens Docker.
- **Para que serve**: Define ambiente, dependências e comandos para container
- **Características**: Instruções simples, versionável
- **Alternativas**: Podmanfile (Podman)
- **Site oficial**: https://docs.docker.com/engine/reference/builder/

### Docker-compose.yml
Arquivo YAML usado pelo Docker Compose para definir serviços, redes e volumes.
- **Para que serve**: Configurar e rodar múltiplos containers como um serviço
- **Características**: Simplicidade, reutilização
- **Alternativas**: Kubernetes manifests (para produção)
- **Site oficial**: https://docs.docker.com/compose/compose-file/

## Dashboards para monitoramento de aplicações
Ferramentas para visualizar métricas e logs de aplicações (Grafana, Kibana).
- **Para que serve**: Monitoramento em tempo real, análise de performance
- **Características**: Visualizações customizáveis, alertas
- **Alternativas**: Datadog, New Relic
- **Site oficial**: https://grafana.com/, https://www.elastic.co/kibana/
- **Exemplos**: Dashboards de CPU, memória, latência, erros

## Dashboards para monitoramento com queries sobre situacões específicas do sistema
Ferramentas para criar dashboards com queries específicas do negócio (Grafana, Metabase).
- **Para que serve**: Análise de métricas de negócio, KPIs
- **Características**: Conexão a múltiplas fontes de dados, visualizações custom
- **Alternativas**: Tableau, Power BI
- **Site oficial**: https://grafana.com/, https://www.metabase.com/
- **Exemplos**: Dashboards de vendas, usuários ativos, conversões

## Metabase
Ferramenta open-source para análise de dados e criação de dashboards.
- **Para que serve**: Visualização de dados, criação de relatórios
- **Características**: Interface amigável, suporte a múltiplas fontes de dados
- **Alternativas**: Tableau, Power BI
- **Site oficial**: https://www.metabase.com/
- **Exemplos**: Dashboards de vendas, usuários ativos, conversões

## Stack
Conjunto de ferramentas usadas em conjunto para desenvolvimento e operação de software (ELK Stack, MEAN Stack).
- **Para que serve**: Solução completa para desenvolvimento, monitoramento, análise
- **Características**: Integração entre componentes, facilidade de uso
- **Alternativas**: LAMP Stack, MERN Stack
- **Site oficial**: Varia conforme a stack (https://www.elastic.co/elastic-stack)

## Software Engineering
Disciplina que aplica princípios sistemáticos, quantificáveis e mensuráveis ao desenvolvimento de software.
- **Para que serve**: Qualidade e confiabilidade, processos estruturados
- **Características**: Métricas, monitoramento, manutenibilidade
- **Alternativas**: Desenvolvimento ad-hoc, prototipagem rápida
- **Site oficial**: N/A (conceito amplo)

## Line Code
Ferramenta de análise estática de código para garantir qualidade e padrões.
- **Para que serve**: Detecta bugs, vulnerabilidades e code smells
- **Características**: Suporte a múltiplas linguagens, integração com CI/CD
- **Alternativas**: SonarQube, CodeClimate
- **Site oficial**: https://linecode.com/

## Branch Code Testing
Prática de testar código em branches separados antes de mesclá-los ao branch principal.
- **Para que serve**: Garante qualidade e estabilidade do código
- **Características**: Testes automatizados, revisão de código
- **Ferramentas**: Jenkins, GitHub Actions, GitLab CI
- **Benefícios**: Reduz bugs, melhora colaboração

## Referencias
- Refactory Guru - https://refactoring.guru/design-patterns/what-is-pattern
- [Martin Fowler - Patterns of Enterprise Application Architecture](https://martinfowler.com/eaaCatalog/unitOfWork.html)
- 