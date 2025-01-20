# Testes Automatizados - Seu Barriga

Este repositório contém testes automatizados para a aplicação web [Seu Barriga](https://seubarriga.wcaquino.me), utilizando **Java**, **Selenium WebDriver** e **JUnit 5**. O objetivo é validar funcionalidades da aplicação de forma automática, garantindo a qualidade do sistema.

## Tecnologias Utilizadas
- **Java 11+**
- **Maven** (Gerenciamento de dependências)
- **JUnit 5** (Execução de testes automatizados)
- **Selenium WebDriver** (Interação com a aplicação web)
- **WebDriverManager** (Gerenciamento automático de drivers dos navegadores)

## Estrutura do Projeto
```
projeto/
|-- src/
|   |-- main/java/
|       |-- tests/ (Casos de teste automatizados)
|       |-- pages/ (Page Objects representando as telas do sistema)
|       |-- core/ (Configurações e classes base para os testes)
|       |-- suites/ (Suites de execução das classes de testes)
|-- pom.xml (Arquivo de configuração do Maven)
|-- README.md (Este documento)
```

## Configuração e Execução
### Requisitos
- **Java 11+** instalado e configurado no `PATH`
- **Maven** instalado e configurado
- **Navegador Firefox ou Chrome** (drivers já configurados)

### Instalação
Clone o repositório e instale as dependências com Maven:
```sh
git clone <URL_DO_REPOSITORIO>
cd projeto
mvn clean install
```

### Execução dos Testes
Para rodar todos os testes:
```sh
mvn test
```
Para executar uma classe de testes específica:
```sh
mvn -Dtest=NomeDaClasse test
```

### Relatórios de Teste
Os resultados dos testes são gerados automaticamente e podem ser encontrados em:
```
target/surefire-reports/
```

## MATC84 - Laboratório de Programação Web
Projeto 5- **Equipe Web Test Tools**
