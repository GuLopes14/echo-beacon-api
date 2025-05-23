
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

## Uso 🚀

- **Execute o comando: `mvn spring-boot:run`** para iniciar a aplicação.
- **URL**: `http://localhost:8080/`

# 📘 Exemplos de Requisições para a API 

## 🔹 Criar um EchoBeacon (POST)
- POST localhost:8080/echo-beacons
- Content-Type: application/json
```http
{
  "numeroIdentificacao": 4,
  "status": "DESATIVADO",
  "versaoFirmware": "v1.0.0",
  "statusConexao": "CONECTADO",
  "dataRegistro": "2025-04-19"
}
```

## 🔹 Atualizar um EchoBeacon (PUT)
- PUT localhost:8080/echo-beacons/4
- Content-Type: application/json
```http
{
  "numeroIdentificacao": 4,
  "status": "ATIVO",
  "versaoFirmware": "v1.0.0",
  "statusConexao": "CONECTADO",
  "dataRegistro": "2025-04-19"
}
```

## 🔹 Criar uma Moto (POST)
- POST localhost:8080/motos
- Content-Type: application/json
```http
{
  "placa": "XYZ5678",
  "chassi": "1HGCM82633A654321",
  "modelo": "MOTTU_SPORT",
  "problema": "Problema no motor",
  "echoBeacon": {
    "id": 4
  },
  "dataRegistro": "2025-05-10"
}
```

## 🔹 Atualizar uma Moto (PUT)

- PUT localhost:8080/motos/4
- Content-Type: application/json
```http
{
  "placa": "XYZ5678",
  "chassi": "1HGCM82633A654321",
  "modelo": "MOTTU_SPORT",
  "problema": "Problema no motor",
  "echoBeacon": {
    "id": 4
  },
  "dataRegistro": "2025-05-10"
}
```

## ❌ Deletar uma Moto (DELETE)
```
localhost:8080/motos/4
```

## ❌ Deletar um EchoBeacon (DELETE)
```
localhost:8080/echo-beacons/4
```
