
---

# Employee Service - HRMS

## Descrição
O **Employee Service** faz parte do sistema **HRMS (Human Resource Management System)** e é responsável pelo gerenciamento dos funcionários da organização. Ele permite criar, atualizar, listar e excluir funcionários, além de associá-los a departamentos.

## Funcionalidades
- **CRUD de Funcionários**:
    - **Criar**: Adicionar novos funcionários ao sistema.
    - **Ler**: Listar todos os funcionários ou buscar detalhes de um funcionário específico.
    - **Atualizar**: Editar as informações de um funcionário existente.
    - **Deletar**: Remover funcionários do sistema.
- **Associação de Funcionários a Departamentos**:
    - Relacionar funcionários com seus respectivos departamentos dentro da empresa.
- **Validação de Dados**:
    - Garantir que os campos obrigatórios sejam preenchidos corretamente antes de realizar qualquer operação.

## Endpoints Iniciais

| Método | Endpoint             | Descrição                        |
|--------|----------------------|----------------------------------|
| POST   | `/employees`          | Adiciona um novo funcionário     |
| GET    | `/employees`          | Lista todos os funcionários      |
| GET    | `/employees/{id}`     | Retorna detalhes de um funcionário específico |
| PUT    | `/employees/{id}`     | Atualiza os dados de um funcionário específico |
| DELETE | `/employees/{id}`     | Remove um funcionário do sistema |

## Tecnologias Utilizadas
- **Java** (versão 21)
- **Spring Boot** (versão 3.3.4)
- **Maven** para gerenciamento de dependências
- **Spring Data JPA** para integração com banco de dados
- **Hibernate** como provedor JPA
- **MySQL** como banco de dados (ou outro banco conforme configuração)
- **Spring Security** para autenticação e autorização (integrado com Auth Service)
- **JWT (JSON Web Token)** para autenticação

## Pré-requisitos

- **Java 21** instalado
- **Maven** instalado
- **MySQL** (ou outro banco de dados) configurado

## Configuração Inicial

1. Clone o repositório:
   ```bash
   git clone https://github.com/gidaltibn/hrms-employee-service.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd employee-service
   ```

3. Compile o projeto e baixe as dependências:
   ```bash
   mvn clean install
   ```

4. Configure o arquivo `application.properties` para conectar com seu banco de dados.

5. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir *pull requests* ou relatar *issues* no repositório.

---

Esse README pode ser expandido conforme o desenvolvimento avance e novos detalhes sobre funcionalidades e configurações sejam implementados.