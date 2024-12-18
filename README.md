---

### Employee Service - HRMS

**Descrição**  
O **Employee Service** faz parte do sistema **HRMS (Human Resource Management System)** e é responsável pelo gerenciamento de funcionários da organização, bem como pelo CRUD de departamentos. Ele permite criar, atualizar, listar e excluir funcionários, associá-los a departamentos e também gerenciar departamentos, tudo isso integrando-se ao Auth Service para validar tokens JWT antes de executar operações sensíveis.

**Principais pontos**:
- **Separação de Responsabilidades**: O Employee Service concentra-se na parte funcional de funcionários e departamentos, enquanto o Auth Service cuida da autenticação e autorização.
- **Fluxo de Cadastro de Funcionários**: Um secretário (ou outro usuário com permissão) faz o pré-cadastro do funcionário com dados básicos (nome, sobrenome, email, telefone, data de contratação, departamento, salário). O próprio funcionário posteriormente pode criar seu usuário no Auth Service.
- **CRUD de Departamentos**: O Employee Service também gerencia departamentos, permitindo cadastrar, atualizar, listar e remover departamentos. Essas ações também requerem a validação do token JWT.
- **Validação via JWT**: Antes de realizar operações, o Employee Service valida o token JWT no cabeçalho da requisição, garantindo que apenas usuários autenticados pelo Auth Service tenham acesso.

---

### Funcionalidades

**CRUD de Funcionários**:
- **Criar**: Adicionar novos funcionários com dados básicos.
- **Ler**: Listar todos os funcionários ou detalhes de um funcionário específico.
- **Atualizar**: Editar as informações de um funcionário existente.
- **Deletar**: Remover um funcionário do sistema.

**CRUD de Departamentos**:
- **Criar**: Registrar um novo departamento.
- **Ler**: Listar todos os departamentos ou detalhes de um departamento específico.
- **Atualizar**: Atualizar dados de um departamento existente.
- **Deletar**: Remover um departamento do sistema.

**Associação de Funcionários a Departamentos**:
- Vincular um funcionário a um departamento específico, facilitando a organização interna.

**Validação de Dados**:
- Garantir o preenchimento correto de campos obrigatórios.
- Validar o token JWT enviado no cabeçalho `Authorization` com o Auth Service.

---

### Endpoints Iniciais

**Funcionários**:
| Método | Endpoint              | Descrição                                          |
|--------|-----------------------|----------------------------------------------------|
| POST   | /employees            | Adiciona um novo funcionário                       |
| GET    | /employees            | Lista todos os funcionários                        |
| GET    | /employees/{id}       | Retorna detalhes de um funcionário específico       |
| PUT    | /employees/{id}       | Atualiza os dados de um funcionário específico      |
| DELETE | /employees/{id}       | Remove um funcionário do sistema                   |

**Departamentos**:
| Método | Endpoint            | Descrição                                        |
|--------|---------------------|--------------------------------------------------|
| POST   | /departments        | Adiciona um novo departamento                    |
| GET    | /departments        | Lista todos os departamentos                     |
| GET    | /departments/{id}   | Retorna detalhes de um departamento específico   |
| PUT    | /departments/{id}   | Atualiza os dados de um departamento específico  |
| DELETE | /departments/{id}   | Remove um departamento do sistema                |

**Observação**: Todas as requisições que exigem autenticação devem incluir o cabeçalho:  
`Authorization: Bearer <seu_token_jwt>`

---

### Tecnologias Utilizadas

- **Java 21**  
- **Spring Boot 3.3.4**  
- **Maven** para gerenciamento de dependências  
- **Spring Data JPA** para integração com banco de dados  
- **Hibernate** como provedor JPA  
- **MySQL** (ou outro banco conforme configuração)  
- **Spring Security** para integração com Auth Service  
- **JWT (JSON Web Token)** para autenticação e autorização

---

### Pré-requisitos

- **Java 21** instalado  
- **Maven** instalado  
- **MySQL** (ou outro banco de dados) configurado  
- **Auth Service** em execução, fornecendo tokens JWT válidos

---

### Configuração Inicial

Clone o repositório:
```bash
git clone https://github.com/gidaltibn/hrms-employee-service.git
```

Navegue até o diretório do projeto:
```bash
cd hrms-employee-service
```

Compile o projeto e baixe as dependências:
```bash
mvn clean install
```

Configure o arquivo `application.properties` para conectar com seu banco de dados e defina a variável de ambiente `JWT_SECRET`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hrms_employee
spring.datasource.username=root
spring.datasource.password=senha

# Outras configurações...
```

Execute o projeto:
```bash
mvn spring-boot:run
```

---

### Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir pull requests ou relatar issues no repositório. Futuramente, este README poderá ser expandido com mais detalhes sobre fluxos de pré-cadastro, integrações entre serviços, e novas funcionalidades no gerenciamento de funcionários e departamentos.

---
