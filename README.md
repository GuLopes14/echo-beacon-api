# 🏍️ Ride Echo Beacon API

O projeto **Ride Echo Beacon API** foi desenvolvido para a empresa **Mottu** com o objetivo de implementar uma solução tecnológica que melhore a organização e localização das motos no pátio da empresa. A solução integra hardware, software e banco de dados para facilitar a gestão e identificação de veículos de forma eficiente.

---

# 👔 Integrantes
* **Gustavo Lopes Santos da Silva** - RM: 556859
* **Renato de Freitas David Campiteli** - RM: 555627
* **Gabriel Santos Jablonski** - RM: 555452

## 🛠️ Descrição do Projeto

O projeto em desenvolvimento para a empresa **Mottu** visa implementar uma solução tecnológica para melhorar a organização e a localização das motos no pátio da empresa, facilitando a gestão e a identificação de cada veículo de forma mais eficiente. O sistema será composto por uma série de componentes integrados, incluindo **Arduino**, um **aplicativo móvel** e um **banco de dados centralizado**.

A solução será composta por pequenas placas eletrônicas, chamadas de **"EchoBeacon"**, que serão instaladas em cada moto. Essas placas conterão:
- Um **sistema de som** (buzzer).
- Um **LED** para sinalização visual.

Quando uma moto chega ao pátio, informações como **placa**, **chassi** e detalhes sobre qualquer problema específico do veículo serão registradas em um banco de dados integrado. Esses dados poderão ser acessados por um sistema desenvolvido em **Java**.

Além disso, os funcionários responsáveis pela organização e monitoramento das motos no pátio terão acesso a um **aplicativo móvel**, que estará conectado ao banco de dados. Através desse aplicativo, eles poderão:
- Consultar informações detalhadas sobre as motos, como **placa**, **chassi** e **problemas**.
- Ativar o **buzzer** e/ou o **LED** da moto selecionada, emitindo um som e sinal visual para facilitar sua localização, mesmo em um ambiente com várias motos.

Essa solução visa resolver o problema de localizar rapidamente as motos no pátio. Sem uma identificação clara e imediata, os funcionários enfrentam dificuldades para encontrar a moto correta entre tantas outras. Com a implementação desse sistema, a **Mottu** poderá organizar melhor suas motos e otimizar o tempo gasto na identificação e localização dos veículos dentro do pátio, garantindo uma gestão mais ágil e eficiente.

---

## 🎯 Objetivo

- **Facilitar a localização de motos no pátio da empresa.**
- **Otimizar o tempo dos funcionários na identificação de veículos.**
- **Garantir uma gestão mais eficiente e organizada.**

---

## 🛡️ Tecnologias Utilizadas

- **Java 17**: Linguagem principal para o desenvolvimento da API.
- **Spring Boot**: Framework para criação da API REST.
- **Spring Data JPA**: Acesso ao banco de dados.
- **Banco de Dados H2**: Banco de dados em memória para desenvolvimento e testes.
- **Maven**: Gerenciamento de dependências.
- **Bean Validation**: Validação de dados.

---

## ⚙️ Como Executar o Projeto

### **Pré-requisitos**
- **Java 17** ou superior.
- **Maven**.
- **IDE** (IntelliJ IDEA, Eclipse ou VS Code).

### **Passos**
1. Clone o repositório:
   git clone <URL_DO_REPOSITORIO>
   cd echo-beacon-api
2. Execute a aplicação:
    Vá para /src -> /main  -> /java -> RideEchoBeacon.java e pressione "Run", caso esteja usando vscode e não tenha a extensão de java instalada, 
    instale esta: https://marketplace.visualstudio.com/items/?itemName=redhat.java
3. Acesse a API em:
    http://localhost:8080


