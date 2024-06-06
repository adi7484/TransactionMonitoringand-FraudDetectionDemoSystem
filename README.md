<h1 align="center" id="title">Kafka Transaction Monitoring and Fraud Detection Platform</h1>

<p id="description">This project is an intelligent transaction monitoring platform built with Spring Boot and Apache Kafka. The platform focuses on real-time monitoring and fraud detection of transaction data. It supports real-time streaming and efficient data handling to ensure seamless operation.</p>

  
  
<h2>🧐 Features</h2>

Here're some of the project's best features:

*   Real-time Monitoring: Monitors transaction data in real-time.
*   Fraud Detection: Implements fraud detection rules
*   <b><ul>Rule : Transactions from more than 2 different cities with the same customerId.</ul></b>
*   Smooth Data Pipeline: Ensures efficient data handling
*   API Integration: Provides REST API for publishing transactions.

<h2>🛠️ Installation Steps:</h2>

<p>1. Install Apache Kafka and extract it</p>

<p>2. open cmd inside kafka before bin folder</p>

<p>3. run these commands to start zookeeper and kafka servers</p>

```
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
```

```
bin\windows\kafka-server-start.bat config\server.properties
```

<p>5. Then run the Spring Boot Application</p>

<p>6. Fraudtest api</p>

```
http://localhost:9090/fraudtest
```

<p>7. json body</p>

```
[     {         "customerId": "customer7"         "timestamp": "2024-06-06T10:15:00Z"         "city": "CityA"         "amount": 200.0     }     {         "customerId": "customer7"         "timestamp": "2024-06-06T10:15:05Z"         "city": "CityB"         "amount": 250.0     }     {         "customerId": "customer7"         "timestamp": "2024-06-06T10:15:10Z"         "city": "CityC"         "amount": 300.0     } ]
```

<h2>🍰 Contribution Guidelines:</h2>

Contributions are welcome! Please fork this repository and submit pull requests.

  
  
<h2>💻 Built with</h2>

Technologies used in the project:

*   Model: Defines the Transaction model. Service: Contains services for producing and monitoring transactions. KafkaProducerService: Publishes transactions to Kafka. FraudDetectionService: Monitors transactions and detects fraud. Controller: Exposes REST endpoints for publishing transactions. KafkaMessageController: Handles HTTP requests for publishing transactions. Resources: Contains the static HTML page for testing APIs.
